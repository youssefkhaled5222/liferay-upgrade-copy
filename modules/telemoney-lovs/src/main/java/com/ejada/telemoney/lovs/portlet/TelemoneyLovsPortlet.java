package com.ejada.telemoney.lovs.portlet;

import com.ejada.telemoney.db.constants.IsoSupportedLocales;
import com.ejada.telemoney.db.constants.TelemoneyConstants;
import com.ejada.telemoney.lovs.constants.TelemoneyLovsPortletKeys;
import com.ejada.telemony.db.exception.NoSuchLovDataException;
import com.ejada.telemony.db.model.Channels;
import com.ejada.telemony.db.model.Languages;
import com.ejada.telemony.db.model.LovData;
import com.ejada.telemony.db.model.Lovs;
import com.ejada.telemony.db.service.ChannelsLocalService;
import com.ejada.telemony.db.service.FeatureLocalService;
import com.ejada.telemony.db.service.LanguagesLocalService;
import com.ejada.telemony.db.service.LovDataLocalService;
import com.ejada.telemony.db.service.LovsLocalService;
import com.ejada.telemony.db.service.UserLogsLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.Language;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.IOException;
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
import javax.ws.rs.NotFoundException;

import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.UnicodeProperties;

/**
 * @author rmostafa
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=TelemoneyLovs", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TelemoneyLovsPortletKeys.TELEMONEYLOVS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class TelemoneyLovsPortlet extends MVCPortlet {
	private static final Pattern XSS_PATTERN = Pattern.compile(".*[<>\"'\\\\].*");

	private boolean containsXSS(String input) {
		return input != null && XSS_PATTERN.matcher(input).find();
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		String langviewUrl = "/META-INF/resources/view.jsp";
		renderRequest.setAttribute("langviewUrl", langviewUrl);

		String languageName = "English"; // Replace with the desired language name
		Language language = LanguageUtil.getLanguage();
		Locale locale = language.getLocale(languageName);

		PortletSession pSession = renderRequest.getPortletSession();
		Long chn = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
				? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1;
		List<LovData> data = pSession.getAttribute("LIFERAY_SHARED_SearchData",
				PortletSession.APPLICATION_SCOPE) != null
						? (List<LovData>) pSession.getAttribute("LIFERAY_SHARED_SearchData",
								PortletSession.APPLICATION_SCOPE)
						: new ArrayList<LovData>();
		int delta = ParamUtil.getInteger(renderRequest, "delta");
		int cur = ParamUtil.getInteger(renderRequest, "cur");
		String myview = "view";
		Long parentId = (Long) pSession.getAttribute("LIFERAY_SHARED_TypeId", PortletSession.APPLICATION_SCOPE);


		String hasPendingVersionParam = renderRequest.getParameter("hasPendingVersion");
		if (hasPendingVersionParam != null) {
			renderRequest.setAttribute("hasPendingVersion", Boolean.parseBoolean(hasPendingVersionParam));
		}



		Set<Long> allEntityResourceIds = new HashSet<>();

		if (renderRequest.getAttribute("myview") != null && !renderRequest.getAttribute("myview").equals("view")) {
			myview = (String) renderRequest.getAttribute("myview");


			if (myview.equals("viewLovData")) {
				List<LovData> lovdata;

				lovdata = _lovDataLocalService.getByEntityResourceIdAndStatusApproved(parentId);
				renderRequest.setAttribute("lovdata", lovdata);

				boolean hasPendingVersion = checkHasPendingVersionForLov(parentId);
				renderRequest.setAttribute("hasPendingVersion", hasPendingVersion);

				Set<Long> lovDataWithPendingVersions = getDraftLovDataEntityResourceIds(allEntityResourceIds);
				renderRequest.setAttribute("lovDataWithPendingVersions", lovDataWithPendingVersions);

			} else {
				List<Languages> languages = _languageLocalService.getbyChannelId(chn);
				List<String> languagesName = new ArrayList<>();
				for (Languages langName : languages) {
					languagesName.add(langName.getLangName());
				}
				renderRequest.setAttribute("languagesNames", languagesName);
			}
		} else if (cur >= 1 || delta > 10) {
			myview = "viewLovData";
			parentId = (Long) pSession.getAttribute("LIFERAY_SHARED_TypeId", PortletSession.APPLICATION_SCOPE);
			List<LovData> lovdata;

			lovdata = _lovDataLocalService.getByEntityResourceIdAndStatusApproved(parentId);

			renderRequest.setAttribute("lovdata", lovdata);
			renderRequest.setAttribute("data", data);
			renderRequest.setAttribute("parentId", parentId);

			boolean hasPendingVersion = checkHasPendingVersionForLov(parentId);
			renderRequest.setAttribute("hasPendingVersion", hasPendingVersion);

			Set<Long> lovDataWithPendingVersions = getDraftLovDataEntityResourceIds(allEntityResourceIds);
			renderRequest.setAttribute("lovDataWithPendingVersions", lovDataWithPendingVersions);
		} else {
			pSession.setAttribute("LIFERAY_SHARED_SearchData", null, PortletSession.APPLICATION_SCOPE);

			List<Lovs> records = _lovsLocalService.getLatestApprovedByChannelId(chn);
			for (Lovs record : records) {
				record.setCount(_lovsLocalService.getLovDataCountByLovId(record.getId()));
			}
			renderRequest.setAttribute("records", records);

			// Get set of LOVs with pending versions
			Set<Long> lovsWithPendingVersions = getLovsWithPendingVersions(chn);
			renderRequest.setAttribute("lovsWithPendingVersions", lovsWithPendingVersions);
		}

		String view = "/" + myview + ".jsp";
		PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(view);
		dispatcher.include(renderRequest, renderResponse);
	}

	/**
	 * Check if a LOV or any of its LOV Data has a pending version.
	 * LovData is linked to Lov by entityResourceId, NOT by lovId.
	 * A draft Lov or draft LovData sharing the same entityResourceId means pending.
	 */
	private boolean checkHasPendingVersionForLov(Long lovId) {
		try {
			Lovs lov = _lovsLocalService.getLovs(lovId);
			long entityResourceId = lov.getEntityResourceId();

			// Check if any other LOV version with same entityResourceId is DRAFT
			DynamicQuery lovQuery = _lovsLocalService.dynamicQuery();
			lovQuery.add(RestrictionsFactoryUtil.eq("entityResourceId", entityResourceId));
			lovQuery.add(RestrictionsFactoryUtil.ne("id", lovId));
			lovQuery.add(RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_DRAFT));
			long draftLovCount = _lovsLocalService.dynamicQueryCount(lovQuery);
			if (draftLovCount > 0) {
				return true;
			}

			// Check if any LovData with same entityResourceId is DRAFT
			DynamicQuery lovDataQuery = _lovDataLocalService.dynamicQuery();
			lovDataQuery.add(RestrictionsFactoryUtil.eq("entityResourceId", entityResourceId));
			lovDataQuery.add(RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_DRAFT));
			long draftLovDataCount = _lovDataLocalService.dynamicQueryCount(lovDataQuery);
			if (draftLovDataCount > 0) {
				return true;
			}
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Get all LOVs with pending versions for a channel.
	 * Checks both LOV status and LOV Data status.
	 *
	 * LovData is linked to Lov by entityResourceId (LovData.entityResourceId == Lov.entityResourceId),
	 * NOT by lovId. A pending LovData is one with status=DRAFT sharing the same Lov entityResourceId.
	 *
	 * Optimized: uses only 2 dynamic queries total instead of N+1 per-LOV queries.
	 */
	private Set<Long> getLovsWithPendingVersions(Long channelId) {
		Set<Long> lovsWithPending = new HashSet<>();

		List<Lovs> approvedLovs = _lovsLocalService.getLatestApprovedByChannelId(channelId);
		if (approvedLovs.isEmpty()) {
			return lovsWithPending;
		}

		// Build a map from entityResourceId -> approved Lov ID
		Map<Long, Long> entityResourceIdToLovId = new LinkedHashMap<>();
		Set<Long> allEntityResourceIds = new HashSet<>();
		for (Lovs lov : approvedLovs) {
			entityResourceIdToLovId.put(lov.getEntityResourceId(), lov.getId());
			allEntityResourceIds.add(lov.getEntityResourceId());
		}

		// Query 1: Find entityResourceIds that have a draft Lov version
		Set<Long> entityResIdsWithDraftLov = getDraftLovsEntityResourceIds(allEntityResourceIds);
		for (Long entityResId : entityResIdsWithDraftLov) {
			Long lovId = entityResourceIdToLovId.get(entityResId);
			if (lovId != null) {
				lovsWithPending.add(lovId);
			}
		}

		// Query 2: Find entityResourceIds that have draft LovData
		Set<Long> entityResIdsToCheckData = new HashSet<>(allEntityResourceIds);
		entityResIdsToCheckData.removeAll(entityResIdsWithDraftLov); // skip already-flagged LOVs

		if (!entityResIdsToCheckData.isEmpty()) {
			Set<Long> entityResIdsWithDraftLovData = getDraftLovDataEntityResourceIds(entityResIdsToCheckData);
			for (Long entityResId : entityResIdsWithDraftLovData) {
				Long lovId = entityResourceIdToLovId.get(entityResId);
				if (lovId != null) {
					lovsWithPending.add(lovId);
				}
			}
		}

		return lovsWithPending;
	}

	/**
	 * Find Lov entityResourceIds that have at least one draft Lov version.
	 */
	private Set<Long> getDraftLovsEntityResourceIds(Set<Long> entityResourceIds) {
		try {
			DynamicQuery query = _lovsLocalService.dynamicQuery();
			query.add(RestrictionsFactoryUtil.in("entityResourceId", new ArrayList<>(entityResourceIds)));
			query.add(RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_DRAFT));
			query.setProjection(ProjectionFactoryUtil.distinct(
					ProjectionFactoryUtil.property("entityResourceId")));

			List<Long> result = _lovsLocalService.dynamicQuery(query);
			return new HashSet<>(result);
		} catch (Exception e) {
			return Collections.emptySet();
		}
	}

	/**
	 * Find entityResourceIds that have at least one draft LovData.
	 * Since LovData.entityResourceId == Lov.entityResourceId, we query LovData
	 * where entityResourceId is in the set AND status is DRAFT.
	 */
	private Set<Long> getDraftLovDataEntityResourceIds(Set<Long> entityResourceIds) {
		try {
			DynamicQuery query = _lovDataLocalService.dynamicQuery();
			query.add(RestrictionsFactoryUtil.in("entityResourceId", new ArrayList<>(entityResourceIds)));
			query.add(RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_DRAFT));
			query.setProjection(ProjectionFactoryUtil.distinct(
					ProjectionFactoryUtil.property("entityResourceId")));

			List<Long> result = _lovDataLocalService.dynamicQuery(query);
			return new HashSet<>(result);
		} catch (Exception e) {
			return Collections.emptySet();
		}
	}

	// -----------------------------------------------------------------------------------------------------\\
	// -----------------------------------------------------------------------------------------------------\\
	public void addType(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.setAttribute("myview", "add");
	}

	public void lovListCreate(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
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
			List<Languages> languages = _languageLocalService.getbyChannelId(chn);
			List<String> languagesName = new ArrayList<>();
			for (Languages langName : languages) {
				languagesName.add(langName.getLangName());
			}

			Map<String, String> nameValues = new HashMap<>();
			String enNameValue = ParamUtil.getString(actionRequest, "EnglishnameValue", "");
			String code = ParamUtil.getString(actionRequest, "code", "");

			String eventCode = ParamUtil.getString(actionRequest, "eventCode", "");
			if (containsXSS(enNameValue) || containsXSS(code) || containsXSS(eventCode)) {
				SessionErrors.add(actionRequest, "xssDetected");
				actionRequest.setAttribute("myview", "add");
				return;
			}
			for (String langName : languagesName) {
				String nameValue = ParamUtil.getString(actionRequest, langName + "nameValue", "");
				if (containsXSS(nameValue)) {
					SessionErrors.add(actionRequest, "xssDetected");
					actionRequest.setAttribute("myview", "add");
					return;
				}

				if (nameValue.isEmpty() && !enNameValue.isEmpty())
					nameValues.put(langName, enNameValue);
				else
					nameValues.put(langName, nameValue);
			}
			List<Lovs> result = _lovsLocalService.getLovsByTypeCodeAndStatus(code, chn,0);
			if (result != null && result.size() > 0)
				throw new Exception("The type code " + code + " already exists.");
			ServiceContext serviceContext =createServiceContextForWorkflow(actionRequest);
			_lovsLocalService.lovListCreate(nameValues, code, eventCode, chn,user,serviceContext);
			String userAction = TelemoneyConstants.USER_ACTION_ADD.concat(TelemoneyConstants.USER_LOGS_LISTOFVALUE)
					.concat(enNameValue);
			_userLogsLocalService.addUserData(userName, userAction, chn);
		} catch (Exception e) {
			actionRequest.setAttribute("errorMsg", e.getMessage());
			SessionErrors.add(actionRequest, "error");
			actionRequest.setAttribute("myview", "add");
		}

	}

	public void getLovsUpdateId(ActionRequest actionRequest, ActionResponse actionResponse) {
		PortletSession pSession = actionRequest.getPortletSession();
		Long id = ParamUtil.getLong(actionRequest, "lovsId", 1);

		// Read hasPendingVersion from JSP param (already calculated in view.jsp via lovsWithPendingVersions)
		boolean hasPendingVersion = ParamUtil.getBoolean(actionRequest, "hasPendingVersion", false);

		Lovs lovs;

		Long chn = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
				? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1;
		List<Languages> languages = _languageLocalService.getbyChannelId(chn);
		List<String> languagesName = new ArrayList<>();
		for (Languages langName : languages) {
			languagesName.add(langName.getLangName());
		}

		Map<String, String> nameValues = new HashMap<>();

		try {
			lovs = _lovsLocalService.getLovs(id);
			actionRequest.setAttribute("channelId", lovs.getChannelId());
			actionRequest.setAttribute("code", lovs.getCode());
			actionRequest.setAttribute("eventCode", lovs.getEventCode());

			for (String langName : languagesName) {
				nameValues.put(langName, lovs.getName(langName));

			}
			actionRequest.setAttribute("Names", nameValues);

		} catch (PortalException e) {
			e.printStackTrace();
		}
		pSession.setAttribute("lovsId", id);
		pSession.removeAttribute("hasPendingVersion");
		actionRequest.setAttribute("hasPendingVersion", hasPendingVersion);
		actionRequest.setAttribute("myview", "updateType");

	}

	public void lovListUpdate(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
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
		List<Languages> languages = _languageLocalService.getbyChannelId(chn);

		List<String> languagesName = new ArrayList<>();
		for (Languages langName : languages) {
			languagesName.add(langName.getLangName());
		}

		Long id = pSession.getAttribute("lovsId") != null ? (Long) pSession.getAttribute("lovsId") : 1;


		if (checkHasPendingVersionForLov(id)) {
			SessionErrors.add(actionRequest, "hasPendingVersion");
			return;
		}

		String code = ParamUtil.getString(actionRequest, "code", "");
		String eventCode = ParamUtil.getString(actionRequest, "eventCode", "");
		Long channelId = ParamUtil.getLong(actionRequest, "channelId", 1);

		// Validate that the type code has not been changed
		Lovs existingLov = _lovsLocalService.getLovs(id);
		if (!existingLov.getCode().equals(code)) {
			SessionErrors.add(actionRequest, "codeChanged");
			return;
		}

		String enNameValue = ParamUtil.getString(actionRequest, "EnglishnameValue", "");
		if (containsXSS(code) || containsXSS(eventCode) || containsXSS(enNameValue)) {
			SessionErrors.add(actionRequest, "xssDetected");
			return;
		}

		Map<String, String> nameValues = new HashMap<>();
		for (String langName : languagesName) {
			String nameValue = ParamUtil.getString(actionRequest, langName + "nameValue", "");
			if (containsXSS(nameValue)) {
				SessionErrors.add(actionRequest, "xssDetected");
				return;
			}
			if (nameValue.equals("") && !enNameValue.equals(""))
				nameValues.put(langName, enNameValue);
			else
				nameValues.put(langName, nameValue);
		}

		ServiceContext serviceContext =createServiceContextForWorkflow(actionRequest);
		_lovsLocalService.updateLovWorkflow(id, nameValues, code, channelId, eventCode, user,serviceContext);
		String userAction = TelemoneyConstants.USER_ACTION_UPDATE.concat(TelemoneyConstants.USER_LOGS_LISTOFVALUE)
				.concat(enNameValue);
		_userLogsLocalService.addUserData(userName, userAction, chn);

	}

	public void lovListDelete(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
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

		Long deleteId = ParamUtil.getLong(actionRequest, "deleteId", 0);
		Lovs deletedLov = _lovsLocalService.fetchLovs(deleteId);
		if (deletedLov!=null){

		if (checkHasPendingVersionForLov(deleteId)) {
			SessionErrors.add(actionRequest, "hasPendingVersion");
			return;
		}
		String lovName = deletedLov.getName();
		String userAction = TelemoneyConstants.USER_ACTION_DELETE.concat(TelemoneyConstants.USER_LOGS_LISTOFVALUE)
				.concat(lovName);
		_userLogsLocalService.addUserData(userName, userAction, chn);

		ServiceContext serviceContext = createServiceContextForWorkflow(actionRequest);
		_lovsLocalService.deleteLovWorkflow(deleteId,user,serviceContext);
		}
	}

	public void searchByName(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		PortletSession pSession = actionRequest.getPortletSession();
		Long chn = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
				? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1;
		List<Lovs> types = new ArrayList<>();
		String searchName = ParamUtil.getString(actionRequest, "searchName");
		String searchType = ParamUtil.getString(actionRequest, "searchType");

		types = searchType.equals("code") ? _lovsLocalService.searchByCode(searchName, chn)
				: _lovsLocalService.searchLovLocalizationByName(searchName, chn);

		if (types != null && !types.isEmpty()) {
			for (Lovs record : types) {
				record.setCount(_lovsLocalService.getLovDataCountByLovId(record.getId()));
			}
		}
		actionRequest.setAttribute("types", types);

	}

	// --------------------------------------------------------------------------------------------------\\

	public void viewData(ActionRequest actionRequest, ActionResponse actionResponse) {
		PortletSession pSession = actionRequest.getPortletSession();
		Long parentId = ParamUtil.getLong(actionRequest, "parentId");

		// Always calculate hasPendingVersion from database (like Banner does)
		boolean hasPendingVersion = checkHasPendingVersionForLov(parentId);

		String lovType = "";
		try {
			lovType = _lovsLocalService.getLovs(parentId).getName("English");

		} catch (PortalException e) {
			System.out.println("no name");
		}
		List<LovData> lovdata;

		lovdata = _lovDataLocalService.getByEntityResourceIdAndStatusApproved(parentId);

		actionRequest.setAttribute("lovdata", lovdata);
		actionRequest.setAttribute("parentId", parentId);
		actionRequest.setAttribute("hasPendingVersion", hasPendingVersion);

		actionRequest.setAttribute("lovType", lovType);

		pSession.setAttribute("lovType", lovType);
		pSession.setAttribute("parentId", parentId);
		// Don't store hasPendingVersion in session - always calculate fresh
		pSession.removeAttribute("hasPendingVersion");

		pSession.setAttribute("LIFERAY_SHARED_TypeId", parentId, PortletSession.APPLICATION_SCOPE);
		pSession.setAttribute("LIFERAY_SHARED_Lovtype", lovType, PortletSession.APPLICATION_SCOPE);

		actionRequest.setAttribute("myview", "viewLovData");
	}

	public void newLovDataForm(ActionRequest actionRequest, ActionResponse actionResponse) {
		PortletSession pSession = actionRequest.getPortletSession();

		Long chn = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
				? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1;
		List<String> currentLanguageForLov = _lovsLocalService.getLangTypeCodeByLOVCode("001", chn);
		Long lovId = ParamUtil.getLong(actionRequest, "lovId", 1);
		List<String> localeLanguageNames = IsoSupportedLocales.getAllLanguageNames();
		localeLanguageNames.removeAll(currentLanguageForLov);
		System.out.println(localeLanguageNames);
		String lovType = "";
		String lovCode = "";
		try {
			lovType = (_lovsLocalService.getLovs(lovId))
					.getName((_languageLocalService.getLanguageses(0, 1)).get(0).getLangName()) != ""
							? (_lovsLocalService.getLovs(lovId))
									.getName((_languageLocalService.getLanguageses(0, 1)).get(0).getLangName())
							: _lovsLocalService.getLovs(lovId).getName("en");
			lovCode = _lovsLocalService.getLovs(lovId).getCode();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		actionRequest.setAttribute("lovId", lovId);
		actionRequest.setAttribute("lovCode", lovCode);

		actionRequest.setAttribute("lovType", lovType);
		actionRequest.setAttribute("localeLanguageNames", localeLanguageNames);

		/*
		 * pSession.setAttribute("lovId", lovId); pSession.setAttribute("lovType",
		 * lovType);
		 */
		pSession.setAttribute("LIFERAY_SHARED_TypeId", lovId, PortletSession.APPLICATION_SCOPE);
		pSession.setAttribute("LIFERAY_SHARED_Lovtype", lovType, PortletSession.APPLICATION_SCOPE);

		actionRequest.setAttribute("myview", "addLovData");
	}

	public void lovDataCreate(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
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
		List<String> currentLanguageForLov = _lovsLocalService.getLangTypeCodeByLOVCode("001", chn);
		List<Languages> languages = _languageLocalService.getbyChannelId(chn);
		List<String> languagesName = new ArrayList<>();
		for (Languages langName : languages) {
			languagesName.add(langName.getLangName());
		}

		Long lovId = (Long) pSession.getAttribute("parentId");
		String lovType = (String) pSession.getAttribute("lovType");
		String recordTypeCode = ParamUtil.getString(actionRequest, "recordTypeCode", "");
		String recordShortDescription = ParamUtil.getString(actionRequest, "recordShortDescription", "");
		Map<String, String> descValues = new HashMap<>();
		String enDescValue = ParamUtil.getString(actionRequest, "EnglishdescValue", "");
		if (containsXSS(recordTypeCode) || containsXSS(recordShortDescription) || containsXSS(enDescValue)) {
			SessionErrors.add(actionRequest, "xssDetected");
			return;
		}
		for (String langName : languagesName) {
			String descValue = ParamUtil.getString(actionRequest, langName + "descValue", "");
			if (containsXSS(descValue)) {
				SessionErrors.add(actionRequest, "xssDetected");
				return;
			}
			if (descValue.equals("") && !enDescValue.equals(""))
				descValues.put(langName, enDescValue);
			else
				descValues.put(langName, descValue);
		}
		try {
			Lovs parentLov = _lovsLocalService.getLovs(lovId);
			long entityResourceId = parentLov.getEntityResourceId();
			List<LovData> result = _lovDataLocalService.getLovDataByTypeCodeAndLovCodeAndStatus(lovType, recordTypeCode, entityResourceId,0);
			if (result != null && result.size() > 0) {
				SessionErrors.add(actionRequest, "duplicateCode");
				actionRequest.setAttribute("lovId", lovId);
				actionRequest.setAttribute("lovType", lovType);
				actionRequest.setAttribute("recordTypeCode", recordTypeCode);
				actionRequest.setAttribute("recordShortDescription", recordShortDescription);
				actionRequest.setAttribute("descs", descValues);
				actionRequest.setAttribute("lovCode", parentLov.getCode());
				actionRequest.setAttribute("localeLanguageNames", IsoSupportedLocales.getAllLanguageNames());
				actionRequest.setAttribute("myview", "addLovData");
				return;
			}

			if (lovType.equalsIgnoreCase("Languages")) {
				List<Locale> availableLocales = new ArrayList<>(LanguageUtil.getAvailableLocales());
				actionRequest.setAttribute("availableLocales", availableLocales);
				addingLocales(actionRequest, "add", themeDisplay, recordTypeCode, "");
			}

			ServiceContext serviceContext =createServiceContextForWorkflow(actionRequest);
			_lovsLocalService.addLovDataWorkflow(lovId, lovType, recordTypeCode, descValues, recordShortDescription, chn,0L,user,serviceContext);

			actionRequest.setAttribute("parentId", lovId);
			actionRequest.setAttribute("lovType", lovType);

			/*
			 * pSession.setAttribute("parentId", lovId); pSession.setAttribute("lovType",
			 * lovType);
			 */
			pSession.setAttribute("LIFERAY_SHARED_TypeId", lovId, PortletSession.APPLICATION_SCOPE);
			pSession.setAttribute("LIFERAY_SHARED_Lovtype", lovType, PortletSession.APPLICATION_SCOPE);

			actionRequest.setAttribute("myview", "viewLovData");
		} catch (Exception e) {
			SessionErrors.add(actionRequest, "error");
			actionRequest.setAttribute("errorMsg",
					"The language you entered does not match any of the supported languages on the server. Please try again with a valid language.");
			actionRequest.setAttribute("lovId", lovId);
			actionRequest.setAttribute("lovType", lovType);
			actionRequest.setAttribute("recordTypeCode", recordTypeCode);
			actionRequest.setAttribute("recordShortDescription", recordShortDescription);
			actionRequest.setAttribute("descs", descValues);
			actionRequest.setAttribute("lovCode", _lovsLocalService.getLovs(lovId).getCode());
			List<String> remainingLocaleNames = IsoSupportedLocales.getAllLanguageNames();
			remainingLocaleNames.removeAll(currentLanguageForLov);
			actionRequest.setAttribute("localeLanguageNames", remainingLocaleNames);
			actionRequest.setAttribute("myview", "addLovData");
		}
	}

	public void getLovDataUpdateId(ActionRequest actionRequest, ActionResponse actionResponse) {
		PortletSession pSession = actionRequest.getPortletSession();

		Long id = ParamUtil.getLong(actionRequest, "lovDataId", 1);
		LovData lovData;
		List<String> localeLanguageNames = IsoSupportedLocales.getAllLanguageNames();
		String lovCode = "";

		// Check if hasPendingVersion is passed from the view
		String hasPendingVersionParam = ParamUtil.getString(actionRequest, "hasPendingVersion", "false");
		boolean hasPendingVersion = Boolean.parseBoolean(hasPendingVersionParam);

		Long chn = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
				? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1;

		// List<String> currentLanguageForLov =
		// _lovsLocalService.getLangTypeCodeByLOVCode("001", chn);
		// localeLanguageNames.removeAll(currentLanguageForLov);
		List<Languages> languages = _languageLocalService.getbyChannelId(chn);
		List<String> languagesName = new ArrayList<>();
		for (Languages langName : languages) {
			languagesName.add(langName.getLangName());
		}

		Map<String, String> descValues = new HashMap<>();

		try {
			lovData = _lovDataLocalService.getLovData(id);
			lovCode = _lovsLocalService.getLovs(lovData.getLovId()).getCode();
			actionRequest.setAttribute("lovId", lovData.getLovId());
			actionRequest.setAttribute("lovType", lovData.getLovType());
			actionRequest.setAttribute("recordTypeCode", lovData.getRecordTypeCode());
			actionRequest.setAttribute("recordShortDescription", lovData.getRecordShortDescription());
			actionRequest.setAttribute("localeLanguageNames", localeLanguageNames);
			actionRequest.setAttribute("lovCode", lovCode);
			for (String langName : languagesName) {
				descValues.put(langName, lovData.getRecordDescription(langName));

			}
			actionRequest.setAttribute("descs", descValues);

			// Check if this LOV has a pending version if not already set from JSP
			if (!hasPendingVersion) {
				hasPendingVersion = checkHasPendingVersionForLov(lovData.getLovId());
			}

		} catch (PortalException e) {
			e.printStackTrace();
		}

		pSession.setAttribute("lovDataId", id);
		actionRequest.setAttribute("hasPendingVersion", hasPendingVersion);
		actionRequest.setAttribute("myview", "updateLovData");
	}

	public void lovDataUpdate(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
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
		// List<String> currentLanguageForLov =
		// _lovsLocalService.getLangTypeCodeByLOVCode("001", chn);
		List<Languages> languages = _languageLocalService.getbyChannelId(chn);
		List<String> languagesName = new ArrayList<>();
		for (Languages langName : languages) {
			languagesName.add(langName.getLangName());
		}

		Long id = pSession.getAttribute("lovDataId") != null ? (Long) pSession.getAttribute("lovDataId") : 1;

		Long lovId = ParamUtil.getLong(actionRequest, "lovId", 1);


		if (checkHasPendingVersionForLov(lovId)) {
			SessionErrors.add(actionRequest, "hasPendingVersion");
			actionRequest.setAttribute("myview", "viewLovData");
			return;
		}

		String lovType = ParamUtil.getString(actionRequest, "lovType", "");
		String recordTypeCode = ParamUtil.getString(actionRequest, "recordTypeCode", "");
		String recordShortDescription = ParamUtil.getString(actionRequest, "recordShortDescription", "");

		// Validate that the record type code has not been changed
		LovData existingLovData = _lovDataLocalService.getLovData(id);
		if (!existingLovData.getRecordTypeCode().equals(recordTypeCode)) {
			SessionErrors.add(actionRequest, "codeChanged");
			actionRequest.setAttribute("myview", "viewLovData");
			return;
		}

		Map<String, String> descValues = new HashMap<>();
		String enDescValue = ParamUtil.getString(actionRequest, "EnglishdescValue", "");
		if (containsXSS(recordTypeCode) || containsXSS(recordShortDescription) || containsXSS(enDescValue)) {
			SessionErrors.add(actionRequest, "xssDetected");
			return;
		}
		for (String langName : languagesName) {
			String nameValue = ParamUtil.getString(actionRequest, langName + "descValue", "");
			if (containsXSS(nameValue)) {
				SessionErrors.add(actionRequest, "xssDetected");
				return;
			}
			if (nameValue.equals("") && !enDescValue.equals("")) {
				descValues.put(langName, enDescValue);
			} else {
				descValues.put(langName, nameValue);
			}
		}
		try {

			if (lovType.equalsIgnoreCase("Languages")) {
				LovData lovData = _lovDataLocalService.getLovData(id);
				addingLocales(actionRequest, "update", themeDisplay, recordTypeCode, lovData.getRecordTypeCode());
			}

			ServiceContext serviceContext =createServiceContextForWorkflow(actionRequest);
			_lovsLocalService.updateLovDataWorkflow(id, lovId, lovType, recordTypeCode, descValues, recordShortDescription, chn,user,serviceContext);

			actionRequest.setAttribute("parentId", lovId);
			actionRequest.setAttribute("lovType", lovType);

			/*
			 * pSession.setAttribute("parentId", lovId); pSession.setAttribute("lovType",
			 * lovType);
			 */
			pSession.setAttribute("LIFERAY_SHARED_TypeId", lovId, PortletSession.APPLICATION_SCOPE);
			pSession.setAttribute("LIFERAY_SHARED_Lovtype", lovType, PortletSession.APPLICATION_SCOPE);

			actionRequest.setAttribute("myview", "viewLovData");
		} catch (Exception e) {
			SessionErrors.add(actionRequest, "error");
			actionRequest.setAttribute("lovId", lovId);
			actionRequest.setAttribute("lovType", lovType);
			actionRequest.setAttribute("recordTypeCode", recordTypeCode);
			actionRequest.setAttribute("recordShortDescription", recordShortDescription);
			actionRequest.setAttribute("descs", descValues);
			actionRequest.setAttribute("lovCode", _lovsLocalService.getLovs(lovId).getCode());
			actionRequest.setAttribute("localeLanguageNames", IsoSupportedLocales.getAllLanguageNames());
			actionRequest.setAttribute("myview", "updateLovData");
		}
	}

	public void lovDataDelete(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
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
		Long deleteId = ParamUtil.getLong(actionRequest, "deleteId", 0);

		Long parentId = (Long) pSession.getAttribute("LIFERAY_SHARED_TypeId", PortletSession.APPLICATION_SCOPE);
		actionRequest.setAttribute("parentId", parentId);
		if (checkHasPendingVersionForLov(parentId)) {
			SessionErrors.add(actionRequest, "hasPendingVersion");
			actionRequest.setAttribute("myview", "viewLovData");
			return;
		}
		Lovs lov = _lovsLocalService.getLovs(parentId);
		LovData lovData = _lovDataLocalService.getLovData(deleteId);

		if (lovData != null && isBlueAppChannel(chn)) {
			String lovCode = lov.getCode();
			if (TelemoneyConstants.WHITELIST_CODE.equalsIgnoreCase(lovCode)
					|| TelemoneyConstants.SEGMENTS_CODE.equalsIgnoreCase(lovCode)) {
				boolean linkedToFeature = _featureLocalService.isLovDataLinkedToApprovedFeature(
						lov.getEntityResourceId(), lovData.getRecordTypeCode());
				if (linkedToFeature) {
					SessionErrors.add(actionRequest, "lovDataLinkedToFeature");
					actionRequest.setAttribute("myview", "viewLovData");
					return;
				}
			}
		}

		if(lovData !=null){
		if (lov.getName().equalsIgnoreCase("Languages")) {
			addingLocales(actionRequest, "delete", themeDisplay, "", lovData.getRecordTypeCode());
		}
		_lovsLocalService.deleteLovDataWorkflow(lovData,chn,createServiceContextForWorkflow(actionRequest),user);

//		_lovDataLocalService.lovDataDelete(deleteId, chn);

		actionRequest.setAttribute("myview", "viewLovData");
		}
	}

	private boolean isBlueAppChannel(long channelId) {
		try {
			Channels channel = _channelsLocalService.getChannels(channelId);
			return channel != null && "Blue App".equalsIgnoreCase(channel.getName());
		} catch (PortalException e) {
			return false;
		}
	}

	public void search(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, Exception, NoSuchLovDataException {
		PortletSession pSession = actionRequest.getPortletSession();
		Long lovIdd = ParamUtil.getLong(actionRequest, "typeIdd");
		String id = Long.toString(lovIdd);
		String lovType = "";
		Lovs lov;
		Long entityResourceId = null ;
		try {
			lov = (_lovsLocalService.getLovs(lovIdd));
			entityResourceId=lov.getEntityResourceId();
			lovType = (_lovsLocalService.getLatestApprovedLovByEntityResourceId(lov.getEntityResourceId())).getName("English");

		} catch (PortalException e) {
			e.printStackTrace();
		}

		String searchName = ParamUtil.getString(actionRequest, "dataSearchName");
		String searchBy = ParamUtil.getString(actionRequest, "searchBy");

		List<LovData> allData = searchBy.equals("code") ? _lovDataLocalService.search(searchName, searchBy,entityResourceId)
				: _lovDataLocalService.searchLovDataLocalizationByDescription(searchName, id);


		actionRequest.setAttribute("data", allData);
		pSession.setAttribute("LIFERAY_SHARED_SearchData", allData, PortletSession.APPLICATION_SCOPE);
		actionRequest.setAttribute("myview", "viewLovData");

		actionRequest.setAttribute("parentId", lovIdd);
		pSession.setAttribute("parentId", lovIdd);

		actionRequest.setAttribute("lovType", lovType);
		pSession.setAttribute("lovType", lovType);

	}

	public void insertDataFromFile(ActionRequest actionRequest, ActionResponse actionResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		List<Role> roles = user.getRoles();
		boolean isAdministrator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Administrator"));
		boolean isPo = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("po"));

		if (!isAdministrator && !isPo) {
			SessionErrors.add(actionRequest, "notAuthorized");
			return;
		}
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);

		// Get the uploaded file
		File file = uploadPortletRequest.getFile("fileInputFieldName"); // replace "fileInputFieldName" with the actual
																		// name of your file input field

		if (file != null && file.exists()) {
			try {

				String filePath = file.getAbsolutePath();

				PortletSession pSession = actionRequest.getPortletSession();
				Long chn = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
						? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
						: 1;

				_lovsLocalService.importLovsAndLovDataFromCSV(filePath, chn);
			} catch (Exception e) {
				e.printStackTrace();

			} finally {

				FileUtil.delete(file);
			}
		}
	}

	public void addingLocales(ActionRequest actionRequest, String action, ThemeDisplay themeDisplay,
			String recievedLanguageName, String foundLanguageName) throws Exception {
		PortletSession pSession = actionRequest.getPortletSession();

		Long chn = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
				? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1;
		List<String> currentLanguageForLov = _lovsLocalService.getLangTypeCodeByLOVCode("001", chn);
		List<Locale> availableLocales = new ArrayList<>(LanguageUtil.getAvailableLocales());
		String newAvailableLocales = "";
		Locale localForRecievedLanguageName = IsoSupportedLocales.getLocaleByLanguageName(recievedLanguageName);
		Locale localeForFoundLanguageName = null;
		Boolean isNewAlreadyAdded = false;
		Boolean isFoundAlreadyAdded = false;

		try {
			localeForFoundLanguageName = foundLanguageName != null && !foundLanguageName.isEmpty()
					? IsoSupportedLocales.getLocaleByLanguageName(foundLanguageName)
					: null;
			isNewAlreadyAdded = availableLocales.contains(localForRecievedLanguageName)
					&& currentLanguageForLov.contains(recievedLanguageName);
			isFoundAlreadyAdded = availableLocales.contains(localeForFoundLanguageName)
					&& currentLanguageForLov.contains(foundLanguageName);
		} catch (Exception e) {
			throw new NotFoundException("Language name was not found in locals.");
		}

		Boolean processValid = false;

		if (action.contains("add")) {
			if (!isNewAlreadyAdded) {
				availableLocales.add(localForRecievedLanguageName);
				System.out.println("availableLocals: " + availableLocales);
				processValid = true;
			}
		} else if (action.contains("update")) {
			if (isFoundAlreadyAdded) {
				availableLocales.remove(localeForFoundLanguageName);
				availableLocales.add(localForRecievedLanguageName);
				processValid = true;
			} else {
				throw new NotFoundException("The language you're trying to update was not found in locals. "
						+ "Try checking the spelling of your language name/record typeCode.");
			}
		} else if (action.contains("delete")) {
			if (isFoundAlreadyAdded) {
				availableLocales.remove(localeForFoundLanguageName);
				processValid = true;
			} else {
				throw new NotFoundException("The language you're trying to delete was not found in locals.");
			}
		}
		if (processValid) {
			newAvailableLocales = String.join(",",
					availableLocales.stream().map(Locale::toString).toArray(String[]::new));
			long liveGroupId = themeDisplay.getLayout().getGroupId();
			Group liveGroup = _groupLocalService.getGroup(liveGroupId);
			UnicodeProperties typeSettingsUnicodeProperties = liveGroup.getTypeSettingsProperties();

			typeSettingsUnicodeProperties.setProperty(PropsKeys.LOCALES, newAvailableLocales);
			CompanyLocalServiceUtil.updatePreferences(liveGroup.getCompanyId(), typeSettingsUnicodeProperties);

		} else {
			throw new Exception("Cannot Add/ Update/ or Delete the New Language Local.");
		}

	}
	private ServiceContext createServiceContextForWorkflow(ActionRequest actionRequest) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Lovs.class.getName(), actionRequest);
		serviceContext.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH);
		return serviceContext;
	}

	@Reference
	private LovsLocalService _lovsLocalService;

	@Reference
	private LovDataLocalService _lovDataLocalService;

	@Reference
	private LanguagesLocalService _languageLocalService;

	@Reference
	private UserLogsLocalService _userLogsLocalService;

	@Reference
	private GroupLocalService _groupLocalService;

	@Reference
	private ChannelsLocalService _channelsLocalService;

	@Reference
	private FeatureLocalService _featureLocalService;
}
