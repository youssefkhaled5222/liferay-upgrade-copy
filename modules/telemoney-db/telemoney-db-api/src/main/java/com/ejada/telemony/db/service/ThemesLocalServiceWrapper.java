/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ThemesLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ThemesLocalService
 * @generated
 */
public class ThemesLocalServiceWrapper
	implements ServiceWrapper<ThemesLocalService>, ThemesLocalService {

	public ThemesLocalServiceWrapper() {
		this(null);
	}

	public ThemesLocalServiceWrapper(ThemesLocalService themesLocalService) {
		_themesLocalService = themesLocalService;
	}

	@Override
	public void addDefaultDarkTheme(Long channelId) {
		_themesLocalService.addDefaultDarkTheme(channelId);
	}

	@Override
	public void addDefaultLightTheme(Long channelId) {
		_themesLocalService.addDefaultLightTheme(channelId);
	}

	@Override
	public void addTheme(
		long channelId, String enName, String arName, boolean darkTheme,
		String neutralColors, String primaryColors, String secondaryColors,
		String successColors, String errorColors, String warningColors,
		String supportColors, String gradientColors, String splashBg,
		String splashAnimation, String headerBg, String balanceBg,
		boolean deafultTheme, long themeId) {

		_themesLocalService.addTheme(
			channelId, enName, arName, darkTheme, neutralColors, primaryColors,
			secondaryColors, successColors, errorColors, warningColors,
			supportColors, gradientColors, splashBg, splashAnimation, headerBg,
			balanceBg, deafultTheme, themeId);
	}

	/**
	 * Adds the themes to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ThemesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param themes the themes
	 * @return the themes that was added
	 */
	@Override
	public com.ejada.telemony.db.model.Themes addThemes(
		com.ejada.telemony.db.model.Themes themes) {

		return _themesLocalService.addThemes(themes);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Persona> checkTheme(
		Long channelId, Long themeId) {

		return _themesLocalService.checkTheme(channelId, themeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _themesLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new themes with the primary key. Does not add the themes to the database.
	 *
	 * @param themeId the primary key for the new themes
	 * @return the new themes
	 */
	@Override
	public com.ejada.telemony.db.model.Themes createThemes(long themeId) {
		return _themesLocalService.createThemes(themeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _themesLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public void deleteTheme(Long themeId, Long channelId) throws Exception {
		_themesLocalService.deleteTheme(themeId, channelId);
	}

	/**
	 * Deletes the themes with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ThemesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param themeId the primary key of the themes
	 * @return the themes that was removed
	 * @throws PortalException if a themes with the primary key could not be found
	 */
	@Override
	public com.ejada.telemony.db.model.Themes deleteThemes(long themeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _themesLocalService.deleteThemes(themeId);
	}

	/**
	 * Deletes the themes from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ThemesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param themes the themes
	 * @return the themes that was removed
	 */
	@Override
	public com.ejada.telemony.db.model.Themes deleteThemes(
		com.ejada.telemony.db.model.Themes themes) {

		return _themesLocalService.deleteThemes(themes);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _themesLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _themesLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _themesLocalService.dynamicQuery();
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

		return _themesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.ThemesModelImpl</code>.
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

		return _themesLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.ThemesModelImpl</code>.
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

		return _themesLocalService.dynamicQuery(
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

		return _themesLocalService.dynamicQueryCount(dynamicQuery);
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

		return _themesLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.ejada.telemony.db.model.Themes fetchThemes(long themeId) {
		return _themesLocalService.fetchThemes(themeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _themesLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Themes>
		getAllDefaultThemes(Long channelId) {

		return _themesLocalService.getAllDefaultThemes(channelId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Themes>
		getAllNonDefaultThemes(Long channelId) {

		return _themesLocalService.getAllNonDefaultThemes(channelId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Themes> getbyChannelId(
		Long channelId) {

		return _themesLocalService.getbyChannelId(channelId);
	}

	@Override
	public com.ejada.telemony.db.model.Themes getDefaultTheme(
		boolean mode, Long channelId) {

		return _themesLocalService.getDefaultTheme(mode, channelId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _themesLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Themes>
		getLatestApprovedByChannelId(long channelId) {

		return _themesLocalService.getLatestApprovedByChannelId(channelId);
	}

	/**
	 * Returns latest APPROVED Themes entries for the channel along with a flag indicating whether
	 * that Theme (entityResourceId) currently has a pending draft awaiting approval.
	 *
	 * Map key: latest approved Theme for an entityResourceId
	 * Map value: true if there is any STATUS_DRAFT row for that entityResourceId
	 */
	@Override
	public java.util.Map<com.ejada.telemony.db.model.Themes, Boolean>
		getLatestApprovedByChannelIdWithPending(long channelId) {

		return _themesLocalService.getLatestApprovedByChannelIdWithPending(
			channelId);
	}

	@Override
	public com.ejada.telemony.db.model.Themes
		getLatestApprovedByEntityResourceId(long entityResourceId) {

		return _themesLocalService.getLatestApprovedByEntityResourceId(
			entityResourceId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Themes>
		getLatestApprovedWithoutPendingByChannelId(long channelId) {

		return _themesLocalService.getLatestApprovedWithoutPendingByChannelId(
			channelId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _themesLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _themesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the themes with the primary key.
	 *
	 * @param themeId the primary key of the themes
	 * @return the themes
	 * @throws PortalException if a themes with the primary key could not be found
	 */
	@Override
	public com.ejada.telemony.db.model.Themes getThemes(long themeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _themesLocalService.getThemes(themeId);
	}

	/**
	 * Returns a range of all the themeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.ThemesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of themeses
	 * @param end the upper bound of the range of themeses (not inclusive)
	 * @return the range of themeses
	 */
	@Override
	public java.util.List<com.ejada.telemony.db.model.Themes> getThemeses(
		int start, int end) {

		return _themesLocalService.getThemeses(start, end);
	}

	/**
	 * Returns the number of themeses.
	 *
	 * @return the number of themeses
	 */
	@Override
	public int getThemesesCount() {
		return _themesLocalService.getThemesesCount();
	}

	@Override
	public boolean hasPendingDraft(long entityResourceId) {
		return _themesLocalService.hasPendingDraft(entityResourceId);
	}

	@Override
	public void importThemes(
		com.ejada.telemony.db.model.ImportRequest importRequest,
		com.liferay.portal.kernel.json.JSONArray dataJson) {

		_themesLocalService.importThemes(importRequest, dataJson);
	}

	@Override
	public void themeCreate(
			long channelId, String enName, String arName, boolean darkTheme,
			String neutralColors, String primaryColors, String secondaryColors,
			String successColors, String errorColors, String warningColors,
			String supportColors, String gradientColors, String splashBg,
			String splashAnimation, String headerBg, String balanceBg,
			boolean defaultTheme,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws Exception {

		_themesLocalService.themeCreate(
			channelId, enName, arName, darkTheme, neutralColors, primaryColors,
			secondaryColors, successColors, errorColors, warningColors,
			supportColors, gradientColors, splashBg, splashAnimation, headerBg,
			balanceBg, defaultTheme, serviceContext, user);
	}

	@Override
	public void themeDelete(
			Long id,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws Exception {

		_themesLocalService.themeDelete(id, serviceContext, user);
	}

	@Override
	public void themeUpdate(
			Long id, long channelId, String enName, String arName,
			boolean darkTheme, String neutralColors, String primaryColors,
			String secondaryColors, String successColors, String errorColors,
			String warningColors, String supportColors, String gradientColors,
			String splashBg, String splashAnimation, String headerBg,
			String balanceBg, boolean defaultTheme,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws Exception {

		_themesLocalService.themeUpdate(
			id, channelId, enName, arName, darkTheme, neutralColors,
			primaryColors, secondaryColors, successColors, errorColors,
			warningColors, supportColors, gradientColors, splashBg,
			splashAnimation, headerBg, balanceBg, defaultTheme, serviceContext,
			user);
	}

	@Override
	public void themeUpdateWithoutWorkflow(
			Long id, long channelId, String enName, String arName,
			boolean darkTheme, String neutralColors, String primaryColors,
			String secondaryColors, String successColors, String errorColors,
			String warningColors, String supportColors, String gradientColors,
			String splashBg, String splashAnimation, String headerBg,
			String balanceBg, boolean defaultTheme,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user,
			com.ejada.telemony.db.model.ImportRequest importRequest)
		throws Exception {

		_themesLocalService.themeUpdateWithoutWorkflow(
			id, channelId, enName, arName, darkTheme, neutralColors,
			primaryColors, secondaryColors, successColors, errorColors,
			warningColors, supportColors, gradientColors, splashBg,
			splashAnimation, headerBg, balanceBg, defaultTheme, serviceContext,
			user, importRequest);
	}

	@Override
	public com.ejada.telemony.db.model.Themes updateStatus(
			long userId, long themeId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _themesLocalService.updateStatus(
			userId, themeId, status, serviceContext);
	}

	/**
	 * Updates the themes in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ThemesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param themes the themes
	 * @return the themes that was updated
	 */
	@Override
	public com.ejada.telemony.db.model.Themes updateThemes(
		com.ejada.telemony.db.model.Themes themes) {

		return _themesLocalService.updateThemes(themes);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _themesLocalService.getBasePersistence();
	}

	@Override
	public ThemesLocalService getWrappedService() {
		return _themesLocalService;
	}

	@Override
	public void setWrappedService(ThemesLocalService themesLocalService) {
		_themesLocalService = themesLocalService;
	}

	private ThemesLocalService _themesLocalService;

}