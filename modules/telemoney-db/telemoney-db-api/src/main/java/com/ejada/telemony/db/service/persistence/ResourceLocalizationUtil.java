/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.model.ResourceLocalization;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the resource localization service. This utility wraps <code>com.ejada.telemony.db.service.persistence.impl.ResourceLocalizationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ResourceLocalizationPersistence
 * @generated
 */
public class ResourceLocalizationUtil {

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
	public static void clearCache(ResourceLocalization resourceLocalization) {
		getPersistence().clearCache(resourceLocalization);
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
	public static Map<Serializable, ResourceLocalization> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ResourceLocalization> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ResourceLocalization> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ResourceLocalization> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ResourceLocalization> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ResourceLocalization update(
		ResourceLocalization resourceLocalization) {

		return getPersistence().update(resourceLocalization);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ResourceLocalization update(
		ResourceLocalization resourceLocalization,
		ServiceContext serviceContext) {

		return getPersistence().update(resourceLocalization, serviceContext);
	}

	/**
	 * Returns all the resource localizations where resourceId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @return the matching resource localizations
	 */
	public static List<ResourceLocalization> findByResourceId(long resourceId) {
		return getPersistence().findByResourceId(resourceId);
	}

	/**
	 * Returns a range of all the resource localizations where resourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param resourceId the resource ID
	 * @param start the lower bound of the range of resource localizations
	 * @param end the upper bound of the range of resource localizations (not inclusive)
	 * @return the range of matching resource localizations
	 */
	public static List<ResourceLocalization> findByResourceId(
		long resourceId, int start, int end) {

		return getPersistence().findByResourceId(resourceId, start, end);
	}

	/**
	 * Returns an ordered range of all the resource localizations where resourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param resourceId the resource ID
	 * @param start the lower bound of the range of resource localizations
	 * @param end the upper bound of the range of resource localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resource localizations
	 */
	public static List<ResourceLocalization> findByResourceId(
		long resourceId, int start, int end,
		OrderByComparator<ResourceLocalization> orderByComparator) {

		return getPersistence().findByResourceId(
			resourceId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the resource localizations where resourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param resourceId the resource ID
	 * @param start the lower bound of the range of resource localizations
	 * @param end the upper bound of the range of resource localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resource localizations
	 */
	public static List<ResourceLocalization> findByResourceId(
		long resourceId, int start, int end,
		OrderByComparator<ResourceLocalization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByResourceId(
			resourceId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first resource localization in the ordered set where resourceId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource localization
	 * @throws NoSuchResourceLocalizationException if a matching resource localization could not be found
	 */
	public static ResourceLocalization findByResourceId_First(
			long resourceId,
			OrderByComparator<ResourceLocalization> orderByComparator)
		throws com.ejada.telemony.db.exception.
			NoSuchResourceLocalizationException {

		return getPersistence().findByResourceId_First(
			resourceId, orderByComparator);
	}

	/**
	 * Returns the first resource localization in the ordered set where resourceId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource localization, or <code>null</code> if a matching resource localization could not be found
	 */
	public static ResourceLocalization fetchByResourceId_First(
		long resourceId,
		OrderByComparator<ResourceLocalization> orderByComparator) {

		return getPersistence().fetchByResourceId_First(
			resourceId, orderByComparator);
	}

	/**
	 * Returns the last resource localization in the ordered set where resourceId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource localization
	 * @throws NoSuchResourceLocalizationException if a matching resource localization could not be found
	 */
	public static ResourceLocalization findByResourceId_Last(
			long resourceId,
			OrderByComparator<ResourceLocalization> orderByComparator)
		throws com.ejada.telemony.db.exception.
			NoSuchResourceLocalizationException {

		return getPersistence().findByResourceId_Last(
			resourceId, orderByComparator);
	}

	/**
	 * Returns the last resource localization in the ordered set where resourceId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource localization, or <code>null</code> if a matching resource localization could not be found
	 */
	public static ResourceLocalization fetchByResourceId_Last(
		long resourceId,
		OrderByComparator<ResourceLocalization> orderByComparator) {

		return getPersistence().fetchByResourceId_Last(
			resourceId, orderByComparator);
	}

	/**
	 * Returns the resource localizations before and after the current resource localization in the ordered set where resourceId = &#63;.
	 *
	 * @param resourceLocalizationId the primary key of the current resource localization
	 * @param resourceId the resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource localization
	 * @throws NoSuchResourceLocalizationException if a resource localization with the primary key could not be found
	 */
	public static ResourceLocalization[] findByResourceId_PrevAndNext(
			long resourceLocalizationId, long resourceId,
			OrderByComparator<ResourceLocalization> orderByComparator)
		throws com.ejada.telemony.db.exception.
			NoSuchResourceLocalizationException {

		return getPersistence().findByResourceId_PrevAndNext(
			resourceLocalizationId, resourceId, orderByComparator);
	}

	/**
	 * Removes all the resource localizations where resourceId = &#63; from the database.
	 *
	 * @param resourceId the resource ID
	 */
	public static void removeByResourceId(long resourceId) {
		getPersistence().removeByResourceId(resourceId);
	}

	/**
	 * Returns the number of resource localizations where resourceId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @return the number of matching resource localizations
	 */
	public static int countByResourceId(long resourceId) {
		return getPersistence().countByResourceId(resourceId);
	}

	/**
	 * Returns the resource localization where resourceId = &#63; and languageId = &#63; or throws a <code>NoSuchResourceLocalizationException</code> if it could not be found.
	 *
	 * @param resourceId the resource ID
	 * @param languageId the language ID
	 * @return the matching resource localization
	 * @throws NoSuchResourceLocalizationException if a matching resource localization could not be found
	 */
	public static ResourceLocalization findByResourceId_LanguageId(
			long resourceId, String languageId)
		throws com.ejada.telemony.db.exception.
			NoSuchResourceLocalizationException {

		return getPersistence().findByResourceId_LanguageId(
			resourceId, languageId);
	}

	/**
	 * Returns the resource localization where resourceId = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param resourceId the resource ID
	 * @param languageId the language ID
	 * @return the matching resource localization, or <code>null</code> if a matching resource localization could not be found
	 */
	public static ResourceLocalization fetchByResourceId_LanguageId(
		long resourceId, String languageId) {

		return getPersistence().fetchByResourceId_LanguageId(
			resourceId, languageId);
	}

	/**
	 * Returns the resource localization where resourceId = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param resourceId the resource ID
	 * @param languageId the language ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching resource localization, or <code>null</code> if a matching resource localization could not be found
	 */
	public static ResourceLocalization fetchByResourceId_LanguageId(
		long resourceId, String languageId, boolean useFinderCache) {

		return getPersistence().fetchByResourceId_LanguageId(
			resourceId, languageId, useFinderCache);
	}

	/**
	 * Removes the resource localization where resourceId = &#63; and languageId = &#63; from the database.
	 *
	 * @param resourceId the resource ID
	 * @param languageId the language ID
	 * @return the resource localization that was removed
	 */
	public static ResourceLocalization removeByResourceId_LanguageId(
			long resourceId, String languageId)
		throws com.ejada.telemony.db.exception.
			NoSuchResourceLocalizationException {

		return getPersistence().removeByResourceId_LanguageId(
			resourceId, languageId);
	}

	/**
	 * Returns the number of resource localizations where resourceId = &#63; and languageId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @param languageId the language ID
	 * @return the number of matching resource localizations
	 */
	public static int countByResourceId_LanguageId(
		long resourceId, String languageId) {

		return getPersistence().countByResourceId_LanguageId(
			resourceId, languageId);
	}

	/**
	 * Returns all the resource localizations where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @return the matching resource localizations
	 */
	public static List<ResourceLocalization> findByLanguage(String languageId) {
		return getPersistence().findByLanguage(languageId);
	}

	/**
	 * Returns a range of all the resource localizations where languageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param start the lower bound of the range of resource localizations
	 * @param end the upper bound of the range of resource localizations (not inclusive)
	 * @return the range of matching resource localizations
	 */
	public static List<ResourceLocalization> findByLanguage(
		String languageId, int start, int end) {

		return getPersistence().findByLanguage(languageId, start, end);
	}

	/**
	 * Returns an ordered range of all the resource localizations where languageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param start the lower bound of the range of resource localizations
	 * @param end the upper bound of the range of resource localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resource localizations
	 */
	public static List<ResourceLocalization> findByLanguage(
		String languageId, int start, int end,
		OrderByComparator<ResourceLocalization> orderByComparator) {

		return getPersistence().findByLanguage(
			languageId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the resource localizations where languageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param start the lower bound of the range of resource localizations
	 * @param end the upper bound of the range of resource localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resource localizations
	 */
	public static List<ResourceLocalization> findByLanguage(
		String languageId, int start, int end,
		OrderByComparator<ResourceLocalization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByLanguage(
			languageId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first resource localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource localization
	 * @throws NoSuchResourceLocalizationException if a matching resource localization could not be found
	 */
	public static ResourceLocalization findByLanguage_First(
			String languageId,
			OrderByComparator<ResourceLocalization> orderByComparator)
		throws com.ejada.telemony.db.exception.
			NoSuchResourceLocalizationException {

		return getPersistence().findByLanguage_First(
			languageId, orderByComparator);
	}

	/**
	 * Returns the first resource localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource localization, or <code>null</code> if a matching resource localization could not be found
	 */
	public static ResourceLocalization fetchByLanguage_First(
		String languageId,
		OrderByComparator<ResourceLocalization> orderByComparator) {

		return getPersistence().fetchByLanguage_First(
			languageId, orderByComparator);
	}

	/**
	 * Returns the last resource localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource localization
	 * @throws NoSuchResourceLocalizationException if a matching resource localization could not be found
	 */
	public static ResourceLocalization findByLanguage_Last(
			String languageId,
			OrderByComparator<ResourceLocalization> orderByComparator)
		throws com.ejada.telemony.db.exception.
			NoSuchResourceLocalizationException {

		return getPersistence().findByLanguage_Last(
			languageId, orderByComparator);
	}

	/**
	 * Returns the last resource localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource localization, or <code>null</code> if a matching resource localization could not be found
	 */
	public static ResourceLocalization fetchByLanguage_Last(
		String languageId,
		OrderByComparator<ResourceLocalization> orderByComparator) {

		return getPersistence().fetchByLanguage_Last(
			languageId, orderByComparator);
	}

	/**
	 * Returns the resource localizations before and after the current resource localization in the ordered set where languageId = &#63;.
	 *
	 * @param resourceLocalizationId the primary key of the current resource localization
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource localization
	 * @throws NoSuchResourceLocalizationException if a resource localization with the primary key could not be found
	 */
	public static ResourceLocalization[] findByLanguage_PrevAndNext(
			long resourceLocalizationId, String languageId,
			OrderByComparator<ResourceLocalization> orderByComparator)
		throws com.ejada.telemony.db.exception.
			NoSuchResourceLocalizationException {

		return getPersistence().findByLanguage_PrevAndNext(
			resourceLocalizationId, languageId, orderByComparator);
	}

	/**
	 * Removes all the resource localizations where languageId = &#63; from the database.
	 *
	 * @param languageId the language ID
	 */
	public static void removeByLanguage(String languageId) {
		getPersistence().removeByLanguage(languageId);
	}

	/**
	 * Returns the number of resource localizations where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @return the number of matching resource localizations
	 */
	public static int countByLanguage(String languageId) {
		return getPersistence().countByLanguage(languageId);
	}

	/**
	 * Returns all the resource localizations where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @return the matching resource localizations
	 */
	public static List<ResourceLocalization> findBynameAndLanguageId(
		String languageId, String name) {

		return getPersistence().findBynameAndLanguageId(languageId, name);
	}

	/**
	 * Returns a range of all the resource localizations where languageId = &#63; and name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @param start the lower bound of the range of resource localizations
	 * @param end the upper bound of the range of resource localizations (not inclusive)
	 * @return the range of matching resource localizations
	 */
	public static List<ResourceLocalization> findBynameAndLanguageId(
		String languageId, String name, int start, int end) {

		return getPersistence().findBynameAndLanguageId(
			languageId, name, start, end);
	}

	/**
	 * Returns an ordered range of all the resource localizations where languageId = &#63; and name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @param start the lower bound of the range of resource localizations
	 * @param end the upper bound of the range of resource localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resource localizations
	 */
	public static List<ResourceLocalization> findBynameAndLanguageId(
		String languageId, String name, int start, int end,
		OrderByComparator<ResourceLocalization> orderByComparator) {

		return getPersistence().findBynameAndLanguageId(
			languageId, name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the resource localizations where languageId = &#63; and name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @param start the lower bound of the range of resource localizations
	 * @param end the upper bound of the range of resource localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resource localizations
	 */
	public static List<ResourceLocalization> findBynameAndLanguageId(
		String languageId, String name, int start, int end,
		OrderByComparator<ResourceLocalization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBynameAndLanguageId(
			languageId, name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first resource localization in the ordered set where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource localization
	 * @throws NoSuchResourceLocalizationException if a matching resource localization could not be found
	 */
	public static ResourceLocalization findBynameAndLanguageId_First(
			String languageId, String name,
			OrderByComparator<ResourceLocalization> orderByComparator)
		throws com.ejada.telemony.db.exception.
			NoSuchResourceLocalizationException {

		return getPersistence().findBynameAndLanguageId_First(
			languageId, name, orderByComparator);
	}

	/**
	 * Returns the first resource localization in the ordered set where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource localization, or <code>null</code> if a matching resource localization could not be found
	 */
	public static ResourceLocalization fetchBynameAndLanguageId_First(
		String languageId, String name,
		OrderByComparator<ResourceLocalization> orderByComparator) {

		return getPersistence().fetchBynameAndLanguageId_First(
			languageId, name, orderByComparator);
	}

	/**
	 * Returns the last resource localization in the ordered set where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource localization
	 * @throws NoSuchResourceLocalizationException if a matching resource localization could not be found
	 */
	public static ResourceLocalization findBynameAndLanguageId_Last(
			String languageId, String name,
			OrderByComparator<ResourceLocalization> orderByComparator)
		throws com.ejada.telemony.db.exception.
			NoSuchResourceLocalizationException {

		return getPersistence().findBynameAndLanguageId_Last(
			languageId, name, orderByComparator);
	}

	/**
	 * Returns the last resource localization in the ordered set where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource localization, or <code>null</code> if a matching resource localization could not be found
	 */
	public static ResourceLocalization fetchBynameAndLanguageId_Last(
		String languageId, String name,
		OrderByComparator<ResourceLocalization> orderByComparator) {

		return getPersistence().fetchBynameAndLanguageId_Last(
			languageId, name, orderByComparator);
	}

	/**
	 * Returns the resource localizations before and after the current resource localization in the ordered set where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param resourceLocalizationId the primary key of the current resource localization
	 * @param languageId the language ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource localization
	 * @throws NoSuchResourceLocalizationException if a resource localization with the primary key could not be found
	 */
	public static ResourceLocalization[] findBynameAndLanguageId_PrevAndNext(
			long resourceLocalizationId, String languageId, String name,
			OrderByComparator<ResourceLocalization> orderByComparator)
		throws com.ejada.telemony.db.exception.
			NoSuchResourceLocalizationException {

		return getPersistence().findBynameAndLanguageId_PrevAndNext(
			resourceLocalizationId, languageId, name, orderByComparator);
	}

	/**
	 * Removes all the resource localizations where languageId = &#63; and name LIKE &#63; from the database.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 */
	public static void removeBynameAndLanguageId(
		String languageId, String name) {

		getPersistence().removeBynameAndLanguageId(languageId, name);
	}

	/**
	 * Returns the number of resource localizations where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @return the number of matching resource localizations
	 */
	public static int countBynameAndLanguageId(String languageId, String name) {
		return getPersistence().countBynameAndLanguageId(languageId, name);
	}

	/**
	 * Caches the resource localization in the entity cache if it is enabled.
	 *
	 * @param resourceLocalization the resource localization
	 */
	public static void cacheResult(ResourceLocalization resourceLocalization) {
		getPersistence().cacheResult(resourceLocalization);
	}

	/**
	 * Caches the resource localizations in the entity cache if it is enabled.
	 *
	 * @param resourceLocalizations the resource localizations
	 */
	public static void cacheResult(
		List<ResourceLocalization> resourceLocalizations) {

		getPersistence().cacheResult(resourceLocalizations);
	}

	/**
	 * Creates a new resource localization with the primary key. Does not add the resource localization to the database.
	 *
	 * @param resourceLocalizationId the primary key for the new resource localization
	 * @return the new resource localization
	 */
	public static ResourceLocalization create(long resourceLocalizationId) {
		return getPersistence().create(resourceLocalizationId);
	}

	/**
	 * Removes the resource localization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param resourceLocalizationId the primary key of the resource localization
	 * @return the resource localization that was removed
	 * @throws NoSuchResourceLocalizationException if a resource localization with the primary key could not be found
	 */
	public static ResourceLocalization remove(long resourceLocalizationId)
		throws com.ejada.telemony.db.exception.
			NoSuchResourceLocalizationException {

		return getPersistence().remove(resourceLocalizationId);
	}

	public static ResourceLocalization updateImpl(
		ResourceLocalization resourceLocalization) {

		return getPersistence().updateImpl(resourceLocalization);
	}

	/**
	 * Returns the resource localization with the primary key or throws a <code>NoSuchResourceLocalizationException</code> if it could not be found.
	 *
	 * @param resourceLocalizationId the primary key of the resource localization
	 * @return the resource localization
	 * @throws NoSuchResourceLocalizationException if a resource localization with the primary key could not be found
	 */
	public static ResourceLocalization findByPrimaryKey(
			long resourceLocalizationId)
		throws com.ejada.telemony.db.exception.
			NoSuchResourceLocalizationException {

		return getPersistence().findByPrimaryKey(resourceLocalizationId);
	}

	/**
	 * Returns the resource localization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param resourceLocalizationId the primary key of the resource localization
	 * @return the resource localization, or <code>null</code> if a resource localization with the primary key could not be found
	 */
	public static ResourceLocalization fetchByPrimaryKey(
		long resourceLocalizationId) {

		return getPersistence().fetchByPrimaryKey(resourceLocalizationId);
	}

	/**
	 * Returns all the resource localizations.
	 *
	 * @return the resource localizations
	 */
	public static List<ResourceLocalization> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the resource localizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resource localizations
	 * @param end the upper bound of the range of resource localizations (not inclusive)
	 * @return the range of resource localizations
	 */
	public static List<ResourceLocalization> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the resource localizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resource localizations
	 * @param end the upper bound of the range of resource localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of resource localizations
	 */
	public static List<ResourceLocalization> findAll(
		int start, int end,
		OrderByComparator<ResourceLocalization> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the resource localizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resource localizations
	 * @param end the upper bound of the range of resource localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of resource localizations
	 */
	public static List<ResourceLocalization> findAll(
		int start, int end,
		OrderByComparator<ResourceLocalization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the resource localizations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of resource localizations.
	 *
	 * @return the number of resource localizations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ResourceLocalizationPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		ResourceLocalizationPersistence persistence) {

		_persistence = persistence;
	}

	private static volatile ResourceLocalizationPersistence _persistence;

}