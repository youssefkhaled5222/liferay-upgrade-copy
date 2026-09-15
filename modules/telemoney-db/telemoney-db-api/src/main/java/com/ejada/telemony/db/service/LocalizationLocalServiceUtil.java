/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.ejada.telemony.db.model.Localization;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Set;

/**
 * Provides the local service utility for Localization. This utility wraps
 * <code>com.ejada.telemony.db.service.impl.LocalizationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LocalizationLocalService
 * @generated
 */
public class LocalizationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.LocalizationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
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
	public static Localization addLocalization(Localization localization) {
		return getService().addLocalization(localization);
	}

	public static Set<String> checkKeys(long channelId) {
		return getService().checkKeys(channelId);
	}

	/**
	 * Creates a new localization with the primary key. Does not add the localization to the database.
	 *
	 * @param localizationId the primary key for the new localization
	 * @return the new localization
	 */
	public static Localization createLocalization(long localizationId) {
		return getService().createLocalization(localizationId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static void deleteLocales(
		long langId, String userName, long channelId) {

		getService().deleteLocales(langId, userName, channelId);
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
	public static Localization deleteLocalization(Localization localization) {
		return getService().deleteLocalization(localization);
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
	public static Localization deleteLocalization(long localizationId)
		throws PortalException {

		return getService().deleteLocalization(localizationId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Localization fetchLocalization(long localizationId) {
		return getService().fetchLocalization(localizationId);
	}

	public static Set<String> findDuplicateKeysAcrossFeatures(
		Set<String> newKeys, long channelId, long currentFeatureId) {

		return getService().findDuplicateKeysAcrossFeatures(
			newKeys, channelId, currentFeatureId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<Localization> getAllLocalizations() {
		return getService().getAllLocalizations();
	}

	public static List<Localization> getbyChannelId(Long channelId) {
		return getService().getbyChannelId(channelId);
	}

	public static List<Localization> getByWorkflowBatchId(
		String workflowBatchId) {

		return getService().getByWorkflowBatchId(workflowBatchId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static List<Localization> getLocalByVersion_LangId(
		long version, long languageId, long channelId) {

		return getService().getLocalByVersion_LangId(
			version, languageId, channelId);
	}

	public static List<Localization> getLocalByVersion_LangId_FeatureId(
		long version, long languageId, long channelId, long featureId) {

		return getService().getLocalByVersion_LangId_FeatureId(
			version, languageId, channelId, featureId);
	}

	/**
	 * Returns the localization with the primary key.
	 *
	 * @param localizationId the primary key of the localization
	 * @return the localization
	 * @throws PortalException if a localization with the primary key could not be found
	 */
	public static Localization getLocalization(long localizationId)
		throws PortalException {

		return getService().getLocalization(localizationId);
	}

	public static com.liferay.portal.kernel.json.JSONObject getLocalizationAPI(
			long channelId, String languageName, String languageCode,
			int version)
		throws Exception {

		return getService().getLocalizationAPI(
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
	public static List<Localization> getLocalizations(int start, int end) {
		return getService().getLocalizations(start, end);
	}

	/**
	 * Returns the number of localizations.
	 *
	 * @return the number of localizations
	 */
	public static int getLocalizationsCount() {
		return getService().getLocalizationsCount();
	}

	public static long getMaxApprovedVersionByFeature(
		long langId, Long channelId, long featureId) {

		return getService().getMaxApprovedVersionByFeature(
			langId, channelId, featureId);
	}

	public static long getMaxDraftVersionByFeature(
		long langId, Long channelId, long featureId) {

		return getService().getMaxDraftVersionByFeature(
			langId, channelId, featureId);
	}

	public static long getMaxGlobalVersion(long channelId) {
		return getService().getMaxGlobalVersion(channelId);
	}

	public static long getMaxGlobalVersionByLanguage(
		long channelId, long languageId) {

		return getService().getMaxGlobalVersionByLanguage(
			channelId, languageId);
	}

	public static long getMaxVersion(long langId, Long channelId) {
		return getService().getMaxVersion(langId, channelId);
	}

	public static long getMaxVersionByFeature(
		long langId, Long channelId, long featureId) {

		return getService().getMaxVersionByFeature(
			langId, channelId, featureId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static boolean hasPendingDraft(long channelId) {
		return getService().hasPendingDraft(channelId);
	}

	public static void importLocalization(
		com.ejada.telemony.db.model.ImportRequest importRequest,
		com.liferay.portal.kernel.json.JSONArray dataJson) {

		getService().importLocalization(importRequest, dataJson);
	}

	public static void rollbackLocalization(Localization localization) {
		getService().rollbackLocalization(localization);
	}

	public static void stampGlobalVersion(long channelId, long languageId) {
		getService().stampGlobalVersion(channelId, languageId);
	}

	public static void startWorkflow(
			Localization localization,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws PortalException {

		getService().startWorkflow(localization, serviceContext, user);
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
	public static Localization updateLocalization(Localization localization) {
		return getService().updateLocalization(localization);
	}

	public static void updateLocalization(
		String localValue, long languageId, long channelId, long featureId,
		String userName, com.liferay.portal.kernel.model.User user,
		String workflowBatchId, Localization originalLocalization,
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		com.ejada.telemony.db.model.ImportRequest importRequest) {

		getService().updateLocalization(
			localValue, languageId, channelId, featureId, userName, user,
			workflowBatchId, originalLocalization, serviceContext,
			importRequest);
	}

	public static void updateLocalization(
		String localValue, long languageId, long channelId, String userName) {

		getService().updateLocalization(
			localValue, languageId, channelId, userName);
	}

	public static Localization updateStatus(
			long userId, long langId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		return getService().updateStatus(
			userId, langId, status, serviceContext);
	}

	public static LocalizationLocalService getService() {
		return _service;
	}

	public static void setService(LocalizationLocalService service) {
		_service = service;
	}

	private static volatile LocalizationLocalService _service;

}