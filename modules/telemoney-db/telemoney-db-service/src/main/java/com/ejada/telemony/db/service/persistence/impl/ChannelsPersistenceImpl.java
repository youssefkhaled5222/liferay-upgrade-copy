/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence.impl;

import com.ejada.telemony.db.exception.NoSuchChannelsException;
import com.ejada.telemony.db.model.Channels;
import com.ejada.telemony.db.model.ChannelsTable;
import com.ejada.telemony.db.model.impl.ChannelsImpl;
import com.ejada.telemony.db.model.impl.ChannelsModelImpl;
import com.ejada.telemony.db.service.persistence.ChannelsPersistence;
import com.ejada.telemony.db.service.persistence.ChannelsUtil;

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
 * The persistence implementation for the channels service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ChannelsPersistenceImpl
	extends BasePersistenceImpl<Channels> implements ChannelsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ChannelsUtil</code> to access the channels persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ChannelsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByName;
	private FinderPath _finderPathWithoutPaginationFindByName;
	private FinderPath _finderPathCountByName;

	/**
	 * Returns all the channelses where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching channelses
	 */
	@Override
	public List<Channels> findByName(String name) {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the channelses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChannelsModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of channelses
	 * @param end the upper bound of the range of channelses (not inclusive)
	 * @return the range of matching channelses
	 */
	@Override
	public List<Channels> findByName(String name, int start, int end) {
		return findByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the channelses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChannelsModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of channelses
	 * @param end the upper bound of the range of channelses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching channelses
	 */
	@Override
	public List<Channels> findByName(
		String name, int start, int end,
		OrderByComparator<Channels> orderByComparator) {

		return findByName(name, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the channelses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChannelsModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of channelses
	 * @param end the upper bound of the range of channelses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching channelses
	 */
	@Override
	public List<Channels> findByName(
		String name, int start, int end,
		OrderByComparator<Channels> orderByComparator, boolean useFinderCache) {

		name = Objects.toString(name, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByName;
				finderArgs = new Object[] {name};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByName;
			finderArgs = new Object[] {name, start, end, orderByComparator};
		}

		List<Channels> list = null;

		if (useFinderCache) {
			list = (List<Channels>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Channels channels : list) {
					if (!name.equals(channels.getName())) {
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

			sb.append(_SQL_SELECT_CHANNELS_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ChannelsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				list = (List<Channels>)QueryUtil.list(
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
	 * Returns the first channels in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channels
	 * @throws NoSuchChannelsException if a matching channels could not be found
	 */
	@Override
	public Channels findByName_First(
			String name, OrderByComparator<Channels> orderByComparator)
		throws NoSuchChannelsException {

		Channels channels = fetchByName_First(name, orderByComparator);

		if (channels != null) {
			return channels;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchChannelsException(sb.toString());
	}

	/**
	 * Returns the first channels in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channels, or <code>null</code> if a matching channels could not be found
	 */
	@Override
	public Channels fetchByName_First(
		String name, OrderByComparator<Channels> orderByComparator) {

		List<Channels> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last channels in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channels
	 * @throws NoSuchChannelsException if a matching channels could not be found
	 */
	@Override
	public Channels findByName_Last(
			String name, OrderByComparator<Channels> orderByComparator)
		throws NoSuchChannelsException {

		Channels channels = fetchByName_Last(name, orderByComparator);

		if (channels != null) {
			return channels;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchChannelsException(sb.toString());
	}

	/**
	 * Returns the last channels in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channels, or <code>null</code> if a matching channels could not be found
	 */
	@Override
	public Channels fetchByName_Last(
		String name, OrderByComparator<Channels> orderByComparator) {

		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<Channels> list = findByName(
			name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the channelses before and after the current channels in the ordered set where name = &#63;.
	 *
	 * @param channelId the primary key of the current channels
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next channels
	 * @throws NoSuchChannelsException if a channels with the primary key could not be found
	 */
	@Override
	public Channels[] findByName_PrevAndNext(
			long channelId, String name,
			OrderByComparator<Channels> orderByComparator)
		throws NoSuchChannelsException {

		name = Objects.toString(name, "");

		Channels channels = findByPrimaryKey(channelId);

		Session session = null;

		try {
			session = openSession();

			Channels[] array = new ChannelsImpl[3];

			array[0] = getByName_PrevAndNext(
				session, channels, name, orderByComparator, true);

			array[1] = channels;

			array[2] = getByName_PrevAndNext(
				session, channels, name, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Channels getByName_PrevAndNext(
		Session session, Channels channels, String name,
		OrderByComparator<Channels> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CHANNELS_WHERE);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_NAME_NAME_2);
		}

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
			sb.append(ChannelsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindName) {
			queryPos.add(name);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(channels)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Channels> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the channelses where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	@Override
	public void removeByName(String name) {
		for (Channels channels :
				findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(channels);
		}
	}

	/**
	 * Returns the number of channelses where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching channelses
	 */
	@Override
	public int countByName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CHANNELS_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

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

	private static final String _FINDER_COLUMN_NAME_NAME_2 =
		"channels.name = ?";

	private static final String _FINDER_COLUMN_NAME_NAME_3 =
		"(channels.name IS NULL OR channels.name = '')";

	private FinderPath _finderPathWithPaginationFindByNameAndStatus;
	private FinderPath _finderPathWithPaginationCountByNameAndStatus;

	/**
	 * Returns all the channelses where name = &#63; and status &ne; &#63;.
	 *
	 * @param name the name
	 * @param status the status
	 * @return the matching channelses
	 */
	@Override
	public List<Channels> findByNameAndStatus(String name, int status) {
		return findByNameAndStatus(
			name, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the channelses where name = &#63; and status &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChannelsModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param status the status
	 * @param start the lower bound of the range of channelses
	 * @param end the upper bound of the range of channelses (not inclusive)
	 * @return the range of matching channelses
	 */
	@Override
	public List<Channels> findByNameAndStatus(
		String name, int status, int start, int end) {

		return findByNameAndStatus(name, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the channelses where name = &#63; and status &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChannelsModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param status the status
	 * @param start the lower bound of the range of channelses
	 * @param end the upper bound of the range of channelses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching channelses
	 */
	@Override
	public List<Channels> findByNameAndStatus(
		String name, int status, int start, int end,
		OrderByComparator<Channels> orderByComparator) {

		return findByNameAndStatus(
			name, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the channelses where name = &#63; and status &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChannelsModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param status the status
	 * @param start the lower bound of the range of channelses
	 * @param end the upper bound of the range of channelses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching channelses
	 */
	@Override
	public List<Channels> findByNameAndStatus(
		String name, int status, int start, int end,
		OrderByComparator<Channels> orderByComparator, boolean useFinderCache) {

		name = Objects.toString(name, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByNameAndStatus;
		finderArgs = new Object[] {name, status, start, end, orderByComparator};

		List<Channels> list = null;

		if (useFinderCache) {
			list = (List<Channels>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Channels channels : list) {
					if (!name.equals(channels.getName()) ||
						(status == channels.getStatus())) {

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

			sb.append(_SQL_SELECT_CHANNELS_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAMEANDSTATUS_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAMEANDSTATUS_NAME_2);
			}

			sb.append(_FINDER_COLUMN_NAMEANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ChannelsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				queryPos.add(status);

				list = (List<Channels>)QueryUtil.list(
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
	 * Returns the first channels in the ordered set where name = &#63; and status &ne; &#63;.
	 *
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channels
	 * @throws NoSuchChannelsException if a matching channels could not be found
	 */
	@Override
	public Channels findByNameAndStatus_First(
			String name, int status,
			OrderByComparator<Channels> orderByComparator)
		throws NoSuchChannelsException {

		Channels channels = fetchByNameAndStatus_First(
			name, status, orderByComparator);

		if (channels != null) {
			return channels;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append(", status!=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchChannelsException(sb.toString());
	}

	/**
	 * Returns the first channels in the ordered set where name = &#63; and status &ne; &#63;.
	 *
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channels, or <code>null</code> if a matching channels could not be found
	 */
	@Override
	public Channels fetchByNameAndStatus_First(
		String name, int status,
		OrderByComparator<Channels> orderByComparator) {

		List<Channels> list = findByNameAndStatus(
			name, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last channels in the ordered set where name = &#63; and status &ne; &#63;.
	 *
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channels
	 * @throws NoSuchChannelsException if a matching channels could not be found
	 */
	@Override
	public Channels findByNameAndStatus_Last(
			String name, int status,
			OrderByComparator<Channels> orderByComparator)
		throws NoSuchChannelsException {

		Channels channels = fetchByNameAndStatus_Last(
			name, status, orderByComparator);

		if (channels != null) {
			return channels;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append(", status!=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchChannelsException(sb.toString());
	}

	/**
	 * Returns the last channels in the ordered set where name = &#63; and status &ne; &#63;.
	 *
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channels, or <code>null</code> if a matching channels could not be found
	 */
	@Override
	public Channels fetchByNameAndStatus_Last(
		String name, int status,
		OrderByComparator<Channels> orderByComparator) {

		int count = countByNameAndStatus(name, status);

		if (count == 0) {
			return null;
		}

		List<Channels> list = findByNameAndStatus(
			name, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the channelses before and after the current channels in the ordered set where name = &#63; and status &ne; &#63;.
	 *
	 * @param channelId the primary key of the current channels
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next channels
	 * @throws NoSuchChannelsException if a channels with the primary key could not be found
	 */
	@Override
	public Channels[] findByNameAndStatus_PrevAndNext(
			long channelId, String name, int status,
			OrderByComparator<Channels> orderByComparator)
		throws NoSuchChannelsException {

		name = Objects.toString(name, "");

		Channels channels = findByPrimaryKey(channelId);

		Session session = null;

		try {
			session = openSession();

			Channels[] array = new ChannelsImpl[3];

			array[0] = getByNameAndStatus_PrevAndNext(
				session, channels, name, status, orderByComparator, true);

			array[1] = channels;

			array[2] = getByNameAndStatus_PrevAndNext(
				session, channels, name, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Channels getByNameAndStatus_PrevAndNext(
		Session session, Channels channels, String name, int status,
		OrderByComparator<Channels> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CHANNELS_WHERE);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_NAMEANDSTATUS_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_NAMEANDSTATUS_NAME_2);
		}

		sb.append(_FINDER_COLUMN_NAMEANDSTATUS_STATUS_2);

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
			sb.append(ChannelsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindName) {
			queryPos.add(name);
		}

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(channels)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Channels> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the channelses where name = &#63; and status &ne; &#63; from the database.
	 *
	 * @param name the name
	 * @param status the status
	 */
	@Override
	public void removeByNameAndStatus(String name, int status) {
		for (Channels channels :
				findByNameAndStatus(
					name, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(channels);
		}
	}

	/**
	 * Returns the number of channelses where name = &#63; and status &ne; &#63;.
	 *
	 * @param name the name
	 * @param status the status
	 * @return the number of matching channelses
	 */
	@Override
	public int countByNameAndStatus(String name, int status) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathWithPaginationCountByNameAndStatus;

		Object[] finderArgs = new Object[] {name, status};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CHANNELS_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAMEANDSTATUS_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAMEANDSTATUS_NAME_2);
			}

			sb.append(_FINDER_COLUMN_NAMEANDSTATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

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

	private static final String _FINDER_COLUMN_NAMEANDSTATUS_NAME_2 =
		"channels.name = ? AND ";

	private static final String _FINDER_COLUMN_NAMEANDSTATUS_NAME_3 =
		"(channels.name IS NULL OR channels.name = '') AND ";

	private static final String _FINDER_COLUMN_NAMEANDSTATUS_STATUS_2 =
		"channels.status != ?";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the channelses where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching channelses
	 */
	@Override
	public List<Channels> findByStatus(int status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the channelses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChannelsModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of channelses
	 * @param end the upper bound of the range of channelses (not inclusive)
	 * @return the range of matching channelses
	 */
	@Override
	public List<Channels> findByStatus(int status, int start, int end) {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the channelses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChannelsModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of channelses
	 * @param end the upper bound of the range of channelses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching channelses
	 */
	@Override
	public List<Channels> findByStatus(
		int status, int start, int end,
		OrderByComparator<Channels> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the channelses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChannelsModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of channelses
	 * @param end the upper bound of the range of channelses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching channelses
	 */
	@Override
	public List<Channels> findByStatus(
		int status, int start, int end,
		OrderByComparator<Channels> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStatus;
				finderArgs = new Object[] {status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatus;
			finderArgs = new Object[] {status, start, end, orderByComparator};
		}

		List<Channels> list = null;

		if (useFinderCache) {
			list = (List<Channels>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Channels channels : list) {
					if (status != channels.getStatus()) {
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

			sb.append(_SQL_SELECT_CHANNELS_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ChannelsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				list = (List<Channels>)QueryUtil.list(
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
	 * Returns the first channels in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channels
	 * @throws NoSuchChannelsException if a matching channels could not be found
	 */
	@Override
	public Channels findByStatus_First(
			int status, OrderByComparator<Channels> orderByComparator)
		throws NoSuchChannelsException {

		Channels channels = fetchByStatus_First(status, orderByComparator);

		if (channels != null) {
			return channels;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchChannelsException(sb.toString());
	}

	/**
	 * Returns the first channels in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channels, or <code>null</code> if a matching channels could not be found
	 */
	@Override
	public Channels fetchByStatus_First(
		int status, OrderByComparator<Channels> orderByComparator) {

		List<Channels> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last channels in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channels
	 * @throws NoSuchChannelsException if a matching channels could not be found
	 */
	@Override
	public Channels findByStatus_Last(
			int status, OrderByComparator<Channels> orderByComparator)
		throws NoSuchChannelsException {

		Channels channels = fetchByStatus_Last(status, orderByComparator);

		if (channels != null) {
			return channels;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchChannelsException(sb.toString());
	}

	/**
	 * Returns the last channels in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channels, or <code>null</code> if a matching channels could not be found
	 */
	@Override
	public Channels fetchByStatus_Last(
		int status, OrderByComparator<Channels> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<Channels> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the channelses before and after the current channels in the ordered set where status = &#63;.
	 *
	 * @param channelId the primary key of the current channels
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next channels
	 * @throws NoSuchChannelsException if a channels with the primary key could not be found
	 */
	@Override
	public Channels[] findByStatus_PrevAndNext(
			long channelId, int status,
			OrderByComparator<Channels> orderByComparator)
		throws NoSuchChannelsException {

		Channels channels = findByPrimaryKey(channelId);

		Session session = null;

		try {
			session = openSession();

			Channels[] array = new ChannelsImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, channels, status, orderByComparator, true);

			array[1] = channels;

			array[2] = getByStatus_PrevAndNext(
				session, channels, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Channels getByStatus_PrevAndNext(
		Session session, Channels channels, int status,
		OrderByComparator<Channels> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CHANNELS_WHERE);

		sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			sb.append(ChannelsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(channels)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Channels> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the channelses where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(int status) {
		for (Channels channels :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(channels);
		}
	}

	/**
	 * Returns the number of channelses where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching channelses
	 */
	@Override
	public int countByStatus(int status) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CHANNELS_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 =
		"channels.status = ?";

	public ChannelsPersistenceImpl() {
		setModelClass(Channels.class);

		setModelImplClass(ChannelsImpl.class);
		setModelPKClass(long.class);

		setTable(ChannelsTable.INSTANCE);
	}

	/**
	 * Caches the channels in the entity cache if it is enabled.
	 *
	 * @param channels the channels
	 */
	@Override
	public void cacheResult(Channels channels) {
		dummyEntityCache.putResult(
			ChannelsImpl.class, channels.getPrimaryKey(), channels);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the channelses in the entity cache if it is enabled.
	 *
	 * @param channelses the channelses
	 */
	@Override
	public void cacheResult(List<Channels> channelses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (channelses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Channels channels : channelses) {
			if (dummyEntityCache.getResult(
					ChannelsImpl.class, channels.getPrimaryKey()) == null) {

				cacheResult(channels);
			}
		}
	}

	/**
	 * Clears the cache for all channelses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(ChannelsImpl.class);

		dummyFinderCache.clearCache(ChannelsImpl.class);
	}

	/**
	 * Clears the cache for the channels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Channels channels) {
		dummyEntityCache.removeResult(ChannelsImpl.class, channels);
	}

	@Override
	public void clearCache(List<Channels> channelses) {
		for (Channels channels : channelses) {
			dummyEntityCache.removeResult(ChannelsImpl.class, channels);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(ChannelsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(ChannelsImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new channels with the primary key. Does not add the channels to the database.
	 *
	 * @param channelId the primary key for the new channels
	 * @return the new channels
	 */
	@Override
	public Channels create(long channelId) {
		Channels channels = new ChannelsImpl();

		channels.setNew(true);
		channels.setPrimaryKey(channelId);

		channels.setCompanyId(CompanyThreadLocal.getCompanyId());

		return channels;
	}

	/**
	 * Removes the channels with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param channelId the primary key of the channels
	 * @return the channels that was removed
	 * @throws NoSuchChannelsException if a channels with the primary key could not be found
	 */
	@Override
	public Channels remove(long channelId) throws NoSuchChannelsException {
		return remove((Serializable)channelId);
	}

	/**
	 * Removes the channels with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the channels
	 * @return the channels that was removed
	 * @throws NoSuchChannelsException if a channels with the primary key could not be found
	 */
	@Override
	public Channels remove(Serializable primaryKey)
		throws NoSuchChannelsException {

		Session session = null;

		try {
			session = openSession();

			Channels channels = (Channels)session.get(
				ChannelsImpl.class, primaryKey);

			if (channels == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchChannelsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(channels);
		}
		catch (NoSuchChannelsException noSuchEntityException) {
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
	protected Channels removeImpl(Channels channels) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(channels)) {
				channels = (Channels)session.get(
					ChannelsImpl.class, channels.getPrimaryKeyObj());
			}

			if (channels != null) {
				session.delete(channels);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (channels != null) {
			clearCache(channels);
		}

		return channels;
	}

	@Override
	public Channels updateImpl(Channels channels) {
		boolean isNew = channels.isNew();

		if (!(channels instanceof ChannelsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(channels.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(channels);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in channels proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Channels implementation " +
					channels.getClass());
		}

		ChannelsModelImpl channelsModelImpl = (ChannelsModelImpl)channels;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (channels.getCreateDate() == null)) {
			if (serviceContext == null) {
				channels.setCreateDate(date);
			}
			else {
				channels.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!channelsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				channels.setModifiedDate(date);
			}
			else {
				channels.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(channels);
			}
			else {
				channels = (Channels)session.merge(channels);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			ChannelsImpl.class, channelsModelImpl, false, true);

		if (isNew) {
			channels.setNew(false);
		}

		channels.resetOriginalValues();

		return channels;
	}

	/**
	 * Returns the channels with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the channels
	 * @return the channels
	 * @throws NoSuchChannelsException if a channels with the primary key could not be found
	 */
	@Override
	public Channels findByPrimaryKey(Serializable primaryKey)
		throws NoSuchChannelsException {

		Channels channels = fetchByPrimaryKey(primaryKey);

		if (channels == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchChannelsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return channels;
	}

	/**
	 * Returns the channels with the primary key or throws a <code>NoSuchChannelsException</code> if it could not be found.
	 *
	 * @param channelId the primary key of the channels
	 * @return the channels
	 * @throws NoSuchChannelsException if a channels with the primary key could not be found
	 */
	@Override
	public Channels findByPrimaryKey(long channelId)
		throws NoSuchChannelsException {

		return findByPrimaryKey((Serializable)channelId);
	}

	/**
	 * Returns the channels with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param channelId the primary key of the channels
	 * @return the channels, or <code>null</code> if a channels with the primary key could not be found
	 */
	@Override
	public Channels fetchByPrimaryKey(long channelId) {
		return fetchByPrimaryKey((Serializable)channelId);
	}

	/**
	 * Returns all the channelses.
	 *
	 * @return the channelses
	 */
	@Override
	public List<Channels> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the channelses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChannelsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of channelses
	 * @param end the upper bound of the range of channelses (not inclusive)
	 * @return the range of channelses
	 */
	@Override
	public List<Channels> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the channelses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChannelsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of channelses
	 * @param end the upper bound of the range of channelses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of channelses
	 */
	@Override
	public List<Channels> findAll(
		int start, int end, OrderByComparator<Channels> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the channelses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChannelsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of channelses
	 * @param end the upper bound of the range of channelses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of channelses
	 */
	@Override
	public List<Channels> findAll(
		int start, int end, OrderByComparator<Channels> orderByComparator,
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

		List<Channels> list = null;

		if (useFinderCache) {
			list = (List<Channels>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CHANNELS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CHANNELS;

				sql = sql.concat(ChannelsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Channels>)QueryUtil.list(
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
	 * Removes all the channelses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Channels channels : findAll()) {
			remove(channels);
		}
	}

	/**
	 * Returns the number of channelses.
	 *
	 * @return the number of channelses
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CHANNELS);

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
		return "channelId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CHANNELS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ChannelsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the channels persistence.
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

		_finderPathWithPaginationFindByName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"name"}, true);

		_finderPathWithoutPaginationFindByName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] {String.class.getName()}, new String[] {"name"}, true);

		_finderPathCountByName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] {String.class.getName()}, new String[] {"name"},
			false);

		_finderPathWithPaginationFindByNameAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNameAndStatus",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"name", "status"}, true);

		_finderPathWithPaginationCountByNameAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByNameAndStatus",
			new String[] {String.class.getName(), Integer.class.getName()},
			new String[] {"name", "status"}, false);

		_finderPathWithPaginationFindByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"status"}, true);

		_finderPathWithoutPaginationFindByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] {Integer.class.getName()}, new String[] {"status"},
			true);

		_finderPathCountByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] {Integer.class.getName()}, new String[] {"status"},
			false);

		ChannelsUtil.setPersistence(this);
	}

	public void destroy() {
		ChannelsUtil.setPersistence(null);

		dummyEntityCache.removeCache(ChannelsImpl.class.getName());
	}

	private static final String _SQL_SELECT_CHANNELS =
		"SELECT channels FROM Channels channels";

	private static final String _SQL_SELECT_CHANNELS_WHERE =
		"SELECT channels FROM Channels channels WHERE ";

	private static final String _SQL_COUNT_CHANNELS =
		"SELECT COUNT(channels) FROM Channels channels";

	private static final String _SQL_COUNT_CHANNELS_WHERE =
		"SELECT COUNT(channels) FROM Channels channels WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "channels.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Channels exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Channels exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ChannelsPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}