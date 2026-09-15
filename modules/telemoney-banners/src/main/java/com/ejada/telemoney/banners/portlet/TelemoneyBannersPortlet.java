package com.ejada.telemoney.banners.portlet;

import com.ejada.telemoney.banners.constants.TelemoneyBannersPortletKeys;
import com.ejada.telemoney.banners.utils.FileValidatorUtil;
import com.ejada.telemoney.db.constants.TelemoneyConstants;
import com.ejada.telemoney.db.dto.BannerContentDTO;
import com.ejada.telemoney.db.dto.BlockDTO;
import com.ejada.telemoney.db.dto.importDtos.ComponentEntryDto;
import com.ejada.telemoney.db.dto.importDtos.ImportResultDTO;
import com.ejada.telemoney.db.utils.ExportFileUtil;
import com.ejada.telemoney.db.utils.ImportFileUtil;
import com.ejada.telemony.db.constants.Constants;
import com.ejada.telemony.db.model.*;
import com.ejada.telemony.db.service.BannerContentLocalService;
import com.ejada.telemony.db.service.BannerLocalService;
import com.ejada.telemony.db.service.BlocksLocalService;
import com.ejada.telemony.db.service.ChannelsLocalService;
import com.ejada.telemony.db.service.FeatureLocalService;
import com.ejada.telemony.db.service.ImportRequestLocalService;
import com.ejada.telemony.db.service.LanguagesLocalService;
import com.ejada.telemony.db.service.PersonaLocalService;
import com.ejada.telemony.db.service.UserLogsLocalService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.json.JSONObject;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
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

import com.liferay.portal.kernel.workflow.WorkflowConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author rmostafa
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=TelemoneyBanners", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TelemoneyBannersPortletKeys.TELEMONEYBANNERS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)

public class TelemoneyBannersPortlet extends MVCPortlet {
	private static final Pattern XSS_PATTERN = Pattern.compile(".*[<>\"'\\\\].*");

	private static final Log LOG = LogFactoryUtil.getLog(TelemoneyBannersPortlet.class);


	private boolean containsXSS(String input) {
	    return input != null && XSS_PATTERN.matcher(input).find();
	}
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		PortletSession pSession = renderRequest.getPortletSession();
		Long channelId = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
				? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1;
		String myview = "view";
		String reqView = (String) renderRequest.getAttribute("myview") == null ? ""
				: (String) renderRequest.getAttribute("myview");
		if (Objects.equals(reqView, "") && ParamUtil.getString(renderRequest, "myview").isEmpty()) {
			List<Banner> banners = _bannerLocalService.getLatestApprovedByChannelId(channelId);

			Set<Long> bannersWithPendingVersions = new HashSet<>();
			for (Banner banner : banners) {
				boolean hasPendingVersion = false;
				List<Banner> allVersions = _bannerLocalService.getByEntityResourceId(banner.getEntityResourceId());
				List<BannerContent> bannerContents = _bannerContentLocalService.getByEntityResourceId(banner.getEntityResourceId());
				for (BannerContent bannerContent : bannerContents) {
					if (bannerContent.getStatus() == WorkflowConstants.STATUS_DRAFT) {
						hasPendingVersion = true;
						bannersWithPendingVersions.add(banner.getBannerId());
						break;
					}
				}
				if (hasPendingVersion)
					continue;
				for (Banner version : allVersions) {
					if (!(version.getBannerId() == banner.getBannerId()) &&
						(version.getStatus() == WorkflowConstants.STATUS_DRAFT)) {
						bannersWithPendingVersions.add(banner.getBannerId());
						break;
					}
				}

			}
			renderRequest.setAttribute("banners",banners);
			renderRequest.setAttribute("bannersWithPendingVersions", bannersWithPendingVersions);

			boolean hasPendingImport = _importRequestLocalService.hasPendingImportRequest(Constants.BANNER);
			renderRequest.setAttribute("hasPendingImport", hasPendingImport);

			String importParsedBanners = (String) pSession.getAttribute("importParsedBanners");
			if (importParsedBanners != null) {
				renderRequest.setAttribute("importParsedBanners", importParsedBanners);
				renderRequest.setAttribute("importChannels", pSession.getAttribute("importChannels"));
				renderRequest.setAttribute("importApprovedPersonasByChannel", pSession.getAttribute("importApprovedPersonasByChannel"));
				renderRequest.setAttribute("importApprovedBannersByChannel", pSession.getAttribute("importApprovedBannersByChannel"));
				pSession.removeAttribute("importParsedBanners");
				pSession.removeAttribute("importChannels");
				pSession.removeAttribute("importApprovedPersonasByChannel");
				pSession.removeAttribute("importApprovedBannersByChannel");
			}
		} else if (reqView.equals("add") || ParamUtil.getString(renderRequest, "myview").equals("add")) {
			myview = "add";

			List<Persona> personas = _personaLocalService.getbyChannelId(channelId);
			renderRequest.setAttribute("personas", personas);

			// Compute hasPendingVersion based on bannerId
			Long bannerId = (Long) renderRequest.getAttribute("bannerId");
			if (bannerId != null && bannerId > 0) {
				renderRequest.setAttribute("hasPendingVersion", checkHasPendingVersion(bannerId));
			}

		} else if (ParamUtil.getString(renderRequest, "myview").equals("addContent") || reqView.equals("addContent")) {
			myview = "content";
			List<Languages> languages = _languageLocalService.getbyChannelId(channelId);
			List<String> languagesName = new ArrayList<>();
			for (Languages langName : languages) {
				languagesName.add(langName.getLangName());
			}
			renderRequest.setAttribute("languagesNames", languagesName);
			renderRequest.setAttribute("features", _featureLocalService.getLatestApprovedByChannelId(channelId));

			// Compute hasPendingVersion based on bannerId
			Long bannerId = (Long) renderRequest.getAttribute("bannerId");
			if (bannerId != null && bannerId > 0) {
				renderRequest.setAttribute("hasPendingVersion", checkHasPendingVersion(bannerId));
			}
		}

		String view = "/" + myview + ".jsp";
		/*
		 * try { _bannerContentLocalService.editOrder(5); } catch
		 * (NoSuchBannerContentException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(view);
		dispatcher.include(renderRequest, renderResponse);
	}

	public void getBannerIdForView(ActionRequest actionRequest, ActionResponse actionRespons) {

		Long bannerId = ParamUtil.getLong(actionRequest, "selectedBannerId", 0);
		Banner banner;

		try {
			banner = _bannerLocalService.getBanner(bannerId);

			// Get only approved banner contents for display
			List<BannerContent> bannerContents = _bannerContentLocalService.getByEntityResourceIdAndStatusApproved(banner.getEntityResourceId());

			long blockId = banner.getBlockId();
			Blocks block = _blocksLocalService.fetchBlocks(blockId);
			String androidVersion = block != null ? block.getAndroidBlockVersion() : "";
			String iosVersion = block != null ? block.getIosBlockVersion() : "";
			String webVersion = block != null ? block.getWebBlockVersion() : "";
			boolean androidCheck = block != null && block.getAndroidBlock();
			boolean iosCheck = block != null && block.getIosBlock();
			boolean webCheck = block != null && block.getWebBlock();

			actionRequest.setAttribute("androidBlock", setBlockDate(block, "android"));
			actionRequest.setAttribute("iosBlock", setBlockDate(block, "ios"));
			actionRequest.setAttribute("webBlock", setBlockDate(block, "web"));
			actionRequest.setAttribute("androidVersion", androidVersion);
			actionRequest.setAttribute("iosVersion", iosVersion);
			actionRequest.setAttribute("webVersion", webVersion);
			actionRequest.setAttribute("androidCheck", androidCheck);
			actionRequest.setAttribute("iosCheck", iosCheck);
			actionRequest.setAttribute("webCheck", webCheck);
			actionRequest.setAttribute("bannerId", bannerId);
			actionRequest.setAttribute("channelId", banner.getChannelId());
			actionRequest.setAttribute("bannerName", banner.getBannerName());
			actionRequest.setAttribute("bannerType", banner.getBannerType());
			actionRequest.setAttribute("container", banner.getContainer());
			actionRequest.setAttribute("dateFrom", banner.getDateFrom());
			actionRequest.setAttribute("dateTo", banner.getDateTo());
			actionRequest.setAttribute("blockId", banner.getBlockId());
			actionRequest.setAttribute("selectedPersonas", banner.getPersona());
			actionRequest.setAttribute("bannerContents", bannerContents);
			actionRequest.setAttribute("myview", "add");

		} catch (PortalException e) {
			e.printStackTrace();
		}

	}

	public void getBannerContentIdForView(ActionRequest actionRequest, ActionResponse actionRespons) {
		PortletSession pSession = actionRequest.getPortletSession();
		Long channelId = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
				? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1;
		Long bannerContentId = ParamUtil.getLong(actionRequest, "selectedBannerContentId", 0);
		Long bannerId = ParamUtil.getLong(actionRequest, "bannerId", 0);

		List<Languages> languages = _languageLocalService.getbyChannelId(channelId);
		Map<String, String> titleValues = new HashMap<>();
		Map<String, String> descValues = new HashMap<>();
		Map<String, String> bannerImages = new HashMap<>();
		Map<String, String> imageOverlays = new HashMap<>();
		Map<String, String> links = new HashMap<>();
		Map<String, String> urls = new HashMap<>();
		for (Languages language : languages) {
			BannerContentLocalization bannerContentLocal = _bannerContentLocalService
					.fetchBannerContentLocalization(bannerContentId, language.getLangName());
			if (bannerContentLocal != null) {
				titleValues.put(language.getLangName(),
						bannerContentLocal.getTitleValue() != null ? bannerContentLocal.getTitleValue() : "");
				descValues.put(language.getLangName(),
						bannerContentLocal.getDescriptionValue() != null ? bannerContentLocal.getDescriptionValue()
								: "");
				bannerImages.put(language.getLangName(),
						bannerContentLocal.getBannerImage() != null ? bannerContentLocal.getBannerImage() : "");
				imageOverlays.put(language.getLangName(), bannerContentLocal.getImageOverlay());
				links.put(language.getLangName(),
						bannerContentLocal.getLinkType() != null ? bannerContentLocal.getLinkType() : "");
				urls.put(language.getLangName(),
						bannerContentLocal.getUrl() != null ? bannerContentLocal.getUrl() : "");
			}
		}
		BannerContent bannerContent = _bannerContentLocalService.fetchBannerContent(bannerContentId);
		actionRequest.setAttribute("bannerContentId", bannerContentId);
		actionRequest.setAttribute("bannerId", bannerId);
		actionRequest.setAttribute("bannerName", bannerContent.getContentName());
		actionRequest.setAttribute("titleValues", titleValues);
		actionRequest.setAttribute("descValues", descValues);
		actionRequest.setAttribute("bannerImages", bannerImages);
		actionRequest.setAttribute("imageOverlays", imageOverlays);
		actionRequest.setAttribute("links", links);
		actionRequest.setAttribute("urls", urls);
		actionRequest.setAttribute("status", bannerContent.getContentStatus());
		actionRequest.setAttribute("myview", "addContent");

	}

	public void addBannerLocalized(ActionRequest actionRequest, ActionResponse actionRespons) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		List<Role> roles = user.getRoles();
		boolean isAdministrator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Administrator"));
		boolean isPo = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("po"));
		boolean isMarketing = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Marketing"));

		if (!isAdministrator && !isPo && !isMarketing) {
			SessionErrors.add(actionRequest, "notAuthorized");
			return;
		}

		PortletSession pSession = actionRequest.getPortletSession();
		Long channelId = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
				? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1;
		String userName = themeDisplay.getUser().getFullName();

		List<Languages> languages = _languageLocalService.getbyChannelId(channelId);
		List<String> languagesName = new ArrayList<>();
		for (Languages langName : languages) {
			languagesName.add(langName.getLangName());
		}
		Long bannerId = ParamUtil.getLong(actionRequest, "selectedBannerId", 0);
		Long blockId = ParamUtil.getLong(actionRequest, "blockId", 0);
		String bannerName = ParamUtil.getString(actionRequest, "bannerName", "");
		String bannerType = ParamUtil.getString(actionRequest, "bannerType", "");
		String container = ParamUtil.getString(actionRequest, "container", "");
		String dateFrom = ParamUtil.getString(actionRequest, "startDateBanner", "");
		String dateTo = ParamUtil.getString(actionRequest, "endDateBanner", "");
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date1 = (dateFrom != "") ? dateFormat.parse(dateFrom) : null;
		Date date2 = (dateTo != "") ? dateFormat.parse(dateTo) : null;
		boolean androidCheck = ParamUtil.getBoolean(actionRequest, "androidCheck", false);
		boolean iosCheck = ParamUtil.getBoolean(actionRequest, "iosCheck", false);
		boolean webCheck = ParamUtil.getBoolean(actionRequest, "webCheck", false);
		String androidStartDate, androidEndDate, androidVersion = null, iosStartDate, iosEndDate, iosVersion = null,
				webStartDate, webEndDate, webVersion = null;
		Date androidStartDateObj = null;
		Date androidEndDateObj = null;
		Date iosStartDateObj = null;
		Date iosEndDateObj = null;
		Date webStartDateObj = null;
		Date webEndDateObj = null;
		if (androidCheck) {
			androidVersion = ParamUtil.getString(actionRequest, "androidVersion");
			androidStartDate = ParamUtil.getString(actionRequest, "androidStartDate");
			androidEndDate = ParamUtil.getString(actionRequest, "androidEndDate");
			androidStartDateObj = (androidStartDate != "") ? dateFormat.parse(androidStartDate) : null;
			androidEndDateObj = (androidEndDate != "") ? dateFormat.parse(androidEndDate) : null;
		}
		if (iosCheck) {
			iosVersion = ParamUtil.getString(actionRequest, "iosVersion");
			iosStartDate = ParamUtil.getString(actionRequest, "iosStartDate");
			iosEndDate = ParamUtil.getString(actionRequest, "iosEndDate");
			iosStartDateObj = (iosStartDate != "") ? dateFormat.parse(iosStartDate) : null;
			iosEndDateObj = (iosEndDate != "") ? dateFormat.parse(iosEndDate) : null;
		}
		if (webCheck) {
			webVersion = ParamUtil.getString(actionRequest, "webVersion");
			webStartDate = ParamUtil.getString(actionRequest, "webStartDate");
			webEndDate = ParamUtil.getString(actionRequest, "webEndDate");
			webStartDateObj = (webStartDate != "") ? dateFormat.parse(webStartDate) : null;
			webEndDateObj = (webEndDate != "") ? dateFormat.parse(webEndDate) : null;
		}

		String[] selectedPersonas = ParamUtil.getStringValues(actionRequest, "selectedPersonas");
		if (containsXSS(bannerName) || containsXSS(bannerType) || containsXSS(container)
			    || containsXSS(androidVersion) || containsXSS(iosVersion) || containsXSS(webVersion)) {
				SessionErrors.add(actionRequest, "xssDetected");
				return;
			}

		if (selectedPersonas != null) {
		    for (String persona : selectedPersonas) {
		        if (containsXSS(persona)) {
		            SessionErrors.add(actionRequest, "xssDetected");
		            return;
		        }
		    }
		}
		JSONArray selectedPersonasJSON = JSONFactoryUtil.createJSONArray(selectedPersonas);


		if (selectedPersonasJSON.length() == 0)
			throw new Exception("No Personas were Selected");

		 ServiceContext serviceContext = createServiceContextForWorkflow(actionRequest);
		if (bannerId > 0) {

			boolean hasPendingVersion = checkHasPendingVersion(bannerId);
			if (hasPendingVersion) {
				SessionErrors.add(actionRequest, "hasPendingVersion");
				return;
			}

			BlockDTO blockDto = _bannerLocalService.createBlockDto(channelId, null, androidCheck, androidVersion, androidStartDateObj,
					androidEndDateObj, iosCheck, iosVersion, iosStartDateObj, iosEndDateObj, webCheck, webVersion,
					webStartDateObj, webEndDateObj);
			_bannerLocalService.updateBannerWithLocalization(channelId, bannerName, bannerType, container, date1, date2,
					blockDto, bannerId, selectedPersonasJSON.toString(),serviceContext,user,actionRequest);
			String userAction = TelemoneyConstants.USER_ACTION_UPDATE.concat(TelemoneyConstants.USER_LOGS_Banner)
					.concat(bannerName);
			_userLogsLocalService.addUserData(userName, userAction, channelId);

		} else {
			BlockDTO blockDto = _bannerLocalService.createBlockDto(channelId, null, androidCheck, androidVersion, androidStartDateObj,
					androidEndDateObj, iosCheck, iosVersion, iosStartDateObj, iosEndDateObj, webCheck, webVersion,
					webStartDateObj, webEndDateObj);
			_bannerLocalService.addNewBannerWithLocalization(channelId, bannerName, bannerType, container, date1, date2,
					blockDto, selectedPersonasJSON.toString(),serviceContext,user);
			String userAction = TelemoneyConstants.USER_ACTION_ADD.concat(TelemoneyConstants.USER_LOGS_Banner)
					.concat(bannerName);
			_userLogsLocalService.addUserData(userName, userAction, channelId);
		}
	}

	public void addContent(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		List<Role> roles = user.getRoles();
		boolean isAdministrator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Administrator"));
		boolean isPo = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("po"));
		boolean isMarketing = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Marketing"));

		if (!isAdministrator && !isPo && !isMarketing) {
			SessionErrors.add(actionRequest, "notAuthorized");
			return;
		}

		PortletSession pSession = actionRequest.getPortletSession();
		Long channelId = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
				? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1;
		List<Languages> languages = _languageLocalService.getbyChannelId(channelId);
		List<String> languagesName = new ArrayList<>();
		for (Languages langName : languages) {
			languagesName.add(langName.getLangName());
		}
		Long bannerId = ParamUtil.getLong(actionRequest, "selectedBannerId", 0);
		Long bannerContentId = ParamUtil.getLong(actionRequest, "bannerContentId", 0);
		String bannerName = ParamUtil.getString(actionRequest, "bannerName", "");
		String status = ParamUtil.getString(actionRequest, "status", "");

		 boolean hasPendingVersion = checkHasPendingVersion(bannerId);
		if (hasPendingVersion) {
			SessionErrors.add(actionRequest, "hasPendingVersion");
			LOG.warn("User attempted to add/update content for banner ID " + bannerId + " which has a pending version");
			return;
		}

		Map<String, String> titleValues = new HashMap<>();
		Map<String, String> descValues = new HashMap<>();
		Map<String, String> bannerImages = new HashMap<>();
		Map<String, String> imageOverlays = new HashMap<>();
		Map<String, String> links = new HashMap<>();
		Map<String, String> urls = new HashMap<>();
		String enBannerImageCheck = ParamUtil.getString(actionRequest, "EnglishBannerImageCheck", "");
		String enImageOverlay = ParamUtil.getString(actionRequest, "EnglishImageOverlay", "");
		String enTitleValue = ParamUtil.getString(actionRequest, "EnglishTitleValue", "");
		String enDescValue = ParamUtil.getString(actionRequest, "EnglishDescValue", "");
		String enLinkValue = ParamUtil.getString(actionRequest, "EnglishLinkType", "");
		String enURLValue = "";
		if (enLinkValue.equals("0"))
			enURLValue = ParamUtil.getString(actionRequest, "EnglishInternalURL", "");
		else if (enLinkValue.equals("1"))
			enURLValue = ParamUtil.getString(actionRequest, "EnglishExternalURL", "");
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		File enfile = uploadRequest.getFile("EnglishBannerImage");

		for (String langName : languagesName) {
			File file = uploadRequest.getFile(langName + "BannerImage");
			String imageName = uploadRequest.getFileName(langName + "BannerImage");
			String bannerImageCheck = ParamUtil.getString(actionRequest, langName + "BannerImageCheck", "");

			try {
				if (file != null && file.length() > 0 && imageName != null && !imageName.trim().isEmpty()) {
					FileValidatorUtil.validateImageFile(uploadRequest, langName + "BannerImage");
					String coverImg64 = Base64.getEncoder().encodeToString(FileUtil.getBytes(file));
					bannerImages.put(langName, coverImg64);

				} else if (bannerImageCheck.equals("") && !enBannerImageCheck.equals("")) {
					//  Fall back to English image
					if (enfile != null && enfile.length() > 0) {
						FileValidatorUtil.validateImageFile(uploadRequest, "EnglishBannerImage");

						String coverImg64 = Base64.getEncoder().encodeToString(FileUtil.getBytes(enfile));
						bannerImages.put(langName, coverImg64);
					}
				}
			} catch (Exception e) {
				SessionErrors.add(actionRequest, "file-upload-error");
				e.printStackTrace(); 
				return;
			}

			String imageOverlay = ParamUtil.getString(actionRequest, langName + "ImageOverlay", "");
			if (imageOverlay.equals("") && !enImageOverlay.equals(""))
				imageOverlays.put(langName, enImageOverlay);
			else
				imageOverlays.put(langName, imageOverlay);

			String titleValue = ParamUtil.getString(actionRequest, langName + "TitleValue", "");
			if (titleValue.equals("") && !enTitleValue.equals(""))
				titleValues.put(langName, enTitleValue);
			else
				titleValues.put(langName, titleValue);

			String descValue = ParamUtil.getString(actionRequest, langName + "DescValue", "");
			if (descValue.equals("") && !enDescValue.equals(""))
				descValues.put(langName, enDescValue);
			else
				descValues.put(langName, descValue);

			String linkType = ParamUtil.getString(actionRequest, langName + "LinkType", "");
			if (linkType.equals("") && !enLinkValue.equals(""))
				links.put(langName, enLinkValue);
			else
				links.put(langName, linkType);

			if (linkType.equals("")) {
				urls.put(langName, enURLValue);

			} else if (linkType.equals("0")) {
				String url = ParamUtil.getString(actionRequest, langName + "InternalURL", "");
				urls.put(langName, url);
			} else if (linkType.equals("1")) {
				String url = ParamUtil.getString(actionRequest, langName + "ExternalURL", "");
				urls.put(langName, url);
			}
		}
		 if (containsXSS(bannerName) || containsXSS(status) || containsXSS(enImageOverlay) ||
		            containsXSS(enTitleValue) || containsXSS(enDescValue) || containsXSS(enLinkValue) || containsXSS(enURLValue)) {
		            SessionErrors.add(actionRequest, "xssDetected");
		            return;
		        }

		BannerContentDTO bannerContentDTO =_bannerLocalService.createBannerContentDto(channelId, bannerName,
				bannerId,
				status
				, titleValues,
				descValues,
				bannerImages,
				imageOverlays,
				links,
				urls
				, bannerContentId);

		ServiceContext serviceContext= createServiceContextForWorkflow(actionRequest);
		_bannerLocalService.handleBannerContent(bannerContentDTO,serviceContext,user);

		getBannerIdForView(actionRequest, actionResponse);
	}

	public void deleteBannerPortlet(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, PortletException, IOException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		List<Role> roles = user.getRoles();
		boolean isAdministrator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Administrator"));
		boolean isPo = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("po"));
		boolean isMarketing = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Marketing"));

		if (!isAdministrator && !isPo && !isMarketing) {
			SessionErrors.add(actionRequest, "notAuthorized");
			return;
		}

		PortletSession pSession = actionRequest.getPortletSession();
		Long channelId = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
				? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1;
		String userName = themeDisplay.getUser().getFullName();
		Long selectedBannerId = ParamUtil.getLong(actionRequest, "selectedBannerId", 0);
		Banner banner =_bannerLocalService.fetchBanner(selectedBannerId);
		if (banner != null) {
			boolean hasPendingVersion = checkHasPendingVersion(selectedBannerId);
			if (hasPendingVersion) {
				SessionErrors.add(actionRequest, "hasPendingVersion");
				LOG.info("User attempted to delete banner ID " + selectedBannerId + " which has a pending version");
				return;
			}
			String bannerName = banner.getBannerName();
			String userAction = TelemoneyConstants.USER_ACTION_DELETE.concat(TelemoneyConstants.USER_LOGS_Banner)
					.concat(bannerName);
			ServiceContext serviceContext = createServiceContextForWorkflow(actionRequest);
			_bannerLocalService.deleteBannersWorkflow(selectedBannerId, serviceContext, user);
			_userLogsLocalService.addUserData(userName, userAction, channelId);
		}
	}

	public void deleteContent(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, JsonProcessingException {
		Long bannerId = ParamUtil.getLong(actionRequest, "selectedBannerId", 0);
		boolean hasPendingVersion = checkHasPendingVersion(bannerId);
		if (hasPendingVersion) {
			SessionErrors.add(actionRequest, "hasPendingVersion");
			LOG.info("User attempted to delete content for banner ID " + bannerId + " which has a pending version");
		} else {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Long selectedBannerContentId = ParamUtil.getLong(actionRequest, "selectedBannerContentId", 0);
		User user = themeDisplay.getUser();
		ServiceContext serviceContext = createServiceContextForWorkflow(actionRequest);
		BannerContent originalBannerContent = _bannerContentLocalService.getBannerContent(selectedBannerContentId);
		if (originalBannerContent != null) {
		_bannerLocalService.handleDeleteBannerContent(originalBannerContent, serviceContext, user);
		getBannerIdForView(actionRequest, actionResponse);
		actionRequest.setAttribute("myview", null);
		}
		}
	}

	public Map<String, Integer> setBlockDate(Blocks block, String platform) {
		Map<String, Integer> dates = new HashMap<>();
		Calendar startCalendar = Calendar.getInstance();
		Calendar endCalendar = Calendar.getInstance();
		Date dateFrom = null;
		Date dateTo = null;
		if (block != null && platform.equals("android")) {
			dateFrom = block.getAndroidBlockFrom() != null ? block.getAndroidBlockFrom() : new Date();
			dateTo = block.getAndroidBlockTo() != null ? block.getAndroidBlockTo() : new Date();
			startCalendar.setTime(dateFrom);
			int startYear = startCalendar.get(Calendar.YEAR);
			int startMonth = startCalendar.get(Calendar.MONTH);
			int startDay = startCalendar.get(Calendar.DAY_OF_MONTH);
			endCalendar.setTime(dateTo);
			int endYear = endCalendar.get(Calendar.YEAR);
			int endMonth = endCalendar.get(Calendar.MONTH);
			int endDay = endCalendar.get(Calendar.DAY_OF_MONTH);
			dates.put("startYear", startYear);
			dates.put("startMonth", startMonth);
			dates.put("startDay", startDay);
			dates.put("endYear", endYear);
			dates.put("endMonth", endMonth);
			dates.put("endDay", endDay);
			return dates;
		} else if (block != null && platform.equals("ios")) {
			dateFrom = block.getIosBlockFrom() != null ? block.getIosBlockFrom() : new Date();
			dateTo = block.getIosBlockTo() != null ? block.getIosBlockTo() : new Date();
			startCalendar.setTime(dateFrom);
			int startYear = startCalendar.get(Calendar.YEAR);
			int startMonth = startCalendar.get(Calendar.MONTH);
			int startDay = startCalendar.get(Calendar.DAY_OF_MONTH);
			endCalendar.setTime(dateTo);
			int endYear = endCalendar.get(Calendar.YEAR);
			int endMonth = endCalendar.get(Calendar.MONTH);
			int endDay = endCalendar.get(Calendar.DAY_OF_MONTH);
			dates.put("startYear", startYear);
			dates.put("startMonth", startMonth);
			dates.put("startDay", startDay);
			dates.put("endYear", endYear);
			dates.put("endMonth", endMonth);
			dates.put("endDay", endDay);
			return dates;
		} else if (block != null && platform.equals("web")) {
			dateFrom = block.getWebBlockFrom() != null ? block.getWebBlockFrom() : new Date();
			dateTo = block.getWebBlockTo() != null ? block.getWebBlockTo() : new Date();
			startCalendar.setTime(dateFrom);
			int startYear = startCalendar.get(Calendar.YEAR);
			int startMonth = startCalendar.get(Calendar.MONTH);
			int startDay = startCalendar.get(Calendar.DAY_OF_MONTH);
			endCalendar.setTime(dateTo);
			int endYear = endCalendar.get(Calendar.YEAR);
			int endMonth = endCalendar.get(Calendar.MONTH);
			int endDay = endCalendar.get(Calendar.DAY_OF_MONTH);
			dates.put("startYear", startYear);
			dates.put("startMonth", startMonth);
			dates.put("startDay", startDay);
			dates.put("endYear", endYear);
			dates.put("endMonth", endMonth);
			dates.put("endDay", endDay);
			return dates;
		} else {
			dateFrom = new Date();
			dateTo = new Date();
			startCalendar.setTime(dateFrom);
			int startYear = startCalendar.get(Calendar.YEAR);
			int startMonth = startCalendar.get(Calendar.MONTH);
			int startDay = startCalendar.get(Calendar.DAY_OF_MONTH);
			endCalendar.setTime(dateTo);
			int endYear = endCalendar.get(Calendar.YEAR);
			int endMonth = endCalendar.get(Calendar.MONTH);
			int endDay = endCalendar.get(Calendar.DAY_OF_MONTH);
			dates.put("startYear", startYear);
			dates.put("startMonth", startMonth);
			dates.put("startDay", startDay);
			dates.put("endYear", endYear);
			dates.put("endMonth", endMonth);
			dates.put("endDay", endDay);
			return dates;
		}
	}
	private ServiceContext createServiceContextForWorkflow(ActionRequest actionRequest) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Banner.class.getName(), actionRequest);
		serviceContext.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH);
		return serviceContext;
	}

	private boolean checkHasPendingVersion(Long bannerId) {
		try {
			Banner banner = _bannerLocalService.getBanner(bannerId);

			// Check if any banner content has draft status
			List<BannerContent> bannerContents = _bannerContentLocalService.getByEntityResourceId(banner.getEntityResourceId());
			for (BannerContent bc : bannerContents) {
				if (bc.getStatus() == WorkflowConstants.STATUS_DRAFT) {
					return true;
				}
			}

			// Check if any banner version (other than current) has draft status
			List<Banner> allVersions = _bannerLocalService.getByEntityResourceId(banner.getEntityResourceId());
			for (Banner version : allVersions) {
				if (version.getBannerId() != banner.getBannerId() &&
					version.getStatus() == WorkflowConstants.STATUS_DRAFT) {
					return true;
				}
			}
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return false;
	}


	public void exportBanner(ActionRequest actionRequest, ActionResponse actionResponse)
	{
		long[] bannerIds = ParamUtil.getLongValues(actionRequest, "bannerIds");
		String summary = ParamUtil.getString(actionRequest, "exportSummary", "Banner Export");

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		List<Role> roles = user.getRoles();
		boolean isAdministrator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Administrator"));
		boolean isPo = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("po"));
		boolean isMarketing = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Marketing"));

		if (!isAdministrator && !isPo && !isMarketing) {
			SessionErrors.add(actionRequest, "notAuthorized");
			return;
		}

		List<ComponentEntryDto> exportData = new ArrayList<>();

		for (long bannerId : bannerIds) {
			try {
				if (checkHasPendingVersion(bannerId)) {
					LOG.warn("Skipping export of banner ID " + bannerId + " because it has a pending version");
					continue;
				}
				Banner banner = _bannerLocalService.getBanner(bannerId);
				List<BannerContent> bannerContents = _bannerContentLocalService.getByEntityResourceIdAndStatusApproved(banner.getEntityResourceId());
				Blocks block = _blocksLocalService.fetchBlocks(banner.getBlockId());
				JSONObject obj = bannerToJson(banner,bannerContents,block);
				ComponentEntryDto dto = new ComponentEntryDto();
				dto.setData(obj);
				exportData.add(dto);
			} catch (PortalException e) {
				e.printStackTrace();
				SessionErrors.add(actionRequest, "error");
			}
		}


		if(exportData.isEmpty()) {
			SessionErrors.add(actionRequest, "noDataToExport");
			return;
		}
		try {
			ExportFileUtil.downloadZip(summary, exportData, user, Constants.BANNER, actionRequest, actionResponse);
		} catch (IllegalStateException e) {
			SessionErrors.add(actionRequest, "zipSizeExceeded");
		}
	}

	public void importBanner(ActionRequest actionRequest, ActionResponse actionResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		List<Role> roles = user.getRoles();
		boolean isAdministrator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Administrator"));
		boolean isPo = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("po"));
		boolean isMarketing = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Marketing"));

		if (!isAdministrator && !isPo && !isMarketing) {
			SessionErrors.add(actionRequest, "notAuthorized");
			return;
		}

		try {
			ImportResultDTO importResult = ImportFileUtil.parseZip(actionRequest,Constants.BANNER);
			List<ComponentEntryDto> components = importResult.getComponents();
			JSONArray parsedBannersArray = JSONFactoryUtil.createJSONArray();
			for (int i = 0; i < components.size(); i++) {
				ComponentEntryDto comp = components.get(i);
				JSONObject bannerEntry = JSONFactoryUtil.createJSONObject();
				bannerEntry.put("index", i);
				String bannerName = "";
				if (comp.getData() != null && comp.getData().has("bannerName")) {
					bannerName = comp.getData().getString("bannerName");
				}
				bannerEntry.put("name", bannerName);
				parsedBannersArray.put(bannerEntry);
			}

			List<Channels> approvedChannels = _channelsLocalService.findByStatus(WorkflowConstants.STATUS_APPROVED);
			JSONArray channelsArray = JSONFactoryUtil.createJSONArray();
			for (Channels ch : approvedChannels) {
				JSONObject chObj = JSONFactoryUtil.createJSONObject();
				chObj.put("channelId", ch.getChannelId());
				chObj.put("name", ch.getName());
				channelsArray.put(chObj);
			}

			JSONObject approvedPersonasByChannel = JSONFactoryUtil.createJSONObject();
			for (Channels ch : approvedChannels) {
				Map<Persona, Boolean> personasWithPending = _personaLocalService.getLatestApprovedByChannelIdWithPending(ch.getChannelId());
				JSONArray personasForChannel = JSONFactoryUtil.createJSONArray();
				for (Map.Entry<Persona, Boolean> entry : personasWithPending.entrySet()) {
					Boolean isPending = entry.getValue();
					if (isPending != null && isPending) {
						continue; // skip personas with pending status
					}
					Persona p = entry.getKey();
					JSONObject pObj = JSONFactoryUtil.createJSONObject();
					pObj.put("personaId", p.getPersonaId());
					pObj.put("name", p.getName());
					personasForChannel.put(pObj);
				}
				approvedPersonasByChannel.put(String.valueOf(ch.getChannelId()), personasForChannel);
			}

			JSONObject approvedBannersByChannel = JSONFactoryUtil.createJSONObject();
			for (Channels ch : approvedChannels) {
				List<Banner> approvedBanners = _bannerLocalService.getLatestApprovedByChannelId(ch.getChannelId());
				JSONArray bannersForChannel = JSONFactoryUtil.createJSONArray();
				for (Banner b : approvedBanners) {
					boolean hasPending = false;
					List<Banner> allVersions = _bannerLocalService.getByEntityResourceId(b.getEntityResourceId());
					List<BannerContent> bannerContents = _bannerContentLocalService.getByEntityResourceId(b.getEntityResourceId());
					for (BannerContent bc : bannerContents) {
						if (bc.getStatus() == WorkflowConstants.STATUS_DRAFT) {
							hasPending = true;
							break;
						}
					}
					if (!hasPending) {
						for (Banner version : allVersions) {
							if (version.getBannerId() != b.getBannerId() && version.getStatus() == WorkflowConstants.STATUS_DRAFT) {
								hasPending = true;
								break;
							}
						}
					}
					if (hasPending) {
						continue;
					}
					JSONObject bObj = JSONFactoryUtil.createJSONObject();
					bObj.put("bannerId", b.getBannerId());
					bObj.put("entityResourceId", b.getEntityResourceId());
					bObj.put("name", b.getBannerName());
					bannersForChannel.put(bObj);
				}
				approvedBannersByChannel.put(String.valueOf(ch.getChannelId()), bannersForChannel);
			}

			PortletSession pSession = actionRequest.getPortletSession();
			pSession.setAttribute("importParsedBanners", parsedBannersArray.toString());
			pSession.setAttribute("importChannels", channelsArray.toString());
			pSession.setAttribute("importApprovedPersonasByChannel", approvedPersonasByChannel.toString());
			pSession.setAttribute("importApprovedBannersByChannel", approvedBannersByChannel.toString());
			pSession.setAttribute("importResult", importResult);
		} catch (Exception e) {
			LOG.error("Error during banner import: " + e.getMessage());
			SessionErrors.add(actionRequest, "import-processing-error");
		}
	}

	public void confirmImportBanner(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
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
			for (int i = 0; i < decisionsArray.length(); i++) {
				JSONObject decision = decisionsArray.getJSONObject(i);
				String name = decision.getString("name");
				String action = decision.getString("action");
				long channelId = decision.getLong("channelId");
				long updateBannerId = decision.getLong("updateBannerId", 0);
				JSONArray personaIds = decision.getJSONArray("personaIds");

				boolean found = false;
				for (ComponentEntryDto entry : components) {
					JSONObject bannerData = entry.getData();
					String bannerName = bannerData.getString("bannerName", "");

					if (name.equals(bannerName)) {
						entry.setAction(action);
						entry.setChannelId(channelId);
						entry.setAffectedEntityId(updateBannerId);
						// Store persona IDs in the data
						if (personaIds != null) {
							bannerData.put("selectedPersonaIds", personaIds);
						}
						found = true;
						break;
					}
				}
				if (!found) {
					LOG.warn("Could not find banner with name '" + name + "' in components list, skipping.");
				}
			}
			Path path = _importRequestLocalService.buildZip(resultDTO);
			_importRequestLocalService.startImportRequestWorkflow(resultDTO, path.toString(), user, serviceContext);

		} catch (Exception e) {
			LOG.error("Error processing import decisions: " + e.getMessage(), e);
			SessionErrors.add(actionRequest, "import-processing-error");
		}
	}


	private JSONObject bannerToJson(Banner banner, List<BannerContent> bannerContents, Blocks block) {
		JSONObject bannerJson = JSONFactoryUtil.createJSONObject();

		bannerJson.put("bannerName", banner.getBannerName());
		bannerJson.put("bannerType", banner.getBannerType());
		bannerJson.put("container", banner.getContainer());

		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		if (banner.getDateFrom() != null) {
			bannerJson.put("dateFrom", dateFormat.format(banner.getDateFrom()));
		}
		if (banner.getDateTo() != null) {
			bannerJson.put("dateTo", dateFormat.format(banner.getDateTo()));
		}
		if (block != null) {
			JSONObject blockJson = JSONFactoryUtil.createJSONObject();
			blockJson.put("type", block.getType());

			blockJson.put("androidBlock", block.getAndroidBlock());
			blockJson.put("androidBlockVersion", block.getAndroidBlockVersion());
			if (block.getAndroidBlockFrom() != null) {
				blockJson.put("androidBlockFrom", dateFormat.format(block.getAndroidBlockFrom()));
			}
			if (block.getAndroidBlockTo() != null) {
				blockJson.put("androidBlockTo", dateFormat.format(block.getAndroidBlockTo()));
			}
			blockJson.put("iosBlock", block.getIosBlock());
			blockJson.put("iosBlockVersion", block.getIosBlockVersion());
			if (block.getIosBlockFrom() != null) {
				blockJson.put("iosBlockFrom", dateFormat.format(block.getIosBlockFrom()));
			}
			if (block.getIosBlockTo() != null) {
				blockJson.put("iosBlockTo", dateFormat.format(block.getIosBlockTo()));
			}
			blockJson.put("webBlock", block.getWebBlock());
			blockJson.put("webBlockVersion", block.getWebBlockVersion());
			if (block.getWebBlockFrom() != null) {
				blockJson.put("webBlockFrom", dateFormat.format(block.getWebBlockFrom()));
			}
			if (block.getWebBlockTo() != null) {
				blockJson.put("webBlockTo", dateFormat.format(block.getWebBlockTo()));
			}

			bannerJson.put("block", blockJson);
		}
		JSONArray bannerContentsArray = JSONFactoryUtil.createJSONArray();
		if (bannerContents != null && !bannerContents.isEmpty()) {
			for (BannerContent bannerContent : bannerContents) {
				JSONObject bannerContentJson = JSONFactoryUtil.createJSONObject();
				bannerContentJson.put("contentName", bannerContent.getContentName());
				bannerContentJson.put("contentOrder", bannerContent.getContentOrder());
				bannerContentJson.put("defaultLanguageId", bannerContent.getDefaultLanguageId());
				bannerContentJson.put("contentStatus", bannerContent.getContentStatus());

				JSONArray localizationsArray = JSONFactoryUtil.createJSONArray();
				List<BannerContentLocalization> localizations =
					_bannerContentLocalService.getBannerContentLocalizations(bannerContent.getContentId());

				for (BannerContentLocalization localization : localizations) {
					JSONObject localizationJson = JSONFactoryUtil.createJSONObject();
					localizationJson.put("languageId", localization.getLanguageId());
					localizationJson.put("titleValue", localization.getTitleValue());
					localizationJson.put("descriptionValue", localization.getDescriptionValue());
					localizationJson.put("bannerImage", localization.getBannerImage());
					localizationJson.put("imageOverlay", localization.getImageOverlay());
					localizationJson.put("linkType", localization.getLinkType());
					localizationJson.put("url", localization.getUrl());
					localizationsArray.put(localizationJson);
				}
				bannerContentJson.put("localizations", localizationsArray);
				bannerContentsArray.put(bannerContentJson);
			}
		}
		bannerJson.put("bannerContents", bannerContentsArray);

		return bannerJson;
	}

	@Reference
	private BannerLocalService _bannerLocalService;

	@Reference
	private LanguagesLocalService _languageLocalService;

	@Reference
	private PersonaLocalService _personaLocalService;

	@Reference
	private BannerContentLocalService _bannerContentLocalService;

	@Reference
	private BlocksLocalService _blocksLocalService;

	@Reference
	private FeatureLocalService _featureLocalService;

	@Reference
	private UserLogsLocalService _userLogsLocalService;

	@Reference
	private ImportRequestLocalService _importRequestLocalService;

	@Reference
	private ChannelsLocalService _channelsLocalService;
}
