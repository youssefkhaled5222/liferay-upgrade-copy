package com.ejada.telemoney.themes.portlet;

import com.ejada.telemoney.db.constants.TelemoneyConstants;
import com.ejada.telemoney.db.dto.importDtos.ComponentEntryDto;
import com.ejada.telemoney.db.dto.importDtos.ImportResultDTO;
import com.ejada.telemoney.themes.constants.TelemoneyThemesPortletKeys;
import com.ejada.telemoney.themes.utils.FileValidatorUtil;
import com.ejada.telemony.db.constants.Constants;
import com.ejada.telemony.db.model.Persona;
import com.ejada.telemony.db.model.Themes;
import com.ejada.telemony.db.model.Channels;
import com.ejada.telemony.db.service.ChannelsLocalService;
import com.ejada.telemony.db.service.ImportRequestLocalService;
import com.ejada.telemony.db.service.ThemesLocalService;
import com.ejada.telemony.db.service.UserLogsLocalService;
import com.ejada.telemoney.db.utils.ExportFileUtil;
import com.ejada.telemoney.db.utils.ImportFileUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
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
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.File;
import java.io.IOException;
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

/**
 * @author iatef
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=TelemoneyThemes", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TelemoneyThemesPortletKeys.TELEMONEYTHEMES,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class TelemoneyThemesPortlet extends MVCPortlet {
	
	private static final Pattern XSS_PATTERN = Pattern.compile(".*[<>\"'\\\\].*");
	private static final Log LOG = LogFactoryUtil.getLog(TelemoneyThemesPortlet.class);


	private boolean containsXSS(String input) {
	    return input != null && XSS_PATTERN.matcher(input).find();
	}
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		String myview = "view";
		PortletSession pSession = renderRequest.getPortletSession();
		Long channelId = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
				? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1;
		if (renderRequest.getAttribute("myview") != null && renderRequest.getAttribute("myview").equals("add")) {
			myview = (String) renderRequest.getAttribute("myview");
		} else {
			// Get latest approved themes with pending status
			Map<Themes, Boolean> allRecordsWithPending = _themesLocalService.getLatestApprovedByChannelIdWithPending(channelId);

			// Separate default and non-default themes
			List<Themes> defaultThemes = new ArrayList<>();
			List<Themes> nonDefaultThemes = new ArrayList<>();
			Map<Themes, Boolean> defaultThemesWithPending = new LinkedHashMap<>();
			Map<Themes, Boolean> nonDefaultThemesWithPending = new LinkedHashMap<>();

			for (Map.Entry<Themes, Boolean> entry : allRecordsWithPending.entrySet()) {
				Themes theme = entry.getKey();
				Boolean isPending = entry.getValue();
				if (theme.getDefaultTheme()) {
					defaultThemes.add(theme);
					defaultThemesWithPending.put(theme, isPending);
				} else {
					nonDefaultThemes.add(theme);
					nonDefaultThemesWithPending.put(theme, isPending);
				}
			}

			renderRequest.setAttribute("nonDefaultThemes", nonDefaultThemes);
			renderRequest.setAttribute("defaultThemes", defaultThemes);
			renderRequest.setAttribute("nonDefaultThemesWithPending", nonDefaultThemesWithPending);
			renderRequest.setAttribute("defaultThemesWithPending", defaultThemesWithPending);

			boolean hasPendingImport = _importRequestLocalService.hasPendingImportRequest(Constants.THEMES);
			renderRequest.setAttribute("hasPendingImport", hasPendingImport);

			String importParsedThemes = (String) pSession.getAttribute("importParsedThemes");
			if (importParsedThemes != null) {
				renderRequest.setAttribute("importParsedThemes", importParsedThemes);
				renderRequest.setAttribute("importChannels", pSession.getAttribute("importChannels"));
				renderRequest.setAttribute("importApprovedThemesByChannel", pSession.getAttribute("importApprovedThemesByChannel"));
				pSession.removeAttribute("importParsedThemes");
				pSession.removeAttribute("importChannels");
				pSession.removeAttribute("importApprovedThemesByChannel");
			}
		}

		PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/" + myview + ".jsp");
		dispatcher.include(renderRequest, renderResponse);
	}
	
	public void viewTheme(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long themeId = ParamUtil.getLong(actionRequest, "clickedTheme");
		PortletSession pSession = actionRequest.getPortletSession();
		Long channelId = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
				? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1;
		actionRequest.setAttribute("myview", "add");
		Themes theme = null;
		try {
			theme = _themesLocalService.getThemes(themeId);
			List<Persona> checkTheme = _themesLocalService.checkTheme(channelId, themeId);
			actionRequest.setAttribute("targetTheme", theme);
			actionRequest.setAttribute("checkTheme", checkTheme);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getPendingThemeViewId(ActionRequest actionRequest, ActionResponse actionResponse) {
		long themeId = ParamUtil.getLong(actionRequest, "pendingThemeId");
		PortletSession pSession = actionRequest.getPortletSession();
		Long channelId = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
				? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1;
		actionRequest.setAttribute("myview", "add");
		try {
			Themes theme = _themesLocalService.getThemes(themeId);
			List<Persona> checkTheme = _themesLocalService.checkTheme(channelId, themeId);
			actionRequest.setAttribute("targetTheme", theme);
			actionRequest.setAttribute("checkTheme", checkTheme);
			actionRequest.setAttribute("viewOnly", true);
		} catch (PortalException e) {
			e.printStackTrace();
		}
	}

	public void editTheme(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
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
		long themeId = ParamUtil.getLong(actionRequest, "clickedTheme");
		String targetAction = ParamUtil.getString(actionRequest, "targetAction");
		PortletSession pSession = actionRequest.getPortletSession();
		Long channelId = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
				? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1;
		String userName = themeDisplay.getUser().getFullName();
		String themeName = _themesLocalService.fetchThemes(themeId).getThemeEnName();
		if (targetAction.equals("edit")) {
			actionRequest.setAttribute("myview", "add");
			Themes theme = null;
			try {
				theme = _themesLocalService.getThemes(themeId);
				List<Persona> checkTheme = _themesLocalService.checkTheme(channelId, themeId);
				actionRequest.setAttribute("targetTheme", theme);
				actionRequest.setAttribute("checkTheme", checkTheme);

				String userAction = TelemoneyConstants.USER_ACTION_UPDATE.concat(TelemoneyConstants.USER_LOGS_THEME)
						.concat(themeName);
				_userLogsLocalService.addUserData(userName, userAction, channelId);
			} catch (PortalException e) {
				e.printStackTrace();
			}
		} else if (targetAction.equals("delete")) {
			try {
				ServiceContext serviceContext = createServiceContextForWorkflow(actionRequest);
				_themesLocalService.themeDelete(themeId, serviceContext, user);
				String userAction = TelemoneyConstants.USER_ACTION_DELETE.concat(TelemoneyConstants.USER_LOGS_THEME)
						.concat(themeName);
				_userLogsLocalService.addUserData(userName, userAction, channelId);
			} catch (Exception e) {
				SessionErrors.add(actionRequest, "error");

			}
		}
	}

	public void addTheme(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
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
		long themeId = ParamUtil.getLong(actionRequest, "themeId");
		String themeEnName = ParamUtil.getString(actionRequest, "themeEnName");
		String themeArName = ParamUtil.getString(actionRequest, "themeArName");
		boolean modeConfigurable = ParamUtil.getBoolean(actionRequest, "modeConfigurable");
		boolean selectedMode = ParamUtil.getBoolean(actionRequest, "selectedMode");
		boolean defaultTheme = ParamUtil.getBoolean(actionRequest, "defaultTheme");
		boolean darkTheme = defaultTheme ? selectedMode
				: modeConfigurable ? ParamUtil.getBoolean(actionRequest, "darkTheme") : selectedMode;
		String neutralColors = getNeutralColors(actionRequest);
		String primaryColors = getPrimaryColors(actionRequest);
		String secondaryColors = getSecondaryColors(actionRequest);
		String successColors = getSuccessColors(actionRequest);
		String errorColors = getErrorColors(actionRequest);
		String warningColors = getWarningColors(actionRequest);
		String supportColors = getSupportColors(actionRequest);

		String gradientColors = getGradientColors(actionRequest);
		String splashBg = null, splashAnimation = null, headerBg = null, balanceBg = null;
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		try {
			if (uploadRequest.getFile("imageBackgroundSplash") != null &&
				uploadRequest.getFile("imageBackgroundSplash").length() > 0) {
				FileValidatorUtil.validateImageFile(uploadRequest, "imageBackgroundSplash");
				splashBg = convertImage64(uploadRequest, "imageBackgroundSplash");
			}

			if (uploadRequest.getFile("splashAnimation") != null &&
				uploadRequest.getFile("splashAnimation").length() > 0) {
				FileValidatorUtil.validateImageFile(uploadRequest, "splashAnimation");
				splashAnimation = convertImage64(uploadRequest, "splashAnimation");
			}

			if (uploadRequest.getFile("imageBackgroundHeader") != null &&
				uploadRequest.getFile("imageBackgroundHeader").length() > 0) {
				FileValidatorUtil.validateImageFile(uploadRequest, "imageBackgroundHeader");
				headerBg = convertImage64(uploadRequest, "imageBackgroundHeader");
			}

			if (uploadRequest.getFile("imageBackgroundBalance") != null &&
				uploadRequest.getFile("imageBackgroundBalance").length() > 0) {
				FileValidatorUtil.validateImageFile(uploadRequest, "imageBackgroundBalance");
				balanceBg = convertImage64(uploadRequest, "imageBackgroundBalance");
			}

		} catch (Exception e) {
			SessionErrors.add(actionRequest, "file-upload-error");
			e.printStackTrace(); 
			return;
		}
		if (themeId != 0) {
			try {
				Themes existingTheme = _themesLocalService.getThemes(themeId);
				if (splashBg == null) {
					splashBg = existingTheme.getSplashBg();
				}
				if (splashAnimation == null) {
					splashAnimation = existingTheme.getSplashAnimation();
				}
				if (headerBg == null) {
					headerBg = existingTheme.getHeaderBg();
				}
				if (balanceBg == null) {
					balanceBg = existingTheme.getBalanceBg();
				}
			} catch (PortalException e) {
				LOG.error("Error fetching existing theme for image preservation: " + e.getMessage(), e);
			}
		}
		if (containsXSS(themeEnName) || containsXSS(themeArName)) {
				SessionErrors.add(actionRequest, "xssDetected");
				return;
			}

		ServiceContext serviceContext = createServiceContextForWorkflow(actionRequest);
		String userName = themeDisplay.getUser().getFullName();

		if (themeId == 0) {
			// Create new theme
			_themesLocalService.themeCreate(channelId, themeEnName, themeArName, darkTheme, neutralColors, primaryColors,
					secondaryColors, successColors, errorColors, warningColors, supportColors, gradientColors, splashBg,
					splashAnimation, headerBg, balanceBg, defaultTheme, serviceContext, user);
			String userAction = TelemoneyConstants.USER_ACTION_ADD.concat(TelemoneyConstants.USER_LOGS_THEME)
					.concat(themeEnName);
			_userLogsLocalService.addUserData(userName, userAction, channelId);
		} else {
			// Update existing theme
			_themesLocalService.themeUpdate(themeId, channelId, themeEnName, themeArName, darkTheme, neutralColors, primaryColors,
					secondaryColors, successColors, errorColors, warningColors, supportColors, gradientColors, splashBg,
					splashAnimation, headerBg, balanceBg, defaultTheme, serviceContext, user);
			String userAction = TelemoneyConstants.USER_ACTION_UPDATE.concat(TelemoneyConstants.USER_LOGS_THEME)
					.concat(themeEnName);
			_userLogsLocalService.addUserData(userName, userAction, channelId);
		}
	}

	public String convertImage64(UploadPortletRequest uploadRequest, String name) {
		File file = uploadRequest.getFile(name);
		String imageName = uploadRequest.getFileName(name);
		if (file != null && imageName != null && !imageName.isEmpty()) {
			try {
				byte[] bytes = FileUtil.getBytes(file);
				if (bytes != null && bytes.length > 0) {
					return Base64.getEncoder().encodeToString(bytes);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public String getNeutralColors(ActionRequest actionRequest) {
		String colorOne = ParamUtil.getString(actionRequest, "colorPickerInputIdNeutral0");
		String colorTwo = ParamUtil.getString(actionRequest, "colorPickerInputIdNeutral1");
		String colorThree = ParamUtil.getString(actionRequest, "colorPickerInputIdNeutral2");
		String colorFour = ParamUtil.getString(actionRequest, "colorPickerInputIdNeutral3");
		String colorFive = ParamUtil.getString(actionRequest, "colorPickerInputIdNeutral4");
		String colorSix = ParamUtil.getString(actionRequest, "colorPickerInputIdNeutral5");
		String colorSeven = ParamUtil.getString(actionRequest, "colorPickerInputIdNeutral6");
		String colorEight = ParamUtil.getString(actionRequest, "colorPickerInputIdNeutral7");
		String colorNine = ParamUtil.getString(actionRequest, "colorPickerInputIdNeutral8");
		String colorTen = ParamUtil.getString(actionRequest, "colorPickerInputIdNeutral9");
		String colorEleven = ParamUtil.getString(actionRequest, "colorPickerInputIdNeutral10");

		JSONObject neutral = JSONFactoryUtil.createJSONObject();
		neutral.put("black", colorOne);
		neutral.put("gray1", colorTwo);
		neutral.put("gray2", colorThree);
		neutral.put("gray3", colorFour);
		neutral.put("gray4", colorFive);
		neutral.put("gray5", colorSix);
		neutral.put("gray6", colorSeven);
		neutral.put("white", colorEight);
		neutral.put("disabledGray", colorNine);
		neutral.put("cards", colorTen);
		neutral.put("Background", colorEleven);

		return neutral.toString();
	}

	public String getPrimaryColors(ActionRequest actionRequest) {
		String colorOne = ParamUtil.getString(actionRequest, "colorPickerInputIdPrimary0");
		String colorTwo = ParamUtil.getString(actionRequest, "colorPickerInputIdPrimary1");
		String colorThree = ParamUtil.getString(actionRequest, "colorPickerInputIdPrimary2");
		String colorFour = ParamUtil.getString(actionRequest, "colorPickerInputIdPrimary3");
		String colorFive = ParamUtil.getString(actionRequest, "colorPickerInputIdPrimary4");
		String colorSix = ParamUtil.getString(actionRequest, "colorPickerInputIdPrimary5");
		JSONObject primary = JSONFactoryUtil.createJSONObject();
		primary.put("bg", colorOne);
		primary.put("light", colorTwo);
		primary.put("dark", colorThree);
		primary.put("default", colorFour);
		primary.put("disabled", colorFive);
		primary.put("icon", colorSix);
		return primary.toString();
	}

	public String getSecondaryColors(ActionRequest actionRequest) {
		String colorOne = ParamUtil.getString(actionRequest, "colorPickerInputIdSecondary0");
		String colorTwo = ParamUtil.getString(actionRequest, "colorPickerInputIdSecondary1");
		String colorThree = ParamUtil.getString(actionRequest, "colorPickerInputIdSecondary2");
		String colorFour = ParamUtil.getString(actionRequest, "colorPickerInputIdSecondary3");
		String colorFive = ParamUtil.getString(actionRequest, "colorPickerInputIdSecondary4");
		String colorSix = ParamUtil.getString(actionRequest, "colorPickerInputIdSecondary5");

		JSONObject secondaryColors = JSONFactoryUtil.createJSONObject();
		secondaryColors.put("bg", colorOne);
		secondaryColors.put("light", colorTwo);
		secondaryColors.put("dark", colorThree);
		secondaryColors.put("default", colorFour);
		secondaryColors.put("disabled", colorFive);
		secondaryColors.put("extra", colorSix);

		return secondaryColors.toString();
	}

	public String getSuccessColors(ActionRequest actionRequest) {
		String colorOne = ParamUtil.getString(actionRequest, "colorPickerInputIdSuccess0");
		String colorTwo = ParamUtil.getString(actionRequest, "colorPickerInputIdSuccess1");
		String colorThree = ParamUtil.getString(actionRequest, "colorPickerInputIdSuccess2");
		String colorFour = ParamUtil.getString(actionRequest, "colorPickerInputIdSuccess3");
		String colorFive = ParamUtil.getString(actionRequest, "colorPickerInputIdSuccess4");

		JSONObject successColors = JSONFactoryUtil.createJSONObject();
		successColors.put("bg", colorOne);
		successColors.put("light", colorTwo);
		successColors.put("dark", colorThree);
		successColors.put("default", colorFour);
		successColors.put("success", colorFive);

		return successColors.toString();
	}

	public String getErrorColors(ActionRequest actionRequest) {
		String colorOne = ParamUtil.getString(actionRequest, "colorPickerInputIdError0");
		String colorTwo = ParamUtil.getString(actionRequest, "colorPickerInputIdError1");
		String colorThree = ParamUtil.getString(actionRequest, "colorPickerInputIdError2");
		String colorFour = ParamUtil.getString(actionRequest, "colorPickerInputIdError3");

		JSONObject errorColors = JSONFactoryUtil.createJSONObject();
		errorColors.put("bg", colorOne);
		errorColors.put("light", colorTwo);
		errorColors.put("dark", colorThree);
		errorColors.put("default", colorFour);

		return errorColors.toString();
	}

	public String getWarningColors(ActionRequest actionRequest) {
		String colorOne = ParamUtil.getString(actionRequest, "colorPickerInputIdWarning0");
		String colorTwo = ParamUtil.getString(actionRequest, "colorPickerInputIdWarning1");
		String colorThree = ParamUtil.getString(actionRequest, "colorPickerInputIdWarning2");
		String colorFour = ParamUtil.getString(actionRequest, "colorPickerInputIdWarning3");

		JSONObject warningColors = JSONFactoryUtil.createJSONObject();
		warningColors.put("bg", colorOne);
		warningColors.put("light", colorTwo);
		warningColors.put("dark", colorThree);
		warningColors.put("default", colorFour);

		return warningColors.toString();
	}

	public String getSupportColors(ActionRequest actionRequest) {
		String colorOne = ParamUtil.getString(actionRequest, "colorPickerInputIdSupport0");
		String colorTwo = ParamUtil.getString(actionRequest, "colorPickerInputIdSupport1");
		String colorThree = ParamUtil.getString(actionRequest, "colorPickerInputIdSupport2");
		String colorFour = ParamUtil.getString(actionRequest, "colorPickerInputIdSupport3");
		String colorFive = ParamUtil.getString(actionRequest, "colorPickerInputIdSupport4");
		String colorSix = ParamUtil.getString(actionRequest, "colorPickerInputIdSupport5");
		String colorSeven = ParamUtil.getString(actionRequest, "colorPickerInputIdSupport6");
		String colorEight = ParamUtil.getString(actionRequest, "colorPickerInputIdSupport7");
		JSONObject support = JSONFactoryUtil.createJSONObject();
		support.put("defaultYellow", colorOne);
		support.put("bgYellow", colorTwo);
		support.put("lightBlue", colorThree);
		support.put("cardDefault", colorFour);
		support.put("cardDarkBlue", colorFive);
		support.put("cardExtra", colorSix);
		support.put("extra", colorSeven);
		support.put("logo", colorEight);
		return support.toString();
	}

	public String getGradientColors(ActionRequest actionRequest) {
		String colorOne = ParamUtil.getString(actionRequest, "colorPickerFirstInputIdGrad0");
		String colorTwo = ParamUtil.getString(actionRequest, "colorPickerSecondInputIdGrad0");
		String colorThree = ParamUtil.getString(actionRequest, "colorPickerThirdInputIdGrad0");
		String colorFour = ParamUtil.getString(actionRequest, "colorPickerFourthInputIdGrad0");
		String colorFive = ParamUtil.getString(actionRequest, "colorPickerFifthInputIdGrad0");


		JSONObject primaryGd = JSONFactoryUtil.createJSONObject();
		JSONObject gradient = JSONFactoryUtil.createJSONObject();

		primaryGd.put("primary1", colorOne);
		primaryGd.put("primary2", colorTwo);
		primaryGd.put("dashboardColorOne",colorThree);
		primaryGd.put("dashboardColorTwo",colorFour);
		primaryGd.put("dashboardColorThree",colorFive);

		gradient.put("primary", primaryGd);

		return gradient.toString();
	}
	public void exportTheme(ActionRequest actionRequest, ActionResponse actionResponse)
	{
		long[] themeIds = ParamUtil.getLongValues(actionRequest, "themeIds");
		String summary = ParamUtil.getString(actionRequest, "exportSummary", "Theme Export");

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

		for (long themeId : themeIds) {
			try {
				Themes theme = _themesLocalService.getThemes(themeId);
				if (_themesLocalService.hasPendingDraft(theme.getEntityResourceId())) {
					LOG.warn("Skipping export of theme ID " + themeId + " because it has a pending draft");
					continue;
				}
				JSONObject obj = themeToJson(theme);
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
			ExportFileUtil.downloadZip(summary, exportData, user, Constants.THEMES, actionRequest, actionResponse);
		} catch (IllegalStateException e) {
			SessionErrors.add(actionRequest, "zipSizeExceeded");
		}
	}

	public void importTheme(ActionRequest actionRequest, ActionResponse actionResponse)
	{
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

		try{
		ImportResultDTO importResult = ImportFileUtil.parseZip(actionRequest,Constants.THEMES);
        List<ComponentEntryDto> components = importResult.getComponents();
        JSONArray parsedThemesArray = JSONFactoryUtil.createJSONArray();
        for (int i = 0; i < components.size(); i++) {
            ComponentEntryDto comp = components.get(i);
			JSONObject themeEntry = JSONFactoryUtil.createJSONObject();
            themeEntry.put("index", i);
            String themeName = "";
            boolean isDarkTheme = false;
            if (comp.getData() != null && comp.getData().has("themeEnName")) {
                themeName = comp.getData().getString("themeEnName");
            }
            if (comp.getData() != null && comp.getData().has("darkTheme")) {
                isDarkTheme = comp.getData().getBoolean("darkTheme");
            }
            themeEntry.put("name", themeName);
            themeEntry.put("isDarkTheme", isDarkTheme);
            parsedThemesArray.put(themeEntry);
        }

        List<Channels> approvedChannels = _channelsLocalService.findByStatus(WorkflowConstants.STATUS_APPROVED);
        JSONArray channelsArray = JSONFactoryUtil.createJSONArray();
        for (Channels ch : approvedChannels) {
			JSONObject chObj = JSONFactoryUtil.createJSONObject();
            chObj.put("channelId", ch.getChannelId());
            chObj.put("name", ch.getName());
            channelsArray.put(chObj);
        }
        JSONObject approvedThemesByChannel = JSONFactoryUtil.createJSONObject();
        for (Channels ch : approvedChannels) {
            List<Themes> latestApproved = _themesLocalService.getLatestApprovedWithoutPendingByChannelId(ch.getChannelId());
            JSONArray themesForChannel = JSONFactoryUtil.createJSONArray();
            for (Themes t : latestApproved) {
                JSONObject tObj = JSONFactoryUtil.createJSONObject();
                tObj.put("themeId", t.getThemeId());
                tObj.put("entityResourceId", t.getEntityResourceId());
                tObj.put("name", t.getThemeEnName());
                tObj.put("isDarkTheme", t.getDarkTheme());
                themesForChannel.put(tObj);
            }
            approvedThemesByChannel.put(String.valueOf(ch.getChannelId()), themesForChannel);
        }
        PortletSession pSession = actionRequest.getPortletSession();
        pSession.setAttribute("importParsedThemes", parsedThemesArray.toString());
        pSession.setAttribute("importChannels", channelsArray.toString());
        pSession.setAttribute("importApprovedThemesByChannel", approvedThemesByChannel.toString());
        pSession.setAttribute("importResult", importResult);
		}
		catch (Exception e) {
			LOG.error("Error during import: " + e.getMessage());
			SessionErrors.add(actionRequest, "import-processing-error");
		}


    }

	public void confirmImportTheme(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		String importDecisionsJson = ParamUtil.getString(actionRequest, "importDecisions");
		PortletSession pSession = actionRequest.getPortletSession();
		if (importDecisionsJson == null || importDecisionsJson.isEmpty()) {
			LOG.error("No import decisions received");
			SessionErrors.add(actionRequest, "no-import-decisions");
			return;
		}
		ServiceContext serviceContext =createServiceContextForWorkflow(actionRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		ImportResultDTO resultDTO = (ImportResultDTO) pSession.getAttribute("importResult");
		try {
			JSONArray decisionsArray =JSONFactoryUtil.createJSONArray(importDecisionsJson);
			List<ComponentEntryDto> components = resultDTO.getComponents();
			for (int i = 0; i < decisionsArray.length(); i++) {
				JSONObject decision = decisionsArray.getJSONObject(i);
				String name = decision.getString("name");
				String action = decision.getString("action");
				long channelId = decision.getLong("channelId");
				long updateThemeId = decision.getLong("updateThemeId", 0);
				boolean found = false;
				for (ComponentEntryDto entry : components) {
					JSONObject themeData = entry.getData();
					String themeEnName = themeData.getString("themeEnName", "");

					if (name.equals(themeEnName)) {
						if ("update".equals(action) && updateThemeId > 0) {
							boolean importedIsDark = themeData.getBoolean("darkTheme", false);
							Themes existingTheme = _themesLocalService.getThemes(updateThemeId);
							if (existingTheme.getDarkTheme() != importedIsDark) {
								String modeLabel = importedIsDark ? "dark" : "light";
								LOG.error("Theme mode mismatch: imported theme '" + name + "' is " + modeLabel
										+ " but target theme ID " + updateThemeId + " is " + (importedIsDark ? "light" : "dark"));
								SessionErrors.add(actionRequest, "import-theme-mode-mismatch");
								return;
							}
						}
						entry.setAction(action);
						entry.setChannelId(channelId);
						entry.setAffectedEntityId(updateThemeId);
						found = true;
						break;
					}
				}
				if (!found) {
					LOG.warn("Could not find theme with name '" + name + "' in components list, skipping.");
				}
			}
			Path path = _importRequestLocalService.buildZip(resultDTO);
			_importRequestLocalService.startImportRequestWorkflow(resultDTO, path.toString(),user,serviceContext);

		} catch (Exception e) {
			LOG.error("Error processing import decisions: " + e.getMessage(), e);
			SessionErrors.add(actionRequest, "import-processing-error");
		}
	}


	private ServiceContext createServiceContextForWorkflow(ActionRequest actionRequest) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Themes.class.getName(), actionRequest);
		serviceContext.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH);
		return serviceContext;
	}
	public JSONObject themeToJson(Themes theme) throws JSONException {
	JSONObject obj = JSONFactoryUtil.createJSONObject();
		obj.put("themeEnName", theme.getThemeEnName());
		obj.put("themeArName", theme.getThemeArName());
		obj.put("darkTheme", theme.getDarkTheme());
		obj.put("primaryColors",JSONFactoryUtil.createJSONObject(theme.getPrimaryColors()));
		obj.put("secondaryColors",JSONFactoryUtil.createJSONObject(theme.getSecondaryColors()));
		obj.put("neutralColors", JSONFactoryUtil.createJSONObject(theme.getNeutralColors()));
		obj.put("successColors",JSONFactoryUtil.createJSONObject(theme.getSuccessColors()));
		obj.put("errorColors", JSONFactoryUtil.createJSONObject(theme.getErrorColors()));
		obj.put("warningColors", JSONFactoryUtil.createJSONObject(theme.getWarningColors()));
		obj.put("supportColors", JSONFactoryUtil.createJSONObject(theme.getSupportColors()));
		obj.put("gradientColors", JSONFactoryUtil.createJSONObject(theme.getGradientColors()));
		obj.put("splashBg", theme.getSplashBg());
		obj.put("splashAnimation", theme.getSplashAnimation());
		obj.put("headerBg", theme.getHeaderBg());
		obj.put("balanceBg", theme.getBalanceBg());
		obj.put("defaultTheme", theme.getDefaultTheme());
		return obj;
	}



	@Reference
	private ThemesLocalService _themesLocalService;

	@Reference
	private UserLogsLocalService _userLogsLocalService;

	@Reference
	private ImportRequestLocalService _importRequestLocalService;

	@Reference
	private ChannelsLocalService _channelsLocalService;
}
