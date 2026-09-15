/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.model.Localization;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the localization service. This utility wraps <code>com.ejada.telemony.db.service.persistence.impl.LocalizationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LocalizationPersistence
 * @generated
 */
public class LocalizationUtil {

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
	public static void clearCache(Localization localization) {
		getPersistence().clearCache(localization);
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
	public static Map<Serializable, Localization> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Localization> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Localization> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Localization> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Localization> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Localization update(Localization localization) {
		return getPersistence().update(localization);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Localization update(
		Localization localization, ServiceContext serviceContext) {

		return getPersistence().update(localization, serviceContext);
	}

	/**
	 * Returns all the localizations where channelId = &#63; and languageId = &#63; and globalVersion = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param languageId the language ID
	 * @param globalVersion the global version
	 * @return the matching localizations
	 */
	public static List<Localization> findByChannelId_LanguageId_GlobalVersion(
		long channelId, long languageId, long globalVersion) {

		return getPersistence().findByChannelId_LanguageId_GlobalVersion(
			channelId, languageId, globalVersion);
	}

	/**
	 * Returns a range of all the localizations where channelId = &#63; and languageId = &#63; and globalVersion = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param languageId the language ID
	 * @param globalVersion the global version
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @return the range of matching localizations
	 */
	public static List<Localization> findByChannelId_LanguageId_GlobalVersion(
		long channelId, long languageId, long globalVersion, int start,
		int end) {

		return getPersistence().findByChannelId_LanguageId_GlobalVersion(
			channelId, languageId, globalVersion, start, end);
	}

	/**
	 * Returns an ordered range of all the localizations where channelId = &#63; and languageId = &#63; and globalVersion = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param languageId the language ID
	 * @param globalVersion the global version
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching localizations
	 */
	public static List<Localization> findByChannelId_LanguageId_GlobalVersion(
		long channelId, long languageId, long globalVersion, int start, int end,
		OrderByComparator<Localization> orderByComparator) {

		return getPersistence().findByChannelId_LanguageId_GlobalVersion(
			channelId, languageId, globalVersion, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the localizations where channelId = &#63; and languageId = &#63; and globalVersion = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param languageId the language ID
	 * @param globalVersion the global version
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching localizations
	 */
	public static List<Localization> findByChannelId_LanguageId_GlobalVersion(
		long channelId, long languageId, long globalVersion, int start, int end,
		OrderByComparator<Localization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByChannelId_LanguageId_GlobalVersion(
			channelId, languageId, globalVersion, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first localization in the ordered set where channelId = &#63; and languageId = &#63; and globalVersion = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param languageId the language ID
	 * @param globalVersion the global version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching localization
	 * @throws NoSuchLocalizationException if a matching localization could not be found
	 */
	public static Localization findByChannelId_LanguageId_GlobalVersion_First(
			long channelId, long languageId, long globalVersion,
			OrderByComparator<Localization> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLocalizationException {

		return getPersistence().findByChannelId_LanguageId_GlobalVersion_First(
			channelId, languageId, globalVersion, orderByComparator);
	}

	/**
	 * Returns the first localization in the ordered set where channelId = &#63; and languageId = &#63; and globalVersion = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param languageId the language ID
	 * @param globalVersion the global version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching localization, or <code>null</code> if a matching localization could not be found
	 */
	public static Localization fetchByChannelId_LanguageId_GlobalVersion_First(
		long channelId, long languageId, long globalVersion,
		OrderByComparator<Localization> orderByComparator) {

		return getPersistence().fetchByChannelId_LanguageId_GlobalVersion_First(
			channelId, languageId, globalVersion, orderByComparator);
	}

	/**
	 * Returns the last localization in the ordered set where channelId = &#63; and languageId = &#63; and globalVersion = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param languageId the language ID
	 * @param globalVersion the global version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching localization
	 * @throws NoSuchLocalizationException if a matching localization could not be found
	 */
	public static Localization findByChannelId_LanguageId_GlobalVersion_Last(
			long channelId, long languageId, long globalVersion,
			OrderByComparator<Localization> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLocalizationException {

		return getPersistence().findByChannelId_LanguageId_GlobalVersion_Last(
			channelId, languageId, globalVersion, orderByComparator);
	}

	/**
	 * Returns the last localization in the ordered set where channelId = &#63; and languageId = &#63; and globalVersion = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param languageId the language ID
	 * @param globalVersion the global version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching localization, or <code>null</code> if a matching localization could not be found
	 */
	public static Localization fetchByChannelId_LanguageId_GlobalVersion_Last(
		long channelId, long languageId, long globalVersion,
		OrderByComparator<Localization> orderByComparator) {

		return getPersistence().fetchByChannelId_LanguageId_GlobalVersion_Last(
			channelId, languageId, globalVersion, orderByComparator);
	}

	/**
	 * Returns the localizations before and after the current localization in the ordered set where channelId = &#63; and languageId = &#63; and globalVersion = &#63;.
	 *
	 * @param localizationId the primary key of the current localization
	 * @param channelId the channel ID
	 * @param languageId the language ID
	 * @param globalVersion the global version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next localization
	 * @throws NoSuchLocalizationException if a localization with the primary key could not be found
	 */
	public static Localization[]
			findByChannelId_LanguageId_GlobalVersion_PrevAndNext(
				long localizationId, long channelId, long languageId,
				long globalVersion,
				OrderByComparator<Localization> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLocalizationException {

		return getPersistence().
			findByChannelId_LanguageId_GlobalVersion_PrevAndNext(
				localizationId, channelId, languageId, globalVersion,
				orderByComparator);
	}

	/**
	 * Removes all the localizations where channelId = &#63; and languageId = &#63; and globalVersion = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param languageId the language ID
	 * @param globalVersion the global version
	 */
	public static void removeByChannelId_LanguageId_GlobalVersion(
		long channelId, long languageId, long globalVersion) {

		getPersistence().removeByChannelId_LanguageId_GlobalVersion(
			channelId, languageId, globalVersion);
	}

	/**
	 * Returns the number of localizations where channelId = &#63; and languageId = &#63; and globalVersion = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param languageId the language ID
	 * @param globalVersion the global version
	 * @return the number of matching localizations
	 */
	public static int countByChannelId_LanguageId_GlobalVersion(
		long channelId, long languageId, long globalVersion) {

		return getPersistence().countByChannelId_LanguageId_GlobalVersion(
			channelId, languageId, globalVersion);
	}

	/**
	 * Returns all the localizations where workflowBatchId = &#63;.
	 *
	 * @param workflowBatchId the workflow batch ID
	 * @return the matching localizations
	 */
	public static List<Localization> findByWorkflowBatchId(
		String workflowBatchId) {

		return getPersistence().findByWorkflowBatchId(workflowBatchId);
	}

	/**
	 * Returns a range of all the localizations where workflowBatchId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param workflowBatchId the workflow batch ID
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @return the range of matching localizations
	 */
	public static List<Localization> findByWorkflowBatchId(
		String workflowBatchId, int start, int end) {

		return getPersistence().findByWorkflowBatchId(
			workflowBatchId, start, end);
	}

	/**
	 * Returns an ordered range of all the localizations where workflowBatchId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param workflowBatchId the workflow batch ID
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching localizations
	 */
	public static List<Localization> findByWorkflowBatchId(
		String workflowBatchId, int start, int end,
		OrderByComparator<Localization> orderByComparator) {

		return getPersistence().findByWorkflowBatchId(
			workflowBatchId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the localizations where workflowBatchId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param workflowBatchId the workflow batch ID
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching localizations
	 */
	public static List<Localization> findByWorkflowBatchId(
		String workflowBatchId, int start, int end,
		OrderByComparator<Localization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByWorkflowBatchId(
			workflowBatchId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first localization in the ordered set where workflowBatchId = &#63;.
	 *
	 * @param workflowBatchId the workflow batch ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching localization
	 * @throws NoSuchLocalizationException if a matching localization could not be found
	 */
	public static Localization findByWorkflowBatchId_First(
			String workflowBatchId,
			OrderByComparator<Localization> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLocalizationException {

		return getPersistence().findByWorkflowBatchId_First(
			workflowBatchId, orderByComparator);
	}

	/**
	 * Returns the first localization in the ordered set where workflowBatchId = &#63;.
	 *
	 * @param workflowBatchId the workflow batch ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching localization, or <code>null</code> if a matching localization could not be found
	 */
	public static Localization fetchByWorkflowBatchId_First(
		String workflowBatchId,
		OrderByComparator<Localization> orderByComparator) {

		return getPersistence().fetchByWorkflowBatchId_First(
			workflowBatchId, orderByComparator);
	}

	/**
	 * Returns the last localization in the ordered set where workflowBatchId = &#63;.
	 *
	 * @param workflowBatchId the workflow batch ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching localization
	 * @throws NoSuchLocalizationException if a matching localization could not be found
	 */
	public static Localization findByWorkflowBatchId_Last(
			String workflowBatchId,
			OrderByComparator<Localization> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLocalizationException {

		return getPersistence().findByWorkflowBatchId_Last(
			workflowBatchId, orderByComparator);
	}

	/**
	 * Returns the last localization in the ordered set where workflowBatchId = &#63;.
	 *
	 * @param workflowBatchId the workflow batch ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching localization, or <code>null</code> if a matching localization could not be found
	 */
	public static Localization fetchByWorkflowBatchId_Last(
		String workflowBatchId,
		OrderByComparator<Localization> orderByComparator) {

		return getPersistence().fetchByWorkflowBatchId_Last(
			workflowBatchId, orderByComparator);
	}

	/**
	 * Returns the localizations before and after the current localization in the ordered set where workflowBatchId = &#63;.
	 *
	 * @param localizationId the primary key of the current localization
	 * @param workflowBatchId the workflow batch ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next localization
	 * @throws NoSuchLocalizationException if a localization with the primary key could not be found
	 */
	public static Localization[] findByWorkflowBatchId_PrevAndNext(
			long localizationId, String workflowBatchId,
			OrderByComparator<Localization> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLocalizationException {

		return getPersistence().findByWorkflowBatchId_PrevAndNext(
			localizationId, workflowBatchId, orderByComparator);
	}

	/**
	 * Removes all the localizations where workflowBatchId = &#63; from the database.
	 *
	 * @param workflowBatchId the workflow batch ID
	 */
	public static void removeByWorkflowBatchId(String workflowBatchId) {
		getPersistence().removeByWorkflowBatchId(workflowBatchId);
	}

	/**
	 * Returns the number of localizations where workflowBatchId = &#63;.
	 *
	 * @param workflowBatchId the workflow batch ID
	 * @return the number of matching localizations
	 */
	public static int countByWorkflowBatchId(String workflowBatchId) {
		return getPersistence().countByWorkflowBatchId(workflowBatchId);
	}

	/**
	 * Returns all the localizations where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the matching localizations
	 */
	public static List<Localization> findByChannelId(long channelId) {
		return getPersistence().findByChannelId(channelId);
	}

	/**
	 * Returns a range of all the localizations where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @return the range of matching localizations
	 */
	public static List<Localization> findByChannelId(
		long channelId, int start, int end) {

		return getPersistence().findByChannelId(channelId, start, end);
	}

	/**
	 * Returns an ordered range of all the localizations where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching localizations
	 */
	public static List<Localization> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<Localization> orderByComparator) {

		return getPersistence().findByChannelId(
			channelId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the localizations where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching localizations
	 */
	public static List<Localization> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<Localization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByChannelId(
			channelId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first localization in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching localization
	 * @throws NoSuchLocalizationException if a matching localization could not be found
	 */
	public static Localization findByChannelId_First(
			long channelId, OrderByComparator<Localization> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLocalizationException {

		return getPersistence().findByChannelId_First(
			channelId, orderByComparator);
	}

	/**
	 * Returns the first localization in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching localization, or <code>null</code> if a matching localization could not be found
	 */
	public static Localization fetchByChannelId_First(
		long channelId, OrderByComparator<Localization> orderByComparator) {

		return getPersistence().fetchByChannelId_First(
			channelId, orderByComparator);
	}

	/**
	 * Returns the last localization in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching localization
	 * @throws NoSuchLocalizationException if a matching localization could not be found
	 */
	public static Localization findByChannelId_Last(
			long channelId, OrderByComparator<Localization> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLocalizationException {

		return getPersistence().findByChannelId_Last(
			channelId, orderByComparator);
	}

	/**
	 * Returns the last localization in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching localization, or <code>null</code> if a matching localization could not be found
	 */
	public static Localization fetchByChannelId_Last(
		long channelId, OrderByComparator<Localization> orderByComparator) {

		return getPersistence().fetchByChannelId_Last(
			channelId, orderByComparator);
	}

	/**
	 * Returns the localizations before and after the current localization in the ordered set where channelId = &#63;.
	 *
	 * @param localizationId the primary key of the current localization
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next localization
	 * @throws NoSuchLocalizationException if a localization with the primary key could not be found
	 */
	public static Localization[] findByChannelId_PrevAndNext(
			long localizationId, long channelId,
			OrderByComparator<Localization> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLocalizationException {

		return getPersistence().findByChannelId_PrevAndNext(
			localizationId, channelId, orderByComparator);
	}

	/**
	 * Removes all the localizations where channelId = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 */
	public static void removeByChannelId(long channelId) {
		getPersistence().removeByChannelId(channelId);
	}

	/**
	 * Returns the number of localizations where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the number of matching localizations
	 */
	public static int countByChannelId(long channelId) {
		return getPersistence().countByChannelId(channelId);
	}

	/**
	 * Returns all the localizations where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the matching localizations
	 */
	public static List<Localization> findByentityResourceId(
		long entityResourceId) {

		return getPersistence().findByentityResourceId(entityResourceId);
	}

	/**
	 * Returns a range of all the localizations where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @return the range of matching localizations
	 */
	public static List<Localization> findByentityResourceId(
		long entityResourceId, int start, int end) {

		return getPersistence().findByentityResourceId(
			entityResourceId, start, end);
	}

	/**
	 * Returns an ordered range of all the localizations where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching localizations
	 */
	public static List<Localization> findByentityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<Localization> orderByComparator) {

		return getPersistence().findByentityResourceId(
			entityResourceId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the localizations where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching localizations
	 */
	public static List<Localization> findByentityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<Localization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByentityResourceId(
			entityResourceId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first localization in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching localization
	 * @throws NoSuchLocalizationException if a matching localization could not be found
	 */
	public static Localization findByentityResourceId_First(
			long entityResourceId,
			OrderByComparator<Localization> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLocalizationException {

		return getPersistence().findByentityResourceId_First(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the first localization in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching localization, or <code>null</code> if a matching localization could not be found
	 */
	public static Localization fetchByentityResourceId_First(
		long entityResourceId,
		OrderByComparator<Localization> orderByComparator) {

		return getPersistence().fetchByentityResourceId_First(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the last localization in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching localization
	 * @throws NoSuchLocalizationException if a matching localization could not be found
	 */
	public static Localization findByentityResourceId_Last(
			long entityResourceId,
			OrderByComparator<Localization> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLocalizationException {

		return getPersistence().findByentityResourceId_Last(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the last localization in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching localization, or <code>null</code> if a matching localization could not be found
	 */
	public static Localization fetchByentityResourceId_Last(
		long entityResourceId,
		OrderByComparator<Localization> orderByComparator) {

		return getPersistence().fetchByentityResourceId_Last(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the localizations before and after the current localization in the ordered set where entityResourceId = &#63;.
	 *
	 * @param localizationId the primary key of the current localization
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next localization
	 * @throws NoSuchLocalizationException if a localization with the primary key could not be found
	 */
	public static Localization[] findByentityResourceId_PrevAndNext(
			long localizationId, long entityResourceId,
			OrderByComparator<Localization> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLocalizationException {

		return getPersistence().findByentityResourceId_PrevAndNext(
			localizationId, entityResourceId, orderByComparator);
	}

	/**
	 * Removes all the localizations where entityResourceId = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 */
	public static void removeByentityResourceId(long entityResourceId) {
		getPersistence().removeByentityResourceId(entityResourceId);
	}

	/**
	 * Returns the number of localizations where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the number of matching localizations
	 */
	public static int countByentityResourceId(long entityResourceId) {
		return getPersistence().countByentityResourceId(entityResourceId);
	}

	/**
	 * Returns all the localizations where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @return the matching localizations
	 */
	public static List<Localization> findByFeatureId(long featureId) {
		return getPersistence().findByFeatureId(featureId);
	}

	/**
	 * Returns a range of all the localizations where featureId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param featureId the feature ID
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @return the range of matching localizations
	 */
	public static List<Localization> findByFeatureId(
		long featureId, int start, int end) {

		return getPersistence().findByFeatureId(featureId, start, end);
	}

	/**
	 * Returns an ordered range of all the localizations where featureId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param featureId the feature ID
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching localizations
	 */
	public static List<Localization> findByFeatureId(
		long featureId, int start, int end,
		OrderByComparator<Localization> orderByComparator) {

		return getPersistence().findByFeatureId(
			featureId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the localizations where featureId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param featureId the feature ID
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching localizations
	 */
	public static List<Localization> findByFeatureId(
		long featureId, int start, int end,
		OrderByComparator<Localization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFeatureId(
			featureId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first localization in the ordered set where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching localization
	 * @throws NoSuchLocalizationException if a matching localization could not be found
	 */
	public static Localization findByFeatureId_First(
			long featureId, OrderByComparator<Localization> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLocalizationException {

		return getPersistence().findByFeatureId_First(
			featureId, orderByComparator);
	}

	/**
	 * Returns the first localization in the ordered set where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching localization, or <code>null</code> if a matching localization could not be found
	 */
	public static Localization fetchByFeatureId_First(
		long featureId, OrderByComparator<Localization> orderByComparator) {

		return getPersistence().fetchByFeatureId_First(
			featureId, orderByComparator);
	}

	/**
	 * Returns the last localization in the ordered set where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching localization
	 * @throws NoSuchLocalizationException if a matching localization could not be found
	 */
	public static Localization findByFeatureId_Last(
			long featureId, OrderByComparator<Localization> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLocalizationException {

		return getPersistence().findByFeatureId_Last(
			featureId, orderByComparator);
	}

	/**
	 * Returns the last localization in the ordered set where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching localization, or <code>null</code> if a matching localization could not be found
	 */
	public static Localization fetchByFeatureId_Last(
		long featureId, OrderByComparator<Localization> orderByComparator) {

		return getPersistence().fetchByFeatureId_Last(
			featureId, orderByComparator);
	}

	/**
	 * Returns the localizations before and after the current localization in the ordered set where featureId = &#63;.
	 *
	 * @param localizationId the primary key of the current localization
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next localization
	 * @throws NoSuchLocalizationException if a localization with the primary key could not be found
	 */
	public static Localization[] findByFeatureId_PrevAndNext(
			long localizationId, long featureId,
			OrderByComparator<Localization> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLocalizationException {

		return getPersistence().findByFeatureId_PrevAndNext(
			localizationId, featureId, orderByComparator);
	}

	/**
	 * Removes all the localizations where featureId = &#63; from the database.
	 *
	 * @param featureId the feature ID
	 */
	public static void removeByFeatureId(long featureId) {
		getPersistence().removeByFeatureId(featureId);
	}

	/**
	 * Returns the number of localizations where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @return the number of matching localizations
	 */
	public static int countByFeatureId(long featureId) {
		return getPersistence().countByFeatureId(featureId);
	}

	/**
	 * Returns all the localizations where channelId = &#63; and featureId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param featureId the feature ID
	 * @return the matching localizations
	 */
	public static List<Localization> findByChannelId_FeatureId(
		long channelId, long featureId) {

		return getPersistence().findByChannelId_FeatureId(channelId, featureId);
	}

	/**
	 * Returns a range of all the localizations where channelId = &#63; and featureId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param featureId the feature ID
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @return the range of matching localizations
	 */
	public static List<Localization> findByChannelId_FeatureId(
		long channelId, long featureId, int start, int end) {

		return getPersistence().findByChannelId_FeatureId(
			channelId, featureId, start, end);
	}

	/**
	 * Returns an ordered range of all the localizations where channelId = &#63; and featureId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param featureId the feature ID
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching localizations
	 */
	public static List<Localization> findByChannelId_FeatureId(
		long channelId, long featureId, int start, int end,
		OrderByComparator<Localization> orderByComparator) {

		return getPersistence().findByChannelId_FeatureId(
			channelId, featureId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the localizations where channelId = &#63; and featureId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param featureId the feature ID
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching localizations
	 */
	public static List<Localization> findByChannelId_FeatureId(
		long channelId, long featureId, int start, int end,
		OrderByComparator<Localization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByChannelId_FeatureId(
			channelId, featureId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first localization in the ordered set where channelId = &#63; and featureId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching localization
	 * @throws NoSuchLocalizationException if a matching localization could not be found
	 */
	public static Localization findByChannelId_FeatureId_First(
			long channelId, long featureId,
			OrderByComparator<Localization> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLocalizationException {

		return getPersistence().findByChannelId_FeatureId_First(
			channelId, featureId, orderByComparator);
	}

	/**
	 * Returns the first localization in the ordered set where channelId = &#63; and featureId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching localization, or <code>null</code> if a matching localization could not be found
	 */
	public static Localization fetchByChannelId_FeatureId_First(
		long channelId, long featureId,
		OrderByComparator<Localization> orderByComparator) {

		return getPersistence().fetchByChannelId_FeatureId_First(
			channelId, featureId, orderByComparator);
	}

	/**
	 * Returns the last localization in the ordered set where channelId = &#63; and featureId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching localization
	 * @throws NoSuchLocalizationException if a matching localization could not be found
	 */
	public static Localization findByChannelId_FeatureId_Last(
			long channelId, long featureId,
			OrderByComparator<Localization> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLocalizationException {

		return getPersistence().findByChannelId_FeatureId_Last(
			channelId, featureId, orderByComparator);
	}

	/**
	 * Returns the last localization in the ordered set where channelId = &#63; and featureId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching localization, or <code>null</code> if a matching localization could not be found
	 */
	public static Localization fetchByChannelId_FeatureId_Last(
		long channelId, long featureId,
		OrderByComparator<Localization> orderByComparator) {

		return getPersistence().fetchByChannelId_FeatureId_Last(
			channelId, featureId, orderByComparator);
	}

	/**
	 * Returns the localizations before and after the current localization in the ordered set where channelId = &#63; and featureId = &#63;.
	 *
	 * @param localizationId the primary key of the current localization
	 * @param channelId the channel ID
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next localization
	 * @throws NoSuchLocalizationException if a localization with the primary key could not be found
	 */
	public static Localization[] findByChannelId_FeatureId_PrevAndNext(
			long localizationId, long channelId, long featureId,
			OrderByComparator<Localization> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchLocalizationException {

		return getPersistence().findByChannelId_FeatureId_PrevAndNext(
			localizationId, channelId, featureId, orderByComparator);
	}

	/**
	 * Removes all the localizations where channelId = &#63; and featureId = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param featureId the feature ID
	 */
	public static void removeByChannelId_FeatureId(
		long channelId, long featureId) {

		getPersistence().removeByChannelId_FeatureId(channelId, featureId);
	}

	/**
	 * Returns the number of localizations where channelId = &#63; and featureId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param featureId the feature ID
	 * @return the number of matching localizations
	 */
	public static int countByChannelId_FeatureId(
		long channelId, long featureId) {

		return getPersistence().countByChannelId_FeatureId(
			channelId, featureId);
	}

	/**
	 * Caches the localization in the entity cache if it is enabled.
	 *
	 * @param localization the localization
	 */
	public static void cacheResult(Localization localization) {
		getPersistence().cacheResult(localization);
	}

	/**
	 * Caches the localizations in the entity cache if it is enabled.
	 *
	 * @param localizations the localizations
	 */
	public static void cacheResult(List<Localization> localizations) {
		getPersistence().cacheResult(localizations);
	}

	/**
	 * Creates a new localization with the primary key. Does not add the localization to the database.
	 *
	 * @param localizationId the primary key for the new localization
	 * @return the new localization
	 */
	public static Localization create(long localizationId) {
		return getPersistence().create(localizationId);
	}

	/**
	 * Removes the localization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param localizationId the primary key of the localization
	 * @return the localization that was removed
	 * @throws NoSuchLocalizationException if a localization with the primary key could not be found
	 */
	public static Localization remove(long localizationId)
		throws com.ejada.telemony.db.exception.NoSuchLocalizationException {

		return getPersistence().remove(localizationId);
	}

	public static Localization updateImpl(Localization localization) {
		return getPersistence().updateImpl(localization);
	}

	/**
	 * Returns the localization with the primary key or throws a <code>NoSuchLocalizationException</code> if it could not be found.
	 *
	 * @param localizationId the primary key of the localization
	 * @return the localization
	 * @throws NoSuchLocalizationException if a localization with the primary key could not be found
	 */
	public static Localization findByPrimaryKey(long localizationId)
		throws com.ejada.telemony.db.exception.NoSuchLocalizationException {

		return getPersistence().findByPrimaryKey(localizationId);
	}

	/**
	 * Returns the localization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param localizationId the primary key of the localization
	 * @return the localization, or <code>null</code> if a localization with the primary key could not be found
	 */
	public static Localization fetchByPrimaryKey(long localizationId) {
		return getPersistence().fetchByPrimaryKey(localizationId);
	}

	/**
	 * Returns all the localizations.
	 *
	 * @return the localizations
	 */
	public static List<Localization> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the localizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @return the range of localizations
	 */
	public static List<Localization> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the localizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of localizations
	 */
	public static List<Localization> findAll(
		int start, int end, OrderByComparator<Localization> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the localizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of localizations
	 */
	public static List<Localization> findAll(
		int start, int end, OrderByComparator<Localization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the localizations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of localizations.
	 *
	 * @return the number of localizations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LocalizationPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(LocalizationPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile LocalizationPersistence _persistence;

}