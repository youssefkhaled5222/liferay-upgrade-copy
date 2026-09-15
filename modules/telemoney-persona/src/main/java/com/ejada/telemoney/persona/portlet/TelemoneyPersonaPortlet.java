	package com.ejada.telemoney.persona.portlet;
	import com.ejada.telemony.db.model.Banner;
	import com.ejada.telemony.db.model.LovData;
	import com.ejada.telemony.db.model.Persona;
	import com.ejada.telemony.db.model.Themes;
	import com.ejada.telemoney.db.constants.TelemoneyConstants;
	import com.ejada.telemoney.persona.constants.TelemoneyPersonaPortletKeys;
	import com.ejada.telemony.db.service.LovsLocalService;
	import com.ejada.telemony.db.service.PersonaLocalService;
	import com.ejada.telemony.db.service.ThemesLocalService;
	import com.ejada.telemony.db.service.UserLogsLocalService;
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
	import com.liferay.portal.kernel.util.ParamUtil;
	import com.liferay.portal.kernel.util.WebKeys;

	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.ArrayList;
	import java.util.Date;
	import java.util.List;
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
			"javax.portlet.display-name=TelemoneyPersona", "javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/view.jsp",
			"javax.portlet.name=" + TelemoneyPersonaPortletKeys.TELEMONEYPERSONA,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
	public class TelemoneyPersonaPortlet extends MVCPortlet {
		private static final Log LOG = LogFactoryUtil.getLog(TelemoneyPersonaPortlet.class);
		private static final Pattern XSS_PATTERN = Pattern.compile(".*[<>\"'\\\\].*");
		@Override
		public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
				throws IOException, PortletException {
			String personaviewUrl = "/META-INF/resources/view.jsp";
			renderRequest.setAttribute("personaviewUrl", personaviewUrl);
			String myview = "view";
			PortletSession pSession = renderRequest.getPortletSession();
			Long chn =  pSession.getAttribute("LIFERAY_SHARED_ChannelId",PortletSession.APPLICATION_SCOPE)!=null
					?(Long)pSession.getAttribute("LIFERAY_SHARED_ChannelId",PortletSession.APPLICATION_SCOPE)
					:1;

			if (renderRequest.getAttribute("myview") != null && renderRequest.getAttribute("myview") != "view") {
				myview = (String) renderRequest.getAttribute("myview");
					List<Themes> darkThemes ;
					darkThemes= _personaLocalService.getDarkThemes(chn);
					List<Themes> lightThemes ;
					lightThemes= _personaLocalService.getLightThemes(chn);
					renderRequest.setAttribute("darkThemes", darkThemes);
					renderRequest.setAttribute("lightThemes", lightThemes);
			} else {
				// Get latest approved personas with pending status
				java.util.Map<Persona, Boolean> allRecordsWithPending =
						_personaLocalService.getLatestApprovedByChannelIdWithPending(chn);

				// Separate default and non-default personas
				java.util.List<Persona> defaultPersonas = new java.util.ArrayList<>();
				java.util.List<Persona> nonDefaultPersonas = new java.util.ArrayList<>();
				java.util.Map<Persona, Boolean> defaultPersonasWithPending = new java.util.LinkedHashMap<>();
				java.util.Map<Persona, Boolean> nonDefaultPersonasWithPending = new java.util.LinkedHashMap<>();

				for (java.util.Map.Entry<Persona, Boolean> entry : allRecordsWithPending.entrySet()) {
					Persona persona = entry.getKey();
					Boolean isPending = entry.getValue();
					if (persona.getDefaultPersona()) {
						defaultPersonas.add(persona);
						defaultPersonasWithPending.put(persona, isPending);
					} else {
						nonDefaultPersonas.add(persona);
						nonDefaultPersonasWithPending.put(persona, isPending);
					}
				}

				renderRequest.setAttribute("records", nonDefaultPersonas);
				renderRequest.setAttribute("defaultPersonas", defaultPersonas);
				renderRequest.setAttribute("recordsWithPending", nonDefaultPersonasWithPending);
				renderRequest.setAttribute("defaultPersonasWithPending", defaultPersonasWithPending);
			}

			String view = "/" + myview + ".jsp";
			PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(view);
			dispatcher.include(renderRequest, renderResponse);
		}

		public void beforeCreatePersona(ActionRequest actionRequest, ActionResponse actionResponse) {
			PortletSession pSession = actionRequest.getPortletSession();
			Long chn = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
					? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
					: 1;
			List<LovData> nationalityListfromLov = _lovsLocalService.getLatestApprovedLovDataByCode(TelemoneyConstants.NATIONALITY_CODE, chn)!=null
					&&_lovsLocalService.getLatestApprovedLovDataByCode(TelemoneyConstants.NATIONALITY_CODE, chn).size()!=0
					&&!(_lovsLocalService.getLatestApprovedLovDataByCode(TelemoneyConstants.NATIONALITY_CODE, chn).isEmpty())
					?_lovsLocalService.getLatestApprovedLovDataByCode(TelemoneyConstants.NATIONALITY_CODE, chn)
					:new ArrayList<LovData>();
			actionRequest.setAttribute("nationalityList", nationalityListfromLov);
			actionRequest.setAttribute("myview", "add");
		}

		public void personaCreate(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
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
			Long chn =  pSession.getAttribute("LIFERAY_SHARED_ChannelId",PortletSession.APPLICATION_SCOPE)!=null
					?(Long)pSession.getAttribute("LIFERAY_SHARED_ChannelId",PortletSession.APPLICATION_SCOPE)
					:1;
			Long darkThemeId = ParamUtil.getLong(actionRequest, "darkThemeId", 1);
			Long lightThemeId = ParamUtil.getLong(actionRequest, "lightThemeId", 1);
			int startAge = ParamUtil.getInteger(actionRequest, "startAge", 1);
			int endAge = ParamUtil.getInteger(actionRequest, "endAge", 1);
			int priority = ParamUtil.getInteger(actionRequest, "priority", 1);
			//String customerSegment = ParamUtil.getString(actionRequest, "customerSegment", "");
			//String nationality = ParamUtil.getString(actionRequest, "nationality", "");
			String name = ParamUtil.getString(actionRequest, "name", "");
			String status = ParamUtil.getString(actionRequest, "status", "");
			String description = ParamUtil.getString(actionRequest, "description", "");
			String gender = ParamUtil.getString(actionRequest, "gender", "");
			String dateFrom = ParamUtil.getString(actionRequest, "startDatePersona", "");
			String dateTo = ParamUtil.getString(actionRequest, "endDatePersona", "");
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date date1 = (!dateFrom.equals("")&&dateFrom!=null) ? dateFormat.parse(dateFrom) : null;
			Date date2 = (!dateTo.equals("")&&dateTo!=null) ? dateFormat.parse(dateTo) : null;
			String[] selectedsector = ParamUtil.getStringValues(actionRequest, "sector");
			JSONArray selectedSectorJSON = JSONFactoryUtil.createJSONArray(selectedsector);
			if (selectedSectorJSON.length() == 0)
				throw new Exception("No sector was Selected");

			String[] customerSegment = ParamUtil.getStringValues(actionRequest, "customerSegment");
			JSONArray selectedSegmentJSON = JSONFactoryUtil.createJSONArray(customerSegment);
			if (selectedSegmentJSON.length() == 0)
				throw new Exception("No customerSegment was Selected");

			String[] selectedNationality = ParamUtil.getStringValues(actionRequest, "nationality");
			JSONArray selectedNationalityJSON = JSONFactoryUtil.createJSONArray(selectedNationality);
			if (selectedNationalityJSON.length() == 0)
				throw new Exception("No Nationality was Selected");
			String incom = ParamUtil.getString(actionRequest, "incom", "");
			String minIncomeStr = null;
			String maxIncomeStr = null;
			int minIncome = 0;
			int maxIncome = 0;
			if (incom != null && !incom.isEmpty()) {
				String[] ageParts = incom.split("-");
				if (ageParts.length == 2) {
					minIncomeStr = ageParts[0];
					maxIncomeStr = ageParts[1];
					minIncome = Integer.parseInt(minIncomeStr);
					maxIncome = Integer.parseInt(maxIncomeStr);
				}
			}
			if (containsXSS(name) || containsXSS(status) || containsXSS(description) || containsXSS(gender) || containsXSS(incom)) {
				SessionErrors.add(actionRequest, "xssDetected");
				return;
			}
			for (String val : selectedsector) {
				if (containsXSS(val)) {
					throw new Exception("XSS content detected in 'sector' selection");
				}
			}
			for (String val : customerSegment) {
				if (containsXSS(val)) {
					throw new Exception("XSS content detected in 'customerSegment' selection");
				}
			}
			for (String val : selectedNationality) {
				if (containsXSS(val)) {
					throw new Exception("XSS content detected in 'nationality' selection");
				}
			}


			ServiceContext serviceContext = createServiceContextForWorkflow(actionRequest);

			_personaLocalService.personaCreate(darkThemeId, lightThemeId, startAge, endAge, name, selectedNationalityJSON.toJSONString(), selectedSegmentJSON.toString(), status, description,
					gender,priority,date2,date1,selectedSectorJSON.toString(),minIncome,maxIncome,chn,false,serviceContext,user);
			String userName = themeDisplay.getUser().getFullName();
			String userAction = TelemoneyConstants.USER_ACTION_ADD.concat(TelemoneyConstants.USER_LOGS_PERSONA).concat(name);
			_userLogsLocalService.addUserData(userName, userAction,chn);
		}



		public void getPersonaViewId(ActionRequest actionRequest, ActionResponse actionRespons) {
			PortletSession pSession = actionRequest.getPortletSession();
			Long id = ParamUtil.getLong(actionRequest, "singlepersonaId", 1);
			try {
				Persona per = _personaLocalService.getPersona(id);
				actionRequest.setAttribute("id", id);
				actionRequest.setAttribute("channelId", per.getChannelId());
				String dark = _themesLocalService.getThemes(per.getDarkThemeId()).getThemeEnName();
				actionRequest.setAttribute("darkThemeId", dark);
				String light = _themesLocalService.getThemes(per.getLightThemeId()).getThemeEnName();
				actionRequest.setAttribute("lightThemeId", light);
				actionRequest.setAttribute("startAge", per.getStartAge());
				actionRequest.setAttribute("endAge", per.getEndAge());
				actionRequest.setAttribute("priority", per.getPriority());
				actionRequest.setAttribute("customerSegment", per.getCustomerSegment());
				actionRequest.setAttribute("status", per.getPersonaStatus());
				actionRequest.setAttribute("nationality", per.getNationality());
				actionRequest.setAttribute("name", per.getName());
				actionRequest.setAttribute("gender", per.getGender());
				actionRequest.setAttribute("description", per.getDescription());
				actionRequest.setAttribute("dateFrom", per.getDateFrom());
				actionRequest.setAttribute("dateTo", per.getDateTo());
				actionRequest.setAttribute("sector", per.getSector());
				actionRequest.setAttribute("defaultPersona", per.getDefaultPersona());
				int minincome= per.getMinIncome();
				int maxIncom = per.getMaxIncome();
				StringBuilder incomeRangeBuilder =  new StringBuilder();
				incomeRangeBuilder.append(minincome);
				incomeRangeBuilder.append("-");
				incomeRangeBuilder.append(maxIncom);
				String income=incomeRangeBuilder.toString();
				actionRequest.setAttribute("incom", income);
			} catch (PortalException e) {
				e.printStackTrace();
			}
			pSession.setAttribute("singlepersonaId", id);
			actionRequest.setAttribute("myview", "viewRecord");
		}

	public void getPersonaUpdateId(ActionRequest actionRequest, ActionResponse actionRespons) {
		PortletSession pSession = actionRequest.getPortletSession();
		Long id = ParamUtil.getLong(actionRequest, "personaId", 1);
		Long chn =  pSession.getAttribute("LIFERAY_SHARED_ChannelId",PortletSession.APPLICATION_SCOPE)!=null
				?(Long)pSession.getAttribute("LIFERAY_SHARED_ChannelId",PortletSession.APPLICATION_SCOPE)
				:1;
		List<LovData> nationalityListfromLov = _lovsLocalService.getLatestApprovedLovDataByCode(TelemoneyConstants.NATIONALITY_CODE, chn)!=null
				&&_lovsLocalService.getLatestApprovedLovDataByCode(TelemoneyConstants.NATIONALITY_CODE, chn).size()!=0
				&&!(_lovsLocalService.getLatestApprovedLovDataByCode(TelemoneyConstants.NATIONALITY_CODE, chn).isEmpty())
				?_lovsLocalService.getLatestApprovedLovDataByCode(TelemoneyConstants.NATIONALITY_CODE, chn)
				:new ArrayList<LovData>();
				actionRequest.setAttribute("nationalityList", nationalityListfromLov);
		try {
			Persona per = _personaLocalService.getPersona(id);
			actionRequest.setAttribute("channelId", per.getChannelId());
			String darkTheneName = null;
			String lightTheneName = null;
			Long darkThemeId = per.getDarkThemeId();
			Long lightThemeId = per.getLightThemeId();
			if (darkThemeId != null && darkThemeId != 0) {
				long darkEntityResourceId = _themesLocalService.getThemes(darkThemeId).getEntityResourceId();
				Themes latestDark = _themesLocalService.getLatestApprovedByEntityResourceId(darkEntityResourceId);
				if (latestDark != null) {
					darkTheneName = latestDark.getThemeEnName();
					darkThemeId = latestDark.getThemeId();
				}
			}
			if (lightThemeId != null && lightThemeId != 0) {
				long lightEntityResourceId = _themesLocalService.getThemes(lightThemeId).getEntityResourceId();
				Themes latestLight = _themesLocalService.getLatestApprovedByEntityResourceId(lightEntityResourceId);
				if (latestLight != null) {
					lightTheneName = latestLight.getThemeEnName();
					lightThemeId = latestLight.getThemeId();
				}
			}
			actionRequest.setAttribute("darkTheneName", darkTheneName);
			actionRequest.setAttribute("lightTheneName", lightTheneName);
			actionRequest.setAttribute("darkThemeId", darkThemeId != null ? darkThemeId : 0L);
			actionRequest.setAttribute("lightThemeId", lightThemeId != null ? lightThemeId : 0L);
				actionRequest.setAttribute("startAge", per.getStartAge());
				actionRequest.setAttribute("endAge", per.getEndAge());
				actionRequest.setAttribute("priority", per.getPriority());
				actionRequest.setAttribute("customerSegment", per.getCustomerSegment());
				actionRequest.setAttribute("status", per.getPersonaStatus());
				actionRequest.setAttribute("nationality", per.getNationality());
				actionRequest.setAttribute("name", per.getName());
				actionRequest.setAttribute("gender", per.getGender());
				actionRequest.setAttribute("description", per.getDescription());
				actionRequest.setAttribute("dateFrom", per.getDateFrom());
				actionRequest.setAttribute("dateTo", per.getDateTo());
				actionRequest.setAttribute("sector", per.getSector());
				actionRequest.setAttribute("defaultPersona", per.getDefaultPersona());
				int minincome= per.getMinIncome();
				int maxIncom = per.getMaxIncome();
				StringBuilder incomeRangeBuilder =  new StringBuilder();
				incomeRangeBuilder.append(minincome);
				incomeRangeBuilder.append("-");
				incomeRangeBuilder.append(maxIncom);
				String income=incomeRangeBuilder.toString();
				actionRequest.setAttribute("incom", income);
			} catch (PortalException e) {
				e.printStackTrace();
			}
			pSession.setAttribute("personaId", id);
			actionRequest.setAttribute("nationalityList", nationalityListfromLov);
			actionRequest.setAttribute("myview", "update");
		}

	public void getPendingPersonaViewId(ActionRequest actionRequest, ActionResponse actionRespons) {
		PortletSession pSession = actionRequest.getPortletSession();
		Long id = ParamUtil.getLong(actionRequest, "pendingPersonaId", 1);
		Long chn =  pSession.getAttribute("LIFERAY_SHARED_ChannelId",PortletSession.APPLICATION_SCOPE)!=null
				?(Long)pSession.getAttribute("LIFERAY_SHARED_ChannelId",PortletSession.APPLICATION_SCOPE)
				:1;
		List<LovData> nationalityListfromLov = _lovsLocalService.getLatestApprovedLovDataByCode(TelemoneyConstants.NATIONALITY_CODE, chn)!=null
				&&_lovsLocalService.getLatestApprovedLovDataByCode(TelemoneyConstants.NATIONALITY_CODE, chn).size()!=0
				&&!(_lovsLocalService.getLatestApprovedLovDataByCode(TelemoneyConstants.NATIONALITY_CODE, chn).isEmpty())
				?_lovsLocalService.getLatestApprovedLovDataByCode(TelemoneyConstants.NATIONALITY_CODE, chn)
				:new ArrayList<LovData>();
				actionRequest.setAttribute("nationalityList", nationalityListfromLov);
		try {
			Persona per = _personaLocalService.getPersona(id);
			actionRequest.setAttribute("channelId", per.getChannelId());
			String darkTheneName = null;
			String lightTheneName = null;
			Long darkThemeId = per.getDarkThemeId();
			Long lightThemeId = per.getLightThemeId();
			if (darkThemeId != null && darkThemeId != 0) {
				long darkEntityResourceId = _themesLocalService.getThemes(darkThemeId).getEntityResourceId();
				Themes latestDark = _themesLocalService.getLatestApprovedByEntityResourceId(darkEntityResourceId);
				if (latestDark != null) {
					darkTheneName = latestDark.getThemeEnName();
					darkThemeId = latestDark.getThemeId();
				}
			}
			if (lightThemeId != null && lightThemeId != 0) {
				long lightEntityResourceId = _themesLocalService.getThemes(lightThemeId).getEntityResourceId();
				Themes latestLight = _themesLocalService.getLatestApprovedByEntityResourceId(lightEntityResourceId);
				if (latestLight != null) {
					lightTheneName = latestLight.getThemeEnName();
					lightThemeId = latestLight.getThemeId();
				}
			}
			actionRequest.setAttribute("darkTheneName", darkTheneName);
			actionRequest.setAttribute("lightTheneName", lightTheneName);
			actionRequest.setAttribute("darkThemeId", darkThemeId != null ? darkThemeId : 0L);
			actionRequest.setAttribute("lightThemeId", lightThemeId != null ? lightThemeId : 0L);
				actionRequest.setAttribute("startAge", per.getStartAge());
				actionRequest.setAttribute("endAge", per.getEndAge());
				actionRequest.setAttribute("priority", per.getPriority());
				actionRequest.setAttribute("customerSegment", per.getCustomerSegment());
				actionRequest.setAttribute("status", per.getPersonaStatus());
				actionRequest.setAttribute("nationality", per.getNationality());
				actionRequest.setAttribute("name", per.getName());
				actionRequest.setAttribute("gender", per.getGender());
				actionRequest.setAttribute("description", per.getDescription());
				actionRequest.setAttribute("dateFrom", per.getDateFrom());
				actionRequest.setAttribute("dateTo", per.getDateTo());
				actionRequest.setAttribute("sector", per.getSector());
				actionRequest.setAttribute("defaultPersona", per.getDefaultPersona());
				int minincome= per.getMinIncome();
				int maxIncom = per.getMaxIncome();
				StringBuilder incomeRangeBuilder =  new StringBuilder();
				incomeRangeBuilder.append(minincome);
				incomeRangeBuilder.append("-");
				incomeRangeBuilder.append(maxIncom);
				String income=incomeRangeBuilder.toString();
				actionRequest.setAttribute("incom", income);
			} catch (PortalException e) {
				e.printStackTrace();
			}
			pSession.setAttribute("personaId", id);
			actionRequest.setAttribute("nationalityList", nationalityListfromLov);
			actionRequest.setAttribute("viewOnly", true);
			actionRequest.setAttribute("myview", "update");
		}

		public void personaUpdate(ActionRequest actionRequest, ActionResponse actionRespons) throws Exception {

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

			String userName = themeDisplay.getUser().getFullName();


			PortletSession pSession = actionRequest.getPortletSession();
			Long id = pSession.getAttribute("personaId") != null ? (Long) pSession.getAttribute("personaId") : 1;
			Long channelId = ParamUtil.getLong(actionRequest, "channelId", 1);
			Long darkThemeId = ParamUtil.getLong(actionRequest, "darkThemeId", 1);
			Long lightThemeId = ParamUtil.getLong(actionRequest, "lightThemeId", 1);
			int startAge = ParamUtil.getInteger(actionRequest, "startAge", 1);
			int endAge = ParamUtil.getInteger(actionRequest, "endAge", 1);
			int priority = ParamUtil.getInteger(actionRequest, "priority", 1);
			//String nationality = ParamUtil.getString(actionRequest, "nationality", "");
			String name = ParamUtil.getString(actionRequest, "name", "");
			//String customerSegment = ParamUtil.getString(actionRequest, "customerSegment", "");
			String status = ParamUtil.getString(actionRequest, "status", "");
			String description = ParamUtil.getString(actionRequest, "description", "");
			String gender = ParamUtil.getString(actionRequest, "gender", "");
			Boolean defaultPersona = ParamUtil.getBoolean(actionRequest, "defaultPersona", false);
			String dateFrom = ParamUtil.getString(actionRequest, "startDatePersona", "");
			String dateTo = ParamUtil.getString(actionRequest, "endDatePersona", "");
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date date1 = (!dateFrom.equals("")&&dateFrom!=null) ? dateFormat.parse(dateFrom) : null;
			Date date2 = (!dateTo.equals("")&&dateTo!=null) ? dateFormat.parse(dateTo) : null;


			String[] selectedsector = ParamUtil.getStringValues(actionRequest, "sector");
			JSONArray selectedSectorJSON = JSONFactoryUtil.createJSONArray(selectedsector);
			if (selectedSectorJSON.length() == 0)
				throw new Exception("No sector was Selected");

			String[] customerSegment = ParamUtil.getStringValues(actionRequest, "customerSegment");
			JSONArray selectedSegmentJSON = JSONFactoryUtil.createJSONArray(customerSegment);
			if (selectedSegmentJSON.length() == 0)
				throw new Exception("No customerSegment was Selected");

			String[] selectedNationality = ParamUtil.getStringValues(actionRequest, "nationality");
			JSONArray selectedNationalityJSON = JSONFactoryUtil.createJSONArray(selectedNationality);
			if (selectedNationalityJSON.length() == 0)
				throw new Exception("No Nationality was Selected");

			String incom = ParamUtil.getString(actionRequest, "incom", "");
			String minIncomeStr = null;
			String maxIncomeStr = null;
			int minIncome = 0;
			int maxIncome = 0;
			if (incom != null && !incom.isEmpty()) {
				String[] ageParts = incom.split("-");
				if (ageParts.length == 2) {
					minIncomeStr = ageParts[0];
					maxIncomeStr = ageParts[1];
					minIncome = Integer.parseInt(minIncomeStr);
					maxIncome = Integer.parseInt(maxIncomeStr);
				}
			}
			// Validate single string inputs
			if (containsXSS(name) || containsXSS(status) || containsXSS(description) || containsXSS(gender) || containsXSS(incom)) {
				SessionErrors.add(actionRequest, "xssDetected");
				return;
				}

			// Validate arrays
			for (String val : selectedsector) {
				if (containsXSS(val)) {
					SessionErrors.add(actionRequest, "xssDetected");
					return;
					}
			}
			for (String val : customerSegment) {
				if (containsXSS(val)) {
					SessionErrors.add(actionRequest, "xssDetected");
					return;
					}
			}
			for (String val : selectedNationality) {
				if (containsXSS(val)) {
					SessionErrors.add(actionRequest, "xssDetected");
					return;
					}
			}
			ServiceContext serviceContext = createServiceContextForWorkflow(actionRequest);

			_personaLocalService.personaUpdate(id, channelId, darkThemeId, lightThemeId, startAge, endAge,
					name, selectedNationalityJSON.toString(), selectedSegmentJSON.toString(), status,
					description, gender,priority,date2,date1,selectedSectorJSON.toString(),minIncome,maxIncome,defaultPersona,serviceContext,user);
			String userAction = TelemoneyConstants.USER_ACTION_UPDATE.concat(TelemoneyConstants.USER_LOGS_PERSONA).concat(name);
			_userLogsLocalService.addUserData(userName, userAction,channelId);
		}

		public void personaDelete(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
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
			Long chn = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
					? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
					: 1;
			Long deleteId = ParamUtil.getLong(actionRequest, "deleteId", 0);
			String userName = themeDisplay.getUser().getFullName();
			Persona persona = _personaLocalService.fetchPersona(deleteId);
			if (persona != null) {
				List<String> linkedBannerNames = _personaLocalService.getLinkedBannerNames(deleteId);
				if(linkedBannerNames != null && !linkedBannerNames.isEmpty())
				{
					String bannerNamesStr = String.join(", ", linkedBannerNames);
					actionRequest.setAttribute("linkedBannerNames", bannerNamesStr);
					SessionErrors.add(actionRequest, "linkedToBanner");
					return;
				}
				ServiceContext serviceContext = createServiceContextForWorkflow(actionRequest);
				_personaLocalService.personaDelete(deleteId, serviceContext, user);
				String name = persona.getName();
				String userAction = TelemoneyConstants.USER_ACTION_DELETE.concat(TelemoneyConstants.USER_LOGS_PERSONA).concat(name);
				_userLogsLocalService.addUserData(userName, userAction, chn);
			}
		}

		public void getDarkThemes(ActionRequest actionRequest, ActionResponse actionResponse) {

		}
		private boolean containsXSS(String input) {
			return input != null && XSS_PATTERN.matcher(input).find();
		}
		private ServiceContext createServiceContextForWorkflow(ActionRequest actionRequest) throws PortalException {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					Persona.class.getName(), actionRequest);
			serviceContext.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH);
			return serviceContext;
		}

		@Reference
		PersonaLocalService _personaLocalService;

		@Reference
		ThemesLocalService _themesLocalService;

		@Reference
		private UserLogsLocalService _userLogsLocalService;

		@Reference
		private LovsLocalService _lovsLocalService;
	}