/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link SegmentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SegmentLocalService
 * @generated
 */
public class SegmentLocalServiceWrapper
	implements SegmentLocalService, ServiceWrapper<SegmentLocalService> {

	public SegmentLocalServiceWrapper() {
		this(null);
	}

	public SegmentLocalServiceWrapper(SegmentLocalService segmentLocalService) {
		_segmentLocalService = segmentLocalService;
	}

	@Override
	public com.ejada.telemony.db.model.Segment addSegment(
		long featureId, String name, Boolean status, String method,
		String popUpTitle, String popUpSubTitle) {

		return _segmentLocalService.addSegment(
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
	@Override
	public com.ejada.telemony.db.model.Segment addSegment(
		com.ejada.telemony.db.model.Segment segment) {

		return _segmentLocalService.addSegment(segment);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _segmentLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new segment with the primary key. Does not add the segment to the database.
	 *
	 * @param segmentId the primary key for the new segment
	 * @return the new segment
	 */
	@Override
	public com.ejada.telemony.db.model.Segment createSegment(long segmentId) {
		return _segmentLocalService.createSegment(segmentId);
	}

	@Override
	public void deleteAllSegmentsForFeature(
			java.util.List<com.ejada.telemony.db.model.Segment> segments)
		throws Exception {

		_segmentLocalService.deleteAllSegmentsForFeature(segments);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _segmentLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public com.ejada.telemony.db.model.Segment deleteSegment(long segmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _segmentLocalService.deleteSegment(segmentId);
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
	@Override
	public com.ejada.telemony.db.model.Segment deleteSegment(
		com.ejada.telemony.db.model.Segment segment) {

		return _segmentLocalService.deleteSegment(segment);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _segmentLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _segmentLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _segmentLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _segmentLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _segmentLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _segmentLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _segmentLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _segmentLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.ejada.telemony.db.model.Segment fetchSegment(long segmentId) {
		return _segmentLocalService.fetchSegment(segmentId);
	}

	/**
	 * Find all segments by resource IDs regardless of status
	 * Used to check if any segment has pending/draft status
	 */
	@Override
	public java.util.List<com.ejada.telemony.db.model.Segment>
		findAllSegmentsByResourceIds(
			long entityResourceId, long childResourceId) {

		return _segmentLocalService.findAllSegmentsByResourceIds(
			entityResourceId, childResourceId);
	}

	/**
	 * Find segments by originalEntityId and status
	 * Used to detect pending segment versions (for segment update workflow)
	 */
	@Override
	public java.util.List<com.ejada.telemony.db.model.Segment>
		findByOriginalEntityIdAndStatus(long originalEntityId, int status) {

		return _segmentLocalService.findByOriginalEntityIdAndStatus(
			originalEntityId, status);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Segment>
		findFeatureSegments(long featureId) {

		return _segmentLocalService.findFeatureSegments(featureId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Segment>
		findSegmentsByFeatureId(long featureId) {

		return _segmentLocalService.findSegmentsByFeatureId(featureId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Segment>
		findSegmentsByResourceIds(long entityResourceId, long childResourceId) {

		return _segmentLocalService.findSegmentsByResourceIds(
			entityResourceId, childResourceId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _segmentLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Segment>
		getAllSegments() {

		return _segmentLocalService.getAllSegments();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _segmentLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _segmentLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _segmentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the segment with the primary key.
	 *
	 * @param segmentId the primary key of the segment
	 * @return the segment
	 * @throws PortalException if a segment with the primary key could not be found
	 */
	@Override
	public com.ejada.telemony.db.model.Segment getSegment(long segmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _segmentLocalService.getSegment(segmentId);
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
	@Override
	public java.util.List<com.ejada.telemony.db.model.Segment> getSegments(
		int start, int end) {

		return _segmentLocalService.getSegments(start, end);
	}

	/**
	 * Returns the number of segments.
	 *
	 * @return the number of segments
	 */
	@Override
	public int getSegmentsCount() {
		return _segmentLocalService.getSegmentsCount();
	}

	@Override
	public void turnOffAllSegmentsStatusForFeature(long featureId) {
		_segmentLocalService.turnOffAllSegmentsStatusForFeature(featureId);
	}

	@Override
	public void updateSegment(
		long segmentId, String name, Boolean status, String method,
		String popUpTitle, String popUpSubTitle) {

		_segmentLocalService.updateSegment(
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
	@Override
	public com.ejada.telemony.db.model.Segment updateSegment(
		com.ejada.telemony.db.model.Segment segment) {

		return _segmentLocalService.updateSegment(segment);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _segmentLocalService.getBasePersistence();
	}

	@Override
	public SegmentLocalService getWrappedService() {
		return _segmentLocalService;
	}

	@Override
	public void setWrappedService(SegmentLocalService segmentLocalService) {
		_segmentLocalService = segmentLocalService;
	}

	private SegmentLocalService _segmentLocalService;

}