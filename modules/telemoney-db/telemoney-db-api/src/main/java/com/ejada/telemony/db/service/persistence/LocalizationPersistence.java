/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.exception.NoSuchLocalizationException;
import com.ejada.telemony.db.model.Localization;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the localization service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LocalizationUtil
 * @generated
 */
@ProviderType
public interface LocalizationPersistence extends BasePersistence<Localization> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LocalizationUtil} to access the localization persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the localizations where channelId = &#63; and languageId = &#63; and globalVersion = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param languageId the language ID
	 * @param globalVersion the global version
	 * @return the matching localizations
	 */
	public java.util.List<Localization>
		findByChannelId_LanguageId_GlobalVersion(
			long channelId, long languageId, long globalVersion);

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
	public java.util.List<Localization>
		findByChannelId_LanguageId_GlobalVersion(
			long channelId, long languageId, long globalVersion, int start,
			int end);

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
	public java.util.List<Localization>
		findByChannelId_LanguageId_GlobalVersion(
			long channelId, long languageId, long globalVersion, int start,
			int end,
			com.liferay.portal.kernel.util.OrderByComparator<Localization>
				orderByComparator);

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
	public java.util.List<Localization>
		findByChannelId_LanguageId_GlobalVersion(
			long channelId, long languageId, long globalVersion, int start,
			int end,
			com.liferay.portal.kernel.util.OrderByComparator<Localization>
				orderByComparator,
			boolean useFinderCache);

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
	public Localization findByChannelId_LanguageId_GlobalVersion_First(
			long channelId, long languageId, long globalVersion,
			com.liferay.portal.kernel.util.OrderByComparator<Localization>
				orderByComparator)
		throws NoSuchLocalizationException;

	/**
	 * Returns the first localization in the ordered set where channelId = &#63; and languageId = &#63; and globalVersion = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param languageId the language ID
	 * @param globalVersion the global version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching localization, or <code>null</code> if a matching localization could not be found
	 */
	public Localization fetchByChannelId_LanguageId_GlobalVersion_First(
		long channelId, long languageId, long globalVersion,
		com.liferay.portal.kernel.util.OrderByComparator<Localization>
			orderByComparator);

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
	public Localization findByChannelId_LanguageId_GlobalVersion_Last(
			long channelId, long languageId, long globalVersion,
			com.liferay.portal.kernel.util.OrderByComparator<Localization>
				orderByComparator)
		throws NoSuchLocalizationException;

	/**
	 * Returns the last localization in the ordered set where channelId = &#63; and languageId = &#63; and globalVersion = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param languageId the language ID
	 * @param globalVersion the global version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching localization, or <code>null</code> if a matching localization could not be found
	 */
	public Localization fetchByChannelId_LanguageId_GlobalVersion_Last(
		long channelId, long languageId, long globalVersion,
		com.liferay.portal.kernel.util.OrderByComparator<Localization>
			orderByComparator);

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
	public Localization[] findByChannelId_LanguageId_GlobalVersion_PrevAndNext(
			long localizationId, long channelId, long languageId,
			long globalVersion,
			com.liferay.portal.kernel.util.OrderByComparator<Localization>
				orderByComparator)
		throws NoSuchLocalizationException;

	/**
	 * Removes all the localizations where channelId = &#63; and languageId = &#63; and globalVersion = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param languageId the language ID
	 * @param globalVersion the global version
	 */
	public void removeByChannelId_LanguageId_GlobalVersion(
		long channelId, long languageId, long globalVersion);

	/**
	 * Returns the number of localizations where channelId = &#63; and languageId = &#63; and globalVersion = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param languageId the language ID
	 * @param globalVersion the global version
	 * @return the number of matching localizations
	 */
	public int countByChannelId_LanguageId_GlobalVersion(
		long channelId, long languageId, long globalVersion);

	/**
	 * Returns all the localizations where workflowBatchId = &#63;.
	 *
	 * @param workflowBatchId the workflow batch ID
	 * @return the matching localizations
	 */
	public java.util.List<Localization> findByWorkflowBatchId(
		String workflowBatchId);

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
	public java.util.List<Localization> findByWorkflowBatchId(
		String workflowBatchId, int start, int end);

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
	public java.util.List<Localization> findByWorkflowBatchId(
		String workflowBatchId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Localization>
			orderByComparator);

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
	public java.util.List<Localization> findByWorkflowBatchId(
		String workflowBatchId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Localization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first localization in the ordered set where workflowBatchId = &#63;.
	 *
	 * @param workflowBatchId the workflow batch ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching localization
	 * @throws NoSuchLocalizationException if a matching localization could not be found
	 */
	public Localization findByWorkflowBatchId_First(
			String workflowBatchId,
			com.liferay.portal.kernel.util.OrderByComparator<Localization>
				orderByComparator)
		throws NoSuchLocalizationException;

	/**
	 * Returns the first localization in the ordered set where workflowBatchId = &#63;.
	 *
	 * @param workflowBatchId the workflow batch ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching localization, or <code>null</code> if a matching localization could not be found
	 */
	public Localization fetchByWorkflowBatchId_First(
		String workflowBatchId,
		com.liferay.portal.kernel.util.OrderByComparator<Localization>
			orderByComparator);

	/**
	 * Returns the last localization in the ordered set where workflowBatchId = &#63;.
	 *
	 * @param workflowBatchId the workflow batch ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching localization
	 * @throws NoSuchLocalizationException if a matching localization could not be found
	 */
	public Localization findByWorkflowBatchId_Last(
			String workflowBatchId,
			com.liferay.portal.kernel.util.OrderByComparator<Localization>
				orderByComparator)
		throws NoSuchLocalizationException;

	/**
	 * Returns the last localization in the ordered set where workflowBatchId = &#63;.
	 *
	 * @param workflowBatchId the workflow batch ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching localization, or <code>null</code> if a matching localization could not be found
	 */
	public Localization fetchByWorkflowBatchId_Last(
		String workflowBatchId,
		com.liferay.portal.kernel.util.OrderByComparator<Localization>
			orderByComparator);

	/**
	 * Returns the localizations before and after the current localization in the ordered set where workflowBatchId = &#63;.
	 *
	 * @param localizationId the primary key of the current localization
	 * @param workflowBatchId the workflow batch ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next localization
	 * @throws NoSuchLocalizationException if a localization with the primary key could not be found
	 */
	public Localization[] findByWorkflowBatchId_PrevAndNext(
			long localizationId, String workflowBatchId,
			com.liferay.portal.kernel.util.OrderByComparator<Localization>
				orderByComparator)
		throws NoSuchLocalizationException;

	/**
	 * Removes all the localizations where workflowBatchId = &#63; from the database.
	 *
	 * @param workflowBatchId the workflow batch ID
	 */
	public void removeByWorkflowBatchId(String workflowBatchId);

	/**
	 * Returns the number of localizations where workflowBatchId = &#63;.
	 *
	 * @param workflowBatchId the workflow batch ID
	 * @return the number of matching localizations
	 */
	public int countByWorkflowBatchId(String workflowBatchId);

	/**
	 * Returns all the localizations where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the matching localizations
	 */
	public java.util.List<Localization> findByChannelId(long channelId);

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
	public java.util.List<Localization> findByChannelId(
		long channelId, int start, int end);

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
	public java.util.List<Localization> findByChannelId(
		long channelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Localization>
			orderByComparator);

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
	public java.util.List<Localization> findByChannelId(
		long channelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Localization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first localization in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching localization
	 * @throws NoSuchLocalizationException if a matching localization could not be found
	 */
	public Localization findByChannelId_First(
			long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<Localization>
				orderByComparator)
		throws NoSuchLocalizationException;

	/**
	 * Returns the first localization in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching localization, or <code>null</code> if a matching localization could not be found
	 */
	public Localization fetchByChannelId_First(
		long channelId,
		com.liferay.portal.kernel.util.OrderByComparator<Localization>
			orderByComparator);

	/**
	 * Returns the last localization in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching localization
	 * @throws NoSuchLocalizationException if a matching localization could not be found
	 */
	public Localization findByChannelId_Last(
			long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<Localization>
				orderByComparator)
		throws NoSuchLocalizationException;

	/**
	 * Returns the last localization in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching localization, or <code>null</code> if a matching localization could not be found
	 */
	public Localization fetchByChannelId_Last(
		long channelId,
		com.liferay.portal.kernel.util.OrderByComparator<Localization>
			orderByComparator);

	/**
	 * Returns the localizations before and after the current localization in the ordered set where channelId = &#63;.
	 *
	 * @param localizationId the primary key of the current localization
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next localization
	 * @throws NoSuchLocalizationException if a localization with the primary key could not be found
	 */
	public Localization[] findByChannelId_PrevAndNext(
			long localizationId, long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<Localization>
				orderByComparator)
		throws NoSuchLocalizationException;

	/**
	 * Removes all the localizations where channelId = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 */
	public void removeByChannelId(long channelId);

	/**
	 * Returns the number of localizations where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the number of matching localizations
	 */
	public int countByChannelId(long channelId);

	/**
	 * Returns all the localizations where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the matching localizations
	 */
	public java.util.List<Localization> findByentityResourceId(
		long entityResourceId);

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
	public java.util.List<Localization> findByentityResourceId(
		long entityResourceId, int start, int end);

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
	public java.util.List<Localization> findByentityResourceId(
		long entityResourceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Localization>
			orderByComparator);

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
	public java.util.List<Localization> findByentityResourceId(
		long entityResourceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Localization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first localization in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching localization
	 * @throws NoSuchLocalizationException if a matching localization could not be found
	 */
	public Localization findByentityResourceId_First(
			long entityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<Localization>
				orderByComparator)
		throws NoSuchLocalizationException;

	/**
	 * Returns the first localization in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching localization, or <code>null</code> if a matching localization could not be found
	 */
	public Localization fetchByentityResourceId_First(
		long entityResourceId,
		com.liferay.portal.kernel.util.OrderByComparator<Localization>
			orderByComparator);

	/**
	 * Returns the last localization in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching localization
	 * @throws NoSuchLocalizationException if a matching localization could not be found
	 */
	public Localization findByentityResourceId_Last(
			long entityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<Localization>
				orderByComparator)
		throws NoSuchLocalizationException;

	/**
	 * Returns the last localization in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching localization, or <code>null</code> if a matching localization could not be found
	 */
	public Localization fetchByentityResourceId_Last(
		long entityResourceId,
		com.liferay.portal.kernel.util.OrderByComparator<Localization>
			orderByComparator);

	/**
	 * Returns the localizations before and after the current localization in the ordered set where entityResourceId = &#63;.
	 *
	 * @param localizationId the primary key of the current localization
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next localization
	 * @throws NoSuchLocalizationException if a localization with the primary key could not be found
	 */
	public Localization[] findByentityResourceId_PrevAndNext(
			long localizationId, long entityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<Localization>
				orderByComparator)
		throws NoSuchLocalizationException;

	/**
	 * Removes all the localizations where entityResourceId = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 */
	public void removeByentityResourceId(long entityResourceId);

	/**
	 * Returns the number of localizations where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the number of matching localizations
	 */
	public int countByentityResourceId(long entityResourceId);

	/**
	 * Returns all the localizations where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @return the matching localizations
	 */
	public java.util.List<Localization> findByFeatureId(long featureId);

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
	public java.util.List<Localization> findByFeatureId(
		long featureId, int start, int end);

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
	public java.util.List<Localization> findByFeatureId(
		long featureId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Localization>
			orderByComparator);

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
	public java.util.List<Localization> findByFeatureId(
		long featureId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Localization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first localization in the ordered set where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching localization
	 * @throws NoSuchLocalizationException if a matching localization could not be found
	 */
	public Localization findByFeatureId_First(
			long featureId,
			com.liferay.portal.kernel.util.OrderByComparator<Localization>
				orderByComparator)
		throws NoSuchLocalizationException;

	/**
	 * Returns the first localization in the ordered set where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching localization, or <code>null</code> if a matching localization could not be found
	 */
	public Localization fetchByFeatureId_First(
		long featureId,
		com.liferay.portal.kernel.util.OrderByComparator<Localization>
			orderByComparator);

	/**
	 * Returns the last localization in the ordered set where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching localization
	 * @throws NoSuchLocalizationException if a matching localization could not be found
	 */
	public Localization findByFeatureId_Last(
			long featureId,
			com.liferay.portal.kernel.util.OrderByComparator<Localization>
				orderByComparator)
		throws NoSuchLocalizationException;

	/**
	 * Returns the last localization in the ordered set where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching localization, or <code>null</code> if a matching localization could not be found
	 */
	public Localization fetchByFeatureId_Last(
		long featureId,
		com.liferay.portal.kernel.util.OrderByComparator<Localization>
			orderByComparator);

	/**
	 * Returns the localizations before and after the current localization in the ordered set where featureId = &#63;.
	 *
	 * @param localizationId the primary key of the current localization
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next localization
	 * @throws NoSuchLocalizationException if a localization with the primary key could not be found
	 */
	public Localization[] findByFeatureId_PrevAndNext(
			long localizationId, long featureId,
			com.liferay.portal.kernel.util.OrderByComparator<Localization>
				orderByComparator)
		throws NoSuchLocalizationException;

	/**
	 * Removes all the localizations where featureId = &#63; from the database.
	 *
	 * @param featureId the feature ID
	 */
	public void removeByFeatureId(long featureId);

	/**
	 * Returns the number of localizations where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @return the number of matching localizations
	 */
	public int countByFeatureId(long featureId);

	/**
	 * Returns all the localizations where channelId = &#63; and featureId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param featureId the feature ID
	 * @return the matching localizations
	 */
	public java.util.List<Localization> findByChannelId_FeatureId(
		long channelId, long featureId);

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
	public java.util.List<Localization> findByChannelId_FeatureId(
		long channelId, long featureId, int start, int end);

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
	public java.util.List<Localization> findByChannelId_FeatureId(
		long channelId, long featureId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Localization>
			orderByComparator);

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
	public java.util.List<Localization> findByChannelId_FeatureId(
		long channelId, long featureId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Localization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first localization in the ordered set where channelId = &#63; and featureId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching localization
	 * @throws NoSuchLocalizationException if a matching localization could not be found
	 */
	public Localization findByChannelId_FeatureId_First(
			long channelId, long featureId,
			com.liferay.portal.kernel.util.OrderByComparator<Localization>
				orderByComparator)
		throws NoSuchLocalizationException;

	/**
	 * Returns the first localization in the ordered set where channelId = &#63; and featureId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching localization, or <code>null</code> if a matching localization could not be found
	 */
	public Localization fetchByChannelId_FeatureId_First(
		long channelId, long featureId,
		com.liferay.portal.kernel.util.OrderByComparator<Localization>
			orderByComparator);

	/**
	 * Returns the last localization in the ordered set where channelId = &#63; and featureId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching localization
	 * @throws NoSuchLocalizationException if a matching localization could not be found
	 */
	public Localization findByChannelId_FeatureId_Last(
			long channelId, long featureId,
			com.liferay.portal.kernel.util.OrderByComparator<Localization>
				orderByComparator)
		throws NoSuchLocalizationException;

	/**
	 * Returns the last localization in the ordered set where channelId = &#63; and featureId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching localization, or <code>null</code> if a matching localization could not be found
	 */
	public Localization fetchByChannelId_FeatureId_Last(
		long channelId, long featureId,
		com.liferay.portal.kernel.util.OrderByComparator<Localization>
			orderByComparator);

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
	public Localization[] findByChannelId_FeatureId_PrevAndNext(
			long localizationId, long channelId, long featureId,
			com.liferay.portal.kernel.util.OrderByComparator<Localization>
				orderByComparator)
		throws NoSuchLocalizationException;

	/**
	 * Removes all the localizations where channelId = &#63; and featureId = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param featureId the feature ID
	 */
	public void removeByChannelId_FeatureId(long channelId, long featureId);

	/**
	 * Returns the number of localizations where channelId = &#63; and featureId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param featureId the feature ID
	 * @return the number of matching localizations
	 */
	public int countByChannelId_FeatureId(long channelId, long featureId);

	/**
	 * Caches the localization in the entity cache if it is enabled.
	 *
	 * @param localization the localization
	 */
	public void cacheResult(Localization localization);

	/**
	 * Caches the localizations in the entity cache if it is enabled.
	 *
	 * @param localizations the localizations
	 */
	public void cacheResult(java.util.List<Localization> localizations);

	/**
	 * Creates a new localization with the primary key. Does not add the localization to the database.
	 *
	 * @param localizationId the primary key for the new localization
	 * @return the new localization
	 */
	public Localization create(long localizationId);

	/**
	 * Removes the localization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param localizationId the primary key of the localization
	 * @return the localization that was removed
	 * @throws NoSuchLocalizationException if a localization with the primary key could not be found
	 */
	public Localization remove(long localizationId)
		throws NoSuchLocalizationException;

	public Localization updateImpl(Localization localization);

	/**
	 * Returns the localization with the primary key or throws a <code>NoSuchLocalizationException</code> if it could not be found.
	 *
	 * @param localizationId the primary key of the localization
	 * @return the localization
	 * @throws NoSuchLocalizationException if a localization with the primary key could not be found
	 */
	public Localization findByPrimaryKey(long localizationId)
		throws NoSuchLocalizationException;

	/**
	 * Returns the localization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param localizationId the primary key of the localization
	 * @return the localization, or <code>null</code> if a localization with the primary key could not be found
	 */
	public Localization fetchByPrimaryKey(long localizationId);

	/**
	 * Returns all the localizations.
	 *
	 * @return the localizations
	 */
	public java.util.List<Localization> findAll();

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
	public java.util.List<Localization> findAll(int start, int end);

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
	public java.util.List<Localization> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Localization>
			orderByComparator);

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
	public java.util.List<Localization> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Localization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the localizations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of localizations.
	 *
	 * @return the number of localizations
	 */
	public int countAll();

}