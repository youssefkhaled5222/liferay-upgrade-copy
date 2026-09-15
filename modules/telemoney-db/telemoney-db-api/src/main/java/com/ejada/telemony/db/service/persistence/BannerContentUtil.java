/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.model.BannerContent;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the banner content service. This utility wraps <code>com.ejada.telemony.db.service.persistence.impl.BannerContentPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BannerContentPersistence
 * @generated
 */
public class BannerContentUtil {

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
	public static void clearCache(BannerContent bannerContent) {
		getPersistence().clearCache(bannerContent);
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
	public static Map<Serializable, BannerContent> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<BannerContent> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BannerContent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BannerContent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BannerContent> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BannerContent update(BannerContent bannerContent) {
		return getPersistence().update(bannerContent);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BannerContent update(
		BannerContent bannerContent, ServiceContext serviceContext) {

		return getPersistence().update(bannerContent, serviceContext);
	}

	/**
	 * Returns all the banner contents where bannerId = &#63;.
	 *
	 * @param bannerId the banner ID
	 * @return the matching banner contents
	 */
	public static List<BannerContent> findByBannerId(long bannerId) {
		return getPersistence().findByBannerId(bannerId);
	}

	/**
	 * Returns a range of all the banner contents where bannerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param bannerId the banner ID
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @return the range of matching banner contents
	 */
	public static List<BannerContent> findByBannerId(
		long bannerId, int start, int end) {

		return getPersistence().findByBannerId(bannerId, start, end);
	}

	/**
	 * Returns an ordered range of all the banner contents where bannerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param bannerId the banner ID
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching banner contents
	 */
	public static List<BannerContent> findByBannerId(
		long bannerId, int start, int end,
		OrderByComparator<BannerContent> orderByComparator) {

		return getPersistence().findByBannerId(
			bannerId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the banner contents where bannerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param bannerId the banner ID
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching banner contents
	 */
	public static List<BannerContent> findByBannerId(
		long bannerId, int start, int end,
		OrderByComparator<BannerContent> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByBannerId(
			bannerId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first banner content in the ordered set where bannerId = &#63;.
	 *
	 * @param bannerId the banner ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner content
	 * @throws NoSuchBannerContentException if a matching banner content could not be found
	 */
	public static BannerContent findByBannerId_First(
			long bannerId, OrderByComparator<BannerContent> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchBannerContentException {

		return getPersistence().findByBannerId_First(
			bannerId, orderByComparator);
	}

	/**
	 * Returns the first banner content in the ordered set where bannerId = &#63;.
	 *
	 * @param bannerId the banner ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner content, or <code>null</code> if a matching banner content could not be found
	 */
	public static BannerContent fetchByBannerId_First(
		long bannerId, OrderByComparator<BannerContent> orderByComparator) {

		return getPersistence().fetchByBannerId_First(
			bannerId, orderByComparator);
	}

	/**
	 * Returns the last banner content in the ordered set where bannerId = &#63;.
	 *
	 * @param bannerId the banner ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner content
	 * @throws NoSuchBannerContentException if a matching banner content could not be found
	 */
	public static BannerContent findByBannerId_Last(
			long bannerId, OrderByComparator<BannerContent> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchBannerContentException {

		return getPersistence().findByBannerId_Last(
			bannerId, orderByComparator);
	}

	/**
	 * Returns the last banner content in the ordered set where bannerId = &#63;.
	 *
	 * @param bannerId the banner ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner content, or <code>null</code> if a matching banner content could not be found
	 */
	public static BannerContent fetchByBannerId_Last(
		long bannerId, OrderByComparator<BannerContent> orderByComparator) {

		return getPersistence().fetchByBannerId_Last(
			bannerId, orderByComparator);
	}

	/**
	 * Returns the banner contents before and after the current banner content in the ordered set where bannerId = &#63;.
	 *
	 * @param contentId the primary key of the current banner content
	 * @param bannerId the banner ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next banner content
	 * @throws NoSuchBannerContentException if a banner content with the primary key could not be found
	 */
	public static BannerContent[] findByBannerId_PrevAndNext(
			long contentId, long bannerId,
			OrderByComparator<BannerContent> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchBannerContentException {

		return getPersistence().findByBannerId_PrevAndNext(
			contentId, bannerId, orderByComparator);
	}

	/**
	 * Removes all the banner contents where bannerId = &#63; from the database.
	 *
	 * @param bannerId the banner ID
	 */
	public static void removeByBannerId(long bannerId) {
		getPersistence().removeByBannerId(bannerId);
	}

	/**
	 * Returns the number of banner contents where bannerId = &#63;.
	 *
	 * @param bannerId the banner ID
	 * @return the number of matching banner contents
	 */
	public static int countByBannerId(long bannerId) {
		return getPersistence().countByBannerId(bannerId);
	}

	/**
	 * Returns all the banner contents where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the matching banner contents
	 */
	public static List<BannerContent> findByEntityResourceId(
		long entityResourceId) {

		return getPersistence().findByEntityResourceId(entityResourceId);
	}

	/**
	 * Returns a range of all the banner contents where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @return the range of matching banner contents
	 */
	public static List<BannerContent> findByEntityResourceId(
		long entityResourceId, int start, int end) {

		return getPersistence().findByEntityResourceId(
			entityResourceId, start, end);
	}

	/**
	 * Returns an ordered range of all the banner contents where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching banner contents
	 */
	public static List<BannerContent> findByEntityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<BannerContent> orderByComparator) {

		return getPersistence().findByEntityResourceId(
			entityResourceId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the banner contents where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching banner contents
	 */
	public static List<BannerContent> findByEntityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<BannerContent> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEntityResourceId(
			entityResourceId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first banner content in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner content
	 * @throws NoSuchBannerContentException if a matching banner content could not be found
	 */
	public static BannerContent findByEntityResourceId_First(
			long entityResourceId,
			OrderByComparator<BannerContent> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchBannerContentException {

		return getPersistence().findByEntityResourceId_First(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the first banner content in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner content, or <code>null</code> if a matching banner content could not be found
	 */
	public static BannerContent fetchByEntityResourceId_First(
		long entityResourceId,
		OrderByComparator<BannerContent> orderByComparator) {

		return getPersistence().fetchByEntityResourceId_First(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the last banner content in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner content
	 * @throws NoSuchBannerContentException if a matching banner content could not be found
	 */
	public static BannerContent findByEntityResourceId_Last(
			long entityResourceId,
			OrderByComparator<BannerContent> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchBannerContentException {

		return getPersistence().findByEntityResourceId_Last(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the last banner content in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner content, or <code>null</code> if a matching banner content could not be found
	 */
	public static BannerContent fetchByEntityResourceId_Last(
		long entityResourceId,
		OrderByComparator<BannerContent> orderByComparator) {

		return getPersistence().fetchByEntityResourceId_Last(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the banner contents before and after the current banner content in the ordered set where entityResourceId = &#63;.
	 *
	 * @param contentId the primary key of the current banner content
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next banner content
	 * @throws NoSuchBannerContentException if a banner content with the primary key could not be found
	 */
	public static BannerContent[] findByEntityResourceId_PrevAndNext(
			long contentId, long entityResourceId,
			OrderByComparator<BannerContent> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchBannerContentException {

		return getPersistence().findByEntityResourceId_PrevAndNext(
			contentId, entityResourceId, orderByComparator);
	}

	/**
	 * Removes all the banner contents where entityResourceId = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 */
	public static void removeByEntityResourceId(long entityResourceId) {
		getPersistence().removeByEntityResourceId(entityResourceId);
	}

	/**
	 * Returns the number of banner contents where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the number of matching banner contents
	 */
	public static int countByEntityResourceId(long entityResourceId) {
		return getPersistence().countByEntityResourceId(entityResourceId);
	}

	/**
	 * Returns all the banner contents where bannerId = &#63; and status = &#63;.
	 *
	 * @param bannerId the banner ID
	 * @param status the status
	 * @return the matching banner contents
	 */
	public static List<BannerContent> findByBannerIdAndStatus(
		long bannerId, int status) {

		return getPersistence().findByBannerIdAndStatus(bannerId, status);
	}

	/**
	 * Returns a range of all the banner contents where bannerId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param bannerId the banner ID
	 * @param status the status
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @return the range of matching banner contents
	 */
	public static List<BannerContent> findByBannerIdAndStatus(
		long bannerId, int status, int start, int end) {

		return getPersistence().findByBannerIdAndStatus(
			bannerId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the banner contents where bannerId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param bannerId the banner ID
	 * @param status the status
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching banner contents
	 */
	public static List<BannerContent> findByBannerIdAndStatus(
		long bannerId, int status, int start, int end,
		OrderByComparator<BannerContent> orderByComparator) {

		return getPersistence().findByBannerIdAndStatus(
			bannerId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the banner contents where bannerId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param bannerId the banner ID
	 * @param status the status
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching banner contents
	 */
	public static List<BannerContent> findByBannerIdAndStatus(
		long bannerId, int status, int start, int end,
		OrderByComparator<BannerContent> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByBannerIdAndStatus(
			bannerId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first banner content in the ordered set where bannerId = &#63; and status = &#63;.
	 *
	 * @param bannerId the banner ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner content
	 * @throws NoSuchBannerContentException if a matching banner content could not be found
	 */
	public static BannerContent findByBannerIdAndStatus_First(
			long bannerId, int status,
			OrderByComparator<BannerContent> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchBannerContentException {

		return getPersistence().findByBannerIdAndStatus_First(
			bannerId, status, orderByComparator);
	}

	/**
	 * Returns the first banner content in the ordered set where bannerId = &#63; and status = &#63;.
	 *
	 * @param bannerId the banner ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner content, or <code>null</code> if a matching banner content could not be found
	 */
	public static BannerContent fetchByBannerIdAndStatus_First(
		long bannerId, int status,
		OrderByComparator<BannerContent> orderByComparator) {

		return getPersistence().fetchByBannerIdAndStatus_First(
			bannerId, status, orderByComparator);
	}

	/**
	 * Returns the last banner content in the ordered set where bannerId = &#63; and status = &#63;.
	 *
	 * @param bannerId the banner ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner content
	 * @throws NoSuchBannerContentException if a matching banner content could not be found
	 */
	public static BannerContent findByBannerIdAndStatus_Last(
			long bannerId, int status,
			OrderByComparator<BannerContent> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchBannerContentException {

		return getPersistence().findByBannerIdAndStatus_Last(
			bannerId, status, orderByComparator);
	}

	/**
	 * Returns the last banner content in the ordered set where bannerId = &#63; and status = &#63;.
	 *
	 * @param bannerId the banner ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner content, or <code>null</code> if a matching banner content could not be found
	 */
	public static BannerContent fetchByBannerIdAndStatus_Last(
		long bannerId, int status,
		OrderByComparator<BannerContent> orderByComparator) {

		return getPersistence().fetchByBannerIdAndStatus_Last(
			bannerId, status, orderByComparator);
	}

	/**
	 * Returns the banner contents before and after the current banner content in the ordered set where bannerId = &#63; and status = &#63;.
	 *
	 * @param contentId the primary key of the current banner content
	 * @param bannerId the banner ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next banner content
	 * @throws NoSuchBannerContentException if a banner content with the primary key could not be found
	 */
	public static BannerContent[] findByBannerIdAndStatus_PrevAndNext(
			long contentId, long bannerId, int status,
			OrderByComparator<BannerContent> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchBannerContentException {

		return getPersistence().findByBannerIdAndStatus_PrevAndNext(
			contentId, bannerId, status, orderByComparator);
	}

	/**
	 * Removes all the banner contents where bannerId = &#63; and status = &#63; from the database.
	 *
	 * @param bannerId the banner ID
	 * @param status the status
	 */
	public static void removeByBannerIdAndStatus(long bannerId, int status) {
		getPersistence().removeByBannerIdAndStatus(bannerId, status);
	}

	/**
	 * Returns the number of banner contents where bannerId = &#63; and status = &#63;.
	 *
	 * @param bannerId the banner ID
	 * @param status the status
	 * @return the number of matching banner contents
	 */
	public static int countByBannerIdAndStatus(long bannerId, int status) {
		return getPersistence().countByBannerIdAndStatus(bannerId, status);
	}

	/**
	 * Returns all the banner contents where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the matching banner contents
	 */
	public static List<BannerContent> findByChannelId(long channelId) {
		return getPersistence().findByChannelId(channelId);
	}

	/**
	 * Returns a range of all the banner contents where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @return the range of matching banner contents
	 */
	public static List<BannerContent> findByChannelId(
		long channelId, int start, int end) {

		return getPersistence().findByChannelId(channelId, start, end);
	}

	/**
	 * Returns an ordered range of all the banner contents where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching banner contents
	 */
	public static List<BannerContent> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<BannerContent> orderByComparator) {

		return getPersistence().findByChannelId(
			channelId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the banner contents where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching banner contents
	 */
	public static List<BannerContent> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<BannerContent> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByChannelId(
			channelId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first banner content in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner content
	 * @throws NoSuchBannerContentException if a matching banner content could not be found
	 */
	public static BannerContent findByChannelId_First(
			long channelId, OrderByComparator<BannerContent> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchBannerContentException {

		return getPersistence().findByChannelId_First(
			channelId, orderByComparator);
	}

	/**
	 * Returns the first banner content in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner content, or <code>null</code> if a matching banner content could not be found
	 */
	public static BannerContent fetchByChannelId_First(
		long channelId, OrderByComparator<BannerContent> orderByComparator) {

		return getPersistence().fetchByChannelId_First(
			channelId, orderByComparator);
	}

	/**
	 * Returns the last banner content in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner content
	 * @throws NoSuchBannerContentException if a matching banner content could not be found
	 */
	public static BannerContent findByChannelId_Last(
			long channelId, OrderByComparator<BannerContent> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchBannerContentException {

		return getPersistence().findByChannelId_Last(
			channelId, orderByComparator);
	}

	/**
	 * Returns the last banner content in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner content, or <code>null</code> if a matching banner content could not be found
	 */
	public static BannerContent fetchByChannelId_Last(
		long channelId, OrderByComparator<BannerContent> orderByComparator) {

		return getPersistence().fetchByChannelId_Last(
			channelId, orderByComparator);
	}

	/**
	 * Returns the banner contents before and after the current banner content in the ordered set where channelId = &#63;.
	 *
	 * @param contentId the primary key of the current banner content
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next banner content
	 * @throws NoSuchBannerContentException if a banner content with the primary key could not be found
	 */
	public static BannerContent[] findByChannelId_PrevAndNext(
			long contentId, long channelId,
			OrderByComparator<BannerContent> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchBannerContentException {

		return getPersistence().findByChannelId_PrevAndNext(
			contentId, channelId, orderByComparator);
	}

	/**
	 * Removes all the banner contents where channelId = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 */
	public static void removeByChannelId(long channelId) {
		getPersistence().removeByChannelId(channelId);
	}

	/**
	 * Returns the number of banner contents where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the number of matching banner contents
	 */
	public static int countByChannelId(long channelId) {
		return getPersistence().countByChannelId(channelId);
	}

	/**
	 * Caches the banner content in the entity cache if it is enabled.
	 *
	 * @param bannerContent the banner content
	 */
	public static void cacheResult(BannerContent bannerContent) {
		getPersistence().cacheResult(bannerContent);
	}

	/**
	 * Caches the banner contents in the entity cache if it is enabled.
	 *
	 * @param bannerContents the banner contents
	 */
	public static void cacheResult(List<BannerContent> bannerContents) {
		getPersistence().cacheResult(bannerContents);
	}

	/**
	 * Creates a new banner content with the primary key. Does not add the banner content to the database.
	 *
	 * @param contentId the primary key for the new banner content
	 * @return the new banner content
	 */
	public static BannerContent create(long contentId) {
		return getPersistence().create(contentId);
	}

	/**
	 * Removes the banner content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contentId the primary key of the banner content
	 * @return the banner content that was removed
	 * @throws NoSuchBannerContentException if a banner content with the primary key could not be found
	 */
	public static BannerContent remove(long contentId)
		throws com.ejada.telemony.db.exception.NoSuchBannerContentException {

		return getPersistence().remove(contentId);
	}

	public static BannerContent updateImpl(BannerContent bannerContent) {
		return getPersistence().updateImpl(bannerContent);
	}

	/**
	 * Returns the banner content with the primary key or throws a <code>NoSuchBannerContentException</code> if it could not be found.
	 *
	 * @param contentId the primary key of the banner content
	 * @return the banner content
	 * @throws NoSuchBannerContentException if a banner content with the primary key could not be found
	 */
	public static BannerContent findByPrimaryKey(long contentId)
		throws com.ejada.telemony.db.exception.NoSuchBannerContentException {

		return getPersistence().findByPrimaryKey(contentId);
	}

	/**
	 * Returns the banner content with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contentId the primary key of the banner content
	 * @return the banner content, or <code>null</code> if a banner content with the primary key could not be found
	 */
	public static BannerContent fetchByPrimaryKey(long contentId) {
		return getPersistence().fetchByPrimaryKey(contentId);
	}

	/**
	 * Returns all the banner contents.
	 *
	 * @return the banner contents
	 */
	public static List<BannerContent> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the banner contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @return the range of banner contents
	 */
	public static List<BannerContent> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the banner contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of banner contents
	 */
	public static List<BannerContent> findAll(
		int start, int end,
		OrderByComparator<BannerContent> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the banner contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of banner contents
	 */
	public static List<BannerContent> findAll(
		int start, int end, OrderByComparator<BannerContent> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the banner contents from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of banner contents.
	 *
	 * @return the number of banner contents
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BannerContentPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(BannerContentPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile BannerContentPersistence _persistence;

}