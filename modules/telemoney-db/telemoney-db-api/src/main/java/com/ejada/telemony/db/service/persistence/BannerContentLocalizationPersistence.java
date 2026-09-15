/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.exception.NoSuchBannerContentLocalizationException;
import com.ejada.telemony.db.model.BannerContentLocalization;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the banner content localization service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BannerContentLocalizationUtil
 * @generated
 */
@ProviderType
public interface BannerContentLocalizationPersistence
	extends BasePersistence<BannerContentLocalization> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BannerContentLocalizationUtil} to access the banner content localization persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the banner content localizations where contentId = &#63;.
	 *
	 * @param contentId the content ID
	 * @return the matching banner content localizations
	 */
	public java.util.List<BannerContentLocalization> findByContentId(
		long contentId);

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
	public java.util.List<BannerContentLocalization> findByContentId(
		long contentId, int start, int end);

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
	public java.util.List<BannerContentLocalization> findByContentId(
		long contentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<BannerContentLocalization> orderByComparator);

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
	public java.util.List<BannerContentLocalization> findByContentId(
		long contentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<BannerContentLocalization> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first banner content localization in the ordered set where contentId = &#63;.
	 *
	 * @param contentId the content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner content localization
	 * @throws NoSuchBannerContentLocalizationException if a matching banner content localization could not be found
	 */
	public BannerContentLocalization findByContentId_First(
			long contentId,
			com.liferay.portal.kernel.util.OrderByComparator
				<BannerContentLocalization> orderByComparator)
		throws NoSuchBannerContentLocalizationException;

	/**
	 * Returns the first banner content localization in the ordered set where contentId = &#63;.
	 *
	 * @param contentId the content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner content localization, or <code>null</code> if a matching banner content localization could not be found
	 */
	public BannerContentLocalization fetchByContentId_First(
		long contentId,
		com.liferay.portal.kernel.util.OrderByComparator
			<BannerContentLocalization> orderByComparator);

	/**
	 * Returns the last banner content localization in the ordered set where contentId = &#63;.
	 *
	 * @param contentId the content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner content localization
	 * @throws NoSuchBannerContentLocalizationException if a matching banner content localization could not be found
	 */
	public BannerContentLocalization findByContentId_Last(
			long contentId,
			com.liferay.portal.kernel.util.OrderByComparator
				<BannerContentLocalization> orderByComparator)
		throws NoSuchBannerContentLocalizationException;

	/**
	 * Returns the last banner content localization in the ordered set where contentId = &#63;.
	 *
	 * @param contentId the content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner content localization, or <code>null</code> if a matching banner content localization could not be found
	 */
	public BannerContentLocalization fetchByContentId_Last(
		long contentId,
		com.liferay.portal.kernel.util.OrderByComparator
			<BannerContentLocalization> orderByComparator);

	/**
	 * Returns the banner content localizations before and after the current banner content localization in the ordered set where contentId = &#63;.
	 *
	 * @param bannerContentLocalizationId the primary key of the current banner content localization
	 * @param contentId the content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next banner content localization
	 * @throws NoSuchBannerContentLocalizationException if a banner content localization with the primary key could not be found
	 */
	public BannerContentLocalization[] findByContentId_PrevAndNext(
			long bannerContentLocalizationId, long contentId,
			com.liferay.portal.kernel.util.OrderByComparator
				<BannerContentLocalization> orderByComparator)
		throws NoSuchBannerContentLocalizationException;

	/**
	 * Removes all the banner content localizations where contentId = &#63; from the database.
	 *
	 * @param contentId the content ID
	 */
	public void removeByContentId(long contentId);

	/**
	 * Returns the number of banner content localizations where contentId = &#63;.
	 *
	 * @param contentId the content ID
	 * @return the number of matching banner content localizations
	 */
	public int countByContentId(long contentId);

	/**
	 * Returns the banner content localization where contentId = &#63; and languageId = &#63; or throws a <code>NoSuchBannerContentLocalizationException</code> if it could not be found.
	 *
	 * @param contentId the content ID
	 * @param languageId the language ID
	 * @return the matching banner content localization
	 * @throws NoSuchBannerContentLocalizationException if a matching banner content localization could not be found
	 */
	public BannerContentLocalization findByContentId_LanguageId(
			long contentId, String languageId)
		throws NoSuchBannerContentLocalizationException;

	/**
	 * Returns the banner content localization where contentId = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param contentId the content ID
	 * @param languageId the language ID
	 * @return the matching banner content localization, or <code>null</code> if a matching banner content localization could not be found
	 */
	public BannerContentLocalization fetchByContentId_LanguageId(
		long contentId, String languageId);

	/**
	 * Returns the banner content localization where contentId = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param contentId the content ID
	 * @param languageId the language ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching banner content localization, or <code>null</code> if a matching banner content localization could not be found
	 */
	public BannerContentLocalization fetchByContentId_LanguageId(
		long contentId, String languageId, boolean useFinderCache);

	/**
	 * Removes the banner content localization where contentId = &#63; and languageId = &#63; from the database.
	 *
	 * @param contentId the content ID
	 * @param languageId the language ID
	 * @return the banner content localization that was removed
	 */
	public BannerContentLocalization removeByContentId_LanguageId(
			long contentId, String languageId)
		throws NoSuchBannerContentLocalizationException;

	/**
	 * Returns the number of banner content localizations where contentId = &#63; and languageId = &#63;.
	 *
	 * @param contentId the content ID
	 * @param languageId the language ID
	 * @return the number of matching banner content localizations
	 */
	public int countByContentId_LanguageId(long contentId, String languageId);

	/**
	 * Returns all the banner content localizations where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @return the matching banner content localizations
	 */
	public java.util.List<BannerContentLocalization> findByLanguage(
		String languageId);

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
	public java.util.List<BannerContentLocalization> findByLanguage(
		String languageId, int start, int end);

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
	public java.util.List<BannerContentLocalization> findByLanguage(
		String languageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<BannerContentLocalization> orderByComparator);

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
	public java.util.List<BannerContentLocalization> findByLanguage(
		String languageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<BannerContentLocalization> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first banner content localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner content localization
	 * @throws NoSuchBannerContentLocalizationException if a matching banner content localization could not be found
	 */
	public BannerContentLocalization findByLanguage_First(
			String languageId,
			com.liferay.portal.kernel.util.OrderByComparator
				<BannerContentLocalization> orderByComparator)
		throws NoSuchBannerContentLocalizationException;

	/**
	 * Returns the first banner content localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner content localization, or <code>null</code> if a matching banner content localization could not be found
	 */
	public BannerContentLocalization fetchByLanguage_First(
		String languageId,
		com.liferay.portal.kernel.util.OrderByComparator
			<BannerContentLocalization> orderByComparator);

	/**
	 * Returns the last banner content localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner content localization
	 * @throws NoSuchBannerContentLocalizationException if a matching banner content localization could not be found
	 */
	public BannerContentLocalization findByLanguage_Last(
			String languageId,
			com.liferay.portal.kernel.util.OrderByComparator
				<BannerContentLocalization> orderByComparator)
		throws NoSuchBannerContentLocalizationException;

	/**
	 * Returns the last banner content localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner content localization, or <code>null</code> if a matching banner content localization could not be found
	 */
	public BannerContentLocalization fetchByLanguage_Last(
		String languageId,
		com.liferay.portal.kernel.util.OrderByComparator
			<BannerContentLocalization> orderByComparator);

	/**
	 * Returns the banner content localizations before and after the current banner content localization in the ordered set where languageId = &#63;.
	 *
	 * @param bannerContentLocalizationId the primary key of the current banner content localization
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next banner content localization
	 * @throws NoSuchBannerContentLocalizationException if a banner content localization with the primary key could not be found
	 */
	public BannerContentLocalization[] findByLanguage_PrevAndNext(
			long bannerContentLocalizationId, String languageId,
			com.liferay.portal.kernel.util.OrderByComparator
				<BannerContentLocalization> orderByComparator)
		throws NoSuchBannerContentLocalizationException;

	/**
	 * Removes all the banner content localizations where languageId = &#63; from the database.
	 *
	 * @param languageId the language ID
	 */
	public void removeByLanguage(String languageId);

	/**
	 * Returns the number of banner content localizations where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @return the number of matching banner content localizations
	 */
	public int countByLanguage(String languageId);

	/**
	 * Caches the banner content localization in the entity cache if it is enabled.
	 *
	 * @param bannerContentLocalization the banner content localization
	 */
	public void cacheResult(
		BannerContentLocalization bannerContentLocalization);

	/**
	 * Caches the banner content localizations in the entity cache if it is enabled.
	 *
	 * @param bannerContentLocalizations the banner content localizations
	 */
	public void cacheResult(
		java.util.List<BannerContentLocalization> bannerContentLocalizations);

	/**
	 * Creates a new banner content localization with the primary key. Does not add the banner content localization to the database.
	 *
	 * @param bannerContentLocalizationId the primary key for the new banner content localization
	 * @return the new banner content localization
	 */
	public BannerContentLocalization create(long bannerContentLocalizationId);

	/**
	 * Removes the banner content localization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bannerContentLocalizationId the primary key of the banner content localization
	 * @return the banner content localization that was removed
	 * @throws NoSuchBannerContentLocalizationException if a banner content localization with the primary key could not be found
	 */
	public BannerContentLocalization remove(long bannerContentLocalizationId)
		throws NoSuchBannerContentLocalizationException;

	public BannerContentLocalization updateImpl(
		BannerContentLocalization bannerContentLocalization);

	/**
	 * Returns the banner content localization with the primary key or throws a <code>NoSuchBannerContentLocalizationException</code> if it could not be found.
	 *
	 * @param bannerContentLocalizationId the primary key of the banner content localization
	 * @return the banner content localization
	 * @throws NoSuchBannerContentLocalizationException if a banner content localization with the primary key could not be found
	 */
	public BannerContentLocalization findByPrimaryKey(
			long bannerContentLocalizationId)
		throws NoSuchBannerContentLocalizationException;

	/**
	 * Returns the banner content localization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bannerContentLocalizationId the primary key of the banner content localization
	 * @return the banner content localization, or <code>null</code> if a banner content localization with the primary key could not be found
	 */
	public BannerContentLocalization fetchByPrimaryKey(
		long bannerContentLocalizationId);

	/**
	 * Returns all the banner content localizations.
	 *
	 * @return the banner content localizations
	 */
	public java.util.List<BannerContentLocalization> findAll();

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
	public java.util.List<BannerContentLocalization> findAll(
		int start, int end);

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
	public java.util.List<BannerContentLocalization> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<BannerContentLocalization> orderByComparator);

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
	public java.util.List<BannerContentLocalization> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<BannerContentLocalization> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the banner content localizations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of banner content localizations.
	 *
	 * @return the number of banner content localizations
	 */
	public int countAll();

}