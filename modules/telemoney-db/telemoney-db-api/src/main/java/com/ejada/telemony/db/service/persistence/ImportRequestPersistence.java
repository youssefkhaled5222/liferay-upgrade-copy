/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.exception.NoSuchImportRequestException;
import com.ejada.telemony.db.model.ImportRequest;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the import request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImportRequestUtil
 * @generated
 */
@ProviderType
public interface ImportRequestPersistence
	extends BasePersistence<ImportRequest> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ImportRequestUtil} to access the import request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the import requests where type = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param status the status
	 * @return the matching import requests
	 */
	public java.util.List<ImportRequest> findBytypeAndStatus(
		String type, int status);

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
	public java.util.List<ImportRequest> findBytypeAndStatus(
		String type, int status, int start, int end);

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
	public java.util.List<ImportRequest> findBytypeAndStatus(
		String type, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImportRequest>
			orderByComparator);

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
	public java.util.List<ImportRequest> findBytypeAndStatus(
		String type, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImportRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first import request in the ordered set where type = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import request
	 * @throws NoSuchImportRequestException if a matching import request could not be found
	 */
	public ImportRequest findBytypeAndStatus_First(
			String type, int status,
			com.liferay.portal.kernel.util.OrderByComparator<ImportRequest>
				orderByComparator)
		throws NoSuchImportRequestException;

	/**
	 * Returns the first import request in the ordered set where type = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import request, or <code>null</code> if a matching import request could not be found
	 */
	public ImportRequest fetchBytypeAndStatus_First(
		String type, int status,
		com.liferay.portal.kernel.util.OrderByComparator<ImportRequest>
			orderByComparator);

	/**
	 * Returns the last import request in the ordered set where type = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import request
	 * @throws NoSuchImportRequestException if a matching import request could not be found
	 */
	public ImportRequest findBytypeAndStatus_Last(
			String type, int status,
			com.liferay.portal.kernel.util.OrderByComparator<ImportRequest>
				orderByComparator)
		throws NoSuchImportRequestException;

	/**
	 * Returns the last import request in the ordered set where type = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import request, or <code>null</code> if a matching import request could not be found
	 */
	public ImportRequest fetchBytypeAndStatus_Last(
		String type, int status,
		com.liferay.portal.kernel.util.OrderByComparator<ImportRequest>
			orderByComparator);

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
	public ImportRequest[] findBytypeAndStatus_PrevAndNext(
			long id, String type, int status,
			com.liferay.portal.kernel.util.OrderByComparator<ImportRequest>
				orderByComparator)
		throws NoSuchImportRequestException;

	/**
	 * Removes all the import requests where type = &#63; and status = &#63; from the database.
	 *
	 * @param type the type
	 * @param status the status
	 */
	public void removeBytypeAndStatus(String type, int status);

	/**
	 * Returns the number of import requests where type = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param status the status
	 * @return the number of matching import requests
	 */
	public int countBytypeAndStatus(String type, int status);

	/**
	 * Caches the import request in the entity cache if it is enabled.
	 *
	 * @param importRequest the import request
	 */
	public void cacheResult(ImportRequest importRequest);

	/**
	 * Caches the import requests in the entity cache if it is enabled.
	 *
	 * @param importRequests the import requests
	 */
	public void cacheResult(java.util.List<ImportRequest> importRequests);

	/**
	 * Creates a new import request with the primary key. Does not add the import request to the database.
	 *
	 * @param id the primary key for the new import request
	 * @return the new import request
	 */
	public ImportRequest create(long id);

	/**
	 * Removes the import request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the import request
	 * @return the import request that was removed
	 * @throws NoSuchImportRequestException if a import request with the primary key could not be found
	 */
	public ImportRequest remove(long id) throws NoSuchImportRequestException;

	public ImportRequest updateImpl(ImportRequest importRequest);

	/**
	 * Returns the import request with the primary key or throws a <code>NoSuchImportRequestException</code> if it could not be found.
	 *
	 * @param id the primary key of the import request
	 * @return the import request
	 * @throws NoSuchImportRequestException if a import request with the primary key could not be found
	 */
	public ImportRequest findByPrimaryKey(long id)
		throws NoSuchImportRequestException;

	/**
	 * Returns the import request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the import request
	 * @return the import request, or <code>null</code> if a import request with the primary key could not be found
	 */
	public ImportRequest fetchByPrimaryKey(long id);

	/**
	 * Returns all the import requests.
	 *
	 * @return the import requests
	 */
	public java.util.List<ImportRequest> findAll();

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
	public java.util.List<ImportRequest> findAll(int start, int end);

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
	public java.util.List<ImportRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImportRequest>
			orderByComparator);

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
	public java.util.List<ImportRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImportRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the import requests from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of import requests.
	 *
	 * @return the number of import requests
	 */
	public int countAll();

}