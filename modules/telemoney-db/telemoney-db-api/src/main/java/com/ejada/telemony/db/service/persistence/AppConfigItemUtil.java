/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.model.AppConfigItem;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the app config item service. This utility wraps <code>com.ejada.telemony.db.service.persistence.impl.AppConfigItemPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppConfigItemPersistence
 * @generated
 */
public class AppConfigItemUtil {

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
	public static void clearCache(AppConfigItem appConfigItem) {
		getPersistence().clearCache(appConfigItem);
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
	public static Map<Serializable, AppConfigItem> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AppConfigItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AppConfigItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AppConfigItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AppConfigItem> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AppConfigItem update(AppConfigItem appConfigItem) {
		return getPersistence().update(appConfigItem);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AppConfigItem update(
		AppConfigItem appConfigItem, ServiceContext serviceContext) {

		return getPersistence().update(appConfigItem, serviceContext);
	}

	/**
	 * Returns all the app config items where environmentId = &#63;.
	 *
	 * @param environmentId the environment ID
	 * @return the matching app config items
	 */
	public static List<AppConfigItem> findByenvironmentId(long environmentId) {
		return getPersistence().findByenvironmentId(environmentId);
	}

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
	public static List<AppConfigItem> findByenvironmentId(
		long environmentId, int start, int end) {

		return getPersistence().findByenvironmentId(environmentId, start, end);
	}

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
	public static List<AppConfigItem> findByenvironmentId(
		long environmentId, int start, int end,
		OrderByComparator<AppConfigItem> orderByComparator) {

		return getPersistence().findByenvironmentId(
			environmentId, start, end, orderByComparator);
	}

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
	public static List<AppConfigItem> findByenvironmentId(
		long environmentId, int start, int end,
		OrderByComparator<AppConfigItem> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByenvironmentId(
			environmentId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first app config item in the ordered set where environmentId = &#63;.
	 *
	 * @param environmentId the environment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app config item
	 * @throws NoSuchAppConfigItemException if a matching app config item could not be found
	 */
	public static AppConfigItem findByenvironmentId_First(
			long environmentId,
			OrderByComparator<AppConfigItem> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchAppConfigItemException {

		return getPersistence().findByenvironmentId_First(
			environmentId, orderByComparator);
	}

	/**
	 * Returns the first app config item in the ordered set where environmentId = &#63;.
	 *
	 * @param environmentId the environment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app config item, or <code>null</code> if a matching app config item could not be found
	 */
	public static AppConfigItem fetchByenvironmentId_First(
		long environmentId,
		OrderByComparator<AppConfigItem> orderByComparator) {

		return getPersistence().fetchByenvironmentId_First(
			environmentId, orderByComparator);
	}

	/**
	 * Returns the last app config item in the ordered set where environmentId = &#63;.
	 *
	 * @param environmentId the environment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app config item
	 * @throws NoSuchAppConfigItemException if a matching app config item could not be found
	 */
	public static AppConfigItem findByenvironmentId_Last(
			long environmentId,
			OrderByComparator<AppConfigItem> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchAppConfigItemException {

		return getPersistence().findByenvironmentId_Last(
			environmentId, orderByComparator);
	}

	/**
	 * Returns the last app config item in the ordered set where environmentId = &#63;.
	 *
	 * @param environmentId the environment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app config item, or <code>null</code> if a matching app config item could not be found
	 */
	public static AppConfigItem fetchByenvironmentId_Last(
		long environmentId,
		OrderByComparator<AppConfigItem> orderByComparator) {

		return getPersistence().fetchByenvironmentId_Last(
			environmentId, orderByComparator);
	}

	/**
	 * Returns the app config items before and after the current app config item in the ordered set where environmentId = &#63;.
	 *
	 * @param configItemId the primary key of the current app config item
	 * @param environmentId the environment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app config item
	 * @throws NoSuchAppConfigItemException if a app config item with the primary key could not be found
	 */
	public static AppConfigItem[] findByenvironmentId_PrevAndNext(
			long configItemId, long environmentId,
			OrderByComparator<AppConfigItem> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchAppConfigItemException {

		return getPersistence().findByenvironmentId_PrevAndNext(
			configItemId, environmentId, orderByComparator);
	}

	/**
	 * Removes all the app config items where environmentId = &#63; from the database.
	 *
	 * @param environmentId the environment ID
	 */
	public static void removeByenvironmentId(long environmentId) {
		getPersistence().removeByenvironmentId(environmentId);
	}

	/**
	 * Returns the number of app config items where environmentId = &#63;.
	 *
	 * @param environmentId the environment ID
	 * @return the number of matching app config items
	 */
	public static int countByenvironmentId(long environmentId) {
		return getPersistence().countByenvironmentId(environmentId);
	}

	/**
	 * Caches the app config item in the entity cache if it is enabled.
	 *
	 * @param appConfigItem the app config item
	 */
	public static void cacheResult(AppConfigItem appConfigItem) {
		getPersistence().cacheResult(appConfigItem);
	}

	/**
	 * Caches the app config items in the entity cache if it is enabled.
	 *
	 * @param appConfigItems the app config items
	 */
	public static void cacheResult(List<AppConfigItem> appConfigItems) {
		getPersistence().cacheResult(appConfigItems);
	}

	/**
	 * Creates a new app config item with the primary key. Does not add the app config item to the database.
	 *
	 * @param configItemId the primary key for the new app config item
	 * @return the new app config item
	 */
	public static AppConfigItem create(long configItemId) {
		return getPersistence().create(configItemId);
	}

	/**
	 * Removes the app config item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param configItemId the primary key of the app config item
	 * @return the app config item that was removed
	 * @throws NoSuchAppConfigItemException if a app config item with the primary key could not be found
	 */
	public static AppConfigItem remove(long configItemId)
		throws com.ejada.telemony.db.exception.NoSuchAppConfigItemException {

		return getPersistence().remove(configItemId);
	}

	public static AppConfigItem updateImpl(AppConfigItem appConfigItem) {
		return getPersistence().updateImpl(appConfigItem);
	}

	/**
	 * Returns the app config item with the primary key or throws a <code>NoSuchAppConfigItemException</code> if it could not be found.
	 *
	 * @param configItemId the primary key of the app config item
	 * @return the app config item
	 * @throws NoSuchAppConfigItemException if a app config item with the primary key could not be found
	 */
	public static AppConfigItem findByPrimaryKey(long configItemId)
		throws com.ejada.telemony.db.exception.NoSuchAppConfigItemException {

		return getPersistence().findByPrimaryKey(configItemId);
	}

	/**
	 * Returns the app config item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param configItemId the primary key of the app config item
	 * @return the app config item, or <code>null</code> if a app config item with the primary key could not be found
	 */
	public static AppConfigItem fetchByPrimaryKey(long configItemId) {
		return getPersistence().fetchByPrimaryKey(configItemId);
	}

	/**
	 * Returns all the app config items.
	 *
	 * @return the app config items
	 */
	public static List<AppConfigItem> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<AppConfigItem> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<AppConfigItem> findAll(
		int start, int end,
		OrderByComparator<AppConfigItem> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<AppConfigItem> findAll(
		int start, int end, OrderByComparator<AppConfigItem> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the app config items from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of app config items.
	 *
	 * @return the number of app config items
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AppConfigItemPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(AppConfigItemPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile AppConfigItemPersistence _persistence;

}