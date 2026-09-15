/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.exception.NoSuchLovsException;
import com.ejada.telemony.db.model.Lovs;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the lovs service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LovsUtil
 * @generated
 */
@ProviderType
public interface LovsPersistence extends BasePersistence<Lovs> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LovsUtil} to access the lovs persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the lovses where channelId = &#63; and code = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param status the status
	 * @return the matching lovses
	 */
	public java.util.List<Lovs> findBytypeCodeAndStatus(
		long channelId, String code, int status);

	/**
	 * Returns a range of all the lovses where channelId = &#63; and code = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param status the status
	 * @param start the lower bound of the range of lovses
	 * @param end the upper bound of the range of lovses (not inclusive)
	 * @return the range of matching lovses
	 */
	public java.util.List<Lovs> findBytypeCodeAndStatus(
		long channelId, String code, int status, int start, int end);

	/**
	 * Returns an ordered range of all the lovses where channelId = &#63; and code = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param status the status
	 * @param start the lower bound of the range of lovses
	 * @param end the upper bound of the range of lovses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lovses
	 */
	public java.util.List<Lovs> findBytypeCodeAndStatus(
		long channelId, String code, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lovs>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lovses where channelId = &#63; and code = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param status the status
	 * @param start the lower bound of the range of lovses
	 * @param end the upper bound of the range of lovses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lovses
	 */
	public java.util.List<Lovs> findBytypeCodeAndStatus(
		long channelId, String code, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lovs>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first lovs in the ordered set where channelId = &#63; and code = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs
	 * @throws NoSuchLovsException if a matching lovs could not be found
	 */
	public Lovs findBytypeCodeAndStatus_First(
			long channelId, String code, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Lovs>
				orderByComparator)
		throws NoSuchLovsException;

	/**
	 * Returns the first lovs in the ordered set where channelId = &#63; and code = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs, or <code>null</code> if a matching lovs could not be found
	 */
	public Lovs fetchBytypeCodeAndStatus_First(
		long channelId, String code, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Lovs>
			orderByComparator);

	/**
	 * Returns the last lovs in the ordered set where channelId = &#63; and code = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs
	 * @throws NoSuchLovsException if a matching lovs could not be found
	 */
	public Lovs findBytypeCodeAndStatus_Last(
			long channelId, String code, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Lovs>
				orderByComparator)
		throws NoSuchLovsException;

	/**
	 * Returns the last lovs in the ordered set where channelId = &#63; and code = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs, or <code>null</code> if a matching lovs could not be found
	 */
	public Lovs fetchBytypeCodeAndStatus_Last(
		long channelId, String code, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Lovs>
			orderByComparator);

	/**
	 * Returns the lovses before and after the current lovs in the ordered set where channelId = &#63; and code = &#63; and status = &#63;.
	 *
	 * @param id the primary key of the current lovs
	 * @param channelId the channel ID
	 * @param code the code
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lovs
	 * @throws NoSuchLovsException if a lovs with the primary key could not be found
	 */
	public Lovs[] findBytypeCodeAndStatus_PrevAndNext(
			long id, long channelId, String code, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Lovs>
				orderByComparator)
		throws NoSuchLovsException;

	/**
	 * Removes all the lovses where channelId = &#63; and code = &#63; and status = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param status the status
	 */
	public void removeBytypeCodeAndStatus(
		long channelId, String code, int status);

	/**
	 * Returns the number of lovses where channelId = &#63; and code = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param status the status
	 * @return the number of matching lovses
	 */
	public int countBytypeCodeAndStatus(
		long channelId, String code, int status);

	/**
	 * Returns all the lovses where channelId = &#63; and code = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @return the matching lovses
	 */
	public java.util.List<Lovs> findBytypeCode(long channelId, String code);

	/**
	 * Returns a range of all the lovses where channelId = &#63; and code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param start the lower bound of the range of lovses
	 * @param end the upper bound of the range of lovses (not inclusive)
	 * @return the range of matching lovses
	 */
	public java.util.List<Lovs> findBytypeCode(
		long channelId, String code, int start, int end);

	/**
	 * Returns an ordered range of all the lovses where channelId = &#63; and code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param start the lower bound of the range of lovses
	 * @param end the upper bound of the range of lovses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lovses
	 */
	public java.util.List<Lovs> findBytypeCode(
		long channelId, String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lovs>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lovses where channelId = &#63; and code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param start the lower bound of the range of lovses
	 * @param end the upper bound of the range of lovses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lovses
	 */
	public java.util.List<Lovs> findBytypeCode(
		long channelId, String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lovs>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first lovs in the ordered set where channelId = &#63; and code = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs
	 * @throws NoSuchLovsException if a matching lovs could not be found
	 */
	public Lovs findBytypeCode_First(
			long channelId, String code,
			com.liferay.portal.kernel.util.OrderByComparator<Lovs>
				orderByComparator)
		throws NoSuchLovsException;

	/**
	 * Returns the first lovs in the ordered set where channelId = &#63; and code = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs, or <code>null</code> if a matching lovs could not be found
	 */
	public Lovs fetchBytypeCode_First(
		long channelId, String code,
		com.liferay.portal.kernel.util.OrderByComparator<Lovs>
			orderByComparator);

	/**
	 * Returns the last lovs in the ordered set where channelId = &#63; and code = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs
	 * @throws NoSuchLovsException if a matching lovs could not be found
	 */
	public Lovs findBytypeCode_Last(
			long channelId, String code,
			com.liferay.portal.kernel.util.OrderByComparator<Lovs>
				orderByComparator)
		throws NoSuchLovsException;

	/**
	 * Returns the last lovs in the ordered set where channelId = &#63; and code = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs, or <code>null</code> if a matching lovs could not be found
	 */
	public Lovs fetchBytypeCode_Last(
		long channelId, String code,
		com.liferay.portal.kernel.util.OrderByComparator<Lovs>
			orderByComparator);

	/**
	 * Returns the lovses before and after the current lovs in the ordered set where channelId = &#63; and code = &#63;.
	 *
	 * @param id the primary key of the current lovs
	 * @param channelId the channel ID
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lovs
	 * @throws NoSuchLovsException if a lovs with the primary key could not be found
	 */
	public Lovs[] findBytypeCode_PrevAndNext(
			long id, long channelId, String code,
			com.liferay.portal.kernel.util.OrderByComparator<Lovs>
				orderByComparator)
		throws NoSuchLovsException;

	/**
	 * Removes all the lovses where channelId = &#63; and code = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 */
	public void removeBytypeCode(long channelId, String code);

	/**
	 * Returns the number of lovses where channelId = &#63; and code = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @return the number of matching lovses
	 */
	public int countBytypeCode(long channelId, String code);

	/**
	 * Returns all the lovses where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the matching lovses
	 */
	public java.util.List<Lovs> findByChannelId(long channelId);

	/**
	 * Returns a range of all the lovses where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of lovses
	 * @param end the upper bound of the range of lovses (not inclusive)
	 * @return the range of matching lovses
	 */
	public java.util.List<Lovs> findByChannelId(
		long channelId, int start, int end);

	/**
	 * Returns an ordered range of all the lovses where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of lovses
	 * @param end the upper bound of the range of lovses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lovses
	 */
	public java.util.List<Lovs> findByChannelId(
		long channelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lovs>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lovses where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of lovses
	 * @param end the upper bound of the range of lovses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lovses
	 */
	public java.util.List<Lovs> findByChannelId(
		long channelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lovs>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first lovs in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs
	 * @throws NoSuchLovsException if a matching lovs could not be found
	 */
	public Lovs findByChannelId_First(
			long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<Lovs>
				orderByComparator)
		throws NoSuchLovsException;

	/**
	 * Returns the first lovs in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs, or <code>null</code> if a matching lovs could not be found
	 */
	public Lovs fetchByChannelId_First(
		long channelId,
		com.liferay.portal.kernel.util.OrderByComparator<Lovs>
			orderByComparator);

	/**
	 * Returns the last lovs in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs
	 * @throws NoSuchLovsException if a matching lovs could not be found
	 */
	public Lovs findByChannelId_Last(
			long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<Lovs>
				orderByComparator)
		throws NoSuchLovsException;

	/**
	 * Returns the last lovs in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs, or <code>null</code> if a matching lovs could not be found
	 */
	public Lovs fetchByChannelId_Last(
		long channelId,
		com.liferay.portal.kernel.util.OrderByComparator<Lovs>
			orderByComparator);

	/**
	 * Returns the lovses before and after the current lovs in the ordered set where channelId = &#63;.
	 *
	 * @param id the primary key of the current lovs
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lovs
	 * @throws NoSuchLovsException if a lovs with the primary key could not be found
	 */
	public Lovs[] findByChannelId_PrevAndNext(
			long id, long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<Lovs>
				orderByComparator)
		throws NoSuchLovsException;

	/**
	 * Removes all the lovses where channelId = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 */
	public void removeByChannelId(long channelId);

	/**
	 * Returns the number of lovses where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the number of matching lovses
	 */
	public int countByChannelId(long channelId);

	/**
	 * Returns all the lovses where id = &#63; and channelId = &#63;.
	 *
	 * @param id the ID
	 * @param channelId the channel ID
	 * @return the matching lovses
	 */
	public java.util.List<Lovs> findByidAndChannel(long id, long channelId);

	/**
	 * Returns a range of all the lovses where id = &#63; and channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of lovses
	 * @param end the upper bound of the range of lovses (not inclusive)
	 * @return the range of matching lovses
	 */
	public java.util.List<Lovs> findByidAndChannel(
		long id, long channelId, int start, int end);

	/**
	 * Returns an ordered range of all the lovses where id = &#63; and channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of lovses
	 * @param end the upper bound of the range of lovses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lovses
	 */
	public java.util.List<Lovs> findByidAndChannel(
		long id, long channelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lovs>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lovses where id = &#63; and channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of lovses
	 * @param end the upper bound of the range of lovses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lovses
	 */
	public java.util.List<Lovs> findByidAndChannel(
		long id, long channelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lovs>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first lovs in the ordered set where id = &#63; and channelId = &#63;.
	 *
	 * @param id the ID
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs
	 * @throws NoSuchLovsException if a matching lovs could not be found
	 */
	public Lovs findByidAndChannel_First(
			long id, long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<Lovs>
				orderByComparator)
		throws NoSuchLovsException;

	/**
	 * Returns the first lovs in the ordered set where id = &#63; and channelId = &#63;.
	 *
	 * @param id the ID
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs, or <code>null</code> if a matching lovs could not be found
	 */
	public Lovs fetchByidAndChannel_First(
		long id, long channelId,
		com.liferay.portal.kernel.util.OrderByComparator<Lovs>
			orderByComparator);

	/**
	 * Returns the last lovs in the ordered set where id = &#63; and channelId = &#63;.
	 *
	 * @param id the ID
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs
	 * @throws NoSuchLovsException if a matching lovs could not be found
	 */
	public Lovs findByidAndChannel_Last(
			long id, long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<Lovs>
				orderByComparator)
		throws NoSuchLovsException;

	/**
	 * Returns the last lovs in the ordered set where id = &#63; and channelId = &#63;.
	 *
	 * @param id the ID
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs, or <code>null</code> if a matching lovs could not be found
	 */
	public Lovs fetchByidAndChannel_Last(
		long id, long channelId,
		com.liferay.portal.kernel.util.OrderByComparator<Lovs>
			orderByComparator);

	/**
	 * Removes all the lovses where id = &#63; and channelId = &#63; from the database.
	 *
	 * @param id the ID
	 * @param channelId the channel ID
	 */
	public void removeByidAndChannel(long id, long channelId);

	/**
	 * Returns the number of lovses where id = &#63; and channelId = &#63;.
	 *
	 * @param id the ID
	 * @param channelId the channel ID
	 * @return the number of matching lovses
	 */
	public int countByidAndChannel(long id, long channelId);

	/**
	 * Returns all the lovses where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the matching lovses
	 */
	public java.util.List<Lovs> findByEntityResourceId(long entityResourceId);

	/**
	 * Returns a range of all the lovses where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of lovses
	 * @param end the upper bound of the range of lovses (not inclusive)
	 * @return the range of matching lovses
	 */
	public java.util.List<Lovs> findByEntityResourceId(
		long entityResourceId, int start, int end);

	/**
	 * Returns an ordered range of all the lovses where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of lovses
	 * @param end the upper bound of the range of lovses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lovses
	 */
	public java.util.List<Lovs> findByEntityResourceId(
		long entityResourceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lovs>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lovses where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of lovses
	 * @param end the upper bound of the range of lovses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lovses
	 */
	public java.util.List<Lovs> findByEntityResourceId(
		long entityResourceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lovs>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first lovs in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs
	 * @throws NoSuchLovsException if a matching lovs could not be found
	 */
	public Lovs findByEntityResourceId_First(
			long entityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<Lovs>
				orderByComparator)
		throws NoSuchLovsException;

	/**
	 * Returns the first lovs in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs, or <code>null</code> if a matching lovs could not be found
	 */
	public Lovs fetchByEntityResourceId_First(
		long entityResourceId,
		com.liferay.portal.kernel.util.OrderByComparator<Lovs>
			orderByComparator);

	/**
	 * Returns the last lovs in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs
	 * @throws NoSuchLovsException if a matching lovs could not be found
	 */
	public Lovs findByEntityResourceId_Last(
			long entityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<Lovs>
				orderByComparator)
		throws NoSuchLovsException;

	/**
	 * Returns the last lovs in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs, or <code>null</code> if a matching lovs could not be found
	 */
	public Lovs fetchByEntityResourceId_Last(
		long entityResourceId,
		com.liferay.portal.kernel.util.OrderByComparator<Lovs>
			orderByComparator);

	/**
	 * Returns the lovses before and after the current lovs in the ordered set where entityResourceId = &#63;.
	 *
	 * @param id the primary key of the current lovs
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lovs
	 * @throws NoSuchLovsException if a lovs with the primary key could not be found
	 */
	public Lovs[] findByEntityResourceId_PrevAndNext(
			long id, long entityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<Lovs>
				orderByComparator)
		throws NoSuchLovsException;

	/**
	 * Removes all the lovses where entityResourceId = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 */
	public void removeByEntityResourceId(long entityResourceId);

	/**
	 * Returns the number of lovses where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the number of matching lovses
	 */
	public int countByEntityResourceId(long entityResourceId);

	/**
	 * Caches the lovs in the entity cache if it is enabled.
	 *
	 * @param lovs the lovs
	 */
	public void cacheResult(Lovs lovs);

	/**
	 * Caches the lovses in the entity cache if it is enabled.
	 *
	 * @param lovses the lovses
	 */
	public void cacheResult(java.util.List<Lovs> lovses);

	/**
	 * Creates a new lovs with the primary key. Does not add the lovs to the database.
	 *
	 * @param id the primary key for the new lovs
	 * @return the new lovs
	 */
	public Lovs create(long id);

	/**
	 * Removes the lovs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the lovs
	 * @return the lovs that was removed
	 * @throws NoSuchLovsException if a lovs with the primary key could not be found
	 */
	public Lovs remove(long id) throws NoSuchLovsException;

	public Lovs updateImpl(Lovs lovs);

	/**
	 * Returns the lovs with the primary key or throws a <code>NoSuchLovsException</code> if it could not be found.
	 *
	 * @param id the primary key of the lovs
	 * @return the lovs
	 * @throws NoSuchLovsException if a lovs with the primary key could not be found
	 */
	public Lovs findByPrimaryKey(long id) throws NoSuchLovsException;

	/**
	 * Returns the lovs with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the lovs
	 * @return the lovs, or <code>null</code> if a lovs with the primary key could not be found
	 */
	public Lovs fetchByPrimaryKey(long id);

	/**
	 * Returns all the lovses.
	 *
	 * @return the lovses
	 */
	public java.util.List<Lovs> findAll();

	/**
	 * Returns a range of all the lovses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lovses
	 * @param end the upper bound of the range of lovses (not inclusive)
	 * @return the range of lovses
	 */
	public java.util.List<Lovs> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the lovses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lovses
	 * @param end the upper bound of the range of lovses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lovses
	 */
	public java.util.List<Lovs> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lovs>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lovses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lovses
	 * @param end the upper bound of the range of lovses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of lovses
	 */
	public java.util.List<Lovs> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lovs>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the lovses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of lovses.
	 *
	 * @return the number of lovses
	 */
	public int countAll();

}