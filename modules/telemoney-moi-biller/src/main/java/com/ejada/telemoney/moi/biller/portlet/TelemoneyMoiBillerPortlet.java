package com.ejada.telemoney.moi.biller.portlet;

import com.ejada.telemoney.db.domain.model.DropDownDataDTO;
import com.ejada.telemoney.db.domain.model.FieldDTO;
import com.ejada.telemoney.db.domain.model.MoiServiceDTO;
import com.ejada.telemoney.db.domain.model.MoiSubServiceDTO;
import com.ejada.telemoney.moi.biller.constants.TelemoneyMoiBillerPortletKeys;
import com.ejada.telemony.db.constants.Constants;
import com.ejada.telemony.db.model.ConfigurationEntity;
import com.ejada.telemony.db.service.ConfigurationEntityLocalService;
import com.ejada.telemony.db.service.MOILocalService;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=TelemoneyMoiBiller", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TelemoneyMoiBillerPortletKeys.TELEMONEYMOIBILLER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class TelemoneyMoiBillerPortlet extends MVCPortlet {
	private static final Pattern XSS_PATTERN = Pattern.compile(".*[<>\"'\\\\].*");

	private boolean containsXSS(String input) {
		return input != null && XSS_PATTERN.matcher(input).find();
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		PortletSession pSession = renderRequest.getPortletSession();
		PortletPreferences portletPreferences = renderRequest.getPreferences();
		String getMOIService = portletPreferences.getValue("getMOIService",
				String.valueOf(_viewMOIConfiguration.getMOIService()));
		String personaviewUrl = "/META-INF/resources/view.jsp";
		renderRequest.setAttribute("personaviewUrl", personaviewUrl);
		String myview = "view";
		JSONObject originalData;

		String refundType = pSession.getAttribute("LIFERAY_SHARED_RefundType", PortletSession.APPLICATION_SCOPE) != null
				? (String) pSession.getAttribute("LIFERAY_SHARED_RefundType", PortletSession.APPLICATION_SCOPE)
				: "1";
		String languageId = pSession.getAttribute("LIFERAY_SHARED_LanguageId", PortletSession.APPLICATION_SCOPE) != null
				? (String) pSession.getAttribute("LIFERAY_SHARED_LanguageId", PortletSession.APPLICATION_SCOPE)
				: "EN";

		if (renderRequest.getAttribute("myview") != null && renderRequest.getAttribute("myview") != "view") {
			myview = (String) renderRequest.getAttribute("myview");
		} else {
			String moiBillers = refundType.equals("1") ? _moiLocalService.getMOIBiller(getMOIService, "1",languageId)
					: _moiLocalService.getMOIBiller(getMOIService, "2",languageId);
			try {
				originalData = JSONFactoryUtil.createJSONObject(moiBillers);
				JSONArray jsonItems = originalData.getJSONArray("body");
				List<MoiServiceDTO> items = MoiServiceDTO.fromJSONArray(jsonItems);
				Set<String> pendingMoiBillerIds = _configurationEntityLocalService.getPendingEntityIdsByType(Constants.MOI_BILLER);

				renderRequest.setAttribute("records", items);
				renderRequest.setAttribute("pendingMoiBillerIds", pendingMoiBillerIds);


			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		String view = "/" + myview + ".jsp";
		renderRequest.setAttribute(ViewMOIConfiguration.class.getName(), _viewMOIConfiguration);
		renderRequest.setAttribute("refundType", refundType);
		PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(view);
		dispatcher.include(renderRequest, renderResponse);
	}

	public void getRefundType(ActionRequest actionRequest, ActionResponse actionResponse) {
		PortletSession pSession = actionRequest.getPortletSession();
		String refundType = ParamUtil.getString(actionRequest, "refundType");
		pSession.setAttribute("LIFERAY_SHARED_RefundType", refundType, PortletSession.APPLICATION_SCOPE);

	}
	
	public void getLanguageId(ActionRequest actionRequest, ActionResponse actionResponse) {
		PortletSession pSession = actionRequest.getPortletSession();
		String languageId = ParamUtil.getString(actionRequest, "languageId");
		pSession.setAttribute("LIFERAY_SHARED_LanguageId", languageId, PortletSession.APPLICATION_SCOPE);

	}

	public void getUpdateMoiServiceData(ActionRequest actionRequest, ActionResponse actionRespons) {
		String billerId = ParamUtil.getString(actionRequest, "billerId", "");
		String billerCode = ParamUtil.getString(actionRequest, "billerCode", "");
		String billerName = ParamUtil.getString(actionRequest, "billerName", "");
		boolean hasPendingVersion = ParamUtil.getBoolean(actionRequest, "hasPendingVersion", false);

		actionRequest.setAttribute("billerId", billerId);
		actionRequest.setAttribute("billerCode", billerCode);
		actionRequest.setAttribute("billerName", billerName);
		actionRequest.setAttribute("hasPendingVersion", hasPendingVersion);


		actionRequest.setAttribute("myview", "moiBillerDetails");

	}

	public void UpdateMoiService(ActionRequest actionRequest, ActionResponse actionRespons) throws PortalException, JsonProcessingException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		List<Role> roles = user.getRoles();
		boolean isAdministrator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Administrator"));
		boolean isPo = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("po"));

		if (!isAdministrator && !isPo) {
			SessionErrors.add(actionRequest, "notAuthorized");
			return;
		}
		PortletSession pSession = actionRequest.getPortletSession();
		String languageId = pSession.getAttribute("LIFERAY_SHARED_LanguageId", PortletSession.APPLICATION_SCOPE) != null
				? (String) pSession.getAttribute("LIFERAY_SHARED_LanguageId", PortletSession.APPLICATION_SCOPE)
				: "EN";
		PortletPreferences portletPreferences = actionRequest.getPreferences();
		String updateMOIService = portletPreferences.getValue("updateMOIService",
				String.valueOf(_viewMOIConfiguration.updateMOIService()));

		String billerId = ParamUtil.getString(actionRequest, "billerId", "");
		String billerCode = ParamUtil.getString(actionRequest, "billerCode", "");
		String billerName = ParamUtil.getString(actionRequest, "billerName", "");

		String oldBillerId = ParamUtil.getString(actionRequest, "oldBillerId", "");
		String oldBillerCode = ParamUtil.getString(actionRequest, "oldBillerCode", "");
		String oldBillerName = ParamUtil.getString(actionRequest, "oldBillerName", "");

		if (containsXSS(billerId) || containsXSS(billerCode) || containsXSS(billerName) ||
			containsXSS(oldBillerId) || containsXSS(oldBillerCode) || containsXSS(oldBillerName)) {
			SessionErrors.add(actionRequest, "xssDetected");
			return;
		}
		
		Set<String> pendingMoiBillerIds = _configurationEntityLocalService.getPendingEntityIdsByType(Constants.MOI_BILLER);
		if (pendingMoiBillerIds.contains(billerId)) {
			SessionErrors.add(actionRequest, "hasPendingVersion");
			return;
		}

		String refundType = pSession.getAttribute("LIFERAY_SHARED_RefundType", PortletSession.APPLICATION_SCOPE) != null
				? (String) pSession.getAttribute("LIFERAY_SHARED_RefundType", PortletSession.APPLICATION_SCOPE)
				: "1";
		ServiceContext serviceContext = createServiceContextForWorkflow(actionRequest);
		_moiLocalService.handleMOIUpdate(updateMOIService, refundType, billerName, billerCode, billerId, languageId,
				oldBillerId, oldBillerCode, oldBillerName, serviceContext, user);
	}

	public void deleteMoiService(ActionRequest actionRequest, ActionResponse actionRespons) throws PortalException, JsonProcessingException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		List<Role> roles = user.getRoles();
		boolean isAdministrator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Administrator"));
		boolean isPo = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("po"));

		if (!isAdministrator && !isPo) {
			SessionErrors.add(actionRequest, "notAuthorized");
			return;
		}
		PortletPreferences portletPreferences = actionRequest.getPreferences();
		String deleteMOIService = portletPreferences.getValue("deleteMOIService",
				String.valueOf(_viewMOIConfiguration.deleteMOIService()));

		String moiBillerId = ParamUtil.getString(actionRequest, "billerId", "");

		String oldBillerId = ParamUtil.getString(actionRequest, "oldBillerId", "");
		String oldBillerCode = ParamUtil.getString(actionRequest, "oldBillerCode", "");
		String oldBillerName = ParamUtil.getString(actionRequest, "oldBillerName", "");

		// XSS validation
		if (containsXSS(moiBillerId) || containsXSS(oldBillerId) ||
			containsXSS(oldBillerCode) || containsXSS(oldBillerName)) {
			SessionErrors.add(actionRequest, "xssDetected");
			return;
		}

		Set<String> pendingMoiBillerIds = _configurationEntityLocalService.getPendingEntityIdsByType(Constants.MOI_BILLER);
		if (pendingMoiBillerIds.contains(moiBillerId)) {
			SessionErrors.add(actionRequest, "hasPendingVersion");
			return;
		}

		ServiceContext serviceContext = createServiceContextForWorkflow(actionRequest);
		_moiLocalService.handleDeleteMOIBiller(deleteMOIService, moiBillerId, oldBillerId,
				oldBillerCode, oldBillerName, serviceContext, user);
	}

	////////////////////////////  SUB SERVICE \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

	public void openSubService(ActionRequest actionRequest, ActionResponse actionRespons) {
		PortletPreferences portletPreferences = actionRequest.getPreferences();
		PortletSession pSession = actionRequest.getPortletSession();
		
		String languageId = pSession.getAttribute("LIFERAY_SHARED_LanguageId", PortletSession.APPLICATION_SCOPE) != null
				? (String) pSession.getAttribute("LIFERAY_SHARED_LanguageId", PortletSession.APPLICATION_SCOPE)
				: "EN";
		
		String getMOISubService = portletPreferences.getValue("getMOISubService",
				String.valueOf(_viewMOIConfiguration.getMOISubService()));

		String moiServiceId = ParamUtil.getString(actionRequest, "moiServiceId");
		String billerName = ParamUtil.getString(actionRequest, "billerName");
		boolean parentHasPendingVersion = ParamUtil.getBoolean(actionRequest, "parentHasPendingVersion", false);

		String moiSubBillers = _moiLocalService.getMOIBillerService(getMOISubService, moiServiceId,languageId);
		JSONObject originalData;
		try {
			originalData = JSONFactoryUtil.createJSONObject(moiSubBillers);
			JSONArray jsonItems = originalData.getJSONArray("body");
			List<MoiSubServiceDTO> items = MoiSubServiceDTO.fromJSONArray(jsonItems);
			Set<String> pendingMoiServiceIds = _configurationEntityLocalService.getPendingEntityIdsByType(Constants.MOI_SERVICE);


			Map<Integer, List<FieldDTO>> serviceFieldMap = new HashMap<>();
			//Map<Integer, List<DropDownDataDTO>> fieldDropDownMap = new HashMap<>();

			for (MoiSubServiceDTO subService : items) {
				serviceFieldMap.put(subService.getId(), subService.getFieldsData());

				/*
				 * for (FieldDTO field : subService.getFieldsData()) {
				 * fieldDropDownMap.put(field.getId(), field.getDropDownDataDTOs()); }
				 */
			}
			
			pSession.setAttribute("LIFERAY_SHARED_ServiceFieldMap", serviceFieldMap, PortletSession.APPLICATION_SCOPE);
			/*
			 * pSession.setAttribute("LIFERAY_SHARED_FieldDropDownMap", fieldDropDownMap,
			 * PortletSession.APPLICATION_SCOPE);
			 */

			actionRequest.setAttribute("records", items);
			actionRequest.setAttribute("billerName", billerName);
			actionRequest.setAttribute("billerId", moiServiceId);
			actionRequest.setAttribute("parentHasPendingVersion", parentHasPendingVersion);
			actionRequest.setAttribute("pendingMoiServiceIds", pendingMoiServiceIds);



		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		actionRequest.setAttribute("myview", "moiBillerService");

	}

	public void getUpdateMoiSubServiceData(ActionRequest actionRequest, ActionResponse actionRespons) {
		PortletSession pSession = actionRequest.getPortletSession();
		String subServiceId = ParamUtil.getString(actionRequest, "subServiceId", "");
		String subServiceName = ParamUtil.getString(actionRequest, "subServiceName", "");
		String subServiceCode = ParamUtil.getString(actionRequest, "subServiceCode", "");
		String billerName = ParamUtil.getString(actionRequest, "billerName", "");
		String billerId = ParamUtil.getString(actionRequest, "billerId", "");
		boolean parentHasPendingVersion = ParamUtil.getBoolean(actionRequest, "parentHasPendingVersion", false);
		boolean hasPendingVersion = ParamUtil.getBoolean(actionRequest, "hasPendingVersion", false);


		actionRequest.setAttribute("billerName", billerName);
		actionRequest.setAttribute("subServiceId", subServiceId);
		actionRequest.setAttribute("subServiceName", subServiceName);
		actionRequest.setAttribute("subServiceCode", subServiceCode);
		actionRequest.setAttribute("billerId", billerId);
		actionRequest.setAttribute("parentHasPendingVersion", parentHasPendingVersion);
		actionRequest.setAttribute("hasPendingVersion", hasPendingVersion);


		actionRequest.setAttribute("myview", "moiBillersServiceDetails");
	}

	public void UpdateMoiSubService(ActionRequest actionRequest, ActionResponse actionRespons) throws PortalException, JsonProcessingException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		List<Role> roles = user.getRoles();
		boolean isAdministrator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Administrator"));
		boolean isPo = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("po"));

		if (!isAdministrator && !isPo) {
			SessionErrors.add(actionRequest, "notAuthorized");
			return;
		}
		PortletSession pSession = actionRequest.getPortletSession();
		PortletPreferences portletPreferences = actionRequest.getPreferences();
		String updateMOISubService = portletPreferences.getValue("updateMOISubService",
				String.valueOf(_viewMOIConfiguration.updateMOISubService()));
		String languageId = pSession.getAttribute("LIFERAY_SHARED_LanguageId", PortletSession.APPLICATION_SCOPE) != null
				? (String) pSession.getAttribute("LIFERAY_SHARED_LanguageId", PortletSession.APPLICATION_SCOPE)
				: "EN";

		String subServiceId = ParamUtil.getString(actionRequest, "subServiceId", "");
		String subServiceName = ParamUtil.getString(actionRequest, "subServiceName", "");
		String subServiceCode = ParamUtil.getString(actionRequest, "subServiceCode", "");
		String billerName = ParamUtil.getString(actionRequest, "billerName", "");
		String moiServiceId = ParamUtil.getString(actionRequest, "moiServiceId", "");

		String oldSubServiceId = ParamUtil.getString(actionRequest, "oldSubServiceId", "");
		String oldSubServiceName = ParamUtil.getString(actionRequest, "oldSubServiceName", "");
		String oldSubServiceCode = ParamUtil.getString(actionRequest, "oldSubServiceCode", "");
		String oldMoiServiceId = ParamUtil.getString(actionRequest, "oldMoiServiceId", "");

		actionRequest.setAttribute("billerName", billerName);
		actionRequest.setAttribute("moiServiceId", moiServiceId);

		Set<String> pendingMoiServiceIds = _configurationEntityLocalService.getPendingEntityIdsByType(Constants.MOI_SERVICE);
		if (pendingMoiServiceIds.contains(subServiceId)) {
			SessionErrors.add(actionRequest, "hasPendingVersion");
			return;
		}

		ServiceContext serviceContext = createServiceContextForWorkflow(actionRequest);
		_moiLocalService.handleMOIServiceUpdate(updateMOISubService, subServiceId, subServiceName, subServiceCode,
				billerName, languageId, oldSubServiceId, oldSubServiceName, oldSubServiceCode, oldMoiServiceId,
				serviceContext, user);
		openSubService(actionRequest,actionRespons);
	}

	public void deleteMoiSubService(ActionRequest actionRequest, ActionResponse actionRespons) throws PortalException, JsonProcessingException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		List<Role> roles = user.getRoles();
		boolean isAdministrator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Administrator"));
		boolean isPo = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("po"));

		if (!isAdministrator && !isPo) {
			SessionErrors.add(actionRequest, "notAuthorized");
			return;
		}
		PortletPreferences portletPreferences = actionRequest.getPreferences();
		String deleteMOISubService = portletPreferences.getValue("deleteMOISubService",
				String.valueOf(_viewMOIConfiguration.deleteMOISubService()));

		String moiSubBillerId = ParamUtil.getString(actionRequest, "subBillerId", "");
		String oldSubServiceId = ParamUtil.getString(actionRequest, "oldSubServiceId", "");
		String oldSubServiceCode = ParamUtil.getString(actionRequest, "oldSubServiceCode", "");
		String oldSubServiceName = ParamUtil.getString(actionRequest, "oldSubServiceName", "");
		String oldMoiServiceId = ParamUtil.getString(actionRequest, "oldMoiServiceId", "");
		String oldBillerName = ParamUtil.getString(actionRequest, "oldBillerName", "");

		Set<String> pendingMoiServiceIds = _configurationEntityLocalService.getPendingEntityIdsByType(Constants.MOI_SERVICE);
		if (pendingMoiServiceIds.contains(moiSubBillerId)) {
			SessionErrors.add(actionRequest, "hasPendingVersion");
			return;
		}

		ServiceContext serviceContext = createServiceContextForWorkflow(actionRequest);
		_moiLocalService.handleDeleteMOIService(deleteMOISubService, moiSubBillerId, oldSubServiceId,
				oldSubServiceCode, oldSubServiceName, oldMoiServiceId, oldBillerName, serviceContext, user);
		openSubService(actionRequest,actionRespons);
	}

	
	///////////////////////////////////// SUB SERVICE FIELD  \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	public void openSubServiceField(ActionRequest actionRequest, ActionResponse actionResponse) {
		PortletSession pSession = actionRequest.getPortletSession();
		try {
			String billerName = ParamUtil.getString(actionRequest, "billerName", "");
			String serviceName = ParamUtil.getString(actionRequest, "serviceName", "");
			String subServiceId = ParamUtil.getString(actionRequest, "subServiceId", "");
			String billerId = ParamUtil.getString(actionRequest, "billerId", "");
			boolean parentHasPendingVersion = ParamUtil.getBoolean(actionRequest, "parentHasPendingVersion", false);


			Map<Integer, List<FieldDTO>> serviceFieldMap = pSession.getAttribute("LIFERAY_SHARED_ServiceFieldMap",
					PortletSession.APPLICATION_SCOPE) != null
							? (Map<Integer, List<FieldDTO>>) pSession.getAttribute("LIFERAY_SHARED_ServiceFieldMap",
									PortletSession.APPLICATION_SCOPE)
							: new HashMap<Integer, List<FieldDTO>>();
			List<FieldDTO> fields = serviceFieldMap.get(Integer.parseInt(subServiceId));
			Set<String> pendingMoiFieldIds = _configurationEntityLocalService.getPendingEntityIdsByType(Constants.MOI_FIELD);


			actionRequest.setAttribute("fields", fields);
			actionRequest.setAttribute("billerName", billerName);
			actionRequest.setAttribute("subServiceId", subServiceId);
			actionRequest.setAttribute("serviceName", serviceName);
			actionRequest.setAttribute("billerId", billerId);
			actionRequest.setAttribute("parentHasPendingVersion", parentHasPendingVersion);
			actionRequest.setAttribute("pendingMoiFieldIds", pendingMoiFieldIds);


			actionRequest.setAttribute("myview", "moiBillersField");

		} catch (Exception e) {
			// Handle exceptions
			e.printStackTrace();
		}
	}
	
	public void getUpdateFieldData(ActionRequest actionRequest, ActionResponse actionRespons) {
		PortletSession pSession = actionRequest.getPortletSession();
		try {
			Map<Integer, List<DropDownDataDTO>> serviceDropdownMap = new HashMap<Integer, List<DropDownDataDTO>>();
			Map<Integer, List<FieldDTO>> serviceFieldMap = null;
			List<DropDownDataDTO> dropdowns = null;
			String fieldId = ParamUtil.getString(actionRequest, "fieldId", "");
			String fieldCode = ParamUtil.getString(actionRequest, "fieldCode", "");
			String fieldName = ParamUtil.getString(actionRequest, "fieldName", "");
			String fixedValueFlag = ParamUtil.getString(actionRequest, "fixedValueFlag", "");
			String fixedValue = ParamUtil.getString(actionRequest, "fixedValue", "");
			String dateFlag = ParamUtil.getString(actionRequest, "dateFlag", "");
			String dropDownFlag = ParamUtil.getString(actionRequest, "dropDownFlag", "");
			String subServiceId = ParamUtil.getString(actionRequest, "subServiceId", "");
			String subServiceName = ParamUtil.getString(actionRequest, "subServiceName", "");			
			String billerName = ParamUtil.getString(actionRequest, "billerName", "");
			String billerId = ParamUtil.getString(actionRequest, "billerId", "");
			boolean parentHasPendingVersion = ParamUtil.getBoolean(actionRequest, "parentHasPendingVersion", false);


			
			int fieldDetailsId = 0; // default value, assuming 0 means no valid flag is set

			if ("1".equals(fixedValueFlag)) {
				fieldDetailsId = 1;
			} else if ("1".equals(dateFlag)) {
				fieldDetailsId = 2;
			} else if ("1".equals(dropDownFlag)) {
				fieldDetailsId = 3;
			}
			
			if ("1".equals(dropDownFlag)){
				serviceFieldMap = pSession.getAttribute("LIFERAY_SHARED_ServiceFieldMap",
						PortletSession.APPLICATION_SCOPE) != null
								? (Map<Integer, List<FieldDTO>>) pSession.getAttribute("LIFERAY_SHARED_ServiceFieldMap",
										PortletSession.APPLICATION_SCOPE)
								: new HashMap<Integer, List<FieldDTO>>();
				List<FieldDTO> fields = serviceFieldMap.get(Integer.parseInt(subServiceId));
				
				
				  for (FieldDTO field : fields) {
					serviceDropdownMap.put(field.getId(), field.getDropDownDataDTOs());
					}
				 
				 
			
				 dropdowns = serviceDropdownMap.get(Integer.parseInt(fieldId));
				
				
			}
			
			Set<String> pendingDropDownIds = _configurationEntityLocalService.getPendingEntityIdsByType(Constants.MOI_FIELD);
			actionRequest.setAttribute("pendingDropDownIds", pendingDropDownIds);
			actionRequest.setAttribute("subServiceName", subServiceName);
			actionRequest.setAttribute("fieldId", fieldId);
			actionRequest.setAttribute("fieldCode", fieldCode);
			actionRequest.setAttribute("fieldName", fieldName);
			actionRequest.setAttribute("fieldDetailsId", String.valueOf(fieldDetailsId));
			actionRequest.setAttribute("fixedValueFlag", fixedValueFlag);
			actionRequest.setAttribute("fixedValue", fixedValue);
			actionRequest.setAttribute("dateFlag",dateFlag);
			actionRequest.setAttribute("dropDownFlag", dropDownFlag);
			
			actionRequest.setAttribute("subServiceId", subServiceId);
			actionRequest.setAttribute("billerName", billerName);
			actionRequest.setAttribute("billerId", billerId);
			actionRequest.setAttribute("dropdowns", dropdowns);
			actionRequest.setAttribute("parentHasPendingVersion", parentHasPendingVersion);


			
			actionRequest.setAttribute("myview", "moiBillersFieldsDetails");
			
			
		} catch (Exception e) {
			// Handle exceptions
			e.printStackTrace();
		}
	}

	public void updateFieldData(ActionRequest actionRequest, ActionResponse actionRespons) {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		List<Role> roles = user.getRoles();
		boolean isAdministrator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Administrator"));
		boolean isPo = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("po"));

		if (!isAdministrator && !isPo) {
			SessionErrors.add(actionRequest, "notAuthorized");
			return;
		}
		PortletPreferences portletPreferences = actionRequest.getPreferences();
		PortletSession pSession = actionRequest.getPortletSession();
		try {
			Map<Integer, List<DropDownDataDTO>> serviceDropdownMap = new HashMap<Integer, List<DropDownDataDTO>>();
			Map<Integer, List<FieldDTO>> serviceFieldMap = null;
			List<DropDownDataDTO> dropdowns = null;
			
			String updateMOIFields = portletPreferences.getValue("updateMOIFields",
					String.valueOf(_viewMOIConfiguration.updateMOIFields()));
			String subServiceId = ParamUtil.getString(actionRequest, "subServiceId", "");
			String subServiceName = ParamUtil.getString(actionRequest, "subServiceName", "");
			String billerName = ParamUtil.getString(actionRequest, "billerName", "");
			String fieldId = ParamUtil.getString(actionRequest, "fieldId", "");
			String fieldCode = ParamUtil.getString(actionRequest, "fieldCode", "");
			String fieldName = ParamUtil.getString(actionRequest, "fieldName", "");
			String fieldDetailsId = ParamUtil.getString(actionRequest, "fieldDetailsId", "");
			int fieldDetails = Integer.parseInt(fieldDetailsId);
			String fixedValue = ParamUtil.getString(actionRequest, "fixedValue", "");

			// Read old values from hidden inputs
			String oldFieldId = ParamUtil.getString(actionRequest, "oldFieldId", "");
			String oldFieldCode = ParamUtil.getString(actionRequest, "oldFieldCode", "");
			String oldFieldName = ParamUtil.getString(actionRequest, "oldFieldName", "");
			String oldFieldDetailsId = ParamUtil.getString(actionRequest, "oldFieldDetailsId", "");
			String oldFixedValueFlag = ParamUtil.getString(actionRequest, "oldFixedValueFlag", "");
			String oldFixedValue = ParamUtil.getString(actionRequest, "oldFixedValue", "");
			String oldDateFlag = ParamUtil.getString(actionRequest, "oldDateFlag", "");
			String oldDropDownFlag = ParamUtil.getString(actionRequest, "oldDropDownFlag", "");

			if (Stream.of(subServiceId, subServiceName, billerName, fieldId, fieldCode, fieldName, fixedValue)
					.anyMatch(this::containsXSS)) {
				SessionErrors.add(actionRequest, "xssDetected");
				return;
			}
			
			Set<String> pendingMoiFieldIds = _configurationEntityLocalService.getPendingEntityIdsByType(Constants.MOI_FIELD);
			if (pendingMoiFieldIds.contains(fieldId)) {
				SessionErrors.add(actionRequest, "hasPendingVersion");
				return;
			}

			 String fixedValueFlag = "0";
		     String dateFlag = "0";
		     String dropDownFlag = "0";
			
			switch (fieldDetails) {
            case 1:
                fixedValueFlag = "1";
                dateFlag = "0";
                dropDownFlag = "0";
                break;
            case 2:
                fixedValueFlag = "0";
                dateFlag = "1";
                dropDownFlag = "0";
                break;
            case 3:
                fixedValueFlag = "0";
                dateFlag = "0";
                dropDownFlag = "1";
                break;
            default:
                System.out.println("Invalid fieldDetails value");
                break;
			}
			
			if ("1".equals(dropDownFlag)){
				serviceFieldMap = pSession.getAttribute("LIFERAY_SHARED_ServiceFieldMap",
						PortletSession.APPLICATION_SCOPE) != null
								? (Map<Integer, List<FieldDTO>>) pSession.getAttribute("LIFERAY_SHARED_ServiceFieldMap",
										PortletSession.APPLICATION_SCOPE)
								: new HashMap<Integer, List<FieldDTO>>();
				List<FieldDTO> fields = serviceFieldMap.get(Integer.parseInt(subServiceId));
				
				
				  for (FieldDTO field : fields) {
					serviceDropdownMap.put(field.getId(), field.getDropDownDataDTOs());
					}
				 
				 
			
				 dropdowns = serviceDropdownMap.get(Integer.parseInt(fieldId));
				
				
			}

			actionRequest.setAttribute("serviceName", subServiceName);
			actionRequest.setAttribute("subServiceId", subServiceId);
			actionRequest.setAttribute("billerName", billerName);
			
			ServiceContext serviceContext = createServiceContextForWorkflow(actionRequest);
			
			_moiLocalService.handleMOIFieldUpdate(updateMOIFields, fieldId, subServiceId, fieldCode, fieldName,
					Integer.parseInt(fieldDetailsId), Integer.parseInt(fixedValueFlag), fixedValue,
					Integer.parseInt(dateFlag), Integer.parseInt(dropDownFlag), dropdowns,
					oldFieldId, oldFieldCode, oldFieldName, oldFieldDetailsId,
					oldFixedValueFlag, oldFixedValue, oldDateFlag, oldDropDownFlag,
					serviceContext, user);

			openSubServiceField(actionRequest,actionRespons);

		} catch (Exception e) {
			// Handle exceptions
			e.printStackTrace();
		}
		
		
	}
	
	/////////////////////////////////// FIELD DROP DOWN  \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	public void getUpdateFieldAndDropDownData(ActionRequest actionRequest, ActionResponse actionRespons) {
		try {
			
			String fieldId = ParamUtil.getString(actionRequest, "fieldId", "");
			String fieldCode = ParamUtil.getString(actionRequest, "fieldCode", "");
			String fieldName = ParamUtil.getString(actionRequest, "fieldName", "");
			String fixedValueFlag = ParamUtil.getString(actionRequest, "fixedValueFlag", "");
			String fixedValue = ParamUtil.getString(actionRequest, "fixedValue", "");
			String dateFlag = ParamUtil.getString(actionRequest, "dateFlag", "");
			String dropDownFlag = ParamUtil.getString(actionRequest, "dropDownFlag", "");
			String subServiceId = ParamUtil.getString(actionRequest, "subServiceId", "");
			String subServiceName = ParamUtil.getString(actionRequest, "subServiceName", "");
			String billerName = ParamUtil.getString(actionRequest, "billerName", "");
			String billerId = ParamUtil.getString(actionRequest, "billerId", "");
			boolean parentHasPendingVersion = ParamUtil.getBoolean(actionRequest, "parentHasPendingVersion", false);


			int fieldDetailsId = 0; // default value, assuming 0 means no valid flag is set

			if ("1".equals(fixedValueFlag)) {
				fieldDetailsId = 1;
			} else if ("1".equals(dateFlag)) {
				fieldDetailsId = 2;
			} else if ("1".equals(dropDownFlag)) {
				fieldDetailsId = 3;
			}
			
			String id = ParamUtil.getString(actionRequest, "id", "");
			String code = ParamUtil.getString(actionRequest, "code", "");
			String valueAr = ParamUtil.getString(actionRequest, "valueAr", "");
			String valueEn = ParamUtil.getString(actionRequest, "valueEn", "");
			String relatedFieldCode = ParamUtil.getString(actionRequest, "relatedFieldCode", "");
			String relatedFieldId = ParamUtil.getString(actionRequest, "relatedFieldId", "");
			String relatedFieldName = ParamUtil.getString(actionRequest, "relatedFieldName", "");
			String allowedValues = ParamUtil.getString(actionRequest, "allowedValues", "");
			
			Set<String> pendingDropDownIds = _configurationEntityLocalService.getPendingEntityIdsByType(Constants.MOI_FIELD);
			actionRequest.setAttribute("pendingDropDownIds", pendingDropDownIds);
			actionRequest.setAttribute("billerName", billerName);
			actionRequest.setAttribute("subServiceName", subServiceName);
			actionRequest.setAttribute("fieldId", fieldId);
			actionRequest.setAttribute("fieldCode", fieldCode);
			actionRequest.setAttribute("fieldName", fieldName);
			actionRequest.setAttribute("fieldDetailsId", String.valueOf(fieldDetailsId));
			actionRequest.setAttribute("fixedValueFlag", fixedValueFlag);
			actionRequest.setAttribute("fixedValue", fixedValue);
			actionRequest.setAttribute("dateFlag",dateFlag);
			actionRequest.setAttribute("dropDownFlag", dropDownFlag);
			
			actionRequest.setAttribute("subServiceId", subServiceId);
			
			actionRequest.setAttribute("id", id);
			actionRequest.setAttribute("code", code);
			actionRequest.setAttribute("valueAr", valueAr);
			actionRequest.setAttribute("valueEn", valueEn);
			actionRequest.setAttribute("relatedFieldCode", relatedFieldCode);
			actionRequest.setAttribute("relatedFieldId", relatedFieldId);
			actionRequest.setAttribute("relatedFieldName", relatedFieldName);
			actionRequest.setAttribute("allowedValues",allowedValues);
			actionRequest.setAttribute("parentHasPendingVersion", parentHasPendingVersion);


			
			
			
			actionRequest.setAttribute("myview", "dropDownValueDetails");
			
			
		} catch (Exception e) {
			// Handle exceptions
			e.printStackTrace();
		}
	}
	
	public void updateFieldAndDropDownData(ActionRequest actionRequest, ActionResponse actionRespons) {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		List<Role> roles = user.getRoles();
		boolean isAdministrator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Administrator"));
		boolean isPo = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("po"));

		if (!isAdministrator && !isPo) {
			SessionErrors.add(actionRequest, "notAuthorized");
			return;
		}
		PortletPreferences portletPreferences = actionRequest.getPreferences();
		try {
			
			String updateMOIFields = portletPreferences.getValue("updateMOIFields",
					String.valueOf(_viewMOIConfiguration.updateMOIFields()));
			String subServiceId = ParamUtil.getString(actionRequest, "subServiceId", "");
			String fieldId = ParamUtil.getString(actionRequest, "fieldId", "");
			String fieldCode = ParamUtil.getString(actionRequest, "fieldCode", "");
			String fieldName = ParamUtil.getString(actionRequest, "fieldName", "");
			String fieldDetailsId = ParamUtil.getString(actionRequest, "fieldDetailsId", "");
			String dateFlag = ParamUtil.getString(actionRequest, "dateFlag", "");
			String fixedValueFlag = ParamUtil.getString(actionRequest, "fixedValueFlag", "");
			String dropDownFlag = ParamUtil.getString(actionRequest, "dropDownFlag", "");
			String fixedValue = ParamUtil.getString(actionRequest, "fixedValue", "");
			String billerName = ParamUtil.getString(actionRequest, "billerName", "");
			String subServiceName = ParamUtil.getString(actionRequest, "subServiceName", "");
			
			
			String dropDownId = ParamUtil.getString(actionRequest, "id", "");
			String dropDownCode = ParamUtil.getString(actionRequest, "code", "");
			String valueAr = ParamUtil.getString(actionRequest, "valueAr", "");
			String valueEn = ParamUtil.getString(actionRequest, "valueEn", "");
			String relatedFieldCode = ParamUtil.getString(actionRequest, "relatedFieldCode", "");
			String relatedFieldName = ParamUtil.getString(actionRequest, "relatedFieldName", "");
			String relatedFieldId = ParamUtil.getString(actionRequest, "relatedFieldId", "");
			String allowedValues = ParamUtil.getString(actionRequest, "allowedValues", "");

			// Read old values from hidden inputs
			String oldFieldId = ParamUtil.getString(actionRequest, "oldFieldId", "");
			String oldFieldCode = ParamUtil.getString(actionRequest, "oldFieldCode", "");
			String oldFieldName = ParamUtil.getString(actionRequest, "oldFieldName", "");
			String oldFieldDetailsId = ParamUtil.getString(actionRequest, "oldFieldDetailsId", "");
			String oldFixedValueFlag = ParamUtil.getString(actionRequest, "oldFixedValueFlag", "");
			String oldFixedValue = ParamUtil.getString(actionRequest, "oldFixedValue", "");
			String oldDateFlag = ParamUtil.getString(actionRequest, "oldDateFlag", "");
			String oldDropDownFlag = ParamUtil.getString(actionRequest, "oldDropDownFlag", "");
			String oldDropDownId = ParamUtil.getString(actionRequest, "oldDropDownId", "");
			String oldCode = ParamUtil.getString(actionRequest, "oldCode", "");
			String oldValueAr = ParamUtil.getString(actionRequest, "oldValueAr", "");
			String oldValueEn = ParamUtil.getString(actionRequest, "oldValueEn", "");
			String oldRelatedFieldCode = ParamUtil.getString(actionRequest, "oldRelatedFieldCode", "");
			String oldRelatedFieldName = ParamUtil.getString(actionRequest, "oldRelatedFieldName", "");
			String oldRelatedFieldId = ParamUtil.getString(actionRequest, "oldRelatedFieldId", "");
			String oldAllowedValues = ParamUtil.getString(actionRequest, "oldAllowedValues", "");

			if (Stream.of(fieldCode, fieldName, dropDownCode, valueAr, valueEn,
					relatedFieldCode, relatedFieldName).anyMatch(this::containsXSS)) {
				SessionErrors.add(actionRequest, "xssDetected");
				return;
			}
			
			Set<String> pendingMoiFieldIds = _configurationEntityLocalService.getPendingEntityIdsByType(Constants.MOI_FIELD);
			if (pendingMoiFieldIds.contains(fieldId)) {
				SessionErrors.add(actionRequest, "hasPendingVersion");
				return;
			}

			List<Integer> allowedValuesList =allowedValues.isEmpty() ? new ArrayList<>()
					:(Arrays.stream(allowedValues.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));

			List<Integer> oldAllowedValuesList = oldAllowedValues.isEmpty() ? new ArrayList<>()
					:(Arrays.stream(oldAllowedValues.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));

			actionRequest.setAttribute("billerName", billerName);
			actionRequest.setAttribute("subServiceName", subServiceName);
			actionRequest.setAttribute("fieldId", fieldId);
			actionRequest.setAttribute("fieldCode", fieldCode);
			actionRequest.setAttribute("fieldName", fieldName);
			actionRequest.setAttribute("subServiceId", subServiceId);
			actionRequest.setAttribute("fixedValueFlag", fixedValueFlag);
			actionRequest.setAttribute("fixedValue", fixedValue);
			actionRequest.setAttribute("dateFlag",dateFlag);
			actionRequest.setAttribute("dropDownFlag", dropDownFlag);


			ServiceContext serviceContext = createServiceContextForWorkflow(actionRequest);
			_moiLocalService.handleMOIFieldAndDropDownUpdate(updateMOIFields, fieldId, subServiceId, fieldCode, fieldName,
					Integer.parseInt(fieldDetailsId), Integer.parseInt(fixedValueFlag), fixedValue,
					Integer.parseInt(dateFlag), Integer.parseInt(dropDownFlag),Integer.parseInt(dropDownId),dropDownCode,valueAr
					,valueEn,relatedFieldCode,relatedFieldName,relatedFieldId,allowedValuesList,
					oldFieldId, oldFieldCode, oldFieldName, oldFieldDetailsId,
					oldFixedValueFlag, oldFixedValue, oldDateFlag, oldDropDownFlag,
					oldDropDownId, oldCode, oldValueAr, oldValueEn,
					oldRelatedFieldCode, oldRelatedFieldName, oldRelatedFieldId, oldAllowedValuesList,
					serviceContext,user);

			getUpdateFieldData(actionRequest,actionRespons);

		} catch (Exception e) {
			// Handle exceptions
			e.printStackTrace();
		}
		
		
	}

	@Reference
	private MOILocalService _moiLocalService;

	@Reference
	private ConfigurationEntityLocalService _configurationEntityLocalService;

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_viewMOIConfiguration = ConfigurableUtil.createConfigurable(ViewMOIConfiguration.class, properties);
	}
	private ServiceContext createServiceContextForWorkflow(ActionRequest actionRequest) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ConfigurationEntity.class.getName(), actionRequest);
		serviceContext.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH);
		return serviceContext;
	}

	private volatile ViewMOIConfiguration _viewMOIConfiguration;
}
