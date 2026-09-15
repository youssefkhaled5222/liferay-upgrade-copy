/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence.impl;

import com.ejada.telemony.db.exception.NoSuchAppConfigItemException;
import com.ejada.telemony.db.model.AppConfigItem;
import com.ejada.telemony.db.model.AppConfigItemTable;
import com.ejada.telemony.db.model.impl.AppConfigItemImpl;
import com.ejada.telemony.db.model.impl.AppConfigItemModelImpl;
import com.ejada.telemony.db.service.persistence.AppConfigItemPersistence;
import com.ejada.telemony.db.service.persistence.AppConfigItemUtil;

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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the app config item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AppConfigItemPersistenceImpl
	extends BasePersistenceImpl<AppConfigItem>
	implements AppConfigItemPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AppConfigItemUtil</code> to access the app config item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AppConfigItemImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByenvironmentId;
	private FinderPath _finderPathWithoutPaginationFindByenvironmentId;
	private FinderPath _finderPathCountByenvironmentId;

	/**
	 * Returns all the app config items where environmentId = &#63;.
	 *
	 * @param environmentId the environment ID
	 * @return the matching app config items
	 */
	@Override
	public List<AppConfigItem> findByenvironmentId(long environmentId) {
		return findByenvironmentId(
			environmentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the app config items where environmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppConfigItemModelImpl</code>.
	 * </p>
	 *
	 * @param environmentId the environment ID
	 * @param start the lower bound of the range of app config items
	 * @param end the upper bound of the range of app config items (not inclusive)
	 * @return the range of matching app config items
	 */
	@Override
	public List<AppConfigItem> findByenvironmentId(
		long environmentId, int start, int end) {

		return findByenvironmentId(environmentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the app config items where environmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppConfigItemModelImpl</code>.
	 * </p>
	 *
	 * @param environmentId the environment ID
	 * @param start the lower bound of the range of app config items
	 * @param end the upper bound of the range of app config items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching app config items
	 */
	@Override
	public List<AppConfigItem> findByenvironmentId(
		long environmentId, int start, int end,
		OrderByComparator<AppConfigItem> orderByComparator) {

		return findByenvironmentId(
			environmentId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the app config items where environmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppConfigItemModelImpl</code>.
	 * </p>
	 *
	 * @param environmentId the environment ID
	 * @param start the lower bound of the range of app config items
	 * @param end the upper bound of the range of app config items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching app config items
	 */
	@Override
	public List<AppConfigItem> findByenvironmentId(
		long environmentId, int start, int end,
		OrderByComparator<AppConfigItem> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByenvironmentId;
				finderArgs = new Object[] {environmentId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByenvironmentId;
			finderArgs = new Object[] {
				environmentId, start, end, orderByComparator
			};
		}

		List<AppConfigItem> list = null;

		if (useFinderCache) {
			list = (List<AppConfigItem>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AppConfigItem appConfigItem : list) {
					if (environmentId != appConfigItem.getEnvironmentId()) {
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

			sb.append(_SQL_SELECT_APPCONFIGITEM_WHERE);

			sb.append(_FINDER_COLUMN_ENVIRONMENTID_ENVIRONMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AppConfigItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(environmentId);

				list = (List<AppConfigItem>)QueryUtil.list(
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
	 * Returns the first app config item in the ordered set where environmentId = &#63;.
	 *
	 * @param environmentId the environment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app config item
	 * @throws NoSuchAppConfigItemException if a matching app config item could not be found
	 */
	@Override
	public AppConfigItem findByenvironmentId_First(
			long environmentId,
			OrderByComparator<AppConfigItem> orderByComparator)
		throws NoSuchAppConfigItemException {

		AppConfigItem appConfigItem = fetchByenvironmentId_First(
			environmentId, orderByComparator);

		if (appConfigItem != null) {
			return appConfigItem;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("environmentId=");
		sb.append(environmentId);

		sb.append("}");

		throw new NoSuchAppConfigItemException(sb.toString());
	}

	/**
	 * Returns the first app config item in the ordered set where environmentId = &#63;.
	 *
	 * @param environmentId the environment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app config item, or <code>null</code> if a matching app config item could not be found
	 */
	@Override
	public AppConfigItem fetchByenvironmentId_First(
		long environmentId,
		OrderByComparator<AppConfigItem> orderByComparator) {

		List<AppConfigItem> list = findByenvironmentId(
			environmentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last app config item in the ordered set where environmentId = &#63;.
	 *
	 * @param environmentId the environment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app config item
	 * @throws NoSuchAppConfigItemException if a matching app config item could not be found
	 */
	@Override
	public AppConfigItem findByenvironmentId_Last(
			long environmentId,
			OrderByComparator<AppConfigItem> orderByComparator)
		throws NoSuchAppConfigItemException {

		AppConfigItem appConfigItem = fetchByenvironmentId_Last(
			environmentId, orderByComparator);

		if (appConfigItem != null) {
			return appConfigItem;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("environmentId=");
		sb.append(environmentId);

		sb.append("}");

		throw new NoSuchAppConfigItemException(sb.toString());
	}

	/**
	 * Returns the last app config item in the ordered set where environmentId = &#63;.
	 *
	 * @param environmentId the environment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app config item, or <code>null</code> if a matching app config item could not be found
	 */
	@Override
	public AppConfigItem fetchByenvironmentId_Last(
		long environmentId,
		OrderByComparator<AppConfigItem> orderByComparator) {

		int count = countByenvironmentId(environmentId);

		if (count == 0) {
			return null;
		}

		List<AppConfigItem> list = findByenvironmentId(
			environmentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the app config items before and after the current app config item in the ordered set where environmentId = &#63;.
	 *
	 * @param configItemId the primary key of the current app config item
	 * @param environmentId the environment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app config item
	 * @throws NoSuchAppConfigItemException if a app config item with the primary key could not be found
	 */
	@Override
	public AppConfigItem[] findByenvironmentId_PrevAndNext(
			long configItemId, long environmentId,
			OrderByComparator<AppConfigItem> orderByComparator)
		throws NoSuchAppConfigItemException {

		AppConfigItem appConfigItem = findByPrimaryKey(configItemId);

		Session session = null;

		try {
			session = openSession();

			AppConfigItem[] array = new AppConfigItemImpl[3];

			array[0] = getByenvironmentId_PrevAndNext(
				session, appConfigItem, environmentId, orderByComparator, true);

			array[1] = appConfigItem;

			array[2] = getByenvironmentId_PrevAndNext(
				session, appConfigItem, environmentId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AppConfigItem getByenvironmentId_PrevAndNext(
		Session session, AppConfigItem appConfigItem, long environmentId,
		OrderByComparator<AppConfigItem> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_APPCONFIGITEM_WHERE);

		sb.append(_FINDER_COLUMN_ENVIRONMENTID_ENVIRONMENTID_2);

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
			sb.append(AppConfigItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(environmentId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						appConfigItem)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AppConfigItem> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the app config items where environmentId = &#63; from the database.
	 *
	 * @param environmentId the environment ID
	 */
	@Override
	public void removeByenvironmentId(long environmentId) {
		for (AppConfigItem appConfigItem :
				findByenvironmentId(
					environmentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(appConfigItem);
		}
	}

	/**
	 * Returns the number of app config items where environmentId = &#63;.
	 *
	 * @param environmentId the environment ID
	 * @return the number of matching app config items
	 */
	@Override
	public int countByenvironmentId(long environmentId) {
		FinderPath finderPath = _finderPathCountByenvironmentId;

		Object[] finderArgs = new Object[] {environmentId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_APPCONFIGITEM_WHERE);

			sb.append(_FINDER_COLUMN_ENVIRONMENTID_ENVIRONMENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(environmentId);

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

	private static final String _FINDER_COLUMN_ENVIRONMENTID_ENVIRONMENTID_2 =
		"appConfigItem.environmentId = ?";

	public AppConfigItemPersistenceImpl() {
		setModelClass(AppConfigItem.class);

		setModelImplClass(AppConfigItemImpl.class);
		setModelPKClass(long.class);

		setTable(AppConfigItemTable.INSTANCE);
	}

	/**
	 * Caches the app config item in the entity cache if it is enabled.
	 *
	 * @param appConfigItem the app config item
	 */
	@Override
	public void cacheResult(AppConfigItem appConfigItem) {
		dummyEntityCache.putResult(
			AppConfigItemImpl.class, appConfigItem.getPrimaryKey(),
			appConfigItem);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the app config items in the entity cache if it is enabled.
	 *
	 * @param appConfigItems the app config items
	 */
	@Override
	public void cacheResult(List<AppConfigItem> appConfigItems) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (appConfigItems.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AppConfigItem appConfigItem : appConfigItems) {
			if (dummyEntityCache.getResult(
					AppConfigItemImpl.class, appConfigItem.getPrimaryKey()) ==
						null) {

				cacheResult(appConfigItem);
			}
		}
	}

	/**
	 * Clears the cache for all app config items.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(AppConfigItemImpl.class);

		dummyFinderCache.clearCache(AppConfigItemImpl.class);
	}

	/**
	 * Clears the cache for the app config item.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AppConfigItem appConfigItem) {
		dummyEntityCache.removeResult(AppConfigItemImpl.class, appConfigItem);
	}

	@Override
	public void clearCache(List<AppConfigItem> appConfigItems) {
		for (AppConfigItem appConfigItem : appConfigItems) {
			dummyEntityCache.removeResult(
				AppConfigItemImpl.class, appConfigItem);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(AppConfigItemImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(AppConfigItemImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new app config item with the primary key. Does not add the app config item to the database.
	 *
	 * @param configItemId the primary key for the new app config item
	 * @return the new app config item
	 */
	@Override
	public AppConfigItem create(long configItemId) {
		AppConfigItem appConfigItem = new AppConfigItemImpl();

		appConfigItem.setNew(true);
		appConfigItem.setPrimaryKey(configItemId);

		return appConfigItem;
	}

	/**
	 * Removes the app config item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param configItemId the primary key of the app config item
	 * @return the app config item that was removed
	 * @throws NoSuchAppConfigItemException if a app config item with the primary key could not be found
	 */
	@Override
	public AppConfigItem remove(long configItemId)
		throws NoSuchAppConfigItemException {

		return remove((Serializable)configItemId);
	}

	/**
	 * Removes the app config item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the app config item
	 * @return the app config item that was removed
	 * @throws NoSuchAppConfigItemException if a app config item with the primary key could not be found
	 */
	@Override
	public AppConfigItem remove(Serializable primaryKey)
		throws NoSuchAppConfigItemException {

		Session session = null;

		try {
			session = openSession();

			AppConfigItem appConfigItem = (AppConfigItem)session.get(
				AppConfigItemImpl.class, primaryKey);

			if (appConfigItem == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAppConfigItemException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(appConfigItem);
		}
		catch (NoSuchAppConfigItemException noSuchEntityException) {
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
	protected AppConfigItem removeImpl(AppConfigItem appConfigItem) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(appConfigItem)) {
				appConfigItem = (AppConfigItem)session.get(
					AppConfigItemImpl.class, appConfigItem.getPrimaryKeyObj());
			}

			if (appConfigItem != null) {
				session.delete(appConfigItem);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (appConfigItem != null) {
			clearCache(appConfigItem);
		}

		return appConfigItem;
	}

	@Override
	public AppConfigItem updateImpl(AppConfigItem appConfigItem) {
		boolean isNew = appConfigItem.isNew();

		if (!(appConfigItem instanceof AppConfigItemModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(appConfigItem.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					appConfigItem);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in appConfigItem proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AppConfigItem implementation " +
					appConfigItem.getClass());
		}

		AppConfigItemModelImpl appConfigItemModelImpl =
			(AppConfigItemModelImpl)appConfigItem;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (appConfigItem.getCreateDate() == null)) {
			if (serviceContext == null) {
				appConfigItem.setCreateDate(date);
			}
			else {
				appConfigItem.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!appConfigItemModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				appConfigItem.setModifiedDate(date);
			}
			else {
				appConfigItem.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(appConfigItem);
			}
			else {
				appConfigItem = (AppConfigItem)session.merge(appConfigItem);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			AppConfigItemImpl.class, appConfigItemModelImpl, false, true);

		if (isNew) {
			appConfigItem.setNew(false);
		}

		appConfigItem.resetOriginalValues();

		return appConfigItem;
	}

	/**
	 * Returns the app config item with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the app config item
	 * @return the app config item
	 * @throws NoSuchAppConfigItemException if a app config item with the primary key could not be found
	 */
	@Override
	public AppConfigItem findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAppConfigItemException {

		AppConfigItem appConfigItem = fetchByPrimaryKey(primaryKey);

		if (appConfigItem == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAppConfigItemException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return appConfigItem;
	}

	/**
	 * Returns the app config item with the primary key or throws a <code>NoSuchAppConfigItemException</code> if it could not be found.
	 *
	 * @param configItemId the primary key of the app config item
	 * @return the app config item
	 * @throws NoSuchAppConfigItemException if a app config item with the primary key could not be found
	 */
	@Override
	public AppConfigItem findByPrimaryKey(long configItemId)
		throws NoSuchAppConfigItemException {

		return findByPrimaryKey((Serializable)configItemId);
	}

	/**
	 * Returns the app config item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param configItemId the primary key of the app config item
	 * @return the app config item, or <code>null</code> if a app config item with the primary key could not be found
	 */
	@Override
	public AppConfigItem fetchByPrimaryKey(long configItemId) {
		return fetchByPrimaryKey((Serializable)configItemId);
	}

	/**
	 * Returns all the app config items.
	 *
	 * @return the app config items
	 */
	@Override
	public List<AppConfigItem> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the app config items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppConfigItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app config items
	 * @param end the upper bound of the range of app config items (not inclusive)
	 * @return the range of app config items
	 */
	@Override
	public List<AppConfigItem> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the app config items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppConfigItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app config items
	 * @param end the upper bound of the range of app config items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of app config items
	 */
	@Override
	public List<AppConfigItem> findAll(
		int start, int end,
		OrderByComparator<AppConfigItem> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the app config items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppConfigItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app config items
	 * @param end the upper bound of the range of app config items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of app config items
	 */
	@Override
	public List<AppConfigItem> findAll(
		int start, int end, OrderByComparator<AppConfigItem> orderByComparator,
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

		List<AppConfigItem> list = null;

		if (useFinderCache) {
			list = (List<AppConfigItem>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_APPCONFIGITEM);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_APPCONFIGITEM;

				sql = sql.concat(AppConfigItemModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AppConfigItem>)QueryUtil.list(
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
	 * Removes all the app config items from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AppConfigItem appConfigItem : findAll()) {
			remove(appConfigItem);
		}
	}

	/**
	 * Returns the number of app config items.
	 *
	 * @return the number of app config items
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_APPCONFIGITEM);

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
		return "configItemId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_APPCONFIGITEM;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AppConfigItemModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the app config item persistence.
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

		_finderPathWithPaginationFindByenvironmentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByenvironmentId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"environmentId"}, true);

		_finderPathWithoutPaginationFindByenvironmentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByenvironmentId",
			new String[] {Long.class.getName()}, new String[] {"environmentId"},
			true);

		_finderPathCountByenvironmentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByenvironmentId",
			new String[] {Long.class.getName()}, new String[] {"environmentId"},
			false);

		AppConfigItemUtil.setPersistence(this);
	}

	public void destroy() {
		AppConfigItemUtil.setPersistence(null);

		dummyEntityCache.removeCache(AppConfigItemImpl.class.getName());
	}

	private static final String _SQL_SELECT_APPCONFIGITEM =
		"SELECT appConfigItem FROM AppConfigItem appConfigItem";

	private static final String _SQL_SELECT_APPCONFIGITEM_WHERE =
		"SELECT appConfigItem FROM AppConfigItem appConfigItem WHERE ";

	private static final String _SQL_COUNT_APPCONFIGITEM =
		"SELECT COUNT(appConfigItem) FROM AppConfigItem appConfigItem";

	private static final String _SQL_COUNT_APPCONFIGITEM_WHERE =
		"SELECT COUNT(appConfigItem) FROM AppConfigItem appConfigItem WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "appConfigItem.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AppConfigItem exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AppConfigItem exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AppConfigItemPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}