package com.ejada.telemoney.resources.portlet;

import com.ejada.telemoney.db.constants.TelemoneyConstants;
import com.ejada.telemoney.db.dto.importDtos.ComponentEntryDto;
import com.ejada.telemoney.db.dto.importDtos.ImportResultDTO;
import com.ejada.telemoney.resources.constants.TelemoneyResourcesPortletKeys;
import com.ejada.telemoney.resources.utils.FileValidatorUtil;
import com.ejada.telemony.db.constants.Constants;
import com.ejada.telemony.db.exception.NoSuchResourceException;
import com.ejada.telemony.db.model.Channels;
import com.ejada.telemony.db.model.Feature;
import com.ejada.telemony.db.model.Languages;
import com.ejada.telemony.db.model.Resource;
import com.ejada.telemony.db.model.ResourceLocalization;
import com.ejada.telemony.db.service.FeatureLocalService;
import com.ejada.telemony.db.service.LanguagesLocalService;
import com.ejada.telemony.db.service.ResourceLocalService;
import com.ejada.telemony.db.service.UserLogsLocalService;
import com.ejada.telemony.db.service.ImportRequestLocalService;
import com.ejada.telemony.db.service.ChannelsLocalService;
import com.ejada.telemoney.db.utils.ExportFileUtil;
import com.ejada.telemoney.db.utils.ImportFileUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.model.DLVersionNumberIncrease;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
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

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=TelemoneyResources", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TelemoneyResourcesPortletKeys.TELEMONEYRESOURCES,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class TelemoneyResourcesPortlet extends MVCPortlet {
	private static final Pattern XSS_PATTERN = Pattern.compile(".*[<>\"'\\\\].*");
	private static final Log LOG = LogFactoryUtil.getLog(TelemoneyResourcesPortlet.class);

	/**
	 * Returns the channel name for the given channel id, or {@code null} when
	 * the channel cannot be resolved.
	 */
	private String getChannelName(long channelId) {
		try {
			Channels channel = _channelsLocalService.fetchChannels(channelId);

			return (channel != null) ? channel.getName() : null;
		} catch (Exception e) {
			LOG.error("Unable to resolve channel name for channel " + channelId, e);

			return null;
		}
	}

	/**
	 * Returns {@code true} only when the given channel is named exactly
	 * "Blue App". Every other channel keeps the original behaviour.
	 */
	private boolean isBlueAppChannel(long channelId) {
		return TelemoneyResourcesPortletKeys.BLUE_APP_CHANNEL_NAME.equals(getChannelName(channelId));
	}

	private boolean containsXSS(String input) {
		return input != null && XSS_PATTERN.matcher(input).find();
	}
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		try {
			PortletSession pSession = renderRequest.getPortletSession();
			Long chn = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
					? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
					: 1;

			// Blue App has its own dedicated screens and its own MVC action
			// commands, so it never reaches the shared resource JSPs.
			if (isBlueAppChannel(chn)) {
				doBlueAppView(renderRequest, renderResponse, chn);

				return;
			}

			String myView = "view";
			if (renderRequest.getAttribute("myView") != null || ParamUtil.getString(renderRequest, "myView") != "") {
				myView = "add";
				renderRequest.setAttribute("allFeatures", _featureLocalServiceImpl.getLatestApprovedByChannelId(chn));

				// Fetch pages (features with pageType = 0)
				List<Feature> pages = _featureLocalServiceImpl.getAllParentPages(chn);
				renderRequest.setAttribute("pages", pages);

				// Get selected featureId from request or default to first page
				long selectedFeatureId = ParamUtil.getLong(renderRequest, "selectedFeatureId", 0);
				if (renderRequest.getAttribute("selectedFeatureId") != null) {
					selectedFeatureId = (Long) renderRequest.getAttribute("selectedFeatureId");
				}
				if (selectedFeatureId == 0 && !pages.isEmpty()) {
					selectedFeatureId = pages.get(0).getEntityResourceId();
				}
				renderRequest.setAttribute("selectedFeatureId", selectedFeatureId);

				List<Languages> languages = _languagesLocalService.getLatestApprovedByChannelId(chn);
				if (languages.isEmpty()) {
					System.out.println("The language list is Empty");
				} else {
					List<String> languagesName = new ArrayList<>();
					for (Languages langName : languages) {
						languagesName.add(langName.getLangName());
					}
					renderRequest.setAttribute("languagesName", languagesName);
				}

			} else {
				// Fetch pages for filtering
				List<Feature> pages = _featureLocalServiceImpl.getAllParentPages(chn);
				renderRequest.setAttribute("pages", pages);

				long selectedFeatureId = ParamUtil.getLong(renderRequest, "selectedFeatureId", 0);
				if (selectedFeatureId == 0 && !pages.isEmpty()) {
					selectedFeatureId = pages.get(0).getEntityResourceId();
				}
				renderRequest.setAttribute("selectedFeatureId", selectedFeatureId);

				java.util.Map<Resource, Boolean> resourcesWithPending =
						_resourcesLocalService.getLatestApprovedByChannelIdWithPending(chn);
				renderRequest.setAttribute("resource", new ArrayList<>(resourcesWithPending.keySet()));
				renderRequest.setAttribute("resourcesWithPending", resourcesWithPending);

				boolean hasPendingImport = _importRequestLocalService.hasPendingImportRequest(Constants.RESOURCE);
				renderRequest.setAttribute("hasPendingImport", hasPendingImport);

				String importParsedResources = (String) pSession.getAttribute("importParsedResources");
				if (importParsedResources != null) {
					renderRequest.setAttribute("importParsedResources", importParsedResources);
					renderRequest.setAttribute("importChannels", pSession.getAttribute("importChannels"));
					renderRequest.setAttribute("importApprovedPagesByChannel", pSession.getAttribute("importApprovedPagesByChannel"));
					renderRequest.setAttribute("importApprovedResourcesByChannelAndPage", pSession.getAttribute("importApprovedResourcesByChannelAndPage"));
					pSession.removeAttribute("importParsedResources");
					pSession.removeAttribute("importChannels");
					pSession.removeAttribute("importApprovedPagesByChannel");
					pSession.removeAttribute("importApprovedResourcesByChannelAndPage");
				}
			}

			String view = "/" + myView + ".jsp";
			PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(view);
			dispatcher.include(renderRequest, renderResponse);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Renders the dedicated Blue App screens.
	 *
	 * <p>
	 * Blue App never uses the shared {@code /view.jsp} and {@code /add.jsp}:
	 * it has its own {@code /blueAppView.jsp} and {@code /blueAppAdd.jsp}
	 * pages. Resources are always attachments, but the page (feature) is
	 * selected like in the other channels.
	 * </p>
	 */
	private void doBlueAppView(RenderRequest renderRequest, RenderResponse renderResponse, Long chn)
			throws IOException, PortletException {

		String myView = "blueAppView";

		// Pages are shared with the other channels: a resource is linked to its
		// parent feature through the stable entityResourceId.
		List<Feature> pages = _featureLocalServiceImpl.getAllParentPages(chn);
		renderRequest.setAttribute("pages", pages);

		long selectedFeatureId = ParamUtil.getLong(renderRequest, "selectedFeatureId", 0);

		if (renderRequest.getAttribute("selectedFeatureId") != null) {
			selectedFeatureId = (Long) renderRequest.getAttribute("selectedFeatureId");
		}

		if (selectedFeatureId == 0 && !pages.isEmpty()) {
			selectedFeatureId = pages.get(0).getEntityResourceId();
		}

		renderRequest.setAttribute("selectedFeatureId", selectedFeatureId);

		if (renderRequest.getAttribute("myView") != null || ParamUtil.getString(renderRequest, "myView") != "") {
			myView = "blueAppAdd";

			List<Languages> languages = _languagesLocalService.getLatestApprovedByChannelId(chn);

			if (languages.isEmpty()) {
				LOG.warn("The language list is empty for the Blue App channel " + chn);
			} else {
				List<String> languagesName = new ArrayList<>();

				for (Languages langName : languages) {
					languagesName.add(langName.getLangName());
				}

				renderRequest.setAttribute("languagesName", languagesName);
			}
		} else {
			java.util.Map<Resource, Boolean> resourcesWithPending =
					_resourcesLocalService.getLatestApprovedByChannelIdWithPending(chn);

			renderRequest.setAttribute("resource", new ArrayList<>(resourcesWithPending.keySet()));
			renderRequest.setAttribute("resourcesWithPending", resourcesWithPending);

			boolean hasPendingImport = _importRequestLocalService.hasPendingImportRequest(Constants.RESOURCE);
			renderRequest.setAttribute("hasPendingImport", hasPendingImport);

			PortletSession pSession = renderRequest.getPortletSession();
			String importParsedResources = (String) pSession.getAttribute("importParsedResources");

			if (importParsedResources != null) {
				renderRequest.setAttribute("importParsedResources", importParsedResources);
				renderRequest.setAttribute("importChannels", pSession.getAttribute("importChannels"));
				renderRequest.setAttribute("importApprovedPagesByChannel", pSession.getAttribute("importApprovedPagesByChannel"));
				renderRequest.setAttribute("importApprovedResourcesByChannelAndPage", pSession.getAttribute("importApprovedResourcesByChannelAndPage"));
				pSession.removeAttribute("importParsedResources");
				pSession.removeAttribute("importChannels");
				pSession.removeAttribute("importApprovedPagesByChannel");
				pSession.removeAttribute("importApprovedResourcesByChannelAndPage");
			}
		}

		String view = "/" + myView + ".jsp";
		PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(view);
		dispatcher.include(renderRequest, renderResponse);
	}

	public void addResourceLocalized(ActionRequest actionRequest, ActionResponse actionResponse)
			throws PortalException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		List<Role> roles = user.getRoles();
		boolean isAdministrator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Administrator"));
		boolean isPo = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("po"));

		if (!isAdministrator && !isPo) {
			SessionErrors.add(actionRequest, "notAuthorized");
			return;
		}
		try {
			PortletSession pSession = actionRequest.getPortletSession();
			Long chn = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
					? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
					: 1;
			String userName = themeDisplay.getUser().getFullName();
			if (userName == null) {
				System.out.println("No user logs available");
			}
			String action = ParamUtil.getString(actionRequest, "action");
			List<ResourceLocalization> resourceLocalization;
			Long resourceId = ParamUtil.getLong(actionRequest, "selectedResourceId", 1);
			String resourceCode = ParamUtil.getString(actionRequest, "resourceCode", "");
			if (Objects.equals(action, "add")) {
				List<Resource> result = _resourcesLocalService.getByResourceCodeLatestApproved(resourceCode, chn);
				if (result != null && result.size() > 0)
					throw new Exception("The resource code " + resourceCode + " already exists");
			}
			String resourceType = ParamUtil.getString(actionRequest, "resourceType", "");
			String urlType = ParamUtil.getString(actionRequest, "urlType", "");
			long selectedFeatureId = ParamUtil.getLong(actionRequest, "selectedFeatureId", 0);
			String featureRouteId = ParamUtil.getString(actionRequest, "featuerName", "");
			List<Languages> languages = _languagesLocalService.getLatestApprovedByChannelId(chn);
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			Map<String, String> nameValues = new HashMap<>();
			Map<String, String> attachfilesName = new HashMap<>();
			Map<String, String> attachValues = new HashMap<>();
			Map<String, String> descriptionValues = new HashMap<>();
			Map<String, String> routeIdValues = new HashMap<>();
			Map<String, String> urlValues = new HashMap<>();
			List<String> languagesName = new ArrayList<>();
			String enUrlName = ParamUtil.getString(actionRequest, "EnglishurlName", "");
			String enfeatureRouteId = ParamUtil.getString(actionRequest, "EnglishfeatuerName", "");
			String enUrl = ParamUtil.getString(actionRequest, "Englishurl", "");
			String enNameValue = ParamUtil.getString(actionRequest, "EnglishattachName", "");
			File enAttachedFile = uploadRequest.getFile("EnglishattachFile");
			String enTermsCondName = ParamUtil.getString(actionRequest, "EnglishtermsCondName", "");
			String enDiscription = ParamUtil.getString(actionRequest, "EnglishdescriptionValue", "");
			if (containsXSS(resourceCode) || containsXSS(resourceType) || containsXSS(urlType) ||
				    containsXSS(featureRouteId) || containsXSS(enUrlName) || containsXSS(enfeatureRouteId) ||
				    containsXSS(enUrl) || containsXSS(enNameValue) || containsXSS(enTermsCondName) ||
				    containsXSS(enDiscription)) {

					SessionErrors.add(actionRequest, "xssDetected");
					return;
				}
			if (!languages.isEmpty()) {
				for (Languages langName : languages) {
					languagesName.add(langName.getLangName());
				}
			}
			if (!languagesName.isEmpty()) {
				//Url
				if (resourceType.equals("1")) {
					for (String languageName : languagesName) {
						String urlName = ParamUtil.getString(actionRequest, languageName + "urlName", "");
						if (containsXSS(urlName)) {
							SessionErrors.add(actionRequest, "xssDetected");
							return;
						}
						if (urlName.equals("") && !enUrlName.equals(""))
							nameValues.put(languageName, enUrlName);
						else
							nameValues.put(languageName, urlName);
						if (urlType.equals("1")) {
							featureRouteId = ParamUtil.getString(actionRequest, languageName + "featuerName", "");
							if (featureRouteId.equals("") && !enfeatureRouteId.equals(""))
								routeIdValues.put(languageName, enfeatureRouteId);
							else
								routeIdValues.put(languageName, featureRouteId);
						} else {
							String urlValue = ParamUtil.getString(actionRequest, languageName + "url", "");
							if (urlValue.equals("") && !enUrl.equals(""))
								urlValues.put(languageName, enUrl);
							else
								urlValues.put(languageName, urlValue);
						}
					}
				}
				//Attachment
				else if (resourceType.equals("2")) {
					for (String languageName : languagesName) {
						String attachName = ParamUtil.getString(actionRequest, languageName + "attachName", "");
						if (containsXSS(attachName)) {
							SessionErrors.add(actionRequest, "xssDetected");
							return;
						}
						if (attachName.equals("") && !enNameValue.equals(""))
							nameValues.put(languageName, enNameValue);
						else
							nameValues.put(languageName, attachName);
						File attachedFile = uploadRequest.getFile(languageName + "attachFile");
						if (attachedFile != null && attachedFile.exists()) {
							try {
								FileValidatorUtil.validateDocumentFile(uploadRequest, languageName + "attachFile");
							} catch (Exception e) {
								SessionErrors.add(actionRequest, "file-upload-error");
								e.printStackTrace();
								return;
							}
						}
						String sourceFileName;
						if (Objects.equals(action, "add")) {
							if (uploadRequest.getFileName(languageName + "attachFile").equals("")
									&& enAttachedFile != null) {
								try {
									FileValidatorUtil.validateDocumentFile(uploadRequest, "EnglishattachFile");
									sourceFileName = uploadRequest.getFileName("EnglishattachFile");
								} catch (Exception e) {
									SessionErrors.add(actionRequest, "file-upload-error");
									e.printStackTrace();
									return;
								}
							}
							else {
								sourceFileName = uploadRequest.getFileName(languageName + "attachFile");
							}
						} else {
							ResourceLocalization resourceForUpdating = _resourcesLocalService
									.getResourceLocalization(resourceId, languageName);
							sourceFileName = uploadRequest.getFileName(languageName + "attachFile");
							if (sourceFileName.isEmpty()) {
								sourceFileName = resourceForUpdating.getAttachName();
							} else {
								sourceFileName = uploadRequest.getFileName(languageName + "attachFile");
							}
						}
						attachfilesName.put(languageName, sourceFileName);

						ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(),
								actionRequest);
						long groupId = themeDisplay.getScopeGroupId();
						Folder folder = null;
						if (attachedFile != null) {
							try {
								folder = _dlAppService.getFolder(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
										languageName + "attachFile");
							} catch (Exception e) {
                                folder = _dlAppService.addFolder("", groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
                                        languageName + "attachFile", "", serviceContext);
							}
							ServiceContext serviceContextFile = ServiceContextFactory
									.getInstance(DLFileEntry.class.getName(), actionRequest);
							FileEntry fileEntry = null;
							try {
								fileEntry = _dlAppService.getFileEntry(groupId, folder.getFolderId(), sourceFileName);
								_dlAppService.updateFileEntry(
                                        fileEntry.getFileEntryId(), sourceFileName, "",
										sourceFileName, "", "", "",DLVersionNumberIncrease.MINOR, attachedFile, null, null,serviceContextFile);


							} catch (Exception e) {
								fileEntry = _dlAppService.addFileEntry(groupId, folder.getFolderId(), sourceFileName,
										"", sourceFileName, "", "", attachedFile, serviceContextFile);
							}
							String attachURL ="/documents/" + String.valueOf(groupId)
									+ "/" + String.valueOf(folder.getFolderId()) + "/"
									+ StringUtil.replace(fileEntry.getTitle(), ' ', '+') + "/";
							attachValues.put(languageName, attachURL);
						}
					}
				}
				//Terms and Conditions
				else {
					for (String languageName : languagesName) {
						String termsCondName = ParamUtil.getString(actionRequest, languageName + "termsCondName", "");
						if (containsXSS(termsCondName)) {
							SessionErrors.add(actionRequest, "xssDetected");
							return;
						}
						if (termsCondName.equals("") && !enTermsCondName.equals(""))
							nameValues.put(languageName, enTermsCondName);
						else
							nameValues.put(languageName, termsCondName);
						String descriptionValue = ParamUtil.getString(actionRequest, languageName + "descriptionValue",
								"");
						if (descriptionValue.equals("") && !enDiscription.equals(""))
							descriptionValues.put(languageName, enDiscription);
						else
							descriptionValues.put(languageName, descriptionValue);
					}
				}
			}
			if (action.equals("add")) {
				ServiceContext workflowServiceContext = createServiceContextForWorkflow(actionRequest);
				_resourcesLocalService.addNewResource(resourceCode, resourceType, urlType, nameValues, attachValues,
						attachfilesName, descriptionValues, routeIdValues, urlValues, chn, selectedFeatureId, workflowServiceContext, user);
				resourceType = TelemoneyConstants.getResourceTypeValue(resourceType);
				String userAction = TelemoneyConstants.USER_ACTION_ADD
						.concat(resourceType.concat(TelemoneyConstants.USER_LOGS_RESOURCE));
				_userLogsLocalService.addUserData(userName, userAction, chn);
				resourceLocalization = _resourcesLocalService.getResourceLocalizations(resourceId);
				actionRequest.setAttribute("resourceLocalization", resourceLocalization);

			} else {
				ServiceContext workflowServiceContext = createServiceContextForWorkflow(actionRequest);
				_resourcesLocalService.updateResource(resourceId, resourceCode, resourceType, urlType, nameValues,
						attachValues, attachfilesName, descriptionValues, routeIdValues, urlValues, chn, selectedFeatureId, workflowServiceContext, user);
//				resourceLocalization = _resourcesLocalService.getResourcesById(resourceId);
//				actionRequest.setAttribute("resourceLocalization", resourceLocalization);
				resourceType = TelemoneyConstants.getResourceTypeValue(resourceType);
				String userAction = TelemoneyConstants.USER_ACTION_UPDATE
						.concat(resourceType.concat(TelemoneyConstants.USER_LOGS_RESOURCE));
				_userLogsLocalService.addUserData(userName, userAction, chn);
			}
		} catch (Exception e) {
			actionRequest.setAttribute("errorMsg", e.getMessage());
			actionRequest.setAttribute("myView", "add");
			SessionErrors.add(actionRequest, "error");
		}

	}


	public void getResourceIdForView(ActionRequest actionRequest, ActionResponse actionRespons) {
		PortletSession pSession = actionRequest.getPortletSession();
		Long chn = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
				? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1;
		Long resourceId = ParamUtil.getLong(actionRequest, "selectedResourceId", 0);
		List<Languages> languages = _languagesLocalService.getbyChannelId(chn);
		Map<String, String> nameValues = new HashMap<>();
		Map<String, String> attachfilesName = new HashMap<>();
		Map<String, String> attachValues = new HashMap<>();
		Map<String, String> descriptionValues = new HashMap<>();
		Map<String, String> routeIdValues = new HashMap<>();
		Map<String, String> urlValues = new HashMap<>();
		Resource resources;
		if (!languages.isEmpty()) {
			for (Languages langName : languages) {
				ResourceLocalization resourceLocalization = _resourcesLocalService.fetchResourceLocalization(resourceId,
						langName.getLangName());
				nameValues.put(langName.getLangName(), resourceLocalization.getName());
				attachfilesName.put(langName.getLangName(), resourceLocalization.getAttachName());
				attachValues.put(langName.getLangName(), resourceLocalization.getAttach());
				descriptionValues.put(langName.getLangName(), resourceLocalization.getDescription());
				routeIdValues.put(langName.getLangName(), resourceLocalization.getRouteId());
				urlValues.put(langName.getLangName(), resourceLocalization.getUrl());
			}
		}
		try {
			resources = _resourcesLocalService.getResource(resourceId);
			actionRequest.setAttribute("resourceId", resourceId);
			actionRequest.setAttribute("resourceCode", resources.getResourceCode());
			actionRequest.setAttribute("resourceType", resources.getResourceType());
			actionRequest.setAttribute("urlType", resources.getUrlType());
			actionRequest.setAttribute("featuerName", resources.getRouteId());
			actionRequest.setAttribute("selectedFeatureId", resources.getFeatureId());
			actionRequest.setAttribute("nameValues", nameValues);
			actionRequest.setAttribute("attachfilesName", attachfilesName);
			actionRequest.setAttribute("attachValues", attachValues);
			actionRequest.setAttribute("descriptionValues", descriptionValues);
			actionRequest.setAttribute("routeIdValues", routeIdValues);
			actionRequest.setAttribute("urlValues", urlValues);

			actionRequest.setAttribute("action", ParamUtil.getString(actionRequest, "action", "update"));
			actionRequest.setAttribute("myView", "add");
		} catch (PortalException e) {
			e.printStackTrace();
		}

	}

	public void deleteResources(ActionRequest actionRequest, ActionResponse actionResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		List<Role> roles = user.getRoles();
		boolean isAdministrator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Administrator"));
		boolean isPo = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("po"));

		if (!isAdministrator && !isPo) {
			SessionErrors.add(actionRequest, "notAuthorized");
			return;
		}
		PortletSession pSession = actionRequest.getPortletSession();
		Long chn = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
				? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1;
		String userName = themeDisplay.getUser().getFullName();
		long resourceId = ParamUtil.getLong(actionRequest, "selectedResourceId");
		Resource resource = _resourcesLocalService.fetchResource(resourceId);
		if (resource != null) {
			String resourceName = resource.getName();
			String resourceType = TelemoneyConstants.getResourceTypeValue(resource.getResourceType());
			String userAction = TelemoneyConstants.USER_ACTION_DELETE
					.concat(resourceType.concat(TelemoneyConstants.USER_LOGS_RESOURCE)).concat(resourceName != null ? resourceName : "");
			try {
				ServiceContext serviceContext = createServiceContextForWorkflow(actionRequest);
				_resourcesLocalService.resourceDelete(resourceId, serviceContext, user);
				_userLogsLocalService.addUserData(userName, userAction, chn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void searchRes(ActionRequest actionRequest, ActionResponse actionRespons) throws NoSuchResourceException {
		PortletSession pSession = actionRequest.getPortletSession();
		Long chn = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
				? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1;
		String searchBy = ParamUtil.getString(actionRequest, "searchBy");
		String searchTerm = ParamUtil.getString(actionRequest, "searchTerm");


		List<Resource> searchResult = searchBy.equals("code")
				? _resourcesLocalService.searchResourceServiceLatestApproved(searchTerm, chn)
				: searchBy.equals("name")
						? _resourcesLocalService.getByResourceCodeByNameLatestApproved(searchTerm, chn)
						: _resourcesLocalService.searchResourceByTypeLatestApproved(searchTerm, chn);
		try {
			actionRequest.setAttribute("searchResult", searchResult);
		} catch (Exception e) {
			System.out.println("Error retrieving data: " + e.getMessage());
		}
	}

	private ServiceContext createServiceContextForWorkflow(ActionRequest actionRequest) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Resource.class.getName(), actionRequest);
		serviceContext.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH);
		return serviceContext;
	}

	public void exportResource(ActionRequest actionRequest, ActionResponse actionResponse) {
		long[] resourceIds = ParamUtil.getLongValues(actionRequest, "resourceIds");
		String summary = ParamUtil.getString(actionRequest, "exportSummary", "Resource Export");

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		List<Role> roles = user.getRoles();
		boolean isAdministrator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Administrator"));
		boolean isPo = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("po"));

		if (!isAdministrator && !isPo) {
			SessionErrors.add(actionRequest, "notAuthorized");
			return;
		}

		List<ComponentEntryDto> exportData = new ArrayList<>();
		Map<String, byte[]> attachmentFiles = new HashMap<>();
		long groupId = themeDisplay.getScopeGroupId();

		for (long resourceId : resourceIds) {
			try {
				Resource resource = _resourcesLocalService.getResource(resourceId);
				if (_resourcesLocalService.hasPendingDraft(resource.getEntityResourceId())) {
					LOG.warn("Skipping export of resource ID " + resourceId + " because it has a pending draft");
					continue;
				}
				JSONObject obj = resourceToJson(resource);

				if ("2".equals(resource.getResourceType())) {
					collectAttachmentFiles(resource, obj, groupId, attachmentFiles);
				}

				ComponentEntryDto dto = new ComponentEntryDto();
				dto.setData(obj);
				exportData.add(dto);
			} catch (PortalException e) {
				e.printStackTrace();
				SessionErrors.add(actionRequest, "error");
			}
		}

		if (exportData.isEmpty()) {
			SessionErrors.add(actionRequest, "noDataToExport");
			return;
		}

		try {
			ExportFileUtil.downloadZipWithAttachments(summary, exportData, user, Constants.RESOURCE,
					actionRequest, actionResponse, attachmentFiles);
		} catch (IllegalStateException e) {
			SessionErrors.add(actionRequest, "zipSizeExceeded");
		}

    }

	private void collectAttachmentFiles(Resource resource, JSONObject resourceJson, long groupId,
										Map<String, byte[]> attachmentFiles) {
		try {
			List<ResourceLocalization> localizations = _resourcesLocalService
					.getResourceLocalizations(resource.getResourceId());
			JSONObject localizationsJson = resourceJson.getJSONObject("localizations");

			byte[] defaultAttachBytes = null;
			String defaultLanguageId = resource.getDefaultLanguageId();
			if (defaultLanguageId == null || defaultLanguageId.isEmpty()) {
				defaultLanguageId = "English";
			}
			for (ResourceLocalization localization : localizations) {
				if (defaultLanguageId.equals(localization.getLanguageId())) {
					String attachPath = localization.getAttach();
					if (attachPath != null && !attachPath.isEmpty()) {
						try {
							defaultAttachBytes = fetchFileFromDL(attachPath, groupId);
						} catch (Exception e) {
							LOG.warn("Could not fetch default language attachment for resource "
									+ resource.getResourceCode() + ": " + e.getMessage());
						}
					}
					break;
				}
			}

			for (ResourceLocalization localization : localizations) {
				String attachPath = localization.getAttach();
				String attachName = localization.getAttachName();
				String languageId = localization.getLanguageId();

				if (attachName == null || attachName.isEmpty() || attachPath == null || attachPath.isEmpty()) {
					continue;
				}

				try {
					byte[] fileBytes = fetchFileFromDL(attachPath, groupId);

					// If fetched bytes are null or empty, fall back to default language attachment
					if ((fileBytes == null || fileBytes.length == 0)
							&& defaultAttachBytes != null && defaultAttachBytes.length > 0) {
						fileBytes = defaultAttachBytes;
					}

					if (fileBytes != null && fileBytes.length > 0) {
						String zipEntryPath = "attachments/" + resource.getResourceCode() + "/"
								+ languageId + "/" + attachName;
						attachmentFiles.put(zipEntryPath, fileBytes);

						if (localizationsJson != null && localizationsJson.has(languageId)) {
							JSONObject locObj = localizationsJson.getJSONObject(languageId);
							locObj.put("attachZipPath", zipEntryPath);
						}
					}
				} catch (Exception e) {
					LOG.warn("Could not fetch attachment file for resource " + resource.getResourceCode()
							+ ", language " + languageId + ": " + e.getMessage());
				}
			}
		} catch (Exception e) {
			LOG.error("Error collecting attachment files for resource " + resource.getResourceCode(), e);
		}
	}

	/**
	 * Fetches file bytes from Documents and Media based on the stored attach path.
	 * Path format: /documents/{groupId}/{folderId}/{fileName}/
	 */
	private byte[] fetchFileFromDL(String attachPath, long groupId) throws PortalException, IOException {
		String[] parts = attachPath.split("/");
		if (parts.length < 5) {
			LOG.warn("Invalid attach path format: " + attachPath);
			return null;
		}
		long folderId = Long.parseLong(parts[3]);
		String fileName = parts[4].replace('+', ' ');

		try {
			FileEntry fileEntry = _dlAppService.getFileEntry(groupId, folderId, fileName);
			InputStream is = fileEntry.getContentStream();
			ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
			byte[] buffer = new byte[4096];
			int len;
			while ((len = is.read(buffer)) != -1) {
				baos.write(buffer, 0, len);
			}
			is.close();
			return baos.toByteArray();
		} catch (Exception e) {
			LOG.warn("Could not fetch file from DL: " + attachPath, e);
			return null;
		}
	}

	public void importResource(ActionRequest actionRequest, ActionResponse actionResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		List<Role> roles = user.getRoles();
		boolean isAdministrator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Administrator"));
		boolean isPo = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("po"));

		if (!isAdministrator && !isPo) {
			SessionErrors.add(actionRequest, "notAuthorized");
			return;
		}

		try {
			ImportResultDTO importResult = ImportFileUtil.parseZip(actionRequest, Constants.RESOURCE);
			List<ComponentEntryDto> components = importResult.getComponents();
			JSONArray parsedResourcesArray = JSONFactoryUtil.createJSONArray();
			for (int i = 0; i < components.size(); i++) {
				ComponentEntryDto comp = components.get(i);
				JSONObject resourceEntry = JSONFactoryUtil.createJSONObject();
				resourceEntry.put("index", i);
				String resourceCode = "";
				if (comp.getData() != null && comp.getData().has("resourceCode")) {
					resourceCode = comp.getData().getString("resourceCode");
				}
				resourceEntry.put("name", resourceCode);
				// The review modal warns about resources that cannot live in the
				// Blue App channel, so it needs to know the type up front.
				resourceEntry.put("resourceType",
						comp.getData() != null ? comp.getData().getString("resourceType", "") : "");
				parsedResourcesArray.put(resourceEntry);
			}

			List<Channels> approvedChannels = _channelsLocalService.findByStatus(WorkflowConstants.STATUS_APPROVED);
			JSONArray channelsArray = JSONFactoryUtil.createJSONArray();
			for (Channels ch : approvedChannels) {
				JSONObject chObj = JSONFactoryUtil.createJSONObject();
				chObj.put("channelId", ch.getChannelId());
				chObj.put("name", ch.getName());
				chObj.put("blueApp", TelemoneyResourcesPortletKeys.BLUE_APP_CHANNEL_NAME.equals(ch.getName()));
				channelsArray.put(chObj);
			}

			// Get approved parent pages (features) per channel
			JSONObject approvedPagesByChannel = JSONFactoryUtil.createJSONObject();
			for (Channels ch : approvedChannels) {
				List<Feature> pages = _featureLocalServiceImpl.getAllParentPages(ch.getChannelId());
				JSONArray pagesForChannel = JSONFactoryUtil.createJSONArray();
				for (Feature page : pages) {
					JSONObject pageObj = JSONFactoryUtil.createJSONObject();
					pageObj.put("featureId", page.getFeatureId());
					pageObj.put("name", page.getFeatureName());
					pagesForChannel.put(pageObj);
				}
				approvedPagesByChannel.put(String.valueOf(ch.getChannelId()), pagesForChannel);
			}

			// Collect all imported resourceCodes for filtering
			Set<String> importedResourceCodes = new HashSet<>();
			for (ComponentEntryDto comp : components) {
				if (comp.getData() != null && comp.getData().has("resourceCode")) {
					importedResourceCodes.add(comp.getData().getString("resourceCode"));
				}
			}

			// Get approved resources per channel+page filtered by imported resourceCodes (for update option)
			JSONObject approvedResourcesByChannelAndPage = JSONFactoryUtil.createJSONObject();
			for (Channels ch : approvedChannels) {
				Map<Resource, Boolean> resourcesWithPending = _resourcesLocalService.getLatestApprovedByChannelIdWithPending(ch.getChannelId());
				// Group by featureId, only include resources matching imported resourceCodes
				Map<Long, JSONArray> byFeature = new HashMap<>();
				for (Map.Entry<Resource, Boolean> entry : resourcesWithPending.entrySet()) {
					Boolean isPending = entry.getValue();
					if (isPending != null && isPending) {
						continue; // skip resources with pending status
					}
					Resource r = entry.getKey();
					// Only include resources whose resourceCode matches one of the imported ones
					if (!importedResourceCodes.contains(r.getResourceCode())) {
						continue;
					}
					long featureId = r.getFeatureId();
					if (!byFeature.containsKey(featureId)) {
						byFeature.put(featureId, JSONFactoryUtil.createJSONArray());
					}
					JSONObject rObj = JSONFactoryUtil.createJSONObject();
					rObj.put("resourceId", r.getResourceId());
					rObj.put("entityResourceId", r.getEntityResourceId());
					rObj.put("name", r.getResourceCode());
					byFeature.get(featureId).put(rObj);
				}
				JSONObject channelResources = JSONFactoryUtil.createJSONObject();
				for (Map.Entry<Long, JSONArray> featureEntry : byFeature.entrySet()) {
					channelResources.put(String.valueOf(featureEntry.getKey()), featureEntry.getValue());
				}
				approvedResourcesByChannelAndPage.put(String.valueOf(ch.getChannelId()), channelResources);
			}

			PortletSession pSession = actionRequest.getPortletSession();
			pSession.setAttribute("importParsedResources", parsedResourcesArray.toString());
			pSession.setAttribute("importChannels", channelsArray.toString());
			pSession.setAttribute("importApprovedPagesByChannel", approvedPagesByChannel.toString());
			pSession.setAttribute("importApprovedResourcesByChannelAndPage", approvedResourcesByChannelAndPage.toString());
			pSession.setAttribute("importResult", importResult);
		} catch (Exception e) {
			LOG.error("Error during resource import: " + e.getMessage());
			SessionErrors.add(actionRequest, "import-processing-error");
		}
	}

	public void confirmImportResource(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		String importDecisionsJson = ParamUtil.getString(actionRequest, "importDecisions");
		PortletSession pSession = actionRequest.getPortletSession();
		if (importDecisionsJson == null || importDecisionsJson.isEmpty()) {
			LOG.error("No import decisions received");
			SessionErrors.add(actionRequest, "no-import-decisions");
			return;
		}
		ServiceContext serviceContext = createServiceContextForWorkflow(actionRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		ImportResultDTO resultDTO = (ImportResultDTO) pSession.getAttribute("importResult");
		try {
			JSONArray decisionsArray = JSONFactoryUtil.createJSONArray(importDecisionsJson);
			List<ComponentEntryDto> components = resultDTO.getComponents();
			Set<Integer> neglectedIndexes = new HashSet<>();
			for (int i = 0; i < decisionsArray.length(); i++) {
				JSONObject decision = decisionsArray.getJSONObject(i);
				String name = decision.getString("name");
				String action = decision.getString("action");
				long channelId = decision.getLong("channelId");
				long updateResourceId = decision.getLong("updateResourceId", 0);
				long featureId = decision.getLong("featureId", 0);

				boolean found = false;
				for (int j = 0; j < components.size(); j++) {
					ComponentEntryDto entry = components.get(j);
					JSONObject resourceData = entry.getData();
					String resourceCode = resourceData.getString("resourceCode", "");

					if (name.equals(resourceCode)) {
						entry.setAction(action);
						entry.setChannelId(channelId);
						entry.setAffectedEntityId(updateResourceId);
						// Store featureId in the data for later use
						resourceData.put("selectedFeatureId", featureId);
						found = true;

						// Blue App only holds attachment resources. The channel can
						// still be picked for any other type, but such a resource is
						// neglected instead of imported.
						if (isBlueAppChannel(channelId) &&
								!TelemoneyResourcesPortletKeys.BLUE_APP_RESOURCE_TYPE.equals(
										resourceData.getString("resourceType", ""))) {

							LOG.info("Neglecting resource '" + name
									+ "': only attachment resources can be imported into the Blue App channel.");
							neglectedIndexes.add(j);
						}
						break;
					}
				}
				if (!found) {
					LOG.warn("Could not find resource with code '" + name + "' in components list, skipping.");
				}
			}

			if (!neglectedIndexes.isEmpty()) {
				List<ComponentEntryDto> importable = new ArrayList<>();
				for (int j = 0; j < components.size(); j++) {
					if (!neglectedIndexes.contains(j)) {
						importable.add(components.get(j));
					}
				}
				components = importable;
				resultDTO.setComponents(importable);
			}

			if (components.isEmpty()) {
				LOG.warn("No importable resources left after filtering, nothing to import.");
				SessionErrors.add(actionRequest, "no-importable-resources");
				return;
			}

			Path path = _importRequestLocalService.buildZip(resultDTO);
			_importRequestLocalService.startImportRequestWorkflow(resultDTO, path.toString(), user, serviceContext);

		} catch (Exception e) {
			LOG.error("Error processing import decisions: " + e.getMessage(), e);
			SessionErrors.add(actionRequest, "import-processing-error");
		}
	}

	private JSONObject resourceToJson(Resource resource) throws JSONException {
		JSONObject obj = JSONFactoryUtil.createJSONObject();
		obj.put("resourceCode", resource.getResourceCode());
		obj.put("resourceType", resource.getResourceType());
		obj.put("urlType", resource.getUrlType());
		obj.put("defaultLanguageId", resource.getDefaultLanguageId());

		// Add localizations
		JSONObject localizations = JSONFactoryUtil.createJSONObject();
		List<ResourceLocalization> resourceLocalizations = _resourcesLocalService.getResourceLocalizations(resource.getResourceId());
		for (ResourceLocalization localization : resourceLocalizations) {
			JSONObject locObj = JSONFactoryUtil.createJSONObject();
			locObj.put("languageId", localization.getLanguageId());
			locObj.put("name", localization.getName());
			locObj.put("attach", localization.getAttach());
			locObj.put("attachName", localization.getAttachName());
			locObj.put("description", localization.getDescription());
			locObj.put("routeId", localization.getRouteId());
			locObj.put("url", localization.getUrl());
			localizations.put(localization.getLanguageId(), locObj);
		}
		obj.put("localizations", localizations);

		return obj;
	}

	@Reference
	private DLAppService _dlAppService;
	@Reference
	private ResourceLocalService _resourcesLocalService;

	@Reference
	private LanguagesLocalService _languagesLocalService;

	@Reference
	private FeatureLocalService _featureLocalServiceImpl;

	@Reference
	private UserLogsLocalService _userLogsLocalService;

	@Reference
	private ImportRequestLocalService _importRequestLocalService;

	@Reference
	private ChannelsLocalService _channelsLocalService;
}

