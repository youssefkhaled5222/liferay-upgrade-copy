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

import com.ejada.telemoney.db.constants.TelemoneyConstants;
import com.ejada.telemony.db.constants.ComponentType;
import com.ejada.telemony.db.constants.Constants;
import com.ejada.telemony.db.model.*;
import com.ejada.telemony.db.service.GlobalVersionLocalServiceUtil;
import com.ejada.telemony.db.service.LocalizationLocalServiceUtil;
import com.ejada.telemony.db.service.base.LanguagesLocalServiceBaseImpl;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;

import java.util.Date;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the languages local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.ejada.telemony.db.service.LanguagesLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LanguagesLocalServiceBaseImpl
 */
public class LanguagesLocalServiceImpl extends LanguagesLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.ejada.telemony.db.service.LanguagesLocalService</code> via
	 * injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.ejada.telemony.db.service.LanguagesLocalServiceUtil</code>.
	 */
	private static final Log LOG = LogFactoryUtil.getLog(LanguagesLocalServiceImpl.class);

	public void addNewLanguage(String langName, String local, String userName, Long channelId, boolean primaryLanguage, User user, ServiceContext serviceContext)
			throws Exception {
		try {
			Languages createdLanguage = this.languagesLocalService.createLanguages(CounterLocalServiceUtil.increment());
			createdLanguage.setChannelId(channelId);
			createdLanguage.setLangName(langName);
			createdLanguage.setLocal(local);
			createdLanguage.setPrimaryLanguage(primaryLanguage);

			createdLanguage = this.languagesLocalService.updateLanguages(createdLanguage);

			// Set entityResourceId to the language's own ID for a new entity
			createdLanguage.setEntityResourceId(createdLanguage.getLanguageId());
			createdLanguage.setVersion(getMaxVersion(createdLanguage.getEntityResourceId()) + 1);

			startWorkflow(createdLanguage, serviceContext, user, 0L, Constants.CREATE);

//			if (!langName.equals(TelemoneyConstants.LANGUAGE_ENGLISH_NAME)) {
//				try {
//					long langId = getByLangName(TelemoneyConstants.LANGUAGE_ENGLISH_NAME, channelId).get(0)
//							.getLanguageId();
//					LOG.info("----------------Language Fallback For Localization-----------------");
//					long version = LocalizationLocalServiceUtil.getMaxVersion(langId, channelId);
//					if (version > 0) {
//						String enLocalValue = LocalizationLocalServiceUtil
//								.getLocalByVersion_LangId(version, langId, channelId).get(0).getLocalValue();
//						LocalizationLocalServiceUtil.updateLocalization(enLocalValue, createdLanguage.getLanguageId(),
//								channelId, userName);
//					}
//
//					LOG.info("----------------Language Fallback For Banner Content-----------------");
//
//					List<BannerContent> bannerContents = bannerContentPersistence.findByChannelId(channelId);
//					List<Resource> resourcesForFallback = resourcePersistence.findByChannelId(channelId);
//					List<Lovs> lovs = lovsPersistence.findByChannelId(channelId);
//
//					for (BannerContent bannerContent : bannerContents) {
//						BannerContentLocalization bannerEnLocal = bannerContentLocalizationPersistence
//								.fetchByContentId_LanguageId(bannerContent.getContentId(),
//										TelemoneyConstants.LANGUAGE_ENGLISH_NAME);
//						if (bannerEnLocal != null) {
//							BannerContentLocalization bannerLocal = bannerContentLocalizationPersistence
//									.create(CounterLocalServiceUtil.increment());
//							bannerLocal.setContentId(bannerEnLocal.getContentId());
//							bannerLocal.setLanguageId(langName);
//							bannerLocal.setTitleValue(bannerEnLocal.getTitleValue());
//							bannerLocal.setDescriptionValue(bannerEnLocal.getDescriptionValue());
//							bannerLocal.setBannerImage(bannerEnLocal.getBannerImage());
//							bannerLocal.setImageOverlay(bannerEnLocal.getImageOverlay());
//							bannerLocal.setLinkType(bannerEnLocal.getLinkType());
//							bannerLocal.setUrl(bannerEnLocal.getUrl());
//							bannerContentLocalizationPersistence.update(bannerLocal);
//						}
//					}
//
//					LOG.info("----------------Language Fallback For Resource Localization-----------------");
//
//					for (Resource resource : resourcesForFallback) {
//						ResourceLocalization resourceEnLocalized = resourceLocalizationPersistence
//								.fetchByResourceId_LanguageId(resource.getResourceId(),
//										TelemoneyConstants.LANGUAGE_ENGLISH_NAME);
//						String resourceType = resource.getResourceType();
//						String urlType = resource.getUrl();
//						System.out.println(urlType);
//						if (resourceEnLocalized != null) {
//							ResourceLocalization resourceLocalized = resourceLocalizationPersistence
//									.create(CounterLocalServiceUtil.increment());
//							resourceLocalized.setMvccVersion(0);
//							resourceLocalized.setResourceId(resourceEnLocalized.getResourceId());
//							resourceLocalized.setLanguageId(langName);
//							resourceLocalized.setName(resourceEnLocalized.getName());
//							resourceLocalized.setRouteId(resourceEnLocalized.getRouteId());
//							resourceLocalized.setUrl(resourceEnLocalized.getUrl());
//							System.out.println("URL" + resourceEnLocalized.getUrl());
//							resourceLocalized.setAttach(resourceEnLocalized.getAttach());
//							resourceLocalized.setDescription(resourceEnLocalized.getDescription());
//							resourceLocalizationPersistence.update(resourceLocalized);
//						}
//
//					}
//
//					for (Lovs lov : lovs) {
//						List<LovData> lovData = lovDataPersistence.findByLovdata(lov.getId());
//						LovsLocalization lovsEnLocal = lovsLocalizationPersistence.fetchById_LanguageId(lov.getId(),
//								TelemoneyConstants.LANGUAGE_ENGLISH_NAME);
//						if (lovsEnLocal != null) {
//							LovsLocalization lovsLocal = lovsLocalizationPersistence
//									.create(CounterLocalServiceUtil.increment());
//							lovsLocal.setId(lovsEnLocal.getId());
//							lovsLocal.setLanguageId(langName);
//							lovsLocal.setName(lovsEnLocal.getName());
//							lovsLocalizationPersistence.update(lovsLocal);
//						}
//
//						for (LovData data : lovData) {
//							LovDataLocalization lovDataEnLocal = lovDataLocalizationPersistence
//									.fetchById_LanguageId(data.getId(), TelemoneyConstants.LANGUAGE_ENGLISH_NAME);
//							if (lovDataEnLocal != null) {
//								LovDataLocalization lovDataLocal = lovDataLocalizationPersistence
//										.create(CounterLocalServiceUtil.increment());
//								lovDataLocal.setId(lovDataEnLocal.getId());
//								lovDataLocal.setLanguageId(langName);
//								lovDataLocal.setRecordDescription(lovDataEnLocal.getRecordDescription());
//								lovDataLocalizationPersistence.update(lovDataLocal);
//							}
//						}
//					}
//
//				} catch (Exception e) {
//					LOG.info("----------------Language Fallback Failed-----------------");
//					LOG.error(e);
//					throw new Exception(e);
//				}
//			}

		} catch (Exception e) {
			LOG.info("----------------Language Failed-----------------");
			LOG.error(e);
			throw new Exception(e);
		}
	}
	public Languages updateStatus(long userId, long languageId, int status,
								  ServiceContext serviceContext) throws Exception {

		Languages language = languagesPersistence.findByPrimaryKey(languageId);

		// Set status metadata
		language.setStatusByUserId(userId);
		if (serviceContext != null && userId > 0) {
			language.setStatusByUserName(UserLocalServiceUtil.getUser(userId).getFullName());
		}
		language.setStatusDate(new Date());
		language.setModifiedDate(new Date());
		language = languagesPersistence.update(language);

		if (status == WorkflowConstants.STATUS_APPROVED) {
			// Read workflow action from the entity
			String workflowAction = language.getWorkflowAction();

			// DELETE action
			if (Constants.DELETE.equalsIgnoreCase(workflowAction)) {
				long entityResourceId = language.getEntityResourceId();
				deleteAllByEntityResourceId(entityResourceId);
				incrementGlobalVersion(language);
				LOG.info("All Language versions deleted for entityResourceId: " + entityResourceId);
				return language;
			}

			// UPDATE action
			if (Constants.UPDATE.equalsIgnoreCase(workflowAction)) {
				language.setStatus(status);
				languagesPersistence.update(language);
				incrementGlobalVersion(language);
				LOG.info("Language updated and approved: " + language.getLangName());
				return language;
			}

			// ADD action
			if (Constants.ADD.equalsIgnoreCase(workflowAction)) {
				language.setStatus(status);
				languagesPersistence.update(language);

				// Language fallback logic for non-English languages
				String langName = language.getLangName();
				if (!langName.equals(TelemoneyConstants.LANGUAGE_ENGLISH_NAME)) {
					applyLanguageFallback(userId, language);
				}

				incrementGlobalVersion(language);
				LOG.info("Language created and approved: " + language.getLangName());
				return language;
			}


			return language;
		}

		if (status == WorkflowConstants.STATUS_DENIED || status == WorkflowConstants.STATUS_EXPIRED) {
			language.setStatus(status);
			languagesPersistence.update(language);
			LOG.info("Language rejected/expired: " + language.getLangName());
		}

		return language;
	}

	private void applyLanguageFallback(long userId, Languages language) throws Exception {
		String langName = language.getLangName();
		long channelId = language.getChannelId();
		String userName = UserLocalServiceUtil.getUser(userId).getFullName();

		try {
			long langId = getByLangName(TelemoneyConstants.LANGUAGE_ENGLISH_NAME, channelId).get(0)
					.getLanguageId();
			LOG.info("----------------Language Fallback For Localization-----------------");
			long version = LocalizationLocalServiceUtil.getMaxVersion(langId, channelId);
			if (version > 0) {
				String enLocalValue = LocalizationLocalServiceUtil
						.getLocalByVersion_LangId(version, langId, channelId).get(0).getLocalValue();
				LocalizationLocalServiceUtil.updateLocalization(enLocalValue, language.getLanguageId(),
						channelId, userName);
			}

			LOG.info("----------------Language Fallback For Banner Content-----------------");

			List<BannerContent> bannerContents = bannerContentPersistence.findByChannelId(channelId);
			List<Resource> resourcesForFallback = resourcePersistence.findByChannelId(channelId);
			List<Lovs> lovs = lovsPersistence.findByChannelId(channelId);

			for (BannerContent bannerContent : bannerContents) {
				BannerContentLocalization bannerEnLocal = bannerContentLocalizationPersistence
						.fetchByContentId_LanguageId(bannerContent.getContentId(),
								TelemoneyConstants.LANGUAGE_ENGLISH_NAME);
				if (bannerEnLocal != null) {
					BannerContentLocalization bannerLocal = bannerContentLocalizationPersistence
							.create(CounterLocalServiceUtil.increment());
					bannerLocal.setContentId(bannerEnLocal.getContentId());
					bannerLocal.setLanguageId(langName);
					bannerLocal.setTitleValue(bannerEnLocal.getTitleValue());
					bannerLocal.setDescriptionValue(bannerEnLocal.getDescriptionValue());
					bannerLocal.setBannerImage(bannerEnLocal.getBannerImage());
					bannerLocal.setImageOverlay(bannerEnLocal.getImageOverlay());
					bannerLocal.setLinkType(bannerEnLocal.getLinkType());
					bannerLocal.setUrl(bannerEnLocal.getUrl());
					bannerContentLocalizationPersistence.update(bannerLocal);
				}
			}

			LOG.info("----------------Language Fallback For Resource Localization-----------------");

			for (Resource resource : resourcesForFallback) {
				ResourceLocalization resourceEnLocalized = resourceLocalizationPersistence
						.fetchByResourceId_LanguageId(resource.getResourceId(),
								TelemoneyConstants.LANGUAGE_ENGLISH_NAME);
				if (resourceEnLocalized != null) {
					ResourceLocalization resourceLocalized = resourceLocalizationPersistence
							.create(CounterLocalServiceUtil.increment());
					resourceLocalized.setMvccVersion(0);
					resourceLocalized.setResourceId(resourceEnLocalized.getResourceId());
					resourceLocalized.setLanguageId(langName);
					resourceLocalized.setName(resourceEnLocalized.getName());
					resourceLocalized.setRouteId(resourceEnLocalized.getRouteId());
					resourceLocalized.setUrl(resourceEnLocalized.getUrl());
					resourceLocalized.setAttach(resourceEnLocalized.getAttach());
					resourceLocalized.setDescription(resourceEnLocalized.getDescription());
					resourceLocalizationPersistence.update(resourceLocalized);
				}
			}

			for (Lovs lov : lovs) {
				List<LovData> lovData = lovDataPersistence.findByLovdata(lov.getId());
				LovsLocalization lovsEnLocal = lovsLocalizationPersistence.fetchById_LanguageId(lov.getId(),
						TelemoneyConstants.LANGUAGE_ENGLISH_NAME);
				if (lovsEnLocal != null) {
					LovsLocalization lovsLocal = lovsLocalizationPersistence
							.create(CounterLocalServiceUtil.increment());
					lovsLocal.setId(lovsEnLocal.getId());
					lovsLocal.setLanguageId(langName);
					lovsLocal.setName(lovsEnLocal.getName());
					lovsLocalizationPersistence.update(lovsLocal);
				}

				for (LovData data : lovData) {
					LovDataLocalization lovDataEnLocal = lovDataLocalizationPersistence
							.fetchById_LanguageId(data.getId(), TelemoneyConstants.LANGUAGE_ENGLISH_NAME);
					if (lovDataEnLocal != null) {
						LovDataLocalization lovDataLocal = lovDataLocalizationPersistence
								.create(CounterLocalServiceUtil.increment());
						lovDataLocal.setId(lovDataEnLocal.getId());
						lovDataLocal.setLanguageId(langName);
						lovDataLocal.setRecordDescription(lovDataEnLocal.getRecordDescription());
						lovDataLocalizationPersistence.update(lovDataLocal);
					}
				}
			}
		} catch (Exception e) {
			LOG.info("----------------Language Fallback Failed-----------------");
			LOG.error(e);
			throw new Exception(e);
		}
	}


	private void startWorkflow(Languages language, ServiceContext serviceContext, User user, Long originalEntityId, String type) throws PortalException {
		language.setGroupId(serviceContext.getScopeGroupId());
		language.setCompanyId(serviceContext.getCompanyId());
		language.setUserId(serviceContext.getUserId());
		language.setUserName(user.getFullName());

		if (language.getCreateDate() == null) {
			language.setCreateDate(new Date());
		}
		language.setModifiedDate(new Date());

		if (language.getUuid_() == null || language.getUuid_().isEmpty()) {
			language.setUuid_(PortalUUIDUtil.generate());
		}

		language.setOriginalEntityId(originalEntityId);
		language.setStatus(WorkflowConstants.STATUS_DRAFT);
		language.setStatusDate(new Date());

		// Persist workflow action on the entity
		if (Constants.ADD.equals(type) || Constants.CREATE.equals(type)) {
			language.setWorkflowAction(Constants.ADD);
		} else if (Constants.UPDATE.equals(type)) {
			language.setWorkflowAction(Constants.UPDATE);
		} else if (Constants.DELETE.equals(type)) {
			language.setWorkflowAction(Constants.DELETE);
		} else {
			language.setWorkflowAction(Constants.ADD);
		}

		language = languagesLocalService.updateLanguages(language);

		serviceContext.setAttribute(Constants.ENTITY_TYPE, Constants.LANGUAGE);
		serviceContext.setAttribute(Constants.USER_NAME, user.getFullName());
		serviceContext.setAttribute(Constants.REQUEST_ID, language.getLanguageId());

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
				Languages.class.getName(),
				language.getLanguageId(),
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames()
		);

		serviceContext.setAssetCategoryIds(null);
		serviceContext.setAssetTagNames(null);

		WorkflowHandlerRegistryUtil.startWorkflowInstance(
				serviceContext.getCompanyId(),
				serviceContext.getUserId(),
				Languages.class.getName(),
				language.getPrimaryKey(),
				language,
				serviceContext
		);

	}


	public void languageUpdate(Long id, String langName, String local, Long channelId, boolean primaryLanguage,
							   ServiceContext serviceContext, User user) throws Exception {
		try {
			Languages originalLanguage = languagesLocalService.getLanguages(id);

			// Block edits if there is any pending draft for the same entityResourceId
			if (hasPendingDraft(originalLanguage.getEntityResourceId())) {
				throw new Exception("This Language is currently locked because there is a pending change awaiting approval.");
			}

			// Create a new draft record
			Languages draftLanguage = this.languagesLocalService.createLanguages(CounterLocalServiceUtil.increment());
			draftLanguage.setChannelId(channelId);
			draftLanguage.setLangName(langName);
			draftLanguage.setLocal(local);
			draftLanguage.setPrimaryLanguage(primaryLanguage);

			// Set entityResourceId from original and increment version
			draftLanguage.setEntityResourceId(originalLanguage.getEntityResourceId());
			draftLanguage.setVersion(getMaxVersion(originalLanguage.getEntityResourceId()) + 1);

			startWorkflow(draftLanguage, serviceContext, user, id, Constants.UPDATE);
			languagesLocalService.updateLanguages(draftLanguage);

		} catch (Exception e) {
			LOG.info("----------------Language update Failed-----------------");
			LOG.error(e);
			throw new Exception(e);
		}
	}



	public void languageDelete(Long id, ServiceContext serviceContext, User user) throws Exception {
		try {
			Languages originalLanguage = languagesLocalService.getLanguages(id);

			// Block edits if there is any pending draft for the same entityResourceId
			if (hasPendingDraft(originalLanguage.getEntityResourceId())) {
				throw new Exception("This Language is currently locked because there is a pending change awaiting approval.");
			}

			Languages draftLanguage = this.languagesLocalService.createLanguages(CounterLocalServiceUtil.increment());
			copyProperties(originalLanguage, draftLanguage);

			// Set entityResourceId from original and increment version
			draftLanguage.setEntityResourceId(originalLanguage.getEntityResourceId());
			draftLanguage.setVersion(getMaxVersion(originalLanguage.getEntityResourceId()) + 1);

			startWorkflow(draftLanguage, serviceContext, user, id, Constants.DELETE);
		} catch (Exception e) {
			LOG.info("----------------Language Delete Failed-----------------");
			LOG.error(e);
			throw new Exception(e);
		}
	}

	private void copyProperties(Languages source, Languages target) {
		long temp = target.getLanguageId();
		target.setChannelId(source.getChannelId());
		target.setLangName(source.getLangName());
		target.setLocal(source.getLocal());
		target.setPrimaryLanguage(source.getPrimaryLanguage());
		target.setLanguageId(temp);
	}

	public List<Languages> getByLocal(String local, Long channeld) throws Exception {
		try {
			return languagesPersistence.findByLocal(channeld, local);
		} catch (Exception e) {
			LOG.info("----------------Language search Failed-----------------");
			LOG.error(e);
			throw new Exception(e);
		}
	}

	public List<Languages> getByLangName(String langName, Long channeld) throws Exception {
		try {
			return languagesPersistence.findByLangName(channeld, langName);
		} catch (Exception e) {
			LOG.info("----------------Language search Failed-----------------");
			LOG.error(e);
			throw new Exception(e);
		}
	}

	public List<Languages> getbyChannelId(Long channelId) {
		return languagesPersistence.findByChannelId(channelId);
	}

	public void addDefaultLanguage(Long channelId) {
		Languages createdLanguage = this.languagesLocalService.createLanguages(CounterLocalServiceUtil.increment());
		createdLanguage.setChannelId(channelId);
		createdLanguage.setLangName(TelemoneyConstants.LANGUAGE_ENGLISH_NAME);
		createdLanguage.setLocal(TelemoneyConstants.LANGUAGE_ENGLISH_LOCAL);
		createdLanguage.setPrimaryLanguage(true);
		languagesLocalService.updateLanguages(createdLanguage);
		incrementGlobalVersion(createdLanguage);
	}

	/**
	 * Returns the max version for all Language rows under the same entityResourceId.
	 */
	private int getMaxVersion(long entityResourceId) {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Languages.class, getClassLoader());
		query.add(RestrictionsFactoryUtil.eq("entityResourceId", entityResourceId));
		query.setProjection(ProjectionFactoryUtil.max("version"));

		@SuppressWarnings("unchecked")
		List<Integer> results = languagesLocalService.dynamicQuery(query);

		if (results != null && !results.isEmpty() && results.get(0) != null) {
			return results.get(0);
		}
		return 0;
	}

	/**
	 * Returns latest APPROVED Languages entries for the channel (latest version per entityResourceId).
	 */
	public List<Languages> getLatestApprovedByChannelId(long channelId) {
		DynamicQuery dq = dynamicQuery();

		dq.add(RestrictionsFactoryUtil.eq("channelId", channelId));
		dq.add(RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_APPROVED));

		dq.addOrder(OrderFactoryUtil.asc("entityResourceId"));
		dq.addOrder(OrderFactoryUtil.desc("version"));

		List<Languages> allApproved = languagesPersistence.findWithDynamicQuery(dq);

		Map<Long, Languages> latestByResource = new LinkedHashMap<>();

		for (Languages language : allApproved) {
			if (!latestByResource.containsKey(language.getEntityResourceId())) {
				latestByResource.put(language.getEntityResourceId(), language);
			}
		}

		return new ArrayList<>(latestByResource.values());
	}

	/**
	 * Returns latest APPROVED Languages entries for the channel along with a flag indicating whether
	 * that language (entityResourceId) currently has a pending draft awaiting approval.
	 *
	 * Map key: latest approved Language for an entityResourceId
	 * Map value: true if there is any STATUS_DRAFT row for that entityResourceId
	 */
	public Map<Languages, Boolean> getLatestApprovedByChannelIdWithPending(long channelId) {
		List<Languages> latestApproved = getLatestApprovedByChannelId(channelId);

		Map<Languages, Boolean> result = new LinkedHashMap<>();

		for (Languages language : latestApproved) {
			boolean pending = hasPendingDraft(language.getEntityResourceId());
			result.put(language, pending);
		}

		return result;
	}

	private boolean hasPendingDraft(long entityResourceId) {
		try {
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(Languages.class, getClassLoader());
			query.add(RestrictionsFactoryUtil.eq("entityResourceId", entityResourceId));
			query.add(RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_DRAFT));

			List<Languages> versions = languagesLocalService.dynamicQuery(query);

			return !versions.isEmpty();
		} catch (Exception e) {
			LOG.error("Unable to evaluate pending drafts for entityResourceId " + entityResourceId, e);
			// Fail closed: better to block edits than allow concurrent conflicting drafts.
			return true;
		}
	}

	private void deleteAllByEntityResourceId(long entityResourceId) {
		try {
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(Languages.class, getClassLoader());
			query.add(RestrictionsFactoryUtil.eq("entityResourceId", entityResourceId));

			List<Languages> languages = languagesLocalService.dynamicQuery(query);

			for (Languages lang : languages) {
				languagesPersistence.remove(lang);
			}
		} catch (Exception e) {
			LOG.error("Unable to delete languages for entityResourceId " + entityResourceId, e);
			throw new RuntimeException("Failed to delete languages for entityResourceId " + entityResourceId, e);
		}
	}

	/**
	 * User Story 5 - Global Component Versioning.
	 *
	 * <p>
	 * An approved change to the Languages component bumps the internal
	 * {@code languageVersion} version for this company/channel. Runs in the same
	 * transaction as the approval so both succeed or roll back together.
	 * </p>
	 */
	private void incrementGlobalVersion(Languages language) {
		GlobalVersionLocalServiceUtil.incrementApprovedVersion(
				language.getCompanyId(),
				language.getChannelId(),
				ComponentType.LANGUAGE.name());
	}

}