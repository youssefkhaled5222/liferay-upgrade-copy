/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence.impl;

import com.ejada.telemony.db.exception.NoSuchThemesException;
import com.ejada.telemony.db.model.Themes;
import com.ejada.telemony.db.model.ThemesTable;
import com.ejada.telemony.db.model.impl.ThemesImpl;
import com.ejada.telemony.db.model.impl.ThemesModelImpl;
import com.ejada.telemony.db.service.persistence.ThemesPersistence;
import com.ejada.telemony.db.service.persistence.ThemesUtil;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the themes service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ThemesPersistenceImpl
	extends BasePersistenceImpl<Themes> implements ThemesPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ThemesUtil</code> to access the themes persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ThemesImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBydarkTheme;
	private FinderPath _finderPathWithoutPaginationFindBydarkTheme;
	private FinderPath _finderPathCountBydarkTheme;

	/**
	 * Returns all the themeses where channelId = &#63; and darkTheme = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param darkTheme the dark theme
	 * @return the matching themeses
	 */
	@Override
	public List<Themes> findBydarkTheme(long channelId, boolean darkTheme) {
		return findBydarkTheme(
			channelId, darkTheme, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Themes> findBydarkTheme(
		long channelId, boolean darkTheme, int start, int end) {

		return findBydarkTheme(channelId, darkTheme, start, end, null);
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
	@Override
	public List<Themes> findBydarkTheme(
		long channelId, boolean darkTheme, int start, int end,
		OrderByComparator<Themes> orderByComparator) {

		return findBydarkTheme(
			channelId, darkTheme, start, end, orderByComparator, true);
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
	@Override
	public List<Themes> findBydarkTheme(
		long channelId, boolean darkTheme, int start, int end,
		OrderByComparator<Themes> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBydarkTheme;
				finderArgs = new Object[] {channelId, darkTheme};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBydarkTheme;
			finderArgs = new Object[] {
				channelId, darkTheme, start, end, orderByComparator
			};
		}

		List<Themes> list = null;

		if (useFinderCache) {
			list = (List<Themes>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Themes themes : list) {
					if ((channelId != themes.getChannelId()) ||
						(darkTheme != themes.isDarkTheme())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_THEMES_WHERE);

			sb.append(_FINDER_COLUMN_DARKTHEME_CHANNELID_2);

			sb.append(_FINDER_COLUMN_DARKTHEME_DARKTHEME_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ThemesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				queryPos.add(darkTheme);

				list = (List<Themes>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Themes findBydarkTheme_First(
			long channelId, boolean darkTheme,
			OrderByComparator<Themes> orderByComparator)
		throws NoSuchThemesException {

		Themes themes = fetchBydarkTheme_First(
			channelId, darkTheme, orderByComparator);

		if (themes != null) {
			return themes;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append(", darkTheme=");
		sb.append(darkTheme);

		sb.append("}");

		throw new NoSuchThemesException(sb.toString());
	}

	/**
	 * Returns the first themes in the ordered set where channelId = &#63; and darkTheme = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param darkTheme the dark theme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching themes, or <code>null</code> if a matching themes could not be found
	 */
	@Override
	public Themes fetchBydarkTheme_First(
		long channelId, boolean darkTheme,
		OrderByComparator<Themes> orderByComparator) {

		List<Themes> list = findBydarkTheme(
			channelId, darkTheme, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Themes findBydarkTheme_Last(
			long channelId, boolean darkTheme,
			OrderByComparator<Themes> orderByComparator)
		throws NoSuchThemesException {

		Themes themes = fetchBydarkTheme_Last(
			channelId, darkTheme, orderByComparator);

		if (themes != null) {
			return themes;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append(", darkTheme=");
		sb.append(darkTheme);

		sb.append("}");

		throw new NoSuchThemesException(sb.toString());
	}

	/**
	 * Returns the last themes in the ordered set where channelId = &#63; and darkTheme = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param darkTheme the dark theme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching themes, or <code>null</code> if a matching themes could not be found
	 */
	@Override
	public Themes fetchBydarkTheme_Last(
		long channelId, boolean darkTheme,
		OrderByComparator<Themes> orderByComparator) {

		int count = countBydarkTheme(channelId, darkTheme);

		if (count == 0) {
			return null;
		}

		List<Themes> list = findBydarkTheme(
			channelId, darkTheme, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Themes[] findBydarkTheme_PrevAndNext(
			long themeId, long channelId, boolean darkTheme,
			OrderByComparator<Themes> orderByComparator)
		throws NoSuchThemesException {

		Themes themes = findByPrimaryKey(themeId);

		Session session = null;

		try {
			session = openSession();

			Themes[] array = new ThemesImpl[3];

			array[0] = getBydarkTheme_PrevAndNext(
				session, themes, channelId, darkTheme, orderByComparator, true);

			array[1] = themes;

			array[2] = getBydarkTheme_PrevAndNext(
				session, themes, channelId, darkTheme, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Themes getBydarkTheme_PrevAndNext(
		Session session, Themes themes, long channelId, boolean darkTheme,
		OrderByComparator<Themes> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_THEMES_WHERE);

		sb.append(_FINDER_COLUMN_DARKTHEME_CHANNELID_2);

		sb.append(_FINDER_COLUMN_DARKTHEME_DARKTHEME_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ThemesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(channelId);

		queryPos.add(darkTheme);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(themes)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Themes> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the themeses where channelId = &#63; and darkTheme = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param darkTheme the dark theme
	 */
	@Override
	public void removeBydarkTheme(long channelId, boolean darkTheme) {
		for (Themes themes :
				findBydarkTheme(
					channelId, darkTheme, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(themes);
		}
	}

	/**
	 * Returns the number of themeses where channelId = &#63; and darkTheme = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param darkTheme the dark theme
	 * @return the number of matching themeses
	 */
	@Override
	public int countBydarkTheme(long channelId, boolean darkTheme) {
		FinderPath finderPath = _finderPathCountBydarkTheme;

		Object[] finderArgs = new Object[] {channelId, darkTheme};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_THEMES_WHERE);

			sb.append(_FINDER_COLUMN_DARKTHEME_CHANNELID_2);

			sb.append(_FINDER_COLUMN_DARKTHEME_DARKTHEME_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				queryPos.add(darkTheme);

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_DARKTHEME_CHANNELID_2 =
		"themes.channelId = ? AND ";

	private static final String _FINDER_COLUMN_DARKTHEME_DARKTHEME_2 =
		"themes.darkTheme = ?";

	private FinderPath _finderPathWithPaginationFindByDefaultTheme;
	private FinderPath _finderPathWithoutPaginationFindByDefaultTheme;
	private FinderPath _finderPathCountByDefaultTheme;

	/**
	 * Returns all the themeses where channelId = &#63; and defaultTheme = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param defaultTheme the default theme
	 * @return the matching themeses
	 */
	@Override
	public List<Themes> findByDefaultTheme(
		long channelId, boolean defaultTheme) {

		return findByDefaultTheme(
			channelId, defaultTheme, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Themes> findByDefaultTheme(
		long channelId, boolean defaultTheme, int start, int end) {

		return findByDefaultTheme(channelId, defaultTheme, start, end, null);
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
	@Override
	public List<Themes> findByDefaultTheme(
		long channelId, boolean defaultTheme, int start, int end,
		OrderByComparator<Themes> orderByComparator) {

		return findByDefaultTheme(
			channelId, defaultTheme, start, end, orderByComparator, true);
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
	@Override
	public List<Themes> findByDefaultTheme(
		long channelId, boolean defaultTheme, int start, int end,
		OrderByComparator<Themes> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDefaultTheme;
				finderArgs = new Object[] {channelId, defaultTheme};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDefaultTheme;
			finderArgs = new Object[] {
				channelId, defaultTheme, start, end, orderByComparator
			};
		}

		List<Themes> list = null;

		if (useFinderCache) {
			list = (List<Themes>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Themes themes : list) {
					if ((channelId != themes.getChannelId()) ||
						(defaultTheme != themes.isDefaultTheme())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_THEMES_WHERE);

			sb.append(_FINDER_COLUMN_DEFAULTTHEME_CHANNELID_2);

			sb.append(_FINDER_COLUMN_DEFAULTTHEME_DEFAULTTHEME_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ThemesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				queryPos.add(defaultTheme);

				list = (List<Themes>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Themes findByDefaultTheme_First(
			long channelId, boolean defaultTheme,
			OrderByComparator<Themes> orderByComparator)
		throws NoSuchThemesException {

		Themes themes = fetchByDefaultTheme_First(
			channelId, defaultTheme, orderByComparator);

		if (themes != null) {
			return themes;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append(", defaultTheme=");
		sb.append(defaultTheme);

		sb.append("}");

		throw new NoSuchThemesException(sb.toString());
	}

	/**
	 * Returns the first themes in the ordered set where channelId = &#63; and defaultTheme = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param defaultTheme the default theme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching themes, or <code>null</code> if a matching themes could not be found
	 */
	@Override
	public Themes fetchByDefaultTheme_First(
		long channelId, boolean defaultTheme,
		OrderByComparator<Themes> orderByComparator) {

		List<Themes> list = findByDefaultTheme(
			channelId, defaultTheme, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Themes findByDefaultTheme_Last(
			long channelId, boolean defaultTheme,
			OrderByComparator<Themes> orderByComparator)
		throws NoSuchThemesException {

		Themes themes = fetchByDefaultTheme_Last(
			channelId, defaultTheme, orderByComparator);

		if (themes != null) {
			return themes;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append(", defaultTheme=");
		sb.append(defaultTheme);

		sb.append("}");

		throw new NoSuchThemesException(sb.toString());
	}

	/**
	 * Returns the last themes in the ordered set where channelId = &#63; and defaultTheme = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param defaultTheme the default theme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching themes, or <code>null</code> if a matching themes could not be found
	 */
	@Override
	public Themes fetchByDefaultTheme_Last(
		long channelId, boolean defaultTheme,
		OrderByComparator<Themes> orderByComparator) {

		int count = countByDefaultTheme(channelId, defaultTheme);

		if (count == 0) {
			return null;
		}

		List<Themes> list = findByDefaultTheme(
			channelId, defaultTheme, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Themes[] findByDefaultTheme_PrevAndNext(
			long themeId, long channelId, boolean defaultTheme,
			OrderByComparator<Themes> orderByComparator)
		throws NoSuchThemesException {

		Themes themes = findByPrimaryKey(themeId);

		Session session = null;

		try {
			session = openSession();

			Themes[] array = new ThemesImpl[3];

			array[0] = getByDefaultTheme_PrevAndNext(
				session, themes, channelId, defaultTheme, orderByComparator,
				true);

			array[1] = themes;

			array[2] = getByDefaultTheme_PrevAndNext(
				session, themes, channelId, defaultTheme, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Themes getByDefaultTheme_PrevAndNext(
		Session session, Themes themes, long channelId, boolean defaultTheme,
		OrderByComparator<Themes> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_THEMES_WHERE);

		sb.append(_FINDER_COLUMN_DEFAULTTHEME_CHANNELID_2);

		sb.append(_FINDER_COLUMN_DEFAULTTHEME_DEFAULTTHEME_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ThemesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(channelId);

		queryPos.add(defaultTheme);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(themes)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Themes> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the themeses where channelId = &#63; and defaultTheme = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param defaultTheme the default theme
	 */
	@Override
	public void removeByDefaultTheme(long channelId, boolean defaultTheme) {
		for (Themes themes :
				findByDefaultTheme(
					channelId, defaultTheme, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(themes);
		}
	}

	/**
	 * Returns the number of themeses where channelId = &#63; and defaultTheme = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param defaultTheme the default theme
	 * @return the number of matching themeses
	 */
	@Override
	public int countByDefaultTheme(long channelId, boolean defaultTheme) {
		FinderPath finderPath = _finderPathCountByDefaultTheme;

		Object[] finderArgs = new Object[] {channelId, defaultTheme};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_THEMES_WHERE);

			sb.append(_FINDER_COLUMN_DEFAULTTHEME_CHANNELID_2);

			sb.append(_FINDER_COLUMN_DEFAULTTHEME_DEFAULTTHEME_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				queryPos.add(defaultTheme);

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_DEFAULTTHEME_CHANNELID_2 =
		"themes.channelId = ? AND ";

	private static final String _FINDER_COLUMN_DEFAULTTHEME_DEFAULTTHEME_2 =
		"themes.defaultTheme = ?";

	private FinderPath _finderPathWithPaginationFindByDefaultModeTheme;
	private FinderPath _finderPathWithoutPaginationFindByDefaultModeTheme;
	private FinderPath _finderPathCountByDefaultModeTheme;

	/**
	 * Returns all the themeses where defaultTheme = &#63; and darkTheme = &#63; and channelId = &#63;.
	 *
	 * @param defaultTheme the default theme
	 * @param darkTheme the dark theme
	 * @param channelId the channel ID
	 * @return the matching themeses
	 */
	@Override
	public List<Themes> findByDefaultModeTheme(
		boolean defaultTheme, boolean darkTheme, long channelId) {

		return findByDefaultModeTheme(
			defaultTheme, darkTheme, channelId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Themes> findByDefaultModeTheme(
		boolean defaultTheme, boolean darkTheme, long channelId, int start,
		int end) {

		return findByDefaultModeTheme(
			defaultTheme, darkTheme, channelId, start, end, null);
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
	@Override
	public List<Themes> findByDefaultModeTheme(
		boolean defaultTheme, boolean darkTheme, long channelId, int start,
		int end, OrderByComparator<Themes> orderByComparator) {

		return findByDefaultModeTheme(
			defaultTheme, darkTheme, channelId, start, end, orderByComparator,
			true);
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
	@Override
	public List<Themes> findByDefaultModeTheme(
		boolean defaultTheme, boolean darkTheme, long channelId, int start,
		int end, OrderByComparator<Themes> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDefaultModeTheme;
				finderArgs = new Object[] {defaultTheme, darkTheme, channelId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDefaultModeTheme;
			finderArgs = new Object[] {
				defaultTheme, darkTheme, channelId, start, end,
				orderByComparator
			};
		}

		List<Themes> list = null;

		if (useFinderCache) {
			list = (List<Themes>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Themes themes : list) {
					if ((defaultTheme != themes.isDefaultTheme()) ||
						(darkTheme != themes.isDarkTheme()) ||
						(channelId != themes.getChannelId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_THEMES_WHERE);

			sb.append(_FINDER_COLUMN_DEFAULTMODETHEME_DEFAULTTHEME_2);

			sb.append(_FINDER_COLUMN_DEFAULTMODETHEME_DARKTHEME_2);

			sb.append(_FINDER_COLUMN_DEFAULTMODETHEME_CHANNELID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ThemesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(defaultTheme);

				queryPos.add(darkTheme);

				queryPos.add(channelId);

				list = (List<Themes>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Themes findByDefaultModeTheme_First(
			boolean defaultTheme, boolean darkTheme, long channelId,
			OrderByComparator<Themes> orderByComparator)
		throws NoSuchThemesException {

		Themes themes = fetchByDefaultModeTheme_First(
			defaultTheme, darkTheme, channelId, orderByComparator);

		if (themes != null) {
			return themes;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("defaultTheme=");
		sb.append(defaultTheme);

		sb.append(", darkTheme=");
		sb.append(darkTheme);

		sb.append(", channelId=");
		sb.append(channelId);

		sb.append("}");

		throw new NoSuchThemesException(sb.toString());
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
	@Override
	public Themes fetchByDefaultModeTheme_First(
		boolean defaultTheme, boolean darkTheme, long channelId,
		OrderByComparator<Themes> orderByComparator) {

		List<Themes> list = findByDefaultModeTheme(
			defaultTheme, darkTheme, channelId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Themes findByDefaultModeTheme_Last(
			boolean defaultTheme, boolean darkTheme, long channelId,
			OrderByComparator<Themes> orderByComparator)
		throws NoSuchThemesException {

		Themes themes = fetchByDefaultModeTheme_Last(
			defaultTheme, darkTheme, channelId, orderByComparator);

		if (themes != null) {
			return themes;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("defaultTheme=");
		sb.append(defaultTheme);

		sb.append(", darkTheme=");
		sb.append(darkTheme);

		sb.append(", channelId=");
		sb.append(channelId);

		sb.append("}");

		throw new NoSuchThemesException(sb.toString());
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
	@Override
	public Themes fetchByDefaultModeTheme_Last(
		boolean defaultTheme, boolean darkTheme, long channelId,
		OrderByComparator<Themes> orderByComparator) {

		int count = countByDefaultModeTheme(defaultTheme, darkTheme, channelId);

		if (count == 0) {
			return null;
		}

		List<Themes> list = findByDefaultModeTheme(
			defaultTheme, darkTheme, channelId, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Themes[] findByDefaultModeTheme_PrevAndNext(
			long themeId, boolean defaultTheme, boolean darkTheme,
			long channelId, OrderByComparator<Themes> orderByComparator)
		throws NoSuchThemesException {

		Themes themes = findByPrimaryKey(themeId);

		Session session = null;

		try {
			session = openSession();

			Themes[] array = new ThemesImpl[3];

			array[0] = getByDefaultModeTheme_PrevAndNext(
				session, themes, defaultTheme, darkTheme, channelId,
				orderByComparator, true);

			array[1] = themes;

			array[2] = getByDefaultModeTheme_PrevAndNext(
				session, themes, defaultTheme, darkTheme, channelId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Themes getByDefaultModeTheme_PrevAndNext(
		Session session, Themes themes, boolean defaultTheme, boolean darkTheme,
		long channelId, OrderByComparator<Themes> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_THEMES_WHERE);

		sb.append(_FINDER_COLUMN_DEFAULTMODETHEME_DEFAULTTHEME_2);

		sb.append(_FINDER_COLUMN_DEFAULTMODETHEME_DARKTHEME_2);

		sb.append(_FINDER_COLUMN_DEFAULTMODETHEME_CHANNELID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ThemesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(defaultTheme);

		queryPos.add(darkTheme);

		queryPos.add(channelId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(themes)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Themes> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the themeses where defaultTheme = &#63; and darkTheme = &#63; and channelId = &#63; from the database.
	 *
	 * @param defaultTheme the default theme
	 * @param darkTheme the dark theme
	 * @param channelId the channel ID
	 */
	@Override
	public void removeByDefaultModeTheme(
		boolean defaultTheme, boolean darkTheme, long channelId) {

		for (Themes themes :
				findByDefaultModeTheme(
					defaultTheme, darkTheme, channelId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(themes);
		}
	}

	/**
	 * Returns the number of themeses where defaultTheme = &#63; and darkTheme = &#63; and channelId = &#63;.
	 *
	 * @param defaultTheme the default theme
	 * @param darkTheme the dark theme
	 * @param channelId the channel ID
	 * @return the number of matching themeses
	 */
	@Override
	public int countByDefaultModeTheme(
		boolean defaultTheme, boolean darkTheme, long channelId) {

		FinderPath finderPath = _finderPathCountByDefaultModeTheme;

		Object[] finderArgs = new Object[] {defaultTheme, darkTheme, channelId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_THEMES_WHERE);

			sb.append(_FINDER_COLUMN_DEFAULTMODETHEME_DEFAULTTHEME_2);

			sb.append(_FINDER_COLUMN_DEFAULTMODETHEME_DARKTHEME_2);

			sb.append(_FINDER_COLUMN_DEFAULTMODETHEME_CHANNELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(defaultTheme);

				queryPos.add(darkTheme);

				queryPos.add(channelId);

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_DEFAULTMODETHEME_DEFAULTTHEME_2 =
		"themes.defaultTheme = ? AND ";

	private static final String _FINDER_COLUMN_DEFAULTMODETHEME_DARKTHEME_2 =
		"themes.darkTheme = ? AND ";

	private static final String _FINDER_COLUMN_DEFAULTMODETHEME_CHANNELID_2 =
		"themes.channelId = ?";

	private FinderPath _finderPathWithPaginationFindByChannelId;
	private FinderPath _finderPathWithoutPaginationFindByChannelId;
	private FinderPath _finderPathCountByChannelId;

	/**
	 * Returns all the themeses where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the matching themeses
	 */
	@Override
	public List<Themes> findByChannelId(long channelId) {
		return findByChannelId(
			channelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Themes> findByChannelId(long channelId, int start, int end) {
		return findByChannelId(channelId, start, end, null);
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
	@Override
	public List<Themes> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<Themes> orderByComparator) {

		return findByChannelId(channelId, start, end, orderByComparator, true);
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
	@Override
	public List<Themes> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<Themes> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByChannelId;
				finderArgs = new Object[] {channelId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByChannelId;
			finderArgs = new Object[] {
				channelId, start, end, orderByComparator
			};
		}

		List<Themes> list = null;

		if (useFinderCache) {
			list = (List<Themes>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Themes themes : list) {
					if (channelId != themes.getChannelId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_THEMES_WHERE);

			sb.append(_FINDER_COLUMN_CHANNELID_CHANNELID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ThemesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				list = (List<Themes>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first themes in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching themes
	 * @throws NoSuchThemesException if a matching themes could not be found
	 */
	@Override
	public Themes findByChannelId_First(
			long channelId, OrderByComparator<Themes> orderByComparator)
		throws NoSuchThemesException {

		Themes themes = fetchByChannelId_First(channelId, orderByComparator);

		if (themes != null) {
			return themes;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append("}");

		throw new NoSuchThemesException(sb.toString());
	}

	/**
	 * Returns the first themes in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching themes, or <code>null</code> if a matching themes could not be found
	 */
	@Override
	public Themes fetchByChannelId_First(
		long channelId, OrderByComparator<Themes> orderByComparator) {

		List<Themes> list = findByChannelId(channelId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last themes in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching themes
	 * @throws NoSuchThemesException if a matching themes could not be found
	 */
	@Override
	public Themes findByChannelId_Last(
			long channelId, OrderByComparator<Themes> orderByComparator)
		throws NoSuchThemesException {

		Themes themes = fetchByChannelId_Last(channelId, orderByComparator);

		if (themes != null) {
			return themes;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append("}");

		throw new NoSuchThemesException(sb.toString());
	}

	/**
	 * Returns the last themes in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching themes, or <code>null</code> if a matching themes could not be found
	 */
	@Override
	public Themes fetchByChannelId_Last(
		long channelId, OrderByComparator<Themes> orderByComparator) {

		int count = countByChannelId(channelId);

		if (count == 0) {
			return null;
		}

		List<Themes> list = findByChannelId(
			channelId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Themes[] findByChannelId_PrevAndNext(
			long themeId, long channelId,
			OrderByComparator<Themes> orderByComparator)
		throws NoSuchThemesException {

		Themes themes = findByPrimaryKey(themeId);

		Session session = null;

		try {
			session = openSession();

			Themes[] array = new ThemesImpl[3];

			array[0] = getByChannelId_PrevAndNext(
				session, themes, channelId, orderByComparator, true);

			array[1] = themes;

			array[2] = getByChannelId_PrevAndNext(
				session, themes, channelId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Themes getByChannelId_PrevAndNext(
		Session session, Themes themes, long channelId,
		OrderByComparator<Themes> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_THEMES_WHERE);

		sb.append(_FINDER_COLUMN_CHANNELID_CHANNELID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ThemesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(channelId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(themes)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Themes> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the themeses where channelId = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 */
	@Override
	public void removeByChannelId(long channelId) {
		for (Themes themes :
				findByChannelId(
					channelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(themes);
		}
	}

	/**
	 * Returns the number of themeses where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the number of matching themeses
	 */
	@Override
	public int countByChannelId(long channelId) {
		FinderPath finderPath = _finderPathCountByChannelId;

		Object[] finderArgs = new Object[] {channelId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_THEMES_WHERE);

			sb.append(_FINDER_COLUMN_CHANNELID_CHANNELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CHANNELID_CHANNELID_2 =
		"themes.channelId = ?";

	private FinderPath _finderPathWithPaginationFindByChannelIdAndStatus;
	private FinderPath _finderPathWithoutPaginationFindByChannelIdAndStatus;
	private FinderPath _finderPathCountByChannelIdAndStatus;

	/**
	 * Returns all the themeses where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @return the matching themeses
	 */
	@Override
	public List<Themes> findByChannelIdAndStatus(long channelId, int status) {
		return findByChannelIdAndStatus(
			channelId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Themes> findByChannelIdAndStatus(
		long channelId, int status, int start, int end) {

		return findByChannelIdAndStatus(channelId, status, start, end, null);
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
	@Override
	public List<Themes> findByChannelIdAndStatus(
		long channelId, int status, int start, int end,
		OrderByComparator<Themes> orderByComparator) {

		return findByChannelIdAndStatus(
			channelId, status, start, end, orderByComparator, true);
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
	@Override
	public List<Themes> findByChannelIdAndStatus(
		long channelId, int status, int start, int end,
		OrderByComparator<Themes> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByChannelIdAndStatus;
				finderArgs = new Object[] {channelId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByChannelIdAndStatus;
			finderArgs = new Object[] {
				channelId, status, start, end, orderByComparator
			};
		}

		List<Themes> list = null;

		if (useFinderCache) {
			list = (List<Themes>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Themes themes : list) {
					if ((channelId != themes.getChannelId()) ||
						(status != themes.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_THEMES_WHERE);

			sb.append(_FINDER_COLUMN_CHANNELIDANDSTATUS_CHANNELID_2);

			sb.append(_FINDER_COLUMN_CHANNELIDANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ThemesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				queryPos.add(status);

				list = (List<Themes>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Themes findByChannelIdAndStatus_First(
			long channelId, int status,
			OrderByComparator<Themes> orderByComparator)
		throws NoSuchThemesException {

		Themes themes = fetchByChannelIdAndStatus_First(
			channelId, status, orderByComparator);

		if (themes != null) {
			return themes;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchThemesException(sb.toString());
	}

	/**
	 * Returns the first themes in the ordered set where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching themes, or <code>null</code> if a matching themes could not be found
	 */
	@Override
	public Themes fetchByChannelIdAndStatus_First(
		long channelId, int status,
		OrderByComparator<Themes> orderByComparator) {

		List<Themes> list = findByChannelIdAndStatus(
			channelId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Themes findByChannelIdAndStatus_Last(
			long channelId, int status,
			OrderByComparator<Themes> orderByComparator)
		throws NoSuchThemesException {

		Themes themes = fetchByChannelIdAndStatus_Last(
			channelId, status, orderByComparator);

		if (themes != null) {
			return themes;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchThemesException(sb.toString());
	}

	/**
	 * Returns the last themes in the ordered set where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching themes, or <code>null</code> if a matching themes could not be found
	 */
	@Override
	public Themes fetchByChannelIdAndStatus_Last(
		long channelId, int status,
		OrderByComparator<Themes> orderByComparator) {

		int count = countByChannelIdAndStatus(channelId, status);

		if (count == 0) {
			return null;
		}

		List<Themes> list = findByChannelIdAndStatus(
			channelId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Themes[] findByChannelIdAndStatus_PrevAndNext(
			long themeId, long channelId, int status,
			OrderByComparator<Themes> orderByComparator)
		throws NoSuchThemesException {

		Themes themes = findByPrimaryKey(themeId);

		Session session = null;

		try {
			session = openSession();

			Themes[] array = new ThemesImpl[3];

			array[0] = getByChannelIdAndStatus_PrevAndNext(
				session, themes, channelId, status, orderByComparator, true);

			array[1] = themes;

			array[2] = getByChannelIdAndStatus_PrevAndNext(
				session, themes, channelId, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Themes getByChannelIdAndStatus_PrevAndNext(
		Session session, Themes themes, long channelId, int status,
		OrderByComparator<Themes> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_THEMES_WHERE);

		sb.append(_FINDER_COLUMN_CHANNELIDANDSTATUS_CHANNELID_2);

		sb.append(_FINDER_COLUMN_CHANNELIDANDSTATUS_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ThemesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(channelId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(themes)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Themes> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the themeses where channelId = &#63; and status = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 */
	@Override
	public void removeByChannelIdAndStatus(long channelId, int status) {
		for (Themes themes :
				findByChannelIdAndStatus(
					channelId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(themes);
		}
	}

	/**
	 * Returns the number of themeses where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @return the number of matching themeses
	 */
	@Override
	public int countByChannelIdAndStatus(long channelId, int status) {
		FinderPath finderPath = _finderPathCountByChannelIdAndStatus;

		Object[] finderArgs = new Object[] {channelId, status};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_THEMES_WHERE);

			sb.append(_FINDER_COLUMN_CHANNELIDANDSTATUS_CHANNELID_2);

			sb.append(_FINDER_COLUMN_CHANNELIDANDSTATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				queryPos.add(status);

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CHANNELIDANDSTATUS_CHANNELID_2 =
		"themes.channelId = ? AND ";

	private static final String _FINDER_COLUMN_CHANNELIDANDSTATUS_STATUS_2 =
		"themes.status = ?";

	private FinderPath _finderPathWithPaginationFindByentityResourceId;
	private FinderPath _finderPathWithoutPaginationFindByentityResourceId;
	private FinderPath _finderPathCountByentityResourceId;

	/**
	 * Returns all the themeses where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the matching themeses
	 */
	@Override
	public List<Themes> findByentityResourceId(long entityResourceId) {
		return findByentityResourceId(
			entityResourceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Themes> findByentityResourceId(
		long entityResourceId, int start, int end) {

		return findByentityResourceId(entityResourceId, start, end, null);
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
	@Override
	public List<Themes> findByentityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<Themes> orderByComparator) {

		return findByentityResourceId(
			entityResourceId, start, end, orderByComparator, true);
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
	@Override
	public List<Themes> findByentityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<Themes> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByentityResourceId;
				finderArgs = new Object[] {entityResourceId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByentityResourceId;
			finderArgs = new Object[] {
				entityResourceId, start, end, orderByComparator
			};
		}

		List<Themes> list = null;

		if (useFinderCache) {
			list = (List<Themes>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Themes themes : list) {
					if (entityResourceId != themes.getEntityResourceId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_THEMES_WHERE);

			sb.append(_FINDER_COLUMN_ENTITYRESOURCEID_ENTITYRESOURCEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ThemesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(entityResourceId);

				list = (List<Themes>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first themes in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching themes
	 * @throws NoSuchThemesException if a matching themes could not be found
	 */
	@Override
	public Themes findByentityResourceId_First(
			long entityResourceId, OrderByComparator<Themes> orderByComparator)
		throws NoSuchThemesException {

		Themes themes = fetchByentityResourceId_First(
			entityResourceId, orderByComparator);

		if (themes != null) {
			return themes;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("entityResourceId=");
		sb.append(entityResourceId);

		sb.append("}");

		throw new NoSuchThemesException(sb.toString());
	}

	/**
	 * Returns the first themes in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching themes, or <code>null</code> if a matching themes could not be found
	 */
	@Override
	public Themes fetchByentityResourceId_First(
		long entityResourceId, OrderByComparator<Themes> orderByComparator) {

		List<Themes> list = findByentityResourceId(
			entityResourceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last themes in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching themes
	 * @throws NoSuchThemesException if a matching themes could not be found
	 */
	@Override
	public Themes findByentityResourceId_Last(
			long entityResourceId, OrderByComparator<Themes> orderByComparator)
		throws NoSuchThemesException {

		Themes themes = fetchByentityResourceId_Last(
			entityResourceId, orderByComparator);

		if (themes != null) {
			return themes;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("entityResourceId=");
		sb.append(entityResourceId);

		sb.append("}");

		throw new NoSuchThemesException(sb.toString());
	}

	/**
	 * Returns the last themes in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching themes, or <code>null</code> if a matching themes could not be found
	 */
	@Override
	public Themes fetchByentityResourceId_Last(
		long entityResourceId, OrderByComparator<Themes> orderByComparator) {

		int count = countByentityResourceId(entityResourceId);

		if (count == 0) {
			return null;
		}

		List<Themes> list = findByentityResourceId(
			entityResourceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Themes[] findByentityResourceId_PrevAndNext(
			long themeId, long entityResourceId,
			OrderByComparator<Themes> orderByComparator)
		throws NoSuchThemesException {

		Themes themes = findByPrimaryKey(themeId);

		Session session = null;

		try {
			session = openSession();

			Themes[] array = new ThemesImpl[3];

			array[0] = getByentityResourceId_PrevAndNext(
				session, themes, entityResourceId, orderByComparator, true);

			array[1] = themes;

			array[2] = getByentityResourceId_PrevAndNext(
				session, themes, entityResourceId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Themes getByentityResourceId_PrevAndNext(
		Session session, Themes themes, long entityResourceId,
		OrderByComparator<Themes> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_THEMES_WHERE);

		sb.append(_FINDER_COLUMN_ENTITYRESOURCEID_ENTITYRESOURCEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ThemesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(entityResourceId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(themes)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Themes> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the themeses where entityResourceId = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 */
	@Override
	public void removeByentityResourceId(long entityResourceId) {
		for (Themes themes :
				findByentityResourceId(
					entityResourceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(themes);
		}
	}

	/**
	 * Returns the number of themeses where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the number of matching themeses
	 */
	@Override
	public int countByentityResourceId(long entityResourceId) {
		FinderPath finderPath = _finderPathCountByentityResourceId;

		Object[] finderArgs = new Object[] {entityResourceId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_THEMES_WHERE);

			sb.append(_FINDER_COLUMN_ENTITYRESOURCEID_ENTITYRESOURCEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(entityResourceId);

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_ENTITYRESOURCEID_ENTITYRESOURCEID_2 =
			"themes.entityResourceId = ?";

	public ThemesPersistenceImpl() {
		setModelClass(Themes.class);

		setModelImplClass(ThemesImpl.class);
		setModelPKClass(long.class);

		setTable(ThemesTable.INSTANCE);
	}

	/**
	 * Caches the themes in the entity cache if it is enabled.
	 *
	 * @param themes the themes
	 */
	@Override
	public void cacheResult(Themes themes) {
		dummyEntityCache.putResult(
			ThemesImpl.class, themes.getPrimaryKey(), themes);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the themeses in the entity cache if it is enabled.
	 *
	 * @param themeses the themeses
	 */
	@Override
	public void cacheResult(List<Themes> themeses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (themeses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Themes themes : themeses) {
			if (dummyEntityCache.getResult(
					ThemesImpl.class, themes.getPrimaryKey()) == null) {

				cacheResult(themes);
			}
		}
	}

	/**
	 * Clears the cache for all themeses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(ThemesImpl.class);

		dummyFinderCache.clearCache(ThemesImpl.class);
	}

	/**
	 * Clears the cache for the themes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Themes themes) {
		dummyEntityCache.removeResult(ThemesImpl.class, themes);
	}

	@Override
	public void clearCache(List<Themes> themeses) {
		for (Themes themes : themeses) {
			dummyEntityCache.removeResult(ThemesImpl.class, themes);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(ThemesImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(ThemesImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new themes with the primary key. Does not add the themes to the database.
	 *
	 * @param themeId the primary key for the new themes
	 * @return the new themes
	 */
	@Override
	public Themes create(long themeId) {
		Themes themes = new ThemesImpl();

		themes.setNew(true);
		themes.setPrimaryKey(themeId);

		themes.setCompanyId(CompanyThreadLocal.getCompanyId());

		return themes;
	}

	/**
	 * Removes the themes with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param themeId the primary key of the themes
	 * @return the themes that was removed
	 * @throws NoSuchThemesException if a themes with the primary key could not be found
	 */
	@Override
	public Themes remove(long themeId) throws NoSuchThemesException {
		return remove((Serializable)themeId);
	}

	/**
	 * Removes the themes with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the themes
	 * @return the themes that was removed
	 * @throws NoSuchThemesException if a themes with the primary key could not be found
	 */
	@Override
	public Themes remove(Serializable primaryKey) throws NoSuchThemesException {
		Session session = null;

		try {
			session = openSession();

			Themes themes = (Themes)session.get(ThemesImpl.class, primaryKey);

			if (themes == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchThemesException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(themes);
		}
		catch (NoSuchThemesException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Themes removeImpl(Themes themes) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(themes)) {
				themes = (Themes)session.get(
					ThemesImpl.class, themes.getPrimaryKeyObj());
			}

			if (themes != null) {
				session.delete(themes);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (themes != null) {
			clearCache(themes);
		}

		return themes;
	}

	@Override
	public Themes updateImpl(Themes themes) {
		boolean isNew = themes.isNew();

		if (!(themes instanceof ThemesModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(themes.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(themes);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in themes proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Themes implementation " +
					themes.getClass());
		}

		ThemesModelImpl themesModelImpl = (ThemesModelImpl)themes;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (themes.getCreateDate() == null)) {
			if (serviceContext == null) {
				themes.setCreateDate(date);
			}
			else {
				themes.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!themesModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				themes.setModifiedDate(date);
			}
			else {
				themes.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(themes);
			}
			else {
				themes = (Themes)session.merge(themes);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			ThemesImpl.class, themesModelImpl, false, true);

		if (isNew) {
			themes.setNew(false);
		}

		themes.resetOriginalValues();

		return themes;
	}

	/**
	 * Returns the themes with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the themes
	 * @return the themes
	 * @throws NoSuchThemesException if a themes with the primary key could not be found
	 */
	@Override
	public Themes findByPrimaryKey(Serializable primaryKey)
		throws NoSuchThemesException {

		Themes themes = fetchByPrimaryKey(primaryKey);

		if (themes == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchThemesException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return themes;
	}

	/**
	 * Returns the themes with the primary key or throws a <code>NoSuchThemesException</code> if it could not be found.
	 *
	 * @param themeId the primary key of the themes
	 * @return the themes
	 * @throws NoSuchThemesException if a themes with the primary key could not be found
	 */
	@Override
	public Themes findByPrimaryKey(long themeId) throws NoSuchThemesException {
		return findByPrimaryKey((Serializable)themeId);
	}

	/**
	 * Returns the themes with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param themeId the primary key of the themes
	 * @return the themes, or <code>null</code> if a themes with the primary key could not be found
	 */
	@Override
	public Themes fetchByPrimaryKey(long themeId) {
		return fetchByPrimaryKey((Serializable)themeId);
	}

	/**
	 * Returns all the themeses.
	 *
	 * @return the themeses
	 */
	@Override
	public List<Themes> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Themes> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Themes> findAll(
		int start, int end, OrderByComparator<Themes> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Themes> findAll(
		int start, int end, OrderByComparator<Themes> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Themes> list = null;

		if (useFinderCache) {
			list = (List<Themes>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_THEMES);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_THEMES;

				sql = sql.concat(ThemesModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Themes>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the themeses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Themes themes : findAll()) {
			remove(themes);
		}
	}

	/**
	 * Returns the number of themeses.
	 *
	 * @return the number of themeses
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_THEMES);

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return dummyEntityCache;
	}

	@Override
	protected String getPKDBName() {
		return "themeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_THEMES;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ThemesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the themes persistence.
	 */
	public void afterPropertiesSet() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindBydarkTheme = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBydarkTheme",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"channelId", "darkTheme"}, true);

		_finderPathWithoutPaginationFindBydarkTheme = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBydarkTheme",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"channelId", "darkTheme"}, true);

		_finderPathCountBydarkTheme = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBydarkTheme",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"channelId", "darkTheme"}, false);

		_finderPathWithPaginationFindByDefaultTheme = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDefaultTheme",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"channelId", "defaultTheme"}, true);

		_finderPathWithoutPaginationFindByDefaultTheme = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDefaultTheme",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"channelId", "defaultTheme"}, true);

		_finderPathCountByDefaultTheme = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDefaultTheme",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"channelId", "defaultTheme"}, false);

		_finderPathWithPaginationFindByDefaultModeTheme = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDefaultModeTheme",
			new String[] {
				Boolean.class.getName(), Boolean.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"defaultTheme", "darkTheme", "channelId"}, true);

		_finderPathWithoutPaginationFindByDefaultModeTheme = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDefaultModeTheme",
			new String[] {
				Boolean.class.getName(), Boolean.class.getName(),
				Long.class.getName()
			},
			new String[] {"defaultTheme", "darkTheme", "channelId"}, true);

		_finderPathCountByDefaultModeTheme = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDefaultModeTheme",
			new String[] {
				Boolean.class.getName(), Boolean.class.getName(),
				Long.class.getName()
			},
			new String[] {"defaultTheme", "darkTheme", "channelId"}, false);

		_finderPathWithPaginationFindByChannelId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByChannelId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"channelId"}, true);

		_finderPathWithoutPaginationFindByChannelId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByChannelId",
			new String[] {Long.class.getName()}, new String[] {"channelId"},
			true);

		_finderPathCountByChannelId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByChannelId",
			new String[] {Long.class.getName()}, new String[] {"channelId"},
			false);

		_finderPathWithPaginationFindByChannelIdAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByChannelIdAndStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"channelId", "status"}, true);

		_finderPathWithoutPaginationFindByChannelIdAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByChannelIdAndStatus",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"channelId", "status"}, true);

		_finderPathCountByChannelIdAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByChannelIdAndStatus",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"channelId", "status"}, false);

		_finderPathWithPaginationFindByentityResourceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByentityResourceId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"entityResourceId"}, true);

		_finderPathWithoutPaginationFindByentityResourceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByentityResourceId",
			new String[] {Long.class.getName()},
			new String[] {"entityResourceId"}, true);

		_finderPathCountByentityResourceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByentityResourceId", new String[] {Long.class.getName()},
			new String[] {"entityResourceId"}, false);

		ThemesUtil.setPersistence(this);
	}

	public void destroy() {
		ThemesUtil.setPersistence(null);

		dummyEntityCache.removeCache(ThemesImpl.class.getName());
	}

	private static final String _SQL_SELECT_THEMES =
		"SELECT themes FROM Themes themes";

	private static final String _SQL_SELECT_THEMES_WHERE =
		"SELECT themes FROM Themes themes WHERE ";

	private static final String _SQL_COUNT_THEMES =
		"SELECT COUNT(themes) FROM Themes themes";

	private static final String _SQL_COUNT_THEMES_WHERE =
		"SELECT COUNT(themes) FROM Themes themes WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "themes.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Themes exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Themes exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ThemesPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}