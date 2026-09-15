/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.model.Blocks;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the blocks service. This utility wraps <code>com.ejada.telemony.db.service.persistence.impl.BlocksPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BlocksPersistence
 * @generated
 */
public class BlocksUtil {

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
	public static void clearCache(Blocks blocks) {
		getPersistence().clearCache(blocks);
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
	public static Map<Serializable, Blocks> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Blocks> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Blocks> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Blocks> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Blocks> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Blocks update(Blocks blocks) {
		return getPersistence().update(blocks);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Blocks update(Blocks blocks, ServiceContext serviceContext) {
		return getPersistence().update(blocks, serviceContext);
	}

	/**
	 * Returns all the blockses where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the matching blockses
	 */
	public static List<Blocks> findByChannelId(long channelId) {
		return getPersistence().findByChannelId(channelId);
	}

	/**
	 * Returns a range of all the blockses where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlocksModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of blockses
	 * @param end the upper bound of the range of blockses (not inclusive)
	 * @return the range of matching blockses
	 */
	public static List<Blocks> findByChannelId(
		long channelId, int start, int end) {

		return getPersistence().findByChannelId(channelId, start, end);
	}

	/**
	 * Returns an ordered range of all the blockses where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlocksModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of blockses
	 * @param end the upper bound of the range of blockses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching blockses
	 */
	public static List<Blocks> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<Blocks> orderByComparator) {

		return getPersistence().findByChannelId(
			channelId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the blockses where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlocksModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of blockses
	 * @param end the upper bound of the range of blockses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching blockses
	 */
	public static List<Blocks> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<Blocks> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByChannelId(
			channelId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first blocks in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blocks
	 * @throws NoSuchBlocksException if a matching blocks could not be found
	 */
	public static Blocks findByChannelId_First(
			long channelId, OrderByComparator<Blocks> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchBlocksException {

		return getPersistence().findByChannelId_First(
			channelId, orderByComparator);
	}

	/**
	 * Returns the first blocks in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blocks, or <code>null</code> if a matching blocks could not be found
	 */
	public static Blocks fetchByChannelId_First(
		long channelId, OrderByComparator<Blocks> orderByComparator) {

		return getPersistence().fetchByChannelId_First(
			channelId, orderByComparator);
	}

	/**
	 * Returns the last blocks in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blocks
	 * @throws NoSuchBlocksException if a matching blocks could not be found
	 */
	public static Blocks findByChannelId_Last(
			long channelId, OrderByComparator<Blocks> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchBlocksException {

		return getPersistence().findByChannelId_Last(
			channelId, orderByComparator);
	}

	/**
	 * Returns the last blocks in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blocks, or <code>null</code> if a matching blocks could not be found
	 */
	public static Blocks fetchByChannelId_Last(
		long channelId, OrderByComparator<Blocks> orderByComparator) {

		return getPersistence().fetchByChannelId_Last(
			channelId, orderByComparator);
	}

	/**
	 * Returns the blockses before and after the current blocks in the ordered set where channelId = &#63;.
	 *
	 * @param blockId the primary key of the current blocks
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next blocks
	 * @throws NoSuchBlocksException if a blocks with the primary key could not be found
	 */
	public static Blocks[] findByChannelId_PrevAndNext(
			long blockId, long channelId,
			OrderByComparator<Blocks> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchBlocksException {

		return getPersistence().findByChannelId_PrevAndNext(
			blockId, channelId, orderByComparator);
	}

	/**
	 * Removes all the blockses where channelId = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 */
	public static void removeByChannelId(long channelId) {
		getPersistence().removeByChannelId(channelId);
	}

	/**
	 * Returns the number of blockses where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the number of matching blockses
	 */
	public static int countByChannelId(long channelId) {
		return getPersistence().countByChannelId(channelId);
	}

	/**
	 * Caches the blocks in the entity cache if it is enabled.
	 *
	 * @param blocks the blocks
	 */
	public static void cacheResult(Blocks blocks) {
		getPersistence().cacheResult(blocks);
	}

	/**
	 * Caches the blockses in the entity cache if it is enabled.
	 *
	 * @param blockses the blockses
	 */
	public static void cacheResult(List<Blocks> blockses) {
		getPersistence().cacheResult(blockses);
	}

	/**
	 * Creates a new blocks with the primary key. Does not add the blocks to the database.
	 *
	 * @param blockId the primary key for the new blocks
	 * @return the new blocks
	 */
	public static Blocks create(long blockId) {
		return getPersistence().create(blockId);
	}

	/**
	 * Removes the blocks with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param blockId the primary key of the blocks
	 * @return the blocks that was removed
	 * @throws NoSuchBlocksException if a blocks with the primary key could not be found
	 */
	public static Blocks remove(long blockId)
		throws com.ejada.telemony.db.exception.NoSuchBlocksException {

		return getPersistence().remove(blockId);
	}

	public static Blocks updateImpl(Blocks blocks) {
		return getPersistence().updateImpl(blocks);
	}

	/**
	 * Returns the blocks with the primary key or throws a <code>NoSuchBlocksException</code> if it could not be found.
	 *
	 * @param blockId the primary key of the blocks
	 * @return the blocks
	 * @throws NoSuchBlocksException if a blocks with the primary key could not be found
	 */
	public static Blocks findByPrimaryKey(long blockId)
		throws com.ejada.telemony.db.exception.NoSuchBlocksException {

		return getPersistence().findByPrimaryKey(blockId);
	}

	/**
	 * Returns the blocks with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param blockId the primary key of the blocks
	 * @return the blocks, or <code>null</code> if a blocks with the primary key could not be found
	 */
	public static Blocks fetchByPrimaryKey(long blockId) {
		return getPersistence().fetchByPrimaryKey(blockId);
	}

	/**
	 * Returns all the blockses.
	 *
	 * @return the blockses
	 */
	public static List<Blocks> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the blockses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlocksModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of blockses
	 * @param end the upper bound of the range of blockses (not inclusive)
	 * @return the range of blockses
	 */
	public static List<Blocks> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the blockses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlocksModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of blockses
	 * @param end the upper bound of the range of blockses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of blockses
	 */
	public static List<Blocks> findAll(
		int start, int end, OrderByComparator<Blocks> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the blockses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlocksModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of blockses
	 * @param end the upper bound of the range of blockses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of blockses
	 */
	public static List<Blocks> findAll(
		int start, int end, OrderByComparator<Blocks> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the blockses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of blockses.
	 *
	 * @return the number of blockses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BlocksPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(BlocksPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile BlocksPersistence _persistence;

}