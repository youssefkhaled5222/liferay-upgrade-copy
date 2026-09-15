/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.exception.NoSuchThemesException;
import com.ejada.telemony.db.model.Themes;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the themes service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ThemesUtil
 * @generated
 */
@ProviderType
public interface ThemesPersistence extends BasePersistence<Themes> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ThemesUtil} to access the themes persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the themeses where channelId = &#63; and darkTheme = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param darkTheme the dark theme
	 * @return the matching themeses
	 */
	public java.util.List<Themes> findBydarkTheme(
		long channelId, boolean darkTheme);

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
	public java.util.List<Themes> findBydarkTheme(
		long channelId, boolean darkTheme, int start, int end);

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
	public java.util.List<Themes> findBydarkTheme(
		long channelId, boolean darkTheme, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Themes>
			orderByComparator);

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
	public java.util.List<Themes> findBydarkTheme(
		long channelId, boolean darkTheme, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Themes>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first themes in the ordered set where channelId = &#63; and darkTheme = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param darkTheme the dark theme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching themes
	 * @throws NoSuchThemesException if a matching themes could not be found
	 */
	public Themes findBydarkTheme_First(
			long channelId, boolean darkTheme,
			com.liferay.portal.kernel.util.OrderByComparator<Themes>
				orderByComparator)
		throws NoSuchThemesException;

	/**
	 * Returns the first themes in the ordered set where channelId = &#63; and darkTheme = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param darkTheme the dark theme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching themes, or <code>null</code> if a matching themes could not be found
	 */
	public Themes fetchBydarkTheme_First(
		long channelId, boolean darkTheme,
		com.liferay.portal.kernel.util.OrderByComparator<Themes>
			orderByComparator);

	/**
	 * Returns the last themes in the ordered set where channelId = &#63; and darkTheme = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param darkTheme the dark theme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching themes
	 * @throws NoSuchThemesException if a matching themes could not be found
	 */
	public Themes findBydarkTheme_Last(
			long channelId, boolean darkTheme,
			com.liferay.portal.kernel.util.OrderByComparator<Themes>
				orderByComparator)
		throws NoSuchThemesException;

	/**
	 * Returns the last themes in the ordered set where channelId = &#63; and darkTheme = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param darkTheme the dark theme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching themes, or <code>null</code> if a matching themes could not be found
	 */
	public Themes fetchBydarkTheme_Last(
		long channelId, boolean darkTheme,
		com.liferay.portal.kernel.util.OrderByComparator<Themes>
			orderByComparator);

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
	public Themes[] findBydarkTheme_PrevAndNext(
			long themeId, long channelId, boolean darkTheme,
			com.liferay.portal.kernel.util.OrderByComparator<Themes>
				orderByComparator)
		throws NoSuchThemesException;

	/**
	 * Removes all the themeses where channelId = &#63; and darkTheme = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param darkTheme the dark theme
	 */
	public void removeBydarkTheme(long channelId, boolean darkTheme);

	/**
	 * Returns the number of themeses where channelId = &#63; and darkTheme = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param darkTheme the dark theme
	 * @return the number of matching themeses
	 */
	public int countBydarkTheme(long channelId, boolean darkTheme);

	/**
	 * Returns all the themeses where channelId = &#63; and defaultTheme = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param defaultTheme the default theme
	 * @return the matching themeses
	 */
	public java.util.List<Themes> findByDefaultTheme(
		long channelId, boolean defaultTheme);

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
	public java.util.List<Themes> findByDefaultTheme(
		long channelId, boolean defaultTheme, int start, int end);

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
	public java.util.List<Themes> findByDefaultTheme(
		long channelId, boolean defaultTheme, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Themes>
			orderByComparator);

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
	public java.util.List<Themes> findByDefaultTheme(
		long channelId, boolean defaultTheme, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Themes>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first themes in the ordered set where channelId = &#63; and defaultTheme = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param defaultTheme the default theme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching themes
	 * @throws NoSuchThemesException if a matching themes could not be found
	 */
	public Themes findByDefaultTheme_First(
			long channelId, boolean defaultTheme,
			com.liferay.portal.kernel.util.OrderByComparator<Themes>
				orderByComparator)
		throws NoSuchThemesException;

	/**
	 * Returns the first themes in the ordered set where channelId = &#63; and defaultTheme = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param defaultTheme the default theme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching themes, or <code>null</code> if a matching themes could not be found
	 */
	public Themes fetchByDefaultTheme_First(
		long channelId, boolean defaultTheme,
		com.liferay.portal.kernel.util.OrderByComparator<Themes>
			orderByComparator);

	/**
	 * Returns the last themes in the ordered set where channelId = &#63; and defaultTheme = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param defaultTheme the default theme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching themes
	 * @throws NoSuchThemesException if a matching themes could not be found
	 */
	public Themes findByDefaultTheme_Last(
			long channelId, boolean defaultTheme,
			com.liferay.portal.kernel.util.OrderByComparator<Themes>
				orderByComparator)
		throws NoSuchThemesException;

	/**
	 * Returns the last themes in the ordered set where channelId = &#63; and defaultTheme = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param defaultTheme the default theme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching themes, or <code>null</code> if a matching themes could not be found
	 */
	public Themes fetchByDefaultTheme_Last(
		long channelId, boolean defaultTheme,
		com.liferay.portal.kernel.util.OrderByComparator<Themes>
			orderByComparator);

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
	public Themes[] findByDefaultTheme_PrevAndNext(
			long themeId, long channelId, boolean defaultTheme,
			com.liferay.portal.kernel.util.OrderByComparator<Themes>
				orderByComparator)
		throws NoSuchThemesException;

	/**
	 * Removes all the themeses where channelId = &#63; and defaultTheme = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param defaultTheme the default theme
	 */
	public void removeByDefaultTheme(long channelId, boolean defaultTheme);

	/**
	 * Returns the number of themeses where channelId = &#63; and defaultTheme = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param defaultTheme the default theme
	 * @return the number of matching themeses
	 */
	public int countByDefaultTheme(long channelId, boolean defaultTheme);

	/**
	 * Returns all the themeses where defaultTheme = &#63; and darkTheme = &#63; and channelId = &#63;.
	 *
	 * @param defaultTheme the default theme
	 * @param darkTheme the dark theme
	 * @param channelId the channel ID
	 * @return the matching themeses
	 */
	public java.util.List<Themes> findByDefaultModeTheme(
		boolean defaultTheme, boolean darkTheme, long channelId);

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
	public java.util.List<Themes> findByDefaultModeTheme(
		boolean defaultTheme, boolean darkTheme, long channelId, int start,
		int end);

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
	public java.util.List<Themes> findByDefaultModeTheme(
		boolean defaultTheme, boolean darkTheme, long channelId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Themes>
			orderByComparator);

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
	public java.util.List<Themes> findByDefaultModeTheme(
		boolean defaultTheme, boolean darkTheme, long channelId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Themes>
			orderByComparator,
		boolean useFinderCache);

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
	public Themes findByDefaultModeTheme_First(
			boolean defaultTheme, boolean darkTheme, long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<Themes>
				orderByComparator)
		throws NoSuchThemesException;

	/**
	 * Returns the first themes in the ordered set where defaultTheme = &#63; and darkTheme = &#63; and channelId = &#63;.
	 *
	 * @param defaultTheme the default theme
	 * @param darkTheme the dark theme
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching themes, or <code>null</code> if a matching themes could not be found
	 */
	public Themes fetchByDefaultModeTheme_First(
		boolean defaultTheme, boolean darkTheme, long channelId,
		com.liferay.portal.kernel.util.OrderByComparator<Themes>
			orderByComparator);

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
	public Themes findByDefaultModeTheme_Last(
			boolean defaultTheme, boolean darkTheme, long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<Themes>
				orderByComparator)
		throws NoSuchThemesException;

	/**
	 * Returns the last themes in the ordered set where defaultTheme = &#63; and darkTheme = &#63; and channelId = &#63;.
	 *
	 * @param defaultTheme the default theme
	 * @param darkTheme the dark theme
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching themes, or <code>null</code> if a matching themes could not be found
	 */
	public Themes fetchByDefaultModeTheme_Last(
		boolean defaultTheme, boolean darkTheme, long channelId,
		com.liferay.portal.kernel.util.OrderByComparator<Themes>
			orderByComparator);

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
	public Themes[] findByDefaultModeTheme_PrevAndNext(
			long themeId, boolean defaultTheme, boolean darkTheme,
			long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<Themes>
				orderByComparator)
		throws NoSuchThemesException;

	/**
	 * Removes all the themeses where defaultTheme = &#63; and darkTheme = &#63; and channelId = &#63; from the database.
	 *
	 * @param defaultTheme the default theme
	 * @param darkTheme the dark theme
	 * @param channelId the channel ID
	 */
	public void removeByDefaultModeTheme(
		boolean defaultTheme, boolean darkTheme, long channelId);

	/**
	 * Returns the number of themeses where defaultTheme = &#63; and darkTheme = &#63; and channelId = &#63;.
	 *
	 * @param defaultTheme the default theme
	 * @param darkTheme the dark theme
	 * @param channelId the channel ID
	 * @return the number of matching themeses
	 */
	public int countByDefaultModeTheme(
		boolean defaultTheme, boolean darkTheme, long channelId);

	/**
	 * Returns all the themeses where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the matching themeses
	 */
	public java.util.List<Themes> findByChannelId(long channelId);

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
	public java.util.List<Themes> findByChannelId(
		long channelId, int start, int end);

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
	public java.util.List<Themes> findByChannelId(
		long channelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Themes>
			orderByComparator);

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
	public java.util.List<Themes> findByChannelId(
		long channelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Themes>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first themes in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching themes
	 * @throws NoSuchThemesException if a matching themes could not be found
	 */
	public Themes findByChannelId_First(
			long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<Themes>
				orderByComparator)
		throws NoSuchThemesException;

	/**
	 * Returns the first themes in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching themes, or <code>null</code> if a matching themes could not be found
	 */
	public Themes fetchByChannelId_First(
		long channelId,
		com.liferay.portal.kernel.util.OrderByComparator<Themes>
			orderByComparator);

	/**
	 * Returns the last themes in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching themes
	 * @throws NoSuchThemesException if a matching themes could not be found
	 */
	public Themes findByChannelId_Last(
			long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<Themes>
				orderByComparator)
		throws NoSuchThemesException;

	/**
	 * Returns the last themes in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching themes, or <code>null</code> if a matching themes could not be found
	 */
	public Themes fetchByChannelId_Last(
		long channelId,
		com.liferay.portal.kernel.util.OrderByComparator<Themes>
			orderByComparator);

	/**
	 * Returns the themeses before and after the current themes in the ordered set where channelId = &#63;.
	 *
	 * @param themeId the primary key of the current themes
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next themes
	 * @throws NoSuchThemesException if a themes with the primary key could not be found
	 */
	public Themes[] findByChannelId_PrevAndNext(
			long themeId, long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<Themes>
				orderByComparator)
		throws NoSuchThemesException;

	/**
	 * Removes all the themeses where channelId = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 */
	public void removeByChannelId(long channelId);

	/**
	 * Returns the number of themeses where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the number of matching themeses
	 */
	public int countByChannelId(long channelId);

	/**
	 * Returns all the themeses where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @return the matching themeses
	 */
	public java.util.List<Themes> findByChannelIdAndStatus(
		long channelId, int status);

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
	public java.util.List<Themes> findByChannelIdAndStatus(
		long channelId, int status, int start, int end);

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
	public java.util.List<Themes> findByChannelIdAndStatus(
		long channelId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Themes>
			orderByComparator);

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
	public java.util.List<Themes> findByChannelIdAndStatus(
		long channelId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Themes>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first themes in the ordered set where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching themes
	 * @throws NoSuchThemesException if a matching themes could not be found
	 */
	public Themes findByChannelIdAndStatus_First(
			long channelId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Themes>
				orderByComparator)
		throws NoSuchThemesException;

	/**
	 * Returns the first themes in the ordered set where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching themes, or <code>null</code> if a matching themes could not be found
	 */
	public Themes fetchByChannelIdAndStatus_First(
		long channelId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Themes>
			orderByComparator);

	/**
	 * Returns the last themes in the ordered set where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching themes
	 * @throws NoSuchThemesException if a matching themes could not be found
	 */
	public Themes findByChannelIdAndStatus_Last(
			long channelId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Themes>
				orderByComparator)
		throws NoSuchThemesException;

	/**
	 * Returns the last themes in the ordered set where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching themes, or <code>null</code> if a matching themes could not be found
	 */
	public Themes fetchByChannelIdAndStatus_Last(
		long channelId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Themes>
			orderByComparator);

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
	public Themes[] findByChannelIdAndStatus_PrevAndNext(
			long themeId, long channelId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Themes>
				orderByComparator)
		throws NoSuchThemesException;

	/**
	 * Removes all the themeses where channelId = &#63; and status = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 */
	public void removeByChannelIdAndStatus(long channelId, int status);

	/**
	 * Returns the number of themeses where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @return the number of matching themeses
	 */
	public int countByChannelIdAndStatus(long channelId, int status);

	/**
	 * Returns all the themeses where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the matching themeses
	 */
	public java.util.List<Themes> findByentityResourceId(long entityResourceId);

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
	public java.util.List<Themes> findByentityResourceId(
		long entityResourceId, int start, int end);

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
	public java.util.List<Themes> findByentityResourceId(
		long entityResourceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Themes>
			orderByComparator);

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
	public java.util.List<Themes> findByentityResourceId(
		long entityResourceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Themes>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first themes in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching themes
	 * @throws NoSuchThemesException if a matching themes could not be found
	 */
	public Themes findByentityResourceId_First(
			long entityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<Themes>
				orderByComparator)
		throws NoSuchThemesException;

	/**
	 * Returns the first themes in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching themes, or <code>null</code> if a matching themes could not be found
	 */
	public Themes fetchByentityResourceId_First(
		long entityResourceId,
		com.liferay.portal.kernel.util.OrderByComparator<Themes>
			orderByComparator);

	/**
	 * Returns the last themes in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching themes
	 * @throws NoSuchThemesException if a matching themes could not be found
	 */
	public Themes findByentityResourceId_Last(
			long entityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<Themes>
				orderByComparator)
		throws NoSuchThemesException;

	/**
	 * Returns the last themes in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching themes, or <code>null</code> if a matching themes could not be found
	 */
	public Themes fetchByentityResourceId_Last(
		long entityResourceId,
		com.liferay.portal.kernel.util.OrderByComparator<Themes>
			orderByComparator);

	/**
	 * Returns the themeses before and after the current themes in the ordered set where entityResourceId = &#63;.
	 *
	 * @param themeId the primary key of the current themes
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next themes
	 * @throws NoSuchThemesException if a themes with the primary key could not be found
	 */
	public Themes[] findByentityResourceId_PrevAndNext(
			long themeId, long entityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<Themes>
				orderByComparator)
		throws NoSuchThemesException;

	/**
	 * Removes all the themeses where entityResourceId = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 */
	public void removeByentityResourceId(long entityResourceId);

	/**
	 * Returns the number of themeses where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the number of matching themeses
	 */
	public int countByentityResourceId(long entityResourceId);

	/**
	 * Caches the themes in the entity cache if it is enabled.
	 *
	 * @param themes the themes
	 */
	public void cacheResult(Themes themes);

	/**
	 * Caches the themeses in the entity cache if it is enabled.
	 *
	 * @param themeses the themeses
	 */
	public void cacheResult(java.util.List<Themes> themeses);

	/**
	 * Creates a new themes with the primary key. Does not add the themes to the database.
	 *
	 * @param themeId the primary key for the new themes
	 * @return the new themes
	 */
	public Themes create(long themeId);

	/**
	 * Removes the themes with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param themeId the primary key of the themes
	 * @return the themes that was removed
	 * @throws NoSuchThemesException if a themes with the primary key could not be found
	 */
	public Themes remove(long themeId) throws NoSuchThemesException;

	public Themes updateImpl(Themes themes);

	/**
	 * Returns the themes with the primary key or throws a <code>NoSuchThemesException</code> if it could not be found.
	 *
	 * @param themeId the primary key of the themes
	 * @return the themes
	 * @throws NoSuchThemesException if a themes with the primary key could not be found
	 */
	public Themes findByPrimaryKey(long themeId) throws NoSuchThemesException;

	/**
	 * Returns the themes with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param themeId the primary key of the themes
	 * @return the themes, or <code>null</code> if a themes with the primary key could not be found
	 */
	public Themes fetchByPrimaryKey(long themeId);

	/**
	 * Returns all the themeses.
	 *
	 * @return the themeses
	 */
	public java.util.List<Themes> findAll();

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
	public java.util.List<Themes> findAll(int start, int end);

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
	public java.util.List<Themes> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Themes>
			orderByComparator);

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
	public java.util.List<Themes> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Themes>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the themeses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of themeses.
	 *
	 * @return the number of themeses
	 */
	public int countAll();

}