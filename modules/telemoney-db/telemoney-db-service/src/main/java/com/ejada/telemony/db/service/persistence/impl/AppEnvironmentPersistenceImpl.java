/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence.impl;

import com.ejada.telemony.db.exception.NoSuchAppEnvironmentException;
import com.ejada.telemony.db.model.AppEnvironment;
import com.ejada.telemony.db.model.AppEnvironmentTable;
import com.ejada.telemony.db.model.impl.AppEnvironmentImpl;
import com.ejada.telemony.db.model.impl.AppEnvironmentModelImpl;
import com.ejada.telemony.db.service.persistence.AppEnvironmentPersistence;
import com.ejada.telemony.db.service.persistence.AppEnvironmentUtil;

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
 * The persistence implementation for the app environment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AppEnvironmentPersistenceImpl
	extends BasePersistenceImpl<AppEnvironment>
	implements AppEnvironmentPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AppEnvironmentUtil</code> to access the app environment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AppEnvironmentImpl.class.getName();

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
	 * Returns all the app environments where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the matching app environments
	 */
	@Override
	public List<AppEnvironment> findByChannelId(long channelId) {
		return findByChannelId(
			channelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the app environments where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppEnvironmentModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of app environments
	 * @param end the upper bound of the range of app environments (not inclusive)
	 * @return the range of matching app environments
	 */
	@Override
	public List<AppEnvironment> findByChannelId(
		long channelId, int start, int end) {

		return findByChannelId(channelId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the app environments where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppEnvironmentModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of app environments
	 * @param end the upper bound of the range of app environments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching app environments
	 */
	@Override
	public List<AppEnvironment> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<AppEnvironment> orderByComparator) {

		return findByChannelId(channelId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the app environments where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppEnvironmentModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of app environments
	 * @param end the upper bound of the range of app environments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching app environments
	 */
	@Override
	public List<AppEnvironment> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<AppEnvironment> orderByComparator,
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

		List<AppEnvironment> list = null;

		if (useFinderCache) {
			list = (List<AppEnvironment>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AppEnvironment appEnvironment : list) {
					if (channelId != appEnvironment.getChannelId()) {
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

			sb.append(_SQL_SELECT_APPENVIRONMENT_WHERE);

			sb.append(_FINDER_COLUMN_CHANNELID_CHANNELID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AppEnvironmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				list = (List<AppEnvironment>)QueryUtil.list(
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
	 * Returns the first app environment in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app environment
	 * @throws NoSuchAppEnvironmentException if a matching app environment could not be found
	 */
	@Override
	public AppEnvironment findByChannelId_First(
			long channelId, OrderByComparator<AppEnvironment> orderByComparator)
		throws NoSuchAppEnvironmentException {

		AppEnvironment appEnvironment = fetchByChannelId_First(
			channelId, orderByComparator);

		if (appEnvironment != null) {
			return appEnvironment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append("}");

		throw new NoSuchAppEnvironmentException(sb.toString());
	}

	/**
	 * Returns the first app environment in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app environment, or <code>null</code> if a matching app environment could not be found
	 */
	@Override
	public AppEnvironment fetchByChannelId_First(
		long channelId, OrderByComparator<AppEnvironment> orderByComparator) {

		List<AppEnvironment> list = findByChannelId(
			channelId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last app environment in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app environment
	 * @throws NoSuchAppEnvironmentException if a matching app environment could not be found
	 */
	@Override
	public AppEnvironment findByChannelId_Last(
			long channelId, OrderByComparator<AppEnvironment> orderByComparator)
		throws NoSuchAppEnvironmentException {

		AppEnvironment appEnvironment = fetchByChannelId_Last(
			channelId, orderByComparator);

		if (appEnvironment != null) {
			return appEnvironment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append("}");

		throw new NoSuchAppEnvironmentException(sb.toString());
	}

	/**
	 * Returns the last app environment in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app environment, or <code>null</code> if a matching app environment could not be found
	 */
	@Override
	public AppEnvironment fetchByChannelId_Last(
		long channelId, OrderByComparator<AppEnvironment> orderByComparator) {

		int count = countByChannelId(channelId);

		if (count == 0) {
			return null;
		}

		List<AppEnvironment> list = findByChannelId(
			channelId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the app environments before and after the current app environment in the ordered set where channelId = &#63;.
	 *
	 * @param environmentId the primary key of the current app environment
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app environment
	 * @throws NoSuchAppEnvironmentException if a app environment with the primary key could not be found
	 */
	@Override
	public AppEnvironment[] findByChannelId_PrevAndNext(
			long environmentId, long channelId,
			OrderByComparator<AppEnvironment> orderByComparator)
		throws NoSuchAppEnvironmentException {

		AppEnvironment appEnvironment = findByPrimaryKey(environmentId);

		Session session = null;

		try {
			session = openSession();

			AppEnvironment[] array = new AppEnvironmentImpl[3];

			array[0] = getByChannelId_PrevAndNext(
				session, appEnvironment, channelId, orderByComparator, true);

			array[1] = appEnvironment;

			array[2] = getByChannelId_PrevAndNext(
				session, appEnvironment, channelId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AppEnvironment getByChannelId_PrevAndNext(
		Session session, AppEnvironment appEnvironment, long channelId,
		OrderByComparator<AppEnvironment> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_APPENVIRONMENT_WHERE);

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
			sb.append(AppEnvironmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(channelId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						appEnvironment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AppEnvironment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the app environments where channelId = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 */
	@Override
	public void removeByChannelId(long channelId) {
		for (AppEnvironment appEnvironment :
				findByChannelId(
					channelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(appEnvironment);
		}
	}

	/**
	 * Returns the number of app environments where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the number of matching app environments
	 */
	@Override
	public int countByChannelId(long channelId) {
		FinderPath finderPath = _finderPathCountByChannelId;

		Object[] finderArgs = new Object[] {channelId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_APPENVIRONMENT_WHERE);

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
		"appEnvironment.channelId = ?";

	private FinderPath _finderPathWithPaginationFindByWorkflowStatus;
	private FinderPath _finderPathWithoutPaginationFindByWorkflowStatus;
	private FinderPath _finderPathCountByWorkflowStatus;

	/**
	 * Returns all the app environments where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching app environments
	 */
	@Override
	public List<AppEnvironment> findByWorkflowStatus(int status) {
		return findByWorkflowStatus(
			status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the app environments where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppEnvironmentModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of app environments
	 * @param end the upper bound of the range of app environments (not inclusive)
	 * @return the range of matching app environments
	 */
	@Override
	public List<AppEnvironment> findByWorkflowStatus(
		int status, int start, int end) {

		return findByWorkflowStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the app environments where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppEnvironmentModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of app environments
	 * @param end the upper bound of the range of app environments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching app environments
	 */
	@Override
	public List<AppEnvironment> findByWorkflowStatus(
		int status, int start, int end,
		OrderByComparator<AppEnvironment> orderByComparator) {

		return findByWorkflowStatus(
			status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the app environments where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppEnvironmentModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of app environments
	 * @param end the upper bound of the range of app environments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching app environments
	 */
	@Override
	public List<AppEnvironment> findByWorkflowStatus(
		int status, int start, int end,
		OrderByComparator<AppEnvironment> orderByComparator,
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

		List<AppEnvironment> list = null;

		if (useFinderCache) {
			list = (List<AppEnvironment>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AppEnvironment appEnvironment : list) {
					if (status != appEnvironment.getStatus()) {
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

			sb.append(_SQL_SELECT_APPENVIRONMENT_WHERE);

			sb.append(_FINDER_COLUMN_WORKFLOWSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AppEnvironmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				list = (List<AppEnvironment>)QueryUtil.list(
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
	 * Returns the first app environment in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app environment
	 * @throws NoSuchAppEnvironmentException if a matching app environment could not be found
	 */
	@Override
	public AppEnvironment findByWorkflowStatus_First(
			int status, OrderByComparator<AppEnvironment> orderByComparator)
		throws NoSuchAppEnvironmentException {

		AppEnvironment appEnvironment = fetchByWorkflowStatus_First(
			status, orderByComparator);

		if (appEnvironment != null) {
			return appEnvironment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchAppEnvironmentException(sb.toString());
	}

	/**
	 * Returns the first app environment in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app environment, or <code>null</code> if a matching app environment could not be found
	 */
	@Override
	public AppEnvironment fetchByWorkflowStatus_First(
		int status, OrderByComparator<AppEnvironment> orderByComparator) {

		List<AppEnvironment> list = findByWorkflowStatus(
			status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last app environment in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app environment
	 * @throws NoSuchAppEnvironmentException if a matching app environment could not be found
	 */
	@Override
	public AppEnvironment findByWorkflowStatus_Last(
			int status, OrderByComparator<AppEnvironment> orderByComparator)
		throws NoSuchAppEnvironmentException {

		AppEnvironment appEnvironment = fetchByWorkflowStatus_Last(
			status, orderByComparator);

		if (appEnvironment != null) {
			return appEnvironment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchAppEnvironmentException(sb.toString());
	}

	/**
	 * Returns the last app environment in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app environment, or <code>null</code> if a matching app environment could not be found
	 */
	@Override
	public AppEnvironment fetchByWorkflowStatus_Last(
		int status, OrderByComparator<AppEnvironment> orderByComparator) {

		int count = countByWorkflowStatus(status);

		if (count == 0) {
			return null;
		}

		List<AppEnvironment> list = findByWorkflowStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the app environments before and after the current app environment in the ordered set where status = &#63;.
	 *
	 * @param environmentId the primary key of the current app environment
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app environment
	 * @throws NoSuchAppEnvironmentException if a app environment with the primary key could not be found
	 */
	@Override
	public AppEnvironment[] findByWorkflowStatus_PrevAndNext(
			long environmentId, int status,
			OrderByComparator<AppEnvironment> orderByComparator)
		throws NoSuchAppEnvironmentException {

		AppEnvironment appEnvironment = findByPrimaryKey(environmentId);

		Session session = null;

		try {
			session = openSession();

			AppEnvironment[] array = new AppEnvironmentImpl[3];

			array[0] = getByWorkflowStatus_PrevAndNext(
				session, appEnvironment, status, orderByComparator, true);

			array[1] = appEnvironment;

			array[2] = getByWorkflowStatus_PrevAndNext(
				session, appEnvironment, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AppEnvironment getByWorkflowStatus_PrevAndNext(
		Session session, AppEnvironment appEnvironment, int status,
		OrderByComparator<AppEnvironment> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_APPENVIRONMENT_WHERE);

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
			sb.append(AppEnvironmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						appEnvironment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AppEnvironment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the app environments where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByWorkflowStatus(int status) {
		for (AppEnvironment appEnvironment :
				findByWorkflowStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(appEnvironment);
		}
	}

	/**
	 * Returns the number of app environments where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching app environments
	 */
	@Override
	public int countByWorkflowStatus(int status) {
		FinderPath finderPath = _finderPathCountByWorkflowStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_APPENVIRONMENT_WHERE);

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
		"appEnvironment.status = ?";

	private FinderPath _finderPathWithPaginationFindByEntityResourceId;
	private FinderPath _finderPathWithoutPaginationFindByEntityResourceId;
	private FinderPath _finderPathCountByEntityResourceId;

	/**
	 * Returns all the app environments where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the matching app environments
	 */
	@Override
	public List<AppEnvironment> findByEntityResourceId(long entityResourceId) {
		return findByEntityResourceId(
			entityResourceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the app environments where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppEnvironmentModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of app environments
	 * @param end the upper bound of the range of app environments (not inclusive)
	 * @return the range of matching app environments
	 */
	@Override
	public List<AppEnvironment> findByEntityResourceId(
		long entityResourceId, int start, int end) {

		return findByEntityResourceId(entityResourceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the app environments where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppEnvironmentModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of app environments
	 * @param end the upper bound of the range of app environments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching app environments
	 */
	@Override
	public List<AppEnvironment> findByEntityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<AppEnvironment> orderByComparator) {

		return findByEntityResourceId(
			entityResourceId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the app environments where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppEnvironmentModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of app environments
	 * @param end the upper bound of the range of app environments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching app environments
	 */
	@Override
	public List<AppEnvironment> findByEntityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<AppEnvironment> orderByComparator,
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

		List<AppEnvironment> list = null;

		if (useFinderCache) {
			list = (List<AppEnvironment>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AppEnvironment appEnvironment : list) {
					if (entityResourceId !=
							appEnvironment.getEntityResourceId()) {

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

			sb.append(_SQL_SELECT_APPENVIRONMENT_WHERE);

			sb.append(_FINDER_COLUMN_ENTITYRESOURCEID_ENTITYRESOURCEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AppEnvironmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(entityResourceId);

				list = (List<AppEnvironment>)QueryUtil.list(
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
	 * Returns the first app environment in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app environment
	 * @throws NoSuchAppEnvironmentException if a matching app environment could not be found
	 */
	@Override
	public AppEnvironment findByEntityResourceId_First(
			long entityResourceId,
			OrderByComparator<AppEnvironment> orderByComparator)
		throws NoSuchAppEnvironmentException {

		AppEnvironment appEnvironment = fetchByEntityResourceId_First(
			entityResourceId, orderByComparator);

		if (appEnvironment != null) {
			return appEnvironment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("entityResourceId=");
		sb.append(entityResourceId);

		sb.append("}");

		throw new NoSuchAppEnvironmentException(sb.toString());
	}

	/**
	 * Returns the first app environment in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app environment, or <code>null</code> if a matching app environment could not be found
	 */
	@Override
	public AppEnvironment fetchByEntityResourceId_First(
		long entityResourceId,
		OrderByComparator<AppEnvironment> orderByComparator) {

		List<AppEnvironment> list = findByEntityResourceId(
			entityResourceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last app environment in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app environment
	 * @throws NoSuchAppEnvironmentException if a matching app environment could not be found
	 */
	@Override
	public AppEnvironment findByEntityResourceId_Last(
			long entityResourceId,
			OrderByComparator<AppEnvironment> orderByComparator)
		throws NoSuchAppEnvironmentException {

		AppEnvironment appEnvironment = fetchByEntityResourceId_Last(
			entityResourceId, orderByComparator);

		if (appEnvironment != null) {
			return appEnvironment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("entityResourceId=");
		sb.append(entityResourceId);

		sb.append("}");

		throw new NoSuchAppEnvironmentException(sb.toString());
	}

	/**
	 * Returns the last app environment in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app environment, or <code>null</code> if a matching app environment could not be found
	 */
	@Override
	public AppEnvironment fetchByEntityResourceId_Last(
		long entityResourceId,
		OrderByComparator<AppEnvironment> orderByComparator) {

		int count = countByEntityResourceId(entityResourceId);

		if (count == 0) {
			return null;
		}

		List<AppEnvironment> list = findByEntityResourceId(
			entityResourceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the app environments before and after the current app environment in the ordered set where entityResourceId = &#63;.
	 *
	 * @param environmentId the primary key of the current app environment
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app environment
	 * @throws NoSuchAppEnvironmentException if a app environment with the primary key could not be found
	 */
	@Override
	public AppEnvironment[] findByEntityResourceId_PrevAndNext(
			long environmentId, long entityResourceId,
			OrderByComparator<AppEnvironment> orderByComparator)
		throws NoSuchAppEnvironmentException {

		AppEnvironment appEnvironment = findByPrimaryKey(environmentId);

		Session session = null;

		try {
			session = openSession();

			AppEnvironment[] array = new AppEnvironmentImpl[3];

			array[0] = getByEntityResourceId_PrevAndNext(
				session, appEnvironment, entityResourceId, orderByComparator,
				true);

			array[1] = appEnvironment;

			array[2] = getByEntityResourceId_PrevAndNext(
				session, appEnvironment, entityResourceId, orderByComparator,
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

	protected AppEnvironment getByEntityResourceId_PrevAndNext(
		Session session, AppEnvironment appEnvironment, long entityResourceId,
		OrderByComparator<AppEnvironment> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_APPENVIRONMENT_WHERE);

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
			sb.append(AppEnvironmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(entityResourceId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						appEnvironment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AppEnvironment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the app environments where entityResourceId = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 */
	@Override
	public void removeByEntityResourceId(long entityResourceId) {
		for (AppEnvironment appEnvironment :
				findByEntityResourceId(
					entityResourceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(appEnvironment);
		}
	}

	/**
	 * Returns the number of app environments where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the number of matching app environments
	 */
	@Override
	public int countByEntityResourceId(long entityResourceId) {
		FinderPath finderPath = _finderPathCountByEntityResourceId;

		Object[] finderArgs = new Object[] {entityResourceId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_APPENVIRONMENT_WHERE);

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
			"appEnvironment.entityResourceId = ?";

	public AppEnvironmentPersistenceImpl() {
		setModelClass(AppEnvironment.class);

		setModelImplClass(AppEnvironmentImpl.class);
		setModelPKClass(long.class);

		setTable(AppEnvironmentTable.INSTANCE);
	}

	/**
	 * Caches the app environment in the entity cache if it is enabled.
	 *
	 * @param appEnvironment the app environment
	 */
	@Override
	public void cacheResult(AppEnvironment appEnvironment) {
		dummyEntityCache.putResult(
			AppEnvironmentImpl.class, appEnvironment.getPrimaryKey(),
			appEnvironment);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the app environments in the entity cache if it is enabled.
	 *
	 * @param appEnvironments the app environments
	 */
	@Override
	public void cacheResult(List<AppEnvironment> appEnvironments) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (appEnvironments.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AppEnvironment appEnvironment : appEnvironments) {
			if (dummyEntityCache.getResult(
					AppEnvironmentImpl.class, appEnvironment.getPrimaryKey()) ==
						null) {

				cacheResult(appEnvironment);
			}
		}
	}

	/**
	 * Clears the cache for all app environments.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(AppEnvironmentImpl.class);

		dummyFinderCache.clearCache(AppEnvironmentImpl.class);
	}

	/**
	 * Clears the cache for the app environment.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AppEnvironment appEnvironment) {
		dummyEntityCache.removeResult(AppEnvironmentImpl.class, appEnvironment);
	}

	@Override
	public void clearCache(List<AppEnvironment> appEnvironments) {
		for (AppEnvironment appEnvironment : appEnvironments) {
			dummyEntityCache.removeResult(
				AppEnvironmentImpl.class, appEnvironment);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(AppEnvironmentImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(AppEnvironmentImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new app environment with the primary key. Does not add the app environment to the database.
	 *
	 * @param environmentId the primary key for the new app environment
	 * @return the new app environment
	 */
	@Override
	public AppEnvironment create(long environmentId) {
		AppEnvironment appEnvironment = new AppEnvironmentImpl();

		appEnvironment.setNew(true);
		appEnvironment.setPrimaryKey(environmentId);

		appEnvironment.setCompanyId(CompanyThreadLocal.getCompanyId());

		return appEnvironment;
	}

	/**
	 * Removes the app environment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param environmentId the primary key of the app environment
	 * @return the app environment that was removed
	 * @throws NoSuchAppEnvironmentException if a app environment with the primary key could not be found
	 */
	@Override
	public AppEnvironment remove(long environmentId)
		throws NoSuchAppEnvironmentException {

		return remove((Serializable)environmentId);
	}

	/**
	 * Removes the app environment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the app environment
	 * @return the app environment that was removed
	 * @throws NoSuchAppEnvironmentException if a app environment with the primary key could not be found
	 */
	@Override
	public AppEnvironment remove(Serializable primaryKey)
		throws NoSuchAppEnvironmentException {

		Session session = null;

		try {
			session = openSession();

			AppEnvironment appEnvironment = (AppEnvironment)session.get(
				AppEnvironmentImpl.class, primaryKey);

			if (appEnvironment == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAppEnvironmentException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(appEnvironment);
		}
		catch (NoSuchAppEnvironmentException noSuchEntityException) {
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
	protected AppEnvironment removeImpl(AppEnvironment appEnvironment) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(appEnvironment)) {
				appEnvironment = (AppEnvironment)session.get(
					AppEnvironmentImpl.class,
					appEnvironment.getPrimaryKeyObj());
			}

			if (appEnvironment != null) {
				session.delete(appEnvironment);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (appEnvironment != null) {
			clearCache(appEnvironment);
		}

		return appEnvironment;
	}

	@Override
	public AppEnvironment updateImpl(AppEnvironment appEnvironment) {
		boolean isNew = appEnvironment.isNew();

		if (!(appEnvironment instanceof AppEnvironmentModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(appEnvironment.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					appEnvironment);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in appEnvironment proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AppEnvironment implementation " +
					appEnvironment.getClass());
		}

		AppEnvironmentModelImpl appEnvironmentModelImpl =
			(AppEnvironmentModelImpl)appEnvironment;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (appEnvironment.getCreateDate() == null)) {
			if (serviceContext == null) {
				appEnvironment.setCreateDate(date);
			}
			else {
				appEnvironment.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!appEnvironmentModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				appEnvironment.setModifiedDate(date);
			}
			else {
				appEnvironment.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(appEnvironment);
			}
			else {
				appEnvironment = (AppEnvironment)session.merge(appEnvironment);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			AppEnvironmentImpl.class, appEnvironmentModelImpl, false, true);

		if (isNew) {
			appEnvironment.setNew(false);
		}

		appEnvironment.resetOriginalValues();

		return appEnvironment;
	}

	/**
	 * Returns the app environment with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the app environment
	 * @return the app environment
	 * @throws NoSuchAppEnvironmentException if a app environment with the primary key could not be found
	 */
	@Override
	public AppEnvironment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAppEnvironmentException {

		AppEnvironment appEnvironment = fetchByPrimaryKey(primaryKey);

		if (appEnvironment == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAppEnvironmentException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return appEnvironment;
	}

	/**
	 * Returns the app environment with the primary key or throws a <code>NoSuchAppEnvironmentException</code> if it could not be found.
	 *
	 * @param environmentId the primary key of the app environment
	 * @return the app environment
	 * @throws NoSuchAppEnvironmentException if a app environment with the primary key could not be found
	 */
	@Override
	public AppEnvironment findByPrimaryKey(long environmentId)
		throws NoSuchAppEnvironmentException {

		return findByPrimaryKey((Serializable)environmentId);
	}

	/**
	 * Returns the app environment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param environmentId the primary key of the app environment
	 * @return the app environment, or <code>null</code> if a app environment with the primary key could not be found
	 */
	@Override
	public AppEnvironment fetchByPrimaryKey(long environmentId) {
		return fetchByPrimaryKey((Serializable)environmentId);
	}

	/**
	 * Returns all the app environments.
	 *
	 * @return the app environments
	 */
	@Override
	public List<AppEnvironment> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the app environments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppEnvironmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app environments
	 * @param end the upper bound of the range of app environments (not inclusive)
	 * @return the range of app environments
	 */
	@Override
	public List<AppEnvironment> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the app environments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppEnvironmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app environments
	 * @param end the upper bound of the range of app environments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of app environments
	 */
	@Override
	public List<AppEnvironment> findAll(
		int start, int end,
		OrderByComparator<AppEnvironment> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the app environments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppEnvironmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app environments
	 * @param end the upper bound of the range of app environments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of app environments
	 */
	@Override
	public List<AppEnvironment> findAll(
		int start, int end, OrderByComparator<AppEnvironment> orderByComparator,
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

		List<AppEnvironment> list = null;

		if (useFinderCache) {
			list = (List<AppEnvironment>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_APPENVIRONMENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_APPENVIRONMENT;

				sql = sql.concat(AppEnvironmentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AppEnvironment>)QueryUtil.list(
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
	 * Removes all the app environments from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AppEnvironment appEnvironment : findAll()) {
			remove(appEnvironment);
		}
	}

	/**
	 * Returns the number of app environments.
	 *
	 * @return the number of app environments
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_APPENVIRONMENT);

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
		return "environmentId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_APPENVIRONMENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AppEnvironmentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the app environment persistence.
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

		AppEnvironmentUtil.setPersistence(this);
	}

	public void destroy() {
		AppEnvironmentUtil.setPersistence(null);

		dummyEntityCache.removeCache(AppEnvironmentImpl.class.getName());
	}

	private static final String _SQL_SELECT_APPENVIRONMENT =
		"SELECT appEnvironment FROM AppEnvironment appEnvironment";

	private static final String _SQL_SELECT_APPENVIRONMENT_WHERE =
		"SELECT appEnvironment FROM AppEnvironment appEnvironment WHERE ";

	private static final String _SQL_COUNT_APPENVIRONMENT =
		"SELECT COUNT(appEnvironment) FROM AppEnvironment appEnvironment";

	private static final String _SQL_COUNT_APPENVIRONMENT_WHERE =
		"SELECT COUNT(appEnvironment) FROM AppEnvironment appEnvironment WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "appEnvironment.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AppEnvironment exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AppEnvironment exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AppEnvironmentPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}