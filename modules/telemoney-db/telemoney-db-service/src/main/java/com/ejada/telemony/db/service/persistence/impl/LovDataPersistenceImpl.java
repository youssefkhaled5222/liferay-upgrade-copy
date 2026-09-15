/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence.impl;

import com.ejada.telemony.db.exception.NoSuchLovDataException;
import com.ejada.telemony.db.model.LovData;
import com.ejada.telemony.db.model.LovDataTable;
import com.ejada.telemony.db.model.impl.LovDataImpl;
import com.ejada.telemony.db.model.impl.LovDataModelImpl;
import com.ejada.telemony.db.service.persistence.LovDataLocalizationPersistence;
import com.ejada.telemony.db.service.persistence.LovDataPersistence;
import com.ejada.telemony.db.service.persistence.LovDataUtil;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the lov data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LovDataPersistenceImpl
	extends BasePersistenceImpl<LovData> implements LovDataPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LovDataUtil</code> to access the lov data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LovDataImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByLovdata;
	private FinderPath _finderPathWithoutPaginationFindByLovdata;
	private FinderPath _finderPathCountByLovdata;

	/**
	 * Returns all the lov datas where lovId = &#63;.
	 *
	 * @param lovId the lov ID
	 * @return the matching lov datas
	 */
	@Override
	public List<LovData> findByLovdata(long lovId) {
		return findByLovdata(lovId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lov datas where lovId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataModelImpl</code>.
	 * </p>
	 *
	 * @param lovId the lov ID
	 * @param start the lower bound of the range of lov datas
	 * @param end the upper bound of the range of lov datas (not inclusive)
	 * @return the range of matching lov datas
	 */
	@Override
	public List<LovData> findByLovdata(long lovId, int start, int end) {
		return findByLovdata(lovId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lov datas where lovId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataModelImpl</code>.
	 * </p>
	 *
	 * @param lovId the lov ID
	 * @param start the lower bound of the range of lov datas
	 * @param end the upper bound of the range of lov datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lov datas
	 */
	@Override
	public List<LovData> findByLovdata(
		long lovId, int start, int end,
		OrderByComparator<LovData> orderByComparator) {

		return findByLovdata(lovId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lov datas where lovId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataModelImpl</code>.
	 * </p>
	 *
	 * @param lovId the lov ID
	 * @param start the lower bound of the range of lov datas
	 * @param end the upper bound of the range of lov datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lov datas
	 */
	@Override
	public List<LovData> findByLovdata(
		long lovId, int start, int end,
		OrderByComparator<LovData> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByLovdata;
				finderArgs = new Object[] {lovId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByLovdata;
			finderArgs = new Object[] {lovId, start, end, orderByComparator};
		}

		List<LovData> list = null;

		if (useFinderCache) {
			list = (List<LovData>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LovData lovData : list) {
					if (lovId != lovData.getLovId()) {
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

			sb.append(_SQL_SELECT_LOVDATA_WHERE);

			sb.append(_FINDER_COLUMN_LOVDATA_LOVID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LovDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(lovId);

				list = (List<LovData>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
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
	 * Returns the first lov data in the ordered set where lovId = &#63;.
	 *
	 * @param lovId the lov ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data
	 * @throws NoSuchLovDataException if a matching lov data could not be found
	 */
	@Override
	public LovData findByLovdata_First(
			long lovId, OrderByComparator<LovData> orderByComparator)
		throws NoSuchLovDataException {

		LovData lovData = fetchByLovdata_First(lovId, orderByComparator);

		if (lovData != null) {
			return lovData;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("lovId=");
		sb.append(lovId);

		sb.append("}");

		throw new NoSuchLovDataException(sb.toString());
	}

	/**
	 * Returns the first lov data in the ordered set where lovId = &#63;.
	 *
	 * @param lovId the lov ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data, or <code>null</code> if a matching lov data could not be found
	 */
	@Override
	public LovData fetchByLovdata_First(
		long lovId, OrderByComparator<LovData> orderByComparator) {

		List<LovData> list = findByLovdata(lovId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lov data in the ordered set where lovId = &#63;.
	 *
	 * @param lovId the lov ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data
	 * @throws NoSuchLovDataException if a matching lov data could not be found
	 */
	@Override
	public LovData findByLovdata_Last(
			long lovId, OrderByComparator<LovData> orderByComparator)
		throws NoSuchLovDataException {

		LovData lovData = fetchByLovdata_Last(lovId, orderByComparator);

		if (lovData != null) {
			return lovData;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("lovId=");
		sb.append(lovId);

		sb.append("}");

		throw new NoSuchLovDataException(sb.toString());
	}

	/**
	 * Returns the last lov data in the ordered set where lovId = &#63;.
	 *
	 * @param lovId the lov ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data, or <code>null</code> if a matching lov data could not be found
	 */
	@Override
	public LovData fetchByLovdata_Last(
		long lovId, OrderByComparator<LovData> orderByComparator) {

		int count = countByLovdata(lovId);

		if (count == 0) {
			return null;
		}

		List<LovData> list = findByLovdata(
			lovId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lov datas before and after the current lov data in the ordered set where lovId = &#63;.
	 *
	 * @param id the primary key of the current lov data
	 * @param lovId the lov ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lov data
	 * @throws NoSuchLovDataException if a lov data with the primary key could not be found
	 */
	@Override
	public LovData[] findByLovdata_PrevAndNext(
			long id, long lovId, OrderByComparator<LovData> orderByComparator)
		throws NoSuchLovDataException {

		LovData lovData = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			LovData[] array = new LovDataImpl[3];

			array[0] = getByLovdata_PrevAndNext(
				session, lovData, lovId, orderByComparator, true);

			array[1] = lovData;

			array[2] = getByLovdata_PrevAndNext(
				session, lovData, lovId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LovData getByLovdata_PrevAndNext(
		Session session, LovData lovData, long lovId,
		OrderByComparator<LovData> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LOVDATA_WHERE);

		sb.append(_FINDER_COLUMN_LOVDATA_LOVID_2);

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
			sb.append(LovDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(lovId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(lovData)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LovData> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lov datas where lovId = &#63; from the database.
	 *
	 * @param lovId the lov ID
	 */
	@Override
	public void removeByLovdata(long lovId) {
		for (LovData lovData :
				findByLovdata(
					lovId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(lovData);
		}
	}

	/**
	 * Returns the number of lov datas where lovId = &#63;.
	 *
	 * @param lovId the lov ID
	 * @return the number of matching lov datas
	 */
	@Override
	public int countByLovdata(long lovId) {
		FinderPath finderPath = _finderPathCountByLovdata;

		Object[] finderArgs = new Object[] {lovId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LOVDATA_WHERE);

			sb.append(_FINDER_COLUMN_LOVDATA_LOVID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(lovId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
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

	private static final String _FINDER_COLUMN_LOVDATA_LOVID_2 =
		"lovData.lovId = ?";

	private FinderPath
		_finderPathWithPaginationFindBylovIdAndRecordShortDescription;
	private FinderPath
		_finderPathWithoutPaginationFindBylovIdAndRecordShortDescription;
	private FinderPath _finderPathCountBylovIdAndRecordShortDescription;

	/**
	 * Returns all the lov datas where lovId = &#63; and recordShortDescription = &#63;.
	 *
	 * @param lovId the lov ID
	 * @param recordShortDescription the record short description
	 * @return the matching lov datas
	 */
	@Override
	public List<LovData> findBylovIdAndRecordShortDescription(
		long lovId, String recordShortDescription) {

		return findBylovIdAndRecordShortDescription(
			lovId, recordShortDescription, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the lov datas where lovId = &#63; and recordShortDescription = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataModelImpl</code>.
	 * </p>
	 *
	 * @param lovId the lov ID
	 * @param recordShortDescription the record short description
	 * @param start the lower bound of the range of lov datas
	 * @param end the upper bound of the range of lov datas (not inclusive)
	 * @return the range of matching lov datas
	 */
	@Override
	public List<LovData> findBylovIdAndRecordShortDescription(
		long lovId, String recordShortDescription, int start, int end) {

		return findBylovIdAndRecordShortDescription(
			lovId, recordShortDescription, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lov datas where lovId = &#63; and recordShortDescription = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataModelImpl</code>.
	 * </p>
	 *
	 * @param lovId the lov ID
	 * @param recordShortDescription the record short description
	 * @param start the lower bound of the range of lov datas
	 * @param end the upper bound of the range of lov datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lov datas
	 */
	@Override
	public List<LovData> findBylovIdAndRecordShortDescription(
		long lovId, String recordShortDescription, int start, int end,
		OrderByComparator<LovData> orderByComparator) {

		return findBylovIdAndRecordShortDescription(
			lovId, recordShortDescription, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lov datas where lovId = &#63; and recordShortDescription = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataModelImpl</code>.
	 * </p>
	 *
	 * @param lovId the lov ID
	 * @param recordShortDescription the record short description
	 * @param start the lower bound of the range of lov datas
	 * @param end the upper bound of the range of lov datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lov datas
	 */
	@Override
	public List<LovData> findBylovIdAndRecordShortDescription(
		long lovId, String recordShortDescription, int start, int end,
		OrderByComparator<LovData> orderByComparator, boolean useFinderCache) {

		recordShortDescription = Objects.toString(recordShortDescription, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBylovIdAndRecordShortDescription;
				finderArgs = new Object[] {lovId, recordShortDescription};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindBylovIdAndRecordShortDescription;
			finderArgs = new Object[] {
				lovId, recordShortDescription, start, end, orderByComparator
			};
		}

		List<LovData> list = null;

		if (useFinderCache) {
			list = (List<LovData>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LovData lovData : list) {
					if ((lovId != lovData.getLovId()) ||
						!recordShortDescription.equals(
							lovData.getRecordShortDescription())) {

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

			sb.append(_SQL_SELECT_LOVDATA_WHERE);

			sb.append(_FINDER_COLUMN_LOVIDANDRECORDSHORTDESCRIPTION_LOVID_2);

			boolean bindRecordShortDescription = false;

			if (recordShortDescription.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_LOVIDANDRECORDSHORTDESCRIPTION_RECORDSHORTDESCRIPTION_3);
			}
			else {
				bindRecordShortDescription = true;

				sb.append(
					_FINDER_COLUMN_LOVIDANDRECORDSHORTDESCRIPTION_RECORDSHORTDESCRIPTION_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LovDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(lovId);

				if (bindRecordShortDescription) {
					queryPos.add(recordShortDescription);
				}

				list = (List<LovData>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
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
	 * Returns the first lov data in the ordered set where lovId = &#63; and recordShortDescription = &#63;.
	 *
	 * @param lovId the lov ID
	 * @param recordShortDescription the record short description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data
	 * @throws NoSuchLovDataException if a matching lov data could not be found
	 */
	@Override
	public LovData findBylovIdAndRecordShortDescription_First(
			long lovId, String recordShortDescription,
			OrderByComparator<LovData> orderByComparator)
		throws NoSuchLovDataException {

		LovData lovData = fetchBylovIdAndRecordShortDescription_First(
			lovId, recordShortDescription, orderByComparator);

		if (lovData != null) {
			return lovData;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("lovId=");
		sb.append(lovId);

		sb.append(", recordShortDescription=");
		sb.append(recordShortDescription);

		sb.append("}");

		throw new NoSuchLovDataException(sb.toString());
	}

	/**
	 * Returns the first lov data in the ordered set where lovId = &#63; and recordShortDescription = &#63;.
	 *
	 * @param lovId the lov ID
	 * @param recordShortDescription the record short description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data, or <code>null</code> if a matching lov data could not be found
	 */
	@Override
	public LovData fetchBylovIdAndRecordShortDescription_First(
		long lovId, String recordShortDescription,
		OrderByComparator<LovData> orderByComparator) {

		List<LovData> list = findBylovIdAndRecordShortDescription(
			lovId, recordShortDescription, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lov data in the ordered set where lovId = &#63; and recordShortDescription = &#63;.
	 *
	 * @param lovId the lov ID
	 * @param recordShortDescription the record short description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data
	 * @throws NoSuchLovDataException if a matching lov data could not be found
	 */
	@Override
	public LovData findBylovIdAndRecordShortDescription_Last(
			long lovId, String recordShortDescription,
			OrderByComparator<LovData> orderByComparator)
		throws NoSuchLovDataException {

		LovData lovData = fetchBylovIdAndRecordShortDescription_Last(
			lovId, recordShortDescription, orderByComparator);

		if (lovData != null) {
			return lovData;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("lovId=");
		sb.append(lovId);

		sb.append(", recordShortDescription=");
		sb.append(recordShortDescription);

		sb.append("}");

		throw new NoSuchLovDataException(sb.toString());
	}

	/**
	 * Returns the last lov data in the ordered set where lovId = &#63; and recordShortDescription = &#63;.
	 *
	 * @param lovId the lov ID
	 * @param recordShortDescription the record short description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data, or <code>null</code> if a matching lov data could not be found
	 */
	@Override
	public LovData fetchBylovIdAndRecordShortDescription_Last(
		long lovId, String recordShortDescription,
		OrderByComparator<LovData> orderByComparator) {

		int count = countBylovIdAndRecordShortDescription(
			lovId, recordShortDescription);

		if (count == 0) {
			return null;
		}

		List<LovData> list = findBylovIdAndRecordShortDescription(
			lovId, recordShortDescription, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lov datas before and after the current lov data in the ordered set where lovId = &#63; and recordShortDescription = &#63;.
	 *
	 * @param id the primary key of the current lov data
	 * @param lovId the lov ID
	 * @param recordShortDescription the record short description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lov data
	 * @throws NoSuchLovDataException if a lov data with the primary key could not be found
	 */
	@Override
	public LovData[] findBylovIdAndRecordShortDescription_PrevAndNext(
			long id, long lovId, String recordShortDescription,
			OrderByComparator<LovData> orderByComparator)
		throws NoSuchLovDataException {

		recordShortDescription = Objects.toString(recordShortDescription, "");

		LovData lovData = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			LovData[] array = new LovDataImpl[3];

			array[0] = getBylovIdAndRecordShortDescription_PrevAndNext(
				session, lovData, lovId, recordShortDescription,
				orderByComparator, true);

			array[1] = lovData;

			array[2] = getBylovIdAndRecordShortDescription_PrevAndNext(
				session, lovData, lovId, recordShortDescription,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LovData getBylovIdAndRecordShortDescription_PrevAndNext(
		Session session, LovData lovData, long lovId,
		String recordShortDescription,
		OrderByComparator<LovData> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_LOVDATA_WHERE);

		sb.append(_FINDER_COLUMN_LOVIDANDRECORDSHORTDESCRIPTION_LOVID_2);

		boolean bindRecordShortDescription = false;

		if (recordShortDescription.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_LOVIDANDRECORDSHORTDESCRIPTION_RECORDSHORTDESCRIPTION_3);
		}
		else {
			bindRecordShortDescription = true;

			sb.append(
				_FINDER_COLUMN_LOVIDANDRECORDSHORTDESCRIPTION_RECORDSHORTDESCRIPTION_2);
		}

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
			sb.append(LovDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(lovId);

		if (bindRecordShortDescription) {
			queryPos.add(recordShortDescription);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(lovData)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LovData> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lov datas where lovId = &#63; and recordShortDescription = &#63; from the database.
	 *
	 * @param lovId the lov ID
	 * @param recordShortDescription the record short description
	 */
	@Override
	public void removeBylovIdAndRecordShortDescription(
		long lovId, String recordShortDescription) {

		for (LovData lovData :
				findBylovIdAndRecordShortDescription(
					lovId, recordShortDescription, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(lovData);
		}
	}

	/**
	 * Returns the number of lov datas where lovId = &#63; and recordShortDescription = &#63;.
	 *
	 * @param lovId the lov ID
	 * @param recordShortDescription the record short description
	 * @return the number of matching lov datas
	 */
	@Override
	public int countBylovIdAndRecordShortDescription(
		long lovId, String recordShortDescription) {

		recordShortDescription = Objects.toString(recordShortDescription, "");

		FinderPath finderPath =
			_finderPathCountBylovIdAndRecordShortDescription;

		Object[] finderArgs = new Object[] {lovId, recordShortDescription};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LOVDATA_WHERE);

			sb.append(_FINDER_COLUMN_LOVIDANDRECORDSHORTDESCRIPTION_LOVID_2);

			boolean bindRecordShortDescription = false;

			if (recordShortDescription.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_LOVIDANDRECORDSHORTDESCRIPTION_RECORDSHORTDESCRIPTION_3);
			}
			else {
				bindRecordShortDescription = true;

				sb.append(
					_FINDER_COLUMN_LOVIDANDRECORDSHORTDESCRIPTION_RECORDSHORTDESCRIPTION_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(lovId);

				if (bindRecordShortDescription) {
					queryPos.add(recordShortDescription);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
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
		_FINDER_COLUMN_LOVIDANDRECORDSHORTDESCRIPTION_LOVID_2 =
			"lovData.lovId = ? AND ";

	private static final String
		_FINDER_COLUMN_LOVIDANDRECORDSHORTDESCRIPTION_RECORDSHORTDESCRIPTION_2 =
			"lovData.recordShortDescription = ?";

	private static final String
		_FINDER_COLUMN_LOVIDANDRECORDSHORTDESCRIPTION_RECORDSHORTDESCRIPTION_3 =
			"(lovData.recordShortDescription IS NULL OR lovData.recordShortDescription = '')";

	private FinderPath
		_finderPathWithPaginationFindByDataTypeCodeAndLovCodeAndStatus;
	private FinderPath
		_finderPathWithoutPaginationFindByDataTypeCodeAndLovCodeAndStatus;
	private FinderPath _finderPathCountByDataTypeCodeAndLovCodeAndStatus;

	/**
	 * Returns all the lov datas where lovType = &#63; and recordTypeCode = &#63; and entityResourceId = &#63; and status = &#63;.
	 *
	 * @param lovType the lov type
	 * @param recordTypeCode the record type code
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @return the matching lov datas
	 */
	@Override
	public List<LovData> findByDataTypeCodeAndLovCodeAndStatus(
		String lovType, String recordTypeCode, long entityResourceId,
		int status) {

		return findByDataTypeCodeAndLovCodeAndStatus(
			lovType, recordTypeCode, entityResourceId, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lov datas where lovType = &#63; and recordTypeCode = &#63; and entityResourceId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataModelImpl</code>.
	 * </p>
	 *
	 * @param lovType the lov type
	 * @param recordTypeCode the record type code
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @param start the lower bound of the range of lov datas
	 * @param end the upper bound of the range of lov datas (not inclusive)
	 * @return the range of matching lov datas
	 */
	@Override
	public List<LovData> findByDataTypeCodeAndLovCodeAndStatus(
		String lovType, String recordTypeCode, long entityResourceId,
		int status, int start, int end) {

		return findByDataTypeCodeAndLovCodeAndStatus(
			lovType, recordTypeCode, entityResourceId, status, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the lov datas where lovType = &#63; and recordTypeCode = &#63; and entityResourceId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataModelImpl</code>.
	 * </p>
	 *
	 * @param lovType the lov type
	 * @param recordTypeCode the record type code
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @param start the lower bound of the range of lov datas
	 * @param end the upper bound of the range of lov datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lov datas
	 */
	@Override
	public List<LovData> findByDataTypeCodeAndLovCodeAndStatus(
		String lovType, String recordTypeCode, long entityResourceId,
		int status, int start, int end,
		OrderByComparator<LovData> orderByComparator) {

		return findByDataTypeCodeAndLovCodeAndStatus(
			lovType, recordTypeCode, entityResourceId, status, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lov datas where lovType = &#63; and recordTypeCode = &#63; and entityResourceId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataModelImpl</code>.
	 * </p>
	 *
	 * @param lovType the lov type
	 * @param recordTypeCode the record type code
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @param start the lower bound of the range of lov datas
	 * @param end the upper bound of the range of lov datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lov datas
	 */
	@Override
	public List<LovData> findByDataTypeCodeAndLovCodeAndStatus(
		String lovType, String recordTypeCode, long entityResourceId,
		int status, int start, int end,
		OrderByComparator<LovData> orderByComparator, boolean useFinderCache) {

		lovType = Objects.toString(lovType, "");
		recordTypeCode = Objects.toString(recordTypeCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByDataTypeCodeAndLovCodeAndStatus;
				finderArgs = new Object[] {
					lovType, recordTypeCode, entityResourceId, status
				};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByDataTypeCodeAndLovCodeAndStatus;
			finderArgs = new Object[] {
				lovType, recordTypeCode, entityResourceId, status, start, end,
				orderByComparator
			};
		}

		List<LovData> list = null;

		if (useFinderCache) {
			list = (List<LovData>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LovData lovData : list) {
					if (!lovType.equals(lovData.getLovType()) ||
						!recordTypeCode.equals(lovData.getRecordTypeCode()) ||
						(entityResourceId != lovData.getEntityResourceId()) ||
						(status != lovData.getStatus())) {

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
					6 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(6);
			}

			sb.append(_SQL_SELECT_LOVDATA_WHERE);

			boolean bindLovType = false;

			if (lovType.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DATATYPECODEANDLOVCODEANDSTATUS_LOVTYPE_3);
			}
			else {
				bindLovType = true;

				sb.append(
					_FINDER_COLUMN_DATATYPECODEANDLOVCODEANDSTATUS_LOVTYPE_2);
			}

			boolean bindRecordTypeCode = false;

			if (recordTypeCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DATATYPECODEANDLOVCODEANDSTATUS_RECORDTYPECODE_3);
			}
			else {
				bindRecordTypeCode = true;

				sb.append(
					_FINDER_COLUMN_DATATYPECODEANDLOVCODEANDSTATUS_RECORDTYPECODE_2);
			}

			sb.append(
				_FINDER_COLUMN_DATATYPECODEANDLOVCODEANDSTATUS_ENTITYRESOURCEID_2);

			sb.append(_FINDER_COLUMN_DATATYPECODEANDLOVCODEANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LovDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLovType) {
					queryPos.add(lovType);
				}

				if (bindRecordTypeCode) {
					queryPos.add(recordTypeCode);
				}

				queryPos.add(entityResourceId);

				queryPos.add(status);

				list = (List<LovData>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
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
	 * Returns the first lov data in the ordered set where lovType = &#63; and recordTypeCode = &#63; and entityResourceId = &#63; and status = &#63;.
	 *
	 * @param lovType the lov type
	 * @param recordTypeCode the record type code
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data
	 * @throws NoSuchLovDataException if a matching lov data could not be found
	 */
	@Override
	public LovData findByDataTypeCodeAndLovCodeAndStatus_First(
			String lovType, String recordTypeCode, long entityResourceId,
			int status, OrderByComparator<LovData> orderByComparator)
		throws NoSuchLovDataException {

		LovData lovData = fetchByDataTypeCodeAndLovCodeAndStatus_First(
			lovType, recordTypeCode, entityResourceId, status,
			orderByComparator);

		if (lovData != null) {
			return lovData;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("lovType=");
		sb.append(lovType);

		sb.append(", recordTypeCode=");
		sb.append(recordTypeCode);

		sb.append(", entityResourceId=");
		sb.append(entityResourceId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchLovDataException(sb.toString());
	}

	/**
	 * Returns the first lov data in the ordered set where lovType = &#63; and recordTypeCode = &#63; and entityResourceId = &#63; and status = &#63;.
	 *
	 * @param lovType the lov type
	 * @param recordTypeCode the record type code
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data, or <code>null</code> if a matching lov data could not be found
	 */
	@Override
	public LovData fetchByDataTypeCodeAndLovCodeAndStatus_First(
		String lovType, String recordTypeCode, long entityResourceId,
		int status, OrderByComparator<LovData> orderByComparator) {

		List<LovData> list = findByDataTypeCodeAndLovCodeAndStatus(
			lovType, recordTypeCode, entityResourceId, status, 0, 1,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lov data in the ordered set where lovType = &#63; and recordTypeCode = &#63; and entityResourceId = &#63; and status = &#63;.
	 *
	 * @param lovType the lov type
	 * @param recordTypeCode the record type code
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data
	 * @throws NoSuchLovDataException if a matching lov data could not be found
	 */
	@Override
	public LovData findByDataTypeCodeAndLovCodeAndStatus_Last(
			String lovType, String recordTypeCode, long entityResourceId,
			int status, OrderByComparator<LovData> orderByComparator)
		throws NoSuchLovDataException {

		LovData lovData = fetchByDataTypeCodeAndLovCodeAndStatus_Last(
			lovType, recordTypeCode, entityResourceId, status,
			orderByComparator);

		if (lovData != null) {
			return lovData;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("lovType=");
		sb.append(lovType);

		sb.append(", recordTypeCode=");
		sb.append(recordTypeCode);

		sb.append(", entityResourceId=");
		sb.append(entityResourceId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchLovDataException(sb.toString());
	}

	/**
	 * Returns the last lov data in the ordered set where lovType = &#63; and recordTypeCode = &#63; and entityResourceId = &#63; and status = &#63;.
	 *
	 * @param lovType the lov type
	 * @param recordTypeCode the record type code
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data, or <code>null</code> if a matching lov data could not be found
	 */
	@Override
	public LovData fetchByDataTypeCodeAndLovCodeAndStatus_Last(
		String lovType, String recordTypeCode, long entityResourceId,
		int status, OrderByComparator<LovData> orderByComparator) {

		int count = countByDataTypeCodeAndLovCodeAndStatus(
			lovType, recordTypeCode, entityResourceId, status);

		if (count == 0) {
			return null;
		}

		List<LovData> list = findByDataTypeCodeAndLovCodeAndStatus(
			lovType, recordTypeCode, entityResourceId, status, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lov datas before and after the current lov data in the ordered set where lovType = &#63; and recordTypeCode = &#63; and entityResourceId = &#63; and status = &#63;.
	 *
	 * @param id the primary key of the current lov data
	 * @param lovType the lov type
	 * @param recordTypeCode the record type code
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lov data
	 * @throws NoSuchLovDataException if a lov data with the primary key could not be found
	 */
	@Override
	public LovData[] findByDataTypeCodeAndLovCodeAndStatus_PrevAndNext(
			long id, String lovType, String recordTypeCode,
			long entityResourceId, int status,
			OrderByComparator<LovData> orderByComparator)
		throws NoSuchLovDataException {

		lovType = Objects.toString(lovType, "");
		recordTypeCode = Objects.toString(recordTypeCode, "");

		LovData lovData = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			LovData[] array = new LovDataImpl[3];

			array[0] = getByDataTypeCodeAndLovCodeAndStatus_PrevAndNext(
				session, lovData, lovType, recordTypeCode, entityResourceId,
				status, orderByComparator, true);

			array[1] = lovData;

			array[2] = getByDataTypeCodeAndLovCodeAndStatus_PrevAndNext(
				session, lovData, lovType, recordTypeCode, entityResourceId,
				status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LovData getByDataTypeCodeAndLovCodeAndStatus_PrevAndNext(
		Session session, LovData lovData, String lovType, String recordTypeCode,
		long entityResourceId, int status,
		OrderByComparator<LovData> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(6);
		}

		sb.append(_SQL_SELECT_LOVDATA_WHERE);

		boolean bindLovType = false;

		if (lovType.isEmpty()) {
			sb.append(_FINDER_COLUMN_DATATYPECODEANDLOVCODEANDSTATUS_LOVTYPE_3);
		}
		else {
			bindLovType = true;

			sb.append(_FINDER_COLUMN_DATATYPECODEANDLOVCODEANDSTATUS_LOVTYPE_2);
		}

		boolean bindRecordTypeCode = false;

		if (recordTypeCode.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_DATATYPECODEANDLOVCODEANDSTATUS_RECORDTYPECODE_3);
		}
		else {
			bindRecordTypeCode = true;

			sb.append(
				_FINDER_COLUMN_DATATYPECODEANDLOVCODEANDSTATUS_RECORDTYPECODE_2);
		}

		sb.append(
			_FINDER_COLUMN_DATATYPECODEANDLOVCODEANDSTATUS_ENTITYRESOURCEID_2);

		sb.append(_FINDER_COLUMN_DATATYPECODEANDLOVCODEANDSTATUS_STATUS_2);

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
			sb.append(LovDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindLovType) {
			queryPos.add(lovType);
		}

		if (bindRecordTypeCode) {
			queryPos.add(recordTypeCode);
		}

		queryPos.add(entityResourceId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(lovData)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LovData> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lov datas where lovType = &#63; and recordTypeCode = &#63; and entityResourceId = &#63; and status = &#63; from the database.
	 *
	 * @param lovType the lov type
	 * @param recordTypeCode the record type code
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 */
	@Override
	public void removeByDataTypeCodeAndLovCodeAndStatus(
		String lovType, String recordTypeCode, long entityResourceId,
		int status) {

		for (LovData lovData :
				findByDataTypeCodeAndLovCodeAndStatus(
					lovType, recordTypeCode, entityResourceId, status,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(lovData);
		}
	}

	/**
	 * Returns the number of lov datas where lovType = &#63; and recordTypeCode = &#63; and entityResourceId = &#63; and status = &#63;.
	 *
	 * @param lovType the lov type
	 * @param recordTypeCode the record type code
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @return the number of matching lov datas
	 */
	@Override
	public int countByDataTypeCodeAndLovCodeAndStatus(
		String lovType, String recordTypeCode, long entityResourceId,
		int status) {

		lovType = Objects.toString(lovType, "");
		recordTypeCode = Objects.toString(recordTypeCode, "");

		FinderPath finderPath =
			_finderPathCountByDataTypeCodeAndLovCodeAndStatus;

		Object[] finderArgs = new Object[] {
			lovType, recordTypeCode, entityResourceId, status
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_LOVDATA_WHERE);

			boolean bindLovType = false;

			if (lovType.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DATATYPECODEANDLOVCODEANDSTATUS_LOVTYPE_3);
			}
			else {
				bindLovType = true;

				sb.append(
					_FINDER_COLUMN_DATATYPECODEANDLOVCODEANDSTATUS_LOVTYPE_2);
			}

			boolean bindRecordTypeCode = false;

			if (recordTypeCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DATATYPECODEANDLOVCODEANDSTATUS_RECORDTYPECODE_3);
			}
			else {
				bindRecordTypeCode = true;

				sb.append(
					_FINDER_COLUMN_DATATYPECODEANDLOVCODEANDSTATUS_RECORDTYPECODE_2);
			}

			sb.append(
				_FINDER_COLUMN_DATATYPECODEANDLOVCODEANDSTATUS_ENTITYRESOURCEID_2);

			sb.append(_FINDER_COLUMN_DATATYPECODEANDLOVCODEANDSTATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLovType) {
					queryPos.add(lovType);
				}

				if (bindRecordTypeCode) {
					queryPos.add(recordTypeCode);
				}

				queryPos.add(entityResourceId);

				queryPos.add(status);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
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
		_FINDER_COLUMN_DATATYPECODEANDLOVCODEANDSTATUS_LOVTYPE_2 =
			"lovData.lovType = ? AND ";

	private static final String
		_FINDER_COLUMN_DATATYPECODEANDLOVCODEANDSTATUS_LOVTYPE_3 =
			"(lovData.lovType IS NULL OR lovData.lovType = '') AND ";

	private static final String
		_FINDER_COLUMN_DATATYPECODEANDLOVCODEANDSTATUS_RECORDTYPECODE_2 =
			"lovData.recordTypeCode = ? AND ";

	private static final String
		_FINDER_COLUMN_DATATYPECODEANDLOVCODEANDSTATUS_RECORDTYPECODE_3 =
			"(lovData.recordTypeCode IS NULL OR lovData.recordTypeCode = '') AND ";

	private static final String
		_FINDER_COLUMN_DATATYPECODEANDLOVCODEANDSTATUS_ENTITYRESOURCEID_2 =
			"lovData.entityResourceId = ? AND ";

	private static final String
		_FINDER_COLUMN_DATATYPECODEANDLOVCODEANDSTATUS_STATUS_2 =
			"lovData.status = ?";

	private FinderPath _finderPathWithPaginationFindByEntityResourceId;
	private FinderPath _finderPathWithoutPaginationFindByEntityResourceId;
	private FinderPath _finderPathCountByEntityResourceId;

	/**
	 * Returns all the lov datas where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the matching lov datas
	 */
	@Override
	public List<LovData> findByEntityResourceId(long entityResourceId) {
		return findByEntityResourceId(
			entityResourceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lov datas where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of lov datas
	 * @param end the upper bound of the range of lov datas (not inclusive)
	 * @return the range of matching lov datas
	 */
	@Override
	public List<LovData> findByEntityResourceId(
		long entityResourceId, int start, int end) {

		return findByEntityResourceId(entityResourceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lov datas where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of lov datas
	 * @param end the upper bound of the range of lov datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lov datas
	 */
	@Override
	public List<LovData> findByEntityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<LovData> orderByComparator) {

		return findByEntityResourceId(
			entityResourceId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lov datas where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of lov datas
	 * @param end the upper bound of the range of lov datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lov datas
	 */
	@Override
	public List<LovData> findByEntityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<LovData> orderByComparator, boolean useFinderCache) {

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

		List<LovData> list = null;

		if (useFinderCache) {
			list = (List<LovData>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LovData lovData : list) {
					if (entityResourceId != lovData.getEntityResourceId()) {
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

			sb.append(_SQL_SELECT_LOVDATA_WHERE);

			sb.append(_FINDER_COLUMN_ENTITYRESOURCEID_ENTITYRESOURCEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LovDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(entityResourceId);

				list = (List<LovData>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
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
	 * Returns the first lov data in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data
	 * @throws NoSuchLovDataException if a matching lov data could not be found
	 */
	@Override
	public LovData findByEntityResourceId_First(
			long entityResourceId, OrderByComparator<LovData> orderByComparator)
		throws NoSuchLovDataException {

		LovData lovData = fetchByEntityResourceId_First(
			entityResourceId, orderByComparator);

		if (lovData != null) {
			return lovData;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("entityResourceId=");
		sb.append(entityResourceId);

		sb.append("}");

		throw new NoSuchLovDataException(sb.toString());
	}

	/**
	 * Returns the first lov data in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data, or <code>null</code> if a matching lov data could not be found
	 */
	@Override
	public LovData fetchByEntityResourceId_First(
		long entityResourceId, OrderByComparator<LovData> orderByComparator) {

		List<LovData> list = findByEntityResourceId(
			entityResourceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lov data in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data
	 * @throws NoSuchLovDataException if a matching lov data could not be found
	 */
	@Override
	public LovData findByEntityResourceId_Last(
			long entityResourceId, OrderByComparator<LovData> orderByComparator)
		throws NoSuchLovDataException {

		LovData lovData = fetchByEntityResourceId_Last(
			entityResourceId, orderByComparator);

		if (lovData != null) {
			return lovData;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("entityResourceId=");
		sb.append(entityResourceId);

		sb.append("}");

		throw new NoSuchLovDataException(sb.toString());
	}

	/**
	 * Returns the last lov data in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data, or <code>null</code> if a matching lov data could not be found
	 */
	@Override
	public LovData fetchByEntityResourceId_Last(
		long entityResourceId, OrderByComparator<LovData> orderByComparator) {

		int count = countByEntityResourceId(entityResourceId);

		if (count == 0) {
			return null;
		}

		List<LovData> list = findByEntityResourceId(
			entityResourceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lov datas before and after the current lov data in the ordered set where entityResourceId = &#63;.
	 *
	 * @param id the primary key of the current lov data
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lov data
	 * @throws NoSuchLovDataException if a lov data with the primary key could not be found
	 */
	@Override
	public LovData[] findByEntityResourceId_PrevAndNext(
			long id, long entityResourceId,
			OrderByComparator<LovData> orderByComparator)
		throws NoSuchLovDataException {

		LovData lovData = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			LovData[] array = new LovDataImpl[3];

			array[0] = getByEntityResourceId_PrevAndNext(
				session, lovData, entityResourceId, orderByComparator, true);

			array[1] = lovData;

			array[2] = getByEntityResourceId_PrevAndNext(
				session, lovData, entityResourceId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LovData getByEntityResourceId_PrevAndNext(
		Session session, LovData lovData, long entityResourceId,
		OrderByComparator<LovData> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LOVDATA_WHERE);

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
			sb.append(LovDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(entityResourceId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(lovData)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LovData> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lov datas where entityResourceId = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 */
	@Override
	public void removeByEntityResourceId(long entityResourceId) {
		for (LovData lovData :
				findByEntityResourceId(
					entityResourceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(lovData);
		}
	}

	/**
	 * Returns the number of lov datas where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the number of matching lov datas
	 */
	@Override
	public int countByEntityResourceId(long entityResourceId) {
		FinderPath finderPath = _finderPathCountByEntityResourceId;

		Object[] finderArgs = new Object[] {entityResourceId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LOVDATA_WHERE);

			sb.append(_FINDER_COLUMN_ENTITYRESOURCEID_ENTITYRESOURCEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(entityResourceId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
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
			"lovData.entityResourceId = ?";

	public LovDataPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("lovId", "lov_id");
		dbColumnNames.put("lovType", "lov_type");
		dbColumnNames.put("recordTypeCode", "record_type_Code");
		dbColumnNames.put("recordShortDescription", "record_short_description");

		setDBColumnNames(dbColumnNames);

		setModelClass(LovData.class);

		setModelImplClass(LovDataImpl.class);
		setModelPKClass(long.class);

		setTable(LovDataTable.INSTANCE);
	}

	/**
	 * Caches the lov data in the entity cache if it is enabled.
	 *
	 * @param lovData the lov data
	 */
	@Override
	public void cacheResult(LovData lovData) {
		entityCache.putResult(
			LovDataImpl.class, lovData.getPrimaryKey(), lovData);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the lov datas in the entity cache if it is enabled.
	 *
	 * @param lovDatas the lov datas
	 */
	@Override
	public void cacheResult(List<LovData> lovDatas) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (lovDatas.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (LovData lovData : lovDatas) {
			if (entityCache.getResult(
					LovDataImpl.class, lovData.getPrimaryKey()) == null) {

				cacheResult(lovData);
			}
		}
	}

	/**
	 * Clears the cache for all lov datas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LovDataImpl.class);

		finderCache.clearCache(LovDataImpl.class);
	}

	/**
	 * Clears the cache for the lov data.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LovData lovData) {
		entityCache.removeResult(LovDataImpl.class, lovData);
	}

	@Override
	public void clearCache(List<LovData> lovDatas) {
		for (LovData lovData : lovDatas) {
			entityCache.removeResult(LovDataImpl.class, lovData);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(LovDataImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(LovDataImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new lov data with the primary key. Does not add the lov data to the database.
	 *
	 * @param id the primary key for the new lov data
	 * @return the new lov data
	 */
	@Override
	public LovData create(long id) {
		LovData lovData = new LovDataImpl();

		lovData.setNew(true);
		lovData.setPrimaryKey(id);

		return lovData;
	}

	/**
	 * Removes the lov data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the lov data
	 * @return the lov data that was removed
	 * @throws NoSuchLovDataException if a lov data with the primary key could not be found
	 */
	@Override
	public LovData remove(long id) throws NoSuchLovDataException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the lov data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lov data
	 * @return the lov data that was removed
	 * @throws NoSuchLovDataException if a lov data with the primary key could not be found
	 */
	@Override
	public LovData remove(Serializable primaryKey)
		throws NoSuchLovDataException {

		Session session = null;

		try {
			session = openSession();

			LovData lovData = (LovData)session.get(
				LovDataImpl.class, primaryKey);

			if (lovData == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLovDataException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(lovData);
		}
		catch (NoSuchLovDataException noSuchEntityException) {
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
	protected LovData removeImpl(LovData lovData) {
		lovDataLocalizationPersistence.removeById(lovData.getId());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(lovData)) {
				lovData = (LovData)session.get(
					LovDataImpl.class, lovData.getPrimaryKeyObj());
			}

			if (lovData != null) {
				session.delete(lovData);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (lovData != null) {
			clearCache(lovData);
		}

		return lovData;
	}

	@Override
	public LovData updateImpl(LovData lovData) {
		boolean isNew = lovData.isNew();

		if (!(lovData instanceof LovDataModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(lovData.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(lovData);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in lovData proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LovData implementation " +
					lovData.getClass());
		}

		LovDataModelImpl lovDataModelImpl = (LovDataModelImpl)lovData;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(lovData);
			}
			else {
				lovData = (LovData)session.merge(lovData);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(LovDataImpl.class, lovDataModelImpl, false, true);

		if (isNew) {
			lovData.setNew(false);
		}

		lovData.resetOriginalValues();

		return lovData;
	}

	/**
	 * Returns the lov data with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lov data
	 * @return the lov data
	 * @throws NoSuchLovDataException if a lov data with the primary key could not be found
	 */
	@Override
	public LovData findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLovDataException {

		LovData lovData = fetchByPrimaryKey(primaryKey);

		if (lovData == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLovDataException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return lovData;
	}

	/**
	 * Returns the lov data with the primary key or throws a <code>NoSuchLovDataException</code> if it could not be found.
	 *
	 * @param id the primary key of the lov data
	 * @return the lov data
	 * @throws NoSuchLovDataException if a lov data with the primary key could not be found
	 */
	@Override
	public LovData findByPrimaryKey(long id) throws NoSuchLovDataException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the lov data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the lov data
	 * @return the lov data, or <code>null</code> if a lov data with the primary key could not be found
	 */
	@Override
	public LovData fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the lov datas.
	 *
	 * @return the lov datas
	 */
	@Override
	public List<LovData> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lov datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lov datas
	 * @param end the upper bound of the range of lov datas (not inclusive)
	 * @return the range of lov datas
	 */
	@Override
	public List<LovData> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lov datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lov datas
	 * @param end the upper bound of the range of lov datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lov datas
	 */
	@Override
	public List<LovData> findAll(
		int start, int end, OrderByComparator<LovData> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lov datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lov datas
	 * @param end the upper bound of the range of lov datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of lov datas
	 */
	@Override
	public List<LovData> findAll(
		int start, int end, OrderByComparator<LovData> orderByComparator,
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

		List<LovData> list = null;

		if (useFinderCache) {
			list = (List<LovData>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LOVDATA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LOVDATA;

				sql = sql.concat(LovDataModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<LovData>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
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
	 * Removes all the lov datas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LovData lovData : findAll()) {
			remove(lovData);
		}
	}

	/**
	 * Returns the number of lov datas.
	 *
	 * @return the number of lov datas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_LOVDATA);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LOVDATA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LovDataModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the lov data persistence.
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

		_finderPathWithPaginationFindByLovdata = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLovdata",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"lov_id"}, true);

		_finderPathWithoutPaginationFindByLovdata = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLovdata",
			new String[] {Long.class.getName()}, new String[] {"lov_id"}, true);

		_finderPathCountByLovdata = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLovdata",
			new String[] {Long.class.getName()}, new String[] {"lov_id"},
			false);

		_finderPathWithPaginationFindBylovIdAndRecordShortDescription =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBylovIdAndRecordShortDescription",
				new String[] {
					Long.class.getName(), String.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"lov_id", "record_short_description"}, true);

		_finderPathWithoutPaginationFindBylovIdAndRecordShortDescription =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBylovIdAndRecordShortDescription",
				new String[] {Long.class.getName(), String.class.getName()},
				new String[] {"lov_id", "record_short_description"}, true);

		_finderPathCountBylovIdAndRecordShortDescription = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBylovIdAndRecordShortDescription",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"lov_id", "record_short_description"}, false);

		_finderPathWithPaginationFindByDataTypeCodeAndLovCodeAndStatus =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByDataTypeCodeAndLovCodeAndStatus",
				new String[] {
					String.class.getName(), String.class.getName(),
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {
					"lov_type", "record_type_Code", "entityResourceId", "status"
				},
				true);

		_finderPathWithoutPaginationFindByDataTypeCodeAndLovCodeAndStatus =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByDataTypeCodeAndLovCodeAndStatus",
				new String[] {
					String.class.getName(), String.class.getName(),
					Long.class.getName(), Integer.class.getName()
				},
				new String[] {
					"lov_type", "record_type_Code", "entityResourceId", "status"
				},
				true);

		_finderPathCountByDataTypeCodeAndLovCodeAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDataTypeCodeAndLovCodeAndStatus",
			new String[] {
				String.class.getName(), String.class.getName(),
				Long.class.getName(), Integer.class.getName()
			},
			new String[] {
				"lov_type", "record_type_Code", "entityResourceId", "status"
			},
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

		LovDataUtil.setPersistence(this);
	}

	public void destroy() {
		LovDataUtil.setPersistence(null);

		entityCache.removeCache(LovDataImpl.class.getName());
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	@BeanReference(type = LovDataLocalizationPersistence.class)
	protected LovDataLocalizationPersistence lovDataLocalizationPersistence;

	private static final String _SQL_SELECT_LOVDATA =
		"SELECT lovData FROM LovData lovData";

	private static final String _SQL_SELECT_LOVDATA_WHERE =
		"SELECT lovData FROM LovData lovData WHERE ";

	private static final String _SQL_COUNT_LOVDATA =
		"SELECT COUNT(lovData) FROM LovData lovData";

	private static final String _SQL_COUNT_LOVDATA_WHERE =
		"SELECT COUNT(lovData) FROM LovData lovData WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "lovData.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LovData exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LovData exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LovDataPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"lovId", "lovType", "recordTypeCode", "recordShortDescription"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}