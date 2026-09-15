/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link FeatureLovMapLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FeatureLovMapLocalService
 * @generated
 */
public class FeatureLovMapLocalServiceWrapper
	implements FeatureLovMapLocalService,
			   ServiceWrapper<FeatureLovMapLocalService> {

	public FeatureLovMapLocalServiceWrapper() {
		this(null);
	}

	public FeatureLovMapLocalServiceWrapper(
		FeatureLovMapLocalService featureLovMapLocalService) {

		_featureLovMapLocalService = featureLovMapLocalService;
	}

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
	@Override
	public com.ejada.telemony.db.model.FeatureLovMap addFeatureLovMap(
		com.ejada.telemony.db.model.FeatureLovMap featureLovMap) {

		return _featureLovMapLocalService.addFeatureLovMap(featureLovMap);
	}

	/**
	 * Creates a new feature lov map with the primary key. Does not add the feature lov map to the database.
	 *
	 * @param id the primary key for the new feature lov map
	 * @return the new feature lov map
	 */
	@Override
	public com.ejada.telemony.db.model.FeatureLovMap createFeatureLovMap(
		long id) {

		return _featureLovMapLocalService.createFeatureLovMap(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _featureLovMapLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.ejada.telemony.db.model.FeatureLovMap deleteFeatureLovMap(
		com.ejada.telemony.db.model.FeatureLovMap featureLovMap) {

		return _featureLovMapLocalService.deleteFeatureLovMap(featureLovMap);
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
	@Override
	public com.ejada.telemony.db.model.FeatureLovMap deleteFeatureLovMap(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _featureLovMapLocalService.deleteFeatureLovMap(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _featureLovMapLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _featureLovMapLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _featureLovMapLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _featureLovMapLocalService.dynamicQuery();
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

		return _featureLovMapLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _featureLovMapLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _featureLovMapLocalService.dynamicQuery(
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

		return _featureLovMapLocalService.dynamicQueryCount(dynamicQuery);
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

		return _featureLovMapLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.telemony.db.model.FeatureLovMap fetchFeatureLovMap(
		long id) {

		return _featureLovMapLocalService.fetchFeatureLovMap(id);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.FeatureLovMap>
		findByFeatureEntityResourceId(long featureEntityResourceId) {

		return _featureLovMapLocalService.findByFeatureEntityResourceId(
			featureEntityResourceId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.FeatureLovMap>
		findByFeatureEntityResourceIdAndLovType(
			long featureEntityResourceId, String lovType) {

		return _featureLovMapLocalService.
			findByFeatureEntityResourceIdAndLovType(
				featureEntityResourceId, lovType);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.FeatureLovMap>
		findByFeatureId(long featureId) {

		return _featureLovMapLocalService.findByFeatureId(featureId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.FeatureLovMap>
		findByFeatureIdAndLovType(long featureId, String lovType) {

		return _featureLovMapLocalService.findByFeatureIdAndLovType(
			featureId, lovType);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.FeatureLovMap>
		findByLovEntityResourceIdAndLovDataCode(
			long lovEntityResourceId, String lovDataCode) {

		return _featureLovMapLocalService.
			findByLovEntityResourceIdAndLovDataCode(
				lovEntityResourceId, lovDataCode);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _featureLovMapLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the feature lov map with the primary key.
	 *
	 * @param id the primary key of the feature lov map
	 * @return the feature lov map
	 * @throws PortalException if a feature lov map with the primary key could not be found
	 */
	@Override
	public com.ejada.telemony.db.model.FeatureLovMap getFeatureLovMap(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _featureLovMapLocalService.getFeatureLovMap(id);
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
	@Override
	public java.util.List<com.ejada.telemony.db.model.FeatureLovMap>
		getFeatureLovMaps(int start, int end) {

		return _featureLovMapLocalService.getFeatureLovMaps(start, end);
	}

	/**
	 * Returns the number of feature lov maps.
	 *
	 * @return the number of feature lov maps
	 */
	@Override
	public int getFeatureLovMapsCount() {
		return _featureLovMapLocalService.getFeatureLovMapsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _featureLovMapLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _featureLovMapLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _featureLovMapLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public com.ejada.telemony.db.model.FeatureLovMap updateFeatureLovMap(
		com.ejada.telemony.db.model.FeatureLovMap featureLovMap) {

		return _featureLovMapLocalService.updateFeatureLovMap(featureLovMap);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _featureLovMapLocalService.getBasePersistence();
	}

	@Override
	public FeatureLovMapLocalService getWrappedService() {
		return _featureLovMapLocalService;
	}

	@Override
	public void setWrappedService(
		FeatureLovMapLocalService featureLovMapLocalService) {

		_featureLovMapLocalService = featureLovMapLocalService;
	}

	private FeatureLovMapLocalService _featureLovMapLocalService;

}