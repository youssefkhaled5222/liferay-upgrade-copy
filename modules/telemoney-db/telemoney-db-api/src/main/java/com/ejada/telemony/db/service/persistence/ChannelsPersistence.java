/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.exception.NoSuchChannelsException;
import com.ejada.telemony.db.model.Channels;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the channels service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChannelsUtil
 * @generated
 */
@ProviderType
public interface ChannelsPersistence extends BasePersistence<Channels> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ChannelsUtil} to access the channels persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the channelses where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching channelses
	 */
	public java.util.List<Channels> findByName(String name);

	/**
	 * Returns a range of all the channelses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChannelsModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of channelses
	 * @param end the upper bound of the range of channelses (not inclusive)
	 * @return the range of matching channelses
	 */
	public java.util.List<Channels> findByName(String name, int start, int end);

	/**
	 * Returns an ordered range of all the channelses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChannelsModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of channelses
	 * @param end the upper bound of the range of channelses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching channelses
	 */
	public java.util.List<Channels> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Channels>
			orderByComparator);

	/**
	 * Returns an ordered range of all the channelses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChannelsModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of channelses
	 * @param end the upper bound of the range of channelses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching channelses
	 */
	public java.util.List<Channels> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Channels>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first channels in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channels
	 * @throws NoSuchChannelsException if a matching channels could not be found
	 */
	public Channels findByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<Channels>
				orderByComparator)
		throws NoSuchChannelsException;

	/**
	 * Returns the first channels in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channels, or <code>null</code> if a matching channels could not be found
	 */
	public Channels fetchByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<Channels>
			orderByComparator);

	/**
	 * Returns the last channels in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channels
	 * @throws NoSuchChannelsException if a matching channels could not be found
	 */
	public Channels findByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<Channels>
				orderByComparator)
		throws NoSuchChannelsException;

	/**
	 * Returns the last channels in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channels, or <code>null</code> if a matching channels could not be found
	 */
	public Channels fetchByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<Channels>
			orderByComparator);

	/**
	 * Returns the channelses before and after the current channels in the ordered set where name = &#63;.
	 *
	 * @param channelId the primary key of the current channels
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next channels
	 * @throws NoSuchChannelsException if a channels with the primary key could not be found
	 */
	public Channels[] findByName_PrevAndNext(
			long channelId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<Channels>
				orderByComparator)
		throws NoSuchChannelsException;

	/**
	 * Removes all the channelses where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByName(String name);

	/**
	 * Returns the number of channelses where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching channelses
	 */
	public int countByName(String name);

	/**
	 * Returns all the channelses where name = &#63; and status &ne; &#63;.
	 *
	 * @param name the name
	 * @param status the status
	 * @return the matching channelses
	 */
	public java.util.List<Channels> findByNameAndStatus(
		String name, int status);

	/**
	 * Returns a range of all the channelses where name = &#63; and status &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChannelsModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param status the status
	 * @param start the lower bound of the range of channelses
	 * @param end the upper bound of the range of channelses (not inclusive)
	 * @return the range of matching channelses
	 */
	public java.util.List<Channels> findByNameAndStatus(
		String name, int status, int start, int end);

	/**
	 * Returns an ordered range of all the channelses where name = &#63; and status &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChannelsModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param status the status
	 * @param start the lower bound of the range of channelses
	 * @param end the upper bound of the range of channelses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching channelses
	 */
	public java.util.List<Channels> findByNameAndStatus(
		String name, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Channels>
			orderByComparator);

	/**
	 * Returns an ordered range of all the channelses where name = &#63; and status &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChannelsModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param status the status
	 * @param start the lower bound of the range of channelses
	 * @param end the upper bound of the range of channelses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching channelses
	 */
	public java.util.List<Channels> findByNameAndStatus(
		String name, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Channels>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first channels in the ordered set where name = &#63; and status &ne; &#63;.
	 *
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channels
	 * @throws NoSuchChannelsException if a matching channels could not be found
	 */
	public Channels findByNameAndStatus_First(
			String name, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Channels>
				orderByComparator)
		throws NoSuchChannelsException;

	/**
	 * Returns the first channels in the ordered set where name = &#63; and status &ne; &#63;.
	 *
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channels, or <code>null</code> if a matching channels could not be found
	 */
	public Channels fetchByNameAndStatus_First(
		String name, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Channels>
			orderByComparator);

	/**
	 * Returns the last channels in the ordered set where name = &#63; and status &ne; &#63;.
	 *
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channels
	 * @throws NoSuchChannelsException if a matching channels could not be found
	 */
	public Channels findByNameAndStatus_Last(
			String name, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Channels>
				orderByComparator)
		throws NoSuchChannelsException;

	/**
	 * Returns the last channels in the ordered set where name = &#63; and status &ne; &#63;.
	 *
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channels, or <code>null</code> if a matching channels could not be found
	 */
	public Channels fetchByNameAndStatus_Last(
		String name, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Channels>
			orderByComparator);

	/**
	 * Returns the channelses before and after the current channels in the ordered set where name = &#63; and status &ne; &#63;.
	 *
	 * @param channelId the primary key of the current channels
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next channels
	 * @throws NoSuchChannelsException if a channels with the primary key could not be found
	 */
	public Channels[] findByNameAndStatus_PrevAndNext(
			long channelId, String name, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Channels>
				orderByComparator)
		throws NoSuchChannelsException;

	/**
	 * Removes all the channelses where name = &#63; and status &ne; &#63; from the database.
	 *
	 * @param name the name
	 * @param status the status
	 */
	public void removeByNameAndStatus(String name, int status);

	/**
	 * Returns the number of channelses where name = &#63; and status &ne; &#63;.
	 *
	 * @param name the name
	 * @param status the status
	 * @return the number of matching channelses
	 */
	public int countByNameAndStatus(String name, int status);

	/**
	 * Returns all the channelses where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching channelses
	 */
	public java.util.List<Channels> findByStatus(int status);

	/**
	 * Returns a range of all the channelses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChannelsModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of channelses
	 * @param end the upper bound of the range of channelses (not inclusive)
	 * @return the range of matching channelses
	 */
	public java.util.List<Channels> findByStatus(
		int status, int start, int end);

	/**
	 * Returns an ordered range of all the channelses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChannelsModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of channelses
	 * @param end the upper bound of the range of channelses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching channelses
	 */
	public java.util.List<Channels> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Channels>
			orderByComparator);

	/**
	 * Returns an ordered range of all the channelses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChannelsModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of channelses
	 * @param end the upper bound of the range of channelses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching channelses
	 */
	public java.util.List<Channels> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Channels>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first channels in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channels
	 * @throws NoSuchChannelsException if a matching channels could not be found
	 */
	public Channels findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<Channels>
				orderByComparator)
		throws NoSuchChannelsException;

	/**
	 * Returns the first channels in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channels, or <code>null</code> if a matching channels could not be found
	 */
	public Channels fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Channels>
			orderByComparator);

	/**
	 * Returns the last channels in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channels
	 * @throws NoSuchChannelsException if a matching channels could not be found
	 */
	public Channels findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<Channels>
				orderByComparator)
		throws NoSuchChannelsException;

	/**
	 * Returns the last channels in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channels, or <code>null</code> if a matching channels could not be found
	 */
	public Channels fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Channels>
			orderByComparator);

	/**
	 * Returns the channelses before and after the current channels in the ordered set where status = &#63;.
	 *
	 * @param channelId the primary key of the current channels
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next channels
	 * @throws NoSuchChannelsException if a channels with the primary key could not be found
	 */
	public Channels[] findByStatus_PrevAndNext(
			long channelId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Channels>
				orderByComparator)
		throws NoSuchChannelsException;

	/**
	 * Removes all the channelses where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of channelses where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching channelses
	 */
	public int countByStatus(int status);

	/**
	 * Caches the channels in the entity cache if it is enabled.
	 *
	 * @param channels the channels
	 */
	public void cacheResult(Channels channels);

	/**
	 * Caches the channelses in the entity cache if it is enabled.
	 *
	 * @param channelses the channelses
	 */
	public void cacheResult(java.util.List<Channels> channelses);

	/**
	 * Creates a new channels with the primary key. Does not add the channels to the database.
	 *
	 * @param channelId the primary key for the new channels
	 * @return the new channels
	 */
	public Channels create(long channelId);

	/**
	 * Removes the channels with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param channelId the primary key of the channels
	 * @return the channels that was removed
	 * @throws NoSuchChannelsException if a channels with the primary key could not be found
	 */
	public Channels remove(long channelId) throws NoSuchChannelsException;

	public Channels updateImpl(Channels channels);

	/**
	 * Returns the channels with the primary key or throws a <code>NoSuchChannelsException</code> if it could not be found.
	 *
	 * @param channelId the primary key of the channels
	 * @return the channels
	 * @throws NoSuchChannelsException if a channels with the primary key could not be found
	 */
	public Channels findByPrimaryKey(long channelId)
		throws NoSuchChannelsException;

	/**
	 * Returns the channels with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param channelId the primary key of the channels
	 * @return the channels, or <code>null</code> if a channels with the primary key could not be found
	 */
	public Channels fetchByPrimaryKey(long channelId);

	/**
	 * Returns all the channelses.
	 *
	 * @return the channelses
	 */
	public java.util.List<Channels> findAll();

	/**
	 * Returns a range of all the channelses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChannelsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of channelses
	 * @param end the upper bound of the range of channelses (not inclusive)
	 * @return the range of channelses
	 */
	public java.util.List<Channels> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the channelses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChannelsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of channelses
	 * @param end the upper bound of the range of channelses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of channelses
	 */
	public java.util.List<Channels> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Channels>
			orderByComparator);

	/**
	 * Returns an ordered range of all the channelses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChannelsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of channelses
	 * @param end the upper bound of the range of channelses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of channelses
	 */
	public java.util.List<Channels> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Channels>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the channelses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of channelses.
	 *
	 * @return the number of channelses
	 */
	public int countAll();

}