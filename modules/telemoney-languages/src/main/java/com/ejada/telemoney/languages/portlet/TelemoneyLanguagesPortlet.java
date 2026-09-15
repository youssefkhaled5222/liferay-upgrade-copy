package com.ejada.telemoney.languages.portlet;

import com.ejada.telemoney.db.constants.IsoSupportedLocales;
import com.ejada.telemoney.db.constants.TelemoneyConstants;
import com.ejada.telemoney.languages.constants.TelemoneyLanguagesPortletKeys;
import com.ejada.telemony.db.model.Channels;
import com.ejada.telemony.db.model.Languages;
import com.ejada.telemony.db.model.LovData;
import com.ejada.telemony.db.model.Lovs;
import com.ejada.telemony.db.service.LanguagesLocalService;
import com.ejada.telemony.db.service.LocalizationLocalService;
import com.ejada.telemony.db.service.LovsLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.ejada.telemony.db.service.UserLogsLocalService;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=TelemoneyLanguages", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TelemoneyLanguagesPortletKeys.TELEMONEYLANGUAGES,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class TelemoneyLanguagesPortlet extends MVCPortlet {
	private static final Pattern XSS_PATTERN = Pattern.compile(".*[<>\"'\\\\].*");

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		String langviewUrl = "/META-INF/resources/view.jsp";
		renderRequest.setAttribute("langviewUrl", langviewUrl);
		String myview = "view";

		PortletSession pSession = renderRequest.getPortletSession();

		Long chn = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
				? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1;
		if (renderRequest.getAttribute("myview") != null && renderRequest.getAttribute("myview") != "view") {
			myview = (String) renderRequest.getAttribute("myview");
		} else {
			// Get latest approved languages with pending status
			java.util.Map<Languages, Boolean> recordsWithPending =
					_languagesLocalService.getLatestApprovedByChannelIdWithPending(chn);

			java.util.List<Languages> records = new java.util.ArrayList<>(recordsWithPending.keySet());

			renderRequest.setAttribute("records", records);
			renderRequest.setAttribute("recordsWithPending", recordsWithPending);
		}
		String view = "/" + myview + ".jsp";
		PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(view);
		dispatcher.forward(renderRequest, renderResponse);
	}

	public void addLanguagereq(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		PortletSession pSession = actionRequest.getPortletSession();
		Long chn = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
				? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1;
		List<LovData> langListfromLov = _lovsLocalService.getLatestApprovedLovDataByCode(TelemoneyConstants.LANG_CODE, chn);

		List<Languages> existingLanguages = _languagesLocalService.getLatestApprovedByChannelId(chn);

		actionRequest.setAttribute("langList", langListfromLov);
		actionRequest.setAttribute("existingLanguages", existingLanguages);

		actionRequest.setAttribute("myview", "add");
	}

	public void addLanguage(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		List<Role> roles = user.getRoles();
		boolean isAdministrator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Administrator"));
		boolean isPo = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("po"));


		if (!isAdministrator && !isPo) {
			System.out.println("you are not authorized");
			SessionErrors.add(actionRequest, "notAuthorized");
			//actionRequest.setAttribute("errorMessage", "You are not authorized to perform this action.");
			return;
		}

		String userName = themeDisplay.getUser().getFullName();

		PortletSession pSession = actionRequest.getPortletSession();
		Long chn = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
				? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1;
		String langName = ParamUtil.getString(actionRequest, "langName", "");
		System.out.println(langName);
		boolean primaryLanguage = ParamUtil.getBoolean(actionRequest, "primaryLanguage");
	    if (containsXSS(langName)) {
			SessionErrors.add(actionRequest, "xssDetected");
	        return;
	    }
		Locale locale = IsoSupportedLocales.getLocaleByLanguageName(langName);
		String userAction = TelemoneyConstants.USER_ACTION_ADD.concat(TelemoneyConstants.USER_LOGS_LANGUAGE).concat(langName);

		ServiceContext serviceContext = createServiceContextForWorkflow(actionRequest);
		_languagesLocalService.addNewLanguage(langName, locale.toString(), userName, chn,primaryLanguage,user,serviceContext);
		_userLogsLocalService.addUserData(userName, userAction,chn);

	}

	public void getLanguageUpdateId(ActionRequest actionRequest, ActionResponse actionRespons) {
		PortletSession pSession = actionRequest.getPortletSession();
		Long id = ParamUtil.getLong(actionRequest, "langId", 1);
		Languages lan;
		final String code = "001";
		Long chn = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
				? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1;
		List<String> langList = _lovsLocalService.getLatestApprovedLangNamesByCode(code, chn);
		try {
			lan = _languagesLocalService.getLanguages(id);
			actionRequest.setAttribute("channelId", lan.getChannelId());
			actionRequest.setAttribute("name", lan.getLangName());
			actionRequest.setAttribute("local", lan.getLocal());

		} catch (PortalException e) {
			e.printStackTrace();
		}

		actionRequest.setAttribute("langList", langList);
		pSession.setAttribute("langId", id);
		actionRequest.setAttribute("myview", "update");
	}

	public void getLanguageViewId(ActionRequest actionRequest, ActionResponse actionRespons) {
		PortletSession pSession = actionRequest.getPortletSession();
		Long id = ParamUtil.getLong(actionRequest, "viewedId", 1);
		Languages lan;
		try {
			lan = _languagesLocalService.getLanguages(id);
			actionRequest.setAttribute("id", id);
			actionRequest.setAttribute("channelId", lan.getChannelId());
			actionRequest.setAttribute("name", lan.getLangName());
			actionRequest.setAttribute("local", lan.getLocal());
			actionRequest.setAttribute("primaryLanguage", lan.getPrimaryLanguage());

		} catch (PortalException e) {
			e.printStackTrace();
		}
		pSession.setAttribute("langId", id);
		actionRequest.setAttribute("myview", "viewRecord");
	}

	public void getPendingLanguageViewId(ActionRequest actionRequest, ActionResponse actionResponse) {
		PortletSession pSession = actionRequest.getPortletSession();
		Long id = ParamUtil.getLong(actionRequest, "pendingLanguageId", 1);
		Languages lan;
		try {
			lan = _languagesLocalService.getLanguages(id);
			actionRequest.setAttribute("id", id);
			actionRequest.setAttribute("channelId", lan.getChannelId());
			actionRequest.setAttribute("name", lan.getLangName());
			actionRequest.setAttribute("local", lan.getLocal());
			actionRequest.setAttribute("primaryLanguage", lan.getPrimaryLanguage());
			actionRequest.setAttribute("isPending", true);

		} catch (PortalException e) {
			e.printStackTrace();
		}
		pSession.setAttribute("langId", id);
		actionRequest.setAttribute("myview", "viewRecord");
	}

	public void languageUpdate(ActionRequest actionRequest, ActionResponse actionRespons) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		List<Role> roles = user.getRoles();
		boolean isAdministrator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Administrator"));
		boolean isPo = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("po"));

		if (!isAdministrator && !isPo) {
			SessionErrors.add(actionRequest, "error");
			actionRequest.setAttribute("errorMessage", "You are not authorized to perform this action.");
			return;
		}

		PortletSession pSession = actionRequest.getPortletSession();
		Long chn = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
				? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1;

		String userName = themeDisplay.getUser().getFullName();

		Long id = pSession.getAttribute("langId") != null ? (Long) pSession.getAttribute("langId") : 1;
		String name = ParamUtil.getString(actionRequest, "langName", "");
		String local = ParamUtil.getString(actionRequest, "local", "");
		Long channelId = ParamUtil.getLong(actionRequest, "channelId", 1);
		boolean primaryLanguage = ParamUtil.getBoolean(actionRequest, "primaryLanguage");
		if (containsXSS(name) || containsXSS(local)) {
			SessionErrors.add(actionRequest, "xssDetected");
		    return;
		}

		ServiceContext serviceContext = createServiceContextForWorkflow(actionRequest);
		_languagesLocalService.languageUpdate(id, name, local, channelId, primaryLanguage, serviceContext, user);

		String userAction = TelemoneyConstants.USER_ACTION_UPDATE.concat(TelemoneyConstants.USER_LOGS_LANGUAGE)
				.concat(name);
		_userLogsLocalService.addUserData(userName, userAction, chn);
	}

	public void languageDelete(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		List<Role> roles = user.getRoles();
		boolean isAdministrator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Administrator"));
		boolean isPo = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("po"));

		if (!isAdministrator && !isPo) {
			SessionErrors.add(actionRequest, "error");
			actionRequest.setAttribute("errorMessage", "You are not authorized to perform this action.");
			return;
		}

		PortletSession pSession = actionRequest.getPortletSession();
		Long chn = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
				? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1;

		String userName = themeDisplay.getUser().getFullName();
		Long deleteId = ParamUtil.getLong(actionRequest, "deleteId", 0);
		String name = _languagesLocalService.fetchLanguages(deleteId).getLangName();

		ServiceContext serviceContext = createServiceContextForWorkflow(actionRequest);
		_languagesLocalService.languageDelete(deleteId, serviceContext, user);

		String userAction = TelemoneyConstants.USER_ACTION_DELETE.concat(TelemoneyConstants.USER_LOGS_LANGUAGE)
				.concat(name);
		_userLogsLocalService.addUserData(userName, userAction, chn);
	}

	private ServiceContext createServiceContextForWorkflow(ActionRequest actionRequest) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Channels.class.getName(), actionRequest);
		serviceContext.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH);
		return serviceContext;
	}

	private boolean containsXSS(String input) {
		return input != null && XSS_PATTERN.matcher(input).find();
	}

	@Reference
	private LanguagesLocalService _languagesLocalService;

	@Reference
	private UserLogsLocalService _userLogsLocalService;

	@Reference
	private LovsLocalService _lovsLocalService;

}