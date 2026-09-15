/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.exception.NoSuchResourceException;
import com.ejada.telemony.db.model.Resource;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the resource service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ResourceUtil
 * @generated
 */
@ProviderType
public interface ResourcePersistence extends BasePersistence<Resource> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ResourceUtil} to access the resource persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the resources where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the matching resources
	 */
	public java.util.List<Resource> findByChannelId(long channelId);

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
	public java.util.List<Resource> findByChannelId(
		long channelId, int start, int end);

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
	public java.util.List<Resource> findByChannelId(
		long channelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Resource>
			orderByComparator);

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
	public java.util.List<Resource> findByChannelId(
		long channelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Resource>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first resource in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource
	 * @throws NoSuchResourceException if a matching resource could not be found
	 */
	public Resource findByChannelId_First(
			long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<Resource>
				orderByComparator)
		throws NoSuchResourceException;

	/**
	 * Returns the first resource in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource, or <code>null</code> if a matching resource could not be found
	 */
	public Resource fetchByChannelId_First(
		long channelId,
		com.liferay.portal.kernel.util.OrderByComparator<Resource>
			orderByComparator);

	/**
	 * Returns the last resource in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource
	 * @throws NoSuchResourceException if a matching resource could not be found
	 */
	public Resource findByChannelId_Last(
			long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<Resource>
				orderByComparator)
		throws NoSuchResourceException;

	/**
	 * Returns the last resource in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource, or <code>null</code> if a matching resource could not be found
	 */
	public Resource fetchByChannelId_Last(
		long channelId,
		com.liferay.portal.kernel.util.OrderByComparator<Resource>
			orderByComparator);

	/**
	 * Returns the resources before and after the current resource in the ordered set where channelId = &#63;.
	 *
	 * @param resourceId the primary key of the current resource
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource
	 * @throws NoSuchResourceException if a resource with the primary key could not be found
	 */
	public Resource[] findByChannelId_PrevAndNext(
			long resourceId, long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<Resource>
				orderByComparator)
		throws NoSuchResourceException;

	/**
	 * Removes all the resources where channelId = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 */
	public void removeByChannelId(long channelId);

	/**
	 * Returns the number of resources where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the number of matching resources
	 */
	public int countByChannelId(long channelId);

	/**
	 * Returns all the resources where resourceCode = &#63; and channelId = &#63;.
	 *
	 * @param resourceCode the resource code
	 * @param channelId the channel ID
	 * @return the matching resources
	 */
	public java.util.List<Resource> findByResourceCode(
		String resourceCode, long channelId);

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
	public java.util.List<Resource> findByResourceCode(
		String resourceCode, long channelId, int start, int end);

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
	public java.util.List<Resource> findByResourceCode(
		String resourceCode, long channelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Resource>
			orderByComparator);

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
	public java.util.List<Resource> findByResourceCode(
		String resourceCode, long channelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Resource>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first resource in the ordered set where resourceCode = &#63; and channelId = &#63;.
	 *
	 * @param resourceCode the resource code
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource
	 * @throws NoSuchResourceException if a matching resource could not be found
	 */
	public Resource findByResourceCode_First(
			String resourceCode, long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<Resource>
				orderByComparator)
		throws NoSuchResourceException;

	/**
	 * Returns the first resource in the ordered set where resourceCode = &#63; and channelId = &#63;.
	 *
	 * @param resourceCode the resource code
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource, or <code>null</code> if a matching resource could not be found
	 */
	public Resource fetchByResourceCode_First(
		String resourceCode, long channelId,
		com.liferay.portal.kernel.util.OrderByComparator<Resource>
			orderByComparator);

	/**
	 * Returns the last resource in the ordered set where resourceCode = &#63; and channelId = &#63;.
	 *
	 * @param resourceCode the resource code
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource
	 * @throws NoSuchResourceException if a matching resource could not be found
	 */
	public Resource findByResourceCode_Last(
			String resourceCode, long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<Resource>
				orderByComparator)
		throws NoSuchResourceException;

	/**
	 * Returns the last resource in the ordered set where resourceCode = &#63; and channelId = &#63;.
	 *
	 * @param resourceCode the resource code
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource, or <code>null</code> if a matching resource could not be found
	 */
	public Resource fetchByResourceCode_Last(
		String resourceCode, long channelId,
		com.liferay.portal.kernel.util.OrderByComparator<Resource>
			orderByComparator);

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
	public Resource[] findByResourceCode_PrevAndNext(
			long resourceId, String resourceCode, long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<Resource>
				orderByComparator)
		throws NoSuchResourceException;

	/**
	 * Removes all the resources where resourceCode = &#63; and channelId = &#63; from the database.
	 *
	 * @param resourceCode the resource code
	 * @param channelId the channel ID
	 */
	public void removeByResourceCode(String resourceCode, long channelId);

	/**
	 * Returns the number of resources where resourceCode = &#63; and channelId = &#63;.
	 *
	 * @param resourceCode the resource code
	 * @param channelId the channel ID
	 * @return the number of matching resources
	 */
	public int countByResourceCode(String resourceCode, long channelId);

	/**
	 * Returns all the resources where resourceType = &#63; and channelId = &#63;.
	 *
	 * @param resourceType the resource type
	 * @param channelId the channel ID
	 * @return the matching resources
	 */
	public java.util.List<Resource> findByResourceType(
		String resourceType, long channelId);

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
	public java.util.List<Resource> findByResourceType(
		String resourceType, long channelId, int start, int end);

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
	public java.util.List<Resource> findByResourceType(
		String resourceType, long channelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Resource>
			orderByComparator);

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
	public java.util.List<Resource> findByResourceType(
		String resourceType, long channelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Resource>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first resource in the ordered set where resourceType = &#63; and channelId = &#63;.
	 *
	 * @param resourceType the resource type
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource
	 * @throws NoSuchResourceException if a matching resource could not be found
	 */
	public Resource findByResourceType_First(
			String resourceType, long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<Resource>
				orderByComparator)
		throws NoSuchResourceException;

	/**
	 * Returns the first resource in the ordered set where resourceType = &#63; and channelId = &#63;.
	 *
	 * @param resourceType the resource type
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource, or <code>null</code> if a matching resource could not be found
	 */
	public Resource fetchByResourceType_First(
		String resourceType, long channelId,
		com.liferay.portal.kernel.util.OrderByComparator<Resource>
			orderByComparator);

	/**
	 * Returns the last resource in the ordered set where resourceType = &#63; and channelId = &#63;.
	 *
	 * @param resourceType the resource type
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource
	 * @throws NoSuchResourceException if a matching resource could not be found
	 */
	public Resource findByResourceType_Last(
			String resourceType, long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<Resource>
				orderByComparator)
		throws NoSuchResourceException;

	/**
	 * Returns the last resource in the ordered set where resourceType = &#63; and channelId = &#63;.
	 *
	 * @param resourceType the resource type
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource, or <code>null</code> if a matching resource could not be found
	 */
	public Resource fetchByResourceType_Last(
		String resourceType, long channelId,
		com.liferay.portal.kernel.util.OrderByComparator<Resource>
			orderByComparator);

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
	public Resource[] findByResourceType_PrevAndNext(
			long resourceId, String resourceType, long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<Resource>
				orderByComparator)
		throws NoSuchResourceException;

	/**
	 * Removes all the resources where resourceType = &#63; and channelId = &#63; from the database.
	 *
	 * @param resourceType the resource type
	 * @param channelId the channel ID
	 */
	public void removeByResourceType(String resourceType, long channelId);

	/**
	 * Returns the number of resources where resourceType = &#63; and channelId = &#63;.
	 *
	 * @param resourceType the resource type
	 * @param channelId the channel ID
	 * @return the number of matching resources
	 */
	public int countByResourceType(String resourceType, long channelId);

	/**
	 * Returns all the resources where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the matching resources
	 */
	public java.util.List<Resource> findByentityResourceId(
		long entityResourceId);

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
	public java.util.List<Resource> findByentityResourceId(
		long entityResourceId, int start, int end);

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
	public java.util.List<Resource> findByentityResourceId(
		long entityResourceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Resource>
			orderByComparator);

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
	public java.util.List<Resource> findByentityResourceId(
		long entityResourceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Resource>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first resource in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource
	 * @throws NoSuchResourceException if a matching resource could not be found
	 */
	public Resource findByentityResourceId_First(
			long entityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<Resource>
				orderByComparator)
		throws NoSuchResourceException;

	/**
	 * Returns the first resource in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource, or <code>null</code> if a matching resource could not be found
	 */
	public Resource fetchByentityResourceId_First(
		long entityResourceId,
		com.liferay.portal.kernel.util.OrderByComparator<Resource>
			orderByComparator);

	/**
	 * Returns the last resource in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource
	 * @throws NoSuchResourceException if a matching resource could not be found
	 */
	public Resource findByentityResourceId_Last(
			long entityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<Resource>
				orderByComparator)
		throws NoSuchResourceException;

	/**
	 * Returns the last resource in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource, or <code>null</code> if a matching resource could not be found
	 */
	public Resource fetchByentityResourceId_Last(
		long entityResourceId,
		com.liferay.portal.kernel.util.OrderByComparator<Resource>
			orderByComparator);

	/**
	 * Returns the resources before and after the current resource in the ordered set where entityResourceId = &#63;.
	 *
	 * @param resourceId the primary key of the current resource
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource
	 * @throws NoSuchResourceException if a resource with the primary key could not be found
	 */
	public Resource[] findByentityResourceId_PrevAndNext(
			long resourceId, long entityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<Resource>
				orderByComparator)
		throws NoSuchResourceException;

	/**
	 * Removes all the resources where entityResourceId = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 */
	public void removeByentityResourceId(long entityResourceId);

	/**
	 * Returns the number of resources where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the number of matching resources
	 */
	public int countByentityResourceId(long entityResourceId);

	/**
	 * Caches the resource in the entity cache if it is enabled.
	 *
	 * @param resource the resource
	 */
	public void cacheResult(Resource resource);

	/**
	 * Caches the resources in the entity cache if it is enabled.
	 *
	 * @param resources the resources
	 */
	public void cacheResult(java.util.List<Resource> resources);

	/**
	 * Creates a new resource with the primary key. Does not add the resource to the database.
	 *
	 * @param resourceId the primary key for the new resource
	 * @return the new resource
	 */
	public Resource create(long resourceId);

	/**
	 * Removes the resource with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param resourceId the primary key of the resource
	 * @return the resource that was removed
	 * @throws NoSuchResourceException if a resource with the primary key could not be found
	 */
	public Resource remove(long resourceId) throws NoSuchResourceException;

	public Resource updateImpl(Resource resource);

	/**
	 * Returns the resource with the primary key or throws a <code>NoSuchResourceException</code> if it could not be found.
	 *
	 * @param resourceId the primary key of the resource
	 * @return the resource
	 * @throws NoSuchResourceException if a resource with the primary key could not be found
	 */
	public Resource findByPrimaryKey(long resourceId)
		throws NoSuchResourceException;

	/**
	 * Returns the resource with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param resourceId the primary key of the resource
	 * @return the resource, or <code>null</code> if a resource with the primary key could not be found
	 */
	public Resource fetchByPrimaryKey(long resourceId);

	/**
	 * Returns all the resources.
	 *
	 * @return the resources
	 */
	public java.util.List<Resource> findAll();

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
	public java.util.List<Resource> findAll(int start, int end);

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
	public java.util.List<Resource> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Resource>
			orderByComparator);

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
	public java.util.List<Resource> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Resource>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the resources from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of resources.
	 *
	 * @return the number of resources
	 */
	public int countAll();

}