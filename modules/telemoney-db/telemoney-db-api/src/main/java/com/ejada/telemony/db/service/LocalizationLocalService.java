/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.ejada.telemony.db.model.*;
import com.ejada.telemony.db.model.ImportRequest;
import com.ejada.telemony.db.model.Localization;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.*;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Localization. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see LocalizationLocalServiceUtil
 * @generated
 */
@OSGiBeanProperties(
	property = {"model.class.name=com.ejada.telemony.db.model.Localization"}
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface LocalizationLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.LocalizationLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the localization local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link LocalizationLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the localization to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LocalizationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param localization the localization
	 * @return the localization that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Localization addLocalization(Localization localization);

	public java.util.Set<String> checkKeys(long channelId);

	/**
	 * Creates a new localization with the primary key. Does not add the localization to the database.
	 *
	 * @param localizationId the primary key for the new localization
	 * @return the new localization
	 */
	@Transactional(enabled = false)
	public Localization createLocalization(long localizationId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public void deleteLocales(long langId, String userName, long channelId);

	/**
	 * Deletes the localization from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LocalizationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param localization the localization
	 * @return the localization that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public Localization deleteLocalization(Localization localization);

	/**
	 * Deletes the localization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LocalizationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param localizationId the primary key of the localization
	 * @return the localization that was removed
	 * @throws PortalException if a localization with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public Localization deleteLocalization(long localizationId)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Localization fetchLocalization(long localizationId);

	public java.util.Set<String> findDuplicateKeysAcrossFeatures(
		java.util.Set<String> newKeys, long channelId, long currentFeatureId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Localization> getAllLocalizations();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Localization> getbyChannelId(Long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Localization> getByWorkflowBatchId(String workflowBatchId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Localization> getLocalByVersion_LangId(
		long version, long languageId, long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Localization> getLocalByVersion_LangId_FeatureId(
		long version, long languageId, long channelId, long featureId);

	/**
	 * Returns the localization with the primary key.
	 *
	 * @param localizationId the primary key of the localization
	 * @return the localization
	 * @throws PortalException if a localization with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Localization getLocalization(long localizationId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getLocalizationAPI(
			long channelId, String languageName, String languageCode,
			int version)
		throws Exception;

	/**
	 * Returns a range of all the localizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @return the range of localizations
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Localization> getLocalizations(int start, int end);

	/**
	 * Returns the number of localizations.
	 *
	 * @return the number of localizations
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLocalizationsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getMaxApprovedVersionByFeature(
		long langId, Long channelId, long featureId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getMaxDraftVersionByFeature(
		long langId, Long channelId, long featureId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getMaxGlobalVersion(long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getMaxGlobalVersionByLanguage(long channelId, long languageId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getMaxVersion(long langId, Long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getMaxVersionByFeature(
		long langId, Long channelId, long featureId);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasPendingDraft(long channelId);

	public void importLocalization(
		ImportRequest importRequest, JSONArray dataJson);

	public void rollbackLocalization(Localization localization);

	public void stampGlobalVersion(long channelId, long languageId);

	public void startWorkflow(
			Localization localization, ServiceContext serviceContext, User user)
		throws PortalException;

	/**
	 * Updates the localization in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LocalizationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param localization the localization
	 * @return the localization that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Localization updateLocalization(Localization localization);

	public void updateLocalization(
		String localValue, long languageId, long channelId, long featureId,
		String userName, User user, String workflowBatchId,
		Localization originalLocalization, ServiceContext serviceContext,
		ImportRequest importRequest);

	public void updateLocalization(
		String localValue, long languageId, long channelId, String userName);

	public Localization updateStatus(
			long userId, long langId, int status, ServiceContext serviceContext)
		throws PortalException, SystemException;

}