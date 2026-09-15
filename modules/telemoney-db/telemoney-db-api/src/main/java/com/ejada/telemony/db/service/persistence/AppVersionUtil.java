/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.model.AppVersion;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the app version service. This utility wraps <code>com.ejada.telemony.db.service.persistence.impl.AppVersionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppVersionPersistence
 * @generated
 */
public class AppVersionUtil {

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
	public static void clearCache(AppVersion appVersion) {
		getPersistence().clearCache(appVersion);
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
	public static Map<Serializable, AppVersion> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AppVersion> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AppVersion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AppVersion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AppVersion> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AppVersion update(AppVersion appVersion) {
		return getPersistence().update(appVersion);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AppVersion update(
		AppVersion appVersion, ServiceContext serviceContext) {

		return getPersistence().update(appVersion, serviceContext);
	}

	/**
	 * Returns all the app versions where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the matching app versions
	 */
	public static List<AppVersion> findByChannelId(long channelId) {
		return getPersistence().findByChannelId(channelId);
	}

	/**
	 * Returns a range of all the app versions where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @return the range of matching app versions
	 */
	public static List<AppVersion> findByChannelId(
		long channelId, int start, int end) {

		return getPersistence().findByChannelId(channelId, start, end);
	}

	/**
	 * Returns an ordered range of all the app versions where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching app versions
	 */
	public static List<AppVersion> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<AppVersion> orderByComparator) {

		return getPersistence().findByChannelId(
			channelId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the app versions where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching app versions
	 */
	public static List<AppVersion> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<AppVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByChannelId(
			channelId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first app version in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app version
	 * @throws NoSuchAppVersionException if a matching app version could not be found
	 */
	public static AppVersion findByChannelId_First(
			long channelId, OrderByComparator<AppVersion> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchAppVersionException {

		return getPersistence().findByChannelId_First(
			channelId, orderByComparator);
	}

	/**
	 * Returns the first app version in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app version, or <code>null</code> if a matching app version could not be found
	 */
	public static AppVersion fetchByChannelId_First(
		long channelId, OrderByComparator<AppVersion> orderByComparator) {

		return getPersistence().fetchByChannelId_First(
			channelId, orderByComparator);
	}

	/**
	 * Returns the last app version in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app version
	 * @throws NoSuchAppVersionException if a matching app version could not be found
	 */
	public static AppVersion findByChannelId_Last(
			long channelId, OrderByComparator<AppVersion> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchAppVersionException {

		return getPersistence().findByChannelId_Last(
			channelId, orderByComparator);
	}

	/**
	 * Returns the last app version in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app version, or <code>null</code> if a matching app version could not be found
	 */
	public static AppVersion fetchByChannelId_Last(
		long channelId, OrderByComparator<AppVersion> orderByComparator) {

		return getPersistence().fetchByChannelId_Last(
			channelId, orderByComparator);
	}

	/**
	 * Returns the app versions before and after the current app version in the ordered set where channelId = &#63;.
	 *
	 * @param versionId the primary key of the current app version
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app version
	 * @throws NoSuchAppVersionException if a app version with the primary key could not be found
	 */
	public static AppVersion[] findByChannelId_PrevAndNext(
			long versionId, long channelId,
			OrderByComparator<AppVersion> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchAppVersionException {

		return getPersistence().findByChannelId_PrevAndNext(
			versionId, channelId, orderByComparator);
	}

	/**
	 * Removes all the app versions where channelId = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 */
	public static void removeByChannelId(long channelId) {
		getPersistence().removeByChannelId(channelId);
	}

	/**
	 * Returns the number of app versions where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the number of matching app versions
	 */
	public static int countByChannelId(long channelId) {
		return getPersistence().countByChannelId(channelId);
	}

	/**
	 * Returns all the app versions where platform = &#63; and channelId = &#63;.
	 *
	 * @param platform the platform
	 * @param channelId the channel ID
	 * @return the matching app versions
	 */
	public static List<AppVersion> findByPlatform(
		String platform, long channelId) {

		return getPersistence().findByPlatform(platform, channelId);
	}

	/**
	 * Returns a range of all the app versions where platform = &#63; and channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param platform the platform
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @return the range of matching app versions
	 */
	public static List<AppVersion> findByPlatform(
		String platform, long channelId, int start, int end) {

		return getPersistence().findByPlatform(platform, channelId, start, end);
	}

	/**
	 * Returns an ordered range of all the app versions where platform = &#63; and channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param platform the platform
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching app versions
	 */
	public static List<AppVersion> findByPlatform(
		String platform, long channelId, int start, int end,
		OrderByComparator<AppVersion> orderByComparator) {

		return getPersistence().findByPlatform(
			platform, channelId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the app versions where platform = &#63; and channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param platform the platform
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching app versions
	 */
	public static List<AppVersion> findByPlatform(
		String platform, long channelId, int start, int end,
		OrderByComparator<AppVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPlatform(
			platform, channelId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first app version in the ordered set where platform = &#63; and channelId = &#63;.
	 *
	 * @param platform the platform
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app version
	 * @throws NoSuchAppVersionException if a matching app version could not be found
	 */
	public static AppVersion findByPlatform_First(
			String platform, long channelId,
			OrderByComparator<AppVersion> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchAppVersionException {

		return getPersistence().findByPlatform_First(
			platform, channelId, orderByComparator);
	}

	/**
	 * Returns the first app version in the ordered set where platform = &#63; and channelId = &#63;.
	 *
	 * @param platform the platform
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app version, or <code>null</code> if a matching app version could not be found
	 */
	public static AppVersion fetchByPlatform_First(
		String platform, long channelId,
		OrderByComparator<AppVersion> orderByComparator) {

		return getPersistence().fetchByPlatform_First(
			platform, channelId, orderByComparator);
	}

	/**
	 * Returns the last app version in the ordered set where platform = &#63; and channelId = &#63;.
	 *
	 * @param platform the platform
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app version
	 * @throws NoSuchAppVersionException if a matching app version could not be found
	 */
	public static AppVersion findByPlatform_Last(
			String platform, long channelId,
			OrderByComparator<AppVersion> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchAppVersionException {

		return getPersistence().findByPlatform_Last(
			platform, channelId, orderByComparator);
	}

	/**
	 * Returns the last app version in the ordered set where platform = &#63; and channelId = &#63;.
	 *
	 * @param platform the platform
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app version, or <code>null</code> if a matching app version could not be found
	 */
	public static AppVersion fetchByPlatform_Last(
		String platform, long channelId,
		OrderByComparator<AppVersion> orderByComparator) {

		return getPersistence().fetchByPlatform_Last(
			platform, channelId, orderByComparator);
	}

	/**
	 * Returns the app versions before and after the current app version in the ordered set where platform = &#63; and channelId = &#63;.
	 *
	 * @param versionId the primary key of the current app version
	 * @param platform the platform
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app version
	 * @throws NoSuchAppVersionException if a app version with the primary key could not be found
	 */
	public static AppVersion[] findByPlatform_PrevAndNext(
			long versionId, String platform, long channelId,
			OrderByComparator<AppVersion> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchAppVersionException {

		return getPersistence().findByPlatform_PrevAndNext(
			versionId, platform, channelId, orderByComparator);
	}

	/**
	 * Removes all the app versions where platform = &#63; and channelId = &#63; from the database.
	 *
	 * @param platform the platform
	 * @param channelId the channel ID
	 */
	public static void removeByPlatform(String platform, long channelId) {
		getPersistence().removeByPlatform(platform, channelId);
	}

	/**
	 * Returns the number of app versions where platform = &#63; and channelId = &#63;.
	 *
	 * @param platform the platform
	 * @param channelId the channel ID
	 * @return the number of matching app versions
	 */
	public static int countByPlatform(String platform, long channelId) {
		return getPersistence().countByPlatform(platform, channelId);
	}

	/**
	 * Returns all the app versions where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching app versions
	 */
	public static List<AppVersion> findByWorkflowStatus(int status) {
		return getPersistence().findByWorkflowStatus(status);
	}

	/**
	 * Returns a range of all the app versions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @return the range of matching app versions
	 */
	public static List<AppVersion> findByWorkflowStatus(
		int status, int start, int end) {

		return getPersistence().findByWorkflowStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the app versions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching app versions
	 */
	public static List<AppVersion> findByWorkflowStatus(
		int status, int start, int end,
		OrderByComparator<AppVersion> orderByComparator) {

		return getPersistence().findByWorkflowStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the app versions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching app versions
	 */
	public static List<AppVersion> findByWorkflowStatus(
		int status, int start, int end,
		OrderByComparator<AppVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByWorkflowStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first app version in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app version
	 * @throws NoSuchAppVersionException if a matching app version could not be found
	 */
	public static AppVersion findByWorkflowStatus_First(
			int status, OrderByComparator<AppVersion> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchAppVersionException {

		return getPersistence().findByWorkflowStatus_First(
			status, orderByComparator);
	}

	/**
	 * Returns the first app version in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app version, or <code>null</code> if a matching app version could not be found
	 */
	public static AppVersion fetchByWorkflowStatus_First(
		int status, OrderByComparator<AppVersion> orderByComparator) {

		return getPersistence().fetchByWorkflowStatus_First(
			status, orderByComparator);
	}

	/**
	 * Returns the last app version in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app version
	 * @throws NoSuchAppVersionException if a matching app version could not be found
	 */
	public static AppVersion findByWorkflowStatus_Last(
			int status, OrderByComparator<AppVersion> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchAppVersionException {

		return getPersistence().findByWorkflowStatus_Last(
			status, orderByComparator);
	}

	/**
	 * Returns the last app version in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app version, or <code>null</code> if a matching app version could not be found
	 */
	public static AppVersion fetchByWorkflowStatus_Last(
		int status, OrderByComparator<AppVersion> orderByComparator) {

		return getPersistence().fetchByWorkflowStatus_Last(
			status, orderByComparator);
	}

	/**
	 * Returns the app versions before and after the current app version in the ordered set where status = &#63;.
	 *
	 * @param versionId the primary key of the current app version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app version
	 * @throws NoSuchAppVersionException if a app version with the primary key could not be found
	 */
	public static AppVersion[] findByWorkflowStatus_PrevAndNext(
			long versionId, int status,
			OrderByComparator<AppVersion> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchAppVersionException {

		return getPersistence().findByWorkflowStatus_PrevAndNext(
			versionId, status, orderByComparator);
	}

	/**
	 * Removes all the app versions where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByWorkflowStatus(int status) {
		getPersistence().removeByWorkflowStatus(status);
	}

	/**
	 * Returns the number of app versions where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching app versions
	 */
	public static int countByWorkflowStatus(int status) {
		return getPersistence().countByWorkflowStatus(status);
	}

	/**
	 * Returns all the app versions where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the matching app versions
	 */
	public static List<AppVersion> findByEntityResourceId(
		long entityResourceId) {

		return getPersistence().findByEntityResourceId(entityResourceId);
	}

	/**
	 * Returns a range of all the app versions where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @return the range of matching app versions
	 */
	public static List<AppVersion> findByEntityResourceId(
		long entityResourceId, int start, int end) {

		return getPersistence().findByEntityResourceId(
			entityResourceId, start, end);
	}

	/**
	 * Returns an ordered range of all the app versions where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching app versions
	 */
	public static List<AppVersion> findByEntityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<AppVersion> orderByComparator) {

		return getPersistence().findByEntityResourceId(
			entityResourceId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the app versions where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching app versions
	 */
	public static List<AppVersion> findByEntityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<AppVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEntityResourceId(
			entityResourceId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first app version in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app version
	 * @throws NoSuchAppVersionException if a matching app version could not be found
	 */
	public static AppVersion findByEntityResourceId_First(
			long entityResourceId,
			OrderByComparator<AppVersion> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchAppVersionException {

		return getPersistence().findByEntityResourceId_First(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the first app version in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app version, or <code>null</code> if a matching app version could not be found
	 */
	public static AppVersion fetchByEntityResourceId_First(
		long entityResourceId,
		OrderByComparator<AppVersion> orderByComparator) {

		return getPersistence().fetchByEntityResourceId_First(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the last app version in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app version
	 * @throws NoSuchAppVersionException if a matching app version could not be found
	 */
	public static AppVersion findByEntityResourceId_Last(
			long entityResourceId,
			OrderByComparator<AppVersion> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchAppVersionException {

		return getPersistence().findByEntityResourceId_Last(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the last app version in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app version, or <code>null</code> if a matching app version could not be found
	 */
	public static AppVersion fetchByEntityResourceId_Last(
		long entityResourceId,
		OrderByComparator<AppVersion> orderByComparator) {

		return getPersistence().fetchByEntityResourceId_Last(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the app versions before and after the current app version in the ordered set where entityResourceId = &#63;.
	 *
	 * @param versionId the primary key of the current app version
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app version
	 * @throws NoSuchAppVersionException if a app version with the primary key could not be found
	 */
	public static AppVersion[] findByEntityResourceId_PrevAndNext(
			long versionId, long entityResourceId,
			OrderByComparator<AppVersion> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchAppVersionException {

		return getPersistence().findByEntityResourceId_PrevAndNext(
			versionId, entityResourceId, orderByComparator);
	}

	/**
	 * Removes all the app versions where entityResourceId = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 */
	public static void removeByEntityResourceId(long entityResourceId) {
		getPersistence().removeByEntityResourceId(entityResourceId);
	}

	/**
	 * Returns the number of app versions where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the number of matching app versions
	 */
	public static int countByEntityResourceId(long entityResourceId) {
		return getPersistence().countByEntityResourceId(entityResourceId);
	}

	/**
	 * Caches the app version in the entity cache if it is enabled.
	 *
	 * @param appVersion the app version
	 */
	public static void cacheResult(AppVersion appVersion) {
		getPersistence().cacheResult(appVersion);
	}

	/**
	 * Caches the app versions in the entity cache if it is enabled.
	 *
	 * @param appVersions the app versions
	 */
	public static void cacheResult(List<AppVersion> appVersions) {
		getPersistence().cacheResult(appVersions);
	}

	/**
	 * Creates a new app version with the primary key. Does not add the app version to the database.
	 *
	 * @param versionId the primary key for the new app version
	 * @return the new app version
	 */
	public static AppVersion create(long versionId) {
		return getPersistence().create(versionId);
	}

	/**
	 * Removes the app version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param versionId the primary key of the app version
	 * @return the app version that was removed
	 * @throws NoSuchAppVersionException if a app version with the primary key could not be found
	 */
	public static AppVersion remove(long versionId)
		throws com.ejada.telemony.db.exception.NoSuchAppVersionException {

		return getPersistence().remove(versionId);
	}

	public static AppVersion updateImpl(AppVersion appVersion) {
		return getPersistence().updateImpl(appVersion);
	}

	/**
	 * Returns the app version with the primary key or throws a <code>NoSuchAppVersionException</code> if it could not be found.
	 *
	 * @param versionId the primary key of the app version
	 * @return the app version
	 * @throws NoSuchAppVersionException if a app version with the primary key could not be found
	 */
	public static AppVersion findByPrimaryKey(long versionId)
		throws com.ejada.telemony.db.exception.NoSuchAppVersionException {

		return getPersistence().findByPrimaryKey(versionId);
	}

	/**
	 * Returns the app version with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param versionId the primary key of the app version
	 * @return the app version, or <code>null</code> if a app version with the primary key could not be found
	 */
	public static AppVersion fetchByPrimaryKey(long versionId) {
		return getPersistence().fetchByPrimaryKey(versionId);
	}

	/**
	 * Returns all the app versions.
	 *
	 * @return the app versions
	 */
	public static List<AppVersion> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the app versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @return the range of app versions
	 */
	public static List<AppVersion> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the app versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of app versions
	 */
	public static List<AppVersion> findAll(
		int start, int end, OrderByComparator<AppVersion> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the app versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of app versions
	 */
	public static List<AppVersion> findAll(
		int start, int end, OrderByComparator<AppVersion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the app versions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of app versions.
	 *
	 * @return the number of app versions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AppVersionPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(AppVersionPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile AppVersionPersistence _persistence;

}