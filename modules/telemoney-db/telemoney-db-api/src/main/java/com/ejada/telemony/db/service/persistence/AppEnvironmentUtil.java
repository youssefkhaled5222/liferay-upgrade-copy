/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.model.AppEnvironment;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the app environment service. This utility wraps <code>com.ejada.telemony.db.service.persistence.impl.AppEnvironmentPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppEnvironmentPersistence
 * @generated
 */
public class AppEnvironmentUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(AppEnvironment appEnvironment) {
		getPersistence().clearCache(appEnvironment);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, AppEnvironment> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AppEnvironment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AppEnvironment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AppEnvironment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AppEnvironment> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AppEnvironment update(AppEnvironment appEnvironment) {
		return getPersistence().update(appEnvironment);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AppEnvironment update(
		AppEnvironment appEnvironment, ServiceContext serviceContext) {

		return getPersistence().update(appEnvironment, serviceContext);
	}

	/**
	 * Returns all the app environments where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the matching app environments
	 */
	public static List<AppEnvironment> findByChannelId(long channelId) {
		return getPersistence().findByChannelId(channelId);
	}

	/**
	 * Returns a range of all the app environments where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppEnvironmentModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of app environments
	 * @param end the upper bound of the range of app environments (not inclusive)
	 * @return the range of matching app environments
	 */
	public static List<AppEnvironment> findByChannelId(
		long channelId, int start, int end) {

		return getPersistence().findByChannelId(channelId, start, end);
	}

	/**
	 * Returns an ordered range of all the app environments where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppEnvironmentModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of app environments
	 * @param end the upper bound of the range of app environments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching app environments
	 */
	public static List<AppEnvironment> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<AppEnvironment> orderByComparator) {

		return getPersistence().findByChannelId(
			channelId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the app environments where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppEnvironmentModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of app environments
	 * @param end the upper bound of the range of app environments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching app environments
	 */
	public static List<AppEnvironment> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<AppEnvironment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByChannelId(
			channelId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first app environment in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app environment
	 * @throws NoSuchAppEnvironmentException if a matching app environment could not be found
	 */
	public static AppEnvironment findByChannelId_First(
			long channelId, OrderByComparator<AppEnvironment> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchAppEnvironmentException {

		return getPersistence().findByChannelId_First(
			channelId, orderByComparator);
	}

	/**
	 * Returns the first app environment in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app environment, or <code>null</code> if a matching app environment could not be found
	 */
	public static AppEnvironment fetchByChannelId_First(
		long channelId, OrderByComparator<AppEnvironment> orderByComparator) {

		return getPersistence().fetchByChannelId_First(
			channelId, orderByComparator);
	}

	/**
	 * Returns the last app environment in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app environment
	 * @throws NoSuchAppEnvironmentException if a matching app environment could not be found
	 */
	public static AppEnvironment findByChannelId_Last(
			long channelId, OrderByComparator<AppEnvironment> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchAppEnvironmentException {

		return getPersistence().findByChannelId_Last(
			channelId, orderByComparator);
	}

	/**
	 * Returns the last app environment in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app environment, or <code>null</code> if a matching app environment could not be found
	 */
	public static AppEnvironment fetchByChannelId_Last(
		long channelId, OrderByComparator<AppEnvironment> orderByComparator) {

		return getPersistence().fetchByChannelId_Last(
			channelId, orderByComparator);
	}

	/**
	 * Returns the app environments before and after the current app environment in the ordered set where channelId = &#63;.
	 *
	 * @param environmentId the primary key of the current app environment
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app environment
	 * @throws NoSuchAppEnvironmentException if a app environment with the primary key could not be found
	 */
	public static AppEnvironment[] findByChannelId_PrevAndNext(
			long environmentId, long channelId,
			OrderByComparator<AppEnvironment> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchAppEnvironmentException {

		return getPersistence().findByChannelId_PrevAndNext(
			environmentId, channelId, orderByComparator);
	}

	/**
	 * Removes all the app environments where channelId = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 */
	public static void removeByChannelId(long channelId) {
		getPersistence().removeByChannelId(channelId);
	}

	/**
	 * Returns the number of app environments where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the number of matching app environments
	 */
	public static int countByChannelId(long channelId) {
		return getPersistence().countByChannelId(channelId);
	}

	/**
	 * Returns all the app environments where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching app environments
	 */
	public static List<AppEnvironment> findByWorkflowStatus(int status) {
		return getPersistence().findByWorkflowStatus(status);
	}

	/**
	 * Returns a range of all the app environments where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppEnvironmentModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of app environments
	 * @param end the upper bound of the range of app environments (not inclusive)
	 * @return the range of matching app environments
	 */
	public static List<AppEnvironment> findByWorkflowStatus(
		int status, int start, int end) {

		return getPersistence().findByWorkflowStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the app environments where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppEnvironmentModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of app environments
	 * @param end the upper bound of the range of app environments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching app environments
	 */
	public static List<AppEnvironment> findByWorkflowStatus(
		int status, int start, int end,
		OrderByComparator<AppEnvironment> orderByComparator) {

		return getPersistence().findByWorkflowStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the app environments where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppEnvironmentModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of app environments
	 * @param end the upper bound of the range of app environments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching app environments
	 */
	public static List<AppEnvironment> findByWorkflowStatus(
		int status, int start, int end,
		OrderByComparator<AppEnvironment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByWorkflowStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first app environment in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app environment
	 * @throws NoSuchAppEnvironmentException if a matching app environment could not be found
	 */
	public static AppEnvironment findByWorkflowStatus_First(
			int status, OrderByComparator<AppEnvironment> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchAppEnvironmentException {

		return getPersistence().findByWorkflowStatus_First(
			status, orderByComparator);
	}

	/**
	 * Returns the first app environment in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app environment, or <code>null</code> if a matching app environment could not be found
	 */
	public static AppEnvironment fetchByWorkflowStatus_First(
		int status, OrderByComparator<AppEnvironment> orderByComparator) {

		return getPersistence().fetchByWorkflowStatus_First(
			status, orderByComparator);
	}

	/**
	 * Returns the last app environment in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app environment
	 * @throws NoSuchAppEnvironmentException if a matching app environment could not be found
	 */
	public static AppEnvironment findByWorkflowStatus_Last(
			int status, OrderByComparator<AppEnvironment> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchAppEnvironmentException {

		return getPersistence().findByWorkflowStatus_Last(
			status, orderByComparator);
	}

	/**
	 * Returns the last app environment in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app environment, or <code>null</code> if a matching app environment could not be found
	 */
	public static AppEnvironment fetchByWorkflowStatus_Last(
		int status, OrderByComparator<AppEnvironment> orderByComparator) {

		return getPersistence().fetchByWorkflowStatus_Last(
			status, orderByComparator);
	}

	/**
	 * Returns the app environments before and after the current app environment in the ordered set where status = &#63;.
	 *
	 * @param environmentId the primary key of the current app environment
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app environment
	 * @throws NoSuchAppEnvironmentException if a app environment with the primary key could not be found
	 */
	public static AppEnvironment[] findByWorkflowStatus_PrevAndNext(
			long environmentId, int status,
			OrderByComparator<AppEnvironment> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchAppEnvironmentException {

		return getPersistence().findByWorkflowStatus_PrevAndNext(
			environmentId, status, orderByComparator);
	}

	/**
	 * Removes all the app environments where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByWorkflowStatus(int status) {
		getPersistence().removeByWorkflowStatus(status);
	}

	/**
	 * Returns the number of app environments where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching app environments
	 */
	public static int countByWorkflowStatus(int status) {
		return getPersistence().countByWorkflowStatus(status);
	}

	/**
	 * Returns all the app environments where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the matching app environments
	 */
	public static List<AppEnvironment> findByEntityResourceId(
		long entityResourceId) {

		return getPersistence().findByEntityResourceId(entityResourceId);
	}

	/**
	 * Returns a range of all the app environments where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppEnvironmentModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of app environments
	 * @param end the upper bound of the range of app environments (not inclusive)
	 * @return the range of matching app environments
	 */
	public static List<AppEnvironment> findByEntityResourceId(
		long entityResourceId, int start, int end) {

		return getPersistence().findByEntityResourceId(
			entityResourceId, start, end);
	}

	/**
	 * Returns an ordered range of all the app environments where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppEnvironmentModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of app environments
	 * @param end the upper bound of the range of app environments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching app environments
	 */
	public static List<AppEnvironment> findByEntityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<AppEnvironment> orderByComparator) {

		return getPersistence().findByEntityResourceId(
			entityResourceId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the app environments where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppEnvironmentModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of app environments
	 * @param end the upper bound of the range of app environments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching app environments
	 */
	public static List<AppEnvironment> findByEntityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<AppEnvironment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEntityResourceId(
			entityResourceId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first app environment in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app environment
	 * @throws NoSuchAppEnvironmentException if a matching app environment could not be found
	 */
	public static AppEnvironment findByEntityResourceId_First(
			long entityResourceId,
			OrderByComparator<AppEnvironment> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchAppEnvironmentException {

		return getPersistence().findByEntityResourceId_First(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the first app environment in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app environment, or <code>null</code> if a matching app environment could not be found
	 */
	public static AppEnvironment fetchByEntityResourceId_First(
		long entityResourceId,
		OrderByComparator<AppEnvironment> orderByComparator) {

		return getPersistence().fetchByEntityResourceId_First(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the last app environment in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app environment
	 * @throws NoSuchAppEnvironmentException if a matching app environment could not be found
	 */
	public static AppEnvironment findByEntityResourceId_Last(
			long entityResourceId,
			OrderByComparator<AppEnvironment> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchAppEnvironmentException {

		return getPersistence().findByEntityResourceId_Last(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the last app environment in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app environment, or <code>null</code> if a matching app environment could not be found
	 */
	public static AppEnvironment fetchByEntityResourceId_Last(
		long entityResourceId,
		OrderByComparator<AppEnvironment> orderByComparator) {

		return getPersistence().fetchByEntityResourceId_Last(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the app environments before and after the current app environment in the ordered set where entityResourceId = &#63;.
	 *
	 * @param environmentId the primary key of the current app environment
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app environment
	 * @throws NoSuchAppEnvironmentException if a app environment with the primary key could not be found
	 */
	public static AppEnvironment[] findByEntityResourceId_PrevAndNext(
			long environmentId, long entityResourceId,
			OrderByComparator<AppEnvironment> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchAppEnvironmentException {

		return getPersistence().findByEntityResourceId_PrevAndNext(
			environmentId, entityResourceId, orderByComparator);
	}

	/**
	 * Removes all the app environments where entityResourceId = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 */
	public static void removeByEntityResourceId(long entityResourceId) {
		getPersistence().removeByEntityResourceId(entityResourceId);
	}

	/**
	 * Returns the number of app environments where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the number of matching app environments
	 */
	public static int countByEntityResourceId(long entityResourceId) {
		return getPersistence().countByEntityResourceId(entityResourceId);
	}

	/**
	 * Caches the app environment in the entity cache if it is enabled.
	 *
	 * @param appEnvironment the app environment
	 */
	public static void cacheResult(AppEnvironment appEnvironment) {
		getPersistence().cacheResult(appEnvironment);
	}

	/**
	 * Caches the app environments in the entity cache if it is enabled.
	 *
	 * @param appEnvironments the app environments
	 */
	public static void cacheResult(List<AppEnvironment> appEnvironments) {
		getPersistence().cacheResult(appEnvironments);
	}

	/**
	 * Creates a new app environment with the primary key. Does not add the app environment to the database.
	 *
	 * @param environmentId the primary key for the new app environment
	 * @return the new app environment
	 */
	public static AppEnvironment create(long environmentId) {
		return getPersistence().create(environmentId);
	}

	/**
	 * Removes the app environment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param environmentId the primary key of the app environment
	 * @return the app environment that was removed
	 * @throws NoSuchAppEnvironmentException if a app environment with the primary key could not be found
	 */
	public static AppEnvironment remove(long environmentId)
		throws com.ejada.telemony.db.exception.NoSuchAppEnvironmentException {

		return getPersistence().remove(environmentId);
	}

	public static AppEnvironment updateImpl(AppEnvironment appEnvironment) {
		return getPersistence().updateImpl(appEnvironment);
	}

	/**
	 * Returns the app environment with the primary key or throws a <code>NoSuchAppEnvironmentException</code> if it could not be found.
	 *
	 * @param environmentId the primary key of the app environment
	 * @return the app environment
	 * @throws NoSuchAppEnvironmentException if a app environment with the primary key could not be found
	 */
	public static AppEnvironment findByPrimaryKey(long environmentId)
		throws com.ejada.telemony.db.exception.NoSuchAppEnvironmentException {

		return getPersistence().findByPrimaryKey(environmentId);
	}

	/**
	 * Returns the app environment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param environmentId the primary key of the app environment
	 * @return the app environment, or <code>null</code> if a app environment with the primary key could not be found
	 */
	public static AppEnvironment fetchByPrimaryKey(long environmentId) {
		return getPersistence().fetchByPrimaryKey(environmentId);
	}

	/**
	 * Returns all the app environments.
	 *
	 * @return the app environments
	 */
	public static List<AppEnvironment> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the app environments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppEnvironmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app environments
	 * @param end the upper bound of the range of app environments (not inclusive)
	 * @return the range of app environments
	 */
	public static List<AppEnvironment> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the app environments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppEnvironmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app environments
	 * @param end the upper bound of the range of app environments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of app environments
	 */
	public static List<AppEnvironment> findAll(
		int start, int end,
		OrderByComparator<AppEnvironment> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the app environments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppEnvironmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app environments
	 * @param end the upper bound of the range of app environments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of app environments
	 */
	public static List<AppEnvironment> findAll(
		int start, int end, OrderByComparator<AppEnvironment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the app environments from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of app environments.
	 *
	 * @return the number of app environments
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AppEnvironmentPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(AppEnvironmentPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile AppEnvironmentPersistence _persistence;

}