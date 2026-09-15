/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.model.Segment;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the segment service. This utility wraps <code>com.ejada.telemony.db.service.persistence.impl.SegmentPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SegmentPersistence
 * @generated
 */
public class SegmentUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Segment segment) {
		getPersistence().clearCache(segment);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Segment> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Segment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Segment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Segment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Segment> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Segment update(Segment segment) {
		return getPersistence().update(segment);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Segment update(
		Segment segment, ServiceContext serviceContext) {

		return getPersistence().update(segment, serviceContext);
	}

	/**
	 * Returns all the segments where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the matching segments
	 */
	public static List<Segment> findByEntityResourceId(long entityResourceId) {
		return getPersistence().findByEntityResourceId(entityResourceId);
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
	public static List<Segment> findByEntityResourceId(
		long entityResourceId, int start, int end) {

		return getPersistence().findByEntityResourceId(
			entityResourceId, start, end);
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
	public static List<Segment> findByEntityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<Segment> orderByComparator) {

		return getPersistence().findByEntityResourceId(
			entityResourceId, start, end, orderByComparator);
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
	public static List<Segment> findByEntityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<Segment> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByEntityResourceId(
			entityResourceId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first segment in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment
	 * @throws NoSuchSegmentException if a matching segment could not be found
	 */
	public static Segment findByEntityResourceId_First(
			long entityResourceId, OrderByComparator<Segment> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchSegmentException {

		return getPersistence().findByEntityResourceId_First(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the first segment in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment, or <code>null</code> if a matching segment could not be found
	 */
	public static Segment fetchByEntityResourceId_First(
		long entityResourceId, OrderByComparator<Segment> orderByComparator) {

		return getPersistence().fetchByEntityResourceId_First(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the last segment in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment
	 * @throws NoSuchSegmentException if a matching segment could not be found
	 */
	public static Segment findByEntityResourceId_Last(
			long entityResourceId, OrderByComparator<Segment> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchSegmentException {

		return getPersistence().findByEntityResourceId_Last(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the last segment in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment, or <code>null</code> if a matching segment could not be found
	 */
	public static Segment fetchByEntityResourceId_Last(
		long entityResourceId, OrderByComparator<Segment> orderByComparator) {

		return getPersistence().fetchByEntityResourceId_Last(
			entityResourceId, orderByComparator);
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
	public static Segment[] findByEntityResourceId_PrevAndNext(
			long segmentId, long entityResourceId,
			OrderByComparator<Segment> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchSegmentException {

		return getPersistence().findByEntityResourceId_PrevAndNext(
			segmentId, entityResourceId, orderByComparator);
	}

	/**
	 * Removes all the segments where entityResourceId = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 */
	public static void removeByEntityResourceId(long entityResourceId) {
		getPersistence().removeByEntityResourceId(entityResourceId);
	}

	/**
	 * Returns the number of segments where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the number of matching segments
	 */
	public static int countByEntityResourceId(long entityResourceId) {
		return getPersistence().countByEntityResourceId(entityResourceId);
	}

	/**
	 * Returns all the segments where childResourceId = &#63;.
	 *
	 * @param childResourceId the child resource ID
	 * @return the matching segments
	 */
	public static List<Segment> findBychildResourceId(long childResourceId) {
		return getPersistence().findBychildResourceId(childResourceId);
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
	public static List<Segment> findBychildResourceId(
		long childResourceId, int start, int end) {

		return getPersistence().findBychildResourceId(
			childResourceId, start, end);
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
	public static List<Segment> findBychildResourceId(
		long childResourceId, int start, int end,
		OrderByComparator<Segment> orderByComparator) {

		return getPersistence().findBychildResourceId(
			childResourceId, start, end, orderByComparator);
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
	public static List<Segment> findBychildResourceId(
		long childResourceId, int start, int end,
		OrderByComparator<Segment> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBychildResourceId(
			childResourceId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first segment in the ordered set where childResourceId = &#63;.
	 *
	 * @param childResourceId the child resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment
	 * @throws NoSuchSegmentException if a matching segment could not be found
	 */
	public static Segment findBychildResourceId_First(
			long childResourceId, OrderByComparator<Segment> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchSegmentException {

		return getPersistence().findBychildResourceId_First(
			childResourceId, orderByComparator);
	}

	/**
	 * Returns the first segment in the ordered set where childResourceId = &#63;.
	 *
	 * @param childResourceId the child resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment, or <code>null</code> if a matching segment could not be found
	 */
	public static Segment fetchBychildResourceId_First(
		long childResourceId, OrderByComparator<Segment> orderByComparator) {

		return getPersistence().fetchBychildResourceId_First(
			childResourceId, orderByComparator);
	}

	/**
	 * Returns the last segment in the ordered set where childResourceId = &#63;.
	 *
	 * @param childResourceId the child resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment
	 * @throws NoSuchSegmentException if a matching segment could not be found
	 */
	public static Segment findBychildResourceId_Last(
			long childResourceId, OrderByComparator<Segment> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchSegmentException {

		return getPersistence().findBychildResourceId_Last(
			childResourceId, orderByComparator);
	}

	/**
	 * Returns the last segment in the ordered set where childResourceId = &#63;.
	 *
	 * @param childResourceId the child resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment, or <code>null</code> if a matching segment could not be found
	 */
	public static Segment fetchBychildResourceId_Last(
		long childResourceId, OrderByComparator<Segment> orderByComparator) {

		return getPersistence().fetchBychildResourceId_Last(
			childResourceId, orderByComparator);
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
	public static Segment[] findBychildResourceId_PrevAndNext(
			long segmentId, long childResourceId,
			OrderByComparator<Segment> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchSegmentException {

		return getPersistence().findBychildResourceId_PrevAndNext(
			segmentId, childResourceId, orderByComparator);
	}

	/**
	 * Removes all the segments where childResourceId = &#63; from the database.
	 *
	 * @param childResourceId the child resource ID
	 */
	public static void removeBychildResourceId(long childResourceId) {
		getPersistence().removeBychildResourceId(childResourceId);
	}

	/**
	 * Returns the number of segments where childResourceId = &#63;.
	 *
	 * @param childResourceId the child resource ID
	 * @return the number of matching segments
	 */
	public static int countBychildResourceId(long childResourceId) {
		return getPersistence().countBychildResourceId(childResourceId);
	}

	/**
	 * Returns all the segments where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @return the matching segments
	 */
	public static List<Segment> findByfeatureSegments(long featureId) {
		return getPersistence().findByfeatureSegments(featureId);
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
	public static List<Segment> findByfeatureSegments(
		long featureId, int start, int end) {

		return getPersistence().findByfeatureSegments(featureId, start, end);
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
	public static List<Segment> findByfeatureSegments(
		long featureId, int start, int end,
		OrderByComparator<Segment> orderByComparator) {

		return getPersistence().findByfeatureSegments(
			featureId, start, end, orderByComparator);
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
	public static List<Segment> findByfeatureSegments(
		long featureId, int start, int end,
		OrderByComparator<Segment> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByfeatureSegments(
			featureId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first segment in the ordered set where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment
	 * @throws NoSuchSegmentException if a matching segment could not be found
	 */
	public static Segment findByfeatureSegments_First(
			long featureId, OrderByComparator<Segment> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchSegmentException {

		return getPersistence().findByfeatureSegments_First(
			featureId, orderByComparator);
	}

	/**
	 * Returns the first segment in the ordered set where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment, or <code>null</code> if a matching segment could not be found
	 */
	public static Segment fetchByfeatureSegments_First(
		long featureId, OrderByComparator<Segment> orderByComparator) {

		return getPersistence().fetchByfeatureSegments_First(
			featureId, orderByComparator);
	}

	/**
	 * Returns the last segment in the ordered set where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment
	 * @throws NoSuchSegmentException if a matching segment could not be found
	 */
	public static Segment findByfeatureSegments_Last(
			long featureId, OrderByComparator<Segment> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchSegmentException {

		return getPersistence().findByfeatureSegments_Last(
			featureId, orderByComparator);
	}

	/**
	 * Returns the last segment in the ordered set where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment, or <code>null</code> if a matching segment could not be found
	 */
	public static Segment fetchByfeatureSegments_Last(
		long featureId, OrderByComparator<Segment> orderByComparator) {

		return getPersistence().fetchByfeatureSegments_Last(
			featureId, orderByComparator);
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
	public static Segment[] findByfeatureSegments_PrevAndNext(
			long segmentId, long featureId,
			OrderByComparator<Segment> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchSegmentException {

		return getPersistence().findByfeatureSegments_PrevAndNext(
			segmentId, featureId, orderByComparator);
	}

	/**
	 * Removes all the segments where featureId = &#63; from the database.
	 *
	 * @param featureId the feature ID
	 */
	public static void removeByfeatureSegments(long featureId) {
		getPersistence().removeByfeatureSegments(featureId);
	}

	/**
	 * Returns the number of segments where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @return the number of matching segments
	 */
	public static int countByfeatureSegments(long featureId) {
		return getPersistence().countByfeatureSegments(featureId);
	}

	/**
	 * Caches the segment in the entity cache if it is enabled.
	 *
	 * @param segment the segment
	 */
	public static void cacheResult(Segment segment) {
		getPersistence().cacheResult(segment);
	}

	/**
	 * Caches the segments in the entity cache if it is enabled.
	 *
	 * @param segments the segments
	 */
	public static void cacheResult(List<Segment> segments) {
		getPersistence().cacheResult(segments);
	}

	/**
	 * Creates a new segment with the primary key. Does not add the segment to the database.
	 *
	 * @param segmentId the primary key for the new segment
	 * @return the new segment
	 */
	public static Segment create(long segmentId) {
		return getPersistence().create(segmentId);
	}

	/**
	 * Removes the segment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param segmentId the primary key of the segment
	 * @return the segment that was removed
	 * @throws NoSuchSegmentException if a segment with the primary key could not be found
	 */
	public static Segment remove(long segmentId)
		throws com.ejada.telemony.db.exception.NoSuchSegmentException {

		return getPersistence().remove(segmentId);
	}

	public static Segment updateImpl(Segment segment) {
		return getPersistence().updateImpl(segment);
	}

	/**
	 * Returns the segment with the primary key or throws a <code>NoSuchSegmentException</code> if it could not be found.
	 *
	 * @param segmentId the primary key of the segment
	 * @return the segment
	 * @throws NoSuchSegmentException if a segment with the primary key could not be found
	 */
	public static Segment findByPrimaryKey(long segmentId)
		throws com.ejada.telemony.db.exception.NoSuchSegmentException {

		return getPersistence().findByPrimaryKey(segmentId);
	}

	/**
	 * Returns the segment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param segmentId the primary key of the segment
	 * @return the segment, or <code>null</code> if a segment with the primary key could not be found
	 */
	public static Segment fetchByPrimaryKey(long segmentId) {
		return getPersistence().fetchByPrimaryKey(segmentId);
	}

	/**
	 * Returns all the segments.
	 *
	 * @return the segments
	 */
	public static List<Segment> findAll() {
		return getPersistence().findAll();
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
	public static List<Segment> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Segment> findAll(
		int start, int end, OrderByComparator<Segment> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Segment> findAll(
		int start, int end, OrderByComparator<Segment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the segments from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of segments.
	 *
	 * @return the number of segments
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SegmentPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(SegmentPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile SegmentPersistence _persistence;

}