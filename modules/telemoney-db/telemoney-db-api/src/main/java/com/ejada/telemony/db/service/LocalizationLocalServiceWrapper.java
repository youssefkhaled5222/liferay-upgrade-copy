/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link LocalizationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LocalizationLocalService
 * @generated
 */
public class LocalizationLocalServiceWrapper
	implements LocalizationLocalService,
			   ServiceWrapper<LocalizationLocalService> {

	public LocalizationLocalServiceWrapper() {
		this(null);
	}

	public LocalizationLocalServiceWrapper(
		LocalizationLocalService localizationLocalService) {

		_localizationLocalService = localizationLocalService;
	}

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
	@Override
	public com.ejada.telemony.db.model.Localization addLocalization(
		com.ejada.telemony.db.model.Localization localization) {

		return _localizationLocalService.addLocalization(localization);
	}

	@Override
	public java.util.Set<String> checkKeys(long channelId) {
		return _localizationLocalService.checkKeys(channelId);
	}

	/**
	 * Creates a new localization with the primary key. Does not add the localization to the database.
	 *
	 * @param localizationId the primary key for the new localization
	 * @return the new localization
	 */
	@Override
	public com.ejada.telemony.db.model.Localization createLocalization(
		long localizationId) {

		return _localizationLocalService.createLocalization(localizationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _localizationLocalService.createPersistedModel(primaryKeyObj);
	}

	@Override
	public void deleteLocales(long langId, String userName, long channelId) {
		_localizationLocalService.deleteLocales(langId, userName, channelId);
	}

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
	@Override
	public com.ejada.telemony.db.model.Localization deleteLocalization(
		com.ejada.telemony.db.model.Localization localization) {

		return _localizationLocalService.deleteLocalization(localization);
	}

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
	@Override
	public com.ejada.telemony.db.model.Localization deleteLocalization(
			long localizationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _localizationLocalService.deleteLocalization(localizationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _localizationLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _localizationLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _localizationLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _localizationLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _localizationLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _localizationLocalService.dynamicQuery(dynamicQuery, start, end);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _localizationLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _localizationLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _localizationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.telemony.db.model.Localization fetchLocalization(
		long localizationId) {

		return _localizationLocalService.fetchLocalization(localizationId);
	}

	@Override
	public java.util.Set<String> findDuplicateKeysAcrossFeatures(
		java.util.Set<String> newKeys, long channelId, long currentFeatureId) {

		return _localizationLocalService.findDuplicateKeysAcrossFeatures(
			newKeys, channelId, currentFeatureId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _localizationLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Localization>
		getAllLocalizations() {

		return _localizationLocalService.getAllLocalizations();
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Localization>
		getbyChannelId(Long channelId) {

		return _localizationLocalService.getbyChannelId(channelId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Localization>
		getByWorkflowBatchId(String workflowBatchId) {

		return _localizationLocalService.getByWorkflowBatchId(workflowBatchId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _localizationLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Localization>
		getLocalByVersion_LangId(
			long version, long languageId, long channelId) {

		return _localizationLocalService.getLocalByVersion_LangId(
			version, languageId, channelId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Localization>
		getLocalByVersion_LangId_FeatureId(
			long version, long languageId, long channelId, long featureId) {

		return _localizationLocalService.getLocalByVersion_LangId_FeatureId(
			version, languageId, channelId, featureId);
	}

	/**
	 * Returns the localization with the primary key.
	 *
	 * @param localizationId the primary key of the localization
	 * @return the localization
	 * @throws PortalException if a localization with the primary key could not be found
	 */
	@Override
	public com.ejada.telemony.db.model.Localization getLocalization(
			long localizationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _localizationLocalService.getLocalization(localizationId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getLocalizationAPI(
			long channelId, String languageName, String languageCode,
			int version)
		throws Exception {

		return _localizationLocalService.getLocalizationAPI(
			channelId, languageName, languageCode, version);
	}

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
	@Override
	public java.util.List<com.ejada.telemony.db.model.Localization>
		getLocalizations(int start, int end) {

		return _localizationLocalService.getLocalizations(start, end);
	}

	/**
	 * Returns the number of localizations.
	 *
	 * @return the number of localizations
	 */
	@Override
	public int getLocalizationsCount() {
		return _localizationLocalService.getLocalizationsCount();
	}

	@Override
	public long getMaxApprovedVersionByFeature(
		long langId, Long channelId, long featureId) {

		return _localizationLocalService.getMaxApprovedVersionByFeature(
			langId, channelId, featureId);
	}

	@Override
	public long getMaxDraftVersionByFeature(
		long langId, Long channelId, long featureId) {

		return _localizationLocalService.getMaxDraftVersionByFeature(
			langId, channelId, featureId);
	}

	@Override
	public long getMaxGlobalVersion(long channelId) {
		return _localizationLocalService.getMaxGlobalVersion(channelId);
	}

	@Override
	public long getMaxGlobalVersionByLanguage(long channelId, long languageId) {
		return _localizationLocalService.getMaxGlobalVersionByLanguage(
			channelId, languageId);
	}

	@Override
	public long getMaxVersion(long langId, Long channelId) {
		return _localizationLocalService.getMaxVersion(langId, channelId);
	}

	@Override
	public long getMaxVersionByFeature(
		long langId, Long channelId, long featureId) {

		return _localizationLocalService.getMaxVersionByFeature(
			langId, channelId, featureId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _localizationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _localizationLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean hasPendingDraft(long channelId) {
		return _localizationLocalService.hasPendingDraft(channelId);
	}

	@Override
	public void importLocalization(
		com.ejada.telemony.db.model.ImportRequest importRequest,
		com.liferay.portal.kernel.json.JSONArray dataJson) {

		_localizationLocalService.importLocalization(importRequest, dataJson);
	}

	@Override
	public void rollbackLocalization(
		com.ejada.telemony.db.model.Localization localization) {

		_localizationLocalService.rollbackLocalization(localization);
	}

	@Override
	public void stampGlobalVersion(long channelId, long languageId) {
		_localizationLocalService.stampGlobalVersion(channelId, languageId);
	}

	@Override
	public void startWorkflow(
			com.ejada.telemony.db.model.Localization localization,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws com.liferay.portal.kernel.exception.PortalException {

		_localizationLocalService.startWorkflow(
			localization, serviceContext, user);
	}

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
	@Override
	public com.ejada.telemony.db.model.Localization updateLocalization(
		com.ejada.telemony.db.model.Localization localization) {

		return _localizationLocalService.updateLocalization(localization);
	}

	@Override
	public void updateLocalization(
		String localValue, long languageId, long channelId, long featureId,
		String userName, com.liferay.portal.kernel.model.User user,
		String workflowBatchId,
		com.ejada.telemony.db.model.Localization originalLocalization,
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		com.ejada.telemony.db.model.ImportRequest importRequest) {

		_localizationLocalService.updateLocalization(
			localValue, languageId, channelId, featureId, userName, user,
			workflowBatchId, originalLocalization, serviceContext,
			importRequest);
	}

	@Override
	public void updateLocalization(
		String localValue, long languageId, long channelId, String userName) {

		_localizationLocalService.updateLocalization(
			localValue, languageId, channelId, userName);
	}

	@Override
	public com.ejada.telemony.db.model.Localization updateStatus(
			long userId, long langId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _localizationLocalService.updateStatus(
			userId, langId, status, serviceContext);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _localizationLocalService.getBasePersistence();
	}

	@Override
	public LocalizationLocalService getWrappedService() {
		return _localizationLocalService;
	}

	@Override
	public void setWrappedService(
		LocalizationLocalService localizationLocalService) {

		_localizationLocalService = localizationLocalService;
	}

	private LocalizationLocalService _localizationLocalService;

}