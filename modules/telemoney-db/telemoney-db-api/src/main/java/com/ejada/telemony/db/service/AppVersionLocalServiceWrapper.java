/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link AppVersionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AppVersionLocalService
 * @generated
 */
public class AppVersionLocalServiceWrapper
	implements AppVersionLocalService, ServiceWrapper<AppVersionLocalService> {

	public AppVersionLocalServiceWrapper() {
		this(null);
	}

	public AppVersionLocalServiceWrapper(
		AppVersionLocalService appVersionLocalService) {

		_appVersionLocalService = appVersionLocalService;
	}

	/**
	 * Adds the app version to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appVersion the app version
	 * @return the app version that was added
	 */
	@Override
	public com.ejada.telemony.db.model.AppVersion addAppVersion(
		com.ejada.telemony.db.model.AppVersion appVersion) {

		return _appVersionLocalService.addAppVersion(appVersion);
	}

	@Override
	public com.ejada.telemony.db.model.AppVersion addAppVersion(
		String platform, String versionNumber, Boolean appVersionStatus,
		String url, Long channelId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		com.liferay.portal.kernel.model.User user) {

		return _appVersionLocalService.addAppVersion(
			platform, versionNumber, appVersionStatus, url, channelId,
			serviceContext, user);
	}

	/**
	 * Creates a new app version with the primary key. Does not add the app version to the database.
	 *
	 * @param versionId the primary key for the new app version
	 * @return the new app version
	 */
	@Override
	public com.ejada.telemony.db.model.AppVersion createAppVersion(
		long versionId) {

		return _appVersionLocalService.createAppVersion(versionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appVersionLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the app version from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appVersion the app version
	 * @return the app version that was removed
	 */
	@Override
	public com.ejada.telemony.db.model.AppVersion deleteAppVersion(
		com.ejada.telemony.db.model.AppVersion appVersion) {

		return _appVersionLocalService.deleteAppVersion(appVersion);
	}

	/**
	 * Deletes the app version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param versionId the primary key of the app version
	 * @return the app version that was removed
	 * @throws PortalException if a app version with the primary key could not be found
	 */
	@Override
	public com.ejada.telemony.db.model.AppVersion deleteAppVersion(
			long versionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appVersionLocalService.deleteAppVersion(versionId);
	}

	@Override
	public void deleteAppVersion(
		Long versionId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		com.liferay.portal.kernel.model.User user) {

		_appVersionLocalService.deleteAppVersion(
			versionId, serviceContext, user);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appVersionLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _appVersionLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _appVersionLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _appVersionLocalService.dynamicQuery();
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

		return _appVersionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.AppVersionModelImpl</code>.
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

		return _appVersionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.AppVersionModelImpl</code>.
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

		return _appVersionLocalService.dynamicQuery(
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

		return _appVersionLocalService.dynamicQueryCount(dynamicQuery);
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

		return _appVersionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.telemony.db.model.AppVersion fetchAppVersion(
		long versionId) {

		return _appVersionLocalService.fetchAppVersion(versionId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _appVersionLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the app version with the primary key.
	 *
	 * @param versionId the primary key of the app version
	 * @return the app version
	 * @throws PortalException if a app version with the primary key could not be found
	 */
	@Override
	public com.ejada.telemony.db.model.AppVersion getAppVersion(long versionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appVersionLocalService.getAppVersion(versionId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getAppVersionDetails(
		Long channelId, String platform) {

		return _appVersionLocalService.getAppVersionDetails(
			channelId, platform);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject
		getAppVersionDetailsLatestApproved(Long channelId, String platform) {

		return _appVersionLocalService.getAppVersionDetailsLatestApproved(
			channelId, platform);
	}

	/**
	 * Returns a range of all the app versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @return the range of app versions
	 */
	@Override
	public java.util.List<com.ejada.telemony.db.model.AppVersion>
		getAppVersions(int start, int end) {

		return _appVersionLocalService.getAppVersions(start, end);
	}

	/**
	 * Returns the number of app versions.
	 *
	 * @return the number of app versions
	 */
	@Override
	public int getAppVersionsCount() {
		return _appVersionLocalService.getAppVersionsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _appVersionLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.AppVersion>
		getLatestApprovedByChannelId(long channelId) {

		return _appVersionLocalService.getLatestApprovedByChannelId(channelId);
	}

	/**
	 * Returns latest APPROVED AppVersion entries for the channel along with a flag indicating whether
	 * that AppVersion (entityResourceId) currently has a pending draft awaiting approval.
	 *
	 * Map key: latest approved AppVersion for an entityResourceId
	 * Map value: true if there is any STATUS_DRAFT row for that entityResourceId
	 */
	@Override
	public java.util.Map<com.ejada.telemony.db.model.AppVersion, Boolean>
		getLatestApprovedByChannelIdWithPending(long channelId) {

		return _appVersionLocalService.getLatestApprovedByChannelIdWithPending(
			channelId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _appVersionLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appVersionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the app version in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appVersion the app version
	 * @return the app version that was updated
	 */
	@Override
	public com.ejada.telemony.db.model.AppVersion updateAppVersion(
		com.ejada.telemony.db.model.AppVersion appVersion) {

		return _appVersionLocalService.updateAppVersion(appVersion);
	}

	@Override
	public com.ejada.telemony.db.model.AppVersion updateAppVersion(
		Long versionId, String versionNumber, Boolean status, String url,
		Long channelId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _appVersionLocalService.updateAppVersion(
			versionId, versionNumber, status, url, channelId, serviceContext);
	}

	@Override
	public com.ejada.telemony.db.model.AppVersion updateStatus(
			long userId, long versionId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appVersionLocalService.updateStatus(
			userId, versionId, status, serviceContext);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _appVersionLocalService.getBasePersistence();
	}

	@Override
	public AppVersionLocalService getWrappedService() {
		return _appVersionLocalService;
	}

	@Override
	public void setWrappedService(
		AppVersionLocalService appVersionLocalService) {

		_appVersionLocalService = appVersionLocalService;
	}

	private AppVersionLocalService _appVersionLocalService;

}