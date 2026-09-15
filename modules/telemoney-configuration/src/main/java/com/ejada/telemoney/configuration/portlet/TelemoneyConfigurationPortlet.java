package com.ejada.telemoney.configuration.portlet;

import com.ejada.telemoney.configuration.config.ViewConfigurationConfig;
import com.ejada.telemoney.configuration.constants.TelemoneyConfigurationPortletKeys;
import com.ejada.telemoney.configuration.dto.Configuration;
import com.ejada.telemony.db.constants.Constants;
import com.ejada.telemony.db.model.ConfigurationEntity;
import com.ejada.telemony.db.service.ConfigurationEntityLocalService;
import com.ejada.telemony.db.service.ConfigurationLocalService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
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
@Component(
		configurationPid = "com.ejada.telemoney.configuration.config.ViewConfigurationConfig",
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=category.sample",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=TelemoneyConfiguration",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/view.jsp",
			"javax.portlet.name=" + TelemoneyConfigurationPortletKeys.TELEMONEYCONFIGURATION,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
)
public class TelemoneyConfigurationPortlet extends MVCPortlet {
	private static final Pattern XSS_PATTERN = Pattern.compile(".*[<>\"'\\\\].*");

	private boolean containsXSS(String input) {
	    return input != null && XSS_PATTERN.matcher(input).find();
	}
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		renderRequest.setAttribute(ViewConfigurationConfig.class.getName(), _viewConfigurationConfig);
		
		PortletPreferences portletPreferences = renderRequest.getPreferences();
		String userName = portletPreferences.getValue("userName", String.valueOf(_viewConfigurationConfig.userName()));
		String password = portletPreferences.getValue("password", String.valueOf(_viewConfigurationConfig.password()));
		String configurationURL = portletPreferences.getValue("configurationURL",
				String.valueOf(_viewConfigurationConfig.configurationURL()));
		
		String view = "view";
		if (renderRequest.getAttribute("myview") != null)
			view = (String) renderRequest.getAttribute("myview");

		
		if(view.contains("view")) {
			renderRequest.setAttribute("configurations", getAllConfigurations(configurationURL, userName, password));
			renderRequest.setAttribute("searchValue", null);

			Set<String> pendingConfigurationIds = _configurationEntityLocalService.getPendingEntityIdsByType(Constants.CONFIGURATION);
			renderRequest.setAttribute("pendingConfigurationIds", pendingConfigurationIds);
		}
		else if(view.contains("search")) {
		    view = "view"; // Resetting view to "view"
		}

		
		view = "/" + view + ".jsp";
		PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(view);

		dispatcher.include(renderRequest, renderResponse);
	}
	
	public List<Configuration> getAllConfigurations(String portalApiUrl, String userName, String password) {
		
		List<Configuration> configurations = new ArrayList<>();
		String apiUrl = _configurationLocalService.getAllConfigurations(portalApiUrl, userName, password);
		try {

			JSONObject jsonObject = JSONFactoryUtil.createJSONObject(apiUrl);
            JSONArray configurationList = jsonObject.getJSONObject("body").getJSONArray("configurationList");
            for (int i = 0; i < configurationList.length(); i++) {
                JSONObject configuration = configurationList.getJSONObject(i);
                Configuration newObject = new Configuration();
                newObject.setKey(configuration.getString("key"));
                newObject.setValue(configuration.getString("value"));
                newObject.setType(configuration.getString("type"));
                
                configurations.add(newObject);
                
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return configurations;
	}
	
	public void getConfigurationInfoForUpdate(ActionRequest actionRequest, ActionResponse actionResponse) {
		
		String key = ParamUtil.getString(actionRequest, "key", "");
		String value = ParamUtil.getString(actionRequest, "value", "");
		String type = ParamUtil.getString(actionRequest, "type", "");
		boolean hasPendingVersion = ParamUtil.getBoolean(actionRequest, "hasPendingVersion", false);

		Configuration configurationInfo = new Configuration();
		configurationInfo.setKey(key);
		configurationInfo.setValue(value);
		configurationInfo.setType(type);
		
		
		actionRequest.setAttribute("configurationInfo", configurationInfo);
		actionRequest.setAttribute("hasPendingVersion", hasPendingVersion);
		actionRequest.setAttribute("myview", "details");
		
		
	}
	
	public void updateConfiguration(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, JsonProcessingException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		List<Role> roles = user.getRoles();
		boolean isAdministrator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Administrator"));

		if (!isAdministrator) {
			SessionErrors.add(actionRequest, "notAuthorized");
			return;
		}

		String key = ParamUtil.getString(actionRequest, "key", "");
		String value = ParamUtil.getString(actionRequest, "value", "");
		String oldKey = ParamUtil.getString(actionRequest, "oldKey", "");
		String oldValue = ParamUtil.getString(actionRequest, "oldValue", "");

		// Backend validation for pending version
		Set<String> pendingConfigurationIds = _configurationEntityLocalService.getPendingEntityIdsByType(Constants.CONFIGURATION);
		if (pendingConfigurationIds.contains(key)) {
			SessionErrors.add(actionRequest, "hasPendingVersion");
			return;
		}

		if (containsXSS(key) || containsXSS(value)) {
			SessionErrors.add(actionRequest, "xssDetected");
			return;
		}

		PortletPreferences portletPreferences = actionRequest.getPreferences();
		String requestParam1 = portletPreferences.getValue("requestParam1", String.valueOf(_viewConfigurationConfig.requestParam1()));
		String requestParam2 = portletPreferences.getValue("requestParam2", String.valueOf(_viewConfigurationConfig.requestParam2()));
		String configurationURL = portletPreferences.getValue("configurationURL",
				String.valueOf(_viewConfigurationConfig.configurationURL()));

		ServiceContext serviceContext = createServiceContextForWorkflow(actionRequest);
		_configurationLocalService.updateConfiguration(requestParam1, requestParam2, configurationURL, key, value,oldKey,oldValue,serviceContext, user);
		
	}
	
	public void searchByTypeOrKey(ActionRequest actionRequest, ActionResponse actionResponse) {
		
		PortletPreferences portletPreferences = actionRequest.getPreferences();
		String userName = portletPreferences.getValue("userName", String.valueOf(_viewConfigurationConfig.userName()));
		String password = portletPreferences.getValue("password", String.valueOf(_viewConfigurationConfig.password()));
		String getConfigurationByKeyURL = portletPreferences.getValue("getConfigurationByKeyURL",
				String.valueOf(_viewConfigurationConfig.getConfigurationByKeyURL()));
		String getConfigurationByTypeURL = portletPreferences.getValue("getConfigurationByTypeURL",
				String.valueOf(_viewConfigurationConfig.getConfigurationByTypeURL()));
		
		String searchValue = ParamUtil.getString(actionRequest, "searchValue", "");
		
		List<Configuration> configurations = new ArrayList<>();
		JSONArray searchResponse = JSONFactoryUtil.createJSONArray();
		String getAllConfigurationByKeyResponse = _configurationLocalService.getAllConfigurations(getConfigurationByKeyURL+searchValue, userName, password);
		String getAllConfigurationByTypeResponse = _configurationLocalService.getAllConfigurations(getConfigurationByTypeURL+searchValue, userName, password);
		
		try {

			JSONObject jsonObject = JSONFactoryUtil.createJSONObject(getAllConfigurationByKeyResponse);
			JSONObject configurationValueByKey = jsonObject.getJSONObject("body");
			if(configurationValueByKey != null)
            	searchResponse.put(configurationValueByKey);
			
			jsonObject = JSONFactoryUtil.createJSONObject(getAllConfigurationByTypeResponse);
			JSONArray configurationListByType = null;
			JSONObject body = jsonObject.getJSONObject("body");
			if (body != null) {
			    configurationListByType = body.getJSONArray("configurationList");
			    if (configurationListByType != null && configurationListByType.length() > 0) {
			        for (int i = 0; i < configurationListByType.length(); i++) {
			            searchResponse.put(configurationListByType.get(i));
			        }
			    }
			}
			
	        for (int i = 0; i < searchResponse.length(); i++) {
                JSONObject configuration = searchResponse.getJSONObject(i);
                Configuration newObject = new Configuration();
                newObject.setKey(configuration.getString("key"));
                newObject.setValue(configuration.getString("value"));
                newObject.setType(configuration.getString("type"));
                System.out.println(newObject);
                
                configurations.add(newObject);
	                
	        }
            
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		actionRequest.setAttribute("configurations", configurations);
		actionRequest.setAttribute("searchValue", searchValue);
		actionRequest.setAttribute("pendingConfigurationIds", _configurationEntityLocalService.getPendingEntityIdsByType(Constants.CONFIGURATION));
		actionRequest.setAttribute("myview", "search");
		
	}

	
	public String sendPutRequest(String url, String requestBody) {
		return requestBody;
	        
        }
	
	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		LOG.info("ConfigurationPortlet activate");
		_viewConfigurationConfig = ConfigurableUtil.createConfigurable(ViewConfigurationConfig.class, properties);
	}

	private ServiceContext createServiceContextForWorkflow(ActionRequest actionRequest) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ConfigurationEntity.class.getName(), actionRequest);
		serviceContext.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH);
		return serviceContext;
	}
	
	@Reference
	private ConfigurationLocalService _configurationLocalService;

	@Reference
	private ConfigurationEntityLocalService _configurationEntityLocalService;

	private static final Log LOG = LogFactoryUtil.getLog(TelemoneyConfigurationPortlet.class);

	private volatile ViewConfigurationConfig _viewConfigurationConfig;
}
