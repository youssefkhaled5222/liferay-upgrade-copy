/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.ejada.telemony.db.model.AppVersion;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for AppVersion. This utility wraps
 * <code>com.ejada.telemony.db.service.impl.AppVersionLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AppVersionLocalService
 * @generated
 */
public class AppVersionLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.AppVersionLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static AppVersion addAppVersion(AppVersion appVersion) {
		return getService().addAppVersion(appVersion);
	}

	public static AppVersion addAppVersion(
		String platform, String versionNumber, Boolean appVersionStatus,
		String url, Long channelId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		com.liferay.portal.kernel.model.User user) {

		return getService().addAppVersion(
			platform, versionNumber, appVersionStatus, url, channelId,
			serviceContext, user);
	}

	/**
	 * Creates a new app version with the primary key. Does not add the app version to the database.
	 *
	 * @param versionId the primary key for the new app version
	 * @return the new app version
	 */
	public static AppVersion createAppVersion(long versionId) {
		return getService().createAppVersion(versionId);
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
	 * Deletes the app version from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appVersion the app version
	 * @return the app version that was removed
	 */
	public static AppVersion deleteAppVersion(AppVersion appVersion) {
		return getService().deleteAppVersion(appVersion);
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
	public static AppVersion deleteAppVersion(long versionId)
		throws PortalException {

		return getService().deleteAppVersion(versionId);
	}

	public static void deleteAppVersion(
		Long versionId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		com.liferay.portal.kernel.model.User user) {

		getService().deleteAppVersion(versionId, serviceContext, user);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.AppVersionModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.AppVersionModelImpl</code>.
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

	public static AppVersion fetchAppVersion(long versionId) {
		return getService().fetchAppVersion(versionId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the app version with the primary key.
	 *
	 * @param versionId the primary key of the app version
	 * @return the app version
	 * @throws PortalException if a app version with the primary key could not be found
	 */
	public static AppVersion getAppVersion(long versionId)
		throws PortalException {

		return getService().getAppVersion(versionId);
	}

	public static com.liferay.portal.kernel.json.JSONObject
		getAppVersionDetails(Long channelId, String platform) {

		return getService().getAppVersionDetails(channelId, platform);
	}

	public static com.liferay.portal.kernel.json.JSONObject
		getAppVersionDetailsLatestApproved(Long channelId, String platform) {

		return getService().getAppVersionDetailsLatestApproved(
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
	public static List<AppVersion> getAppVersions(int start, int end) {
		return getService().getAppVersions(start, end);
	}

	/**
	 * Returns the number of app versions.
	 *
	 * @return the number of app versions
	 */
	public static int getAppVersionsCount() {
		return getService().getAppVersionsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static List<AppVersion> getLatestApprovedByChannelId(
		long channelId) {

		return getService().getLatestApprovedByChannelId(channelId);
	}

	/**
	 * Returns latest APPROVED AppVersion entries for the channel along with a flag indicating whether
	 * that AppVersion (entityResourceId) currently has a pending draft awaiting approval.
	 *
	 * Map key: latest approved AppVersion for an entityResourceId
	 * Map value: true if there is any STATUS_DRAFT row for that entityResourceId
	 */
	public static Map<AppVersion, Boolean>
		getLatestApprovedByChannelIdWithPending(long channelId) {

		return getService().getLatestApprovedByChannelIdWithPending(channelId);
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
	 * Updates the app version in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppVersionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appVersion the app version
	 * @return the app version that was updated
	 */
	public static AppVersion updateAppVersion(AppVersion appVersion) {
		return getService().updateAppVersion(appVersion);
	}

	public static AppVersion updateAppVersion(
		Long versionId, String versionNumber, Boolean status, String url,
		Long channelId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().updateAppVersion(
			versionId, versionNumber, status, url, channelId, serviceContext);
	}

	public static AppVersion updateStatus(
			long userId, long versionId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateStatus(
			userId, versionId, status, serviceContext);
	}

	public static AppVersionLocalService getService() {
		return _service;
	}

	public static void setService(AppVersionLocalService service) {
		_service = service;
	}

	private static volatile AppVersionLocalService _service;

}