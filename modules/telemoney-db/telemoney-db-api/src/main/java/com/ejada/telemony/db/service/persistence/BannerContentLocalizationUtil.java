/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.model.BannerContentLocalization;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the banner content localization service. This utility wraps <code>com.ejada.telemony.db.service.persistence.impl.BannerContentLocalizationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BannerContentLocalizationPersistence
 * @generated
 */
public class BannerContentLocalizationUtil {

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
	public static void clearCache(
		BannerContentLocalization bannerContentLocalization) {

		getPersistence().clearCache(bannerContentLocalization);
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
	public static Map<Serializable, BannerContentLocalization>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<BannerContentLocalization> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BannerContentLocalization> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BannerContentLocalization> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BannerContentLocalization> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BannerContentLocalization update(
		BannerContentLocalization bannerContentLocalization) {

		return getPersistence().update(bannerContentLocalization);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BannerContentLocalization update(
		BannerContentLocalization bannerContentLocalization,
		ServiceContext serviceContext) {

		return getPersistence().update(
			bannerContentLocalization, serviceContext);
	}

	/**
	 * Returns all the banner content localizations where contentId = &#63;.
	 *
	 * @param contentId the content ID
	 * @return the matching banner content localizations
	 */
	public static List<BannerContentLocalization> findByContentId(
		long contentId) {

		return getPersistence().findByContentId(contentId);
	}

	/**
	 * Returns a range of all the banner content localizations where contentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param contentId the content ID
	 * @param start the lower bound of the range of banner content localizations
	 * @param end the upper bound of the range of banner content localizations (not inclusive)
	 * @return the range of matching banner content localizations
	 */
	public static List<BannerContentLocalization> findByContentId(
		long contentId, int start, int end) {

		return getPersistence().findByContentId(contentId, start, end);
	}

	/**
	 * Returns an ordered range of all the banner content localizations where contentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param contentId the content ID
	 * @param start the lower bound of the range of banner content localizations
	 * @param end the upper bound of the range of banner content localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching banner content localizations
	 */
	public static List<BannerContentLocalization> findByContentId(
		long contentId, int start, int end,
		OrderByComparator<BannerContentLocalization> orderByComparator) {

		return getPersistence().findByContentId(
			contentId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the banner content localizations where contentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param contentId the content ID
	 * @param start the lower bound of the range of banner content localizations
	 * @param end the upper bound of the range of banner content localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching banner content localizations
	 */
	public static List<BannerContentLocalization> findByContentId(
		long contentId, int start, int end,
		OrderByComparator<BannerContentLocalization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByContentId(
			contentId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first banner content localization in the ordered set where contentId = &#63;.
	 *
	 * @param contentId the content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner content localization
	 * @throws NoSuchBannerContentLocalizationException if a matching banner content localization could not be found
	 */
	public static BannerContentLocalization findByContentId_First(
			long contentId,
			OrderByComparator<BannerContentLocalization> orderByComparator)
		throws com.ejada.telemony.db.exception.
			NoSuchBannerContentLocalizationException {

		return getPersistence().findByContentId_First(
			contentId, orderByComparator);
	}

	/**
	 * Returns the first banner content localization in the ordered set where contentId = &#63;.
	 *
	 * @param contentId the content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner content localization, or <code>null</code> if a matching banner content localization could not be found
	 */
	public static BannerContentLocalization fetchByContentId_First(
		long contentId,
		OrderByComparator<BannerContentLocalization> orderByComparator) {

		return getPersistence().fetchByContentId_First(
			contentId, orderByComparator);
	}

	/**
	 * Returns the last banner content localization in the ordered set where contentId = &#63;.
	 *
	 * @param contentId the content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner content localization
	 * @throws NoSuchBannerContentLocalizationException if a matching banner content localization could not be found
	 */
	public static BannerContentLocalization findByContentId_Last(
			long contentId,
			OrderByComparator<BannerContentLocalization> orderByComparator)
		throws com.ejada.telemony.db.exception.
			NoSuchBannerContentLocalizationException {

		return getPersistence().findByContentId_Last(
			contentId, orderByComparator);
	}

	/**
	 * Returns the last banner content localization in the ordered set where contentId = &#63;.
	 *
	 * @param contentId the content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner content localization, or <code>null</code> if a matching banner content localization could not be found
	 */
	public static BannerContentLocalization fetchByContentId_Last(
		long contentId,
		OrderByComparator<BannerContentLocalization> orderByComparator) {

		return getPersistence().fetchByContentId_Last(
			contentId, orderByComparator);
	}

	/**
	 * Returns the banner content localizations before and after the current banner content localization in the ordered set where contentId = &#63;.
	 *
	 * @param bannerContentLocalizationId the primary key of the current banner content localization
	 * @param contentId the content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next banner content localization
	 * @throws NoSuchBannerContentLocalizationException if a banner content localization with the primary key could not be found
	 */
	public static BannerContentLocalization[] findByContentId_PrevAndNext(
			long bannerContentLocalizationId, long contentId,
			OrderByComparator<BannerContentLocalization> orderByComparator)
		throws com.ejada.telemony.db.exception.
			NoSuchBannerContentLocalizationException {

		return getPersistence().findByContentId_PrevAndNext(
			bannerContentLocalizationId, contentId, orderByComparator);
	}

	/**
	 * Removes all the banner content localizations where contentId = &#63; from the database.
	 *
	 * @param contentId the content ID
	 */
	public static void removeByContentId(long contentId) {
		getPersistence().removeByContentId(contentId);
	}

	/**
	 * Returns the number of banner content localizations where contentId = &#63;.
	 *
	 * @param contentId the content ID
	 * @return the number of matching banner content localizations
	 */
	public static int countByContentId(long contentId) {
		return getPersistence().countByContentId(contentId);
	}

	/**
	 * Returns the banner content localization where contentId = &#63; and languageId = &#63; or throws a <code>NoSuchBannerContentLocalizationException</code> if it could not be found.
	 *
	 * @param contentId the content ID
	 * @param languageId the language ID
	 * @return the matching banner content localization
	 * @throws NoSuchBannerContentLocalizationException if a matching banner content localization could not be found
	 */
	public static BannerContentLocalization findByContentId_LanguageId(
			long contentId, String languageId)
		throws com.ejada.telemony.db.exception.
			NoSuchBannerContentLocalizationException {

		return getPersistence().findByContentId_LanguageId(
			contentId, languageId);
	}

	/**
	 * Returns the banner content localization where contentId = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param contentId the content ID
	 * @param languageId the language ID
	 * @return the matching banner content localization, or <code>null</code> if a matching banner content localization could not be found
	 */
	public static BannerContentLocalization fetchByContentId_LanguageId(
		long contentId, String languageId) {

		return getPersistence().fetchByContentId_LanguageId(
			contentId, languageId);
	}

	/**
	 * Returns the banner content localization where contentId = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param contentId the content ID
	 * @param languageId the language ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching banner content localization, or <code>null</code> if a matching banner content localization could not be found
	 */
	public static BannerContentLocalization fetchByContentId_LanguageId(
		long contentId, String languageId, boolean useFinderCache) {

		return getPersistence().fetchByContentId_LanguageId(
			contentId, languageId, useFinderCache);
	}

	/**
	 * Removes the banner content localization where contentId = &#63; and languageId = &#63; from the database.
	 *
	 * @param contentId the content ID
	 * @param languageId the language ID
	 * @return the banner content localization that was removed
	 */
	public static BannerContentLocalization removeByContentId_LanguageId(
			long contentId, String languageId)
		throws com.ejada.telemony.db.exception.
			NoSuchBannerContentLocalizationException {

		return getPersistence().removeByContentId_LanguageId(
			contentId, languageId);
	}

	/**
	 * Returns the number of banner content localizations where contentId = &#63; and languageId = &#63;.
	 *
	 * @param contentId the content ID
	 * @param languageId the language ID
	 * @return the number of matching banner content localizations
	 */
	public static int countByContentId_LanguageId(
		long contentId, String languageId) {

		return getPersistence().countByContentId_LanguageId(
			contentId, languageId);
	}

	/**
	 * Returns all the banner content localizations where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @return the matching banner content localizations
	 */
	public static List<BannerContentLocalization> findByLanguage(
		String languageId) {

		return getPersistence().findByLanguage(languageId);
	}

	/**
	 * Returns a range of all the banner content localizations where languageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param start the lower bound of the range of banner content localizations
	 * @param end the upper bound of the range of banner content localizations (not inclusive)
	 * @return the range of matching banner content localizations
	 */
	public static List<BannerContentLocalization> findByLanguage(
		String languageId, int start, int end) {

		return getPersistence().findByLanguage(languageId, start, end);
	}

	/**
	 * Returns an ordered range of all the banner content localizations where languageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param start the lower bound of the range of banner content localizations
	 * @param end the upper bound of the range of banner content localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching banner content localizations
	 */
	public static List<BannerContentLocalization> findByLanguage(
		String languageId, int start, int end,
		OrderByComparator<BannerContentLocalization> orderByComparator) {

		return getPersistence().findByLanguage(
			languageId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the banner content localizations where languageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param start the lower bound of the range of banner content localizations
	 * @param end the upper bound of the range of banner content localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching banner content localizations
	 */
	public static List<BannerContentLocalization> findByLanguage(
		String languageId, int start, int end,
		OrderByComparator<BannerContentLocalization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByLanguage(
			languageId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first banner content localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner content localization
	 * @throws NoSuchBannerContentLocalizationException if a matching banner content localization could not be found
	 */
	public static BannerContentLocalization findByLanguage_First(
			String languageId,
			OrderByComparator<BannerContentLocalization> orderByComparator)
		throws com.ejada.telemony.db.exception.
			NoSuchBannerContentLocalizationException {

		return getPersistence().findByLanguage_First(
			languageId, orderByComparator);
	}

	/**
	 * Returns the first banner content localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner content localization, or <code>null</code> if a matching banner content localization could not be found
	 */
	public static BannerContentLocalization fetchByLanguage_First(
		String languageId,
		OrderByComparator<BannerContentLocalization> orderByComparator) {

		return getPersistence().fetchByLanguage_First(
			languageId, orderByComparator);
	}

	/**
	 * Returns the last banner content localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner content localization
	 * @throws NoSuchBannerContentLocalizationException if a matching banner content localization could not be found
	 */
	public static BannerContentLocalization findByLanguage_Last(
			String languageId,
			OrderByComparator<BannerContentLocalization> orderByComparator)
		throws com.ejada.telemony.db.exception.
			NoSuchBannerContentLocalizationException {

		return getPersistence().findByLanguage_Last(
			languageId, orderByComparator);
	}

	/**
	 * Returns the last banner content localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner content localization, or <code>null</code> if a matching banner content localization could not be found
	 */
	public static BannerContentLocalization fetchByLanguage_Last(
		String languageId,
		OrderByComparator<BannerContentLocalization> orderByComparator) {

		return getPersistence().fetchByLanguage_Last(
			languageId, orderByComparator);
	}

	/**
	 * Returns the banner content localizations before and after the current banner content localization in the ordered set where languageId = &#63;.
	 *
	 * @param bannerContentLocalizationId the primary key of the current banner content localization
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next banner content localization
	 * @throws NoSuchBannerContentLocalizationException if a banner content localization with the primary key could not be found
	 */
	public static BannerContentLocalization[] findByLanguage_PrevAndNext(
			long bannerContentLocalizationId, String languageId,
			OrderByComparator<BannerContentLocalization> orderByComparator)
		throws com.ejada.telemony.db.exception.
			NoSuchBannerContentLocalizationException {

		return getPersistence().findByLanguage_PrevAndNext(
			bannerContentLocalizationId, languageId, orderByComparator);
	}

	/**
	 * Removes all the banner content localizations where languageId = &#63; from the database.
	 *
	 * @param languageId the language ID
	 */
	public static void removeByLanguage(String languageId) {
		getPersistence().removeByLanguage(languageId);
	}

	/**
	 * Returns the number of banner content localizations where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @return the number of matching banner content localizations
	 */
	public static int countByLanguage(String languageId) {
		return getPersistence().countByLanguage(languageId);
	}

	/**
	 * Caches the banner content localization in the entity cache if it is enabled.
	 *
	 * @param bannerContentLocalization the banner content localization
	 */
	public static void cacheResult(
		BannerContentLocalization bannerContentLocalization) {

		getPersistence().cacheResult(bannerContentLocalization);
	}

	/**
	 * Caches the banner content localizations in the entity cache if it is enabled.
	 *
	 * @param bannerContentLocalizations the banner content localizations
	 */
	public static void cacheResult(
		List<BannerContentLocalization> bannerContentLocalizations) {

		getPersistence().cacheResult(bannerContentLocalizations);
	}

	/**
	 * Creates a new banner content localization with the primary key. Does not add the banner content localization to the database.
	 *
	 * @param bannerContentLocalizationId the primary key for the new banner content localization
	 * @return the new banner content localization
	 */
	public static BannerContentLocalization create(
		long bannerContentLocalizationId) {

		return getPersistence().create(bannerContentLocalizationId);
	}

	/**
	 * Removes the banner content localization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bannerContentLocalizationId the primary key of the banner content localization
	 * @return the banner content localization that was removed
	 * @throws NoSuchBannerContentLocalizationException if a banner content localization with the primary key could not be found
	 */
	public static BannerContentLocalization remove(
			long bannerContentLocalizationId)
		throws com.ejada.telemony.db.exception.
			NoSuchBannerContentLocalizationException {

		return getPersistence().remove(bannerContentLocalizationId);
	}

	public static BannerContentLocalization updateImpl(
		BannerContentLocalization bannerContentLocalization) {

		return getPersistence().updateImpl(bannerContentLocalization);
	}

	/**
	 * Returns the banner content localization with the primary key or throws a <code>NoSuchBannerContentLocalizationException</code> if it could not be found.
	 *
	 * @param bannerContentLocalizationId the primary key of the banner content localization
	 * @return the banner content localization
	 * @throws NoSuchBannerContentLocalizationException if a banner content localization with the primary key could not be found
	 */
	public static BannerContentLocalization findByPrimaryKey(
			long bannerContentLocalizationId)
		throws com.ejada.telemony.db.exception.
			NoSuchBannerContentLocalizationException {

		return getPersistence().findByPrimaryKey(bannerContentLocalizationId);
	}

	/**
	 * Returns the banner content localization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bannerContentLocalizationId the primary key of the banner content localization
	 * @return the banner content localization, or <code>null</code> if a banner content localization with the primary key could not be found
	 */
	public static BannerContentLocalization fetchByPrimaryKey(
		long bannerContentLocalizationId) {

		return getPersistence().fetchByPrimaryKey(bannerContentLocalizationId);
	}

	/**
	 * Returns all the banner content localizations.
	 *
	 * @return the banner content localizations
	 */
	public static List<BannerContentLocalization> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the banner content localizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of banner content localizations
	 * @param end the upper bound of the range of banner content localizations (not inclusive)
	 * @return the range of banner content localizations
	 */
	public static List<BannerContentLocalization> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the banner content localizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of banner content localizations
	 * @param end the upper bound of the range of banner content localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of banner content localizations
	 */
	public static List<BannerContentLocalization> findAll(
		int start, int end,
		OrderByComparator<BannerContentLocalization> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the banner content localizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of banner content localizations
	 * @param end the upper bound of the range of banner content localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of banner content localizations
	 */
	public static List<BannerContentLocalization> findAll(
		int start, int end,
		OrderByComparator<BannerContentLocalization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the banner content localizations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of banner content localizations.
	 *
	 * @return the number of banner content localizations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BannerContentLocalizationPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		BannerContentLocalizationPersistence persistence) {

		_persistence = persistence;
	}

	private static volatile BannerContentLocalizationPersistence _persistence;

}