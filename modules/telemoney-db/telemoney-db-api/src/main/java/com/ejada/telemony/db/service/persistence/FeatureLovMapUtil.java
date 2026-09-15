/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.model.FeatureLovMap;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the feature lov map service. This utility wraps <code>com.ejada.telemony.db.service.persistence.impl.FeatureLovMapPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FeatureLovMapPersistence
 * @generated
 */
public class FeatureLovMapUtil {

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
	public static void clearCache(FeatureLovMap featureLovMap) {
		getPersistence().clearCache(featureLovMap);
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
	public static Map<Serializable, FeatureLovMap> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FeatureLovMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FeatureLovMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FeatureLovMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FeatureLovMap> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FeatureLovMap update(FeatureLovMap featureLovMap) {
		return getPersistence().update(featureLovMap);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FeatureLovMap update(
		FeatureLovMap featureLovMap, ServiceContext serviceContext) {

		return getPersistence().update(featureLovMap, serviceContext);
	}

	/**
	 * Returns all the feature lov maps where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @return the matching feature lov maps
	 */
	public static List<FeatureLovMap> findByFeatureId(long featureId) {
		return getPersistence().findByFeatureId(featureId);
	}

	/**
	 * Returns a range of all the feature lov maps where featureId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureLovMapModelImpl</code>.
	 * </p>
	 *
	 * @param featureId the feature ID
	 * @param start the lower bound of the range of feature lov maps
	 * @param end the upper bound of the range of feature lov maps (not inclusive)
	 * @return the range of matching feature lov maps
	 */
	public static List<FeatureLovMap> findByFeatureId(
		long featureId, int start, int end) {

		return getPersistence().findByFeatureId(featureId, start, end);
	}

	/**
	 * Returns an ordered range of all the feature lov maps where featureId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureLovMapModelImpl</code>.
	 * </p>
	 *
	 * @param featureId the feature ID
	 * @param start the lower bound of the range of feature lov maps
	 * @param end the upper bound of the range of feature lov maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching feature lov maps
	 */
	public static List<FeatureLovMap> findByFeatureId(
		long featureId, int start, int end,
		OrderByComparator<FeatureLovMap> orderByComparator) {

		return getPersistence().findByFeatureId(
			featureId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the feature lov maps where featureId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureLovMapModelImpl</code>.
	 * </p>
	 *
	 * @param featureId the feature ID
	 * @param start the lower bound of the range of feature lov maps
	 * @param end the upper bound of the range of feature lov maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching feature lov maps
	 */
	public static List<FeatureLovMap> findByFeatureId(
		long featureId, int start, int end,
		OrderByComparator<FeatureLovMap> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFeatureId(
			featureId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first feature lov map in the ordered set where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature lov map
	 * @throws NoSuchFeatureLovMapException if a matching feature lov map could not be found
	 */
	public static FeatureLovMap findByFeatureId_First(
			long featureId, OrderByComparator<FeatureLovMap> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchFeatureLovMapException {

		return getPersistence().findByFeatureId_First(
			featureId, orderByComparator);
	}

	/**
	 * Returns the first feature lov map in the ordered set where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature lov map, or <code>null</code> if a matching feature lov map could not be found
	 */
	public static FeatureLovMap fetchByFeatureId_First(
		long featureId, OrderByComparator<FeatureLovMap> orderByComparator) {

		return getPersistence().fetchByFeatureId_First(
			featureId, orderByComparator);
	}

	/**
	 * Returns the last feature lov map in the ordered set where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature lov map
	 * @throws NoSuchFeatureLovMapException if a matching feature lov map could not be found
	 */
	public static FeatureLovMap findByFeatureId_Last(
			long featureId, OrderByComparator<FeatureLovMap> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchFeatureLovMapException {

		return getPersistence().findByFeatureId_Last(
			featureId, orderByComparator);
	}

	/**
	 * Returns the last feature lov map in the ordered set where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature lov map, or <code>null</code> if a matching feature lov map could not be found
	 */
	public static FeatureLovMap fetchByFeatureId_Last(
		long featureId, OrderByComparator<FeatureLovMap> orderByComparator) {

		return getPersistence().fetchByFeatureId_Last(
			featureId, orderByComparator);
	}

	/**
	 * Returns the feature lov maps before and after the current feature lov map in the ordered set where featureId = &#63;.
	 *
	 * @param id the primary key of the current feature lov map
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next feature lov map
	 * @throws NoSuchFeatureLovMapException if a feature lov map with the primary key could not be found
	 */
	public static FeatureLovMap[] findByFeatureId_PrevAndNext(
			long id, long featureId,
			OrderByComparator<FeatureLovMap> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchFeatureLovMapException {

		return getPersistence().findByFeatureId_PrevAndNext(
			id, featureId, orderByComparator);
	}

	/**
	 * Removes all the feature lov maps where featureId = &#63; from the database.
	 *
	 * @param featureId the feature ID
	 */
	public static void removeByFeatureId(long featureId) {
		getPersistence().removeByFeatureId(featureId);
	}

	/**
	 * Returns the number of feature lov maps where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @return the number of matching feature lov maps
	 */
	public static int countByFeatureId(long featureId) {
		return getPersistence().countByFeatureId(featureId);
	}

	/**
	 * Returns all the feature lov maps where featureEntityResourceId = &#63;.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @return the matching feature lov maps
	 */
	public static List<FeatureLovMap> findByFeatureEntityResourceId(
		long featureEntityResourceId) {

		return getPersistence().findByFeatureEntityResourceId(
			featureEntityResourceId);
	}

	/**
	 * Returns a range of all the feature lov maps where featureEntityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureLovMapModelImpl</code>.
	 * </p>
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param start the lower bound of the range of feature lov maps
	 * @param end the upper bound of the range of feature lov maps (not inclusive)
	 * @return the range of matching feature lov maps
	 */
	public static List<FeatureLovMap> findByFeatureEntityResourceId(
		long featureEntityResourceId, int start, int end) {

		return getPersistence().findByFeatureEntityResourceId(
			featureEntityResourceId, start, end);
	}

	/**
	 * Returns an ordered range of all the feature lov maps where featureEntityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureLovMapModelImpl</code>.
	 * </p>
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param start the lower bound of the range of feature lov maps
	 * @param end the upper bound of the range of feature lov maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching feature lov maps
	 */
	public static List<FeatureLovMap> findByFeatureEntityResourceId(
		long featureEntityResourceId, int start, int end,
		OrderByComparator<FeatureLovMap> orderByComparator) {

		return getPersistence().findByFeatureEntityResourceId(
			featureEntityResourceId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the feature lov maps where featureEntityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureLovMapModelImpl</code>.
	 * </p>
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param start the lower bound of the range of feature lov maps
	 * @param end the upper bound of the range of feature lov maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching feature lov maps
	 */
	public static List<FeatureLovMap> findByFeatureEntityResourceId(
		long featureEntityResourceId, int start, int end,
		OrderByComparator<FeatureLovMap> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFeatureEntityResourceId(
			featureEntityResourceId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first feature lov map in the ordered set where featureEntityResourceId = &#63;.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature lov map
	 * @throws NoSuchFeatureLovMapException if a matching feature lov map could not be found
	 */
	public static FeatureLovMap findByFeatureEntityResourceId_First(
			long featureEntityResourceId,
			OrderByComparator<FeatureLovMap> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchFeatureLovMapException {

		return getPersistence().findByFeatureEntityResourceId_First(
			featureEntityResourceId, orderByComparator);
	}

	/**
	 * Returns the first feature lov map in the ordered set where featureEntityResourceId = &#63;.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature lov map, or <code>null</code> if a matching feature lov map could not be found
	 */
	public static FeatureLovMap fetchByFeatureEntityResourceId_First(
		long featureEntityResourceId,
		OrderByComparator<FeatureLovMap> orderByComparator) {

		return getPersistence().fetchByFeatureEntityResourceId_First(
			featureEntityResourceId, orderByComparator);
	}

	/**
	 * Returns the last feature lov map in the ordered set where featureEntityResourceId = &#63;.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature lov map
	 * @throws NoSuchFeatureLovMapException if a matching feature lov map could not be found
	 */
	public static FeatureLovMap findByFeatureEntityResourceId_Last(
			long featureEntityResourceId,
			OrderByComparator<FeatureLovMap> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchFeatureLovMapException {

		return getPersistence().findByFeatureEntityResourceId_Last(
			featureEntityResourceId, orderByComparator);
	}

	/**
	 * Returns the last feature lov map in the ordered set where featureEntityResourceId = &#63;.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature lov map, or <code>null</code> if a matching feature lov map could not be found
	 */
	public static FeatureLovMap fetchByFeatureEntityResourceId_Last(
		long featureEntityResourceId,
		OrderByComparator<FeatureLovMap> orderByComparator) {

		return getPersistence().fetchByFeatureEntityResourceId_Last(
			featureEntityResourceId, orderByComparator);
	}

	/**
	 * Returns the feature lov maps before and after the current feature lov map in the ordered set where featureEntityResourceId = &#63;.
	 *
	 * @param id the primary key of the current feature lov map
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next feature lov map
	 * @throws NoSuchFeatureLovMapException if a feature lov map with the primary key could not be found
	 */
	public static FeatureLovMap[] findByFeatureEntityResourceId_PrevAndNext(
			long id, long featureEntityResourceId,
			OrderByComparator<FeatureLovMap> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchFeatureLovMapException {

		return getPersistence().findByFeatureEntityResourceId_PrevAndNext(
			id, featureEntityResourceId, orderByComparator);
	}

	/**
	 * Removes all the feature lov maps where featureEntityResourceId = &#63; from the database.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 */
	public static void removeByFeatureEntityResourceId(
		long featureEntityResourceId) {

		getPersistence().removeByFeatureEntityResourceId(
			featureEntityResourceId);
	}

	/**
	 * Returns the number of feature lov maps where featureEntityResourceId = &#63;.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @return the number of matching feature lov maps
	 */
	public static int countByFeatureEntityResourceId(
		long featureEntityResourceId) {

		return getPersistence().countByFeatureEntityResourceId(
			featureEntityResourceId);
	}

	/**
	 * Returns all the feature lov maps where featureId = &#63; and lovType = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param lovType the lov type
	 * @return the matching feature lov maps
	 */
	public static List<FeatureLovMap> findByFeatureIdAndLovType(
		long featureId, String lovType) {

		return getPersistence().findByFeatureIdAndLovType(featureId, lovType);
	}

	/**
	 * Returns a range of all the feature lov maps where featureId = &#63; and lovType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureLovMapModelImpl</code>.
	 * </p>
	 *
	 * @param featureId the feature ID
	 * @param lovType the lov type
	 * @param start the lower bound of the range of feature lov maps
	 * @param end the upper bound of the range of feature lov maps (not inclusive)
	 * @return the range of matching feature lov maps
	 */
	public static List<FeatureLovMap> findByFeatureIdAndLovType(
		long featureId, String lovType, int start, int end) {

		return getPersistence().findByFeatureIdAndLovType(
			featureId, lovType, start, end);
	}

	/**
	 * Returns an ordered range of all the feature lov maps where featureId = &#63; and lovType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureLovMapModelImpl</code>.
	 * </p>
	 *
	 * @param featureId the feature ID
	 * @param lovType the lov type
	 * @param start the lower bound of the range of feature lov maps
	 * @param end the upper bound of the range of feature lov maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching feature lov maps
	 */
	public static List<FeatureLovMap> findByFeatureIdAndLovType(
		long featureId, String lovType, int start, int end,
		OrderByComparator<FeatureLovMap> orderByComparator) {

		return getPersistence().findByFeatureIdAndLovType(
			featureId, lovType, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the feature lov maps where featureId = &#63; and lovType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureLovMapModelImpl</code>.
	 * </p>
	 *
	 * @param featureId the feature ID
	 * @param lovType the lov type
	 * @param start the lower bound of the range of feature lov maps
	 * @param end the upper bound of the range of feature lov maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching feature lov maps
	 */
	public static List<FeatureLovMap> findByFeatureIdAndLovType(
		long featureId, String lovType, int start, int end,
		OrderByComparator<FeatureLovMap> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFeatureIdAndLovType(
			featureId, lovType, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first feature lov map in the ordered set where featureId = &#63; and lovType = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param lovType the lov type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature lov map
	 * @throws NoSuchFeatureLovMapException if a matching feature lov map could not be found
	 */
	public static FeatureLovMap findByFeatureIdAndLovType_First(
			long featureId, String lovType,
			OrderByComparator<FeatureLovMap> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchFeatureLovMapException {

		return getPersistence().findByFeatureIdAndLovType_First(
			featureId, lovType, orderByComparator);
	}

	/**
	 * Returns the first feature lov map in the ordered set where featureId = &#63; and lovType = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param lovType the lov type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature lov map, or <code>null</code> if a matching feature lov map could not be found
	 */
	public static FeatureLovMap fetchByFeatureIdAndLovType_First(
		long featureId, String lovType,
		OrderByComparator<FeatureLovMap> orderByComparator) {

		return getPersistence().fetchByFeatureIdAndLovType_First(
			featureId, lovType, orderByComparator);
	}

	/**
	 * Returns the last feature lov map in the ordered set where featureId = &#63; and lovType = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param lovType the lov type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature lov map
	 * @throws NoSuchFeatureLovMapException if a matching feature lov map could not be found
	 */
	public static FeatureLovMap findByFeatureIdAndLovType_Last(
			long featureId, String lovType,
			OrderByComparator<FeatureLovMap> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchFeatureLovMapException {

		return getPersistence().findByFeatureIdAndLovType_Last(
			featureId, lovType, orderByComparator);
	}

	/**
	 * Returns the last feature lov map in the ordered set where featureId = &#63; and lovType = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param lovType the lov type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature lov map, or <code>null</code> if a matching feature lov map could not be found
	 */
	public static FeatureLovMap fetchByFeatureIdAndLovType_Last(
		long featureId, String lovType,
		OrderByComparator<FeatureLovMap> orderByComparator) {

		return getPersistence().fetchByFeatureIdAndLovType_Last(
			featureId, lovType, orderByComparator);
	}

	/**
	 * Returns the feature lov maps before and after the current feature lov map in the ordered set where featureId = &#63; and lovType = &#63;.
	 *
	 * @param id the primary key of the current feature lov map
	 * @param featureId the feature ID
	 * @param lovType the lov type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next feature lov map
	 * @throws NoSuchFeatureLovMapException if a feature lov map with the primary key could not be found
	 */
	public static FeatureLovMap[] findByFeatureIdAndLovType_PrevAndNext(
			long id, long featureId, String lovType,
			OrderByComparator<FeatureLovMap> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchFeatureLovMapException {

		return getPersistence().findByFeatureIdAndLovType_PrevAndNext(
			id, featureId, lovType, orderByComparator);
	}

	/**
	 * Removes all the feature lov maps where featureId = &#63; and lovType = &#63; from the database.
	 *
	 * @param featureId the feature ID
	 * @param lovType the lov type
	 */
	public static void removeByFeatureIdAndLovType(
		long featureId, String lovType) {

		getPersistence().removeByFeatureIdAndLovType(featureId, lovType);
	}

	/**
	 * Returns the number of feature lov maps where featureId = &#63; and lovType = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param lovType the lov type
	 * @return the number of matching feature lov maps
	 */
	public static int countByFeatureIdAndLovType(
		long featureId, String lovType) {

		return getPersistence().countByFeatureIdAndLovType(featureId, lovType);
	}

	/**
	 * Returns all the feature lov maps where featureEntityResourceId = &#63; and lovType = &#63;.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param lovType the lov type
	 * @return the matching feature lov maps
	 */
	public static List<FeatureLovMap> findByFeatureEntityResourceIdAndLovType(
		long featureEntityResourceId, String lovType) {

		return getPersistence().findByFeatureEntityResourceIdAndLovType(
			featureEntityResourceId, lovType);
	}

	/**
	 * Returns a range of all the feature lov maps where featureEntityResourceId = &#63; and lovType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureLovMapModelImpl</code>.
	 * </p>
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param lovType the lov type
	 * @param start the lower bound of the range of feature lov maps
	 * @param end the upper bound of the range of feature lov maps (not inclusive)
	 * @return the range of matching feature lov maps
	 */
	public static List<FeatureLovMap> findByFeatureEntityResourceIdAndLovType(
		long featureEntityResourceId, String lovType, int start, int end) {

		return getPersistence().findByFeatureEntityResourceIdAndLovType(
			featureEntityResourceId, lovType, start, end);
	}

	/**
	 * Returns an ordered range of all the feature lov maps where featureEntityResourceId = &#63; and lovType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureLovMapModelImpl</code>.
	 * </p>
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param lovType the lov type
	 * @param start the lower bound of the range of feature lov maps
	 * @param end the upper bound of the range of feature lov maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching feature lov maps
	 */
	public static List<FeatureLovMap> findByFeatureEntityResourceIdAndLovType(
		long featureEntityResourceId, String lovType, int start, int end,
		OrderByComparator<FeatureLovMap> orderByComparator) {

		return getPersistence().findByFeatureEntityResourceIdAndLovType(
			featureEntityResourceId, lovType, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the feature lov maps where featureEntityResourceId = &#63; and lovType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureLovMapModelImpl</code>.
	 * </p>
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param lovType the lov type
	 * @param start the lower bound of the range of feature lov maps
	 * @param end the upper bound of the range of feature lov maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching feature lov maps
	 */
	public static List<FeatureLovMap> findByFeatureEntityResourceIdAndLovType(
		long featureEntityResourceId, String lovType, int start, int end,
		OrderByComparator<FeatureLovMap> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFeatureEntityResourceIdAndLovType(
			featureEntityResourceId, lovType, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first feature lov map in the ordered set where featureEntityResourceId = &#63; and lovType = &#63;.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param lovType the lov type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature lov map
	 * @throws NoSuchFeatureLovMapException if a matching feature lov map could not be found
	 */
	public static FeatureLovMap findByFeatureEntityResourceIdAndLovType_First(
			long featureEntityResourceId, String lovType,
			OrderByComparator<FeatureLovMap> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchFeatureLovMapException {

		return getPersistence().findByFeatureEntityResourceIdAndLovType_First(
			featureEntityResourceId, lovType, orderByComparator);
	}

	/**
	 * Returns the first feature lov map in the ordered set where featureEntityResourceId = &#63; and lovType = &#63;.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param lovType the lov type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature lov map, or <code>null</code> if a matching feature lov map could not be found
	 */
	public static FeatureLovMap fetchByFeatureEntityResourceIdAndLovType_First(
		long featureEntityResourceId, String lovType,
		OrderByComparator<FeatureLovMap> orderByComparator) {

		return getPersistence().fetchByFeatureEntityResourceIdAndLovType_First(
			featureEntityResourceId, lovType, orderByComparator);
	}

	/**
	 * Returns the last feature lov map in the ordered set where featureEntityResourceId = &#63; and lovType = &#63;.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param lovType the lov type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature lov map
	 * @throws NoSuchFeatureLovMapException if a matching feature lov map could not be found
	 */
	public static FeatureLovMap findByFeatureEntityResourceIdAndLovType_Last(
			long featureEntityResourceId, String lovType,
			OrderByComparator<FeatureLovMap> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchFeatureLovMapException {

		return getPersistence().findByFeatureEntityResourceIdAndLovType_Last(
			featureEntityResourceId, lovType, orderByComparator);
	}

	/**
	 * Returns the last feature lov map in the ordered set where featureEntityResourceId = &#63; and lovType = &#63;.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param lovType the lov type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature lov map, or <code>null</code> if a matching feature lov map could not be found
	 */
	public static FeatureLovMap fetchByFeatureEntityResourceIdAndLovType_Last(
		long featureEntityResourceId, String lovType,
		OrderByComparator<FeatureLovMap> orderByComparator) {

		return getPersistence().fetchByFeatureEntityResourceIdAndLovType_Last(
			featureEntityResourceId, lovType, orderByComparator);
	}

	/**
	 * Returns the feature lov maps before and after the current feature lov map in the ordered set where featureEntityResourceId = &#63; and lovType = &#63;.
	 *
	 * @param id the primary key of the current feature lov map
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param lovType the lov type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next feature lov map
	 * @throws NoSuchFeatureLovMapException if a feature lov map with the primary key could not be found
	 */
	public static FeatureLovMap[]
			findByFeatureEntityResourceIdAndLovType_PrevAndNext(
				long id, long featureEntityResourceId, String lovType,
				OrderByComparator<FeatureLovMap> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchFeatureLovMapException {

		return getPersistence().
			findByFeatureEntityResourceIdAndLovType_PrevAndNext(
				id, featureEntityResourceId, lovType, orderByComparator);
	}

	/**
	 * Removes all the feature lov maps where featureEntityResourceId = &#63; and lovType = &#63; from the database.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param lovType the lov type
	 */
	public static void removeByFeatureEntityResourceIdAndLovType(
		long featureEntityResourceId, String lovType) {

		getPersistence().removeByFeatureEntityResourceIdAndLovType(
			featureEntityResourceId, lovType);
	}

	/**
	 * Returns the number of feature lov maps where featureEntityResourceId = &#63; and lovType = &#63;.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param lovType the lov type
	 * @return the number of matching feature lov maps
	 */
	public static int countByFeatureEntityResourceIdAndLovType(
		long featureEntityResourceId, String lovType) {

		return getPersistence().countByFeatureEntityResourceIdAndLovType(
			featureEntityResourceId, lovType);
	}

	/**
	 * Returns all the feature lov maps where lovEntityResourceId = &#63; and lovDataCode = &#63;.
	 *
	 * @param lovEntityResourceId the lov entity resource ID
	 * @param lovDataCode the lov data code
	 * @return the matching feature lov maps
	 */
	public static List<FeatureLovMap> findByLovEntityResourceIdAndLovDataCode(
		long lovEntityResourceId, String lovDataCode) {

		return getPersistence().findByLovEntityResourceIdAndLovDataCode(
			lovEntityResourceId, lovDataCode);
	}

	/**
	 * Returns a range of all the feature lov maps where lovEntityResourceId = &#63; and lovDataCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureLovMapModelImpl</code>.
	 * </p>
	 *
	 * @param lovEntityResourceId the lov entity resource ID
	 * @param lovDataCode the lov data code
	 * @param start the lower bound of the range of feature lov maps
	 * @param end the upper bound of the range of feature lov maps (not inclusive)
	 * @return the range of matching feature lov maps
	 */
	public static List<FeatureLovMap> findByLovEntityResourceIdAndLovDataCode(
		long lovEntityResourceId, String lovDataCode, int start, int end) {

		return getPersistence().findByLovEntityResourceIdAndLovDataCode(
			lovEntityResourceId, lovDataCode, start, end);
	}

	/**
	 * Returns an ordered range of all the feature lov maps where lovEntityResourceId = &#63; and lovDataCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureLovMapModelImpl</code>.
	 * </p>
	 *
	 * @param lovEntityResourceId the lov entity resource ID
	 * @param lovDataCode the lov data code
	 * @param start the lower bound of the range of feature lov maps
	 * @param end the upper bound of the range of feature lov maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching feature lov maps
	 */
	public static List<FeatureLovMap> findByLovEntityResourceIdAndLovDataCode(
		long lovEntityResourceId, String lovDataCode, int start, int end,
		OrderByComparator<FeatureLovMap> orderByComparator) {

		return getPersistence().findByLovEntityResourceIdAndLovDataCode(
			lovEntityResourceId, lovDataCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the feature lov maps where lovEntityResourceId = &#63; and lovDataCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureLovMapModelImpl</code>.
	 * </p>
	 *
	 * @param lovEntityResourceId the lov entity resource ID
	 * @param lovDataCode the lov data code
	 * @param start the lower bound of the range of feature lov maps
	 * @param end the upper bound of the range of feature lov maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching feature lov maps
	 */
	public static List<FeatureLovMap> findByLovEntityResourceIdAndLovDataCode(
		long lovEntityResourceId, String lovDataCode, int start, int end,
		OrderByComparator<FeatureLovMap> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByLovEntityResourceIdAndLovDataCode(
			lovEntityResourceId, lovDataCode, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first feature lov map in the ordered set where lovEntityResourceId = &#63; and lovDataCode = &#63;.
	 *
	 * @param lovEntityResourceId the lov entity resource ID
	 * @param lovDataCode the lov data code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature lov map
	 * @throws NoSuchFeatureLovMapException if a matching feature lov map could not be found
	 */
	public static FeatureLovMap findByLovEntityResourceIdAndLovDataCode_First(
			long lovEntityResourceId, String lovDataCode,
			OrderByComparator<FeatureLovMap> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchFeatureLovMapException {

		return getPersistence().findByLovEntityResourceIdAndLovDataCode_First(
			lovEntityResourceId, lovDataCode, orderByComparator);
	}

	/**
	 * Returns the first feature lov map in the ordered set where lovEntityResourceId = &#63; and lovDataCode = &#63;.
	 *
	 * @param lovEntityResourceId the lov entity resource ID
	 * @param lovDataCode the lov data code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature lov map, or <code>null</code> if a matching feature lov map could not be found
	 */
	public static FeatureLovMap fetchByLovEntityResourceIdAndLovDataCode_First(
		long lovEntityResourceId, String lovDataCode,
		OrderByComparator<FeatureLovMap> orderByComparator) {

		return getPersistence().fetchByLovEntityResourceIdAndLovDataCode_First(
			lovEntityResourceId, lovDataCode, orderByComparator);
	}

	/**
	 * Returns the last feature lov map in the ordered set where lovEntityResourceId = &#63; and lovDataCode = &#63;.
	 *
	 * @param lovEntityResourceId the lov entity resource ID
	 * @param lovDataCode the lov data code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature lov map
	 * @throws NoSuchFeatureLovMapException if a matching feature lov map could not be found
	 */
	public static FeatureLovMap findByLovEntityResourceIdAndLovDataCode_Last(
			long lovEntityResourceId, String lovDataCode,
			OrderByComparator<FeatureLovMap> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchFeatureLovMapException {

		return getPersistence().findByLovEntityResourceIdAndLovDataCode_Last(
			lovEntityResourceId, lovDataCode, orderByComparator);
	}

	/**
	 * Returns the last feature lov map in the ordered set where lovEntityResourceId = &#63; and lovDataCode = &#63;.
	 *
	 * @param lovEntityResourceId the lov entity resource ID
	 * @param lovDataCode the lov data code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature lov map, or <code>null</code> if a matching feature lov map could not be found
	 */
	public static FeatureLovMap fetchByLovEntityResourceIdAndLovDataCode_Last(
		long lovEntityResourceId, String lovDataCode,
		OrderByComparator<FeatureLovMap> orderByComparator) {

		return getPersistence().fetchByLovEntityResourceIdAndLovDataCode_Last(
			lovEntityResourceId, lovDataCode, orderByComparator);
	}

	/**
	 * Returns the feature lov maps before and after the current feature lov map in the ordered set where lovEntityResourceId = &#63; and lovDataCode = &#63;.
	 *
	 * @param id the primary key of the current feature lov map
	 * @param lovEntityResourceId the lov entity resource ID
	 * @param lovDataCode the lov data code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next feature lov map
	 * @throws NoSuchFeatureLovMapException if a feature lov map with the primary key could not be found
	 */
	public static FeatureLovMap[]
			findByLovEntityResourceIdAndLovDataCode_PrevAndNext(
				long id, long lovEntityResourceId, String lovDataCode,
				OrderByComparator<FeatureLovMap> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchFeatureLovMapException {

		return getPersistence().
			findByLovEntityResourceIdAndLovDataCode_PrevAndNext(
				id, lovEntityResourceId, lovDataCode, orderByComparator);
	}

	/**
	 * Removes all the feature lov maps where lovEntityResourceId = &#63; and lovDataCode = &#63; from the database.
	 *
	 * @param lovEntityResourceId the lov entity resource ID
	 * @param lovDataCode the lov data code
	 */
	public static void removeByLovEntityResourceIdAndLovDataCode(
		long lovEntityResourceId, String lovDataCode) {

		getPersistence().removeByLovEntityResourceIdAndLovDataCode(
			lovEntityResourceId, lovDataCode);
	}

	/**
	 * Returns the number of feature lov maps where lovEntityResourceId = &#63; and lovDataCode = &#63;.
	 *
	 * @param lovEntityResourceId the lov entity resource ID
	 * @param lovDataCode the lov data code
	 * @return the number of matching feature lov maps
	 */
	public static int countByLovEntityResourceIdAndLovDataCode(
		long lovEntityResourceId, String lovDataCode) {

		return getPersistence().countByLovEntityResourceIdAndLovDataCode(
			lovEntityResourceId, lovDataCode);
	}

	/**
	 * Caches the feature lov map in the entity cache if it is enabled.
	 *
	 * @param featureLovMap the feature lov map
	 */
	public static void cacheResult(FeatureLovMap featureLovMap) {
		getPersistence().cacheResult(featureLovMap);
	}

	/**
	 * Caches the feature lov maps in the entity cache if it is enabled.
	 *
	 * @param featureLovMaps the feature lov maps
	 */
	public static void cacheResult(List<FeatureLovMap> featureLovMaps) {
		getPersistence().cacheResult(featureLovMaps);
	}

	/**
	 * Creates a new feature lov map with the primary key. Does not add the feature lov map to the database.
	 *
	 * @param id the primary key for the new feature lov map
	 * @return the new feature lov map
	 */
	public static FeatureLovMap create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the feature lov map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the feature lov map
	 * @return the feature lov map that was removed
	 * @throws NoSuchFeatureLovMapException if a feature lov map with the primary key could not be found
	 */
	public static FeatureLovMap remove(long id)
		throws com.ejada.telemony.db.exception.NoSuchFeatureLovMapException {

		return getPersistence().remove(id);
	}

	public static FeatureLovMap updateImpl(FeatureLovMap featureLovMap) {
		return getPersistence().updateImpl(featureLovMap);
	}

	/**
	 * Returns the feature lov map with the primary key or throws a <code>NoSuchFeatureLovMapException</code> if it could not be found.
	 *
	 * @param id the primary key of the feature lov map
	 * @return the feature lov map
	 * @throws NoSuchFeatureLovMapException if a feature lov map with the primary key could not be found
	 */
	public static FeatureLovMap findByPrimaryKey(long id)
		throws com.ejada.telemony.db.exception.NoSuchFeatureLovMapException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the feature lov map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the feature lov map
	 * @return the feature lov map, or <code>null</code> if a feature lov map with the primary key could not be found
	 */
	public static FeatureLovMap fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the feature lov maps.
	 *
	 * @return the feature lov maps
	 */
	public static List<FeatureLovMap> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the feature lov maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureLovMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of feature lov maps
	 * @param end the upper bound of the range of feature lov maps (not inclusive)
	 * @return the range of feature lov maps
	 */
	public static List<FeatureLovMap> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the feature lov maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureLovMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of feature lov maps
	 * @param end the upper bound of the range of feature lov maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of feature lov maps
	 */
	public static List<FeatureLovMap> findAll(
		int start, int end,
		OrderByComparator<FeatureLovMap> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the feature lov maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureLovMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of feature lov maps
	 * @param end the upper bound of the range of feature lov maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of feature lov maps
	 */
	public static List<FeatureLovMap> findAll(
		int start, int end, OrderByComparator<FeatureLovMap> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the feature lov maps from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of feature lov maps.
	 *
	 * @return the number of feature lov maps
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FeatureLovMapPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(FeatureLovMapPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile FeatureLovMapPersistence _persistence;

}