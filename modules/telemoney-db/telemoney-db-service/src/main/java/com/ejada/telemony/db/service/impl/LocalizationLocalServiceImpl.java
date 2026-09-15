/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ejada.telemony.db.service.impl;

import com.ejada.telemony.db.constants.ComponentType;
import com.ejada.telemony.db.constants.Constants;
import com.ejada.telemony.db.model.*;
import com.ejada.telemony.db.service.GlobalVersionLocalServiceUtil;
import com.ejada.telemony.db.service.LocalizationLocalServiceUtil;
import com.ejada.telemony.db.service.base.LocalizationLocalServiceBaseImpl;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.ejada.telemony.db.model.ImportRequest;

import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;

import java.util.*;

/**
 * The implementation of the localization local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.ejada.telemony.db.service.LocalizationLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LocalizationLocalServiceBaseImpl
 */
public class LocalizationLocalServiceImpl extends LocalizationLocalServiceBaseImpl {
	private static final Log LOG = LogFactoryUtil.getLog(LanguagesLocalServiceImpl.class);

	//Deprecated
	public void updateLocalization(String localValue, long languageId, long channelId, String userName) {
		long newVersion = getMaxVersion(languageId, channelId) + 1;
		Localization local = LocalizationLocalServiceUtil.createLocalization(CounterLocalServiceUtil.increment());
		local.setVersion(newVersion);
		local.setChannelId(channelId);
		local.setLanguageId(languageId);
		local.setLocalValue(localValue);
		local.setUserName(userName);
		LocalizationLocalServiceUtil.updateLocalization(local);
	}

	/**
	 * Feature PKs change on every edit. Localization.featureId stores the STABLE
	 * resource id instead. Idempotent: entityResourceId/childResourceId is seeded
	 * from the first version's own PK, so resolving an already-stable id returns
	 * itself.
	 */
	private long toStableFeatureId(long featureId) {
		Feature feature = featureLocalService.fetchFeature(featureId);
		if (feature == null) {
			return featureId;
		}
		return feature.getEntityResourceId();
	}

	public void updateLocalization(String localValue, long languageId, long channelId, long featureId, String userName, User user,String workflowBatchId,Localization originalLocalization,ServiceContext serviceContext,ImportRequest importRequest) {
		LOG.info("updatelocalization has been called");


		long stableFeatureId = toStableFeatureId(featureId);
		long newVersion = getMaxVersionByFeature(languageId, channelId, stableFeatureId) + 1;
		Localization local = LocalizationLocalServiceUtil.createLocalization(CounterLocalServiceUtil.increment());
		local.setVersion(newVersion);
		local.setChannelId(channelId);
		local.setLanguageId(languageId);
		local.setFeatureId(stableFeatureId);
		local.setLocalValue(localValue);
		local.setUserName(userName);
		local.setWorkflowBatchId(workflowBatchId);
		Long originalEntityId;
		Long entityResourceId;
		if(originalLocalization != null){
			originalEntityId = originalLocalization.getLocalizationId();
			entityResourceId = originalLocalization.getEntityResourceId();
		}else {
			originalEntityId = 0L;
			entityResourceId = local.getLocalizationId();
		}

		local.setOriginalEntityId(originalEntityId);
		local.setEntityResourceId(entityResourceId);
		if (serviceContext != null) {
			local.setGroupId(serviceContext.getScopeGroupId());
			local.setCompanyId(serviceContext.getCompanyId());
			local.setUserId(serviceContext.getUserId());}
		else {
			local.setGroupId(importRequest.getGroupId());
			local.setCompanyId(importRequest.getCompanyId());
			local.setUserId(importRequest.getUserId());
			local.setImportRequestId(importRequest.getId());
		}
		//local.setUserName(user.getFullName());

		// Only set createDate if not already set
		if (local.getCreateDate() == null) {
			local.setCreateDate(new Date());
		}
		local.setModifiedDate(new Date());

		// Only set UUID if not already set
		if (local.getUuid_() == null || local.getUuid_().isEmpty()) {
			local.setUuid_(PortalUUIDUtil.generate());
		}

		//local.setOriginalEntityId(id);

		local.setStatus(WorkflowConstants.STATUS_DRAFT);
		local.setStatusDate(new Date());

		LocalizationLocalServiceUtil.updateLocalization(local);

	}
	public void startWorkflow(Localization localization, ServiceContext serviceContext, User user) throws PortalException {

		localization = LocalizationLocalServiceUtil.updateLocalization(localization);
		serviceContext.setAttribute(Constants.ENTITY_TYPE, Constants.LOCALIZATION);
		serviceContext.setAttribute(Constants.USER_NAME, user.getFullName());
		serviceContext.setAttribute(Constants.REQUEST_ID, localization.getLocalizationId());


		if (serviceContext.getScopeGroupId() <= 0) {
			serviceContext.setScopeGroupId(
					GroupLocalServiceUtil.getCompanyGroup(
							serviceContext.getCompanyId()
					).getGroupId()
			);
		}
		AssetEntryLocalServiceUtil.updateEntry(
				serviceContext.getUserId(),
				serviceContext.getScopeGroupId(),
				Localization.class.getName(),
				localization.getLocalizationId(),
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames()
		);

		serviceContext.setAssetCategoryIds(null);
		serviceContext.setAssetTagNames(null);

		WorkflowHandlerRegistryUtil.startWorkflowInstance(
				serviceContext.getCompanyId(),
				serviceContext.getUserId(),
				Localization.class.getName(),
				localization.getPrimaryKey(),
				localization,
				serviceContext
		);
	}

	public List<Localization> getAllLocalizations() {
		return localizationPersistence.findAll();
	}

	public List<Localization> getLocalByVersion_LangId(long version, long languageId, long channelId) {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Localization.class, getClassLoader());
		query.add(RestrictionsFactoryUtil.eq("languageId", languageId));
		query.add(RestrictionsFactoryUtil.eq("version", version));
		query.add(RestrictionsFactoryUtil.eq("channelId", channelId));
		List<Localization> result = LocalizationLocalServiceUtil.dynamicQuery(query);
		return result;

	}

	public long getMaxVersion(long langId, Long channelId) {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Localization.class, getClassLoader());
		query.add(RestrictionsFactoryUtil.eq("languageId", langId));
		query.add(RestrictionsFactoryUtil.eq("channelId", channelId));
		query.setProjection(PropertyFactoryUtil.forName("version").max());
		List<Long> result = LocalizationLocalServiceUtil.dynamicQuery(query);
		if (result != null && !result.isEmpty())
			return result.get(0);
		else {
			return 0;
		}
	}

	public long getMaxVersionByFeature(long langId, Long channelId, long featureId) {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Localization.class, getClassLoader());
		query.add(RestrictionsFactoryUtil.eq("languageId", langId));
		query.add(RestrictionsFactoryUtil.eq("channelId", channelId));
		query.add(RestrictionsFactoryUtil.eq("featureId", toStableFeatureId(featureId)));
		query.setProjection(PropertyFactoryUtil.forName("version").max());
		List<Long> result = LocalizationLocalServiceUtil.dynamicQuery(query);
		if (result != null && !result.isEmpty() && result.get(0) != null)
			return result.get(0);
		else {
			return 0;
		}
	}

	public long getMaxApprovedVersionByFeature(long langId, Long channelId, long featureId) {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Localization.class, getClassLoader());
		query.add(RestrictionsFactoryUtil.eq("languageId", langId));
		query.add(RestrictionsFactoryUtil.eq("channelId", channelId));
		query.add(RestrictionsFactoryUtil.eq("featureId", toStableFeatureId(featureId)));
		query.add(RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_APPROVED));
		query.setProjection(PropertyFactoryUtil.forName("version").max());
		List<Long> result = LocalizationLocalServiceUtil.dynamicQuery(query);
		if (result != null && !result.isEmpty() && result.get(0) != null)
			return result.get(0);
		else {
			return 0;
		}
	}
	public long getMaxDraftVersionByFeature(long langId, Long channelId, long featureId) {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Localization.class, getClassLoader());
		query.add(RestrictionsFactoryUtil.eq("languageId", langId));
		query.add(RestrictionsFactoryUtil.eq("channelId", channelId));
		query.add(RestrictionsFactoryUtil.eq("featureId", toStableFeatureId(featureId)));
		query.add(RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_DRAFT));
		query.setProjection(PropertyFactoryUtil.forName("version").max());
		List<Long> result = LocalizationLocalServiceUtil.dynamicQuery(query);
		if (result != null && !result.isEmpty() && result.get(0) != null)
			return result.get(0);
		else {
			return 0;
		}
	}

	public long getMaxGlobalVersion(long channelId) {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Localization.class, getClassLoader());
		query.add(RestrictionsFactoryUtil.eq("channelId", channelId));
		query.setProjection(PropertyFactoryUtil.forName("globalVersion").max());
		List<Long> result = LocalizationLocalServiceUtil.dynamicQuery(query);
		if (result != null && !result.isEmpty() && result.get(0) != null)
			return result.get(0);
		else
			return 0;
	}

	public long getMaxGlobalVersionByLanguage(long channelId, long languageId) {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Localization.class, getClassLoader());
		query.add(RestrictionsFactoryUtil.eq("channelId", channelId));
		query.add(RestrictionsFactoryUtil.eq("languageId", languageId));
		query.setProjection(PropertyFactoryUtil.forName("globalVersion").max());
		List<Long> result = LocalizationLocalServiceUtil.dynamicQuery(query);
		if (result != null && !result.isEmpty() && result.get(0) != null)
			return result.get(0);
		else
			return 0;
	}

	public void stampGlobalVersion(long channelId, long languageId) {
		long nextGlobalVersion = getMaxGlobalVersionByLanguage(channelId, languageId) + 1;
		List<Feature> features = featureLocalService.getAllParentPages(channelId);
		for (Feature feature : features) {
			long resourceId = feature.getEntityResourceId();          // <-- was getFeatureId()
			long maxApproved = getMaxApprovedVersionByFeature(languageId, channelId, resourceId);
			if (maxApproved > 0) {
				List<Localization> rows = getLocalByVersion_LangId_FeatureId(
						maxApproved, languageId, channelId, resourceId);
				if (!rows.isEmpty()) {
					Localization row = rows.get(0);
					row.setGlobalVersion(nextGlobalVersion);
					localizationPersistence.update(row);
				}
			}
		}
	}

	public boolean hasPendingDraft(long channelId) {
		try {
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(Localization.class, getClassLoader());
			query.add(RestrictionsFactoryUtil.eq("channelId", channelId));
			query.add(RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_DRAFT));
			List<Localization> results = LocalizationLocalServiceUtil.dynamicQuery(query);
			return !results.isEmpty();
		} catch (Exception e) {
			LOG.error("Unable to evaluate pending drafts for channelId " + channelId, e);
			return true;
		}
	}

	public void rollbackLocalization(Localization localization) {
		// Block rollback if there is any pending draft in the channel
		if (hasPendingDraft(localization.getChannelId())) {
			throw new RuntimeException("Localization is currently locked because there is a pending change awaiting approval.");
		}
		long channelId = localization.getChannelId();
		long languageId = localization.getLanguageId();
		localizationPersistence.remove(localization);
		stampGlobalVersion(channelId, languageId);
	}

	public Localization updateStatus(long userId, long langId, int status,
									 ServiceContext serviceContext) throws PortalException, SystemException
	{
		Localization localization = localizationPersistence.findByPrimaryKey(langId);

		// Set status metadata
		localization.setStatusByUserId(userId);
		if (userId > 0) {
			localization.setStatusByUserName(UserLocalServiceUtil.getUser(userId).getFullName());
		}
		localization.setStatusDate(new Date());
		localization.setModifiedDate(new Date());
		localization = localizationPersistence.update(localization);

		if (status == WorkflowConstants.STATUS_APPROVED) {
			String workflowBatchId = localization.getWorkflowBatchId();
			Set<Long> stampedLanguages = new HashSet<>();
			if (workflowBatchId != null && !workflowBatchId.isEmpty()) {
				List<Localization> batchLocalizations = localizationPersistence.findByWorkflowBatchId(workflowBatchId);
				for (Localization batchLocalization : batchLocalizations) {
					batchLocalization.setStatus(status);
					batchLocalization.setStatusByUserId(userId);
					if (userId > 0) {
						batchLocalization.setStatusByUserName(UserLocalServiceUtil.getUser(userId).getFullName());
					}
					batchLocalization.setStatusDate(new Date());
					batchLocalization.setModifiedDate(new Date());
					localizationPersistence.update(batchLocalization);
					stampedLanguages.add(batchLocalization.getLanguageId());
				}
			} else {
				stampedLanguages.add(localization.getLanguageId());
			}

			for (Long langId2 : stampedLanguages) {
				stampGlobalVersion(localization.getChannelId(), langId2);
			}

			// ---- User Story 5: Global Component Versioning ----
			// An approved change to the Localization component bumps the internal
			// localizationVersion for this company/channel.
			incrementGlobalVersion(localization);

			// Fallback: keep same row as approved
			return localization;
		}

		if (status == WorkflowConstants.STATUS_DENIED || status == WorkflowConstants.STATUS_EXPIRED) {
			String workflowBatchId = localization.getWorkflowBatchId();
			if (workflowBatchId != null && !workflowBatchId.isEmpty()) {
				List<Localization> batchLocalizations = localizationPersistence.findByWorkflowBatchId(workflowBatchId);
				for (Localization batchLocalization : batchLocalizations) {
					batchLocalization.setStatus(status);
					batchLocalization.setStatusByUserId(userId);
					if (userId > 0) {
						batchLocalization.setStatusByUserName(UserLocalServiceUtil.getUser(userId).getFullName());
					}
					batchLocalization.setStatusDate(new Date());
					batchLocalization.setModifiedDate(new Date());
					localizationPersistence.update(batchLocalization);
				}
			}
		}

		return localization;
	}

	public List<Localization> getLocalByVersion_LangId_FeatureId(long version, long languageId, long channelId, long featureId) {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Localization.class, getClassLoader());
		query.add(RestrictionsFactoryUtil.eq("languageId", languageId));
		query.add(RestrictionsFactoryUtil.eq("version", version));
		query.add(RestrictionsFactoryUtil.eq("channelId", channelId));
		query.add(RestrictionsFactoryUtil.eq("featureId", toStableFeatureId(featureId)));
		List<Localization> result = LocalizationLocalServiceUtil.dynamicQuery(query);
		return result;
	}

	//not used in localization module
	public void deleteLocales(long langId, String userName, long channelId) {
		long maxVersion = getMaxVersion(langId, channelId);
		if (maxVersion > 1) {
			Localization local = getLocalByVersion_LangId(maxVersion, langId, channelId).get(0);
			LocalizationLocalServiceUtil.deleteLocalization(local);
			Localization oldLocal = getLocalByVersion_LangId(maxVersion - 1, langId, channelId).get(0);
			oldLocal.setUserName(userName);
			LocalizationLocalServiceUtil.updateLocalization(oldLocal);

		}
	}


	//not used in localization module
	public Set<String> checkKeys(long channelId) {
		try {
			List<Languages> languages = languagesPersistence.findByChannelId(channelId);
			List<Localization> locals = new ArrayList<>();
			List<String> languagesNames = new ArrayList<>();
			Set<String> result = new HashSet<>();
			for (Languages language : languages) {
				long version = getMaxVersion(language.getLanguageId(), channelId);
				if (version > 0) {
					locals.add(getLocalByVersion_LangId(version, language.getLanguageId(), channelId).get(0));
					languagesNames.add(language.getLangName());
				}
			}

			// 1 1 2 3 3
			// 1 1 2 3 3
			for (int i = 0; i < locals.size(); i++) {
				JSONObject curr = JSONFactoryUtil.createJSONObject(locals.get(i).getLocalValue());
				for (int j = 0; j < locals.size(); j++) {
					if (i != j) {
						Set<String> currSet = curr.keySet();
						JSONObject next = JSONFactoryUtil.createJSONObject(locals.get(j).getLocalValue());
						currSet.removeAll((next.keySet()));
						result.addAll(currSet);

					}
				}
			}
			return result;
		} catch (

				Exception e) {
			LOG.info("---------------- Localization Check Error ----------------");
			LOG.info(e.getMessage());
			return null;
		}
	}
	//not used in localization module
	private JSONObject createJsonResponse(List<Object[]> locals, String languageCode) {
		JSONObject result = JSONFactoryUtil.createJSONObject();
		for (Object[] tmc : locals) {
			try {
				result.put(languageCode.toLowerCase(), JSONFactoryUtil.createJSONObject((String) tmc[0]));
			} catch (JSONException e) {
				LOG.error("Unable to build the localization JSON response", e);
			}
			result.put("version", tmc[1]);
		}
		return result;
	}
	//not used in localization module
	public JSONObject getLocalizationAPI(long channelId, String languageName, String languageCode, int version)
			throws Exception {
		List<Languages> lang = languagesLocalService.getByLangName(languageName, channelId);
		if (lang.size() < 1)
			throw new Exception(languageName + " is not found in languages table");
		long languageId = lang.get(0).getLanguageId();
		long maxGlobalVersion = getMaxGlobalVersionByLanguage(channelId, languageId);

		if (version == maxGlobalVersion) {
			JSONObject versionResponse = JSONFactoryUtil.createJSONObject();
			versionResponse.put("version", maxGlobalVersion);
			versionResponse.put(languageCode.toLowerCase(), JSONFactoryUtil.createJSONObject());
			return versionResponse;
		}

		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Localization.class, getClassLoader());
		query.add(RestrictionsFactoryUtil.eq("channelId", channelId));
		query.add(RestrictionsFactoryUtil.eq("languageId", languageId));
		query.add(RestrictionsFactoryUtil.eq("globalVersion", maxGlobalVersion));
		query.add(RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_APPROVED));
		List<Localization> rows = LocalizationLocalServiceUtil.dynamicQuery(query);

		JSONObject merged = JSONFactoryUtil.createJSONObject();
		for (Localization row : rows) {
			if (row.getLocalValue() != null && !row.getLocalValue().isEmpty()) {
				JSONObject pageJson = JSONFactoryUtil.createJSONObject(row.getLocalValue());
				for (String key : pageJson.keySet()) {
					merged.put(key, pageJson.getString(key));
				}
			}
		}

		JSONObject result = JSONFactoryUtil.createJSONObject();
		result.put("version", maxGlobalVersion);
		result.put(languageCode.toLowerCase(), merged);
		return result;
	}

	public List<Localization> getbyChannelId(Long channelId) {
		return localizationPersistence.findByChannelId(channelId);
	}

	public List<Localization> getByWorkflowBatchId(String workflowBatchId) {
		return localizationPersistence.findByWorkflowBatchId(workflowBatchId);
	}

	public void importLocalization(ImportRequest importRequest, JSONArray dataJson) {
		try {
			String workflowBatchId = PortalUUIDUtil.generate();
			Localization firstUpdatedLocalization = null;
			for (int i = 0; i < dataJson.length(); i++) {
				JSONObject themeJson = dataJson.getJSONObject(i);
				Long channelId = themeJson.getLong("channelId");
				Long affectedEntityId = themeJson.getLong("affectedEntityId", 0L);
				JSONObject dataObj = themeJson.getJSONObject("data");
				firstUpdatedLocalization = null;
				for (String key : dataObj.keySet()) {
					JSONObject langData = dataObj.getJSONObject(key);
					String localValue = langData.toString(4);
					List<Languages> languages = languagesPersistence.findByLangName(channelId, key);
					if (languages.isEmpty()) {
						LOG.warn("Language with name " + key + " not found for channelId " + channelId);
						continue;
					}
					Long languageId = languages.get(0).getLanguageId();
					long maxApprovedVersion = getMaxApprovedVersionByFeature(languageId, channelId, affectedEntityId);

					if (maxApprovedVersion > 0) {
						String oldLocalValue = getLocalByVersion_LangId_FeatureId(maxApprovedVersion, languageId, channelId, affectedEntityId).get(0)
								.getLocalValue();
						Localization originalLocalization = getLocalByVersion_LangId_FeatureId(maxApprovedVersion, languageId, channelId, affectedEntityId).get(0);
						JSONObject jsonLocalValue = JSONFactoryUtil.createJSONObject(localValue);
						JSONObject jsonOldLocalValue = JSONFactoryUtil.createJSONObject(oldLocalValue);
						if (!jsonLocalValue.toString().equals(jsonOldLocalValue.toString())) {
							updateLocalization(localValue, languageId, channelId, affectedEntityId, importRequest.getUserName(), null, workflowBatchId, originalLocalization, null,importRequest);
							if (firstUpdatedLocalization == null) {
								long newVersion = getMaxVersionByFeature(languageId, channelId, affectedEntityId);
								firstUpdatedLocalization = getLocalByVersion_LangId_FeatureId(newVersion, languageId, channelId, affectedEntityId).get(0);
							}
						}
					} else {
						updateLocalization(localValue, languageId, channelId, affectedEntityId, importRequest.getUserName(), null, workflowBatchId, null, null,importRequest);
						if (firstUpdatedLocalization == null) {
							long newVersion = 1;
							firstUpdatedLocalization = getLocalByVersion_LangId_FeatureId(newVersion, languageId, channelId, affectedEntityId).get(0);
						}
					}
				}
			}
			if (firstUpdatedLocalization != null) {
				firstUpdatedLocalization = LocalizationLocalServiceUtil.updateLocalization(firstUpdatedLocalization);
			}
			if (firstUpdatedLocalization != null){
				updateStatus(firstUpdatedLocalization.getUserId(), firstUpdatedLocalization.getLocalizationId(), WorkflowConstants.STATUS_APPROVED, null);}
		} catch (PortalException e) {
			LOG.error("PortalException while importing localizations: " + e.getMessage(), e);
			throw new RuntimeException(e);
		}


	}

	public Set<String> findDuplicateKeysAcrossFeatures(Set<String> newKeys, long channelId, long currentFeatureId) {
		Set<String> duplicateKeys = new HashSet<>();
		long currentResourceId = toStableFeatureId(currentFeatureId);
		try {
			// Get all features (pages) for the channel except the current one
			List<Feature> allFeatures = featureLocalService.getAllParentPages(channelId);

			for (Feature feature : allFeatures) {
				long resourceId = feature.getEntityResourceId();
				if (resourceId == currentResourceId) {
					continue;
				}

				// Get the latest approved localization for any language in this feature
				List<Languages> languages = languagesLocalService.getbyChannelId(channelId);
				for (Languages lang : languages) {
					long maxApprovedVersion = localizationLocalService.getMaxApprovedVersionByFeature(lang.getLanguageId(), channelId, resourceId);
					if (maxApprovedVersion > 0) {
						List<Localization> localizations = localizationLocalService.getLocalByVersion_LangId_FeatureId(maxApprovedVersion, lang.getLanguageId(), channelId, resourceId);
						if (!localizations.isEmpty() && localizations.get(0).getLocalValue() != null) {
							try {
								JSONObject existingJson = JSONFactoryUtil.createJSONObject(localizations.get(0).getLocalValue());
								Set<String> existingKeys = existingJson.keySet();
								// Find intersection of newKeys and existingKeys
								for (String key : newKeys) {
									if (existingKeys.contains(key)) {
										duplicateKeys.add(key);
									}
								}
							} catch (Exception e) {
								// Ignore JSON parsing errors
							}
						}
						break; // Only need to check one language since all should have same keys
					}
				}
			}
		} catch (Exception e) {
			// Log error if needed
		}
		return duplicateKeys;
	}

	/**
	 * User Story 5 - Global Component Versioning.
	 *
	 * <p>
	 * An approved change to the Localization component bumps the internal
	 * {@code localizationVersion} version for this company/channel. Runs in the
	 * same transaction as the approval so both succeed or roll back together.
	 * </p>
	 */
	private void incrementGlobalVersion(Localization localization) {
		GlobalVersionLocalServiceUtil.incrementApprovedVersion(
				localization.getCompanyId(),
				localization.getChannelId(),
				ComponentType.LOCALIZATION.name());
	}


	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.ejada.telemony.db.service.LocalizationLocalService</code> via
	 * injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.ejada.telemony.db.service.LocalizationLocalServiceUtil</code>.
	 */
}

