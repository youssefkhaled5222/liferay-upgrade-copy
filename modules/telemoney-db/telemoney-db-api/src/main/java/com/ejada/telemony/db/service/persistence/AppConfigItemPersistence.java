/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.exception.NoSuchAppConfigItemException;
import com.ejada.telemony.db.model.AppConfigItem;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the app config item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppConfigItemUtil
 * @generated
 */
@ProviderType
public interface AppConfigItemPersistence
	extends BasePersistence<AppConfigItem> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AppConfigItemUtil} to access the app config item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the app config items where environmentId = &#63;.
	 *
	 * @param environmentId the environment ID
	 * @return the matching app config items
	 */
	public java.util.List<AppConfigItem> findByenvironmentId(
		long environmentId);

	/**
	 * Returns a range of all the app config items where environmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppConfigItemModelImpl</code>.
	 * </p>
	 *
	 * @param environmentId the environment ID
	 * @param start the lower bound of the range of app config items
	 * @param end the upper bound of the range of app config items (not inclusive)
	 * @return the range of matching app config items
	 */
	public java.util.List<AppConfigItem> findByenvironmentId(
		long environmentId, int start, int end);

	/**
	 * Returns an ordered range of all the app config items where environmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppConfigItemModelImpl</code>.
	 * </p>
	 *
	 * @param environmentId the environment ID
	 * @param start the lower bound of the range of app config items
	 * @param end the upper bound of the range of app config items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching app config items
	 */
	public java.util.List<AppConfigItem> findByenvironmentId(
		long environmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppConfigItem>
			orderByComparator);

	/**
	 * Returns an ordered range of all the app config items where environmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppConfigItemModelImpl</code>.
	 * </p>
	 *
	 * @param environmentId the environment ID
	 * @param start the lower bound of the range of app config items
	 * @param end the upper bound of the range of app config items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching app config items
	 */
	public java.util.List<AppConfigItem> findByenvironmentId(
		long environmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppConfigItem>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first app config item in the ordered set where environmentId = &#63;.
	 *
	 * @param environmentId the environment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app config item
	 * @throws NoSuchAppConfigItemException if a matching app config item could not be found
	 */
	public AppConfigItem findByenvironmentId_First(
			long environmentId,
			com.liferay.portal.kernel.util.OrderByComparator<AppConfigItem>
				orderByComparator)
		throws NoSuchAppConfigItemException;

	/**
	 * Returns the first app config item in the ordered set where environmentId = &#63;.
	 *
	 * @param environmentId the environment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app config item, or <code>null</code> if a matching app config item could not be found
	 */
	public AppConfigItem fetchByenvironmentId_First(
		long environmentId,
		com.liferay.portal.kernel.util.OrderByComparator<AppConfigItem>
			orderByComparator);

	/**
	 * Returns the last app config item in the ordered set where environmentId = &#63;.
	 *
	 * @param environmentId the environment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app config item
	 * @throws NoSuchAppConfigItemException if a matching app config item could not be found
	 */
	public AppConfigItem findByenvironmentId_Last(
			long environmentId,
			com.liferay.portal.kernel.util.OrderByComparator<AppConfigItem>
				orderByComparator)
		throws NoSuchAppConfigItemException;

	/**
	 * Returns the last app config item in the ordered set where environmentId = &#63;.
	 *
	 * @param environmentId the environment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app config item, or <code>null</code> if a matching app config item could not be found
	 */
	public AppConfigItem fetchByenvironmentId_Last(
		long environmentId,
		com.liferay.portal.kernel.util.OrderByComparator<AppConfigItem>
			orderByComparator);

	/**
	 * Returns the app config items before and after the current app config item in the ordered set where environmentId = &#63;.
	 *
	 * @param configItemId the primary key of the current app config item
	 * @param environmentId the environment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app config item
	 * @throws NoSuchAppConfigItemException if a app config item with the primary key could not be found
	 */
	public AppConfigItem[] findByenvironmentId_PrevAndNext(
			long configItemId, long environmentId,
			com.liferay.portal.kernel.util.OrderByComparator<AppConfigItem>
				orderByComparator)
		throws NoSuchAppConfigItemException;

	/**
	 * Removes all the app config items where environmentId = &#63; from the database.
	 *
	 * @param environmentId the environment ID
	 */
	public void removeByenvironmentId(long environmentId);

	/**
	 * Returns the number of app config items where environmentId = &#63;.
	 *
	 * @param environmentId the environment ID
	 * @return the number of matching app config items
	 */
	public int countByenvironmentId(long environmentId);

	/**
	 * Caches the app config item in the entity cache if it is enabled.
	 *
	 * @param appConfigItem the app config item
	 */
	public void cacheResult(AppConfigItem appConfigItem);

	/**
	 * Caches the app config items in the entity cache if it is enabled.
	 *
	 * @param appConfigItems the app config items
	 */
	public void cacheResult(java.util.List<AppConfigItem> appConfigItems);

	/**
	 * Creates a new app config item with the primary key. Does not add the app config item to the database.
	 *
	 * @param configItemId the primary key for the new app config item
	 * @return the new app config item
	 */
	public AppConfigItem create(long configItemId);

	/**
	 * Removes the app config item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param configItemId the primary key of the app config item
	 * @return the app config item that was removed
	 * @throws NoSuchAppConfigItemException if a app config item with the primary key could not be found
	 */
	public AppConfigItem remove(long configItemId)
		throws NoSuchAppConfigItemException;

	public AppConfigItem updateImpl(AppConfigItem appConfigItem);

	/**
	 * Returns the app config item with the primary key or throws a <code>NoSuchAppConfigItemException</code> if it could not be found.
	 *
	 * @param configItemId the primary key of the app config item
	 * @return the app config item
	 * @throws NoSuchAppConfigItemException if a app config item with the primary key could not be found
	 */
	public AppConfigItem findByPrimaryKey(long configItemId)
		throws NoSuchAppConfigItemException;

	/**
	 * Returns the app config item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param configItemId the primary key of the app config item
	 * @return the app config item, or <code>null</code> if a app config item with the primary key could not be found
	 */
	public AppConfigItem fetchByPrimaryKey(long configItemId);

	/**
	 * Returns all the app config items.
	 *
	 * @return the app config items
	 */
	public java.util.List<AppConfigItem> findAll();

	/**
	 * Returns a range of all the app config items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppConfigItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app config items
	 * @param end the upper bound of the range of app config items (not inclusive)
	 * @return the range of app config items
	 */
	public java.util.List<AppConfigItem> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the app config items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppConfigItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app config items
	 * @param end the upper bound of the range of app config items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of app config items
	 */
	public java.util.List<AppConfigItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppConfigItem>
			orderByComparator);

	/**
	 * Returns an ordered range of all the app config items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppConfigItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app config items
	 * @param end the upper bound of the range of app config items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of app config items
	 */
	public java.util.List<AppConfigItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppConfigItem>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the app config items from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of app config items.
	 *
	 * @return the number of app config items
	 */
	public int countAll();

}