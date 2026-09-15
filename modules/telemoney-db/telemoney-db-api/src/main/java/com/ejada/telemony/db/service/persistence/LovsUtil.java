/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.model.Lovs;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the lovs service. This utility wraps <code>com.ejada.telemony.db.service.persistence.impl.LovsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LovsPersistence
 * @generated
 */
public class LovsUtil {

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
	public static void clearCache(Lovs lovs) {
		getPersistence().clearCache(lovs);
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
	public static Map<Serializable, Lovs> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Lovs> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Lovs> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Lovs> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Lovs> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Lovs update(Lovs lovs) {
		return getPersistence().update(lovs);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Lovs update(Lovs lovs, ServiceContext serviceContext) {
		return getPersistence().update(lovs, serviceContext);
	}

	/**
	 * Returns all the lovses where channelId = &#63; and code = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param status the status
	 * @return the matching lovses
	 */
	public static List<Lovs> findBytypeCodeAndStatus(
		long channelId, String code, int status) {

		return getPersistence().findBytypeCodeAndStatus(
			channelId, code, status);
	}

	/**
	 * Returns a range of all the lovses where channelId = &#63; and code = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param status the status
	 * @param start the lower bound of the range of lovses
	 * @param end the upper bound of the range of lovses (not inclusive)
	 * @return the range of matching lovses
	 */
	public static List<Lovs> findBytypeCodeAndStatus(
		long channelId, String code, int status, int start, int end) {

		return getPersistence().findBytypeCodeAndStatus(
			channelId, code, status, start, end);
	}

	/**
	 * Returns an ordered range of all the lovses where channelId = &#63; and code = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param status the status
	 * @param start the lower bound of the range of lovses
	 * @param end the upper bound of the range of lovses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lovses
	 */
	public static List<Lovs> findBytypeCodeAndStatus(
		long channelId, String code, int status, int start, int end,
		OrderByComparator<Lovs> orderByComparator) {

		return getPersistence().findBytypeCodeAndStatus(
			channelId, code, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the lovses where channelId = &#63; and code = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param status the status
	 * @param start the lower bound of the range of lovses
	 * @param end the upper bound of the range of lovses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lovses
	 */
	public static List<Lovs> findBytypeCodeAndStatus(
		long channelId, String code, int status, int start, int end,
		OrderByComparator<Lovs> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBytypeCodeAndStatus(
			channelId, code, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first lovs in the ordered set where channelId = &#63; and code = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs
	 * @throws NoSuchLovsException if a matching lovs could not be found
	 */
	public static Lovs findBytypeCodeAndStatus_First(
			long channelId, String code, int status,
			OrderByComparator<Lovs> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLovsException {

		return getPersistence().findBytypeCodeAndStatus_First(
			channelId, code, status, orderByComparator);
	}

	/**
	 * Returns the first lovs in the ordered set where channelId = &#63; and code = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs, or <code>null</code> if a matching lovs could not be found
	 */
	public static Lovs fetchBytypeCodeAndStatus_First(
		long channelId, String code, int status,
		OrderByComparator<Lovs> orderByComparator) {

		return getPersistence().fetchBytypeCodeAndStatus_First(
			channelId, code, status, orderByComparator);
	}

	/**
	 * Returns the last lovs in the ordered set where channelId = &#63; and code = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs
	 * @throws NoSuchLovsException if a matching lovs could not be found
	 */
	public static Lovs findBytypeCodeAndStatus_Last(
			long channelId, String code, int status,
			OrderByComparator<Lovs> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLovsException {

		return getPersistence().findBytypeCodeAndStatus_Last(
			channelId, code, status, orderByComparator);
	}

	/**
	 * Returns the last lovs in the ordered set where channelId = &#63; and code = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs, or <code>null</code> if a matching lovs could not be found
	 */
	public static Lovs fetchBytypeCodeAndStatus_Last(
		long channelId, String code, int status,
		OrderByComparator<Lovs> orderByComparator) {

		return getPersistence().fetchBytypeCodeAndStatus_Last(
			channelId, code, status, orderByComparator);
	}

	/**
	 * Returns the lovses before and after the current lovs in the ordered set where channelId = &#63; and code = &#63; and status = &#63;.
	 *
	 * @param id the primary key of the current lovs
	 * @param channelId the channel ID
	 * @param code the code
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lovs
	 * @throws NoSuchLovsException if a lovs with the primary key could not be found
	 */
	public static Lovs[] findBytypeCodeAndStatus_PrevAndNext(
			long id, long channelId, String code, int status,
			OrderByComparator<Lovs> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLovsException {

		return getPersistence().findBytypeCodeAndStatus_PrevAndNext(
			id, channelId, code, status, orderByComparator);
	}

	/**
	 * Removes all the lovses where channelId = &#63; and code = &#63; and status = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param status the status
	 */
	public static void removeBytypeCodeAndStatus(
		long channelId, String code, int status) {

		getPersistence().removeBytypeCodeAndStatus(channelId, code, status);
	}

	/**
	 * Returns the number of lovses where channelId = &#63; and code = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param status the status
	 * @return the number of matching lovses
	 */
	public static int countBytypeCodeAndStatus(
		long channelId, String code, int status) {

		return getPersistence().countBytypeCodeAndStatus(
			channelId, code, status);
	}

	/**
	 * Returns all the lovses where channelId = &#63; and code = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @return the matching lovses
	 */
	public static List<Lovs> findBytypeCode(long channelId, String code) {
		return getPersistence().findBytypeCode(channelId, code);
	}

	/**
	 * Returns a range of all the lovses where channelId = &#63; and code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param start the lower bound of the range of lovses
	 * @param end the upper bound of the range of lovses (not inclusive)
	 * @return the range of matching lovses
	 */
	public static List<Lovs> findBytypeCode(
		long channelId, String code, int start, int end) {

		return getPersistence().findBytypeCode(channelId, code, start, end);
	}

	/**
	 * Returns an ordered range of all the lovses where channelId = &#63; and code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param start the lower bound of the range of lovses
	 * @param end the upper bound of the range of lovses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lovses
	 */
	public static List<Lovs> findBytypeCode(
		long channelId, String code, int start, int end,
		OrderByComparator<Lovs> orderByComparator) {

		return getPersistence().findBytypeCode(
			channelId, code, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the lovses where channelId = &#63; and code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param start the lower bound of the range of lovses
	 * @param end the upper bound of the range of lovses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lovses
	 */
	public static List<Lovs> findBytypeCode(
		long channelId, String code, int start, int end,
		OrderByComparator<Lovs> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBytypeCode(
			channelId, code, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first lovs in the ordered set where channelId = &#63; and code = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs
	 * @throws NoSuchLovsException if a matching lovs could not be found
	 */
	public static Lovs findBytypeCode_First(
			long channelId, String code,
			OrderByComparator<Lovs> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLovsException {

		return getPersistence().findBytypeCode_First(
			channelId, code, orderByComparator);
	}

	/**
	 * Returns the first lovs in the ordered set where channelId = &#63; and code = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs, or <code>null</code> if a matching lovs could not be found
	 */
	public static Lovs fetchBytypeCode_First(
		long channelId, String code,
		OrderByComparator<Lovs> orderByComparator) {

		return getPersistence().fetchBytypeCode_First(
			channelId, code, orderByComparator);
	}

	/**
	 * Returns the last lovs in the ordered set where channelId = &#63; and code = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs
	 * @throws NoSuchLovsException if a matching lovs could not be found
	 */
	public static Lovs findBytypeCode_Last(
			long channelId, String code,
			OrderByComparator<Lovs> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLovsException {

		return getPersistence().findBytypeCode_Last(
			channelId, code, orderByComparator);
	}

	/**
	 * Returns the last lovs in the ordered set where channelId = &#63; and code = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs, or <code>null</code> if a matching lovs could not be found
	 */
	public static Lovs fetchBytypeCode_Last(
		long channelId, String code,
		OrderByComparator<Lovs> orderByComparator) {

		return getPersistence().fetchBytypeCode_Last(
			channelId, code, orderByComparator);
	}

	/**
	 * Returns the lovses before and after the current lovs in the ordered set where channelId = &#63; and code = &#63;.
	 *
	 * @param id the primary key of the current lovs
	 * @param channelId the channel ID
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lovs
	 * @throws NoSuchLovsException if a lovs with the primary key could not be found
	 */
	public static Lovs[] findBytypeCode_PrevAndNext(
			long id, long channelId, String code,
			OrderByComparator<Lovs> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLovsException {

		return getPersistence().findBytypeCode_PrevAndNext(
			id, channelId, code, orderByComparator);
	}

	/**
	 * Removes all the lovses where channelId = &#63; and code = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 */
	public static void removeBytypeCode(long channelId, String code) {
		getPersistence().removeBytypeCode(channelId, code);
	}

	/**
	 * Returns the number of lovses where channelId = &#63; and code = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @return the number of matching lovses
	 */
	public static int countBytypeCode(long channelId, String code) {
		return getPersistence().countBytypeCode(channelId, code);
	}

	/**
	 * Returns all the lovses where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the matching lovses
	 */
	public static List<Lovs> findByChannelId(long channelId) {
		return getPersistence().findByChannelId(channelId);
	}

	/**
	 * Returns a range of all the lovses where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of lovses
	 * @param end the upper bound of the range of lovses (not inclusive)
	 * @return the range of matching lovses
	 */
	public static List<Lovs> findByChannelId(
		long channelId, int start, int end) {

		return getPersistence().findByChannelId(channelId, start, end);
	}

	/**
	 * Returns an ordered range of all the lovses where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of lovses
	 * @param end the upper bound of the range of lovses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lovses
	 */
	public static List<Lovs> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<Lovs> orderByComparator) {

		return getPersistence().findByChannelId(
			channelId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the lovses where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of lovses
	 * @param end the upper bound of the range of lovses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lovses
	 */
	public static List<Lovs> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<Lovs> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByChannelId(
			channelId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first lovs in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs
	 * @throws NoSuchLovsException if a matching lovs could not be found
	 */
	public static Lovs findByChannelId_First(
			long channelId, OrderByComparator<Lovs> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLovsException {

		return getPersistence().findByChannelId_First(
			channelId, orderByComparator);
	}

	/**
	 * Returns the first lovs in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs, or <code>null</code> if a matching lovs could not be found
	 */
	public static Lovs fetchByChannelId_First(
		long channelId, OrderByComparator<Lovs> orderByComparator) {

		return getPersistence().fetchByChannelId_First(
			channelId, orderByComparator);
	}

	/**
	 * Returns the last lovs in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs
	 * @throws NoSuchLovsException if a matching lovs could not be found
	 */
	public static Lovs findByChannelId_Last(
			long channelId, OrderByComparator<Lovs> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLovsException {

		return getPersistence().findByChannelId_Last(
			channelId, orderByComparator);
	}

	/**
	 * Returns the last lovs in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs, or <code>null</code> if a matching lovs could not be found
	 */
	public static Lovs fetchByChannelId_Last(
		long channelId, OrderByComparator<Lovs> orderByComparator) {

		return getPersistence().fetchByChannelId_Last(
			channelId, orderByComparator);
	}

	/**
	 * Returns the lovses before and after the current lovs in the ordered set where channelId = &#63;.
	 *
	 * @param id the primary key of the current lovs
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lovs
	 * @throws NoSuchLovsException if a lovs with the primary key could not be found
	 */
	public static Lovs[] findByChannelId_PrevAndNext(
			long id, long channelId, OrderByComparator<Lovs> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLovsException {

		return getPersistence().findByChannelId_PrevAndNext(
			id, channelId, orderByComparator);
	}

	/**
	 * Removes all the lovses where channelId = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 */
	public static void removeByChannelId(long channelId) {
		getPersistence().removeByChannelId(channelId);
	}

	/**
	 * Returns the number of lovses where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the number of matching lovses
	 */
	public static int countByChannelId(long channelId) {
		return getPersistence().countByChannelId(channelId);
	}

	/**
	 * Returns all the lovses where id = &#63; and channelId = &#63;.
	 *
	 * @param id the ID
	 * @param channelId the channel ID
	 * @return the matching lovses
	 */
	public static List<Lovs> findByidAndChannel(long id, long channelId) {
		return getPersistence().findByidAndChannel(id, channelId);
	}

	/**
	 * Returns a range of all the lovses where id = &#63; and channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of lovses
	 * @param end the upper bound of the range of lovses (not inclusive)
	 * @return the range of matching lovses
	 */
	public static List<Lovs> findByidAndChannel(
		long id, long channelId, int start, int end) {

		return getPersistence().findByidAndChannel(id, channelId, start, end);
	}

	/**
	 * Returns an ordered range of all the lovses where id = &#63; and channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of lovses
	 * @param end the upper bound of the range of lovses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lovses
	 */
	public static List<Lovs> findByidAndChannel(
		long id, long channelId, int start, int end,
		OrderByComparator<Lovs> orderByComparator) {

		return getPersistence().findByidAndChannel(
			id, channelId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the lovses where id = &#63; and channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of lovses
	 * @param end the upper bound of the range of lovses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lovses
	 */
	public static List<Lovs> findByidAndChannel(
		long id, long channelId, int start, int end,
		OrderByComparator<Lovs> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByidAndChannel(
			id, channelId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first lovs in the ordered set where id = &#63; and channelId = &#63;.
	 *
	 * @param id the ID
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs
	 * @throws NoSuchLovsException if a matching lovs could not be found
	 */
	public static Lovs findByidAndChannel_First(
			long id, long channelId, OrderByComparator<Lovs> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLovsException {

		return getPersistence().findByidAndChannel_First(
			id, channelId, orderByComparator);
	}

	/**
	 * Returns the first lovs in the ordered set where id = &#63; and channelId = &#63;.
	 *
	 * @param id the ID
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs, or <code>null</code> if a matching lovs could not be found
	 */
	public static Lovs fetchByidAndChannel_First(
		long id, long channelId, OrderByComparator<Lovs> orderByComparator) {

		return getPersistence().fetchByidAndChannel_First(
			id, channelId, orderByComparator);
	}

	/**
	 * Returns the last lovs in the ordered set where id = &#63; and channelId = &#63;.
	 *
	 * @param id the ID
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs
	 * @throws NoSuchLovsException if a matching lovs could not be found
	 */
	public static Lovs findByidAndChannel_Last(
			long id, long channelId, OrderByComparator<Lovs> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLovsException {

		return getPersistence().findByidAndChannel_Last(
			id, channelId, orderByComparator);
	}

	/**
	 * Returns the last lovs in the ordered set where id = &#63; and channelId = &#63;.
	 *
	 * @param id the ID
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs, or <code>null</code> if a matching lovs could not be found
	 */
	public static Lovs fetchByidAndChannel_Last(
		long id, long channelId, OrderByComparator<Lovs> orderByComparator) {

		return getPersistence().fetchByidAndChannel_Last(
			id, channelId, orderByComparator);
	}

	/**
	 * Removes all the lovses where id = &#63; and channelId = &#63; from the database.
	 *
	 * @param id the ID
	 * @param channelId the channel ID
	 */
	public static void removeByidAndChannel(long id, long channelId) {
		getPersistence().removeByidAndChannel(id, channelId);
	}

	/**
	 * Returns the number of lovses where id = &#63; and channelId = &#63;.
	 *
	 * @param id the ID
	 * @param channelId the channel ID
	 * @return the number of matching lovses
	 */
	public static int countByidAndChannel(long id, long channelId) {
		return getPersistence().countByidAndChannel(id, channelId);
	}

	/**
	 * Returns all the lovses where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the matching lovses
	 */
	public static List<Lovs> findByEntityResourceId(long entityResourceId) {
		return getPersistence().findByEntityResourceId(entityResourceId);
	}

	/**
	 * Returns a range of all the lovses where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of lovses
	 * @param end the upper bound of the range of lovses (not inclusive)
	 * @return the range of matching lovses
	 */
	public static List<Lovs> findByEntityResourceId(
		long entityResourceId, int start, int end) {

		return getPersistence().findByEntityResourceId(
			entityResourceId, start, end);
	}

	/**
	 * Returns an ordered range of all the lovses where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of lovses
	 * @param end the upper bound of the range of lovses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lovses
	 */
	public static List<Lovs> findByEntityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<Lovs> orderByComparator) {

		return getPersistence().findByEntityResourceId(
			entityResourceId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the lovses where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of lovses
	 * @param end the upper bound of the range of lovses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lovses
	 */
	public static List<Lovs> findByEntityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<Lovs> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByEntityResourceId(
			entityResourceId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first lovs in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs
	 * @throws NoSuchLovsException if a matching lovs could not be found
	 */
	public static Lovs findByEntityResourceId_First(
			long entityResourceId, OrderByComparator<Lovs> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLovsException {

		return getPersistence().findByEntityResourceId_First(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the first lovs in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs, or <code>null</code> if a matching lovs could not be found
	 */
	public static Lovs fetchByEntityResourceId_First(
		long entityResourceId, OrderByComparator<Lovs> orderByComparator) {

		return getPersistence().fetchByEntityResourceId_First(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the last lovs in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs
	 * @throws NoSuchLovsException if a matching lovs could not be found
	 */
	public static Lovs findByEntityResourceId_Last(
			long entityResourceId, OrderByComparator<Lovs> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLovsException {

		return getPersistence().findByEntityResourceId_Last(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the last lovs in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs, or <code>null</code> if a matching lovs could not be found
	 */
	public static Lovs fetchByEntityResourceId_Last(
		long entityResourceId, OrderByComparator<Lovs> orderByComparator) {

		return getPersistence().fetchByEntityResourceId_Last(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the lovses before and after the current lovs in the ordered set where entityResourceId = &#63;.
	 *
	 * @param id the primary key of the current lovs
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lovs
	 * @throws NoSuchLovsException if a lovs with the primary key could not be found
	 */
	public static Lovs[] findByEntityResourceId_PrevAndNext(
			long id, long entityResourceId,
			OrderByComparator<Lovs> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLovsException {

		return getPersistence().findByEntityResourceId_PrevAndNext(
			id, entityResourceId, orderByComparator);
	}

	/**
	 * Removes all the lovses where entityResourceId = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 */
	public static void removeByEntityResourceId(long entityResourceId) {
		getPersistence().removeByEntityResourceId(entityResourceId);
	}

	/**
	 * Returns the number of lovses where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the number of matching lovses
	 */
	public static int countByEntityResourceId(long entityResourceId) {
		return getPersistence().countByEntityResourceId(entityResourceId);
	}

	/**
	 * Caches the lovs in the entity cache if it is enabled.
	 *
	 * @param lovs the lovs
	 */
	public static void cacheResult(Lovs lovs) {
		getPersistence().cacheResult(lovs);
	}

	/**
	 * Caches the lovses in the entity cache if it is enabled.
	 *
	 * @param lovses the lovses
	 */
	public static void cacheResult(List<Lovs> lovses) {
		getPersistence().cacheResult(lovses);
	}

	/**
	 * Creates a new lovs with the primary key. Does not add the lovs to the database.
	 *
	 * @param id the primary key for the new lovs
	 * @return the new lovs
	 */
	public static Lovs create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the lovs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the lovs
	 * @return the lovs that was removed
	 * @throws NoSuchLovsException if a lovs with the primary key could not be found
	 */
	public static Lovs remove(long id)
		throws com.ejada.telemony.db.exception.NoSuchLovsException {

		return getPersistence().remove(id);
	}

	public static Lovs updateImpl(Lovs lovs) {
		return getPersistence().updateImpl(lovs);
	}

	/**
	 * Returns the lovs with the primary key or throws a <code>NoSuchLovsException</code> if it could not be found.
	 *
	 * @param id the primary key of the lovs
	 * @return the lovs
	 * @throws NoSuchLovsException if a lovs with the primary key could not be found
	 */
	public static Lovs findByPrimaryKey(long id)
		throws com.ejada.telemony.db.exception.NoSuchLovsException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the lovs with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the lovs
	 * @return the lovs, or <code>null</code> if a lovs with the primary key could not be found
	 */
	public static Lovs fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the lovses.
	 *
	 * @return the lovses
	 */
	public static List<Lovs> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the lovses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lovses
	 * @param end the upper bound of the range of lovses (not inclusive)
	 * @return the range of lovses
	 */
	public static List<Lovs> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the lovses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lovses
	 * @param end the upper bound of the range of lovses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lovses
	 */
	public static List<Lovs> findAll(
		int start, int end, OrderByComparator<Lovs> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the lovses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lovses
	 * @param end the upper bound of the range of lovses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of lovses
	 */
	public static List<Lovs> findAll(
		int start, int end, OrderByComparator<Lovs> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the lovses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of lovses.
	 *
	 * @return the number of lovses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LovsPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(LovsPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile LovsPersistence _persistence;

}