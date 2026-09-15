package com.ejada.telemoney.ivr.events.portlet;

import com.ejada.telemoney.db.dto.IvrEventsRequestDto;
import com.ejada.telemoney.ivr.events.configuration.IVRConfiguration;
import com.ejada.telemoney.ivr.events.constants.TelemoneyIvrEventsPortletKeys;
import com.ejada.telemoney.ivr.events.dto.IvrEventObject;
import com.ejada.telemony.db.constants.Constants;
import com.ejada.telemony.db.model.ConfigurationEntity;
import com.ejada.telemony.db.service.ConfigurationEntityLocalService;
import com.ejada.telemony.db.service.IVRLocalService;
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
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=TelemoneyIvrEvents",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TelemoneyIvrEventsPortletKeys.TELEMONEYIVREVENTS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TelemoneyIvrEventsPortlet extends MVCPortlet {
	private static final Pattern XSS_PATTERN = Pattern.compile(".*[<>\"'\\\\].*");

	private boolean containsXSS(String input) {
		return input != null && XSS_PATTERN.matcher(input).find();
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException{
		
		renderRequest.setAttribute(IVRConfiguration.class.getName(), _ivrConfiguration);

		PortletPreferences portletPreferences = renderRequest.getPreferences();
		String XCorrelationId = portletPreferences.getValue("XCorrelationId",
				String.valueOf(_ivrConfiguration.XCorrelationId()));
		String userName = portletPreferences.getValue("userName", String.valueOf(_ivrConfiguration.userName()));
		String password = portletPreferences.getValue("password", String.valueOf(_ivrConfiguration.password()));
		String getAllIVREventsURL = portletPreferences.getValue("getAllIVREventsURL",
				String.valueOf(_ivrConfiguration.getAllIVREventsURL()));
		
		String view = "view";
		if (renderRequest.getAttribute("myview") != null)
			view = (String) renderRequest.getAttribute("myview");
		
		if(view.contains("view")) {
			renderRequest.setAttribute("ivrEvents", getAllIvrEvents(XCorrelationId, userName, password, getAllIVREventsURL));

			Set<String> pendingIvrEventIds = _configurationEntityLocalService.getPendingEntityIdsByType(Constants.IVR);
			renderRequest.setAttribute("pendingIvrEventIds", pendingIvrEventIds);
		}

		view = "/" + view + ".jsp";
		PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(view);

		dispatcher.include(renderRequest, renderResponse);
	}

	public List<IvrEventObject> getAllIvrEvents(String XCorrelationId, String userName, String password, String getAllIVREventsURL) {
		List<IvrEventObject> events = new ArrayList<>();
		String apiUrl = _ivrLocalService.getAllIVREvents(getAllIVREventsURL, XCorrelationId, userName, password);
		try {

			JSONObject jsonObject = JSONFactoryUtil.createJSONObject(apiUrl);
            JSONArray eventsList = jsonObject.getJSONObject("body").getJSONArray("IVREventsList");

            for (int i = 0; i < eventsList.length(); i++) {
                JSONObject event = eventsList.getJSONObject(i);
                IvrEventObject newObject = new IvrEventObject();
                newObject.setEventCode(event.getString("eventCode"));
                newObject.setEventName(event.getString("eventName"));
                newObject.setEventClass(event.getString("eventClass"));
                newObject.setEventSubClass(event.getString("eventSubClass"));
                newObject.setEventVersion(event.getString("eventVersion"));
                newObject.setEventType(event.getString("eventType"));
                newObject.setEventSource(event.getString("eventSource"));
                events.add(newObject);
                
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return events;
	}
	public void getIvrEventInfoForUpdate(ActionRequest actionRequest, ActionResponse actionResponse) {
		
		String eventCode = ParamUtil.getString(actionRequest, "eventCode", "");
		String eventName = ParamUtil.getString(actionRequest, "eventName", "");
		String eventClass = ParamUtil.getString(actionRequest, "eventClass", "");
		String eventSubClass = ParamUtil.getString(actionRequest, "eventSubClass", "");
		String eventVersion = ParamUtil.getString(actionRequest, "eventVersion", "");
		String eventType = ParamUtil.getString(actionRequest, "eventType", "");
		String eventSource = ParamUtil.getString(actionRequest, "eventSource", "");
		boolean hasPendingVersion = ParamUtil.getBoolean(actionRequest, "hasPendingVersion", false);

		
		IvrEventObject ivrEventInfo = new IvrEventObject();
		ivrEventInfo.setEventCode(eventCode);
		ivrEventInfo.setEventName(eventName);
		ivrEventInfo.setEventClass(eventClass);
		ivrEventInfo.setEventSubClass(eventSubClass);
		ivrEventInfo.setEventVersion(eventVersion);
		ivrEventInfo.setEventType(eventType);
		ivrEventInfo.setEventSource(eventSource);	
		
		actionRequest.setAttribute("ivrEventInfo", ivrEventInfo);
		actionRequest.setAttribute("hasPendingVersion", hasPendingVersion);
		actionRequest.setAttribute("myview", "details");
	}
	
	public void updateIvrEvent(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, JsonProcessingException {
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
				String.valueOf(_ivrConfiguration.XCorrelationId()));
		String requestParam1 = portletPreferences.getValue("requestParam1", String.valueOf(_ivrConfiguration.requestParam1()));
		String requestParam2 = portletPreferences.getValue("requestParam2", String.valueOf(_ivrConfiguration.requestParam2()));
		String requestParam3 = portletPreferences.getValue("requestParam3", String.valueOf(_ivrConfiguration.requestParam3()));
		String requestParam4 = portletPreferences.getValue("requestParam4", String.valueOf(_ivrConfiguration.requestParam4()));
		String requestParam5 = portletPreferences.getValue("requestParam5", String.valueOf(_ivrConfiguration.requestParam5()));
		String requestParam6 = portletPreferences.getValue("requestParam6", String.valueOf(_ivrConfiguration.requestParam6()));
		
		String updateIVREventURL = portletPreferences.getValue("updateIVREventURL",
				String.valueOf(_ivrConfiguration.updateIVREventURL()));
		
		String eventCode = ParamUtil.getString(actionRequest, "eventCode", "");
		String eventName = ParamUtil.getString(actionRequest, "eventName", "");
		String eventClass = ParamUtil.getString(actionRequest, "eventClass", "");
		String eventSubClass = ParamUtil.getString(actionRequest, "eventSubClass", "");
		String eventType = ParamUtil.getString(actionRequest, "eventType", "");
		String eventSource = ParamUtil.getString(actionRequest, "eventSource", "");

		String oldEventCode = ParamUtil.getString(actionRequest, "oldEventCode", "");
		String oldEventName = ParamUtil.getString(actionRequest, "oldEventName", "");
		String oldEventClass = ParamUtil.getString(actionRequest, "oldEventClass", "");
		String oldEventSubClass = ParamUtil.getString(actionRequest, "oldEventSubClass", "");
		String oldEventType = ParamUtil.getString(actionRequest, "oldEventType", "");
		String oldEventSource = ParamUtil.getString(actionRequest, "oldEventSource", "");

		// Backend validation for pending version
		Set<String> pendingIvrEventIds = _configurationEntityLocalService.getPendingEntityIdsByType(Constants.IVR);
		if (pendingIvrEventIds.contains(eventCode)) {
			SessionErrors.add(actionRequest, "hasPendingVersion");
			return;
		}

		if (containsXSS(eventCode) || containsXSS(eventName) || containsXSS(eventClass) || containsXSS(eventSubClass)
				|| containsXSS(eventType) || containsXSS(eventSource)) {
			SessionErrors.add(actionRequest, "xssDetected");
			return;
		}

		IvrEventsRequestDto ivrEventRequestDto = createIvrEventsRequestDto(eventCode, eventName, eventClass, eventSubClass, eventType, eventSource);
		IvrEventsRequestDto oldIvrEventData = createIvrEventsRequestDto(oldEventCode, oldEventName, oldEventClass, oldEventSubClass, oldEventType, oldEventSource);
		ServiceContext serviceContext = createServiceContextForWorkflow(actionRequest);
		_ivrLocalService.updateIVREvent(requestParam1, requestParam2, requestParam3, requestParam4, 
				requestParam5, requestParam6, updateIVREventURL, ivrEventRequestDto,oldIvrEventData, XCorrelationId,serviceContext, user);

	}


	private IvrEventsRequestDto createIvrEventsRequestDto(String eventCode, String eventName, String eventClass, String eventSubClass, String eventType, String eventSource) {
		IvrEventsRequestDto dto = new IvrEventsRequestDto();
		dto.setEventCode(eventCode);
		dto.setEventName(eventName);
		dto.setEventClass(eventClass);
		dto.setEventSubClass(eventSubClass);
		dto.setEventType(eventType);
		dto.setEventSource(eventSource);
		return dto;
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
		LOG.info("IVRConfigurationPortlet activate");
		_ivrConfiguration = ConfigurableUtil.createConfigurable(IVRConfiguration.class, properties);
	}
	
	private volatile IVRConfiguration _ivrConfiguration;
	
	private static final Log LOG = LogFactoryUtil.getLog(TelemoneyIvrEventsPortlet.class);
	
	@Reference
	private IVRLocalService _ivrLocalService;

	@Reference
	private ConfigurationEntityLocalService _configurationEntityLocalService;
}
