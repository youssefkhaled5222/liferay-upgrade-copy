/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.model.LovsLocalization;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the lovs localization service. This utility wraps <code>com.ejada.telemony.db.service.persistence.impl.LovsLocalizationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LovsLocalizationPersistence
 * @generated
 */
public class LovsLocalizationUtil {

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
	public static void clearCache(LovsLocalization lovsLocalization) {
		getPersistence().clearCache(lovsLocalization);
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
	public static Map<Serializable, LovsLocalization> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LovsLocalization> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LovsLocalization> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LovsLocalization> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LovsLocalization> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LovsLocalization update(LovsLocalization lovsLocalization) {
		return getPersistence().update(lovsLocalization);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LovsLocalization update(
		LovsLocalization lovsLocalization, ServiceContext serviceContext) {

		return getPersistence().update(lovsLocalization, serviceContext);
	}

	/**
	 * Returns all the lovs localizations where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching lovs localizations
	 */
	public static List<LovsLocalization> findById(long id) {
		return getPersistence().findById(id);
	}

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
	public static List<LovsLocalization> findById(long id, int start, int end) {
		return getPersistence().findById(id, start, end);
	}

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
	public static List<LovsLocalization> findById(
		long id, int start, int end,
		OrderByComparator<LovsLocalization> orderByComparator) {

		return getPersistence().findById(id, start, end, orderByComparator);
	}

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
	public static List<LovsLocalization> findById(
		long id, int start, int end,
		OrderByComparator<LovsLocalization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findById(
			id, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first lovs localization in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs localization
	 * @throws NoSuchLovsLocalizationException if a matching lovs localization could not be found
	 */
	public static LovsLocalization findById_First(
			long id, OrderByComparator<LovsLocalization> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLovsLocalizationException {

		return getPersistence().findById_First(id, orderByComparator);
	}

	/**
	 * Returns the first lovs localization in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs localization, or <code>null</code> if a matching lovs localization could not be found
	 */
	public static LovsLocalization fetchById_First(
		long id, OrderByComparator<LovsLocalization> orderByComparator) {

		return getPersistence().fetchById_First(id, orderByComparator);
	}

	/**
	 * Returns the last lovs localization in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs localization
	 * @throws NoSuchLovsLocalizationException if a matching lovs localization could not be found
	 */
	public static LovsLocalization findById_Last(
			long id, OrderByComparator<LovsLocalization> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLovsLocalizationException {

		return getPersistence().findById_Last(id, orderByComparator);
	}

	/**
	 * Returns the last lovs localization in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs localization, or <code>null</code> if a matching lovs localization could not be found
	 */
	public static LovsLocalization fetchById_Last(
		long id, OrderByComparator<LovsLocalization> orderByComparator) {

		return getPersistence().fetchById_Last(id, orderByComparator);
	}

	/**
	 * Returns the lovs localizations before and after the current lovs localization in the ordered set where id = &#63;.
	 *
	 * @param lovsLocalizationId the primary key of the current lovs localization
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lovs localization
	 * @throws NoSuchLovsLocalizationException if a lovs localization with the primary key could not be found
	 */
	public static LovsLocalization[] findById_PrevAndNext(
			long lovsLocalizationId, long id,
			OrderByComparator<LovsLocalization> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLovsLocalizationException {

		return getPersistence().findById_PrevAndNext(
			lovsLocalizationId, id, orderByComparator);
	}

	/**
	 * Removes all the lovs localizations where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	public static void removeById(long id) {
		getPersistence().removeById(id);
	}

	/**
	 * Returns the number of lovs localizations where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching lovs localizations
	 */
	public static int countById(long id) {
		return getPersistence().countById(id);
	}

	/**
	 * Returns the lovs localization where id = &#63; and languageId = &#63; or throws a <code>NoSuchLovsLocalizationException</code> if it could not be found.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @return the matching lovs localization
	 * @throws NoSuchLovsLocalizationException if a matching lovs localization could not be found
	 */
	public static LovsLocalization findById_LanguageId(
			long id, String languageId)
		throws com.ejada.telemony.db.exception.NoSuchLovsLocalizationException {

		return getPersistence().findById_LanguageId(id, languageId);
	}

	/**
	 * Returns the lovs localization where id = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @return the matching lovs localization, or <code>null</code> if a matching lovs localization could not be found
	 */
	public static LovsLocalization fetchById_LanguageId(
		long id, String languageId) {

		return getPersistence().fetchById_LanguageId(id, languageId);
	}

	/**
	 * Returns the lovs localization where id = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching lovs localization, or <code>null</code> if a matching lovs localization could not be found
	 */
	public static LovsLocalization fetchById_LanguageId(
		long id, String languageId, boolean useFinderCache) {

		return getPersistence().fetchById_LanguageId(
			id, languageId, useFinderCache);
	}

	/**
	 * Removes the lovs localization where id = &#63; and languageId = &#63; from the database.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @return the lovs localization that was removed
	 */
	public static LovsLocalization removeById_LanguageId(
			long id, String languageId)
		throws com.ejada.telemony.db.exception.NoSuchLovsLocalizationException {

		return getPersistence().removeById_LanguageId(id, languageId);
	}

	/**
	 * Returns the number of lovs localizations where id = &#63; and languageId = &#63;.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @return the number of matching lovs localizations
	 */
	public static int countById_LanguageId(long id, String languageId) {
		return getPersistence().countById_LanguageId(id, languageId);
	}

	/**
	 * Returns all the lovs localizations where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @return the matching lovs localizations
	 */
	public static List<LovsLocalization> findBylangId(String languageId) {
		return getPersistence().findBylangId(languageId);
	}

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
	public static List<LovsLocalization> findBylangId(
		String languageId, int start, int end) {

		return getPersistence().findBylangId(languageId, start, end);
	}

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
	public static List<LovsLocalization> findBylangId(
		String languageId, int start, int end,
		OrderByComparator<LovsLocalization> orderByComparator) {

		return getPersistence().findBylangId(
			languageId, start, end, orderByComparator);
	}

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
	public static List<LovsLocalization> findBylangId(
		String languageId, int start, int end,
		OrderByComparator<LovsLocalization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBylangId(
			languageId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first lovs localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs localization
	 * @throws NoSuchLovsLocalizationException if a matching lovs localization could not be found
	 */
	public static LovsLocalization findBylangId_First(
			String languageId,
			OrderByComparator<LovsLocalization> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLovsLocalizationException {

		return getPersistence().findBylangId_First(
			languageId, orderByComparator);
	}

	/**
	 * Returns the first lovs localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs localization, or <code>null</code> if a matching lovs localization could not be found
	 */
	public static LovsLocalization fetchBylangId_First(
		String languageId,
		OrderByComparator<LovsLocalization> orderByComparator) {

		return getPersistence().fetchBylangId_First(
			languageId, orderByComparator);
	}

	/**
	 * Returns the last lovs localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs localization
	 * @throws NoSuchLovsLocalizationException if a matching lovs localization could not be found
	 */
	public static LovsLocalization findBylangId_Last(
			String languageId,
			OrderByComparator<LovsLocalization> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLovsLocalizationException {

		return getPersistence().findBylangId_Last(
			languageId, orderByComparator);
	}

	/**
	 * Returns the last lovs localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs localization, or <code>null</code> if a matching lovs localization could not be found
	 */
	public static LovsLocalization fetchBylangId_Last(
		String languageId,
		OrderByComparator<LovsLocalization> orderByComparator) {

		return getPersistence().fetchBylangId_Last(
			languageId, orderByComparator);
	}

	/**
	 * Returns the lovs localizations before and after the current lovs localization in the ordered set where languageId = &#63;.
	 *
	 * @param lovsLocalizationId the primary key of the current lovs localization
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lovs localization
	 * @throws NoSuchLovsLocalizationException if a lovs localization with the primary key could not be found
	 */
	public static LovsLocalization[] findBylangId_PrevAndNext(
			long lovsLocalizationId, String languageId,
			OrderByComparator<LovsLocalization> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLovsLocalizationException {

		return getPersistence().findBylangId_PrevAndNext(
			lovsLocalizationId, languageId, orderByComparator);
	}

	/**
	 * Removes all the lovs localizations where languageId = &#63; from the database.
	 *
	 * @param languageId the language ID
	 */
	public static void removeBylangId(String languageId) {
		getPersistence().removeBylangId(languageId);
	}

	/**
	 * Returns the number of lovs localizations where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @return the number of matching lovs localizations
	 */
	public static int countBylangId(String languageId) {
		return getPersistence().countBylangId(languageId);
	}

	/**
	 * Returns all the lovs localizations where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @return the matching lovs localizations
	 */
	public static List<LovsLocalization> findBynameAndLanguageId(
		String languageId, String name) {

		return getPersistence().findBynameAndLanguageId(languageId, name);
	}

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
	public static List<LovsLocalization> findBynameAndLanguageId(
		String languageId, String name, int start, int end) {

		return getPersistence().findBynameAndLanguageId(
			languageId, name, start, end);
	}

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
	public static List<LovsLocalization> findBynameAndLanguageId(
		String languageId, String name, int start, int end,
		OrderByComparator<LovsLocalization> orderByComparator) {

		return getPersistence().findBynameAndLanguageId(
			languageId, name, start, end, orderByComparator);
	}

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
	public static List<LovsLocalization> findBynameAndLanguageId(
		String languageId, String name, int start, int end,
		OrderByComparator<LovsLocalization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBynameAndLanguageId(
			languageId, name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first lovs localization in the ordered set where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs localization
	 * @throws NoSuchLovsLocalizationException if a matching lovs localization could not be found
	 */
	public static LovsLocalization findBynameAndLanguageId_First(
			String languageId, String name,
			OrderByComparator<LovsLocalization> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLovsLocalizationException {

		return getPersistence().findBynameAndLanguageId_First(
			languageId, name, orderByComparator);
	}

	/**
	 * Returns the first lovs localization in the ordered set where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs localization, or <code>null</code> if a matching lovs localization could not be found
	 */
	public static LovsLocalization fetchBynameAndLanguageId_First(
		String languageId, String name,
		OrderByComparator<LovsLocalization> orderByComparator) {

		return getPersistence().fetchBynameAndLanguageId_First(
			languageId, name, orderByComparator);
	}

	/**
	 * Returns the last lovs localization in the ordered set where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs localization
	 * @throws NoSuchLovsLocalizationException if a matching lovs localization could not be found
	 */
	public static LovsLocalization findBynameAndLanguageId_Last(
			String languageId, String name,
			OrderByComparator<LovsLocalization> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLovsLocalizationException {

		return getPersistence().findBynameAndLanguageId_Last(
			languageId, name, orderByComparator);
	}

	/**
	 * Returns the last lovs localization in the ordered set where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs localization, or <code>null</code> if a matching lovs localization could not be found
	 */
	public static LovsLocalization fetchBynameAndLanguageId_Last(
		String languageId, String name,
		OrderByComparator<LovsLocalization> orderByComparator) {

		return getPersistence().fetchBynameAndLanguageId_Last(
			languageId, name, orderByComparator);
	}

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
	public static LovsLocalization[] findBynameAndLanguageId_PrevAndNext(
			long lovsLocalizationId, String languageId, String name,
			OrderByComparator<LovsLocalization> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLovsLocalizationException {

		return getPersistence().findBynameAndLanguageId_PrevAndNext(
			lovsLocalizationId, languageId, name, orderByComparator);
	}

	/**
	 * Removes all the lovs localizations where languageId = &#63; and name LIKE &#63; from the database.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 */
	public static void removeBynameAndLanguageId(
		String languageId, String name) {

		getPersistence().removeBynameAndLanguageId(languageId, name);
	}

	/**
	 * Returns the number of lovs localizations where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @return the number of matching lovs localizations
	 */
	public static int countBynameAndLanguageId(String languageId, String name) {
		return getPersistence().countBynameAndLanguageId(languageId, name);
	}

	/**
	 * Caches the lovs localization in the entity cache if it is enabled.
	 *
	 * @param lovsLocalization the lovs localization
	 */
	public static void cacheResult(LovsLocalization lovsLocalization) {
		getPersistence().cacheResult(lovsLocalization);
	}

	/**
	 * Caches the lovs localizations in the entity cache if it is enabled.
	 *
	 * @param lovsLocalizations the lovs localizations
	 */
	public static void cacheResult(List<LovsLocalization> lovsLocalizations) {
		getPersistence().cacheResult(lovsLocalizations);
	}

	/**
	 * Creates a new lovs localization with the primary key. Does not add the lovs localization to the database.
	 *
	 * @param lovsLocalizationId the primary key for the new lovs localization
	 * @return the new lovs localization
	 */
	public static LovsLocalization create(long lovsLocalizationId) {
		return getPersistence().create(lovsLocalizationId);
	}

	/**
	 * Removes the lovs localization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lovsLocalizationId the primary key of the lovs localization
	 * @return the lovs localization that was removed
	 * @throws NoSuchLovsLocalizationException if a lovs localization with the primary key could not be found
	 */
	public static LovsLocalization remove(long lovsLocalizationId)
		throws com.ejada.telemony.db.exception.NoSuchLovsLocalizationException {

		return getPersistence().remove(lovsLocalizationId);
	}

	public static LovsLocalization updateImpl(
		LovsLocalization lovsLocalization) {

		return getPersistence().updateImpl(lovsLocalization);
	}

	/**
	 * Returns the lovs localization with the primary key or throws a <code>NoSuchLovsLocalizationException</code> if it could not be found.
	 *
	 * @param lovsLocalizationId the primary key of the lovs localization
	 * @return the lovs localization
	 * @throws NoSuchLovsLocalizationException if a lovs localization with the primary key could not be found
	 */
	public static LovsLocalization findByPrimaryKey(long lovsLocalizationId)
		throws com.ejada.telemony.db.exception.NoSuchLovsLocalizationException {

		return getPersistence().findByPrimaryKey(lovsLocalizationId);
	}

	/**
	 * Returns the lovs localization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lovsLocalizationId the primary key of the lovs localization
	 * @return the lovs localization, or <code>null</code> if a lovs localization with the primary key could not be found
	 */
	public static LovsLocalization fetchByPrimaryKey(long lovsLocalizationId) {
		return getPersistence().fetchByPrimaryKey(lovsLocalizationId);
	}

	/**
	 * Returns all the lovs localizations.
	 *
	 * @return the lovs localizations
	 */
	public static List<LovsLocalization> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<LovsLocalization> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<LovsLocalization> findAll(
		int start, int end,
		OrderByComparator<LovsLocalization> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<LovsLocalization> findAll(
		int start, int end,
		OrderByComparator<LovsLocalization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the lovs localizations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of lovs localizations.
	 *
	 * @return the number of lovs localizations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LovsLocalizationPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(LovsLocalizationPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile LovsLocalizationPersistence _persistence;

}