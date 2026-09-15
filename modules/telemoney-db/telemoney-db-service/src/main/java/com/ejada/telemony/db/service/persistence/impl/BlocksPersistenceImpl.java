/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence.impl;

import com.ejada.telemony.db.exception.NoSuchBlocksException;
import com.ejada.telemony.db.model.Blocks;
import com.ejada.telemony.db.model.BlocksTable;
import com.ejada.telemony.db.model.impl.BlocksImpl;
import com.ejada.telemony.db.model.impl.BlocksModelImpl;
import com.ejada.telemony.db.service.persistence.BlocksPersistence;
import com.ejada.telemony.db.service.persistence.BlocksUtil;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the blocks service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BlocksPersistenceImpl
	extends BasePersistenceImpl<Blocks> implements BlocksPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BlocksUtil</code> to access the blocks persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BlocksImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByChannelId;
	private FinderPath _finderPathWithoutPaginationFindByChannelId;
	private FinderPath _finderPathCountByChannelId;

	/**
	 * Returns all the blockses where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the matching blockses
	 */
	@Override
	public List<Blocks> findByChannelId(long channelId) {
		return findByChannelId(
			channelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Blocks> findByChannelId(long channelId, int start, int end) {
		return findByChannelId(channelId, start, end, null);
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
	@Override
	public List<Blocks> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<Blocks> orderByComparator) {

		return findByChannelId(channelId, start, end, orderByComparator, true);
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
	@Override
	public List<Blocks> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<Blocks> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByChannelId;
				finderArgs = new Object[] {channelId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByChannelId;
			finderArgs = new Object[] {
				channelId, start, end, orderByComparator
			};
		}

		List<Blocks> list = null;

		if (useFinderCache) {
			list = (List<Blocks>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Blocks blocks : list) {
					if (channelId != blocks.getChannelId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_BLOCKS_WHERE);

			sb.append(_FINDER_COLUMN_CHANNELID_CHANNELID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BlocksModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				list = (List<Blocks>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first blocks in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blocks
	 * @throws NoSuchBlocksException if a matching blocks could not be found
	 */
	@Override
	public Blocks findByChannelId_First(
			long channelId, OrderByComparator<Blocks> orderByComparator)
		throws NoSuchBlocksException {

		Blocks blocks = fetchByChannelId_First(channelId, orderByComparator);

		if (blocks != null) {
			return blocks;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append("}");

		throw new NoSuchBlocksException(sb.toString());
	}

	/**
	 * Returns the first blocks in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blocks, or <code>null</code> if a matching blocks could not be found
	 */
	@Override
	public Blocks fetchByChannelId_First(
		long channelId, OrderByComparator<Blocks> orderByComparator) {

		List<Blocks> list = findByChannelId(channelId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last blocks in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blocks
	 * @throws NoSuchBlocksException if a matching blocks could not be found
	 */
	@Override
	public Blocks findByChannelId_Last(
			long channelId, OrderByComparator<Blocks> orderByComparator)
		throws NoSuchBlocksException {

		Blocks blocks = fetchByChannelId_Last(channelId, orderByComparator);

		if (blocks != null) {
			return blocks;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append("}");

		throw new NoSuchBlocksException(sb.toString());
	}

	/**
	 * Returns the last blocks in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blocks, or <code>null</code> if a matching blocks could not be found
	 */
	@Override
	public Blocks fetchByChannelId_Last(
		long channelId, OrderByComparator<Blocks> orderByComparator) {

		int count = countByChannelId(channelId);

		if (count == 0) {
			return null;
		}

		List<Blocks> list = findByChannelId(
			channelId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Blocks[] findByChannelId_PrevAndNext(
			long blockId, long channelId,
			OrderByComparator<Blocks> orderByComparator)
		throws NoSuchBlocksException {

		Blocks blocks = findByPrimaryKey(blockId);

		Session session = null;

		try {
			session = openSession();

			Blocks[] array = new BlocksImpl[3];

			array[0] = getByChannelId_PrevAndNext(
				session, blocks, channelId, orderByComparator, true);

			array[1] = blocks;

			array[2] = getByChannelId_PrevAndNext(
				session, blocks, channelId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Blocks getByChannelId_PrevAndNext(
		Session session, Blocks blocks, long channelId,
		OrderByComparator<Blocks> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BLOCKS_WHERE);

		sb.append(_FINDER_COLUMN_CHANNELID_CHANNELID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(BlocksModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(channelId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(blocks)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Blocks> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the blockses where channelId = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 */
	@Override
	public void removeByChannelId(long channelId) {
		for (Blocks blocks :
				findByChannelId(
					channelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(blocks);
		}
	}

	/**
	 * Returns the number of blockses where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the number of matching blockses
	 */
	@Override
	public int countByChannelId(long channelId) {
		FinderPath finderPath = _finderPathCountByChannelId;

		Object[] finderArgs = new Object[] {channelId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BLOCKS_WHERE);

			sb.append(_FINDER_COLUMN_CHANNELID_CHANNELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CHANNELID_CHANNELID_2 =
		"blocks.channelId = ?";

	public BlocksPersistenceImpl() {
		setModelClass(Blocks.class);

		setModelImplClass(BlocksImpl.class);
		setModelPKClass(long.class);

		setTable(BlocksTable.INSTANCE);
	}

	/**
	 * Caches the blocks in the entity cache if it is enabled.
	 *
	 * @param blocks the blocks
	 */
	@Override
	public void cacheResult(Blocks blocks) {
		dummyEntityCache.putResult(
			BlocksImpl.class, blocks.getPrimaryKey(), blocks);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the blockses in the entity cache if it is enabled.
	 *
	 * @param blockses the blockses
	 */
	@Override
	public void cacheResult(List<Blocks> blockses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (blockses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Blocks blocks : blockses) {
			if (dummyEntityCache.getResult(
					BlocksImpl.class, blocks.getPrimaryKey()) == null) {

				cacheResult(blocks);
			}
		}
	}

	/**
	 * Clears the cache for all blockses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(BlocksImpl.class);

		dummyFinderCache.clearCache(BlocksImpl.class);
	}

	/**
	 * Clears the cache for the blocks.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Blocks blocks) {
		dummyEntityCache.removeResult(BlocksImpl.class, blocks);
	}

	@Override
	public void clearCache(List<Blocks> blockses) {
		for (Blocks blocks : blockses) {
			dummyEntityCache.removeResult(BlocksImpl.class, blocks);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(BlocksImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(BlocksImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new blocks with the primary key. Does not add the blocks to the database.
	 *
	 * @param blockId the primary key for the new blocks
	 * @return the new blocks
	 */
	@Override
	public Blocks create(long blockId) {
		Blocks blocks = new BlocksImpl();

		blocks.setNew(true);
		blocks.setPrimaryKey(blockId);

		return blocks;
	}

	/**
	 * Removes the blocks with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param blockId the primary key of the blocks
	 * @return the blocks that was removed
	 * @throws NoSuchBlocksException if a blocks with the primary key could not be found
	 */
	@Override
	public Blocks remove(long blockId) throws NoSuchBlocksException {
		return remove((Serializable)blockId);
	}

	/**
	 * Removes the blocks with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the blocks
	 * @return the blocks that was removed
	 * @throws NoSuchBlocksException if a blocks with the primary key could not be found
	 */
	@Override
	public Blocks remove(Serializable primaryKey) throws NoSuchBlocksException {
		Session session = null;

		try {
			session = openSession();

			Blocks blocks = (Blocks)session.get(BlocksImpl.class, primaryKey);

			if (blocks == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBlocksException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(blocks);
		}
		catch (NoSuchBlocksException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Blocks removeImpl(Blocks blocks) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(blocks)) {
				blocks = (Blocks)session.get(
					BlocksImpl.class, blocks.getPrimaryKeyObj());
			}

			if (blocks != null) {
				session.delete(blocks);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (blocks != null) {
			clearCache(blocks);
		}

		return blocks;
	}

	@Override
	public Blocks updateImpl(Blocks blocks) {
		boolean isNew = blocks.isNew();

		if (!(blocks instanceof BlocksModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(blocks.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(blocks);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in blocks proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Blocks implementation " +
					blocks.getClass());
		}

		BlocksModelImpl blocksModelImpl = (BlocksModelImpl)blocks;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(blocks);
			}
			else {
				blocks = (Blocks)session.merge(blocks);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			BlocksImpl.class, blocksModelImpl, false, true);

		if (isNew) {
			blocks.setNew(false);
		}

		blocks.resetOriginalValues();

		return blocks;
	}

	/**
	 * Returns the blocks with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the blocks
	 * @return the blocks
	 * @throws NoSuchBlocksException if a blocks with the primary key could not be found
	 */
	@Override
	public Blocks findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBlocksException {

		Blocks blocks = fetchByPrimaryKey(primaryKey);

		if (blocks == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBlocksException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return blocks;
	}

	/**
	 * Returns the blocks with the primary key or throws a <code>NoSuchBlocksException</code> if it could not be found.
	 *
	 * @param blockId the primary key of the blocks
	 * @return the blocks
	 * @throws NoSuchBlocksException if a blocks with the primary key could not be found
	 */
	@Override
	public Blocks findByPrimaryKey(long blockId) throws NoSuchBlocksException {
		return findByPrimaryKey((Serializable)blockId);
	}

	/**
	 * Returns the blocks with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param blockId the primary key of the blocks
	 * @return the blocks, or <code>null</code> if a blocks with the primary key could not be found
	 */
	@Override
	public Blocks fetchByPrimaryKey(long blockId) {
		return fetchByPrimaryKey((Serializable)blockId);
	}

	/**
	 * Returns all the blockses.
	 *
	 * @return the blockses
	 */
	@Override
	public List<Blocks> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Blocks> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Blocks> findAll(
		int start, int end, OrderByComparator<Blocks> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Blocks> findAll(
		int start, int end, OrderByComparator<Blocks> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Blocks> list = null;

		if (useFinderCache) {
			list = (List<Blocks>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BLOCKS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BLOCKS;

				sql = sql.concat(BlocksModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Blocks>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the blockses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Blocks blocks : findAll()) {
			remove(blocks);
		}
	}

	/**
	 * Returns the number of blockses.
	 *
	 * @return the number of blockses
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_BLOCKS);

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return dummyEntityCache;
	}

	@Override
	protected String getPKDBName() {
		return "blockId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_BLOCKS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BlocksModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the blocks persistence.
	 */
	public void afterPropertiesSet() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByChannelId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByChannelId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"channelId"}, true);

		_finderPathWithoutPaginationFindByChannelId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByChannelId",
			new String[] {Long.class.getName()}, new String[] {"channelId"},
			true);

		_finderPathCountByChannelId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByChannelId",
			new String[] {Long.class.getName()}, new String[] {"channelId"},
			false);

		BlocksUtil.setPersistence(this);
	}

	public void destroy() {
		BlocksUtil.setPersistence(null);

		dummyEntityCache.removeCache(BlocksImpl.class.getName());
	}

	private static final String _SQL_SELECT_BLOCKS =
		"SELECT blocks FROM Blocks blocks";

	private static final String _SQL_SELECT_BLOCKS_WHERE =
		"SELECT blocks FROM Blocks blocks WHERE ";

	private static final String _SQL_COUNT_BLOCKS =
		"SELECT COUNT(blocks) FROM Blocks blocks";

	private static final String _SQL_COUNT_BLOCKS_WHERE =
		"SELECT COUNT(blocks) FROM Blocks blocks WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "blocks.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Blocks exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Blocks exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BlocksPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}