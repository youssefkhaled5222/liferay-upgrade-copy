package com.ejada.telemoney.telemoney.esb.constant.portlet;

import com.ejada.telemoney.telemoney.esb.constant.constants.TelemoneyEsbConstantPortletKeys;
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

import javax.portlet.PortletPreferences;


@Component(
		configurationPid = "com.ejada.telemoney.telemoney.esb.constant.portlet.ViewESBConfiguration", 
		configurationPolicy = ConfigurationPolicy.OPTIONAL, 
		immediate = true, 
		property = {
		"javax.portlet.name=" + TelemoneyEsbConstantPortletKeys.TELEMONEYESBCONSTANT },
		service = ConfigurationAction.class)
public class ESBConfigurationAction extends DefaultConfigurationAction {
	
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		String esbUrl = ParamUtil.getString(actionRequest, "esbUrl");
		String esbReloadUrl = ParamUtil.getString(actionRequest, "esbReloadUrl");
		String searchUrl = ParamUtil.getString(actionRequest, "searchUrl");
		String XCorrelationId = ParamUtil.getString(actionRequest, "XCorrelationId");
		String entityReloadUrl = ParamUtil.getString(actionRequest, "entityReloadUrl");
		String esbUpdateUrl = ParamUtil.getString(actionRequest, "esbUpdateUrl");
		String userName = ParamUtil.getString(actionRequest, "userName");
		String password = ParamUtil.getString(actionRequest, "password");

		setPreference(actionRequest, "esbUrl", esbUrl);
		setPreference(actionRequest, "esbReloadUrl", esbReloadUrl);
		setPreference(actionRequest, "searchUrl", searchUrl);
		setPreference(actionRequest, "XCorrelationId", XCorrelationId);
		setPreference(actionRequest, "entityReloadUrl", entityReloadUrl);
		setPreference(actionRequest, "esbUpdateUrl", esbUpdateUrl);
		setPreference(actionRequest, "userName", userName);
		setPreference(actionRequest, "password", password);
	
		

		super.processAction(portletConfig, actionRequest, actionResponse);
		
	  

	}
	

	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		httpServletRequest.setAttribute(ViewESBConfiguration.class.getName(), _viewESBConfiguration);

		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_viewESBConfiguration = ConfigurableUtil.createConfigurable(ViewESBConfiguration.class, properties);
		System.out.println("in activate action: "+_viewESBConfiguration.password());
	}

	

	private volatile ViewESBConfiguration _viewESBConfiguration;

	
	

}
