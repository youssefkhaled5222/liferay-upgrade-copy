/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.model.LovDataLocalization;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the lov data localization service. This utility wraps <code>com.ejada.telemony.db.service.persistence.impl.LovDataLocalizationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LovDataLocalizationPersistence
 * @generated
 */
public class LovDataLocalizationUtil {

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
	public static void clearCache(LovDataLocalization lovDataLocalization) {
		getPersistence().clearCache(lovDataLocalization);
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
	public static Map<Serializable, LovDataLocalization> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LovDataLocalization> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LovDataLocalization> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LovDataLocalization> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LovDataLocalization> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LovDataLocalization update(
		LovDataLocalization lovDataLocalization) {

		return getPersistence().update(lovDataLocalization);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LovDataLocalization update(
		LovDataLocalization lovDataLocalization,
		ServiceContext serviceContext) {

		return getPersistence().update(lovDataLocalization, serviceContext);
	}

	/**
	 * Returns all the lov data localizations where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching lov data localizations
	 */
	public static List<LovDataLocalization> findById(long id) {
		return getPersistence().findById(id);
	}

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
	public static List<LovDataLocalization> findById(
		long id, int start, int end) {

		return getPersistence().findById(id, start, end);
	}

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
	public static List<LovDataLocalization> findById(
		long id, int start, int end,
		OrderByComparator<LovDataLocalization> orderByComparator) {

		return getPersistence().findById(id, start, end, orderByComparator);
	}

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
	public static List<LovDataLocalization> findById(
		long id, int start, int end,
		OrderByComparator<LovDataLocalization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findById(
			id, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first lov data localization in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data localization
	 * @throws NoSuchLovDataLocalizationException if a matching lov data localization could not be found
	 */
	public static LovDataLocalization findById_First(
			long id, OrderByComparator<LovDataLocalization> orderByComparator)
		throws com.ejada.telemony.db.exception.
			NoSuchLovDataLocalizationException {

		return getPersistence().findById_First(id, orderByComparator);
	}

	/**
	 * Returns the first lov data localization in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data localization, or <code>null</code> if a matching lov data localization could not be found
	 */
	public static LovDataLocalization fetchById_First(
		long id, OrderByComparator<LovDataLocalization> orderByComparator) {

		return getPersistence().fetchById_First(id, orderByComparator);
	}

	/**
	 * Returns the last lov data localization in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data localization
	 * @throws NoSuchLovDataLocalizationException if a matching lov data localization could not be found
	 */
	public static LovDataLocalization findById_Last(
			long id, OrderByComparator<LovDataLocalization> orderByComparator)
		throws com.ejada.telemony.db.exception.
			NoSuchLovDataLocalizationException {

		return getPersistence().findById_Last(id, orderByComparator);
	}

	/**
	 * Returns the last lov data localization in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data localization, or <code>null</code> if a matching lov data localization could not be found
	 */
	public static LovDataLocalization fetchById_Last(
		long id, OrderByComparator<LovDataLocalization> orderByComparator) {

		return getPersistence().fetchById_Last(id, orderByComparator);
	}

	/**
	 * Returns the lov data localizations before and after the current lov data localization in the ordered set where id = &#63;.
	 *
	 * @param lovDataLocalizationId the primary key of the current lov data localization
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lov data localization
	 * @throws NoSuchLovDataLocalizationException if a lov data localization with the primary key could not be found
	 */
	public static LovDataLocalization[] findById_PrevAndNext(
			long lovDataLocalizationId, long id,
			OrderByComparator<LovDataLocalization> orderByComparator)
		throws com.ejada.telemony.db.exception.
			NoSuchLovDataLocalizationException {

		return getPersistence().findById_PrevAndNext(
			lovDataLocalizationId, id, orderByComparator);
	}

	/**
	 * Removes all the lov data localizations where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	public static void removeById(long id) {
		getPersistence().removeById(id);
	}

	/**
	 * Returns the number of lov data localizations where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching lov data localizations
	 */
	public static int countById(long id) {
		return getPersistence().countById(id);
	}

	/**
	 * Returns the lov data localization where id = &#63; and languageId = &#63; or throws a <code>NoSuchLovDataLocalizationException</code> if it could not be found.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @return the matching lov data localization
	 * @throws NoSuchLovDataLocalizationException if a matching lov data localization could not be found
	 */
	public static LovDataLocalization findById_LanguageId(
			long id, String languageId)
		throws com.ejada.telemony.db.exception.
			NoSuchLovDataLocalizationException {

		return getPersistence().findById_LanguageId(id, languageId);
	}

	/**
	 * Returns the lov data localization where id = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @return the matching lov data localization, or <code>null</code> if a matching lov data localization could not be found
	 */
	public static LovDataLocalization fetchById_LanguageId(
		long id, String languageId) {

		return getPersistence().fetchById_LanguageId(id, languageId);
	}

	/**
	 * Returns the lov data localization where id = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching lov data localization, or <code>null</code> if a matching lov data localization could not be found
	 */
	public static LovDataLocalization fetchById_LanguageId(
		long id, String languageId, boolean useFinderCache) {

		return getPersistence().fetchById_LanguageId(
			id, languageId, useFinderCache);
	}

	/**
	 * Removes the lov data localization where id = &#63; and languageId = &#63; from the database.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @return the lov data localization that was removed
	 */
	public static LovDataLocalization removeById_LanguageId(
			long id, String languageId)
		throws com.ejada.telemony.db.exception.
			NoSuchLovDataLocalizationException {

		return getPersistence().removeById_LanguageId(id, languageId);
	}

	/**
	 * Returns the number of lov data localizations where id = &#63; and languageId = &#63;.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @return the number of matching lov data localizations
	 */
	public static int countById_LanguageId(long id, String languageId) {
		return getPersistence().countById_LanguageId(id, languageId);
	}

	/**
	 * Returns all the lov data localizations where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @return the matching lov data localizations
	 */
	public static List<LovDataLocalization> findBylangId(String languageId) {
		return getPersistence().findBylangId(languageId);
	}

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
	public static List<LovDataLocalization> findBylangId(
		String languageId, int start, int end) {

		return getPersistence().findBylangId(languageId, start, end);
	}

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
	public static List<LovDataLocalization> findBylangId(
		String languageId, int start, int end,
		OrderByComparator<LovDataLocalization> orderByComparator) {

		return getPersistence().findBylangId(
			languageId, start, end, orderByComparator);
	}

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
	public static List<LovDataLocalization> findBylangId(
		String languageId, int start, int end,
		OrderByComparator<LovDataLocalization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBylangId(
			languageId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first lov data localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data localization
	 * @throws NoSuchLovDataLocalizationException if a matching lov data localization could not be found
	 */
	public static LovDataLocalization findBylangId_First(
			String languageId,
			OrderByComparator<LovDataLocalization> orderByComparator)
		throws com.ejada.telemony.db.exception.
			NoSuchLovDataLocalizationException {

		return getPersistence().findBylangId_First(
			languageId, orderByComparator);
	}

	/**
	 * Returns the first lov data localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data localization, or <code>null</code> if a matching lov data localization could not be found
	 */
	public static LovDataLocalization fetchBylangId_First(
		String languageId,
		OrderByComparator<LovDataLocalization> orderByComparator) {

		return getPersistence().fetchBylangId_First(
			languageId, orderByComparator);
	}

	/**
	 * Returns the last lov data localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data localization
	 * @throws NoSuchLovDataLocalizationException if a matching lov data localization could not be found
	 */
	public static LovDataLocalization findBylangId_Last(
			String languageId,
			OrderByComparator<LovDataLocalization> orderByComparator)
		throws com.ejada.telemony.db.exception.
			NoSuchLovDataLocalizationException {

		return getPersistence().findBylangId_Last(
			languageId, orderByComparator);
	}

	/**
	 * Returns the last lov data localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data localization, or <code>null</code> if a matching lov data localization could not be found
	 */
	public static LovDataLocalization fetchBylangId_Last(
		String languageId,
		OrderByComparator<LovDataLocalization> orderByComparator) {

		return getPersistence().fetchBylangId_Last(
			languageId, orderByComparator);
	}

	/**
	 * Returns the lov data localizations before and after the current lov data localization in the ordered set where languageId = &#63;.
	 *
	 * @param lovDataLocalizationId the primary key of the current lov data localization
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lov data localization
	 * @throws NoSuchLovDataLocalizationException if a lov data localization with the primary key could not be found
	 */
	public static LovDataLocalization[] findBylangId_PrevAndNext(
			long lovDataLocalizationId, String languageId,
			OrderByComparator<LovDataLocalization> orderByComparator)
		throws com.ejada.telemony.db.exception.
			NoSuchLovDataLocalizationException {

		return getPersistence().findBylangId_PrevAndNext(
			lovDataLocalizationId, languageId, orderByComparator);
	}

	/**
	 * Removes all the lov data localizations where languageId = &#63; from the database.
	 *
	 * @param languageId the language ID
	 */
	public static void removeBylangId(String languageId) {
		getPersistence().removeBylangId(languageId);
	}

	/**
	 * Returns the number of lov data localizations where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @return the number of matching lov data localizations
	 */
	public static int countBylangId(String languageId) {
		return getPersistence().countBylangId(languageId);
	}

	/**
	 * Returns all the lov data localizations where lovIdLocalization = &#63; and languageId = &#63;.
	 *
	 * @param lovIdLocalization the lov ID localization
	 * @param languageId the language ID
	 * @return the matching lov data localizations
	 */
	public static List<LovDataLocalization> findByLovsId(
		String lovIdLocalization, String languageId) {

		return getPersistence().findByLovsId(lovIdLocalization, languageId);
	}

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
	public static List<LovDataLocalization> findByLovsId(
		String lovIdLocalization, String languageId, int start, int end) {

		return getPersistence().findByLovsId(
			lovIdLocalization, languageId, start, end);
	}

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
	public static List<LovDataLocalization> findByLovsId(
		String lovIdLocalization, String languageId, int start, int end,
		OrderByComparator<LovDataLocalization> orderByComparator) {

		return getPersistence().findByLovsId(
			lovIdLocalization, languageId, start, end, orderByComparator);
	}

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
	public static List<LovDataLocalization> findByLovsId(
		String lovIdLocalization, String languageId, int start, int end,
		OrderByComparator<LovDataLocalization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByLovsId(
			lovIdLocalization, languageId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first lov data localization in the ordered set where lovIdLocalization = &#63; and languageId = &#63;.
	 *
	 * @param lovIdLocalization the lov ID localization
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data localization
	 * @throws NoSuchLovDataLocalizationException if a matching lov data localization could not be found
	 */
	public static LovDataLocalization findByLovsId_First(
			String lovIdLocalization, String languageId,
			OrderByComparator<LovDataLocalization> orderByComparator)
		throws com.ejada.telemony.db.exception.
			NoSuchLovDataLocalizationException {

		return getPersistence().findByLovsId_First(
			lovIdLocalization, languageId, orderByComparator);
	}

	/**
	 * Returns the first lov data localization in the ordered set where lovIdLocalization = &#63; and languageId = &#63;.
	 *
	 * @param lovIdLocalization the lov ID localization
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data localization, or <code>null</code> if a matching lov data localization could not be found
	 */
	public static LovDataLocalization fetchByLovsId_First(
		String lovIdLocalization, String languageId,
		OrderByComparator<LovDataLocalization> orderByComparator) {

		return getPersistence().fetchByLovsId_First(
			lovIdLocalization, languageId, orderByComparator);
	}

	/**
	 * Returns the last lov data localization in the ordered set where lovIdLocalization = &#63; and languageId = &#63;.
	 *
	 * @param lovIdLocalization the lov ID localization
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data localization
	 * @throws NoSuchLovDataLocalizationException if a matching lov data localization could not be found
	 */
	public static LovDataLocalization findByLovsId_Last(
			String lovIdLocalization, String languageId,
			OrderByComparator<LovDataLocalization> orderByComparator)
		throws com.ejada.telemony.db.exception.
			NoSuchLovDataLocalizationException {

		return getPersistence().findByLovsId_Last(
			lovIdLocalization, languageId, orderByComparator);
	}

	/**
	 * Returns the last lov data localization in the ordered set where lovIdLocalization = &#63; and languageId = &#63;.
	 *
	 * @param lovIdLocalization the lov ID localization
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data localization, or <code>null</code> if a matching lov data localization could not be found
	 */
	public static LovDataLocalization fetchByLovsId_Last(
		String lovIdLocalization, String languageId,
		OrderByComparator<LovDataLocalization> orderByComparator) {

		return getPersistence().fetchByLovsId_Last(
			lovIdLocalization, languageId, orderByComparator);
	}

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
	public static LovDataLocalization[] findByLovsId_PrevAndNext(
			long lovDataLocalizationId, String lovIdLocalization,
			String languageId,
			OrderByComparator<LovDataLocalization> orderByComparator)
		throws com.ejada.telemony.db.exception.
			NoSuchLovDataLocalizationException {

		return getPersistence().findByLovsId_PrevAndNext(
			lovDataLocalizationId, lovIdLocalization, languageId,
			orderByComparator);
	}

	/**
	 * Removes all the lov data localizations where lovIdLocalization = &#63; and languageId = &#63; from the database.
	 *
	 * @param lovIdLocalization the lov ID localization
	 * @param languageId the language ID
	 */
	public static void removeByLovsId(
		String lovIdLocalization, String languageId) {

		getPersistence().removeByLovsId(lovIdLocalization, languageId);
	}

	/**
	 * Returns the number of lov data localizations where lovIdLocalization = &#63; and languageId = &#63;.
	 *
	 * @param lovIdLocalization the lov ID localization
	 * @param languageId the language ID
	 * @return the number of matching lov data localizations
	 */
	public static int countByLovsId(
		String lovIdLocalization, String languageId) {

		return getPersistence().countByLovsId(lovIdLocalization, languageId);
	}

	/**
	 * Returns all the lov data localizations where id = &#63; and languageId = &#63; and recordDescription LIKE &#63;.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @param recordDescription the record description
	 * @return the matching lov data localizations
	 */
	public static List<LovDataLocalization> findBydescriptionAndLanguageId(
		long id, String languageId, String recordDescription) {

		return getPersistence().findBydescriptionAndLanguageId(
			id, languageId, recordDescription);
	}

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
	public static List<LovDataLocalization> findBydescriptionAndLanguageId(
		long id, String languageId, String recordDescription, int start,
		int end) {

		return getPersistence().findBydescriptionAndLanguageId(
			id, languageId, recordDescription, start, end);
	}

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
	public static List<LovDataLocalization> findBydescriptionAndLanguageId(
		long id, String languageId, String recordDescription, int start,
		int end, OrderByComparator<LovDataLocalization> orderByComparator) {

		return getPersistence().findBydescriptionAndLanguageId(
			id, languageId, recordDescription, start, end, orderByComparator);
	}

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
	public static List<LovDataLocalization> findBydescriptionAndLanguageId(
		long id, String languageId, String recordDescription, int start,
		int end, OrderByComparator<LovDataLocalization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydescriptionAndLanguageId(
			id, languageId, recordDescription, start, end, orderByComparator,
			useFinderCache);
	}

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
	public static LovDataLocalization findBydescriptionAndLanguageId_First(
			long id, String languageId, String recordDescription,
			OrderByComparator<LovDataLocalization> orderByComparator)
		throws com.ejada.telemony.db.exception.
			NoSuchLovDataLocalizationException {

		return getPersistence().findBydescriptionAndLanguageId_First(
			id, languageId, recordDescription, orderByComparator);
	}

	/**
	 * Returns the first lov data localization in the ordered set where id = &#63; and languageId = &#63; and recordDescription LIKE &#63;.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @param recordDescription the record description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data localization, or <code>null</code> if a matching lov data localization could not be found
	 */
	public static LovDataLocalization fetchBydescriptionAndLanguageId_First(
		long id, String languageId, String recordDescription,
		OrderByComparator<LovDataLocalization> orderByComparator) {

		return getPersistence().fetchBydescriptionAndLanguageId_First(
			id, languageId, recordDescription, orderByComparator);
	}

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
	public static LovDataLocalization findBydescriptionAndLanguageId_Last(
			long id, String languageId, String recordDescription,
			OrderByComparator<LovDataLocalization> orderByComparator)
		throws com.ejada.telemony.db.exception.
			NoSuchLovDataLocalizationException {

		return getPersistence().findBydescriptionAndLanguageId_Last(
			id, languageId, recordDescription, orderByComparator);
	}

	/**
	 * Returns the last lov data localization in the ordered set where id = &#63; and languageId = &#63; and recordDescription LIKE &#63;.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @param recordDescription the record description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data localization, or <code>null</code> if a matching lov data localization could not be found
	 */
	public static LovDataLocalization fetchBydescriptionAndLanguageId_Last(
		long id, String languageId, String recordDescription,
		OrderByComparator<LovDataLocalization> orderByComparator) {

		return getPersistence().fetchBydescriptionAndLanguageId_Last(
			id, languageId, recordDescription, orderByComparator);
	}

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
	public static LovDataLocalization[]
			findBydescriptionAndLanguageId_PrevAndNext(
				long lovDataLocalizationId, long id, String languageId,
				String recordDescription,
				OrderByComparator<LovDataLocalization> orderByComparator)
		throws com.ejada.telemony.db.exception.
			NoSuchLovDataLocalizationException {

		return getPersistence().findBydescriptionAndLanguageId_PrevAndNext(
			lovDataLocalizationId, id, languageId, recordDescription,
			orderByComparator);
	}

	/**
	 * Removes all the lov data localizations where id = &#63; and languageId = &#63; and recordDescription LIKE &#63; from the database.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @param recordDescription the record description
	 */
	public static void removeBydescriptionAndLanguageId(
		long id, String languageId, String recordDescription) {

		getPersistence().removeBydescriptionAndLanguageId(
			id, languageId, recordDescription);
	}

	/**
	 * Returns the number of lov data localizations where id = &#63; and languageId = &#63; and recordDescription LIKE &#63;.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @param recordDescription the record description
	 * @return the number of matching lov data localizations
	 */
	public static int countBydescriptionAndLanguageId(
		long id, String languageId, String recordDescription) {

		return getPersistence().countBydescriptionAndLanguageId(
			id, languageId, recordDescription);
	}

	/**
	 * Caches the lov data localization in the entity cache if it is enabled.
	 *
	 * @param lovDataLocalization the lov data localization
	 */
	public static void cacheResult(LovDataLocalization lovDataLocalization) {
		getPersistence().cacheResult(lovDataLocalization);
	}

	/**
	 * Caches the lov data localizations in the entity cache if it is enabled.
	 *
	 * @param lovDataLocalizations the lov data localizations
	 */
	public static void cacheResult(
		List<LovDataLocalization> lovDataLocalizations) {

		getPersistence().cacheResult(lovDataLocalizations);
	}

	/**
	 * Creates a new lov data localization with the primary key. Does not add the lov data localization to the database.
	 *
	 * @param lovDataLocalizationId the primary key for the new lov data localization
	 * @return the new lov data localization
	 */
	public static LovDataLocalization create(long lovDataLocalizationId) {
		return getPersistence().create(lovDataLocalizationId);
	}

	/**
	 * Removes the lov data localization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lovDataLocalizationId the primary key of the lov data localization
	 * @return the lov data localization that was removed
	 * @throws NoSuchLovDataLocalizationException if a lov data localization with the primary key could not be found
	 */
	public static LovDataLocalization remove(long lovDataLocalizationId)
		throws com.ejada.telemony.db.exception.
			NoSuchLovDataLocalizationException {

		return getPersistence().remove(lovDataLocalizationId);
	}

	public static LovDataLocalization updateImpl(
		LovDataLocalization lovDataLocalization) {

		return getPersistence().updateImpl(lovDataLocalization);
	}

	/**
	 * Returns the lov data localization with the primary key or throws a <code>NoSuchLovDataLocalizationException</code> if it could not be found.
	 *
	 * @param lovDataLocalizationId the primary key of the lov data localization
	 * @return the lov data localization
	 * @throws NoSuchLovDataLocalizationException if a lov data localization with the primary key could not be found
	 */
	public static LovDataLocalization findByPrimaryKey(
			long lovDataLocalizationId)
		throws com.ejada.telemony.db.exception.
			NoSuchLovDataLocalizationException {

		return getPersistence().findByPrimaryKey(lovDataLocalizationId);
	}

	/**
	 * Returns the lov data localization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lovDataLocalizationId the primary key of the lov data localization
	 * @return the lov data localization, or <code>null</code> if a lov data localization with the primary key could not be found
	 */
	public static LovDataLocalization fetchByPrimaryKey(
		long lovDataLocalizationId) {

		return getPersistence().fetchByPrimaryKey(lovDataLocalizationId);
	}

	/**
	 * Returns all the lov data localizations.
	 *
	 * @return the lov data localizations
	 */
	public static List<LovDataLocalization> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<LovDataLocalization> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<LovDataLocalization> findAll(
		int start, int end,
		OrderByComparator<LovDataLocalization> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<LovDataLocalization> findAll(
		int start, int end,
		OrderByComparator<LovDataLocalization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the lov data localizations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of lov data localizations.
	 *
	 * @return the number of lov data localizations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LovDataLocalizationPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		LovDataLocalizationPersistence persistence) {

		_persistence = persistence;
	}

	private static volatile LovDataLocalizationPersistence _persistence;

}