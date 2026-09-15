package com.ejada.telemoney.localization.portlet;

import com.ejada.telemoney.db.constants.TelemoneyConstants;
import com.ejada.telemoney.db.dto.importDtos.ComponentEntryDto;
import com.ejada.telemoney.db.dto.importDtos.ImportResultDTO;
import com.ejada.telemoney.db.utils.ExportFileUtil;
import com.ejada.telemoney.db.utils.ImportFileUtil;
import com.ejada.telemoney.localization.constants.TelemoneyLocalizationPortletKeys;
import com.ejada.telemoney.localization.utils.FileValidatorUtil;
import com.ejada.telemony.db.constants.Constants;
import com.ejada.telemony.db.model.Feature;
import com.ejada.telemony.db.model.Languages;
import com.ejada.telemony.db.model.Localization;
import com.ejada.telemony.db.model.Persona;
import com.ejada.telemony.db.model.Channels;
import com.ejada.telemony.db.service.FeatureLocalService;
import com.ejada.telemony.db.service.LanguagesLocalService;

import com.ejada.telemony.db.service.LocalizationLocalService;
import com.ejada.telemony.db.service.LocalizationLocalServiceUtil;
import com.ejada.telemony.db.service.UserLogsLocalService;
import com.ejada.telemony.db.service.ChannelsLocalService;
import com.ejada.telemony.db.service.ImportRequestLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.repository.cmis.Session;
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
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author iatef
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=TelemoneyLocalization", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TelemoneyLocalizationPortletKeys.TELEMONEYLOCALIZATION,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class TelemoneyLocalizationPortlet extends MVCPortlet {

	private static final Log LOG = LogFactoryUtil.getLog(TelemoneyLocalizationPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		PortletSession pSession = renderRequest.getPortletSession();
		Long channelId = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
				? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1;
		String myview = "view";
		if (ParamUtil.getString(renderRequest, "myview") != "") {
			myview = ParamUtil.getString(renderRequest, "myview");

			// Fetch pages (features with pageType = 0)
			List<Feature> pages = _featureLocalService.getAllParentPages(channelId);
			renderRequest.setAttribute("pages", pages);

			// Get selected featureId from request or default to first page
			long selectedFeatureId = ParamUtil.getLong(renderRequest, "selectedFeatureId", 0);
			if (selectedFeatureId == 0 && !pages.isEmpty()) {
				selectedFeatureId = pages.get(0).getFeatureId();
			}
			renderRequest.setAttribute("selectedFeatureId", selectedFeatureId);

			List<Languages> records = _languageLocalService.getbyChannelId(channelId);
			List<Localization> locals = new ArrayList<>();
			List<String> languagesNames = new ArrayList<>();
			for (Languages record : records) {
				long maxApprovedVersion = _localizationLocalService.getMaxApprovedVersionByFeature(record.getLanguageId(), channelId, selectedFeatureId);
				if (maxApprovedVersion > 0) {
					locals.add(_localizationLocalService
							.getLocalByVersion_LangId_FeatureId(maxApprovedVersion, record.getLanguageId(), channelId, selectedFeatureId).get(0));
				} else {
					locals.add(null);
				}
				languagesNames.add(record.getLangName());

			}
			renderRequest.setAttribute("locals", locals);
			renderRequest.setAttribute("languagesNames", languagesNames);
			// Check if any localization in the channel has a pending draft
			boolean hasPendingDraft = _localizationLocalService.hasPendingDraft(channelId);
			renderRequest.setAttribute("hasPendingDraft", hasPendingDraft);

			boolean hasPendingImport = _importRequestLocalService.hasPendingImportRequest(Constants.LOCALIZATION);
			renderRequest.setAttribute("hasPendingImport", hasPendingImport);

			// Handle import review data from session
			String importParsedLocalizations = (String) pSession.getAttribute("importParsedLocalizations");
			if (importParsedLocalizations != null) {
				renderRequest.setAttribute("importParsedLocalizations", importParsedLocalizations);
				renderRequest.setAttribute("importChannels", pSession.getAttribute("importChannels"));
				renderRequest.setAttribute("importApprovedPagesByChannel", pSession.getAttribute("importApprovedPagesByChannel"));
				pSession.removeAttribute("importParsedLocalizations");
				pSession.removeAttribute("importChannels");
				pSession.removeAttribute("importApprovedPagesByChannel");
			}
//			Set<String> warnings = _localizationLocalService.checkKeys(channelId);
//			if (warnings != null) {
//				List<String> warningsList = new ArrayList<String>();
//				warningsList.addAll(warnings);
//				renderRequest.setAttribute("warnings", warningsList);
//			}
		}
		PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/" + myview + ".jsp");
		dispatcher.include(renderRequest, renderResponse);
		// TODO Auto-generated method stub
		/*
		 * super.doView(renderRequest, renderResponse);
		 */
	}

	public void updateLocalization(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		List<Role> roles = user.getRoles();
		boolean isAdministrator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Administrator"));
		boolean isPo = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("po"));
		boolean isTranslator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("translator"));

		if (!isAdministrator && !isPo && !isTranslator) {
			SessionErrors.add(actionRequest, "notAuthorized");
			return;
		}

		PortletSession pSession = actionRequest.getPortletSession();
		Long channelId = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
				? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1;
		long selectedFeatureId = ParamUtil.getLong(actionRequest, "selectedFeatureId", 0);

		try {

			String confirmation = ParamUtil.getString(actionRequest, "confirmation");
			if (!confirmation.equals("done"))
				throw new Exception("Something went wrong");
			String userName = themeDisplay.getUser().getFullName();
			List<Languages> records = _languageLocalService.getbyChannelId(channelId);

			// Collect all new keys from current localization to validate against other features
			Set<String> allNewKeys = new HashSet<>();
			Set<String> existingKeys = new HashSet<>();

			for (Languages lang : records) {
				String localValue = ParamUtil.getString(actionRequest, lang.getLangName() + "TextArea");
				if (localValue != null && !localValue.isEmpty()) {
					JSONObject jsonLocalValue = JSONFactoryUtil.createJSONObject(localValue);
					allNewKeys.addAll(jsonLocalValue.keySet());
				}

				// Get existing keys for this feature (use approved version)
				long maxApprovedVersion = _localizationLocalService.getMaxApprovedVersionByFeature(lang.getLanguageId(), channelId, selectedFeatureId);
				if (maxApprovedVersion > 0) {
					String oldLocalValue = _localizationLocalService
							.getLocalByVersion_LangId_FeatureId(maxApprovedVersion, lang.getLanguageId(), channelId, selectedFeatureId).get(0)
							.getLocalValue();
					if (oldLocalValue != null) {
						JSONObject jsonOldLocalValue = JSONFactoryUtil.createJSONObject(oldLocalValue);
						existingKeys.addAll(jsonOldLocalValue.keySet());
					}
				}
				break; // Only need first language since all should have same keys
			}

			// Find newly added keys (keys that are in allNewKeys but not in existingKeys)
			Set<String> newlyAddedKeys = new HashSet<>(allNewKeys);
			newlyAddedKeys.removeAll(existingKeys);

			// Check if any newly added key exists in other features
			if (!newlyAddedKeys.isEmpty()) {
				Set<String> duplicateKeys = _localizationLocalService.findDuplicateKeysAcrossFeatures(newlyAddedKeys, channelId, selectedFeatureId);
				if (!duplicateKeys.isEmpty()) {
					throw new Exception("The following keys already exist in other pages: " + String.join(", ", duplicateKeys));
				}
			}
			ServiceContext serviceContext = createServiceContextForWorkflow(actionRequest);

			String workflowBatchId = PortalUUIDUtil.generate();
			Localization firstUpdatedLocalization = null;

			for (Languages lang : records) {
				String localValue = ParamUtil.getString(actionRequest, lang.getLangName() + "TextArea");
				long maxApprovedVersion = _localizationLocalService.getMaxApprovedVersionByFeature(lang.getLanguageId(), channelId, selectedFeatureId);
				if (maxApprovedVersion > 0) {
					String oldLocalValue = _localizationLocalService
							.getLocalByVersion_LangId_FeatureId(maxApprovedVersion, lang.getLanguageId(), channelId, selectedFeatureId).get(0)
							.getLocalValue();
					Localization originalLocalization = _localizationLocalService.getLocalByVersion_LangId_FeatureId(maxApprovedVersion, lang.getLanguageId(), channelId, selectedFeatureId).get(0);
					JSONObject jsonLocalValue = JSONFactoryUtil.createJSONObject(localValue);
					JSONObject jsonOldLocalValue = JSONFactoryUtil.createJSONObject(oldLocalValue);
					if (!jsonLocalValue.toString().equals(jsonOldLocalValue.toString())) {
						_localizationLocalService.updateLocalization(localValue, lang.getLanguageId(), channelId,
								selectedFeatureId, userName, user, workflowBatchId, originalLocalization, serviceContext,null);
						if (firstUpdatedLocalization == null) {
							long newVersion = _localizationLocalService.getMaxVersionByFeature(lang.getLanguageId(), channelId, selectedFeatureId);
							firstUpdatedLocalization = _localizationLocalService
									.getLocalByVersion_LangId_FeatureId(newVersion, lang.getLanguageId(), channelId, selectedFeatureId).get(0);
						}
					}
				} else {
					_localizationLocalService.updateLocalization(localValue, lang.getLanguageId(), channelId, selectedFeatureId, userName, user, workflowBatchId, null, serviceContext,null);
					if (firstUpdatedLocalization == null) {
						long newVersion = 1;
						firstUpdatedLocalization = _localizationLocalService
								.getLocalByVersion_LangId_FeatureId(newVersion, lang.getLanguageId(), channelId, selectedFeatureId).get(0);
					}
				}
			}

			// Start workflow for the first updated localization after all updates
			if (firstUpdatedLocalization != null) {
				_localizationLocalService.startWorkflow(firstUpdatedLocalization, serviceContext, user);
			}
			// Redirect back with the selected featureId
			actionResponse.setRenderParameter("selectedFeatureId", String.valueOf(selectedFeatureId));
			actionResponse.setRenderParameter("myview", "add");

		} catch (Exception e) { // TODO Auto-generated catch block
			SessionErrors.add(actionRequest, "error");
			actionRequest.setAttribute("errorMessage", e.getMessage());
			actionResponse.setRenderParameter("myview", "add");
			actionResponse.setRenderParameter("selectedFeatureId", String.valueOf(selectedFeatureId));
		}

	}

	public void rollbackLocalization(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		List<Role> roles = user.getRoles();
		boolean isAdministrator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Administrator"));
		boolean isPo = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("po"));
		boolean isTranslator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("translator"));

		if (!isAdministrator && !isPo && !isTranslator) {
			SessionErrors.add(actionRequest, "notAuthorized");
			return;
		}
		PortletSession pSession = actionRequest.getPortletSession();
		Long channelId = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
				? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1;
		long selectedFeatureId = ParamUtil.getLong(actionRequest, "selectedFeatureId", 0);
		try {

			String langName = ParamUtil.getString(actionRequest, "languageId");
			String userName = themeDisplay.getUser().getFullName();
			Languages language = _languageLocalService.getByLangName(langName, channelId).get(0);
			long maxApprovedVersion = _localizationLocalService.getMaxApprovedVersionByFeature(language.getLanguageId(), channelId, selectedFeatureId);
			Localization currRecord = _localizationLocalService
					.getLocalByVersion_LangId_FeatureId(maxApprovedVersion, language.getLanguageId(), channelId, selectedFeatureId).get(0);
			String currLocalValue = currRecord.getLocalValue();
			String oldLocalValue = _localizationLocalService
					.getLocalByVersion_LangId_FeatureId(maxApprovedVersion - 1, language.getLanguageId(), channelId, selectedFeatureId).get(0)
					.getLocalValue();

			JSONObject jsonOldLocalValue = JSONFactoryUtil.createJSONObject(oldLocalValue);
			JSONObject jsonCurrLocalValue = JSONFactoryUtil.createJSONObject(currLocalValue);
			if (jsonCurrLocalValue.keySet().equals(jsonOldLocalValue.keySet()))
				_localizationLocalService.rollbackLocalization(currRecord);
			else
				throw new Exception("Unable to roll back due to inconsistent keys");
			// Redirect back with the selected featureId
			actionResponse.setRenderParameter("selectedFeatureId", String.valueOf(selectedFeatureId));
			actionResponse.setRenderParameter("myview", "add");
		} catch (Exception e) { // TODO Auto-generated catch block
			SessionErrors.add(actionRequest, "error");
			actionRequest.setAttribute("errorMessage", e.getMessage());
			actionResponse.setRenderParameter("myview", "add");
			actionResponse.setRenderParameter("selectedFeatureId", String.valueOf(selectedFeatureId));
		}

	}



	/**
	 * Finds keys that exist in other features' localizations.
	 */



	public void exportLocalization(ActionRequest actionRequest, ActionResponse actionResponse)
	{
		long[] localizationIds = ParamUtil.getLongValues(actionRequest, "localizationIds");
		String summary = ParamUtil.getString(actionRequest, "exportSummary", "Localization Export");

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		List<Role> roles = user.getRoles();
		boolean isAdministrator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Administrator"));
		boolean isPo = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("po"));
		boolean isTranslator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("translator"));

		if (!isAdministrator && !isPo && !isTranslator) {
			SessionErrors.add(actionRequest, "notAuthorized");
			return;
		}
		List<ComponentEntryDto> exportData = new ArrayList<>();
		JSONObject mergedData = JSONFactoryUtil.createJSONObject(); // single merged object

		for (long localizationId : localizationIds) {
			try {
				Localization localization = _localizationLocalService.getLocalization(localizationId);
				if (_localizationLocalService.hasPendingDraft(localization.getChannelId())) {
					SessionErrors.add(actionRequest, "hasPendingDraft");
					return;
				}

				JSONObject obj = localizationToJson(localization);

				String languageName = obj.getString("languageName");
				String localValueStr = obj.getString("localValue");

				JSONObject localValueJson = JSONFactoryUtil.createJSONObject(localValueStr);
				mergedData.put(languageName, localValueJson);

			} catch (PortalException e) {
				SessionErrors.add(actionRequest, "export-error");
				e.printStackTrace();
			}
		}

		if (mergedData.length() == 0) {
			SessionErrors.add(actionRequest, "noDataToExport");
			return;
		}

		ComponentEntryDto dto = new ComponentEntryDto();
		dto.setData(mergedData);
		exportData.add(dto);

		try {
			ExportFileUtil.downloadZip(summary, exportData, user, Constants.LOCALIZATION, actionRequest, actionResponse);
		} catch (IllegalStateException e) {
			SessionErrors.add(actionRequest, "zipSizeExceeded");
		}
	}

	public void importLocalization(ActionRequest actionRequest, ActionResponse actionResponse)
	{
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		List<Role> roles = user.getRoles();
		boolean isAdministrator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Administrator"));
		boolean isPo = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("po"));
		boolean isTranslator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("translator"));

		if (!isAdministrator && !isPo && !isTranslator) {
			SessionErrors.add(actionRequest, "notAuthorized");
			return;
		}

		try {
			ImportResultDTO importResult = ImportFileUtil.parseZip(actionRequest,Constants.LOCALIZATION);
			List<ComponentEntryDto> components = importResult.getComponents();


			JSONArray parsedLocalizationsArray = JSONFactoryUtil.createJSONArray();
			for (int i = 0; i < components.size(); i++) {
				ComponentEntryDto comp = components.get(i);
				JSONObject localizationEntry = JSONFactoryUtil.createJSONObject();
				localizationEntry.put("index", i);
				// Extract language names from the data keys
				if (comp.getData() != null) {
					JSONArray langNames = JSONFactoryUtil.createJSONArray();
					for (String key : comp.getData().keySet()) {
						langNames.put(key);
					}
					localizationEntry.put("languages", langNames);
				}
				parsedLocalizationsArray.put(localizationEntry);
			}

			// Get approved channels
			List<Channels> approvedChannels = _channelsLocalService.findByStatus(WorkflowConstants.STATUS_APPROVED);
			JSONArray channelsArray = JSONFactoryUtil.createJSONArray();
			for (Channels ch : approvedChannels) {
				JSONObject chObj = JSONFactoryUtil.createJSONObject();
				chObj.put("channelId", ch.getChannelId());
				chObj.put("name", ch.getName());
				channelsArray.put(chObj);
			}

			// Get approved parent pages (features) per channel
			JSONObject approvedPagesByChannel = JSONFactoryUtil.createJSONObject();
			for (Channels ch : approvedChannels) {
				List<Feature> pages = _featureLocalService.getAllParentPages(ch.getChannelId());
				JSONArray pagesForChannel = JSONFactoryUtil.createJSONArray();
				for (Feature page : pages) {
					JSONObject pageObj = JSONFactoryUtil.createJSONObject();
					pageObj.put("featureId", page.getFeatureId());
					pageObj.put("name", page.getFeatureName());
					pagesForChannel.put(pageObj);
				}
				approvedPagesByChannel.put(String.valueOf(ch.getChannelId()), pagesForChannel);
			}

			PortletSession pSession = actionRequest.getPortletSession();
			pSession.setAttribute("importParsedLocalizations", parsedLocalizationsArray.toString());
			pSession.setAttribute("importChannels", channelsArray.toString());
			pSession.setAttribute("importApprovedPagesByChannel", approvedPagesByChannel.toString());
			pSession.setAttribute("importResult", importResult);
			actionResponse.setRenderParameter("myview", "add");
		} catch (Exception e) {
			LOG.error("Unexpected error during import: " + e.getMessage());
			SessionErrors.add(actionRequest, "import-processing-error");
		}
	}

	public void confirmImportLocalization(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		String importDecisionsJson = ParamUtil.getString(actionRequest, "importDecisions");
		PortletSession pSession = actionRequest.getPortletSession();
		if (importDecisionsJson == null || importDecisionsJson.isEmpty()) {
			LOG.error("No import decisions received");
			SessionErrors.add(actionRequest, "no-import-decisions");
			return;
		}
		ServiceContext serviceContext = createServiceContextForWorkflow(actionRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		ImportResultDTO resultDTO = (ImportResultDTO) pSession.getAttribute("importResult");
		try {
			JSONArray decisionsArray = JSONFactoryUtil.createJSONArray(importDecisionsJson);
			List<ComponentEntryDto> components = resultDTO.getComponents();
			for (int i = 0; i < decisionsArray.length(); i++) {
				JSONObject decision = decisionsArray.getJSONObject(i);
				int index = decision.getInt("index");
				String action = decision.getString("action");
				long channelId = decision.getLong("channelId");
				long updatePageId = decision.getLong("updatePageId", 0);

				if (index >= 0 && index < components.size()) {
					ComponentEntryDto entry = components.get(index);
					entry.setAction(action);
					entry.setChannelId(channelId);
					entry.setAffectedEntityId(updatePageId);
				} else {
					LOG.warn("Invalid index " + index + " in import decisions, skipping.");
				}
			}

			// Check for duplicate keys across features per chosen channel
			for (int i = 0; i < decisionsArray.length(); i++) {
				JSONObject decision = decisionsArray.getJSONObject(i);
				int index = decision.getInt("index");
				long channelId = decision.getLong("channelId");
				long updatePageId = decision.getLong("updatePageId", 0);

				if (index >= 0 && index < components.size()) {
					ComponentEntryDto comp = components.get(index);
					Set<String> allNewKeys = new HashSet<>();
					if (comp.getData() != null) {
						for (String langKey : comp.getData().keySet()) {
							JSONObject localValueJson = comp.getData().getJSONObject(langKey);
							if (localValueJson != null) {
								allNewKeys.addAll(localValueJson.keySet());
							}
						}
					}
					if (!allNewKeys.isEmpty()) {
						Set<String> duplicateKeys = _localizationLocalService.findDuplicateKeysAcrossFeatures(allNewKeys, channelId, updatePageId);
						if (!duplicateKeys.isEmpty()) {
							throw new PortalException("The following keys already exist in other pages: " + String.join(", ", duplicateKeys));
						}
					}
				}
			}

			Path path = _importRequestLocalService.buildZip(resultDTO);
			_importRequestLocalService.startImportRequestWorkflow(resultDTO, path.toString(), user, serviceContext);

		} catch (PortalException e) {
			LOG.error("Error processing import: " + e.getMessage(), e);
			SessionErrors.add(actionRequest, "import-duplicate-keys-error");
		} catch (Exception e) {
			LOG.error("Error processing import decisions: " + e.getMessage(), e);
			SessionErrors.add(actionRequest, "import-processing-error");
		}
	}

	private JSONObject localizationToJson(Localization localization) {
		Languages lang;
		try {
			 lang =_languageLocalService.getLanguages(localization.getLanguageId());
		} catch (PortalException e) {
			return null;
		}
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("languageName", lang.getLangName());
		json.put("localValue", localization.getLocalValue());
		return json;
	}


	private ServiceContext createServiceContextForWorkflow(ActionRequest actionRequest) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Persona.class.getName(), actionRequest);
		serviceContext.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH);
		return serviceContext;
	}

	@Reference
	private LocalizationLocalService _localizationLocalService;
	@Reference
	private LanguagesLocalService _languageLocalService;
	@Reference
	private FeatureLocalService _featureLocalService;

	@Reference
	private UserLogsLocalService _userLogsLocalService;

	@Reference
	private ChannelsLocalService _channelsLocalService;

	@Reference
	private ImportRequestLocalService _importRequestLocalService;
}
