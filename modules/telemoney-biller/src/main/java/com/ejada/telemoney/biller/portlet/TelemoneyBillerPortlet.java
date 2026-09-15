package com.ejada.telemoney.biller.portlet;

import com.ejada.telemoney.biller.constants.TelemoneyBillerPortletKeys;
import com.ejada.telemony.db.constants.Constants;
import com.ejada.telemony.db.model.ConfigurationEntity;
import com.ejada.telemony.db.service.BillerLocalService;
import com.ejada.telemony.db.service.ConfigurationEntityLocalService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.liferay.item.selector.ItemSelector;
import com.liferay.item.selector.ItemSelectorReturnType;
import com.liferay.item.selector.criteria.URLItemSelectorReturnType;
import com.liferay.item.selector.criteria.image.criterion.ImageItemSelectorCriterion;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
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
import javax.portlet.PortletURL;
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
		"javax.portlet.display-name=TelemoneyBiller", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/viewCategory.jsp",
		"javax.portlet.name=" + TelemoneyBillerPortletKeys.TELEMONEYBILLER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class TelemoneyBillerPortlet extends MVCPortlet {
	
	private static final Pattern XSS_PATTERN = Pattern.compile(".*[<>\"'\\\\].*");

	private boolean containsXSS(String input) {
		return input != null && XSS_PATTERN.matcher(input).find();
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		PortletPreferences portletPreferences = renderRequest.getPreferences();

		/*
		 * String getAllBillers = portletPreferences.getValue("getAllBillers",
		 * String.valueOf(_viewBillerConfiguration.getAllBillers())); String
		 * defaultBillerId = portletPreferences.getValue("defaultBillerId",
		 * String.valueOf(_viewBillerConfiguration.defaultBillerId())); String
		 * defaultBillerName = portletPreferences.getValue("defaultBillerName",
		 * String.valueOf(_viewBillerConfiguration.defaultBillerName())); String
		 * defaultBillerCategoryId =
		 * portletPreferences.getValue("defaultBillerCategoryId",
		 * String.valueOf(_viewBillerConfiguration.defaultBillerCategoryId()));
		 */
		
		String getAllBillerCategory = portletPreferences.getValue("getAllBillerCategory",
				String.valueOf(_viewBillerConfiguration.getAllBillerCategory()));
		String personaviewUrl = "/META-INF/resources/viewCategory.jsp";
		renderRequest.setAttribute("personaviewUrl", personaviewUrl);
		String myview = "viewCategory";
		
		JSONObject billerCategoriesOriginalData;

		if (renderRequest.getAttribute("myview") != null && renderRequest.getAttribute("myview") != "viewCategory") {
			myview = (String) renderRequest.getAttribute("myview");
		} else {
			String billerCategories = _billerLocalService.getAllBillerCategory(getAllBillerCategory);

			try {
				billerCategoriesOriginalData = JSONFactoryUtil.createJSONObject(billerCategories);
				JSONArray billerCategoriesJsonItems = billerCategoriesOriginalData.getJSONArray("body");
				List<CategoryDTO> billerCategoriesData = CategoryDTO.fromJSONArray(billerCategoriesJsonItems);
				Set<String> pendingCategoryIds = _configurationEntityLocalService.getPendingEntityIdsByType(Constants.BILLER_CATEGORY);

				renderRequest.setAttribute("records", billerCategoriesData);
				renderRequest.setAttribute("pendingCategoryIds", pendingCategoryIds);

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		String view = "/" + myview + ".jsp";
		renderRequest.setAttribute(ViewBillerConfiguration.class.getName(), _viewBillerConfiguration);
		PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(view);
		dispatcher.include(renderRequest, renderResponse);
	}
	
	public void getBillerByCategory(ActionRequest actionRequest, ActionResponse actionResponse) {
		PortletPreferences portletPreferences = actionRequest.getPreferences();
		String defaultBillerId = portletPreferences.getValue("defaultBillerId",
				String.valueOf(_viewBillerConfiguration.defaultBillerId()));
		String defaultBillerName = portletPreferences.getValue("defaultBillerName",
				String.valueOf(_viewBillerConfiguration.defaultBillerName()));
		String getAllBillers = portletPreferences.getValue("getAllBillers",
				String.valueOf(_viewBillerConfiguration.getAllBillers()));
		String categoryId = ParamUtil.getString(actionRequest, "categoryId","");

		// Receive isCategoryPending from the viewCategory.jsp param (already determined from doView query)
		boolean isCategoryPending = ParamUtil.getBoolean(actionRequest, "isCategoryPending", false);

		// Receive pendingCategoryIds CSV from viewCategory.jsp (already determined from doView query)
		String pendingCategoryIdsCsv = ParamUtil.getString(actionRequest, "pendingCategoryIds", "");

		JSONObject originalData;

		try {
			String Billers = _billerLocalService.getAllBillers(getAllBillers, defaultBillerId, defaultBillerName,
					categoryId);

			originalData = JSONFactoryUtil.createJSONObject(Billers);
			JSONArray jsonItems = originalData.getJSONObject("body").getJSONArray("searchBillerList");
			List<BillerDTO> items = BillerDTO.fromJSONArray(jsonItems);

			// Get pending biller IDs (single query — only for billers)
			Set<String> pendingBillerIds = _configurationEntityLocalService.getPendingEntityIdsByType(Constants.BILLER);


			actionRequest.setAttribute("records", items);
			actionRequest.setAttribute("pendingBillerIds", pendingBillerIds);
			actionRequest.setAttribute("isCategoryPending", isCategoryPending);
			actionRequest.setAttribute("pendingCategoryIdsCsv", pendingCategoryIdsCsv);
			actionRequest.setAttribute("myview", "view");
			actionRequest.setAttribute("billerCategoryId", categoryId);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void beforeCreateBiller(ActionRequest actionRequest, ActionResponse actionResponse) {
		PortletPreferences portletPreferences = actionRequest.getPreferences();

		String getAllBillerCategory = portletPreferences.getValue("getAllBillerCategory",
				String.valueOf(_viewBillerConfiguration.getAllBillerCategory()));
		String getAllPaymentTypes = portletPreferences.getValue("getAllPaymentTypes",
				String.valueOf(_viewBillerConfiguration.getAllPaymentTypes()));
		String billerCategoryId = ParamUtil.getString(actionRequest, "categoryId");

		// Receive pendingCategoryIds as comma-separated param from view.jsp (already known from getBillerByCategory)
		String pendingCatIdsParam = ParamUtil.getString(actionRequest, "pendingCategoryIds", "");
		Set<String> pendingCategoryIds = new HashSet<>();
		if (!pendingCatIdsParam.isEmpty()) {
			for (String id : pendingCatIdsParam.split(",")) {
				pendingCategoryIds.add(id.trim());
			}
		}

		String billerCategories = _billerLocalService.getAllBillerCategory(getAllBillerCategory);
		String paymentTypes = _billerLocalService.getAllPaymentType(getAllPaymentTypes);
		JSONObject originalData;
		JSONObject billerCategoriesOriginalData;
		try {
			originalData = JSONFactoryUtil.createJSONObject(paymentTypes);
			JSONArray jsonItems = originalData.getJSONArray("body");
			List<PaymentTypeDTO> paymentTypesData = PaymentTypeDTO.fromJSONArray(jsonItems);

			billerCategoriesOriginalData = JSONFactoryUtil.createJSONObject(billerCategories);
			JSONArray billerCategoriesJsonItems = billerCategoriesOriginalData.getJSONArray("body");
			List<CategoryDTO> billerCategoriesData = CategoryDTO.fromJSONArray(billerCategoriesJsonItems);

			// Filter out pending categories using the passed set
			List<CategoryDTO> filteredCategories = new ArrayList<>();
			for (CategoryDTO category : billerCategoriesData) {
				String categoryIdStr = String.valueOf(category.getCategoryId());
				if (!pendingCategoryIds.contains(categoryIdStr)) {
					filteredCategories.add(category);
				}
			}

			RequestBackedPortletURLFactory requestBackedPortletURLFactory = RequestBackedPortletURLFactoryUtil.create(actionRequest);

			List<ItemSelectorReturnType> desiredItemSelectorReturnTypes = new ArrayList<ItemSelectorReturnType>();
			desiredItemSelectorReturnTypes.add(new URLItemSelectorReturnType());

			ImageItemSelectorCriterion imageItemSelectorCriterion = new  ImageItemSelectorCriterion();
			imageItemSelectorCriterion.setDesiredItemSelectorReturnTypes(desiredItemSelectorReturnTypes);

			PortletURL itemSelectorURL = _itemSelector.getItemSelectorURL(
					requestBackedPortletURLFactory, "selectedItemChange", imageItemSelectorCriterion);

			actionRequest.setAttribute("itemSelectorURL", itemSelectorURL.toString());
			actionRequest.setAttribute("paymentTypes", paymentTypesData);
			actionRequest.setAttribute("billerCategories", filteredCategories);
			actionRequest.setAttribute("billerCategoryId", billerCategoryId);
			actionRequest.setAttribute("pendingCategoryIds", pendingCategoryIds);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		actionRequest.setAttribute("myview", "add");
	}

	public void addBiller(ActionRequest actionRequest, ActionResponse actionRespons) throws PortalException, JsonProcessingException {
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

		String addBillerUrl = portletPreferences.getValue("addBiller",
				String.valueOf(_viewBillerConfiguration.addBiller()));
		String billerCategoryId = ParamUtil.getString(actionRequest, "billerCategoryId");
		String postpaidcode = ParamUtil.getString(actionRequest, "postpaidcode");
		String prepaidcode = ParamUtil.getString(actionRequest, "prepaidcode");
		String billerNameEnglish = ParamUtil.getString(actionRequest, "billerNameEnglish");
		String billerNameArabic = ParamUtil.getString(actionRequest, "billerNameArabic");
		String paymentTypeId = ParamUtil.getString(actionRequest, "paymentType");
		String labelNameEnglish = ParamUtil.getString(actionRequest, "labelNameEnglish");
		String labelNameArabic = ParamUtil.getString(actionRequest, "labelNameArabic");
		String allowFixedValues = ParamUtil.getString(actionRequest, "allowFixedValues");
		double paymentMinAmount = ParamUtil.getDouble(actionRequest, "paymentMinAmount");
		double paymentMaxAmount = ParamUtil.getDouble(actionRequest, "paymentMaxAmount");
		String photoLink = ParamUtil.getString(actionRequest, "photoLink");
		String allowedPaymentAmount = ParamUtil.getString(actionRequest, "allowedPaymentAmount");
		if (containsXSS(billerCategoryId) || containsXSS(postpaidcode) || containsXSS(prepaidcode)
				|| containsXSS(billerNameEnglish) || containsXSS(billerNameArabic) || containsXSS(paymentTypeId)
				|| containsXSS(labelNameEnglish) || containsXSS(labelNameArabic) || containsXSS(allowFixedValues)
				|| containsXSS(photoLink) || containsXSS(allowedPaymentAmount)) {

			SessionErrors.add(actionRequest, "xssDetected");
			return;
		}


		ServiceContext serviceContext = createServiceContextForWorkflow(actionRequest);
		_billerLocalService.addBiller(addBillerUrl, prepaidcode, postpaidcode, billerNameArabic, billerNameEnglish,
				billerCategoryId, labelNameArabic, labelNameEnglish, paymentTypeId, allowFixedValues, paymentMinAmount,
				paymentMaxAmount, allowedPaymentAmount, photoLink,user,serviceContext);
	}

	public void getUpdateData(ActionRequest actionRequest, ActionResponse actionRespons) {
		PortletPreferences portletPreferences = actionRequest.getPreferences();

		String getAllBillersUrl = portletPreferences.getValue("getAllBillers",
				String.valueOf(_viewBillerConfiguration.getAllBillers()));
		
		String billerId = ParamUtil.getString(actionRequest, "billerId","");
		String billerName = ParamUtil.getString(actionRequest, "billerName","");

		// Receive pending flags from view.jsp (already determined from getBillerByCategory query)
		boolean hasPendingVersion = ParamUtil.getBoolean(actionRequest, "hasPendingVersion", false);
		boolean isCategoryPending = ParamUtil.getBoolean(actionRequest, "isCategoryPending", false);

		// Receive pendingCategoryIds as comma-separated param from view.jsp
		String pendingCatIdsParam = ParamUtil.getString(actionRequest, "pendingCategoryIds", "");
		Set<String> pendingCategoryIds = new HashSet<>();
		if (!pendingCatIdsParam.isEmpty()) {
			for (String id : pendingCatIdsParam.split(",")) {
				pendingCategoryIds.add(id.trim());
			}
		}

		String biller = _billerLocalService.searchBiller(getAllBillersUrl, billerId, billerName, "1");

		String getAllBillerCategory = portletPreferences.getValue("getAllBillerCategory",
				String.valueOf(_viewBillerConfiguration.getAllBillerCategory()));
		String getAllPaymentTypes = portletPreferences.getValue("getAllPaymentTypes",
				String.valueOf(_viewBillerConfiguration.getAllPaymentTypes()));

		String billerCategories = _billerLocalService.getAllBillerCategory(getAllBillerCategory);
		
		String paymentTypes = _billerLocalService.getAllPaymentType(getAllPaymentTypes);
		JSONObject originalData;
		JSONObject originalDataBiller;
		JSONObject billerCategoriesOriginalData;
		try {
			originalDataBiller = JSONFactoryUtil.createJSONObject(biller);
			JSONObject jsonItem = originalDataBiller.getJSONObject("body").getJSONArray("searchBillerList").getJSONObject(0);
			BillerDTO item = BillerDTO.toDTO(jsonItem);

			// Pass flags to JSP — no extra DB queries needed
			actionRequest.setAttribute("hasPendingVersion", hasPendingVersion || isCategoryPending);
			actionRequest.setAttribute("isCategoryPending", isCategoryPending);

			actionRequest.setAttribute("id", item.getId());
			actionRequest.setAttribute("prePaidCode", item.getPrepaidCode());
			actionRequest.setAttribute("postPaidCode", item.getPostpaidCode());
			actionRequest.setAttribute("billerNameAr", item.getBillerNameAr());
			actionRequest.setAttribute("billerNameEn", item.getBillerNameEn());
			actionRequest.setAttribute("billerCategoryId", item.getBillerCategoryId());
			actionRequest.setAttribute("billerCategoryNameEn", item.getCategoryNameEn());
			actionRequest.setAttribute("labelNameAr", item.getLabelNameAr());
			actionRequest.setAttribute("labelNameEn", item.getLabelNameEn());
			actionRequest.setAttribute("payementTypeId", fetchPaymentType( item.getPrepaidCode(),  item.getPostpaidCode()));
			actionRequest.setAttribute("allowedFixedValues", item.getAllowedFixedValues());
			actionRequest.setAttribute("paymentMinAmount", item.getPaymentMinAmount());
			actionRequest.setAttribute("paymentMaxAmount", item.getPaymentMaxAmount());
			String allowedPaymentAmounts = _billerLocalService.convertListToString(item.getAllowedPaymentAmounts());
			actionRequest.setAttribute("allowedPaymentAmounts", allowedPaymentAmounts);
			actionRequest.setAttribute("photoLink", item.getPhotoLink());

			originalData = JSONFactoryUtil.createJSONObject(paymentTypes);
			JSONArray jsonItems = originalData.getJSONArray("body");
			List<PaymentTypeDTO> paymentTypesData = PaymentTypeDTO.fromJSONArray(jsonItems);

			billerCategoriesOriginalData = JSONFactoryUtil.createJSONObject(billerCategories);
			JSONArray billerCategoriesJsonItems = billerCategoriesOriginalData.getJSONArray("body");
			List<CategoryDTO> billerCategoriesData = CategoryDTO.fromJSONArray(billerCategoriesJsonItems);

			// Filter out pending categories from the dropdown (except the current one)
			String currentCategoryId = item.getBillerCategoryId();
			List<CategoryDTO> filteredCategories = new ArrayList<>();
			for (CategoryDTO category : billerCategoriesData) {
				String categoryIdStr = String.valueOf(category.getCategoryId());
				if (!pendingCategoryIds.contains(categoryIdStr) || categoryIdStr.equals(currentCategoryId)) {
					filteredCategories.add(category);
				}
			}

			RequestBackedPortletURLFactory requestBackedPortletURLFactory = RequestBackedPortletURLFactoryUtil.create(actionRequest);

			List<ItemSelectorReturnType> desiredItemSelectorReturnTypes = new ArrayList<ItemSelectorReturnType>();
			desiredItemSelectorReturnTypes.add(new URLItemSelectorReturnType());

			ImageItemSelectorCriterion imageItemSelectorCriterion = new  ImageItemSelectorCriterion();
			imageItemSelectorCriterion.setDesiredItemSelectorReturnTypes(desiredItemSelectorReturnTypes);

			PortletURL itemSelectorURL = _itemSelector.getItemSelectorURL(
					requestBackedPortletURLFactory, "selectedItemChange", imageItemSelectorCriterion);

			actionRequest.setAttribute("itemSelectorURL", itemSelectorURL.toString());
			actionRequest.setAttribute("paymentTypes", paymentTypesData);
			actionRequest.setAttribute("billerCategories", filteredCategories);
			actionRequest.setAttribute("pendingCategoryIds", pendingCategoryIds);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		actionRequest.setAttribute("myview", "update");
	}


	public void updateBiller(ActionRequest actionRequest, ActionResponse actionRespons) throws PortalException, JsonProcessingException {
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

		String updateBillerUrl = portletPreferences.getValue("updateBiller",
				String.valueOf(_viewBillerConfiguration.updateBiller()));

		// New values
		String id = ParamUtil.getString(actionRequest, "id", "");
		String prePaidCode = ParamUtil.getString(actionRequest, "prepaidcode", "");
		String postPaidCode = ParamUtil.getString(actionRequest, "postpaidcode", "");
		String billerNameAr = ParamUtil.getString(actionRequest, "billerNameArabic", "");
		String billerNameEn = ParamUtil.getString(actionRequest, "billerNameEnglish", "");
		String billerCategoryId = ParamUtil.getString(actionRequest, "billerCategoryId", "");

		// Check if biller has pending version from backend
		Set<String> pendingBillerIds = _configurationEntityLocalService.getPendingEntityIdsByType(Constants.BILLER);
		if (pendingBillerIds.contains(id)) {
			SessionErrors.add(actionRequest, "hasPendingVersion");
			return;
		}
		String labelNameAr = ParamUtil.getString(actionRequest, "labelNameArabic", "");
		String labelNameEn = ParamUtil.getString(actionRequest, "labelNameEnglish", "");
		String payementTypeId = ParamUtil.getString(actionRequest, "paymentType", "");
		String allowedFixedValues = ParamUtil.getString(actionRequest, "allowFixedValues", "");
		double paymentMinAmount = ParamUtil.getDouble(actionRequest, "paymentMinAmount", 0);
		double paymentMaxAmount = ParamUtil.getDouble(actionRequest, "paymentMaxAmount", 0);
		String allowedPaymentAmounts = ParamUtil.getString(actionRequest, "allowedPaymentAmount", "");
		String photoLink = ParamUtil.getString(actionRequest, "photoLink", "");

		// Old values from hidden fields
		String oldPrePaidCode = ParamUtil.getString(actionRequest, "oldPrepaidcode", "");
		String oldPostPaidCode = ParamUtil.getString(actionRequest, "oldPostpaidcode", "");
		String oldBillerNameAr = ParamUtil.getString(actionRequest, "oldBillerNameArabic", "");
		String oldBillerNameEn = ParamUtil.getString(actionRequest, "oldBillerNameEnglish", "");
		String oldBillerCategoryId = ParamUtil.getString(actionRequest, "oldBillerCategoryId", "");
		String oldLabelNameAr = ParamUtil.getString(actionRequest, "oldLabelNameArabic", "");
		String oldLabelNameEn = ParamUtil.getString(actionRequest, "oldLabelNameEnglish", "");
		String oldPayementTypeId = ParamUtil.getString(actionRequest, "oldPaymentType", "");
		String oldAllowedFixedValues = ParamUtil.getString(actionRequest, "oldAllowFixedValues", "");
		double oldPaymentMinAmount = ParamUtil.getDouble(actionRequest, "oldPaymentMinAmount", 0);
		double oldPaymentMaxAmount = ParamUtil.getDouble(actionRequest, "oldPaymentMaxAmount", 0);
		String oldAllowedPaymentAmounts = ParamUtil.getString(actionRequest, "oldAllowedPaymentAmount", "");
		String oldPhotoLink = ParamUtil.getString(actionRequest, "oldPhotoLink", "");

		if (containsXSS(id) || containsXSS(prePaidCode) || containsXSS(postPaidCode) || containsXSS(billerNameAr)
				|| containsXSS(billerNameEn) || containsXSS(billerCategoryId) || containsXSS(labelNameAr)
				|| containsXSS(labelNameEn) || containsXSS(payementTypeId) || containsXSS(allowedFixedValues)
				|| containsXSS(allowedPaymentAmounts) || containsXSS(photoLink)) {

			SessionErrors.add(actionRequest, "xssDetected");
			return;
		}

		ServiceContext serviceContext = createServiceContextForWorkflow(actionRequest);
		_billerLocalService.updateBiller(updateBillerUrl, id, prePaidCode, postPaidCode, billerNameAr, billerNameEn,
				billerCategoryId, labelNameAr, labelNameEn, payementTypeId, allowedFixedValues, paymentMinAmount,
				paymentMaxAmount, allowedPaymentAmounts, photoLink,
				oldPrePaidCode, oldPostPaidCode, oldBillerNameAr, oldBillerNameEn, oldBillerCategoryId,
				oldLabelNameAr, oldLabelNameEn, oldPayementTypeId, oldAllowedFixedValues, oldPaymentMinAmount,
				oldPaymentMaxAmount, oldAllowedPaymentAmounts, oldPhotoLink,
				user, serviceContext);
	}

	public void deleteBiller(ActionRequest actionRequest, ActionResponse actionRespons) {
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

		String billerId = ParamUtil.getString(actionRequest, "billerDeleteId", "");
		String prePaidCode = ParamUtil.getString(actionRequest, "deletePrePaidCode", "");
		String postPaidCode = ParamUtil.getString(actionRequest, "deletePostPaidCode", "");
		String billerNameAr = ParamUtil.getString(actionRequest, "deleteBillerNameAr", "");
		String billerNameEn = ParamUtil.getString(actionRequest, "deleteBillerNameEn", "");
		String billerCategoryId = ParamUtil.getString(actionRequest, "deleteBillerCategoryId", "");
		String labelNameAr = ParamUtil.getString(actionRequest, "deleteLabelNameAr", "");
		String labelNameEn = ParamUtil.getString(actionRequest, "deleteLabelNameEn", "");
		String paymentTypeId = ParamUtil.getString(actionRequest, "deletePaymentTypeId", "");
		String allowedFixedValues = ParamUtil.getString(actionRequest, "deleteAllowedFixedValues", "");
		double paymentMinAmount = ParamUtil.getDouble(actionRequest, "deletePaymentMinAmount", 0);
		double paymentMaxAmount = ParamUtil.getDouble(actionRequest, "deletePaymentMaxAmount", 0);
		String allowedPaymentAmounts = ParamUtil.getString(actionRequest, "deleteAllowedPaymentAmounts", "");
		String photoLink = ParamUtil.getString(actionRequest, "deletePhotoLink", "");

		// Check if biller has pending version
		Set<String> pendingBillerIds = _configurationEntityLocalService.getPendingEntityIdsByType(Constants.BILLER);
		if (pendingBillerIds.contains(billerId)) {
			SessionErrors.add(actionRequest, "hasPendingVersion");
			return;
		}

		String deleteBillerUrl = portletPreferences.getValue("deleteBiller",
				String.valueOf(_viewBillerConfiguration.deleteBiller()));

		try {
			ServiceContext serviceContext = createServiceContextForWorkflow(actionRequest);
			_billerLocalService.handleDeleteBillerWorkflow(deleteBillerUrl, billerId, prePaidCode, postPaidCode,
					billerNameAr, billerNameEn, billerCategoryId, labelNameAr, labelNameEn,
					paymentTypeId, allowedFixedValues, paymentMinAmount, paymentMaxAmount,
					allowedPaymentAmounts, photoLink, user, serviceContext);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void beforeCreateCategory(ActionRequest actionRequest, ActionResponse actionRespons) {
		actionRequest.setAttribute("myview", "addCategory");
	}

	public void createBillerCategory(ActionRequest actionRequest, ActionResponse actionRespons) throws PortalException {
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

		String addBillerCategory = portletPreferences.getValue("addBillerCategory",
				String.valueOf(_viewBillerConfiguration.addBillerCategory()));

		String categoryCode = ParamUtil.getString(actionRequest, "categoryCode");
		String categoryNameAr = ParamUtil.getString(actionRequest, "categoryNameAr");
		String categoryNameEn = ParamUtil.getString(actionRequest, "categoryNameEn");
		if (containsXSS(categoryCode) || containsXSS(categoryNameAr) || containsXSS(categoryNameEn)) {
			SessionErrors.add(actionRequest, "xssDetected");
			return;
		}
	 	ServiceContext serviceContext = createServiceContextForWorkflow(actionRequest);
		try {
			 _billerLocalService.createBillerCategory(addBillerCategory, categoryCode,
										categoryNameAr, categoryNameEn,user,serviceContext);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void beforeUpdateCategory(ActionRequest actionRequest, ActionResponse actionRespons) {
		String categoryID = ParamUtil.getString(actionRequest, "categoryID","");
		String categoryNameAr = ParamUtil.getString(actionRequest, "categoryNameAr","");
		String categoryNameEn = ParamUtil.getString(actionRequest, "categoryNameEn","");
		String categoryCode = ParamUtil.getString(actionRequest, "categoryCode","");
		
		// Receive pending flag from viewCategory.jsp param (already determined from doView query)
		boolean hasPendingVersion = ParamUtil.getBoolean(actionRequest, "hasPendingVersion", false);

		actionRequest.setAttribute("categoryID", categoryID);
		actionRequest.setAttribute("categoryNameAr", categoryNameAr);
		actionRequest.setAttribute("categoryNameEn", categoryNameEn);
		actionRequest.setAttribute("categoryCode", categoryCode);
		actionRequest.setAttribute("hasPendingVersion", hasPendingVersion);

		actionRequest.setAttribute("myview", "updateCategory");
	}
	
	public void updateBillerCategory(ActionRequest actionRequest, ActionResponse actionRespons) {
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

		String updateBillerCategory = portletPreferences.getValue("updateBillerCategory",
				String.valueOf(_viewBillerConfiguration.updateBillerCategory()));
		String categoryId = ParamUtil.getString(actionRequest, "catId");

		// Check if category has pending version from backend
		Set<String> pendingCategoryIds = _configurationEntityLocalService.getPendingEntityIdsByType(Constants.BILLER_CATEGORY);
		if (pendingCategoryIds.contains(categoryId)) {
			SessionErrors.add(actionRequest, "hasPendingVersion");
			return;
		}

		String categoryNameAr = ParamUtil.getString(actionRequest, "categoryNameAr");
		String categoryNameEn = ParamUtil.getString(actionRequest, "categoryNameEn");

		// Get old values from hidden fields
		String oldCategoryNameAr = ParamUtil.getString(actionRequest, "oldCategoryNameAr");
		String oldCategoryNameEn = ParamUtil.getString(actionRequest, "oldCategoryNameEn");

		if (containsXSS(categoryId) || containsXSS(categoryNameAr) || containsXSS(categoryNameEn)) {
			SessionErrors.add(actionRequest, "xssDetected");
			actionRequest.setAttribute("myView", "addBillerCategory"); // Adjust this view name if needed
			return;
		}
		try {
			ServiceContext serviceContext = createServiceContextForWorkflow(actionRequest);
			 _billerLocalService.updateBillerCategory(updateBillerCategory, categoryId,
										categoryNameAr, categoryNameEn, oldCategoryNameAr, oldCategoryNameEn, user, serviceContext);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteCategory(ActionRequest actionRequest, ActionResponse actionRespons) {
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

		String categoryID = ParamUtil.getString(actionRequest, "categoryDeleteId", "");
		String categoryNameAr = ParamUtil.getString(actionRequest, "deleteCategoryNameAr", "");
		String categoryNameEn = ParamUtil.getString(actionRequest, "deleteCategoryNameEn", "");
		String categoryCode = ParamUtil.getString(actionRequest, "deleteCategoryCode", "");

		// Check if category has pending version
		Set<String> pendingCategoryIds = _configurationEntityLocalService.getPendingEntityIdsByType(Constants.BILLER_CATEGORY);
		if (pendingCategoryIds.contains(categoryID)) {
			SessionErrors.add(actionRequest, "hasPendingVersion");
			return;
		}

		String deleteBillerCategory = portletPreferences.getValue("deleteBillerCategory",
				String.valueOf(_viewBillerConfiguration.deleteBillerCategory()));

		try {
			ServiceContext serviceContext = createServiceContextForWorkflow(actionRequest);
			_billerLocalService.deleteBillerCategory(deleteBillerCategory, categoryID,
					categoryNameAr, categoryNameEn, categoryCode, user, serviceContext);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String fetchPaymentType(String prePaid, String postPaid) {
	    if (prePaid != null && !prePaid.isEmpty() && (postPaid == null || postPaid.isEmpty())) {
	        return "2";
	    } else if (postPaid != null && !postPaid.isEmpty() && (prePaid == null || prePaid.isEmpty())) {
	        return "1";
	    } else if (prePaid != null && !prePaid.isEmpty() && postPaid != null && !postPaid.isEmpty()) {
	        return "3";
	    } else {
	        return null; // or some other default value if needed
	    }
	}


	@Reference
	private BillerLocalService _billerLocalService;
	
	@Reference
	private ItemSelector _itemSelector;

	@Reference
	private ConfigurationEntityLocalService _configurationEntityLocalService;

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_viewBillerConfiguration = ConfigurableUtil.createConfigurable(ViewBillerConfiguration.class, properties);
	}

	private ServiceContext createServiceContextForWorkflow(ActionRequest actionRequest) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ConfigurationEntity.class.getName(), actionRequest);
		serviceContext.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH);
		return serviceContext;
	}

	private volatile ViewBillerConfiguration _viewBillerConfiguration;
	
}
