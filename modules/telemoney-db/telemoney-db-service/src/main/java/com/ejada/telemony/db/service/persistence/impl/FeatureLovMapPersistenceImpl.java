/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence.impl;

import com.ejada.telemony.db.exception.NoSuchFeatureLovMapException;
import com.ejada.telemony.db.model.FeatureLovMap;
import com.ejada.telemony.db.model.FeatureLovMapTable;
import com.ejada.telemony.db.model.impl.FeatureLovMapImpl;
import com.ejada.telemony.db.model.impl.FeatureLovMapModelImpl;
import com.ejada.telemony.db.service.persistence.FeatureLovMapPersistence;
import com.ejada.telemony.db.service.persistence.FeatureLovMapUtil;

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
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the feature lov map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FeatureLovMapPersistenceImpl
	extends BasePersistenceImpl<FeatureLovMap>
	implements FeatureLovMapPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FeatureLovMapUtil</code> to access the feature lov map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FeatureLovMapImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByFeatureId;
	private FinderPath _finderPathWithoutPaginationFindByFeatureId;
	private FinderPath _finderPathCountByFeatureId;

	/**
	 * Returns all the feature lov maps where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @return the matching feature lov maps
	 */
	@Override
	public List<FeatureLovMap> findByFeatureId(long featureId) {
		return findByFeatureId(
			featureId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the feature lov maps where featureId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureLovMapModelImpl</code>.
	 * </p>
	 *
	 * @param featureId the feature ID
	 * @param start the lower bound of the range of feature lov maps
	 * @param end the upper bound of the range of feature lov maps (not inclusive)
	 * @return the range of matching feature lov maps
	 */
	@Override
	public List<FeatureLovMap> findByFeatureId(
		long featureId, int start, int end) {

		return findByFeatureId(featureId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the feature lov maps where featureId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureLovMapModelImpl</code>.
	 * </p>
	 *
	 * @param featureId the feature ID
	 * @param start the lower bound of the range of feature lov maps
	 * @param end the upper bound of the range of feature lov maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching feature lov maps
	 */
	@Override
	public List<FeatureLovMap> findByFeatureId(
		long featureId, int start, int end,
		OrderByComparator<FeatureLovMap> orderByComparator) {

		return findByFeatureId(featureId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the feature lov maps where featureId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureLovMapModelImpl</code>.
	 * </p>
	 *
	 * @param featureId the feature ID
	 * @param start the lower bound of the range of feature lov maps
	 * @param end the upper bound of the range of feature lov maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching feature lov maps
	 */
	@Override
	public List<FeatureLovMap> findByFeatureId(
		long featureId, int start, int end,
		OrderByComparator<FeatureLovMap> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFeatureId;
				finderArgs = new Object[] {featureId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFeatureId;
			finderArgs = new Object[] {
				featureId, start, end, orderByComparator
			};
		}

		List<FeatureLovMap> list = null;

		if (useFinderCache) {
			list = (List<FeatureLovMap>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FeatureLovMap featureLovMap : list) {
					if (featureId != featureLovMap.getFeatureId()) {
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

			sb.append(_SQL_SELECT_FEATURELOVMAP_WHERE);

			sb.append(_FINDER_COLUMN_FEATUREID_FEATUREID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FeatureLovMapModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(featureId);

				list = (List<FeatureLovMap>)QueryUtil.list(
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
	 * Returns the first feature lov map in the ordered set where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature lov map
	 * @throws NoSuchFeatureLovMapException if a matching feature lov map could not be found
	 */
	@Override
	public FeatureLovMap findByFeatureId_First(
			long featureId, OrderByComparator<FeatureLovMap> orderByComparator)
		throws NoSuchFeatureLovMapException {

		FeatureLovMap featureLovMap = fetchByFeatureId_First(
			featureId, orderByComparator);

		if (featureLovMap != null) {
			return featureLovMap;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("featureId=");
		sb.append(featureId);

		sb.append("}");

		throw new NoSuchFeatureLovMapException(sb.toString());
	}

	/**
	 * Returns the first feature lov map in the ordered set where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature lov map, or <code>null</code> if a matching feature lov map could not be found
	 */
	@Override
	public FeatureLovMap fetchByFeatureId_First(
		long featureId, OrderByComparator<FeatureLovMap> orderByComparator) {

		List<FeatureLovMap> list = findByFeatureId(
			featureId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last feature lov map in the ordered set where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature lov map
	 * @throws NoSuchFeatureLovMapException if a matching feature lov map could not be found
	 */
	@Override
	public FeatureLovMap findByFeatureId_Last(
			long featureId, OrderByComparator<FeatureLovMap> orderByComparator)
		throws NoSuchFeatureLovMapException {

		FeatureLovMap featureLovMap = fetchByFeatureId_Last(
			featureId, orderByComparator);

		if (featureLovMap != null) {
			return featureLovMap;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("featureId=");
		sb.append(featureId);

		sb.append("}");

		throw new NoSuchFeatureLovMapException(sb.toString());
	}

	/**
	 * Returns the last feature lov map in the ordered set where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature lov map, or <code>null</code> if a matching feature lov map could not be found
	 */
	@Override
	public FeatureLovMap fetchByFeatureId_Last(
		long featureId, OrderByComparator<FeatureLovMap> orderByComparator) {

		int count = countByFeatureId(featureId);

		if (count == 0) {
			return null;
		}

		List<FeatureLovMap> list = findByFeatureId(
			featureId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the feature lov maps before and after the current feature lov map in the ordered set where featureId = &#63;.
	 *
	 * @param id the primary key of the current feature lov map
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next feature lov map
	 * @throws NoSuchFeatureLovMapException if a feature lov map with the primary key could not be found
	 */
	@Override
	public FeatureLovMap[] findByFeatureId_PrevAndNext(
			long id, long featureId,
			OrderByComparator<FeatureLovMap> orderByComparator)
		throws NoSuchFeatureLovMapException {

		FeatureLovMap featureLovMap = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			FeatureLovMap[] array = new FeatureLovMapImpl[3];

			array[0] = getByFeatureId_PrevAndNext(
				session, featureLovMap, featureId, orderByComparator, true);

			array[1] = featureLovMap;

			array[2] = getByFeatureId_PrevAndNext(
				session, featureLovMap, featureId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FeatureLovMap getByFeatureId_PrevAndNext(
		Session session, FeatureLovMap featureLovMap, long featureId,
		OrderByComparator<FeatureLovMap> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_FEATURELOVMAP_WHERE);

		sb.append(_FINDER_COLUMN_FEATUREID_FEATUREID_2);

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
			sb.append(FeatureLovMapModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(featureId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						featureLovMap)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FeatureLovMap> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the feature lov maps where featureId = &#63; from the database.
	 *
	 * @param featureId the feature ID
	 */
	@Override
	public void removeByFeatureId(long featureId) {
		for (FeatureLovMap featureLovMap :
				findByFeatureId(
					featureId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(featureLovMap);
		}
	}

	/**
	 * Returns the number of feature lov maps where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @return the number of matching feature lov maps
	 */
	@Override
	public int countByFeatureId(long featureId) {
		FinderPath finderPath = _finderPathCountByFeatureId;

		Object[] finderArgs = new Object[] {featureId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FEATURELOVMAP_WHERE);

			sb.append(_FINDER_COLUMN_FEATUREID_FEATUREID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(featureId);

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

	private static final String _FINDER_COLUMN_FEATUREID_FEATUREID_2 =
		"featureLovMap.featureId = ?";

	private FinderPath _finderPathWithPaginationFindByFeatureEntityResourceId;
	private FinderPath
		_finderPathWithoutPaginationFindByFeatureEntityResourceId;
	private FinderPath _finderPathCountByFeatureEntityResourceId;

	/**
	 * Returns all the feature lov maps where featureEntityResourceId = &#63;.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @return the matching feature lov maps
	 */
	@Override
	public List<FeatureLovMap> findByFeatureEntityResourceId(
		long featureEntityResourceId) {

		return findByFeatureEntityResourceId(
			featureEntityResourceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the feature lov maps where featureEntityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureLovMapModelImpl</code>.
	 * </p>
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param start the lower bound of the range of feature lov maps
	 * @param end the upper bound of the range of feature lov maps (not inclusive)
	 * @return the range of matching feature lov maps
	 */
	@Override
	public List<FeatureLovMap> findByFeatureEntityResourceId(
		long featureEntityResourceId, int start, int end) {

		return findByFeatureEntityResourceId(
			featureEntityResourceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the feature lov maps where featureEntityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureLovMapModelImpl</code>.
	 * </p>
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param start the lower bound of the range of feature lov maps
	 * @param end the upper bound of the range of feature lov maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching feature lov maps
	 */
	@Override
	public List<FeatureLovMap> findByFeatureEntityResourceId(
		long featureEntityResourceId, int start, int end,
		OrderByComparator<FeatureLovMap> orderByComparator) {

		return findByFeatureEntityResourceId(
			featureEntityResourceId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the feature lov maps where featureEntityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureLovMapModelImpl</code>.
	 * </p>
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param start the lower bound of the range of feature lov maps
	 * @param end the upper bound of the range of feature lov maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching feature lov maps
	 */
	@Override
	public List<FeatureLovMap> findByFeatureEntityResourceId(
		long featureEntityResourceId, int start, int end,
		OrderByComparator<FeatureLovMap> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByFeatureEntityResourceId;
				finderArgs = new Object[] {featureEntityResourceId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFeatureEntityResourceId;
			finderArgs = new Object[] {
				featureEntityResourceId, start, end, orderByComparator
			};
		}

		List<FeatureLovMap> list = null;

		if (useFinderCache) {
			list = (List<FeatureLovMap>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FeatureLovMap featureLovMap : list) {
					if (featureEntityResourceId !=
							featureLovMap.getFeatureEntityResourceId()) {

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

			sb.append(_SQL_SELECT_FEATURELOVMAP_WHERE);

			sb.append(
				_FINDER_COLUMN_FEATUREENTITYRESOURCEID_FEATUREENTITYRESOURCEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FeatureLovMapModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(featureEntityResourceId);

				list = (List<FeatureLovMap>)QueryUtil.list(
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
	 * Returns the first feature lov map in the ordered set where featureEntityResourceId = &#63;.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature lov map
	 * @throws NoSuchFeatureLovMapException if a matching feature lov map could not be found
	 */
	@Override
	public FeatureLovMap findByFeatureEntityResourceId_First(
			long featureEntityResourceId,
			OrderByComparator<FeatureLovMap> orderByComparator)
		throws NoSuchFeatureLovMapException {

		FeatureLovMap featureLovMap = fetchByFeatureEntityResourceId_First(
			featureEntityResourceId, orderByComparator);

		if (featureLovMap != null) {
			return featureLovMap;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("featureEntityResourceId=");
		sb.append(featureEntityResourceId);

		sb.append("}");

		throw new NoSuchFeatureLovMapException(sb.toString());
	}

	/**
	 * Returns the first feature lov map in the ordered set where featureEntityResourceId = &#63;.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature lov map, or <code>null</code> if a matching feature lov map could not be found
	 */
	@Override
	public FeatureLovMap fetchByFeatureEntityResourceId_First(
		long featureEntityResourceId,
		OrderByComparator<FeatureLovMap> orderByComparator) {

		List<FeatureLovMap> list = findByFeatureEntityResourceId(
			featureEntityResourceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last feature lov map in the ordered set where featureEntityResourceId = &#63;.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature lov map
	 * @throws NoSuchFeatureLovMapException if a matching feature lov map could not be found
	 */
	@Override
	public FeatureLovMap findByFeatureEntityResourceId_Last(
			long featureEntityResourceId,
			OrderByComparator<FeatureLovMap> orderByComparator)
		throws NoSuchFeatureLovMapException {

		FeatureLovMap featureLovMap = fetchByFeatureEntityResourceId_Last(
			featureEntityResourceId, orderByComparator);

		if (featureLovMap != null) {
			return featureLovMap;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("featureEntityResourceId=");
		sb.append(featureEntityResourceId);

		sb.append("}");

		throw new NoSuchFeatureLovMapException(sb.toString());
	}

	/**
	 * Returns the last feature lov map in the ordered set where featureEntityResourceId = &#63;.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature lov map, or <code>null</code> if a matching feature lov map could not be found
	 */
	@Override
	public FeatureLovMap fetchByFeatureEntityResourceId_Last(
		long featureEntityResourceId,
		OrderByComparator<FeatureLovMap> orderByComparator) {

		int count = countByFeatureEntityResourceId(featureEntityResourceId);

		if (count == 0) {
			return null;
		}

		List<FeatureLovMap> list = findByFeatureEntityResourceId(
			featureEntityResourceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the feature lov maps before and after the current feature lov map in the ordered set where featureEntityResourceId = &#63;.
	 *
	 * @param id the primary key of the current feature lov map
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next feature lov map
	 * @throws NoSuchFeatureLovMapException if a feature lov map with the primary key could not be found
	 */
	@Override
	public FeatureLovMap[] findByFeatureEntityResourceId_PrevAndNext(
			long id, long featureEntityResourceId,
			OrderByComparator<FeatureLovMap> orderByComparator)
		throws NoSuchFeatureLovMapException {

		FeatureLovMap featureLovMap = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			FeatureLovMap[] array = new FeatureLovMapImpl[3];

			array[0] = getByFeatureEntityResourceId_PrevAndNext(
				session, featureLovMap, featureEntityResourceId,
				orderByComparator, true);

			array[1] = featureLovMap;

			array[2] = getByFeatureEntityResourceId_PrevAndNext(
				session, featureLovMap, featureEntityResourceId,
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

	protected FeatureLovMap getByFeatureEntityResourceId_PrevAndNext(
		Session session, FeatureLovMap featureLovMap,
		long featureEntityResourceId,
		OrderByComparator<FeatureLovMap> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_FEATURELOVMAP_WHERE);

		sb.append(
			_FINDER_COLUMN_FEATUREENTITYRESOURCEID_FEATUREENTITYRESOURCEID_2);

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
			sb.append(FeatureLovMapModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(featureEntityResourceId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						featureLovMap)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FeatureLovMap> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the feature lov maps where featureEntityResourceId = &#63; from the database.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 */
	@Override
	public void removeByFeatureEntityResourceId(long featureEntityResourceId) {
		for (FeatureLovMap featureLovMap :
				findByFeatureEntityResourceId(
					featureEntityResourceId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(featureLovMap);
		}
	}

	/**
	 * Returns the number of feature lov maps where featureEntityResourceId = &#63;.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @return the number of matching feature lov maps
	 */
	@Override
	public int countByFeatureEntityResourceId(long featureEntityResourceId) {
		FinderPath finderPath = _finderPathCountByFeatureEntityResourceId;

		Object[] finderArgs = new Object[] {featureEntityResourceId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FEATURELOVMAP_WHERE);

			sb.append(
				_FINDER_COLUMN_FEATUREENTITYRESOURCEID_FEATUREENTITYRESOURCEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(featureEntityResourceId);

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
		_FINDER_COLUMN_FEATUREENTITYRESOURCEID_FEATUREENTITYRESOURCEID_2 =
			"featureLovMap.featureEntityResourceId = ?";

	private FinderPath _finderPathWithPaginationFindByFeatureIdAndLovType;
	private FinderPath _finderPathWithoutPaginationFindByFeatureIdAndLovType;
	private FinderPath _finderPathCountByFeatureIdAndLovType;

	/**
	 * Returns all the feature lov maps where featureId = &#63; and lovType = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param lovType the lov type
	 * @return the matching feature lov maps
	 */
	@Override
	public List<FeatureLovMap> findByFeatureIdAndLovType(
		long featureId, String lovType) {

		return findByFeatureIdAndLovType(
			featureId, lovType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the feature lov maps where featureId = &#63; and lovType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureLovMapModelImpl</code>.
	 * </p>
	 *
	 * @param featureId the feature ID
	 * @param lovType the lov type
	 * @param start the lower bound of the range of feature lov maps
	 * @param end the upper bound of the range of feature lov maps (not inclusive)
	 * @return the range of matching feature lov maps
	 */
	@Override
	public List<FeatureLovMap> findByFeatureIdAndLovType(
		long featureId, String lovType, int start, int end) {

		return findByFeatureIdAndLovType(featureId, lovType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the feature lov maps where featureId = &#63; and lovType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureLovMapModelImpl</code>.
	 * </p>
	 *
	 * @param featureId the feature ID
	 * @param lovType the lov type
	 * @param start the lower bound of the range of feature lov maps
	 * @param end the upper bound of the range of feature lov maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching feature lov maps
	 */
	@Override
	public List<FeatureLovMap> findByFeatureIdAndLovType(
		long featureId, String lovType, int start, int end,
		OrderByComparator<FeatureLovMap> orderByComparator) {

		return findByFeatureIdAndLovType(
			featureId, lovType, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the feature lov maps where featureId = &#63; and lovType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureLovMapModelImpl</code>.
	 * </p>
	 *
	 * @param featureId the feature ID
	 * @param lovType the lov type
	 * @param start the lower bound of the range of feature lov maps
	 * @param end the upper bound of the range of feature lov maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching feature lov maps
	 */
	@Override
	public List<FeatureLovMap> findByFeatureIdAndLovType(
		long featureId, String lovType, int start, int end,
		OrderByComparator<FeatureLovMap> orderByComparator,
		boolean useFinderCache) {

		lovType = Objects.toString(lovType, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByFeatureIdAndLovType;
				finderArgs = new Object[] {featureId, lovType};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFeatureIdAndLovType;
			finderArgs = new Object[] {
				featureId, lovType, start, end, orderByComparator
			};
		}

		List<FeatureLovMap> list = null;

		if (useFinderCache) {
			list = (List<FeatureLovMap>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FeatureLovMap featureLovMap : list) {
					if ((featureId != featureLovMap.getFeatureId()) ||
						!lovType.equals(featureLovMap.getLovType())) {

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

			sb.append(_SQL_SELECT_FEATURELOVMAP_WHERE);

			sb.append(_FINDER_COLUMN_FEATUREIDANDLOVTYPE_FEATUREID_2);

			boolean bindLovType = false;

			if (lovType.isEmpty()) {
				sb.append(_FINDER_COLUMN_FEATUREIDANDLOVTYPE_LOVTYPE_3);
			}
			else {
				bindLovType = true;

				sb.append(_FINDER_COLUMN_FEATUREIDANDLOVTYPE_LOVTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FeatureLovMapModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(featureId);

				if (bindLovType) {
					queryPos.add(lovType);
				}

				list = (List<FeatureLovMap>)QueryUtil.list(
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
	 * Returns the first feature lov map in the ordered set where featureId = &#63; and lovType = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param lovType the lov type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature lov map
	 * @throws NoSuchFeatureLovMapException if a matching feature lov map could not be found
	 */
	@Override
	public FeatureLovMap findByFeatureIdAndLovType_First(
			long featureId, String lovType,
			OrderByComparator<FeatureLovMap> orderByComparator)
		throws NoSuchFeatureLovMapException {

		FeatureLovMap featureLovMap = fetchByFeatureIdAndLovType_First(
			featureId, lovType, orderByComparator);

		if (featureLovMap != null) {
			return featureLovMap;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("featureId=");
		sb.append(featureId);

		sb.append(", lovType=");
		sb.append(lovType);

		sb.append("}");

		throw new NoSuchFeatureLovMapException(sb.toString());
	}

	/**
	 * Returns the first feature lov map in the ordered set where featureId = &#63; and lovType = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param lovType the lov type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature lov map, or <code>null</code> if a matching feature lov map could not be found
	 */
	@Override
	public FeatureLovMap fetchByFeatureIdAndLovType_First(
		long featureId, String lovType,
		OrderByComparator<FeatureLovMap> orderByComparator) {

		List<FeatureLovMap> list = findByFeatureIdAndLovType(
			featureId, lovType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last feature lov map in the ordered set where featureId = &#63; and lovType = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param lovType the lov type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature lov map
	 * @throws NoSuchFeatureLovMapException if a matching feature lov map could not be found
	 */
	@Override
	public FeatureLovMap findByFeatureIdAndLovType_Last(
			long featureId, String lovType,
			OrderByComparator<FeatureLovMap> orderByComparator)
		throws NoSuchFeatureLovMapException {

		FeatureLovMap featureLovMap = fetchByFeatureIdAndLovType_Last(
			featureId, lovType, orderByComparator);

		if (featureLovMap != null) {
			return featureLovMap;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("featureId=");
		sb.append(featureId);

		sb.append(", lovType=");
		sb.append(lovType);

		sb.append("}");

		throw new NoSuchFeatureLovMapException(sb.toString());
	}

	/**
	 * Returns the last feature lov map in the ordered set where featureId = &#63; and lovType = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param lovType the lov type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature lov map, or <code>null</code> if a matching feature lov map could not be found
	 */
	@Override
	public FeatureLovMap fetchByFeatureIdAndLovType_Last(
		long featureId, String lovType,
		OrderByComparator<FeatureLovMap> orderByComparator) {

		int count = countByFeatureIdAndLovType(featureId, lovType);

		if (count == 0) {
			return null;
		}

		List<FeatureLovMap> list = findByFeatureIdAndLovType(
			featureId, lovType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the feature lov maps before and after the current feature lov map in the ordered set where featureId = &#63; and lovType = &#63;.
	 *
	 * @param id the primary key of the current feature lov map
	 * @param featureId the feature ID
	 * @param lovType the lov type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next feature lov map
	 * @throws NoSuchFeatureLovMapException if a feature lov map with the primary key could not be found
	 */
	@Override
	public FeatureLovMap[] findByFeatureIdAndLovType_PrevAndNext(
			long id, long featureId, String lovType,
			OrderByComparator<FeatureLovMap> orderByComparator)
		throws NoSuchFeatureLovMapException {

		lovType = Objects.toString(lovType, "");

		FeatureLovMap featureLovMap = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			FeatureLovMap[] array = new FeatureLovMapImpl[3];

			array[0] = getByFeatureIdAndLovType_PrevAndNext(
				session, featureLovMap, featureId, lovType, orderByComparator,
				true);

			array[1] = featureLovMap;

			array[2] = getByFeatureIdAndLovType_PrevAndNext(
				session, featureLovMap, featureId, lovType, orderByComparator,
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

	protected FeatureLovMap getByFeatureIdAndLovType_PrevAndNext(
		Session session, FeatureLovMap featureLovMap, long featureId,
		String lovType, OrderByComparator<FeatureLovMap> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_FEATURELOVMAP_WHERE);

		sb.append(_FINDER_COLUMN_FEATUREIDANDLOVTYPE_FEATUREID_2);

		boolean bindLovType = false;

		if (lovType.isEmpty()) {
			sb.append(_FINDER_COLUMN_FEATUREIDANDLOVTYPE_LOVTYPE_3);
		}
		else {
			bindLovType = true;

			sb.append(_FINDER_COLUMN_FEATUREIDANDLOVTYPE_LOVTYPE_2);
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
			sb.append(FeatureLovMapModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(featureId);

		if (bindLovType) {
			queryPos.add(lovType);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						featureLovMap)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FeatureLovMap> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the feature lov maps where featureId = &#63; and lovType = &#63; from the database.
	 *
	 * @param featureId the feature ID
	 * @param lovType the lov type
	 */
	@Override
	public void removeByFeatureIdAndLovType(long featureId, String lovType) {
		for (FeatureLovMap featureLovMap :
				findByFeatureIdAndLovType(
					featureId, lovType, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(featureLovMap);
		}
	}

	/**
	 * Returns the number of feature lov maps where featureId = &#63; and lovType = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param lovType the lov type
	 * @return the number of matching feature lov maps
	 */
	@Override
	public int countByFeatureIdAndLovType(long featureId, String lovType) {
		lovType = Objects.toString(lovType, "");

		FinderPath finderPath = _finderPathCountByFeatureIdAndLovType;

		Object[] finderArgs = new Object[] {featureId, lovType};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FEATURELOVMAP_WHERE);

			sb.append(_FINDER_COLUMN_FEATUREIDANDLOVTYPE_FEATUREID_2);

			boolean bindLovType = false;

			if (lovType.isEmpty()) {
				sb.append(_FINDER_COLUMN_FEATUREIDANDLOVTYPE_LOVTYPE_3);
			}
			else {
				bindLovType = true;

				sb.append(_FINDER_COLUMN_FEATUREIDANDLOVTYPE_LOVTYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(featureId);

				if (bindLovType) {
					queryPos.add(lovType);
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

	private static final String _FINDER_COLUMN_FEATUREIDANDLOVTYPE_FEATUREID_2 =
		"featureLovMap.featureId = ? AND ";

	private static final String _FINDER_COLUMN_FEATUREIDANDLOVTYPE_LOVTYPE_2 =
		"featureLovMap.lovType = ?";

	private static final String _FINDER_COLUMN_FEATUREIDANDLOVTYPE_LOVTYPE_3 =
		"(featureLovMap.lovType IS NULL OR featureLovMap.lovType = '')";

	private FinderPath
		_finderPathWithPaginationFindByFeatureEntityResourceIdAndLovType;
	private FinderPath
		_finderPathWithoutPaginationFindByFeatureEntityResourceIdAndLovType;
	private FinderPath _finderPathCountByFeatureEntityResourceIdAndLovType;

	/**
	 * Returns all the feature lov maps where featureEntityResourceId = &#63; and lovType = &#63;.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param lovType the lov type
	 * @return the matching feature lov maps
	 */
	@Override
	public List<FeatureLovMap> findByFeatureEntityResourceIdAndLovType(
		long featureEntityResourceId, String lovType) {

		return findByFeatureEntityResourceIdAndLovType(
			featureEntityResourceId, lovType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the feature lov maps where featureEntityResourceId = &#63; and lovType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureLovMapModelImpl</code>.
	 * </p>
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param lovType the lov type
	 * @param start the lower bound of the range of feature lov maps
	 * @param end the upper bound of the range of feature lov maps (not inclusive)
	 * @return the range of matching feature lov maps
	 */
	@Override
	public List<FeatureLovMap> findByFeatureEntityResourceIdAndLovType(
		long featureEntityResourceId, String lovType, int start, int end) {

		return findByFeatureEntityResourceIdAndLovType(
			featureEntityResourceId, lovType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the feature lov maps where featureEntityResourceId = &#63; and lovType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureLovMapModelImpl</code>.
	 * </p>
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param lovType the lov type
	 * @param start the lower bound of the range of feature lov maps
	 * @param end the upper bound of the range of feature lov maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching feature lov maps
	 */
	@Override
	public List<FeatureLovMap> findByFeatureEntityResourceIdAndLovType(
		long featureEntityResourceId, String lovType, int start, int end,
		OrderByComparator<FeatureLovMap> orderByComparator) {

		return findByFeatureEntityResourceIdAndLovType(
			featureEntityResourceId, lovType, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the feature lov maps where featureEntityResourceId = &#63; and lovType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureLovMapModelImpl</code>.
	 * </p>
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param lovType the lov type
	 * @param start the lower bound of the range of feature lov maps
	 * @param end the upper bound of the range of feature lov maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching feature lov maps
	 */
	@Override
	public List<FeatureLovMap> findByFeatureEntityResourceIdAndLovType(
		long featureEntityResourceId, String lovType, int start, int end,
		OrderByComparator<FeatureLovMap> orderByComparator,
		boolean useFinderCache) {

		lovType = Objects.toString(lovType, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByFeatureEntityResourceIdAndLovType;
				finderArgs = new Object[] {featureEntityResourceId, lovType};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByFeatureEntityResourceIdAndLovType;
			finderArgs = new Object[] {
				featureEntityResourceId, lovType, start, end, orderByComparator
			};
		}

		List<FeatureLovMap> list = null;

		if (useFinderCache) {
			list = (List<FeatureLovMap>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FeatureLovMap featureLovMap : list) {
					if ((featureEntityResourceId !=
							featureLovMap.getFeatureEntityResourceId()) ||
						!lovType.equals(featureLovMap.getLovType())) {

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

			sb.append(_SQL_SELECT_FEATURELOVMAP_WHERE);

			sb.append(
				_FINDER_COLUMN_FEATUREENTITYRESOURCEIDANDLOVTYPE_FEATUREENTITYRESOURCEID_2);

			boolean bindLovType = false;

			if (lovType.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_FEATUREENTITYRESOURCEIDANDLOVTYPE_LOVTYPE_3);
			}
			else {
				bindLovType = true;

				sb.append(
					_FINDER_COLUMN_FEATUREENTITYRESOURCEIDANDLOVTYPE_LOVTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FeatureLovMapModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(featureEntityResourceId);

				if (bindLovType) {
					queryPos.add(lovType);
				}

				list = (List<FeatureLovMap>)QueryUtil.list(
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
	 * Returns the first feature lov map in the ordered set where featureEntityResourceId = &#63; and lovType = &#63;.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param lovType the lov type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature lov map
	 * @throws NoSuchFeatureLovMapException if a matching feature lov map could not be found
	 */
	@Override
	public FeatureLovMap findByFeatureEntityResourceIdAndLovType_First(
			long featureEntityResourceId, String lovType,
			OrderByComparator<FeatureLovMap> orderByComparator)
		throws NoSuchFeatureLovMapException {

		FeatureLovMap featureLovMap =
			fetchByFeatureEntityResourceIdAndLovType_First(
				featureEntityResourceId, lovType, orderByComparator);

		if (featureLovMap != null) {
			return featureLovMap;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("featureEntityResourceId=");
		sb.append(featureEntityResourceId);

		sb.append(", lovType=");
		sb.append(lovType);

		sb.append("}");

		throw new NoSuchFeatureLovMapException(sb.toString());
	}

	/**
	 * Returns the first feature lov map in the ordered set where featureEntityResourceId = &#63; and lovType = &#63;.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param lovType the lov type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature lov map, or <code>null</code> if a matching feature lov map could not be found
	 */
	@Override
	public FeatureLovMap fetchByFeatureEntityResourceIdAndLovType_First(
		long featureEntityResourceId, String lovType,
		OrderByComparator<FeatureLovMap> orderByComparator) {

		List<FeatureLovMap> list = findByFeatureEntityResourceIdAndLovType(
			featureEntityResourceId, lovType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last feature lov map in the ordered set where featureEntityResourceId = &#63; and lovType = &#63;.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param lovType the lov type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature lov map
	 * @throws NoSuchFeatureLovMapException if a matching feature lov map could not be found
	 */
	@Override
	public FeatureLovMap findByFeatureEntityResourceIdAndLovType_Last(
			long featureEntityResourceId, String lovType,
			OrderByComparator<FeatureLovMap> orderByComparator)
		throws NoSuchFeatureLovMapException {

		FeatureLovMap featureLovMap =
			fetchByFeatureEntityResourceIdAndLovType_Last(
				featureEntityResourceId, lovType, orderByComparator);

		if (featureLovMap != null) {
			return featureLovMap;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("featureEntityResourceId=");
		sb.append(featureEntityResourceId);

		sb.append(", lovType=");
		sb.append(lovType);

		sb.append("}");

		throw new NoSuchFeatureLovMapException(sb.toString());
	}

	/**
	 * Returns the last feature lov map in the ordered set where featureEntityResourceId = &#63; and lovType = &#63;.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param lovType the lov type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature lov map, or <code>null</code> if a matching feature lov map could not be found
	 */
	@Override
	public FeatureLovMap fetchByFeatureEntityResourceIdAndLovType_Last(
		long featureEntityResourceId, String lovType,
		OrderByComparator<FeatureLovMap> orderByComparator) {

		int count = countByFeatureEntityResourceIdAndLovType(
			featureEntityResourceId, lovType);

		if (count == 0) {
			return null;
		}

		List<FeatureLovMap> list = findByFeatureEntityResourceIdAndLovType(
			featureEntityResourceId, lovType, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the feature lov maps before and after the current feature lov map in the ordered set where featureEntityResourceId = &#63; and lovType = &#63;.
	 *
	 * @param id the primary key of the current feature lov map
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param lovType the lov type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next feature lov map
	 * @throws NoSuchFeatureLovMapException if a feature lov map with the primary key could not be found
	 */
	@Override
	public FeatureLovMap[] findByFeatureEntityResourceIdAndLovType_PrevAndNext(
			long id, long featureEntityResourceId, String lovType,
			OrderByComparator<FeatureLovMap> orderByComparator)
		throws NoSuchFeatureLovMapException {

		lovType = Objects.toString(lovType, "");

		FeatureLovMap featureLovMap = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			FeatureLovMap[] array = new FeatureLovMapImpl[3];

			array[0] = getByFeatureEntityResourceIdAndLovType_PrevAndNext(
				session, featureLovMap, featureEntityResourceId, lovType,
				orderByComparator, true);

			array[1] = featureLovMap;

			array[2] = getByFeatureEntityResourceIdAndLovType_PrevAndNext(
				session, featureLovMap, featureEntityResourceId, lovType,
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

	protected FeatureLovMap getByFeatureEntityResourceIdAndLovType_PrevAndNext(
		Session session, FeatureLovMap featureLovMap,
		long featureEntityResourceId, String lovType,
		OrderByComparator<FeatureLovMap> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_FEATURELOVMAP_WHERE);

		sb.append(
			_FINDER_COLUMN_FEATUREENTITYRESOURCEIDANDLOVTYPE_FEATUREENTITYRESOURCEID_2);

		boolean bindLovType = false;

		if (lovType.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_FEATUREENTITYRESOURCEIDANDLOVTYPE_LOVTYPE_3);
		}
		else {
			bindLovType = true;

			sb.append(
				_FINDER_COLUMN_FEATUREENTITYRESOURCEIDANDLOVTYPE_LOVTYPE_2);
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
			sb.append(FeatureLovMapModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(featureEntityResourceId);

		if (bindLovType) {
			queryPos.add(lovType);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						featureLovMap)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FeatureLovMap> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the feature lov maps where featureEntityResourceId = &#63; and lovType = &#63; from the database.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param lovType the lov type
	 */
	@Override
	public void removeByFeatureEntityResourceIdAndLovType(
		long featureEntityResourceId, String lovType) {

		for (FeatureLovMap featureLovMap :
				findByFeatureEntityResourceIdAndLovType(
					featureEntityResourceId, lovType, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(featureLovMap);
		}
	}

	/**
	 * Returns the number of feature lov maps where featureEntityResourceId = &#63; and lovType = &#63;.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param lovType the lov type
	 * @return the number of matching feature lov maps
	 */
	@Override
	public int countByFeatureEntityResourceIdAndLovType(
		long featureEntityResourceId, String lovType) {

		lovType = Objects.toString(lovType, "");

		FinderPath finderPath =
			_finderPathCountByFeatureEntityResourceIdAndLovType;

		Object[] finderArgs = new Object[] {featureEntityResourceId, lovType};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FEATURELOVMAP_WHERE);

			sb.append(
				_FINDER_COLUMN_FEATUREENTITYRESOURCEIDANDLOVTYPE_FEATUREENTITYRESOURCEID_2);

			boolean bindLovType = false;

			if (lovType.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_FEATUREENTITYRESOURCEIDANDLOVTYPE_LOVTYPE_3);
			}
			else {
				bindLovType = true;

				sb.append(
					_FINDER_COLUMN_FEATUREENTITYRESOURCEIDANDLOVTYPE_LOVTYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(featureEntityResourceId);

				if (bindLovType) {
					queryPos.add(lovType);
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

	private static final String
		_FINDER_COLUMN_FEATUREENTITYRESOURCEIDANDLOVTYPE_FEATUREENTITYRESOURCEID_2 =
			"featureLovMap.featureEntityResourceId = ? AND ";

	private static final String
		_FINDER_COLUMN_FEATUREENTITYRESOURCEIDANDLOVTYPE_LOVTYPE_2 =
			"featureLovMap.lovType = ?";

	private static final String
		_FINDER_COLUMN_FEATUREENTITYRESOURCEIDANDLOVTYPE_LOVTYPE_3 =
			"(featureLovMap.lovType IS NULL OR featureLovMap.lovType = '')";

	private FinderPath
		_finderPathWithPaginationFindByLovEntityResourceIdAndLovDataCode;
	private FinderPath
		_finderPathWithoutPaginationFindByLovEntityResourceIdAndLovDataCode;
	private FinderPath _finderPathCountByLovEntityResourceIdAndLovDataCode;

	/**
	 * Returns all the feature lov maps where lovEntityResourceId = &#63; and lovDataCode = &#63;.
	 *
	 * @param lovEntityResourceId the lov entity resource ID
	 * @param lovDataCode the lov data code
	 * @return the matching feature lov maps
	 */
	@Override
	public List<FeatureLovMap> findByLovEntityResourceIdAndLovDataCode(
		long lovEntityResourceId, String lovDataCode) {

		return findByLovEntityResourceIdAndLovDataCode(
			lovEntityResourceId, lovDataCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the feature lov maps where lovEntityResourceId = &#63; and lovDataCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureLovMapModelImpl</code>.
	 * </p>
	 *
	 * @param lovEntityResourceId the lov entity resource ID
	 * @param lovDataCode the lov data code
	 * @param start the lower bound of the range of feature lov maps
	 * @param end the upper bound of the range of feature lov maps (not inclusive)
	 * @return the range of matching feature lov maps
	 */
	@Override
	public List<FeatureLovMap> findByLovEntityResourceIdAndLovDataCode(
		long lovEntityResourceId, String lovDataCode, int start, int end) {

		return findByLovEntityResourceIdAndLovDataCode(
			lovEntityResourceId, lovDataCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the feature lov maps where lovEntityResourceId = &#63; and lovDataCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureLovMapModelImpl</code>.
	 * </p>
	 *
	 * @param lovEntityResourceId the lov entity resource ID
	 * @param lovDataCode the lov data code
	 * @param start the lower bound of the range of feature lov maps
	 * @param end the upper bound of the range of feature lov maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching feature lov maps
	 */
	@Override
	public List<FeatureLovMap> findByLovEntityResourceIdAndLovDataCode(
		long lovEntityResourceId, String lovDataCode, int start, int end,
		OrderByComparator<FeatureLovMap> orderByComparator) {

		return findByLovEntityResourceIdAndLovDataCode(
			lovEntityResourceId, lovDataCode, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the feature lov maps where lovEntityResourceId = &#63; and lovDataCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureLovMapModelImpl</code>.
	 * </p>
	 *
	 * @param lovEntityResourceId the lov entity resource ID
	 * @param lovDataCode the lov data code
	 * @param start the lower bound of the range of feature lov maps
	 * @param end the upper bound of the range of feature lov maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching feature lov maps
	 */
	@Override
	public List<FeatureLovMap> findByLovEntityResourceIdAndLovDataCode(
		long lovEntityResourceId, String lovDataCode, int start, int end,
		OrderByComparator<FeatureLovMap> orderByComparator,
		boolean useFinderCache) {

		lovDataCode = Objects.toString(lovDataCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByLovEntityResourceIdAndLovDataCode;
				finderArgs = new Object[] {lovEntityResourceId, lovDataCode};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByLovEntityResourceIdAndLovDataCode;
			finderArgs = new Object[] {
				lovEntityResourceId, lovDataCode, start, end, orderByComparator
			};
		}

		List<FeatureLovMap> list = null;

		if (useFinderCache) {
			list = (List<FeatureLovMap>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FeatureLovMap featureLovMap : list) {
					if ((lovEntityResourceId !=
							featureLovMap.getLovEntityResourceId()) ||
						!lovDataCode.equals(featureLovMap.getLovDataCode())) {

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

			sb.append(_SQL_SELECT_FEATURELOVMAP_WHERE);

			sb.append(
				_FINDER_COLUMN_LOVENTITYRESOURCEIDANDLOVDATACODE_LOVENTITYRESOURCEID_2);

			boolean bindLovDataCode = false;

			if (lovDataCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_LOVENTITYRESOURCEIDANDLOVDATACODE_LOVDATACODE_3);
			}
			else {
				bindLovDataCode = true;

				sb.append(
					_FINDER_COLUMN_LOVENTITYRESOURCEIDANDLOVDATACODE_LOVDATACODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FeatureLovMapModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(lovEntityResourceId);

				if (bindLovDataCode) {
					queryPos.add(lovDataCode);
				}

				list = (List<FeatureLovMap>)QueryUtil.list(
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
	 * Returns the first feature lov map in the ordered set where lovEntityResourceId = &#63; and lovDataCode = &#63;.
	 *
	 * @param lovEntityResourceId the lov entity resource ID
	 * @param lovDataCode the lov data code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature lov map
	 * @throws NoSuchFeatureLovMapException if a matching feature lov map could not be found
	 */
	@Override
	public FeatureLovMap findByLovEntityResourceIdAndLovDataCode_First(
			long lovEntityResourceId, String lovDataCode,
			OrderByComparator<FeatureLovMap> orderByComparator)
		throws NoSuchFeatureLovMapException {

		FeatureLovMap featureLovMap =
			fetchByLovEntityResourceIdAndLovDataCode_First(
				lovEntityResourceId, lovDataCode, orderByComparator);

		if (featureLovMap != null) {
			return featureLovMap;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("lovEntityResourceId=");
		sb.append(lovEntityResourceId);

		sb.append(", lovDataCode=");
		sb.append(lovDataCode);

		sb.append("}");

		throw new NoSuchFeatureLovMapException(sb.toString());
	}

	/**
	 * Returns the first feature lov map in the ordered set where lovEntityResourceId = &#63; and lovDataCode = &#63;.
	 *
	 * @param lovEntityResourceId the lov entity resource ID
	 * @param lovDataCode the lov data code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature lov map, or <code>null</code> if a matching feature lov map could not be found
	 */
	@Override
	public FeatureLovMap fetchByLovEntityResourceIdAndLovDataCode_First(
		long lovEntityResourceId, String lovDataCode,
		OrderByComparator<FeatureLovMap> orderByComparator) {

		List<FeatureLovMap> list = findByLovEntityResourceIdAndLovDataCode(
			lovEntityResourceId, lovDataCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last feature lov map in the ordered set where lovEntityResourceId = &#63; and lovDataCode = &#63;.
	 *
	 * @param lovEntityResourceId the lov entity resource ID
	 * @param lovDataCode the lov data code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature lov map
	 * @throws NoSuchFeatureLovMapException if a matching feature lov map could not be found
	 */
	@Override
	public FeatureLovMap findByLovEntityResourceIdAndLovDataCode_Last(
			long lovEntityResourceId, String lovDataCode,
			OrderByComparator<FeatureLovMap> orderByComparator)
		throws NoSuchFeatureLovMapException {

		FeatureLovMap featureLovMap =
			fetchByLovEntityResourceIdAndLovDataCode_Last(
				lovEntityResourceId, lovDataCode, orderByComparator);

		if (featureLovMap != null) {
			return featureLovMap;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("lovEntityResourceId=");
		sb.append(lovEntityResourceId);

		sb.append(", lovDataCode=");
		sb.append(lovDataCode);

		sb.append("}");

		throw new NoSuchFeatureLovMapException(sb.toString());
	}

	/**
	 * Returns the last feature lov map in the ordered set where lovEntityResourceId = &#63; and lovDataCode = &#63;.
	 *
	 * @param lovEntityResourceId the lov entity resource ID
	 * @param lovDataCode the lov data code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature lov map, or <code>null</code> if a matching feature lov map could not be found
	 */
	@Override
	public FeatureLovMap fetchByLovEntityResourceIdAndLovDataCode_Last(
		long lovEntityResourceId, String lovDataCode,
		OrderByComparator<FeatureLovMap> orderByComparator) {

		int count = countByLovEntityResourceIdAndLovDataCode(
			lovEntityResourceId, lovDataCode);

		if (count == 0) {
			return null;
		}

		List<FeatureLovMap> list = findByLovEntityResourceIdAndLovDataCode(
			lovEntityResourceId, lovDataCode, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the feature lov maps before and after the current feature lov map in the ordered set where lovEntityResourceId = &#63; and lovDataCode = &#63;.
	 *
	 * @param id the primary key of the current feature lov map
	 * @param lovEntityResourceId the lov entity resource ID
	 * @param lovDataCode the lov data code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next feature lov map
	 * @throws NoSuchFeatureLovMapException if a feature lov map with the primary key could not be found
	 */
	@Override
	public FeatureLovMap[] findByLovEntityResourceIdAndLovDataCode_PrevAndNext(
			long id, long lovEntityResourceId, String lovDataCode,
			OrderByComparator<FeatureLovMap> orderByComparator)
		throws NoSuchFeatureLovMapException {

		lovDataCode = Objects.toString(lovDataCode, "");

		FeatureLovMap featureLovMap = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			FeatureLovMap[] array = new FeatureLovMapImpl[3];

			array[0] = getByLovEntityResourceIdAndLovDataCode_PrevAndNext(
				session, featureLovMap, lovEntityResourceId, lovDataCode,
				orderByComparator, true);

			array[1] = featureLovMap;

			array[2] = getByLovEntityResourceIdAndLovDataCode_PrevAndNext(
				session, featureLovMap, lovEntityResourceId, lovDataCode,
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

	protected FeatureLovMap getByLovEntityResourceIdAndLovDataCode_PrevAndNext(
		Session session, FeatureLovMap featureLovMap, long lovEntityResourceId,
		String lovDataCode, OrderByComparator<FeatureLovMap> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_FEATURELOVMAP_WHERE);

		sb.append(
			_FINDER_COLUMN_LOVENTITYRESOURCEIDANDLOVDATACODE_LOVENTITYRESOURCEID_2);

		boolean bindLovDataCode = false;

		if (lovDataCode.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_LOVENTITYRESOURCEIDANDLOVDATACODE_LOVDATACODE_3);
		}
		else {
			bindLovDataCode = true;

			sb.append(
				_FINDER_COLUMN_LOVENTITYRESOURCEIDANDLOVDATACODE_LOVDATACODE_2);
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
			sb.append(FeatureLovMapModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(lovEntityResourceId);

		if (bindLovDataCode) {
			queryPos.add(lovDataCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						featureLovMap)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FeatureLovMap> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the feature lov maps where lovEntityResourceId = &#63; and lovDataCode = &#63; from the database.
	 *
	 * @param lovEntityResourceId the lov entity resource ID
	 * @param lovDataCode the lov data code
	 */
	@Override
	public void removeByLovEntityResourceIdAndLovDataCode(
		long lovEntityResourceId, String lovDataCode) {

		for (FeatureLovMap featureLovMap :
				findByLovEntityResourceIdAndLovDataCode(
					lovEntityResourceId, lovDataCode, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(featureLovMap);
		}
	}

	/**
	 * Returns the number of feature lov maps where lovEntityResourceId = &#63; and lovDataCode = &#63;.
	 *
	 * @param lovEntityResourceId the lov entity resource ID
	 * @param lovDataCode the lov data code
	 * @return the number of matching feature lov maps
	 */
	@Override
	public int countByLovEntityResourceIdAndLovDataCode(
		long lovEntityResourceId, String lovDataCode) {

		lovDataCode = Objects.toString(lovDataCode, "");

		FinderPath finderPath =
			_finderPathCountByLovEntityResourceIdAndLovDataCode;

		Object[] finderArgs = new Object[] {lovEntityResourceId, lovDataCode};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FEATURELOVMAP_WHERE);

			sb.append(
				_FINDER_COLUMN_LOVENTITYRESOURCEIDANDLOVDATACODE_LOVENTITYRESOURCEID_2);

			boolean bindLovDataCode = false;

			if (lovDataCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_LOVENTITYRESOURCEIDANDLOVDATACODE_LOVDATACODE_3);
			}
			else {
				bindLovDataCode = true;

				sb.append(
					_FINDER_COLUMN_LOVENTITYRESOURCEIDANDLOVDATACODE_LOVDATACODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(lovEntityResourceId);

				if (bindLovDataCode) {
					queryPos.add(lovDataCode);
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

	private static final String
		_FINDER_COLUMN_LOVENTITYRESOURCEIDANDLOVDATACODE_LOVENTITYRESOURCEID_2 =
			"featureLovMap.lovEntityResourceId = ? AND ";

	private static final String
		_FINDER_COLUMN_LOVENTITYRESOURCEIDANDLOVDATACODE_LOVDATACODE_2 =
			"featureLovMap.lovDataCode = ?";

	private static final String
		_FINDER_COLUMN_LOVENTITYRESOURCEIDANDLOVDATACODE_LOVDATACODE_3 =
			"(featureLovMap.lovDataCode IS NULL OR featureLovMap.lovDataCode = '')";

	public FeatureLovMapPersistenceImpl() {
		setModelClass(FeatureLovMap.class);

		setModelImplClass(FeatureLovMapImpl.class);
		setModelPKClass(long.class);

		setTable(FeatureLovMapTable.INSTANCE);
	}

	/**
	 * Caches the feature lov map in the entity cache if it is enabled.
	 *
	 * @param featureLovMap the feature lov map
	 */
	@Override
	public void cacheResult(FeatureLovMap featureLovMap) {
		dummyEntityCache.putResult(
			FeatureLovMapImpl.class, featureLovMap.getPrimaryKey(),
			featureLovMap);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the feature lov maps in the entity cache if it is enabled.
	 *
	 * @param featureLovMaps the feature lov maps
	 */
	@Override
	public void cacheResult(List<FeatureLovMap> featureLovMaps) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (featureLovMaps.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (FeatureLovMap featureLovMap : featureLovMaps) {
			if (dummyEntityCache.getResult(
					FeatureLovMapImpl.class, featureLovMap.getPrimaryKey()) ==
						null) {

				cacheResult(featureLovMap);
			}
		}
	}

	/**
	 * Clears the cache for all feature lov maps.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(FeatureLovMapImpl.class);

		dummyFinderCache.clearCache(FeatureLovMapImpl.class);
	}

	/**
	 * Clears the cache for the feature lov map.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FeatureLovMap featureLovMap) {
		dummyEntityCache.removeResult(FeatureLovMapImpl.class, featureLovMap);
	}

	@Override
	public void clearCache(List<FeatureLovMap> featureLovMaps) {
		for (FeatureLovMap featureLovMap : featureLovMaps) {
			dummyEntityCache.removeResult(
				FeatureLovMapImpl.class, featureLovMap);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FeatureLovMapImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(FeatureLovMapImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new feature lov map with the primary key. Does not add the feature lov map to the database.
	 *
	 * @param id the primary key for the new feature lov map
	 * @return the new feature lov map
	 */
	@Override
	public FeatureLovMap create(long id) {
		FeatureLovMap featureLovMap = new FeatureLovMapImpl();

		featureLovMap.setNew(true);
		featureLovMap.setPrimaryKey(id);

		return featureLovMap;
	}

	/**
	 * Removes the feature lov map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the feature lov map
	 * @return the feature lov map that was removed
	 * @throws NoSuchFeatureLovMapException if a feature lov map with the primary key could not be found
	 */
	@Override
	public FeatureLovMap remove(long id) throws NoSuchFeatureLovMapException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the feature lov map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the feature lov map
	 * @return the feature lov map that was removed
	 * @throws NoSuchFeatureLovMapException if a feature lov map with the primary key could not be found
	 */
	@Override
	public FeatureLovMap remove(Serializable primaryKey)
		throws NoSuchFeatureLovMapException {

		Session session = null;

		try {
			session = openSession();

			FeatureLovMap featureLovMap = (FeatureLovMap)session.get(
				FeatureLovMapImpl.class, primaryKey);

			if (featureLovMap == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFeatureLovMapException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(featureLovMap);
		}
		catch (NoSuchFeatureLovMapException noSuchEntityException) {
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
	protected FeatureLovMap removeImpl(FeatureLovMap featureLovMap) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(featureLovMap)) {
				featureLovMap = (FeatureLovMap)session.get(
					FeatureLovMapImpl.class, featureLovMap.getPrimaryKeyObj());
			}

			if (featureLovMap != null) {
				session.delete(featureLovMap);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (featureLovMap != null) {
			clearCache(featureLovMap);
		}

		return featureLovMap;
	}

	@Override
	public FeatureLovMap updateImpl(FeatureLovMap featureLovMap) {
		boolean isNew = featureLovMap.isNew();

		if (!(featureLovMap instanceof FeatureLovMapModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(featureLovMap.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					featureLovMap);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in featureLovMap proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FeatureLovMap implementation " +
					featureLovMap.getClass());
		}

		FeatureLovMapModelImpl featureLovMapModelImpl =
			(FeatureLovMapModelImpl)featureLovMap;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(featureLovMap);
			}
			else {
				featureLovMap = (FeatureLovMap)session.merge(featureLovMap);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			FeatureLovMapImpl.class, featureLovMapModelImpl, false, true);

		if (isNew) {
			featureLovMap.setNew(false);
		}

		featureLovMap.resetOriginalValues();

		return featureLovMap;
	}

	/**
	 * Returns the feature lov map with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the feature lov map
	 * @return the feature lov map
	 * @throws NoSuchFeatureLovMapException if a feature lov map with the primary key could not be found
	 */
	@Override
	public FeatureLovMap findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFeatureLovMapException {

		FeatureLovMap featureLovMap = fetchByPrimaryKey(primaryKey);

		if (featureLovMap == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFeatureLovMapException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return featureLovMap;
	}

	/**
	 * Returns the feature lov map with the primary key or throws a <code>NoSuchFeatureLovMapException</code> if it could not be found.
	 *
	 * @param id the primary key of the feature lov map
	 * @return the feature lov map
	 * @throws NoSuchFeatureLovMapException if a feature lov map with the primary key could not be found
	 */
	@Override
	public FeatureLovMap findByPrimaryKey(long id)
		throws NoSuchFeatureLovMapException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the feature lov map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the feature lov map
	 * @return the feature lov map, or <code>null</code> if a feature lov map with the primary key could not be found
	 */
	@Override
	public FeatureLovMap fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the feature lov maps.
	 *
	 * @return the feature lov maps
	 */
	@Override
	public List<FeatureLovMap> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the feature lov maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureLovMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of feature lov maps
	 * @param end the upper bound of the range of feature lov maps (not inclusive)
	 * @return the range of feature lov maps
	 */
	@Override
	public List<FeatureLovMap> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the feature lov maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureLovMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of feature lov maps
	 * @param end the upper bound of the range of feature lov maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of feature lov maps
	 */
	@Override
	public List<FeatureLovMap> findAll(
		int start, int end,
		OrderByComparator<FeatureLovMap> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the feature lov maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureLovMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of feature lov maps
	 * @param end the upper bound of the range of feature lov maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of feature lov maps
	 */
	@Override
	public List<FeatureLovMap> findAll(
		int start, int end, OrderByComparator<FeatureLovMap> orderByComparator,
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

		List<FeatureLovMap> list = null;

		if (useFinderCache) {
			list = (List<FeatureLovMap>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FEATURELOVMAP);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FEATURELOVMAP;

				sql = sql.concat(FeatureLovMapModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FeatureLovMap>)QueryUtil.list(
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
	 * Removes all the feature lov maps from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FeatureLovMap featureLovMap : findAll()) {
			remove(featureLovMap);
		}
	}

	/**
	 * Returns the number of feature lov maps.
	 *
	 * @return the number of feature lov maps
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_FEATURELOVMAP);

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
		return "id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FEATURELOVMAP;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FeatureLovMapModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the feature lov map persistence.
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

		_finderPathWithPaginationFindByFeatureId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFeatureId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"featureId"}, true);

		_finderPathWithoutPaginationFindByFeatureId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFeatureId",
			new String[] {Long.class.getName()}, new String[] {"featureId"},
			true);

		_finderPathCountByFeatureId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFeatureId",
			new String[] {Long.class.getName()}, new String[] {"featureId"},
			false);

		_finderPathWithPaginationFindByFeatureEntityResourceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByFeatureEntityResourceId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"featureEntityResourceId"}, true);

		_finderPathWithoutPaginationFindByFeatureEntityResourceId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByFeatureEntityResourceId",
				new String[] {Long.class.getName()},
				new String[] {"featureEntityResourceId"}, true);

		_finderPathCountByFeatureEntityResourceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFeatureEntityResourceId",
			new String[] {Long.class.getName()},
			new String[] {"featureEntityResourceId"}, false);

		_finderPathWithPaginationFindByFeatureIdAndLovType = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFeatureIdAndLovType",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"featureId", "lovType"}, true);

		_finderPathWithoutPaginationFindByFeatureIdAndLovType = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByFeatureIdAndLovType",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"featureId", "lovType"}, true);

		_finderPathCountByFeatureIdAndLovType = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFeatureIdAndLovType",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"featureId", "lovType"}, false);

		_finderPathWithPaginationFindByFeatureEntityResourceIdAndLovType =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByFeatureEntityResourceIdAndLovType",
				new String[] {
					Long.class.getName(), String.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"featureEntityResourceId", "lovType"}, true);

		_finderPathWithoutPaginationFindByFeatureEntityResourceIdAndLovType =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByFeatureEntityResourceIdAndLovType",
				new String[] {Long.class.getName(), String.class.getName()},
				new String[] {"featureEntityResourceId", "lovType"}, true);

		_finderPathCountByFeatureEntityResourceIdAndLovType = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFeatureEntityResourceIdAndLovType",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"featureEntityResourceId", "lovType"}, false);

		_finderPathWithPaginationFindByLovEntityResourceIdAndLovDataCode =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByLovEntityResourceIdAndLovDataCode",
				new String[] {
					Long.class.getName(), String.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"lovEntityResourceId", "lovDataCode"}, true);

		_finderPathWithoutPaginationFindByLovEntityResourceIdAndLovDataCode =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByLovEntityResourceIdAndLovDataCode",
				new String[] {Long.class.getName(), String.class.getName()},
				new String[] {"lovEntityResourceId", "lovDataCode"}, true);

		_finderPathCountByLovEntityResourceIdAndLovDataCode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLovEntityResourceIdAndLovDataCode",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"lovEntityResourceId", "lovDataCode"}, false);

		FeatureLovMapUtil.setPersistence(this);
	}

	public void destroy() {
		FeatureLovMapUtil.setPersistence(null);

		dummyEntityCache.removeCache(FeatureLovMapImpl.class.getName());
	}

	private static final String _SQL_SELECT_FEATURELOVMAP =
		"SELECT featureLovMap FROM FeatureLovMap featureLovMap";

	private static final String _SQL_SELECT_FEATURELOVMAP_WHERE =
		"SELECT featureLovMap FROM FeatureLovMap featureLovMap WHERE ";

	private static final String _SQL_COUNT_FEATURELOVMAP =
		"SELECT COUNT(featureLovMap) FROM FeatureLovMap featureLovMap";

	private static final String _SQL_COUNT_FEATURELOVMAP_WHERE =
		"SELECT COUNT(featureLovMap) FROM FeatureLovMap featureLovMap WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "featureLovMap.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FeatureLovMap exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No FeatureLovMap exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FeatureLovMapPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}