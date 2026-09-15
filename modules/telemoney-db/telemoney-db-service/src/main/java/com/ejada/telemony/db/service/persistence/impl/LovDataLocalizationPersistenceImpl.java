/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence.impl;

import com.ejada.telemony.db.exception.NoSuchLovDataLocalizationException;
import com.ejada.telemony.db.model.LovDataLocalization;
import com.ejada.telemony.db.model.LovDataLocalizationTable;
import com.ejada.telemony.db.model.impl.LovDataLocalizationImpl;
import com.ejada.telemony.db.model.impl.LovDataLocalizationModelImpl;
import com.ejada.telemony.db.service.persistence.LovDataLocalizationPersistence;
import com.ejada.telemony.db.service.persistence.LovDataLocalizationUtil;

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
 * The persistence implementation for the lov data localization service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LovDataLocalizationPersistenceImpl
	extends BasePersistenceImpl<LovDataLocalization>
	implements LovDataLocalizationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LovDataLocalizationUtil</code> to access the lov data localization persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LovDataLocalizationImpl.class.getName();

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
	 * Returns all the lov data localizations where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching lov data localizations
	 */
	@Override
	public List<LovDataLocalization> findById(long id) {
		return findById(id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lov data localizations where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of lov data localizations
	 * @param end the upper bound of the range of lov data localizations (not inclusive)
	 * @return the range of matching lov data localizations
	 */
	@Override
	public List<LovDataLocalization> findById(long id, int start, int end) {
		return findById(id, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lov data localizations where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of lov data localizations
	 * @param end the upper bound of the range of lov data localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lov data localizations
	 */
	@Override
	public List<LovDataLocalization> findById(
		long id, int start, int end,
		OrderByComparator<LovDataLocalization> orderByComparator) {

		return findById(id, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lov data localizations where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of lov data localizations
	 * @param end the upper bound of the range of lov data localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lov data localizations
	 */
	@Override
	public List<LovDataLocalization> findById(
		long id, int start, int end,
		OrderByComparator<LovDataLocalization> orderByComparator,
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

		List<LovDataLocalization> list = null;

		if (useFinderCache) {
			list = (List<LovDataLocalization>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LovDataLocalization lovDataLocalization : list) {
					if (id != lovDataLocalization.getId()) {
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

			sb.append(_SQL_SELECT_LOVDATALOCALIZATION_WHERE);

			sb.append(_FINDER_COLUMN_ID_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LovDataLocalizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(id);

				list = (List<LovDataLocalization>)QueryUtil.list(
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
	 * Returns the first lov data localization in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data localization
	 * @throws NoSuchLovDataLocalizationException if a matching lov data localization could not be found
	 */
	@Override
	public LovDataLocalization findById_First(
			long id, OrderByComparator<LovDataLocalization> orderByComparator)
		throws NoSuchLovDataLocalizationException {

		LovDataLocalization lovDataLocalization = fetchById_First(
			id, orderByComparator);

		if (lovDataLocalization != null) {
			return lovDataLocalization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("id=");
		sb.append(id);

		sb.append("}");

		throw new NoSuchLovDataLocalizationException(sb.toString());
	}

	/**
	 * Returns the first lov data localization in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data localization, or <code>null</code> if a matching lov data localization could not be found
	 */
	@Override
	public LovDataLocalization fetchById_First(
		long id, OrderByComparator<LovDataLocalization> orderByComparator) {

		List<LovDataLocalization> list = findById(id, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lov data localization in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data localization
	 * @throws NoSuchLovDataLocalizationException if a matching lov data localization could not be found
	 */
	@Override
	public LovDataLocalization findById_Last(
			long id, OrderByComparator<LovDataLocalization> orderByComparator)
		throws NoSuchLovDataLocalizationException {

		LovDataLocalization lovDataLocalization = fetchById_Last(
			id, orderByComparator);

		if (lovDataLocalization != null) {
			return lovDataLocalization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("id=");
		sb.append(id);

		sb.append("}");

		throw new NoSuchLovDataLocalizationException(sb.toString());
	}

	/**
	 * Returns the last lov data localization in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data localization, or <code>null</code> if a matching lov data localization could not be found
	 */
	@Override
	public LovDataLocalization fetchById_Last(
		long id, OrderByComparator<LovDataLocalization> orderByComparator) {

		int count = countById(id);

		if (count == 0) {
			return null;
		}

		List<LovDataLocalization> list = findById(
			id, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lov data localizations before and after the current lov data localization in the ordered set where id = &#63;.
	 *
	 * @param lovDataLocalizationId the primary key of the current lov data localization
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lov data localization
	 * @throws NoSuchLovDataLocalizationException if a lov data localization with the primary key could not be found
	 */
	@Override
	public LovDataLocalization[] findById_PrevAndNext(
			long lovDataLocalizationId, long id,
			OrderByComparator<LovDataLocalization> orderByComparator)
		throws NoSuchLovDataLocalizationException {

		LovDataLocalization lovDataLocalization = findByPrimaryKey(
			lovDataLocalizationId);

		Session session = null;

		try {
			session = openSession();

			LovDataLocalization[] array = new LovDataLocalizationImpl[3];

			array[0] = getById_PrevAndNext(
				session, lovDataLocalization, id, orderByComparator, true);

			array[1] = lovDataLocalization;

			array[2] = getById_PrevAndNext(
				session, lovDataLocalization, id, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LovDataLocalization getById_PrevAndNext(
		Session session, LovDataLocalization lovDataLocalization, long id,
		OrderByComparator<LovDataLocalization> orderByComparator,
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

		sb.append(_SQL_SELECT_LOVDATALOCALIZATION_WHERE);

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
			sb.append(LovDataLocalizationModelImpl.ORDER_BY_JPQL);
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
						lovDataLocalization)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LovDataLocalization> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lov data localizations where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	@Override
	public void removeById(long id) {
		for (LovDataLocalization lovDataLocalization :
				findById(id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(lovDataLocalization);
		}
	}

	/**
	 * Returns the number of lov data localizations where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching lov data localizations
	 */
	@Override
	public int countById(long id) {
		FinderPath finderPath = _finderPathCountById;

		Object[] finderArgs = new Object[] {id};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LOVDATALOCALIZATION_WHERE);

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
		"lovDataLocalization.id = ?";

	private FinderPath _finderPathFetchById_LanguageId;

	/**
	 * Returns the lov data localization where id = &#63; and languageId = &#63; or throws a <code>NoSuchLovDataLocalizationException</code> if it could not be found.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @return the matching lov data localization
	 * @throws NoSuchLovDataLocalizationException if a matching lov data localization could not be found
	 */
	@Override
	public LovDataLocalization findById_LanguageId(long id, String languageId)
		throws NoSuchLovDataLocalizationException {

		LovDataLocalization lovDataLocalization = fetchById_LanguageId(
			id, languageId);

		if (lovDataLocalization == null) {
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

			throw new NoSuchLovDataLocalizationException(sb.toString());
		}

		return lovDataLocalization;
	}

	/**
	 * Returns the lov data localization where id = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @return the matching lov data localization, or <code>null</code> if a matching lov data localization could not be found
	 */
	@Override
	public LovDataLocalization fetchById_LanguageId(
		long id, String languageId) {

		return fetchById_LanguageId(id, languageId, true);
	}

	/**
	 * Returns the lov data localization where id = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching lov data localization, or <code>null</code> if a matching lov data localization could not be found
	 */
	@Override
	public LovDataLocalization fetchById_LanguageId(
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

		if (result instanceof LovDataLocalization) {
			LovDataLocalization lovDataLocalization =
				(LovDataLocalization)result;

			if ((id != lovDataLocalization.getId()) ||
				!Objects.equals(
					languageId, lovDataLocalization.getLanguageId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_LOVDATALOCALIZATION_WHERE);

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

				List<LovDataLocalization> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchById_LanguageId, finderArgs, list);
					}
				}
				else {
					LovDataLocalization lovDataLocalization = list.get(0);

					result = lovDataLocalization;

					cacheResult(lovDataLocalization);
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
			return (LovDataLocalization)result;
		}
	}

	/**
	 * Removes the lov data localization where id = &#63; and languageId = &#63; from the database.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @return the lov data localization that was removed
	 */
	@Override
	public LovDataLocalization removeById_LanguageId(long id, String languageId)
		throws NoSuchLovDataLocalizationException {

		LovDataLocalization lovDataLocalization = findById_LanguageId(
			id, languageId);

		return remove(lovDataLocalization);
	}

	/**
	 * Returns the number of lov data localizations where id = &#63; and languageId = &#63;.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @return the number of matching lov data localizations
	 */
	@Override
	public int countById_LanguageId(long id, String languageId) {
		LovDataLocalization lovDataLocalization = fetchById_LanguageId(
			id, languageId);

		if (lovDataLocalization == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_ID_LANGUAGEID_ID_2 =
		"lovDataLocalization.id = ? AND ";

	private static final String _FINDER_COLUMN_ID_LANGUAGEID_LANGUAGEID_2 =
		"lovDataLocalization.languageId = ?";

	private static final String _FINDER_COLUMN_ID_LANGUAGEID_LANGUAGEID_3 =
		"(lovDataLocalization.languageId IS NULL OR lovDataLocalization.languageId = '')";

	private FinderPath _finderPathWithPaginationFindBylangId;
	private FinderPath _finderPathWithoutPaginationFindBylangId;
	private FinderPath _finderPathCountBylangId;

	/**
	 * Returns all the lov data localizations where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @return the matching lov data localizations
	 */
	@Override
	public List<LovDataLocalization> findBylangId(String languageId) {
		return findBylangId(
			languageId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lov data localizations where languageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param start the lower bound of the range of lov data localizations
	 * @param end the upper bound of the range of lov data localizations (not inclusive)
	 * @return the range of matching lov data localizations
	 */
	@Override
	public List<LovDataLocalization> findBylangId(
		String languageId, int start, int end) {

		return findBylangId(languageId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lov data localizations where languageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param start the lower bound of the range of lov data localizations
	 * @param end the upper bound of the range of lov data localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lov data localizations
	 */
	@Override
	public List<LovDataLocalization> findBylangId(
		String languageId, int start, int end,
		OrderByComparator<LovDataLocalization> orderByComparator) {

		return findBylangId(languageId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lov data localizations where languageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param start the lower bound of the range of lov data localizations
	 * @param end the upper bound of the range of lov data localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lov data localizations
	 */
	@Override
	public List<LovDataLocalization> findBylangId(
		String languageId, int start, int end,
		OrderByComparator<LovDataLocalization> orderByComparator,
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

		List<LovDataLocalization> list = null;

		if (useFinderCache) {
			list = (List<LovDataLocalization>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LovDataLocalization lovDataLocalization : list) {
					if (!languageId.equals(
							lovDataLocalization.getLanguageId())) {

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

			sb.append(_SQL_SELECT_LOVDATALOCALIZATION_WHERE);

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
				sb.append(LovDataLocalizationModelImpl.ORDER_BY_JPQL);
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

				list = (List<LovDataLocalization>)QueryUtil.list(
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
	 * Returns the first lov data localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data localization
	 * @throws NoSuchLovDataLocalizationException if a matching lov data localization could not be found
	 */
	@Override
	public LovDataLocalization findBylangId_First(
			String languageId,
			OrderByComparator<LovDataLocalization> orderByComparator)
		throws NoSuchLovDataLocalizationException {

		LovDataLocalization lovDataLocalization = fetchBylangId_First(
			languageId, orderByComparator);

		if (lovDataLocalization != null) {
			return lovDataLocalization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("languageId=");
		sb.append(languageId);

		sb.append("}");

		throw new NoSuchLovDataLocalizationException(sb.toString());
	}

	/**
	 * Returns the first lov data localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data localization, or <code>null</code> if a matching lov data localization could not be found
	 */
	@Override
	public LovDataLocalization fetchBylangId_First(
		String languageId,
		OrderByComparator<LovDataLocalization> orderByComparator) {

		List<LovDataLocalization> list = findBylangId(
			languageId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lov data localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data localization
	 * @throws NoSuchLovDataLocalizationException if a matching lov data localization could not be found
	 */
	@Override
	public LovDataLocalization findBylangId_Last(
			String languageId,
			OrderByComparator<LovDataLocalization> orderByComparator)
		throws NoSuchLovDataLocalizationException {

		LovDataLocalization lovDataLocalization = fetchBylangId_Last(
			languageId, orderByComparator);

		if (lovDataLocalization != null) {
			return lovDataLocalization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("languageId=");
		sb.append(languageId);

		sb.append("}");

		throw new NoSuchLovDataLocalizationException(sb.toString());
	}

	/**
	 * Returns the last lov data localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data localization, or <code>null</code> if a matching lov data localization could not be found
	 */
	@Override
	public LovDataLocalization fetchBylangId_Last(
		String languageId,
		OrderByComparator<LovDataLocalization> orderByComparator) {

		int count = countBylangId(languageId);

		if (count == 0) {
			return null;
		}

		List<LovDataLocalization> list = findBylangId(
			languageId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lov data localizations before and after the current lov data localization in the ordered set where languageId = &#63;.
	 *
	 * @param lovDataLocalizationId the primary key of the current lov data localization
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lov data localization
	 * @throws NoSuchLovDataLocalizationException if a lov data localization with the primary key could not be found
	 */
	@Override
	public LovDataLocalization[] findBylangId_PrevAndNext(
			long lovDataLocalizationId, String languageId,
			OrderByComparator<LovDataLocalization> orderByComparator)
		throws NoSuchLovDataLocalizationException {

		languageId = Objects.toString(languageId, "");

		LovDataLocalization lovDataLocalization = findByPrimaryKey(
			lovDataLocalizationId);

		Session session = null;

		try {
			session = openSession();

			LovDataLocalization[] array = new LovDataLocalizationImpl[3];

			array[0] = getBylangId_PrevAndNext(
				session, lovDataLocalization, languageId, orderByComparator,
				true);

			array[1] = lovDataLocalization;

			array[2] = getBylangId_PrevAndNext(
				session, lovDataLocalization, languageId, orderByComparator,
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

	protected LovDataLocalization getBylangId_PrevAndNext(
		Session session, LovDataLocalization lovDataLocalization,
		String languageId,
		OrderByComparator<LovDataLocalization> orderByComparator,
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

		sb.append(_SQL_SELECT_LOVDATALOCALIZATION_WHERE);

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
			sb.append(LovDataLocalizationModelImpl.ORDER_BY_JPQL);
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
						lovDataLocalization)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LovDataLocalization> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lov data localizations where languageId = &#63; from the database.
	 *
	 * @param languageId the language ID
	 */
	@Override
	public void removeBylangId(String languageId) {
		for (LovDataLocalization lovDataLocalization :
				findBylangId(
					languageId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(lovDataLocalization);
		}
	}

	/**
	 * Returns the number of lov data localizations where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @return the number of matching lov data localizations
	 */
	@Override
	public int countBylangId(String languageId) {
		languageId = Objects.toString(languageId, "");

		FinderPath finderPath = _finderPathCountBylangId;

		Object[] finderArgs = new Object[] {languageId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LOVDATALOCALIZATION_WHERE);

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
		"lovDataLocalization.languageId = ?";

	private static final String _FINDER_COLUMN_LANGID_LANGUAGEID_3 =
		"(lovDataLocalization.languageId IS NULL OR lovDataLocalization.languageId = '')";

	private FinderPath _finderPathWithPaginationFindByLovsId;
	private FinderPath _finderPathWithoutPaginationFindByLovsId;
	private FinderPath _finderPathCountByLovsId;

	/**
	 * Returns all the lov data localizations where lovIdLocalization = &#63; and languageId = &#63;.
	 *
	 * @param lovIdLocalization the lov ID localization
	 * @param languageId the language ID
	 * @return the matching lov data localizations
	 */
	@Override
	public List<LovDataLocalization> findByLovsId(
		String lovIdLocalization, String languageId) {

		return findByLovsId(
			lovIdLocalization, languageId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the lov data localizations where lovIdLocalization = &#63; and languageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param lovIdLocalization the lov ID localization
	 * @param languageId the language ID
	 * @param start the lower bound of the range of lov data localizations
	 * @param end the upper bound of the range of lov data localizations (not inclusive)
	 * @return the range of matching lov data localizations
	 */
	@Override
	public List<LovDataLocalization> findByLovsId(
		String lovIdLocalization, String languageId, int start, int end) {

		return findByLovsId(lovIdLocalization, languageId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lov data localizations where lovIdLocalization = &#63; and languageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param lovIdLocalization the lov ID localization
	 * @param languageId the language ID
	 * @param start the lower bound of the range of lov data localizations
	 * @param end the upper bound of the range of lov data localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lov data localizations
	 */
	@Override
	public List<LovDataLocalization> findByLovsId(
		String lovIdLocalization, String languageId, int start, int end,
		OrderByComparator<LovDataLocalization> orderByComparator) {

		return findByLovsId(
			lovIdLocalization, languageId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lov data localizations where lovIdLocalization = &#63; and languageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param lovIdLocalization the lov ID localization
	 * @param languageId the language ID
	 * @param start the lower bound of the range of lov data localizations
	 * @param end the upper bound of the range of lov data localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lov data localizations
	 */
	@Override
	public List<LovDataLocalization> findByLovsId(
		String lovIdLocalization, String languageId, int start, int end,
		OrderByComparator<LovDataLocalization> orderByComparator,
		boolean useFinderCache) {

		lovIdLocalization = Objects.toString(lovIdLocalization, "");
		languageId = Objects.toString(languageId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByLovsId;
				finderArgs = new Object[] {lovIdLocalization, languageId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByLovsId;
			finderArgs = new Object[] {
				lovIdLocalization, languageId, start, end, orderByComparator
			};
		}

		List<LovDataLocalization> list = null;

		if (useFinderCache) {
			list = (List<LovDataLocalization>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LovDataLocalization lovDataLocalization : list) {
					if (!lovIdLocalization.equals(
							lovDataLocalization.getLovIdLocalization()) ||
						!languageId.equals(
							lovDataLocalization.getLanguageId())) {

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

			sb.append(_SQL_SELECT_LOVDATALOCALIZATION_WHERE);

			boolean bindLovIdLocalization = false;

			if (lovIdLocalization.isEmpty()) {
				sb.append(_FINDER_COLUMN_LOVSID_LOVIDLOCALIZATION_3);
			}
			else {
				bindLovIdLocalization = true;

				sb.append(_FINDER_COLUMN_LOVSID_LOVIDLOCALIZATION_2);
			}

			boolean bindLanguageId = false;

			if (languageId.isEmpty()) {
				sb.append(_FINDER_COLUMN_LOVSID_LANGUAGEID_3);
			}
			else {
				bindLanguageId = true;

				sb.append(_FINDER_COLUMN_LOVSID_LANGUAGEID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LovDataLocalizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLovIdLocalization) {
					queryPos.add(lovIdLocalization);
				}

				if (bindLanguageId) {
					queryPos.add(languageId);
				}

				list = (List<LovDataLocalization>)QueryUtil.list(
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
	 * Returns the first lov data localization in the ordered set where lovIdLocalization = &#63; and languageId = &#63;.
	 *
	 * @param lovIdLocalization the lov ID localization
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data localization
	 * @throws NoSuchLovDataLocalizationException if a matching lov data localization could not be found
	 */
	@Override
	public LovDataLocalization findByLovsId_First(
			String lovIdLocalization, String languageId,
			OrderByComparator<LovDataLocalization> orderByComparator)
		throws NoSuchLovDataLocalizationException {

		LovDataLocalization lovDataLocalization = fetchByLovsId_First(
			lovIdLocalization, languageId, orderByComparator);

		if (lovDataLocalization != null) {
			return lovDataLocalization;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("lovIdLocalization=");
		sb.append(lovIdLocalization);

		sb.append(", languageId=");
		sb.append(languageId);

		sb.append("}");

		throw new NoSuchLovDataLocalizationException(sb.toString());
	}

	/**
	 * Returns the first lov data localization in the ordered set where lovIdLocalization = &#63; and languageId = &#63;.
	 *
	 * @param lovIdLocalization the lov ID localization
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data localization, or <code>null</code> if a matching lov data localization could not be found
	 */
	@Override
	public LovDataLocalization fetchByLovsId_First(
		String lovIdLocalization, String languageId,
		OrderByComparator<LovDataLocalization> orderByComparator) {

		List<LovDataLocalization> list = findByLovsId(
			lovIdLocalization, languageId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lov data localization in the ordered set where lovIdLocalization = &#63; and languageId = &#63;.
	 *
	 * @param lovIdLocalization the lov ID localization
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data localization
	 * @throws NoSuchLovDataLocalizationException if a matching lov data localization could not be found
	 */
	@Override
	public LovDataLocalization findByLovsId_Last(
			String lovIdLocalization, String languageId,
			OrderByComparator<LovDataLocalization> orderByComparator)
		throws NoSuchLovDataLocalizationException {

		LovDataLocalization lovDataLocalization = fetchByLovsId_Last(
			lovIdLocalization, languageId, orderByComparator);

		if (lovDataLocalization != null) {
			return lovDataLocalization;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("lovIdLocalization=");
		sb.append(lovIdLocalization);

		sb.append(", languageId=");
		sb.append(languageId);

		sb.append("}");

		throw new NoSuchLovDataLocalizationException(sb.toString());
	}

	/**
	 * Returns the last lov data localization in the ordered set where lovIdLocalization = &#63; and languageId = &#63;.
	 *
	 * @param lovIdLocalization the lov ID localization
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data localization, or <code>null</code> if a matching lov data localization could not be found
	 */
	@Override
	public LovDataLocalization fetchByLovsId_Last(
		String lovIdLocalization, String languageId,
		OrderByComparator<LovDataLocalization> orderByComparator) {

		int count = countByLovsId(lovIdLocalization, languageId);

		if (count == 0) {
			return null;
		}

		List<LovDataLocalization> list = findByLovsId(
			lovIdLocalization, languageId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lov data localizations before and after the current lov data localization in the ordered set where lovIdLocalization = &#63; and languageId = &#63;.
	 *
	 * @param lovDataLocalizationId the primary key of the current lov data localization
	 * @param lovIdLocalization the lov ID localization
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lov data localization
	 * @throws NoSuchLovDataLocalizationException if a lov data localization with the primary key could not be found
	 */
	@Override
	public LovDataLocalization[] findByLovsId_PrevAndNext(
			long lovDataLocalizationId, String lovIdLocalization,
			String languageId,
			OrderByComparator<LovDataLocalization> orderByComparator)
		throws NoSuchLovDataLocalizationException {

		lovIdLocalization = Objects.toString(lovIdLocalization, "");
		languageId = Objects.toString(languageId, "");

		LovDataLocalization lovDataLocalization = findByPrimaryKey(
			lovDataLocalizationId);

		Session session = null;

		try {
			session = openSession();

			LovDataLocalization[] array = new LovDataLocalizationImpl[3];

			array[0] = getByLovsId_PrevAndNext(
				session, lovDataLocalization, lovIdLocalization, languageId,
				orderByComparator, true);

			array[1] = lovDataLocalization;

			array[2] = getByLovsId_PrevAndNext(
				session, lovDataLocalization, lovIdLocalization, languageId,
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

	protected LovDataLocalization getByLovsId_PrevAndNext(
		Session session, LovDataLocalization lovDataLocalization,
		String lovIdLocalization, String languageId,
		OrderByComparator<LovDataLocalization> orderByComparator,
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

		sb.append(_SQL_SELECT_LOVDATALOCALIZATION_WHERE);

		boolean bindLovIdLocalization = false;

		if (lovIdLocalization.isEmpty()) {
			sb.append(_FINDER_COLUMN_LOVSID_LOVIDLOCALIZATION_3);
		}
		else {
			bindLovIdLocalization = true;

			sb.append(_FINDER_COLUMN_LOVSID_LOVIDLOCALIZATION_2);
		}

		boolean bindLanguageId = false;

		if (languageId.isEmpty()) {
			sb.append(_FINDER_COLUMN_LOVSID_LANGUAGEID_3);
		}
		else {
			bindLanguageId = true;

			sb.append(_FINDER_COLUMN_LOVSID_LANGUAGEID_2);
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
			sb.append(LovDataLocalizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindLovIdLocalization) {
			queryPos.add(lovIdLocalization);
		}

		if (bindLanguageId) {
			queryPos.add(languageId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						lovDataLocalization)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LovDataLocalization> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lov data localizations where lovIdLocalization = &#63; and languageId = &#63; from the database.
	 *
	 * @param lovIdLocalization the lov ID localization
	 * @param languageId the language ID
	 */
	@Override
	public void removeByLovsId(String lovIdLocalization, String languageId) {
		for (LovDataLocalization lovDataLocalization :
				findByLovsId(
					lovIdLocalization, languageId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(lovDataLocalization);
		}
	}

	/**
	 * Returns the number of lov data localizations where lovIdLocalization = &#63; and languageId = &#63;.
	 *
	 * @param lovIdLocalization the lov ID localization
	 * @param languageId the language ID
	 * @return the number of matching lov data localizations
	 */
	@Override
	public int countByLovsId(String lovIdLocalization, String languageId) {
		lovIdLocalization = Objects.toString(lovIdLocalization, "");
		languageId = Objects.toString(languageId, "");

		FinderPath finderPath = _finderPathCountByLovsId;

		Object[] finderArgs = new Object[] {lovIdLocalization, languageId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LOVDATALOCALIZATION_WHERE);

			boolean bindLovIdLocalization = false;

			if (lovIdLocalization.isEmpty()) {
				sb.append(_FINDER_COLUMN_LOVSID_LOVIDLOCALIZATION_3);
			}
			else {
				bindLovIdLocalization = true;

				sb.append(_FINDER_COLUMN_LOVSID_LOVIDLOCALIZATION_2);
			}

			boolean bindLanguageId = false;

			if (languageId.isEmpty()) {
				sb.append(_FINDER_COLUMN_LOVSID_LANGUAGEID_3);
			}
			else {
				bindLanguageId = true;

				sb.append(_FINDER_COLUMN_LOVSID_LANGUAGEID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLovIdLocalization) {
					queryPos.add(lovIdLocalization);
				}

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

	private static final String _FINDER_COLUMN_LOVSID_LOVIDLOCALIZATION_2 =
		"lovDataLocalization.lovIdLocalization = ? AND ";

	private static final String _FINDER_COLUMN_LOVSID_LOVIDLOCALIZATION_3 =
		"(lovDataLocalization.lovIdLocalization IS NULL OR lovDataLocalization.lovIdLocalization = '') AND ";

	private static final String _FINDER_COLUMN_LOVSID_LANGUAGEID_2 =
		"lovDataLocalization.languageId = ?";

	private static final String _FINDER_COLUMN_LOVSID_LANGUAGEID_3 =
		"(lovDataLocalization.languageId IS NULL OR lovDataLocalization.languageId = '')";

	private FinderPath _finderPathWithPaginationFindBydescriptionAndLanguageId;
	private FinderPath _finderPathWithPaginationCountBydescriptionAndLanguageId;

	/**
	 * Returns all the lov data localizations where id = &#63; and languageId = &#63; and recordDescription LIKE &#63;.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @param recordDescription the record description
	 * @return the matching lov data localizations
	 */
	@Override
	public List<LovDataLocalization> findBydescriptionAndLanguageId(
		long id, String languageId, String recordDescription) {

		return findBydescriptionAndLanguageId(
			id, languageId, recordDescription, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lov data localizations where id = &#63; and languageId = &#63; and recordDescription LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @param recordDescription the record description
	 * @param start the lower bound of the range of lov data localizations
	 * @param end the upper bound of the range of lov data localizations (not inclusive)
	 * @return the range of matching lov data localizations
	 */
	@Override
	public List<LovDataLocalization> findBydescriptionAndLanguageId(
		long id, String languageId, String recordDescription, int start,
		int end) {

		return findBydescriptionAndLanguageId(
			id, languageId, recordDescription, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lov data localizations where id = &#63; and languageId = &#63; and recordDescription LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @param recordDescription the record description
	 * @param start the lower bound of the range of lov data localizations
	 * @param end the upper bound of the range of lov data localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lov data localizations
	 */
	@Override
	public List<LovDataLocalization> findBydescriptionAndLanguageId(
		long id, String languageId, String recordDescription, int start,
		int end, OrderByComparator<LovDataLocalization> orderByComparator) {

		return findBydescriptionAndLanguageId(
			id, languageId, recordDescription, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the lov data localizations where id = &#63; and languageId = &#63; and recordDescription LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @param recordDescription the record description
	 * @param start the lower bound of the range of lov data localizations
	 * @param end the upper bound of the range of lov data localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lov data localizations
	 */
	@Override
	public List<LovDataLocalization> findBydescriptionAndLanguageId(
		long id, String languageId, String recordDescription, int start,
		int end, OrderByComparator<LovDataLocalization> orderByComparator,
		boolean useFinderCache) {

		languageId = Objects.toString(languageId, "");
		recordDescription = Objects.toString(recordDescription, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindBydescriptionAndLanguageId;
		finderArgs = new Object[] {
			id, languageId, recordDescription, start, end, orderByComparator
		};

		List<LovDataLocalization> list = null;

		if (useFinderCache) {
			list = (List<LovDataLocalization>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LovDataLocalization lovDataLocalization : list) {
					if ((id != lovDataLocalization.getId()) ||
						!languageId.equals(
							lovDataLocalization.getLanguageId()) ||
						!StringUtil.wildcardMatches(
							lovDataLocalization.getRecordDescription(),
							recordDescription, '_', '%', '\\', true)) {

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

			sb.append(_SQL_SELECT_LOVDATALOCALIZATION_WHERE);

			sb.append(_FINDER_COLUMN_DESCRIPTIONANDLANGUAGEID_ID_2);

			boolean bindLanguageId = false;

			if (languageId.isEmpty()) {
				sb.append(_FINDER_COLUMN_DESCRIPTIONANDLANGUAGEID_LANGUAGEID_3);
			}
			else {
				bindLanguageId = true;

				sb.append(_FINDER_COLUMN_DESCRIPTIONANDLANGUAGEID_LANGUAGEID_2);
			}

			boolean bindRecordDescription = false;

			if (recordDescription.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DESCRIPTIONANDLANGUAGEID_RECORDDESCRIPTION_3);
			}
			else {
				bindRecordDescription = true;

				sb.append(
					_FINDER_COLUMN_DESCRIPTIONANDLANGUAGEID_RECORDDESCRIPTION_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LovDataLocalizationModelImpl.ORDER_BY_JPQL);
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

				if (bindRecordDescription) {
					queryPos.add(recordDescription);
				}

				list = (List<LovDataLocalization>)QueryUtil.list(
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
	 * Returns the first lov data localization in the ordered set where id = &#63; and languageId = &#63; and recordDescription LIKE &#63;.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @param recordDescription the record description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data localization
	 * @throws NoSuchLovDataLocalizationException if a matching lov data localization could not be found
	 */
	@Override
	public LovDataLocalization findBydescriptionAndLanguageId_First(
			long id, String languageId, String recordDescription,
			OrderByComparator<LovDataLocalization> orderByComparator)
		throws NoSuchLovDataLocalizationException {

		LovDataLocalization lovDataLocalization =
			fetchBydescriptionAndLanguageId_First(
				id, languageId, recordDescription, orderByComparator);

		if (lovDataLocalization != null) {
			return lovDataLocalization;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("id=");
		sb.append(id);

		sb.append(", languageId=");
		sb.append(languageId);

		sb.append(", recordDescriptionLIKE");
		sb.append(recordDescription);

		sb.append("}");

		throw new NoSuchLovDataLocalizationException(sb.toString());
	}

	/**
	 * Returns the first lov data localization in the ordered set where id = &#63; and languageId = &#63; and recordDescription LIKE &#63;.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @param recordDescription the record description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lov data localization, or <code>null</code> if a matching lov data localization could not be found
	 */
	@Override
	public LovDataLocalization fetchBydescriptionAndLanguageId_First(
		long id, String languageId, String recordDescription,
		OrderByComparator<LovDataLocalization> orderByComparator) {

		List<LovDataLocalization> list = findBydescriptionAndLanguageId(
			id, languageId, recordDescription, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lov data localization in the ordered set where id = &#63; and languageId = &#63; and recordDescription LIKE &#63;.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @param recordDescription the record description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data localization
	 * @throws NoSuchLovDataLocalizationException if a matching lov data localization could not be found
	 */
	@Override
	public LovDataLocalization findBydescriptionAndLanguageId_Last(
			long id, String languageId, String recordDescription,
			OrderByComparator<LovDataLocalization> orderByComparator)
		throws NoSuchLovDataLocalizationException {

		LovDataLocalization lovDataLocalization =
			fetchBydescriptionAndLanguageId_Last(
				id, languageId, recordDescription, orderByComparator);

		if (lovDataLocalization != null) {
			return lovDataLocalization;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("id=");
		sb.append(id);

		sb.append(", languageId=");
		sb.append(languageId);

		sb.append(", recordDescriptionLIKE");
		sb.append(recordDescription);

		sb.append("}");

		throw new NoSuchLovDataLocalizationException(sb.toString());
	}

	/**
	 * Returns the last lov data localization in the ordered set where id = &#63; and languageId = &#63; and recordDescription LIKE &#63;.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @param recordDescription the record description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lov data localization, or <code>null</code> if a matching lov data localization could not be found
	 */
	@Override
	public LovDataLocalization fetchBydescriptionAndLanguageId_Last(
		long id, String languageId, String recordDescription,
		OrderByComparator<LovDataLocalization> orderByComparator) {

		int count = countBydescriptionAndLanguageId(
			id, languageId, recordDescription);

		if (count == 0) {
			return null;
		}

		List<LovDataLocalization> list = findBydescriptionAndLanguageId(
			id, languageId, recordDescription, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lov data localizations before and after the current lov data localization in the ordered set where id = &#63; and languageId = &#63; and recordDescription LIKE &#63;.
	 *
	 * @param lovDataLocalizationId the primary key of the current lov data localization
	 * @param id the ID
	 * @param languageId the language ID
	 * @param recordDescription the record description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lov data localization
	 * @throws NoSuchLovDataLocalizationException if a lov data localization with the primary key could not be found
	 */
	@Override
	public LovDataLocalization[] findBydescriptionAndLanguageId_PrevAndNext(
			long lovDataLocalizationId, long id, String languageId,
			String recordDescription,
			OrderByComparator<LovDataLocalization> orderByComparator)
		throws NoSuchLovDataLocalizationException {

		languageId = Objects.toString(languageId, "");
		recordDescription = Objects.toString(recordDescription, "");

		LovDataLocalization lovDataLocalization = findByPrimaryKey(
			lovDataLocalizationId);

		Session session = null;

		try {
			session = openSession();

			LovDataLocalization[] array = new LovDataLocalizationImpl[3];

			array[0] = getBydescriptionAndLanguageId_PrevAndNext(
				session, lovDataLocalization, id, languageId, recordDescription,
				orderByComparator, true);

			array[1] = lovDataLocalization;

			array[2] = getBydescriptionAndLanguageId_PrevAndNext(
				session, lovDataLocalization, id, languageId, recordDescription,
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

	protected LovDataLocalization getBydescriptionAndLanguageId_PrevAndNext(
		Session session, LovDataLocalization lovDataLocalization, long id,
		String languageId, String recordDescription,
		OrderByComparator<LovDataLocalization> orderByComparator,
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

		sb.append(_SQL_SELECT_LOVDATALOCALIZATION_WHERE);

		sb.append(_FINDER_COLUMN_DESCRIPTIONANDLANGUAGEID_ID_2);

		boolean bindLanguageId = false;

		if (languageId.isEmpty()) {
			sb.append(_FINDER_COLUMN_DESCRIPTIONANDLANGUAGEID_LANGUAGEID_3);
		}
		else {
			bindLanguageId = true;

			sb.append(_FINDER_COLUMN_DESCRIPTIONANDLANGUAGEID_LANGUAGEID_2);
		}

		boolean bindRecordDescription = false;

		if (recordDescription.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_DESCRIPTIONANDLANGUAGEID_RECORDDESCRIPTION_3);
		}
		else {
			bindRecordDescription = true;

			sb.append(
				_FINDER_COLUMN_DESCRIPTIONANDLANGUAGEID_RECORDDESCRIPTION_2);
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
			sb.append(LovDataLocalizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(id);

		if (bindLanguageId) {
			queryPos.add(languageId);
		}

		if (bindRecordDescription) {
			queryPos.add(recordDescription);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						lovDataLocalization)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LovDataLocalization> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lov data localizations where id = &#63; and languageId = &#63; and recordDescription LIKE &#63; from the database.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @param recordDescription the record description
	 */
	@Override
	public void removeBydescriptionAndLanguageId(
		long id, String languageId, String recordDescription) {

		for (LovDataLocalization lovDataLocalization :
				findBydescriptionAndLanguageId(
					id, languageId, recordDescription, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(lovDataLocalization);
		}
	}

	/**
	 * Returns the number of lov data localizations where id = &#63; and languageId = &#63; and recordDescription LIKE &#63;.
	 *
	 * @param id the ID
	 * @param languageId the language ID
	 * @param recordDescription the record description
	 * @return the number of matching lov data localizations
	 */
	@Override
	public int countBydescriptionAndLanguageId(
		long id, String languageId, String recordDescription) {

		languageId = Objects.toString(languageId, "");
		recordDescription = Objects.toString(recordDescription, "");

		FinderPath finderPath =
			_finderPathWithPaginationCountBydescriptionAndLanguageId;

		Object[] finderArgs = new Object[] {id, languageId, recordDescription};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_LOVDATALOCALIZATION_WHERE);

			sb.append(_FINDER_COLUMN_DESCRIPTIONANDLANGUAGEID_ID_2);

			boolean bindLanguageId = false;

			if (languageId.isEmpty()) {
				sb.append(_FINDER_COLUMN_DESCRIPTIONANDLANGUAGEID_LANGUAGEID_3);
			}
			else {
				bindLanguageId = true;

				sb.append(_FINDER_COLUMN_DESCRIPTIONANDLANGUAGEID_LANGUAGEID_2);
			}

			boolean bindRecordDescription = false;

			if (recordDescription.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DESCRIPTIONANDLANGUAGEID_RECORDDESCRIPTION_3);
			}
			else {
				bindRecordDescription = true;

				sb.append(
					_FINDER_COLUMN_DESCRIPTIONANDLANGUAGEID_RECORDDESCRIPTION_2);
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

				if (bindRecordDescription) {
					queryPos.add(recordDescription);
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

	private static final String _FINDER_COLUMN_DESCRIPTIONANDLANGUAGEID_ID_2 =
		"lovDataLocalization.id = ? AND ";

	private static final String
		_FINDER_COLUMN_DESCRIPTIONANDLANGUAGEID_LANGUAGEID_2 =
			"lovDataLocalization.languageId = ? AND ";

	private static final String
		_FINDER_COLUMN_DESCRIPTIONANDLANGUAGEID_LANGUAGEID_3 =
			"(lovDataLocalization.languageId IS NULL OR lovDataLocalization.languageId = '') AND ";

	private static final String
		_FINDER_COLUMN_DESCRIPTIONANDLANGUAGEID_RECORDDESCRIPTION_2 =
			"lovDataLocalization.recordDescription LIKE ?";

	private static final String
		_FINDER_COLUMN_DESCRIPTIONANDLANGUAGEID_RECORDDESCRIPTION_3 =
			"(lovDataLocalization.recordDescription IS NULL OR lovDataLocalization.recordDescription LIKE '')";

	public LovDataLocalizationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");
		dbColumnNames.put("lovIdLocalization", "lov_id");

		setDBColumnNames(dbColumnNames);

		setModelClass(LovDataLocalization.class);

		setModelImplClass(LovDataLocalizationImpl.class);
		setModelPKClass(long.class);

		setTable(LovDataLocalizationTable.INSTANCE);
	}

	/**
	 * Caches the lov data localization in the entity cache if it is enabled.
	 *
	 * @param lovDataLocalization the lov data localization
	 */
	@Override
	public void cacheResult(LovDataLocalization lovDataLocalization) {
		entityCache.putResult(
			LovDataLocalizationImpl.class, lovDataLocalization.getPrimaryKey(),
			lovDataLocalization);

		finderCache.putResult(
			_finderPathFetchById_LanguageId,
			new Object[] {
				lovDataLocalization.getId(), lovDataLocalization.getLanguageId()
			},
			lovDataLocalization);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the lov data localizations in the entity cache if it is enabled.
	 *
	 * @param lovDataLocalizations the lov data localizations
	 */
	@Override
	public void cacheResult(List<LovDataLocalization> lovDataLocalizations) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (lovDataLocalizations.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (LovDataLocalization lovDataLocalization : lovDataLocalizations) {
			if (entityCache.getResult(
					LovDataLocalizationImpl.class,
					lovDataLocalization.getPrimaryKey()) == null) {

				cacheResult(lovDataLocalization);
			}
		}
	}

	/**
	 * Clears the cache for all lov data localizations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LovDataLocalizationImpl.class);

		finderCache.clearCache(LovDataLocalizationImpl.class);
	}

	/**
	 * Clears the cache for the lov data localization.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LovDataLocalization lovDataLocalization) {
		entityCache.removeResult(
			LovDataLocalizationImpl.class, lovDataLocalization);
	}

	@Override
	public void clearCache(List<LovDataLocalization> lovDataLocalizations) {
		for (LovDataLocalization lovDataLocalization : lovDataLocalizations) {
			entityCache.removeResult(
				LovDataLocalizationImpl.class, lovDataLocalization);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(LovDataLocalizationImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(LovDataLocalizationImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		LovDataLocalizationModelImpl lovDataLocalizationModelImpl) {

		Object[] args = new Object[] {
			lovDataLocalizationModelImpl.getId(),
			lovDataLocalizationModelImpl.getLanguageId()
		};

		finderCache.putResult(
			_finderPathFetchById_LanguageId, args,
			lovDataLocalizationModelImpl);
	}

	/**
	 * Creates a new lov data localization with the primary key. Does not add the lov data localization to the database.
	 *
	 * @param lovDataLocalizationId the primary key for the new lov data localization
	 * @return the new lov data localization
	 */
	@Override
	public LovDataLocalization create(long lovDataLocalizationId) {
		LovDataLocalization lovDataLocalization = new LovDataLocalizationImpl();

		lovDataLocalization.setNew(true);
		lovDataLocalization.setPrimaryKey(lovDataLocalizationId);

		return lovDataLocalization;
	}

	/**
	 * Removes the lov data localization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lovDataLocalizationId the primary key of the lov data localization
	 * @return the lov data localization that was removed
	 * @throws NoSuchLovDataLocalizationException if a lov data localization with the primary key could not be found
	 */
	@Override
	public LovDataLocalization remove(long lovDataLocalizationId)
		throws NoSuchLovDataLocalizationException {

		return remove((Serializable)lovDataLocalizationId);
	}

	/**
	 * Removes the lov data localization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lov data localization
	 * @return the lov data localization that was removed
	 * @throws NoSuchLovDataLocalizationException if a lov data localization with the primary key could not be found
	 */
	@Override
	public LovDataLocalization remove(Serializable primaryKey)
		throws NoSuchLovDataLocalizationException {

		Session session = null;

		try {
			session = openSession();

			LovDataLocalization lovDataLocalization =
				(LovDataLocalization)session.get(
					LovDataLocalizationImpl.class, primaryKey);

			if (lovDataLocalization == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLovDataLocalizationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(lovDataLocalization);
		}
		catch (NoSuchLovDataLocalizationException noSuchEntityException) {
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
	protected LovDataLocalization removeImpl(
		LovDataLocalization lovDataLocalization) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(lovDataLocalization)) {
				lovDataLocalization = (LovDataLocalization)session.get(
					LovDataLocalizationImpl.class,
					lovDataLocalization.getPrimaryKeyObj());
			}

			if (lovDataLocalization != null) {
				session.delete(lovDataLocalization);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (lovDataLocalization != null) {
			clearCache(lovDataLocalization);
		}

		return lovDataLocalization;
	}

	@Override
	public LovDataLocalization updateImpl(
		LovDataLocalization lovDataLocalization) {

		boolean isNew = lovDataLocalization.isNew();

		if (!(lovDataLocalization instanceof LovDataLocalizationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(lovDataLocalization.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					lovDataLocalization);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in lovDataLocalization proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LovDataLocalization implementation " +
					lovDataLocalization.getClass());
		}

		LovDataLocalizationModelImpl lovDataLocalizationModelImpl =
			(LovDataLocalizationModelImpl)lovDataLocalization;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(lovDataLocalization);
			}
			else {
				lovDataLocalization = (LovDataLocalization)session.merge(
					lovDataLocalization);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			LovDataLocalizationImpl.class, lovDataLocalizationModelImpl, false,
			true);

		cacheUniqueFindersCache(lovDataLocalizationModelImpl);

		if (isNew) {
			lovDataLocalization.setNew(false);
		}

		lovDataLocalization.resetOriginalValues();

		return lovDataLocalization;
	}

	/**
	 * Returns the lov data localization with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lov data localization
	 * @return the lov data localization
	 * @throws NoSuchLovDataLocalizationException if a lov data localization with the primary key could not be found
	 */
	@Override
	public LovDataLocalization findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLovDataLocalizationException {

		LovDataLocalization lovDataLocalization = fetchByPrimaryKey(primaryKey);

		if (lovDataLocalization == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLovDataLocalizationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return lovDataLocalization;
	}

	/**
	 * Returns the lov data localization with the primary key or throws a <code>NoSuchLovDataLocalizationException</code> if it could not be found.
	 *
	 * @param lovDataLocalizationId the primary key of the lov data localization
	 * @return the lov data localization
	 * @throws NoSuchLovDataLocalizationException if a lov data localization with the primary key could not be found
	 */
	@Override
	public LovDataLocalization findByPrimaryKey(long lovDataLocalizationId)
		throws NoSuchLovDataLocalizationException {

		return findByPrimaryKey((Serializable)lovDataLocalizationId);
	}

	/**
	 * Returns the lov data localization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lovDataLocalizationId the primary key of the lov data localization
	 * @return the lov data localization, or <code>null</code> if a lov data localization with the primary key could not be found
	 */
	@Override
	public LovDataLocalization fetchByPrimaryKey(long lovDataLocalizationId) {
		return fetchByPrimaryKey((Serializable)lovDataLocalizationId);
	}

	/**
	 * Returns all the lov data localizations.
	 *
	 * @return the lov data localizations
	 */
	@Override
	public List<LovDataLocalization> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lov data localizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lov data localizations
	 * @param end the upper bound of the range of lov data localizations (not inclusive)
	 * @return the range of lov data localizations
	 */
	@Override
	public List<LovDataLocalization> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lov data localizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lov data localizations
	 * @param end the upper bound of the range of lov data localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lov data localizations
	 */
	@Override
	public List<LovDataLocalization> findAll(
		int start, int end,
		OrderByComparator<LovDataLocalization> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lov data localizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LovDataLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lov data localizations
	 * @param end the upper bound of the range of lov data localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of lov data localizations
	 */
	@Override
	public List<LovDataLocalization> findAll(
		int start, int end,
		OrderByComparator<LovDataLocalization> orderByComparator,
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

		List<LovDataLocalization> list = null;

		if (useFinderCache) {
			list = (List<LovDataLocalization>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LOVDATALOCALIZATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LOVDATALOCALIZATION;

				sql = sql.concat(LovDataLocalizationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<LovDataLocalization>)QueryUtil.list(
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
	 * Removes all the lov data localizations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LovDataLocalization lovDataLocalization : findAll()) {
			remove(lovDataLocalization);
		}
	}

	/**
	 * Returns the number of lov data localizations.
	 *
	 * @return the number of lov data localizations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_LOVDATALOCALIZATION);

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
		return "lovDataLocalizationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LOVDATALOCALIZATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LovDataLocalizationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the lov data localization persistence.
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

		_finderPathWithPaginationFindByLovsId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLovsId",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"lov_id", "languageId"}, true);

		_finderPathWithoutPaginationFindByLovsId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLovsId",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"lov_id", "languageId"}, true);

		_finderPathCountByLovsId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLovsId",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"lov_id", "languageId"}, false);

		_finderPathWithPaginationFindBydescriptionAndLanguageId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBydescriptionAndLanguageId",
				new String[] {
					Long.class.getName(), String.class.getName(),
					String.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"id_", "languageId", "recordDescription"}, true);

		_finderPathWithPaginationCountBydescriptionAndLanguageId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"countBydescriptionAndLanguageId",
				new String[] {
					Long.class.getName(), String.class.getName(),
					String.class.getName()
				},
				new String[] {"id_", "languageId", "recordDescription"}, false);

		LovDataLocalizationUtil.setPersistence(this);
	}

	public void destroy() {
		LovDataLocalizationUtil.setPersistence(null);

		entityCache.removeCache(LovDataLocalizationImpl.class.getName());
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_LOVDATALOCALIZATION =
		"SELECT lovDataLocalization FROM LovDataLocalization lovDataLocalization";

	private static final String _SQL_SELECT_LOVDATALOCALIZATION_WHERE =
		"SELECT lovDataLocalization FROM LovDataLocalization lovDataLocalization WHERE ";

	private static final String _SQL_COUNT_LOVDATALOCALIZATION =
		"SELECT COUNT(lovDataLocalization) FROM LovDataLocalization lovDataLocalization";

	private static final String _SQL_COUNT_LOVDATALOCALIZATION_WHERE =
		"SELECT COUNT(lovDataLocalization) FROM LovDataLocalization lovDataLocalization WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "lovDataLocalization.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LovDataLocalization exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LovDataLocalization exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LovDataLocalizationPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id", "lovIdLocalization"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}