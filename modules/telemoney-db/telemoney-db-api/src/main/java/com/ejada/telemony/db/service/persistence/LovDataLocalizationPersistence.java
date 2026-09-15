/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.exception.NoSuchLovDataLocalizationException;
import com.ejada.telemony.db.model.LovDataLocalization;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the lov data localization service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LovDataLocalizationUtil
 * @generated
 */
@ProviderType
public interface LovDataLocalizationPersistence
	extends BasePersistence<LovDataLocalization> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LovDataLocalizationUtil} to access the lov data localization persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the lov data localizations where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching lov data localizations
	 */
	public java.util.List<LovDataLocalization> findById(long id);

	/**
	 * Returns a range of all the lov data localizations where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of lov data localizations
	 * @param end the upper bound of the range of lov data localizations (not inclusive)
	 * @return the range of matching lov data localizations
	 */
	public java.util.List<LovDataLocalization> findById(
		long id, int start, int end);

	/**
	 * Returns an ordered range of all the lov data localizations where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of lov data localizations
	 * @param end the upper bound of the range of lov data localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lov data localizations
	 */
	public java.util.List<LovDataLocalization> findById(
		long id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LovDataLocalization>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lov data localizations where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of lov data localizations
	 * @param end the upper bound of the range of lov data localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lov data localizations
	 */
	public java.util.List<LovDataLocalization> findById(
		long id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LovDataLocalization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first lov data localization in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data localization
	 * @throws NoSuchLovDataLocalizationException if a matching lov data localization could not be found
	 */
	public LovDataLocalization findById_First(
			long id,
			com.liferay.portal.kernel.util.OrderByComparator
				<LovDataLocalization> orderByComparator)
		throws NoSuchLovDataLocalizationException;

	/**
	 * Returns the first lov data localization in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data localization, or <code>null</code> if a matching lov data localization could not be found
	 */
	public LovDataLocalization fetchById_First(
		long id,
		com.liferay.portal.kernel.util.OrderByComparator<LovDataLocalization>
			orderByComparator);

	/**
	 * Returns the last lov data localization in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data localization
	 * @throws NoSuchLovDataLocalizationException if a matching lov data localization could not be found
	 */
	public LovDataLocalization findById_Last(
			long id,
			com.liferay.portal.kernel.util.OrderByComparator
				<LovDataLocalization> orderByComparator)
		throws NoSuchLovDataLocalizationException;

	/**
	 * Returns the last lov data localization in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data localization, or <code>null</code> if a matching lov data localization could not be found
	 */
	public LovDataLocalization fetchById_Last(
		long id,
		com.liferay.portal.kernel.util.OrderByComparator<LovDataLocalization>
			orderByComparator);

	/**
	 * Returns the lov data localizations before and after the current lov data localization in the ordered set where id = &#63;.
	 *
	 * @param lovDataLocalizationId the primary key of the current lov data localization
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lov data localization
	 * @throws NoSuchLovDataLocalizationException if a lov data localization with the primary key could not be found
	 */
	public LovDataLocalization[] findById_PrevAndNext(
			long lovDataLocalizationId, long id,
			com.liferay.portal.kernel.util.OrderByComparator
				<LovDataLocalization> orderByComparator)
		throws NoSuchLovDataLocalizationException;

	/**
	 * Removes all the lov data localizations where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	public void removeById(long id);

	/**
	 * Returns the number of lov data localizations where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching lov data localizations
	 */
	public int countById(long id);

	/**
	 * Returns the lov data localization where id = &#63; and languageId = &#63; or throws a <code>NoSuchLovDataLocalizationException</code> if it could not be found.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @return the matching lov data localization
	 * @throws NoSuchLovDataLocalizationException if a matching lov data localization could not be found
	 */
	public LovDataLocalization findById_LanguageId(long id, String languageId)
		throws NoSuchLovDataLocalizationException;

	/**
	 * Returns the lov data localization where id = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @return the matching lov data localization, or <code>null</code> if a matching lov data localization could not be found
	 */
	public LovDataLocalization fetchById_LanguageId(long id, String languageId);

	/**
	 * Returns the lov data localization where id = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching lov data localization, or <code>null</code> if a matching lov data localization could not be found
	 */
	public LovDataLocalization fetchById_LanguageId(
		long id, String languageId, boolean useFinderCache);

	/**
	 * Removes the lov data localization where id = &#63; and languageId = &#63; from the database.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @return the lov data localization that was removed
	 */
	public LovDataLocalization removeById_LanguageId(long id, String languageId)
		throws NoSuchLovDataLocalizationException;

	/**
	 * Returns the number of lov data localizations where id = &#63; and languageId = &#63;.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @return the number of matching lov data localizations
	 */
	public int countById_LanguageId(long id, String languageId);

	/**
	 * Returns all the lov data localizations where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @return the matching lov data localizations
	 */
	public java.util.List<LovDataLocalization> findBylangId(String languageId);

	/**
	 * Returns a range of all the lov data localizations where languageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param start the lower bound of the range of lov data localizations
	 * @param end the upper bound of the range of lov data localizations (not inclusive)
	 * @return the range of matching lov data localizations
	 */
	public java.util.List<LovDataLocalization> findBylangId(
		String languageId, int start, int end);

	/**
	 * Returns an ordered range of all the lov data localizations where languageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param start the lower bound of the range of lov data localizations
	 * @param end the upper bound of the range of lov data localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lov data localizations
	 */
	public java.util.List<LovDataLocalization> findBylangId(
		String languageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LovDataLocalization>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lov data localizations where languageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param start the lower bound of the range of lov data localizations
	 * @param end the upper bound of the range of lov data localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lov data localizations
	 */
	public java.util.List<LovDataLocalization> findBylangId(
		String languageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LovDataLocalization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first lov data localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data localization
	 * @throws NoSuchLovDataLocalizationException if a matching lov data localization could not be found
	 */
	public LovDataLocalization findBylangId_First(
			String languageId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LovDataLocalization> orderByComparator)
		throws NoSuchLovDataLocalizationException;

	/**
	 * Returns the first lov data localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data localization, or <code>null</code> if a matching lov data localization could not be found
	 */
	public LovDataLocalization fetchBylangId_First(
		String languageId,
		com.liferay.portal.kernel.util.OrderByComparator<LovDataLocalization>
			orderByComparator);

	/**
	 * Returns the last lov data localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data localization
	 * @throws NoSuchLovDataLocalizationException if a matching lov data localization could not be found
	 */
	public LovDataLocalization findBylangId_Last(
			String languageId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LovDataLocalization> orderByComparator)
		throws NoSuchLovDataLocalizationException;

	/**
	 * Returns the last lov data localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data localization, or <code>null</code> if a matching lov data localization could not be found
	 */
	public LovDataLocalization fetchBylangId_Last(
		String languageId,
		com.liferay.portal.kernel.util.OrderByComparator<LovDataLocalization>
			orderByComparator);

	/**
	 * Returns the lov data localizations before and after the current lov data localization in the ordered set where languageId = &#63;.
	 *
	 * @param lovDataLocalizationId the primary key of the current lov data localization
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lov data localization
	 * @throws NoSuchLovDataLocalizationException if a lov data localization with the primary key could not be found
	 */
	public LovDataLocalization[] findBylangId_PrevAndNext(
			long lovDataLocalizationId, String languageId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LovDataLocalization> orderByComparator)
		throws NoSuchLovDataLocalizationException;

	/**
	 * Removes all the lov data localizations where languageId = &#63; from the database.
	 *
	 * @param languageId the language ID
	 */
	public void removeBylangId(String languageId);

	/**
	 * Returns the number of lov data localizations where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @return the number of matching lov data localizations
	 */
	public int countBylangId(String languageId);

	/**
	 * Returns all the lov data localizations where lovIdLocalization = &#63; and languageId = &#63;.
	 *
	 * @param lovIdLocalization the lov ID localization
	 * @param languageId the language ID
	 * @return the matching lov data localizations
	 */
	public java.util.List<LovDataLocalization> findByLovsId(
		String lovIdLocalization, String languageId);

	/**
	 * Returns a range of all the lov data localizations where lovIdLocalization = &#63; and languageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param lovIdLocalization the lov ID localization
	 * @param languageId the language ID
	 * @param start the lower bound of the range of lov data localizations
	 * @param end the upper bound of the range of lov data localizations (not inclusive)
	 * @return the range of matching lov data localizations
	 */
	public java.util.List<LovDataLocalization> findByLovsId(
		String lovIdLocalization, String languageId, int start, int end);

	/**
	 * Returns an ordered range of all the lov data localizations where lovIdLocalization = &#63; and languageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param lovIdLocalization the lov ID localization
	 * @param languageId the language ID
	 * @param start the lower bound of the range of lov data localizations
	 * @param end the upper bound of the range of lov data localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lov data localizations
	 */
	public java.util.List<LovDataLocalization> findByLovsId(
		String lovIdLocalization, String languageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LovDataLocalization>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lov data localizations where lovIdLocalization = &#63; and languageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param lovIdLocalization the lov ID localization
	 * @param languageId the language ID
	 * @param start the lower bound of the range of lov data localizations
	 * @param end the upper bound of the range of lov data localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lov data localizations
	 */
	public java.util.List<LovDataLocalization> findByLovsId(
		String lovIdLocalization, String languageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LovDataLocalization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first lov data localization in the ordered set where lovIdLocalization = &#63; and languageId = &#63;.
	 *
	 * @param lovIdLocalization the lov ID localization
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data localization
	 * @throws NoSuchLovDataLocalizationException if a matching lov data localization could not be found
	 */
	public LovDataLocalization findByLovsId_First(
			String lovIdLocalization, String languageId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LovDataLocalization> orderByComparator)
		throws NoSuchLovDataLocalizationException;

	/**
	 * Returns the first lov data localization in the ordered set where lovIdLocalization = &#63; and languageId = &#63;.
	 *
	 * @param lovIdLocalization the lov ID localization
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data localization, or <code>null</code> if a matching lov data localization could not be found
	 */
	public LovDataLocalization fetchByLovsId_First(
		String lovIdLocalization, String languageId,
		com.liferay.portal.kernel.util.OrderByComparator<LovDataLocalization>
			orderByComparator);

	/**
	 * Returns the last lov data localization in the ordered set where lovIdLocalization = &#63; and languageId = &#63;.
	 *
	 * @param lovIdLocalization the lov ID localization
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data localization
	 * @throws NoSuchLovDataLocalizationException if a matching lov data localization could not be found
	 */
	public LovDataLocalization findByLovsId_Last(
			String lovIdLocalization, String languageId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LovDataLocalization> orderByComparator)
		throws NoSuchLovDataLocalizationException;

	/**
	 * Returns the last lov data localization in the ordered set where lovIdLocalization = &#63; and languageId = &#63;.
	 *
	 * @param lovIdLocalization the lov ID localization
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data localization, or <code>null</code> if a matching lov data localization could not be found
	 */
	public LovDataLocalization fetchByLovsId_Last(
		String lovIdLocalization, String languageId,
		com.liferay.portal.kernel.util.OrderByComparator<LovDataLocalization>
			orderByComparator);

	/**
	 * Returns the lov data localizations before and after the current lov data localization in the ordered set where lovIdLocalization = &#63; and languageId = &#63;.
	 *
	 * @param lovDataLocalizationId the primary key of the current lov data localization
	 * @param lovIdLocalization the lov ID localization
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lov data localization
	 * @throws NoSuchLovDataLocalizationException if a lov data localization with the primary key could not be found
	 */
	public LovDataLocalization[] findByLovsId_PrevAndNext(
			long lovDataLocalizationId, String lovIdLocalization,
			String languageId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LovDataLocalization> orderByComparator)
		throws NoSuchLovDataLocalizationException;

	/**
	 * Removes all the lov data localizations where lovIdLocalization = &#63; and languageId = &#63; from the database.
	 *
	 * @param lovIdLocalization the lov ID localization
	 * @param languageId the language ID
	 */
	public void removeByLovsId(String lovIdLocalization, String languageId);

	/**
	 * Returns the number of lov data localizations where lovIdLocalization = &#63; and languageId = &#63;.
	 *
	 * @param lovIdLocalization the lov ID localization
	 * @param languageId the language ID
	 * @return the number of matching lov data localizations
	 */
	public int countByLovsId(String lovIdLocalization, String languageId);

	/**
	 * Returns all the lov data localizations where id = &#63; and languageId = &#63; and recordDescription LIKE &#63;.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @param recordDescription the record description
	 * @return the matching lov data localizations
	 */
	public java.util.List<LovDataLocalization> findBydescriptionAndLanguageId(
		long id, String languageId, String recordDescription);

	/**
	 * Returns a range of all the lov data localizations where id = &#63; and languageId = &#63; and recordDescription LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @param recordDescription the record description
	 * @param start the lower bound of the range of lov data localizations
	 * @param end the upper bound of the range of lov data localizations (not inclusive)
	 * @return the range of matching lov data localizations
	 */
	public java.util.List<LovDataLocalization> findBydescriptionAndLanguageId(
		long id, String languageId, String recordDescription, int start,
		int end);

	/**
	 * Returns an ordered range of all the lov data localizations where id = &#63; and languageId = &#63; and recordDescription LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @param recordDescription the record description
	 * @param start the lower bound of the range of lov data localizations
	 * @param end the upper bound of the range of lov data localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lov data localizations
	 */
	public java.util.List<LovDataLocalization> findBydescriptionAndLanguageId(
		long id, String languageId, String recordDescription, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<LovDataLocalization>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lov data localizations where id = &#63; and languageId = &#63; and recordDescription LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @param recordDescription the record description
	 * @param start the lower bound of the range of lov data localizations
	 * @param end the upper bound of the range of lov data localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lov data localizations
	 */
	public java.util.List<LovDataLocalization> findBydescriptionAndLanguageId(
		long id, String languageId, String recordDescription, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<LovDataLocalization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first lov data localization in the ordered set where id = &#63; and languageId = &#63; and recordDescription LIKE &#63;.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @param recordDescription the record description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data localization
	 * @throws NoSuchLovDataLocalizationException if a matching lov data localization could not be found
	 */
	public LovDataLocalization findBydescriptionAndLanguageId_First(
			long id, String languageId, String recordDescription,
			com.liferay.portal.kernel.util.OrderByComparator
				<LovDataLocalization> orderByComparator)
		throws NoSuchLovDataLocalizationException;

	/**
	 * Returns the first lov data localization in the ordered set where id = &#63; and languageId = &#63; and recordDescription LIKE &#63;.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @param recordDescription the record description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data localization, or <code>null</code> if a matching lov data localization could not be found
	 */
	public LovDataLocalization fetchBydescriptionAndLanguageId_First(
		long id, String languageId, String recordDescription,
		com.liferay.portal.kernel.util.OrderByComparator<LovDataLocalization>
			orderByComparator);

	/**
	 * Returns the last lov data localization in the ordered set where id = &#63; and languageId = &#63; and recordDescription LIKE &#63;.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @param recordDescription the record description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data localization
	 * @throws NoSuchLovDataLocalizationException if a matching lov data localization could not be found
	 */
	public LovDataLocalization findBydescriptionAndLanguageId_Last(
			long id, String languageId, String recordDescription,
			com.liferay.portal.kernel.util.OrderByComparator
				<LovDataLocalization> orderByComparator)
		throws NoSuchLovDataLocalizationException;

	/**
	 * Returns the last lov data localization in the ordered set where id = &#63; and languageId = &#63; and recordDescription LIKE &#63;.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @param recordDescription the record description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data localization, or <code>null</code> if a matching lov data localization could not be found
	 */
	public LovDataLocalization fetchBydescriptionAndLanguageId_Last(
		long id, String languageId, String recordDescription,
		com.liferay.portal.kernel.util.OrderByComparator<LovDataLocalization>
			orderByComparator);

	/**
	 * Returns the lov data localizations before and after the current lov data localization in the ordered set where id = &#63; and languageId = &#63; and recordDescription LIKE &#63;.
	 *
	 * @param lovDataLocalizationId the primary key of the current lov data localization
	 * @param id the ID
	 * @param languageId the language ID
	 * @param recordDescription the record description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lov data localization
	 * @throws NoSuchLovDataLocalizationException if a lov data localization with the primary key could not be found
	 */
	public LovDataLocalization[] findBydescriptionAndLanguageId_PrevAndNext(
			long lovDataLocalizationId, long id, String languageId,
			String recordDescription,
			com.liferay.portal.kernel.util.OrderByComparator
				<LovDataLocalization> orderByComparator)
		throws NoSuchLovDataLocalizationException;

	/**
	 * Removes all the lov data localizations where id = &#63; and languageId = &#63; and recordDescription LIKE &#63; from the database.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @param recordDescription the record description
	 */
	public void removeBydescriptionAndLanguageId(
		long id, String languageId, String recordDescription);

	/**
	 * Returns the number of lov data localizations where id = &#63; and languageId = &#63; and recordDescription LIKE &#63;.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @param recordDescription the record description
	 * @return the number of matching lov data localizations
	 */
	public int countBydescriptionAndLanguageId(
		long id, String languageId, String recordDescription);

	/**
	 * Caches the lov data localization in the entity cache if it is enabled.
	 *
	 * @param lovDataLocalization the lov data localization
	 */
	public void cacheResult(LovDataLocalization lovDataLocalization);

	/**
	 * Caches the lov data localizations in the entity cache if it is enabled.
	 *
	 * @param lovDataLocalizations the lov data localizations
	 */
	public void cacheResult(
		java.util.List<LovDataLocalization> lovDataLocalizations);

	/**
	 * Creates a new lov data localization with the primary key. Does not add the lov data localization to the database.
	 *
	 * @param lovDataLocalizationId the primary key for the new lov data localization
	 * @return the new lov data localization
	 */
	public LovDataLocalization create(long lovDataLocalizationId);

	/**
	 * Removes the lov data localization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lovDataLocalizationId the primary key of the lov data localization
	 * @return the lov data localization that was removed
	 * @throws NoSuchLovDataLocalizationException if a lov data localization with the primary key could not be found
	 */
	public LovDataLocalization remove(long lovDataLocalizationId)
		throws NoSuchLovDataLocalizationException;

	public LovDataLocalization updateImpl(
		LovDataLocalization lovDataLocalization);

	/**
	 * Returns the lov data localization with the primary key or throws a <code>NoSuchLovDataLocalizationException</code> if it could not be found.
	 *
	 * @param lovDataLocalizationId the primary key of the lov data localization
	 * @return the lov data localization
	 * @throws NoSuchLovDataLocalizationException if a lov data localization with the primary key could not be found
	 */
	public LovDataLocalization findByPrimaryKey(long lovDataLocalizationId)
		throws NoSuchLovDataLocalizationException;

	/**
	 * Returns the lov data localization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lovDataLocalizationId the primary key of the lov data localization
	 * @return the lov data localization, or <code>null</code> if a lov data localization with the primary key could not be found
	 */
	public LovDataLocalization fetchByPrimaryKey(long lovDataLocalizationId);

	/**
	 * Returns all the lov data localizations.
	 *
	 * @return the lov data localizations
	 */
	public java.util.List<LovDataLocalization> findAll();

	/**
	 * Returns a range of all the lov data localizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lov data localizations
	 * @param end the upper bound of the range of lov data localizations (not inclusive)
	 * @return the range of lov data localizations
	 */
	public java.util.List<LovDataLocalization> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the lov data localizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lov data localizations
	 * @param end the upper bound of the range of lov data localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lov data localizations
	 */
	public java.util.List<LovDataLocalization> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LovDataLocalization>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lov data localizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lov data localizations
	 * @param end the upper bound of the range of lov data localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of lov data localizations
	 */
	public java.util.List<LovDataLocalization> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LovDataLocalization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the lov data localizations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of lov data localizations.
	 *
	 * @return the number of lov data localizations
	 */
	public int countAll();

}