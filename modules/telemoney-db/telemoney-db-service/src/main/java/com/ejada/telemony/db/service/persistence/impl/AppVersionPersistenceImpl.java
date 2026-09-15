/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence.impl;

import com.ejada.telemony.db.exception.NoSuchAppVersionException;
import com.ejada.telemony.db.model.AppVersion;
import com.ejada.telemony.db.model.AppVersionTable;
import com.ejada.telemony.db.model.impl.AppVersionImpl;
import com.ejada.telemony.db.model.impl.AppVersionModelImpl;
import com.ejada.telemony.db.service.persistence.AppVersionPersistence;
import com.ejada.telemony.db.service.persistence.AppVersionUtil;

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
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the app version service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AppVersionPersistenceImpl
	extends BasePersistenceImpl<AppVersion> implements AppVersionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AppVersionUtil</code> to access the app version persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AppVersionImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByChannelId;
	private FinderPath _finderPathWithoutPaginationFindByChannelId;
	private FinderPath _finderPathCountByChannelId;

	/**
	 * Returns all the app versions where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the matching app versions
	 */
	@Override
	public List<AppVersion> findByChannelId(long channelId) {
		return findByChannelId(
			channelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the app versions where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @return the range of matching app versions
	 */
	@Override
	public List<AppVersion> findByChannelId(
		long channelId, int start, int end) {

		return findByChannelId(channelId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the app versions where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching app versions
	 */
	@Override
	public List<AppVersion> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<AppVersion> orderByComparator) {

		return findByChannelId(channelId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the app versions where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching app versions
	 */
	@Override
	public List<AppVersion> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<AppVersion> orderByComparator,
		boolean useFinderCache) {

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

		List<AppVersion> list = null;

		if (useFinderCache) {
			list = (List<AppVersion>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AppVersion appVersion : list) {
					if (channelId != appVersion.getChannelId()) {
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

			sb.append(_SQL_SELECT_APPVERSION_WHERE);

			sb.append(_FINDER_COLUMN_CHANNELID_CHANNELID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AppVersionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				list = (List<AppVersion>)QueryUtil.list(
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
	 * Returns the first app version in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app version
	 * @throws NoSuchAppVersionException if a matching app version could not be found
	 */
	@Override
	public AppVersion findByChannelId_First(
			long channelId, OrderByComparator<AppVersion> orderByComparator)
		throws NoSuchAppVersionException {

		AppVersion appVersion = fetchByChannelId_First(
			channelId, orderByComparator);

		if (appVersion != null) {
			return appVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append("}");

		throw new NoSuchAppVersionException(sb.toString());
	}

	/**
	 * Returns the first app version in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app version, or <code>null</code> if a matching app version could not be found
	 */
	@Override
	public AppVersion fetchByChannelId_First(
		long channelId, OrderByComparator<AppVersion> orderByComparator) {

		List<AppVersion> list = findByChannelId(
			channelId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last app version in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app version
	 * @throws NoSuchAppVersionException if a matching app version could not be found
	 */
	@Override
	public AppVersion findByChannelId_Last(
			long channelId, OrderByComparator<AppVersion> orderByComparator)
		throws NoSuchAppVersionException {

		AppVersion appVersion = fetchByChannelId_Last(
			channelId, orderByComparator);

		if (appVersion != null) {
			return appVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append("}");

		throw new NoSuchAppVersionException(sb.toString());
	}

	/**
	 * Returns the last app version in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app version, or <code>null</code> if a matching app version could not be found
	 */
	@Override
	public AppVersion fetchByChannelId_Last(
		long channelId, OrderByComparator<AppVersion> orderByComparator) {

		int count = countByChannelId(channelId);

		if (count == 0) {
			return null;
		}

		List<AppVersion> list = findByChannelId(
			channelId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the app versions before and after the current app version in the ordered set where channelId = &#63;.
	 *
	 * @param versionId the primary key of the current app version
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app version
	 * @throws NoSuchAppVersionException if a app version with the primary key could not be found
	 */
	@Override
	public AppVersion[] findByChannelId_PrevAndNext(
			long versionId, long channelId,
			OrderByComparator<AppVersion> orderByComparator)
		throws NoSuchAppVersionException {

		AppVersion appVersion = findByPrimaryKey(versionId);

		Session session = null;

		try {
			session = openSession();

			AppVersion[] array = new AppVersionImpl[3];

			array[0] = getByChannelId_PrevAndNext(
				session, appVersion, channelId, orderByComparator, true);

			array[1] = appVersion;

			array[2] = getByChannelId_PrevAndNext(
				session, appVersion, channelId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AppVersion getByChannelId_PrevAndNext(
		Session session, AppVersion appVersion, long channelId,
		OrderByComparator<AppVersion> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_APPVERSION_WHERE);

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
			sb.append(AppVersionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(channelId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(appVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AppVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the app versions where channelId = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 */
	@Override
	public void removeByChannelId(long channelId) {
		for (AppVersion appVersion :
				findByChannelId(
					channelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(appVersion);
		}
	}

	/**
	 * Returns the number of app versions where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the number of matching app versions
	 */
	@Override
	public int countByChannelId(long channelId) {
		FinderPath finderPath = _finderPathCountByChannelId;

		Object[] finderArgs = new Object[] {channelId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_APPVERSION_WHERE);

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
		"appVersion.channelId = ?";

	private FinderPath _finderPathWithPaginationFindByPlatform;
	private FinderPath _finderPathWithoutPaginationFindByPlatform;
	private FinderPath _finderPathCountByPlatform;

	/**
	 * Returns all the app versions where platform = &#63; and channelId = &#63;.
	 *
	 * @param platform the platform
	 * @param channelId the channel ID
	 * @return the matching app versions
	 */
	@Override
	public List<AppVersion> findByPlatform(String platform, long channelId) {
		return findByPlatform(
			platform, channelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the app versions where platform = &#63; and channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param platform the platform
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @return the range of matching app versions
	 */
	@Override
	public List<AppVersion> findByPlatform(
		String platform, long channelId, int start, int end) {

		return findByPlatform(platform, channelId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the app versions where platform = &#63; and channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param platform the platform
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching app versions
	 */
	@Override
	public List<AppVersion> findByPlatform(
		String platform, long channelId, int start, int end,
		OrderByComparator<AppVersion> orderByComparator) {

		return findByPlatform(
			platform, channelId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the app versions where platform = &#63; and channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param platform the platform
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching app versions
	 */
	@Override
	public List<AppVersion> findByPlatform(
		String platform, long channelId, int start, int end,
		OrderByComparator<AppVersion> orderByComparator,
		boolean useFinderCache) {

		platform = Objects.toString(platform, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPlatform;
				finderArgs = new Object[] {platform, channelId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPlatform;
			finderArgs = new Object[] {
				platform, channelId, start, end, orderByComparator
			};
		}

		List<AppVersion> list = null;

		if (useFinderCache) {
			list = (List<AppVersion>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AppVersion appVersion : list) {
					if (!platform.equals(appVersion.getPlatform()) ||
						(channelId != appVersion.getChannelId())) {

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

			sb.append(_SQL_SELECT_APPVERSION_WHERE);

			boolean bindPlatform = false;

			if (platform.isEmpty()) {
				sb.append(_FINDER_COLUMN_PLATFORM_PLATFORM_3);
			}
			else {
				bindPlatform = true;

				sb.append(_FINDER_COLUMN_PLATFORM_PLATFORM_2);
			}

			sb.append(_FINDER_COLUMN_PLATFORM_CHANNELID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AppVersionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPlatform) {
					queryPos.add(platform);
				}

				queryPos.add(channelId);

				list = (List<AppVersion>)QueryUtil.list(
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
	 * Returns the first app version in the ordered set where platform = &#63; and channelId = &#63;.
	 *
	 * @param platform the platform
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app version
	 * @throws NoSuchAppVersionException if a matching app version could not be found
	 */
	@Override
	public AppVersion findByPlatform_First(
			String platform, long channelId,
			OrderByComparator<AppVersion> orderByComparator)
		throws NoSuchAppVersionException {

		AppVersion appVersion = fetchByPlatform_First(
			platform, channelId, orderByComparator);

		if (appVersion != null) {
			return appVersion;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("platform=");
		sb.append(platform);

		sb.append(", channelId=");
		sb.append(channelId);

		sb.append("}");

		throw new NoSuchAppVersionException(sb.toString());
	}

	/**
	 * Returns the first app version in the ordered set where platform = &#63; and channelId = &#63;.
	 *
	 * @param platform the platform
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app version, or <code>null</code> if a matching app version could not be found
	 */
	@Override
	public AppVersion fetchByPlatform_First(
		String platform, long channelId,
		OrderByComparator<AppVersion> orderByComparator) {

		List<AppVersion> list = findByPlatform(
			platform, channelId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last app version in the ordered set where platform = &#63; and channelId = &#63;.
	 *
	 * @param platform the platform
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app version
	 * @throws NoSuchAppVersionException if a matching app version could not be found
	 */
	@Override
	public AppVersion findByPlatform_Last(
			String platform, long channelId,
			OrderByComparator<AppVersion> orderByComparator)
		throws NoSuchAppVersionException {

		AppVersion appVersion = fetchByPlatform_Last(
			platform, channelId, orderByComparator);

		if (appVersion != null) {
			return appVersion;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("platform=");
		sb.append(platform);

		sb.append(", channelId=");
		sb.append(channelId);

		sb.append("}");

		throw new NoSuchAppVersionException(sb.toString());
	}

	/**
	 * Returns the last app version in the ordered set where platform = &#63; and channelId = &#63;.
	 *
	 * @param platform the platform
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app version, or <code>null</code> if a matching app version could not be found
	 */
	@Override
	public AppVersion fetchByPlatform_Last(
		String platform, long channelId,
		OrderByComparator<AppVersion> orderByComparator) {

		int count = countByPlatform(platform, channelId);

		if (count == 0) {
			return null;
		}

		List<AppVersion> list = findByPlatform(
			platform, channelId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the app versions before and after the current app version in the ordered set where platform = &#63; and channelId = &#63;.
	 *
	 * @param versionId the primary key of the current app version
	 * @param platform the platform
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app version
	 * @throws NoSuchAppVersionException if a app version with the primary key could not be found
	 */
	@Override
	public AppVersion[] findByPlatform_PrevAndNext(
			long versionId, String platform, long channelId,
			OrderByComparator<AppVersion> orderByComparator)
		throws NoSuchAppVersionException {

		platform = Objects.toString(platform, "");

		AppVersion appVersion = findByPrimaryKey(versionId);

		Session session = null;

		try {
			session = openSession();

			AppVersion[] array = new AppVersionImpl[3];

			array[0] = getByPlatform_PrevAndNext(
				session, appVersion, platform, channelId, orderByComparator,
				true);

			array[1] = appVersion;

			array[2] = getByPlatform_PrevAndNext(
				session, appVersion, platform, channelId, orderByComparator,
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

	protected AppVersion getByPlatform_PrevAndNext(
		Session session, AppVersion appVersion, String platform, long channelId,
		OrderByComparator<AppVersion> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_APPVERSION_WHERE);

		boolean bindPlatform = false;

		if (platform.isEmpty()) {
			sb.append(_FINDER_COLUMN_PLATFORM_PLATFORM_3);
		}
		else {
			bindPlatform = true;

			sb.append(_FINDER_COLUMN_PLATFORM_PLATFORM_2);
		}

		sb.append(_FINDER_COLUMN_PLATFORM_CHANNELID_2);

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
			sb.append(AppVersionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindPlatform) {
			queryPos.add(platform);
		}

		queryPos.add(channelId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(appVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AppVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the app versions where platform = &#63; and channelId = &#63; from the database.
	 *
	 * @param platform the platform
	 * @param channelId the channel ID
	 */
	@Override
	public void removeByPlatform(String platform, long channelId) {
		for (AppVersion appVersion :
				findByPlatform(
					platform, channelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(appVersion);
		}
	}

	/**
	 * Returns the number of app versions where platform = &#63; and channelId = &#63;.
	 *
	 * @param platform the platform
	 * @param channelId the channel ID
	 * @return the number of matching app versions
	 */
	@Override
	public int countByPlatform(String platform, long channelId) {
		platform = Objects.toString(platform, "");

		FinderPath finderPath = _finderPathCountByPlatform;

		Object[] finderArgs = new Object[] {platform, channelId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_APPVERSION_WHERE);

			boolean bindPlatform = false;

			if (platform.isEmpty()) {
				sb.append(_FINDER_COLUMN_PLATFORM_PLATFORM_3);
			}
			else {
				bindPlatform = true;

				sb.append(_FINDER_COLUMN_PLATFORM_PLATFORM_2);
			}

			sb.append(_FINDER_COLUMN_PLATFORM_CHANNELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPlatform) {
					queryPos.add(platform);
				}

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

	private static final String _FINDER_COLUMN_PLATFORM_PLATFORM_2 =
		"appVersion.platform = ? AND ";

	private static final String _FINDER_COLUMN_PLATFORM_PLATFORM_3 =
		"(appVersion.platform IS NULL OR appVersion.platform = '') AND ";

	private static final String _FINDER_COLUMN_PLATFORM_CHANNELID_2 =
		"appVersion.channelId = ?";

	private FinderPath _finderPathWithPaginationFindByWorkflowStatus;
	private FinderPath _finderPathWithoutPaginationFindByWorkflowStatus;
	private FinderPath _finderPathCountByWorkflowStatus;

	/**
	 * Returns all the app versions where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching app versions
	 */
	@Override
	public List<AppVersion> findByWorkflowStatus(int status) {
		return findByWorkflowStatus(
			status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the app versions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @return the range of matching app versions
	 */
	@Override
	public List<AppVersion> findByWorkflowStatus(
		int status, int start, int end) {

		return findByWorkflowStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the app versions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching app versions
	 */
	@Override
	public List<AppVersion> findByWorkflowStatus(
		int status, int start, int end,
		OrderByComparator<AppVersion> orderByComparator) {

		return findByWorkflowStatus(
			status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the app versions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching app versions
	 */
	@Override
	public List<AppVersion> findByWorkflowStatus(
		int status, int start, int end,
		OrderByComparator<AppVersion> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByWorkflowStatus;
				finderArgs = new Object[] {status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByWorkflowStatus;
			finderArgs = new Object[] {status, start, end, orderByComparator};
		}

		List<AppVersion> list = null;

		if (useFinderCache) {
			list = (List<AppVersion>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AppVersion appVersion : list) {
					if (status != appVersion.getStatus()) {
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

			sb.append(_SQL_SELECT_APPVERSION_WHERE);

			sb.append(_FINDER_COLUMN_WORKFLOWSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AppVersionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				list = (List<AppVersion>)QueryUtil.list(
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
	 * Returns the first app version in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app version
	 * @throws NoSuchAppVersionException if a matching app version could not be found
	 */
	@Override
	public AppVersion findByWorkflowStatus_First(
			int status, OrderByComparator<AppVersion> orderByComparator)
		throws NoSuchAppVersionException {

		AppVersion appVersion = fetchByWorkflowStatus_First(
			status, orderByComparator);

		if (appVersion != null) {
			return appVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchAppVersionException(sb.toString());
	}

	/**
	 * Returns the first app version in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app version, or <code>null</code> if a matching app version could not be found
	 */
	@Override
	public AppVersion fetchByWorkflowStatus_First(
		int status, OrderByComparator<AppVersion> orderByComparator) {

		List<AppVersion> list = findByWorkflowStatus(
			status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last app version in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app version
	 * @throws NoSuchAppVersionException if a matching app version could not be found
	 */
	@Override
	public AppVersion findByWorkflowStatus_Last(
			int status, OrderByComparator<AppVersion> orderByComparator)
		throws NoSuchAppVersionException {

		AppVersion appVersion = fetchByWorkflowStatus_Last(
			status, orderByComparator);

		if (appVersion != null) {
			return appVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchAppVersionException(sb.toString());
	}

	/**
	 * Returns the last app version in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app version, or <code>null</code> if a matching app version could not be found
	 */
	@Override
	public AppVersion fetchByWorkflowStatus_Last(
		int status, OrderByComparator<AppVersion> orderByComparator) {

		int count = countByWorkflowStatus(status);

		if (count == 0) {
			return null;
		}

		List<AppVersion> list = findByWorkflowStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the app versions before and after the current app version in the ordered set where status = &#63;.
	 *
	 * @param versionId the primary key of the current app version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app version
	 * @throws NoSuchAppVersionException if a app version with the primary key could not be found
	 */
	@Override
	public AppVersion[] findByWorkflowStatus_PrevAndNext(
			long versionId, int status,
			OrderByComparator<AppVersion> orderByComparator)
		throws NoSuchAppVersionException {

		AppVersion appVersion = findByPrimaryKey(versionId);

		Session session = null;

		try {
			session = openSession();

			AppVersion[] array = new AppVersionImpl[3];

			array[0] = getByWorkflowStatus_PrevAndNext(
				session, appVersion, status, orderByComparator, true);

			array[1] = appVersion;

			array[2] = getByWorkflowStatus_PrevAndNext(
				session, appVersion, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AppVersion getByWorkflowStatus_PrevAndNext(
		Session session, AppVersion appVersion, int status,
		OrderByComparator<AppVersion> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_APPVERSION_WHERE);

		sb.append(_FINDER_COLUMN_WORKFLOWSTATUS_STATUS_2);

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
			sb.append(AppVersionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(appVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AppVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the app versions where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByWorkflowStatus(int status) {
		for (AppVersion appVersion :
				findByWorkflowStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(appVersion);
		}
	}

	/**
	 * Returns the number of app versions where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching app versions
	 */
	@Override
	public int countByWorkflowStatus(int status) {
		FinderPath finderPath = _finderPathCountByWorkflowStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_APPVERSION_WHERE);

			sb.append(_FINDER_COLUMN_WORKFLOWSTATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

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

	private static final String _FINDER_COLUMN_WORKFLOWSTATUS_STATUS_2 =
		"appVersion.status = ?";

	private FinderPath _finderPathWithPaginationFindByEntityResourceId;
	private FinderPath _finderPathWithoutPaginationFindByEntityResourceId;
	private FinderPath _finderPathCountByEntityResourceId;

	/**
	 * Returns all the app versions where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the matching app versions
	 */
	@Override
	public List<AppVersion> findByEntityResourceId(long entityResourceId) {
		return findByEntityResourceId(
			entityResourceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the app versions where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @return the range of matching app versions
	 */
	@Override
	public List<AppVersion> findByEntityResourceId(
		long entityResourceId, int start, int end) {

		return findByEntityResourceId(entityResourceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the app versions where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching app versions
	 */
	@Override
	public List<AppVersion> findByEntityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<AppVersion> orderByComparator) {

		return findByEntityResourceId(
			entityResourceId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the app versions where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching app versions
	 */
	@Override
	public List<AppVersion> findByEntityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<AppVersion> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByEntityResourceId;
				finderArgs = new Object[] {entityResourceId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByEntityResourceId;
			finderArgs = new Object[] {
				entityResourceId, start, end, orderByComparator
			};
		}

		List<AppVersion> list = null;

		if (useFinderCache) {
			list = (List<AppVersion>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AppVersion appVersion : list) {
					if (entityResourceId != appVersion.getEntityResourceId()) {
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

			sb.append(_SQL_SELECT_APPVERSION_WHERE);

			sb.append(_FINDER_COLUMN_ENTITYRESOURCEID_ENTITYRESOURCEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AppVersionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(entityResourceId);

				list = (List<AppVersion>)QueryUtil.list(
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
	 * Returns the first app version in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app version
	 * @throws NoSuchAppVersionException if a matching app version could not be found
	 */
	@Override
	public AppVersion findByEntityResourceId_First(
			long entityResourceId,
			OrderByComparator<AppVersion> orderByComparator)
		throws NoSuchAppVersionException {

		AppVersion appVersion = fetchByEntityResourceId_First(
			entityResourceId, orderByComparator);

		if (appVersion != null) {
			return appVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("entityResourceId=");
		sb.append(entityResourceId);

		sb.append("}");

		throw new NoSuchAppVersionException(sb.toString());
	}

	/**
	 * Returns the first app version in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app version, or <code>null</code> if a matching app version could not be found
	 */
	@Override
	public AppVersion fetchByEntityResourceId_First(
		long entityResourceId,
		OrderByComparator<AppVersion> orderByComparator) {

		List<AppVersion> list = findByEntityResourceId(
			entityResourceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last app version in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app version
	 * @throws NoSuchAppVersionException if a matching app version could not be found
	 */
	@Override
	public AppVersion findByEntityResourceId_Last(
			long entityResourceId,
			OrderByComparator<AppVersion> orderByComparator)
		throws NoSuchAppVersionException {

		AppVersion appVersion = fetchByEntityResourceId_Last(
			entityResourceId, orderByComparator);

		if (appVersion != null) {
			return appVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("entityResourceId=");
		sb.append(entityResourceId);

		sb.append("}");

		throw new NoSuchAppVersionException(sb.toString());
	}

	/**
	 * Returns the last app version in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app version, or <code>null</code> if a matching app version could not be found
	 */
	@Override
	public AppVersion fetchByEntityResourceId_Last(
		long entityResourceId,
		OrderByComparator<AppVersion> orderByComparator) {

		int count = countByEntityResourceId(entityResourceId);

		if (count == 0) {
			return null;
		}

		List<AppVersion> list = findByEntityResourceId(
			entityResourceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the app versions before and after the current app version in the ordered set where entityResourceId = &#63;.
	 *
	 * @param versionId the primary key of the current app version
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app version
	 * @throws NoSuchAppVersionException if a app version with the primary key could not be found
	 */
	@Override
	public AppVersion[] findByEntityResourceId_PrevAndNext(
			long versionId, long entityResourceId,
			OrderByComparator<AppVersion> orderByComparator)
		throws NoSuchAppVersionException {

		AppVersion appVersion = findByPrimaryKey(versionId);

		Session session = null;

		try {
			session = openSession();

			AppVersion[] array = new AppVersionImpl[3];

			array[0] = getByEntityResourceId_PrevAndNext(
				session, appVersion, entityResourceId, orderByComparator, true);

			array[1] = appVersion;

			array[2] = getByEntityResourceId_PrevAndNext(
				session, appVersion, entityResourceId, orderByComparator,
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

	protected AppVersion getByEntityResourceId_PrevAndNext(
		Session session, AppVersion appVersion, long entityResourceId,
		OrderByComparator<AppVersion> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_APPVERSION_WHERE);

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
			sb.append(AppVersionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(entityResourceId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(appVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AppVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the app versions where entityResourceId = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 */
	@Override
	public void removeByEntityResourceId(long entityResourceId) {
		for (AppVersion appVersion :
				findByEntityResourceId(
					entityResourceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(appVersion);
		}
	}

	/**
	 * Returns the number of app versions where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the number of matching app versions
	 */
	@Override
	public int countByEntityResourceId(long entityResourceId) {
		FinderPath finderPath = _finderPathCountByEntityResourceId;

		Object[] finderArgs = new Object[] {entityResourceId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_APPVERSION_WHERE);

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
			"appVersion.entityResourceId = ?";

	public AppVersionPersistenceImpl() {
		setModelClass(AppVersion.class);

		setModelImplClass(AppVersionImpl.class);
		setModelPKClass(long.class);

		setTable(AppVersionTable.INSTANCE);
	}

	/**
	 * Caches the app version in the entity cache if it is enabled.
	 *
	 * @param appVersion the app version
	 */
	@Override
	public void cacheResult(AppVersion appVersion) {
		dummyEntityCache.putResult(
			AppVersionImpl.class, appVersion.getPrimaryKey(), appVersion);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the app versions in the entity cache if it is enabled.
	 *
	 * @param appVersions the app versions
	 */
	@Override
	public void cacheResult(List<AppVersion> appVersions) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (appVersions.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AppVersion appVersion : appVersions) {
			if (dummyEntityCache.getResult(
					AppVersionImpl.class, appVersion.getPrimaryKey()) == null) {

				cacheResult(appVersion);
			}
		}
	}

	/**
	 * Clears the cache for all app versions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(AppVersionImpl.class);

		dummyFinderCache.clearCache(AppVersionImpl.class);
	}

	/**
	 * Clears the cache for the app version.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AppVersion appVersion) {
		dummyEntityCache.removeResult(AppVersionImpl.class, appVersion);
	}

	@Override
	public void clearCache(List<AppVersion> appVersions) {
		for (AppVersion appVersion : appVersions) {
			dummyEntityCache.removeResult(AppVersionImpl.class, appVersion);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(AppVersionImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(AppVersionImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new app version with the primary key. Does not add the app version to the database.
	 *
	 * @param versionId the primary key for the new app version
	 * @return the new app version
	 */
	@Override
	public AppVersion create(long versionId) {
		AppVersion appVersion = new AppVersionImpl();

		appVersion.setNew(true);
		appVersion.setPrimaryKey(versionId);

		appVersion.setCompanyId(CompanyThreadLocal.getCompanyId());

		return appVersion;
	}

	/**
	 * Removes the app version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param versionId the primary key of the app version
	 * @return the app version that was removed
	 * @throws NoSuchAppVersionException if a app version with the primary key could not be found
	 */
	@Override
	public AppVersion remove(long versionId) throws NoSuchAppVersionException {
		return remove((Serializable)versionId);
	}

	/**
	 * Removes the app version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the app version
	 * @return the app version that was removed
	 * @throws NoSuchAppVersionException if a app version with the primary key could not be found
	 */
	@Override
	public AppVersion remove(Serializable primaryKey)
		throws NoSuchAppVersionException {

		Session session = null;

		try {
			session = openSession();

			AppVersion appVersion = (AppVersion)session.get(
				AppVersionImpl.class, primaryKey);

			if (appVersion == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAppVersionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(appVersion);
		}
		catch (NoSuchAppVersionException noSuchEntityException) {
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
	protected AppVersion removeImpl(AppVersion appVersion) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(appVersion)) {
				appVersion = (AppVersion)session.get(
					AppVersionImpl.class, appVersion.getPrimaryKeyObj());
			}

			if (appVersion != null) {
				session.delete(appVersion);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (appVersion != null) {
			clearCache(appVersion);
		}

		return appVersion;
	}

	@Override
	public AppVersion updateImpl(AppVersion appVersion) {
		boolean isNew = appVersion.isNew();

		if (!(appVersion instanceof AppVersionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(appVersion.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(appVersion);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in appVersion proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AppVersion implementation " +
					appVersion.getClass());
		}

		AppVersionModelImpl appVersionModelImpl =
			(AppVersionModelImpl)appVersion;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (appVersion.getCreateDate() == null)) {
			if (serviceContext == null) {
				appVersion.setCreateDate(date);
			}
			else {
				appVersion.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!appVersionModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				appVersion.setModifiedDate(date);
			}
			else {
				appVersion.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(appVersion);
			}
			else {
				appVersion = (AppVersion)session.merge(appVersion);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			AppVersionImpl.class, appVersionModelImpl, false, true);

		if (isNew) {
			appVersion.setNew(false);
		}

		appVersion.resetOriginalValues();

		return appVersion;
	}

	/**
	 * Returns the app version with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the app version
	 * @return the app version
	 * @throws NoSuchAppVersionException if a app version with the primary key could not be found
	 */
	@Override
	public AppVersion findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAppVersionException {

		AppVersion appVersion = fetchByPrimaryKey(primaryKey);

		if (appVersion == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAppVersionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return appVersion;
	}

	/**
	 * Returns the app version with the primary key or throws a <code>NoSuchAppVersionException</code> if it could not be found.
	 *
	 * @param versionId the primary key of the app version
	 * @return the app version
	 * @throws NoSuchAppVersionException if a app version with the primary key could not be found
	 */
	@Override
	public AppVersion findByPrimaryKey(long versionId)
		throws NoSuchAppVersionException {

		return findByPrimaryKey((Serializable)versionId);
	}

	/**
	 * Returns the app version with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param versionId the primary key of the app version
	 * @return the app version, or <code>null</code> if a app version with the primary key could not be found
	 */
	@Override
	public AppVersion fetchByPrimaryKey(long versionId) {
		return fetchByPrimaryKey((Serializable)versionId);
	}

	/**
	 * Returns all the app versions.
	 *
	 * @return the app versions
	 */
	@Override
	public List<AppVersion> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the app versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @return the range of app versions
	 */
	@Override
	public List<AppVersion> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the app versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of app versions
	 */
	@Override
	public List<AppVersion> findAll(
		int start, int end, OrderByComparator<AppVersion> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the app versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of app versions
	 */
	@Override
	public List<AppVersion> findAll(
		int start, int end, OrderByComparator<AppVersion> orderByComparator,
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

		List<AppVersion> list = null;

		if (useFinderCache) {
			list = (List<AppVersion>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_APPVERSION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_APPVERSION;

				sql = sql.concat(AppVersionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AppVersion>)QueryUtil.list(
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
	 * Removes all the app versions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AppVersion appVersion : findAll()) {
			remove(appVersion);
		}
	}

	/**
	 * Returns the number of app versions.
	 *
	 * @return the number of app versions
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_APPVERSION);

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
		return "versionId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_APPVERSION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AppVersionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the app version persistence.
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

		_finderPathWithPaginationFindByPlatform = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPlatform",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"platform", "channelId"}, true);

		_finderPathWithoutPaginationFindByPlatform = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPlatform",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"platform", "channelId"}, true);

		_finderPathCountByPlatform = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPlatform",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"platform", "channelId"}, false);

		_finderPathWithPaginationFindByWorkflowStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByWorkflowStatus",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"status"}, true);

		_finderPathWithoutPaginationFindByWorkflowStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByWorkflowStatus",
			new String[] {Integer.class.getName()}, new String[] {"status"},
			true);

		_finderPathCountByWorkflowStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByWorkflowStatus",
			new String[] {Integer.class.getName()}, new String[] {"status"},
			false);

		_finderPathWithPaginationFindByEntityResourceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEntityResourceId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"entityResourceId"}, true);

		_finderPathWithoutPaginationFindByEntityResourceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEntityResourceId",
			new String[] {Long.class.getName()},
			new String[] {"entityResourceId"}, true);

		_finderPathCountByEntityResourceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEntityResourceId", new String[] {Long.class.getName()},
			new String[] {"entityResourceId"}, false);

		AppVersionUtil.setPersistence(this);
	}

	public void destroy() {
		AppVersionUtil.setPersistence(null);

		dummyEntityCache.removeCache(AppVersionImpl.class.getName());
	}

	private static final String _SQL_SELECT_APPVERSION =
		"SELECT appVersion FROM AppVersion appVersion";

	private static final String _SQL_SELECT_APPVERSION_WHERE =
		"SELECT appVersion FROM AppVersion appVersion WHERE ";

	private static final String _SQL_COUNT_APPVERSION =
		"SELECT COUNT(appVersion) FROM AppVersion appVersion";

	private static final String _SQL_COUNT_APPVERSION_WHERE =
		"SELECT COUNT(appVersion) FROM AppVersion appVersion WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "appVersion.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AppVersion exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AppVersion exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AppVersionPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}