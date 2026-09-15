/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence.impl;

import com.ejada.telemony.db.exception.NoSuchLovsLocalizationException;
import com.ejada.telemony.db.model.LovsLocalization;
import com.ejada.telemony.db.model.LovsLocalizationTable;
import com.ejada.telemony.db.model.impl.LovsLocalizationImpl;
import com.ejada.telemony.db.model.impl.LovsLocalizationModelImpl;
import com.ejada.telemony.db.service.persistence.LovsLocalizationPersistence;
import com.ejada.telemony.db.service.persistence.LovsLocalizationUtil;

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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the lovs localization service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LovsLocalizationPersistenceImpl
	extends BasePersistenceImpl<LovsLocalization>
	implements LovsLocalizationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LovsLocalizationUtil</code> to access the lovs localization persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LovsLocalizationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindById;
	private FinderPath _finderPathWithoutPaginationFindById;
	private FinderPath _finderPathCountById;

	/**
	 * Returns all the lovs localizations where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching lovs localizations
	 */
	@Override
	public List<LovsLocalization> findById(long id) {
		return findById(id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lovs localizations where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of lovs localizations
	 * @param end the upper bound of the range of lovs localizations (not inclusive)
	 * @return the range of matching lovs localizations
	 */
	@Override
	public List<LovsLocalization> findById(long id, int start, int end) {
		return findById(id, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lovs localizations where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of lovs localizations
	 * @param end the upper bound of the range of lovs localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lovs localizations
	 */
	@Override
	public List<LovsLocalization> findById(
		long id, int start, int end,
		OrderByComparator<LovsLocalization> orderByComparator) {

		return findById(id, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lovs localizations where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of lovs localizations
	 * @param end the upper bound of the range of lovs localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lovs localizations
	 */
	@Override
	public List<LovsLocalization> findById(
		long id, int start, int end,
		OrderByComparator<LovsLocalization> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindById;
				finderArgs = new Object[] {id};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindById;
			finderArgs = new Object[] {id, start, end, orderByComparator};
		}

		List<LovsLocalization> list = null;

		if (useFinderCache) {
			list = (List<LovsLocalization>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LovsLocalization lovsLocalization : list) {
					if (id != lovsLocalization.getId()) {
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

			sb.append(_SQL_SELECT_LOVSLOCALIZATION_WHERE);

			sb.append(_FINDER_COLUMN_ID_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LovsLocalizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(id);

				list = (List<LovsLocalization>)QueryUtil.list(
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
	 * Returns the first lovs localization in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs localization
	 * @throws NoSuchLovsLocalizationException if a matching lovs localization could not be found
	 */
	@Override
	public LovsLocalization findById_First(
			long id, OrderByComparator<LovsLocalization> orderByComparator)
		throws NoSuchLovsLocalizationException {

		LovsLocalization lovsLocalization = fetchById_First(
			id, orderByComparator);

		if (lovsLocalization != null) {
			return lovsLocalization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("id=");
		sb.append(id);

		sb.append("}");

		throw new NoSuchLovsLocalizationException(sb.toString());
	}

	/**
	 * Returns the first lovs localization in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs localization, or <code>null</code> if a matching lovs localization could not be found
	 */
	@Override
	public LovsLocalization fetchById_First(
		long id, OrderByComparator<LovsLocalization> orderByComparator) {

		List<LovsLocalization> list = findById(id, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lovs localization in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs localization
	 * @throws NoSuchLovsLocalizationException if a matching lovs localization could not be found
	 */
	@Override
	public LovsLocalization findById_Last(
			long id, OrderByComparator<LovsLocalization> orderByComparator)
		throws NoSuchLovsLocalizationException {

		LovsLocalization lovsLocalization = fetchById_Last(
			id, orderByComparator);

		if (lovsLocalization != null) {
			return lovsLocalization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("id=");
		sb.append(id);

		sb.append("}");

		throw new NoSuchLovsLocalizationException(sb.toString());
	}

	/**
	 * Returns the last lovs localization in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs localization, or <code>null</code> if a matching lovs localization could not be found
	 */
	@Override
	public LovsLocalization fetchById_Last(
		long id, OrderByComparator<LovsLocalization> orderByComparator) {

		int count = countById(id);

		if (count == 0) {
			return null;
		}

		List<LovsLocalization> list = findById(
			id, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lovs localizations before and after the current lovs localization in the ordered set where id = &#63;.
	 *
	 * @param lovsLocalizationId the primary key of the current lovs localization
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lovs localization
	 * @throws NoSuchLovsLocalizationException if a lovs localization with the primary key could not be found
	 */
	@Override
	public LovsLocalization[] findById_PrevAndNext(
			long lovsLocalizationId, long id,
			OrderByComparator<LovsLocalization> orderByComparator)
		throws NoSuchLovsLocalizationException {

		LovsLocalization lovsLocalization = findByPrimaryKey(
			lovsLocalizationId);

		Session session = null;

		try {
			session = openSession();

			LovsLocalization[] array = new LovsLocalizationImpl[3];

			array[0] = getById_PrevAndNext(
				session, lovsLocalization, id, orderByComparator, true);

			array[1] = lovsLocalization;

			array[2] = getById_PrevAndNext(
				session, lovsLocalization, id, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LovsLocalization getById_PrevAndNext(
		Session session, LovsLocalization lovsLocalization, long id,
		OrderByComparator<LovsLocalization> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LOVSLOCALIZATION_WHERE);

		sb.append(_FINDER_COLUMN_ID_ID_2);

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
			sb.append(LovsLocalizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(id);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						lovsLocalization)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LovsLocalization> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lovs localizations where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	@Override
	public void removeById(long id) {
		for (LovsLocalization lovsLocalization :
				findById(id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(lovsLocalization);
		}
	}

	/**
	 * Returns the number of lovs localizations where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching lovs localizations
	 */
	@Override
	public int countById(long id) {
		FinderPath finderPath = _finderPathCountById;

		Object[] finderArgs = new Object[] {id};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LOVSLOCALIZATION_WHERE);

			sb.append(_FINDER_COLUMN_ID_ID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(id);

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

	private static final String _FINDER_COLUMN_ID_ID_2 =
		"lovsLocalization.id = ?";

	private FinderPath _finderPathFetchById_LanguageId;

	/**
	 * Returns the lovs localization where id = &#63; and languageId = &#63; or throws a <code>NoSuchLovsLocalizationException</code> if it could not be found.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @return the matching lovs localization
	 * @throws NoSuchLovsLocalizationException if a matching lovs localization could not be found
	 */
	@Override
	public LovsLocalization findById_LanguageId(long id, String languageId)
		throws NoSuchLovsLocalizationException {

		LovsLocalization lovsLocalization = fetchById_LanguageId(
			id, languageId);

		if (lovsLocalization == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("id=");
			sb.append(id);

			sb.append(", languageId=");
			sb.append(languageId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchLovsLocalizationException(sb.toString());
		}

		return lovsLocalization;
	}

	/**
	 * Returns the lovs localization where id = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @return the matching lovs localization, or <code>null</code> if a matching lovs localization could not be found
	 */
	@Override
	public LovsLocalization fetchById_LanguageId(long id, String languageId) {
		return fetchById_LanguageId(id, languageId, true);
	}

	/**
	 * Returns the lovs localization where id = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching lovs localization, or <code>null</code> if a matching lovs localization could not be found
	 */
	@Override
	public LovsLocalization fetchById_LanguageId(
		long id, String languageId, boolean useFinderCache) {

		languageId = Objects.toString(languageId, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {id, languageId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchById_LanguageId, finderArgs, this);
		}

		if (result instanceof LovsLocalization) {
			LovsLocalization lovsLocalization = (LovsLocalization)result;

			if ((id != lovsLocalization.getId()) ||
				!Objects.equals(languageId, lovsLocalization.getLanguageId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_LOVSLOCALIZATION_WHERE);

			sb.append(_FINDER_COLUMN_ID_LANGUAGEID_ID_2);

			boolean bindLanguageId = false;

			if (languageId.isEmpty()) {
				sb.append(_FINDER_COLUMN_ID_LANGUAGEID_LANGUAGEID_3);
			}
			else {
				bindLanguageId = true;

				sb.append(_FINDER_COLUMN_ID_LANGUAGEID_LANGUAGEID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(id);

				if (bindLanguageId) {
					queryPos.add(languageId);
				}

				List<LovsLocalization> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchById_LanguageId, finderArgs, list);
					}
				}
				else {
					LovsLocalization lovsLocalization = list.get(0);

					result = lovsLocalization;

					cacheResult(lovsLocalization);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (LovsLocalization)result;
		}
	}

	/**
	 * Removes the lovs localization where id = &#63; and languageId = &#63; from the database.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @return the lovs localization that was removed
	 */
	@Override
	public LovsLocalization removeById_LanguageId(long id, String languageId)
		throws NoSuchLovsLocalizationException {

		LovsLocalization lovsLocalization = findById_LanguageId(id, languageId);

		return remove(lovsLocalization);
	}

	/**
	 * Returns the number of lovs localizations where id = &#63; and languageId = &#63;.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @return the number of matching lovs localizations
	 */
	@Override
	public int countById_LanguageId(long id, String languageId) {
		LovsLocalization lovsLocalization = fetchById_LanguageId(
			id, languageId);

		if (lovsLocalization == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_ID_LANGUAGEID_ID_2 =
		"lovsLocalization.id = ? AND ";

	private static final String _FINDER_COLUMN_ID_LANGUAGEID_LANGUAGEID_2 =
		"lovsLocalization.languageId = ?";

	private static final String _FINDER_COLUMN_ID_LANGUAGEID_LANGUAGEID_3 =
		"(lovsLocalization.languageId IS NULL OR lovsLocalization.languageId = '')";

	private FinderPath _finderPathWithPaginationFindBylangId;
	private FinderPath _finderPathWithoutPaginationFindBylangId;
	private FinderPath _finderPathCountBylangId;

	/**
	 * Returns all the lovs localizations where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @return the matching lovs localizations
	 */
	@Override
	public List<LovsLocalization> findBylangId(String languageId) {
		return findBylangId(
			languageId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lovs localizations where languageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param start the lower bound of the range of lovs localizations
	 * @param end the upper bound of the range of lovs localizations (not inclusive)
	 * @return the range of matching lovs localizations
	 */
	@Override
	public List<LovsLocalization> findBylangId(
		String languageId, int start, int end) {

		return findBylangId(languageId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lovs localizations where languageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param start the lower bound of the range of lovs localizations
	 * @param end the upper bound of the range of lovs localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lovs localizations
	 */
	@Override
	public List<LovsLocalization> findBylangId(
		String languageId, int start, int end,
		OrderByComparator<LovsLocalization> orderByComparator) {

		return findBylangId(languageId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lovs localizations where languageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param start the lower bound of the range of lovs localizations
	 * @param end the upper bound of the range of lovs localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lovs localizations
	 */
	@Override
	public List<LovsLocalization> findBylangId(
		String languageId, int start, int end,
		OrderByComparator<LovsLocalization> orderByComparator,
		boolean useFinderCache) {

		languageId = Objects.toString(languageId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBylangId;
				finderArgs = new Object[] {languageId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBylangId;
			finderArgs = new Object[] {
				languageId, start, end, orderByComparator
			};
		}

		List<LovsLocalization> list = null;

		if (useFinderCache) {
			list = (List<LovsLocalization>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LovsLocalization lovsLocalization : list) {
					if (!languageId.equals(lovsLocalization.getLanguageId())) {
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

			sb.append(_SQL_SELECT_LOVSLOCALIZATION_WHERE);

			boolean bindLanguageId = false;

			if (languageId.isEmpty()) {
				sb.append(_FINDER_COLUMN_LANGID_LANGUAGEID_3);
			}
			else {
				bindLanguageId = true;

				sb.append(_FINDER_COLUMN_LANGID_LANGUAGEID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LovsLocalizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLanguageId) {
					queryPos.add(languageId);
				}

				list = (List<LovsLocalization>)QueryUtil.list(
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
	 * Returns the first lovs localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs localization
	 * @throws NoSuchLovsLocalizationException if a matching lovs localization could not be found
	 */
	@Override
	public LovsLocalization findBylangId_First(
			String languageId,
			OrderByComparator<LovsLocalization> orderByComparator)
		throws NoSuchLovsLocalizationException {

		LovsLocalization lovsLocalization = fetchBylangId_First(
			languageId, orderByComparator);

		if (lovsLocalization != null) {
			return lovsLocalization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("languageId=");
		sb.append(languageId);

		sb.append("}");

		throw new NoSuchLovsLocalizationException(sb.toString());
	}

	/**
	 * Returns the first lovs localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs localization, or <code>null</code> if a matching lovs localization could not be found
	 */
	@Override
	public LovsLocalization fetchBylangId_First(
		String languageId,
		OrderByComparator<LovsLocalization> orderByComparator) {

		List<LovsLocalization> list = findBylangId(
			languageId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lovs localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs localization
	 * @throws NoSuchLovsLocalizationException if a matching lovs localization could not be found
	 */
	@Override
	public LovsLocalization findBylangId_Last(
			String languageId,
			OrderByComparator<LovsLocalization> orderByComparator)
		throws NoSuchLovsLocalizationException {

		LovsLocalization lovsLocalization = fetchBylangId_Last(
			languageId, orderByComparator);

		if (lovsLocalization != null) {
			return lovsLocalization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("languageId=");
		sb.append(languageId);

		sb.append("}");

		throw new NoSuchLovsLocalizationException(sb.toString());
	}

	/**
	 * Returns the last lovs localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs localization, or <code>null</code> if a matching lovs localization could not be found
	 */
	@Override
	public LovsLocalization fetchBylangId_Last(
		String languageId,
		OrderByComparator<LovsLocalization> orderByComparator) {

		int count = countBylangId(languageId);

		if (count == 0) {
			return null;
		}

		List<LovsLocalization> list = findBylangId(
			languageId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lovs localizations before and after the current lovs localization in the ordered set where languageId = &#63;.
	 *
	 * @param lovsLocalizationId the primary key of the current lovs localization
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lovs localization
	 * @throws NoSuchLovsLocalizationException if a lovs localization with the primary key could not be found
	 */
	@Override
	public LovsLocalization[] findBylangId_PrevAndNext(
			long lovsLocalizationId, String languageId,
			OrderByComparator<LovsLocalization> orderByComparator)
		throws NoSuchLovsLocalizationException {

		languageId = Objects.toString(languageId, "");

		LovsLocalization lovsLocalization = findByPrimaryKey(
			lovsLocalizationId);

		Session session = null;

		try {
			session = openSession();

			LovsLocalization[] array = new LovsLocalizationImpl[3];

			array[0] = getBylangId_PrevAndNext(
				session, lovsLocalization, languageId, orderByComparator, true);

			array[1] = lovsLocalization;

			array[2] = getBylangId_PrevAndNext(
				session, lovsLocalization, languageId, orderByComparator,
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

	protected LovsLocalization getBylangId_PrevAndNext(
		Session session, LovsLocalization lovsLocalization, String languageId,
		OrderByComparator<LovsLocalization> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LOVSLOCALIZATION_WHERE);

		boolean bindLanguageId = false;

		if (languageId.isEmpty()) {
			sb.append(_FINDER_COLUMN_LANGID_LANGUAGEID_3);
		}
		else {
			bindLanguageId = true;

			sb.append(_FINDER_COLUMN_LANGID_LANGUAGEID_2);
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
			sb.append(LovsLocalizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindLanguageId) {
			queryPos.add(languageId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						lovsLocalization)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LovsLocalization> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lovs localizations where languageId = &#63; from the database.
	 *
	 * @param languageId the language ID
	 */
	@Override
	public void removeBylangId(String languageId) {
		for (LovsLocalization lovsLocalization :
				findBylangId(
					languageId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(lovsLocalization);
		}
	}

	/**
	 * Returns the number of lovs localizations where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @return the number of matching lovs localizations
	 */
	@Override
	public int countBylangId(String languageId) {
		languageId = Objects.toString(languageId, "");

		FinderPath finderPath = _finderPathCountBylangId;

		Object[] finderArgs = new Object[] {languageId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LOVSLOCALIZATION_WHERE);

			boolean bindLanguageId = false;

			if (languageId.isEmpty()) {
				sb.append(_FINDER_COLUMN_LANGID_LANGUAGEID_3);
			}
			else {
				bindLanguageId = true;

				sb.append(_FINDER_COLUMN_LANGID_LANGUAGEID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLanguageId) {
					queryPos.add(languageId);
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

	private static final String _FINDER_COLUMN_LANGID_LANGUAGEID_2 =
		"lovsLocalization.languageId = ?";

	private static final String _FINDER_COLUMN_LANGID_LANGUAGEID_3 =
		"(lovsLocalization.languageId IS NULL OR lovsLocalization.languageId = '')";

	private FinderPath _finderPathWithPaginationFindBynameAndLanguageId;
	private FinderPath _finderPathWithPaginationCountBynameAndLanguageId;

	/**
	 * Returns all the lovs localizations where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @return the matching lovs localizations
	 */
	@Override
	public List<LovsLocalization> findBynameAndLanguageId(
		String languageId, String name) {

		return findBynameAndLanguageId(
			languageId, name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lovs localizations where languageId = &#63; and name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @param start the lower bound of the range of lovs localizations
	 * @param end the upper bound of the range of lovs localizations (not inclusive)
	 * @return the range of matching lovs localizations
	 */
	@Override
	public List<LovsLocalization> findBynameAndLanguageId(
		String languageId, String name, int start, int end) {

		return findBynameAndLanguageId(languageId, name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lovs localizations where languageId = &#63; and name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @param start the lower bound of the range of lovs localizations
	 * @param end the upper bound of the range of lovs localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lovs localizations
	 */
	@Override
	public List<LovsLocalization> findBynameAndLanguageId(
		String languageId, String name, int start, int end,
		OrderByComparator<LovsLocalization> orderByComparator) {

		return findBynameAndLanguageId(
			languageId, name, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lovs localizations where languageId = &#63; and name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @param start the lower bound of the range of lovs localizations
	 * @param end the upper bound of the range of lovs localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lovs localizations
	 */
	@Override
	public List<LovsLocalization> findBynameAndLanguageId(
		String languageId, String name, int start, int end,
		OrderByComparator<LovsLocalization> orderByComparator,
		boolean useFinderCache) {

		languageId = Objects.toString(languageId, "");
		name = Objects.toString(name, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindBynameAndLanguageId;
		finderArgs = new Object[] {
			languageId, name, start, end, orderByComparator
		};

		List<LovsLocalization> list = null;

		if (useFinderCache) {
			list = (List<LovsLocalization>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LovsLocalization lovsLocalization : list) {
					if (!languageId.equals(lovsLocalization.getLanguageId()) ||
						!StringUtil.wildcardMatches(
							lovsLocalization.getName(), name, '_', '%', '\\',
							true)) {

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

			sb.append(_SQL_SELECT_LOVSLOCALIZATION_WHERE);

			boolean bindLanguageId = false;

			if (languageId.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAMEANDLANGUAGEID_LANGUAGEID_3);
			}
			else {
				bindLanguageId = true;

				sb.append(_FINDER_COLUMN_NAMEANDLANGUAGEID_LANGUAGEID_2);
			}

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAMEANDLANGUAGEID_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAMEANDLANGUAGEID_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LovsLocalizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLanguageId) {
					queryPos.add(languageId);
				}

				if (bindName) {
					queryPos.add(name);
				}

				list = (List<LovsLocalization>)QueryUtil.list(
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
	 * Returns the first lovs localization in the ordered set where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs localization
	 * @throws NoSuchLovsLocalizationException if a matching lovs localization could not be found
	 */
	@Override
	public LovsLocalization findBynameAndLanguageId_First(
			String languageId, String name,
			OrderByComparator<LovsLocalization> orderByComparator)
		throws NoSuchLovsLocalizationException {

		LovsLocalization lovsLocalization = fetchBynameAndLanguageId_First(
			languageId, name, orderByComparator);

		if (lovsLocalization != null) {
			return lovsLocalization;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("languageId=");
		sb.append(languageId);

		sb.append(", nameLIKE");
		sb.append(name);

		sb.append("}");

		throw new NoSuchLovsLocalizationException(sb.toString());
	}

	/**
	 * Returns the first lovs localization in the ordered set where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lovs localization, or <code>null</code> if a matching lovs localization could not be found
	 */
	@Override
	public LovsLocalization fetchBynameAndLanguageId_First(
		String languageId, String name,
		OrderByComparator<LovsLocalization> orderByComparator) {

		List<LovsLocalization> list = findBynameAndLanguageId(
			languageId, name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lovs localization in the ordered set where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs localization
	 * @throws NoSuchLovsLocalizationException if a matching lovs localization could not be found
	 */
	@Override
	public LovsLocalization findBynameAndLanguageId_Last(
			String languageId, String name,
			OrderByComparator<LovsLocalization> orderByComparator)
		throws NoSuchLovsLocalizationException {

		LovsLocalization lovsLocalization = fetchBynameAndLanguageId_Last(
			languageId, name, orderByComparator);

		if (lovsLocalization != null) {
			return lovsLocalization;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("languageId=");
		sb.append(languageId);

		sb.append(", nameLIKE");
		sb.append(name);

		sb.append("}");

		throw new NoSuchLovsLocalizationException(sb.toString());
	}

	/**
	 * Returns the last lovs localization in the ordered set where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lovs localization, or <code>null</code> if a matching lovs localization could not be found
	 */
	@Override
	public LovsLocalization fetchBynameAndLanguageId_Last(
		String languageId, String name,
		OrderByComparator<LovsLocalization> orderByComparator) {

		int count = countBynameAndLanguageId(languageId, name);

		if (count == 0) {
			return null;
		}

		List<LovsLocalization> list = findBynameAndLanguageId(
			languageId, name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lovs localizations before and after the current lovs localization in the ordered set where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param lovsLocalizationId the primary key of the current lovs localization
	 * @param languageId the language ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lovs localization
	 * @throws NoSuchLovsLocalizationException if a lovs localization with the primary key could not be found
	 */
	@Override
	public LovsLocalization[] findBynameAndLanguageId_PrevAndNext(
			long lovsLocalizationId, String languageId, String name,
			OrderByComparator<LovsLocalization> orderByComparator)
		throws NoSuchLovsLocalizationException {

		languageId = Objects.toString(languageId, "");
		name = Objects.toString(name, "");

		LovsLocalization lovsLocalization = findByPrimaryKey(
			lovsLocalizationId);

		Session session = null;

		try {
			session = openSession();

			LovsLocalization[] array = new LovsLocalizationImpl[3];

			array[0] = getBynameAndLanguageId_PrevAndNext(
				session, lovsLocalization, languageId, name, orderByComparator,
				true);

			array[1] = lovsLocalization;

			array[2] = getBynameAndLanguageId_PrevAndNext(
				session, lovsLocalization, languageId, name, orderByComparator,
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

	protected LovsLocalization getBynameAndLanguageId_PrevAndNext(
		Session session, LovsLocalization lovsLocalization, String languageId,
		String name, OrderByComparator<LovsLocalization> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_LOVSLOCALIZATION_WHERE);

		boolean bindLanguageId = false;

		if (languageId.isEmpty()) {
			sb.append(_FINDER_COLUMN_NAMEANDLANGUAGEID_LANGUAGEID_3);
		}
		else {
			bindLanguageId = true;

			sb.append(_FINDER_COLUMN_NAMEANDLANGUAGEID_LANGUAGEID_2);
		}

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_NAMEANDLANGUAGEID_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_NAMEANDLANGUAGEID_NAME_2);
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
			sb.append(LovsLocalizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindLanguageId) {
			queryPos.add(languageId);
		}

		if (bindName) {
			queryPos.add(name);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						lovsLocalization)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LovsLocalization> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lovs localizations where languageId = &#63; and name LIKE &#63; from the database.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 */
	@Override
	public void removeBynameAndLanguageId(String languageId, String name) {
		for (LovsLocalization lovsLocalization :
				findBynameAndLanguageId(
					languageId, name, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(lovsLocalization);
		}
	}

	/**
	 * Returns the number of lovs localizations where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @return the number of matching lovs localizations
	 */
	@Override
	public int countBynameAndLanguageId(String languageId, String name) {
		languageId = Objects.toString(languageId, "");
		name = Objects.toString(name, "");

		FinderPath finderPath =
			_finderPathWithPaginationCountBynameAndLanguageId;

		Object[] finderArgs = new Object[] {languageId, name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LOVSLOCALIZATION_WHERE);

			boolean bindLanguageId = false;

			if (languageId.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAMEANDLANGUAGEID_LANGUAGEID_3);
			}
			else {
				bindLanguageId = true;

				sb.append(_FINDER_COLUMN_NAMEANDLANGUAGEID_LANGUAGEID_2);
			}

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAMEANDLANGUAGEID_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAMEANDLANGUAGEID_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLanguageId) {
					queryPos.add(languageId);
				}

				if (bindName) {
					queryPos.add(name);
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

	private static final String _FINDER_COLUMN_NAMEANDLANGUAGEID_LANGUAGEID_2 =
		"lovsLocalization.languageId = ? AND ";

	private static final String _FINDER_COLUMN_NAMEANDLANGUAGEID_LANGUAGEID_3 =
		"(lovsLocalization.languageId IS NULL OR lovsLocalization.languageId = '') AND ";

	private static final String _FINDER_COLUMN_NAMEANDLANGUAGEID_NAME_2 =
		"lovsLocalization.name LIKE ?";

	private static final String _FINDER_COLUMN_NAMEANDLANGUAGEID_NAME_3 =
		"(lovsLocalization.name IS NULL OR lovsLocalization.name LIKE '')";

	public LovsLocalizationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(LovsLocalization.class);

		setModelImplClass(LovsLocalizationImpl.class);
		setModelPKClass(long.class);

		setTable(LovsLocalizationTable.INSTANCE);
	}

	/**
	 * Caches the lovs localization in the entity cache if it is enabled.
	 *
	 * @param lovsLocalization the lovs localization
	 */
	@Override
	public void cacheResult(LovsLocalization lovsLocalization) {
		entityCache.putResult(
			LovsLocalizationImpl.class, lovsLocalization.getPrimaryKey(),
			lovsLocalization);

		finderCache.putResult(
			_finderPathFetchById_LanguageId,
			new Object[] {
				lovsLocalization.getId(), lovsLocalization.getLanguageId()
			},
			lovsLocalization);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the lovs localizations in the entity cache if it is enabled.
	 *
	 * @param lovsLocalizations the lovs localizations
	 */
	@Override
	public void cacheResult(List<LovsLocalization> lovsLocalizations) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (lovsLocalizations.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (LovsLocalization lovsLocalization : lovsLocalizations) {
			if (entityCache.getResult(
					LovsLocalizationImpl.class,
					lovsLocalization.getPrimaryKey()) == null) {

				cacheResult(lovsLocalization);
			}
		}
	}

	/**
	 * Clears the cache for all lovs localizations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LovsLocalizationImpl.class);

		finderCache.clearCache(LovsLocalizationImpl.class);
	}

	/**
	 * Clears the cache for the lovs localization.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LovsLocalization lovsLocalization) {
		entityCache.removeResult(LovsLocalizationImpl.class, lovsLocalization);
	}

	@Override
	public void clearCache(List<LovsLocalization> lovsLocalizations) {
		for (LovsLocalization lovsLocalization : lovsLocalizations) {
			entityCache.removeResult(
				LovsLocalizationImpl.class, lovsLocalization);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(LovsLocalizationImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(LovsLocalizationImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		LovsLocalizationModelImpl lovsLocalizationModelImpl) {

		Object[] args = new Object[] {
			lovsLocalizationModelImpl.getId(),
			lovsLocalizationModelImpl.getLanguageId()
		};

		finderCache.putResult(
			_finderPathFetchById_LanguageId, args, lovsLocalizationModelImpl);
	}

	/**
	 * Creates a new lovs localization with the primary key. Does not add the lovs localization to the database.
	 *
	 * @param lovsLocalizationId the primary key for the new lovs localization
	 * @return the new lovs localization
	 */
	@Override
	public LovsLocalization create(long lovsLocalizationId) {
		LovsLocalization lovsLocalization = new LovsLocalizationImpl();

		lovsLocalization.setNew(true);
		lovsLocalization.setPrimaryKey(lovsLocalizationId);

		lovsLocalization.setCompanyId(CompanyThreadLocal.getCompanyId());

		return lovsLocalization;
	}

	/**
	 * Removes the lovs localization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lovsLocalizationId the primary key of the lovs localization
	 * @return the lovs localization that was removed
	 * @throws NoSuchLovsLocalizationException if a lovs localization with the primary key could not be found
	 */
	@Override
	public LovsLocalization remove(long lovsLocalizationId)
		throws NoSuchLovsLocalizationException {

		return remove((Serializable)lovsLocalizationId);
	}

	/**
	 * Removes the lovs localization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lovs localization
	 * @return the lovs localization that was removed
	 * @throws NoSuchLovsLocalizationException if a lovs localization with the primary key could not be found
	 */
	@Override
	public LovsLocalization remove(Serializable primaryKey)
		throws NoSuchLovsLocalizationException {

		Session session = null;

		try {
			session = openSession();

			LovsLocalization lovsLocalization = (LovsLocalization)session.get(
				LovsLocalizationImpl.class, primaryKey);

			if (lovsLocalization == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLovsLocalizationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(lovsLocalization);
		}
		catch (NoSuchLovsLocalizationException noSuchEntityException) {
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
	protected LovsLocalization removeImpl(LovsLocalization lovsLocalization) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(lovsLocalization)) {
				lovsLocalization = (LovsLocalization)session.get(
					LovsLocalizationImpl.class,
					lovsLocalization.getPrimaryKeyObj());
			}

			if (lovsLocalization != null) {
				session.delete(lovsLocalization);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (lovsLocalization != null) {
			clearCache(lovsLocalization);
		}

		return lovsLocalization;
	}

	@Override
	public LovsLocalization updateImpl(LovsLocalization lovsLocalization) {
		boolean isNew = lovsLocalization.isNew();

		if (!(lovsLocalization instanceof LovsLocalizationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(lovsLocalization.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					lovsLocalization);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in lovsLocalization proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LovsLocalization implementation " +
					lovsLocalization.getClass());
		}

		LovsLocalizationModelImpl lovsLocalizationModelImpl =
			(LovsLocalizationModelImpl)lovsLocalization;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(lovsLocalization);
			}
			else {
				lovsLocalization = (LovsLocalization)session.merge(
					lovsLocalization);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			LovsLocalizationImpl.class, lovsLocalizationModelImpl, false, true);

		cacheUniqueFindersCache(lovsLocalizationModelImpl);

		if (isNew) {
			lovsLocalization.setNew(false);
		}

		lovsLocalization.resetOriginalValues();

		return lovsLocalization;
	}

	/**
	 * Returns the lovs localization with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lovs localization
	 * @return the lovs localization
	 * @throws NoSuchLovsLocalizationException if a lovs localization with the primary key could not be found
	 */
	@Override
	public LovsLocalization findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLovsLocalizationException {

		LovsLocalization lovsLocalization = fetchByPrimaryKey(primaryKey);

		if (lovsLocalization == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLovsLocalizationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return lovsLocalization;
	}

	/**
	 * Returns the lovs localization with the primary key or throws a <code>NoSuchLovsLocalizationException</code> if it could not be found.
	 *
	 * @param lovsLocalizationId the primary key of the lovs localization
	 * @return the lovs localization
	 * @throws NoSuchLovsLocalizationException if a lovs localization with the primary key could not be found
	 */
	@Override
	public LovsLocalization findByPrimaryKey(long lovsLocalizationId)
		throws NoSuchLovsLocalizationException {

		return findByPrimaryKey((Serializable)lovsLocalizationId);
	}

	/**
	 * Returns the lovs localization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lovsLocalizationId the primary key of the lovs localization
	 * @return the lovs localization, or <code>null</code> if a lovs localization with the primary key could not be found
	 */
	@Override
	public LovsLocalization fetchByPrimaryKey(long lovsLocalizationId) {
		return fetchByPrimaryKey((Serializable)lovsLocalizationId);
	}

	/**
	 * Returns all the lovs localizations.
	 *
	 * @return the lovs localizations
	 */
	@Override
	public List<LovsLocalization> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lovs localizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lovs localizations
	 * @param end the upper bound of the range of lovs localizations (not inclusive)
	 * @return the range of lovs localizations
	 */
	@Override
	public List<LovsLocalization> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lovs localizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lovs localizations
	 * @param end the upper bound of the range of lovs localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lovs localizations
	 */
	@Override
	public List<LovsLocalization> findAll(
		int start, int end,
		OrderByComparator<LovsLocalization> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lovs localizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovsLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lovs localizations
	 * @param end the upper bound of the range of lovs localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of lovs localizations
	 */
	@Override
	public List<LovsLocalization> findAll(
		int start, int end,
		OrderByComparator<LovsLocalization> orderByComparator,
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

		List<LovsLocalization> list = null;

		if (useFinderCache) {
			list = (List<LovsLocalization>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LOVSLOCALIZATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LOVSLOCALIZATION;

				sql = sql.concat(LovsLocalizationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<LovsLocalization>)QueryUtil.list(
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
	 * Removes all the lovs localizations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LovsLocalization lovsLocalization : findAll()) {
			remove(lovsLocalization);
		}
	}

	/**
	 * Returns the number of lovs localizations.
	 *
	 * @return the number of lovs localizations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_LOVSLOCALIZATION);

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
		return "lovsLocalizationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LOVSLOCALIZATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LovsLocalizationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the lovs localization persistence.
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

		_finderPathWithPaginationFindById = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findById",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"id_"}, true);

		_finderPathWithoutPaginationFindById = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findById",
			new String[] {Long.class.getName()}, new String[] {"id_"}, true);

		_finderPathCountById = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countById",
			new String[] {Long.class.getName()}, new String[] {"id_"}, false);

		_finderPathFetchById_LanguageId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchById_LanguageId",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"id_", "languageId"}, true);

		_finderPathWithPaginationFindBylangId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBylangId",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"languageId"}, true);

		_finderPathWithoutPaginationFindBylangId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBylangId",
			new String[] {String.class.getName()}, new String[] {"languageId"},
			true);

		_finderPathCountBylangId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBylangId",
			new String[] {String.class.getName()}, new String[] {"languageId"},
			false);

		_finderPathWithPaginationFindBynameAndLanguageId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBynameAndLanguageId",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"languageId", "name"}, true);

		_finderPathWithPaginationCountBynameAndLanguageId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countBynameAndLanguageId",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"languageId", "name"}, false);

		LovsLocalizationUtil.setPersistence(this);
	}

	public void destroy() {
		LovsLocalizationUtil.setPersistence(null);

		entityCache.removeCache(LovsLocalizationImpl.class.getName());
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_LOVSLOCALIZATION =
		"SELECT lovsLocalization FROM LovsLocalization lovsLocalization";

	private static final String _SQL_SELECT_LOVSLOCALIZATION_WHERE =
		"SELECT lovsLocalization FROM LovsLocalization lovsLocalization WHERE ";

	private static final String _SQL_COUNT_LOVSLOCALIZATION =
		"SELECT COUNT(lovsLocalization) FROM LovsLocalization lovsLocalization";

	private static final String _SQL_COUNT_LOVSLOCALIZATION_WHERE =
		"SELECT COUNT(lovsLocalization) FROM LovsLocalization lovsLocalization WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "lovsLocalization.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LovsLocalization exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LovsLocalization exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LovsLocalizationPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}