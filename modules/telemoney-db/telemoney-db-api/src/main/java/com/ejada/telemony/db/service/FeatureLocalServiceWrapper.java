/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link FeatureLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FeatureLocalService
 * @generated
 */
public class FeatureLocalServiceWrapper
	implements FeatureLocalService, ServiceWrapper<FeatureLocalService> {

	public FeatureLocalServiceWrapper() {
		this(null);
	}

	public FeatureLocalServiceWrapper(FeatureLocalService featureLocalService) {
		_featureLocalService = featureLocalService;
	}

	/**
	 * Adds the feature to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FeatureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param feature the feature
	 * @return the feature that was added
	 */
	@Override
	public com.ejada.telemony.db.model.Feature addFeature(
		com.ejada.telemony.db.model.Feature feature) {

		return _featureLocalService.addFeature(feature);
	}

	@Override
	public void addFeature(
			String featureName, String pageType, long parentPage,
			String routeId, Boolean status, long blockId, long channelId,
			java.util.List<String> whitelistLovData,
			java.util.List<String> segmentsLovData,
			com.liferay.portal.kernel.model.User user,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   com.liferay.portal.kernel.exception.PortalException {

		_featureLocalService.addFeature(
			featureName, pageType, parentPage, routeId, status, blockId,
			channelId, whitelistLovData, segmentsLovData, user, serviceContext);
	}

	@Override
	public Boolean checkIfParentHaveChildren(long entityResourceId) {
		return _featureLocalService.checkIfParentHaveChildren(entityResourceId);
	}

	/**
	 * Creates a new feature with the primary key. Does not add the feature to the database.
	 *
	 * @param featureId the primary key for the new feature
	 * @return the new feature
	 */
	@Override
	public com.ejada.telemony.db.model.Feature createFeature(long featureId) {
		return _featureLocalService.createFeature(featureId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _featureLocalService.createPersistedModel(primaryKeyObj);
	}

	@Override
	public void delete(long featureId) throws Exception {
		_featureLocalService.delete(featureId);
	}

	/**
	 * Deletes the feature from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FeatureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param feature the feature
	 * @return the feature that was removed
	 */
	@Override
	public com.ejada.telemony.db.model.Feature deleteFeature(
		com.ejada.telemony.db.model.Feature feature) {

		return _featureLocalService.deleteFeature(feature);
	}

	/**
	 * Deletes the feature with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FeatureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param featureId the primary key of the feature
	 * @return the feature that was removed
	 * @throws PortalException if a feature with the primary key could not be found
	 */
	@Override
	public com.ejada.telemony.db.model.Feature deleteFeature(long featureId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _featureLocalService.deleteFeature(featureId);
	}

	@Override
	public void deleteFeatureWithItsSegments(
			long featureId, com.liferay.portal.kernel.model.User user)
		throws Exception {

		_featureLocalService.deleteFeatureWithItsSegments(featureId, user);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _featureLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _featureLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _featureLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _featureLocalService.dynamicQuery();
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

		return _featureLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.FeatureModelImpl</code>.
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

		return _featureLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.FeatureModelImpl</code>.
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

		return _featureLocalService.dynamicQuery(
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

		return _featureLocalService.dynamicQueryCount(dynamicQuery);
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

		return _featureLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.ejada.telemony.db.model.Feature fetchFeature(long featureId) {
		return _featureLocalService.fetchFeature(featureId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Feature>
		findByOriginalEntityIdAndStatus(long originalEntityId, int status) {

		return _featureLocalService.findByOriginalEntityIdAndStatus(
			originalEntityId, status);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _featureLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Feature>
		getAllChildrenFeatures(long entityResourceId, int status) {

		return _featureLocalService.getAllChildrenFeatures(
			entityResourceId, status);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getAllFeaturesForSegment(
		long channelId, String segmentName, String deviceType,
		String deviceVersion) {

		return _featureLocalService.getAllFeaturesForSegment(
			channelId, segmentName, deviceType, deviceVersion);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Feature>
		getAllParentPages(Long channelId) {

		return _featureLocalService.getAllParentPages(channelId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getBlueAppFeatures(
		long channelId, java.util.List<String> whitelistFilter,
		java.util.List<String> segmentsFilter) {

		return _featureLocalService.getBlueAppFeatures(
			channelId, whitelistFilter, segmentsFilter);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Feature>
		getByChildResourceId(long childResourceId) {

		return _featureLocalService.getByChildResourceId(childResourceId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Feature>
		getByEntityResourceId(long entityResourceId) {

		return _featureLocalService.getByEntityResourceId(entityResourceId);
	}

	/**
	 * Returns the feature with the primary key.
	 *
	 * @param featureId the primary key of the feature
	 * @return the feature
	 * @throws PortalException if a feature with the primary key could not be found
	 */
	@Override
	public com.ejada.telemony.db.model.Feature getFeature(long featureId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _featureLocalService.getFeature(featureId);
	}

	/**
	 * Returns a range of all the features.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.FeatureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of features
	 * @param end the upper bound of the range of features (not inclusive)
	 * @return the range of features
	 */
	@Override
	public java.util.List<com.ejada.telemony.db.model.Feature> getFeatures(
		int start, int end) {

		return _featureLocalService.getFeatures(start, end);
	}

	/**
	 * Returns the number of features.
	 *
	 * @return the number of features
	 */
	@Override
	public int getFeaturesCount() {
		return _featureLocalService.getFeaturesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _featureLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Feature>
		getLatestApprovedByChannelId(long channelId) {

		return _featureLocalService.getLatestApprovedByChannelId(channelId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _featureLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _featureLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public void handleDeleteFeature(
			com.ejada.telemony.db.model.Feature originalFeature,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws Exception {

		_featureLocalService.handleDeleteFeature(
			originalFeature, serviceContext, user);
	}

	@Override
	public boolean isLinkedToLocalization(Long featureId, Long channelId) {
		return _featureLocalService.isLinkedToLocalization(
			featureId, channelId);
	}

	@Override
	public boolean isLinkedToResources(Long featureId, Long channelId) {
		return _featureLocalService.isLinkedToResources(featureId, channelId);
	}

	@Override
	public boolean isLovDataLinkedToApprovedFeature(
		long lovEntityResourceId, String lovDataCode) {

		return _featureLocalService.isLovDataLinkedToApprovedFeature(
			lovEntityResourceId, lovDataCode);
	}

	@Override
	public void turnOffChildrenFeatures(
		long entityResourceId, long draftFeatureId) {

		_featureLocalService.turnOffChildrenFeatures(
			entityResourceId, draftFeatureId);
	}

	/**
	 * Updates the feature in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FeatureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param feature the feature
	 * @return the feature that was updated
	 */
	@Override
	public com.ejada.telemony.db.model.Feature updateFeature(
		com.ejada.telemony.db.model.Feature feature) {

		return _featureLocalService.updateFeature(feature);
	}

	@Override
	public void updateFeature(
			String featureName, String pageType, long parentPage,
			String routeId, Boolean status, Long channelId,
			com.ejada.telemoney.db.dto.BlockDTO blockDTO,
			java.util.List<String> whitelistLovData,
			java.util.List<String> segmentsLovData,
			com.ejada.telemony.db.model.Feature originalFeature,
			com.liferay.portal.kernel.model.User user,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   com.liferay.portal.kernel.exception.PortalException {

		_featureLocalService.updateFeature(
			featureName, pageType, parentPage, routeId, status, channelId,
			blockDTO, whitelistLovData, segmentsLovData, originalFeature, user,
			serviceContext);
	}

	@Override
	public void updateSegment(
			long segmentId, String name, Boolean status, String method,
			String popUpTitle, String popUpSubTitle,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   com.liferay.portal.kernel.exception.PortalException {

		_featureLocalService.updateSegment(
			segmentId, name, status, method, popUpTitle, popUpSubTitle,
			serviceContext, user);
	}

	@Override
	public com.ejada.telemony.db.model.Feature updateStatus(
			long userId, long featureId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws Exception {

		return _featureLocalService.updateStatus(
			userId, featureId, status, serviceContext);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _featureLocalService.getBasePersistence();
	}

	@Override
	public FeatureLocalService getWrappedService() {
		return _featureLocalService;
	}

	@Override
	public void setWrappedService(FeatureLocalService featureLocalService) {
		_featureLocalService = featureLocalService;
	}

	private FeatureLocalService _featureLocalService;

}