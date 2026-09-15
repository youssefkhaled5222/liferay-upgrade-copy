/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.model.UserLogs;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the user logs service. This utility wraps <code>com.ejada.telemony.db.service.persistence.impl.UserLogsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserLogsPersistence
 * @generated
 */
public class UserLogsUtil {

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
	public static void clearCache(UserLogs userLogs) {
		getPersistence().clearCache(userLogs);
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
	public static Map<Serializable, UserLogs> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserLogs> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserLogs> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserLogs> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserLogs> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserLogs update(UserLogs userLogs) {
		return getPersistence().update(userLogs);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserLogs update(
		UserLogs userLogs, ServiceContext serviceContext) {

		return getPersistence().update(userLogs, serviceContext);
	}

	/**
	 * Returns all the user logses where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the matching user logses
	 */
	public static List<UserLogs> findByChannelId(long channelId) {
		return getPersistence().findByChannelId(channelId);
	}

	/**
	 * Returns a range of all the user logses where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLogsModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of user logses
	 * @param end the upper bound of the range of user logses (not inclusive)
	 * @return the range of matching user logses
	 */
	public static List<UserLogs> findByChannelId(
		long channelId, int start, int end) {

		return getPersistence().findByChannelId(channelId, start, end);
	}

	/**
	 * Returns an ordered range of all the user logses where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLogsModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of user logses
	 * @param end the upper bound of the range of user logses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user logses
	 */
	public static List<UserLogs> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<UserLogs> orderByComparator) {

		return getPersistence().findByChannelId(
			channelId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user logses where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLogsModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of user logses
	 * @param end the upper bound of the range of user logses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user logses
	 */
	public static List<UserLogs> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<UserLogs> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByChannelId(
			channelId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first user logs in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user logs
	 * @throws NoSuchUserLogsException if a matching user logs could not be found
	 */
	public static UserLogs findByChannelId_First(
			long channelId, OrderByComparator<UserLogs> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchUserLogsException {

		return getPersistence().findByChannelId_First(
			channelId, orderByComparator);
	}

	/**
	 * Returns the first user logs in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user logs, or <code>null</code> if a matching user logs could not be found
	 */
	public static UserLogs fetchByChannelId_First(
		long channelId, OrderByComparator<UserLogs> orderByComparator) {

		return getPersistence().fetchByChannelId_First(
			channelId, orderByComparator);
	}

	/**
	 * Returns the last user logs in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user logs
	 * @throws NoSuchUserLogsException if a matching user logs could not be found
	 */
	public static UserLogs findByChannelId_Last(
			long channelId, OrderByComparator<UserLogs> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchUserLogsException {

		return getPersistence().findByChannelId_Last(
			channelId, orderByComparator);
	}

	/**
	 * Returns the last user logs in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user logs, or <code>null</code> if a matching user logs could not be found
	 */
	public static UserLogs fetchByChannelId_Last(
		long channelId, OrderByComparator<UserLogs> orderByComparator) {

		return getPersistence().fetchByChannelId_Last(
			channelId, orderByComparator);
	}

	/**
	 * Returns the user logses before and after the current user logs in the ordered set where channelId = &#63;.
	 *
	 * @param logsId the primary key of the current user logs
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user logs
	 * @throws NoSuchUserLogsException if a user logs with the primary key could not be found
	 */
	public static UserLogs[] findByChannelId_PrevAndNext(
			long logsId, long channelId,
			OrderByComparator<UserLogs> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchUserLogsException {

		return getPersistence().findByChannelId_PrevAndNext(
			logsId, channelId, orderByComparator);
	}

	/**
	 * Removes all the user logses where channelId = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 */
	public static void removeByChannelId(long channelId) {
		getPersistence().removeByChannelId(channelId);
	}

	/**
	 * Returns the number of user logses where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the number of matching user logses
	 */
	public static int countByChannelId(long channelId) {
		return getPersistence().countByChannelId(channelId);
	}

	/**
	 * Caches the user logs in the entity cache if it is enabled.
	 *
	 * @param userLogs the user logs
	 */
	public static void cacheResult(UserLogs userLogs) {
		getPersistence().cacheResult(userLogs);
	}

	/**
	 * Caches the user logses in the entity cache if it is enabled.
	 *
	 * @param userLogses the user logses
	 */
	public static void cacheResult(List<UserLogs> userLogses) {
		getPersistence().cacheResult(userLogses);
	}

	/**
	 * Creates a new user logs with the primary key. Does not add the user logs to the database.
	 *
	 * @param logsId the primary key for the new user logs
	 * @return the new user logs
	 */
	public static UserLogs create(long logsId) {
		return getPersistence().create(logsId);
	}

	/**
	 * Removes the user logs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param logsId the primary key of the user logs
	 * @return the user logs that was removed
	 * @throws NoSuchUserLogsException if a user logs with the primary key could not be found
	 */
	public static UserLogs remove(long logsId)
		throws com.ejada.telemony.db.exception.NoSuchUserLogsException {

		return getPersistence().remove(logsId);
	}

	public static UserLogs updateImpl(UserLogs userLogs) {
		return getPersistence().updateImpl(userLogs);
	}

	/**
	 * Returns the user logs with the primary key or throws a <code>NoSuchUserLogsException</code> if it could not be found.
	 *
	 * @param logsId the primary key of the user logs
	 * @return the user logs
	 * @throws NoSuchUserLogsException if a user logs with the primary key could not be found
	 */
	public static UserLogs findByPrimaryKey(long logsId)
		throws com.ejada.telemony.db.exception.NoSuchUserLogsException {

		return getPersistence().findByPrimaryKey(logsId);
	}

	/**
	 * Returns the user logs with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param logsId the primary key of the user logs
	 * @return the user logs, or <code>null</code> if a user logs with the primary key could not be found
	 */
	public static UserLogs fetchByPrimaryKey(long logsId) {
		return getPersistence().fetchByPrimaryKey(logsId);
	}

	/**
	 * Returns all the user logses.
	 *
	 * @return the user logses
	 */
	public static List<UserLogs> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the user logses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLogsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user logses
	 * @param end the upper bound of the range of user logses (not inclusive)
	 * @return the range of user logses
	 */
	public static List<UserLogs> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the user logses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLogsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user logses
	 * @param end the upper bound of the range of user logses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user logses
	 */
	public static List<UserLogs> findAll(
		int start, int end, OrderByComparator<UserLogs> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user logses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserLogsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user logses
	 * @param end the upper bound of the range of user logses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user logses
	 */
	public static List<UserLogs> findAll(
		int start, int end, OrderByComparator<UserLogs> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the user logses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of user logses.
	 *
	 * @return the number of user logses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static UserLogsPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(UserLogsPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile UserLogsPersistence _persistence;

}