package com.ejada.telemoney.sms.template.portlet;

import com.ejada.telemoney.sms.template.constants.TelemoneySmsTemplatePortletKeys;
import com.ejada.telemony.db.model.ConfigurationEntity;
import com.ejada.telemony.db.service.ConfigurationEntityLocalService;
import com.ejada.telemony.db.service.SMSLocalService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.ejada.telemony.db.constants.Constants;

import java.io.IOException;
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
import javax.portlet.PortletSession;
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

@Component(configurationPid = "com.ejada.telemoney.sms.template.portlet.ViewSMSConfiguration", immediate = true, property = {
		"com.liferay.portlet.display-category=category.sample", "com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=TelemoneySmsTemplate",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TelemoneySmsTemplatePortletKeys.TELEMONEYSMSTEMPLATE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)


public class TelemoneySmsTemplatePortlet extends MVCPortlet {
	private static final Pattern XSS_PATTERN = Pattern.compile(".*[<>\"'\\\\].*");

	private boolean containsXSS(String input) {
		return input != null && XSS_PATTERN.matcher(input).find();
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		PortletPreferences portletPreferences = renderRequest.getPreferences();
		String XCorrelationId = portletPreferences.getValue("XCorrelationId",
				String.valueOf(_viewSMSConfiguration.XCorrelationId()));
		String userName = portletPreferences.getValue("userName", String.valueOf(_viewSMSConfiguration.userName()));
		String password = portletPreferences.getValue("password", String.valueOf(_viewSMSConfiguration.password()));
		String smsURLGetAll = portletPreferences.getValue("smsURLGetAll",
				String.valueOf(_viewSMSConfiguration.smsURLGetAll()));

		String personaviewUrl = "/META-INF/resources/view.jsp";
		renderRequest.setAttribute("personaviewUrl", personaviewUrl);
		String myview = "view";
		// PortletSession pSession = renderRequest.getPortletSession();
		JSONObject originalData;
		if (renderRequest.getAttribute("myview") != null && renderRequest.getAttribute("myview") != "view") {
			myview = (String) renderRequest.getAttribute("myview");
		} else {
			String SMSResponse = _smsLocalService.getAllSMS(smsURLGetAll, XCorrelationId, userName, password);

			try {
				originalData = JSONFactoryUtil.createJSONObject(SMSResponse);
				// JSONArray items = originalData.getJSONArray("body");
				JSONArray jsonItems = originalData.getJSONObject("body").getJSONArray("smsTemplateList");
				List<SMSDTO> items = SMSDTO.fromJSONArray(jsonItems);
				renderRequest.setAttribute("records", items);
				
				Set<String> pendingSmsIds = _configurationEntityLocalService.getPendingEntityIdsByType(Constants.SMS);
				renderRequest.setAttribute("pendingSmsIds", pendingSmsIds);


			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		renderRequest.setAttribute(ViewSMSConfiguration.class.getName(), _viewSMSConfiguration);
		String view = "/" + myview + ".jsp";
		PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(view);
		dispatcher.include(renderRequest, renderResponse);

	}

	public void getSMSviewId(ActionRequest actionRequest, ActionResponse actionRespons) throws PortalException {
		PortletSession pSession = actionRequest.getPortletSession();
		String eventCode = ParamUtil.getString(actionRequest, "eventCode", "");
		String eventDescription = ParamUtil.getString(actionRequest, "eventDescription", "");
		String serviceId = ParamUtil.getString(actionRequest, "serviceId", "");

		actionRequest.setAttribute("eventcode", eventCode);
		actionRequest.setAttribute("eventdescription", eventDescription);
		actionRequest.setAttribute("serviceid", serviceId);

		pSession.setAttribute("LIFERAY_SHARED_SERVICEID", serviceId, PortletSession.APPLICATION_SCOPE);
		pSession.setAttribute("LIFERAY_SHARED_EVENTDESCRIPTION", eventDescription, PortletSession.APPLICATION_SCOPE);

		System.out.println("eventCode : " + eventCode + "/ " + "eventDescription : " + eventDescription + "/ "
				+ "serviceId : " + serviceId);

		actionRequest.setAttribute("myview", "details");
	}

	public void updateSMS(ActionRequest actionRequest, ActionResponse actionRespons) throws PortalException, JsonProcessingException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		List<Role> roles = user.getRoles();
		boolean isAdministrator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Administrator"));

		if (!isAdministrator) {
			SessionErrors.add(actionRequest, "notAuthorized");
			return;
		}
		PortletSession pSession = actionRequest.getPortletSession();

		String oldServiceid = pSession.getAttribute("LIFERAY_SHARED_SERVICEID",
				PortletSession.APPLICATION_SCOPE) != null
						? (String) pSession.getAttribute("LIFERAY_SHARED_SERVICEID", PortletSession.APPLICATION_SCOPE)
						: "";
		String oldEventDescription = pSession.getAttribute("LIFERAY_SHARED_EVENTDESCRIPTION",
				PortletSession.APPLICATION_SCOPE) != null
						? (String) pSession.getAttribute("LIFERAY_SHARED_EVENTDESCRIPTION",
								PortletSession.APPLICATION_SCOPE)
						: "";
		String serviceId = ParamUtil.getString(actionRequest, "serviceId", "");
		String eventCode = ParamUtil.getString(actionRequest, "eventCode", "");
		String eventDescription = ParamUtil.getString(actionRequest, "eventDescription", "");

		// Backend validation for pending version
		Set<String> pendingSmsIds = _configurationEntityLocalService.getPendingEntityIdsByType(Constants.SMS);
		if (pendingSmsIds.contains(eventCode)) {
			SessionErrors.add(actionRequest, "hasPendingVersion");
			return;
		}

		if (containsXSS(serviceId) || containsXSS(eventDescription)) {
			SessionErrors.add(actionRequest, "xssDetected");
			return;
		}
		PortletPreferences portletPreferences = actionRequest.getPreferences();
		String XCorrelationId = portletPreferences.getValue("XCorrelationId",
				String.valueOf(_viewSMSConfiguration.XCorrelationId()));
		String smsURLServiceUpdate = portletPreferences.getValue("smsURLServiceUpdate",
				String.valueOf(_viewSMSConfiguration.smsURLServiceUpdate()));
		String serviceRequestParam1 = portletPreferences.getValue("serviceRequestParam1",
				String.valueOf(_viewSMSConfiguration.serviceRequestParam1()));
		String serviceRequestParam2 = portletPreferences.getValue("serviceRequestParam2",
				String.valueOf(_viewSMSConfiguration.serviceRequestParam2()));
		String descriptionRequestParam1 = portletPreferences.getValue("descriptionRequestParam1",
				String.valueOf(_viewSMSConfiguration.descriptionRequestParam1()));
		String descriptionRequestParam2 = portletPreferences.getValue("descriptionRequestParam2",
				String.valueOf(_viewSMSConfiguration.descriptionRequestParam2()));
		String smsURLDescriptionUpdate = portletPreferences.getValue("smsURLDescriptionUpdate",
				String.valueOf(_viewSMSConfiguration.smsURLDescriptionUpdate()));

		  ServiceContext serviceContext = createServiceContextForWorkflow(actionRequest);
		if (!oldServiceid.equals(serviceId) && !oldEventDescription.equals(eventDescription)) {

			_smsLocalService.updateSMSServiceIdAndDesc(smsURLServiceUpdate,smsURLDescriptionUpdate,oldServiceid,serviceId,serviceRequestParam1,serviceRequestParam2,
					eventDescription,oldEventDescription,descriptionRequestParam1,descriptionRequestParam2,XCorrelationId,eventCode,user,serviceContext);

//			if (serviceIdResponse.equals("500") || serviceIdResponse.equals("400") || descriptionResponse.equals("500")
//					|| descriptionResponse.equals("400")) {
//				SessionErrors.add(actionRequest, "error");
//			}

		} else if (oldServiceid.equals(serviceId) && !oldEventDescription.equals(eventDescription)) {
			 _smsLocalService.updateSMSDescByServiceId(
					smsURLDescriptionUpdate, oldServiceid, eventDescription,oldEventDescription,descriptionRequestParam1,
					descriptionRequestParam2, XCorrelationId,eventCode,user,serviceContext);

//			if (descriptionResponseForDescription.equals("500") || descriptionResponseForDescription.equals("400")) {
//				SessionErrors.add(actionRequest, "error");
//			}

		} else if (!oldServiceid.equals(serviceId) && oldEventDescription.equals(eventDescription)) {
			_smsLocalService.updateSMSServiceId(smsURLServiceUpdate, oldServiceid,
					serviceId, serviceRequestParam1, serviceRequestParam2, XCorrelationId,eventCode, user, serviceContext);

//			if (serviceIdResponseForService.equals("500") || serviceIdResponseForService.equals("400")) {
//				SessionErrors.add(actionRequest, "error");
//			}

		}

		else {
			actionRequest.setAttribute("myview", "view");
		}
	}

	private ServiceContext createServiceContextForWorkflow(ActionRequest actionRequest) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ConfigurationEntity.class.getName(), actionRequest);
		serviceContext.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH);
		return serviceContext;
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_viewSMSConfiguration = ConfigurableUtil.createConfigurable(ViewSMSConfiguration.class, properties);
	}

	@Reference
	private SMSLocalService _smsLocalService;

	@Reference
	private ConfigurationEntityLocalService _configurationEntityLocalService;

	private volatile ViewSMSConfiguration _viewSMSConfiguration;

}
