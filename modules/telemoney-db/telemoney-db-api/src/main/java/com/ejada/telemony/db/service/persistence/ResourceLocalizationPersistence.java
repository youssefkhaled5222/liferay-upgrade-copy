/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.exception.NoSuchResourceLocalizationException;
import com.ejada.telemony.db.model.ResourceLocalization;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the resource localization service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ResourceLocalizationUtil
 * @generated
 */
@ProviderType
public interface ResourceLocalizationPersistence
	extends BasePersistence<ResourceLocalization> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ResourceLocalizationUtil} to access the resource localization persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the resource localizations where resourceId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @return the matching resource localizations
	 */
	public java.util.List<ResourceLocalization> findByResourceId(
		long resourceId);

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
	public java.util.List<ResourceLocalization> findByResourceId(
		long resourceId, int start, int end);

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
	public java.util.List<ResourceLocalization> findByResourceId(
		long resourceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceLocalization>
			orderByComparator);

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
	public java.util.List<ResourceLocalization> findByResourceId(
		long resourceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceLocalization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first resource localization in the ordered set where resourceId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource localization
	 * @throws NoSuchResourceLocalizationException if a matching resource localization could not be found
	 */
	public ResourceLocalization findByResourceId_First(
			long resourceId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ResourceLocalization> orderByComparator)
		throws NoSuchResourceLocalizationException;

	/**
	 * Returns the first resource localization in the ordered set where resourceId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource localization, or <code>null</code> if a matching resource localization could not be found
	 */
	public ResourceLocalization fetchByResourceId_First(
		long resourceId,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceLocalization>
			orderByComparator);

	/**
	 * Returns the last resource localization in the ordered set where resourceId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource localization
	 * @throws NoSuchResourceLocalizationException if a matching resource localization could not be found
	 */
	public ResourceLocalization findByResourceId_Last(
			long resourceId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ResourceLocalization> orderByComparator)
		throws NoSuchResourceLocalizationException;

	/**
	 * Returns the last resource localization in the ordered set where resourceId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource localization, or <code>null</code> if a matching resource localization could not be found
	 */
	public ResourceLocalization fetchByResourceId_Last(
		long resourceId,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceLocalization>
			orderByComparator);

	/**
	 * Returns the resource localizations before and after the current resource localization in the ordered set where resourceId = &#63;.
	 *
	 * @param resourceLocalizationId the primary key of the current resource localization
	 * @param resourceId the resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource localization
	 * @throws NoSuchResourceLocalizationException if a resource localization with the primary key could not be found
	 */
	public ResourceLocalization[] findByResourceId_PrevAndNext(
			long resourceLocalizationId, long resourceId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ResourceLocalization> orderByComparator)
		throws NoSuchResourceLocalizationException;

	/**
	 * Removes all the resource localizations where resourceId = &#63; from the database.
	 *
	 * @param resourceId the resource ID
	 */
	public void removeByResourceId(long resourceId);

	/**
	 * Returns the number of resource localizations where resourceId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @return the number of matching resource localizations
	 */
	public int countByResourceId(long resourceId);

	/**
	 * Returns the resource localization where resourceId = &#63; and languageId = &#63; or throws a <code>NoSuchResourceLocalizationException</code> if it could not be found.
	 *
	 * @param resourceId the resource ID
	 * @param languageId the language ID
	 * @return the matching resource localization
	 * @throws NoSuchResourceLocalizationException if a matching resource localization could not be found
	 */
	public ResourceLocalization findByResourceId_LanguageId(
			long resourceId, String languageId)
		throws NoSuchResourceLocalizationException;

	/**
	 * Returns the resource localization where resourceId = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param resourceId the resource ID
	 * @param languageId the language ID
	 * @return the matching resource localization, or <code>null</code> if a matching resource localization could not be found
	 */
	public ResourceLocalization fetchByResourceId_LanguageId(
		long resourceId, String languageId);

	/**
	 * Returns the resource localization where resourceId = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param resourceId the resource ID
	 * @param languageId the language ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching resource localization, or <code>null</code> if a matching resource localization could not be found
	 */
	public ResourceLocalization fetchByResourceId_LanguageId(
		long resourceId, String languageId, boolean useFinderCache);

	/**
	 * Removes the resource localization where resourceId = &#63; and languageId = &#63; from the database.
	 *
	 * @param resourceId the resource ID
	 * @param languageId the language ID
	 * @return the resource localization that was removed
	 */
	public ResourceLocalization removeByResourceId_LanguageId(
			long resourceId, String languageId)
		throws NoSuchResourceLocalizationException;

	/**
	 * Returns the number of resource localizations where resourceId = &#63; and languageId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @param languageId the language ID
	 * @return the number of matching resource localizations
	 */
	public int countByResourceId_LanguageId(long resourceId, String languageId);

	/**
	 * Returns all the resource localizations where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @return the matching resource localizations
	 */
	public java.util.List<ResourceLocalization> findByLanguage(
		String languageId);

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
	public java.util.List<ResourceLocalization> findByLanguage(
		String languageId, int start, int end);

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
	public java.util.List<ResourceLocalization> findByLanguage(
		String languageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceLocalization>
			orderByComparator);

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
	public java.util.List<ResourceLocalization> findByLanguage(
		String languageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceLocalization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first resource localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource localization
	 * @throws NoSuchResourceLocalizationException if a matching resource localization could not be found
	 */
	public ResourceLocalization findByLanguage_First(
			String languageId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ResourceLocalization> orderByComparator)
		throws NoSuchResourceLocalizationException;

	/**
	 * Returns the first resource localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource localization, or <code>null</code> if a matching resource localization could not be found
	 */
	public ResourceLocalization fetchByLanguage_First(
		String languageId,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceLocalization>
			orderByComparator);

	/**
	 * Returns the last resource localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource localization
	 * @throws NoSuchResourceLocalizationException if a matching resource localization could not be found
	 */
	public ResourceLocalization findByLanguage_Last(
			String languageId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ResourceLocalization> orderByComparator)
		throws NoSuchResourceLocalizationException;

	/**
	 * Returns the last resource localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource localization, or <code>null</code> if a matching resource localization could not be found
	 */
	public ResourceLocalization fetchByLanguage_Last(
		String languageId,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceLocalization>
			orderByComparator);

	/**
	 * Returns the resource localizations before and after the current resource localization in the ordered set where languageId = &#63;.
	 *
	 * @param resourceLocalizationId the primary key of the current resource localization
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource localization
	 * @throws NoSuchResourceLocalizationException if a resource localization with the primary key could not be found
	 */
	public ResourceLocalization[] findByLanguage_PrevAndNext(
			long resourceLocalizationId, String languageId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ResourceLocalization> orderByComparator)
		throws NoSuchResourceLocalizationException;

	/**
	 * Removes all the resource localizations where languageId = &#63; from the database.
	 *
	 * @param languageId the language ID
	 */
	public void removeByLanguage(String languageId);

	/**
	 * Returns the number of resource localizations where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @return the number of matching resource localizations
	 */
	public int countByLanguage(String languageId);

	/**
	 * Returns all the resource localizations where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @return the matching resource localizations
	 */
	public java.util.List<ResourceLocalization> findBynameAndLanguageId(
		String languageId, String name);

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
	public java.util.List<ResourceLocalization> findBynameAndLanguageId(
		String languageId, String name, int start, int end);

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
	public java.util.List<ResourceLocalization> findBynameAndLanguageId(
		String languageId, String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceLocalization>
			orderByComparator);

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
	public java.util.List<ResourceLocalization> findBynameAndLanguageId(
		String languageId, String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceLocalization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first resource localization in the ordered set where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource localization
	 * @throws NoSuchResourceLocalizationException if a matching resource localization could not be found
	 */
	public ResourceLocalization findBynameAndLanguageId_First(
			String languageId, String name,
			com.liferay.portal.kernel.util.OrderByComparator
				<ResourceLocalization> orderByComparator)
		throws NoSuchResourceLocalizationException;

	/**
	 * Returns the first resource localization in the ordered set where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource localization, or <code>null</code> if a matching resource localization could not be found
	 */
	public ResourceLocalization fetchBynameAndLanguageId_First(
		String languageId, String name,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceLocalization>
			orderByComparator);

	/**
	 * Returns the last resource localization in the ordered set where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource localization
	 * @throws NoSuchResourceLocalizationException if a matching resource localization could not be found
	 */
	public ResourceLocalization findBynameAndLanguageId_Last(
			String languageId, String name,
			com.liferay.portal.kernel.util.OrderByComparator
				<ResourceLocalization> orderByComparator)
		throws NoSuchResourceLocalizationException;

	/**
	 * Returns the last resource localization in the ordered set where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource localization, or <code>null</code> if a matching resource localization could not be found
	 */
	public ResourceLocalization fetchBynameAndLanguageId_Last(
		String languageId, String name,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceLocalization>
			orderByComparator);

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
	public ResourceLocalization[] findBynameAndLanguageId_PrevAndNext(
			long resourceLocalizationId, String languageId, String name,
			com.liferay.portal.kernel.util.OrderByComparator
				<ResourceLocalization> orderByComparator)
		throws NoSuchResourceLocalizationException;

	/**
	 * Removes all the resource localizations where languageId = &#63; and name LIKE &#63; from the database.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 */
	public void removeBynameAndLanguageId(String languageId, String name);

	/**
	 * Returns the number of resource localizations where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @return the number of matching resource localizations
	 */
	public int countBynameAndLanguageId(String languageId, String name);

	/**
	 * Caches the resource localization in the entity cache if it is enabled.
	 *
	 * @param resourceLocalization the resource localization
	 */
	public void cacheResult(ResourceLocalization resourceLocalization);

	/**
	 * Caches the resource localizations in the entity cache if it is enabled.
	 *
	 * @param resourceLocalizations the resource localizations
	 */
	public void cacheResult(
		java.util.List<ResourceLocalization> resourceLocalizations);

	/**
	 * Creates a new resource localization with the primary key. Does not add the resource localization to the database.
	 *
	 * @param resourceLocalizationId the primary key for the new resource localization
	 * @return the new resource localization
	 */
	public ResourceLocalization create(long resourceLocalizationId);

	/**
	 * Removes the resource localization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param resourceLocalizationId the primary key of the resource localization
	 * @return the resource localization that was removed
	 * @throws NoSuchResourceLocalizationException if a resource localization with the primary key could not be found
	 */
	public ResourceLocalization remove(long resourceLocalizationId)
		throws NoSuchResourceLocalizationException;

	public ResourceLocalization updateImpl(
		ResourceLocalization resourceLocalization);

	/**
	 * Returns the resource localization with the primary key or throws a <code>NoSuchResourceLocalizationException</code> if it could not be found.
	 *
	 * @param resourceLocalizationId the primary key of the resource localization
	 * @return the resource localization
	 * @throws NoSuchResourceLocalizationException if a resource localization with the primary key could not be found
	 */
	public ResourceLocalization findByPrimaryKey(long resourceLocalizationId)
		throws NoSuchResourceLocalizationException;

	/**
	 * Returns the resource localization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param resourceLocalizationId the primary key of the resource localization
	 * @return the resource localization, or <code>null</code> if a resource localization with the primary key could not be found
	 */
	public ResourceLocalization fetchByPrimaryKey(long resourceLocalizationId);

	/**
	 * Returns all the resource localizations.
	 *
	 * @return the resource localizations
	 */
	public java.util.List<ResourceLocalization> findAll();

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
	public java.util.List<ResourceLocalization> findAll(int start, int end);

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
	public java.util.List<ResourceLocalization> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceLocalization>
			orderByComparator);

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
	public java.util.List<ResourceLocalization> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceLocalization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the resource localizations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of resource localizations.
	 *
	 * @return the number of resource localizations
	 */
	public int countAll();

}