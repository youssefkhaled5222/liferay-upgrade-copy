/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.exception.NoSuchLanguagesException;
import com.ejada.telemony.db.model.Languages;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the languages service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LanguagesUtil
 * @generated
 */
@ProviderType
public interface LanguagesPersistence extends BasePersistence<Languages> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LanguagesUtil} to access the languages persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the languageses where channelId = &#63; and local = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param local the local
	 * @return the matching languageses
	 */
	public java.util.List<Languages> findByLocal(long channelId, String local);

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
	public java.util.List<Languages> findByLocal(
		long channelId, String local, int start, int end);

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
	public java.util.List<Languages> findByLocal(
		long channelId, String local, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Languages>
			orderByComparator);

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
	public java.util.List<Languages> findByLocal(
		long channelId, String local, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Languages>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first languages in the ordered set where channelId = &#63; and local = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param local the local
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching languages
	 * @throws NoSuchLanguagesException if a matching languages could not be found
	 */
	public Languages findByLocal_First(
			long channelId, String local,
			com.liferay.portal.kernel.util.OrderByComparator<Languages>
				orderByComparator)
		throws NoSuchLanguagesException;

	/**
	 * Returns the first languages in the ordered set where channelId = &#63; and local = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param local the local
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching languages, or <code>null</code> if a matching languages could not be found
	 */
	public Languages fetchByLocal_First(
		long channelId, String local,
		com.liferay.portal.kernel.util.OrderByComparator<Languages>
			orderByComparator);

	/**
	 * Returns the last languages in the ordered set where channelId = &#63; and local = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param local the local
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching languages
	 * @throws NoSuchLanguagesException if a matching languages could not be found
	 */
	public Languages findByLocal_Last(
			long channelId, String local,
			com.liferay.portal.kernel.util.OrderByComparator<Languages>
				orderByComparator)
		throws NoSuchLanguagesException;

	/**
	 * Returns the last languages in the ordered set where channelId = &#63; and local = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param local the local
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching languages, or <code>null</code> if a matching languages could not be found
	 */
	public Languages fetchByLocal_Last(
		long channelId, String local,
		com.liferay.portal.kernel.util.OrderByComparator<Languages>
			orderByComparator);

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
	public Languages[] findByLocal_PrevAndNext(
			long languageId, long channelId, String local,
			com.liferay.portal.kernel.util.OrderByComparator<Languages>
				orderByComparator)
		throws NoSuchLanguagesException;

	/**
	 * Removes all the languageses where channelId = &#63; and local = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param local the local
	 */
	public void removeByLocal(long channelId, String local);

	/**
	 * Returns the number of languageses where channelId = &#63; and local = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param local the local
	 * @return the number of matching languageses
	 */
	public int countByLocal(long channelId, String local);

	/**
	 * Returns all the languageses where channelId = &#63; and langName = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param langName the lang name
	 * @return the matching languageses
	 */
	public java.util.List<Languages> findByLangName(
		long channelId, String langName);

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
	public java.util.List<Languages> findByLangName(
		long channelId, String langName, int start, int end);

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
	public java.util.List<Languages> findByLangName(
		long channelId, String langName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Languages>
			orderByComparator);

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
	public java.util.List<Languages> findByLangName(
		long channelId, String langName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Languages>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first languages in the ordered set where channelId = &#63; and langName = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param langName the lang name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching languages
	 * @throws NoSuchLanguagesException if a matching languages could not be found
	 */
	public Languages findByLangName_First(
			long channelId, String langName,
			com.liferay.portal.kernel.util.OrderByComparator<Languages>
				orderByComparator)
		throws NoSuchLanguagesException;

	/**
	 * Returns the first languages in the ordered set where channelId = &#63; and langName = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param langName the lang name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching languages, or <code>null</code> if a matching languages could not be found
	 */
	public Languages fetchByLangName_First(
		long channelId, String langName,
		com.liferay.portal.kernel.util.OrderByComparator<Languages>
			orderByComparator);

	/**
	 * Returns the last languages in the ordered set where channelId = &#63; and langName = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param langName the lang name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching languages
	 * @throws NoSuchLanguagesException if a matching languages could not be found
	 */
	public Languages findByLangName_Last(
			long channelId, String langName,
			com.liferay.portal.kernel.util.OrderByComparator<Languages>
				orderByComparator)
		throws NoSuchLanguagesException;

	/**
	 * Returns the last languages in the ordered set where channelId = &#63; and langName = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param langName the lang name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching languages, or <code>null</code> if a matching languages could not be found
	 */
	public Languages fetchByLangName_Last(
		long channelId, String langName,
		com.liferay.portal.kernel.util.OrderByComparator<Languages>
			orderByComparator);

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
	public Languages[] findByLangName_PrevAndNext(
			long languageId, long channelId, String langName,
			com.liferay.portal.kernel.util.OrderByComparator<Languages>
				orderByComparator)
		throws NoSuchLanguagesException;

	/**
	 * Removes all the languageses where channelId = &#63; and langName = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param langName the lang name
	 */
	public void removeByLangName(long channelId, String langName);

	/**
	 * Returns the number of languageses where channelId = &#63; and langName = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param langName the lang name
	 * @return the number of matching languageses
	 */
	public int countByLangName(long channelId, String langName);

	/**
	 * Returns all the languageses where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the matching languageses
	 */
	public java.util.List<Languages> findByChannelId(long channelId);

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
	public java.util.List<Languages> findByChannelId(
		long channelId, int start, int end);

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
	public java.util.List<Languages> findByChannelId(
		long channelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Languages>
			orderByComparator);

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
	public java.util.List<Languages> findByChannelId(
		long channelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Languages>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first languages in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching languages
	 * @throws NoSuchLanguagesException if a matching languages could not be found
	 */
	public Languages findByChannelId_First(
			long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<Languages>
				orderByComparator)
		throws NoSuchLanguagesException;

	/**
	 * Returns the first languages in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching languages, or <code>null</code> if a matching languages could not be found
	 */
	public Languages fetchByChannelId_First(
		long channelId,
		com.liferay.portal.kernel.util.OrderByComparator<Languages>
			orderByComparator);

	/**
	 * Returns the last languages in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching languages
	 * @throws NoSuchLanguagesException if a matching languages could not be found
	 */
	public Languages findByChannelId_Last(
			long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<Languages>
				orderByComparator)
		throws NoSuchLanguagesException;

	/**
	 * Returns the last languages in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching languages, or <code>null</code> if a matching languages could not be found
	 */
	public Languages fetchByChannelId_Last(
		long channelId,
		com.liferay.portal.kernel.util.OrderByComparator<Languages>
			orderByComparator);

	/**
	 * Returns the languageses before and after the current languages in the ordered set where channelId = &#63;.
	 *
	 * @param languageId the primary key of the current languages
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next languages
	 * @throws NoSuchLanguagesException if a languages with the primary key could not be found
	 */
	public Languages[] findByChannelId_PrevAndNext(
			long languageId, long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<Languages>
				orderByComparator)
		throws NoSuchLanguagesException;

	/**
	 * Removes all the languageses where channelId = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 */
	public void removeByChannelId(long channelId);

	/**
	 * Returns the number of languageses where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the number of matching languageses
	 */
	public int countByChannelId(long channelId);

	/**
	 * Returns all the languageses where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching languageses
	 */
	public java.util.List<Languages> findByStatus(int status);

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
	public java.util.List<Languages> findByStatus(
		int status, int start, int end);

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
	public java.util.List<Languages> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Languages>
			orderByComparator);

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
	public java.util.List<Languages> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Languages>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first languages in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching languages
	 * @throws NoSuchLanguagesException if a matching languages could not be found
	 */
	public Languages findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<Languages>
				orderByComparator)
		throws NoSuchLanguagesException;

	/**
	 * Returns the first languages in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching languages, or <code>null</code> if a matching languages could not be found
	 */
	public Languages fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Languages>
			orderByComparator);

	/**
	 * Returns the last languages in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching languages
	 * @throws NoSuchLanguagesException if a matching languages could not be found
	 */
	public Languages findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<Languages>
				orderByComparator)
		throws NoSuchLanguagesException;

	/**
	 * Returns the last languages in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching languages, or <code>null</code> if a matching languages could not be found
	 */
	public Languages fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Languages>
			orderByComparator);

	/**
	 * Returns the languageses before and after the current languages in the ordered set where status = &#63;.
	 *
	 * @param languageId the primary key of the current languages
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next languages
	 * @throws NoSuchLanguagesException if a languages with the primary key could not be found
	 */
	public Languages[] findByStatus_PrevAndNext(
			long languageId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Languages>
				orderByComparator)
		throws NoSuchLanguagesException;

	/**
	 * Removes all the languageses where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of languageses where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching languageses
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the languageses where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the matching languageses
	 */
	public java.util.List<Languages> findByentityResourceId(
		long entityResourceId);

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
	public java.util.List<Languages> findByentityResourceId(
		long entityResourceId, int start, int end);

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
	public java.util.List<Languages> findByentityResourceId(
		long entityResourceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Languages>
			orderByComparator);

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
	public java.util.List<Languages> findByentityResourceId(
		long entityResourceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Languages>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first languages in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching languages
	 * @throws NoSuchLanguagesException if a matching languages could not be found
	 */
	public Languages findByentityResourceId_First(
			long entityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<Languages>
				orderByComparator)
		throws NoSuchLanguagesException;

	/**
	 * Returns the first languages in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching languages, or <code>null</code> if a matching languages could not be found
	 */
	public Languages fetchByentityResourceId_First(
		long entityResourceId,
		com.liferay.portal.kernel.util.OrderByComparator<Languages>
			orderByComparator);

	/**
	 * Returns the last languages in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching languages
	 * @throws NoSuchLanguagesException if a matching languages could not be found
	 */
	public Languages findByentityResourceId_Last(
			long entityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<Languages>
				orderByComparator)
		throws NoSuchLanguagesException;

	/**
	 * Returns the last languages in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching languages, or <code>null</code> if a matching languages could not be found
	 */
	public Languages fetchByentityResourceId_Last(
		long entityResourceId,
		com.liferay.portal.kernel.util.OrderByComparator<Languages>
			orderByComparator);

	/**
	 * Returns the languageses before and after the current languages in the ordered set where entityResourceId = &#63;.
	 *
	 * @param languageId the primary key of the current languages
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next languages
	 * @throws NoSuchLanguagesException if a languages with the primary key could not be found
	 */
	public Languages[] findByentityResourceId_PrevAndNext(
			long languageId, long entityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<Languages>
				orderByComparator)
		throws NoSuchLanguagesException;

	/**
	 * Removes all the languageses where entityResourceId = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 */
	public void removeByentityResourceId(long entityResourceId);

	/**
	 * Returns the number of languageses where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the number of matching languageses
	 */
	public int countByentityResourceId(long entityResourceId);

	/**
	 * Caches the languages in the entity cache if it is enabled.
	 *
	 * @param languages the languages
	 */
	public void cacheResult(Languages languages);

	/**
	 * Caches the languageses in the entity cache if it is enabled.
	 *
	 * @param languageses the languageses
	 */
	public void cacheResult(java.util.List<Languages> languageses);

	/**
	 * Creates a new languages with the primary key. Does not add the languages to the database.
	 *
	 * @param languageId the primary key for the new languages
	 * @return the new languages
	 */
	public Languages create(long languageId);

	/**
	 * Removes the languages with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param languageId the primary key of the languages
	 * @return the languages that was removed
	 * @throws NoSuchLanguagesException if a languages with the primary key could not be found
	 */
	public Languages remove(long languageId) throws NoSuchLanguagesException;

	public Languages updateImpl(Languages languages);

	/**
	 * Returns the languages with the primary key or throws a <code>NoSuchLanguagesException</code> if it could not be found.
	 *
	 * @param languageId the primary key of the languages
	 * @return the languages
	 * @throws NoSuchLanguagesException if a languages with the primary key could not be found
	 */
	public Languages findByPrimaryKey(long languageId)
		throws NoSuchLanguagesException;

	/**
	 * Returns the languages with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param languageId the primary key of the languages
	 * @return the languages, or <code>null</code> if a languages with the primary key could not be found
	 */
	public Languages fetchByPrimaryKey(long languageId);

	/**
	 * Returns all the languageses.
	 *
	 * @return the languageses
	 */
	public java.util.List<Languages> findAll();

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
	public java.util.List<Languages> findAll(int start, int end);

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
	public java.util.List<Languages> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Languages>
			orderByComparator);

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
	public java.util.List<Languages> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Languages>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the languageses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of languageses.
	 *
	 * @return the number of languageses
	 */
	public int countAll();

}