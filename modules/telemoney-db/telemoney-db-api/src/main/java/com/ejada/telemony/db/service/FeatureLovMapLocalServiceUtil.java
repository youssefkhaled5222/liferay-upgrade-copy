/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.ejada.telemony.db.model.FeatureLovMap;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for FeatureLovMap. This utility wraps
 * <code>com.ejada.telemony.db.service.impl.FeatureLovMapLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see FeatureLovMapLocalService
 * @generated
 */
public class FeatureLovMapLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.FeatureLovMapLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the feature lov map to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FeatureLovMapLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param featureLovMap the feature lov map
	 * @return the feature lov map that was added
	 */
	public static FeatureLovMap addFeatureLovMap(FeatureLovMap featureLovMap) {
		return getService().addFeatureLovMap(featureLovMap);
	}

	/**
	 * Creates a new feature lov map with the primary key. Does not add the feature lov map to the database.
	 *
	 * @param id the primary key for the new feature lov map
	 * @return the new feature lov map
	 */
	public static FeatureLovMap createFeatureLovMap(long id) {
		return getService().createFeatureLovMap(id);
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
	 * Deletes the feature lov map from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FeatureLovMapLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param featureLovMap the feature lov map
	 * @return the feature lov map that was removed
	 */
	public static FeatureLovMap deleteFeatureLovMap(
		FeatureLovMap featureLovMap) {

		return getService().deleteFeatureLovMap(featureLovMap);
	}

	/**
	 * Deletes the feature lov map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FeatureLovMapLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the feature lov map
	 * @return the feature lov map that was removed
	 * @throws PortalException if a feature lov map with the primary key could not be found
	 */
	public static FeatureLovMap deleteFeatureLovMap(long id)
		throws PortalException {

		return getService().deleteFeatureLovMap(id);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.FeatureLovMapModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.FeatureLovMapModelImpl</code>.
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

	public static FeatureLovMap fetchFeatureLovMap(long id) {
		return getService().fetchFeatureLovMap(id);
	}

	public static List<FeatureLovMap> findByFeatureEntityResourceId(
		long featureEntityResourceId) {

		return getService().findByFeatureEntityResourceId(
			featureEntityResourceId);
	}

	public static List<FeatureLovMap> findByFeatureEntityResourceIdAndLovType(
		long featureEntityResourceId, String lovType) {

		return getService().findByFeatureEntityResourceIdAndLovType(
			featureEntityResourceId, lovType);
	}

	public static List<FeatureLovMap> findByFeatureId(long featureId) {
		return getService().findByFeatureId(featureId);
	}

	public static List<FeatureLovMap> findByFeatureIdAndLovType(
		long featureId, String lovType) {

		return getService().findByFeatureIdAndLovType(featureId, lovType);
	}

	public static List<FeatureLovMap> findByLovEntityResourceIdAndLovDataCode(
		long lovEntityResourceId, String lovDataCode) {

		return getService().findByLovEntityResourceIdAndLovDataCode(
			lovEntityResourceId, lovDataCode);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the feature lov map with the primary key.
	 *
	 * @param id the primary key of the feature lov map
	 * @return the feature lov map
	 * @throws PortalException if a feature lov map with the primary key could not be found
	 */
	public static FeatureLovMap getFeatureLovMap(long id)
		throws PortalException {

		return getService().getFeatureLovMap(id);
	}

	/**
	 * Returns a range of all the feature lov maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.FeatureLovMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of feature lov maps
	 * @param end the upper bound of the range of feature lov maps (not inclusive)
	 * @return the range of feature lov maps
	 */
	public static List<FeatureLovMap> getFeatureLovMaps(int start, int end) {
		return getService().getFeatureLovMaps(start, end);
	}

	/**
	 * Returns the number of feature lov maps.
	 *
	 * @return the number of feature lov maps
	 */
	public static int getFeatureLovMapsCount() {
		return getService().getFeatureLovMapsCount();
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
	 * Updates the feature lov map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FeatureLovMapLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param featureLovMap the feature lov map
	 * @return the feature lov map that was updated
	 */
	public static FeatureLovMap updateFeatureLovMap(
		FeatureLovMap featureLovMap) {

		return getService().updateFeatureLovMap(featureLovMap);
	}

	public static FeatureLovMapLocalService getService() {
		return _service;
	}

	public static void setService(FeatureLovMapLocalService service) {
		_service = service;
	}

	private static volatile FeatureLovMapLocalService _service;

}