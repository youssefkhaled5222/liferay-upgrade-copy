package com.ejada.telemoney.noncustomer.list.screen.portlet;

import com.ejada.telemoney.noncustomer.list.screen.constants.TelemoneyNonCustomerListScreenPortletKeys;
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
		configurationPid = "com.ejada.telemoney.noncustomer.list.screen.portlet.ViewNonCustomerConfiguration", 
		configurationPolicy = ConfigurationPolicy.OPTIONAL, 
		immediate = true, 
		property = {
		"javax.portlet.name=" + TelemoneyNonCustomerListScreenPortletKeys.TELEMONEYNONCUSTOMERLISTSCREEN },
		service = ConfigurationAction.class)
public class NonCustomerConfigurationAction extends DefaultConfigurationAction {
	
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		String XCorrelationId = ParamUtil.getString(actionRequest, "XCorrelationId");
		String userName = ParamUtil.getString(actionRequest, "userName");
		String password = ParamUtil.getString(actionRequest, "password");
		String nonCustomerURL = ParamUtil.getString(actionRequest, "nonCustomerURL");
		
		setPreference(actionRequest, "XCorrelationId", XCorrelationId);
		setPreference(actionRequest, "userName", userName);
		setPreference(actionRequest, "password", password);
		setPreference(actionRequest, "nonCustomerURL", nonCustomerURL);
		
		super.processAction(portletConfig, actionRequest, actionResponse);
	}
	
	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		httpServletRequest.setAttribute(ViewNonCustomerConfiguration.class.getName(), _viewNonCustomerConfiguration);

		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_viewNonCustomerConfiguration = ConfigurableUtil.createConfigurable(ViewNonCustomerConfiguration.class, properties);
	}

	

	private volatile ViewNonCustomerConfiguration _viewNonCustomerConfiguration;

	
}
