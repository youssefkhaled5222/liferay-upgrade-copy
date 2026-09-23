package com.ejada.telemoney.resources.portlet.action;

import com.ejada.telemoney.db.constants.TelemoneyConstants;
import com.ejada.telemoney.resources.constants.TelemoneyResourcesPortletKeys;
import com.ejada.telemoney.resources.utils.FileValidatorUtil;
import com.ejada.telemony.db.model.Channels;
import com.ejada.telemony.db.model.Resource;
import com.ejada.telemony.db.service.ChannelsLocalService;
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
 * Adds a new Blue App resource from the file picked on the list.
 *
 * <p>
 * Blue App assets are not localized: a resource holds a single English
 * attachment, stored in the {@code channelName_English_attachFile} folder.
 * There is no resource code and no name to enter: the code defaults to the
 * generated resource id and the name is the uploaded file name. The page
 * (feature) is the one being viewed on the list.
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

	private static final String FILE_FIELD =
		TelemoneyConstants.LANGUAGE_ENGLISH_NAME + "attachFile";

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

		long selectedFeatureId = ParamUtil.getLong(
			actionRequest, "selectedFeatureId", 0);

		// The list is shown again afterwards, on the page the file was added
		// to, whether the upload succeeded or not.
		actionRequest.setAttribute("selectedFeatureId", selectedFeatureId);

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

			String resourceCode = "";
			String resourceType =
				TelemoneyResourcesPortletKeys.BLUE_APP_RESOURCE_TYPE;
			String urlType = "";

			UploadPortletRequest uploadRequest =
				PortalUtil.getUploadPortletRequest(actionRequest);

			File attachedFile = uploadRequest.getFile(FILE_FIELD);
			String sourceFileName = uploadRequest.getFileName(FILE_FIELD);

			if (sourceFileName == null) {
				sourceFileName = "";
			}

			if (containsXSS(sourceFileName)) {
				SessionErrors.add(actionRequest, "xssDetected");

				return;
			}

			boolean hasUploadedFile =
				!sourceFileName.isEmpty() && (attachedFile != null) &&
					attachedFile.exists() && (attachedFile.length() > 0);

			if (!hasUploadedFile) {
				reportError(actionRequest, "Please choose a file to add.");

				return;
			}

			try {
				FileValidatorUtil.validateBlueAppAttachmentFile(
					uploadRequest, FILE_FIELD);
			}
			catch (Exception exception) {
				LOG.error("Invalid Blue App attachment", exception);

				reportError(actionRequest, exception.getMessage());

				return;
			}

			long groupId = themeDisplay.getScopeGroupId();

			String attachFolderName =
				channelName + "_" + TelemoneyConstants.LANGUAGE_ENGLISH_NAME +
					"_attachFile";

			// A file name is unique inside the folder: the file is refused
			// before anything is uploaded when it is already there.
			if (fileExists(groupId, attachFolderName, sourceFileName)) {
				reportError(
					actionRequest,
					"The file \"" + sourceFileName + "\" already exists in \"" +
						attachFolderName + "\" and cannot be added again.");

				return;
			}

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
				DLFolder.class.getName(), actionRequest);

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

			FileEntry fileEntry = _dlAppService.addFileEntry(
				groupId, folder.getFolderId(), sourceFileName, "",
				sourceFileName, "", "", attachedFile, serviceContextFile);

			String attachURL =
				"/documents/" + groupId + "/" + folder.getFolderId() + "/" +
					StringUtil.replace(fileEntry.getTitle(), ' ', '+') + "/";

			Map<String, String> nameValues = new HashMap<>();
			Map<String, String> attachfilesName = new HashMap<>();
			Map<String, String> attachValues = new HashMap<>();

			// Like the resource code, which defaults to the generated resource
			// id, the name is filled in from the uploaded file name.
			nameValues.put(
				TelemoneyConstants.LANGUAGE_ENGLISH_NAME, sourceFileName);
			attachfilesName.put(
				TelemoneyConstants.LANGUAGE_ENGLISH_NAME, sourceFileName);
			attachValues.put(
				TelemoneyConstants.LANGUAGE_ENGLISH_NAME, attachURL);

			ServiceContext workflowServiceContext =
				ServiceContextFactory.getInstance(
					Resource.class.getName(), actionRequest);

			workflowServiceContext.setWorkflowAction(
				WorkflowConstants.ACTION_PUBLISH);

			_resourcesLocalService.addNewResource(
				resourceCode, resourceType, urlType, nameValues, attachValues,
				attachfilesName, new HashMap<>(), new HashMap<>(),
				new HashMap<>(), chn, selectedFeatureId, workflowServiceContext,
				user);

			String userAction = TelemoneyConstants.USER_ACTION_ADD.concat(
				TelemoneyConstants.getResourceTypeValue(resourceType).concat(
					TelemoneyConstants.USER_LOGS_RESOURCE));

			_userLogsLocalService.addUserData(userName, userAction, chn);
		}
		catch (Exception exception) {
			LOG.error("Error while adding a Blue App resource", exception);

			reportError(actionRequest, exception.getMessage());
		}
	}

	private boolean fileExists(
		long groupId, String folderName, String fileName) {

		try {
			Folder folder = _dlAppService.getFolder(
				groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, folderName);

			_dlAppService.getFileEntry(groupId, folder.getFolderId(), fileName);

			return true;
		}
		catch (Exception exception) {

			// Either the folder does not exist yet or it holds no file with
			// that name.

			return false;
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

	/**
	 * Shows the reason on the list, above the resources of the page.
	 */
	private void reportError(ActionRequest actionRequest, String message) {
		actionRequest.setAttribute("errorMsg", message);
		SessionErrors.add(actionRequest, "error");
	}

	@Reference
	private ChannelsLocalService _channelsLocalService;

	@Reference
	private DLAppService _dlAppService;

	@Reference
	private ResourceLocalService _resourcesLocalService;

	@Reference
	private UserLogsLocalService _userLogsLocalService;

}
