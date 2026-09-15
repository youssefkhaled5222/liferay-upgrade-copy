/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.ejada.telemony.db.model.AppEnvironment;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for AppEnvironment. This utility wraps
 * <code>com.ejada.telemony.db.service.impl.AppEnvironmentLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AppEnvironmentLocalService
 * @generated
 */
public class AppEnvironmentLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.AppEnvironmentLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static AppEnvironment addAppEnvironment(
		AppEnvironment appEnvironment) {

		return getService().addAppEnvironment(appEnvironment);
	}

	public static AppEnvironment addAppEnvironment(
		Long channelId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		com.liferay.portal.kernel.model.User user, String environmentName) {

		return getService().addAppEnvironment(
			channelId, serviceContext, user, environmentName);
	}

	public static AppEnvironment addAppEnvironment(
		Long channelId, String environmentName,
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		com.liferay.portal.kernel.model.User user) {

		return getService().addAppEnvironment(
			channelId, environmentName, serviceContext, user);
	}

	/**
	 * Creates a new app environment with the primary key. Does not add the app environment to the database.
	 *
	 * @param environmentId the primary key for the new app environment
	 * @return the new app environment
	 */
	public static AppEnvironment createAppEnvironment(long environmentId) {
		return getService().createAppEnvironment(environmentId);
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
	 * Deletes the app environment from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppEnvironmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appEnvironment the app environment
	 * @return the app environment that was removed
	 */
	public static AppEnvironment deleteAppEnvironment(
		AppEnvironment appEnvironment) {

		return getService().deleteAppEnvironment(appEnvironment);
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
	public static AppEnvironment deleteAppEnvironment(long environmentId)
		throws PortalException {

		return getService().deleteAppEnvironment(environmentId);
	}

	public static void deleteAppEnvironment(
		Long environmentId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		com.liferay.portal.kernel.model.User user) {

		getService().deleteAppEnvironment(environmentId, serviceContext, user);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.AppEnvironmentModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.AppEnvironmentModelImpl</code>.
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

	public static AppEnvironment fetchAppEnvironment(long environmentId) {
		return getService().fetchAppEnvironment(environmentId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the app environment with the primary key.
	 *
	 * @param environmentId the primary key of the app environment
	 * @return the app environment
	 * @throws PortalException if a app environment with the primary key could not be found
	 */
	public static AppEnvironment getAppEnvironment(long environmentId)
		throws PortalException {

		return getService().getAppEnvironment(environmentId);
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
	public static List<AppEnvironment> getAppEnvironments(int start, int end) {
		return getService().getAppEnvironments(start, end);
	}

	/**
	 * Returns the number of app environments.
	 *
	 * @return the number of app environments
	 */
	public static int getAppEnvironmentsCount() {
		return getService().getAppEnvironmentsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static List<AppEnvironment> getLatestApprovedByChannelId(
		long channelId) {

		return getService().getLatestApprovedByChannelId(channelId);
	}

	public static Map<AppEnvironment, Boolean>
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
	 * Updates the app environment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppEnvironmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appEnvironment the app environment
	 * @return the app environment that was updated
	 */
	public static AppEnvironment updateAppEnvironment(
		AppEnvironment appEnvironment) {

		return getService().updateAppEnvironment(appEnvironment);
	}

	public static AppEnvironment updateAppEnvironment(
		Long environmentId, Long channelId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().updateAppEnvironment(
			environmentId, channelId, serviceContext);
	}

	public static AppEnvironment updateAppEnvironment(
		Long environmentId, Long channelId, String environmentName,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().updateAppEnvironment(
			environmentId, channelId, environmentName, serviceContext);
	}

	public static AppEnvironment updateStatus(
			long userId, long environmentId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateStatus(
			userId, environmentId, status, serviceContext);
	}

	public static AppEnvironmentLocalService getService() {
		return _service;
	}

	public static void setService(AppEnvironmentLocalService service) {
		_service = service;
	}

	private static volatile AppEnvironmentLocalService _service;

}