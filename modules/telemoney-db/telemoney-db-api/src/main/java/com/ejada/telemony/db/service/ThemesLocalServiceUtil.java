/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.ejada.telemony.db.model.Themes;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for Themes. This utility wraps
 * <code>com.ejada.telemony.db.service.impl.ThemesLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ThemesLocalService
 * @generated
 */
public class ThemesLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.ThemesLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addDefaultDarkTheme(Long channelId) {
		getService().addDefaultDarkTheme(channelId);
	}

	public static void addDefaultLightTheme(Long channelId) {
		getService().addDefaultLightTheme(channelId);
	}

	public static void addTheme(
		long channelId, String enName, String arName, boolean darkTheme,
		String neutralColors, String primaryColors, String secondaryColors,
		String successColors, String errorColors, String warningColors,
		String supportColors, String gradientColors, String splashBg,
		String splashAnimation, String headerBg, String balanceBg,
		boolean deafultTheme, long themeId) {

		getService().addTheme(
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
	public static Themes addThemes(Themes themes) {
		return getService().addThemes(themes);
	}

	public static List<com.ejada.telemony.db.model.Persona> checkTheme(
		Long channelId, Long themeId) {

		return getService().checkTheme(channelId, themeId);
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
	 * Creates a new themes with the primary key. Does not add the themes to the database.
	 *
	 * @param themeId the primary key for the new themes
	 * @return the new themes
	 */
	public static Themes createThemes(long themeId) {
		return getService().createThemes(themeId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static void deleteTheme(Long themeId, Long channelId)
		throws Exception {

		getService().deleteTheme(themeId, channelId);
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
	public static Themes deleteThemes(long themeId) throws PortalException {
		return getService().deleteThemes(themeId);
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
	public static Themes deleteThemes(Themes themes) {
		return getService().deleteThemes(themes);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.ThemesModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.ThemesModelImpl</code>.
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

	public static Themes fetchThemes(long themeId) {
		return getService().fetchThemes(themeId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<Themes> getAllDefaultThemes(Long channelId) {
		return getService().getAllDefaultThemes(channelId);
	}

	public static List<Themes> getAllNonDefaultThemes(Long channelId) {
		return getService().getAllNonDefaultThemes(channelId);
	}

	public static List<Themes> getbyChannelId(Long channelId) {
		return getService().getbyChannelId(channelId);
	}

	public static Themes getDefaultTheme(boolean mode, Long channelId) {
		return getService().getDefaultTheme(mode, channelId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static List<Themes> getLatestApprovedByChannelId(long channelId) {
		return getService().getLatestApprovedByChannelId(channelId);
	}

	/**
	 * Returns latest APPROVED Themes entries for the channel along with a flag indicating whether
	 * that Theme (entityResourceId) currently has a pending draft awaiting approval.
	 *
	 * Map key: latest approved Theme for an entityResourceId
	 * Map value: true if there is any STATUS_DRAFT row for that entityResourceId
	 */
	public static Map<Themes, Boolean> getLatestApprovedByChannelIdWithPending(
		long channelId) {

		return getService().getLatestApprovedByChannelIdWithPending(channelId);
	}

	public static Themes getLatestApprovedByEntityResourceId(
		long entityResourceId) {

		return getService().getLatestApprovedByEntityResourceId(
			entityResourceId);
	}

	public static List<Themes> getLatestApprovedWithoutPendingByChannelId(
		long channelId) {

		return getService().getLatestApprovedWithoutPendingByChannelId(
			channelId);
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

	/**
	 * Returns the themes with the primary key.
	 *
	 * @param themeId the primary key of the themes
	 * @return the themes
	 * @throws PortalException if a themes with the primary key could not be found
	 */
	public static Themes getThemes(long themeId) throws PortalException {
		return getService().getThemes(themeId);
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
	public static List<Themes> getThemeses(int start, int end) {
		return getService().getThemeses(start, end);
	}

	/**
	 * Returns the number of themeses.
	 *
	 * @return the number of themeses
	 */
	public static int getThemesesCount() {
		return getService().getThemesesCount();
	}

	public static boolean hasPendingDraft(long entityResourceId) {
		return getService().hasPendingDraft(entityResourceId);
	}

	public static void importThemes(
		com.ejada.telemony.db.model.ImportRequest importRequest,
		com.liferay.portal.kernel.json.JSONArray dataJson) {

		getService().importThemes(importRequest, dataJson);
	}

	public static void themeCreate(
			long channelId, String enName, String arName, boolean darkTheme,
			String neutralColors, String primaryColors, String secondaryColors,
			String successColors, String errorColors, String warningColors,
			String supportColors, String gradientColors, String splashBg,
			String splashAnimation, String headerBg, String balanceBg,
			boolean defaultTheme,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws Exception {

		getService().themeCreate(
			channelId, enName, arName, darkTheme, neutralColors, primaryColors,
			secondaryColors, successColors, errorColors, warningColors,
			supportColors, gradientColors, splashBg, splashAnimation, headerBg,
			balanceBg, defaultTheme, serviceContext, user);
	}

	public static void themeDelete(
			Long id,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws Exception {

		getService().themeDelete(id, serviceContext, user);
	}

	public static void themeUpdate(
			Long id, long channelId, String enName, String arName,
			boolean darkTheme, String neutralColors, String primaryColors,
			String secondaryColors, String successColors, String errorColors,
			String warningColors, String supportColors, String gradientColors,
			String splashBg, String splashAnimation, String headerBg,
			String balanceBg, boolean defaultTheme,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws Exception {

		getService().themeUpdate(
			id, channelId, enName, arName, darkTheme, neutralColors,
			primaryColors, secondaryColors, successColors, errorColors,
			warningColors, supportColors, gradientColors, splashBg,
			splashAnimation, headerBg, balanceBg, defaultTheme, serviceContext,
			user);
	}

	public static void themeUpdateWithoutWorkflow(
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

		getService().themeUpdateWithoutWorkflow(
			id, channelId, enName, arName, darkTheme, neutralColors,
			primaryColors, secondaryColors, successColors, errorColors,
			warningColors, supportColors, gradientColors, splashBg,
			splashAnimation, headerBg, balanceBg, defaultTheme, serviceContext,
			user, importRequest);
	}

	public static Themes updateStatus(
			long userId, long themeId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		return getService().updateStatus(
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
	public static Themes updateThemes(Themes themes) {
		return getService().updateThemes(themes);
	}

	public static ThemesLocalService getService() {
		return _service;
	}

	public static void setService(ThemesLocalService service) {
		_service = service;
	}

	private static volatile ThemesLocalService _service;

}