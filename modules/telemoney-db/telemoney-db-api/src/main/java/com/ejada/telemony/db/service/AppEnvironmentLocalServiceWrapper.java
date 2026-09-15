/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link AppEnvironmentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AppEnvironmentLocalService
 * @generated
 */
public class AppEnvironmentLocalServiceWrapper
	implements AppEnvironmentLocalService,
			   ServiceWrapper<AppEnvironmentLocalService> {

	public AppEnvironmentLocalServiceWrapper() {
		this(null);
	}

	public AppEnvironmentLocalServiceWrapper(
		AppEnvironmentLocalService appEnvironmentLocalService) {

		_appEnvironmentLocalService = appEnvironmentLocalService;
	}

	/**
	 * Adds the app environment to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppEnvironmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appEnvironment the app environment
	 * @return the app environment that was added
	 */
	@Override
	public com.ejada.telemony.db.model.AppEnvironment addAppEnvironment(
		com.ejada.telemony.db.model.AppEnvironment appEnvironment) {

		return _appEnvironmentLocalService.addAppEnvironment(appEnvironment);
	}

	@Override
	public com.ejada.telemony.db.model.AppEnvironment addAppEnvironment(
		Long channelId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		com.liferay.portal.kernel.model.User user, String environmentName) {

		return _appEnvironmentLocalService.addAppEnvironment(
			channelId, serviceContext, user, environmentName);
	}

	@Override
	public com.ejada.telemony.db.model.AppEnvironment addAppEnvironment(
		Long channelId, String environmentName,
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		com.liferay.portal.kernel.model.User user) {

		return _appEnvironmentLocalService.addAppEnvironment(
			channelId, environmentName, serviceContext, user);
	}

	/**
	 * Creates a new app environment with the primary key. Does not add the app environment to the database.
	 *
	 * @param environmentId the primary key for the new app environment
	 * @return the new app environment
	 */
	@Override
	public com.ejada.telemony.db.model.AppEnvironment createAppEnvironment(
		long environmentId) {

		return _appEnvironmentLocalService.createAppEnvironment(environmentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appEnvironmentLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the app environment from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppEnvironmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appEnvironment the app environment
	 * @return the app environment that was removed
	 */
	@Override
	public com.ejada.telemony.db.model.AppEnvironment deleteAppEnvironment(
		com.ejada.telemony.db.model.AppEnvironment appEnvironment) {

		return _appEnvironmentLocalService.deleteAppEnvironment(appEnvironment);
	}

	/**
	 * Deletes the app environment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppEnvironmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param environmentId the primary key of the app environment
	 * @return the app environment that was removed
	 * @throws PortalException if a app environment with the primary key could not be found
	 */
	@Override
	public com.ejada.telemony.db.model.AppEnvironment deleteAppEnvironment(
			long environmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appEnvironmentLocalService.deleteAppEnvironment(environmentId);
	}

	@Override
	public void deleteAppEnvironment(
		Long environmentId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		com.liferay.portal.kernel.model.User user) {

		_appEnvironmentLocalService.deleteAppEnvironment(
			environmentId, serviceContext, user);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appEnvironmentLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _appEnvironmentLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _appEnvironmentLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _appEnvironmentLocalService.dynamicQuery();
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

		return _appEnvironmentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.AppEnvironmentModelImpl</code>.
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

		return _appEnvironmentLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.AppEnvironmentModelImpl</code>.
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

		return _appEnvironmentLocalService.dynamicQuery(
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

		return _appEnvironmentLocalService.dynamicQueryCount(dynamicQuery);
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

		return _appEnvironmentLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.telemony.db.model.AppEnvironment fetchAppEnvironment(
		long environmentId) {

		return _appEnvironmentLocalService.fetchAppEnvironment(environmentId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _appEnvironmentLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the app environment with the primary key.
	 *
	 * @param environmentId the primary key of the app environment
	 * @return the app environment
	 * @throws PortalException if a app environment with the primary key could not be found
	 */
	@Override
	public com.ejada.telemony.db.model.AppEnvironment getAppEnvironment(
			long environmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appEnvironmentLocalService.getAppEnvironment(environmentId);
	}

	/**
	 * Returns a range of all the app environments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.AppEnvironmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app environments
	 * @param end the upper bound of the range of app environments (not inclusive)
	 * @return the range of app environments
	 */
	@Override
	public java.util.List<com.ejada.telemony.db.model.AppEnvironment>
		getAppEnvironments(int start, int end) {

		return _appEnvironmentLocalService.getAppEnvironments(start, end);
	}

	/**
	 * Returns the number of app environments.
	 *
	 * @return the number of app environments
	 */
	@Override
	public int getAppEnvironmentsCount() {
		return _appEnvironmentLocalService.getAppEnvironmentsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _appEnvironmentLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.AppEnvironment>
		getLatestApprovedByChannelId(long channelId) {

		return _appEnvironmentLocalService.getLatestApprovedByChannelId(
			channelId);
	}

	@Override
	public java.util.Map<com.ejada.telemony.db.model.AppEnvironment, Boolean>
		getLatestApprovedByChannelIdWithPending(long channelId) {

		return _appEnvironmentLocalService.
			getLatestApprovedByChannelIdWithPending(channelId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _appEnvironmentLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appEnvironmentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the app environment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppEnvironmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appEnvironment the app environment
	 * @return the app environment that was updated
	 */
	@Override
	public com.ejada.telemony.db.model.AppEnvironment updateAppEnvironment(
		com.ejada.telemony.db.model.AppEnvironment appEnvironment) {

		return _appEnvironmentLocalService.updateAppEnvironment(appEnvironment);
	}

	@Override
	public com.ejada.telemony.db.model.AppEnvironment updateAppEnvironment(
		Long environmentId, Long channelId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _appEnvironmentLocalService.updateAppEnvironment(
			environmentId, channelId, serviceContext);
	}

	@Override
	public com.ejada.telemony.db.model.AppEnvironment updateAppEnvironment(
		Long environmentId, Long channelId, String environmentName,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _appEnvironmentLocalService.updateAppEnvironment(
			environmentId, channelId, environmentName, serviceContext);
	}

	@Override
	public com.ejada.telemony.db.model.AppEnvironment updateStatus(
			long userId, long environmentId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appEnvironmentLocalService.updateStatus(
			userId, environmentId, status, serviceContext);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _appEnvironmentLocalService.getBasePersistence();
	}

	@Override
	public AppEnvironmentLocalService getWrappedService() {
		return _appEnvironmentLocalService;
	}

	@Override
	public void setWrappedService(
		AppEnvironmentLocalService appEnvironmentLocalService) {

		_appEnvironmentLocalService = appEnvironmentLocalService;
	}

	private AppEnvironmentLocalService _appEnvironmentLocalService;

}