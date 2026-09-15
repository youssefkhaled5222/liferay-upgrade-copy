/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.ejada.telemony.db.model.Feature;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Feature. This utility wraps
 * <code>com.ejada.telemony.db.service.impl.FeatureLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see FeatureLocalService
 * @generated
 */
public class FeatureLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.FeatureLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static Feature addFeature(Feature feature) {
		return getService().addFeature(feature);
	}

	public static void addFeature(
			String featureName, String pageType, long parentPage,
			String routeId, Boolean status, long blockId, long channelId,
			List<String> whitelistLovData, List<String> segmentsLovData,
			com.liferay.portal.kernel.model.User user,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   PortalException {

		getService().addFeature(
			featureName, pageType, parentPage, routeId, status, blockId,
			channelId, whitelistLovData, segmentsLovData, user, serviceContext);
	}

	public static Boolean checkIfParentHaveChildren(long entityResourceId) {
		return getService().checkIfParentHaveChildren(entityResourceId);
	}

	/**
	 * Creates a new feature with the primary key. Does not add the feature to the database.
	 *
	 * @param featureId the primary key for the new feature
	 * @return the new feature
	 */
	public static Feature createFeature(long featureId) {
		return getService().createFeature(featureId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static void delete(long featureId) throws Exception {
		getService().delete(featureId);
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
	public static Feature deleteFeature(Feature feature) {
		return getService().deleteFeature(feature);
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
	public static Feature deleteFeature(long featureId) throws PortalException {
		return getService().deleteFeature(featureId);
	}

	public static void deleteFeatureWithItsSegments(
			long featureId, com.liferay.portal.kernel.model.User user)
		throws Exception {

		getService().deleteFeatureWithItsSegments(featureId, user);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.FeatureModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.FeatureModelImpl</code>.
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

	public static Feature fetchFeature(long featureId) {
		return getService().fetchFeature(featureId);
	}

	public static List<Feature> findByOriginalEntityIdAndStatus(
		long originalEntityId, int status) {

		return getService().findByOriginalEntityIdAndStatus(
			originalEntityId, status);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<Feature> getAllChildrenFeatures(
		long entityResourceId, int status) {

		return getService().getAllChildrenFeatures(entityResourceId, status);
	}

	public static com.liferay.portal.kernel.json.JSONArray
		getAllFeaturesForSegment(
			long channelId, String segmentName, String deviceType,
			String deviceVersion) {

		return getService().getAllFeaturesForSegment(
			channelId, segmentName, deviceType, deviceVersion);
	}

	public static List<Feature> getAllParentPages(Long channelId) {
		return getService().getAllParentPages(channelId);
	}

	public static com.liferay.portal.kernel.json.JSONObject getBlueAppFeatures(
		long channelId, List<String> whitelistFilter,
		List<String> segmentsFilter) {

		return getService().getBlueAppFeatures(
			channelId, whitelistFilter, segmentsFilter);
	}

	public static List<Feature> getByChildResourceId(long childResourceId) {
		return getService().getByChildResourceId(childResourceId);
	}

	public static List<Feature> getByEntityResourceId(long entityResourceId) {
		return getService().getByEntityResourceId(entityResourceId);
	}

	/**
	 * Returns the feature with the primary key.
	 *
	 * @param featureId the primary key of the feature
	 * @return the feature
	 * @throws PortalException if a feature with the primary key could not be found
	 */
	public static Feature getFeature(long featureId) throws PortalException {
		return getService().getFeature(featureId);
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
	public static List<Feature> getFeatures(int start, int end) {
		return getService().getFeatures(start, end);
	}

	/**
	 * Returns the number of features.
	 *
	 * @return the number of features
	 */
	public static int getFeaturesCount() {
		return getService().getFeaturesCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static List<Feature> getLatestApprovedByChannelId(long channelId) {
		return getService().getLatestApprovedByChannelId(channelId);
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

	public static void handleDeleteFeature(
			Feature originalFeature,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws Exception {

		getService().handleDeleteFeature(originalFeature, serviceContext, user);
	}

	public static boolean isLinkedToLocalization(
		Long featureId, Long channelId) {

		return getService().isLinkedToLocalization(featureId, channelId);
	}

	public static boolean isLinkedToResources(Long featureId, Long channelId) {
		return getService().isLinkedToResources(featureId, channelId);
	}

	public static boolean isLovDataLinkedToApprovedFeature(
		long lovEntityResourceId, String lovDataCode) {

		return getService().isLovDataLinkedToApprovedFeature(
			lovEntityResourceId, lovDataCode);
	}

	public static void turnOffChildrenFeatures(
		long entityResourceId, long draftFeatureId) {

		getService().turnOffChildrenFeatures(entityResourceId, draftFeatureId);
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
	public static Feature updateFeature(Feature feature) {
		return getService().updateFeature(feature);
	}

	public static void updateFeature(
			String featureName, String pageType, long parentPage,
			String routeId, Boolean status, Long channelId,
			com.ejada.telemoney.db.dto.BlockDTO blockDTO,
			List<String> whitelistLovData, List<String> segmentsLovData,
			Feature originalFeature, com.liferay.portal.kernel.model.User user,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   PortalException {

		getService().updateFeature(
			featureName, pageType, parentPage, routeId, status, channelId,
			blockDTO, whitelistLovData, segmentsLovData, originalFeature, user,
			serviceContext);
	}

	public static void updateSegment(
			long segmentId, String name, Boolean status, String method,
			String popUpTitle, String popUpSubTitle,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   PortalException {

		getService().updateSegment(
			segmentId, name, status, method, popUpTitle, popUpSubTitle,
			serviceContext, user);
	}

	public static Feature updateStatus(
			long userId, long featureId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws Exception {

		return getService().updateStatus(
			userId, featureId, status, serviceContext);
	}

	public static FeatureLocalService getService() {
		return _service;
	}

	public static void setService(FeatureLocalService service) {
		_service = service;
	}

	private static volatile FeatureLocalService _service;

}