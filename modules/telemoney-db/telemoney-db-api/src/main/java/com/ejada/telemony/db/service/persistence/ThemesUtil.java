/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.model.Themes;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the themes service. This utility wraps <code>com.ejada.telemony.db.service.persistence.impl.ThemesPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ThemesPersistence
 * @generated
 */
public class ThemesUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Themes themes) {
		getPersistence().clearCache(themes);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Themes> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Themes> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Themes> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Themes> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Themes> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Themes update(Themes themes) {
		return getPersistence().update(themes);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Themes update(Themes themes, ServiceContext serviceContext) {
		return getPersistence().update(themes, serviceContext);
	}

	/**
	 * Returns all the themeses where channelId = &#63; and darkTheme = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param darkTheme the dark theme
	 * @return the matching themeses
	 */
	public static List<Themes> findBydarkTheme(
		long channelId, boolean darkTheme) {

		return getPersistence().findBydarkTheme(channelId, darkTheme);
	}

	/**
	 * Returns a range of all the themeses where channelId = &#63; and darkTheme = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThemesModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param darkTheme the dark theme
	 * @param start the lower bound of the range of themeses
	 * @param end the upper bound of the range of themeses (not inclusive)
	 * @return the range of matching themeses
	 */
	public static List<Themes> findBydarkTheme(
		long channelId, boolean darkTheme, int start, int end) {

		return getPersistence().findBydarkTheme(
			channelId, darkTheme, start, end);
	}

	/**
	 * Returns an ordered range of all the themeses where channelId = &#63; and darkTheme = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThemesModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param darkTheme the dark theme
	 * @param start the lower bound of the range of themeses
	 * @param end the upper bound of the range of themeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching themeses
	 */
	public static List<Themes> findBydarkTheme(
		long channelId, boolean darkTheme, int start, int end,
		OrderByComparator<Themes> orderByComparator) {

		return getPersistence().findBydarkTheme(
			channelId, darkTheme, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the themeses where channelId = &#63; and darkTheme = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThemesModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param darkTheme the dark theme
	 * @param start the lower bound of the range of themeses
	 * @param end the upper bound of the range of themeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching themeses
	 */
	public static List<Themes> findBydarkTheme(
		long channelId, boolean darkTheme, int start, int end,
		OrderByComparator<Themes> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBydarkTheme(
			channelId, darkTheme, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first themes in the ordered set where channelId = &#63; and darkTheme = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param darkTheme the dark theme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching themes
	 * @throws NoSuchThemesException if a matching themes could not be found
	 */
	public static Themes findBydarkTheme_First(
			long channelId, boolean darkTheme,
			OrderByComparator<Themes> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchThemesException {

		return getPersistence().findBydarkTheme_First(
			channelId, darkTheme, orderByComparator);
	}

	/**
	 * Returns the first themes in the ordered set where channelId = &#63; and darkTheme = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param darkTheme the dark theme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching themes, or <code>null</code> if a matching themes could not be found
	 */
	public static Themes fetchBydarkTheme_First(
		long channelId, boolean darkTheme,
		OrderByComparator<Themes> orderByComparator) {

		return getPersistence().fetchBydarkTheme_First(
			channelId, darkTheme, orderByComparator);
	}

	/**
	 * Returns the last themes in the ordered set where channelId = &#63; and darkTheme = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param darkTheme the dark theme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching themes
	 * @throws NoSuchThemesException if a matching themes could not be found
	 */
	public static Themes findBydarkTheme_Last(
			long channelId, boolean darkTheme,
			OrderByComparator<Themes> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchThemesException {

		return getPersistence().findBydarkTheme_Last(
			channelId, darkTheme, orderByComparator);
	}

	/**
	 * Returns the last themes in the ordered set where channelId = &#63; and darkTheme = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param darkTheme the dark theme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching themes, or <code>null</code> if a matching themes could not be found
	 */
	public static Themes fetchBydarkTheme_Last(
		long channelId, boolean darkTheme,
		OrderByComparator<Themes> orderByComparator) {

		return getPersistence().fetchBydarkTheme_Last(
			channelId, darkTheme, orderByComparator);
	}

	/**
	 * Returns the themeses before and after the current themes in the ordered set where channelId = &#63; and darkTheme = &#63;.
	 *
	 * @param themeId the primary key of the current themes
	 * @param channelId the channel ID
	 * @param darkTheme the dark theme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next themes
	 * @throws NoSuchThemesException if a themes with the primary key could not be found
	 */
	public static Themes[] findBydarkTheme_PrevAndNext(
			long themeId, long channelId, boolean darkTheme,
			OrderByComparator<Themes> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchThemesException {

		return getPersistence().findBydarkTheme_PrevAndNext(
			themeId, channelId, darkTheme, orderByComparator);
	}

	/**
	 * Removes all the themeses where channelId = &#63; and darkTheme = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param darkTheme the dark theme
	 */
	public static void removeBydarkTheme(long channelId, boolean darkTheme) {
		getPersistence().removeBydarkTheme(channelId, darkTheme);
	}

	/**
	 * Returns the number of themeses where channelId = &#63; and darkTheme = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param darkTheme the dark theme
	 * @return the number of matching themeses
	 */
	public static int countBydarkTheme(long channelId, boolean darkTheme) {
		return getPersistence().countBydarkTheme(channelId, darkTheme);
	}

	/**
	 * Returns all the themeses where channelId = &#63; and defaultTheme = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param defaultTheme the default theme
	 * @return the matching themeses
	 */
	public static List<Themes> findByDefaultTheme(
		long channelId, boolean defaultTheme) {

		return getPersistence().findByDefaultTheme(channelId, defaultTheme);
	}

	/**
	 * Returns a range of all the themeses where channelId = &#63; and defaultTheme = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThemesModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param defaultTheme the default theme
	 * @param start the lower bound of the range of themeses
	 * @param end the upper bound of the range of themeses (not inclusive)
	 * @return the range of matching themeses
	 */
	public static List<Themes> findByDefaultTheme(
		long channelId, boolean defaultTheme, int start, int end) {

		return getPersistence().findByDefaultTheme(
			channelId, defaultTheme, start, end);
	}

	/**
	 * Returns an ordered range of all the themeses where channelId = &#63; and defaultTheme = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThemesModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param defaultTheme the default theme
	 * @param start the lower bound of the range of themeses
	 * @param end the upper bound of the range of themeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching themeses
	 */
	public static List<Themes> findByDefaultTheme(
		long channelId, boolean defaultTheme, int start, int end,
		OrderByComparator<Themes> orderByComparator) {

		return getPersistence().findByDefaultTheme(
			channelId, defaultTheme, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the themeses where channelId = &#63; and defaultTheme = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThemesModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param defaultTheme the default theme
	 * @param start the lower bound of the range of themeses
	 * @param end the upper bound of the range of themeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching themeses
	 */
	public static List<Themes> findByDefaultTheme(
		long channelId, boolean defaultTheme, int start, int end,
		OrderByComparator<Themes> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByDefaultTheme(
			channelId, defaultTheme, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first themes in the ordered set where channelId = &#63; and defaultTheme = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param defaultTheme the default theme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching themes
	 * @throws NoSuchThemesException if a matching themes could not be found
	 */
	public static Themes findByDefaultTheme_First(
			long channelId, boolean defaultTheme,
			OrderByComparator<Themes> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchThemesException {

		return getPersistence().findByDefaultTheme_First(
			channelId, defaultTheme, orderByComparator);
	}

	/**
	 * Returns the first themes in the ordered set where channelId = &#63; and defaultTheme = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param defaultTheme the default theme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching themes, or <code>null</code> if a matching themes could not be found
	 */
	public static Themes fetchByDefaultTheme_First(
		long channelId, boolean defaultTheme,
		OrderByComparator<Themes> orderByComparator) {

		return getPersistence().fetchByDefaultTheme_First(
			channelId, defaultTheme, orderByComparator);
	}

	/**
	 * Returns the last themes in the ordered set where channelId = &#63; and defaultTheme = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param defaultTheme the default theme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching themes
	 * @throws NoSuchThemesException if a matching themes could not be found
	 */
	public static Themes findByDefaultTheme_Last(
			long channelId, boolean defaultTheme,
			OrderByComparator<Themes> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchThemesException {

		return getPersistence().findByDefaultTheme_Last(
			channelId, defaultTheme, orderByComparator);
	}

	/**
	 * Returns the last themes in the ordered set where channelId = &#63; and defaultTheme = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param defaultTheme the default theme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching themes, or <code>null</code> if a matching themes could not be found
	 */
	public static Themes fetchByDefaultTheme_Last(
		long channelId, boolean defaultTheme,
		OrderByComparator<Themes> orderByComparator) {

		return getPersistence().fetchByDefaultTheme_Last(
			channelId, defaultTheme, orderByComparator);
	}

	/**
	 * Returns the themeses before and after the current themes in the ordered set where channelId = &#63; and defaultTheme = &#63;.
	 *
	 * @param themeId the primary key of the current themes
	 * @param channelId the channel ID
	 * @param defaultTheme the default theme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next themes
	 * @throws NoSuchThemesException if a themes with the primary key could not be found
	 */
	public static Themes[] findByDefaultTheme_PrevAndNext(
			long themeId, long channelId, boolean defaultTheme,
			OrderByComparator<Themes> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchThemesException {

		return getPersistence().findByDefaultTheme_PrevAndNext(
			themeId, channelId, defaultTheme, orderByComparator);
	}

	/**
	 * Removes all the themeses where channelId = &#63; and defaultTheme = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param defaultTheme the default theme
	 */
	public static void removeByDefaultTheme(
		long channelId, boolean defaultTheme) {

		getPersistence().removeByDefaultTheme(channelId, defaultTheme);
	}

	/**
	 * Returns the number of themeses where channelId = &#63; and defaultTheme = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param defaultTheme the default theme
	 * @return the number of matching themeses
	 */
	public static int countByDefaultTheme(
		long channelId, boolean defaultTheme) {

		return getPersistence().countByDefaultTheme(channelId, defaultTheme);
	}

	/**
	 * Returns all the themeses where defaultTheme = &#63; and darkTheme = &#63; and channelId = &#63;.
	 *
	 * @param defaultTheme the default theme
	 * @param darkTheme the dark theme
	 * @param channelId the channel ID
	 * @return the matching themeses
	 */
	public static List<Themes> findByDefaultModeTheme(
		boolean defaultTheme, boolean darkTheme, long channelId) {

		return getPersistence().findByDefaultModeTheme(
			defaultTheme, darkTheme, channelId);
	}

	/**
	 * Returns a range of all the themeses where defaultTheme = &#63; and darkTheme = &#63; and channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThemesModelImpl</code>.
	 * </p>
	 *
	 * @param defaultTheme the default theme
	 * @param darkTheme the dark theme
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of themeses
	 * @param end the upper bound of the range of themeses (not inclusive)
	 * @return the range of matching themeses
	 */
	public static List<Themes> findByDefaultModeTheme(
		boolean defaultTheme, boolean darkTheme, long channelId, int start,
		int end) {

		return getPersistence().findByDefaultModeTheme(
			defaultTheme, darkTheme, channelId, start, end);
	}

	/**
	 * Returns an ordered range of all the themeses where defaultTheme = &#63; and darkTheme = &#63; and channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThemesModelImpl</code>.
	 * </p>
	 *
	 * @param defaultTheme the default theme
	 * @param darkTheme the dark theme
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of themeses
	 * @param end the upper bound of the range of themeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching themeses
	 */
	public static List<Themes> findByDefaultModeTheme(
		boolean defaultTheme, boolean darkTheme, long channelId, int start,
		int end, OrderByComparator<Themes> orderByComparator) {

		return getPersistence().findByDefaultModeTheme(
			defaultTheme, darkTheme, channelId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the themeses where defaultTheme = &#63; and darkTheme = &#63; and channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThemesModelImpl</code>.
	 * </p>
	 *
	 * @param defaultTheme the default theme
	 * @param darkTheme the dark theme
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of themeses
	 * @param end the upper bound of the range of themeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching themeses
	 */
	public static List<Themes> findByDefaultModeTheme(
		boolean defaultTheme, boolean darkTheme, long channelId, int start,
		int end, OrderByComparator<Themes> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDefaultModeTheme(
			defaultTheme, darkTheme, channelId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first themes in the ordered set where defaultTheme = &#63; and darkTheme = &#63; and channelId = &#63;.
	 *
	 * @param defaultTheme the default theme
	 * @param darkTheme the dark theme
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching themes
	 * @throws NoSuchThemesException if a matching themes could not be found
	 */
	public static Themes findByDefaultModeTheme_First(
			boolean defaultTheme, boolean darkTheme, long channelId,
			OrderByComparator<Themes> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchThemesException {

		return getPersistence().findByDefaultModeTheme_First(
			defaultTheme, darkTheme, channelId, orderByComparator);
	}

	/**
	 * Returns the first themes in the ordered set where defaultTheme = &#63; and darkTheme = &#63; and channelId = &#63;.
	 *
	 * @param defaultTheme the default theme
	 * @param darkTheme the dark theme
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching themes, or <code>null</code> if a matching themes could not be found
	 */
	public static Themes fetchByDefaultModeTheme_First(
		boolean defaultTheme, boolean darkTheme, long channelId,
		OrderByComparator<Themes> orderByComparator) {

		return getPersistence().fetchByDefaultModeTheme_First(
			defaultTheme, darkTheme, channelId, orderByComparator);
	}

	/**
	 * Returns the last themes in the ordered set where defaultTheme = &#63; and darkTheme = &#63; and channelId = &#63;.
	 *
	 * @param defaultTheme the default theme
	 * @param darkTheme the dark theme
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching themes
	 * @throws NoSuchThemesException if a matching themes could not be found
	 */
	public static Themes findByDefaultModeTheme_Last(
			boolean defaultTheme, boolean darkTheme, long channelId,
			OrderByComparator<Themes> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchThemesException {

		return getPersistence().findByDefaultModeTheme_Last(
			defaultTheme, darkTheme, channelId, orderByComparator);
	}

	/**
	 * Returns the last themes in the ordered set where defaultTheme = &#63; and darkTheme = &#63; and channelId = &#63;.
	 *
	 * @param defaultTheme the default theme
	 * @param darkTheme the dark theme
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching themes, or <code>null</code> if a matching themes could not be found
	 */
	public static Themes fetchByDefaultModeTheme_Last(
		boolean defaultTheme, boolean darkTheme, long channelId,
		OrderByComparator<Themes> orderByComparator) {

		return getPersistence().fetchByDefaultModeTheme_Last(
			defaultTheme, darkTheme, channelId, orderByComparator);
	}

	/**
	 * Returns the themeses before and after the current themes in the ordered set where defaultTheme = &#63; and darkTheme = &#63; and channelId = &#63;.
	 *
	 * @param themeId the primary key of the current themes
	 * @param defaultTheme the default theme
	 * @param darkTheme the dark theme
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next themes
	 * @throws NoSuchThemesException if a themes with the primary key could not be found
	 */
	public static Themes[] findByDefaultModeTheme_PrevAndNext(
			long themeId, boolean defaultTheme, boolean darkTheme,
			long channelId, OrderByComparator<Themes> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchThemesException {

		return getPersistence().findByDefaultModeTheme_PrevAndNext(
			themeId, defaultTheme, darkTheme, channelId, orderByComparator);
	}

	/**
	 * Removes all the themeses where defaultTheme = &#63; and darkTheme = &#63; and channelId = &#63; from the database.
	 *
	 * @param defaultTheme the default theme
	 * @param darkTheme the dark theme
	 * @param channelId the channel ID
	 */
	public static void removeByDefaultModeTheme(
		boolean defaultTheme, boolean darkTheme, long channelId) {

		getPersistence().removeByDefaultModeTheme(
			defaultTheme, darkTheme, channelId);
	}

	/**
	 * Returns the number of themeses where defaultTheme = &#63; and darkTheme = &#63; and channelId = &#63;.
	 *
	 * @param defaultTheme the default theme
	 * @param darkTheme the dark theme
	 * @param channelId the channel ID
	 * @return the number of matching themeses
	 */
	public static int countByDefaultModeTheme(
		boolean defaultTheme, boolean darkTheme, long channelId) {

		return getPersistence().countByDefaultModeTheme(
			defaultTheme, darkTheme, channelId);
	}

	/**
	 * Returns all the themeses where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the matching themeses
	 */
	public static List<Themes> findByChannelId(long channelId) {
		return getPersistence().findByChannelId(channelId);
	}

	/**
	 * Returns a range of all the themeses where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThemesModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of themeses
	 * @param end the upper bound of the range of themeses (not inclusive)
	 * @return the range of matching themeses
	 */
	public static List<Themes> findByChannelId(
		long channelId, int start, int end) {

		return getPersistence().findByChannelId(channelId, start, end);
	}

	/**
	 * Returns an ordered range of all the themeses where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThemesModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of themeses
	 * @param end the upper bound of the range of themeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching themeses
	 */
	public static List<Themes> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<Themes> orderByComparator) {

		return getPersistence().findByChannelId(
			channelId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the themeses where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThemesModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of themeses
	 * @param end the upper bound of the range of themeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching themeses
	 */
	public static List<Themes> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<Themes> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByChannelId(
			channelId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first themes in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching themes
	 * @throws NoSuchThemesException if a matching themes could not be found
	 */
	public static Themes findByChannelId_First(
			long channelId, OrderByComparator<Themes> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchThemesException {

		return getPersistence().findByChannelId_First(
			channelId, orderByComparator);
	}

	/**
	 * Returns the first themes in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching themes, or <code>null</code> if a matching themes could not be found
	 */
	public static Themes fetchByChannelId_First(
		long channelId, OrderByComparator<Themes> orderByComparator) {

		return getPersistence().fetchByChannelId_First(
			channelId, orderByComparator);
	}

	/**
	 * Returns the last themes in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching themes
	 * @throws NoSuchThemesException if a matching themes could not be found
	 */
	public static Themes findByChannelId_Last(
			long channelId, OrderByComparator<Themes> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchThemesException {

		return getPersistence().findByChannelId_Last(
			channelId, orderByComparator);
	}

	/**
	 * Returns the last themes in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching themes, or <code>null</code> if a matching themes could not be found
	 */
	public static Themes fetchByChannelId_Last(
		long channelId, OrderByComparator<Themes> orderByComparator) {

		return getPersistence().fetchByChannelId_Last(
			channelId, orderByComparator);
	}

	/**
	 * Returns the themeses before and after the current themes in the ordered set where channelId = &#63;.
	 *
	 * @param themeId the primary key of the current themes
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next themes
	 * @throws NoSuchThemesException if a themes with the primary key could not be found
	 */
	public static Themes[] findByChannelId_PrevAndNext(
			long themeId, long channelId,
			OrderByComparator<Themes> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchThemesException {

		return getPersistence().findByChannelId_PrevAndNext(
			themeId, channelId, orderByComparator);
	}

	/**
	 * Removes all the themeses where channelId = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 */
	public static void removeByChannelId(long channelId) {
		getPersistence().removeByChannelId(channelId);
	}

	/**
	 * Returns the number of themeses where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the number of matching themeses
	 */
	public static int countByChannelId(long channelId) {
		return getPersistence().countByChannelId(channelId);
	}

	/**
	 * Returns all the themeses where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @return the matching themeses
	 */
	public static List<Themes> findByChannelIdAndStatus(
		long channelId, int status) {

		return getPersistence().findByChannelIdAndStatus(channelId, status);
	}

	/**
	 * Returns a range of all the themeses where channelId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThemesModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param start the lower bound of the range of themeses
	 * @param end the upper bound of the range of themeses (not inclusive)
	 * @return the range of matching themeses
	 */
	public static List<Themes> findByChannelIdAndStatus(
		long channelId, int status, int start, int end) {

		return getPersistence().findByChannelIdAndStatus(
			channelId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the themeses where channelId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThemesModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param start the lower bound of the range of themeses
	 * @param end the upper bound of the range of themeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching themeses
	 */
	public static List<Themes> findByChannelIdAndStatus(
		long channelId, int status, int start, int end,
		OrderByComparator<Themes> orderByComparator) {

		return getPersistence().findByChannelIdAndStatus(
			channelId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the themeses where channelId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThemesModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param start the lower bound of the range of themeses
	 * @param end the upper bound of the range of themeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching themeses
	 */
	public static List<Themes> findByChannelIdAndStatus(
		long channelId, int status, int start, int end,
		OrderByComparator<Themes> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByChannelIdAndStatus(
			channelId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first themes in the ordered set where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching themes
	 * @throws NoSuchThemesException if a matching themes could not be found
	 */
	public static Themes findByChannelIdAndStatus_First(
			long channelId, int status,
			OrderByComparator<Themes> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchThemesException {

		return getPersistence().findByChannelIdAndStatus_First(
			channelId, status, orderByComparator);
	}

	/**
	 * Returns the first themes in the ordered set where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching themes, or <code>null</code> if a matching themes could not be found
	 */
	public static Themes fetchByChannelIdAndStatus_First(
		long channelId, int status,
		OrderByComparator<Themes> orderByComparator) {

		return getPersistence().fetchByChannelIdAndStatus_First(
			channelId, status, orderByComparator);
	}

	/**
	 * Returns the last themes in the ordered set where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching themes
	 * @throws NoSuchThemesException if a matching themes could not be found
	 */
	public static Themes findByChannelIdAndStatus_Last(
			long channelId, int status,
			OrderByComparator<Themes> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchThemesException {

		return getPersistence().findByChannelIdAndStatus_Last(
			channelId, status, orderByComparator);
	}

	/**
	 * Returns the last themes in the ordered set where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching themes, or <code>null</code> if a matching themes could not be found
	 */
	public static Themes fetchByChannelIdAndStatus_Last(
		long channelId, int status,
		OrderByComparator<Themes> orderByComparator) {

		return getPersistence().fetchByChannelIdAndStatus_Last(
			channelId, status, orderByComparator);
	}

	/**
	 * Returns the themeses before and after the current themes in the ordered set where channelId = &#63; and status = &#63;.
	 *
	 * @param themeId the primary key of the current themes
	 * @param channelId the channel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next themes
	 * @throws NoSuchThemesException if a themes with the primary key could not be found
	 */
	public static Themes[] findByChannelIdAndStatus_PrevAndNext(
			long themeId, long channelId, int status,
			OrderByComparator<Themes> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchThemesException {

		return getPersistence().findByChannelIdAndStatus_PrevAndNext(
			themeId, channelId, status, orderByComparator);
	}

	/**
	 * Removes all the themeses where channelId = &#63; and status = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 */
	public static void removeByChannelIdAndStatus(long channelId, int status) {
		getPersistence().removeByChannelIdAndStatus(channelId, status);
	}

	/**
	 * Returns the number of themeses where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @return the number of matching themeses
	 */
	public static int countByChannelIdAndStatus(long channelId, int status) {
		return getPersistence().countByChannelIdAndStatus(channelId, status);
	}

	/**
	 * Returns all the themeses where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the matching themeses
	 */
	public static List<Themes> findByentityResourceId(long entityResourceId) {
		return getPersistence().findByentityResourceId(entityResourceId);
	}

	/**
	 * Returns a range of all the themeses where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThemesModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of themeses
	 * @param end the upper bound of the range of themeses (not inclusive)
	 * @return the range of matching themeses
	 */
	public static List<Themes> findByentityResourceId(
		long entityResourceId, int start, int end) {

		return getPersistence().findByentityResourceId(
			entityResourceId, start, end);
	}

	/**
	 * Returns an ordered range of all the themeses where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThemesModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of themeses
	 * @param end the upper bound of the range of themeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching themeses
	 */
	public static List<Themes> findByentityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<Themes> orderByComparator) {

		return getPersistence().findByentityResourceId(
			entityResourceId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the themeses where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThemesModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of themeses
	 * @param end the upper bound of the range of themeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching themeses
	 */
	public static List<Themes> findByentityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<Themes> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByentityResourceId(
			entityResourceId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first themes in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching themes
	 * @throws NoSuchThemesException if a matching themes could not be found
	 */
	public static Themes findByentityResourceId_First(
			long entityResourceId, OrderByComparator<Themes> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchThemesException {

		return getPersistence().findByentityResourceId_First(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the first themes in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching themes, or <code>null</code> if a matching themes could not be found
	 */
	public static Themes fetchByentityResourceId_First(
		long entityResourceId, OrderByComparator<Themes> orderByComparator) {

		return getPersistence().fetchByentityResourceId_First(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the last themes in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching themes
	 * @throws NoSuchThemesException if a matching themes could not be found
	 */
	public static Themes findByentityResourceId_Last(
			long entityResourceId, OrderByComparator<Themes> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchThemesException {

		return getPersistence().findByentityResourceId_Last(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the last themes in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching themes, or <code>null</code> if a matching themes could not be found
	 */
	public static Themes fetchByentityResourceId_Last(
		long entityResourceId, OrderByComparator<Themes> orderByComparator) {

		return getPersistence().fetchByentityResourceId_Last(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the themeses before and after the current themes in the ordered set where entityResourceId = &#63;.
	 *
	 * @param themeId the primary key of the current themes
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next themes
	 * @throws NoSuchThemesException if a themes with the primary key could not be found
	 */
	public static Themes[] findByentityResourceId_PrevAndNext(
			long themeId, long entityResourceId,
			OrderByComparator<Themes> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchThemesException {

		return getPersistence().findByentityResourceId_PrevAndNext(
			themeId, entityResourceId, orderByComparator);
	}

	/**
	 * Removes all the themeses where entityResourceId = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 */
	public static void removeByentityResourceId(long entityResourceId) {
		getPersistence().removeByentityResourceId(entityResourceId);
	}

	/**
	 * Returns the number of themeses where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the number of matching themeses
	 */
	public static int countByentityResourceId(long entityResourceId) {
		return getPersistence().countByentityResourceId(entityResourceId);
	}

	/**
	 * Caches the themes in the entity cache if it is enabled.
	 *
	 * @param themes the themes
	 */
	public static void cacheResult(Themes themes) {
		getPersistence().cacheResult(themes);
	}

	/**
	 * Caches the themeses in the entity cache if it is enabled.
	 *
	 * @param themeses the themeses
	 */
	public static void cacheResult(List<Themes> themeses) {
		getPersistence().cacheResult(themeses);
	}

	/**
	 * Creates a new themes with the primary key. Does not add the themes to the database.
	 *
	 * @param themeId the primary key for the new themes
	 * @return the new themes
	 */
	public static Themes create(long themeId) {
		return getPersistence().create(themeId);
	}

	/**
	 * Removes the themes with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param themeId the primary key of the themes
	 * @return the themes that was removed
	 * @throws NoSuchThemesException if a themes with the primary key could not be found
	 */
	public static Themes remove(long themeId)
		throws com.ejada.telemony.db.exception.NoSuchThemesException {

		return getPersistence().remove(themeId);
	}

	public static Themes updateImpl(Themes themes) {
		return getPersistence().updateImpl(themes);
	}

	/**
	 * Returns the themes with the primary key or throws a <code>NoSuchThemesException</code> if it could not be found.
	 *
	 * @param themeId the primary key of the themes
	 * @return the themes
	 * @throws NoSuchThemesException if a themes with the primary key could not be found
	 */
	public static Themes findByPrimaryKey(long themeId)
		throws com.ejada.telemony.db.exception.NoSuchThemesException {

		return getPersistence().findByPrimaryKey(themeId);
	}

	/**
	 * Returns the themes with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param themeId the primary key of the themes
	 * @return the themes, or <code>null</code> if a themes with the primary key could not be found
	 */
	public static Themes fetchByPrimaryKey(long themeId) {
		return getPersistence().fetchByPrimaryKey(themeId);
	}

	/**
	 * Returns all the themeses.
	 *
	 * @return the themeses
	 */
	public static List<Themes> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the themeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThemesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of themeses
	 * @param end the upper bound of the range of themeses (not inclusive)
	 * @return the range of themeses
	 */
	public static List<Themes> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the themeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThemesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of themeses
	 * @param end the upper bound of the range of themeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of themeses
	 */
	public static List<Themes> findAll(
		int start, int end, OrderByComparator<Themes> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the themeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThemesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of themeses
	 * @param end the upper bound of the range of themeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of themeses
	 */
	public static List<Themes> findAll(
		int start, int end, OrderByComparator<Themes> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the themeses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of themeses.
	 *
	 * @return the number of themeses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ThemesPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(ThemesPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile ThemesPersistence _persistence;

}