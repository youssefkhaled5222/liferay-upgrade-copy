/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence.impl;

import com.ejada.telemony.db.exception.NoSuchPersonaException;
import com.ejada.telemony.db.model.Persona;
import com.ejada.telemony.db.model.PersonaTable;
import com.ejada.telemony.db.model.impl.PersonaImpl;
import com.ejada.telemony.db.model.impl.PersonaModelImpl;
import com.ejada.telemony.db.service.persistence.PersonaPersistence;
import com.ejada.telemony.db.service.persistence.PersonaUtil;

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
 * The persistence implementation for the persona service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PersonaPersistenceImpl
	extends BasePersistenceImpl<Persona> implements PersonaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PersonaUtil</code> to access the persona persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PersonaImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBylightThemeAndStatus;
	private FinderPath _finderPathWithoutPaginationFindBylightThemeAndStatus;
	private FinderPath _finderPathCountBylightThemeAndStatus;

	/**
	 * Returns all the personas where channelId = &#63; and lightThemeId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param lightThemeId the light theme ID
	 * @param status the status
	 * @return the matching personas
	 */
	@Override
	public List<Persona> findBylightThemeAndStatus(
		long channelId, Long lightThemeId, int status) {

		return findBylightThemeAndStatus(
			channelId, lightThemeId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the personas where channelId = &#63; and lightThemeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param lightThemeId the light theme ID
	 * @param status the status
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @return the range of matching personas
	 */
	@Override
	public List<Persona> findBylightThemeAndStatus(
		long channelId, Long lightThemeId, int status, int start, int end) {

		return findBylightThemeAndStatus(
			channelId, lightThemeId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the personas where channelId = &#63; and lightThemeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param lightThemeId the light theme ID
	 * @param status the status
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching personas
	 */
	@Override
	public List<Persona> findBylightThemeAndStatus(
		long channelId, Long lightThemeId, int status, int start, int end,
		OrderByComparator<Persona> orderByComparator) {

		return findBylightThemeAndStatus(
			channelId, lightThemeId, status, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the personas where channelId = &#63; and lightThemeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param lightThemeId the light theme ID
	 * @param status the status
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching personas
	 */
	@Override
	public List<Persona> findBylightThemeAndStatus(
		long channelId, Long lightThemeId, int status, int start, int end,
		OrderByComparator<Persona> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBylightThemeAndStatus;
				finderArgs = new Object[] {channelId, lightThemeId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBylightThemeAndStatus;
			finderArgs = new Object[] {
				channelId, lightThemeId, status, start, end, orderByComparator
			};
		}

		List<Persona> list = null;

		if (useFinderCache) {
			list = (List<Persona>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Persona persona : list) {
					if ((channelId != persona.getChannelId()) ||
						!Objects.equals(
							lightThemeId, persona.getLightThemeId()) ||
						(status != persona.getStatus())) {

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

			sb.append(_SQL_SELECT_PERSONA_WHERE);

			sb.append(_FINDER_COLUMN_LIGHTTHEMEANDSTATUS_CHANNELID_2);

			sb.append(_FINDER_COLUMN_LIGHTTHEMEANDSTATUS_LIGHTTHEMEID_2);

			sb.append(_FINDER_COLUMN_LIGHTTHEMEANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PersonaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				queryPos.add(lightThemeId.longValue());

				queryPos.add(status);

				list = (List<Persona>)QueryUtil.list(
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
	 * Returns the first persona in the ordered set where channelId = &#63; and lightThemeId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param lightThemeId the light theme ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona
	 * @throws NoSuchPersonaException if a matching persona could not be found
	 */
	@Override
	public Persona findBylightThemeAndStatus_First(
			long channelId, Long lightThemeId, int status,
			OrderByComparator<Persona> orderByComparator)
		throws NoSuchPersonaException {

		Persona persona = fetchBylightThemeAndStatus_First(
			channelId, lightThemeId, status, orderByComparator);

		if (persona != null) {
			return persona;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append(", lightThemeId=");
		sb.append(lightThemeId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchPersonaException(sb.toString());
	}

	/**
	 * Returns the first persona in the ordered set where channelId = &#63; and lightThemeId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param lightThemeId the light theme ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona, or <code>null</code> if a matching persona could not be found
	 */
	@Override
	public Persona fetchBylightThemeAndStatus_First(
		long channelId, Long lightThemeId, int status,
		OrderByComparator<Persona> orderByComparator) {

		List<Persona> list = findBylightThemeAndStatus(
			channelId, lightThemeId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last persona in the ordered set where channelId = &#63; and lightThemeId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param lightThemeId the light theme ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona
	 * @throws NoSuchPersonaException if a matching persona could not be found
	 */
	@Override
	public Persona findBylightThemeAndStatus_Last(
			long channelId, Long lightThemeId, int status,
			OrderByComparator<Persona> orderByComparator)
		throws NoSuchPersonaException {

		Persona persona = fetchBylightThemeAndStatus_Last(
			channelId, lightThemeId, status, orderByComparator);

		if (persona != null) {
			return persona;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append(", lightThemeId=");
		sb.append(lightThemeId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchPersonaException(sb.toString());
	}

	/**
	 * Returns the last persona in the ordered set where channelId = &#63; and lightThemeId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param lightThemeId the light theme ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona, or <code>null</code> if a matching persona could not be found
	 */
	@Override
	public Persona fetchBylightThemeAndStatus_Last(
		long channelId, Long lightThemeId, int status,
		OrderByComparator<Persona> orderByComparator) {

		int count = countBylightThemeAndStatus(channelId, lightThemeId, status);

		if (count == 0) {
			return null;
		}

		List<Persona> list = findBylightThemeAndStatus(
			channelId, lightThemeId, status, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the personas before and after the current persona in the ordered set where channelId = &#63; and lightThemeId = &#63; and status = &#63;.
	 *
	 * @param personaId the primary key of the current persona
	 * @param channelId the channel ID
	 * @param lightThemeId the light theme ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persona
	 * @throws NoSuchPersonaException if a persona with the primary key could not be found
	 */
	@Override
	public Persona[] findBylightThemeAndStatus_PrevAndNext(
			long personaId, long channelId, Long lightThemeId, int status,
			OrderByComparator<Persona> orderByComparator)
		throws NoSuchPersonaException {

		Persona persona = findByPrimaryKey(personaId);

		Session session = null;

		try {
			session = openSession();

			Persona[] array = new PersonaImpl[3];

			array[0] = getBylightThemeAndStatus_PrevAndNext(
				session, persona, channelId, lightThemeId, status,
				orderByComparator, true);

			array[1] = persona;

			array[2] = getBylightThemeAndStatus_PrevAndNext(
				session, persona, channelId, lightThemeId, status,
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

	protected Persona getBylightThemeAndStatus_PrevAndNext(
		Session session, Persona persona, long channelId, Long lightThemeId,
		int status, OrderByComparator<Persona> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_PERSONA_WHERE);

		sb.append(_FINDER_COLUMN_LIGHTTHEMEANDSTATUS_CHANNELID_2);

		sb.append(_FINDER_COLUMN_LIGHTTHEMEANDSTATUS_LIGHTTHEMEID_2);

		sb.append(_FINDER_COLUMN_LIGHTTHEMEANDSTATUS_STATUS_2);

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
			sb.append(PersonaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(channelId);

		queryPos.add(lightThemeId.longValue());

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(persona)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Persona> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the personas where channelId = &#63; and lightThemeId = &#63; and status = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param lightThemeId the light theme ID
	 * @param status the status
	 */
	@Override
	public void removeBylightThemeAndStatus(
		long channelId, Long lightThemeId, int status) {

		for (Persona persona :
				findBylightThemeAndStatus(
					channelId, lightThemeId, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(persona);
		}
	}

	/**
	 * Returns the number of personas where channelId = &#63; and lightThemeId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param lightThemeId the light theme ID
	 * @param status the status
	 * @return the number of matching personas
	 */
	@Override
	public int countBylightThemeAndStatus(
		long channelId, Long lightThemeId, int status) {

		FinderPath finderPath = _finderPathCountBylightThemeAndStatus;

		Object[] finderArgs = new Object[] {channelId, lightThemeId, status};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_PERSONA_WHERE);

			sb.append(_FINDER_COLUMN_LIGHTTHEMEANDSTATUS_CHANNELID_2);

			sb.append(_FINDER_COLUMN_LIGHTTHEMEANDSTATUS_LIGHTTHEMEID_2);

			sb.append(_FINDER_COLUMN_LIGHTTHEMEANDSTATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				queryPos.add(lightThemeId.longValue());

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

	private static final String _FINDER_COLUMN_LIGHTTHEMEANDSTATUS_CHANNELID_2 =
		"persona.channelId = ? AND ";

	private static final String
		_FINDER_COLUMN_LIGHTTHEMEANDSTATUS_LIGHTTHEMEID_2 =
			"persona.lightThemeId = ? AND ";

	private static final String _FINDER_COLUMN_LIGHTTHEMEANDSTATUS_STATUS_2 =
		"persona.status = ?";

	private FinderPath _finderPathWithPaginationFindBydarkThemeAndStatus;
	private FinderPath _finderPathWithoutPaginationFindBydarkThemeAndStatus;
	private FinderPath _finderPathCountBydarkThemeAndStatus;

	/**
	 * Returns all the personas where channelId = &#63; and darkThemeId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param darkThemeId the dark theme ID
	 * @param status the status
	 * @return the matching personas
	 */
	@Override
	public List<Persona> findBydarkThemeAndStatus(
		long channelId, Long darkThemeId, int status) {

		return findBydarkThemeAndStatus(
			channelId, darkThemeId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the personas where channelId = &#63; and darkThemeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param darkThemeId the dark theme ID
	 * @param status the status
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @return the range of matching personas
	 */
	@Override
	public List<Persona> findBydarkThemeAndStatus(
		long channelId, Long darkThemeId, int status, int start, int end) {

		return findBydarkThemeAndStatus(
			channelId, darkThemeId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the personas where channelId = &#63; and darkThemeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param darkThemeId the dark theme ID
	 * @param status the status
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching personas
	 */
	@Override
	public List<Persona> findBydarkThemeAndStatus(
		long channelId, Long darkThemeId, int status, int start, int end,
		OrderByComparator<Persona> orderByComparator) {

		return findBydarkThemeAndStatus(
			channelId, darkThemeId, status, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the personas where channelId = &#63; and darkThemeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param darkThemeId the dark theme ID
	 * @param status the status
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching personas
	 */
	@Override
	public List<Persona> findBydarkThemeAndStatus(
		long channelId, Long darkThemeId, int status, int start, int end,
		OrderByComparator<Persona> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBydarkThemeAndStatus;
				finderArgs = new Object[] {channelId, darkThemeId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBydarkThemeAndStatus;
			finderArgs = new Object[] {
				channelId, darkThemeId, status, start, end, orderByComparator
			};
		}

		List<Persona> list = null;

		if (useFinderCache) {
			list = (List<Persona>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Persona persona : list) {
					if ((channelId != persona.getChannelId()) ||
						!Objects.equals(
							darkThemeId, persona.getDarkThemeId()) ||
						(status != persona.getStatus())) {

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

			sb.append(_SQL_SELECT_PERSONA_WHERE);

			sb.append(_FINDER_COLUMN_DARKTHEMEANDSTATUS_CHANNELID_2);

			sb.append(_FINDER_COLUMN_DARKTHEMEANDSTATUS_DARKTHEMEID_2);

			sb.append(_FINDER_COLUMN_DARKTHEMEANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PersonaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				queryPos.add(darkThemeId.longValue());

				queryPos.add(status);

				list = (List<Persona>)QueryUtil.list(
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
	 * Returns the first persona in the ordered set where channelId = &#63; and darkThemeId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param darkThemeId the dark theme ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona
	 * @throws NoSuchPersonaException if a matching persona could not be found
	 */
	@Override
	public Persona findBydarkThemeAndStatus_First(
			long channelId, Long darkThemeId, int status,
			OrderByComparator<Persona> orderByComparator)
		throws NoSuchPersonaException {

		Persona persona = fetchBydarkThemeAndStatus_First(
			channelId, darkThemeId, status, orderByComparator);

		if (persona != null) {
			return persona;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append(", darkThemeId=");
		sb.append(darkThemeId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchPersonaException(sb.toString());
	}

	/**
	 * Returns the first persona in the ordered set where channelId = &#63; and darkThemeId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param darkThemeId the dark theme ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona, or <code>null</code> if a matching persona could not be found
	 */
	@Override
	public Persona fetchBydarkThemeAndStatus_First(
		long channelId, Long darkThemeId, int status,
		OrderByComparator<Persona> orderByComparator) {

		List<Persona> list = findBydarkThemeAndStatus(
			channelId, darkThemeId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last persona in the ordered set where channelId = &#63; and darkThemeId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param darkThemeId the dark theme ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona
	 * @throws NoSuchPersonaException if a matching persona could not be found
	 */
	@Override
	public Persona findBydarkThemeAndStatus_Last(
			long channelId, Long darkThemeId, int status,
			OrderByComparator<Persona> orderByComparator)
		throws NoSuchPersonaException {

		Persona persona = fetchBydarkThemeAndStatus_Last(
			channelId, darkThemeId, status, orderByComparator);

		if (persona != null) {
			return persona;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append(", darkThemeId=");
		sb.append(darkThemeId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchPersonaException(sb.toString());
	}

	/**
	 * Returns the last persona in the ordered set where channelId = &#63; and darkThemeId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param darkThemeId the dark theme ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona, or <code>null</code> if a matching persona could not be found
	 */
	@Override
	public Persona fetchBydarkThemeAndStatus_Last(
		long channelId, Long darkThemeId, int status,
		OrderByComparator<Persona> orderByComparator) {

		int count = countBydarkThemeAndStatus(channelId, darkThemeId, status);

		if (count == 0) {
			return null;
		}

		List<Persona> list = findBydarkThemeAndStatus(
			channelId, darkThemeId, status, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the personas before and after the current persona in the ordered set where channelId = &#63; and darkThemeId = &#63; and status = &#63;.
	 *
	 * @param personaId the primary key of the current persona
	 * @param channelId the channel ID
	 * @param darkThemeId the dark theme ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persona
	 * @throws NoSuchPersonaException if a persona with the primary key could not be found
	 */
	@Override
	public Persona[] findBydarkThemeAndStatus_PrevAndNext(
			long personaId, long channelId, Long darkThemeId, int status,
			OrderByComparator<Persona> orderByComparator)
		throws NoSuchPersonaException {

		Persona persona = findByPrimaryKey(personaId);

		Session session = null;

		try {
			session = openSession();

			Persona[] array = new PersonaImpl[3];

			array[0] = getBydarkThemeAndStatus_PrevAndNext(
				session, persona, channelId, darkThemeId, status,
				orderByComparator, true);

			array[1] = persona;

			array[2] = getBydarkThemeAndStatus_PrevAndNext(
				session, persona, channelId, darkThemeId, status,
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

	protected Persona getBydarkThemeAndStatus_PrevAndNext(
		Session session, Persona persona, long channelId, Long darkThemeId,
		int status, OrderByComparator<Persona> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_PERSONA_WHERE);

		sb.append(_FINDER_COLUMN_DARKTHEMEANDSTATUS_CHANNELID_2);

		sb.append(_FINDER_COLUMN_DARKTHEMEANDSTATUS_DARKTHEMEID_2);

		sb.append(_FINDER_COLUMN_DARKTHEMEANDSTATUS_STATUS_2);

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
			sb.append(PersonaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(channelId);

		queryPos.add(darkThemeId.longValue());

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(persona)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Persona> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the personas where channelId = &#63; and darkThemeId = &#63; and status = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param darkThemeId the dark theme ID
	 * @param status the status
	 */
	@Override
	public void removeBydarkThemeAndStatus(
		long channelId, Long darkThemeId, int status) {

		for (Persona persona :
				findBydarkThemeAndStatus(
					channelId, darkThemeId, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(persona);
		}
	}

	/**
	 * Returns the number of personas where channelId = &#63; and darkThemeId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param darkThemeId the dark theme ID
	 * @param status the status
	 * @return the number of matching personas
	 */
	@Override
	public int countBydarkThemeAndStatus(
		long channelId, Long darkThemeId, int status) {

		FinderPath finderPath = _finderPathCountBydarkThemeAndStatus;

		Object[] finderArgs = new Object[] {channelId, darkThemeId, status};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_PERSONA_WHERE);

			sb.append(_FINDER_COLUMN_DARKTHEMEANDSTATUS_CHANNELID_2);

			sb.append(_FINDER_COLUMN_DARKTHEMEANDSTATUS_DARKTHEMEID_2);

			sb.append(_FINDER_COLUMN_DARKTHEMEANDSTATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				queryPos.add(darkThemeId.longValue());

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

	private static final String _FINDER_COLUMN_DARKTHEMEANDSTATUS_CHANNELID_2 =
		"persona.channelId = ? AND ";

	private static final String
		_FINDER_COLUMN_DARKTHEMEANDSTATUS_DARKTHEMEID_2 =
			"persona.darkThemeId = ? AND ";

	private static final String _FINDER_COLUMN_DARKTHEMEANDSTATUS_STATUS_2 =
		"persona.status = ?";

	private FinderPath _finderPathWithPaginationFindByChannelIdAndStatus;
	private FinderPath _finderPathWithoutPaginationFindByChannelIdAndStatus;
	private FinderPath _finderPathCountByChannelIdAndStatus;

	/**
	 * Returns all the personas where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @return the matching personas
	 */
	@Override
	public List<Persona> findByChannelIdAndStatus(long channelId, int status) {
		return findByChannelIdAndStatus(
			channelId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the personas where channelId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @return the range of matching personas
	 */
	@Override
	public List<Persona> findByChannelIdAndStatus(
		long channelId, int status, int start, int end) {

		return findByChannelIdAndStatus(channelId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the personas where channelId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching personas
	 */
	@Override
	public List<Persona> findByChannelIdAndStatus(
		long channelId, int status, int start, int end,
		OrderByComparator<Persona> orderByComparator) {

		return findByChannelIdAndStatus(
			channelId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the personas where channelId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching personas
	 */
	@Override
	public List<Persona> findByChannelIdAndStatus(
		long channelId, int status, int start, int end,
		OrderByComparator<Persona> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByChannelIdAndStatus;
				finderArgs = new Object[] {channelId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByChannelIdAndStatus;
			finderArgs = new Object[] {
				channelId, status, start, end, orderByComparator
			};
		}

		List<Persona> list = null;

		if (useFinderCache) {
			list = (List<Persona>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Persona persona : list) {
					if ((channelId != persona.getChannelId()) ||
						(status != persona.getStatus())) {

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

			sb.append(_SQL_SELECT_PERSONA_WHERE);

			sb.append(_FINDER_COLUMN_CHANNELIDANDSTATUS_CHANNELID_2);

			sb.append(_FINDER_COLUMN_CHANNELIDANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PersonaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				queryPos.add(status);

				list = (List<Persona>)QueryUtil.list(
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
	 * Returns the first persona in the ordered set where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona
	 * @throws NoSuchPersonaException if a matching persona could not be found
	 */
	@Override
	public Persona findByChannelIdAndStatus_First(
			long channelId, int status,
			OrderByComparator<Persona> orderByComparator)
		throws NoSuchPersonaException {

		Persona persona = fetchByChannelIdAndStatus_First(
			channelId, status, orderByComparator);

		if (persona != null) {
			return persona;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchPersonaException(sb.toString());
	}

	/**
	 * Returns the first persona in the ordered set where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona, or <code>null</code> if a matching persona could not be found
	 */
	@Override
	public Persona fetchByChannelIdAndStatus_First(
		long channelId, int status,
		OrderByComparator<Persona> orderByComparator) {

		List<Persona> list = findByChannelIdAndStatus(
			channelId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last persona in the ordered set where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona
	 * @throws NoSuchPersonaException if a matching persona could not be found
	 */
	@Override
	public Persona findByChannelIdAndStatus_Last(
			long channelId, int status,
			OrderByComparator<Persona> orderByComparator)
		throws NoSuchPersonaException {

		Persona persona = fetchByChannelIdAndStatus_Last(
			channelId, status, orderByComparator);

		if (persona != null) {
			return persona;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchPersonaException(sb.toString());
	}

	/**
	 * Returns the last persona in the ordered set where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona, or <code>null</code> if a matching persona could not be found
	 */
	@Override
	public Persona fetchByChannelIdAndStatus_Last(
		long channelId, int status,
		OrderByComparator<Persona> orderByComparator) {

		int count = countByChannelIdAndStatus(channelId, status);

		if (count == 0) {
			return null;
		}

		List<Persona> list = findByChannelIdAndStatus(
			channelId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the personas before and after the current persona in the ordered set where channelId = &#63; and status = &#63;.
	 *
	 * @param personaId the primary key of the current persona
	 * @param channelId the channel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persona
	 * @throws NoSuchPersonaException if a persona with the primary key could not be found
	 */
	@Override
	public Persona[] findByChannelIdAndStatus_PrevAndNext(
			long personaId, long channelId, int status,
			OrderByComparator<Persona> orderByComparator)
		throws NoSuchPersonaException {

		Persona persona = findByPrimaryKey(personaId);

		Session session = null;

		try {
			session = openSession();

			Persona[] array = new PersonaImpl[3];

			array[0] = getByChannelIdAndStatus_PrevAndNext(
				session, persona, channelId, status, orderByComparator, true);

			array[1] = persona;

			array[2] = getByChannelIdAndStatus_PrevAndNext(
				session, persona, channelId, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Persona getByChannelIdAndStatus_PrevAndNext(
		Session session, Persona persona, long channelId, int status,
		OrderByComparator<Persona> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PERSONA_WHERE);

		sb.append(_FINDER_COLUMN_CHANNELIDANDSTATUS_CHANNELID_2);

		sb.append(_FINDER_COLUMN_CHANNELIDANDSTATUS_STATUS_2);

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
			sb.append(PersonaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(channelId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(persona)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Persona> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the personas where channelId = &#63; and status = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 */
	@Override
	public void removeByChannelIdAndStatus(long channelId, int status) {
		for (Persona persona :
				findByChannelIdAndStatus(
					channelId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(persona);
		}
	}

	/**
	 * Returns the number of personas where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @return the number of matching personas
	 */
	@Override
	public int countByChannelIdAndStatus(long channelId, int status) {
		FinderPath finderPath = _finderPathCountByChannelIdAndStatus;

		Object[] finderArgs = new Object[] {channelId, status};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PERSONA_WHERE);

			sb.append(_FINDER_COLUMN_CHANNELIDANDSTATUS_CHANNELID_2);

			sb.append(_FINDER_COLUMN_CHANNELIDANDSTATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

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

	private static final String _FINDER_COLUMN_CHANNELIDANDSTATUS_CHANNELID_2 =
		"persona.channelId = ? AND ";

	private static final String _FINDER_COLUMN_CHANNELIDANDSTATUS_STATUS_2 =
		"persona.status = ?";

	private FinderPath _finderPathWithPaginationFindBydefaultPersonaAndStatus;
	private FinderPath
		_finderPathWithoutPaginationFindBydefaultPersonaAndStatus;
	private FinderPath _finderPathCountBydefaultPersonaAndStatus;

	/**
	 * Returns all the personas where channelId = &#63; and defaultPersona = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param defaultPersona the default persona
	 * @param status the status
	 * @return the matching personas
	 */
	@Override
	public List<Persona> findBydefaultPersonaAndStatus(
		long channelId, boolean defaultPersona, int status) {

		return findBydefaultPersonaAndStatus(
			channelId, defaultPersona, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the personas where channelId = &#63; and defaultPersona = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param defaultPersona the default persona
	 * @param status the status
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @return the range of matching personas
	 */
	@Override
	public List<Persona> findBydefaultPersonaAndStatus(
		long channelId, boolean defaultPersona, int status, int start,
		int end) {

		return findBydefaultPersonaAndStatus(
			channelId, defaultPersona, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the personas where channelId = &#63; and defaultPersona = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param defaultPersona the default persona
	 * @param status the status
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching personas
	 */
	@Override
	public List<Persona> findBydefaultPersonaAndStatus(
		long channelId, boolean defaultPersona, int status, int start, int end,
		OrderByComparator<Persona> orderByComparator) {

		return findBydefaultPersonaAndStatus(
			channelId, defaultPersona, status, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the personas where channelId = &#63; and defaultPersona = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param defaultPersona the default persona
	 * @param status the status
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching personas
	 */
	@Override
	public List<Persona> findBydefaultPersonaAndStatus(
		long channelId, boolean defaultPersona, int status, int start, int end,
		OrderByComparator<Persona> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBydefaultPersonaAndStatus;
				finderArgs = new Object[] {channelId, defaultPersona, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBydefaultPersonaAndStatus;
			finderArgs = new Object[] {
				channelId, defaultPersona, status, start, end, orderByComparator
			};
		}

		List<Persona> list = null;

		if (useFinderCache) {
			list = (List<Persona>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Persona persona : list) {
					if ((channelId != persona.getChannelId()) ||
						(defaultPersona != persona.isDefaultPersona()) ||
						(status != persona.getStatus())) {

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

			sb.append(_SQL_SELECT_PERSONA_WHERE);

			sb.append(_FINDER_COLUMN_DEFAULTPERSONAANDSTATUS_CHANNELID_2);

			sb.append(_FINDER_COLUMN_DEFAULTPERSONAANDSTATUS_DEFAULTPERSONA_2);

			sb.append(_FINDER_COLUMN_DEFAULTPERSONAANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PersonaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				queryPos.add(defaultPersona);

				queryPos.add(status);

				list = (List<Persona>)QueryUtil.list(
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
	 * Returns the first persona in the ordered set where channelId = &#63; and defaultPersona = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param defaultPersona the default persona
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona
	 * @throws NoSuchPersonaException if a matching persona could not be found
	 */
	@Override
	public Persona findBydefaultPersonaAndStatus_First(
			long channelId, boolean defaultPersona, int status,
			OrderByComparator<Persona> orderByComparator)
		throws NoSuchPersonaException {

		Persona persona = fetchBydefaultPersonaAndStatus_First(
			channelId, defaultPersona, status, orderByComparator);

		if (persona != null) {
			return persona;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append(", defaultPersona=");
		sb.append(defaultPersona);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchPersonaException(sb.toString());
	}

	/**
	 * Returns the first persona in the ordered set where channelId = &#63; and defaultPersona = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param defaultPersona the default persona
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona, or <code>null</code> if a matching persona could not be found
	 */
	@Override
	public Persona fetchBydefaultPersonaAndStatus_First(
		long channelId, boolean defaultPersona, int status,
		OrderByComparator<Persona> orderByComparator) {

		List<Persona> list = findBydefaultPersonaAndStatus(
			channelId, defaultPersona, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last persona in the ordered set where channelId = &#63; and defaultPersona = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param defaultPersona the default persona
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona
	 * @throws NoSuchPersonaException if a matching persona could not be found
	 */
	@Override
	public Persona findBydefaultPersonaAndStatus_Last(
			long channelId, boolean defaultPersona, int status,
			OrderByComparator<Persona> orderByComparator)
		throws NoSuchPersonaException {

		Persona persona = fetchBydefaultPersonaAndStatus_Last(
			channelId, defaultPersona, status, orderByComparator);

		if (persona != null) {
			return persona;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append(", defaultPersona=");
		sb.append(defaultPersona);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchPersonaException(sb.toString());
	}

	/**
	 * Returns the last persona in the ordered set where channelId = &#63; and defaultPersona = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param defaultPersona the default persona
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona, or <code>null</code> if a matching persona could not be found
	 */
	@Override
	public Persona fetchBydefaultPersonaAndStatus_Last(
		long channelId, boolean defaultPersona, int status,
		OrderByComparator<Persona> orderByComparator) {

		int count = countBydefaultPersonaAndStatus(
			channelId, defaultPersona, status);

		if (count == 0) {
			return null;
		}

		List<Persona> list = findBydefaultPersonaAndStatus(
			channelId, defaultPersona, status, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the personas before and after the current persona in the ordered set where channelId = &#63; and defaultPersona = &#63; and status = &#63;.
	 *
	 * @param personaId the primary key of the current persona
	 * @param channelId the channel ID
	 * @param defaultPersona the default persona
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persona
	 * @throws NoSuchPersonaException if a persona with the primary key could not be found
	 */
	@Override
	public Persona[] findBydefaultPersonaAndStatus_PrevAndNext(
			long personaId, long channelId, boolean defaultPersona, int status,
			OrderByComparator<Persona> orderByComparator)
		throws NoSuchPersonaException {

		Persona persona = findByPrimaryKey(personaId);

		Session session = null;

		try {
			session = openSession();

			Persona[] array = new PersonaImpl[3];

			array[0] = getBydefaultPersonaAndStatus_PrevAndNext(
				session, persona, channelId, defaultPersona, status,
				orderByComparator, true);

			array[1] = persona;

			array[2] = getBydefaultPersonaAndStatus_PrevAndNext(
				session, persona, channelId, defaultPersona, status,
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

	protected Persona getBydefaultPersonaAndStatus_PrevAndNext(
		Session session, Persona persona, long channelId,
		boolean defaultPersona, int status,
		OrderByComparator<Persona> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_PERSONA_WHERE);

		sb.append(_FINDER_COLUMN_DEFAULTPERSONAANDSTATUS_CHANNELID_2);

		sb.append(_FINDER_COLUMN_DEFAULTPERSONAANDSTATUS_DEFAULTPERSONA_2);

		sb.append(_FINDER_COLUMN_DEFAULTPERSONAANDSTATUS_STATUS_2);

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
			sb.append(PersonaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(channelId);

		queryPos.add(defaultPersona);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(persona)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Persona> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the personas where channelId = &#63; and defaultPersona = &#63; and status = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param defaultPersona the default persona
	 * @param status the status
	 */
	@Override
	public void removeBydefaultPersonaAndStatus(
		long channelId, boolean defaultPersona, int status) {

		for (Persona persona :
				findBydefaultPersonaAndStatus(
					channelId, defaultPersona, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(persona);
		}
	}

	/**
	 * Returns the number of personas where channelId = &#63; and defaultPersona = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param defaultPersona the default persona
	 * @param status the status
	 * @return the number of matching personas
	 */
	@Override
	public int countBydefaultPersonaAndStatus(
		long channelId, boolean defaultPersona, int status) {

		FinderPath finderPath = _finderPathCountBydefaultPersonaAndStatus;

		Object[] finderArgs = new Object[] {channelId, defaultPersona, status};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_PERSONA_WHERE);

			sb.append(_FINDER_COLUMN_DEFAULTPERSONAANDSTATUS_CHANNELID_2);

			sb.append(_FINDER_COLUMN_DEFAULTPERSONAANDSTATUS_DEFAULTPERSONA_2);

			sb.append(_FINDER_COLUMN_DEFAULTPERSONAANDSTATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				queryPos.add(defaultPersona);

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

	private static final String
		_FINDER_COLUMN_DEFAULTPERSONAANDSTATUS_CHANNELID_2 =
			"persona.channelId = ? AND ";

	private static final String
		_FINDER_COLUMN_DEFAULTPERSONAANDSTATUS_DEFAULTPERSONA_2 =
			"persona.defaultPersona = ? AND ";

	private static final String
		_FINDER_COLUMN_DEFAULTPERSONAANDSTATUS_STATUS_2 = "persona.status = ?";

	private FinderPath _finderPathWithPaginationFindByentityResourceId;
	private FinderPath _finderPathWithoutPaginationFindByentityResourceId;
	private FinderPath _finderPathCountByentityResourceId;

	/**
	 * Returns all the personas where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the matching personas
	 */
	@Override
	public List<Persona> findByentityResourceId(long entityResourceId) {
		return findByentityResourceId(
			entityResourceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the personas where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @return the range of matching personas
	 */
	@Override
	public List<Persona> findByentityResourceId(
		long entityResourceId, int start, int end) {

		return findByentityResourceId(entityResourceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the personas where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching personas
	 */
	@Override
	public List<Persona> findByentityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<Persona> orderByComparator) {

		return findByentityResourceId(
			entityResourceId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the personas where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching personas
	 */
	@Override
	public List<Persona> findByentityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<Persona> orderByComparator, boolean useFinderCache) {

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

		List<Persona> list = null;

		if (useFinderCache) {
			list = (List<Persona>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Persona persona : list) {
					if (entityResourceId != persona.getEntityResourceId()) {
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

			sb.append(_SQL_SELECT_PERSONA_WHERE);

			sb.append(_FINDER_COLUMN_ENTITYRESOURCEID_ENTITYRESOURCEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PersonaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(entityResourceId);

				list = (List<Persona>)QueryUtil.list(
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
	 * Returns the first persona in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona
	 * @throws NoSuchPersonaException if a matching persona could not be found
	 */
	@Override
	public Persona findByentityResourceId_First(
			long entityResourceId, OrderByComparator<Persona> orderByComparator)
		throws NoSuchPersonaException {

		Persona persona = fetchByentityResourceId_First(
			entityResourceId, orderByComparator);

		if (persona != null) {
			return persona;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("entityResourceId=");
		sb.append(entityResourceId);

		sb.append("}");

		throw new NoSuchPersonaException(sb.toString());
	}

	/**
	 * Returns the first persona in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona, or <code>null</code> if a matching persona could not be found
	 */
	@Override
	public Persona fetchByentityResourceId_First(
		long entityResourceId, OrderByComparator<Persona> orderByComparator) {

		List<Persona> list = findByentityResourceId(
			entityResourceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last persona in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona
	 * @throws NoSuchPersonaException if a matching persona could not be found
	 */
	@Override
	public Persona findByentityResourceId_Last(
			long entityResourceId, OrderByComparator<Persona> orderByComparator)
		throws NoSuchPersonaException {

		Persona persona = fetchByentityResourceId_Last(
			entityResourceId, orderByComparator);

		if (persona != null) {
			return persona;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("entityResourceId=");
		sb.append(entityResourceId);

		sb.append("}");

		throw new NoSuchPersonaException(sb.toString());
	}

	/**
	 * Returns the last persona in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona, or <code>null</code> if a matching persona could not be found
	 */
	@Override
	public Persona fetchByentityResourceId_Last(
		long entityResourceId, OrderByComparator<Persona> orderByComparator) {

		int count = countByentityResourceId(entityResourceId);

		if (count == 0) {
			return null;
		}

		List<Persona> list = findByentityResourceId(
			entityResourceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the personas before and after the current persona in the ordered set where entityResourceId = &#63;.
	 *
	 * @param personaId the primary key of the current persona
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persona
	 * @throws NoSuchPersonaException if a persona with the primary key could not be found
	 */
	@Override
	public Persona[] findByentityResourceId_PrevAndNext(
			long personaId, long entityResourceId,
			OrderByComparator<Persona> orderByComparator)
		throws NoSuchPersonaException {

		Persona persona = findByPrimaryKey(personaId);

		Session session = null;

		try {
			session = openSession();

			Persona[] array = new PersonaImpl[3];

			array[0] = getByentityResourceId_PrevAndNext(
				session, persona, entityResourceId, orderByComparator, true);

			array[1] = persona;

			array[2] = getByentityResourceId_PrevAndNext(
				session, persona, entityResourceId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Persona getByentityResourceId_PrevAndNext(
		Session session, Persona persona, long entityResourceId,
		OrderByComparator<Persona> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PERSONA_WHERE);

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
			sb.append(PersonaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(entityResourceId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(persona)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Persona> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the personas where entityResourceId = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 */
	@Override
	public void removeByentityResourceId(long entityResourceId) {
		for (Persona persona :
				findByentityResourceId(
					entityResourceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(persona);
		}
	}

	/**
	 * Returns the number of personas where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the number of matching personas
	 */
	@Override
	public int countByentityResourceId(long entityResourceId) {
		FinderPath finderPath = _finderPathCountByentityResourceId;

		Object[] finderArgs = new Object[] {entityResourceId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PERSONA_WHERE);

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
			"persona.entityResourceId = ?";

	private FinderPath _finderPathWithPaginationFindByentityResourceIdAndStatus;
	private FinderPath
		_finderPathWithoutPaginationFindByentityResourceIdAndStatus;
	private FinderPath _finderPathCountByentityResourceIdAndStatus;

	/**
	 * Returns all the personas where entityResourceId = &#63; and status = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @return the matching personas
	 */
	@Override
	public List<Persona> findByentityResourceIdAndStatus(
		long entityResourceId, int status) {

		return findByentityResourceIdAndStatus(
			entityResourceId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the personas where entityResourceId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @return the range of matching personas
	 */
	@Override
	public List<Persona> findByentityResourceIdAndStatus(
		long entityResourceId, int status, int start, int end) {

		return findByentityResourceIdAndStatus(
			entityResourceId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the personas where entityResourceId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching personas
	 */
	@Override
	public List<Persona> findByentityResourceIdAndStatus(
		long entityResourceId, int status, int start, int end,
		OrderByComparator<Persona> orderByComparator) {

		return findByentityResourceIdAndStatus(
			entityResourceId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the personas where entityResourceId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching personas
	 */
	@Override
	public List<Persona> findByentityResourceIdAndStatus(
		long entityResourceId, int status, int start, int end,
		OrderByComparator<Persona> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByentityResourceIdAndStatus;
				finderArgs = new Object[] {entityResourceId, status};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByentityResourceIdAndStatus;
			finderArgs = new Object[] {
				entityResourceId, status, start, end, orderByComparator
			};
		}

		List<Persona> list = null;

		if (useFinderCache) {
			list = (List<Persona>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Persona persona : list) {
					if ((entityResourceId != persona.getEntityResourceId()) ||
						(status != persona.getStatus())) {

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

			sb.append(_SQL_SELECT_PERSONA_WHERE);

			sb.append(
				_FINDER_COLUMN_ENTITYRESOURCEIDANDSTATUS_ENTITYRESOURCEID_2);

			sb.append(_FINDER_COLUMN_ENTITYRESOURCEIDANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PersonaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(entityResourceId);

				queryPos.add(status);

				list = (List<Persona>)QueryUtil.list(
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
	 * Returns the first persona in the ordered set where entityResourceId = &#63; and status = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona
	 * @throws NoSuchPersonaException if a matching persona could not be found
	 */
	@Override
	public Persona findByentityResourceIdAndStatus_First(
			long entityResourceId, int status,
			OrderByComparator<Persona> orderByComparator)
		throws NoSuchPersonaException {

		Persona persona = fetchByentityResourceIdAndStatus_First(
			entityResourceId, status, orderByComparator);

		if (persona != null) {
			return persona;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("entityResourceId=");
		sb.append(entityResourceId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchPersonaException(sb.toString());
	}

	/**
	 * Returns the first persona in the ordered set where entityResourceId = &#63; and status = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona, or <code>null</code> if a matching persona could not be found
	 */
	@Override
	public Persona fetchByentityResourceIdAndStatus_First(
		long entityResourceId, int status,
		OrderByComparator<Persona> orderByComparator) {

		List<Persona> list = findByentityResourceIdAndStatus(
			entityResourceId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last persona in the ordered set where entityResourceId = &#63; and status = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona
	 * @throws NoSuchPersonaException if a matching persona could not be found
	 */
	@Override
	public Persona findByentityResourceIdAndStatus_Last(
			long entityResourceId, int status,
			OrderByComparator<Persona> orderByComparator)
		throws NoSuchPersonaException {

		Persona persona = fetchByentityResourceIdAndStatus_Last(
			entityResourceId, status, orderByComparator);

		if (persona != null) {
			return persona;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("entityResourceId=");
		sb.append(entityResourceId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchPersonaException(sb.toString());
	}

	/**
	 * Returns the last persona in the ordered set where entityResourceId = &#63; and status = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona, or <code>null</code> if a matching persona could not be found
	 */
	@Override
	public Persona fetchByentityResourceIdAndStatus_Last(
		long entityResourceId, int status,
		OrderByComparator<Persona> orderByComparator) {

		int count = countByentityResourceIdAndStatus(entityResourceId, status);

		if (count == 0) {
			return null;
		}

		List<Persona> list = findByentityResourceIdAndStatus(
			entityResourceId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the personas before and after the current persona in the ordered set where entityResourceId = &#63; and status = &#63;.
	 *
	 * @param personaId the primary key of the current persona
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persona
	 * @throws NoSuchPersonaException if a persona with the primary key could not be found
	 */
	@Override
	public Persona[] findByentityResourceIdAndStatus_PrevAndNext(
			long personaId, long entityResourceId, int status,
			OrderByComparator<Persona> orderByComparator)
		throws NoSuchPersonaException {

		Persona persona = findByPrimaryKey(personaId);

		Session session = null;

		try {
			session = openSession();

			Persona[] array = new PersonaImpl[3];

			array[0] = getByentityResourceIdAndStatus_PrevAndNext(
				session, persona, entityResourceId, status, orderByComparator,
				true);

			array[1] = persona;

			array[2] = getByentityResourceIdAndStatus_PrevAndNext(
				session, persona, entityResourceId, status, orderByComparator,
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

	protected Persona getByentityResourceIdAndStatus_PrevAndNext(
		Session session, Persona persona, long entityResourceId, int status,
		OrderByComparator<Persona> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PERSONA_WHERE);

		sb.append(_FINDER_COLUMN_ENTITYRESOURCEIDANDSTATUS_ENTITYRESOURCEID_2);

		sb.append(_FINDER_COLUMN_ENTITYRESOURCEIDANDSTATUS_STATUS_2);

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
			sb.append(PersonaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(entityResourceId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(persona)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Persona> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the personas where entityResourceId = &#63; and status = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 */
	@Override
	public void removeByentityResourceIdAndStatus(
		long entityResourceId, int status) {

		for (Persona persona :
				findByentityResourceIdAndStatus(
					entityResourceId, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(persona);
		}
	}

	/**
	 * Returns the number of personas where entityResourceId = &#63; and status = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @return the number of matching personas
	 */
	@Override
	public int countByentityResourceIdAndStatus(
		long entityResourceId, int status) {

		FinderPath finderPath = _finderPathCountByentityResourceIdAndStatus;

		Object[] finderArgs = new Object[] {entityResourceId, status};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PERSONA_WHERE);

			sb.append(
				_FINDER_COLUMN_ENTITYRESOURCEIDANDSTATUS_ENTITYRESOURCEID_2);

			sb.append(_FINDER_COLUMN_ENTITYRESOURCEIDANDSTATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(entityResourceId);

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

	private static final String
		_FINDER_COLUMN_ENTITYRESOURCEIDANDSTATUS_ENTITYRESOURCEID_2 =
			"persona.entityResourceId = ? AND ";

	private static final String
		_FINDER_COLUMN_ENTITYRESOURCEIDANDSTATUS_STATUS_2 =
			"persona.status = ?";

	public PersonaPersistenceImpl() {
		setModelClass(Persona.class);

		setModelImplClass(PersonaImpl.class);
		setModelPKClass(long.class);

		setTable(PersonaTable.INSTANCE);
	}

	/**
	 * Caches the persona in the entity cache if it is enabled.
	 *
	 * @param persona the persona
	 */
	@Override
	public void cacheResult(Persona persona) {
		dummyEntityCache.putResult(
			PersonaImpl.class, persona.getPrimaryKey(), persona);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the personas in the entity cache if it is enabled.
	 *
	 * @param personas the personas
	 */
	@Override
	public void cacheResult(List<Persona> personas) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (personas.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Persona persona : personas) {
			if (dummyEntityCache.getResult(
					PersonaImpl.class, persona.getPrimaryKey()) == null) {

				cacheResult(persona);
			}
		}
	}

	/**
	 * Clears the cache for all personas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(PersonaImpl.class);

		dummyFinderCache.clearCache(PersonaImpl.class);
	}

	/**
	 * Clears the cache for the persona.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Persona persona) {
		dummyEntityCache.removeResult(PersonaImpl.class, persona);
	}

	@Override
	public void clearCache(List<Persona> personas) {
		for (Persona persona : personas) {
			dummyEntityCache.removeResult(PersonaImpl.class, persona);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(PersonaImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(PersonaImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new persona with the primary key. Does not add the persona to the database.
	 *
	 * @param personaId the primary key for the new persona
	 * @return the new persona
	 */
	@Override
	public Persona create(long personaId) {
		Persona persona = new PersonaImpl();

		persona.setNew(true);
		persona.setPrimaryKey(personaId);

		persona.setCompanyId(CompanyThreadLocal.getCompanyId());

		return persona;
	}

	/**
	 * Removes the persona with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param personaId the primary key of the persona
	 * @return the persona that was removed
	 * @throws NoSuchPersonaException if a persona with the primary key could not be found
	 */
	@Override
	public Persona remove(long personaId) throws NoSuchPersonaException {
		return remove((Serializable)personaId);
	}

	/**
	 * Removes the persona with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the persona
	 * @return the persona that was removed
	 * @throws NoSuchPersonaException if a persona with the primary key could not be found
	 */
	@Override
	public Persona remove(Serializable primaryKey)
		throws NoSuchPersonaException {

		Session session = null;

		try {
			session = openSession();

			Persona persona = (Persona)session.get(
				PersonaImpl.class, primaryKey);

			if (persona == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPersonaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(persona);
		}
		catch (NoSuchPersonaException noSuchEntityException) {
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
	protected Persona removeImpl(Persona persona) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(persona)) {
				persona = (Persona)session.get(
					PersonaImpl.class, persona.getPrimaryKeyObj());
			}

			if (persona != null) {
				session.delete(persona);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (persona != null) {
			clearCache(persona);
		}

		return persona;
	}

	@Override
	public Persona updateImpl(Persona persona) {
		boolean isNew = persona.isNew();

		if (!(persona instanceof PersonaModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(persona.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(persona);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in persona proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Persona implementation " +
					persona.getClass());
		}

		PersonaModelImpl personaModelImpl = (PersonaModelImpl)persona;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (persona.getCreateDate() == null)) {
			if (serviceContext == null) {
				persona.setCreateDate(date);
			}
			else {
				persona.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!personaModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				persona.setModifiedDate(date);
			}
			else {
				persona.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(persona);
			}
			else {
				persona = (Persona)session.merge(persona);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			PersonaImpl.class, personaModelImpl, false, true);

		if (isNew) {
			persona.setNew(false);
		}

		persona.resetOriginalValues();

		return persona;
	}

	/**
	 * Returns the persona with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the persona
	 * @return the persona
	 * @throws NoSuchPersonaException if a persona with the primary key could not be found
	 */
	@Override
	public Persona findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPersonaException {

		Persona persona = fetchByPrimaryKey(primaryKey);

		if (persona == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPersonaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return persona;
	}

	/**
	 * Returns the persona with the primary key or throws a <code>NoSuchPersonaException</code> if it could not be found.
	 *
	 * @param personaId the primary key of the persona
	 * @return the persona
	 * @throws NoSuchPersonaException if a persona with the primary key could not be found
	 */
	@Override
	public Persona findByPrimaryKey(long personaId)
		throws NoSuchPersonaException {

		return findByPrimaryKey((Serializable)personaId);
	}

	/**
	 * Returns the persona with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param personaId the primary key of the persona
	 * @return the persona, or <code>null</code> if a persona with the primary key could not be found
	 */
	@Override
	public Persona fetchByPrimaryKey(long personaId) {
		return fetchByPrimaryKey((Serializable)personaId);
	}

	/**
	 * Returns all the personas.
	 *
	 * @return the personas
	 */
	@Override
	public List<Persona> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the personas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @return the range of personas
	 */
	@Override
	public List<Persona> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the personas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of personas
	 */
	@Override
	public List<Persona> findAll(
		int start, int end, OrderByComparator<Persona> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the personas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of personas
	 */
	@Override
	public List<Persona> findAll(
		int start, int end, OrderByComparator<Persona> orderByComparator,
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

		List<Persona> list = null;

		if (useFinderCache) {
			list = (List<Persona>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PERSONA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PERSONA;

				sql = sql.concat(PersonaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Persona>)QueryUtil.list(
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
	 * Removes all the personas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Persona persona : findAll()) {
			remove(persona);
		}
	}

	/**
	 * Returns the number of personas.
	 *
	 * @return the number of personas
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PERSONA);

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
		return "personaId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PERSONA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PersonaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the persona persistence.
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

		_finderPathWithPaginationFindBylightThemeAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBylightThemeAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"channelId", "lightThemeId", "status"}, true);

		_finderPathWithoutPaginationFindBylightThemeAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBylightThemeAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			new String[] {"channelId", "lightThemeId", "status"}, true);

		_finderPathCountBylightThemeAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBylightThemeAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			new String[] {"channelId", "lightThemeId", "status"}, false);

		_finderPathWithPaginationFindBydarkThemeAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBydarkThemeAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"channelId", "darkThemeId", "status"}, true);

		_finderPathWithoutPaginationFindBydarkThemeAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBydarkThemeAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			new String[] {"channelId", "darkThemeId", "status"}, true);

		_finderPathCountBydarkThemeAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydarkThemeAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			new String[] {"channelId", "darkThemeId", "status"}, false);

		_finderPathWithPaginationFindByChannelIdAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByChannelIdAndStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"channelId", "status"}, true);

		_finderPathWithoutPaginationFindByChannelIdAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByChannelIdAndStatus",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"channelId", "status"}, true);

		_finderPathCountByChannelIdAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByChannelIdAndStatus",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"channelId", "status"}, false);

		_finderPathWithPaginationFindBydefaultPersonaAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBydefaultPersonaAndStatus",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"channelId", "defaultPersona", "status"}, true);

		_finderPathWithoutPaginationFindBydefaultPersonaAndStatus =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBydefaultPersonaAndStatus",
				new String[] {
					Long.class.getName(), Boolean.class.getName(),
					Integer.class.getName()
				},
				new String[] {"channelId", "defaultPersona", "status"}, true);

		_finderPathCountBydefaultPersonaAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydefaultPersonaAndStatus",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName()
			},
			new String[] {"channelId", "defaultPersona", "status"}, false);

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

		_finderPathWithPaginationFindByentityResourceIdAndStatus =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByentityResourceIdAndStatus",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"entityResourceId", "status"}, true);

		_finderPathWithoutPaginationFindByentityResourceIdAndStatus =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByentityResourceIdAndStatus",
				new String[] {Long.class.getName(), Integer.class.getName()},
				new String[] {"entityResourceId", "status"}, true);

		_finderPathCountByentityResourceIdAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByentityResourceIdAndStatus",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"entityResourceId", "status"}, false);

		PersonaUtil.setPersistence(this);
	}

	public void destroy() {
		PersonaUtil.setPersistence(null);

		dummyEntityCache.removeCache(PersonaImpl.class.getName());
	}

	private static final String _SQL_SELECT_PERSONA =
		"SELECT persona FROM Persona persona";

	private static final String _SQL_SELECT_PERSONA_WHERE =
		"SELECT persona FROM Persona persona WHERE ";

	private static final String _SQL_COUNT_PERSONA =
		"SELECT COUNT(persona) FROM Persona persona";

	private static final String _SQL_COUNT_PERSONA_WHERE =
		"SELECT COUNT(persona) FROM Persona persona WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "persona.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Persona exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Persona exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PersonaPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}