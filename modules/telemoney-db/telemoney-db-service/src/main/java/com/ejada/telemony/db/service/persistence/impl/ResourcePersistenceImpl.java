/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence.impl;

import com.ejada.telemony.db.exception.NoSuchResourceException;
import com.ejada.telemony.db.model.Resource;
import com.ejada.telemony.db.model.ResourceTable;
import com.ejada.telemony.db.model.impl.ResourceImpl;
import com.ejada.telemony.db.model.impl.ResourceModelImpl;
import com.ejada.telemony.db.service.persistence.ResourceLocalizationPersistence;
import com.ejada.telemony.db.service.persistence.ResourcePersistence;
import com.ejada.telemony.db.service.persistence.ResourceUtil;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
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
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the resource service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ResourcePersistenceImpl
	extends BasePersistenceImpl<Resource> implements ResourcePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ResourceUtil</code> to access the resource persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ResourceImpl.class.getName();

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
	 * Returns all the resources where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the matching resources
	 */
	@Override
	public List<Resource> findByChannelId(long channelId) {
		return findByChannelId(
			channelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the resources where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of resources
	 * @param end the upper bound of the range of resources (not inclusive)
	 * @return the range of matching resources
	 */
	@Override
	public List<Resource> findByChannelId(long channelId, int start, int end) {
		return findByChannelId(channelId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the resources where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of resources
	 * @param end the upper bound of the range of resources (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resources
	 */
	@Override
	public List<Resource> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<Resource> orderByComparator) {

		return findByChannelId(channelId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the resources where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of resources
	 * @param end the upper bound of the range of resources (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resources
	 */
	@Override
	public List<Resource> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<Resource> orderByComparator, boolean useFinderCache) {

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

		List<Resource> list = null;

		if (useFinderCache) {
			list = (List<Resource>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Resource resource : list) {
					if (channelId != resource.getChannelId()) {
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

			sb.append(_SQL_SELECT_RESOURCE_WHERE);

			sb.append(_FINDER_COLUMN_CHANNELID_CHANNELID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ResourceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				list = (List<Resource>)QueryUtil.list(
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
	 * Returns the first resource in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource
	 * @throws NoSuchResourceException if a matching resource could not be found
	 */
	@Override
	public Resource findByChannelId_First(
			long channelId, OrderByComparator<Resource> orderByComparator)
		throws NoSuchResourceException {

		Resource resource = fetchByChannelId_First(
			channelId, orderByComparator);

		if (resource != null) {
			return resource;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append("}");

		throw new NoSuchResourceException(sb.toString());
	}

	/**
	 * Returns the first resource in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource, or <code>null</code> if a matching resource could not be found
	 */
	@Override
	public Resource fetchByChannelId_First(
		long channelId, OrderByComparator<Resource> orderByComparator) {

		List<Resource> list = findByChannelId(
			channelId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last resource in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource
	 * @throws NoSuchResourceException if a matching resource could not be found
	 */
	@Override
	public Resource findByChannelId_Last(
			long channelId, OrderByComparator<Resource> orderByComparator)
		throws NoSuchResourceException {

		Resource resource = fetchByChannelId_Last(channelId, orderByComparator);

		if (resource != null) {
			return resource;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append("}");

		throw new NoSuchResourceException(sb.toString());
	}

	/**
	 * Returns the last resource in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource, or <code>null</code> if a matching resource could not be found
	 */
	@Override
	public Resource fetchByChannelId_Last(
		long channelId, OrderByComparator<Resource> orderByComparator) {

		int count = countByChannelId(channelId);

		if (count == 0) {
			return null;
		}

		List<Resource> list = findByChannelId(
			channelId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the resources before and after the current resource in the ordered set where channelId = &#63;.
	 *
	 * @param resourceId the primary key of the current resource
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource
	 * @throws NoSuchResourceException if a resource with the primary key could not be found
	 */
	@Override
	public Resource[] findByChannelId_PrevAndNext(
			long resourceId, long channelId,
			OrderByComparator<Resource> orderByComparator)
		throws NoSuchResourceException {

		Resource resource = findByPrimaryKey(resourceId);

		Session session = null;

		try {
			session = openSession();

			Resource[] array = new ResourceImpl[3];

			array[0] = getByChannelId_PrevAndNext(
				session, resource, channelId, orderByComparator, true);

			array[1] = resource;

			array[2] = getByChannelId_PrevAndNext(
				session, resource, channelId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Resource getByChannelId_PrevAndNext(
		Session session, Resource resource, long channelId,
		OrderByComparator<Resource> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_RESOURCE_WHERE);

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
			sb.append(ResourceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(channelId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(resource)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Resource> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the resources where channelId = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 */
	@Override
	public void removeByChannelId(long channelId) {
		for (Resource resource :
				findByChannelId(
					channelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(resource);
		}
	}

	/**
	 * Returns the number of resources where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the number of matching resources
	 */
	@Override
	public int countByChannelId(long channelId) {
		FinderPath finderPath = _finderPathCountByChannelId;

		Object[] finderArgs = new Object[] {channelId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RESOURCE_WHERE);

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
		"resource.channelId = ?";

	private FinderPath _finderPathWithPaginationFindByResourceCode;
	private FinderPath _finderPathWithoutPaginationFindByResourceCode;
	private FinderPath _finderPathCountByResourceCode;

	/**
	 * Returns all the resources where resourceCode = &#63; and channelId = &#63;.
	 *
	 * @param resourceCode the resource code
	 * @param channelId the channel ID
	 * @return the matching resources
	 */
	@Override
	public List<Resource> findByResourceCode(
		String resourceCode, long channelId) {

		return findByResourceCode(
			resourceCode, channelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the resources where resourceCode = &#63; and channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceModelImpl</code>.
	 * </p>
	 *
	 * @param resourceCode the resource code
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of resources
	 * @param end the upper bound of the range of resources (not inclusive)
	 * @return the range of matching resources
	 */
	@Override
	public List<Resource> findByResourceCode(
		String resourceCode, long channelId, int start, int end) {

		return findByResourceCode(resourceCode, channelId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the resources where resourceCode = &#63; and channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceModelImpl</code>.
	 * </p>
	 *
	 * @param resourceCode the resource code
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of resources
	 * @param end the upper bound of the range of resources (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resources
	 */
	@Override
	public List<Resource> findByResourceCode(
		String resourceCode, long channelId, int start, int end,
		OrderByComparator<Resource> orderByComparator) {

		return findByResourceCode(
			resourceCode, channelId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the resources where resourceCode = &#63; and channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceModelImpl</code>.
	 * </p>
	 *
	 * @param resourceCode the resource code
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of resources
	 * @param end the upper bound of the range of resources (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resources
	 */
	@Override
	public List<Resource> findByResourceCode(
		String resourceCode, long channelId, int start, int end,
		OrderByComparator<Resource> orderByComparator, boolean useFinderCache) {

		resourceCode = Objects.toString(resourceCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByResourceCode;
				finderArgs = new Object[] {resourceCode, channelId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByResourceCode;
			finderArgs = new Object[] {
				resourceCode, channelId, start, end, orderByComparator
			};
		}

		List<Resource> list = null;

		if (useFinderCache) {
			list = (List<Resource>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Resource resource : list) {
					if (!resourceCode.equals(resource.getResourceCode()) ||
						(channelId != resource.getChannelId())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_RESOURCE_WHERE);

			boolean bindResourceCode = false;

			if (resourceCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_RESOURCECODE_RESOURCECODE_3);
			}
			else {
				bindResourceCode = true;

				sb.append(_FINDER_COLUMN_RESOURCECODE_RESOURCECODE_2);
			}

			sb.append(_FINDER_COLUMN_RESOURCECODE_CHANNELID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ResourceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindResourceCode) {
					queryPos.add(resourceCode);
				}

				queryPos.add(channelId);

				list = (List<Resource>)QueryUtil.list(
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
	 * Returns the first resource in the ordered set where resourceCode = &#63; and channelId = &#63;.
	 *
	 * @param resourceCode the resource code
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource
	 * @throws NoSuchResourceException if a matching resource could not be found
	 */
	@Override
	public Resource findByResourceCode_First(
			String resourceCode, long channelId,
			OrderByComparator<Resource> orderByComparator)
		throws NoSuchResourceException {

		Resource resource = fetchByResourceCode_First(
			resourceCode, channelId, orderByComparator);

		if (resource != null) {
			return resource;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("resourceCode=");
		sb.append(resourceCode);

		sb.append(", channelId=");
		sb.append(channelId);

		sb.append("}");

		throw new NoSuchResourceException(sb.toString());
	}

	/**
	 * Returns the first resource in the ordered set where resourceCode = &#63; and channelId = &#63;.
	 *
	 * @param resourceCode the resource code
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource, or <code>null</code> if a matching resource could not be found
	 */
	@Override
	public Resource fetchByResourceCode_First(
		String resourceCode, long channelId,
		OrderByComparator<Resource> orderByComparator) {

		List<Resource> list = findByResourceCode(
			resourceCode, channelId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last resource in the ordered set where resourceCode = &#63; and channelId = &#63;.
	 *
	 * @param resourceCode the resource code
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource
	 * @throws NoSuchResourceException if a matching resource could not be found
	 */
	@Override
	public Resource findByResourceCode_Last(
			String resourceCode, long channelId,
			OrderByComparator<Resource> orderByComparator)
		throws NoSuchResourceException {

		Resource resource = fetchByResourceCode_Last(
			resourceCode, channelId, orderByComparator);

		if (resource != null) {
			return resource;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("resourceCode=");
		sb.append(resourceCode);

		sb.append(", channelId=");
		sb.append(channelId);

		sb.append("}");

		throw new NoSuchResourceException(sb.toString());
	}

	/**
	 * Returns the last resource in the ordered set where resourceCode = &#63; and channelId = &#63;.
	 *
	 * @param resourceCode the resource code
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource, or <code>null</code> if a matching resource could not be found
	 */
	@Override
	public Resource fetchByResourceCode_Last(
		String resourceCode, long channelId,
		OrderByComparator<Resource> orderByComparator) {

		int count = countByResourceCode(resourceCode, channelId);

		if (count == 0) {
			return null;
		}

		List<Resource> list = findByResourceCode(
			resourceCode, channelId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the resources before and after the current resource in the ordered set where resourceCode = &#63; and channelId = &#63;.
	 *
	 * @param resourceId the primary key of the current resource
	 * @param resourceCode the resource code
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource
	 * @throws NoSuchResourceException if a resource with the primary key could not be found
	 */
	@Override
	public Resource[] findByResourceCode_PrevAndNext(
			long resourceId, String resourceCode, long channelId,
			OrderByComparator<Resource> orderByComparator)
		throws NoSuchResourceException {

		resourceCode = Objects.toString(resourceCode, "");

		Resource resource = findByPrimaryKey(resourceId);

		Session session = null;

		try {
			session = openSession();

			Resource[] array = new ResourceImpl[3];

			array[0] = getByResourceCode_PrevAndNext(
				session, resource, resourceCode, channelId, orderByComparator,
				true);

			array[1] = resource;

			array[2] = getByResourceCode_PrevAndNext(
				session, resource, resourceCode, channelId, orderByComparator,
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

	protected Resource getByResourceCode_PrevAndNext(
		Session session, Resource resource, String resourceCode, long channelId,
		OrderByComparator<Resource> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_RESOURCE_WHERE);

		boolean bindResourceCode = false;

		if (resourceCode.isEmpty()) {
			sb.append(_FINDER_COLUMN_RESOURCECODE_RESOURCECODE_3);
		}
		else {
			bindResourceCode = true;

			sb.append(_FINDER_COLUMN_RESOURCECODE_RESOURCECODE_2);
		}

		sb.append(_FINDER_COLUMN_RESOURCECODE_CHANNELID_2);

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
			sb.append(ResourceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindResourceCode) {
			queryPos.add(resourceCode);
		}

		queryPos.add(channelId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(resource)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Resource> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the resources where resourceCode = &#63; and channelId = &#63; from the database.
	 *
	 * @param resourceCode the resource code
	 * @param channelId the channel ID
	 */
	@Override
	public void removeByResourceCode(String resourceCode, long channelId) {
		for (Resource resource :
				findByResourceCode(
					resourceCode, channelId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(resource);
		}
	}

	/**
	 * Returns the number of resources where resourceCode = &#63; and channelId = &#63;.
	 *
	 * @param resourceCode the resource code
	 * @param channelId the channel ID
	 * @return the number of matching resources
	 */
	@Override
	public int countByResourceCode(String resourceCode, long channelId) {
		resourceCode = Objects.toString(resourceCode, "");

		FinderPath finderPath = _finderPathCountByResourceCode;

		Object[] finderArgs = new Object[] {resourceCode, channelId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_RESOURCE_WHERE);

			boolean bindResourceCode = false;

			if (resourceCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_RESOURCECODE_RESOURCECODE_3);
			}
			else {
				bindResourceCode = true;

				sb.append(_FINDER_COLUMN_RESOURCECODE_RESOURCECODE_2);
			}

			sb.append(_FINDER_COLUMN_RESOURCECODE_CHANNELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindResourceCode) {
					queryPos.add(resourceCode);
				}

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

	private static final String _FINDER_COLUMN_RESOURCECODE_RESOURCECODE_2 =
		"resource.resourceCode = ? AND ";

	private static final String _FINDER_COLUMN_RESOURCECODE_RESOURCECODE_3 =
		"(resource.resourceCode IS NULL OR resource.resourceCode = '') AND ";

	private static final String _FINDER_COLUMN_RESOURCECODE_CHANNELID_2 =
		"resource.channelId = ?";

	private FinderPath _finderPathWithPaginationFindByResourceType;
	private FinderPath _finderPathWithoutPaginationFindByResourceType;
	private FinderPath _finderPathCountByResourceType;

	/**
	 * Returns all the resources where resourceType = &#63; and channelId = &#63;.
	 *
	 * @param resourceType the resource type
	 * @param channelId the channel ID
	 * @return the matching resources
	 */
	@Override
	public List<Resource> findByResourceType(
		String resourceType, long channelId) {

		return findByResourceType(
			resourceType, channelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the resources where resourceType = &#63; and channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceModelImpl</code>.
	 * </p>
	 *
	 * @param resourceType the resource type
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of resources
	 * @param end the upper bound of the range of resources (not inclusive)
	 * @return the range of matching resources
	 */
	@Override
	public List<Resource> findByResourceType(
		String resourceType, long channelId, int start, int end) {

		return findByResourceType(resourceType, channelId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the resources where resourceType = &#63; and channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceModelImpl</code>.
	 * </p>
	 *
	 * @param resourceType the resource type
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of resources
	 * @param end the upper bound of the range of resources (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resources
	 */
	@Override
	public List<Resource> findByResourceType(
		String resourceType, long channelId, int start, int end,
		OrderByComparator<Resource> orderByComparator) {

		return findByResourceType(
			resourceType, channelId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the resources where resourceType = &#63; and channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceModelImpl</code>.
	 * </p>
	 *
	 * @param resourceType the resource type
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of resources
	 * @param end the upper bound of the range of resources (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resources
	 */
	@Override
	public List<Resource> findByResourceType(
		String resourceType, long channelId, int start, int end,
		OrderByComparator<Resource> orderByComparator, boolean useFinderCache) {

		resourceType = Objects.toString(resourceType, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByResourceType;
				finderArgs = new Object[] {resourceType, channelId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByResourceType;
			finderArgs = new Object[] {
				resourceType, channelId, start, end, orderByComparator
			};
		}

		List<Resource> list = null;

		if (useFinderCache) {
			list = (List<Resource>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Resource resource : list) {
					if (!resourceType.equals(resource.getResourceType()) ||
						(channelId != resource.getChannelId())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_RESOURCE_WHERE);

			boolean bindResourceType = false;

			if (resourceType.isEmpty()) {
				sb.append(_FINDER_COLUMN_RESOURCETYPE_RESOURCETYPE_3);
			}
			else {
				bindResourceType = true;

				sb.append(_FINDER_COLUMN_RESOURCETYPE_RESOURCETYPE_2);
			}

			sb.append(_FINDER_COLUMN_RESOURCETYPE_CHANNELID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ResourceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindResourceType) {
					queryPos.add(resourceType);
				}

				queryPos.add(channelId);

				list = (List<Resource>)QueryUtil.list(
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
	 * Returns the first resource in the ordered set where resourceType = &#63; and channelId = &#63;.
	 *
	 * @param resourceType the resource type
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource
	 * @throws NoSuchResourceException if a matching resource could not be found
	 */
	@Override
	public Resource findByResourceType_First(
			String resourceType, long channelId,
			OrderByComparator<Resource> orderByComparator)
		throws NoSuchResourceException {

		Resource resource = fetchByResourceType_First(
			resourceType, channelId, orderByComparator);

		if (resource != null) {
			return resource;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("resourceType=");
		sb.append(resourceType);

		sb.append(", channelId=");
		sb.append(channelId);

		sb.append("}");

		throw new NoSuchResourceException(sb.toString());
	}

	/**
	 * Returns the first resource in the ordered set where resourceType = &#63; and channelId = &#63;.
	 *
	 * @param resourceType the resource type
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource, or <code>null</code> if a matching resource could not be found
	 */
	@Override
	public Resource fetchByResourceType_First(
		String resourceType, long channelId,
		OrderByComparator<Resource> orderByComparator) {

		List<Resource> list = findByResourceType(
			resourceType, channelId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last resource in the ordered set where resourceType = &#63; and channelId = &#63;.
	 *
	 * @param resourceType the resource type
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource
	 * @throws NoSuchResourceException if a matching resource could not be found
	 */
	@Override
	public Resource findByResourceType_Last(
			String resourceType, long channelId,
			OrderByComparator<Resource> orderByComparator)
		throws NoSuchResourceException {

		Resource resource = fetchByResourceType_Last(
			resourceType, channelId, orderByComparator);

		if (resource != null) {
			return resource;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("resourceType=");
		sb.append(resourceType);

		sb.append(", channelId=");
		sb.append(channelId);

		sb.append("}");

		throw new NoSuchResourceException(sb.toString());
	}

	/**
	 * Returns the last resource in the ordered set where resourceType = &#63; and channelId = &#63;.
	 *
	 * @param resourceType the resource type
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource, or <code>null</code> if a matching resource could not be found
	 */
	@Override
	public Resource fetchByResourceType_Last(
		String resourceType, long channelId,
		OrderByComparator<Resource> orderByComparator) {

		int count = countByResourceType(resourceType, channelId);

		if (count == 0) {
			return null;
		}

		List<Resource> list = findByResourceType(
			resourceType, channelId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the resources before and after the current resource in the ordered set where resourceType = &#63; and channelId = &#63;.
	 *
	 * @param resourceId the primary key of the current resource
	 * @param resourceType the resource type
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource
	 * @throws NoSuchResourceException if a resource with the primary key could not be found
	 */
	@Override
	public Resource[] findByResourceType_PrevAndNext(
			long resourceId, String resourceType, long channelId,
			OrderByComparator<Resource> orderByComparator)
		throws NoSuchResourceException {

		resourceType = Objects.toString(resourceType, "");

		Resource resource = findByPrimaryKey(resourceId);

		Session session = null;

		try {
			session = openSession();

			Resource[] array = new ResourceImpl[3];

			array[0] = getByResourceType_PrevAndNext(
				session, resource, resourceType, channelId, orderByComparator,
				true);

			array[1] = resource;

			array[2] = getByResourceType_PrevAndNext(
				session, resource, resourceType, channelId, orderByComparator,
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

	protected Resource getByResourceType_PrevAndNext(
		Session session, Resource resource, String resourceType, long channelId,
		OrderByComparator<Resource> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_RESOURCE_WHERE);

		boolean bindResourceType = false;

		if (resourceType.isEmpty()) {
			sb.append(_FINDER_COLUMN_RESOURCETYPE_RESOURCETYPE_3);
		}
		else {
			bindResourceType = true;

			sb.append(_FINDER_COLUMN_RESOURCETYPE_RESOURCETYPE_2);
		}

		sb.append(_FINDER_COLUMN_RESOURCETYPE_CHANNELID_2);

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
			sb.append(ResourceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindResourceType) {
			queryPos.add(resourceType);
		}

		queryPos.add(channelId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(resource)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Resource> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the resources where resourceType = &#63; and channelId = &#63; from the database.
	 *
	 * @param resourceType the resource type
	 * @param channelId the channel ID
	 */
	@Override
	public void removeByResourceType(String resourceType, long channelId) {
		for (Resource resource :
				findByResourceType(
					resourceType, channelId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(resource);
		}
	}

	/**
	 * Returns the number of resources where resourceType = &#63; and channelId = &#63;.
	 *
	 * @param resourceType the resource type
	 * @param channelId the channel ID
	 * @return the number of matching resources
	 */
	@Override
	public int countByResourceType(String resourceType, long channelId) {
		resourceType = Objects.toString(resourceType, "");

		FinderPath finderPath = _finderPathCountByResourceType;

		Object[] finderArgs = new Object[] {resourceType, channelId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_RESOURCE_WHERE);

			boolean bindResourceType = false;

			if (resourceType.isEmpty()) {
				sb.append(_FINDER_COLUMN_RESOURCETYPE_RESOURCETYPE_3);
			}
			else {
				bindResourceType = true;

				sb.append(_FINDER_COLUMN_RESOURCETYPE_RESOURCETYPE_2);
			}

			sb.append(_FINDER_COLUMN_RESOURCETYPE_CHANNELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindResourceType) {
					queryPos.add(resourceType);
				}

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

	private static final String _FINDER_COLUMN_RESOURCETYPE_RESOURCETYPE_2 =
		"resource.resourceType = ? AND ";

	private static final String _FINDER_COLUMN_RESOURCETYPE_RESOURCETYPE_3 =
		"(resource.resourceType IS NULL OR resource.resourceType = '') AND ";

	private static final String _FINDER_COLUMN_RESOURCETYPE_CHANNELID_2 =
		"resource.channelId = ?";

	private FinderPath _finderPathWithPaginationFindByentityResourceId;
	private FinderPath _finderPathWithoutPaginationFindByentityResourceId;
	private FinderPath _finderPathCountByentityResourceId;

	/**
	 * Returns all the resources where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the matching resources
	 */
	@Override
	public List<Resource> findByentityResourceId(long entityResourceId) {
		return findByentityResourceId(
			entityResourceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the resources where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of resources
	 * @param end the upper bound of the range of resources (not inclusive)
	 * @return the range of matching resources
	 */
	@Override
	public List<Resource> findByentityResourceId(
		long entityResourceId, int start, int end) {

		return findByentityResourceId(entityResourceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the resources where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of resources
	 * @param end the upper bound of the range of resources (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resources
	 */
	@Override
	public List<Resource> findByentityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<Resource> orderByComparator) {

		return findByentityResourceId(
			entityResourceId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the resources where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of resources
	 * @param end the upper bound of the range of resources (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resources
	 */
	@Override
	public List<Resource> findByentityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<Resource> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByentityResourceId;
				finderArgs = new Object[] {entityResourceId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByentityResourceId;
			finderArgs = new Object[] {
				entityResourceId, start, end, orderByComparator
			};
		}

		List<Resource> list = null;

		if (useFinderCache) {
			list = (List<Resource>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Resource resource : list) {
					if (entityResourceId != resource.getEntityResourceId()) {
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

			sb.append(_SQL_SELECT_RESOURCE_WHERE);

			sb.append(_FINDER_COLUMN_ENTITYRESOURCEID_ENTITYRESOURCEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ResourceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(entityResourceId);

				list = (List<Resource>)QueryUtil.list(
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
	 * Returns the first resource in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource
	 * @throws NoSuchResourceException if a matching resource could not be found
	 */
	@Override
	public Resource findByentityResourceId_First(
			long entityResourceId,
			OrderByComparator<Resource> orderByComparator)
		throws NoSuchResourceException {

		Resource resource = fetchByentityResourceId_First(
			entityResourceId, orderByComparator);

		if (resource != null) {
			return resource;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("entityResourceId=");
		sb.append(entityResourceId);

		sb.append("}");

		throw new NoSuchResourceException(sb.toString());
	}

	/**
	 * Returns the first resource in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource, or <code>null</code> if a matching resource could not be found
	 */
	@Override
	public Resource fetchByentityResourceId_First(
		long entityResourceId, OrderByComparator<Resource> orderByComparator) {

		List<Resource> list = findByentityResourceId(
			entityResourceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last resource in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource
	 * @throws NoSuchResourceException if a matching resource could not be found
	 */
	@Override
	public Resource findByentityResourceId_Last(
			long entityResourceId,
			OrderByComparator<Resource> orderByComparator)
		throws NoSuchResourceException {

		Resource resource = fetchByentityResourceId_Last(
			entityResourceId, orderByComparator);

		if (resource != null) {
			return resource;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("entityResourceId=");
		sb.append(entityResourceId);

		sb.append("}");

		throw new NoSuchResourceException(sb.toString());
	}

	/**
	 * Returns the last resource in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource, or <code>null</code> if a matching resource could not be found
	 */
	@Override
	public Resource fetchByentityResourceId_Last(
		long entityResourceId, OrderByComparator<Resource> orderByComparator) {

		int count = countByentityResourceId(entityResourceId);

		if (count == 0) {
			return null;
		}

		List<Resource> list = findByentityResourceId(
			entityResourceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the resources before and after the current resource in the ordered set where entityResourceId = &#63;.
	 *
	 * @param resourceId the primary key of the current resource
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource
	 * @throws NoSuchResourceException if a resource with the primary key could not be found
	 */
	@Override
	public Resource[] findByentityResourceId_PrevAndNext(
			long resourceId, long entityResourceId,
			OrderByComparator<Resource> orderByComparator)
		throws NoSuchResourceException {

		Resource resource = findByPrimaryKey(resourceId);

		Session session = null;

		try {
			session = openSession();

			Resource[] array = new ResourceImpl[3];

			array[0] = getByentityResourceId_PrevAndNext(
				session, resource, entityResourceId, orderByComparator, true);

			array[1] = resource;

			array[2] = getByentityResourceId_PrevAndNext(
				session, resource, entityResourceId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Resource getByentityResourceId_PrevAndNext(
		Session session, Resource resource, long entityResourceId,
		OrderByComparator<Resource> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_RESOURCE_WHERE);

		sb.append(_FINDER_COLUMN_ENTITYRESOURCEID_ENTITYRESOURCEID_2);

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
			sb.append(ResourceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(entityResourceId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(resource)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Resource> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the resources where entityResourceId = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 */
	@Override
	public void removeByentityResourceId(long entityResourceId) {
		for (Resource resource :
				findByentityResourceId(
					entityResourceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(resource);
		}
	}

	/**
	 * Returns the number of resources where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the number of matching resources
	 */
	@Override
	public int countByentityResourceId(long entityResourceId) {
		FinderPath finderPath = _finderPathCountByentityResourceId;

		Object[] finderArgs = new Object[] {entityResourceId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RESOURCE_WHERE);

			sb.append(_FINDER_COLUMN_ENTITYRESOURCEID_ENTITYRESOURCEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(entityResourceId);

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

	private static final String
		_FINDER_COLUMN_ENTITYRESOURCEID_ENTITYRESOURCEID_2 =
			"resource.entityResourceId = ?";

	public ResourcePersistenceImpl() {
		setModelClass(Resource.class);

		setModelImplClass(ResourceImpl.class);
		setModelPKClass(long.class);

		setTable(ResourceTable.INSTANCE);
	}

	/**
	 * Caches the resource in the entity cache if it is enabled.
	 *
	 * @param resource the resource
	 */
	@Override
	public void cacheResult(Resource resource) {
		dummyEntityCache.putResult(
			ResourceImpl.class, resource.getPrimaryKey(), resource);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the resources in the entity cache if it is enabled.
	 *
	 * @param resources the resources
	 */
	@Override
	public void cacheResult(List<Resource> resources) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (resources.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Resource resource : resources) {
			if (dummyEntityCache.getResult(
					ResourceImpl.class, resource.getPrimaryKey()) == null) {

				cacheResult(resource);
			}
		}
	}

	/**
	 * Clears the cache for all resources.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(ResourceImpl.class);

		dummyFinderCache.clearCache(ResourceImpl.class);
	}

	/**
	 * Clears the cache for the resource.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Resource resource) {
		dummyEntityCache.removeResult(ResourceImpl.class, resource);
	}

	@Override
	public void clearCache(List<Resource> resources) {
		for (Resource resource : resources) {
			dummyEntityCache.removeResult(ResourceImpl.class, resource);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(ResourceImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(ResourceImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new resource with the primary key. Does not add the resource to the database.
	 *
	 * @param resourceId the primary key for the new resource
	 * @return the new resource
	 */
	@Override
	public Resource create(long resourceId) {
		Resource resource = new ResourceImpl();

		resource.setNew(true);
		resource.setPrimaryKey(resourceId);

		resource.setCompanyId(CompanyThreadLocal.getCompanyId());

		return resource;
	}

	/**
	 * Removes the resource with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param resourceId the primary key of the resource
	 * @return the resource that was removed
	 * @throws NoSuchResourceException if a resource with the primary key could not be found
	 */
	@Override
	public Resource remove(long resourceId) throws NoSuchResourceException {
		return remove((Serializable)resourceId);
	}

	/**
	 * Removes the resource with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the resource
	 * @return the resource that was removed
	 * @throws NoSuchResourceException if a resource with the primary key could not be found
	 */
	@Override
	public Resource remove(Serializable primaryKey)
		throws NoSuchResourceException {

		Session session = null;

		try {
			session = openSession();

			Resource resource = (Resource)session.get(
				ResourceImpl.class, primaryKey);

			if (resource == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchResourceException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(resource);
		}
		catch (NoSuchResourceException noSuchEntityException) {
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
	protected Resource removeImpl(Resource resource) {
		resourceLocalizationPersistence.removeByResourceId(
			resource.getResourceId());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(resource)) {
				resource = (Resource)session.get(
					ResourceImpl.class, resource.getPrimaryKeyObj());
			}

			if (resource != null) {
				session.delete(resource);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (resource != null) {
			clearCache(resource);
		}

		return resource;
	}

	@Override
	public Resource updateImpl(Resource resource) {
		boolean isNew = resource.isNew();

		if (!(resource instanceof ResourceModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(resource.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(resource);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in resource proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Resource implementation " +
					resource.getClass());
		}

		ResourceModelImpl resourceModelImpl = (ResourceModelImpl)resource;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (resource.getCreateDate() == null)) {
			if (serviceContext == null) {
				resource.setCreateDate(date);
			}
			else {
				resource.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!resourceModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				resource.setModifiedDate(date);
			}
			else {
				resource.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(resource);
			}
			else {
				resource = (Resource)session.merge(resource);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			ResourceImpl.class, resourceModelImpl, false, true);

		if (isNew) {
			resource.setNew(false);
		}

		resource.resetOriginalValues();

		return resource;
	}

	/**
	 * Returns the resource with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the resource
	 * @return the resource
	 * @throws NoSuchResourceException if a resource with the primary key could not be found
	 */
	@Override
	public Resource findByPrimaryKey(Serializable primaryKey)
		throws NoSuchResourceException {

		Resource resource = fetchByPrimaryKey(primaryKey);

		if (resource == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchResourceException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return resource;
	}

	/**
	 * Returns the resource with the primary key or throws a <code>NoSuchResourceException</code> if it could not be found.
	 *
	 * @param resourceId the primary key of the resource
	 * @return the resource
	 * @throws NoSuchResourceException if a resource with the primary key could not be found
	 */
	@Override
	public Resource findByPrimaryKey(long resourceId)
		throws NoSuchResourceException {

		return findByPrimaryKey((Serializable)resourceId);
	}

	/**
	 * Returns the resource with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param resourceId the primary key of the resource
	 * @return the resource, or <code>null</code> if a resource with the primary key could not be found
	 */
	@Override
	public Resource fetchByPrimaryKey(long resourceId) {
		return fetchByPrimaryKey((Serializable)resourceId);
	}

	/**
	 * Returns all the resources.
	 *
	 * @return the resources
	 */
	@Override
	public List<Resource> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the resources.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resources
	 * @param end the upper bound of the range of resources (not inclusive)
	 * @return the range of resources
	 */
	@Override
	public List<Resource> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the resources.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resources
	 * @param end the upper bound of the range of resources (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of resources
	 */
	@Override
	public List<Resource> findAll(
		int start, int end, OrderByComparator<Resource> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the resources.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resources
	 * @param end the upper bound of the range of resources (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of resources
	 */
	@Override
	public List<Resource> findAll(
		int start, int end, OrderByComparator<Resource> orderByComparator,
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

		List<Resource> list = null;

		if (useFinderCache) {
			list = (List<Resource>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_RESOURCE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_RESOURCE;

				sql = sql.concat(ResourceModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Resource>)QueryUtil.list(
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
	 * Removes all the resources from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Resource resource : findAll()) {
			remove(resource);
		}
	}

	/**
	 * Returns the number of resources.
	 *
	 * @return the number of resources
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_RESOURCE);

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
		return "resourceId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_RESOURCE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ResourceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the resource persistence.
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

		_finderPathWithPaginationFindByResourceCode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByResourceCode",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"resourceCode", "channelId"}, true);

		_finderPathWithoutPaginationFindByResourceCode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByResourceCode",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"resourceCode", "channelId"}, true);

		_finderPathCountByResourceCode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByResourceCode",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"resourceCode", "channelId"}, false);

		_finderPathWithPaginationFindByResourceType = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByResourceType",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"resourceType", "channelId"}, true);

		_finderPathWithoutPaginationFindByResourceType = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByResourceType",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"resourceType", "channelId"}, true);

		_finderPathCountByResourceType = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByResourceType",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"resourceType", "channelId"}, false);

		_finderPathWithPaginationFindByentityResourceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByentityResourceId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"entityResourceId"}, true);

		_finderPathWithoutPaginationFindByentityResourceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByentityResourceId",
			new String[] {Long.class.getName()},
			new String[] {"entityResourceId"}, true);

		_finderPathCountByentityResourceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByentityResourceId", new String[] {Long.class.getName()},
			new String[] {"entityResourceId"}, false);

		ResourceUtil.setPersistence(this);
	}

	public void destroy() {
		ResourceUtil.setPersistence(null);

		dummyEntityCache.removeCache(ResourceImpl.class.getName());
	}

	@BeanReference(type = ResourceLocalizationPersistence.class)
	protected ResourceLocalizationPersistence resourceLocalizationPersistence;

	private static final String _SQL_SELECT_RESOURCE =
		"SELECT resource FROM Resource resource";

	private static final String _SQL_SELECT_RESOURCE_WHERE =
		"SELECT resource FROM Resource resource WHERE ";

	private static final String _SQL_COUNT_RESOURCE =
		"SELECT COUNT(resource) FROM Resource resource";

	private static final String _SQL_COUNT_RESOURCE_WHERE =
		"SELECT COUNT(resource) FROM Resource resource WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "resource.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Resource exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Resource exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ResourcePersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}