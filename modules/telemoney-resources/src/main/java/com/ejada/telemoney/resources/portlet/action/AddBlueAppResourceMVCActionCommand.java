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
import java.util.Collections;
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
 * Blue App resources are always attachments: there is no resource code and no
 * resource type in the UI, but the page (feature) is selected like in the other
 * channels. The resource code defaults to the generated resource id and the
 * attachments are stored per language in
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

			// A file name is unique inside the folder of its language: the
			// whole submission is refused before anything is uploaded when one
			// of the files is already there.
			String duplicateMsg = findDuplicateAttachment(
				themeDisplay.getScopeGroupId(), channelName, languagesName,
				uploadRequest, Collections.<String, String>emptyMap());

			if (duplicateMsg != null) {
				actionRequest.setAttribute("errorMsg", duplicateMsg);
				actionRequest.setAttribute("myView", "add");
				actionRequest.setAttribute("action", "add");
				actionRequest.setAttribute(
					"selectedFeatureId", selectedFeatureId);
				SessionErrors.add(actionRequest, "error");

				return;
			}

			for (String languageName : languagesName) {
				File attachedFile = uploadRequest.getFile(
					languageName + "attachFile");

				String sourceFileName = uploadRequest.getFileName(
					languageName + "attachFile");

				if (sourceFileName == null) {
					sourceFileName = "";
				}

				if (containsXSS(sourceFileName)) {
					SessionErrors.add(actionRequest, "xssDetected");

					return;
				}

				// The name is not entered by the user: like the resource code,
				// which defaults to the generated resource id, it is filled in
				// from the uploaded file name. Each language keeps its own.
				nameValues.put(languageName, sourceFileName);

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

					// Keep the user on the same screen, with the reason and the
					// language the rejected file belongs to.
					actionRequest.setAttribute(
						"errorMsg",
						"[" + languageName + "] " + exception.getMessage());
					actionRequest.setAttribute("myView", "add");
					actionRequest.setAttribute("action", "add");
					actionRequest.setAttribute(
						"selectedFeatureId", selectedFeatureId);
					actionRequest.setAttribute(
						"attachfilesName", attachfilesName);
					actionRequest.setAttribute("attachValues", attachValues);
					SessionErrors.add(actionRequest, "error");

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

	/**
	 * Looks for an attachment that is already stored in the folder a language
	 * uploads to.
	 *
	 * <p>
	 * The check runs before anything is uploaded, so a duplicate reported for
	 * one language never leaves the files of the previous languages behind.
	 * Re-uploading the file a language already uses is an update of that file
	 * and is not reported.
	 * </p>
	 *
	 * @return the message describing the first duplicate found, or
	 *         <code>null</code> when every uploaded file is new
	 */
	private String findDuplicateAttachment(
		long groupId, String channelName, List<String> languagesName,
		UploadPortletRequest uploadRequest,
		Map<String, String> ownAttachNames) {

		for (String languageName : languagesName) {
			String sourceFileName = uploadRequest.getFileName(
				languageName + "attachFile");

			File attachedFile = uploadRequest.getFile(
				languageName + "attachFile");

			if ((sourceFileName == null) || sourceFileName.isEmpty() ||
				(attachedFile == null) || !attachedFile.exists() ||
				(attachedFile.length() == 0)) {

				continue;
			}

			if (sourceFileName.equals(ownAttachNames.get(languageName))) {
				continue;
			}

			String attachFolderName =
				channelName + "_" + languageName + "_attachFile";

			try {
				Folder folder = _dlAppService.getFolder(
					groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
					attachFolderName);

				_dlAppService.getFileEntry(
					groupId, folder.getFolderId(), sourceFileName);
			}
			catch (Exception exception) {

				// Either the folder does not exist yet or it holds no file
				// with that name: nothing to report for this language.

				continue;
			}

			return "[" + languageName + "] The file \"" + sourceFileName +
				"\" already exists in \"" + attachFolderName +
					"\" and cannot be added again for this language.";
		}

		return null;
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
