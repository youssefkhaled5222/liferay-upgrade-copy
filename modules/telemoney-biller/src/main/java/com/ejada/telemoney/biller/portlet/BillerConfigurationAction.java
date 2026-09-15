package com.ejada.telemoney.biller.portlet;

import com.ejada.telemoney.biller.constants.TelemoneyBillerPortletKeys;
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
		configurationPid = "com.ejada.telemoney.biller.portlet.ViewBillerConfiguration", 
		configurationPolicy = ConfigurationPolicy.OPTIONAL, 
		immediate = true, 
		property = {
		"javax.portlet.name=" + TelemoneyBillerPortletKeys.TELEMONEYBILLER },
		service = ConfigurationAction.class)
public class BillerConfigurationAction extends DefaultConfigurationAction{
	
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		String getAllBillers = ParamUtil.getString(actionRequest, "getAllBillers");
		String updateBiller = ParamUtil.getString(actionRequest, "updateBiller");
		String addBiller = ParamUtil.getString(actionRequest, "addBiller");
		String getAllPaymentTypes = ParamUtil.getString(actionRequest, "getAllPaymentTypes");
		String deleteBiller = ParamUtil.getString(actionRequest, "deleteBiller");
		String defaultBillerId = ParamUtil.getString(actionRequest, "defaultBillerId");
		String defaultBillerName = ParamUtil.getString(actionRequest, "defaultBillerName");
		String defaultBillerCategoryId = ParamUtil.getString(actionRequest, "defaultBillerCategoryId");
		String getAllBillerCategory = ParamUtil.getString(actionRequest, "getAllBillerCategory");
		String addBillerCategory = ParamUtil.getString(actionRequest, "addBillerCategory");
		String updateBillerCategory = ParamUtil.getString(actionRequest, "updateBillerCategory");
		String deleteBillerCategory = ParamUtil.getString(actionRequest, "deleteBillerCategory");

		setPreference(actionRequest, "getAllBillers", getAllBillers);
		setPreference(actionRequest, "updateBiller", updateBiller);
		setPreference(actionRequest, "addBiller", addBiller);
		setPreference(actionRequest, "getAllPaymentTypes", getAllPaymentTypes);
		setPreference(actionRequest, "deleteBiller", deleteBiller);
		setPreference(actionRequest, "defaultBillerId", defaultBillerId);
		setPreference(actionRequest, "defaultBillerName", defaultBillerName);
		setPreference(actionRequest, "defaultBillerCategoryId", defaultBillerCategoryId);
		setPreference(actionRequest, "getAllBillerCategory", getAllBillerCategory);
		setPreference(actionRequest, "addBillerCategory", addBillerCategory);
		setPreference(actionRequest, "updateBillerCategory", updateBillerCategory);
		setPreference(actionRequest, "deleteBillerCategory", deleteBillerCategory);
		
		

		super.processAction(portletConfig, actionRequest, actionResponse);
	}
	
	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		httpServletRequest.setAttribute(ViewBillerConfiguration.class.getName(), _viewBillerConfiguration);

		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}
	
	
	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_viewBillerConfiguration = ConfigurableUtil.createConfigurable(ViewBillerConfiguration.class, properties);
	}

	
	private volatile ViewBillerConfiguration _viewBillerConfiguration;

}
