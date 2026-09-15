package com.ejada.telemoney.telemoney.esb.constant.portlet;

import com.ejada.telemoney.db.dto.EsbConstantRequestDto;
import com.ejada.telemoney.telemoney.esb.constant.constants.TelemoneyEsbConstantPortletKeys;
import com.ejada.telemony.db.constants.Constants;
import com.ejada.telemony.db.model.ConfigurationEntity;
import com.ejada.telemony.db.service.ConfigurationEntityLocalService;
import com.ejada.telemony.db.service.ESBLocalService;
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

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.workflow.WorkflowConstants;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import javax.portlet.PortletPreferences;

/**
 * @author rmostafa
 */
@Component(configurationPid = "com.ejada.telemoney.telemoney.esb.constant.portlet.ViewESBConfiguration", immediate = true, property = {
		"com.liferay.portlet.display-category=category.sample", "com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=TelemoneyEsbConstant",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TelemoneyEsbConstantPortletKeys.TELEMONEYESBCONSTANT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class TelemoneyEsbConstantPortlet extends MVCPortlet {
	private static final Pattern XSS_PATTERN = Pattern.compile(".*[<>\"'\\\\].*");

	private boolean containsXSS(String input) {
	    return input != null && XSS_PATTERN.matcher(input).find();
	}
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		String personaviewUrl = "/META-INF/resources/view.jsp";
		renderRequest.setAttribute("personaviewUrl", personaviewUrl);
		String myview = "view";
		PortletPreferences portletPreferences = renderRequest.getPreferences();
		String XCorrelationId = portletPreferences.getValue("XCorrelationId",
				String.valueOf(_viewESBConfiguration.XCorrelationId()));
		String userName = portletPreferences.getValue("userName", String.valueOf(_viewESBConfiguration.userName()));
		String password = portletPreferences.getValue("password", String.valueOf(_viewESBConfiguration.password()));
		String esbUrl = portletPreferences.getValue("esbUrl", String.valueOf(_viewESBConfiguration.esbUrl()));

		// PortletSession pSession = renderRequest.getPortletSession();
		JSONObject originalData;
		if (renderRequest.getAttribute("myview") != null && renderRequest.getAttribute("myview") != "view") {
			myview = (String) renderRequest.getAttribute("myview");
		} else {
			String ESBResponse = _esbEsbLocalService.getConstantList(esbUrl, XCorrelationId, userName, password);

			System.out.println(password);
			try {
				originalData = JSONFactoryUtil.createJSONObject(ESBResponse);
				// JSONArray items = originalData.getJSONArray("body");
				JSONArray jsonItems = originalData.getJSONArray("ESBConstants");
				List<ESBDTO> items = ESBDTO.fromJSONArray(jsonItems);

				renderRequest.setAttribute("records", items);

				Set<String> pendingEsbConstantIds = _configurationEntityLocalService.getPendingEntityIdsByType(Constants.ESB_CONSTANT);
				renderRequest.setAttribute("pendingEsbConstantIds", pendingEsbConstantIds);

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		String view = "/" + myview + ".jsp";
		renderRequest.setAttribute(ViewESBConfiguration.class.getName(), _viewESBConfiguration);
		PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(view);
		dispatcher.include(renderRequest, renderResponse);

	}

	public void reload(ActionRequest actionRequest, ActionResponse actionResponse) {
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
				String.valueOf(_viewESBConfiguration.XCorrelationId()));
		String userName = portletPreferences.getValue("userName", String.valueOf(_viewESBConfiguration.userName()));
		String password = portletPreferences.getValue("password", String.valueOf(_viewESBConfiguration.password()));
		String esbReloadUrl = portletPreferences.getValue("esbReloadUrl",
				String.valueOf(_viewESBConfiguration.esbReloadUrl()));

		String ESBResponse = _esbEsbLocalService.getESBConstantsReload(esbReloadUrl, XCorrelationId, userName,
				password);

	}

	public void searchInList(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		PortletPreferences portletPreferences = actionRequest.getPreferences();
		String XCorrelationId = portletPreferences.getValue("XCorrelationId",
				String.valueOf(_viewESBConfiguration.XCorrelationId()));
		String userName = portletPreferences.getValue("userName", String.valueOf(_viewESBConfiguration.userName()));
		String password = portletPreferences.getValue("password", String.valueOf(_viewESBConfiguration.password()));
		String searchUrl = portletPreferences.getValue("searchUrl", String.valueOf(_viewESBConfiguration.searchUrl()));

		String searchName = ParamUtil.getString(actionRequest, "search");
		String replacedSentence = searchName.replaceAll(" ", "%20");
		String codes = _esbEsbLocalService.getConstantListSearch(searchUrl, replacedSentence, XCorrelationId, userName,
				password);

		JSONObject originalData;
		try {
			originalData = JSONFactoryUtil.createJSONObject(codes);

			JSONArray jsonItems = JSONFactoryUtil.createJSONArray();
			jsonItems.put(originalData);
			List<ESBDTO> items = ESBDTO.fromJSONArray(jsonItems);
			actionRequest.setAttribute("searchList", items);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void getESBConstantsReloadSearch(ActionRequest actionRequest, ActionResponse actionResponse) {
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
				String.valueOf(_viewESBConfiguration.XCorrelationId()));
		String userName = portletPreferences.getValue("userName", String.valueOf(_viewESBConfiguration.userName()));
		String password = portletPreferences.getValue("password", String.valueOf(_viewESBConfiguration.password()));
		String entityReloadUrl = portletPreferences.getValue("entityReloadUrl",
				String.valueOf(_viewESBConfiguration.entityReloadUrl()));

		String entityServiceName = ParamUtil.getString(actionRequest, "entityServiceName", "");
		String replacedSentence = entityServiceName.replaceAll(" ", "%20");
		String searched = _esbEsbLocalService.getESBConstantsReloadSearch(entityReloadUrl, replacedSentence,
				XCorrelationId, userName, password);
	}

	public void getESBviewId(ActionRequest actionRequest, ActionResponse actionRespons) throws PortalException {

		boolean hasPendingVersion = ParamUtil.getBoolean(actionRequest, "hasPendingVersion", false);

		PortletPreferences portletPreferences = actionRequest.getPreferences();
		String XCorrelationId = portletPreferences.getValue("XCorrelationId",
				String.valueOf(_viewESBConfiguration.XCorrelationId()));
		String userName = portletPreferences.getValue("userName", String.valueOf(_viewESBConfiguration.userName()));
		String password = portletPreferences.getValue("password", String.valueOf(_viewESBConfiguration.password()));
		String searchUrl = portletPreferences.getValue("searchUrl", String.valueOf(_viewESBConfiguration.searchUrl()));

		String serviceName = ParamUtil.getString(actionRequest, "serviceName", "");
		String replacedSentence = serviceName.replaceAll(" ", "%20");

		String codes = _esbEsbLocalService.getConstantListSearch(searchUrl, replacedSentence, XCorrelationId, userName,
				password);

		try {

			JSONObject jsonItem = JSONFactoryUtil.createJSONObject(codes);
			ESBDTO item = ESBDTO.toDTO(jsonItem);

			actionRequest.setAttribute("serviceName", serviceName);
			actionRequest.setAttribute("FuncId", item.getFuncId());
			actionRequest.setAttribute("Ip", item.getIp());
			actionRequest.setAttribute("Port", item.getPort());
			actionRequest.setAttribute("Path", item.getPath());
			actionRequest.setAttribute("SCId", item.getSCId());
			actionRequest.setAttribute("BranchId", item.getBranchId());
			actionRequest.setAttribute("BranchName", item.getBranchName());
			actionRequest.setAttribute("UserId", item.getUserId());
			actionRequest.setAttribute("AgentId", item.getAgentId());
			actionRequest.setAttribute("SecInfo", item.getSecInfo());
			actionRequest.setAttribute("SecInfoType", item.getSecInfoType());
			actionRequest.setAttribute("Version", item.getVersion());
			actionRequest.setAttribute("hasPendingVersion", hasPendingVersion);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		actionRequest.setAttribute("myview", "details");
	}

	public void updateESB(ActionRequest actionRequest, ActionResponse actionRespons) throws PortalException, JsonProcessingException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		List<Role> roles = user.getRoles();
		boolean isAdministrator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Administrator"));

		if (!isAdministrator) {
			SessionErrors.add(actionRequest, "notAuthorized");
			return;
		}
		PortletPreferences portletPreferences = actionRequest.getPreferences();
		String esbUpdateUrl = portletPreferences.getValue("esbUpdateUrl", String.valueOf(_viewESBConfiguration.esbUpdateUrl()));
		
		String serviceName = ParamUtil.getString(actionRequest, "serviceName", "");
		String FuncId = ParamUtil.getString(actionRequest, "FuncId", "");
		String Ip = ParamUtil.getString(actionRequest, "Ip", "");
		String Port = ParamUtil.getString(actionRequest, "Port", "");
		String Path = ParamUtil.getString(actionRequest, "Path", "");
		String SCId = ParamUtil.getString(actionRequest, "SCId", "");
		String BranchId = ParamUtil.getString(actionRequest, "BranchId", "");
		String BranchName = ParamUtil.getString(actionRequest, "BranchName", "");
		String UserId = ParamUtil.getString(actionRequest, "UserId", "");
		String AgentId = ParamUtil.getString(actionRequest, "AgentId", "");
		String SecInfo = ParamUtil.getString(actionRequest, "SecInfo", "");
		String SecInfoType = ParamUtil.getString(actionRequest, "SecInfoType", "");
		String Version = ParamUtil.getString(actionRequest, "Version", "");

		String oldFuncId = ParamUtil.getString(actionRequest, "oldFuncId", "");
		String oldIp = ParamUtil.getString(actionRequest, "oldIp", "");
		String oldPort = ParamUtil.getString(actionRequest, "oldPort", "");
		String oldPath = ParamUtil.getString(actionRequest, "oldPath", "");
		String oldSCId = ParamUtil.getString(actionRequest, "oldSCId", "");
		String oldBranchId = ParamUtil.getString(actionRequest, "oldBranchId", "");
		String oldBranchName = ParamUtil.getString(actionRequest, "oldBranchName", "");
		String oldUserId = ParamUtil.getString(actionRequest, "oldUserId", "");
		String oldAgentId = ParamUtil.getString(actionRequest, "oldAgentId", "");
		String oldSecInfo = ParamUtil.getString(actionRequest, "oldSecInfo", "");
		String oldSecInfoType = ParamUtil.getString(actionRequest, "oldSecInfoType", "");
		String oldVersion = ParamUtil.getString(actionRequest, "oldVersion", "");

		// Backend validation for pending version
		Set<String> pendingEsbConstantIds = _configurationEntityLocalService.getPendingEntityIdsByType(Constants.ESB_CONSTANT);
		if (pendingEsbConstantIds.contains(serviceName)) {
			SessionErrors.add(actionRequest, "hasPendingVersion");
			return;
		}

		if (containsXSS(serviceName) || containsXSS(FuncId) || containsXSS(Ip) || containsXSS(Port) || containsXSS(Path)
				|| containsXSS(SCId) || containsXSS(BranchId) || containsXSS(BranchName) || containsXSS(UserId)
				|| containsXSS(AgentId) || containsXSS(SecInfo) || containsXSS(SecInfoType) || containsXSS(Version)) {

			SessionErrors.add(actionRequest, "xssDetected");
			return;
		}
		String replacedSentence = serviceName.replaceAll(" ", "%20");
		EsbConstantRequestDto newEsbDto = CreateEsbConstantDto(serviceName,replacedSentence, FuncId, Ip, Port, Path, SCId, BranchId, BranchName, UserId, AgentId, SecInfo, SecInfoType, Version);
		EsbConstantRequestDto oldEsbDto = CreateEsbConstantDto(serviceName,replacedSentence, oldFuncId, oldIp, oldPort, oldPath, oldSCId, oldBranchId, oldBranchName, oldUserId, oldAgentId, oldSecInfo, oldSecInfoType, oldVersion);
		ServiceContext serviceContext = createServiceContextForWorkflow(actionRequest);
		_esbEsbLocalService.updateESB(esbUpdateUrl,oldEsbDto,newEsbDto,serviceContext,user);
	}

	private ServiceContext createServiceContextForWorkflow(ActionRequest actionRequest) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ConfigurationEntity.class.getName(), actionRequest);
		serviceContext.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH);
		return serviceContext;
	}
	private EsbConstantRequestDto CreateEsbConstantDto(
			String serviceName, String sanitizedServiceName,String FuncId,String Ip
			,String Port,String Path,String SCId,String BranchId
			,String BranchName,String UserId,String AgentId
			,String SecInfo,String SecInfoType,String Version)
	{
		EsbConstantRequestDto esbConstantRequestDto = new EsbConstantRequestDto();
		esbConstantRequestDto.setServiceName(serviceName);
		esbConstantRequestDto.setSanitizedServiceName(sanitizedServiceName);
		esbConstantRequestDto.setFuncId(FuncId);
		esbConstantRequestDto.setIp(Ip);
		esbConstantRequestDto.setPort(Port);
		esbConstantRequestDto.setPath(Path);
		esbConstantRequestDto.setScId(SCId);
		esbConstantRequestDto.setBranchId(BranchId);
		esbConstantRequestDto.setBranchName(BranchName);
		esbConstantRequestDto.setUserId(UserId);
		esbConstantRequestDto.setAgentId(AgentId);
		esbConstantRequestDto.setSecInfo(SecInfo);
		esbConstantRequestDto.setSecInfoType(SecInfoType);
		esbConstantRequestDto.setVersion(Version);
		return esbConstantRequestDto;

	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_viewESBConfiguration = ConfigurableUtil.createConfigurable(ViewESBConfiguration.class, properties);
		System.out.println("in activate: " + _viewESBConfiguration.password());
	}

	private volatile ViewESBConfiguration _viewESBConfiguration;

	@Reference
	private ESBLocalService _esbEsbLocalService;

	@Reference
	private ConfigurationEntityLocalService _configurationEntityLocalService;
}
