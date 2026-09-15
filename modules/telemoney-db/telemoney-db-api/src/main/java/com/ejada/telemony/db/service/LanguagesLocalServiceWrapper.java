/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link LanguagesLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LanguagesLocalService
 * @generated
 */
public class LanguagesLocalServiceWrapper
	implements LanguagesLocalService, ServiceWrapper<LanguagesLocalService> {

	public LanguagesLocalServiceWrapper() {
		this(null);
	}

	public LanguagesLocalServiceWrapper(
		LanguagesLocalService languagesLocalService) {

		_languagesLocalService = languagesLocalService;
	}

	@Override
	public void addDefaultLanguage(Long channelId) {
		_languagesLocalService.addDefaultLanguage(channelId);
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
	@Override
	public com.ejada.telemony.db.model.Languages addLanguages(
		com.ejada.telemony.db.model.Languages languages) {

		return _languagesLocalService.addLanguages(languages);
	}

	@Override
	public void addNewLanguage(
			String langName, String local, String userName, Long channelId,
			boolean primaryLanguage, com.liferay.portal.kernel.model.User user,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws Exception {

		_languagesLocalService.addNewLanguage(
			langName, local, userName, channelId, primaryLanguage, user,
			serviceContext);
	}

	/**
	 * Creates a new languages with the primary key. Does not add the languages to the database.
	 *
	 * @param languageId the primary key for the new languages
	 * @return the new languages
	 */
	@Override
	public com.ejada.telemony.db.model.Languages createLanguages(
		long languageId) {

		return _languagesLocalService.createLanguages(languageId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _languagesLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.ejada.telemony.db.model.Languages deleteLanguages(
		com.ejada.telemony.db.model.Languages languages) {

		return _languagesLocalService.deleteLanguages(languages);
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
	@Override
	public com.ejada.telemony.db.model.Languages deleteLanguages(
			long languageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _languagesLocalService.deleteLanguages(languageId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _languagesLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _languagesLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _languagesLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _languagesLocalService.dynamicQuery();
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

		return _languagesLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _languagesLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _languagesLocalService.dynamicQuery(
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

		return _languagesLocalService.dynamicQueryCount(dynamicQuery);
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

		return _languagesLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.telemony.db.model.Languages fetchLanguages(
		long languageId) {

		return _languagesLocalService.fetchLanguages(languageId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _languagesLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Languages> getbyChannelId(
		Long channelId) {

		return _languagesLocalService.getbyChannelId(channelId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Languages> getByLangName(
			String langName, Long channeld)
		throws Exception {

		return _languagesLocalService.getByLangName(langName, channeld);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Languages> getByLocal(
			String local, Long channeld)
		throws Exception {

		return _languagesLocalService.getByLocal(local, channeld);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _languagesLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the languages with the primary key.
	 *
	 * @param languageId the primary key of the languages
	 * @return the languages
	 * @throws PortalException if a languages with the primary key could not be found
	 */
	@Override
	public com.ejada.telemony.db.model.Languages getLanguages(long languageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _languagesLocalService.getLanguages(languageId);
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
	@Override
	public java.util.List<com.ejada.telemony.db.model.Languages> getLanguageses(
		int start, int end) {

		return _languagesLocalService.getLanguageses(start, end);
	}

	/**
	 * Returns the number of languageses.
	 *
	 * @return the number of languageses
	 */
	@Override
	public int getLanguagesesCount() {
		return _languagesLocalService.getLanguagesesCount();
	}

	/**
	 * Returns latest APPROVED Languages entries for the channel (latest version per entityResourceId).
	 */
	@Override
	public java.util.List<com.ejada.telemony.db.model.Languages>
		getLatestApprovedByChannelId(long channelId) {

		return _languagesLocalService.getLatestApprovedByChannelId(channelId);
	}

	/**
	 * Returns latest APPROVED Languages entries for the channel along with a flag indicating whether
	 * that language (entityResourceId) currently has a pending draft awaiting approval.
	 *
	 * Map key: latest approved Language for an entityResourceId
	 * Map value: true if there is any STATUS_DRAFT row for that entityResourceId
	 */
	@Override
	public java.util.Map<com.ejada.telemony.db.model.Languages, Boolean>
		getLatestApprovedByChannelIdWithPending(long channelId) {

		return _languagesLocalService.getLatestApprovedByChannelIdWithPending(
			channelId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _languagesLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _languagesLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public void languageDelete(
			Long id,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws Exception {

		_languagesLocalService.languageDelete(id, serviceContext, user);
	}

	@Override
	public void languageUpdate(
			Long id, String langName, String local, Long channelId,
			boolean primaryLanguage,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws Exception {

		_languagesLocalService.languageUpdate(
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
	@Override
	public com.ejada.telemony.db.model.Languages updateLanguages(
		com.ejada.telemony.db.model.Languages languages) {

		return _languagesLocalService.updateLanguages(languages);
	}

	@Override
	public com.ejada.telemony.db.model.Languages updateStatus(
			long userId, long languageId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws Exception {

		return _languagesLocalService.updateStatus(
			userId, languageId, status, serviceContext);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _languagesLocalService.getBasePersistence();
	}

	@Override
	public LanguagesLocalService getWrappedService() {
		return _languagesLocalService;
	}

	@Override
	public void setWrappedService(LanguagesLocalService languagesLocalService) {
		_languagesLocalService = languagesLocalService;
	}

	private LanguagesLocalService _languagesLocalService;

}