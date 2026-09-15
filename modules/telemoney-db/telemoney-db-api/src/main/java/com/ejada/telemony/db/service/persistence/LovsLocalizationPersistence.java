/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.exception.NoSuchLovsLocalizationException;
import com.ejada.telemony.db.model.LovsLocalization;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the lovs localization service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LovsLocalizationUtil
 * @generated
 */
@ProviderType
public interface LovsLocalizationPersistence
	extends BasePersistence<LovsLocalization> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LovsLocalizationUtil} to access the lovs localization persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the lovs localizations where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching lovs localizations
	 */
	public java.util.List<LovsLocalization> findById(long id);

	/**
	 * Returns a range of all the lovs localizations where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of lovs localizations
	 * @param end the upper bound of the range of lovs localizations (not inclusive)
	 * @return the range of matching lovs localizations
	 */
	public java.util.List<LovsLocalization> findById(
		long id, int start, int end);

	/**
	 * Returns an ordered range of all the lovs localizations where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of lovs localizations
	 * @param end the upper bound of the range of lovs localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lovs localizations
	 */
	public java.util.List<LovsLocalization> findById(
		long id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LovsLocalization>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lovs localizations where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of lovs localizations
	 * @param end the upper bound of the range of lovs localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lovs localizations
	 */
	public java.util.List<LovsLocalization> findById(
		long id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LovsLocalization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first lovs localization in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs localization
	 * @throws NoSuchLovsLocalizationException if a matching lovs localization could not be found
	 */
	public LovsLocalization findById_First(
			long id,
			com.liferay.portal.kernel.util.OrderByComparator<LovsLocalization>
				orderByComparator)
		throws NoSuchLovsLocalizationException;

	/**
	 * Returns the first lovs localization in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs localization, or <code>null</code> if a matching lovs localization could not be found
	 */
	public LovsLocalization fetchById_First(
		long id,
		com.liferay.portal.kernel.util.OrderByComparator<LovsLocalization>
			orderByComparator);

	/**
	 * Returns the last lovs localization in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs localization
	 * @throws NoSuchLovsLocalizationException if a matching lovs localization could not be found
	 */
	public LovsLocalization findById_Last(
			long id,
			com.liferay.portal.kernel.util.OrderByComparator<LovsLocalization>
				orderByComparator)
		throws NoSuchLovsLocalizationException;

	/**
	 * Returns the last lovs localization in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs localization, or <code>null</code> if a matching lovs localization could not be found
	 */
	public LovsLocalization fetchById_Last(
		long id,
		com.liferay.portal.kernel.util.OrderByComparator<LovsLocalization>
			orderByComparator);

	/**
	 * Returns the lovs localizations before and after the current lovs localization in the ordered set where id = &#63;.
	 *
	 * @param lovsLocalizationId the primary key of the current lovs localization
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lovs localization
	 * @throws NoSuchLovsLocalizationException if a lovs localization with the primary key could not be found
	 */
	public LovsLocalization[] findById_PrevAndNext(
			long lovsLocalizationId, long id,
			com.liferay.portal.kernel.util.OrderByComparator<LovsLocalization>
				orderByComparator)
		throws NoSuchLovsLocalizationException;

	/**
	 * Removes all the lovs localizations where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	public void removeById(long id);

	/**
	 * Returns the number of lovs localizations where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching lovs localizations
	 */
	public int countById(long id);

	/**
	 * Returns the lovs localization where id = &#63; and languageId = &#63; or throws a <code>NoSuchLovsLocalizationException</code> if it could not be found.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @return the matching lovs localization
	 * @throws NoSuchLovsLocalizationException if a matching lovs localization could not be found
	 */
	public LovsLocalization findById_LanguageId(long id, String languageId)
		throws NoSuchLovsLocalizationException;

	/**
	 * Returns the lovs localization where id = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @return the matching lovs localization, or <code>null</code> if a matching lovs localization could not be found
	 */
	public LovsLocalization fetchById_LanguageId(long id, String languageId);

	/**
	 * Returns the lovs localization where id = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching lovs localization, or <code>null</code> if a matching lovs localization could not be found
	 */
	public LovsLocalization fetchById_LanguageId(
		long id, String languageId, boolean useFinderCache);

	/**
	 * Removes the lovs localization where id = &#63; and languageId = &#63; from the database.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @return the lovs localization that was removed
	 */
	public LovsLocalization removeById_LanguageId(long id, String languageId)
		throws NoSuchLovsLocalizationException;

	/**
	 * Returns the number of lovs localizations where id = &#63; and languageId = &#63;.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @return the number of matching lovs localizations
	 */
	public int countById_LanguageId(long id, String languageId);

	/**
	 * Returns all the lovs localizations where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @return the matching lovs localizations
	 */
	public java.util.List<LovsLocalization> findBylangId(String languageId);

	/**
	 * Returns a range of all the lovs localizations where languageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param start the lower bound of the range of lovs localizations
	 * @param end the upper bound of the range of lovs localizations (not inclusive)
	 * @return the range of matching lovs localizations
	 */
	public java.util.List<LovsLocalization> findBylangId(
		String languageId, int start, int end);

	/**
	 * Returns an ordered range of all the lovs localizations where languageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param start the lower bound of the range of lovs localizations
	 * @param end the upper bound of the range of lovs localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lovs localizations
	 */
	public java.util.List<LovsLocalization> findBylangId(
		String languageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LovsLocalization>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lovs localizations where languageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param start the lower bound of the range of lovs localizations
	 * @param end the upper bound of the range of lovs localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lovs localizations
	 */
	public java.util.List<LovsLocalization> findBylangId(
		String languageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LovsLocalization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first lovs localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs localization
	 * @throws NoSuchLovsLocalizationException if a matching lovs localization could not be found
	 */
	public LovsLocalization findBylangId_First(
			String languageId,
			com.liferay.portal.kernel.util.OrderByComparator<LovsLocalization>
				orderByComparator)
		throws NoSuchLovsLocalizationException;

	/**
	 * Returns the first lovs localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs localization, or <code>null</code> if a matching lovs localization could not be found
	 */
	public LovsLocalization fetchBylangId_First(
		String languageId,
		com.liferay.portal.kernel.util.OrderByComparator<LovsLocalization>
			orderByComparator);

	/**
	 * Returns the last lovs localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs localization
	 * @throws NoSuchLovsLocalizationException if a matching lovs localization could not be found
	 */
	public LovsLocalization findBylangId_Last(
			String languageId,
			com.liferay.portal.kernel.util.OrderByComparator<LovsLocalization>
				orderByComparator)
		throws NoSuchLovsLocalizationException;

	/**
	 * Returns the last lovs localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs localization, or <code>null</code> if a matching lovs localization could not be found
	 */
	public LovsLocalization fetchBylangId_Last(
		String languageId,
		com.liferay.portal.kernel.util.OrderByComparator<LovsLocalization>
			orderByComparator);

	/**
	 * Returns the lovs localizations before and after the current lovs localization in the ordered set where languageId = &#63;.
	 *
	 * @param lovsLocalizationId the primary key of the current lovs localization
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lovs localization
	 * @throws NoSuchLovsLocalizationException if a lovs localization with the primary key could not be found
	 */
	public LovsLocalization[] findBylangId_PrevAndNext(
			long lovsLocalizationId, String languageId,
			com.liferay.portal.kernel.util.OrderByComparator<LovsLocalization>
				orderByComparator)
		throws NoSuchLovsLocalizationException;

	/**
	 * Removes all the lovs localizations where languageId = &#63; from the database.
	 *
	 * @param languageId the language ID
	 */
	public void removeBylangId(String languageId);

	/**
	 * Returns the number of lovs localizations where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @return the number of matching lovs localizations
	 */
	public int countBylangId(String languageId);

	/**
	 * Returns all the lovs localizations where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @return the matching lovs localizations
	 */
	public java.util.List<LovsLocalization> findBynameAndLanguageId(
		String languageId, String name);

	/**
	 * Returns a range of all the lovs localizations where languageId = &#63; and name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @param start the lower bound of the range of lovs localizations
	 * @param end the upper bound of the range of lovs localizations (not inclusive)
	 * @return the range of matching lovs localizations
	 */
	public java.util.List<LovsLocalization> findBynameAndLanguageId(
		String languageId, String name, int start, int end);

	/**
	 * Returns an ordered range of all the lovs localizations where languageId = &#63; and name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @param start the lower bound of the range of lovs localizations
	 * @param end the upper bound of the range of lovs localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lovs localizations
	 */
	public java.util.List<LovsLocalization> findBynameAndLanguageId(
		String languageId, String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LovsLocalization>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lovs localizations where languageId = &#63; and name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @param start the lower bound of the range of lovs localizations
	 * @param end the upper bound of the range of lovs localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lovs localizations
	 */
	public java.util.List<LovsLocalization> findBynameAndLanguageId(
		String languageId, String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LovsLocalization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first lovs localization in the ordered set where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs localization
	 * @throws NoSuchLovsLocalizationException if a matching lovs localization could not be found
	 */
	public LovsLocalization findBynameAndLanguageId_First(
			String languageId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<LovsLocalization>
				orderByComparator)
		throws NoSuchLovsLocalizationException;

	/**
	 * Returns the first lovs localization in the ordered set where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs localization, or <code>null</code> if a matching lovs localization could not be found
	 */
	public LovsLocalization fetchBynameAndLanguageId_First(
		String languageId, String name,
		com.liferay.portal.kernel.util.OrderByComparator<LovsLocalization>
			orderByComparator);

	/**
	 * Returns the last lovs localization in the ordered set where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs localization
	 * @throws NoSuchLovsLocalizationException if a matching lovs localization could not be found
	 */
	public LovsLocalization findBynameAndLanguageId_Last(
			String languageId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<LovsLocalization>
				orderByComparator)
		throws NoSuchLovsLocalizationException;

	/**
	 * Returns the last lovs localization in the ordered set where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs localization, or <code>null</code> if a matching lovs localization could not be found
	 */
	public LovsLocalization fetchBynameAndLanguageId_Last(
		String languageId, String name,
		com.liferay.portal.kernel.util.OrderByComparator<LovsLocalization>
			orderByComparator);

	/**
	 * Returns the lovs localizations before and after the current lovs localization in the ordered set where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param lovsLocalizationId the primary key of the current lovs localization
	 * @param languageId the language ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lovs localization
	 * @throws NoSuchLovsLocalizationException if a lovs localization with the primary key could not be found
	 */
	public LovsLocalization[] findBynameAndLanguageId_PrevAndNext(
			long lovsLocalizationId, String languageId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<LovsLocalization>
				orderByComparator)
		throws NoSuchLovsLocalizationException;

	/**
	 * Removes all the lovs localizations where languageId = &#63; and name LIKE &#63; from the database.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 */
	public void removeBynameAndLanguageId(String languageId, String name);

	/**
	 * Returns the number of lovs localizations where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @return the number of matching lovs localizations
	 */
	public int countBynameAndLanguageId(String languageId, String name);

	/**
	 * Caches the lovs localization in the entity cache if it is enabled.
	 *
	 * @param lovsLocalization the lovs localization
	 */
	public void cacheResult(LovsLocalization lovsLocalization);

	/**
	 * Caches the lovs localizations in the entity cache if it is enabled.
	 *
	 * @param lovsLocalizations the lovs localizations
	 */
	public void cacheResult(java.util.List<LovsLocalization> lovsLocalizations);

	/**
	 * Creates a new lovs localization with the primary key. Does not add the lovs localization to the database.
	 *
	 * @param lovsLocalizationId the primary key for the new lovs localization
	 * @return the new lovs localization
	 */
	public LovsLocalization create(long lovsLocalizationId);

	/**
	 * Removes the lovs localization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lovsLocalizationId the primary key of the lovs localization
	 * @return the lovs localization that was removed
	 * @throws NoSuchLovsLocalizationException if a lovs localization with the primary key could not be found
	 */
	public LovsLocalization remove(long lovsLocalizationId)
		throws NoSuchLovsLocalizationException;

	public LovsLocalization updateImpl(LovsLocalization lovsLocalization);

	/**
	 * Returns the lovs localization with the primary key or throws a <code>NoSuchLovsLocalizationException</code> if it could not be found.
	 *
	 * @param lovsLocalizationId the primary key of the lovs localization
	 * @return the lovs localization
	 * @throws NoSuchLovsLocalizationException if a lovs localization with the primary key could not be found
	 */
	public LovsLocalization findByPrimaryKey(long lovsLocalizationId)
		throws NoSuchLovsLocalizationException;

	/**
	 * Returns the lovs localization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lovsLocalizationId the primary key of the lovs localization
	 * @return the lovs localization, or <code>null</code> if a lovs localization with the primary key could not be found
	 */
	public LovsLocalization fetchByPrimaryKey(long lovsLocalizationId);

	/**
	 * Returns all the lovs localizations.
	 *
	 * @return the lovs localizations
	 */
	public java.util.List<LovsLocalization> findAll();

	/**
	 * Returns a range of all the lovs localizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lovs localizations
	 * @param end the upper bound of the range of lovs localizations (not inclusive)
	 * @return the range of lovs localizations
	 */
	public java.util.List<LovsLocalization> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the lovs localizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lovs localizations
	 * @param end the upper bound of the range of lovs localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lovs localizations
	 */
	public java.util.List<LovsLocalization> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LovsLocalization>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lovs localizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lovs localizations
	 * @param end the upper bound of the range of lovs localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of lovs localizations
	 */
	public java.util.List<LovsLocalization> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LovsLocalization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the lovs localizations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of lovs localizations.
	 *
	 * @return the number of lovs localizations
	 */
	public int countAll();

}