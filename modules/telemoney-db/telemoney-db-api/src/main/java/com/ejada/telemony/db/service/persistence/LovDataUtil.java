/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.model.LovData;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the lov data service. This utility wraps <code>com.ejada.telemony.db.service.persistence.impl.LovDataPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LovDataPersistence
 * @generated
 */
public class LovDataUtil {

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
	public static void clearCache(LovData lovData) {
		getPersistence().clearCache(lovData);
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
	public static Map<Serializable, LovData> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LovData> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LovData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LovData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LovData> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LovData update(LovData lovData) {
		return getPersistence().update(lovData);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LovData update(
		LovData lovData, ServiceContext serviceContext) {

		return getPersistence().update(lovData, serviceContext);
	}

	/**
	 * Returns all the lov datas where lovId = &#63;.
	 *
	 * @param lovId the lov ID
	 * @return the matching lov datas
	 */
	public static List<LovData> findByLovdata(long lovId) {
		return getPersistence().findByLovdata(lovId);
	}

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
	public static List<LovData> findByLovdata(long lovId, int start, int end) {
		return getPersistence().findByLovdata(lovId, start, end);
	}

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
	public static List<LovData> findByLovdata(
		long lovId, int start, int end,
		OrderByComparator<LovData> orderByComparator) {

		return getPersistence().findByLovdata(
			lovId, start, end, orderByComparator);
	}

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
	public static List<LovData> findByLovdata(
		long lovId, int start, int end,
		OrderByComparator<LovData> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByLovdata(
			lovId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first lov data in the ordered set where lovId = &#63;.
	 *
	 * @param lovId the lov ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data
	 * @throws NoSuchLovDataException if a matching lov data could not be found
	 */
	public static LovData findByLovdata_First(
			long lovId, OrderByComparator<LovData> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLovDataException {

		return getPersistence().findByLovdata_First(lovId, orderByComparator);
	}

	/**
	 * Returns the first lov data in the ordered set where lovId = &#63;.
	 *
	 * @param lovId the lov ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data, or <code>null</code> if a matching lov data could not be found
	 */
	public static LovData fetchByLovdata_First(
		long lovId, OrderByComparator<LovData> orderByComparator) {

		return getPersistence().fetchByLovdata_First(lovId, orderByComparator);
	}

	/**
	 * Returns the last lov data in the ordered set where lovId = &#63;.
	 *
	 * @param lovId the lov ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data
	 * @throws NoSuchLovDataException if a matching lov data could not be found
	 */
	public static LovData findByLovdata_Last(
			long lovId, OrderByComparator<LovData> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLovDataException {

		return getPersistence().findByLovdata_Last(lovId, orderByComparator);
	}

	/**
	 * Returns the last lov data in the ordered set where lovId = &#63;.
	 *
	 * @param lovId the lov ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data, or <code>null</code> if a matching lov data could not be found
	 */
	public static LovData fetchByLovdata_Last(
		long lovId, OrderByComparator<LovData> orderByComparator) {

		return getPersistence().fetchByLovdata_Last(lovId, orderByComparator);
	}

	/**
	 * Returns the lov datas before and after the current lov data in the ordered set where lovId = &#63;.
	 *
	 * @param id the primary key of the current lov data
	 * @param lovId the lov ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lov data
	 * @throws NoSuchLovDataException if a lov data with the primary key could not be found
	 */
	public static LovData[] findByLovdata_PrevAndNext(
			long id, long lovId, OrderByComparator<LovData> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLovDataException {

		return getPersistence().findByLovdata_PrevAndNext(
			id, lovId, orderByComparator);
	}

	/**
	 * Removes all the lov datas where lovId = &#63; from the database.
	 *
	 * @param lovId the lov ID
	 */
	public static void removeByLovdata(long lovId) {
		getPersistence().removeByLovdata(lovId);
	}

	/**
	 * Returns the number of lov datas where lovId = &#63;.
	 *
	 * @param lovId the lov ID
	 * @return the number of matching lov datas
	 */
	public static int countByLovdata(long lovId) {
		return getPersistence().countByLovdata(lovId);
	}

	/**
	 * Returns all the lov datas where lovId = &#63; and recordShortDescription = &#63;.
	 *
	 * @param lovId the lov ID
	 * @param recordShortDescription the record short description
	 * @return the matching lov datas
	 */
	public static List<LovData> findBylovIdAndRecordShortDescription(
		long lovId, String recordShortDescription) {

		return getPersistence().findBylovIdAndRecordShortDescription(
			lovId, recordShortDescription);
	}

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
	public static List<LovData> findBylovIdAndRecordShortDescription(
		long lovId, String recordShortDescription, int start, int end) {

		return getPersistence().findBylovIdAndRecordShortDescription(
			lovId, recordShortDescription, start, end);
	}

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
	public static List<LovData> findBylovIdAndRecordShortDescription(
		long lovId, String recordShortDescription, int start, int end,
		OrderByComparator<LovData> orderByComparator) {

		return getPersistence().findBylovIdAndRecordShortDescription(
			lovId, recordShortDescription, start, end, orderByComparator);
	}

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
	public static List<LovData> findBylovIdAndRecordShortDescription(
		long lovId, String recordShortDescription, int start, int end,
		OrderByComparator<LovData> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBylovIdAndRecordShortDescription(
			lovId, recordShortDescription, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first lov data in the ordered set where lovId = &#63; and recordShortDescription = &#63;.
	 *
	 * @param lovId the lov ID
	 * @param recordShortDescription the record short description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data
	 * @throws NoSuchLovDataException if a matching lov data could not be found
	 */
	public static LovData findBylovIdAndRecordShortDescription_First(
			long lovId, String recordShortDescription,
			OrderByComparator<LovData> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLovDataException {

		return getPersistence().findBylovIdAndRecordShortDescription_First(
			lovId, recordShortDescription, orderByComparator);
	}

	/**
	 * Returns the first lov data in the ordered set where lovId = &#63; and recordShortDescription = &#63;.
	 *
	 * @param lovId the lov ID
	 * @param recordShortDescription the record short description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data, or <code>null</code> if a matching lov data could not be found
	 */
	public static LovData fetchBylovIdAndRecordShortDescription_First(
		long lovId, String recordShortDescription,
		OrderByComparator<LovData> orderByComparator) {

		return getPersistence().fetchBylovIdAndRecordShortDescription_First(
			lovId, recordShortDescription, orderByComparator);
	}

	/**
	 * Returns the last lov data in the ordered set where lovId = &#63; and recordShortDescription = &#63;.
	 *
	 * @param lovId the lov ID
	 * @param recordShortDescription the record short description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data
	 * @throws NoSuchLovDataException if a matching lov data could not be found
	 */
	public static LovData findBylovIdAndRecordShortDescription_Last(
			long lovId, String recordShortDescription,
			OrderByComparator<LovData> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLovDataException {

		return getPersistence().findBylovIdAndRecordShortDescription_Last(
			lovId, recordShortDescription, orderByComparator);
	}

	/**
	 * Returns the last lov data in the ordered set where lovId = &#63; and recordShortDescription = &#63;.
	 *
	 * @param lovId the lov ID
	 * @param recordShortDescription the record short description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data, or <code>null</code> if a matching lov data could not be found
	 */
	public static LovData fetchBylovIdAndRecordShortDescription_Last(
		long lovId, String recordShortDescription,
		OrderByComparator<LovData> orderByComparator) {

		return getPersistence().fetchBylovIdAndRecordShortDescription_Last(
			lovId, recordShortDescription, orderByComparator);
	}

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
	public static LovData[] findBylovIdAndRecordShortDescription_PrevAndNext(
			long id, long lovId, String recordShortDescription,
			OrderByComparator<LovData> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLovDataException {

		return getPersistence().
			findBylovIdAndRecordShortDescription_PrevAndNext(
				id, lovId, recordShortDescription, orderByComparator);
	}

	/**
	 * Removes all the lov datas where lovId = &#63; and recordShortDescription = &#63; from the database.
	 *
	 * @param lovId the lov ID
	 * @param recordShortDescription the record short description
	 */
	public static void removeBylovIdAndRecordShortDescription(
		long lovId, String recordShortDescription) {

		getPersistence().removeBylovIdAndRecordShortDescription(
			lovId, recordShortDescription);
	}

	/**
	 * Returns the number of lov datas where lovId = &#63; and recordShortDescription = &#63;.
	 *
	 * @param lovId the lov ID
	 * @param recordShortDescription the record short description
	 * @return the number of matching lov datas
	 */
	public static int countBylovIdAndRecordShortDescription(
		long lovId, String recordShortDescription) {

		return getPersistence().countBylovIdAndRecordShortDescription(
			lovId, recordShortDescription);
	}

	/**
	 * Returns all the lov datas where lovType = &#63; and recordTypeCode = &#63; and entityResourceId = &#63; and status = &#63;.
	 *
	 * @param lovType the lov type
	 * @param recordTypeCode the record type code
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @return the matching lov datas
	 */
	public static List<LovData> findByDataTypeCodeAndLovCodeAndStatus(
		String lovType, String recordTypeCode, long entityResourceId,
		int status) {

		return getPersistence().findByDataTypeCodeAndLovCodeAndStatus(
			lovType, recordTypeCode, entityResourceId, status);
	}

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
	public static List<LovData> findByDataTypeCodeAndLovCodeAndStatus(
		String lovType, String recordTypeCode, long entityResourceId,
		int status, int start, int end) {

		return getPersistence().findByDataTypeCodeAndLovCodeAndStatus(
			lovType, recordTypeCode, entityResourceId, status, start, end);
	}

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
	public static List<LovData> findByDataTypeCodeAndLovCodeAndStatus(
		String lovType, String recordTypeCode, long entityResourceId,
		int status, int start, int end,
		OrderByComparator<LovData> orderByComparator) {

		return getPersistence().findByDataTypeCodeAndLovCodeAndStatus(
			lovType, recordTypeCode, entityResourceId, status, start, end,
			orderByComparator);
	}

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
	public static List<LovData> findByDataTypeCodeAndLovCodeAndStatus(
		String lovType, String recordTypeCode, long entityResourceId,
		int status, int start, int end,
		OrderByComparator<LovData> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByDataTypeCodeAndLovCodeAndStatus(
			lovType, recordTypeCode, entityResourceId, status, start, end,
			orderByComparator, useFinderCache);
	}

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
	public static LovData findByDataTypeCodeAndLovCodeAndStatus_First(
			String lovType, String recordTypeCode, long entityResourceId,
			int status, OrderByComparator<LovData> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLovDataException {

		return getPersistence().findByDataTypeCodeAndLovCodeAndStatus_First(
			lovType, recordTypeCode, entityResourceId, status,
			orderByComparator);
	}

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
	public static LovData fetchByDataTypeCodeAndLovCodeAndStatus_First(
		String lovType, String recordTypeCode, long entityResourceId,
		int status, OrderByComparator<LovData> orderByComparator) {

		return getPersistence().fetchByDataTypeCodeAndLovCodeAndStatus_First(
			lovType, recordTypeCode, entityResourceId, status,
			orderByComparator);
	}

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
	public static LovData findByDataTypeCodeAndLovCodeAndStatus_Last(
			String lovType, String recordTypeCode, long entityResourceId,
			int status, OrderByComparator<LovData> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLovDataException {

		return getPersistence().findByDataTypeCodeAndLovCodeAndStatus_Last(
			lovType, recordTypeCode, entityResourceId, status,
			orderByComparator);
	}

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
	public static LovData fetchByDataTypeCodeAndLovCodeAndStatus_Last(
		String lovType, String recordTypeCode, long entityResourceId,
		int status, OrderByComparator<LovData> orderByComparator) {

		return getPersistence().fetchByDataTypeCodeAndLovCodeAndStatus_Last(
			lovType, recordTypeCode, entityResourceId, status,
			orderByComparator);
	}

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
	public static LovData[] findByDataTypeCodeAndLovCodeAndStatus_PrevAndNext(
			long id, String lovType, String recordTypeCode,
			long entityResourceId, int status,
			OrderByComparator<LovData> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLovDataException {

		return getPersistence().
			findByDataTypeCodeAndLovCodeAndStatus_PrevAndNext(
				id, lovType, recordTypeCode, entityResourceId, status,
				orderByComparator);
	}

	/**
	 * Removes all the lov datas where lovType = &#63; and recordTypeCode = &#63; and entityResourceId = &#63; and status = &#63; from the database.
	 *
	 * @param lovType the lov type
	 * @param recordTypeCode the record type code
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 */
	public static void removeByDataTypeCodeAndLovCodeAndStatus(
		String lovType, String recordTypeCode, long entityResourceId,
		int status) {

		getPersistence().removeByDataTypeCodeAndLovCodeAndStatus(
			lovType, recordTypeCode, entityResourceId, status);
	}

	/**
	 * Returns the number of lov datas where lovType = &#63; and recordTypeCode = &#63; and entityResourceId = &#63; and status = &#63;.
	 *
	 * @param lovType the lov type
	 * @param recordTypeCode the record type code
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @return the number of matching lov datas
	 */
	public static int countByDataTypeCodeAndLovCodeAndStatus(
		String lovType, String recordTypeCode, long entityResourceId,
		int status) {

		return getPersistence().countByDataTypeCodeAndLovCodeAndStatus(
			lovType, recordTypeCode, entityResourceId, status);
	}

	/**
	 * Returns all the lov datas where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the matching lov datas
	 */
	public static List<LovData> findByEntityResourceId(long entityResourceId) {
		return getPersistence().findByEntityResourceId(entityResourceId);
	}

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
	public static List<LovData> findByEntityResourceId(
		long entityResourceId, int start, int end) {

		return getPersistence().findByEntityResourceId(
			entityResourceId, start, end);
	}

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
	public static List<LovData> findByEntityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<LovData> orderByComparator) {

		return getPersistence().findByEntityResourceId(
			entityResourceId, start, end, orderByComparator);
	}

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
	public static List<LovData> findByEntityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<LovData> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByEntityResourceId(
			entityResourceId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first lov data in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data
	 * @throws NoSuchLovDataException if a matching lov data could not be found
	 */
	public static LovData findByEntityResourceId_First(
			long entityResourceId, OrderByComparator<LovData> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLovDataException {

		return getPersistence().findByEntityResourceId_First(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the first lov data in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data, or <code>null</code> if a matching lov data could not be found
	 */
	public static LovData fetchByEntityResourceId_First(
		long entityResourceId, OrderByComparator<LovData> orderByComparator) {

		return getPersistence().fetchByEntityResourceId_First(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the last lov data in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data
	 * @throws NoSuchLovDataException if a matching lov data could not be found
	 */
	public static LovData findByEntityResourceId_Last(
			long entityResourceId, OrderByComparator<LovData> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLovDataException {

		return getPersistence().findByEntityResourceId_Last(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the last lov data in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data, or <code>null</code> if a matching lov data could not be found
	 */
	public static LovData fetchByEntityResourceId_Last(
		long entityResourceId, OrderByComparator<LovData> orderByComparator) {

		return getPersistence().fetchByEntityResourceId_Last(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the lov datas before and after the current lov data in the ordered set where entityResourceId = &#63;.
	 *
	 * @param id the primary key of the current lov data
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lov data
	 * @throws NoSuchLovDataException if a lov data with the primary key could not be found
	 */
	public static LovData[] findByEntityResourceId_PrevAndNext(
			long id, long entityResourceId,
			OrderByComparator<LovData> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLovDataException {

		return getPersistence().findByEntityResourceId_PrevAndNext(
			id, entityResourceId, orderByComparator);
	}

	/**
	 * Removes all the lov datas where entityResourceId = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 */
	public static void removeByEntityResourceId(long entityResourceId) {
		getPersistence().removeByEntityResourceId(entityResourceId);
	}

	/**
	 * Returns the number of lov datas where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the number of matching lov datas
	 */
	public static int countByEntityResourceId(long entityResourceId) {
		return getPersistence().countByEntityResourceId(entityResourceId);
	}

	/**
	 * Caches the lov data in the entity cache if it is enabled.
	 *
	 * @param lovData the lov data
	 */
	public static void cacheResult(LovData lovData) {
		getPersistence().cacheResult(lovData);
	}

	/**
	 * Caches the lov datas in the entity cache if it is enabled.
	 *
	 * @param lovDatas the lov datas
	 */
	public static void cacheResult(List<LovData> lovDatas) {
		getPersistence().cacheResult(lovDatas);
	}

	/**
	 * Creates a new lov data with the primary key. Does not add the lov data to the database.
	 *
	 * @param id the primary key for the new lov data
	 * @return the new lov data
	 */
	public static LovData create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the lov data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the lov data
	 * @return the lov data that was removed
	 * @throws NoSuchLovDataException if a lov data with the primary key could not be found
	 */
	public static LovData remove(long id)
		throws com.ejada.telemony.db.exception.NoSuchLovDataException {

		return getPersistence().remove(id);
	}

	public static LovData updateImpl(LovData lovData) {
		return getPersistence().updateImpl(lovData);
	}

	/**
	 * Returns the lov data with the primary key or throws a <code>NoSuchLovDataException</code> if it could not be found.
	 *
	 * @param id the primary key of the lov data
	 * @return the lov data
	 * @throws NoSuchLovDataException if a lov data with the primary key could not be found
	 */
	public static LovData findByPrimaryKey(long id)
		throws com.ejada.telemony.db.exception.NoSuchLovDataException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the lov data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the lov data
	 * @return the lov data, or <code>null</code> if a lov data with the primary key could not be found
	 */
	public static LovData fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the lov datas.
	 *
	 * @return the lov datas
	 */
	public static List<LovData> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<LovData> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<LovData> findAll(
		int start, int end, OrderByComparator<LovData> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<LovData> findAll(
		int start, int end, OrderByComparator<LovData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the lov datas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of lov datas.
	 *
	 * @return the number of lov datas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LovDataPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(LovDataPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile LovDataPersistence _persistence;

}