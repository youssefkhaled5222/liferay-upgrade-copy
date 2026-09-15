/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.exception.NoSuchLovDataException;
import com.ejada.telemony.db.model.LovData;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the lov data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LovDataUtil
 * @generated
 */
@ProviderType
public interface LovDataPersistence extends BasePersistence<LovData> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LovDataUtil} to access the lov data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the lov datas where lovId = &#63;.
	 *
	 * @param lovId the lov ID
	 * @return the matching lov datas
	 */
	public java.util.List<LovData> findByLovdata(long lovId);

	/**
	 * Returns a range of all the lov datas where lovId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataModelImpl</code>.
	 * </p>
	 *
	 * @param lovId the lov ID
	 * @param start the lower bound of the range of lov datas
	 * @param end the upper bound of the range of lov datas (not inclusive)
	 * @return the range of matching lov datas
	 */
	public java.util.List<LovData> findByLovdata(
		long lovId, int start, int end);

	/**
	 * Returns an ordered range of all the lov datas where lovId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataModelImpl</code>.
	 * </p>
	 *
	 * @param lovId the lov ID
	 * @param start the lower bound of the range of lov datas
	 * @param end the upper bound of the range of lov datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lov datas
	 */
	public java.util.List<LovData> findByLovdata(
		long lovId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LovData>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lov datas where lovId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataModelImpl</code>.
	 * </p>
	 *
	 * @param lovId the lov ID
	 * @param start the lower bound of the range of lov datas
	 * @param end the upper bound of the range of lov datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lov datas
	 */
	public java.util.List<LovData> findByLovdata(
		long lovId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LovData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first lov data in the ordered set where lovId = &#63;.
	 *
	 * @param lovId the lov ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data
	 * @throws NoSuchLovDataException if a matching lov data could not be found
	 */
	public LovData findByLovdata_First(
			long lovId,
			com.liferay.portal.kernel.util.OrderByComparator<LovData>
				orderByComparator)
		throws NoSuchLovDataException;

	/**
	 * Returns the first lov data in the ordered set where lovId = &#63;.
	 *
	 * @param lovId the lov ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data, or <code>null</code> if a matching lov data could not be found
	 */
	public LovData fetchByLovdata_First(
		long lovId,
		com.liferay.portal.kernel.util.OrderByComparator<LovData>
			orderByComparator);

	/**
	 * Returns the last lov data in the ordered set where lovId = &#63;.
	 *
	 * @param lovId the lov ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data
	 * @throws NoSuchLovDataException if a matching lov data could not be found
	 */
	public LovData findByLovdata_Last(
			long lovId,
			com.liferay.portal.kernel.util.OrderByComparator<LovData>
				orderByComparator)
		throws NoSuchLovDataException;

	/**
	 * Returns the last lov data in the ordered set where lovId = &#63;.
	 *
	 * @param lovId the lov ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data, or <code>null</code> if a matching lov data could not be found
	 */
	public LovData fetchByLovdata_Last(
		long lovId,
		com.liferay.portal.kernel.util.OrderByComparator<LovData>
			orderByComparator);

	/**
	 * Returns the lov datas before and after the current lov data in the ordered set where lovId = &#63;.
	 *
	 * @param id the primary key of the current lov data
	 * @param lovId the lov ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lov data
	 * @throws NoSuchLovDataException if a lov data with the primary key could not be found
	 */
	public LovData[] findByLovdata_PrevAndNext(
			long id, long lovId,
			com.liferay.portal.kernel.util.OrderByComparator<LovData>
				orderByComparator)
		throws NoSuchLovDataException;

	/**
	 * Removes all the lov datas where lovId = &#63; from the database.
	 *
	 * @param lovId the lov ID
	 */
	public void removeByLovdata(long lovId);

	/**
	 * Returns the number of lov datas where lovId = &#63;.
	 *
	 * @param lovId the lov ID
	 * @return the number of matching lov datas
	 */
	public int countByLovdata(long lovId);

	/**
	 * Returns all the lov datas where lovId = &#63; and recordShortDescription = &#63;.
	 *
	 * @param lovId the lov ID
	 * @param recordShortDescription the record short description
	 * @return the matching lov datas
	 */
	public java.util.List<LovData> findBylovIdAndRecordShortDescription(
		long lovId, String recordShortDescription);

	/**
	 * Returns a range of all the lov datas where lovId = &#63; and recordShortDescription = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataModelImpl</code>.
	 * </p>
	 *
	 * @param lovId the lov ID
	 * @param recordShortDescription the record short description
	 * @param start the lower bound of the range of lov datas
	 * @param end the upper bound of the range of lov datas (not inclusive)
	 * @return the range of matching lov datas
	 */
	public java.util.List<LovData> findBylovIdAndRecordShortDescription(
		long lovId, String recordShortDescription, int start, int end);

	/**
	 * Returns an ordered range of all the lov datas where lovId = &#63; and recordShortDescription = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataModelImpl</code>.
	 * </p>
	 *
	 * @param lovId the lov ID
	 * @param recordShortDescription the record short description
	 * @param start the lower bound of the range of lov datas
	 * @param end the upper bound of the range of lov datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lov datas
	 */
	public java.util.List<LovData> findBylovIdAndRecordShortDescription(
		long lovId, String recordShortDescription, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LovData>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lov datas where lovId = &#63; and recordShortDescription = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataModelImpl</code>.
	 * </p>
	 *
	 * @param lovId the lov ID
	 * @param recordShortDescription the record short description
	 * @param start the lower bound of the range of lov datas
	 * @param end the upper bound of the range of lov datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lov datas
	 */
	public java.util.List<LovData> findBylovIdAndRecordShortDescription(
		long lovId, String recordShortDescription, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LovData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first lov data in the ordered set where lovId = &#63; and recordShortDescription = &#63;.
	 *
	 * @param lovId the lov ID
	 * @param recordShortDescription the record short description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data
	 * @throws NoSuchLovDataException if a matching lov data could not be found
	 */
	public LovData findBylovIdAndRecordShortDescription_First(
			long lovId, String recordShortDescription,
			com.liferay.portal.kernel.util.OrderByComparator<LovData>
				orderByComparator)
		throws NoSuchLovDataException;

	/**
	 * Returns the first lov data in the ordered set where lovId = &#63; and recordShortDescription = &#63;.
	 *
	 * @param lovId the lov ID
	 * @param recordShortDescription the record short description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data, or <code>null</code> if a matching lov data could not be found
	 */
	public LovData fetchBylovIdAndRecordShortDescription_First(
		long lovId, String recordShortDescription,
		com.liferay.portal.kernel.util.OrderByComparator<LovData>
			orderByComparator);

	/**
	 * Returns the last lov data in the ordered set where lovId = &#63; and recordShortDescription = &#63;.
	 *
	 * @param lovId the lov ID
	 * @param recordShortDescription the record short description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data
	 * @throws NoSuchLovDataException if a matching lov data could not be found
	 */
	public LovData findBylovIdAndRecordShortDescription_Last(
			long lovId, String recordShortDescription,
			com.liferay.portal.kernel.util.OrderByComparator<LovData>
				orderByComparator)
		throws NoSuchLovDataException;

	/**
	 * Returns the last lov data in the ordered set where lovId = &#63; and recordShortDescription = &#63;.
	 *
	 * @param lovId the lov ID
	 * @param recordShortDescription the record short description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data, or <code>null</code> if a matching lov data could not be found
	 */
	public LovData fetchBylovIdAndRecordShortDescription_Last(
		long lovId, String recordShortDescription,
		com.liferay.portal.kernel.util.OrderByComparator<LovData>
			orderByComparator);

	/**
	 * Returns the lov datas before and after the current lov data in the ordered set where lovId = &#63; and recordShortDescription = &#63;.
	 *
	 * @param id the primary key of the current lov data
	 * @param lovId the lov ID
	 * @param recordShortDescription the record short description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lov data
	 * @throws NoSuchLovDataException if a lov data with the primary key could not be found
	 */
	public LovData[] findBylovIdAndRecordShortDescription_PrevAndNext(
			long id, long lovId, String recordShortDescription,
			com.liferay.portal.kernel.util.OrderByComparator<LovData>
				orderByComparator)
		throws NoSuchLovDataException;

	/**
	 * Removes all the lov datas where lovId = &#63; and recordShortDescription = &#63; from the database.
	 *
	 * @param lovId the lov ID
	 * @param recordShortDescription the record short description
	 */
	public void removeBylovIdAndRecordShortDescription(
		long lovId, String recordShortDescription);

	/**
	 * Returns the number of lov datas where lovId = &#63; and recordShortDescription = &#63;.
	 *
	 * @param lovId the lov ID
	 * @param recordShortDescription the record short description
	 * @return the number of matching lov datas
	 */
	public int countBylovIdAndRecordShortDescription(
		long lovId, String recordShortDescription);

	/**
	 * Returns all the lov datas where lovType = &#63; and recordTypeCode = &#63; and entityResourceId = &#63; and status = &#63;.
	 *
	 * @param lovType the lov type
	 * @param recordTypeCode the record type code
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @return the matching lov datas
	 */
	public java.util.List<LovData> findByDataTypeCodeAndLovCodeAndStatus(
		String lovType, String recordTypeCode, long entityResourceId,
		int status);

	/**
	 * Returns a range of all the lov datas where lovType = &#63; and recordTypeCode = &#63; and entityResourceId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataModelImpl</code>.
	 * </p>
	 *
	 * @param lovType the lov type
	 * @param recordTypeCode the record type code
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @param start the lower bound of the range of lov datas
	 * @param end the upper bound of the range of lov datas (not inclusive)
	 * @return the range of matching lov datas
	 */
	public java.util.List<LovData> findByDataTypeCodeAndLovCodeAndStatus(
		String lovType, String recordTypeCode, long entityResourceId,
		int status, int start, int end);

	/**
	 * Returns an ordered range of all the lov datas where lovType = &#63; and recordTypeCode = &#63; and entityResourceId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataModelImpl</code>.
	 * </p>
	 *
	 * @param lovType the lov type
	 * @param recordTypeCode the record type code
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @param start the lower bound of the range of lov datas
	 * @param end the upper bound of the range of lov datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lov datas
	 */
	public java.util.List<LovData> findByDataTypeCodeAndLovCodeAndStatus(
		String lovType, String recordTypeCode, long entityResourceId,
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LovData>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lov datas where lovType = &#63; and recordTypeCode = &#63; and entityResourceId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataModelImpl</code>.
	 * </p>
	 *
	 * @param lovType the lov type
	 * @param recordTypeCode the record type code
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @param start the lower bound of the range of lov datas
	 * @param end the upper bound of the range of lov datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lov datas
	 */
	public java.util.List<LovData> findByDataTypeCodeAndLovCodeAndStatus(
		String lovType, String recordTypeCode, long entityResourceId,
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LovData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first lov data in the ordered set where lovType = &#63; and recordTypeCode = &#63; and entityResourceId = &#63; and status = &#63;.
	 *
	 * @param lovType the lov type
	 * @param recordTypeCode the record type code
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data
	 * @throws NoSuchLovDataException if a matching lov data could not be found
	 */
	public LovData findByDataTypeCodeAndLovCodeAndStatus_First(
			String lovType, String recordTypeCode, long entityResourceId,
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<LovData>
				orderByComparator)
		throws NoSuchLovDataException;

	/**
	 * Returns the first lov data in the ordered set where lovType = &#63; and recordTypeCode = &#63; and entityResourceId = &#63; and status = &#63;.
	 *
	 * @param lovType the lov type
	 * @param recordTypeCode the record type code
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data, or <code>null</code> if a matching lov data could not be found
	 */
	public LovData fetchByDataTypeCodeAndLovCodeAndStatus_First(
		String lovType, String recordTypeCode, long entityResourceId,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<LovData>
			orderByComparator);

	/**
	 * Returns the last lov data in the ordered set where lovType = &#63; and recordTypeCode = &#63; and entityResourceId = &#63; and status = &#63;.
	 *
	 * @param lovType the lov type
	 * @param recordTypeCode the record type code
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data
	 * @throws NoSuchLovDataException if a matching lov data could not be found
	 */
	public LovData findByDataTypeCodeAndLovCodeAndStatus_Last(
			String lovType, String recordTypeCode, long entityResourceId,
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<LovData>
				orderByComparator)
		throws NoSuchLovDataException;

	/**
	 * Returns the last lov data in the ordered set where lovType = &#63; and recordTypeCode = &#63; and entityResourceId = &#63; and status = &#63;.
	 *
	 * @param lovType the lov type
	 * @param recordTypeCode the record type code
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data, or <code>null</code> if a matching lov data could not be found
	 */
	public LovData fetchByDataTypeCodeAndLovCodeAndStatus_Last(
		String lovType, String recordTypeCode, long entityResourceId,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<LovData>
			orderByComparator);

	/**
	 * Returns the lov datas before and after the current lov data in the ordered set where lovType = &#63; and recordTypeCode = &#63; and entityResourceId = &#63; and status = &#63;.
	 *
	 * @param id the primary key of the current lov data
	 * @param lovType the lov type
	 * @param recordTypeCode the record type code
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lov data
	 * @throws NoSuchLovDataException if a lov data with the primary key could not be found
	 */
	public LovData[] findByDataTypeCodeAndLovCodeAndStatus_PrevAndNext(
			long id, String lovType, String recordTypeCode,
			long entityResourceId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<LovData>
				orderByComparator)
		throws NoSuchLovDataException;

	/**
	 * Removes all the lov datas where lovType = &#63; and recordTypeCode = &#63; and entityResourceId = &#63; and status = &#63; from the database.
	 *
	 * @param lovType the lov type
	 * @param recordTypeCode the record type code
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 */
	public void removeByDataTypeCodeAndLovCodeAndStatus(
		String lovType, String recordTypeCode, long entityResourceId,
		int status);

	/**
	 * Returns the number of lov datas where lovType = &#63; and recordTypeCode = &#63; and entityResourceId = &#63; and status = &#63;.
	 *
	 * @param lovType the lov type
	 * @param recordTypeCode the record type code
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @return the number of matching lov datas
	 */
	public int countByDataTypeCodeAndLovCodeAndStatus(
		String lovType, String recordTypeCode, long entityResourceId,
		int status);

	/**
	 * Returns all the lov datas where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the matching lov datas
	 */
	public java.util.List<LovData> findByEntityResourceId(
		long entityResourceId);

	/**
	 * Returns a range of all the lov datas where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of lov datas
	 * @param end the upper bound of the range of lov datas (not inclusive)
	 * @return the range of matching lov datas
	 */
	public java.util.List<LovData> findByEntityResourceId(
		long entityResourceId, int start, int end);

	/**
	 * Returns an ordered range of all the lov datas where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of lov datas
	 * @param end the upper bound of the range of lov datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lov datas
	 */
	public java.util.List<LovData> findByEntityResourceId(
		long entityResourceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LovData>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lov datas where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of lov datas
	 * @param end the upper bound of the range of lov datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lov datas
	 */
	public java.util.List<LovData> findByEntityResourceId(
		long entityResourceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LovData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first lov data in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data
	 * @throws NoSuchLovDataException if a matching lov data could not be found
	 */
	public LovData findByEntityResourceId_First(
			long entityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<LovData>
				orderByComparator)
		throws NoSuchLovDataException;

	/**
	 * Returns the first lov data in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data, or <code>null</code> if a matching lov data could not be found
	 */
	public LovData fetchByEntityResourceId_First(
		long entityResourceId,
		com.liferay.portal.kernel.util.OrderByComparator<LovData>
			orderByComparator);

	/**
	 * Returns the last lov data in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data
	 * @throws NoSuchLovDataException if a matching lov data could not be found
	 */
	public LovData findByEntityResourceId_Last(
			long entityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<LovData>
				orderByComparator)
		throws NoSuchLovDataException;

	/**
	 * Returns the last lov data in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data, or <code>null</code> if a matching lov data could not be found
	 */
	public LovData fetchByEntityResourceId_Last(
		long entityResourceId,
		com.liferay.portal.kernel.util.OrderByComparator<LovData>
			orderByComparator);

	/**
	 * Returns the lov datas before and after the current lov data in the ordered set where entityResourceId = &#63;.
	 *
	 * @param id the primary key of the current lov data
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lov data
	 * @throws NoSuchLovDataException if a lov data with the primary key could not be found
	 */
	public LovData[] findByEntityResourceId_PrevAndNext(
			long id, long entityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<LovData>
				orderByComparator)
		throws NoSuchLovDataException;

	/**
	 * Removes all the lov datas where entityResourceId = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 */
	public void removeByEntityResourceId(long entityResourceId);

	/**
	 * Returns the number of lov datas where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the number of matching lov datas
	 */
	public int countByEntityResourceId(long entityResourceId);

	/**
	 * Caches the lov data in the entity cache if it is enabled.
	 *
	 * @param lovData the lov data
	 */
	public void cacheResult(LovData lovData);

	/**
	 * Caches the lov datas in the entity cache if it is enabled.
	 *
	 * @param lovDatas the lov datas
	 */
	public void cacheResult(java.util.List<LovData> lovDatas);

	/**
	 * Creates a new lov data with the primary key. Does not add the lov data to the database.
	 *
	 * @param id the primary key for the new lov data
	 * @return the new lov data
	 */
	public LovData create(long id);

	/**
	 * Removes the lov data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the lov data
	 * @return the lov data that was removed
	 * @throws NoSuchLovDataException if a lov data with the primary key could not be found
	 */
	public LovData remove(long id) throws NoSuchLovDataException;

	public LovData updateImpl(LovData lovData);

	/**
	 * Returns the lov data with the primary key or throws a <code>NoSuchLovDataException</code> if it could not be found.
	 *
	 * @param id the primary key of the lov data
	 * @return the lov data
	 * @throws NoSuchLovDataException if a lov data with the primary key could not be found
	 */
	public LovData findByPrimaryKey(long id) throws NoSuchLovDataException;

	/**
	 * Returns the lov data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the lov data
	 * @return the lov data, or <code>null</code> if a lov data with the primary key could not be found
	 */
	public LovData fetchByPrimaryKey(long id);

	/**
	 * Returns all the lov datas.
	 *
	 * @return the lov datas
	 */
	public java.util.List<LovData> findAll();

	/**
	 * Returns a range of all the lov datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lov datas
	 * @param end the upper bound of the range of lov datas (not inclusive)
	 * @return the range of lov datas
	 */
	public java.util.List<LovData> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the lov datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lov datas
	 * @param end the upper bound of the range of lov datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lov datas
	 */
	public java.util.List<LovData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LovData>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lov datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lov datas
	 * @param end the upper bound of the range of lov datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of lov datas
	 */
	public java.util.List<LovData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LovData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the lov datas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of lov datas.
	 *
	 * @return the number of lov datas
	 */
	public int countAll();

}