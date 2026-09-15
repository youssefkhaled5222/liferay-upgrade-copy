package com.ejada.telemoney.otp.events.configuration;

import com.ejada.telemoney.otp.events.constants.TelemoneyOtpEventsPortletKeys;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
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
		configurationPid = "com.ejada.telemoney.otp.events.configuration.OTPConfiguration", 
		configurationPolicy = ConfigurationPolicy.OPTIONAL, 
		immediate = true, 
		property = {
		"javax.portlet.name=" + 
		TelemoneyOtpEventsPortletKeys.TELEMONEYOTPEVENTS 
		},
		service = ConfigurationAction.class)

public class OTPConfigurationAction extends DefaultConfigurationAction {
	
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		
		String getAllOTPEventsURL = ParamUtil.getString(actionRequest, "getAllOTPEventsURL");
		String updateOTPEventURL = ParamUtil.getString(actionRequest, "updateOTPEventURL");
		String XCorrelationId = ParamUtil.getString(actionRequest, "XCorrelationId");
		String requestParam1 = ParamUtil.getString(actionRequest, "requestParam1");
		String requestParam2 = ParamUtil.getString(actionRequest, "requestParam2");
		String requestParam3 = ParamUtil.getString(actionRequest, "requestParam3");
		String requestParam4 = ParamUtil.getString(actionRequest, "requestParam4");
		String userName = ParamUtil.getString(actionRequest, "userName");
		String password = ParamUtil.getString(actionRequest, "password");

		setPreference(actionRequest, "getAllOTPEventsURL", getAllOTPEventsURL);
		setPreference(actionRequest, "updateOTPEventURL", updateOTPEventURL);
		setPreference(actionRequest, "XCorrelationId", XCorrelationId);
		setPreference(actionRequest, "requestParam1", requestParam1);
		setPreference(actionRequest, "requestParam2", requestParam2);
		setPreference(actionRequest, "requestParam3", requestParam3);
		setPreference(actionRequest, "requestParam4", requestParam4);
		setPreference(actionRequest, "userName", userName);
		setPreference(actionRequest, "password", password);
		
		

		super.processAction(portletConfig, actionRequest, actionResponse);
	}
	
	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		httpServletRequest.setAttribute(OTPConfiguration.class.getName(), _OTPConfiguration);
		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_LOG.info("start activate configuration");
		_OTPConfiguration = ConfigurableUtil.createConfigurable(OTPConfiguration.class, properties);
		_LOG.info("finish activate configuration");
	}
	
	private volatile OTPConfiguration _OTPConfiguration;
	private static final Log _LOG = LogFactoryUtil.getLog(OTPConfigurationAction.class);
}
