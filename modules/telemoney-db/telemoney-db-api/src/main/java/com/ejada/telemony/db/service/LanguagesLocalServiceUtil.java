/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.ejada.telemony.db.model.Languages;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for Languages. This utility wraps
 * <code>com.ejada.telemony.db.service.impl.LanguagesLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LanguagesLocalService
 * @generated
 */
public class LanguagesLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.LanguagesLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addDefaultLanguage(Long channelId) {
		getService().addDefaultLanguage(channelId);
	}

	/**
	 * Adds the languages to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LanguagesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param languages the languages
	 * @return the languages that was added
	 */
	public static Languages addLanguages(Languages languages) {
		return getService().addLanguages(languages);
	}

	public static void addNewLanguage(
			String langName, String local, String userName, Long channelId,
			boolean primaryLanguage, com.liferay.portal.kernel.model.User user,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws Exception {

		getService().addNewLanguage(
			langName, local, userName, channelId, primaryLanguage, user,
			serviceContext);
	}

	/**
	 * Creates a new languages with the primary key. Does not add the languages to the database.
	 *
	 * @param languageId the primary key for the new languages
	 * @return the new languages
	 */
	public static Languages createLanguages(long languageId) {
		return getService().createLanguages(languageId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the languages from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LanguagesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param languages the languages
	 * @return the languages that was removed
	 */
	public static Languages deleteLanguages(Languages languages) {
		return getService().deleteLanguages(languages);
	}

	/**
	 * Deletes the languages with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LanguagesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param languageId the primary key of the languages
	 * @return the languages that was removed
	 * @throws PortalException if a languages with the primary key could not be found
	 */
	public static Languages deleteLanguages(long languageId)
		throws PortalException {

		return getService().deleteLanguages(languageId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.LanguagesModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.LanguagesModelImpl</code>.
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

	public static Languages fetchLanguages(long languageId) {
		return getService().fetchLanguages(languageId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<Languages> getbyChannelId(Long channelId) {
		return getService().getbyChannelId(channelId);
	}

	public static List<Languages> getByLangName(String langName, Long channeld)
		throws Exception {

		return getService().getByLangName(langName, channeld);
	}

	public static List<Languages> getByLocal(String local, Long channeld)
		throws Exception {

		return getService().getByLocal(local, channeld);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the languages with the primary key.
	 *
	 * @param languageId the primary key of the languages
	 * @return the languages
	 * @throws PortalException if a languages with the primary key could not be found
	 */
	public static Languages getLanguages(long languageId)
		throws PortalException {

		return getService().getLanguages(languageId);
	}

	/**
	 * Returns a range of all the languageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.LanguagesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of languageses
	 * @param end the upper bound of the range of languageses (not inclusive)
	 * @return the range of languageses
	 */
	public static List<Languages> getLanguageses(int start, int end) {
		return getService().getLanguageses(start, end);
	}

	/**
	 * Returns the number of languageses.
	 *
	 * @return the number of languageses
	 */
	public static int getLanguagesesCount() {
		return getService().getLanguagesesCount();
	}

	/**
	 * Returns latest APPROVED Languages entries for the channel (latest version per entityResourceId).
	 */
	public static List<Languages> getLatestApprovedByChannelId(long channelId) {
		return getService().getLatestApprovedByChannelId(channelId);
	}

	/**
	 * Returns latest APPROVED Languages entries for the channel along with a flag indicating whether
	 * that language (entityResourceId) currently has a pending draft awaiting approval.
	 *
	 * Map key: latest approved Language for an entityResourceId
	 * Map value: true if there is any STATUS_DRAFT row for that entityResourceId
	 */
	public static Map<Languages, Boolean>
		getLatestApprovedByChannelIdWithPending(long channelId) {

		return getService().getLatestApprovedByChannelIdWithPending(channelId);
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

	public static void languageDelete(
			Long id,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws Exception {

		getService().languageDelete(id, serviceContext, user);
	}

	public static void languageUpdate(
			Long id, String langName, String local, Long channelId,
			boolean primaryLanguage,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws Exception {

		getService().languageUpdate(
			id, langName, local, channelId, primaryLanguage, serviceContext,
			user);
	}

	/**
	 * Updates the languages in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LanguagesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param languages the languages
	 * @return the languages that was updated
	 */
	public static Languages updateLanguages(Languages languages) {
		return getService().updateLanguages(languages);
	}

	public static Languages updateStatus(
			long userId, long languageId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws Exception {

		return getService().updateStatus(
			userId, languageId, status, serviceContext);
	}

	public static LanguagesLocalService getService() {
		return _service;
	}

	public static void setService(LanguagesLocalService service) {
		_service = service;
	}

	private static volatile LanguagesLocalService _service;

}