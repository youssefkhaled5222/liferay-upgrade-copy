package com.ejada.telemoney.sms.template.portlet;

import com.ejada.telemoney.sms.template.constants.TelemoneySmsTemplatePortletKeys;
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
		configurationPid = "com.ejada.telemoney.sms.template.portlet.ViewSMSConfiguration", 
		configurationPolicy = ConfigurationPolicy.OPTIONAL, 
		immediate = true, 
		property = {
		"javax.portlet.name=" + TelemoneySmsTemplatePortletKeys.TELEMONEYSMSTEMPLATE },
		service = ConfigurationAction.class)
public class SMSConfigurationAction extends DefaultConfigurationAction {
	
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		String smsURLGetAll = ParamUtil.getString(actionRequest, "smsURLGetAll");
		String smsURLServiceUpdate = ParamUtil.getString(actionRequest, "smsURLServiceUpdate");
		String smsURLDescriptionUpdate = ParamUtil.getString(actionRequest, "smsURLDescriptionUpdate");
		String XCorrelationId = ParamUtil.getString(actionRequest, "XCorrelationId");
		String serviceRequestParam1 = ParamUtil.getString(actionRequest, "serviceRequestParam1");
		String serviceRequestParam2 = ParamUtil.getString(actionRequest, "serviceRequestParam2");
		String descriptionRequestParam1 = ParamUtil.getString(actionRequest, "descriptionRequestParam1");
		String descriptionRequestParam2 = ParamUtil.getString(actionRequest, "descriptionRequestParam2");
		String userName = ParamUtil.getString(actionRequest, "userName");
		String password = ParamUtil.getString(actionRequest, "password");

		setPreference(actionRequest, "smsURLGetAll", smsURLGetAll);
		setPreference(actionRequest, "smsURLServiceUpdate", smsURLServiceUpdate);
		setPreference(actionRequest, "smsURLDescriptionUpdate", smsURLDescriptionUpdate);
		setPreference(actionRequest, "XCorrelationId", XCorrelationId);
		setPreference(actionRequest, "serviceRequestParam1", serviceRequestParam1);
		setPreference(actionRequest, "serviceRequestParam2", serviceRequestParam2);
		setPreference(actionRequest, "descriptionRequestParam1", descriptionRequestParam1);
		setPreference(actionRequest, "descriptionRequestParam2", descriptionRequestParam2);
		setPreference(actionRequest, "userName", userName);
		setPreference(actionRequest, "password", password);
		
		

		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		httpServletRequest.setAttribute(ViewSMSConfiguration.class.getName(), _viewSMSConfiguration);

		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_viewSMSConfiguration = ConfigurableUtil.createConfigurable(ViewSMSConfiguration.class, properties);
	}
	
	

	private volatile ViewSMSConfiguration _viewSMSConfiguration;
}
