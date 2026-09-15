/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence.impl;

import com.ejada.telemony.db.exception.NoSuchSegmentException;
import com.ejada.telemony.db.model.Segment;
import com.ejada.telemony.db.model.SegmentTable;
import com.ejada.telemony.db.model.impl.SegmentImpl;
import com.ejada.telemony.db.model.impl.SegmentModelImpl;
import com.ejada.telemony.db.service.persistence.SegmentPersistence;
import com.ejada.telemony.db.service.persistence.SegmentUtil;

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
 * The persistence implementation for the segment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SegmentPersistenceImpl
	extends BasePersistenceImpl<Segment> implements SegmentPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SegmentUtil</code> to access the segment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SegmentImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByEntityResourceId;
	private FinderPath _finderPathWithoutPaginationFindByEntityResourceId;
	private FinderPath _finderPathCountByEntityResourceId;

	/**
	 * Returns all the segments where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the matching segments
	 */
	@Override
	public List<Segment> findByEntityResourceId(long entityResourceId) {
		return findByEntityResourceId(
			entityResourceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the segments where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @return the range of matching segments
	 */
	@Override
	public List<Segment> findByEntityResourceId(
		long entityResourceId, int start, int end) {

		return findByEntityResourceId(entityResourceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the segments where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching segments
	 */
	@Override
	public List<Segment> findByEntityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<Segment> orderByComparator) {

		return findByEntityResourceId(
			entityResourceId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the segments where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching segments
	 */
	@Override
	public List<Segment> findByEntityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<Segment> orderByComparator, boolean useFinderCache) {

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

		List<Segment> list = null;

		if (useFinderCache) {
			list = (List<Segment>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Segment segment : list) {
					if (entityResourceId != segment.getEntityResourceId()) {
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

			sb.append(_SQL_SELECT_SEGMENT_WHERE);

			sb.append(_FINDER_COLUMN_ENTITYRESOURCEID_ENTITYRESOURCEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SegmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(entityResourceId);

				list = (List<Segment>)QueryUtil.list(
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
	 * Returns the first segment in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment
	 * @throws NoSuchSegmentException if a matching segment could not be found
	 */
	@Override
	public Segment findByEntityResourceId_First(
			long entityResourceId, OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException {

		Segment segment = fetchByEntityResourceId_First(
			entityResourceId, orderByComparator);

		if (segment != null) {
			return segment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("entityResourceId=");
		sb.append(entityResourceId);

		sb.append("}");

		throw new NoSuchSegmentException(sb.toString());
	}

	/**
	 * Returns the first segment in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment, or <code>null</code> if a matching segment could not be found
	 */
	@Override
	public Segment fetchByEntityResourceId_First(
		long entityResourceId, OrderByComparator<Segment> orderByComparator) {

		List<Segment> list = findByEntityResourceId(
			entityResourceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last segment in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment
	 * @throws NoSuchSegmentException if a matching segment could not be found
	 */
	@Override
	public Segment findByEntityResourceId_Last(
			long entityResourceId, OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException {

		Segment segment = fetchByEntityResourceId_Last(
			entityResourceId, orderByComparator);

		if (segment != null) {
			return segment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("entityResourceId=");
		sb.append(entityResourceId);

		sb.append("}");

		throw new NoSuchSegmentException(sb.toString());
	}

	/**
	 * Returns the last segment in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment, or <code>null</code> if a matching segment could not be found
	 */
	@Override
	public Segment fetchByEntityResourceId_Last(
		long entityResourceId, OrderByComparator<Segment> orderByComparator) {

		int count = countByEntityResourceId(entityResourceId);

		if (count == 0) {
			return null;
		}

		List<Segment> list = findByEntityResourceId(
			entityResourceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the segments before and after the current segment in the ordered set where entityResourceId = &#63;.
	 *
	 * @param segmentId the primary key of the current segment
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next segment
	 * @throws NoSuchSegmentException if a segment with the primary key could not be found
	 */
	@Override
	public Segment[] findByEntityResourceId_PrevAndNext(
			long segmentId, long entityResourceId,
			OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException {

		Segment segment = findByPrimaryKey(segmentId);

		Session session = null;

		try {
			session = openSession();

			Segment[] array = new SegmentImpl[3];

			array[0] = getByEntityResourceId_PrevAndNext(
				session, segment, entityResourceId, orderByComparator, true);

			array[1] = segment;

			array[2] = getByEntityResourceId_PrevAndNext(
				session, segment, entityResourceId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Segment getByEntityResourceId_PrevAndNext(
		Session session, Segment segment, long entityResourceId,
		OrderByComparator<Segment> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SEGMENT_WHERE);

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
			sb.append(SegmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(entityResourceId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(segment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Segment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the segments where entityResourceId = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 */
	@Override
	public void removeByEntityResourceId(long entityResourceId) {
		for (Segment segment :
				findByEntityResourceId(
					entityResourceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(segment);
		}
	}

	/**
	 * Returns the number of segments where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the number of matching segments
	 */
	@Override
	public int countByEntityResourceId(long entityResourceId) {
		FinderPath finderPath = _finderPathCountByEntityResourceId;

		Object[] finderArgs = new Object[] {entityResourceId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SEGMENT_WHERE);

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
			"segment.entityResourceId = ?";

	private FinderPath _finderPathWithPaginationFindBychildResourceId;
	private FinderPath _finderPathWithoutPaginationFindBychildResourceId;
	private FinderPath _finderPathCountBychildResourceId;

	/**
	 * Returns all the segments where childResourceId = &#63;.
	 *
	 * @param childResourceId the child resource ID
	 * @return the matching segments
	 */
	@Override
	public List<Segment> findBychildResourceId(long childResourceId) {
		return findBychildResourceId(
			childResourceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the segments where childResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>.
	 * </p>
	 *
	 * @param childResourceId the child resource ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @return the range of matching segments
	 */
	@Override
	public List<Segment> findBychildResourceId(
		long childResourceId, int start, int end) {

		return findBychildResourceId(childResourceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the segments where childResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>.
	 * </p>
	 *
	 * @param childResourceId the child resource ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching segments
	 */
	@Override
	public List<Segment> findBychildResourceId(
		long childResourceId, int start, int end,
		OrderByComparator<Segment> orderByComparator) {

		return findBychildResourceId(
			childResourceId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the segments where childResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>.
	 * </p>
	 *
	 * @param childResourceId the child resource ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching segments
	 */
	@Override
	public List<Segment> findBychildResourceId(
		long childResourceId, int start, int end,
		OrderByComparator<Segment> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBychildResourceId;
				finderArgs = new Object[] {childResourceId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBychildResourceId;
			finderArgs = new Object[] {
				childResourceId, start, end, orderByComparator
			};
		}

		List<Segment> list = null;

		if (useFinderCache) {
			list = (List<Segment>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Segment segment : list) {
					if (childResourceId != segment.getChildResourceId()) {
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

			sb.append(_SQL_SELECT_SEGMENT_WHERE);

			sb.append(_FINDER_COLUMN_CHILDRESOURCEID_CHILDRESOURCEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SegmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(childResourceId);

				list = (List<Segment>)QueryUtil.list(
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
	 * Returns the first segment in the ordered set where childResourceId = &#63;.
	 *
	 * @param childResourceId the child resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment
	 * @throws NoSuchSegmentException if a matching segment could not be found
	 */
	@Override
	public Segment findBychildResourceId_First(
			long childResourceId, OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException {

		Segment segment = fetchBychildResourceId_First(
			childResourceId, orderByComparator);

		if (segment != null) {
			return segment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("childResourceId=");
		sb.append(childResourceId);

		sb.append("}");

		throw new NoSuchSegmentException(sb.toString());
	}

	/**
	 * Returns the first segment in the ordered set where childResourceId = &#63;.
	 *
	 * @param childResourceId the child resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment, or <code>null</code> if a matching segment could not be found
	 */
	@Override
	public Segment fetchBychildResourceId_First(
		long childResourceId, OrderByComparator<Segment> orderByComparator) {

		List<Segment> list = findBychildResourceId(
			childResourceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last segment in the ordered set where childResourceId = &#63;.
	 *
	 * @param childResourceId the child resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment
	 * @throws NoSuchSegmentException if a matching segment could not be found
	 */
	@Override
	public Segment findBychildResourceId_Last(
			long childResourceId, OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException {

		Segment segment = fetchBychildResourceId_Last(
			childResourceId, orderByComparator);

		if (segment != null) {
			return segment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("childResourceId=");
		sb.append(childResourceId);

		sb.append("}");

		throw new NoSuchSegmentException(sb.toString());
	}

	/**
	 * Returns the last segment in the ordered set where childResourceId = &#63;.
	 *
	 * @param childResourceId the child resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment, or <code>null</code> if a matching segment could not be found
	 */
	@Override
	public Segment fetchBychildResourceId_Last(
		long childResourceId, OrderByComparator<Segment> orderByComparator) {

		int count = countBychildResourceId(childResourceId);

		if (count == 0) {
			return null;
		}

		List<Segment> list = findBychildResourceId(
			childResourceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the segments before and after the current segment in the ordered set where childResourceId = &#63;.
	 *
	 * @param segmentId the primary key of the current segment
	 * @param childResourceId the child resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next segment
	 * @throws NoSuchSegmentException if a segment with the primary key could not be found
	 */
	@Override
	public Segment[] findBychildResourceId_PrevAndNext(
			long segmentId, long childResourceId,
			OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException {

		Segment segment = findByPrimaryKey(segmentId);

		Session session = null;

		try {
			session = openSession();

			Segment[] array = new SegmentImpl[3];

			array[0] = getBychildResourceId_PrevAndNext(
				session, segment, childResourceId, orderByComparator, true);

			array[1] = segment;

			array[2] = getBychildResourceId_PrevAndNext(
				session, segment, childResourceId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Segment getBychildResourceId_PrevAndNext(
		Session session, Segment segment, long childResourceId,
		OrderByComparator<Segment> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SEGMENT_WHERE);

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
			sb.append(SegmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(childResourceId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(segment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Segment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the segments where childResourceId = &#63; from the database.
	 *
	 * @param childResourceId the child resource ID
	 */
	@Override
	public void removeBychildResourceId(long childResourceId) {
		for (Segment segment :
				findBychildResourceId(
					childResourceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(segment);
		}
	}

	/**
	 * Returns the number of segments where childResourceId = &#63;.
	 *
	 * @param childResourceId the child resource ID
	 * @return the number of matching segments
	 */
	@Override
	public int countBychildResourceId(long childResourceId) {
		FinderPath finderPath = _finderPathCountBychildResourceId;

		Object[] finderArgs = new Object[] {childResourceId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SEGMENT_WHERE);

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
			"segment.childResourceId = ?";

	private FinderPath _finderPathWithPaginationFindByfeatureSegments;
	private FinderPath _finderPathWithoutPaginationFindByfeatureSegments;
	private FinderPath _finderPathCountByfeatureSegments;

	/**
	 * Returns all the segments where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @return the matching segments
	 */
	@Override
	public List<Segment> findByfeatureSegments(long featureId) {
		return findByfeatureSegments(
			featureId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the segments where featureId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>.
	 * </p>
	 *
	 * @param featureId the feature ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @return the range of matching segments
	 */
	@Override
	public List<Segment> findByfeatureSegments(
		long featureId, int start, int end) {

		return findByfeatureSegments(featureId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the segments where featureId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>.
	 * </p>
	 *
	 * @param featureId the feature ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching segments
	 */
	@Override
	public List<Segment> findByfeatureSegments(
		long featureId, int start, int end,
		OrderByComparator<Segment> orderByComparator) {

		return findByfeatureSegments(
			featureId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the segments where featureId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>.
	 * </p>
	 *
	 * @param featureId the feature ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching segments
	 */
	@Override
	public List<Segment> findByfeatureSegments(
		long featureId, int start, int end,
		OrderByComparator<Segment> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByfeatureSegments;
				finderArgs = new Object[] {featureId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByfeatureSegments;
			finderArgs = new Object[] {
				featureId, start, end, orderByComparator
			};
		}

		List<Segment> list = null;

		if (useFinderCache) {
			list = (List<Segment>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Segment segment : list) {
					if (featureId != segment.getFeatureId()) {
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

			sb.append(_SQL_SELECT_SEGMENT_WHERE);

			sb.append(_FINDER_COLUMN_FEATURESEGMENTS_FEATUREID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SegmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(featureId);

				list = (List<Segment>)QueryUtil.list(
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
	 * Returns the first segment in the ordered set where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment
	 * @throws NoSuchSegmentException if a matching segment could not be found
	 */
	@Override
	public Segment findByfeatureSegments_First(
			long featureId, OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException {

		Segment segment = fetchByfeatureSegments_First(
			featureId, orderByComparator);

		if (segment != null) {
			return segment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("featureId=");
		sb.append(featureId);

		sb.append("}");

		throw new NoSuchSegmentException(sb.toString());
	}

	/**
	 * Returns the first segment in the ordered set where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment, or <code>null</code> if a matching segment could not be found
	 */
	@Override
	public Segment fetchByfeatureSegments_First(
		long featureId, OrderByComparator<Segment> orderByComparator) {

		List<Segment> list = findByfeatureSegments(
			featureId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last segment in the ordered set where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment
	 * @throws NoSuchSegmentException if a matching segment could not be found
	 */
	@Override
	public Segment findByfeatureSegments_Last(
			long featureId, OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException {

		Segment segment = fetchByfeatureSegments_Last(
			featureId, orderByComparator);

		if (segment != null) {
			return segment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("featureId=");
		sb.append(featureId);

		sb.append("}");

		throw new NoSuchSegmentException(sb.toString());
	}

	/**
	 * Returns the last segment in the ordered set where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment, or <code>null</code> if a matching segment could not be found
	 */
	@Override
	public Segment fetchByfeatureSegments_Last(
		long featureId, OrderByComparator<Segment> orderByComparator) {

		int count = countByfeatureSegments(featureId);

		if (count == 0) {
			return null;
		}

		List<Segment> list = findByfeatureSegments(
			featureId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the segments before and after the current segment in the ordered set where featureId = &#63;.
	 *
	 * @param segmentId the primary key of the current segment
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next segment
	 * @throws NoSuchSegmentException if a segment with the primary key could not be found
	 */
	@Override
	public Segment[] findByfeatureSegments_PrevAndNext(
			long segmentId, long featureId,
			OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException {

		Segment segment = findByPrimaryKey(segmentId);

		Session session = null;

		try {
			session = openSession();

			Segment[] array = new SegmentImpl[3];

			array[0] = getByfeatureSegments_PrevAndNext(
				session, segment, featureId, orderByComparator, true);

			array[1] = segment;

			array[2] = getByfeatureSegments_PrevAndNext(
				session, segment, featureId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Segment getByfeatureSegments_PrevAndNext(
		Session session, Segment segment, long featureId,
		OrderByComparator<Segment> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SEGMENT_WHERE);

		sb.append(_FINDER_COLUMN_FEATURESEGMENTS_FEATUREID_2);

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
			sb.append(SegmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(featureId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(segment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Segment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the segments where featureId = &#63; from the database.
	 *
	 * @param featureId the feature ID
	 */
	@Override
	public void removeByfeatureSegments(long featureId) {
		for (Segment segment :
				findByfeatureSegments(
					featureId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(segment);
		}
	}

	/**
	 * Returns the number of segments where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @return the number of matching segments
	 */
	@Override
	public int countByfeatureSegments(long featureId) {
		FinderPath finderPath = _finderPathCountByfeatureSegments;

		Object[] finderArgs = new Object[] {featureId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SEGMENT_WHERE);

			sb.append(_FINDER_COLUMN_FEATURESEGMENTS_FEATUREID_2);

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

	private static final String _FINDER_COLUMN_FEATURESEGMENTS_FEATUREID_2 =
		"segment.featureId = ?";

	public SegmentPersistenceImpl() {
		setModelClass(Segment.class);

		setModelImplClass(SegmentImpl.class);
		setModelPKClass(long.class);

		setTable(SegmentTable.INSTANCE);
	}

	/**
	 * Caches the segment in the entity cache if it is enabled.
	 *
	 * @param segment the segment
	 */
	@Override
	public void cacheResult(Segment segment) {
		dummyEntityCache.putResult(
			SegmentImpl.class, segment.getPrimaryKey(), segment);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the segments in the entity cache if it is enabled.
	 *
	 * @param segments the segments
	 */
	@Override
	public void cacheResult(List<Segment> segments) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (segments.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Segment segment : segments) {
			if (dummyEntityCache.getResult(
					SegmentImpl.class, segment.getPrimaryKey()) == null) {

				cacheResult(segment);
			}
		}
	}

	/**
	 * Clears the cache for all segments.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(SegmentImpl.class);

		dummyFinderCache.clearCache(SegmentImpl.class);
	}

	/**
	 * Clears the cache for the segment.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Segment segment) {
		dummyEntityCache.removeResult(SegmentImpl.class, segment);
	}

	@Override
	public void clearCache(List<Segment> segments) {
		for (Segment segment : segments) {
			dummyEntityCache.removeResult(SegmentImpl.class, segment);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(SegmentImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(SegmentImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new segment with the primary key. Does not add the segment to the database.
	 *
	 * @param segmentId the primary key for the new segment
	 * @return the new segment
	 */
	@Override
	public Segment create(long segmentId) {
		Segment segment = new SegmentImpl();

		segment.setNew(true);
		segment.setPrimaryKey(segmentId);

		return segment;
	}

	/**
	 * Removes the segment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param segmentId the primary key of the segment
	 * @return the segment that was removed
	 * @throws NoSuchSegmentException if a segment with the primary key could not be found
	 */
	@Override
	public Segment remove(long segmentId) throws NoSuchSegmentException {
		return remove((Serializable)segmentId);
	}

	/**
	 * Removes the segment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the segment
	 * @return the segment that was removed
	 * @throws NoSuchSegmentException if a segment with the primary key could not be found
	 */
	@Override
	public Segment remove(Serializable primaryKey)
		throws NoSuchSegmentException {

		Session session = null;

		try {
			session = openSession();

			Segment segment = (Segment)session.get(
				SegmentImpl.class, primaryKey);

			if (segment == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSegmentException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(segment);
		}
		catch (NoSuchSegmentException noSuchEntityException) {
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
	protected Segment removeImpl(Segment segment) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(segment)) {
				segment = (Segment)session.get(
					SegmentImpl.class, segment.getPrimaryKeyObj());
			}

			if (segment != null) {
				session.delete(segment);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (segment != null) {
			clearCache(segment);
		}

		return segment;
	}

	@Override
	public Segment updateImpl(Segment segment) {
		boolean isNew = segment.isNew();

		if (!(segment instanceof SegmentModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(segment.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(segment);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in segment proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Segment implementation " +
					segment.getClass());
		}

		SegmentModelImpl segmentModelImpl = (SegmentModelImpl)segment;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(segment);
			}
			else {
				segment = (Segment)session.merge(segment);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			SegmentImpl.class, segmentModelImpl, false, true);

		if (isNew) {
			segment.setNew(false);
		}

		segment.resetOriginalValues();

		return segment;
	}

	/**
	 * Returns the segment with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the segment
	 * @return the segment
	 * @throws NoSuchSegmentException if a segment with the primary key could not be found
	 */
	@Override
	public Segment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSegmentException {

		Segment segment = fetchByPrimaryKey(primaryKey);

		if (segment == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSegmentException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return segment;
	}

	/**
	 * Returns the segment with the primary key or throws a <code>NoSuchSegmentException</code> if it could not be found.
	 *
	 * @param segmentId the primary key of the segment
	 * @return the segment
	 * @throws NoSuchSegmentException if a segment with the primary key could not be found
	 */
	@Override
	public Segment findByPrimaryKey(long segmentId)
		throws NoSuchSegmentException {

		return findByPrimaryKey((Serializable)segmentId);
	}

	/**
	 * Returns the segment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param segmentId the primary key of the segment
	 * @return the segment, or <code>null</code> if a segment with the primary key could not be found
	 */
	@Override
	public Segment fetchByPrimaryKey(long segmentId) {
		return fetchByPrimaryKey((Serializable)segmentId);
	}

	/**
	 * Returns all the segments.
	 *
	 * @return the segments
	 */
	@Override
	public List<Segment> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the segments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @return the range of segments
	 */
	@Override
	public List<Segment> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the segments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of segments
	 */
	@Override
	public List<Segment> findAll(
		int start, int end, OrderByComparator<Segment> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the segments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of segments
	 */
	@Override
	public List<Segment> findAll(
		int start, int end, OrderByComparator<Segment> orderByComparator,
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

		List<Segment> list = null;

		if (useFinderCache) {
			list = (List<Segment>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SEGMENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SEGMENT;

				sql = sql.concat(SegmentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Segment>)QueryUtil.list(
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
	 * Removes all the segments from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Segment segment : findAll()) {
			remove(segment);
		}
	}

	/**
	 * Returns the number of segments.
	 *
	 * @return the number of segments
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SEGMENT);

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
		return "segmentId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SEGMENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SegmentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the segment persistence.
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

		_finderPathWithPaginationFindBychildResourceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBychildResourceId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"childResourceId"}, true);

		_finderPathWithoutPaginationFindBychildResourceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBychildResourceId",
			new String[] {Long.class.getName()},
			new String[] {"childResourceId"}, true);

		_finderPathCountBychildResourceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBychildResourceId",
			new String[] {Long.class.getName()},
			new String[] {"childResourceId"}, false);

		_finderPathWithPaginationFindByfeatureSegments = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByfeatureSegments",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"featureId"}, true);

		_finderPathWithoutPaginationFindByfeatureSegments = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByfeatureSegments",
			new String[] {Long.class.getName()}, new String[] {"featureId"},
			true);

		_finderPathCountByfeatureSegments = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfeatureSegments",
			new String[] {Long.class.getName()}, new String[] {"featureId"},
			false);

		SegmentUtil.setPersistence(this);
	}

	public void destroy() {
		SegmentUtil.setPersistence(null);

		dummyEntityCache.removeCache(SegmentImpl.class.getName());
	}

	private static final String _SQL_SELECT_SEGMENT =
		"SELECT segment FROM Segment segment";

	private static final String _SQL_SELECT_SEGMENT_WHERE =
		"SELECT segment FROM Segment segment WHERE ";

	private static final String _SQL_COUNT_SEGMENT =
		"SELECT COUNT(segment) FROM Segment segment";

	private static final String _SQL_COUNT_SEGMENT_WHERE =
		"SELECT COUNT(segment) FROM Segment segment WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "segment.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Segment exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Segment exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SegmentPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}