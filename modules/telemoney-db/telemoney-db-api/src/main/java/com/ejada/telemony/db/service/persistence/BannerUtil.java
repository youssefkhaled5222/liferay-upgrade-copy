/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.model.Banner;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the banner service. This utility wraps <code>com.ejada.telemony.db.service.persistence.impl.BannerPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BannerPersistence
 * @generated
 */
public class BannerUtil {

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
	public static void clearCache(Banner banner) {
		getPersistence().clearCache(banner);
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
	public static Map<Serializable, Banner> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Banner> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Banner> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Banner> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Banner> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Banner update(Banner banner) {
		return getPersistence().update(banner);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Banner update(Banner banner, ServiceContext serviceContext) {
		return getPersistence().update(banner, serviceContext);
	}

	/**
	 * Returns all the banners where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @return the matching banners
	 */
	public static List<Banner> findByChannelIdAndStatus(
		long channelId, int status) {

		return getPersistence().findByChannelIdAndStatus(channelId, status);
	}

	/**
	 * Returns a range of all the banners where channelId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param start the lower bound of the range of banners
	 * @param end the upper bound of the range of banners (not inclusive)
	 * @return the range of matching banners
	 */
	public static List<Banner> findByChannelIdAndStatus(
		long channelId, int status, int start, int end) {

		return getPersistence().findByChannelIdAndStatus(
			channelId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the banners where channelId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param start the lower bound of the range of banners
	 * @param end the upper bound of the range of banners (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching banners
	 */
	public static List<Banner> findByChannelIdAndStatus(
		long channelId, int status, int start, int end,
		OrderByComparator<Banner> orderByComparator) {

		return getPersistence().findByChannelIdAndStatus(
			channelId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the banners where channelId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param start the lower bound of the range of banners
	 * @param end the upper bound of the range of banners (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching banners
	 */
	public static List<Banner> findByChannelIdAndStatus(
		long channelId, int status, int start, int end,
		OrderByComparator<Banner> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByChannelIdAndStatus(
			channelId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first banner in the ordered set where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner
	 * @throws NoSuchBannerException if a matching banner could not be found
	 */
	public static Banner findByChannelIdAndStatus_First(
			long channelId, int status,
			OrderByComparator<Banner> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchBannerException {

		return getPersistence().findByChannelIdAndStatus_First(
			channelId, status, orderByComparator);
	}

	/**
	 * Returns the first banner in the ordered set where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner, or <code>null</code> if a matching banner could not be found
	 */
	public static Banner fetchByChannelIdAndStatus_First(
		long channelId, int status,
		OrderByComparator<Banner> orderByComparator) {

		return getPersistence().fetchByChannelIdAndStatus_First(
			channelId, status, orderByComparator);
	}

	/**
	 * Returns the last banner in the ordered set where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner
	 * @throws NoSuchBannerException if a matching banner could not be found
	 */
	public static Banner findByChannelIdAndStatus_Last(
			long channelId, int status,
			OrderByComparator<Banner> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchBannerException {

		return getPersistence().findByChannelIdAndStatus_Last(
			channelId, status, orderByComparator);
	}

	/**
	 * Returns the last banner in the ordered set where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner, or <code>null</code> if a matching banner could not be found
	 */
	public static Banner fetchByChannelIdAndStatus_Last(
		long channelId, int status,
		OrderByComparator<Banner> orderByComparator) {

		return getPersistence().fetchByChannelIdAndStatus_Last(
			channelId, status, orderByComparator);
	}

	/**
	 * Returns the banners before and after the current banner in the ordered set where channelId = &#63; and status = &#63;.
	 *
	 * @param bannerId the primary key of the current banner
	 * @param channelId the channel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next banner
	 * @throws NoSuchBannerException if a banner with the primary key could not be found
	 */
	public static Banner[] findByChannelIdAndStatus_PrevAndNext(
			long bannerId, long channelId, int status,
			OrderByComparator<Banner> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchBannerException {

		return getPersistence().findByChannelIdAndStatus_PrevAndNext(
			bannerId, channelId, status, orderByComparator);
	}

	/**
	 * Removes all the banners where channelId = &#63; and status = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 */
	public static void removeByChannelIdAndStatus(long channelId, int status) {
		getPersistence().removeByChannelIdAndStatus(channelId, status);
	}

	/**
	 * Returns the number of banners where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @return the number of matching banners
	 */
	public static int countByChannelIdAndStatus(long channelId, int status) {
		return getPersistence().countByChannelIdAndStatus(channelId, status);
	}

	/**
	 * Returns all the banners where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the matching banners
	 */
	public static List<Banner> findByEntityResourceId(long entityResourceId) {
		return getPersistence().findByEntityResourceId(entityResourceId);
	}

	/**
	 * Returns a range of all the banners where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of banners
	 * @param end the upper bound of the range of banners (not inclusive)
	 * @return the range of matching banners
	 */
	public static List<Banner> findByEntityResourceId(
		long entityResourceId, int start, int end) {

		return getPersistence().findByEntityResourceId(
			entityResourceId, start, end);
	}

	/**
	 * Returns an ordered range of all the banners where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of banners
	 * @param end the upper bound of the range of banners (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching banners
	 */
	public static List<Banner> findByEntityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<Banner> orderByComparator) {

		return getPersistence().findByEntityResourceId(
			entityResourceId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the banners where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of banners
	 * @param end the upper bound of the range of banners (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching banners
	 */
	public static List<Banner> findByEntityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<Banner> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByEntityResourceId(
			entityResourceId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first banner in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner
	 * @throws NoSuchBannerException if a matching banner could not be found
	 */
	public static Banner findByEntityResourceId_First(
			long entityResourceId, OrderByComparator<Banner> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchBannerException {

		return getPersistence().findByEntityResourceId_First(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the first banner in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner, or <code>null</code> if a matching banner could not be found
	 */
	public static Banner fetchByEntityResourceId_First(
		long entityResourceId, OrderByComparator<Banner> orderByComparator) {

		return getPersistence().fetchByEntityResourceId_First(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the last banner in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner
	 * @throws NoSuchBannerException if a matching banner could not be found
	 */
	public static Banner findByEntityResourceId_Last(
			long entityResourceId, OrderByComparator<Banner> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchBannerException {

		return getPersistence().findByEntityResourceId_Last(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the last banner in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner, or <code>null</code> if a matching banner could not be found
	 */
	public static Banner fetchByEntityResourceId_Last(
		long entityResourceId, OrderByComparator<Banner> orderByComparator) {

		return getPersistence().fetchByEntityResourceId_Last(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the banners before and after the current banner in the ordered set where entityResourceId = &#63;.
	 *
	 * @param bannerId the primary key of the current banner
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next banner
	 * @throws NoSuchBannerException if a banner with the primary key could not be found
	 */
	public static Banner[] findByEntityResourceId_PrevAndNext(
			long bannerId, long entityResourceId,
			OrderByComparator<Banner> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchBannerException {

		return getPersistence().findByEntityResourceId_PrevAndNext(
			bannerId, entityResourceId, orderByComparator);
	}

	/**
	 * Removes all the banners where entityResourceId = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 */
	public static void removeByEntityResourceId(long entityResourceId) {
		getPersistence().removeByEntityResourceId(entityResourceId);
	}

	/**
	 * Returns the number of banners where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the number of matching banners
	 */
	public static int countByEntityResourceId(long entityResourceId) {
		return getPersistence().countByEntityResourceId(entityResourceId);
	}

	/**
	 * Caches the banner in the entity cache if it is enabled.
	 *
	 * @param banner the banner
	 */
	public static void cacheResult(Banner banner) {
		getPersistence().cacheResult(banner);
	}

	/**
	 * Caches the banners in the entity cache if it is enabled.
	 *
	 * @param banners the banners
	 */
	public static void cacheResult(List<Banner> banners) {
		getPersistence().cacheResult(banners);
	}

	/**
	 * Creates a new banner with the primary key. Does not add the banner to the database.
	 *
	 * @param bannerId the primary key for the new banner
	 * @return the new banner
	 */
	public static Banner create(long bannerId) {
		return getPersistence().create(bannerId);
	}

	/**
	 * Removes the banner with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bannerId the primary key of the banner
	 * @return the banner that was removed
	 * @throws NoSuchBannerException if a banner with the primary key could not be found
	 */
	public static Banner remove(long bannerId)
		throws com.ejada.telemony.db.exception.NoSuchBannerException {

		return getPersistence().remove(bannerId);
	}

	public static Banner updateImpl(Banner banner) {
		return getPersistence().updateImpl(banner);
	}

	/**
	 * Returns the banner with the primary key or throws a <code>NoSuchBannerException</code> if it could not be found.
	 *
	 * @param bannerId the primary key of the banner
	 * @return the banner
	 * @throws NoSuchBannerException if a banner with the primary key could not be found
	 */
	public static Banner findByPrimaryKey(long bannerId)
		throws com.ejada.telemony.db.exception.NoSuchBannerException {

		return getPersistence().findByPrimaryKey(bannerId);
	}

	/**
	 * Returns the banner with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bannerId the primary key of the banner
	 * @return the banner, or <code>null</code> if a banner with the primary key could not be found
	 */
	public static Banner fetchByPrimaryKey(long bannerId) {
		return getPersistence().fetchByPrimaryKey(bannerId);
	}

	/**
	 * Returns all the banners.
	 *
	 * @return the banners
	 */
	public static List<Banner> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the banners.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of banners
	 * @param end the upper bound of the range of banners (not inclusive)
	 * @return the range of banners
	 */
	public static List<Banner> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the banners.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of banners
	 * @param end the upper bound of the range of banners (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of banners
	 */
	public static List<Banner> findAll(
		int start, int end, OrderByComparator<Banner> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the banners.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of banners
	 * @param end the upper bound of the range of banners (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of banners
	 */
	public static List<Banner> findAll(
		int start, int end, OrderByComparator<Banner> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the banners from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of banners.
	 *
	 * @return the number of banners
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BannerPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(BannerPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile BannerPersistence _persistence;

}