package com.ejada.telemoney.whiteList.configuration;

import com.ejada.telemoney.whiteList.constants.TelemoneyWhiteListPortletKeys;
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
		configurationPid = "com.ejada.telemoney.whiteList.configuration.WhiteListConfiguration", 
		configurationPolicy = ConfigurationPolicy.OPTIONAL, 
		immediate = true, 
		property = {
		"javax.portlet.name=" + 
			TelemoneyWhiteListPortletKeys.TELEMONEYWHITELIST 
		},
		service = ConfigurationAction.class)

public class WhiteListConfigurationAction extends DefaultConfigurationAction{
	
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		
		String getAllWhiteListed = ParamUtil.getString(actionRequest, "getAllWhiteListed");
		String updateWhiteListedStatus = ParamUtil.getString(actionRequest, "updateWhiteListedStatus");
		String XCorrelationId = ParamUtil.getString(actionRequest, "XCorrelationId");
		String defaultPOI = ParamUtil.getString(actionRequest, "defaultPOI");
		
		setPreference(actionRequest, "getAllWhiteListed", getAllWhiteListed);
		setPreference(actionRequest, "updateWhiteListedStatus", updateWhiteListedStatus);
		setPreference(actionRequest, "XCorrelationId", XCorrelationId);
		setPreference(actionRequest, "defaultPOI", defaultPOI);
		
		super.processAction(portletConfig, actionRequest, actionResponse);
		
	}
	
	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		httpServletRequest.setAttribute(WhiteListConfiguration.class.getName(), _whiteListConfiguration);
		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}
	
	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_LOG.info("start activate configuration");
		_whiteListConfiguration = ConfigurableUtil.createConfigurable(WhiteListConfiguration.class, properties);
		_LOG.info("finish activate configuration");
	}
	
	private volatile WhiteListConfiguration _whiteListConfiguration;
	private static final Log _LOG = LogFactoryUtil.getLog(WhiteListConfigurationAction.class);

}
