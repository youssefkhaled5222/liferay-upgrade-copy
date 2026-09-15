/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence.impl;

import com.ejada.telemony.db.exception.NoSuchUserLogsException;
import com.ejada.telemony.db.model.UserLogs;
import com.ejada.telemony.db.model.UserLogsTable;
import com.ejada.telemony.db.model.impl.UserLogsImpl;
import com.ejada.telemony.db.model.impl.UserLogsModelImpl;
import com.ejada.telemony.db.service.persistence.UserLogsPersistence;
import com.ejada.telemony.db.service.persistence.UserLogsUtil;

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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the user logs service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UserLogsPersistenceImpl
	extends BasePersistenceImpl<UserLogs> implements UserLogsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>UserLogsUtil</code> to access the user logs persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		UserLogsImpl.class.getName();

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
	 * Returns all the user logses where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the matching user logses
	 */
	@Override
	public List<UserLogs> findByChannelId(long channelId) {
		return findByChannelId(
			channelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user logses where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLogsModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of user logses
	 * @param end the upper bound of the range of user logses (not inclusive)
	 * @return the range of matching user logses
	 */
	@Override
	public List<UserLogs> findByChannelId(long channelId, int start, int end) {
		return findByChannelId(channelId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user logses where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLogsModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of user logses
	 * @param end the upper bound of the range of user logses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user logses
	 */
	@Override
	public List<UserLogs> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<UserLogs> orderByComparator) {

		return findByChannelId(channelId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user logses where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLogsModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of user logses
	 * @param end the upper bound of the range of user logses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user logses
	 */
	@Override
	public List<UserLogs> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<UserLogs> orderByComparator, boolean useFinderCache) {

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

		List<UserLogs> list = null;

		if (useFinderCache) {
			list = (List<UserLogs>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserLogs userLogs : list) {
					if (channelId != userLogs.getChannelId()) {
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

			sb.append(_SQL_SELECT_USERLOGS_WHERE);

			sb.append(_FINDER_COLUMN_CHANNELID_CHANNELID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(UserLogsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				list = (List<UserLogs>)QueryUtil.list(
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
	 * Returns the first user logs in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user logs
	 * @throws NoSuchUserLogsException if a matching user logs could not be found
	 */
	@Override
	public UserLogs findByChannelId_First(
			long channelId, OrderByComparator<UserLogs> orderByComparator)
		throws NoSuchUserLogsException {

		UserLogs userLogs = fetchByChannelId_First(
			channelId, orderByComparator);

		if (userLogs != null) {
			return userLogs;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append("}");

		throw new NoSuchUserLogsException(sb.toString());
	}

	/**
	 * Returns the first user logs in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user logs, or <code>null</code> if a matching user logs could not be found
	 */
	@Override
	public UserLogs fetchByChannelId_First(
		long channelId, OrderByComparator<UserLogs> orderByComparator) {

		List<UserLogs> list = findByChannelId(
			channelId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user logs in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user logs
	 * @throws NoSuchUserLogsException if a matching user logs could not be found
	 */
	@Override
	public UserLogs findByChannelId_Last(
			long channelId, OrderByComparator<UserLogs> orderByComparator)
		throws NoSuchUserLogsException {

		UserLogs userLogs = fetchByChannelId_Last(channelId, orderByComparator);

		if (userLogs != null) {
			return userLogs;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append("}");

		throw new NoSuchUserLogsException(sb.toString());
	}

	/**
	 * Returns the last user logs in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user logs, or <code>null</code> if a matching user logs could not be found
	 */
	@Override
	public UserLogs fetchByChannelId_Last(
		long channelId, OrderByComparator<UserLogs> orderByComparator) {

		int count = countByChannelId(channelId);

		if (count == 0) {
			return null;
		}

		List<UserLogs> list = findByChannelId(
			channelId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user logses before and after the current user logs in the ordered set where channelId = &#63;.
	 *
	 * @param logsId the primary key of the current user logs
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user logs
	 * @throws NoSuchUserLogsException if a user logs with the primary key could not be found
	 */
	@Override
	public UserLogs[] findByChannelId_PrevAndNext(
			long logsId, long channelId,
			OrderByComparator<UserLogs> orderByComparator)
		throws NoSuchUserLogsException {

		UserLogs userLogs = findByPrimaryKey(logsId);

		Session session = null;

		try {
			session = openSession();

			UserLogs[] array = new UserLogsImpl[3];

			array[0] = getByChannelId_PrevAndNext(
				session, userLogs, channelId, orderByComparator, true);

			array[1] = userLogs;

			array[2] = getByChannelId_PrevAndNext(
				session, userLogs, channelId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserLogs getByChannelId_PrevAndNext(
		Session session, UserLogs userLogs, long channelId,
		OrderByComparator<UserLogs> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_USERLOGS_WHERE);

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
			sb.append(UserLogsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(channelId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(userLogs)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UserLogs> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user logses where channelId = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 */
	@Override
	public void removeByChannelId(long channelId) {
		for (UserLogs userLogs :
				findByChannelId(
					channelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(userLogs);
		}
	}

	/**
	 * Returns the number of user logses where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the number of matching user logses
	 */
	@Override
	public int countByChannelId(long channelId) {
		FinderPath finderPath = _finderPathCountByChannelId;

		Object[] finderArgs = new Object[] {channelId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_USERLOGS_WHERE);

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
		"userLogs.channelId = ?";

	public UserLogsPersistenceImpl() {
		setModelClass(UserLogs.class);

		setModelImplClass(UserLogsImpl.class);
		setModelPKClass(long.class);

		setTable(UserLogsTable.INSTANCE);
	}

	/**
	 * Caches the user logs in the entity cache if it is enabled.
	 *
	 * @param userLogs the user logs
	 */
	@Override
	public void cacheResult(UserLogs userLogs) {
		dummyEntityCache.putResult(
			UserLogsImpl.class, userLogs.getPrimaryKey(), userLogs);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the user logses in the entity cache if it is enabled.
	 *
	 * @param userLogses the user logses
	 */
	@Override
	public void cacheResult(List<UserLogs> userLogses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (userLogses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (UserLogs userLogs : userLogses) {
			if (dummyEntityCache.getResult(
					UserLogsImpl.class, userLogs.getPrimaryKey()) == null) {

				cacheResult(userLogs);
			}
		}
	}

	/**
	 * Clears the cache for all user logses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(UserLogsImpl.class);

		dummyFinderCache.clearCache(UserLogsImpl.class);
	}

	/**
	 * Clears the cache for the user logs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserLogs userLogs) {
		dummyEntityCache.removeResult(UserLogsImpl.class, userLogs);
	}

	@Override
	public void clearCache(List<UserLogs> userLogses) {
		for (UserLogs userLogs : userLogses) {
			dummyEntityCache.removeResult(UserLogsImpl.class, userLogs);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(UserLogsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(UserLogsImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new user logs with the primary key. Does not add the user logs to the database.
	 *
	 * @param logsId the primary key for the new user logs
	 * @return the new user logs
	 */
	@Override
	public UserLogs create(long logsId) {
		UserLogs userLogs = new UserLogsImpl();

		userLogs.setNew(true);
		userLogs.setPrimaryKey(logsId);

		return userLogs;
	}

	/**
	 * Removes the user logs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param logsId the primary key of the user logs
	 * @return the user logs that was removed
	 * @throws NoSuchUserLogsException if a user logs with the primary key could not be found
	 */
	@Override
	public UserLogs remove(long logsId) throws NoSuchUserLogsException {
		return remove((Serializable)logsId);
	}

	/**
	 * Removes the user logs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user logs
	 * @return the user logs that was removed
	 * @throws NoSuchUserLogsException if a user logs with the primary key could not be found
	 */
	@Override
	public UserLogs remove(Serializable primaryKey)
		throws NoSuchUserLogsException {

		Session session = null;

		try {
			session = openSession();

			UserLogs userLogs = (UserLogs)session.get(
				UserLogsImpl.class, primaryKey);

			if (userLogs == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserLogsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(userLogs);
		}
		catch (NoSuchUserLogsException noSuchEntityException) {
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
	protected UserLogs removeImpl(UserLogs userLogs) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userLogs)) {
				userLogs = (UserLogs)session.get(
					UserLogsImpl.class, userLogs.getPrimaryKeyObj());
			}

			if (userLogs != null) {
				session.delete(userLogs);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (userLogs != null) {
			clearCache(userLogs);
		}

		return userLogs;
	}

	@Override
	public UserLogs updateImpl(UserLogs userLogs) {
		boolean isNew = userLogs.isNew();

		if (!(userLogs instanceof UserLogsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(userLogs.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(userLogs);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in userLogs proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom UserLogs implementation " +
					userLogs.getClass());
		}

		UserLogsModelImpl userLogsModelImpl = (UserLogsModelImpl)userLogs;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(userLogs);
			}
			else {
				userLogs = (UserLogs)session.merge(userLogs);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			UserLogsImpl.class, userLogsModelImpl, false, true);

		if (isNew) {
			userLogs.setNew(false);
		}

		userLogs.resetOriginalValues();

		return userLogs;
	}

	/**
	 * Returns the user logs with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user logs
	 * @return the user logs
	 * @throws NoSuchUserLogsException if a user logs with the primary key could not be found
	 */
	@Override
	public UserLogs findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserLogsException {

		UserLogs userLogs = fetchByPrimaryKey(primaryKey);

		if (userLogs == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserLogsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return userLogs;
	}

	/**
	 * Returns the user logs with the primary key or throws a <code>NoSuchUserLogsException</code> if it could not be found.
	 *
	 * @param logsId the primary key of the user logs
	 * @return the user logs
	 * @throws NoSuchUserLogsException if a user logs with the primary key could not be found
	 */
	@Override
	public UserLogs findByPrimaryKey(long logsId)
		throws NoSuchUserLogsException {

		return findByPrimaryKey((Serializable)logsId);
	}

	/**
	 * Returns the user logs with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param logsId the primary key of the user logs
	 * @return the user logs, or <code>null</code> if a user logs with the primary key could not be found
	 */
	@Override
	public UserLogs fetchByPrimaryKey(long logsId) {
		return fetchByPrimaryKey((Serializable)logsId);
	}

	/**
	 * Returns all the user logses.
	 *
	 * @return the user logses
	 */
	@Override
	public List<UserLogs> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user logses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLogsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user logses
	 * @param end the upper bound of the range of user logses (not inclusive)
	 * @return the range of user logses
	 */
	@Override
	public List<UserLogs> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user logses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLogsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user logses
	 * @param end the upper bound of the range of user logses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user logses
	 */
	@Override
	public List<UserLogs> findAll(
		int start, int end, OrderByComparator<UserLogs> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user logses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLogsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user logses
	 * @param end the upper bound of the range of user logses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user logses
	 */
	@Override
	public List<UserLogs> findAll(
		int start, int end, OrderByComparator<UserLogs> orderByComparator,
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

		List<UserLogs> list = null;

		if (useFinderCache) {
			list = (List<UserLogs>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_USERLOGS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_USERLOGS;

				sql = sql.concat(UserLogsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<UserLogs>)QueryUtil.list(
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
	 * Removes all the user logses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserLogs userLogs : findAll()) {
			remove(userLogs);
		}
	}

	/**
	 * Returns the number of user logses.
	 *
	 * @return the number of user logses
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_USERLOGS);

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
		return "logsId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_USERLOGS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return UserLogsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user logs persistence.
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

		UserLogsUtil.setPersistence(this);
	}

	public void destroy() {
		UserLogsUtil.setPersistence(null);

		dummyEntityCache.removeCache(UserLogsImpl.class.getName());
	}

	private static final String _SQL_SELECT_USERLOGS =
		"SELECT userLogs FROM UserLogs userLogs";

	private static final String _SQL_SELECT_USERLOGS_WHERE =
		"SELECT userLogs FROM UserLogs userLogs WHERE ";

	private static final String _SQL_COUNT_USERLOGS =
		"SELECT COUNT(userLogs) FROM UserLogs userLogs";

	private static final String _SQL_COUNT_USERLOGS_WHERE =
		"SELECT COUNT(userLogs) FROM UserLogs userLogs WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "userLogs.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No UserLogs exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No UserLogs exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		UserLogsPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}