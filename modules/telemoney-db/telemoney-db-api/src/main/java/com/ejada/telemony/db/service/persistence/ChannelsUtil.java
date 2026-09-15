/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.model.Channels;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the channels service. This utility wraps <code>com.ejada.telemony.db.service.persistence.impl.ChannelsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChannelsPersistence
 * @generated
 */
public class ChannelsUtil {

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
	public static void clearCache(Channels channels) {
		getPersistence().clearCache(channels);
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
	public static Map<Serializable, Channels> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Channels> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Channels> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Channels> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Channels> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Channels update(Channels channels) {
		return getPersistence().update(channels);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Channels update(
		Channels channels, ServiceContext serviceContext) {

		return getPersistence().update(channels, serviceContext);
	}

	/**
	 * Returns all the channelses where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching channelses
	 */
	public static List<Channels> findByName(String name) {
		return getPersistence().findByName(name);
	}

	/**
	 * Returns a range of all the channelses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChannelsModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of channelses
	 * @param end the upper bound of the range of channelses (not inclusive)
	 * @return the range of matching channelses
	 */
	public static List<Channels> findByName(String name, int start, int end) {
		return getPersistence().findByName(name, start, end);
	}

	/**
	 * Returns an ordered range of all the channelses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChannelsModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of channelses
	 * @param end the upper bound of the range of channelses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching channelses
	 */
	public static List<Channels> findByName(
		String name, int start, int end,
		OrderByComparator<Channels> orderByComparator) {

		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the channelses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChannelsModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of channelses
	 * @param end the upper bound of the range of channelses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching channelses
	 */
	public static List<Channels> findByName(
		String name, int start, int end,
		OrderByComparator<Channels> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first channels in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channels
	 * @throws NoSuchChannelsException if a matching channels could not be found
	 */
	public static Channels findByName_First(
			String name, OrderByComparator<Channels> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchChannelsException {

		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first channels in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channels, or <code>null</code> if a matching channels could not be found
	 */
	public static Channels fetchByName_First(
		String name, OrderByComparator<Channels> orderByComparator) {

		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	 * Returns the last channels in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channels
	 * @throws NoSuchChannelsException if a matching channels could not be found
	 */
	public static Channels findByName_Last(
			String name, OrderByComparator<Channels> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchChannelsException {

		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last channels in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channels, or <code>null</code> if a matching channels could not be found
	 */
	public static Channels fetchByName_Last(
		String name, OrderByComparator<Channels> orderByComparator) {

		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the channelses before and after the current channels in the ordered set where name = &#63;.
	 *
	 * @param channelId the primary key of the current channels
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next channels
	 * @throws NoSuchChannelsException if a channels with the primary key could not be found
	 */
	public static Channels[] findByName_PrevAndNext(
			long channelId, String name,
			OrderByComparator<Channels> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchChannelsException {

		return getPersistence().findByName_PrevAndNext(
			channelId, name, orderByComparator);
	}

	/**
	 * Removes all the channelses where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByName(String name) {
		getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of channelses where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching channelses
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Returns all the channelses where name = &#63; and status &ne; &#63;.
	 *
	 * @param name the name
	 * @param status the status
	 * @return the matching channelses
	 */
	public static List<Channels> findByNameAndStatus(String name, int status) {
		return getPersistence().findByNameAndStatus(name, status);
	}

	/**
	 * Returns a range of all the channelses where name = &#63; and status &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChannelsModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param status the status
	 * @param start the lower bound of the range of channelses
	 * @param end the upper bound of the range of channelses (not inclusive)
	 * @return the range of matching channelses
	 */
	public static List<Channels> findByNameAndStatus(
		String name, int status, int start, int end) {

		return getPersistence().findByNameAndStatus(name, status, start, end);
	}

	/**
	 * Returns an ordered range of all the channelses where name = &#63; and status &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChannelsModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param status the status
	 * @param start the lower bound of the range of channelses
	 * @param end the upper bound of the range of channelses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching channelses
	 */
	public static List<Channels> findByNameAndStatus(
		String name, int status, int start, int end,
		OrderByComparator<Channels> orderByComparator) {

		return getPersistence().findByNameAndStatus(
			name, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the channelses where name = &#63; and status &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChannelsModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param status the status
	 * @param start the lower bound of the range of channelses
	 * @param end the upper bound of the range of channelses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching channelses
	 */
	public static List<Channels> findByNameAndStatus(
		String name, int status, int start, int end,
		OrderByComparator<Channels> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByNameAndStatus(
			name, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first channels in the ordered set where name = &#63; and status &ne; &#63;.
	 *
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channels
	 * @throws NoSuchChannelsException if a matching channels could not be found
	 */
	public static Channels findByNameAndStatus_First(
			String name, int status,
			OrderByComparator<Channels> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchChannelsException {

		return getPersistence().findByNameAndStatus_First(
			name, status, orderByComparator);
	}

	/**
	 * Returns the first channels in the ordered set where name = &#63; and status &ne; &#63;.
	 *
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channels, or <code>null</code> if a matching channels could not be found
	 */
	public static Channels fetchByNameAndStatus_First(
		String name, int status,
		OrderByComparator<Channels> orderByComparator) {

		return getPersistence().fetchByNameAndStatus_First(
			name, status, orderByComparator);
	}

	/**
	 * Returns the last channels in the ordered set where name = &#63; and status &ne; &#63;.
	 *
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channels
	 * @throws NoSuchChannelsException if a matching channels could not be found
	 */
	public static Channels findByNameAndStatus_Last(
			String name, int status,
			OrderByComparator<Channels> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchChannelsException {

		return getPersistence().findByNameAndStatus_Last(
			name, status, orderByComparator);
	}

	/**
	 * Returns the last channels in the ordered set where name = &#63; and status &ne; &#63;.
	 *
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channels, or <code>null</code> if a matching channels could not be found
	 */
	public static Channels fetchByNameAndStatus_Last(
		String name, int status,
		OrderByComparator<Channels> orderByComparator) {

		return getPersistence().fetchByNameAndStatus_Last(
			name, status, orderByComparator);
	}

	/**
	 * Returns the channelses before and after the current channels in the ordered set where name = &#63; and status &ne; &#63;.
	 *
	 * @param channelId the primary key of the current channels
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next channels
	 * @throws NoSuchChannelsException if a channels with the primary key could not be found
	 */
	public static Channels[] findByNameAndStatus_PrevAndNext(
			long channelId, String name, int status,
			OrderByComparator<Channels> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchChannelsException {

		return getPersistence().findByNameAndStatus_PrevAndNext(
			channelId, name, status, orderByComparator);
	}

	/**
	 * Removes all the channelses where name = &#63; and status &ne; &#63; from the database.
	 *
	 * @param name the name
	 * @param status the status
	 */
	public static void removeByNameAndStatus(String name, int status) {
		getPersistence().removeByNameAndStatus(name, status);
	}

	/**
	 * Returns the number of channelses where name = &#63; and status &ne; &#63;.
	 *
	 * @param name the name
	 * @param status the status
	 * @return the number of matching channelses
	 */
	public static int countByNameAndStatus(String name, int status) {
		return getPersistence().countByNameAndStatus(name, status);
	}

	/**
	 * Returns all the channelses where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching channelses
	 */
	public static List<Channels> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the channelses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChannelsModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of channelses
	 * @param end the upper bound of the range of channelses (not inclusive)
	 * @return the range of matching channelses
	 */
	public static List<Channels> findByStatus(int status, int start, int end) {
		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the channelses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChannelsModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of channelses
	 * @param end the upper bound of the range of channelses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching channelses
	 */
	public static List<Channels> findByStatus(
		int status, int start, int end,
		OrderByComparator<Channels> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the channelses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChannelsModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of channelses
	 * @param end the upper bound of the range of channelses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching channelses
	 */
	public static List<Channels> findByStatus(
		int status, int start, int end,
		OrderByComparator<Channels> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first channels in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channels
	 * @throws NoSuchChannelsException if a matching channels could not be found
	 */
	public static Channels findByStatus_First(
			int status, OrderByComparator<Channels> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchChannelsException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first channels in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channels, or <code>null</code> if a matching channels could not be found
	 */
	public static Channels fetchByStatus_First(
		int status, OrderByComparator<Channels> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last channels in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channels
	 * @throws NoSuchChannelsException if a matching channels could not be found
	 */
	public static Channels findByStatus_Last(
			int status, OrderByComparator<Channels> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchChannelsException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last channels in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channels, or <code>null</code> if a matching channels could not be found
	 */
	public static Channels fetchByStatus_Last(
		int status, OrderByComparator<Channels> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the channelses before and after the current channels in the ordered set where status = &#63;.
	 *
	 * @param channelId the primary key of the current channels
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next channels
	 * @throws NoSuchChannelsException if a channels with the primary key could not be found
	 */
	public static Channels[] findByStatus_PrevAndNext(
			long channelId, int status,
			OrderByComparator<Channels> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchChannelsException {

		return getPersistence().findByStatus_PrevAndNext(
			channelId, status, orderByComparator);
	}

	/**
	 * Removes all the channelses where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of channelses where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching channelses
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Caches the channels in the entity cache if it is enabled.
	 *
	 * @param channels the channels
	 */
	public static void cacheResult(Channels channels) {
		getPersistence().cacheResult(channels);
	}

	/**
	 * Caches the channelses in the entity cache if it is enabled.
	 *
	 * @param channelses the channelses
	 */
	public static void cacheResult(List<Channels> channelses) {
		getPersistence().cacheResult(channelses);
	}

	/**
	 * Creates a new channels with the primary key. Does not add the channels to the database.
	 *
	 * @param channelId the primary key for the new channels
	 * @return the new channels
	 */
	public static Channels create(long channelId) {
		return getPersistence().create(channelId);
	}

	/**
	 * Removes the channels with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param channelId the primary key of the channels
	 * @return the channels that was removed
	 * @throws NoSuchChannelsException if a channels with the primary key could not be found
	 */
	public static Channels remove(long channelId)
		throws com.ejada.telemony.db.exception.NoSuchChannelsException {

		return getPersistence().remove(channelId);
	}

	public static Channels updateImpl(Channels channels) {
		return getPersistence().updateImpl(channels);
	}

	/**
	 * Returns the channels with the primary key or throws a <code>NoSuchChannelsException</code> if it could not be found.
	 *
	 * @param channelId the primary key of the channels
	 * @return the channels
	 * @throws NoSuchChannelsException if a channels with the primary key could not be found
	 */
	public static Channels findByPrimaryKey(long channelId)
		throws com.ejada.telemony.db.exception.NoSuchChannelsException {

		return getPersistence().findByPrimaryKey(channelId);
	}

	/**
	 * Returns the channels with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param channelId the primary key of the channels
	 * @return the channels, or <code>null</code> if a channels with the primary key could not be found
	 */
	public static Channels fetchByPrimaryKey(long channelId) {
		return getPersistence().fetchByPrimaryKey(channelId);
	}

	/**
	 * Returns all the channelses.
	 *
	 * @return the channelses
	 */
	public static List<Channels> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the channelses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChannelsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of channelses
	 * @param end the upper bound of the range of channelses (not inclusive)
	 * @return the range of channelses
	 */
	public static List<Channels> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the channelses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChannelsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of channelses
	 * @param end the upper bound of the range of channelses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of channelses
	 */
	public static List<Channels> findAll(
		int start, int end, OrderByComparator<Channels> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the channelses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChannelsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of channelses
	 * @param end the upper bound of the range of channelses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of channelses
	 */
	public static List<Channels> findAll(
		int start, int end, OrderByComparator<Channels> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the channelses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of channelses.
	 *
	 * @return the number of channelses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ChannelsPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(ChannelsPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile ChannelsPersistence _persistence;

}