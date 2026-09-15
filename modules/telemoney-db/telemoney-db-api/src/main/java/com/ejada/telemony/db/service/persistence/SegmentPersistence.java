/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.exception.NoSuchSegmentException;
import com.ejada.telemony.db.model.Segment;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the segment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SegmentUtil
 * @generated
 */
@ProviderType
public interface SegmentPersistence extends BasePersistence<Segment> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SegmentUtil} to access the segment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the segments where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the matching segments
	 */
	public java.util.List<Segment> findByEntityResourceId(
		long entityResourceId);

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
	public java.util.List<Segment> findByEntityResourceId(
		long entityResourceId, int start, int end);

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
	public java.util.List<Segment> findByEntityResourceId(
		long entityResourceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Segment>
			orderByComparator);

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
	public java.util.List<Segment> findByEntityResourceId(
		long entityResourceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Segment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first segment in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment
	 * @throws NoSuchSegmentException if a matching segment could not be found
	 */
	public Segment findByEntityResourceId_First(
			long entityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<Segment>
				orderByComparator)
		throws NoSuchSegmentException;

	/**
	 * Returns the first segment in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment, or <code>null</code> if a matching segment could not be found
	 */
	public Segment fetchByEntityResourceId_First(
		long entityResourceId,
		com.liferay.portal.kernel.util.OrderByComparator<Segment>
			orderByComparator);

	/**
	 * Returns the last segment in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment
	 * @throws NoSuchSegmentException if a matching segment could not be found
	 */
	public Segment findByEntityResourceId_Last(
			long entityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<Segment>
				orderByComparator)
		throws NoSuchSegmentException;

	/**
	 * Returns the last segment in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment, or <code>null</code> if a matching segment could not be found
	 */
	public Segment fetchByEntityResourceId_Last(
		long entityResourceId,
		com.liferay.portal.kernel.util.OrderByComparator<Segment>
			orderByComparator);

	/**
	 * Returns the segments before and after the current segment in the ordered set where entityResourceId = &#63;.
	 *
	 * @param segmentId the primary key of the current segment
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next segment
	 * @throws NoSuchSegmentException if a segment with the primary key could not be found
	 */
	public Segment[] findByEntityResourceId_PrevAndNext(
			long segmentId, long entityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<Segment>
				orderByComparator)
		throws NoSuchSegmentException;

	/**
	 * Removes all the segments where entityResourceId = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 */
	public void removeByEntityResourceId(long entityResourceId);

	/**
	 * Returns the number of segments where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the number of matching segments
	 */
	public int countByEntityResourceId(long entityResourceId);

	/**
	 * Returns all the segments where childResourceId = &#63;.
	 *
	 * @param childResourceId the child resource ID
	 * @return the matching segments
	 */
	public java.util.List<Segment> findBychildResourceId(long childResourceId);

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
	public java.util.List<Segment> findBychildResourceId(
		long childResourceId, int start, int end);

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
	public java.util.List<Segment> findBychildResourceId(
		long childResourceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Segment>
			orderByComparator);

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
	public java.util.List<Segment> findBychildResourceId(
		long childResourceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Segment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first segment in the ordered set where childResourceId = &#63;.
	 *
	 * @param childResourceId the child resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment
	 * @throws NoSuchSegmentException if a matching segment could not be found
	 */
	public Segment findBychildResourceId_First(
			long childResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<Segment>
				orderByComparator)
		throws NoSuchSegmentException;

	/**
	 * Returns the first segment in the ordered set where childResourceId = &#63;.
	 *
	 * @param childResourceId the child resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment, or <code>null</code> if a matching segment could not be found
	 */
	public Segment fetchBychildResourceId_First(
		long childResourceId,
		com.liferay.portal.kernel.util.OrderByComparator<Segment>
			orderByComparator);

	/**
	 * Returns the last segment in the ordered set where childResourceId = &#63;.
	 *
	 * @param childResourceId the child resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment
	 * @throws NoSuchSegmentException if a matching segment could not be found
	 */
	public Segment findBychildResourceId_Last(
			long childResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<Segment>
				orderByComparator)
		throws NoSuchSegmentException;

	/**
	 * Returns the last segment in the ordered set where childResourceId = &#63;.
	 *
	 * @param childResourceId the child resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment, or <code>null</code> if a matching segment could not be found
	 */
	public Segment fetchBychildResourceId_Last(
		long childResourceId,
		com.liferay.portal.kernel.util.OrderByComparator<Segment>
			orderByComparator);

	/**
	 * Returns the segments before and after the current segment in the ordered set where childResourceId = &#63;.
	 *
	 * @param segmentId the primary key of the current segment
	 * @param childResourceId the child resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next segment
	 * @throws NoSuchSegmentException if a segment with the primary key could not be found
	 */
	public Segment[] findBychildResourceId_PrevAndNext(
			long segmentId, long childResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<Segment>
				orderByComparator)
		throws NoSuchSegmentException;

	/**
	 * Removes all the segments where childResourceId = &#63; from the database.
	 *
	 * @param childResourceId the child resource ID
	 */
	public void removeBychildResourceId(long childResourceId);

	/**
	 * Returns the number of segments where childResourceId = &#63;.
	 *
	 * @param childResourceId the child resource ID
	 * @return the number of matching segments
	 */
	public int countBychildResourceId(long childResourceId);

	/**
	 * Returns all the segments where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @return the matching segments
	 */
	public java.util.List<Segment> findByfeatureSegments(long featureId);

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
	public java.util.List<Segment> findByfeatureSegments(
		long featureId, int start, int end);

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
	public java.util.List<Segment> findByfeatureSegments(
		long featureId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Segment>
			orderByComparator);

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
	public java.util.List<Segment> findByfeatureSegments(
		long featureId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Segment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first segment in the ordered set where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment
	 * @throws NoSuchSegmentException if a matching segment could not be found
	 */
	public Segment findByfeatureSegments_First(
			long featureId,
			com.liferay.portal.kernel.util.OrderByComparator<Segment>
				orderByComparator)
		throws NoSuchSegmentException;

	/**
	 * Returns the first segment in the ordered set where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment, or <code>null</code> if a matching segment could not be found
	 */
	public Segment fetchByfeatureSegments_First(
		long featureId,
		com.liferay.portal.kernel.util.OrderByComparator<Segment>
			orderByComparator);

	/**
	 * Returns the last segment in the ordered set where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment
	 * @throws NoSuchSegmentException if a matching segment could not be found
	 */
	public Segment findByfeatureSegments_Last(
			long featureId,
			com.liferay.portal.kernel.util.OrderByComparator<Segment>
				orderByComparator)
		throws NoSuchSegmentException;

	/**
	 * Returns the last segment in the ordered set where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment, or <code>null</code> if a matching segment could not be found
	 */
	public Segment fetchByfeatureSegments_Last(
		long featureId,
		com.liferay.portal.kernel.util.OrderByComparator<Segment>
			orderByComparator);

	/**
	 * Returns the segments before and after the current segment in the ordered set where featureId = &#63;.
	 *
	 * @param segmentId the primary key of the current segment
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next segment
	 * @throws NoSuchSegmentException if a segment with the primary key could not be found
	 */
	public Segment[] findByfeatureSegments_PrevAndNext(
			long segmentId, long featureId,
			com.liferay.portal.kernel.util.OrderByComparator<Segment>
				orderByComparator)
		throws NoSuchSegmentException;

	/**
	 * Removes all the segments where featureId = &#63; from the database.
	 *
	 * @param featureId the feature ID
	 */
	public void removeByfeatureSegments(long featureId);

	/**
	 * Returns the number of segments where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @return the number of matching segments
	 */
	public int countByfeatureSegments(long featureId);

	/**
	 * Caches the segment in the entity cache if it is enabled.
	 *
	 * @param segment the segment
	 */
	public void cacheResult(Segment segment);

	/**
	 * Caches the segments in the entity cache if it is enabled.
	 *
	 * @param segments the segments
	 */
	public void cacheResult(java.util.List<Segment> segments);

	/**
	 * Creates a new segment with the primary key. Does not add the segment to the database.
	 *
	 * @param segmentId the primary key for the new segment
	 * @return the new segment
	 */
	public Segment create(long segmentId);

	/**
	 * Removes the segment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param segmentId the primary key of the segment
	 * @return the segment that was removed
	 * @throws NoSuchSegmentException if a segment with the primary key could not be found
	 */
	public Segment remove(long segmentId) throws NoSuchSegmentException;

	public Segment updateImpl(Segment segment);

	/**
	 * Returns the segment with the primary key or throws a <code>NoSuchSegmentException</code> if it could not be found.
	 *
	 * @param segmentId the primary key of the segment
	 * @return the segment
	 * @throws NoSuchSegmentException if a segment with the primary key could not be found
	 */
	public Segment findByPrimaryKey(long segmentId)
		throws NoSuchSegmentException;

	/**
	 * Returns the segment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param segmentId the primary key of the segment
	 * @return the segment, or <code>null</code> if a segment with the primary key could not be found
	 */
	public Segment fetchByPrimaryKey(long segmentId);

	/**
	 * Returns all the segments.
	 *
	 * @return the segments
	 */
	public java.util.List<Segment> findAll();

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
	public java.util.List<Segment> findAll(int start, int end);

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
	public java.util.List<Segment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Segment>
			orderByComparator);

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
	public java.util.List<Segment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Segment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the segments from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of segments.
	 *
	 * @return the number of segments
	 */
	public int countAll();

}