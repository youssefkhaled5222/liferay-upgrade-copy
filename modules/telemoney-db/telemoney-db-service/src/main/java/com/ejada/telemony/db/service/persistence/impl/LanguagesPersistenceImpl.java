/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence.impl;

import com.ejada.telemony.db.exception.NoSuchLanguagesException;
import com.ejada.telemony.db.model.Languages;
import com.ejada.telemony.db.model.LanguagesTable;
import com.ejada.telemony.db.model.impl.LanguagesImpl;
import com.ejada.telemony.db.model.impl.LanguagesModelImpl;
import com.ejada.telemony.db.service.persistence.LanguagesPersistence;
import com.ejada.telemony.db.service.persistence.LanguagesUtil;

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
 * The persistence implementation for the languages service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LanguagesPersistenceImpl
	extends BasePersistenceImpl<Languages> implements LanguagesPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LanguagesUtil</code> to access the languages persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LanguagesImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByLocal;
	private FinderPath _finderPathWithoutPaginationFindByLocal;
	private FinderPath _finderPathCountByLocal;

	/**
	 * Returns all the languageses where channelId = &#63; and local = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param local the local
	 * @return the matching languageses
	 */
	@Override
	public List<Languages> findByLocal(long channelId, String local) {
		return findByLocal(
			channelId, local, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the languageses where channelId = &#63; and local = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LanguagesModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param local the local
	 * @param start the lower bound of the range of languageses
	 * @param end the upper bound of the range of languageses (not inclusive)
	 * @return the range of matching languageses
	 */
	@Override
	public List<Languages> findByLocal(
		long channelId, String local, int start, int end) {

		return findByLocal(channelId, local, start, end, null);
	}

	/**
	 * Returns an ordered range of all the languageses where channelId = &#63; and local = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LanguagesModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param local the local
	 * @param start the lower bound of the range of languageses
	 * @param end the upper bound of the range of languageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching languageses
	 */
	@Override
	public List<Languages> findByLocal(
		long channelId, String local, int start, int end,
		OrderByComparator<Languages> orderByComparator) {

		return findByLocal(
			channelId, local, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the languageses where channelId = &#63; and local = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LanguagesModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param local the local
	 * @param start the lower bound of the range of languageses
	 * @param end the upper bound of the range of languageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching languageses
	 */
	@Override
	public List<Languages> findByLocal(
		long channelId, String local, int start, int end,
		OrderByComparator<Languages> orderByComparator,
		boolean useFinderCache) {

		local = Objects.toString(local, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByLocal;
				finderArgs = new Object[] {channelId, local};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByLocal;
			finderArgs = new Object[] {
				channelId, local, start, end, orderByComparator
			};
		}

		List<Languages> list = null;

		if (useFinderCache) {
			list = (List<Languages>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Languages languages : list) {
					if ((channelId != languages.getChannelId()) ||
						!local.equals(languages.getLocal())) {

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

			sb.append(_SQL_SELECT_LANGUAGES_WHERE);

			sb.append(_FINDER_COLUMN_LOCAL_CHANNELID_2);

			boolean bindLocal = false;

			if (local.isEmpty()) {
				sb.append(_FINDER_COLUMN_LOCAL_LOCAL_3);
			}
			else {
				bindLocal = true;

				sb.append(_FINDER_COLUMN_LOCAL_LOCAL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LanguagesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				if (bindLocal) {
					queryPos.add(local);
				}

				list = (List<Languages>)QueryUtil.list(
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
	 * Returns the first languages in the ordered set where channelId = &#63; and local = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param local the local
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching languages
	 * @throws NoSuchLanguagesException if a matching languages could not be found
	 */
	@Override
	public Languages findByLocal_First(
			long channelId, String local,
			OrderByComparator<Languages> orderByComparator)
		throws NoSuchLanguagesException {

		Languages languages = fetchByLocal_First(
			channelId, local, orderByComparator);

		if (languages != null) {
			return languages;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append(", local=");
		sb.append(local);

		sb.append("}");

		throw new NoSuchLanguagesException(sb.toString());
	}

	/**
	 * Returns the first languages in the ordered set where channelId = &#63; and local = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param local the local
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching languages, or <code>null</code> if a matching languages could not be found
	 */
	@Override
	public Languages fetchByLocal_First(
		long channelId, String local,
		OrderByComparator<Languages> orderByComparator) {

		List<Languages> list = findByLocal(
			channelId, local, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last languages in the ordered set where channelId = &#63; and local = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param local the local
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching languages
	 * @throws NoSuchLanguagesException if a matching languages could not be found
	 */
	@Override
	public Languages findByLocal_Last(
			long channelId, String local,
			OrderByComparator<Languages> orderByComparator)
		throws NoSuchLanguagesException {

		Languages languages = fetchByLocal_Last(
			channelId, local, orderByComparator);

		if (languages != null) {
			return languages;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append(", local=");
		sb.append(local);

		sb.append("}");

		throw new NoSuchLanguagesException(sb.toString());
	}

	/**
	 * Returns the last languages in the ordered set where channelId = &#63; and local = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param local the local
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching languages, or <code>null</code> if a matching languages could not be found
	 */
	@Override
	public Languages fetchByLocal_Last(
		long channelId, String local,
		OrderByComparator<Languages> orderByComparator) {

		int count = countByLocal(channelId, local);

		if (count == 0) {
			return null;
		}

		List<Languages> list = findByLocal(
			channelId, local, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the languageses before and after the current languages in the ordered set where channelId = &#63; and local = &#63;.
	 *
	 * @param languageId the primary key of the current languages
	 * @param channelId the channel ID
	 * @param local the local
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next languages
	 * @throws NoSuchLanguagesException if a languages with the primary key could not be found
	 */
	@Override
	public Languages[] findByLocal_PrevAndNext(
			long languageId, long channelId, String local,
			OrderByComparator<Languages> orderByComparator)
		throws NoSuchLanguagesException {

		local = Objects.toString(local, "");

		Languages languages = findByPrimaryKey(languageId);

		Session session = null;

		try {
			session = openSession();

			Languages[] array = new LanguagesImpl[3];

			array[0] = getByLocal_PrevAndNext(
				session, languages, channelId, local, orderByComparator, true);

			array[1] = languages;

			array[2] = getByLocal_PrevAndNext(
				session, languages, channelId, local, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Languages getByLocal_PrevAndNext(
		Session session, Languages languages, long channelId, String local,
		OrderByComparator<Languages> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_LANGUAGES_WHERE);

		sb.append(_FINDER_COLUMN_LOCAL_CHANNELID_2);

		boolean bindLocal = false;

		if (local.isEmpty()) {
			sb.append(_FINDER_COLUMN_LOCAL_LOCAL_3);
		}
		else {
			bindLocal = true;

			sb.append(_FINDER_COLUMN_LOCAL_LOCAL_2);
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
			sb.append(LanguagesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(channelId);

		if (bindLocal) {
			queryPos.add(local);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(languages)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Languages> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the languageses where channelId = &#63; and local = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param local the local
	 */
	@Override
	public void removeByLocal(long channelId, String local) {
		for (Languages languages :
				findByLocal(
					channelId, local, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(languages);
		}
	}

	/**
	 * Returns the number of languageses where channelId = &#63; and local = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param local the local
	 * @return the number of matching languageses
	 */
	@Override
	public int countByLocal(long channelId, String local) {
		local = Objects.toString(local, "");

		FinderPath finderPath = _finderPathCountByLocal;

		Object[] finderArgs = new Object[] {channelId, local};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LANGUAGES_WHERE);

			sb.append(_FINDER_COLUMN_LOCAL_CHANNELID_2);

			boolean bindLocal = false;

			if (local.isEmpty()) {
				sb.append(_FINDER_COLUMN_LOCAL_LOCAL_3);
			}
			else {
				bindLocal = true;

				sb.append(_FINDER_COLUMN_LOCAL_LOCAL_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				if (bindLocal) {
					queryPos.add(local);
				}

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

	private static final String _FINDER_COLUMN_LOCAL_CHANNELID_2 =
		"languages.channelId = ? AND ";

	private static final String _FINDER_COLUMN_LOCAL_LOCAL_2 =
		"languages.local = ?";

	private static final String _FINDER_COLUMN_LOCAL_LOCAL_3 =
		"(languages.local IS NULL OR languages.local = '')";

	private FinderPath _finderPathWithPaginationFindByLangName;
	private FinderPath _finderPathWithoutPaginationFindByLangName;
	private FinderPath _finderPathCountByLangName;

	/**
	 * Returns all the languageses where channelId = &#63; and langName = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param langName the lang name
	 * @return the matching languageses
	 */
	@Override
	public List<Languages> findByLangName(long channelId, String langName) {
		return findByLangName(
			channelId, langName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the languageses where channelId = &#63; and langName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LanguagesModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param langName the lang name
	 * @param start the lower bound of the range of languageses
	 * @param end the upper bound of the range of languageses (not inclusive)
	 * @return the range of matching languageses
	 */
	@Override
	public List<Languages> findByLangName(
		long channelId, String langName, int start, int end) {

		return findByLangName(channelId, langName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the languageses where channelId = &#63; and langName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LanguagesModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param langName the lang name
	 * @param start the lower bound of the range of languageses
	 * @param end the upper bound of the range of languageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching languageses
	 */
	@Override
	public List<Languages> findByLangName(
		long channelId, String langName, int start, int end,
		OrderByComparator<Languages> orderByComparator) {

		return findByLangName(
			channelId, langName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the languageses where channelId = &#63; and langName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LanguagesModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param langName the lang name
	 * @param start the lower bound of the range of languageses
	 * @param end the upper bound of the range of languageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching languageses
	 */
	@Override
	public List<Languages> findByLangName(
		long channelId, String langName, int start, int end,
		OrderByComparator<Languages> orderByComparator,
		boolean useFinderCache) {

		langName = Objects.toString(langName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByLangName;
				finderArgs = new Object[] {channelId, langName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByLangName;
			finderArgs = new Object[] {
				channelId, langName, start, end, orderByComparator
			};
		}

		List<Languages> list = null;

		if (useFinderCache) {
			list = (List<Languages>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Languages languages : list) {
					if ((channelId != languages.getChannelId()) ||
						!langName.equals(languages.getLangName())) {

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

			sb.append(_SQL_SELECT_LANGUAGES_WHERE);

			sb.append(_FINDER_COLUMN_LANGNAME_CHANNELID_2);

			boolean bindLangName = false;

			if (langName.isEmpty()) {
				sb.append(_FINDER_COLUMN_LANGNAME_LANGNAME_3);
			}
			else {
				bindLangName = true;

				sb.append(_FINDER_COLUMN_LANGNAME_LANGNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LanguagesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				if (bindLangName) {
					queryPos.add(langName);
				}

				list = (List<Languages>)QueryUtil.list(
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
	 * Returns the first languages in the ordered set where channelId = &#63; and langName = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param langName the lang name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching languages
	 * @throws NoSuchLanguagesException if a matching languages could not be found
	 */
	@Override
	public Languages findByLangName_First(
			long channelId, String langName,
			OrderByComparator<Languages> orderByComparator)
		throws NoSuchLanguagesException {

		Languages languages = fetchByLangName_First(
			channelId, langName, orderByComparator);

		if (languages != null) {
			return languages;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append(", langName=");
		sb.append(langName);

		sb.append("}");

		throw new NoSuchLanguagesException(sb.toString());
	}

	/**
	 * Returns the first languages in the ordered set where channelId = &#63; and langName = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param langName the lang name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching languages, or <code>null</code> if a matching languages could not be found
	 */
	@Override
	public Languages fetchByLangName_First(
		long channelId, String langName,
		OrderByComparator<Languages> orderByComparator) {

		List<Languages> list = findByLangName(
			channelId, langName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last languages in the ordered set where channelId = &#63; and langName = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param langName the lang name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching languages
	 * @throws NoSuchLanguagesException if a matching languages could not be found
	 */
	@Override
	public Languages findByLangName_Last(
			long channelId, String langName,
			OrderByComparator<Languages> orderByComparator)
		throws NoSuchLanguagesException {

		Languages languages = fetchByLangName_Last(
			channelId, langName, orderByComparator);

		if (languages != null) {
			return languages;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append(", langName=");
		sb.append(langName);

		sb.append("}");

		throw new NoSuchLanguagesException(sb.toString());
	}

	/**
	 * Returns the last languages in the ordered set where channelId = &#63; and langName = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param langName the lang name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching languages, or <code>null</code> if a matching languages could not be found
	 */
	@Override
	public Languages fetchByLangName_Last(
		long channelId, String langName,
		OrderByComparator<Languages> orderByComparator) {

		int count = countByLangName(channelId, langName);

		if (count == 0) {
			return null;
		}

		List<Languages> list = findByLangName(
			channelId, langName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the languageses before and after the current languages in the ordered set where channelId = &#63; and langName = &#63;.
	 *
	 * @param languageId the primary key of the current languages
	 * @param channelId the channel ID
	 * @param langName the lang name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next languages
	 * @throws NoSuchLanguagesException if a languages with the primary key could not be found
	 */
	@Override
	public Languages[] findByLangName_PrevAndNext(
			long languageId, long channelId, String langName,
			OrderByComparator<Languages> orderByComparator)
		throws NoSuchLanguagesException {

		langName = Objects.toString(langName, "");

		Languages languages = findByPrimaryKey(languageId);

		Session session = null;

		try {
			session = openSession();

			Languages[] array = new LanguagesImpl[3];

			array[0] = getByLangName_PrevAndNext(
				session, languages, channelId, langName, orderByComparator,
				true);

			array[1] = languages;

			array[2] = getByLangName_PrevAndNext(
				session, languages, channelId, langName, orderByComparator,
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

	protected Languages getByLangName_PrevAndNext(
		Session session, Languages languages, long channelId, String langName,
		OrderByComparator<Languages> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_LANGUAGES_WHERE);

		sb.append(_FINDER_COLUMN_LANGNAME_CHANNELID_2);

		boolean bindLangName = false;

		if (langName.isEmpty()) {
			sb.append(_FINDER_COLUMN_LANGNAME_LANGNAME_3);
		}
		else {
			bindLangName = true;

			sb.append(_FINDER_COLUMN_LANGNAME_LANGNAME_2);
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
			sb.append(LanguagesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(channelId);

		if (bindLangName) {
			queryPos.add(langName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(languages)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Languages> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the languageses where channelId = &#63; and langName = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param langName the lang name
	 */
	@Override
	public void removeByLangName(long channelId, String langName) {
		for (Languages languages :
				findByLangName(
					channelId, langName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(languages);
		}
	}

	/**
	 * Returns the number of languageses where channelId = &#63; and langName = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param langName the lang name
	 * @return the number of matching languageses
	 */
	@Override
	public int countByLangName(long channelId, String langName) {
		langName = Objects.toString(langName, "");

		FinderPath finderPath = _finderPathCountByLangName;

		Object[] finderArgs = new Object[] {channelId, langName};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LANGUAGES_WHERE);

			sb.append(_FINDER_COLUMN_LANGNAME_CHANNELID_2);

			boolean bindLangName = false;

			if (langName.isEmpty()) {
				sb.append(_FINDER_COLUMN_LANGNAME_LANGNAME_3);
			}
			else {
				bindLangName = true;

				sb.append(_FINDER_COLUMN_LANGNAME_LANGNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				if (bindLangName) {
					queryPos.add(langName);
				}

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

	private static final String _FINDER_COLUMN_LANGNAME_CHANNELID_2 =
		"languages.channelId = ? AND ";

	private static final String _FINDER_COLUMN_LANGNAME_LANGNAME_2 =
		"languages.langName = ?";

	private static final String _FINDER_COLUMN_LANGNAME_LANGNAME_3 =
		"(languages.langName IS NULL OR languages.langName = '')";

	private FinderPath _finderPathWithPaginationFindByChannelId;
	private FinderPath _finderPathWithoutPaginationFindByChannelId;
	private FinderPath _finderPathCountByChannelId;

	/**
	 * Returns all the languageses where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the matching languageses
	 */
	@Override
	public List<Languages> findByChannelId(long channelId) {
		return findByChannelId(
			channelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the languageses where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LanguagesModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of languageses
	 * @param end the upper bound of the range of languageses (not inclusive)
	 * @return the range of matching languageses
	 */
	@Override
	public List<Languages> findByChannelId(long channelId, int start, int end) {
		return findByChannelId(channelId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the languageses where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LanguagesModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of languageses
	 * @param end the upper bound of the range of languageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching languageses
	 */
	@Override
	public List<Languages> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<Languages> orderByComparator) {

		return findByChannelId(channelId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the languageses where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LanguagesModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of languageses
	 * @param end the upper bound of the range of languageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching languageses
	 */
	@Override
	public List<Languages> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<Languages> orderByComparator,
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

		List<Languages> list = null;

		if (useFinderCache) {
			list = (List<Languages>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Languages languages : list) {
					if (channelId != languages.getChannelId()) {
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

			sb.append(_SQL_SELECT_LANGUAGES_WHERE);

			sb.append(_FINDER_COLUMN_CHANNELID_CHANNELID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LanguagesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				list = (List<Languages>)QueryUtil.list(
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
	 * Returns the first languages in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching languages
	 * @throws NoSuchLanguagesException if a matching languages could not be found
	 */
	@Override
	public Languages findByChannelId_First(
			long channelId, OrderByComparator<Languages> orderByComparator)
		throws NoSuchLanguagesException {

		Languages languages = fetchByChannelId_First(
			channelId, orderByComparator);

		if (languages != null) {
			return languages;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append("}");

		throw new NoSuchLanguagesException(sb.toString());
	}

	/**
	 * Returns the first languages in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching languages, or <code>null</code> if a matching languages could not be found
	 */
	@Override
	public Languages fetchByChannelId_First(
		long channelId, OrderByComparator<Languages> orderByComparator) {

		List<Languages> list = findByChannelId(
			channelId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last languages in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching languages
	 * @throws NoSuchLanguagesException if a matching languages could not be found
	 */
	@Override
	public Languages findByChannelId_Last(
			long channelId, OrderByComparator<Languages> orderByComparator)
		throws NoSuchLanguagesException {

		Languages languages = fetchByChannelId_Last(
			channelId, orderByComparator);

		if (languages != null) {
			return languages;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append("}");

		throw new NoSuchLanguagesException(sb.toString());
	}

	/**
	 * Returns the last languages in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching languages, or <code>null</code> if a matching languages could not be found
	 */
	@Override
	public Languages fetchByChannelId_Last(
		long channelId, OrderByComparator<Languages> orderByComparator) {

		int count = countByChannelId(channelId);

		if (count == 0) {
			return null;
		}

		List<Languages> list = findByChannelId(
			channelId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the languageses before and after the current languages in the ordered set where channelId = &#63;.
	 *
	 * @param languageId the primary key of the current languages
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next languages
	 * @throws NoSuchLanguagesException if a languages with the primary key could not be found
	 */
	@Override
	public Languages[] findByChannelId_PrevAndNext(
			long languageId, long channelId,
			OrderByComparator<Languages> orderByComparator)
		throws NoSuchLanguagesException {

		Languages languages = findByPrimaryKey(languageId);

		Session session = null;

		try {
			session = openSession();

			Languages[] array = new LanguagesImpl[3];

			array[0] = getByChannelId_PrevAndNext(
				session, languages, channelId, orderByComparator, true);

			array[1] = languages;

			array[2] = getByChannelId_PrevAndNext(
				session, languages, channelId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Languages getByChannelId_PrevAndNext(
		Session session, Languages languages, long channelId,
		OrderByComparator<Languages> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LANGUAGES_WHERE);

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
			sb.append(LanguagesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(channelId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(languages)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Languages> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the languageses where channelId = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 */
	@Override
	public void removeByChannelId(long channelId) {
		for (Languages languages :
				findByChannelId(
					channelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(languages);
		}
	}

	/**
	 * Returns the number of languageses where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the number of matching languageses
	 */
	@Override
	public int countByChannelId(long channelId) {
		FinderPath finderPath = _finderPathCountByChannelId;

		Object[] finderArgs = new Object[] {channelId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LANGUAGES_WHERE);

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
		"languages.channelId = ?";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the languageses where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching languageses
	 */
	@Override
	public List<Languages> findByStatus(int status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the languageses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LanguagesModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of languageses
	 * @param end the upper bound of the range of languageses (not inclusive)
	 * @return the range of matching languageses
	 */
	@Override
	public List<Languages> findByStatus(int status, int start, int end) {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the languageses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LanguagesModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of languageses
	 * @param end the upper bound of the range of languageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching languageses
	 */
	@Override
	public List<Languages> findByStatus(
		int status, int start, int end,
		OrderByComparator<Languages> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the languageses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LanguagesModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of languageses
	 * @param end the upper bound of the range of languageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching languageses
	 */
	@Override
	public List<Languages> findByStatus(
		int status, int start, int end,
		OrderByComparator<Languages> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStatus;
				finderArgs = new Object[] {status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatus;
			finderArgs = new Object[] {status, start, end, orderByComparator};
		}

		List<Languages> list = null;

		if (useFinderCache) {
			list = (List<Languages>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Languages languages : list) {
					if (status != languages.getStatus()) {
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

			sb.append(_SQL_SELECT_LANGUAGES_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LanguagesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				list = (List<Languages>)QueryUtil.list(
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
	 * Returns the first languages in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching languages
	 * @throws NoSuchLanguagesException if a matching languages could not be found
	 */
	@Override
	public Languages findByStatus_First(
			int status, OrderByComparator<Languages> orderByComparator)
		throws NoSuchLanguagesException {

		Languages languages = fetchByStatus_First(status, orderByComparator);

		if (languages != null) {
			return languages;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchLanguagesException(sb.toString());
	}

	/**
	 * Returns the first languages in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching languages, or <code>null</code> if a matching languages could not be found
	 */
	@Override
	public Languages fetchByStatus_First(
		int status, OrderByComparator<Languages> orderByComparator) {

		List<Languages> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last languages in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching languages
	 * @throws NoSuchLanguagesException if a matching languages could not be found
	 */
	@Override
	public Languages findByStatus_Last(
			int status, OrderByComparator<Languages> orderByComparator)
		throws NoSuchLanguagesException {

		Languages languages = fetchByStatus_Last(status, orderByComparator);

		if (languages != null) {
			return languages;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchLanguagesException(sb.toString());
	}

	/**
	 * Returns the last languages in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching languages, or <code>null</code> if a matching languages could not be found
	 */
	@Override
	public Languages fetchByStatus_Last(
		int status, OrderByComparator<Languages> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<Languages> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the languageses before and after the current languages in the ordered set where status = &#63;.
	 *
	 * @param languageId the primary key of the current languages
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next languages
	 * @throws NoSuchLanguagesException if a languages with the primary key could not be found
	 */
	@Override
	public Languages[] findByStatus_PrevAndNext(
			long languageId, int status,
			OrderByComparator<Languages> orderByComparator)
		throws NoSuchLanguagesException {

		Languages languages = findByPrimaryKey(languageId);

		Session session = null;

		try {
			session = openSession();

			Languages[] array = new LanguagesImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, languages, status, orderByComparator, true);

			array[1] = languages;

			array[2] = getByStatus_PrevAndNext(
				session, languages, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Languages getByStatus_PrevAndNext(
		Session session, Languages languages, int status,
		OrderByComparator<Languages> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LANGUAGES_WHERE);

		sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			sb.append(LanguagesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(languages)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Languages> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the languageses where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(int status) {
		for (Languages languages :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(languages);
		}
	}

	/**
	 * Returns the number of languageses where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching languageses
	 */
	@Override
	public int countByStatus(int status) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LANGUAGES_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 =
		"languages.status = ?";

	private FinderPath _finderPathWithPaginationFindByentityResourceId;
	private FinderPath _finderPathWithoutPaginationFindByentityResourceId;
	private FinderPath _finderPathCountByentityResourceId;

	/**
	 * Returns all the languageses where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the matching languageses
	 */
	@Override
	public List<Languages> findByentityResourceId(long entityResourceId) {
		return findByentityResourceId(
			entityResourceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the languageses where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LanguagesModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of languageses
	 * @param end the upper bound of the range of languageses (not inclusive)
	 * @return the range of matching languageses
	 */
	@Override
	public List<Languages> findByentityResourceId(
		long entityResourceId, int start, int end) {

		return findByentityResourceId(entityResourceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the languageses where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LanguagesModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of languageses
	 * @param end the upper bound of the range of languageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching languageses
	 */
	@Override
	public List<Languages> findByentityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<Languages> orderByComparator) {

		return findByentityResourceId(
			entityResourceId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the languageses where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LanguagesModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of languageses
	 * @param end the upper bound of the range of languageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching languageses
	 */
	@Override
	public List<Languages> findByentityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<Languages> orderByComparator,
		boolean useFinderCache) {

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

		List<Languages> list = null;

		if (useFinderCache) {
			list = (List<Languages>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Languages languages : list) {
					if (entityResourceId != languages.getEntityResourceId()) {
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

			sb.append(_SQL_SELECT_LANGUAGES_WHERE);

			sb.append(_FINDER_COLUMN_ENTITYRESOURCEID_ENTITYRESOURCEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LanguagesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(entityResourceId);

				list = (List<Languages>)QueryUtil.list(
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
	 * Returns the first languages in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching languages
	 * @throws NoSuchLanguagesException if a matching languages could not be found
	 */
	@Override
	public Languages findByentityResourceId_First(
			long entityResourceId,
			OrderByComparator<Languages> orderByComparator)
		throws NoSuchLanguagesException {

		Languages languages = fetchByentityResourceId_First(
			entityResourceId, orderByComparator);

		if (languages != null) {
			return languages;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("entityResourceId=");
		sb.append(entityResourceId);

		sb.append("}");

		throw new NoSuchLanguagesException(sb.toString());
	}

	/**
	 * Returns the first languages in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching languages, or <code>null</code> if a matching languages could not be found
	 */
	@Override
	public Languages fetchByentityResourceId_First(
		long entityResourceId, OrderByComparator<Languages> orderByComparator) {

		List<Languages> list = findByentityResourceId(
			entityResourceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last languages in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching languages
	 * @throws NoSuchLanguagesException if a matching languages could not be found
	 */
	@Override
	public Languages findByentityResourceId_Last(
			long entityResourceId,
			OrderByComparator<Languages> orderByComparator)
		throws NoSuchLanguagesException {

		Languages languages = fetchByentityResourceId_Last(
			entityResourceId, orderByComparator);

		if (languages != null) {
			return languages;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("entityResourceId=");
		sb.append(entityResourceId);

		sb.append("}");

		throw new NoSuchLanguagesException(sb.toString());
	}

	/**
	 * Returns the last languages in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching languages, or <code>null</code> if a matching languages could not be found
	 */
	@Override
	public Languages fetchByentityResourceId_Last(
		long entityResourceId, OrderByComparator<Languages> orderByComparator) {

		int count = countByentityResourceId(entityResourceId);

		if (count == 0) {
			return null;
		}

		List<Languages> list = findByentityResourceId(
			entityResourceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the languageses before and after the current languages in the ordered set where entityResourceId = &#63;.
	 *
	 * @param languageId the primary key of the current languages
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next languages
	 * @throws NoSuchLanguagesException if a languages with the primary key could not be found
	 */
	@Override
	public Languages[] findByentityResourceId_PrevAndNext(
			long languageId, long entityResourceId,
			OrderByComparator<Languages> orderByComparator)
		throws NoSuchLanguagesException {

		Languages languages = findByPrimaryKey(languageId);

		Session session = null;

		try {
			session = openSession();

			Languages[] array = new LanguagesImpl[3];

			array[0] = getByentityResourceId_PrevAndNext(
				session, languages, entityResourceId, orderByComparator, true);

			array[1] = languages;

			array[2] = getByentityResourceId_PrevAndNext(
				session, languages, entityResourceId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Languages getByentityResourceId_PrevAndNext(
		Session session, Languages languages, long entityResourceId,
		OrderByComparator<Languages> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LANGUAGES_WHERE);

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
			sb.append(LanguagesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(entityResourceId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(languages)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Languages> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the languageses where entityResourceId = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 */
	@Override
	public void removeByentityResourceId(long entityResourceId) {
		for (Languages languages :
				findByentityResourceId(
					entityResourceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(languages);
		}
	}

	/**
	 * Returns the number of languageses where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the number of matching languageses
	 */
	@Override
	public int countByentityResourceId(long entityResourceId) {
		FinderPath finderPath = _finderPathCountByentityResourceId;

		Object[] finderArgs = new Object[] {entityResourceId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LANGUAGES_WHERE);

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
			"languages.entityResourceId = ?";

	public LanguagesPersistenceImpl() {
		setModelClass(Languages.class);

		setModelImplClass(LanguagesImpl.class);
		setModelPKClass(long.class);

		setTable(LanguagesTable.INSTANCE);
	}

	/**
	 * Caches the languages in the entity cache if it is enabled.
	 *
	 * @param languages the languages
	 */
	@Override
	public void cacheResult(Languages languages) {
		dummyEntityCache.putResult(
			LanguagesImpl.class, languages.getPrimaryKey(), languages);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the languageses in the entity cache if it is enabled.
	 *
	 * @param languageses the languageses
	 */
	@Override
	public void cacheResult(List<Languages> languageses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (languageses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Languages languages : languageses) {
			if (dummyEntityCache.getResult(
					LanguagesImpl.class, languages.getPrimaryKey()) == null) {

				cacheResult(languages);
			}
		}
	}

	/**
	 * Clears the cache for all languageses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(LanguagesImpl.class);

		dummyFinderCache.clearCache(LanguagesImpl.class);
	}

	/**
	 * Clears the cache for the languages.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Languages languages) {
		dummyEntityCache.removeResult(LanguagesImpl.class, languages);
	}

	@Override
	public void clearCache(List<Languages> languageses) {
		for (Languages languages : languageses) {
			dummyEntityCache.removeResult(LanguagesImpl.class, languages);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(LanguagesImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(LanguagesImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new languages with the primary key. Does not add the languages to the database.
	 *
	 * @param languageId the primary key for the new languages
	 * @return the new languages
	 */
	@Override
	public Languages create(long languageId) {
		Languages languages = new LanguagesImpl();

		languages.setNew(true);
		languages.setPrimaryKey(languageId);

		languages.setCompanyId(CompanyThreadLocal.getCompanyId());

		return languages;
	}

	/**
	 * Removes the languages with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param languageId the primary key of the languages
	 * @return the languages that was removed
	 * @throws NoSuchLanguagesException if a languages with the primary key could not be found
	 */
	@Override
	public Languages remove(long languageId) throws NoSuchLanguagesException {
		return remove((Serializable)languageId);
	}

	/**
	 * Removes the languages with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the languages
	 * @return the languages that was removed
	 * @throws NoSuchLanguagesException if a languages with the primary key could not be found
	 */
	@Override
	public Languages remove(Serializable primaryKey)
		throws NoSuchLanguagesException {

		Session session = null;

		try {
			session = openSession();

			Languages languages = (Languages)session.get(
				LanguagesImpl.class, primaryKey);

			if (languages == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLanguagesException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(languages);
		}
		catch (NoSuchLanguagesException noSuchEntityException) {
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
	protected Languages removeImpl(Languages languages) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(languages)) {
				languages = (Languages)session.get(
					LanguagesImpl.class, languages.getPrimaryKeyObj());
			}

			if (languages != null) {
				session.delete(languages);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (languages != null) {
			clearCache(languages);
		}

		return languages;
	}

	@Override
	public Languages updateImpl(Languages languages) {
		boolean isNew = languages.isNew();

		if (!(languages instanceof LanguagesModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(languages.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(languages);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in languages proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Languages implementation " +
					languages.getClass());
		}

		LanguagesModelImpl languagesModelImpl = (LanguagesModelImpl)languages;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (languages.getCreateDate() == null)) {
			if (serviceContext == null) {
				languages.setCreateDate(date);
			}
			else {
				languages.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!languagesModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				languages.setModifiedDate(date);
			}
			else {
				languages.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(languages);
			}
			else {
				languages = (Languages)session.merge(languages);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			LanguagesImpl.class, languagesModelImpl, false, true);

		if (isNew) {
			languages.setNew(false);
		}

		languages.resetOriginalValues();

		return languages;
	}

	/**
	 * Returns the languages with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the languages
	 * @return the languages
	 * @throws NoSuchLanguagesException if a languages with the primary key could not be found
	 */
	@Override
	public Languages findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLanguagesException {

		Languages languages = fetchByPrimaryKey(primaryKey);

		if (languages == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLanguagesException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return languages;
	}

	/**
	 * Returns the languages with the primary key or throws a <code>NoSuchLanguagesException</code> if it could not be found.
	 *
	 * @param languageId the primary key of the languages
	 * @return the languages
	 * @throws NoSuchLanguagesException if a languages with the primary key could not be found
	 */
	@Override
	public Languages findByPrimaryKey(long languageId)
		throws NoSuchLanguagesException {

		return findByPrimaryKey((Serializable)languageId);
	}

	/**
	 * Returns the languages with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param languageId the primary key of the languages
	 * @return the languages, or <code>null</code> if a languages with the primary key could not be found
	 */
	@Override
	public Languages fetchByPrimaryKey(long languageId) {
		return fetchByPrimaryKey((Serializable)languageId);
	}

	/**
	 * Returns all the languageses.
	 *
	 * @return the languageses
	 */
	@Override
	public List<Languages> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the languageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LanguagesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of languageses
	 * @param end the upper bound of the range of languageses (not inclusive)
	 * @return the range of languageses
	 */
	@Override
	public List<Languages> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the languageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LanguagesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of languageses
	 * @param end the upper bound of the range of languageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of languageses
	 */
	@Override
	public List<Languages> findAll(
		int start, int end, OrderByComparator<Languages> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the languageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LanguagesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of languageses
	 * @param end the upper bound of the range of languageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of languageses
	 */
	@Override
	public List<Languages> findAll(
		int start, int end, OrderByComparator<Languages> orderByComparator,
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

		List<Languages> list = null;

		if (useFinderCache) {
			list = (List<Languages>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LANGUAGES);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LANGUAGES;

				sql = sql.concat(LanguagesModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Languages>)QueryUtil.list(
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
	 * Removes all the languageses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Languages languages : findAll()) {
			remove(languages);
		}
	}

	/**
	 * Returns the number of languageses.
	 *
	 * @return the number of languageses
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_LANGUAGES);

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
		return "languageId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LANGUAGES;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LanguagesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the languages persistence.
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

		_finderPathWithPaginationFindByLocal = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLocal",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"channelId", "local"}, true);

		_finderPathWithoutPaginationFindByLocal = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLocal",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"channelId", "local"}, true);

		_finderPathCountByLocal = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLocal",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"channelId", "local"}, false);

		_finderPathWithPaginationFindByLangName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLangName",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"channelId", "langName"}, true);

		_finderPathWithoutPaginationFindByLangName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLangName",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"channelId", "langName"}, true);

		_finderPathCountByLangName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLangName",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"channelId", "langName"}, false);

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

		_finderPathWithPaginationFindByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"status"}, true);

		_finderPathWithoutPaginationFindByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] {Integer.class.getName()}, new String[] {"status"},
			true);

		_finderPathCountByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] {Integer.class.getName()}, new String[] {"status"},
			false);

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

		LanguagesUtil.setPersistence(this);
	}

	public void destroy() {
		LanguagesUtil.setPersistence(null);

		dummyEntityCache.removeCache(LanguagesImpl.class.getName());
	}

	private static final String _SQL_SELECT_LANGUAGES =
		"SELECT languages FROM Languages languages";

	private static final String _SQL_SELECT_LANGUAGES_WHERE =
		"SELECT languages FROM Languages languages WHERE ";

	private static final String _SQL_COUNT_LANGUAGES =
		"SELECT COUNT(languages) FROM Languages languages";

	private static final String _SQL_COUNT_LANGUAGES_WHERE =
		"SELECT COUNT(languages) FROM Languages languages WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "languages.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Languages exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Languages exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LanguagesPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}