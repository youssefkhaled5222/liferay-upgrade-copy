/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence.impl;

import com.ejada.telemony.db.exception.NoSuchBannerContentException;
import com.ejada.telemony.db.model.BannerContent;
import com.ejada.telemony.db.model.BannerContentTable;
import com.ejada.telemony.db.model.impl.BannerContentImpl;
import com.ejada.telemony.db.model.impl.BannerContentModelImpl;
import com.ejada.telemony.db.service.persistence.BannerContentLocalizationPersistence;
import com.ejada.telemony.db.service.persistence.BannerContentPersistence;
import com.ejada.telemony.db.service.persistence.BannerContentUtil;

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
 * The persistence implementation for the banner content service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BannerContentPersistenceImpl
	extends BasePersistenceImpl<BannerContent>
	implements BannerContentPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BannerContentUtil</code> to access the banner content persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BannerContentImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByBannerId;
	private FinderPath _finderPathWithoutPaginationFindByBannerId;
	private FinderPath _finderPathCountByBannerId;

	/**
	 * Returns all the banner contents where bannerId = &#63;.
	 *
	 * @param bannerId the banner ID
	 * @return the matching banner contents
	 */
	@Override
	public List<BannerContent> findByBannerId(long bannerId) {
		return findByBannerId(
			bannerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the banner contents where bannerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param bannerId the banner ID
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @return the range of matching banner contents
	 */
	@Override
	public List<BannerContent> findByBannerId(
		long bannerId, int start, int end) {

		return findByBannerId(bannerId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the banner contents where bannerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param bannerId the banner ID
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching banner contents
	 */
	@Override
	public List<BannerContent> findByBannerId(
		long bannerId, int start, int end,
		OrderByComparator<BannerContent> orderByComparator) {

		return findByBannerId(bannerId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the banner contents where bannerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param bannerId the banner ID
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching banner contents
	 */
	@Override
	public List<BannerContent> findByBannerId(
		long bannerId, int start, int end,
		OrderByComparator<BannerContent> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByBannerId;
				finderArgs = new Object[] {bannerId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByBannerId;
			finderArgs = new Object[] {bannerId, start, end, orderByComparator};
		}

		List<BannerContent> list = null;

		if (useFinderCache) {
			list = (List<BannerContent>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BannerContent bannerContent : list) {
					if (bannerId != bannerContent.getBannerId()) {
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

			sb.append(_SQL_SELECT_BANNERCONTENT_WHERE);

			sb.append(_FINDER_COLUMN_BANNERID_BANNERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BannerContentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(bannerId);

				list = (List<BannerContent>)QueryUtil.list(
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
	 * Returns the first banner content in the ordered set where bannerId = &#63;.
	 *
	 * @param bannerId the banner ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner content
	 * @throws NoSuchBannerContentException if a matching banner content could not be found
	 */
	@Override
	public BannerContent findByBannerId_First(
			long bannerId, OrderByComparator<BannerContent> orderByComparator)
		throws NoSuchBannerContentException {

		BannerContent bannerContent = fetchByBannerId_First(
			bannerId, orderByComparator);

		if (bannerContent != null) {
			return bannerContent;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("bannerId=");
		sb.append(bannerId);

		sb.append("}");

		throw new NoSuchBannerContentException(sb.toString());
	}

	/**
	 * Returns the first banner content in the ordered set where bannerId = &#63;.
	 *
	 * @param bannerId the banner ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner content, or <code>null</code> if a matching banner content could not be found
	 */
	@Override
	public BannerContent fetchByBannerId_First(
		long bannerId, OrderByComparator<BannerContent> orderByComparator) {

		List<BannerContent> list = findByBannerId(
			bannerId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last banner content in the ordered set where bannerId = &#63;.
	 *
	 * @param bannerId the banner ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner content
	 * @throws NoSuchBannerContentException if a matching banner content could not be found
	 */
	@Override
	public BannerContent findByBannerId_Last(
			long bannerId, OrderByComparator<BannerContent> orderByComparator)
		throws NoSuchBannerContentException {

		BannerContent bannerContent = fetchByBannerId_Last(
			bannerId, orderByComparator);

		if (bannerContent != null) {
			return bannerContent;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("bannerId=");
		sb.append(bannerId);

		sb.append("}");

		throw new NoSuchBannerContentException(sb.toString());
	}

	/**
	 * Returns the last banner content in the ordered set where bannerId = &#63;.
	 *
	 * @param bannerId the banner ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner content, or <code>null</code> if a matching banner content could not be found
	 */
	@Override
	public BannerContent fetchByBannerId_Last(
		long bannerId, OrderByComparator<BannerContent> orderByComparator) {

		int count = countByBannerId(bannerId);

		if (count == 0) {
			return null;
		}

		List<BannerContent> list = findByBannerId(
			bannerId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the banner contents before and after the current banner content in the ordered set where bannerId = &#63;.
	 *
	 * @param contentId the primary key of the current banner content
	 * @param bannerId the banner ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next banner content
	 * @throws NoSuchBannerContentException if a banner content with the primary key could not be found
	 */
	@Override
	public BannerContent[] findByBannerId_PrevAndNext(
			long contentId, long bannerId,
			OrderByComparator<BannerContent> orderByComparator)
		throws NoSuchBannerContentException {

		BannerContent bannerContent = findByPrimaryKey(contentId);

		Session session = null;

		try {
			session = openSession();

			BannerContent[] array = new BannerContentImpl[3];

			array[0] = getByBannerId_PrevAndNext(
				session, bannerContent, bannerId, orderByComparator, true);

			array[1] = bannerContent;

			array[2] = getByBannerId_PrevAndNext(
				session, bannerContent, bannerId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected BannerContent getByBannerId_PrevAndNext(
		Session session, BannerContent bannerContent, long bannerId,
		OrderByComparator<BannerContent> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BANNERCONTENT_WHERE);

		sb.append(_FINDER_COLUMN_BANNERID_BANNERID_2);

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
			sb.append(BannerContentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(bannerId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						bannerContent)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BannerContent> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the banner contents where bannerId = &#63; from the database.
	 *
	 * @param bannerId the banner ID
	 */
	@Override
	public void removeByBannerId(long bannerId) {
		for (BannerContent bannerContent :
				findByBannerId(
					bannerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(bannerContent);
		}
	}

	/**
	 * Returns the number of banner contents where bannerId = &#63;.
	 *
	 * @param bannerId the banner ID
	 * @return the number of matching banner contents
	 */
	@Override
	public int countByBannerId(long bannerId) {
		FinderPath finderPath = _finderPathCountByBannerId;

		Object[] finderArgs = new Object[] {bannerId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BANNERCONTENT_WHERE);

			sb.append(_FINDER_COLUMN_BANNERID_BANNERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(bannerId);

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

	private static final String _FINDER_COLUMN_BANNERID_BANNERID_2 =
		"bannerContent.bannerId = ?";

	private FinderPath _finderPathWithPaginationFindByEntityResourceId;
	private FinderPath _finderPathWithoutPaginationFindByEntityResourceId;
	private FinderPath _finderPathCountByEntityResourceId;

	/**
	 * Returns all the banner contents where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the matching banner contents
	 */
	@Override
	public List<BannerContent> findByEntityResourceId(long entityResourceId) {
		return findByEntityResourceId(
			entityResourceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the banner contents where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @return the range of matching banner contents
	 */
	@Override
	public List<BannerContent> findByEntityResourceId(
		long entityResourceId, int start, int end) {

		return findByEntityResourceId(entityResourceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the banner contents where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching banner contents
	 */
	@Override
	public List<BannerContent> findByEntityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<BannerContent> orderByComparator) {

		return findByEntityResourceId(
			entityResourceId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the banner contents where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching banner contents
	 */
	@Override
	public List<BannerContent> findByEntityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<BannerContent> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByEntityResourceId;
				finderArgs = new Object[] {entityResourceId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByEntityResourceId;
			finderArgs = new Object[] {
				entityResourceId, start, end, orderByComparator
			};
		}

		List<BannerContent> list = null;

		if (useFinderCache) {
			list = (List<BannerContent>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BannerContent bannerContent : list) {
					if (entityResourceId !=
							bannerContent.getEntityResourceId()) {

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

			sb.append(_SQL_SELECT_BANNERCONTENT_WHERE);

			sb.append(_FINDER_COLUMN_ENTITYRESOURCEID_ENTITYRESOURCEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BannerContentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(entityResourceId);

				list = (List<BannerContent>)QueryUtil.list(
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
	 * Returns the first banner content in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner content
	 * @throws NoSuchBannerContentException if a matching banner content could not be found
	 */
	@Override
	public BannerContent findByEntityResourceId_First(
			long entityResourceId,
			OrderByComparator<BannerContent> orderByComparator)
		throws NoSuchBannerContentException {

		BannerContent bannerContent = fetchByEntityResourceId_First(
			entityResourceId, orderByComparator);

		if (bannerContent != null) {
			return bannerContent;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("entityResourceId=");
		sb.append(entityResourceId);

		sb.append("}");

		throw new NoSuchBannerContentException(sb.toString());
	}

	/**
	 * Returns the first banner content in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner content, or <code>null</code> if a matching banner content could not be found
	 */
	@Override
	public BannerContent fetchByEntityResourceId_First(
		long entityResourceId,
		OrderByComparator<BannerContent> orderByComparator) {

		List<BannerContent> list = findByEntityResourceId(
			entityResourceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last banner content in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner content
	 * @throws NoSuchBannerContentException if a matching banner content could not be found
	 */
	@Override
	public BannerContent findByEntityResourceId_Last(
			long entityResourceId,
			OrderByComparator<BannerContent> orderByComparator)
		throws NoSuchBannerContentException {

		BannerContent bannerContent = fetchByEntityResourceId_Last(
			entityResourceId, orderByComparator);

		if (bannerContent != null) {
			return bannerContent;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("entityResourceId=");
		sb.append(entityResourceId);

		sb.append("}");

		throw new NoSuchBannerContentException(sb.toString());
	}

	/**
	 * Returns the last banner content in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner content, or <code>null</code> if a matching banner content could not be found
	 */
	@Override
	public BannerContent fetchByEntityResourceId_Last(
		long entityResourceId,
		OrderByComparator<BannerContent> orderByComparator) {

		int count = countByEntityResourceId(entityResourceId);

		if (count == 0) {
			return null;
		}

		List<BannerContent> list = findByEntityResourceId(
			entityResourceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the banner contents before and after the current banner content in the ordered set where entityResourceId = &#63;.
	 *
	 * @param contentId the primary key of the current banner content
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next banner content
	 * @throws NoSuchBannerContentException if a banner content with the primary key could not be found
	 */
	@Override
	public BannerContent[] findByEntityResourceId_PrevAndNext(
			long contentId, long entityResourceId,
			OrderByComparator<BannerContent> orderByComparator)
		throws NoSuchBannerContentException {

		BannerContent bannerContent = findByPrimaryKey(contentId);

		Session session = null;

		try {
			session = openSession();

			BannerContent[] array = new BannerContentImpl[3];

			array[0] = getByEntityResourceId_PrevAndNext(
				session, bannerContent, entityResourceId, orderByComparator,
				true);

			array[1] = bannerContent;

			array[2] = getByEntityResourceId_PrevAndNext(
				session, bannerContent, entityResourceId, orderByComparator,
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

	protected BannerContent getByEntityResourceId_PrevAndNext(
		Session session, BannerContent bannerContent, long entityResourceId,
		OrderByComparator<BannerContent> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BANNERCONTENT_WHERE);

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
			sb.append(BannerContentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(entityResourceId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						bannerContent)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BannerContent> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the banner contents where entityResourceId = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 */
	@Override
	public void removeByEntityResourceId(long entityResourceId) {
		for (BannerContent bannerContent :
				findByEntityResourceId(
					entityResourceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(bannerContent);
		}
	}

	/**
	 * Returns the number of banner contents where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the number of matching banner contents
	 */
	@Override
	public int countByEntityResourceId(long entityResourceId) {
		FinderPath finderPath = _finderPathCountByEntityResourceId;

		Object[] finderArgs = new Object[] {entityResourceId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BANNERCONTENT_WHERE);

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
			"bannerContent.entityResourceId = ?";

	private FinderPath _finderPathWithPaginationFindByBannerIdAndStatus;
	private FinderPath _finderPathWithoutPaginationFindByBannerIdAndStatus;
	private FinderPath _finderPathCountByBannerIdAndStatus;

	/**
	 * Returns all the banner contents where bannerId = &#63; and status = &#63;.
	 *
	 * @param bannerId the banner ID
	 * @param status the status
	 * @return the matching banner contents
	 */
	@Override
	public List<BannerContent> findByBannerIdAndStatus(
		long bannerId, int status) {

		return findByBannerIdAndStatus(
			bannerId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the banner contents where bannerId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param bannerId the banner ID
	 * @param status the status
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @return the range of matching banner contents
	 */
	@Override
	public List<BannerContent> findByBannerIdAndStatus(
		long bannerId, int status, int start, int end) {

		return findByBannerIdAndStatus(bannerId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the banner contents where bannerId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param bannerId the banner ID
	 * @param status the status
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching banner contents
	 */
	@Override
	public List<BannerContent> findByBannerIdAndStatus(
		long bannerId, int status, int start, int end,
		OrderByComparator<BannerContent> orderByComparator) {

		return findByBannerIdAndStatus(
			bannerId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the banner contents where bannerId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param bannerId the banner ID
	 * @param status the status
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching banner contents
	 */
	@Override
	public List<BannerContent> findByBannerIdAndStatus(
		long bannerId, int status, int start, int end,
		OrderByComparator<BannerContent> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByBannerIdAndStatus;
				finderArgs = new Object[] {bannerId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByBannerIdAndStatus;
			finderArgs = new Object[] {
				bannerId, status, start, end, orderByComparator
			};
		}

		List<BannerContent> list = null;

		if (useFinderCache) {
			list = (List<BannerContent>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BannerContent bannerContent : list) {
					if ((bannerId != bannerContent.getBannerId()) ||
						(status != bannerContent.getStatus())) {

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

			sb.append(_SQL_SELECT_BANNERCONTENT_WHERE);

			sb.append(_FINDER_COLUMN_BANNERIDANDSTATUS_BANNERID_2);

			sb.append(_FINDER_COLUMN_BANNERIDANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BannerContentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(bannerId);

				queryPos.add(status);

				list = (List<BannerContent>)QueryUtil.list(
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
	 * Returns the first banner content in the ordered set where bannerId = &#63; and status = &#63;.
	 *
	 * @param bannerId the banner ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner content
	 * @throws NoSuchBannerContentException if a matching banner content could not be found
	 */
	@Override
	public BannerContent findByBannerIdAndStatus_First(
			long bannerId, int status,
			OrderByComparator<BannerContent> orderByComparator)
		throws NoSuchBannerContentException {

		BannerContent bannerContent = fetchByBannerIdAndStatus_First(
			bannerId, status, orderByComparator);

		if (bannerContent != null) {
			return bannerContent;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("bannerId=");
		sb.append(bannerId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchBannerContentException(sb.toString());
	}

	/**
	 * Returns the first banner content in the ordered set where bannerId = &#63; and status = &#63;.
	 *
	 * @param bannerId the banner ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner content, or <code>null</code> if a matching banner content could not be found
	 */
	@Override
	public BannerContent fetchByBannerIdAndStatus_First(
		long bannerId, int status,
		OrderByComparator<BannerContent> orderByComparator) {

		List<BannerContent> list = findByBannerIdAndStatus(
			bannerId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last banner content in the ordered set where bannerId = &#63; and status = &#63;.
	 *
	 * @param bannerId the banner ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner content
	 * @throws NoSuchBannerContentException if a matching banner content could not be found
	 */
	@Override
	public BannerContent findByBannerIdAndStatus_Last(
			long bannerId, int status,
			OrderByComparator<BannerContent> orderByComparator)
		throws NoSuchBannerContentException {

		BannerContent bannerContent = fetchByBannerIdAndStatus_Last(
			bannerId, status, orderByComparator);

		if (bannerContent != null) {
			return bannerContent;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("bannerId=");
		sb.append(bannerId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchBannerContentException(sb.toString());
	}

	/**
	 * Returns the last banner content in the ordered set where bannerId = &#63; and status = &#63;.
	 *
	 * @param bannerId the banner ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner content, or <code>null</code> if a matching banner content could not be found
	 */
	@Override
	public BannerContent fetchByBannerIdAndStatus_Last(
		long bannerId, int status,
		OrderByComparator<BannerContent> orderByComparator) {

		int count = countByBannerIdAndStatus(bannerId, status);

		if (count == 0) {
			return null;
		}

		List<BannerContent> list = findByBannerIdAndStatus(
			bannerId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the banner contents before and after the current banner content in the ordered set where bannerId = &#63; and status = &#63;.
	 *
	 * @param contentId the primary key of the current banner content
	 * @param bannerId the banner ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next banner content
	 * @throws NoSuchBannerContentException if a banner content with the primary key could not be found
	 */
	@Override
	public BannerContent[] findByBannerIdAndStatus_PrevAndNext(
			long contentId, long bannerId, int status,
			OrderByComparator<BannerContent> orderByComparator)
		throws NoSuchBannerContentException {

		BannerContent bannerContent = findByPrimaryKey(contentId);

		Session session = null;

		try {
			session = openSession();

			BannerContent[] array = new BannerContentImpl[3];

			array[0] = getByBannerIdAndStatus_PrevAndNext(
				session, bannerContent, bannerId, status, orderByComparator,
				true);

			array[1] = bannerContent;

			array[2] = getByBannerIdAndStatus_PrevAndNext(
				session, bannerContent, bannerId, status, orderByComparator,
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

	protected BannerContent getByBannerIdAndStatus_PrevAndNext(
		Session session, BannerContent bannerContent, long bannerId, int status,
		OrderByComparator<BannerContent> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_BANNERCONTENT_WHERE);

		sb.append(_FINDER_COLUMN_BANNERIDANDSTATUS_BANNERID_2);

		sb.append(_FINDER_COLUMN_BANNERIDANDSTATUS_STATUS_2);

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
			sb.append(BannerContentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(bannerId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						bannerContent)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BannerContent> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the banner contents where bannerId = &#63; and status = &#63; from the database.
	 *
	 * @param bannerId the banner ID
	 * @param status the status
	 */
	@Override
	public void removeByBannerIdAndStatus(long bannerId, int status) {
		for (BannerContent bannerContent :
				findByBannerIdAndStatus(
					bannerId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(bannerContent);
		}
	}

	/**
	 * Returns the number of banner contents where bannerId = &#63; and status = &#63;.
	 *
	 * @param bannerId the banner ID
	 * @param status the status
	 * @return the number of matching banner contents
	 */
	@Override
	public int countByBannerIdAndStatus(long bannerId, int status) {
		FinderPath finderPath = _finderPathCountByBannerIdAndStatus;

		Object[] finderArgs = new Object[] {bannerId, status};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_BANNERCONTENT_WHERE);

			sb.append(_FINDER_COLUMN_BANNERIDANDSTATUS_BANNERID_2);

			sb.append(_FINDER_COLUMN_BANNERIDANDSTATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(bannerId);

				queryPos.add(status);

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

	private static final String _FINDER_COLUMN_BANNERIDANDSTATUS_BANNERID_2 =
		"bannerContent.bannerId = ? AND ";

	private static final String _FINDER_COLUMN_BANNERIDANDSTATUS_STATUS_2 =
		"bannerContent.status = ?";

	private FinderPath _finderPathWithPaginationFindByChannelId;
	private FinderPath _finderPathWithoutPaginationFindByChannelId;
	private FinderPath _finderPathCountByChannelId;

	/**
	 * Returns all the banner contents where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the matching banner contents
	 */
	@Override
	public List<BannerContent> findByChannelId(long channelId) {
		return findByChannelId(
			channelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the banner contents where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @return the range of matching banner contents
	 */
	@Override
	public List<BannerContent> findByChannelId(
		long channelId, int start, int end) {

		return findByChannelId(channelId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the banner contents where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching banner contents
	 */
	@Override
	public List<BannerContent> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<BannerContent> orderByComparator) {

		return findByChannelId(channelId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the banner contents where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching banner contents
	 */
	@Override
	public List<BannerContent> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<BannerContent> orderByComparator,
		boolean useFinderCache) {

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

		List<BannerContent> list = null;

		if (useFinderCache) {
			list = (List<BannerContent>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BannerContent bannerContent : list) {
					if (channelId != bannerContent.getChannelId()) {
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

			sb.append(_SQL_SELECT_BANNERCONTENT_WHERE);

			sb.append(_FINDER_COLUMN_CHANNELID_CHANNELID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BannerContentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				list = (List<BannerContent>)QueryUtil.list(
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
	 * Returns the first banner content in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner content
	 * @throws NoSuchBannerContentException if a matching banner content could not be found
	 */
	@Override
	public BannerContent findByChannelId_First(
			long channelId, OrderByComparator<BannerContent> orderByComparator)
		throws NoSuchBannerContentException {

		BannerContent bannerContent = fetchByChannelId_First(
			channelId, orderByComparator);

		if (bannerContent != null) {
			return bannerContent;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append("}");

		throw new NoSuchBannerContentException(sb.toString());
	}

	/**
	 * Returns the first banner content in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner content, or <code>null</code> if a matching banner content could not be found
	 */
	@Override
	public BannerContent fetchByChannelId_First(
		long channelId, OrderByComparator<BannerContent> orderByComparator) {

		List<BannerContent> list = findByChannelId(
			channelId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last banner content in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner content
	 * @throws NoSuchBannerContentException if a matching banner content could not be found
	 */
	@Override
	public BannerContent findByChannelId_Last(
			long channelId, OrderByComparator<BannerContent> orderByComparator)
		throws NoSuchBannerContentException {

		BannerContent bannerContent = fetchByChannelId_Last(
			channelId, orderByComparator);

		if (bannerContent != null) {
			return bannerContent;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append("}");

		throw new NoSuchBannerContentException(sb.toString());
	}

	/**
	 * Returns the last banner content in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner content, or <code>null</code> if a matching banner content could not be found
	 */
	@Override
	public BannerContent fetchByChannelId_Last(
		long channelId, OrderByComparator<BannerContent> orderByComparator) {

		int count = countByChannelId(channelId);

		if (count == 0) {
			return null;
		}

		List<BannerContent> list = findByChannelId(
			channelId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the banner contents before and after the current banner content in the ordered set where channelId = &#63;.
	 *
	 * @param contentId the primary key of the current banner content
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next banner content
	 * @throws NoSuchBannerContentException if a banner content with the primary key could not be found
	 */
	@Override
	public BannerContent[] findByChannelId_PrevAndNext(
			long contentId, long channelId,
			OrderByComparator<BannerContent> orderByComparator)
		throws NoSuchBannerContentException {

		BannerContent bannerContent = findByPrimaryKey(contentId);

		Session session = null;

		try {
			session = openSession();

			BannerContent[] array = new BannerContentImpl[3];

			array[0] = getByChannelId_PrevAndNext(
				session, bannerContent, channelId, orderByComparator, true);

			array[1] = bannerContent;

			array[2] = getByChannelId_PrevAndNext(
				session, bannerContent, channelId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected BannerContent getByChannelId_PrevAndNext(
		Session session, BannerContent bannerContent, long channelId,
		OrderByComparator<BannerContent> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BANNERCONTENT_WHERE);

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
			sb.append(BannerContentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(channelId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						bannerContent)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BannerContent> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the banner contents where channelId = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 */
	@Override
	public void removeByChannelId(long channelId) {
		for (BannerContent bannerContent :
				findByChannelId(
					channelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(bannerContent);
		}
	}

	/**
	 * Returns the number of banner contents where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the number of matching banner contents
	 */
	@Override
	public int countByChannelId(long channelId) {
		FinderPath finderPath = _finderPathCountByChannelId;

		Object[] finderArgs = new Object[] {channelId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BANNERCONTENT_WHERE);

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
		"bannerContent.channelId = ?";

	public BannerContentPersistenceImpl() {
		setModelClass(BannerContent.class);

		setModelImplClass(BannerContentImpl.class);
		setModelPKClass(long.class);

		setTable(BannerContentTable.INSTANCE);
	}

	/**
	 * Caches the banner content in the entity cache if it is enabled.
	 *
	 * @param bannerContent the banner content
	 */
	@Override
	public void cacheResult(BannerContent bannerContent) {
		dummyEntityCache.putResult(
			BannerContentImpl.class, bannerContent.getPrimaryKey(),
			bannerContent);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the banner contents in the entity cache if it is enabled.
	 *
	 * @param bannerContents the banner contents
	 */
	@Override
	public void cacheResult(List<BannerContent> bannerContents) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (bannerContents.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (BannerContent bannerContent : bannerContents) {
			if (dummyEntityCache.getResult(
					BannerContentImpl.class, bannerContent.getPrimaryKey()) ==
						null) {

				cacheResult(bannerContent);
			}
		}
	}

	/**
	 * Clears the cache for all banner contents.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(BannerContentImpl.class);

		dummyFinderCache.clearCache(BannerContentImpl.class);
	}

	/**
	 * Clears the cache for the banner content.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BannerContent bannerContent) {
		dummyEntityCache.removeResult(BannerContentImpl.class, bannerContent);
	}

	@Override
	public void clearCache(List<BannerContent> bannerContents) {
		for (BannerContent bannerContent : bannerContents) {
			dummyEntityCache.removeResult(
				BannerContentImpl.class, bannerContent);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(BannerContentImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(BannerContentImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new banner content with the primary key. Does not add the banner content to the database.
	 *
	 * @param contentId the primary key for the new banner content
	 * @return the new banner content
	 */
	@Override
	public BannerContent create(long contentId) {
		BannerContent bannerContent = new BannerContentImpl();

		bannerContent.setNew(true);
		bannerContent.setPrimaryKey(contentId);

		return bannerContent;
	}

	/**
	 * Removes the banner content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contentId the primary key of the banner content
	 * @return the banner content that was removed
	 * @throws NoSuchBannerContentException if a banner content with the primary key could not be found
	 */
	@Override
	public BannerContent remove(long contentId)
		throws NoSuchBannerContentException {

		return remove((Serializable)contentId);
	}

	/**
	 * Removes the banner content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the banner content
	 * @return the banner content that was removed
	 * @throws NoSuchBannerContentException if a banner content with the primary key could not be found
	 */
	@Override
	public BannerContent remove(Serializable primaryKey)
		throws NoSuchBannerContentException {

		Session session = null;

		try {
			session = openSession();

			BannerContent bannerContent = (BannerContent)session.get(
				BannerContentImpl.class, primaryKey);

			if (bannerContent == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBannerContentException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(bannerContent);
		}
		catch (NoSuchBannerContentException noSuchEntityException) {
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
	protected BannerContent removeImpl(BannerContent bannerContent) {
		bannerContentLocalizationPersistence.removeByContentId(
			bannerContent.getContentId());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bannerContent)) {
				bannerContent = (BannerContent)session.get(
					BannerContentImpl.class, bannerContent.getPrimaryKeyObj());
			}

			if (bannerContent != null) {
				session.delete(bannerContent);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (bannerContent != null) {
			clearCache(bannerContent);
		}

		return bannerContent;
	}

	@Override
	public BannerContent updateImpl(BannerContent bannerContent) {
		boolean isNew = bannerContent.isNew();

		if (!(bannerContent instanceof BannerContentModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(bannerContent.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					bannerContent);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in bannerContent proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom BannerContent implementation " +
					bannerContent.getClass());
		}

		BannerContentModelImpl bannerContentModelImpl =
			(BannerContentModelImpl)bannerContent;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(bannerContent);
			}
			else {
				bannerContent = (BannerContent)session.merge(bannerContent);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			BannerContentImpl.class, bannerContentModelImpl, false, true);

		if (isNew) {
			bannerContent.setNew(false);
		}

		bannerContent.resetOriginalValues();

		return bannerContent;
	}

	/**
	 * Returns the banner content with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the banner content
	 * @return the banner content
	 * @throws NoSuchBannerContentException if a banner content with the primary key could not be found
	 */
	@Override
	public BannerContent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBannerContentException {

		BannerContent bannerContent = fetchByPrimaryKey(primaryKey);

		if (bannerContent == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBannerContentException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return bannerContent;
	}

	/**
	 * Returns the banner content with the primary key or throws a <code>NoSuchBannerContentException</code> if it could not be found.
	 *
	 * @param contentId the primary key of the banner content
	 * @return the banner content
	 * @throws NoSuchBannerContentException if a banner content with the primary key could not be found
	 */
	@Override
	public BannerContent findByPrimaryKey(long contentId)
		throws NoSuchBannerContentException {

		return findByPrimaryKey((Serializable)contentId);
	}

	/**
	 * Returns the banner content with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contentId the primary key of the banner content
	 * @return the banner content, or <code>null</code> if a banner content with the primary key could not be found
	 */
	@Override
	public BannerContent fetchByPrimaryKey(long contentId) {
		return fetchByPrimaryKey((Serializable)contentId);
	}

	/**
	 * Returns all the banner contents.
	 *
	 * @return the banner contents
	 */
	@Override
	public List<BannerContent> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the banner contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @return the range of banner contents
	 */
	@Override
	public List<BannerContent> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the banner contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of banner contents
	 */
	@Override
	public List<BannerContent> findAll(
		int start, int end,
		OrderByComparator<BannerContent> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the banner contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of banner contents
	 */
	@Override
	public List<BannerContent> findAll(
		int start, int end, OrderByComparator<BannerContent> orderByComparator,
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

		List<BannerContent> list = null;

		if (useFinderCache) {
			list = (List<BannerContent>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BANNERCONTENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BANNERCONTENT;

				sql = sql.concat(BannerContentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<BannerContent>)QueryUtil.list(
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
	 * Removes all the banner contents from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BannerContent bannerContent : findAll()) {
			remove(bannerContent);
		}
	}

	/**
	 * Returns the number of banner contents.
	 *
	 * @return the number of banner contents
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_BANNERCONTENT);

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
		return "contentId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_BANNERCONTENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BannerContentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the banner content persistence.
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

		_finderPathWithPaginationFindByBannerId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBannerId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"bannerId"}, true);

		_finderPathWithoutPaginationFindByBannerId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBannerId",
			new String[] {Long.class.getName()}, new String[] {"bannerId"},
			true);

		_finderPathCountByBannerId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBannerId",
			new String[] {Long.class.getName()}, new String[] {"bannerId"},
			false);

		_finderPathWithPaginationFindByEntityResourceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEntityResourceId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"entityResourceId"}, true);

		_finderPathWithoutPaginationFindByEntityResourceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEntityResourceId",
			new String[] {Long.class.getName()},
			new String[] {"entityResourceId"}, true);

		_finderPathCountByEntityResourceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEntityResourceId", new String[] {Long.class.getName()},
			new String[] {"entityResourceId"}, false);

		_finderPathWithPaginationFindByBannerIdAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBannerIdAndStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"bannerId", "status"}, true);

		_finderPathWithoutPaginationFindByBannerIdAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByBannerIdAndStatus",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"bannerId", "status"}, true);

		_finderPathCountByBannerIdAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByBannerIdAndStatus",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"bannerId", "status"}, false);

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

		BannerContentUtil.setPersistence(this);
	}

	public void destroy() {
		BannerContentUtil.setPersistence(null);

		dummyEntityCache.removeCache(BannerContentImpl.class.getName());
	}

	@BeanReference(type = BannerContentLocalizationPersistence.class)
	protected BannerContentLocalizationPersistence
		bannerContentLocalizationPersistence;

	private static final String _SQL_SELECT_BANNERCONTENT =
		"SELECT bannerContent FROM BannerContent bannerContent";

	private static final String _SQL_SELECT_BANNERCONTENT_WHERE =
		"SELECT bannerContent FROM BannerContent bannerContent WHERE ";

	private static final String _SQL_COUNT_BANNERCONTENT =
		"SELECT COUNT(bannerContent) FROM BannerContent bannerContent";

	private static final String _SQL_COUNT_BANNERCONTENT_WHERE =
		"SELECT COUNT(bannerContent) FROM BannerContent bannerContent WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "bannerContent.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No BannerContent exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No BannerContent exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BannerContentPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}