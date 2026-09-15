/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence.impl;

import com.ejada.telemony.db.exception.NoSuchLovsException;
import com.ejada.telemony.db.model.Lovs;
import com.ejada.telemony.db.model.LovsTable;
import com.ejada.telemony.db.model.impl.LovsImpl;
import com.ejada.telemony.db.model.impl.LovsModelImpl;
import com.ejada.telemony.db.service.persistence.LovsLocalizationPersistence;
import com.ejada.telemony.db.service.persistence.LovsPersistence;
import com.ejada.telemony.db.service.persistence.LovsUtil;

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
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the lovs service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LovsPersistenceImpl
	extends BasePersistenceImpl<Lovs> implements LovsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LovsUtil</code> to access the lovs persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LovsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBytypeCodeAndStatus;
	private FinderPath _finderPathWithoutPaginationFindBytypeCodeAndStatus;
	private FinderPath _finderPathCountBytypeCodeAndStatus;

	/**
	 * Returns all the lovses where channelId = &#63; and code = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param status the status
	 * @return the matching lovses
	 */
	@Override
	public List<Lovs> findBytypeCodeAndStatus(
		long channelId, String code, int status) {

		return findBytypeCodeAndStatus(
			channelId, code, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

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
	@Override
	public List<Lovs> findBytypeCodeAndStatus(
		long channelId, String code, int status, int start, int end) {

		return findBytypeCodeAndStatus(
			channelId, code, status, start, end, null);
	}

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
	@Override
	public List<Lovs> findBytypeCodeAndStatus(
		long channelId, String code, int status, int start, int end,
		OrderByComparator<Lovs> orderByComparator) {

		return findBytypeCodeAndStatus(
			channelId, code, status, start, end, orderByComparator, true);
	}

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
	@Override
	public List<Lovs> findBytypeCodeAndStatus(
		long channelId, String code, int status, int start, int end,
		OrderByComparator<Lovs> orderByComparator, boolean useFinderCache) {

		code = Objects.toString(code, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBytypeCodeAndStatus;
				finderArgs = new Object[] {channelId, code, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBytypeCodeAndStatus;
			finderArgs = new Object[] {
				channelId, code, status, start, end, orderByComparator
			};
		}

		List<Lovs> list = null;

		if (useFinderCache) {
			list = (List<Lovs>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Lovs lovs : list) {
					if ((channelId != lovs.getChannelId()) ||
						!code.equals(lovs.getCode()) ||
						(status != lovs.getStatus())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_LOVS_WHERE);

			sb.append(_FINDER_COLUMN_TYPECODEANDSTATUS_CHANNELID_2);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_TYPECODEANDSTATUS_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_TYPECODEANDSTATUS_CODE_2);
			}

			sb.append(_FINDER_COLUMN_TYPECODEANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LovsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				if (bindCode) {
					queryPos.add(code);
				}

				queryPos.add(status);

				list = (List<Lovs>)QueryUtil.list(
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
	 * Returns the first lovs in the ordered set where channelId = &#63; and code = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs
	 * @throws NoSuchLovsException if a matching lovs could not be found
	 */
	@Override
	public Lovs findBytypeCodeAndStatus_First(
			long channelId, String code, int status,
			OrderByComparator<Lovs> orderByComparator)
		throws NoSuchLovsException {

		Lovs lovs = fetchBytypeCodeAndStatus_First(
			channelId, code, status, orderByComparator);

		if (lovs != null) {
			return lovs;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append(", code=");
		sb.append(code);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchLovsException(sb.toString());
	}

	/**
	 * Returns the first lovs in the ordered set where channelId = &#63; and code = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs, or <code>null</code> if a matching lovs could not be found
	 */
	@Override
	public Lovs fetchBytypeCodeAndStatus_First(
		long channelId, String code, int status,
		OrderByComparator<Lovs> orderByComparator) {

		List<Lovs> list = findBytypeCodeAndStatus(
			channelId, code, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Lovs findBytypeCodeAndStatus_Last(
			long channelId, String code, int status,
			OrderByComparator<Lovs> orderByComparator)
		throws NoSuchLovsException {

		Lovs lovs = fetchBytypeCodeAndStatus_Last(
			channelId, code, status, orderByComparator);

		if (lovs != null) {
			return lovs;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append(", code=");
		sb.append(code);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchLovsException(sb.toString());
	}

	/**
	 * Returns the last lovs in the ordered set where channelId = &#63; and code = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs, or <code>null</code> if a matching lovs could not be found
	 */
	@Override
	public Lovs fetchBytypeCodeAndStatus_Last(
		long channelId, String code, int status,
		OrderByComparator<Lovs> orderByComparator) {

		int count = countBytypeCodeAndStatus(channelId, code, status);

		if (count == 0) {
			return null;
		}

		List<Lovs> list = findBytypeCodeAndStatus(
			channelId, code, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Lovs[] findBytypeCodeAndStatus_PrevAndNext(
			long id, long channelId, String code, int status,
			OrderByComparator<Lovs> orderByComparator)
		throws NoSuchLovsException {

		code = Objects.toString(code, "");

		Lovs lovs = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Lovs[] array = new LovsImpl[3];

			array[0] = getBytypeCodeAndStatus_PrevAndNext(
				session, lovs, channelId, code, status, orderByComparator,
				true);

			array[1] = lovs;

			array[2] = getBytypeCodeAndStatus_PrevAndNext(
				session, lovs, channelId, code, status, orderByComparator,
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

	protected Lovs getBytypeCodeAndStatus_PrevAndNext(
		Session session, Lovs lovs, long channelId, String code, int status,
		OrderByComparator<Lovs> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_LOVS_WHERE);

		sb.append(_FINDER_COLUMN_TYPECODEANDSTATUS_CHANNELID_2);

		boolean bindCode = false;

		if (code.isEmpty()) {
			sb.append(_FINDER_COLUMN_TYPECODEANDSTATUS_CODE_3);
		}
		else {
			bindCode = true;

			sb.append(_FINDER_COLUMN_TYPECODEANDSTATUS_CODE_2);
		}

		sb.append(_FINDER_COLUMN_TYPECODEANDSTATUS_STATUS_2);

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
			sb.append(LovsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(channelId);

		if (bindCode) {
			queryPos.add(code);
		}

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(lovs)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Lovs> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lovses where channelId = &#63; and code = &#63; and status = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param status the status
	 */
	@Override
	public void removeBytypeCodeAndStatus(
		long channelId, String code, int status) {

		for (Lovs lovs :
				findBytypeCodeAndStatus(
					channelId, code, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(lovs);
		}
	}

	/**
	 * Returns the number of lovses where channelId = &#63; and code = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param status the status
	 * @return the number of matching lovses
	 */
	@Override
	public int countBytypeCodeAndStatus(
		long channelId, String code, int status) {

		code = Objects.toString(code, "");

		FinderPath finderPath = _finderPathCountBytypeCodeAndStatus;

		Object[] finderArgs = new Object[] {channelId, code, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_LOVS_WHERE);

			sb.append(_FINDER_COLUMN_TYPECODEANDSTATUS_CHANNELID_2);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_TYPECODEANDSTATUS_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_TYPECODEANDSTATUS_CODE_2);
			}

			sb.append(_FINDER_COLUMN_TYPECODEANDSTATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				if (bindCode) {
					queryPos.add(code);
				}

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

	private static final String _FINDER_COLUMN_TYPECODEANDSTATUS_CHANNELID_2 =
		"lovs.channelId = ? AND ";

	private static final String _FINDER_COLUMN_TYPECODEANDSTATUS_CODE_2 =
		"lovs.code = ? AND ";

	private static final String _FINDER_COLUMN_TYPECODEANDSTATUS_CODE_3 =
		"(lovs.code IS NULL OR lovs.code = '') AND ";

	private static final String _FINDER_COLUMN_TYPECODEANDSTATUS_STATUS_2 =
		"lovs.status = ?";

	private FinderPath _finderPathWithPaginationFindBytypeCode;
	private FinderPath _finderPathWithoutPaginationFindBytypeCode;
	private FinderPath _finderPathCountBytypeCode;

	/**
	 * Returns all the lovses where channelId = &#63; and code = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @return the matching lovses
	 */
	@Override
	public List<Lovs> findBytypeCode(long channelId, String code) {
		return findBytypeCode(
			channelId, code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Lovs> findBytypeCode(
		long channelId, String code, int start, int end) {

		return findBytypeCode(channelId, code, start, end, null);
	}

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
	@Override
	public List<Lovs> findBytypeCode(
		long channelId, String code, int start, int end,
		OrderByComparator<Lovs> orderByComparator) {

		return findBytypeCode(
			channelId, code, start, end, orderByComparator, true);
	}

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
	@Override
	public List<Lovs> findBytypeCode(
		long channelId, String code, int start, int end,
		OrderByComparator<Lovs> orderByComparator, boolean useFinderCache) {

		code = Objects.toString(code, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBytypeCode;
				finderArgs = new Object[] {channelId, code};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBytypeCode;
			finderArgs = new Object[] {
				channelId, code, start, end, orderByComparator
			};
		}

		List<Lovs> list = null;

		if (useFinderCache) {
			list = (List<Lovs>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Lovs lovs : list) {
					if ((channelId != lovs.getChannelId()) ||
						!code.equals(lovs.getCode())) {

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

			sb.append(_SQL_SELECT_LOVS_WHERE);

			sb.append(_FINDER_COLUMN_TYPECODE_CHANNELID_2);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_TYPECODE_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_TYPECODE_CODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LovsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				if (bindCode) {
					queryPos.add(code);
				}

				list = (List<Lovs>)QueryUtil.list(
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
	 * Returns the first lovs in the ordered set where channelId = &#63; and code = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs
	 * @throws NoSuchLovsException if a matching lovs could not be found
	 */
	@Override
	public Lovs findBytypeCode_First(
			long channelId, String code,
			OrderByComparator<Lovs> orderByComparator)
		throws NoSuchLovsException {

		Lovs lovs = fetchBytypeCode_First(channelId, code, orderByComparator);

		if (lovs != null) {
			return lovs;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append(", code=");
		sb.append(code);

		sb.append("}");

		throw new NoSuchLovsException(sb.toString());
	}

	/**
	 * Returns the first lovs in the ordered set where channelId = &#63; and code = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs, or <code>null</code> if a matching lovs could not be found
	 */
	@Override
	public Lovs fetchBytypeCode_First(
		long channelId, String code,
		OrderByComparator<Lovs> orderByComparator) {

		List<Lovs> list = findBytypeCode(
			channelId, code, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lovs in the ordered set where channelId = &#63; and code = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs
	 * @throws NoSuchLovsException if a matching lovs could not be found
	 */
	@Override
	public Lovs findBytypeCode_Last(
			long channelId, String code,
			OrderByComparator<Lovs> orderByComparator)
		throws NoSuchLovsException {

		Lovs lovs = fetchBytypeCode_Last(channelId, code, orderByComparator);

		if (lovs != null) {
			return lovs;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append(", code=");
		sb.append(code);

		sb.append("}");

		throw new NoSuchLovsException(sb.toString());
	}

	/**
	 * Returns the last lovs in the ordered set where channelId = &#63; and code = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs, or <code>null</code> if a matching lovs could not be found
	 */
	@Override
	public Lovs fetchBytypeCode_Last(
		long channelId, String code,
		OrderByComparator<Lovs> orderByComparator) {

		int count = countBytypeCode(channelId, code);

		if (count == 0) {
			return null;
		}

		List<Lovs> list = findBytypeCode(
			channelId, code, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Lovs[] findBytypeCode_PrevAndNext(
			long id, long channelId, String code,
			OrderByComparator<Lovs> orderByComparator)
		throws NoSuchLovsException {

		code = Objects.toString(code, "");

		Lovs lovs = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Lovs[] array = new LovsImpl[3];

			array[0] = getBytypeCode_PrevAndNext(
				session, lovs, channelId, code, orderByComparator, true);

			array[1] = lovs;

			array[2] = getBytypeCode_PrevAndNext(
				session, lovs, channelId, code, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Lovs getBytypeCode_PrevAndNext(
		Session session, Lovs lovs, long channelId, String code,
		OrderByComparator<Lovs> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_LOVS_WHERE);

		sb.append(_FINDER_COLUMN_TYPECODE_CHANNELID_2);

		boolean bindCode = false;

		if (code.isEmpty()) {
			sb.append(_FINDER_COLUMN_TYPECODE_CODE_3);
		}
		else {
			bindCode = true;

			sb.append(_FINDER_COLUMN_TYPECODE_CODE_2);
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
			sb.append(LovsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(channelId);

		if (bindCode) {
			queryPos.add(code);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(lovs)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Lovs> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lovses where channelId = &#63; and code = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 */
	@Override
	public void removeBytypeCode(long channelId, String code) {
		for (Lovs lovs :
				findBytypeCode(
					channelId, code, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(lovs);
		}
	}

	/**
	 * Returns the number of lovses where channelId = &#63; and code = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param code the code
	 * @return the number of matching lovses
	 */
	@Override
	public int countBytypeCode(long channelId, String code) {
		code = Objects.toString(code, "");

		FinderPath finderPath = _finderPathCountBytypeCode;

		Object[] finderArgs = new Object[] {channelId, code};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LOVS_WHERE);

			sb.append(_FINDER_COLUMN_TYPECODE_CHANNELID_2);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_TYPECODE_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_TYPECODE_CODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				if (bindCode) {
					queryPos.add(code);
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

	private static final String _FINDER_COLUMN_TYPECODE_CHANNELID_2 =
		"lovs.channelId = ? AND ";

	private static final String _FINDER_COLUMN_TYPECODE_CODE_2 =
		"lovs.code = ?";

	private static final String _FINDER_COLUMN_TYPECODE_CODE_3 =
		"(lovs.code IS NULL OR lovs.code = '')";

	private FinderPath _finderPathWithPaginationFindByChannelId;
	private FinderPath _finderPathWithoutPaginationFindByChannelId;
	private FinderPath _finderPathCountByChannelId;

	/**
	 * Returns all the lovses where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the matching lovses
	 */
	@Override
	public List<Lovs> findByChannelId(long channelId) {
		return findByChannelId(
			channelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Lovs> findByChannelId(long channelId, int start, int end) {
		return findByChannelId(channelId, start, end, null);
	}

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
	@Override
	public List<Lovs> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<Lovs> orderByComparator) {

		return findByChannelId(channelId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<Lovs> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<Lovs> orderByComparator, boolean useFinderCache) {

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

		List<Lovs> list = null;

		if (useFinderCache) {
			list = (List<Lovs>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Lovs lovs : list) {
					if (channelId != lovs.getChannelId()) {
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

			sb.append(_SQL_SELECT_LOVS_WHERE);

			sb.append(_FINDER_COLUMN_CHANNELID_CHANNELID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LovsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				list = (List<Lovs>)QueryUtil.list(
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
	 * Returns the first lovs in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs
	 * @throws NoSuchLovsException if a matching lovs could not be found
	 */
	@Override
	public Lovs findByChannelId_First(
			long channelId, OrderByComparator<Lovs> orderByComparator)
		throws NoSuchLovsException {

		Lovs lovs = fetchByChannelId_First(channelId, orderByComparator);

		if (lovs != null) {
			return lovs;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append("}");

		throw new NoSuchLovsException(sb.toString());
	}

	/**
	 * Returns the first lovs in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs, or <code>null</code> if a matching lovs could not be found
	 */
	@Override
	public Lovs fetchByChannelId_First(
		long channelId, OrderByComparator<Lovs> orderByComparator) {

		List<Lovs> list = findByChannelId(channelId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lovs in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs
	 * @throws NoSuchLovsException if a matching lovs could not be found
	 */
	@Override
	public Lovs findByChannelId_Last(
			long channelId, OrderByComparator<Lovs> orderByComparator)
		throws NoSuchLovsException {

		Lovs lovs = fetchByChannelId_Last(channelId, orderByComparator);

		if (lovs != null) {
			return lovs;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append("}");

		throw new NoSuchLovsException(sb.toString());
	}

	/**
	 * Returns the last lovs in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs, or <code>null</code> if a matching lovs could not be found
	 */
	@Override
	public Lovs fetchByChannelId_Last(
		long channelId, OrderByComparator<Lovs> orderByComparator) {

		int count = countByChannelId(channelId);

		if (count == 0) {
			return null;
		}

		List<Lovs> list = findByChannelId(
			channelId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lovses before and after the current lovs in the ordered set where channelId = &#63;.
	 *
	 * @param id the primary key of the current lovs
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lovs
	 * @throws NoSuchLovsException if a lovs with the primary key could not be found
	 */
	@Override
	public Lovs[] findByChannelId_PrevAndNext(
			long id, long channelId, OrderByComparator<Lovs> orderByComparator)
		throws NoSuchLovsException {

		Lovs lovs = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Lovs[] array = new LovsImpl[3];

			array[0] = getByChannelId_PrevAndNext(
				session, lovs, channelId, orderByComparator, true);

			array[1] = lovs;

			array[2] = getByChannelId_PrevAndNext(
				session, lovs, channelId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Lovs getByChannelId_PrevAndNext(
		Session session, Lovs lovs, long channelId,
		OrderByComparator<Lovs> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LOVS_WHERE);

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
			sb.append(LovsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(channelId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(lovs)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Lovs> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lovses where channelId = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 */
	@Override
	public void removeByChannelId(long channelId) {
		for (Lovs lovs :
				findByChannelId(
					channelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(lovs);
		}
	}

	/**
	 * Returns the number of lovses where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the number of matching lovses
	 */
	@Override
	public int countByChannelId(long channelId) {
		FinderPath finderPath = _finderPathCountByChannelId;

		Object[] finderArgs = new Object[] {channelId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LOVS_WHERE);

			sb.append(_FINDER_COLUMN_CHANNELID_CHANNELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

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

	private static final String _FINDER_COLUMN_CHANNELID_CHANNELID_2 =
		"lovs.channelId = ?";

	private FinderPath _finderPathWithPaginationFindByidAndChannel;
	private FinderPath _finderPathWithoutPaginationFindByidAndChannel;
	private FinderPath _finderPathCountByidAndChannel;

	/**
	 * Returns all the lovses where id = &#63; and channelId = &#63;.
	 *
	 * @param id the ID
	 * @param channelId the channel ID
	 * @return the matching lovses
	 */
	@Override
	public List<Lovs> findByidAndChannel(long id, long channelId) {
		return findByidAndChannel(
			id, channelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Lovs> findByidAndChannel(
		long id, long channelId, int start, int end) {

		return findByidAndChannel(id, channelId, start, end, null);
	}

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
	@Override
	public List<Lovs> findByidAndChannel(
		long id, long channelId, int start, int end,
		OrderByComparator<Lovs> orderByComparator) {

		return findByidAndChannel(
			id, channelId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<Lovs> findByidAndChannel(
		long id, long channelId, int start, int end,
		OrderByComparator<Lovs> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByidAndChannel;
				finderArgs = new Object[] {id, channelId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByidAndChannel;
			finderArgs = new Object[] {
				id, channelId, start, end, orderByComparator
			};
		}

		List<Lovs> list = null;

		if (useFinderCache) {
			list = (List<Lovs>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Lovs lovs : list) {
					if ((id != lovs.getId()) ||
						(channelId != lovs.getChannelId())) {

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

			sb.append(_SQL_SELECT_LOVS_WHERE);

			sb.append(_FINDER_COLUMN_IDANDCHANNEL_ID_2);

			sb.append(_FINDER_COLUMN_IDANDCHANNEL_CHANNELID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LovsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(id);

				queryPos.add(channelId);

				list = (List<Lovs>)QueryUtil.list(
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
	 * Returns the first lovs in the ordered set where id = &#63; and channelId = &#63;.
	 *
	 * @param id the ID
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs
	 * @throws NoSuchLovsException if a matching lovs could not be found
	 */
	@Override
	public Lovs findByidAndChannel_First(
			long id, long channelId, OrderByComparator<Lovs> orderByComparator)
		throws NoSuchLovsException {

		Lovs lovs = fetchByidAndChannel_First(id, channelId, orderByComparator);

		if (lovs != null) {
			return lovs;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("id=");
		sb.append(id);

		sb.append(", channelId=");
		sb.append(channelId);

		sb.append("}");

		throw new NoSuchLovsException(sb.toString());
	}

	/**
	 * Returns the first lovs in the ordered set where id = &#63; and channelId = &#63;.
	 *
	 * @param id the ID
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs, or <code>null</code> if a matching lovs could not be found
	 */
	@Override
	public Lovs fetchByidAndChannel_First(
		long id, long channelId, OrderByComparator<Lovs> orderByComparator) {

		List<Lovs> list = findByidAndChannel(
			id, channelId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lovs in the ordered set where id = &#63; and channelId = &#63;.
	 *
	 * @param id the ID
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs
	 * @throws NoSuchLovsException if a matching lovs could not be found
	 */
	@Override
	public Lovs findByidAndChannel_Last(
			long id, long channelId, OrderByComparator<Lovs> orderByComparator)
		throws NoSuchLovsException {

		Lovs lovs = fetchByidAndChannel_Last(id, channelId, orderByComparator);

		if (lovs != null) {
			return lovs;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("id=");
		sb.append(id);

		sb.append(", channelId=");
		sb.append(channelId);

		sb.append("}");

		throw new NoSuchLovsException(sb.toString());
	}

	/**
	 * Returns the last lovs in the ordered set where id = &#63; and channelId = &#63;.
	 *
	 * @param id the ID
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs, or <code>null</code> if a matching lovs could not be found
	 */
	@Override
	public Lovs fetchByidAndChannel_Last(
		long id, long channelId, OrderByComparator<Lovs> orderByComparator) {

		int count = countByidAndChannel(id, channelId);

		if (count == 0) {
			return null;
		}

		List<Lovs> list = findByidAndChannel(
			id, channelId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the lovses where id = &#63; and channelId = &#63; from the database.
	 *
	 * @param id the ID
	 * @param channelId the channel ID
	 */
	@Override
	public void removeByidAndChannel(long id, long channelId) {
		for (Lovs lovs :
				findByidAndChannel(
					id, channelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(lovs);
		}
	}

	/**
	 * Returns the number of lovses where id = &#63; and channelId = &#63;.
	 *
	 * @param id the ID
	 * @param channelId the channel ID
	 * @return the number of matching lovses
	 */
	@Override
	public int countByidAndChannel(long id, long channelId) {
		FinderPath finderPath = _finderPathCountByidAndChannel;

		Object[] finderArgs = new Object[] {id, channelId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LOVS_WHERE);

			sb.append(_FINDER_COLUMN_IDANDCHANNEL_ID_2);

			sb.append(_FINDER_COLUMN_IDANDCHANNEL_CHANNELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(id);

				queryPos.add(channelId);

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

	private static final String _FINDER_COLUMN_IDANDCHANNEL_ID_2 =
		"lovs.id = ? AND ";

	private static final String _FINDER_COLUMN_IDANDCHANNEL_CHANNELID_2 =
		"lovs.channelId = ?";

	private FinderPath _finderPathWithPaginationFindByEntityResourceId;
	private FinderPath _finderPathWithoutPaginationFindByEntityResourceId;
	private FinderPath _finderPathCountByEntityResourceId;

	/**
	 * Returns all the lovses where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the matching lovses
	 */
	@Override
	public List<Lovs> findByEntityResourceId(long entityResourceId) {
		return findByEntityResourceId(
			entityResourceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Lovs> findByEntityResourceId(
		long entityResourceId, int start, int end) {

		return findByEntityResourceId(entityResourceId, start, end, null);
	}

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
	@Override
	public List<Lovs> findByEntityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<Lovs> orderByComparator) {

		return findByEntityResourceId(
			entityResourceId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<Lovs> findByEntityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<Lovs> orderByComparator, boolean useFinderCache) {

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

		List<Lovs> list = null;

		if (useFinderCache) {
			list = (List<Lovs>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Lovs lovs : list) {
					if (entityResourceId != lovs.getEntityResourceId()) {
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

			sb.append(_SQL_SELECT_LOVS_WHERE);

			sb.append(_FINDER_COLUMN_ENTITYRESOURCEID_ENTITYRESOURCEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LovsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(entityResourceId);

				list = (List<Lovs>)QueryUtil.list(
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
	 * Returns the first lovs in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs
	 * @throws NoSuchLovsException if a matching lovs could not be found
	 */
	@Override
	public Lovs findByEntityResourceId_First(
			long entityResourceId, OrderByComparator<Lovs> orderByComparator)
		throws NoSuchLovsException {

		Lovs lovs = fetchByEntityResourceId_First(
			entityResourceId, orderByComparator);

		if (lovs != null) {
			return lovs;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("entityResourceId=");
		sb.append(entityResourceId);

		sb.append("}");

		throw new NoSuchLovsException(sb.toString());
	}

	/**
	 * Returns the first lovs in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs, or <code>null</code> if a matching lovs could not be found
	 */
	@Override
	public Lovs fetchByEntityResourceId_First(
		long entityResourceId, OrderByComparator<Lovs> orderByComparator) {

		List<Lovs> list = findByEntityResourceId(
			entityResourceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lovs in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs
	 * @throws NoSuchLovsException if a matching lovs could not be found
	 */
	@Override
	public Lovs findByEntityResourceId_Last(
			long entityResourceId, OrderByComparator<Lovs> orderByComparator)
		throws NoSuchLovsException {

		Lovs lovs = fetchByEntityResourceId_Last(
			entityResourceId, orderByComparator);

		if (lovs != null) {
			return lovs;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("entityResourceId=");
		sb.append(entityResourceId);

		sb.append("}");

		throw new NoSuchLovsException(sb.toString());
	}

	/**
	 * Returns the last lovs in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs, or <code>null</code> if a matching lovs could not be found
	 */
	@Override
	public Lovs fetchByEntityResourceId_Last(
		long entityResourceId, OrderByComparator<Lovs> orderByComparator) {

		int count = countByEntityResourceId(entityResourceId);

		if (count == 0) {
			return null;
		}

		List<Lovs> list = findByEntityResourceId(
			entityResourceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lovses before and after the current lovs in the ordered set where entityResourceId = &#63;.
	 *
	 * @param id the primary key of the current lovs
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lovs
	 * @throws NoSuchLovsException if a lovs with the primary key could not be found
	 */
	@Override
	public Lovs[] findByEntityResourceId_PrevAndNext(
			long id, long entityResourceId,
			OrderByComparator<Lovs> orderByComparator)
		throws NoSuchLovsException {

		Lovs lovs = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Lovs[] array = new LovsImpl[3];

			array[0] = getByEntityResourceId_PrevAndNext(
				session, lovs, entityResourceId, orderByComparator, true);

			array[1] = lovs;

			array[2] = getByEntityResourceId_PrevAndNext(
				session, lovs, entityResourceId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Lovs getByEntityResourceId_PrevAndNext(
		Session session, Lovs lovs, long entityResourceId,
		OrderByComparator<Lovs> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LOVS_WHERE);

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
			sb.append(LovsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(entityResourceId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(lovs)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Lovs> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lovses where entityResourceId = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 */
	@Override
	public void removeByEntityResourceId(long entityResourceId) {
		for (Lovs lovs :
				findByEntityResourceId(
					entityResourceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(lovs);
		}
	}

	/**
	 * Returns the number of lovses where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the number of matching lovses
	 */
	@Override
	public int countByEntityResourceId(long entityResourceId) {
		FinderPath finderPath = _finderPathCountByEntityResourceId;

		Object[] finderArgs = new Object[] {entityResourceId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LOVS_WHERE);

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
			"lovs.entityResourceId = ?";

	public LovsPersistenceImpl() {
		setModelClass(Lovs.class);

		setModelImplClass(LovsImpl.class);
		setModelPKClass(long.class);

		setTable(LovsTable.INSTANCE);
	}

	/**
	 * Caches the lovs in the entity cache if it is enabled.
	 *
	 * @param lovs the lovs
	 */
	@Override
	public void cacheResult(Lovs lovs) {
		entityCache.putResult(LovsImpl.class, lovs.getPrimaryKey(), lovs);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the lovses in the entity cache if it is enabled.
	 *
	 * @param lovses the lovses
	 */
	@Override
	public void cacheResult(List<Lovs> lovses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (lovses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Lovs lovs : lovses) {
			if (entityCache.getResult(LovsImpl.class, lovs.getPrimaryKey()) ==
					null) {

				cacheResult(lovs);
			}
		}
	}

	/**
	 * Clears the cache for all lovses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LovsImpl.class);

		finderCache.clearCache(LovsImpl.class);
	}

	/**
	 * Clears the cache for the lovs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Lovs lovs) {
		entityCache.removeResult(LovsImpl.class, lovs);
	}

	@Override
	public void clearCache(List<Lovs> lovses) {
		for (Lovs lovs : lovses) {
			entityCache.removeResult(LovsImpl.class, lovs);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(LovsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(LovsImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new lovs with the primary key. Does not add the lovs to the database.
	 *
	 * @param id the primary key for the new lovs
	 * @return the new lovs
	 */
	@Override
	public Lovs create(long id) {
		Lovs lovs = new LovsImpl();

		lovs.setNew(true);
		lovs.setPrimaryKey(id);

		lovs.setCompanyId(CompanyThreadLocal.getCompanyId());

		return lovs;
	}

	/**
	 * Removes the lovs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the lovs
	 * @return the lovs that was removed
	 * @throws NoSuchLovsException if a lovs with the primary key could not be found
	 */
	@Override
	public Lovs remove(long id) throws NoSuchLovsException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the lovs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lovs
	 * @return the lovs that was removed
	 * @throws NoSuchLovsException if a lovs with the primary key could not be found
	 */
	@Override
	public Lovs remove(Serializable primaryKey) throws NoSuchLovsException {
		Session session = null;

		try {
			session = openSession();

			Lovs lovs = (Lovs)session.get(LovsImpl.class, primaryKey);

			if (lovs == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLovsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(lovs);
		}
		catch (NoSuchLovsException noSuchEntityException) {
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
	protected Lovs removeImpl(Lovs lovs) {
		lovsLocalizationPersistence.removeById(lovs.getId());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(lovs)) {
				lovs = (Lovs)session.get(
					LovsImpl.class, lovs.getPrimaryKeyObj());
			}

			if (lovs != null) {
				session.delete(lovs);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (lovs != null) {
			clearCache(lovs);
		}

		return lovs;
	}

	@Override
	public Lovs updateImpl(Lovs lovs) {
		boolean isNew = lovs.isNew();

		if (!(lovs instanceof LovsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(lovs.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(lovs);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in lovs proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Lovs implementation " +
					lovs.getClass());
		}

		LovsModelImpl lovsModelImpl = (LovsModelImpl)lovs;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (lovs.getCreateDate() == null)) {
			if (serviceContext == null) {
				lovs.setCreateDate(date);
			}
			else {
				lovs.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!lovsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				lovs.setModifiedDate(date);
			}
			else {
				lovs.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(lovs);
			}
			else {
				lovs = (Lovs)session.merge(lovs);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(LovsImpl.class, lovsModelImpl, false, true);

		if (isNew) {
			lovs.setNew(false);
		}

		lovs.resetOriginalValues();

		return lovs;
	}

	/**
	 * Returns the lovs with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lovs
	 * @return the lovs
	 * @throws NoSuchLovsException if a lovs with the primary key could not be found
	 */
	@Override
	public Lovs findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLovsException {

		Lovs lovs = fetchByPrimaryKey(primaryKey);

		if (lovs == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLovsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return lovs;
	}

	/**
	 * Returns the lovs with the primary key or throws a <code>NoSuchLovsException</code> if it could not be found.
	 *
	 * @param id the primary key of the lovs
	 * @return the lovs
	 * @throws NoSuchLovsException if a lovs with the primary key could not be found
	 */
	@Override
	public Lovs findByPrimaryKey(long id) throws NoSuchLovsException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the lovs with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the lovs
	 * @return the lovs, or <code>null</code> if a lovs with the primary key could not be found
	 */
	@Override
	public Lovs fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the lovses.
	 *
	 * @return the lovses
	 */
	@Override
	public List<Lovs> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Lovs> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Lovs> findAll(
		int start, int end, OrderByComparator<Lovs> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<Lovs> findAll(
		int start, int end, OrderByComparator<Lovs> orderByComparator,
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

		List<Lovs> list = null;

		if (useFinderCache) {
			list = (List<Lovs>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LOVS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LOVS;

				sql = sql.concat(LovsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Lovs>)QueryUtil.list(
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
	 * Removes all the lovses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Lovs lovs : findAll()) {
			remove(lovs);
		}
	}

	/**
	 * Returns the number of lovses.
	 *
	 * @return the number of lovses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_LOVS);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LOVS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LovsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the lovs persistence.
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

		_finderPathWithPaginationFindBytypeCodeAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBytypeCodeAndStatus",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"channelId", "code", "status"}, true);

		_finderPathWithoutPaginationFindBytypeCodeAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBytypeCodeAndStatus",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName()
			},
			new String[] {"channelId", "code", "status"}, true);

		_finderPathCountBytypeCodeAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBytypeCodeAndStatus",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName()
			},
			new String[] {"channelId", "code", "status"}, false);

		_finderPathWithPaginationFindBytypeCode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBytypeCode",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"channelId", "code"}, true);

		_finderPathWithoutPaginationFindBytypeCode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBytypeCode",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"channelId", "code"}, true);

		_finderPathCountBytypeCode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytypeCode",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"channelId", "code"}, false);

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

		_finderPathWithPaginationFindByidAndChannel = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByidAndChannel",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"id", "channelId"}, true);

		_finderPathWithoutPaginationFindByidAndChannel = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByidAndChannel",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"id", "channelId"}, true);

		_finderPathCountByidAndChannel = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByidAndChannel",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"id", "channelId"}, false);

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

		LovsUtil.setPersistence(this);
	}

	public void destroy() {
		LovsUtil.setPersistence(null);

		entityCache.removeCache(LovsImpl.class.getName());
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	@BeanReference(type = LovsLocalizationPersistence.class)
	protected LovsLocalizationPersistence lovsLocalizationPersistence;

	private static final String _SQL_SELECT_LOVS = "SELECT lovs FROM Lovs lovs";

	private static final String _SQL_SELECT_LOVS_WHERE =
		"SELECT lovs FROM Lovs lovs WHERE ";

	private static final String _SQL_COUNT_LOVS =
		"SELECT COUNT(lovs) FROM Lovs lovs";

	private static final String _SQL_COUNT_LOVS_WHERE =
		"SELECT COUNT(lovs) FROM Lovs lovs WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "lovs.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Lovs exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Lovs exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LovsPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}