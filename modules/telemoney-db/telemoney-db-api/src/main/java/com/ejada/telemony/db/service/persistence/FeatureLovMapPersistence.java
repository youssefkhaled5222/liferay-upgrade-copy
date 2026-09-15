/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.exception.NoSuchFeatureLovMapException;
import com.ejada.telemony.db.model.FeatureLovMap;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the feature lov map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FeatureLovMapUtil
 * @generated
 */
@ProviderType
public interface FeatureLovMapPersistence
	extends BasePersistence<FeatureLovMap> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FeatureLovMapUtil} to access the feature lov map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the feature lov maps where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @return the matching feature lov maps
	 */
	public java.util.List<FeatureLovMap> findByFeatureId(long featureId);

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
	public java.util.List<FeatureLovMap> findByFeatureId(
		long featureId, int start, int end);

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
	public java.util.List<FeatureLovMap> findByFeatureId(
		long featureId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FeatureLovMap>
			orderByComparator);

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
	public java.util.List<FeatureLovMap> findByFeatureId(
		long featureId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FeatureLovMap>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first feature lov map in the ordered set where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature lov map
	 * @throws NoSuchFeatureLovMapException if a matching feature lov map could not be found
	 */
	public FeatureLovMap findByFeatureId_First(
			long featureId,
			com.liferay.portal.kernel.util.OrderByComparator<FeatureLovMap>
				orderByComparator)
		throws NoSuchFeatureLovMapException;

	/**
	 * Returns the first feature lov map in the ordered set where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature lov map, or <code>null</code> if a matching feature lov map could not be found
	 */
	public FeatureLovMap fetchByFeatureId_First(
		long featureId,
		com.liferay.portal.kernel.util.OrderByComparator<FeatureLovMap>
			orderByComparator);

	/**
	 * Returns the last feature lov map in the ordered set where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature lov map
	 * @throws NoSuchFeatureLovMapException if a matching feature lov map could not be found
	 */
	public FeatureLovMap findByFeatureId_Last(
			long featureId,
			com.liferay.portal.kernel.util.OrderByComparator<FeatureLovMap>
				orderByComparator)
		throws NoSuchFeatureLovMapException;

	/**
	 * Returns the last feature lov map in the ordered set where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature lov map, or <code>null</code> if a matching feature lov map could not be found
	 */
	public FeatureLovMap fetchByFeatureId_Last(
		long featureId,
		com.liferay.portal.kernel.util.OrderByComparator<FeatureLovMap>
			orderByComparator);

	/**
	 * Returns the feature lov maps before and after the current feature lov map in the ordered set where featureId = &#63;.
	 *
	 * @param id the primary key of the current feature lov map
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next feature lov map
	 * @throws NoSuchFeatureLovMapException if a feature lov map with the primary key could not be found
	 */
	public FeatureLovMap[] findByFeatureId_PrevAndNext(
			long id, long featureId,
			com.liferay.portal.kernel.util.OrderByComparator<FeatureLovMap>
				orderByComparator)
		throws NoSuchFeatureLovMapException;

	/**
	 * Removes all the feature lov maps where featureId = &#63; from the database.
	 *
	 * @param featureId the feature ID
	 */
	public void removeByFeatureId(long featureId);

	/**
	 * Returns the number of feature lov maps where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @return the number of matching feature lov maps
	 */
	public int countByFeatureId(long featureId);

	/**
	 * Returns all the feature lov maps where featureEntityResourceId = &#63;.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @return the matching feature lov maps
	 */
	public java.util.List<FeatureLovMap> findByFeatureEntityResourceId(
		long featureEntityResourceId);

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
	public java.util.List<FeatureLovMap> findByFeatureEntityResourceId(
		long featureEntityResourceId, int start, int end);

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
	public java.util.List<FeatureLovMap> findByFeatureEntityResourceId(
		long featureEntityResourceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FeatureLovMap>
			orderByComparator);

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
	public java.util.List<FeatureLovMap> findByFeatureEntityResourceId(
		long featureEntityResourceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FeatureLovMap>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first feature lov map in the ordered set where featureEntityResourceId = &#63;.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature lov map
	 * @throws NoSuchFeatureLovMapException if a matching feature lov map could not be found
	 */
	public FeatureLovMap findByFeatureEntityResourceId_First(
			long featureEntityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<FeatureLovMap>
				orderByComparator)
		throws NoSuchFeatureLovMapException;

	/**
	 * Returns the first feature lov map in the ordered set where featureEntityResourceId = &#63;.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature lov map, or <code>null</code> if a matching feature lov map could not be found
	 */
	public FeatureLovMap fetchByFeatureEntityResourceId_First(
		long featureEntityResourceId,
		com.liferay.portal.kernel.util.OrderByComparator<FeatureLovMap>
			orderByComparator);

	/**
	 * Returns the last feature lov map in the ordered set where featureEntityResourceId = &#63;.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature lov map
	 * @throws NoSuchFeatureLovMapException if a matching feature lov map could not be found
	 */
	public FeatureLovMap findByFeatureEntityResourceId_Last(
			long featureEntityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<FeatureLovMap>
				orderByComparator)
		throws NoSuchFeatureLovMapException;

	/**
	 * Returns the last feature lov map in the ordered set where featureEntityResourceId = &#63;.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature lov map, or <code>null</code> if a matching feature lov map could not be found
	 */
	public FeatureLovMap fetchByFeatureEntityResourceId_Last(
		long featureEntityResourceId,
		com.liferay.portal.kernel.util.OrderByComparator<FeatureLovMap>
			orderByComparator);

	/**
	 * Returns the feature lov maps before and after the current feature lov map in the ordered set where featureEntityResourceId = &#63;.
	 *
	 * @param id the primary key of the current feature lov map
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next feature lov map
	 * @throws NoSuchFeatureLovMapException if a feature lov map with the primary key could not be found
	 */
	public FeatureLovMap[] findByFeatureEntityResourceId_PrevAndNext(
			long id, long featureEntityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<FeatureLovMap>
				orderByComparator)
		throws NoSuchFeatureLovMapException;

	/**
	 * Removes all the feature lov maps where featureEntityResourceId = &#63; from the database.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 */
	public void removeByFeatureEntityResourceId(long featureEntityResourceId);

	/**
	 * Returns the number of feature lov maps where featureEntityResourceId = &#63;.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @return the number of matching feature lov maps
	 */
	public int countByFeatureEntityResourceId(long featureEntityResourceId);

	/**
	 * Returns all the feature lov maps where featureId = &#63; and lovType = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param lovType the lov type
	 * @return the matching feature lov maps
	 */
	public java.util.List<FeatureLovMap> findByFeatureIdAndLovType(
		long featureId, String lovType);

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
	public java.util.List<FeatureLovMap> findByFeatureIdAndLovType(
		long featureId, String lovType, int start, int end);

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
	public java.util.List<FeatureLovMap> findByFeatureIdAndLovType(
		long featureId, String lovType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FeatureLovMap>
			orderByComparator);

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
	public java.util.List<FeatureLovMap> findByFeatureIdAndLovType(
		long featureId, String lovType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FeatureLovMap>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first feature lov map in the ordered set where featureId = &#63; and lovType = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param lovType the lov type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature lov map
	 * @throws NoSuchFeatureLovMapException if a matching feature lov map could not be found
	 */
	public FeatureLovMap findByFeatureIdAndLovType_First(
			long featureId, String lovType,
			com.liferay.portal.kernel.util.OrderByComparator<FeatureLovMap>
				orderByComparator)
		throws NoSuchFeatureLovMapException;

	/**
	 * Returns the first feature lov map in the ordered set where featureId = &#63; and lovType = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param lovType the lov type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature lov map, or <code>null</code> if a matching feature lov map could not be found
	 */
	public FeatureLovMap fetchByFeatureIdAndLovType_First(
		long featureId, String lovType,
		com.liferay.portal.kernel.util.OrderByComparator<FeatureLovMap>
			orderByComparator);

	/**
	 * Returns the last feature lov map in the ordered set where featureId = &#63; and lovType = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param lovType the lov type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature lov map
	 * @throws NoSuchFeatureLovMapException if a matching feature lov map could not be found
	 */
	public FeatureLovMap findByFeatureIdAndLovType_Last(
			long featureId, String lovType,
			com.liferay.portal.kernel.util.OrderByComparator<FeatureLovMap>
				orderByComparator)
		throws NoSuchFeatureLovMapException;

	/**
	 * Returns the last feature lov map in the ordered set where featureId = &#63; and lovType = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param lovType the lov type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature lov map, or <code>null</code> if a matching feature lov map could not be found
	 */
	public FeatureLovMap fetchByFeatureIdAndLovType_Last(
		long featureId, String lovType,
		com.liferay.portal.kernel.util.OrderByComparator<FeatureLovMap>
			orderByComparator);

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
	public FeatureLovMap[] findByFeatureIdAndLovType_PrevAndNext(
			long id, long featureId, String lovType,
			com.liferay.portal.kernel.util.OrderByComparator<FeatureLovMap>
				orderByComparator)
		throws NoSuchFeatureLovMapException;

	/**
	 * Removes all the feature lov maps where featureId = &#63; and lovType = &#63; from the database.
	 *
	 * @param featureId the feature ID
	 * @param lovType the lov type
	 */
	public void removeByFeatureIdAndLovType(long featureId, String lovType);

	/**
	 * Returns the number of feature lov maps where featureId = &#63; and lovType = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param lovType the lov type
	 * @return the number of matching feature lov maps
	 */
	public int countByFeatureIdAndLovType(long featureId, String lovType);

	/**
	 * Returns all the feature lov maps where featureEntityResourceId = &#63; and lovType = &#63;.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param lovType the lov type
	 * @return the matching feature lov maps
	 */
	public java.util.List<FeatureLovMap>
		findByFeatureEntityResourceIdAndLovType(
			long featureEntityResourceId, String lovType);

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
	public java.util.List<FeatureLovMap>
		findByFeatureEntityResourceIdAndLovType(
			long featureEntityResourceId, String lovType, int start, int end);

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
	public java.util.List<FeatureLovMap>
		findByFeatureEntityResourceIdAndLovType(
			long featureEntityResourceId, String lovType, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<FeatureLovMap>
				orderByComparator);

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
	public java.util.List<FeatureLovMap>
		findByFeatureEntityResourceIdAndLovType(
			long featureEntityResourceId, String lovType, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<FeatureLovMap>
				orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first feature lov map in the ordered set where featureEntityResourceId = &#63; and lovType = &#63;.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param lovType the lov type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature lov map
	 * @throws NoSuchFeatureLovMapException if a matching feature lov map could not be found
	 */
	public FeatureLovMap findByFeatureEntityResourceIdAndLovType_First(
			long featureEntityResourceId, String lovType,
			com.liferay.portal.kernel.util.OrderByComparator<FeatureLovMap>
				orderByComparator)
		throws NoSuchFeatureLovMapException;

	/**
	 * Returns the first feature lov map in the ordered set where featureEntityResourceId = &#63; and lovType = &#63;.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param lovType the lov type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature lov map, or <code>null</code> if a matching feature lov map could not be found
	 */
	public FeatureLovMap fetchByFeatureEntityResourceIdAndLovType_First(
		long featureEntityResourceId, String lovType,
		com.liferay.portal.kernel.util.OrderByComparator<FeatureLovMap>
			orderByComparator);

	/**
	 * Returns the last feature lov map in the ordered set where featureEntityResourceId = &#63; and lovType = &#63;.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param lovType the lov type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature lov map
	 * @throws NoSuchFeatureLovMapException if a matching feature lov map could not be found
	 */
	public FeatureLovMap findByFeatureEntityResourceIdAndLovType_Last(
			long featureEntityResourceId, String lovType,
			com.liferay.portal.kernel.util.OrderByComparator<FeatureLovMap>
				orderByComparator)
		throws NoSuchFeatureLovMapException;

	/**
	 * Returns the last feature lov map in the ordered set where featureEntityResourceId = &#63; and lovType = &#63;.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param lovType the lov type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature lov map, or <code>null</code> if a matching feature lov map could not be found
	 */
	public FeatureLovMap fetchByFeatureEntityResourceIdAndLovType_Last(
		long featureEntityResourceId, String lovType,
		com.liferay.portal.kernel.util.OrderByComparator<FeatureLovMap>
			orderByComparator);

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
	public FeatureLovMap[] findByFeatureEntityResourceIdAndLovType_PrevAndNext(
			long id, long featureEntityResourceId, String lovType,
			com.liferay.portal.kernel.util.OrderByComparator<FeatureLovMap>
				orderByComparator)
		throws NoSuchFeatureLovMapException;

	/**
	 * Removes all the feature lov maps where featureEntityResourceId = &#63; and lovType = &#63; from the database.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param lovType the lov type
	 */
	public void removeByFeatureEntityResourceIdAndLovType(
		long featureEntityResourceId, String lovType);

	/**
	 * Returns the number of feature lov maps where featureEntityResourceId = &#63; and lovType = &#63;.
	 *
	 * @param featureEntityResourceId the feature entity resource ID
	 * @param lovType the lov type
	 * @return the number of matching feature lov maps
	 */
	public int countByFeatureEntityResourceIdAndLovType(
		long featureEntityResourceId, String lovType);

	/**
	 * Returns all the feature lov maps where lovEntityResourceId = &#63; and lovDataCode = &#63;.
	 *
	 * @param lovEntityResourceId the lov entity resource ID
	 * @param lovDataCode the lov data code
	 * @return the matching feature lov maps
	 */
	public java.util.List<FeatureLovMap>
		findByLovEntityResourceIdAndLovDataCode(
			long lovEntityResourceId, String lovDataCode);

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
	public java.util.List<FeatureLovMap>
		findByLovEntityResourceIdAndLovDataCode(
			long lovEntityResourceId, String lovDataCode, int start, int end);

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
	public java.util.List<FeatureLovMap>
		findByLovEntityResourceIdAndLovDataCode(
			long lovEntityResourceId, String lovDataCode, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<FeatureLovMap>
				orderByComparator);

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
	public java.util.List<FeatureLovMap>
		findByLovEntityResourceIdAndLovDataCode(
			long lovEntityResourceId, String lovDataCode, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<FeatureLovMap>
				orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first feature lov map in the ordered set where lovEntityResourceId = &#63; and lovDataCode = &#63;.
	 *
	 * @param lovEntityResourceId the lov entity resource ID
	 * @param lovDataCode the lov data code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature lov map
	 * @throws NoSuchFeatureLovMapException if a matching feature lov map could not be found
	 */
	public FeatureLovMap findByLovEntityResourceIdAndLovDataCode_First(
			long lovEntityResourceId, String lovDataCode,
			com.liferay.portal.kernel.util.OrderByComparator<FeatureLovMap>
				orderByComparator)
		throws NoSuchFeatureLovMapException;

	/**
	 * Returns the first feature lov map in the ordered set where lovEntityResourceId = &#63; and lovDataCode = &#63;.
	 *
	 * @param lovEntityResourceId the lov entity resource ID
	 * @param lovDataCode the lov data code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature lov map, or <code>null</code> if a matching feature lov map could not be found
	 */
	public FeatureLovMap fetchByLovEntityResourceIdAndLovDataCode_First(
		long lovEntityResourceId, String lovDataCode,
		com.liferay.portal.kernel.util.OrderByComparator<FeatureLovMap>
			orderByComparator);

	/**
	 * Returns the last feature lov map in the ordered set where lovEntityResourceId = &#63; and lovDataCode = &#63;.
	 *
	 * @param lovEntityResourceId the lov entity resource ID
	 * @param lovDataCode the lov data code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature lov map
	 * @throws NoSuchFeatureLovMapException if a matching feature lov map could not be found
	 */
	public FeatureLovMap findByLovEntityResourceIdAndLovDataCode_Last(
			long lovEntityResourceId, String lovDataCode,
			com.liferay.portal.kernel.util.OrderByComparator<FeatureLovMap>
				orderByComparator)
		throws NoSuchFeatureLovMapException;

	/**
	 * Returns the last feature lov map in the ordered set where lovEntityResourceId = &#63; and lovDataCode = &#63;.
	 *
	 * @param lovEntityResourceId the lov entity resource ID
	 * @param lovDataCode the lov data code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature lov map, or <code>null</code> if a matching feature lov map could not be found
	 */
	public FeatureLovMap fetchByLovEntityResourceIdAndLovDataCode_Last(
		long lovEntityResourceId, String lovDataCode,
		com.liferay.portal.kernel.util.OrderByComparator<FeatureLovMap>
			orderByComparator);

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
	public FeatureLovMap[] findByLovEntityResourceIdAndLovDataCode_PrevAndNext(
			long id, long lovEntityResourceId, String lovDataCode,
			com.liferay.portal.kernel.util.OrderByComparator<FeatureLovMap>
				orderByComparator)
		throws NoSuchFeatureLovMapException;

	/**
	 * Removes all the feature lov maps where lovEntityResourceId = &#63; and lovDataCode = &#63; from the database.
	 *
	 * @param lovEntityResourceId the lov entity resource ID
	 * @param lovDataCode the lov data code
	 */
	public void removeByLovEntityResourceIdAndLovDataCode(
		long lovEntityResourceId, String lovDataCode);

	/**
	 * Returns the number of feature lov maps where lovEntityResourceId = &#63; and lovDataCode = &#63;.
	 *
	 * @param lovEntityResourceId the lov entity resource ID
	 * @param lovDataCode the lov data code
	 * @return the number of matching feature lov maps
	 */
	public int countByLovEntityResourceIdAndLovDataCode(
		long lovEntityResourceId, String lovDataCode);

	/**
	 * Caches the feature lov map in the entity cache if it is enabled.
	 *
	 * @param featureLovMap the feature lov map
	 */
	public void cacheResult(FeatureLovMap featureLovMap);

	/**
	 * Caches the feature lov maps in the entity cache if it is enabled.
	 *
	 * @param featureLovMaps the feature lov maps
	 */
	public void cacheResult(java.util.List<FeatureLovMap> featureLovMaps);

	/**
	 * Creates a new feature lov map with the primary key. Does not add the feature lov map to the database.
	 *
	 * @param id the primary key for the new feature lov map
	 * @return the new feature lov map
	 */
	public FeatureLovMap create(long id);

	/**
	 * Removes the feature lov map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the feature lov map
	 * @return the feature lov map that was removed
	 * @throws NoSuchFeatureLovMapException if a feature lov map with the primary key could not be found
	 */
	public FeatureLovMap remove(long id) throws NoSuchFeatureLovMapException;

	public FeatureLovMap updateImpl(FeatureLovMap featureLovMap);

	/**
	 * Returns the feature lov map with the primary key or throws a <code>NoSuchFeatureLovMapException</code> if it could not be found.
	 *
	 * @param id the primary key of the feature lov map
	 * @return the feature lov map
	 * @throws NoSuchFeatureLovMapException if a feature lov map with the primary key could not be found
	 */
	public FeatureLovMap findByPrimaryKey(long id)
		throws NoSuchFeatureLovMapException;

	/**
	 * Returns the feature lov map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the feature lov map
	 * @return the feature lov map, or <code>null</code> if a feature lov map with the primary key could not be found
	 */
	public FeatureLovMap fetchByPrimaryKey(long id);

	/**
	 * Returns all the feature lov maps.
	 *
	 * @return the feature lov maps
	 */
	public java.util.List<FeatureLovMap> findAll();

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
	public java.util.List<FeatureLovMap> findAll(int start, int end);

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
	public java.util.List<FeatureLovMap> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FeatureLovMap>
			orderByComparator);

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
	public java.util.List<FeatureLovMap> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FeatureLovMap>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the feature lov maps from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of feature lov maps.
	 *
	 * @return the number of feature lov maps
	 */
	public int countAll();

}