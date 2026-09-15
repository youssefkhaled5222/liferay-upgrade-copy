/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence.impl;

import com.ejada.telemony.db.exception.NoSuchBannerException;
import com.ejada.telemony.db.model.Banner;
import com.ejada.telemony.db.model.BannerTable;
import com.ejada.telemony.db.model.impl.BannerImpl;
import com.ejada.telemony.db.model.impl.BannerModelImpl;
import com.ejada.telemony.db.service.persistence.BannerPersistence;
import com.ejada.telemony.db.service.persistence.BannerUtil;

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
 * The persistence implementation for the banner service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BannerPersistenceImpl
	extends BasePersistenceImpl<Banner> implements BannerPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BannerUtil</code> to access the banner persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BannerImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByChannelIdAndStatus;
	private FinderPath _finderPathWithoutPaginationFindByChannelIdAndStatus;
	private FinderPath _finderPathCountByChannelIdAndStatus;

	/**
	 * Returns all the banners where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @return the matching banners
	 */
	@Override
	public List<Banner> findByChannelIdAndStatus(long channelId, int status) {
		return findByChannelIdAndStatus(
			channelId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the banners where channelId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param start the lower bound of the range of banners
	 * @param end the upper bound of the range of banners (not inclusive)
	 * @return the range of matching banners
	 */
	@Override
	public List<Banner> findByChannelIdAndStatus(
		long channelId, int status, int start, int end) {

		return findByChannelIdAndStatus(channelId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the banners where channelId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param start the lower bound of the range of banners
	 * @param end the upper bound of the range of banners (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching banners
	 */
	@Override
	public List<Banner> findByChannelIdAndStatus(
		long channelId, int status, int start, int end,
		OrderByComparator<Banner> orderByComparator) {

		return findByChannelIdAndStatus(
			channelId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the banners where channelId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param start the lower bound of the range of banners
	 * @param end the upper bound of the range of banners (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching banners
	 */
	@Override
	public List<Banner> findByChannelIdAndStatus(
		long channelId, int status, int start, int end,
		OrderByComparator<Banner> orderByComparator, boolean useFinderCache) {

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

		List<Banner> list = null;

		if (useFinderCache) {
			list = (List<Banner>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Banner banner : list) {
					if ((channelId != banner.getChannelId()) ||
						(status != banner.getStatus())) {

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

			sb.append(_SQL_SELECT_BANNER_WHERE);

			sb.append(_FINDER_COLUMN_CHANNELIDANDSTATUS_CHANNELID_2);

			sb.append(_FINDER_COLUMN_CHANNELIDANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BannerModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				queryPos.add(status);

				list = (List<Banner>)QueryUtil.list(
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
	 * Returns the first banner in the ordered set where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner
	 * @throws NoSuchBannerException if a matching banner could not be found
	 */
	@Override
	public Banner findByChannelIdAndStatus_First(
			long channelId, int status,
			OrderByComparator<Banner> orderByComparator)
		throws NoSuchBannerException {

		Banner banner = fetchByChannelIdAndStatus_First(
			channelId, status, orderByComparator);

		if (banner != null) {
			return banner;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchBannerException(sb.toString());
	}

	/**
	 * Returns the first banner in the ordered set where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner, or <code>null</code> if a matching banner could not be found
	 */
	@Override
	public Banner fetchByChannelIdAndStatus_First(
		long channelId, int status,
		OrderByComparator<Banner> orderByComparator) {

		List<Banner> list = findByChannelIdAndStatus(
			channelId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last banner in the ordered set where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner
	 * @throws NoSuchBannerException if a matching banner could not be found
	 */
	@Override
	public Banner findByChannelIdAndStatus_Last(
			long channelId, int status,
			OrderByComparator<Banner> orderByComparator)
		throws NoSuchBannerException {

		Banner banner = fetchByChannelIdAndStatus_Last(
			channelId, status, orderByComparator);

		if (banner != null) {
			return banner;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchBannerException(sb.toString());
	}

	/**
	 * Returns the last banner in the ordered set where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner, or <code>null</code> if a matching banner could not be found
	 */
	@Override
	public Banner fetchByChannelIdAndStatus_Last(
		long channelId, int status,
		OrderByComparator<Banner> orderByComparator) {

		int count = countByChannelIdAndStatus(channelId, status);

		if (count == 0) {
			return null;
		}

		List<Banner> list = findByChannelIdAndStatus(
			channelId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the banners before and after the current banner in the ordered set where channelId = &#63; and status = &#63;.
	 *
	 * @param bannerId the primary key of the current banner
	 * @param channelId the channel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next banner
	 * @throws NoSuchBannerException if a banner with the primary key could not be found
	 */
	@Override
	public Banner[] findByChannelIdAndStatus_PrevAndNext(
			long bannerId, long channelId, int status,
			OrderByComparator<Banner> orderByComparator)
		throws NoSuchBannerException {

		Banner banner = findByPrimaryKey(bannerId);

		Session session = null;

		try {
			session = openSession();

			Banner[] array = new BannerImpl[3];

			array[0] = getByChannelIdAndStatus_PrevAndNext(
				session, banner, channelId, status, orderByComparator, true);

			array[1] = banner;

			array[2] = getByChannelIdAndStatus_PrevAndNext(
				session, banner, channelId, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Banner getByChannelIdAndStatus_PrevAndNext(
		Session session, Banner banner, long channelId, int status,
		OrderByComparator<Banner> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_BANNER_WHERE);

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
			sb.append(BannerModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(banner)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Banner> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the banners where channelId = &#63; and status = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 */
	@Override
	public void removeByChannelIdAndStatus(long channelId, int status) {
		for (Banner banner :
				findByChannelIdAndStatus(
					channelId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(banner);
		}
	}

	/**
	 * Returns the number of banners where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @return the number of matching banners
	 */
	@Override
	public int countByChannelIdAndStatus(long channelId, int status) {
		FinderPath finderPath = _finderPathCountByChannelIdAndStatus;

		Object[] finderArgs = new Object[] {channelId, status};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_BANNER_WHERE);

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
		"banner.channelId = ? AND ";

	private static final String _FINDER_COLUMN_CHANNELIDANDSTATUS_STATUS_2 =
		"banner.status = ?";

	private FinderPath _finderPathWithPaginationFindByEntityResourceId;
	private FinderPath _finderPathWithoutPaginationFindByEntityResourceId;
	private FinderPath _finderPathCountByEntityResourceId;

	/**
	 * Returns all the banners where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the matching banners
	 */
	@Override
	public List<Banner> findByEntityResourceId(long entityResourceId) {
		return findByEntityResourceId(
			entityResourceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the banners where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of banners
	 * @param end the upper bound of the range of banners (not inclusive)
	 * @return the range of matching banners
	 */
	@Override
	public List<Banner> findByEntityResourceId(
		long entityResourceId, int start, int end) {

		return findByEntityResourceId(entityResourceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the banners where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of banners
	 * @param end the upper bound of the range of banners (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching banners
	 */
	@Override
	public List<Banner> findByEntityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<Banner> orderByComparator) {

		return findByEntityResourceId(
			entityResourceId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the banners where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of banners
	 * @param end the upper bound of the range of banners (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching banners
	 */
	@Override
	public List<Banner> findByEntityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<Banner> orderByComparator, boolean useFinderCache) {

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

		List<Banner> list = null;

		if (useFinderCache) {
			list = (List<Banner>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Banner banner : list) {
					if (entityResourceId != banner.getEntityResourceId()) {
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

			sb.append(_SQL_SELECT_BANNER_WHERE);

			sb.append(_FINDER_COLUMN_ENTITYRESOURCEID_ENTITYRESOURCEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BannerModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(entityResourceId);

				list = (List<Banner>)QueryUtil.list(
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
	 * Returns the first banner in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner
	 * @throws NoSuchBannerException if a matching banner could not be found
	 */
	@Override
	public Banner findByEntityResourceId_First(
			long entityResourceId, OrderByComparator<Banner> orderByComparator)
		throws NoSuchBannerException {

		Banner banner = fetchByEntityResourceId_First(
			entityResourceId, orderByComparator);

		if (banner != null) {
			return banner;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("entityResourceId=");
		sb.append(entityResourceId);

		sb.append("}");

		throw new NoSuchBannerException(sb.toString());
	}

	/**
	 * Returns the first banner in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner, or <code>null</code> if a matching banner could not be found
	 */
	@Override
	public Banner fetchByEntityResourceId_First(
		long entityResourceId, OrderByComparator<Banner> orderByComparator) {

		List<Banner> list = findByEntityResourceId(
			entityResourceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last banner in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner
	 * @throws NoSuchBannerException if a matching banner could not be found
	 */
	@Override
	public Banner findByEntityResourceId_Last(
			long entityResourceId, OrderByComparator<Banner> orderByComparator)
		throws NoSuchBannerException {

		Banner banner = fetchByEntityResourceId_Last(
			entityResourceId, orderByComparator);

		if (banner != null) {
			return banner;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("entityResourceId=");
		sb.append(entityResourceId);

		sb.append("}");

		throw new NoSuchBannerException(sb.toString());
	}

	/**
	 * Returns the last banner in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner, or <code>null</code> if a matching banner could not be found
	 */
	@Override
	public Banner fetchByEntityResourceId_Last(
		long entityResourceId, OrderByComparator<Banner> orderByComparator) {

		int count = countByEntityResourceId(entityResourceId);

		if (count == 0) {
			return null;
		}

		List<Banner> list = findByEntityResourceId(
			entityResourceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the banners before and after the current banner in the ordered set where entityResourceId = &#63;.
	 *
	 * @param bannerId the primary key of the current banner
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next banner
	 * @throws NoSuchBannerException if a banner with the primary key could not be found
	 */
	@Override
	public Banner[] findByEntityResourceId_PrevAndNext(
			long bannerId, long entityResourceId,
			OrderByComparator<Banner> orderByComparator)
		throws NoSuchBannerException {

		Banner banner = findByPrimaryKey(bannerId);

		Session session = null;

		try {
			session = openSession();

			Banner[] array = new BannerImpl[3];

			array[0] = getByEntityResourceId_PrevAndNext(
				session, banner, entityResourceId, orderByComparator, true);

			array[1] = banner;

			array[2] = getByEntityResourceId_PrevAndNext(
				session, banner, entityResourceId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Banner getByEntityResourceId_PrevAndNext(
		Session session, Banner banner, long entityResourceId,
		OrderByComparator<Banner> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BANNER_WHERE);

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
			sb.append(BannerModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(entityResourceId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(banner)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Banner> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the banners where entityResourceId = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 */
	@Override
	public void removeByEntityResourceId(long entityResourceId) {
		for (Banner banner :
				findByEntityResourceId(
					entityResourceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(banner);
		}
	}

	/**
	 * Returns the number of banners where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the number of matching banners
	 */
	@Override
	public int countByEntityResourceId(long entityResourceId) {
		FinderPath finderPath = _finderPathCountByEntityResourceId;

		Object[] finderArgs = new Object[] {entityResourceId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BANNER_WHERE);

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
			"banner.entityResourceId = ?";

	public BannerPersistenceImpl() {
		setModelClass(Banner.class);

		setModelImplClass(BannerImpl.class);
		setModelPKClass(long.class);

		setTable(BannerTable.INSTANCE);
	}

	/**
	 * Caches the banner in the entity cache if it is enabled.
	 *
	 * @param banner the banner
	 */
	@Override
	public void cacheResult(Banner banner) {
		dummyEntityCache.putResult(
			BannerImpl.class, banner.getPrimaryKey(), banner);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the banners in the entity cache if it is enabled.
	 *
	 * @param banners the banners
	 */
	@Override
	public void cacheResult(List<Banner> banners) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (banners.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Banner banner : banners) {
			if (dummyEntityCache.getResult(
					BannerImpl.class, banner.getPrimaryKey()) == null) {

				cacheResult(banner);
			}
		}
	}

	/**
	 * Clears the cache for all banners.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(BannerImpl.class);

		dummyFinderCache.clearCache(BannerImpl.class);
	}

	/**
	 * Clears the cache for the banner.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Banner banner) {
		dummyEntityCache.removeResult(BannerImpl.class, banner);
	}

	@Override
	public void clearCache(List<Banner> banners) {
		for (Banner banner : banners) {
			dummyEntityCache.removeResult(BannerImpl.class, banner);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(BannerImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(BannerImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new banner with the primary key. Does not add the banner to the database.
	 *
	 * @param bannerId the primary key for the new banner
	 * @return the new banner
	 */
	@Override
	public Banner create(long bannerId) {
		Banner banner = new BannerImpl();

		banner.setNew(true);
		banner.setPrimaryKey(bannerId);

		banner.setCompanyId(CompanyThreadLocal.getCompanyId());

		return banner;
	}

	/**
	 * Removes the banner with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bannerId the primary key of the banner
	 * @return the banner that was removed
	 * @throws NoSuchBannerException if a banner with the primary key could not be found
	 */
	@Override
	public Banner remove(long bannerId) throws NoSuchBannerException {
		return remove((Serializable)bannerId);
	}

	/**
	 * Removes the banner with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the banner
	 * @return the banner that was removed
	 * @throws NoSuchBannerException if a banner with the primary key could not be found
	 */
	@Override
	public Banner remove(Serializable primaryKey) throws NoSuchBannerException {
		Session session = null;

		try {
			session = openSession();

			Banner banner = (Banner)session.get(BannerImpl.class, primaryKey);

			if (banner == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBannerException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(banner);
		}
		catch (NoSuchBannerException noSuchEntityException) {
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
	protected Banner removeImpl(Banner banner) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(banner)) {
				banner = (Banner)session.get(
					BannerImpl.class, banner.getPrimaryKeyObj());
			}

			if (banner != null) {
				session.delete(banner);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (banner != null) {
			clearCache(banner);
		}

		return banner;
	}

	@Override
	public Banner updateImpl(Banner banner) {
		boolean isNew = banner.isNew();

		if (!(banner instanceof BannerModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(banner.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(banner);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in banner proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Banner implementation " +
					banner.getClass());
		}

		BannerModelImpl bannerModelImpl = (BannerModelImpl)banner;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (banner.getCreateDate() == null)) {
			if (serviceContext == null) {
				banner.setCreateDate(date);
			}
			else {
				banner.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!bannerModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				banner.setModifiedDate(date);
			}
			else {
				banner.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(banner);
			}
			else {
				banner = (Banner)session.merge(banner);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			BannerImpl.class, bannerModelImpl, false, true);

		if (isNew) {
			banner.setNew(false);
		}

		banner.resetOriginalValues();

		return banner;
	}

	/**
	 * Returns the banner with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the banner
	 * @return the banner
	 * @throws NoSuchBannerException if a banner with the primary key could not be found
	 */
	@Override
	public Banner findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBannerException {

		Banner banner = fetchByPrimaryKey(primaryKey);

		if (banner == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBannerException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return banner;
	}

	/**
	 * Returns the banner with the primary key or throws a <code>NoSuchBannerException</code> if it could not be found.
	 *
	 * @param bannerId the primary key of the banner
	 * @return the banner
	 * @throws NoSuchBannerException if a banner with the primary key could not be found
	 */
	@Override
	public Banner findByPrimaryKey(long bannerId) throws NoSuchBannerException {
		return findByPrimaryKey((Serializable)bannerId);
	}

	/**
	 * Returns the banner with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bannerId the primary key of the banner
	 * @return the banner, or <code>null</code> if a banner with the primary key could not be found
	 */
	@Override
	public Banner fetchByPrimaryKey(long bannerId) {
		return fetchByPrimaryKey((Serializable)bannerId);
	}

	/**
	 * Returns all the banners.
	 *
	 * @return the banners
	 */
	@Override
	public List<Banner> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the banners.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of banners
	 * @param end the upper bound of the range of banners (not inclusive)
	 * @return the range of banners
	 */
	@Override
	public List<Banner> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the banners.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of banners
	 * @param end the upper bound of the range of banners (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of banners
	 */
	@Override
	public List<Banner> findAll(
		int start, int end, OrderByComparator<Banner> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the banners.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of banners
	 * @param end the upper bound of the range of banners (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of banners
	 */
	@Override
	public List<Banner> findAll(
		int start, int end, OrderByComparator<Banner> orderByComparator,
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

		List<Banner> list = null;

		if (useFinderCache) {
			list = (List<Banner>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BANNER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BANNER;

				sql = sql.concat(BannerModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Banner>)QueryUtil.list(
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
	 * Removes all the banners from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Banner banner : findAll()) {
			remove(banner);
		}
	}

	/**
	 * Returns the number of banners.
	 *
	 * @return the number of banners
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_BANNER);

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
		return "bannerId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_BANNER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BannerModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the banner persistence.
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

		BannerUtil.setPersistence(this);
	}

	public void destroy() {
		BannerUtil.setPersistence(null);

		dummyEntityCache.removeCache(BannerImpl.class.getName());
	}

	private static final String _SQL_SELECT_BANNER =
		"SELECT banner FROM Banner banner";

	private static final String _SQL_SELECT_BANNER_WHERE =
		"SELECT banner FROM Banner banner WHERE ";

	private static final String _SQL_COUNT_BANNER =
		"SELECT COUNT(banner) FROM Banner banner";

	private static final String _SQL_COUNT_BANNER_WHERE =
		"SELECT COUNT(banner) FROM Banner banner WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "banner.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Banner exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Banner exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BannerPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}