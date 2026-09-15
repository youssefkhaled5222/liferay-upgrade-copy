/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.model.Resource;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the resource service. This utility wraps <code>com.ejada.telemony.db.service.persistence.impl.ResourcePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ResourcePersistence
 * @generated
 */
public class ResourceUtil {

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
	public static void clearCache(Resource resource) {
		getPersistence().clearCache(resource);
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
	public static Map<Serializable, Resource> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Resource> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Resource> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Resource> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Resource> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Resource update(Resource resource) {
		return getPersistence().update(resource);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Resource update(
		Resource resource, ServiceContext serviceContext) {

		return getPersistence().update(resource, serviceContext);
	}

	/**
	 * Returns all the resources where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the matching resources
	 */
	public static List<Resource> findByChannelId(long channelId) {
		return getPersistence().findByChannelId(channelId);
	}

	/**
	 * Returns a range of all the resources where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of resources
	 * @param end the upper bound of the range of resources (not inclusive)
	 * @return the range of matching resources
	 */
	public static List<Resource> findByChannelId(
		long channelId, int start, int end) {

		return getPersistence().findByChannelId(channelId, start, end);
	}

	/**
	 * Returns an ordered range of all the resources where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of resources
	 * @param end the upper bound of the range of resources (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resources
	 */
	public static List<Resource> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<Resource> orderByComparator) {

		return getPersistence().findByChannelId(
			channelId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the resources where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of resources
	 * @param end the upper bound of the range of resources (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resources
	 */
	public static List<Resource> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<Resource> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByChannelId(
			channelId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first resource in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource
	 * @throws NoSuchResourceException if a matching resource could not be found
	 */
	public static Resource findByChannelId_First(
			long channelId, OrderByComparator<Resource> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchResourceException {

		return getPersistence().findByChannelId_First(
			channelId, orderByComparator);
	}

	/**
	 * Returns the first resource in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource, or <code>null</code> if a matching resource could not be found
	 */
	public static Resource fetchByChannelId_First(
		long channelId, OrderByComparator<Resource> orderByComparator) {

		return getPersistence().fetchByChannelId_First(
			channelId, orderByComparator);
	}

	/**
	 * Returns the last resource in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource
	 * @throws NoSuchResourceException if a matching resource could not be found
	 */
	public static Resource findByChannelId_Last(
			long channelId, OrderByComparator<Resource> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchResourceException {

		return getPersistence().findByChannelId_Last(
			channelId, orderByComparator);
	}

	/**
	 * Returns the last resource in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource, or <code>null</code> if a matching resource could not be found
	 */
	public static Resource fetchByChannelId_Last(
		long channelId, OrderByComparator<Resource> orderByComparator) {

		return getPersistence().fetchByChannelId_Last(
			channelId, orderByComparator);
	}

	/**
	 * Returns the resources before and after the current resource in the ordered set where channelId = &#63;.
	 *
	 * @param resourceId the primary key of the current resource
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource
	 * @throws NoSuchResourceException if a resource with the primary key could not be found
	 */
	public static Resource[] findByChannelId_PrevAndNext(
			long resourceId, long channelId,
			OrderByComparator<Resource> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchResourceException {

		return getPersistence().findByChannelId_PrevAndNext(
			resourceId, channelId, orderByComparator);
	}

	/**
	 * Removes all the resources where channelId = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 */
	public static void removeByChannelId(long channelId) {
		getPersistence().removeByChannelId(channelId);
	}

	/**
	 * Returns the number of resources where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the number of matching resources
	 */
	public static int countByChannelId(long channelId) {
		return getPersistence().countByChannelId(channelId);
	}

	/**
	 * Returns all the resources where resourceCode = &#63; and channelId = &#63;.
	 *
	 * @param resourceCode the resource code
	 * @param channelId the channel ID
	 * @return the matching resources
	 */
	public static List<Resource> findByResourceCode(
		String resourceCode, long channelId) {

		return getPersistence().findByResourceCode(resourceCode, channelId);
	}

	/**
	 * Returns a range of all the resources where resourceCode = &#63; and channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceModelImpl</code>.
	 * </p>
	 *
	 * @param resourceCode the resource code
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of resources
	 * @param end the upper bound of the range of resources (not inclusive)
	 * @return the range of matching resources
	 */
	public static List<Resource> findByResourceCode(
		String resourceCode, long channelId, int start, int end) {

		return getPersistence().findByResourceCode(
			resourceCode, channelId, start, end);
	}

	/**
	 * Returns an ordered range of all the resources where resourceCode = &#63; and channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceModelImpl</code>.
	 * </p>
	 *
	 * @param resourceCode the resource code
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of resources
	 * @param end the upper bound of the range of resources (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resources
	 */
	public static List<Resource> findByResourceCode(
		String resourceCode, long channelId, int start, int end,
		OrderByComparator<Resource> orderByComparator) {

		return getPersistence().findByResourceCode(
			resourceCode, channelId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the resources where resourceCode = &#63; and channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceModelImpl</code>.
	 * </p>
	 *
	 * @param resourceCode the resource code
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of resources
	 * @param end the upper bound of the range of resources (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resources
	 */
	public static List<Resource> findByResourceCode(
		String resourceCode, long channelId, int start, int end,
		OrderByComparator<Resource> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByResourceCode(
			resourceCode, channelId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first resource in the ordered set where resourceCode = &#63; and channelId = &#63;.
	 *
	 * @param resourceCode the resource code
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource
	 * @throws NoSuchResourceException if a matching resource could not be found
	 */
	public static Resource findByResourceCode_First(
			String resourceCode, long channelId,
			OrderByComparator<Resource> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchResourceException {

		return getPersistence().findByResourceCode_First(
			resourceCode, channelId, orderByComparator);
	}

	/**
	 * Returns the first resource in the ordered set where resourceCode = &#63; and channelId = &#63;.
	 *
	 * @param resourceCode the resource code
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource, or <code>null</code> if a matching resource could not be found
	 */
	public static Resource fetchByResourceCode_First(
		String resourceCode, long channelId,
		OrderByComparator<Resource> orderByComparator) {

		return getPersistence().fetchByResourceCode_First(
			resourceCode, channelId, orderByComparator);
	}

	/**
	 * Returns the last resource in the ordered set where resourceCode = &#63; and channelId = &#63;.
	 *
	 * @param resourceCode the resource code
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource
	 * @throws NoSuchResourceException if a matching resource could not be found
	 */
	public static Resource findByResourceCode_Last(
			String resourceCode, long channelId,
			OrderByComparator<Resource> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchResourceException {

		return getPersistence().findByResourceCode_Last(
			resourceCode, channelId, orderByComparator);
	}

	/**
	 * Returns the last resource in the ordered set where resourceCode = &#63; and channelId = &#63;.
	 *
	 * @param resourceCode the resource code
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource, or <code>null</code> if a matching resource could not be found
	 */
	public static Resource fetchByResourceCode_Last(
		String resourceCode, long channelId,
		OrderByComparator<Resource> orderByComparator) {

		return getPersistence().fetchByResourceCode_Last(
			resourceCode, channelId, orderByComparator);
	}

	/**
	 * Returns the resources before and after the current resource in the ordered set where resourceCode = &#63; and channelId = &#63;.
	 *
	 * @param resourceId the primary key of the current resource
	 * @param resourceCode the resource code
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource
	 * @throws NoSuchResourceException if a resource with the primary key could not be found
	 */
	public static Resource[] findByResourceCode_PrevAndNext(
			long resourceId, String resourceCode, long channelId,
			OrderByComparator<Resource> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchResourceException {

		return getPersistence().findByResourceCode_PrevAndNext(
			resourceId, resourceCode, channelId, orderByComparator);
	}

	/**
	 * Removes all the resources where resourceCode = &#63; and channelId = &#63; from the database.
	 *
	 * @param resourceCode the resource code
	 * @param channelId the channel ID
	 */
	public static void removeByResourceCode(
		String resourceCode, long channelId) {

		getPersistence().removeByResourceCode(resourceCode, channelId);
	}

	/**
	 * Returns the number of resources where resourceCode = &#63; and channelId = &#63;.
	 *
	 * @param resourceCode the resource code
	 * @param channelId the channel ID
	 * @return the number of matching resources
	 */
	public static int countByResourceCode(String resourceCode, long channelId) {
		return getPersistence().countByResourceCode(resourceCode, channelId);
	}

	/**
	 * Returns all the resources where resourceType = &#63; and channelId = &#63;.
	 *
	 * @param resourceType the resource type
	 * @param channelId the channel ID
	 * @return the matching resources
	 */
	public static List<Resource> findByResourceType(
		String resourceType, long channelId) {

		return getPersistence().findByResourceType(resourceType, channelId);
	}

	/**
	 * Returns a range of all the resources where resourceType = &#63; and channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceModelImpl</code>.
	 * </p>
	 *
	 * @param resourceType the resource type
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of resources
	 * @param end the upper bound of the range of resources (not inclusive)
	 * @return the range of matching resources
	 */
	public static List<Resource> findByResourceType(
		String resourceType, long channelId, int start, int end) {

		return getPersistence().findByResourceType(
			resourceType, channelId, start, end);
	}

	/**
	 * Returns an ordered range of all the resources where resourceType = &#63; and channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceModelImpl</code>.
	 * </p>
	 *
	 * @param resourceType the resource type
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of resources
	 * @param end the upper bound of the range of resources (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resources
	 */
	public static List<Resource> findByResourceType(
		String resourceType, long channelId, int start, int end,
		OrderByComparator<Resource> orderByComparator) {

		return getPersistence().findByResourceType(
			resourceType, channelId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the resources where resourceType = &#63; and channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceModelImpl</code>.
	 * </p>
	 *
	 * @param resourceType the resource type
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of resources
	 * @param end the upper bound of the range of resources (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resources
	 */
	public static List<Resource> findByResourceType(
		String resourceType, long channelId, int start, int end,
		OrderByComparator<Resource> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByResourceType(
			resourceType, channelId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first resource in the ordered set where resourceType = &#63; and channelId = &#63;.
	 *
	 * @param resourceType the resource type
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource
	 * @throws NoSuchResourceException if a matching resource could not be found
	 */
	public static Resource findByResourceType_First(
			String resourceType, long channelId,
			OrderByComparator<Resource> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchResourceException {

		return getPersistence().findByResourceType_First(
			resourceType, channelId, orderByComparator);
	}

	/**
	 * Returns the first resource in the ordered set where resourceType = &#63; and channelId = &#63;.
	 *
	 * @param resourceType the resource type
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource, or <code>null</code> if a matching resource could not be found
	 */
	public static Resource fetchByResourceType_First(
		String resourceType, long channelId,
		OrderByComparator<Resource> orderByComparator) {

		return getPersistence().fetchByResourceType_First(
			resourceType, channelId, orderByComparator);
	}

	/**
	 * Returns the last resource in the ordered set where resourceType = &#63; and channelId = &#63;.
	 *
	 * @param resourceType the resource type
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource
	 * @throws NoSuchResourceException if a matching resource could not be found
	 */
	public static Resource findByResourceType_Last(
			String resourceType, long channelId,
			OrderByComparator<Resource> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchResourceException {

		return getPersistence().findByResourceType_Last(
			resourceType, channelId, orderByComparator);
	}

	/**
	 * Returns the last resource in the ordered set where resourceType = &#63; and channelId = &#63;.
	 *
	 * @param resourceType the resource type
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource, or <code>null</code> if a matching resource could not be found
	 */
	public static Resource fetchByResourceType_Last(
		String resourceType, long channelId,
		OrderByComparator<Resource> orderByComparator) {

		return getPersistence().fetchByResourceType_Last(
			resourceType, channelId, orderByComparator);
	}

	/**
	 * Returns the resources before and after the current resource in the ordered set where resourceType = &#63; and channelId = &#63;.
	 *
	 * @param resourceId the primary key of the current resource
	 * @param resourceType the resource type
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource
	 * @throws NoSuchResourceException if a resource with the primary key could not be found
	 */
	public static Resource[] findByResourceType_PrevAndNext(
			long resourceId, String resourceType, long channelId,
			OrderByComparator<Resource> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchResourceException {

		return getPersistence().findByResourceType_PrevAndNext(
			resourceId, resourceType, channelId, orderByComparator);
	}

	/**
	 * Removes all the resources where resourceType = &#63; and channelId = &#63; from the database.
	 *
	 * @param resourceType the resource type
	 * @param channelId the channel ID
	 */
	public static void removeByResourceType(
		String resourceType, long channelId) {

		getPersistence().removeByResourceType(resourceType, channelId);
	}

	/**
	 * Returns the number of resources where resourceType = &#63; and channelId = &#63;.
	 *
	 * @param resourceType the resource type
	 * @param channelId the channel ID
	 * @return the number of matching resources
	 */
	public static int countByResourceType(String resourceType, long channelId) {
		return getPersistence().countByResourceType(resourceType, channelId);
	}

	/**
	 * Returns all the resources where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the matching resources
	 */
	public static List<Resource> findByentityResourceId(long entityResourceId) {
		return getPersistence().findByentityResourceId(entityResourceId);
	}

	/**
	 * Returns a range of all the resources where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of resources
	 * @param end the upper bound of the range of resources (not inclusive)
	 * @return the range of matching resources
	 */
	public static List<Resource> findByentityResourceId(
		long entityResourceId, int start, int end) {

		return getPersistence().findByentityResourceId(
			entityResourceId, start, end);
	}

	/**
	 * Returns an ordered range of all the resources where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of resources
	 * @param end the upper bound of the range of resources (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resources
	 */
	public static List<Resource> findByentityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<Resource> orderByComparator) {

		return getPersistence().findByentityResourceId(
			entityResourceId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the resources where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of resources
	 * @param end the upper bound of the range of resources (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resources
	 */
	public static List<Resource> findByentityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<Resource> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByentityResourceId(
			entityResourceId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first resource in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource
	 * @throws NoSuchResourceException if a matching resource could not be found
	 */
	public static Resource findByentityResourceId_First(
			long entityResourceId,
			OrderByComparator<Resource> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchResourceException {

		return getPersistence().findByentityResourceId_First(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the first resource in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource, or <code>null</code> if a matching resource could not be found
	 */
	public static Resource fetchByentityResourceId_First(
		long entityResourceId, OrderByComparator<Resource> orderByComparator) {

		return getPersistence().fetchByentityResourceId_First(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the last resource in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource
	 * @throws NoSuchResourceException if a matching resource could not be found
	 */
	public static Resource findByentityResourceId_Last(
			long entityResourceId,
			OrderByComparator<Resource> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchResourceException {

		return getPersistence().findByentityResourceId_Last(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the last resource in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource, or <code>null</code> if a matching resource could not be found
	 */
	public static Resource fetchByentityResourceId_Last(
		long entityResourceId, OrderByComparator<Resource> orderByComparator) {

		return getPersistence().fetchByentityResourceId_Last(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the resources before and after the current resource in the ordered set where entityResourceId = &#63;.
	 *
	 * @param resourceId the primary key of the current resource
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource
	 * @throws NoSuchResourceException if a resource with the primary key could not be found
	 */
	public static Resource[] findByentityResourceId_PrevAndNext(
			long resourceId, long entityResourceId,
			OrderByComparator<Resource> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchResourceException {

		return getPersistence().findByentityResourceId_PrevAndNext(
			resourceId, entityResourceId, orderByComparator);
	}

	/**
	 * Removes all the resources where entityResourceId = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 */
	public static void removeByentityResourceId(long entityResourceId) {
		getPersistence().removeByentityResourceId(entityResourceId);
	}

	/**
	 * Returns the number of resources where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the number of matching resources
	 */
	public static int countByentityResourceId(long entityResourceId) {
		return getPersistence().countByentityResourceId(entityResourceId);
	}

	/**
	 * Caches the resource in the entity cache if it is enabled.
	 *
	 * @param resource the resource
	 */
	public static void cacheResult(Resource resource) {
		getPersistence().cacheResult(resource);
	}

	/**
	 * Caches the resources in the entity cache if it is enabled.
	 *
	 * @param resources the resources
	 */
	public static void cacheResult(List<Resource> resources) {
		getPersistence().cacheResult(resources);
	}

	/**
	 * Creates a new resource with the primary key. Does not add the resource to the database.
	 *
	 * @param resourceId the primary key for the new resource
	 * @return the new resource
	 */
	public static Resource create(long resourceId) {
		return getPersistence().create(resourceId);
	}

	/**
	 * Removes the resource with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param resourceId the primary key of the resource
	 * @return the resource that was removed
	 * @throws NoSuchResourceException if a resource with the primary key could not be found
	 */
	public static Resource remove(long resourceId)
		throws com.ejada.telemony.db.exception.NoSuchResourceException {

		return getPersistence().remove(resourceId);
	}

	public static Resource updateImpl(Resource resource) {
		return getPersistence().updateImpl(resource);
	}

	/**
	 * Returns the resource with the primary key or throws a <code>NoSuchResourceException</code> if it could not be found.
	 *
	 * @param resourceId the primary key of the resource
	 * @return the resource
	 * @throws NoSuchResourceException if a resource with the primary key could not be found
	 */
	public static Resource findByPrimaryKey(long resourceId)
		throws com.ejada.telemony.db.exception.NoSuchResourceException {

		return getPersistence().findByPrimaryKey(resourceId);
	}

	/**
	 * Returns the resource with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param resourceId the primary key of the resource
	 * @return the resource, or <code>null</code> if a resource with the primary key could not be found
	 */
	public static Resource fetchByPrimaryKey(long resourceId) {
		return getPersistence().fetchByPrimaryKey(resourceId);
	}

	/**
	 * Returns all the resources.
	 *
	 * @return the resources
	 */
	public static List<Resource> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the resources.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resources
	 * @param end the upper bound of the range of resources (not inclusive)
	 * @return the range of resources
	 */
	public static List<Resource> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the resources.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resources
	 * @param end the upper bound of the range of resources (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of resources
	 */
	public static List<Resource> findAll(
		int start, int end, OrderByComparator<Resource> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the resources.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resources
	 * @param end the upper bound of the range of resources (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of resources
	 */
	public static List<Resource> findAll(
		int start, int end, OrderByComparator<Resource> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the resources from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of resources.
	 *
	 * @return the number of resources
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ResourcePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(ResourcePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile ResourcePersistence _persistence;

}