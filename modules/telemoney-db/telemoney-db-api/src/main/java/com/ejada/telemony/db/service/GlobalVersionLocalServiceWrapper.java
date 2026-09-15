/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link GlobalVersionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see GlobalVersionLocalService
 * @generated
 */
public class GlobalVersionLocalServiceWrapper
	implements GlobalVersionLocalService,
			   ServiceWrapper<GlobalVersionLocalService> {

	public GlobalVersionLocalServiceWrapper() {
		this(null);
	}

	public GlobalVersionLocalServiceWrapper(
		GlobalVersionLocalService globalVersionLocalService) {

		_globalVersionLocalService = globalVersionLocalService;
	}

	/**
	 * Adds the global version to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GlobalVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param globalVersion the global version
	 * @return the global version that was added
	 */
	@Override
	public com.ejada.telemony.db.model.GlobalVersion addGlobalVersion(
		com.ejada.telemony.db.model.GlobalVersion globalVersion) {

		return _globalVersionLocalService.addGlobalVersion(globalVersion);
	}

	/**
	 * Creates a new global version with the primary key. Does not add the global version to the database.
	 *
	 * @param versionId the primary key for the new global version
	 * @return the new global version
	 */
	@Override
	public com.ejada.telemony.db.model.GlobalVersion createGlobalVersion(
		long versionId) {

		return _globalVersionLocalService.createGlobalVersion(versionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _globalVersionLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the global version from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GlobalVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param globalVersion the global version
	 * @return the global version that was removed
	 */
	@Override
	public com.ejada.telemony.db.model.GlobalVersion deleteGlobalVersion(
		com.ejada.telemony.db.model.GlobalVersion globalVersion) {

		return _globalVersionLocalService.deleteGlobalVersion(globalVersion);
	}

	/**
	 * Deletes the global version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GlobalVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param versionId the primary key of the global version
	 * @return the global version that was removed
	 * @throws PortalException if a global version with the primary key could not be found
	 */
	@Override
	public com.ejada.telemony.db.model.GlobalVersion deleteGlobalVersion(
			long versionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _globalVersionLocalService.deleteGlobalVersion(versionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _globalVersionLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _globalVersionLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _globalVersionLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _globalVersionLocalService.dynamicQuery();
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

		return _globalVersionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.GlobalVersionModelImpl</code>.
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

		return _globalVersionLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.GlobalVersionModelImpl</code>.
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

		return _globalVersionLocalService.dynamicQuery(
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

		return _globalVersionLocalService.dynamicQueryCount(dynamicQuery);
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

		return _globalVersionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.telemony.db.model.GlobalVersion fetchGlobalVersion(
		long versionId) {

		return _globalVersionLocalService.fetchGlobalVersion(versionId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _globalVersionLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the current approved internal version for the given
	 * company/channel/component, or {@code 0} if no version exists yet.
	 */
	@Override
	public long getCurrentVersion(
		long companyId, long channelId, String componentName) {

		return _globalVersionLocalService.getCurrentVersion(
			companyId, channelId, componentName);
	}

	/**
	 * Returns the global version with the primary key.
	 *
	 * @param versionId the primary key of the global version
	 * @return the global version
	 * @throws PortalException if a global version with the primary key could not be found
	 */
	@Override
	public com.ejada.telemony.db.model.GlobalVersion getGlobalVersion(
			long versionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _globalVersionLocalService.getGlobalVersion(versionId);
	}

	/**
	 * Returns a range of all the global versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.GlobalVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of global versions
	 * @param end the upper bound of the range of global versions (not inclusive)
	 * @return the range of global versions
	 */
	@Override
	public java.util.List<com.ejada.telemony.db.model.GlobalVersion>
		getGlobalVersions(int start, int end) {

		return _globalVersionLocalService.getGlobalVersions(start, end);
	}

	/**
	 * Returns the number of global versions.
	 *
	 * @return the number of global versions
	 */
	@Override
	public int getGlobalVersionsCount() {
		return _globalVersionLocalService.getGlobalVersionsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _globalVersionLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _globalVersionLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _globalVersionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Approval Update Flow (User Story 5.2).
	 *
	 * <p>
	 * Finds the record using companyId, channelId and componentName. Creates it
	 * with version 1 if it does not exist; otherwise increments the current
	 * version by 1. The {@code modifiedDate} is updated in the same
	 * transaction. This method must be called only after a component change is
	 * approved.
	 * </p>
	 *
	 * @param companyId company/tenant identifier
	 * @param channelId channel identifier
	 * @param componentName one of {@code ComponentType} names
	 (APP_CONFIGURATION, LOCALIZATION, ASSET_MANAGEMENT, FEATURE_FLAG)
	 * @return the created or updated {@link GlobalVersion} record
	 */
	@Override
	public com.ejada.telemony.db.model.GlobalVersion incrementApprovedVersion(
		long companyId, long channelId, String componentName) {

		return _globalVersionLocalService.incrementApprovedVersion(
			companyId, channelId, componentName);
	}

	/**
	 * Updates the global version in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GlobalVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param globalVersion the global version
	 * @return the global version that was updated
	 */
	@Override
	public com.ejada.telemony.db.model.GlobalVersion updateGlobalVersion(
		com.ejada.telemony.db.model.GlobalVersion globalVersion) {

		return _globalVersionLocalService.updateGlobalVersion(globalVersion);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _globalVersionLocalService.getBasePersistence();
	}

	@Override
	public GlobalVersionLocalService getWrappedService() {
		return _globalVersionLocalService;
	}

	@Override
	public void setWrappedService(
		GlobalVersionLocalService globalVersionLocalService) {

		_globalVersionLocalService = globalVersionLocalService;
	}

	private GlobalVersionLocalService _globalVersionLocalService;

}