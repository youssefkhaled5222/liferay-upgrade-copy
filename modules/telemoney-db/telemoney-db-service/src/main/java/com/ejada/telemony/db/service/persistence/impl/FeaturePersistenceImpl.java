/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence.impl;

import com.ejada.telemony.db.exception.NoSuchFeatureException;
import com.ejada.telemony.db.model.Feature;
import com.ejada.telemony.db.model.FeatureTable;
import com.ejada.telemony.db.model.impl.FeatureImpl;
import com.ejada.telemony.db.model.impl.FeatureModelImpl;
import com.ejada.telemony.db.service.persistence.FeaturePersistence;
import com.ejada.telemony.db.service.persistence.FeatureUtil;

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
 * The persistence implementation for the feature service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FeaturePersistenceImpl
	extends BasePersistenceImpl<Feature> implements FeaturePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FeatureUtil</code> to access the feature persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FeatureImpl.class.getName();

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
	 * Returns all the features where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the matching features
	 */
	@Override
	public List<Feature> findByChannelId(long channelId) {
		return findByChannelId(
			channelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the features where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of features
	 * @param end the upper bound of the range of features (not inclusive)
	 * @return the range of matching features
	 */
	@Override
	public List<Feature> findByChannelId(long channelId, int start, int end) {
		return findByChannelId(channelId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the features where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of features
	 * @param end the upper bound of the range of features (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching features
	 */
	@Override
	public List<Feature> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<Feature> orderByComparator) {

		return findByChannelId(channelId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the features where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of features
	 * @param end the upper bound of the range of features (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching features
	 */
	@Override
	public List<Feature> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<Feature> orderByComparator, boolean useFinderCache) {

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

		List<Feature> list = null;

		if (useFinderCache) {
			list = (List<Feature>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Feature feature : list) {
					if (channelId != feature.getChannelId()) {
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

			sb.append(_SQL_SELECT_FEATURE_WHERE);

			sb.append(_FINDER_COLUMN_CHANNELID_CHANNELID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FeatureModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				list = (List<Feature>)QueryUtil.list(
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
	 * Returns the first feature in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature
	 * @throws NoSuchFeatureException if a matching feature could not be found
	 */
	@Override
	public Feature findByChannelId_First(
			long channelId, OrderByComparator<Feature> orderByComparator)
		throws NoSuchFeatureException {

		Feature feature = fetchByChannelId_First(channelId, orderByComparator);

		if (feature != null) {
			return feature;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append("}");

		throw new NoSuchFeatureException(sb.toString());
	}

	/**
	 * Returns the first feature in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature, or <code>null</code> if a matching feature could not be found
	 */
	@Override
	public Feature fetchByChannelId_First(
		long channelId, OrderByComparator<Feature> orderByComparator) {

		List<Feature> list = findByChannelId(
			channelId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last feature in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature
	 * @throws NoSuchFeatureException if a matching feature could not be found
	 */
	@Override
	public Feature findByChannelId_Last(
			long channelId, OrderByComparator<Feature> orderByComparator)
		throws NoSuchFeatureException {

		Feature feature = fetchByChannelId_Last(channelId, orderByComparator);

		if (feature != null) {
			return feature;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append("}");

		throw new NoSuchFeatureException(sb.toString());
	}

	/**
	 * Returns the last feature in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature, or <code>null</code> if a matching feature could not be found
	 */
	@Override
	public Feature fetchByChannelId_Last(
		long channelId, OrderByComparator<Feature> orderByComparator) {

		int count = countByChannelId(channelId);

		if (count == 0) {
			return null;
		}

		List<Feature> list = findByChannelId(
			channelId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the features before and after the current feature in the ordered set where channelId = &#63;.
	 *
	 * @param featureId the primary key of the current feature
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next feature
	 * @throws NoSuchFeatureException if a feature with the primary key could not be found
	 */
	@Override
	public Feature[] findByChannelId_PrevAndNext(
			long featureId, long channelId,
			OrderByComparator<Feature> orderByComparator)
		throws NoSuchFeatureException {

		Feature feature = findByPrimaryKey(featureId);

		Session session = null;

		try {
			session = openSession();

			Feature[] array = new FeatureImpl[3];

			array[0] = getByChannelId_PrevAndNext(
				session, feature, channelId, orderByComparator, true);

			array[1] = feature;

			array[2] = getByChannelId_PrevAndNext(
				session, feature, channelId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Feature getByChannelId_PrevAndNext(
		Session session, Feature feature, long channelId,
		OrderByComparator<Feature> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_FEATURE_WHERE);

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
			sb.append(FeatureModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(channelId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(feature)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Feature> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the features where channelId = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 */
	@Override
	public void removeByChannelId(long channelId) {
		for (Feature feature :
				findByChannelId(
					channelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(feature);
		}
	}

	/**
	 * Returns the number of features where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the number of matching features
	 */
	@Override
	public int countByChannelId(long channelId) {
		FinderPath finderPath = _finderPathCountByChannelId;

		Object[] finderArgs = new Object[] {channelId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FEATURE_WHERE);

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
		"feature.channelId = ?";

	private FinderPath _finderPathWithPaginationFindByFeatureId;
	private FinderPath _finderPathWithoutPaginationFindByFeatureId;
	private FinderPath _finderPathCountByFeatureId;

	/**
	 * Returns all the features where parentPage = &#63;.
	 *
	 * @param parentPage the parent page
	 * @return the matching features
	 */
	@Override
	public List<Feature> findByFeatureId(long parentPage) {
		return findByFeatureId(
			parentPage, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the features where parentPage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureModelImpl</code>.
	 * </p>
	 *
	 * @param parentPage the parent page
	 * @param start the lower bound of the range of features
	 * @param end the upper bound of the range of features (not inclusive)
	 * @return the range of matching features
	 */
	@Override
	public List<Feature> findByFeatureId(long parentPage, int start, int end) {
		return findByFeatureId(parentPage, start, end, null);
	}

	/**
	 * Returns an ordered range of all the features where parentPage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureModelImpl</code>.
	 * </p>
	 *
	 * @param parentPage the parent page
	 * @param start the lower bound of the range of features
	 * @param end the upper bound of the range of features (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching features
	 */
	@Override
	public List<Feature> findByFeatureId(
		long parentPage, int start, int end,
		OrderByComparator<Feature> orderByComparator) {

		return findByFeatureId(parentPage, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the features where parentPage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureModelImpl</code>.
	 * </p>
	 *
	 * @param parentPage the parent page
	 * @param start the lower bound of the range of features
	 * @param end the upper bound of the range of features (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching features
	 */
	@Override
	public List<Feature> findByFeatureId(
		long parentPage, int start, int end,
		OrderByComparator<Feature> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFeatureId;
				finderArgs = new Object[] {parentPage};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFeatureId;
			finderArgs = new Object[] {
				parentPage, start, end, orderByComparator
			};
		}

		List<Feature> list = null;

		if (useFinderCache) {
			list = (List<Feature>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Feature feature : list) {
					if (parentPage != feature.getParentPage()) {
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

			sb.append(_SQL_SELECT_FEATURE_WHERE);

			sb.append(_FINDER_COLUMN_FEATUREID_PARENTPAGE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FeatureModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(parentPage);

				list = (List<Feature>)QueryUtil.list(
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
	 * Returns the first feature in the ordered set where parentPage = &#63;.
	 *
	 * @param parentPage the parent page
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature
	 * @throws NoSuchFeatureException if a matching feature could not be found
	 */
	@Override
	public Feature findByFeatureId_First(
			long parentPage, OrderByComparator<Feature> orderByComparator)
		throws NoSuchFeatureException {

		Feature feature = fetchByFeatureId_First(parentPage, orderByComparator);

		if (feature != null) {
			return feature;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentPage=");
		sb.append(parentPage);

		sb.append("}");

		throw new NoSuchFeatureException(sb.toString());
	}

	/**
	 * Returns the first feature in the ordered set where parentPage = &#63;.
	 *
	 * @param parentPage the parent page
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature, or <code>null</code> if a matching feature could not be found
	 */
	@Override
	public Feature fetchByFeatureId_First(
		long parentPage, OrderByComparator<Feature> orderByComparator) {

		List<Feature> list = findByFeatureId(
			parentPage, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last feature in the ordered set where parentPage = &#63;.
	 *
	 * @param parentPage the parent page
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature
	 * @throws NoSuchFeatureException if a matching feature could not be found
	 */
	@Override
	public Feature findByFeatureId_Last(
			long parentPage, OrderByComparator<Feature> orderByComparator)
		throws NoSuchFeatureException {

		Feature feature = fetchByFeatureId_Last(parentPage, orderByComparator);

		if (feature != null) {
			return feature;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentPage=");
		sb.append(parentPage);

		sb.append("}");

		throw new NoSuchFeatureException(sb.toString());
	}

	/**
	 * Returns the last feature in the ordered set where parentPage = &#63;.
	 *
	 * @param parentPage the parent page
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature, or <code>null</code> if a matching feature could not be found
	 */
	@Override
	public Feature fetchByFeatureId_Last(
		long parentPage, OrderByComparator<Feature> orderByComparator) {

		int count = countByFeatureId(parentPage);

		if (count == 0) {
			return null;
		}

		List<Feature> list = findByFeatureId(
			parentPage, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the features before and after the current feature in the ordered set where parentPage = &#63;.
	 *
	 * @param featureId the primary key of the current feature
	 * @param parentPage the parent page
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next feature
	 * @throws NoSuchFeatureException if a feature with the primary key could not be found
	 */
	@Override
	public Feature[] findByFeatureId_PrevAndNext(
			long featureId, long parentPage,
			OrderByComparator<Feature> orderByComparator)
		throws NoSuchFeatureException {

		Feature feature = findByPrimaryKey(featureId);

		Session session = null;

		try {
			session = openSession();

			Feature[] array = new FeatureImpl[3];

			array[0] = getByFeatureId_PrevAndNext(
				session, feature, parentPage, orderByComparator, true);

			array[1] = feature;

			array[2] = getByFeatureId_PrevAndNext(
				session, feature, parentPage, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Feature getByFeatureId_PrevAndNext(
		Session session, Feature feature, long parentPage,
		OrderByComparator<Feature> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_FEATURE_WHERE);

		sb.append(_FINDER_COLUMN_FEATUREID_PARENTPAGE_2);

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
			sb.append(FeatureModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(parentPage);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(feature)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Feature> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the features where parentPage = &#63; from the database.
	 *
	 * @param parentPage the parent page
	 */
	@Override
	public void removeByFeatureId(long parentPage) {
		for (Feature feature :
				findByFeatureId(
					parentPage, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(feature);
		}
	}

	/**
	 * Returns the number of features where parentPage = &#63;.
	 *
	 * @param parentPage the parent page
	 * @return the number of matching features
	 */
	@Override
	public int countByFeatureId(long parentPage) {
		FinderPath finderPath = _finderPathCountByFeatureId;

		Object[] finderArgs = new Object[] {parentPage};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FEATURE_WHERE);

			sb.append(_FINDER_COLUMN_FEATUREID_PARENTPAGE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(parentPage);

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

	private static final String _FINDER_COLUMN_FEATUREID_PARENTPAGE_2 =
		"feature.parentPage = ?";

	private FinderPath _finderPathWithPaginationFindByEntityResourceId;
	private FinderPath _finderPathWithoutPaginationFindByEntityResourceId;
	private FinderPath _finderPathCountByEntityResourceId;

	/**
	 * Returns all the features where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the matching features
	 */
	@Override
	public List<Feature> findByEntityResourceId(long entityResourceId) {
		return findByEntityResourceId(
			entityResourceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the features where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of features
	 * @param end the upper bound of the range of features (not inclusive)
	 * @return the range of matching features
	 */
	@Override
	public List<Feature> findByEntityResourceId(
		long entityResourceId, int start, int end) {

		return findByEntityResourceId(entityResourceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the features where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of features
	 * @param end the upper bound of the range of features (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching features
	 */
	@Override
	public List<Feature> findByEntityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<Feature> orderByComparator) {

		return findByEntityResourceId(
			entityResourceId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the features where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of features
	 * @param end the upper bound of the range of features (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching features
	 */
	@Override
	public List<Feature> findByEntityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<Feature> orderByComparator, boolean useFinderCache) {

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

		List<Feature> list = null;

		if (useFinderCache) {
			list = (List<Feature>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Feature feature : list) {
					if (entityResourceId != feature.getEntityResourceId()) {
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

			sb.append(_SQL_SELECT_FEATURE_WHERE);

			sb.append(_FINDER_COLUMN_ENTITYRESOURCEID_ENTITYRESOURCEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FeatureModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(entityResourceId);

				list = (List<Feature>)QueryUtil.list(
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
	 * Returns the first feature in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature
	 * @throws NoSuchFeatureException if a matching feature could not be found
	 */
	@Override
	public Feature findByEntityResourceId_First(
			long entityResourceId, OrderByComparator<Feature> orderByComparator)
		throws NoSuchFeatureException {

		Feature feature = fetchByEntityResourceId_First(
			entityResourceId, orderByComparator);

		if (feature != null) {
			return feature;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("entityResourceId=");
		sb.append(entityResourceId);

		sb.append("}");

		throw new NoSuchFeatureException(sb.toString());
	}

	/**
	 * Returns the first feature in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature, or <code>null</code> if a matching feature could not be found
	 */
	@Override
	public Feature fetchByEntityResourceId_First(
		long entityResourceId, OrderByComparator<Feature> orderByComparator) {

		List<Feature> list = findByEntityResourceId(
			entityResourceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last feature in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature
	 * @throws NoSuchFeatureException if a matching feature could not be found
	 */
	@Override
	public Feature findByEntityResourceId_Last(
			long entityResourceId, OrderByComparator<Feature> orderByComparator)
		throws NoSuchFeatureException {

		Feature feature = fetchByEntityResourceId_Last(
			entityResourceId, orderByComparator);

		if (feature != null) {
			return feature;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("entityResourceId=");
		sb.append(entityResourceId);

		sb.append("}");

		throw new NoSuchFeatureException(sb.toString());
	}

	/**
	 * Returns the last feature in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature, or <code>null</code> if a matching feature could not be found
	 */
	@Override
	public Feature fetchByEntityResourceId_Last(
		long entityResourceId, OrderByComparator<Feature> orderByComparator) {

		int count = countByEntityResourceId(entityResourceId);

		if (count == 0) {
			return null;
		}

		List<Feature> list = findByEntityResourceId(
			entityResourceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the features before and after the current feature in the ordered set where entityResourceId = &#63;.
	 *
	 * @param featureId the primary key of the current feature
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next feature
	 * @throws NoSuchFeatureException if a feature with the primary key could not be found
	 */
	@Override
	public Feature[] findByEntityResourceId_PrevAndNext(
			long featureId, long entityResourceId,
			OrderByComparator<Feature> orderByComparator)
		throws NoSuchFeatureException {

		Feature feature = findByPrimaryKey(featureId);

		Session session = null;

		try {
			session = openSession();

			Feature[] array = new FeatureImpl[3];

			array[0] = getByEntityResourceId_PrevAndNext(
				session, feature, entityResourceId, orderByComparator, true);

			array[1] = feature;

			array[2] = getByEntityResourceId_PrevAndNext(
				session, feature, entityResourceId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Feature getByEntityResourceId_PrevAndNext(
		Session session, Feature feature, long entityResourceId,
		OrderByComparator<Feature> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_FEATURE_WHERE);

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
			sb.append(FeatureModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(entityResourceId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(feature)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Feature> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the features where entityResourceId = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 */
	@Override
	public void removeByEntityResourceId(long entityResourceId) {
		for (Feature feature :
				findByEntityResourceId(
					entityResourceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(feature);
		}
	}

	/**
	 * Returns the number of features where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the number of matching features
	 */
	@Override
	public int countByEntityResourceId(long entityResourceId) {
		FinderPath finderPath = _finderPathCountByEntityResourceId;

		Object[] finderArgs = new Object[] {entityResourceId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FEATURE_WHERE);

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
			"feature.entityResourceId = ?";

	private FinderPath _finderPathWithPaginationFindByChildResourceId;
	private FinderPath _finderPathWithoutPaginationFindByChildResourceId;
	private FinderPath _finderPathCountByChildResourceId;

	/**
	 * Returns all the features where childResourceId = &#63;.
	 *
	 * @param childResourceId the child resource ID
	 * @return the matching features
	 */
	@Override
	public List<Feature> findByChildResourceId(long childResourceId) {
		return findByChildResourceId(
			childResourceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the features where childResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureModelImpl</code>.
	 * </p>
	 *
	 * @param childResourceId the child resource ID
	 * @param start the lower bound of the range of features
	 * @param end the upper bound of the range of features (not inclusive)
	 * @return the range of matching features
	 */
	@Override
	public List<Feature> findByChildResourceId(
		long childResourceId, int start, int end) {

		return findByChildResourceId(childResourceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the features where childResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureModelImpl</code>.
	 * </p>
	 *
	 * @param childResourceId the child resource ID
	 * @param start the lower bound of the range of features
	 * @param end the upper bound of the range of features (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching features
	 */
	@Override
	public List<Feature> findByChildResourceId(
		long childResourceId, int start, int end,
		OrderByComparator<Feature> orderByComparator) {

		return findByChildResourceId(
			childResourceId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the features where childResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureModelImpl</code>.
	 * </p>
	 *
	 * @param childResourceId the child resource ID
	 * @param start the lower bound of the range of features
	 * @param end the upper bound of the range of features (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching features
	 */
	@Override
	public List<Feature> findByChildResourceId(
		long childResourceId, int start, int end,
		OrderByComparator<Feature> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByChildResourceId;
				finderArgs = new Object[] {childResourceId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByChildResourceId;
			finderArgs = new Object[] {
				childResourceId, start, end, orderByComparator
			};
		}

		List<Feature> list = null;

		if (useFinderCache) {
			list = (List<Feature>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Feature feature : list) {
					if (childResourceId != feature.getChildResourceId()) {
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

			sb.append(_SQL_SELECT_FEATURE_WHERE);

			sb.append(_FINDER_COLUMN_CHILDRESOURCEID_CHILDRESOURCEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FeatureModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(childResourceId);

				list = (List<Feature>)QueryUtil.list(
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
	 * Returns the first feature in the ordered set where childResourceId = &#63;.
	 *
	 * @param childResourceId the child resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature
	 * @throws NoSuchFeatureException if a matching feature could not be found
	 */
	@Override
	public Feature findByChildResourceId_First(
			long childResourceId, OrderByComparator<Feature> orderByComparator)
		throws NoSuchFeatureException {

		Feature feature = fetchByChildResourceId_First(
			childResourceId, orderByComparator);

		if (feature != null) {
			return feature;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("childResourceId=");
		sb.append(childResourceId);

		sb.append("}");

		throw new NoSuchFeatureException(sb.toString());
	}

	/**
	 * Returns the first feature in the ordered set where childResourceId = &#63;.
	 *
	 * @param childResourceId the child resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature, or <code>null</code> if a matching feature could not be found
	 */
	@Override
	public Feature fetchByChildResourceId_First(
		long childResourceId, OrderByComparator<Feature> orderByComparator) {

		List<Feature> list = findByChildResourceId(
			childResourceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last feature in the ordered set where childResourceId = &#63;.
	 *
	 * @param childResourceId the child resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature
	 * @throws NoSuchFeatureException if a matching feature could not be found
	 */
	@Override
	public Feature findByChildResourceId_Last(
			long childResourceId, OrderByComparator<Feature> orderByComparator)
		throws NoSuchFeatureException {

		Feature feature = fetchByChildResourceId_Last(
			childResourceId, orderByComparator);

		if (feature != null) {
			return feature;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("childResourceId=");
		sb.append(childResourceId);

		sb.append("}");

		throw new NoSuchFeatureException(sb.toString());
	}

	/**
	 * Returns the last feature in the ordered set where childResourceId = &#63;.
	 *
	 * @param childResourceId the child resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature, or <code>null</code> if a matching feature could not be found
	 */
	@Override
	public Feature fetchByChildResourceId_Last(
		long childResourceId, OrderByComparator<Feature> orderByComparator) {

		int count = countByChildResourceId(childResourceId);

		if (count == 0) {
			return null;
		}

		List<Feature> list = findByChildResourceId(
			childResourceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the features before and after the current feature in the ordered set where childResourceId = &#63;.
	 *
	 * @param featureId the primary key of the current feature
	 * @param childResourceId the child resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next feature
	 * @throws NoSuchFeatureException if a feature with the primary key could not be found
	 */
	@Override
	public Feature[] findByChildResourceId_PrevAndNext(
			long featureId, long childResourceId,
			OrderByComparator<Feature> orderByComparator)
		throws NoSuchFeatureException {

		Feature feature = findByPrimaryKey(featureId);

		Session session = null;

		try {
			session = openSession();

			Feature[] array = new FeatureImpl[3];

			array[0] = getByChildResourceId_PrevAndNext(
				session, feature, childResourceId, orderByComparator, true);

			array[1] = feature;

			array[2] = getByChildResourceId_PrevAndNext(
				session, feature, childResourceId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Feature getByChildResourceId_PrevAndNext(
		Session session, Feature feature, long childResourceId,
		OrderByComparator<Feature> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_FEATURE_WHERE);

		sb.append(_FINDER_COLUMN_CHILDRESOURCEID_CHILDRESOURCEID_2);

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
			sb.append(FeatureModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(childResourceId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(feature)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Feature> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the features where childResourceId = &#63; from the database.
	 *
	 * @param childResourceId the child resource ID
	 */
	@Override
	public void removeByChildResourceId(long childResourceId) {
		for (Feature feature :
				findByChildResourceId(
					childResourceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(feature);
		}
	}

	/**
	 * Returns the number of features where childResourceId = &#63;.
	 *
	 * @param childResourceId the child resource ID
	 * @return the number of matching features
	 */
	@Override
	public int countByChildResourceId(long childResourceId) {
		FinderPath finderPath = _finderPathCountByChildResourceId;

		Object[] finderArgs = new Object[] {childResourceId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FEATURE_WHERE);

			sb.append(_FINDER_COLUMN_CHILDRESOURCEID_CHILDRESOURCEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(childResourceId);

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
		_FINDER_COLUMN_CHILDRESOURCEID_CHILDRESOURCEID_2 =
			"feature.childResourceId = ?";

	public FeaturePersistenceImpl() {
		setModelClass(Feature.class);

		setModelImplClass(FeatureImpl.class);
		setModelPKClass(long.class);

		setTable(FeatureTable.INSTANCE);
	}

	/**
	 * Caches the feature in the entity cache if it is enabled.
	 *
	 * @param feature the feature
	 */
	@Override
	public void cacheResult(Feature feature) {
		dummyEntityCache.putResult(
			FeatureImpl.class, feature.getPrimaryKey(), feature);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the features in the entity cache if it is enabled.
	 *
	 * @param features the features
	 */
	@Override
	public void cacheResult(List<Feature> features) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (features.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Feature feature : features) {
			if (dummyEntityCache.getResult(
					FeatureImpl.class, feature.getPrimaryKey()) == null) {

				cacheResult(feature);
			}
		}
	}

	/**
	 * Clears the cache for all features.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(FeatureImpl.class);

		dummyFinderCache.clearCache(FeatureImpl.class);
	}

	/**
	 * Clears the cache for the feature.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Feature feature) {
		dummyEntityCache.removeResult(FeatureImpl.class, feature);
	}

	@Override
	public void clearCache(List<Feature> features) {
		for (Feature feature : features) {
			dummyEntityCache.removeResult(FeatureImpl.class, feature);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FeatureImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(FeatureImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new feature with the primary key. Does not add the feature to the database.
	 *
	 * @param featureId the primary key for the new feature
	 * @return the new feature
	 */
	@Override
	public Feature create(long featureId) {
		Feature feature = new FeatureImpl();

		feature.setNew(true);
		feature.setPrimaryKey(featureId);

		feature.setCompanyId(CompanyThreadLocal.getCompanyId());

		return feature;
	}

	/**
	 * Removes the feature with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param featureId the primary key of the feature
	 * @return the feature that was removed
	 * @throws NoSuchFeatureException if a feature with the primary key could not be found
	 */
	@Override
	public Feature remove(long featureId) throws NoSuchFeatureException {
		return remove((Serializable)featureId);
	}

	/**
	 * Removes the feature with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the feature
	 * @return the feature that was removed
	 * @throws NoSuchFeatureException if a feature with the primary key could not be found
	 */
	@Override
	public Feature remove(Serializable primaryKey)
		throws NoSuchFeatureException {

		Session session = null;

		try {
			session = openSession();

			Feature feature = (Feature)session.get(
				FeatureImpl.class, primaryKey);

			if (feature == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFeatureException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(feature);
		}
		catch (NoSuchFeatureException noSuchEntityException) {
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
	protected Feature removeImpl(Feature feature) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(feature)) {
				feature = (Feature)session.get(
					FeatureImpl.class, feature.getPrimaryKeyObj());
			}

			if (feature != null) {
				session.delete(feature);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (feature != null) {
			clearCache(feature);
		}

		return feature;
	}

	@Override
	public Feature updateImpl(Feature feature) {
		boolean isNew = feature.isNew();

		if (!(feature instanceof FeatureModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(feature.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(feature);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in feature proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Feature implementation " +
					feature.getClass());
		}

		FeatureModelImpl featureModelImpl = (FeatureModelImpl)feature;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (feature.getCreateDate() == null)) {
			if (serviceContext == null) {
				feature.setCreateDate(date);
			}
			else {
				feature.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!featureModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				feature.setModifiedDate(date);
			}
			else {
				feature.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(feature);
			}
			else {
				feature = (Feature)session.merge(feature);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			FeatureImpl.class, featureModelImpl, false, true);

		if (isNew) {
			feature.setNew(false);
		}

		feature.resetOriginalValues();

		return feature;
	}

	/**
	 * Returns the feature with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the feature
	 * @return the feature
	 * @throws NoSuchFeatureException if a feature with the primary key could not be found
	 */
	@Override
	public Feature findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFeatureException {

		Feature feature = fetchByPrimaryKey(primaryKey);

		if (feature == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFeatureException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return feature;
	}

	/**
	 * Returns the feature with the primary key or throws a <code>NoSuchFeatureException</code> if it could not be found.
	 *
	 * @param featureId the primary key of the feature
	 * @return the feature
	 * @throws NoSuchFeatureException if a feature with the primary key could not be found
	 */
	@Override
	public Feature findByPrimaryKey(long featureId)
		throws NoSuchFeatureException {

		return findByPrimaryKey((Serializable)featureId);
	}

	/**
	 * Returns the feature with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param featureId the primary key of the feature
	 * @return the feature, or <code>null</code> if a feature with the primary key could not be found
	 */
	@Override
	public Feature fetchByPrimaryKey(long featureId) {
		return fetchByPrimaryKey((Serializable)featureId);
	}

	/**
	 * Returns all the features.
	 *
	 * @return the features
	 */
	@Override
	public List<Feature> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the features.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of features
	 * @param end the upper bound of the range of features (not inclusive)
	 * @return the range of features
	 */
	@Override
	public List<Feature> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the features.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of features
	 * @param end the upper bound of the range of features (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of features
	 */
	@Override
	public List<Feature> findAll(
		int start, int end, OrderByComparator<Feature> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the features.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of features
	 * @param end the upper bound of the range of features (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of features
	 */
	@Override
	public List<Feature> findAll(
		int start, int end, OrderByComparator<Feature> orderByComparator,
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

		List<Feature> list = null;

		if (useFinderCache) {
			list = (List<Feature>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FEATURE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FEATURE;

				sql = sql.concat(FeatureModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Feature>)QueryUtil.list(
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
	 * Removes all the features from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Feature feature : findAll()) {
			remove(feature);
		}
	}

	/**
	 * Returns the number of features.
	 *
	 * @return the number of features
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_FEATURE);

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
		return "featureId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FEATURE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FeatureModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the feature persistence.
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

		_finderPathWithPaginationFindByFeatureId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFeatureId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"parentPage"}, true);

		_finderPathWithoutPaginationFindByFeatureId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFeatureId",
			new String[] {Long.class.getName()}, new String[] {"parentPage"},
			true);

		_finderPathCountByFeatureId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFeatureId",
			new String[] {Long.class.getName()}, new String[] {"parentPage"},
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

		_finderPathWithPaginationFindByChildResourceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByChildResourceId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"childResourceId"}, true);

		_finderPathWithoutPaginationFindByChildResourceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByChildResourceId",
			new String[] {Long.class.getName()},
			new String[] {"childResourceId"}, true);

		_finderPathCountByChildResourceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByChildResourceId",
			new String[] {Long.class.getName()},
			new String[] {"childResourceId"}, false);

		FeatureUtil.setPersistence(this);
	}

	public void destroy() {
		FeatureUtil.setPersistence(null);

		dummyEntityCache.removeCache(FeatureImpl.class.getName());
	}

	private static final String _SQL_SELECT_FEATURE =
		"SELECT feature FROM Feature feature";

	private static final String _SQL_SELECT_FEATURE_WHERE =
		"SELECT feature FROM Feature feature WHERE ";

	private static final String _SQL_COUNT_FEATURE =
		"SELECT COUNT(feature) FROM Feature feature";

	private static final String _SQL_COUNT_FEATURE_WHERE =
		"SELECT COUNT(feature) FROM Feature feature WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "feature.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Feature exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Feature exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FeaturePersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}