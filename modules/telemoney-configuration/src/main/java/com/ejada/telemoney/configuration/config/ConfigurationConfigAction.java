package com.ejada.telemoney.configuration.config;

import com.ejada.telemoney.configuration.constants.TelemoneyConfigurationPortletKeys;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

@Component(
		configurationPid = "com.ejada.telemoney.configuration.config.ViewConfigurationConfig", 
		configurationPolicy = ConfigurationPolicy.OPTIONAL, 
		immediate = true, 
		property = {
		"javax.portlet.name=" + TelemoneyConfigurationPortletKeys.TELEMONEYCONFIGURATION },
		service = ConfigurationAction.class)

public class ConfigurationConfigAction extends DefaultConfigurationAction {
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		String configurationURL = ParamUtil.getString(actionRequest, "configurationURL");
		String getConfigurationByTypeURL = ParamUtil.getString(actionRequest, "getConfigurationByTypeURL");
		String getConfigurationByKeyURL = ParamUtil.getString(actionRequest, "getConfigurationByKeyURL");
		String XCorrelationId = ParamUtil.getString(actionRequest, "XCorrelationId");
		String requestParam1 = ParamUtil.getString(actionRequest, "requestParam1");
		String requestParam2 = ParamUtil.getString(actionRequest, "requestParam2");
		String userName = ParamUtil.getString(actionRequest, "userName");
		String password = ParamUtil.getString(actionRequest, "password");

		setPreference(actionRequest, "configurationURL", configurationURL);
		setPreference(actionRequest, "getConfigurationByTypeURL", getConfigurationByTypeURL);
		setPreference(actionRequest, "getConfigurationByKeyURL", getConfigurationByKeyURL);
		setPreference(actionRequest, "XCorrelationId", XCorrelationId);
		setPreference(actionRequest, "requestParam1", requestParam1);
		setPreference(actionRequest, "requestParam2", requestParam2);
		setPreference(actionRequest, "userName", userName);
		setPreference(actionRequest, "password", password);

		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		httpServletRequest.setAttribute(ViewConfigurationConfig.class.getName(), _viewConfigurationConfig);

		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_viewConfigurationConfig = ConfigurableUtil.createConfigurable(ViewConfigurationConfig.class, properties);
	}
	
	

	private volatile ViewConfigurationConfig _viewConfigurationConfig;
}
