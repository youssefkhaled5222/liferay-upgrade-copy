package com.ejada.telemoney.error.code.portlet;

import com.ejada.telemoney.error.code.constants.TelemoneyErrorCodePortletKeys;
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
		configurationPid = "com.ejada.telemoney.error.code.portlet.ViewErrorCodeConfiguration", 
		configurationPolicy = ConfigurationPolicy.OPTIONAL, 
		immediate = true, 
		property = {
		"javax.portlet.name=" + TelemoneyErrorCodePortletKeys.TELEMONEYERRORCODE },
		service = ConfigurationAction.class)
public class ErrorCodeConfigurationAction  extends DefaultConfigurationAction{
	
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		String errorCodeUrl = ParamUtil.getString(actionRequest, "errorCodeUrl");
		String updateErrorCode = ParamUtil.getString(actionRequest, "updateErrorCode");
		String getAllLanguages = ParamUtil.getString(actionRequest, "getAllLanguages");
		String XCorrelationId = ParamUtil.getString(actionRequest, "XCorrelationId");
		String searchByCode = ParamUtil.getString(actionRequest, "searchByCode");
		String userName = ParamUtil.getString(actionRequest, "userName");
		String password = ParamUtil.getString(actionRequest, "password");

		setPreference(actionRequest, "errorCodeUrl", errorCodeUrl);
		setPreference(actionRequest, "updateErrorCode", updateErrorCode);
		setPreference(actionRequest, "getAllLanguages", getAllLanguages);
		setPreference(actionRequest, "XCorrelationId", XCorrelationId);
		setPreference(actionRequest, "searchByCode", searchByCode);
		setPreference(actionRequest, "userName", userName);
		setPreference(actionRequest, "password", password);
		
		

		super.processAction(portletConfig, actionRequest, actionResponse);
	}
	
	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		httpServletRequest.setAttribute(ViewErrorCodeConfiguration.class.getName(), _viewErrorCodeConfiguration);

		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_viewErrorCodeConfiguration = ConfigurableUtil.createConfigurable(ViewErrorCodeConfiguration.class, properties);
	}

	

	private volatile ViewErrorCodeConfiguration _viewErrorCodeConfiguration;

	

}
