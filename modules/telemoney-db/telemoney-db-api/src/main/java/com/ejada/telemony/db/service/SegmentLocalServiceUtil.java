/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.ejada.telemony.db.model.Segment;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Segment. This utility wraps
 * <code>com.ejada.telemony.db.service.impl.SegmentLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SegmentLocalService
 * @generated
 */
public class SegmentLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.SegmentLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Segment addSegment(
		long featureId, String name, Boolean status, String method,
		String popUpTitle, String popUpSubTitle) {

		return getService().addSegment(
			featureId, name, status, method, popUpTitle, popUpSubTitle);
	}

	/**
	 * Adds the segment to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SegmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param segment the segment
	 * @return the segment that was added
	 */
	public static Segment addSegment(Segment segment) {
		return getService().addSegment(segment);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new segment with the primary key. Does not add the segment to the database.
	 *
	 * @param segmentId the primary key for the new segment
	 * @return the new segment
	 */
	public static Segment createSegment(long segmentId) {
		return getService().createSegment(segmentId);
	}

	public static void deleteAllSegmentsForFeature(List<Segment> segments)
		throws Exception {

		getService().deleteAllSegmentsForFeature(segments);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the segment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SegmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param segmentId the primary key of the segment
	 * @return the segment that was removed
	 * @throws PortalException if a segment with the primary key could not be found
	 */
	public static Segment deleteSegment(long segmentId) throws PortalException {
		return getService().deleteSegment(segmentId);
	}

	/**
	 * Deletes the segment from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SegmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param segment the segment
	 * @return the segment that was removed
	 */
	public static Segment deleteSegment(Segment segment) {
		return getService().deleteSegment(segment);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.SegmentModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.SegmentModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Segment fetchSegment(long segmentId) {
		return getService().fetchSegment(segmentId);
	}

	/**
	 * Find all segments by resource IDs regardless of status
	 * Used to check if any segment has pending/draft status
	 */
	public static List<Segment> findAllSegmentsByResourceIds(
		long entityResourceId, long childResourceId) {

		return getService().findAllSegmentsByResourceIds(
			entityResourceId, childResourceId);
	}

	/**
	 * Find segments by originalEntityId and status
	 * Used to detect pending segment versions (for segment update workflow)
	 */
	public static List<Segment> findByOriginalEntityIdAndStatus(
		long originalEntityId, int status) {

		return getService().findByOriginalEntityIdAndStatus(
			originalEntityId, status);
	}

	public static List<Segment> findFeatureSegments(long featureId) {
		return getService().findFeatureSegments(featureId);
	}

	public static List<Segment> findSegmentsByFeatureId(long featureId) {
		return getService().findSegmentsByFeatureId(featureId);
	}

	public static List<Segment> findSegmentsByResourceIds(
		long entityResourceId, long childResourceId) {

		return getService().findSegmentsByResourceIds(
			entityResourceId, childResourceId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<Segment> getAllSegments() {
		return getService().getAllSegments();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the segment with the primary key.
	 *
	 * @param segmentId the primary key of the segment
	 * @return the segment
	 * @throws PortalException if a segment with the primary key could not be found
	 */
	public static Segment getSegment(long segmentId) throws PortalException {
		return getService().getSegment(segmentId);
	}

	/**
	 * Returns a range of all the segments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.SegmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @return the range of segments
	 */
	public static List<Segment> getSegments(int start, int end) {
		return getService().getSegments(start, end);
	}

	/**
	 * Returns the number of segments.
	 *
	 * @return the number of segments
	 */
	public static int getSegmentsCount() {
		return getService().getSegmentsCount();
	}

	public static void turnOffAllSegmentsStatusForFeature(long featureId) {
		getService().turnOffAllSegmentsStatusForFeature(featureId);
	}

	public static void updateSegment(
		long segmentId, String name, Boolean status, String method,
		String popUpTitle, String popUpSubTitle) {

		getService().updateSegment(
			segmentId, name, status, method, popUpTitle, popUpSubTitle);
	}

	/**
	 * Updates the segment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SegmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param segment the segment
	 * @return the segment that was updated
	 */
	public static Segment updateSegment(Segment segment) {
		return getService().updateSegment(segment);
	}

	public static SegmentLocalService getService() {
		return _service;
	}

	public static void setService(SegmentLocalService service) {
		_service = service;
	}

	private static volatile SegmentLocalService _service;

}