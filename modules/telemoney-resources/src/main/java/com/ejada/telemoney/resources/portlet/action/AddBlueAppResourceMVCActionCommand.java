package com.ejada.telemoney.resources.portlet.action;

import com.ejada.telemoney.db.constants.TelemoneyConstants;
import com.ejada.telemoney.resources.constants.TelemoneyResourcesPortletKeys;
import com.ejada.telemoney.resources.utils.FileValidatorUtil;
import com.ejada.telemony.db.model.Channels;
import com.ejada.telemony.db.model.Languages;
import com.ejada.telemony.db.model.Resource;
import com.ejada.telemony.db.service.ChannelsLocalService;
import com.ejada.telemony.db.service.LanguagesLocalService;
import com.ejada.telemony.db.service.ResourceLocalService;
import com.ejada.telemony.db.service.UserLogsLocalService;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Adds a new Blue App resource.
 *
 * <p>
 * Blue App resources are always attachments: there is no resource code, no
 * resource type and no page selection in the UI. The resource code defaults to
 * the generated resource id and the attachments are stored per language in
 * {@code channelName_langName_attachFile} folders.
 * </p>
 *
 * <p>
 * Every language stands on its own: a language submitted without a name or
 * without a file does not fall back to the English values and is simply saved
 * empty.
 * </p>
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + TelemoneyResourcesPortletKeys.TELEMONEYRESOURCES,
		"mvc.command.name=addBlueAppResource"
	},
	service = MVCActionCommand.class
)
public class AddBlueAppResourceMVCActionCommand extends BaseMVCActionCommand {

	private static final Log LOG = LogFactoryUtil.getLog(
		AddBlueAppResourceMVCActionCommand.class);

	private static final Pattern XSS_PATTERN = Pattern.compile(".*[<>\"'\\\\].*");

	private boolean containsXSS(String input) {
		return input != null && XSS_PATTERN.matcher(input).find();
	}

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		List<Role> roles = user.getRoles();
		boolean isAdministrator = roles.stream().anyMatch(
			role -> role.getName().equalsIgnoreCase("Administrator"));
		boolean isPo = roles.stream().anyMatch(
			role -> role.getName().equalsIgnoreCase("po"));

		if (!isAdministrator && !isPo) {
			SessionErrors.add(actionRequest, "notAuthorized");

			return;
		}

		try {
			PortletSession pSession = actionRequest.getPortletSession();
			Long chn = pSession.getAttribute(
				"LIFERAY_SHARED_ChannelId",
				PortletSession.APPLICATION_SCOPE) != null
					? (Long)pSession.getAttribute(
						"LIFERAY_SHARED_ChannelId",
						PortletSession.APPLICATION_SCOPE)
					: 1;

			String userName = user.getFullName();
			String channelName = getChannelName(chn);

			// Blue App resources are always attachments, are not linked to a
			// page and the resource code is generated from the resource id.
			String resourceCode = "";
			String resourceType =
				TelemoneyResourcesPortletKeys.BLUE_APP_RESOURCE_TYPE;
			String urlType = "";
			long selectedFeatureId = ParamUtil.getLong(
				actionRequest, "selectedFeatureId", 0);

			List<Languages> languages =
				_languagesLocalService.getLatestApprovedByChannelId(chn);

			UploadPortletRequest uploadRequest =
				PortalUtil.getUploadPortletRequest(actionRequest);

			Map<String, String> nameValues = new HashMap<>();
			Map<String, String> attachfilesName = new HashMap<>();
			Map<String, String> attachValues = new HashMap<>();
			Map<String, String> descriptionValues = new HashMap<>();
			Map<String, String> routeIdValues = new HashMap<>();
			Map<String, String> urlValues = new HashMap<>();
			List<String> languagesName = new ArrayList<>();

			for (Languages langName : languages) {
				languagesName.add(langName.getLangName());
			}

			for (String languageName : languagesName) {
				String attachName = ParamUtil.getString(
					actionRequest, languageName + "attachName", "");

				if (containsXSS(attachName)) {
					SessionErrors.add(actionRequest, "xssDetected");

					return;
				}

				// Each language keeps its own name: no English fallback.
				nameValues.put(languageName, attachName);

				File attachedFile = uploadRequest.getFile(
					languageName + "attachFile");

				String sourceFileName = uploadRequest.getFileName(
					languageName + "attachFile");

				if (sourceFileName == null) {
					sourceFileName = "";
				}

				attachfilesName.put(languageName, sourceFileName);

				// A language may be left completely empty: only upload when a
				// file was really selected for it.
				boolean hasUploadedFile =
					!sourceFileName.isEmpty() && (attachedFile != null) &&
						attachedFile.exists() && (attachedFile.length() > 0);

				if (!hasUploadedFile) {
					continue;
				}

				try {
					FileValidatorUtil.validateBlueAppAttachmentFile(
						uploadRequest, languageName + "attachFile");
				}
				catch (Exception exception) {
					LOG.error(
						"Invalid Blue App attachment for language " +
							languageName,
						exception);
					SessionErrors.add(actionRequest, "file-upload-error");

					return;
				}

				ServiceContext serviceContext = ServiceContextFactory.getInstance(
					DLFolder.class.getName(), actionRequest);

				long groupId = themeDisplay.getScopeGroupId();

				String attachFolderName =
					channelName + "_" + languageName + "_attachFile";

				Folder folder;

				try {
					folder = _dlAppService.getFolder(
						groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
						attachFolderName);
				}
				catch (Exception exception) {
					folder = _dlAppService.addFolder(
						"", groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
						attachFolderName, "", serviceContext);
				}

				ServiceContext serviceContextFile =
					ServiceContextFactory.getInstance(
						DLFileEntry.class.getName(), actionRequest);

				FileEntry fileEntry;

				try {
					fileEntry = _dlAppService.getFileEntry(
						groupId, folder.getFolderId(), sourceFileName);
				}
				catch (Exception exception) {
					fileEntry = _dlAppService.addFileEntry(
						groupId, folder.getFolderId(), sourceFileName, "",
						sourceFileName, "", "", attachedFile,
						serviceContextFile);
				}

				String attachURL =
					"/documents/" + groupId + "/" + folder.getFolderId() + "/" +
						StringUtil.replace(fileEntry.getTitle(), ' ', '+') + "/";

				attachValues.put(languageName, attachURL);
			}

			ServiceContext workflowServiceContext =
				ServiceContextFactory.getInstance(
					Resource.class.getName(), actionRequest);

			workflowServiceContext.setWorkflowAction(
				WorkflowConstants.ACTION_PUBLISH);

			_resourcesLocalService.addNewResource(
				resourceCode, resourceType, urlType, nameValues, attachValues,
				attachfilesName, descriptionValues, routeIdValues, urlValues,
				chn, selectedFeatureId, workflowServiceContext, user);

			String userAction = TelemoneyConstants.USER_ACTION_ADD.concat(
				TelemoneyConstants.getResourceTypeValue(resourceType).concat(
					TelemoneyConstants.USER_LOGS_RESOURCE));

			_userLogsLocalService.addUserData(userName, userAction, chn);
		}
		catch (Exception exception) {
			LOG.error("Error while adding a Blue App resource", exception);
			actionRequest.setAttribute("errorMsg", exception.getMessage());
			actionRequest.setAttribute("myView", "add");
			SessionErrors.add(actionRequest, "error");
		}
	}

	private String getChannelName(long channelId) {
		try {
			Channels channel = _channelsLocalService.fetchChannels(channelId);

			return (channel != null) ? channel.getName() : "";
		}
		catch (Exception exception) {
			LOG.error(
				"Unable to resolve channel name for channel " + channelId,
				exception);

			return "";
		}
	}

	@Reference
	private ChannelsLocalService _channelsLocalService;

	@Reference
	private DLAppService _dlAppService;

	@Reference
	private LanguagesLocalService _languagesLocalService;

	@Reference
	private ResourceLocalService _resourcesLocalService;

	@Reference
	private UserLogsLocalService _userLogsLocalService;

}
