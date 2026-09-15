/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence.impl;

import com.ejada.telemony.db.exception.NoSuchGlobalVersionException;
import com.ejada.telemony.db.model.GlobalVersion;
import com.ejada.telemony.db.model.GlobalVersionTable;
import com.ejada.telemony.db.model.impl.GlobalVersionImpl;
import com.ejada.telemony.db.model.impl.GlobalVersionModelImpl;
import com.ejada.telemony.db.service.persistence.GlobalVersionPersistence;
import com.ejada.telemony.db.service.persistence.GlobalVersionUtil;

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
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the global version service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class GlobalVersionPersistenceImpl
	extends BasePersistenceImpl<GlobalVersion>
	implements GlobalVersionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>GlobalVersionUtil</code> to access the global version persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		GlobalVersionImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByC_C_C;

	/**
	 * Returns the global version where companyId = &#63; and channelId = &#63; and componentName = &#63; or throws a <code>NoSuchGlobalVersionException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param channelId the channel ID
	 * @param componentName the component name
	 * @return the matching global version
	 * @throws NoSuchGlobalVersionException if a matching global version could not be found
	 */
	@Override
	public GlobalVersion findByC_C_C(
			long companyId, long channelId, String componentName)
		throws NoSuchGlobalVersionException {

		GlobalVersion globalVersion = fetchByC_C_C(
			companyId, channelId, componentName);

		if (globalVersion == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("companyId=");
			sb.append(companyId);

			sb.append(", channelId=");
			sb.append(channelId);

			sb.append(", componentName=");
			sb.append(componentName);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchGlobalVersionException(sb.toString());
		}

		return globalVersion;
	}

	/**
	 * Returns the global version where companyId = &#63; and channelId = &#63; and componentName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param channelId the channel ID
	 * @param componentName the component name
	 * @return the matching global version, or <code>null</code> if a matching global version could not be found
	 */
	@Override
	public GlobalVersion fetchByC_C_C(
		long companyId, long channelId, String componentName) {

		return fetchByC_C_C(companyId, channelId, componentName, true);
	}

	/**
	 * Returns the global version where companyId = &#63; and channelId = &#63; and componentName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param channelId the channel ID
	 * @param componentName the component name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching global version, or <code>null</code> if a matching global version could not be found
	 */
	@Override
	public GlobalVersion fetchByC_C_C(
		long companyId, long channelId, String componentName,
		boolean useFinderCache) {

		componentName = Objects.toString(componentName, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {companyId, channelId, componentName};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
				_finderPathFetchByC_C_C, finderArgs, this);
		}

		if (result instanceof GlobalVersion) {
			GlobalVersion globalVersion = (GlobalVersion)result;

			if ((companyId != globalVersion.getCompanyId()) ||
				(channelId != globalVersion.getChannelId()) ||
				!Objects.equals(
					componentName, globalVersion.getComponentName())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_GLOBALVERSION_WHERE);

			sb.append(_FINDER_COLUMN_C_C_C_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_C_C_CHANNELID_2);

			boolean bindComponentName = false;

			if (componentName.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_C_C_COMPONENTNAME_3);
			}
			else {
				bindComponentName = true;

				sb.append(_FINDER_COLUMN_C_C_C_COMPONENTNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(channelId);

				if (bindComponentName) {
					queryPos.add(componentName);
				}

				List<GlobalVersion> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchByC_C_C, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									companyId, channelId, componentName
								};
							}

							_log.warn(
								"GlobalVersionPersistenceImpl.fetchByC_C_C(long, long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					GlobalVersion globalVersion = list.get(0);

					result = globalVersion;

					cacheResult(globalVersion);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (GlobalVersion)result;
		}
	}

	/**
	 * Removes the global version where companyId = &#63; and channelId = &#63; and componentName = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param channelId the channel ID
	 * @param componentName the component name
	 * @return the global version that was removed
	 */
	@Override
	public GlobalVersion removeByC_C_C(
			long companyId, long channelId, String componentName)
		throws NoSuchGlobalVersionException {

		GlobalVersion globalVersion = findByC_C_C(
			companyId, channelId, componentName);

		return remove(globalVersion);
	}

	/**
	 * Returns the number of global versions where companyId = &#63; and channelId = &#63; and componentName = &#63;.
	 *
	 * @param companyId the company ID
	 * @param channelId the channel ID
	 * @param componentName the component name
	 * @return the number of matching global versions
	 */
	@Override
	public int countByC_C_C(
		long companyId, long channelId, String componentName) {

		GlobalVersion globalVersion = fetchByC_C_C(
			companyId, channelId, componentName);

		if (globalVersion == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_C_C_C_COMPANYID_2 =
		"globalVersion.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_C_C_CHANNELID_2 =
		"globalVersion.channelId = ? AND ";

	private static final String _FINDER_COLUMN_C_C_C_COMPONENTNAME_2 =
		"globalVersion.componentName = ?";

	private static final String _FINDER_COLUMN_C_C_C_COMPONENTNAME_3 =
		"(globalVersion.componentName IS NULL OR globalVersion.componentName = '')";

	private FinderPath _finderPathWithPaginationFindByCompanyId;
	private FinderPath _finderPathWithoutPaginationFindByCompanyId;
	private FinderPath _finderPathCountByCompanyId;

	/**
	 * Returns all the global versions where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching global versions
	 */
	@Override
	public List<GlobalVersion> findByCompanyId(long companyId) {
		return findByCompanyId(
			companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the global versions where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GlobalVersionModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of global versions
	 * @param end the upper bound of the range of global versions (not inclusive)
	 * @return the range of matching global versions
	 */
	@Override
	public List<GlobalVersion> findByCompanyId(
		long companyId, int start, int end) {

		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the global versions where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GlobalVersionModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of global versions
	 * @param end the upper bound of the range of global versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching global versions
	 */
	@Override
	public List<GlobalVersion> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<GlobalVersion> orderByComparator) {

		return findByCompanyId(companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the global versions where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GlobalVersionModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of global versions
	 * @param end the upper bound of the range of global versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching global versions
	 */
	@Override
	public List<GlobalVersion> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<GlobalVersion> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCompanyId;
				finderArgs = new Object[] {companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCompanyId;
			finderArgs = new Object[] {
				companyId, start, end, orderByComparator
			};
		}

		List<GlobalVersion> list = null;

		if (useFinderCache) {
			list = (List<GlobalVersion>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GlobalVersion globalVersion : list) {
					if (companyId != globalVersion.getCompanyId()) {
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

			sb.append(_SQL_SELECT_GLOBALVERSION_WHERE);

			sb.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(GlobalVersionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				list = (List<GlobalVersion>)QueryUtil.list(
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
	 * Returns the first global version in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching global version
	 * @throws NoSuchGlobalVersionException if a matching global version could not be found
	 */
	@Override
	public GlobalVersion findByCompanyId_First(
			long companyId, OrderByComparator<GlobalVersion> orderByComparator)
		throws NoSuchGlobalVersionException {

		GlobalVersion globalVersion = fetchByCompanyId_First(
			companyId, orderByComparator);

		if (globalVersion != null) {
			return globalVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchGlobalVersionException(sb.toString());
	}

	/**
	 * Returns the first global version in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching global version, or <code>null</code> if a matching global version could not be found
	 */
	@Override
	public GlobalVersion fetchByCompanyId_First(
		long companyId, OrderByComparator<GlobalVersion> orderByComparator) {

		List<GlobalVersion> list = findByCompanyId(
			companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last global version in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching global version
	 * @throws NoSuchGlobalVersionException if a matching global version could not be found
	 */
	@Override
	public GlobalVersion findByCompanyId_Last(
			long companyId, OrderByComparator<GlobalVersion> orderByComparator)
		throws NoSuchGlobalVersionException {

		GlobalVersion globalVersion = fetchByCompanyId_Last(
			companyId, orderByComparator);

		if (globalVersion != null) {
			return globalVersion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchGlobalVersionException(sb.toString());
	}

	/**
	 * Returns the last global version in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching global version, or <code>null</code> if a matching global version could not be found
	 */
	@Override
	public GlobalVersion fetchByCompanyId_Last(
		long companyId, OrderByComparator<GlobalVersion> orderByComparator) {

		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<GlobalVersion> list = findByCompanyId(
			companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the global versions before and after the current global version in the ordered set where companyId = &#63;.
	 *
	 * @param versionId the primary key of the current global version
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next global version
	 * @throws NoSuchGlobalVersionException if a global version with the primary key could not be found
	 */
	@Override
	public GlobalVersion[] findByCompanyId_PrevAndNext(
			long versionId, long companyId,
			OrderByComparator<GlobalVersion> orderByComparator)
		throws NoSuchGlobalVersionException {

		GlobalVersion globalVersion = findByPrimaryKey(versionId);

		Session session = null;

		try {
			session = openSession();

			GlobalVersion[] array = new GlobalVersionImpl[3];

			array[0] = getByCompanyId_PrevAndNext(
				session, globalVersion, companyId, orderByComparator, true);

			array[1] = globalVersion;

			array[2] = getByCompanyId_PrevAndNext(
				session, globalVersion, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected GlobalVersion getByCompanyId_PrevAndNext(
		Session session, GlobalVersion globalVersion, long companyId,
		OrderByComparator<GlobalVersion> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_GLOBALVERSION_WHERE);

		sb.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

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
			sb.append(GlobalVersionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						globalVersion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<GlobalVersion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the global versions where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeByCompanyId(long companyId) {
		for (GlobalVersion globalVersion :
				findByCompanyId(
					companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(globalVersion);
		}
	}

	/**
	 * Returns the number of global versions where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching global versions
	 */
	@Override
	public int countByCompanyId(long companyId) {
		FinderPath finderPath = _finderPathCountByCompanyId;

		Object[] finderArgs = new Object[] {companyId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_GLOBALVERSION_WHERE);

			sb.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

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

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 =
		"globalVersion.companyId = ?";

	public GlobalVersionPersistenceImpl() {
		setModelClass(GlobalVersion.class);

		setModelImplClass(GlobalVersionImpl.class);
		setModelPKClass(long.class);

		setTable(GlobalVersionTable.INSTANCE);
	}

	/**
	 * Caches the global version in the entity cache if it is enabled.
	 *
	 * @param globalVersion the global version
	 */
	@Override
	public void cacheResult(GlobalVersion globalVersion) {
		dummyEntityCache.putResult(
			GlobalVersionImpl.class, globalVersion.getPrimaryKey(),
			globalVersion);

		dummyFinderCache.putResult(
			_finderPathFetchByC_C_C,
			new Object[] {
				globalVersion.getCompanyId(), globalVersion.getChannelId(),
				globalVersion.getComponentName()
			},
			globalVersion);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the global versions in the entity cache if it is enabled.
	 *
	 * @param globalVersions the global versions
	 */
	@Override
	public void cacheResult(List<GlobalVersion> globalVersions) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (globalVersions.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (GlobalVersion globalVersion : globalVersions) {
			if (dummyEntityCache.getResult(
					GlobalVersionImpl.class, globalVersion.getPrimaryKey()) ==
						null) {

				cacheResult(globalVersion);
			}
		}
	}

	/**
	 * Clears the cache for all global versions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(GlobalVersionImpl.class);

		dummyFinderCache.clearCache(GlobalVersionImpl.class);
	}

	/**
	 * Clears the cache for the global version.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GlobalVersion globalVersion) {
		dummyEntityCache.removeResult(GlobalVersionImpl.class, globalVersion);
	}

	@Override
	public void clearCache(List<GlobalVersion> globalVersions) {
		for (GlobalVersion globalVersion : globalVersions) {
			dummyEntityCache.removeResult(
				GlobalVersionImpl.class, globalVersion);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(GlobalVersionImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(GlobalVersionImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		GlobalVersionModelImpl globalVersionModelImpl) {

		Object[] args = new Object[] {
			globalVersionModelImpl.getCompanyId(),
			globalVersionModelImpl.getChannelId(),
			globalVersionModelImpl.getComponentName()
		};

		dummyFinderCache.putResult(
			_finderPathFetchByC_C_C, args, globalVersionModelImpl);
	}

	/**
	 * Creates a new global version with the primary key. Does not add the global version to the database.
	 *
	 * @param versionId the primary key for the new global version
	 * @return the new global version
	 */
	@Override
	public GlobalVersion create(long versionId) {
		GlobalVersion globalVersion = new GlobalVersionImpl();

		globalVersion.setNew(true);
		globalVersion.setPrimaryKey(versionId);

		globalVersion.setCompanyId(CompanyThreadLocal.getCompanyId());

		return globalVersion;
	}

	/**
	 * Removes the global version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param versionId the primary key of the global version
	 * @return the global version that was removed
	 * @throws NoSuchGlobalVersionException if a global version with the primary key could not be found
	 */
	@Override
	public GlobalVersion remove(long versionId)
		throws NoSuchGlobalVersionException {

		return remove((Serializable)versionId);
	}

	/**
	 * Removes the global version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the global version
	 * @return the global version that was removed
	 * @throws NoSuchGlobalVersionException if a global version with the primary key could not be found
	 */
	@Override
	public GlobalVersion remove(Serializable primaryKey)
		throws NoSuchGlobalVersionException {

		Session session = null;

		try {
			session = openSession();

			GlobalVersion globalVersion = (GlobalVersion)session.get(
				GlobalVersionImpl.class, primaryKey);

			if (globalVersion == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGlobalVersionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(globalVersion);
		}
		catch (NoSuchGlobalVersionException noSuchEntityException) {
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
	protected GlobalVersion removeImpl(GlobalVersion globalVersion) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(globalVersion)) {
				globalVersion = (GlobalVersion)session.get(
					GlobalVersionImpl.class, globalVersion.getPrimaryKeyObj());
			}

			if (globalVersion != null) {
				session.delete(globalVersion);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (globalVersion != null) {
			clearCache(globalVersion);
		}

		return globalVersion;
	}

	@Override
	public GlobalVersion updateImpl(GlobalVersion globalVersion) {
		boolean isNew = globalVersion.isNew();

		if (!(globalVersion instanceof GlobalVersionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(globalVersion.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					globalVersion);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in globalVersion proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom GlobalVersion implementation " +
					globalVersion.getClass());
		}

		GlobalVersionModelImpl globalVersionModelImpl =
			(GlobalVersionModelImpl)globalVersion;

		if (!globalVersionModelImpl.hasSetModifiedDate()) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				globalVersion.setModifiedDate(date);
			}
			else {
				globalVersion.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(globalVersion);
			}
			else {
				globalVersion = (GlobalVersion)session.merge(globalVersion);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			GlobalVersionImpl.class, globalVersionModelImpl, false, true);

		cacheUniqueFindersCache(globalVersionModelImpl);

		if (isNew) {
			globalVersion.setNew(false);
		}

		globalVersion.resetOriginalValues();

		return globalVersion;
	}

	/**
	 * Returns the global version with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the global version
	 * @return the global version
	 * @throws NoSuchGlobalVersionException if a global version with the primary key could not be found
	 */
	@Override
	public GlobalVersion findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGlobalVersionException {

		GlobalVersion globalVersion = fetchByPrimaryKey(primaryKey);

		if (globalVersion == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGlobalVersionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return globalVersion;
	}

	/**
	 * Returns the global version with the primary key or throws a <code>NoSuchGlobalVersionException</code> if it could not be found.
	 *
	 * @param versionId the primary key of the global version
	 * @return the global version
	 * @throws NoSuchGlobalVersionException if a global version with the primary key could not be found
	 */
	@Override
	public GlobalVersion findByPrimaryKey(long versionId)
		throws NoSuchGlobalVersionException {

		return findByPrimaryKey((Serializable)versionId);
	}

	/**
	 * Returns the global version with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param versionId the primary key of the global version
	 * @return the global version, or <code>null</code> if a global version with the primary key could not be found
	 */
	@Override
	public GlobalVersion fetchByPrimaryKey(long versionId) {
		return fetchByPrimaryKey((Serializable)versionId);
	}

	/**
	 * Returns all the global versions.
	 *
	 * @return the global versions
	 */
	@Override
	public List<GlobalVersion> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the global versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GlobalVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of global versions
	 * @param end the upper bound of the range of global versions (not inclusive)
	 * @return the range of global versions
	 */
	@Override
	public List<GlobalVersion> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the global versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GlobalVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of global versions
	 * @param end the upper bound of the range of global versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of global versions
	 */
	@Override
	public List<GlobalVersion> findAll(
		int start, int end,
		OrderByComparator<GlobalVersion> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the global versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GlobalVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of global versions
	 * @param end the upper bound of the range of global versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of global versions
	 */
	@Override
	public List<GlobalVersion> findAll(
		int start, int end, OrderByComparator<GlobalVersion> orderByComparator,
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

		List<GlobalVersion> list = null;

		if (useFinderCache) {
			list = (List<GlobalVersion>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_GLOBALVERSION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_GLOBALVERSION;

				sql = sql.concat(GlobalVersionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<GlobalVersion>)QueryUtil.list(
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
	 * Removes all the global versions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (GlobalVersion globalVersion : findAll()) {
			remove(globalVersion);
		}
	}

	/**
	 * Returns the number of global versions.
	 *
	 * @return the number of global versions
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_GLOBALVERSION);

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
		return _SQL_SELECT_GLOBALVERSION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return GlobalVersionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the global version persistence.
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

		_finderPathFetchByC_C_C = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_C_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			new String[] {"companyId", "channelId", "componentName"}, true);

		_finderPathWithPaginationFindByCompanyId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"companyId"}, true);

		_finderPathWithoutPaginationFindByCompanyId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] {Long.class.getName()}, new String[] {"companyId"},
			true);

		_finderPathCountByCompanyId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] {Long.class.getName()}, new String[] {"companyId"},
			false);

		GlobalVersionUtil.setPersistence(this);
	}

	public void destroy() {
		GlobalVersionUtil.setPersistence(null);

		dummyEntityCache.removeCache(GlobalVersionImpl.class.getName());
	}

	private static final String _SQL_SELECT_GLOBALVERSION =
		"SELECT globalVersion FROM GlobalVersion globalVersion";

	private static final String _SQL_SELECT_GLOBALVERSION_WHERE =
		"SELECT globalVersion FROM GlobalVersion globalVersion WHERE ";

	private static final String _SQL_COUNT_GLOBALVERSION =
		"SELECT COUNT(globalVersion) FROM GlobalVersion globalVersion";

	private static final String _SQL_COUNT_GLOBALVERSION_WHERE =
		"SELECT COUNT(globalVersion) FROM GlobalVersion globalVersion WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "globalVersion.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No GlobalVersion exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No GlobalVersion exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		GlobalVersionPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}