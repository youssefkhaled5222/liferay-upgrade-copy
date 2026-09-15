/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.model.Languages;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the languages service. This utility wraps <code>com.ejada.telemony.db.service.persistence.impl.LanguagesPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LanguagesPersistence
 * @generated
 */
public class LanguagesUtil {

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
	public static void clearCache(Languages languages) {
		getPersistence().clearCache(languages);
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
	public static Map<Serializable, Languages> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Languages> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Languages> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Languages> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Languages> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Languages update(Languages languages) {
		return getPersistence().update(languages);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Languages update(
		Languages languages, ServiceContext serviceContext) {

		return getPersistence().update(languages, serviceContext);
	}

	/**
	 * Returns all the languageses where channelId = &#63; and local = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param local the local
	 * @return the matching languageses
	 */
	public static List<Languages> findByLocal(long channelId, String local) {
		return getPersistence().findByLocal(channelId, local);
	}

	/**
	 * Returns a range of all the languageses where channelId = &#63; and local = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LanguagesModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param local the local
	 * @param start the lower bound of the range of languageses
	 * @param end the upper bound of the range of languageses (not inclusive)
	 * @return the range of matching languageses
	 */
	public static List<Languages> findByLocal(
		long channelId, String local, int start, int end) {

		return getPersistence().findByLocal(channelId, local, start, end);
	}

	/**
	 * Returns an ordered range of all the languageses where channelId = &#63; and local = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LanguagesModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param local the local
	 * @param start the lower bound of the range of languageses
	 * @param end the upper bound of the range of languageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching languageses
	 */
	public static List<Languages> findByLocal(
		long channelId, String local, int start, int end,
		OrderByComparator<Languages> orderByComparator) {

		return getPersistence().findByLocal(
			channelId, local, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the languageses where channelId = &#63; and local = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LanguagesModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param local the local
	 * @param start the lower bound of the range of languageses
	 * @param end the upper bound of the range of languageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching languageses
	 */
	public static List<Languages> findByLocal(
		long channelId, String local, int start, int end,
		OrderByComparator<Languages> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByLocal(
			channelId, local, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first languages in the ordered set where channelId = &#63; and local = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param local the local
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching languages
	 * @throws NoSuchLanguagesException if a matching languages could not be found
	 */
	public static Languages findByLocal_First(
			long channelId, String local,
			OrderByComparator<Languages> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLanguagesException {

		return getPersistence().findByLocal_First(
			channelId, local, orderByComparator);
	}

	/**
	 * Returns the first languages in the ordered set where channelId = &#63; and local = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param local the local
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching languages, or <code>null</code> if a matching languages could not be found
	 */
	public static Languages fetchByLocal_First(
		long channelId, String local,
		OrderByComparator<Languages> orderByComparator) {

		return getPersistence().fetchByLocal_First(
			channelId, local, orderByComparator);
	}

	/**
	 * Returns the last languages in the ordered set where channelId = &#63; and local = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param local the local
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching languages
	 * @throws NoSuchLanguagesException if a matching languages could not be found
	 */
	public static Languages findByLocal_Last(
			long channelId, String local,
			OrderByComparator<Languages> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLanguagesException {

		return getPersistence().findByLocal_Last(
			channelId, local, orderByComparator);
	}

	/**
	 * Returns the last languages in the ordered set where channelId = &#63; and local = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param local the local
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching languages, or <code>null</code> if a matching languages could not be found
	 */
	public static Languages fetchByLocal_Last(
		long channelId, String local,
		OrderByComparator<Languages> orderByComparator) {

		return getPersistence().fetchByLocal_Last(
			channelId, local, orderByComparator);
	}

	/**
	 * Returns the languageses before and after the current languages in the ordered set where channelId = &#63; and local = &#63;.
	 *
	 * @param languageId the primary key of the current languages
	 * @param channelId the channel ID
	 * @param local the local
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next languages
	 * @throws NoSuchLanguagesException if a languages with the primary key could not be found
	 */
	public static Languages[] findByLocal_PrevAndNext(
			long languageId, long channelId, String local,
			OrderByComparator<Languages> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLanguagesException {

		return getPersistence().findByLocal_PrevAndNext(
			languageId, channelId, local, orderByComparator);
	}

	/**
	 * Removes all the languageses where channelId = &#63; and local = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param local the local
	 */
	public static void removeByLocal(long channelId, String local) {
		getPersistence().removeByLocal(channelId, local);
	}

	/**
	 * Returns the number of languageses where channelId = &#63; and local = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param local the local
	 * @return the number of matching languageses
	 */
	public static int countByLocal(long channelId, String local) {
		return getPersistence().countByLocal(channelId, local);
	}

	/**
	 * Returns all the languageses where channelId = &#63; and langName = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param langName the lang name
	 * @return the matching languageses
	 */
	public static List<Languages> findByLangName(
		long channelId, String langName) {

		return getPersistence().findByLangName(channelId, langName);
	}

	/**
	 * Returns a range of all the languageses where channelId = &#63; and langName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LanguagesModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param langName the lang name
	 * @param start the lower bound of the range of languageses
	 * @param end the upper bound of the range of languageses (not inclusive)
	 * @return the range of matching languageses
	 */
	public static List<Languages> findByLangName(
		long channelId, String langName, int start, int end) {

		return getPersistence().findByLangName(channelId, langName, start, end);
	}

	/**
	 * Returns an ordered range of all the languageses where channelId = &#63; and langName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LanguagesModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param langName the lang name
	 * @param start the lower bound of the range of languageses
	 * @param end the upper bound of the range of languageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching languageses
	 */
	public static List<Languages> findByLangName(
		long channelId, String langName, int start, int end,
		OrderByComparator<Languages> orderByComparator) {

		return getPersistence().findByLangName(
			channelId, langName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the languageses where channelId = &#63; and langName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LanguagesModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param langName the lang name
	 * @param start the lower bound of the range of languageses
	 * @param end the upper bound of the range of languageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching languageses
	 */
	public static List<Languages> findByLangName(
		long channelId, String langName, int start, int end,
		OrderByComparator<Languages> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByLangName(
			channelId, langName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first languages in the ordered set where channelId = &#63; and langName = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param langName the lang name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching languages
	 * @throws NoSuchLanguagesException if a matching languages could not be found
	 */
	public static Languages findByLangName_First(
			long channelId, String langName,
			OrderByComparator<Languages> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLanguagesException {

		return getPersistence().findByLangName_First(
			channelId, langName, orderByComparator);
	}

	/**
	 * Returns the first languages in the ordered set where channelId = &#63; and langName = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param langName the lang name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching languages, or <code>null</code> if a matching languages could not be found
	 */
	public static Languages fetchByLangName_First(
		long channelId, String langName,
		OrderByComparator<Languages> orderByComparator) {

		return getPersistence().fetchByLangName_First(
			channelId, langName, orderByComparator);
	}

	/**
	 * Returns the last languages in the ordered set where channelId = &#63; and langName = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param langName the lang name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching languages
	 * @throws NoSuchLanguagesException if a matching languages could not be found
	 */
	public static Languages findByLangName_Last(
			long channelId, String langName,
			OrderByComparator<Languages> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLanguagesException {

		return getPersistence().findByLangName_Last(
			channelId, langName, orderByComparator);
	}

	/**
	 * Returns the last languages in the ordered set where channelId = &#63; and langName = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param langName the lang name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching languages, or <code>null</code> if a matching languages could not be found
	 */
	public static Languages fetchByLangName_Last(
		long channelId, String langName,
		OrderByComparator<Languages> orderByComparator) {

		return getPersistence().fetchByLangName_Last(
			channelId, langName, orderByComparator);
	}

	/**
	 * Returns the languageses before and after the current languages in the ordered set where channelId = &#63; and langName = &#63;.
	 *
	 * @param languageId the primary key of the current languages
	 * @param channelId the channel ID
	 * @param langName the lang name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next languages
	 * @throws NoSuchLanguagesException if a languages with the primary key could not be found
	 */
	public static Languages[] findByLangName_PrevAndNext(
			long languageId, long channelId, String langName,
			OrderByComparator<Languages> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLanguagesException {

		return getPersistence().findByLangName_PrevAndNext(
			languageId, channelId, langName, orderByComparator);
	}

	/**
	 * Removes all the languageses where channelId = &#63; and langName = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param langName the lang name
	 */
	public static void removeByLangName(long channelId, String langName) {
		getPersistence().removeByLangName(channelId, langName);
	}

	/**
	 * Returns the number of languageses where channelId = &#63; and langName = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param langName the lang name
	 * @return the number of matching languageses
	 */
	public static int countByLangName(long channelId, String langName) {
		return getPersistence().countByLangName(channelId, langName);
	}

	/**
	 * Returns all the languageses where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the matching languageses
	 */
	public static List<Languages> findByChannelId(long channelId) {
		return getPersistence().findByChannelId(channelId);
	}

	/**
	 * Returns a range of all the languageses where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LanguagesModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of languageses
	 * @param end the upper bound of the range of languageses (not inclusive)
	 * @return the range of matching languageses
	 */
	public static List<Languages> findByChannelId(
		long channelId, int start, int end) {

		return getPersistence().findByChannelId(channelId, start, end);
	}

	/**
	 * Returns an ordered range of all the languageses where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LanguagesModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of languageses
	 * @param end the upper bound of the range of languageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching languageses
	 */
	public static List<Languages> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<Languages> orderByComparator) {

		return getPersistence().findByChannelId(
			channelId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the languageses where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LanguagesModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of languageses
	 * @param end the upper bound of the range of languageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching languageses
	 */
	public static List<Languages> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<Languages> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByChannelId(
			channelId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first languages in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching languages
	 * @throws NoSuchLanguagesException if a matching languages could not be found
	 */
	public static Languages findByChannelId_First(
			long channelId, OrderByComparator<Languages> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLanguagesException {

		return getPersistence().findByChannelId_First(
			channelId, orderByComparator);
	}

	/**
	 * Returns the first languages in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching languages, or <code>null</code> if a matching languages could not be found
	 */
	public static Languages fetchByChannelId_First(
		long channelId, OrderByComparator<Languages> orderByComparator) {

		return getPersistence().fetchByChannelId_First(
			channelId, orderByComparator);
	}

	/**
	 * Returns the last languages in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching languages
	 * @throws NoSuchLanguagesException if a matching languages could not be found
	 */
	public static Languages findByChannelId_Last(
			long channelId, OrderByComparator<Languages> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLanguagesException {

		return getPersistence().findByChannelId_Last(
			channelId, orderByComparator);
	}

	/**
	 * Returns the last languages in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching languages, or <code>null</code> if a matching languages could not be found
	 */
	public static Languages fetchByChannelId_Last(
		long channelId, OrderByComparator<Languages> orderByComparator) {

		return getPersistence().fetchByChannelId_Last(
			channelId, orderByComparator);
	}

	/**
	 * Returns the languageses before and after the current languages in the ordered set where channelId = &#63;.
	 *
	 * @param languageId the primary key of the current languages
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next languages
	 * @throws NoSuchLanguagesException if a languages with the primary key could not be found
	 */
	public static Languages[] findByChannelId_PrevAndNext(
			long languageId, long channelId,
			OrderByComparator<Languages> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLanguagesException {

		return getPersistence().findByChannelId_PrevAndNext(
			languageId, channelId, orderByComparator);
	}

	/**
	 * Removes all the languageses where channelId = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 */
	public static void removeByChannelId(long channelId) {
		getPersistence().removeByChannelId(channelId);
	}

	/**
	 * Returns the number of languageses where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the number of matching languageses
	 */
	public static int countByChannelId(long channelId) {
		return getPersistence().countByChannelId(channelId);
	}

	/**
	 * Returns all the languageses where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching languageses
	 */
	public static List<Languages> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the languageses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LanguagesModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of languageses
	 * @param end the upper bound of the range of languageses (not inclusive)
	 * @return the range of matching languageses
	 */
	public static List<Languages> findByStatus(int status, int start, int end) {
		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the languageses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LanguagesModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of languageses
	 * @param end the upper bound of the range of languageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching languageses
	 */
	public static List<Languages> findByStatus(
		int status, int start, int end,
		OrderByComparator<Languages> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the languageses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LanguagesModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of languageses
	 * @param end the upper bound of the range of languageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching languageses
	 */
	public static List<Languages> findByStatus(
		int status, int start, int end,
		OrderByComparator<Languages> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first languages in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching languages
	 * @throws NoSuchLanguagesException if a matching languages could not be found
	 */
	public static Languages findByStatus_First(
			int status, OrderByComparator<Languages> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLanguagesException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first languages in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching languages, or <code>null</code> if a matching languages could not be found
	 */
	public static Languages fetchByStatus_First(
		int status, OrderByComparator<Languages> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last languages in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching languages
	 * @throws NoSuchLanguagesException if a matching languages could not be found
	 */
	public static Languages findByStatus_Last(
			int status, OrderByComparator<Languages> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLanguagesException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last languages in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching languages, or <code>null</code> if a matching languages could not be found
	 */
	public static Languages fetchByStatus_Last(
		int status, OrderByComparator<Languages> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the languageses before and after the current languages in the ordered set where status = &#63;.
	 *
	 * @param languageId the primary key of the current languages
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next languages
	 * @throws NoSuchLanguagesException if a languages with the primary key could not be found
	 */
	public static Languages[] findByStatus_PrevAndNext(
			long languageId, int status,
			OrderByComparator<Languages> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLanguagesException {

		return getPersistence().findByStatus_PrevAndNext(
			languageId, status, orderByComparator);
	}

	/**
	 * Removes all the languageses where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of languageses where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching languageses
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the languageses where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the matching languageses
	 */
	public static List<Languages> findByentityResourceId(
		long entityResourceId) {

		return getPersistence().findByentityResourceId(entityResourceId);
	}

	/**
	 * Returns a range of all the languageses where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LanguagesModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of languageses
	 * @param end the upper bound of the range of languageses (not inclusive)
	 * @return the range of matching languageses
	 */
	public static List<Languages> findByentityResourceId(
		long entityResourceId, int start, int end) {

		return getPersistence().findByentityResourceId(
			entityResourceId, start, end);
	}

	/**
	 * Returns an ordered range of all the languageses where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LanguagesModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of languageses
	 * @param end the upper bound of the range of languageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching languageses
	 */
	public static List<Languages> findByentityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<Languages> orderByComparator) {

		return getPersistence().findByentityResourceId(
			entityResourceId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the languageses where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LanguagesModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of languageses
	 * @param end the upper bound of the range of languageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching languageses
	 */
	public static List<Languages> findByentityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<Languages> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByentityResourceId(
			entityResourceId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first languages in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching languages
	 * @throws NoSuchLanguagesException if a matching languages could not be found
	 */
	public static Languages findByentityResourceId_First(
			long entityResourceId,
			OrderByComparator<Languages> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLanguagesException {

		return getPersistence().findByentityResourceId_First(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the first languages in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching languages, or <code>null</code> if a matching languages could not be found
	 */
	public static Languages fetchByentityResourceId_First(
		long entityResourceId, OrderByComparator<Languages> orderByComparator) {

		return getPersistence().fetchByentityResourceId_First(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the last languages in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching languages
	 * @throws NoSuchLanguagesException if a matching languages could not be found
	 */
	public static Languages findByentityResourceId_Last(
			long entityResourceId,
			OrderByComparator<Languages> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLanguagesException {

		return getPersistence().findByentityResourceId_Last(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the last languages in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching languages, or <code>null</code> if a matching languages could not be found
	 */
	public static Languages fetchByentityResourceId_Last(
		long entityResourceId, OrderByComparator<Languages> orderByComparator) {

		return getPersistence().fetchByentityResourceId_Last(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the languageses before and after the current languages in the ordered set where entityResourceId = &#63;.
	 *
	 * @param languageId the primary key of the current languages
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next languages
	 * @throws NoSuchLanguagesException if a languages with the primary key could not be found
	 */
	public static Languages[] findByentityResourceId_PrevAndNext(
			long languageId, long entityResourceId,
			OrderByComparator<Languages> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLanguagesException {

		return getPersistence().findByentityResourceId_PrevAndNext(
			languageId, entityResourceId, orderByComparator);
	}

	/**
	 * Removes all the languageses where entityResourceId = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 */
	public static void removeByentityResourceId(long entityResourceId) {
		getPersistence().removeByentityResourceId(entityResourceId);
	}

	/**
	 * Returns the number of languageses where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the number of matching languageses
	 */
	public static int countByentityResourceId(long entityResourceId) {
		return getPersistence().countByentityResourceId(entityResourceId);
	}

	/**
	 * Caches the languages in the entity cache if it is enabled.
	 *
	 * @param languages the languages
	 */
	public static void cacheResult(Languages languages) {
		getPersistence().cacheResult(languages);
	}

	/**
	 * Caches the languageses in the entity cache if it is enabled.
	 *
	 * @param languageses the languageses
	 */
	public static void cacheResult(List<Languages> languageses) {
		getPersistence().cacheResult(languageses);
	}

	/**
	 * Creates a new languages with the primary key. Does not add the languages to the database.
	 *
	 * @param languageId the primary key for the new languages
	 * @return the new languages
	 */
	public static Languages create(long languageId) {
		return getPersistence().create(languageId);
	}

	/**
	 * Removes the languages with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param languageId the primary key of the languages
	 * @return the languages that was removed
	 * @throws NoSuchLanguagesException if a languages with the primary key could not be found
	 */
	public static Languages remove(long languageId)
		throws com.ejada.telemony.db.exception.NoSuchLanguagesException {

		return getPersistence().remove(languageId);
	}

	public static Languages updateImpl(Languages languages) {
		return getPersistence().updateImpl(languages);
	}

	/**
	 * Returns the languages with the primary key or throws a <code>NoSuchLanguagesException</code> if it could not be found.
	 *
	 * @param languageId the primary key of the languages
	 * @return the languages
	 * @throws NoSuchLanguagesException if a languages with the primary key could not be found
	 */
	public static Languages findByPrimaryKey(long languageId)
		throws com.ejada.telemony.db.exception.NoSuchLanguagesException {

		return getPersistence().findByPrimaryKey(languageId);
	}

	/**
	 * Returns the languages with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param languageId the primary key of the languages
	 * @return the languages, or <code>null</code> if a languages with the primary key could not be found
	 */
	public static Languages fetchByPrimaryKey(long languageId) {
		return getPersistence().fetchByPrimaryKey(languageId);
	}

	/**
	 * Returns all the languageses.
	 *
	 * @return the languageses
	 */
	public static List<Languages> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the languageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LanguagesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of languageses
	 * @param end the upper bound of the range of languageses (not inclusive)
	 * @return the range of languageses
	 */
	public static List<Languages> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the languageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LanguagesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of languageses
	 * @param end the upper bound of the range of languageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of languageses
	 */
	public static List<Languages> findAll(
		int start, int end, OrderByComparator<Languages> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the languageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LanguagesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of languageses
	 * @param end the upper bound of the range of languageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of languageses
	 */
	public static List<Languages> findAll(
		int start, int end, OrderByComparator<Languages> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the languageses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of languageses.
	 *
	 * @return the number of languageses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LanguagesPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(LanguagesPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile LanguagesPersistence _persistence;

}