package com.ejada.telemoney.moi.biller.portlet;

import com.ejada.telemoney.moi.biller.constants.TelemoneyMoiBillerPortletKeys;
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
		configurationPid = "com.ejada.telemoney.moi.biller.portlet.ViewMOIConfiguration", 
		configurationPolicy = ConfigurationPolicy.OPTIONAL, 
		immediate = true, 
		property = {
		"javax.portlet.name=" + TelemoneyMoiBillerPortletKeys.TELEMONEYMOIBILLER },
		service = ConfigurationAction.class)
public class MOIConfigurationAction extends DefaultConfigurationAction{

	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		
		String getMOIService = ParamUtil.getString(actionRequest, "getMOIService");
		String getMOISubService = ParamUtil.getString(actionRequest, "getMOISubService");
		String updateMOIService = ParamUtil.getString(actionRequest, "updateMOIService");
		String updateMOISubService = ParamUtil.getString(actionRequest, "updateMOISubService");
		String deleteMOIService = ParamUtil.getString(actionRequest, "deleteMOIService");
		String deleteMOISubService = ParamUtil.getString(actionRequest, "deleteMOISubService");
		String updateMOIFields = ParamUtil.getString(actionRequest, "updateMOIFields");

		setPreference(actionRequest, "getMOIService", getMOIService);
		setPreference(actionRequest, "getMOISubService", getMOISubService);
		setPreference(actionRequest, "updateMOIService", updateMOIService);
		setPreference(actionRequest, "updateMOISubService", updateMOISubService);
		setPreference(actionRequest, "deleteMOIService", deleteMOIService);
		setPreference(actionRequest, "deleteMOISubService", deleteMOISubService);
		setPreference(actionRequest, "updateMOIFields", updateMOIFields);
		
		

		super.processAction(portletConfig, actionRequest, actionResponse);
	}
	
	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		httpServletRequest.setAttribute(ViewMOIConfiguration.class.getName(), _viewMOIConfiguration);

		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_viewMOIConfiguration = ConfigurableUtil.createConfigurable(ViewMOIConfiguration.class, properties);
	}

	

	private volatile ViewMOIConfiguration _viewMOIConfiguration;

	
}
