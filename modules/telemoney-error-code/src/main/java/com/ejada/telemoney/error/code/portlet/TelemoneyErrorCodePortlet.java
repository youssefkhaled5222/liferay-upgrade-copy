package com.ejada.telemoney.error.code.portlet;

import com.ejada.telemoney.error.code.constants.TelemoneyErrorCodePortletKeys;
import com.ejada.telemony.db.constants.Constants;
import com.ejada.telemony.db.model.ConfigurationEntity;
import com.ejada.telemony.db.service.ConfigurationEntityLocalService;
import com.ejada.telemony.db.service.ErrorCodeLocalService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.workflow.WorkflowConstants;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

/**
 * @author rmostafa
 */
@Component(configurationPid = "com.ejada.telemoney.error.code.portlet.ViewErrorCodeConfiguration", immediate = true, property = {
		"com.liferay.portlet.display-category=category.sample", "com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=TelemoneyErrorCode",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TelemoneyErrorCodePortletKeys.TELEMONEYERRORCODE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class TelemoneyErrorCodePortlet extends MVCPortlet {
	private static final Pattern XSS_PATTERN = Pattern.compile(".*[<>\"'\\\\].*");

	private boolean containsXSS(String input) {
	    return input != null && XSS_PATTERN.matcher(input).find();
	}
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		PortletPreferences portletPreferences = renderRequest.getPreferences();
		String XCorrelationId = portletPreferences.getValue("XCorrelationId",
				String.valueOf(_viewErrorCodeConfiguration.XCorrelationId()));
		String userName = portletPreferences.getValue("userName",
				String.valueOf(_viewErrorCodeConfiguration.userName()));
		String password = portletPreferences.getValue("password",
				String.valueOf(_viewErrorCodeConfiguration.password()));
		String errorCodeUrl = portletPreferences.getValue("errorCodeUrl",
				String.valueOf(_viewErrorCodeConfiguration.errorCodeUrl()));

		String personaviewUrl = "/META-INF/resources/view.jsp";
		renderRequest.setAttribute("personaviewUrl", personaviewUrl);
		String myview = "view";
		// PortletSession pSession = renderRequest.getPortletSession();
		JSONObject originalData;
		int delta = ParamUtil.getInteger(renderRequest, "delta");
		int cur = ParamUtil.getInteger(renderRequest, "cur");
		if (renderRequest.getAttribute("myview") != null && renderRequest.getAttribute("myview") != "view") {
			myview = (String) renderRequest.getAttribute("myview");

		} else if (cur >= 1 || delta > 10) {
			String errorCodeResponse = _errorCodeLocalService.getAllErrorCodes(errorCodeUrl, XCorrelationId, userName,
					password);
			try {
				originalData = JSONFactoryUtil.createJSONObject(errorCodeResponse);
				JSONArray jsonItems = originalData.getJSONArray("body");
				List<ErrorCodeDTO> items = ErrorCodeDTO.fromJSONArray(jsonItems);
				items = ErrorCodeDTO.fromJSONArray(jsonItems);

				Set<String> pendingErrorCodeIds = _configurationEntityLocalService.getPendingEntityIdsByType(Constants.ERROR_CODE);
				renderRequest.setAttribute("pendingErrorCodeIds", pendingErrorCodeIds);

				renderRequest.setAttribute("records", items);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			String errorCodeResponse = _errorCodeLocalService.getAllErrorCodes(errorCodeUrl, XCorrelationId, userName,
					password);
			try {
				originalData = JSONFactoryUtil.createJSONObject(errorCodeResponse);
				JSONArray jsonItems = originalData.getJSONArray("body");
				List<ErrorCodeDTO> items = ErrorCodeDTO.fromJSONArray(jsonItems);
				items = ErrorCodeDTO.fromJSONArray(jsonItems);

				Set<String> pendingErrorCodeIds = _configurationEntityLocalService.getPendingEntityIdsByType(Constants.ERROR_CODE);
				renderRequest.setAttribute("pendingErrorCodeIds", pendingErrorCodeIds);

				renderRequest.setAttribute("records", items);

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		String view = "/" + myview + ".jsp";
		renderRequest.setAttribute(ViewErrorCodeConfiguration.class.getName(), _viewErrorCodeConfiguration);
		PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(view);
		dispatcher.include(renderRequest, renderResponse);

	}

	public void getErrorCodeviewId(ActionRequest actionRequest, ActionResponse actionRespons) throws PortalException {
		JSONObject originalData;
		String statusCode = ParamUtil.getString(actionRequest, "statusCode", "");
		String language = ParamUtil.getString(actionRequest, "languages", "");
		String description = ParamUtil.getString(actionRequest, "description", "");
		boolean hasPendingVersion = ParamUtil.getBoolean(actionRequest, "hasPendingVersion", false);

		PortletPreferences portletPreferences = actionRequest.getPreferences();
		String XCorrelationId = portletPreferences.getValue("XCorrelationId",
				String.valueOf(_viewErrorCodeConfiguration.XCorrelationId()));
		String userName = portletPreferences.getValue("userName",
				String.valueOf(_viewErrorCodeConfiguration.userName()));
		String password = portletPreferences.getValue("password",
				String.valueOf(_viewErrorCodeConfiguration.password()));
		String getAllLanguages = portletPreferences.getValue("getAllLanguages",
				String.valueOf(_viewErrorCodeConfiguration.getAllLanguages()));

		String allLangs = _errorCodeLocalService.getAllLanguages(getAllLanguages, XCorrelationId, userName, password);
		try {
			originalData = JSONFactoryUtil.createJSONObject(allLangs);
			// JSONArray items = originalData.getJSONArray("body");
			JSONArray jsonItems = originalData.getJSONArray("body");
			List<LanguageDTO> items = LanguageDTO.fromJSONArray(jsonItems);
			actionRequest.setAttribute("records", items);

			actionRequest.setAttribute("statusCode", statusCode);
			actionRequest.setAttribute("language", language);
			actionRequest.setAttribute("description", description);
			actionRequest.setAttribute("hasPendingVersion", hasPendingVersion);

			actionRequest.setAttribute("myview", "details");

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateErrorCode(ActionRequest actionRequest, ActionResponse actionRespons) throws PortalException, JsonProcessingException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		List<Role> roles = user.getRoles();
		boolean isAdministrator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Administrator"));
		boolean isPo = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("po"));

		if (!isAdministrator && !isPo) {
			SessionErrors.add(actionRequest, "notAuthorized");
			return;
		}
		String statusCode = ParamUtil.getString(actionRequest, "statusCode", "");
		String language = ParamUtil.getString(actionRequest, "language", "");
		String description = ParamUtil.getString(actionRequest, "description", "");

		String oldStatusCode = ParamUtil.getString(actionRequest, "oldStatusCode", "");
		String oldLanguage = ParamUtil.getString(actionRequest, "oldLanguage", "");
		String oldDescription = ParamUtil.getString(actionRequest, "oldDescription", "");

		// Backend validation for pending version
		Set<String> pendingErrorCodeIds = _configurationEntityLocalService.getPendingEntityIdsByType(Constants.ERROR_CODE);
		if (pendingErrorCodeIds.contains(statusCode)) {
			SessionErrors.add(actionRequest, "hasPendingVersion");
			return;
		}

		if (containsXSS(statusCode) || containsXSS(language) || containsXSS(description)) {
			SessionErrors.add(actionRequest, "xssDetected");
			return;
		}
		PortletPreferences portletPreferences = actionRequest.getPreferences();
		String XCorrelationId = portletPreferences.getValue("XCorrelationId",
				String.valueOf(_viewErrorCodeConfiguration.XCorrelationId()));
		String updateErrorCode = portletPreferences.getValue("updateErrorCode",
				String.valueOf(_viewErrorCodeConfiguration.updateErrorCode()));
		 ServiceContext serviceContext = createServiceContextForWorkflow(actionRequest);
		_errorCodeLocalService.updateErrorCode(updateErrorCode, XCorrelationId, statusCode, language, description,
				oldStatusCode, oldLanguage, oldDescription, serviceContext, user);
	}

	public void searchByCode(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		PortletPreferences portletPreferences = actionRequest.getPreferences();
		String XCorrelationId = portletPreferences.getValue("XCorrelationId",
				String.valueOf(_viewErrorCodeConfiguration.XCorrelationId()));
		String userName = portletPreferences.getValue("userName",
				String.valueOf(_viewErrorCodeConfiguration.userName()));
		String password = portletPreferences.getValue("password",
				String.valueOf(_viewErrorCodeConfiguration.password()));
		String searchByCode = portletPreferences.getValue("searchByCode",
				String.valueOf(_viewErrorCodeConfiguration.searchByCode()));

		String searchType = ParamUtil.getString(actionRequest, "searchType");
		String searchValue = ParamUtil.getString(actionRequest, "searchName");
		String LangId = ParamUtil.getString(actionRequest, "LangId");

		String codes = _errorCodeLocalService.searchBycodeAndDesc(searchByCode, searchType, searchValue, LangId,
				XCorrelationId, userName, password);
		JSONObject originalData;
		try {
			JSONArray itemsList = JSONFactoryUtil.createJSONArray();
			
			originalData = JSONFactoryUtil.createJSONObject(codes);
			JSONObject jsonItems = originalData.getJSONObject("body");
			
			//ErrorCodeDTO item = ErrorCodeDTO.toDTO(jsonItems);
			itemsList.put(jsonItems);
			List<ErrorCodeDTO> items = ErrorCodeDTO.fromJSONArray(itemsList);
			
			actionRequest.setAttribute("search", items);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private ServiceContext createServiceContextForWorkflow(ActionRequest actionRequest) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ConfigurationEntity.class.getName(), actionRequest);
		serviceContext.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH);
		return serviceContext;
	}

	@Reference
	private ErrorCodeLocalService _errorCodeLocalService;

	@Reference
	private ConfigurationEntityLocalService _configurationEntityLocalService;

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_viewErrorCodeConfiguration = ConfigurableUtil.createConfigurable(ViewErrorCodeConfiguration.class, properties);
	}

	private volatile ViewErrorCodeConfiguration _viewErrorCodeConfiguration;
}
