package com.ejada.telemoney.otp.events.portlet;

import com.ejada.telemoney.db.dto.OtpRequestDto;
import com.ejada.telemoney.otp.events.DTO.OtpEventDTO;
import com.ejada.telemoney.otp.events.configuration.OTPConfiguration;
import com.ejada.telemoney.otp.events.constants.TelemoneyOtpEventsPortletKeys;
import com.ejada.telemony.db.constants.Constants;
import com.ejada.telemony.db.model.ConfigurationEntity;
import com.ejada.telemony.db.service.ConfigurationEntityLocalService;
import com.ejada.telemony.db.service.OTPLocalService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
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
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.workflow.WorkflowConstants;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

/**
 * @author shathaar
 */
@Component(
	configurationPid = "com.ejada.telemoney.otp.events.configuration.OTPConfiguration",
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=TelemoneyOtpEvents",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TelemoneyOtpEventsPortletKeys.TELEMONEYOTPEVENTS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TelemoneyOtpEventsPortlet extends MVCPortlet {
	private static final Pattern XSS_PATTERN = Pattern.compile(".*[<>\"'\\\\].*");

	private boolean containsXSS(String input) {
		return input != null && XSS_PATTERN.matcher(input).find();
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		renderRequest.setAttribute(OTPConfiguration.class.getName(), _otpConfiguration);

		PortletPreferences portletPreferences = renderRequest.getPreferences();
		String XCorrelationId = portletPreferences.getValue("XCorrelationId",
				String.valueOf(_otpConfiguration.XCorrelationId()));
		String userName = portletPreferences.getValue("userName", String.valueOf(_otpConfiguration.userName()));
		String password = portletPreferences.getValue("password", String.valueOf(_otpConfiguration.password()));
		String getAllOTPEventsURL = portletPreferences.getValue("getAllOTPEventsURL",
				String.valueOf(_otpConfiguration.getAllOTPEventsURL()));
		
		String view = "view";
		if (renderRequest.getAttribute("myview") != null)
			view = (String) renderRequest.getAttribute("myview");
		System.out.println("VIEW: " + view);
		
		if(view.contains("view")) {
			renderRequest.setAttribute("otpEvents", getAllOtpEvents(getAllOTPEventsURL, XCorrelationId, userName, password));

			Set<String> pendingOtpEventIds = _configurationEntityLocalService.getPendingEntityIdsByType(Constants.OTP);
			renderRequest.setAttribute("pendingOtpEventIds", pendingOtpEventIds);
		}

		view = "/" + view + ".jsp";
		PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(view);

		dispatcher.include(renderRequest, renderResponse);
	}
	
	public List<OtpEventDTO> getAllOtpEvents(String portalApiUrl, String XCorrelationId, String userName, String password) {
		List<OtpEventDTO> otpEvents = new ArrayList<>();
		try {
			String otpEventsURL = _otpLocalService.getAllOTPEvents(portalApiUrl, XCorrelationId, userName, password);

			JSONObject jsonObject = JSONFactoryUtil.createJSONObject(otpEventsURL);
            JSONArray eventsList = jsonObject.getJSONObject("body").getJSONArray("OTPEventsList");
            for (int i = 0; i < eventsList.length(); i++) {
                JSONObject event = eventsList.getJSONObject(i);
                OtpEventDTO newObject = new OtpEventDTO();
                newObject.setEventCode(event.getString("eventCode"));
                newObject.setEventReasonAr(event.getString("eventReasonAr"));
                newObject.setEventReasonEn(event.getString("eventReasonEn"));
                newObject.setEventDescription(event.getString("eventDescription"));
                otpEvents.add(newObject);
                
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return otpEvents;
	}
	public void getOtpEventInfoForUpdate(ActionRequest actionRequest, ActionResponse actionResponse) {
		
		String eventCode = ParamUtil.getString(actionRequest, "eventCode", "");
		String eventDescription = ParamUtil.getString(actionRequest, "eventDescription", "");
		String eventReasonAr = ParamUtil.getString(actionRequest, "eventReasonAr", "");
		String eventReasonEn = ParamUtil.getString(actionRequest, "eventReasonEn", "");
		boolean hasPendingVersion = ParamUtil.getBoolean(actionRequest, "hasPendingVersion", false);

		OtpEventDTO otpEventInfo = new OtpEventDTO();
		otpEventInfo.setEventCode(eventCode);
		otpEventInfo.setEventDescription(eventDescription);
		otpEventInfo.setEventReasonAr(eventReasonAr);
		otpEventInfo.setEventReasonEn(eventReasonEn);
		
		
		actionRequest.setAttribute("otpEventInfo", otpEventInfo);
		actionRequest.setAttribute("hasPendingVersion", hasPendingVersion);
		actionRequest.setAttribute("myview", "details");
		
		
	}
	
	public void updateOtpEvent(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, JsonProcessingException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		List<Role> roles = user.getRoles();
		boolean isAdministrator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Administrator"));

		if (!isAdministrator) {
			SessionErrors.add(actionRequest, "notAuthorized");
			return;
		}
		PortletPreferences portletPreferences = actionRequest.getPreferences();
		
		String XCorrelationId = portletPreferences.getValue("XCorrelationId",
				String.valueOf(_otpConfiguration.XCorrelationId()));
		String requestParam1 = portletPreferences.getValue("requestParam1", String.valueOf(_otpConfiguration.requestParam1()));
		String requestParam2 = portletPreferences.getValue("requestParam2", String.valueOf(_otpConfiguration.requestParam2()));
		String requestParam3 = portletPreferences.getValue("requestParam3", String.valueOf(_otpConfiguration.requestParam3()));
		String requestParam4 = portletPreferences.getValue("requestParam4", String.valueOf(_otpConfiguration.requestParam4()));
		String updateOTPEventURL = portletPreferences.getValue("updateOTPEventURL",
				String.valueOf(_otpConfiguration.updateOTPEventURL()));
		
		String eventCode = ParamUtil.getString(actionRequest, "eventCode", "");
		String eventDescription = ParamUtil.getString(actionRequest, "eventDescription", "");
		String eventReasonAr = ParamUtil.getString(actionRequest, "eventReasonAr", "");
		String eventReasonEn = ParamUtil.getString(actionRequest, "eventReasonEn", "");

		String oldEventCode = ParamUtil.getString(actionRequest, "oldEventCode", "");
		String oldEventDescription = ParamUtil.getString(actionRequest, "oldEventDescription", "");
		String oldEventReasonAr = ParamUtil.getString(actionRequest, "oldEventReasonAr", "");
		String oldEventReasonEn = ParamUtil.getString(actionRequest, "oldEventReasonEn", "");

		// Backend validation for pending version
		Set<String> pendingOtpEventIds = _configurationEntityLocalService.getPendingEntityIdsByType(Constants.OTP);
		if (pendingOtpEventIds.contains(eventCode)) {
			SessionErrors.add(actionRequest, "hasPendingVersion");
			return;
		}

		if (containsXSS(eventCode) || containsXSS(eventDescription) ||
				containsXSS(eventReasonAr) || containsXSS(eventReasonEn)) {
				SessionErrors.add(actionRequest, "xssDetected");
				return;
			}



		ServiceContext serviceContext = createServiceContextForWorkflow(actionRequest);
		OtpRequestDto otpRequestDto = createOtpRequestDto(eventCode, eventReasonAr, eventReasonEn, eventDescription);
		OtpRequestDto oldOtpData = createOtpRequestDto(oldEventCode, oldEventReasonAr, oldEventReasonEn, oldEventDescription);
		_otpLocalService.updateOTPEvent(requestParam1,requestParam2,requestParam3,requestParam4,updateOTPEventURL
				,otpRequestDto, oldOtpData,XCorrelationId,serviceContext, user);
	}

	private ServiceContext createServiceContextForWorkflow(ActionRequest actionRequest) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ConfigurationEntity.class.getName(), actionRequest);
		serviceContext.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH);
		return serviceContext;
	}

	private OtpRequestDto createOtpRequestDto(String eventCode, String eventReasonAr, String eventReasonEn, String eventDescription) {
		OtpRequestDto otpRequestDto = new OtpRequestDto();
		otpRequestDto.setEventCode(eventCode);
		otpRequestDto.setEventReasonAr(eventReasonAr);
		otpRequestDto.setEventReasonEn(eventReasonEn);
		otpRequestDto.setEventDescription(eventDescription);
		return otpRequestDto;
	}
	
	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		LOG.info("OTP Events Portlet activate");
		_otpConfiguration = ConfigurableUtil.createConfigurable(OTPConfiguration.class, properties);
	}
	
	private volatile OTPConfiguration _otpConfiguration;
	
	private static final Log LOG = LogFactoryUtil.getLog(TelemoneyOtpEventsPortlet.class);
	
	@Reference
	private OTPLocalService _otpLocalService;

	@Reference
	private ConfigurationEntityLocalService _configurationEntityLocalService;
}
