/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.model.ImportRequest;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the import request service. This utility wraps <code>com.ejada.telemony.db.service.persistence.impl.ImportRequestPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImportRequestPersistence
 * @generated
 */
public class ImportRequestUtil {

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
	public static void clearCache(ImportRequest importRequest) {
		getPersistence().clearCache(importRequest);
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
	public static Map<Serializable, ImportRequest> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ImportRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ImportRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ImportRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ImportRequest> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ImportRequest update(ImportRequest importRequest) {
		return getPersistence().update(importRequest);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ImportRequest update(
		ImportRequest importRequest, ServiceContext serviceContext) {

		return getPersistence().update(importRequest, serviceContext);
	}

	/**
	 * Returns all the import requests where type = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param status the status
	 * @return the matching import requests
	 */
	public static List<ImportRequest> findBytypeAndStatus(
		String type, int status) {

		return getPersistence().findBytypeAndStatus(type, status);
	}

	/**
	 * Returns a range of all the import requests where type = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportRequestModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param status the status
	 * @param start the lower bound of the range of import requests
	 * @param end the upper bound of the range of import requests (not inclusive)
	 * @return the range of matching import requests
	 */
	public static List<ImportRequest> findBytypeAndStatus(
		String type, int status, int start, int end) {

		return getPersistence().findBytypeAndStatus(type, status, start, end);
	}

	/**
	 * Returns an ordered range of all the import requests where type = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportRequestModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param status the status
	 * @param start the lower bound of the range of import requests
	 * @param end the upper bound of the range of import requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching import requests
	 */
	public static List<ImportRequest> findBytypeAndStatus(
		String type, int status, int start, int end,
		OrderByComparator<ImportRequest> orderByComparator) {

		return getPersistence().findBytypeAndStatus(
			type, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the import requests where type = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportRequestModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param status the status
	 * @param start the lower bound of the range of import requests
	 * @param end the upper bound of the range of import requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching import requests
	 */
	public static List<ImportRequest> findBytypeAndStatus(
		String type, int status, int start, int end,
		OrderByComparator<ImportRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBytypeAndStatus(
			type, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first import request in the ordered set where type = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import request
	 * @throws NoSuchImportRequestException if a matching import request could not be found
	 */
	public static ImportRequest findBytypeAndStatus_First(
			String type, int status,
			OrderByComparator<ImportRequest> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchImportRequestException {

		return getPersistence().findBytypeAndStatus_First(
			type, status, orderByComparator);
	}

	/**
	 * Returns the first import request in the ordered set where type = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import request, or <code>null</code> if a matching import request could not be found
	 */
	public static ImportRequest fetchBytypeAndStatus_First(
		String type, int status,
		OrderByComparator<ImportRequest> orderByComparator) {

		return getPersistence().fetchBytypeAndStatus_First(
			type, status, orderByComparator);
	}

	/**
	 * Returns the last import request in the ordered set where type = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import request
	 * @throws NoSuchImportRequestException if a matching import request could not be found
	 */
	public static ImportRequest findBytypeAndStatus_Last(
			String type, int status,
			OrderByComparator<ImportRequest> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchImportRequestException {

		return getPersistence().findBytypeAndStatus_Last(
			type, status, orderByComparator);
	}

	/**
	 * Returns the last import request in the ordered set where type = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import request, or <code>null</code> if a matching import request could not be found
	 */
	public static ImportRequest fetchBytypeAndStatus_Last(
		String type, int status,
		OrderByComparator<ImportRequest> orderByComparator) {

		return getPersistence().fetchBytypeAndStatus_Last(
			type, status, orderByComparator);
	}

	/**
	 * Returns the import requests before and after the current import request in the ordered set where type = &#63; and status = &#63;.
	 *
	 * @param id the primary key of the current import request
	 * @param type the type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next import request
	 * @throws NoSuchImportRequestException if a import request with the primary key could not be found
	 */
	public static ImportRequest[] findBytypeAndStatus_PrevAndNext(
			long id, String type, int status,
			OrderByComparator<ImportRequest> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchImportRequestException {

		return getPersistence().findBytypeAndStatus_PrevAndNext(
			id, type, status, orderByComparator);
	}

	/**
	 * Removes all the import requests where type = &#63; and status = &#63; from the database.
	 *
	 * @param type the type
	 * @param status the status
	 */
	public static void removeBytypeAndStatus(String type, int status) {
		getPersistence().removeBytypeAndStatus(type, status);
	}

	/**
	 * Returns the number of import requests where type = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param status the status
	 * @return the number of matching import requests
	 */
	public static int countBytypeAndStatus(String type, int status) {
		return getPersistence().countBytypeAndStatus(type, status);
	}

	/**
	 * Caches the import request in the entity cache if it is enabled.
	 *
	 * @param importRequest the import request
	 */
	public static void cacheResult(ImportRequest importRequest) {
		getPersistence().cacheResult(importRequest);
	}

	/**
	 * Caches the import requests in the entity cache if it is enabled.
	 *
	 * @param importRequests the import requests
	 */
	public static void cacheResult(List<ImportRequest> importRequests) {
		getPersistence().cacheResult(importRequests);
	}

	/**
	 * Creates a new import request with the primary key. Does not add the import request to the database.
	 *
	 * @param id the primary key for the new import request
	 * @return the new import request
	 */
	public static ImportRequest create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the import request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the import request
	 * @return the import request that was removed
	 * @throws NoSuchImportRequestException if a import request with the primary key could not be found
	 */
	public static ImportRequest remove(long id)
		throws com.ejada.telemony.db.exception.NoSuchImportRequestException {

		return getPersistence().remove(id);
	}

	public static ImportRequest updateImpl(ImportRequest importRequest) {
		return getPersistence().updateImpl(importRequest);
	}

	/**
	 * Returns the import request with the primary key or throws a <code>NoSuchImportRequestException</code> if it could not be found.
	 *
	 * @param id the primary key of the import request
	 * @return the import request
	 * @throws NoSuchImportRequestException if a import request with the primary key could not be found
	 */
	public static ImportRequest findByPrimaryKey(long id)
		throws com.ejada.telemony.db.exception.NoSuchImportRequestException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the import request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the import request
	 * @return the import request, or <code>null</code> if a import request with the primary key could not be found
	 */
	public static ImportRequest fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the import requests.
	 *
	 * @return the import requests
	 */
	public static List<ImportRequest> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the import requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of import requests
	 * @param end the upper bound of the range of import requests (not inclusive)
	 * @return the range of import requests
	 */
	public static List<ImportRequest> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the import requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of import requests
	 * @param end the upper bound of the range of import requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of import requests
	 */
	public static List<ImportRequest> findAll(
		int start, int end,
		OrderByComparator<ImportRequest> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the import requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of import requests
	 * @param end the upper bound of the range of import requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of import requests
	 */
	public static List<ImportRequest> findAll(
		int start, int end, OrderByComparator<ImportRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the import requests from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of import requests.
	 *
	 * @return the number of import requests
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ImportRequestPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(ImportRequestPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile ImportRequestPersistence _persistence;

}