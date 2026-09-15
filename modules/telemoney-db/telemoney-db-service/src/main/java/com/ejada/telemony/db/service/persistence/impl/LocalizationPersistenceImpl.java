/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence.impl;

import com.ejada.telemony.db.exception.NoSuchLocalizationException;
import com.ejada.telemony.db.model.Localization;
import com.ejada.telemony.db.model.LocalizationTable;
import com.ejada.telemony.db.model.impl.LocalizationImpl;
import com.ejada.telemony.db.model.impl.LocalizationModelImpl;
import com.ejada.telemony.db.service.persistence.LocalizationPersistence;
import com.ejada.telemony.db.service.persistence.LocalizationUtil;

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
 * The persistence implementation for the localization service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LocalizationPersistenceImpl
	extends BasePersistenceImpl<Localization>
	implements LocalizationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LocalizationUtil</code> to access the localization persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LocalizationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath
		_finderPathWithPaginationFindByChannelId_LanguageId_GlobalVersion;
	private FinderPath
		_finderPathWithoutPaginationFindByChannelId_LanguageId_GlobalVersion;
	private FinderPath _finderPathCountByChannelId_LanguageId_GlobalVersion;

	/**
	 * Returns all the localizations where channelId = &#63; and languageId = &#63; and globalVersion = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param languageId the language ID
	 * @param globalVersion the global version
	 * @return the matching localizations
	 */
	@Override
	public List<Localization> findByChannelId_LanguageId_GlobalVersion(
		long channelId, long languageId, long globalVersion) {

		return findByChannelId_LanguageId_GlobalVersion(
			channelId, languageId, globalVersion, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the localizations where channelId = &#63; and languageId = &#63; and globalVersion = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param languageId the language ID
	 * @param globalVersion the global version
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @return the range of matching localizations
	 */
	@Override
	public List<Localization> findByChannelId_LanguageId_GlobalVersion(
		long channelId, long languageId, long globalVersion, int start,
		int end) {

		return findByChannelId_LanguageId_GlobalVersion(
			channelId, languageId, globalVersion, start, end, null);
	}

	/**
	 * Returns an ordered range of all the localizations where channelId = &#63; and languageId = &#63; and globalVersion = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param languageId the language ID
	 * @param globalVersion the global version
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching localizations
	 */
	@Override
	public List<Localization> findByChannelId_LanguageId_GlobalVersion(
		long channelId, long languageId, long globalVersion, int start, int end,
		OrderByComparator<Localization> orderByComparator) {

		return findByChannelId_LanguageId_GlobalVersion(
			channelId, languageId, globalVersion, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the localizations where channelId = &#63; and languageId = &#63; and globalVersion = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param languageId the language ID
	 * @param globalVersion the global version
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching localizations
	 */
	@Override
	public List<Localization> findByChannelId_LanguageId_GlobalVersion(
		long channelId, long languageId, long globalVersion, int start, int end,
		OrderByComparator<Localization> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByChannelId_LanguageId_GlobalVersion;
				finderArgs = new Object[] {
					channelId, languageId, globalVersion
				};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByChannelId_LanguageId_GlobalVersion;
			finderArgs = new Object[] {
				channelId, languageId, globalVersion, start, end,
				orderByComparator
			};
		}

		List<Localization> list = null;

		if (useFinderCache) {
			list = (List<Localization>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Localization localization : list) {
					if ((channelId != localization.getChannelId()) ||
						(languageId != localization.getLanguageId()) ||
						(globalVersion != localization.getGlobalVersion())) {

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

			sb.append(_SQL_SELECT_LOCALIZATION_WHERE);

			sb.append(
				_FINDER_COLUMN_CHANNELID_LANGUAGEID_GLOBALVERSION_CHANNELID_2);

			sb.append(
				_FINDER_COLUMN_CHANNELID_LANGUAGEID_GLOBALVERSION_LANGUAGEID_2);

			sb.append(
				_FINDER_COLUMN_CHANNELID_LANGUAGEID_GLOBALVERSION_GLOBALVERSION_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LocalizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				queryPos.add(languageId);

				queryPos.add(globalVersion);

				list = (List<Localization>)QueryUtil.list(
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
	 * Returns the first localization in the ordered set where channelId = &#63; and languageId = &#63; and globalVersion = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param languageId the language ID
	 * @param globalVersion the global version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching localization
	 * @throws NoSuchLocalizationException if a matching localization could not be found
	 */
	@Override
	public Localization findByChannelId_LanguageId_GlobalVersion_First(
			long channelId, long languageId, long globalVersion,
			OrderByComparator<Localization> orderByComparator)
		throws NoSuchLocalizationException {

		Localization localization =
			fetchByChannelId_LanguageId_GlobalVersion_First(
				channelId, languageId, globalVersion, orderByComparator);

		if (localization != null) {
			return localization;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append(", languageId=");
		sb.append(languageId);

		sb.append(", globalVersion=");
		sb.append(globalVersion);

		sb.append("}");

		throw new NoSuchLocalizationException(sb.toString());
	}

	/**
	 * Returns the first localization in the ordered set where channelId = &#63; and languageId = &#63; and globalVersion = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param languageId the language ID
	 * @param globalVersion the global version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching localization, or <code>null</code> if a matching localization could not be found
	 */
	@Override
	public Localization fetchByChannelId_LanguageId_GlobalVersion_First(
		long channelId, long languageId, long globalVersion,
		OrderByComparator<Localization> orderByComparator) {

		List<Localization> list = findByChannelId_LanguageId_GlobalVersion(
			channelId, languageId, globalVersion, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last localization in the ordered set where channelId = &#63; and languageId = &#63; and globalVersion = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param languageId the language ID
	 * @param globalVersion the global version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching localization
	 * @throws NoSuchLocalizationException if a matching localization could not be found
	 */
	@Override
	public Localization findByChannelId_LanguageId_GlobalVersion_Last(
			long channelId, long languageId, long globalVersion,
			OrderByComparator<Localization> orderByComparator)
		throws NoSuchLocalizationException {

		Localization localization =
			fetchByChannelId_LanguageId_GlobalVersion_Last(
				channelId, languageId, globalVersion, orderByComparator);

		if (localization != null) {
			return localization;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append(", languageId=");
		sb.append(languageId);

		sb.append(", globalVersion=");
		sb.append(globalVersion);

		sb.append("}");

		throw new NoSuchLocalizationException(sb.toString());
	}

	/**
	 * Returns the last localization in the ordered set where channelId = &#63; and languageId = &#63; and globalVersion = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param languageId the language ID
	 * @param globalVersion the global version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching localization, or <code>null</code> if a matching localization could not be found
	 */
	@Override
	public Localization fetchByChannelId_LanguageId_GlobalVersion_Last(
		long channelId, long languageId, long globalVersion,
		OrderByComparator<Localization> orderByComparator) {

		int count = countByChannelId_LanguageId_GlobalVersion(
			channelId, languageId, globalVersion);

		if (count == 0) {
			return null;
		}

		List<Localization> list = findByChannelId_LanguageId_GlobalVersion(
			channelId, languageId, globalVersion, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the localizations before and after the current localization in the ordered set where channelId = &#63; and languageId = &#63; and globalVersion = &#63;.
	 *
	 * @param localizationId the primary key of the current localization
	 * @param channelId the channel ID
	 * @param languageId the language ID
	 * @param globalVersion the global version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next localization
	 * @throws NoSuchLocalizationException if a localization with the primary key could not be found
	 */
	@Override
	public Localization[] findByChannelId_LanguageId_GlobalVersion_PrevAndNext(
			long localizationId, long channelId, long languageId,
			long globalVersion,
			OrderByComparator<Localization> orderByComparator)
		throws NoSuchLocalizationException {

		Localization localization = findByPrimaryKey(localizationId);

		Session session = null;

		try {
			session = openSession();

			Localization[] array = new LocalizationImpl[3];

			array[0] = getByChannelId_LanguageId_GlobalVersion_PrevAndNext(
				session, localization, channelId, languageId, globalVersion,
				orderByComparator, true);

			array[1] = localization;

			array[2] = getByChannelId_LanguageId_GlobalVersion_PrevAndNext(
				session, localization, channelId, languageId, globalVersion,
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

	protected Localization getByChannelId_LanguageId_GlobalVersion_PrevAndNext(
		Session session, Localization localization, long channelId,
		long languageId, long globalVersion,
		OrderByComparator<Localization> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_LOCALIZATION_WHERE);

		sb.append(
			_FINDER_COLUMN_CHANNELID_LANGUAGEID_GLOBALVERSION_CHANNELID_2);

		sb.append(
			_FINDER_COLUMN_CHANNELID_LANGUAGEID_GLOBALVERSION_LANGUAGEID_2);

		sb.append(
			_FINDER_COLUMN_CHANNELID_LANGUAGEID_GLOBALVERSION_GLOBALVERSION_2);

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
			sb.append(LocalizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(channelId);

		queryPos.add(languageId);

		queryPos.add(globalVersion);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(localization)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Localization> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the localizations where channelId = &#63; and languageId = &#63; and globalVersion = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param languageId the language ID
	 * @param globalVersion the global version
	 */
	@Override
	public void removeByChannelId_LanguageId_GlobalVersion(
		long channelId, long languageId, long globalVersion) {

		for (Localization localization :
				findByChannelId_LanguageId_GlobalVersion(
					channelId, languageId, globalVersion, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(localization);
		}
	}

	/**
	 * Returns the number of localizations where channelId = &#63; and languageId = &#63; and globalVersion = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param languageId the language ID
	 * @param globalVersion the global version
	 * @return the number of matching localizations
	 */
	@Override
	public int countByChannelId_LanguageId_GlobalVersion(
		long channelId, long languageId, long globalVersion) {

		FinderPath finderPath =
			_finderPathCountByChannelId_LanguageId_GlobalVersion;

		Object[] finderArgs = new Object[] {
			channelId, languageId, globalVersion
		};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_LOCALIZATION_WHERE);

			sb.append(
				_FINDER_COLUMN_CHANNELID_LANGUAGEID_GLOBALVERSION_CHANNELID_2);

			sb.append(
				_FINDER_COLUMN_CHANNELID_LANGUAGEID_GLOBALVERSION_LANGUAGEID_2);

			sb.append(
				_FINDER_COLUMN_CHANNELID_LANGUAGEID_GLOBALVERSION_GLOBALVERSION_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				queryPos.add(languageId);

				queryPos.add(globalVersion);

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
		_FINDER_COLUMN_CHANNELID_LANGUAGEID_GLOBALVERSION_CHANNELID_2 =
			"localization.channelId = ? AND ";

	private static final String
		_FINDER_COLUMN_CHANNELID_LANGUAGEID_GLOBALVERSION_LANGUAGEID_2 =
			"localization.languageId = ? AND ";

	private static final String
		_FINDER_COLUMN_CHANNELID_LANGUAGEID_GLOBALVERSION_GLOBALVERSION_2 =
			"localization.globalVersion = ?";

	private FinderPath _finderPathWithPaginationFindByWorkflowBatchId;
	private FinderPath _finderPathWithoutPaginationFindByWorkflowBatchId;
	private FinderPath _finderPathCountByWorkflowBatchId;

	/**
	 * Returns all the localizations where workflowBatchId = &#63;.
	 *
	 * @param workflowBatchId the workflow batch ID
	 * @return the matching localizations
	 */
	@Override
	public List<Localization> findByWorkflowBatchId(String workflowBatchId) {
		return findByWorkflowBatchId(
			workflowBatchId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the localizations where workflowBatchId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param workflowBatchId the workflow batch ID
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @return the range of matching localizations
	 */
	@Override
	public List<Localization> findByWorkflowBatchId(
		String workflowBatchId, int start, int end) {

		return findByWorkflowBatchId(workflowBatchId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the localizations where workflowBatchId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param workflowBatchId the workflow batch ID
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching localizations
	 */
	@Override
	public List<Localization> findByWorkflowBatchId(
		String workflowBatchId, int start, int end,
		OrderByComparator<Localization> orderByComparator) {

		return findByWorkflowBatchId(
			workflowBatchId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the localizations where workflowBatchId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param workflowBatchId the workflow batch ID
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching localizations
	 */
	@Override
	public List<Localization> findByWorkflowBatchId(
		String workflowBatchId, int start, int end,
		OrderByComparator<Localization> orderByComparator,
		boolean useFinderCache) {

		workflowBatchId = Objects.toString(workflowBatchId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByWorkflowBatchId;
				finderArgs = new Object[] {workflowBatchId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByWorkflowBatchId;
			finderArgs = new Object[] {
				workflowBatchId, start, end, orderByComparator
			};
		}

		List<Localization> list = null;

		if (useFinderCache) {
			list = (List<Localization>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Localization localization : list) {
					if (!workflowBatchId.equals(
							localization.getWorkflowBatchId())) {

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

			sb.append(_SQL_SELECT_LOCALIZATION_WHERE);

			boolean bindWorkflowBatchId = false;

			if (workflowBatchId.isEmpty()) {
				sb.append(_FINDER_COLUMN_WORKFLOWBATCHID_WORKFLOWBATCHID_3);
			}
			else {
				bindWorkflowBatchId = true;

				sb.append(_FINDER_COLUMN_WORKFLOWBATCHID_WORKFLOWBATCHID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LocalizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindWorkflowBatchId) {
					queryPos.add(workflowBatchId);
				}

				list = (List<Localization>)QueryUtil.list(
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
	 * Returns the first localization in the ordered set where workflowBatchId = &#63;.
	 *
	 * @param workflowBatchId the workflow batch ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching localization
	 * @throws NoSuchLocalizationException if a matching localization could not be found
	 */
	@Override
	public Localization findByWorkflowBatchId_First(
			String workflowBatchId,
			OrderByComparator<Localization> orderByComparator)
		throws NoSuchLocalizationException {

		Localization localization = fetchByWorkflowBatchId_First(
			workflowBatchId, orderByComparator);

		if (localization != null) {
			return localization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("workflowBatchId=");
		sb.append(workflowBatchId);

		sb.append("}");

		throw new NoSuchLocalizationException(sb.toString());
	}

	/**
	 * Returns the first localization in the ordered set where workflowBatchId = &#63;.
	 *
	 * @param workflowBatchId the workflow batch ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching localization, or <code>null</code> if a matching localization could not be found
	 */
	@Override
	public Localization fetchByWorkflowBatchId_First(
		String workflowBatchId,
		OrderByComparator<Localization> orderByComparator) {

		List<Localization> list = findByWorkflowBatchId(
			workflowBatchId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last localization in the ordered set where workflowBatchId = &#63;.
	 *
	 * @param workflowBatchId the workflow batch ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching localization
	 * @throws NoSuchLocalizationException if a matching localization could not be found
	 */
	@Override
	public Localization findByWorkflowBatchId_Last(
			String workflowBatchId,
			OrderByComparator<Localization> orderByComparator)
		throws NoSuchLocalizationException {

		Localization localization = fetchByWorkflowBatchId_Last(
			workflowBatchId, orderByComparator);

		if (localization != null) {
			return localization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("workflowBatchId=");
		sb.append(workflowBatchId);

		sb.append("}");

		throw new NoSuchLocalizationException(sb.toString());
	}

	/**
	 * Returns the last localization in the ordered set where workflowBatchId = &#63;.
	 *
	 * @param workflowBatchId the workflow batch ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching localization, or <code>null</code> if a matching localization could not be found
	 */
	@Override
	public Localization fetchByWorkflowBatchId_Last(
		String workflowBatchId,
		OrderByComparator<Localization> orderByComparator) {

		int count = countByWorkflowBatchId(workflowBatchId);

		if (count == 0) {
			return null;
		}

		List<Localization> list = findByWorkflowBatchId(
			workflowBatchId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the localizations before and after the current localization in the ordered set where workflowBatchId = &#63;.
	 *
	 * @param localizationId the primary key of the current localization
	 * @param workflowBatchId the workflow batch ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next localization
	 * @throws NoSuchLocalizationException if a localization with the primary key could not be found
	 */
	@Override
	public Localization[] findByWorkflowBatchId_PrevAndNext(
			long localizationId, String workflowBatchId,
			OrderByComparator<Localization> orderByComparator)
		throws NoSuchLocalizationException {

		workflowBatchId = Objects.toString(workflowBatchId, "");

		Localization localization = findByPrimaryKey(localizationId);

		Session session = null;

		try {
			session = openSession();

			Localization[] array = new LocalizationImpl[3];

			array[0] = getByWorkflowBatchId_PrevAndNext(
				session, localization, workflowBatchId, orderByComparator,
				true);

			array[1] = localization;

			array[2] = getByWorkflowBatchId_PrevAndNext(
				session, localization, workflowBatchId, orderByComparator,
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

	protected Localization getByWorkflowBatchId_PrevAndNext(
		Session session, Localization localization, String workflowBatchId,
		OrderByComparator<Localization> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LOCALIZATION_WHERE);

		boolean bindWorkflowBatchId = false;

		if (workflowBatchId.isEmpty()) {
			sb.append(_FINDER_COLUMN_WORKFLOWBATCHID_WORKFLOWBATCHID_3);
		}
		else {
			bindWorkflowBatchId = true;

			sb.append(_FINDER_COLUMN_WORKFLOWBATCHID_WORKFLOWBATCHID_2);
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
			sb.append(LocalizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindWorkflowBatchId) {
			queryPos.add(workflowBatchId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(localization)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Localization> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the localizations where workflowBatchId = &#63; from the database.
	 *
	 * @param workflowBatchId the workflow batch ID
	 */
	@Override
	public void removeByWorkflowBatchId(String workflowBatchId) {
		for (Localization localization :
				findByWorkflowBatchId(
					workflowBatchId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(localization);
		}
	}

	/**
	 * Returns the number of localizations where workflowBatchId = &#63;.
	 *
	 * @param workflowBatchId the workflow batch ID
	 * @return the number of matching localizations
	 */
	@Override
	public int countByWorkflowBatchId(String workflowBatchId) {
		workflowBatchId = Objects.toString(workflowBatchId, "");

		FinderPath finderPath = _finderPathCountByWorkflowBatchId;

		Object[] finderArgs = new Object[] {workflowBatchId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LOCALIZATION_WHERE);

			boolean bindWorkflowBatchId = false;

			if (workflowBatchId.isEmpty()) {
				sb.append(_FINDER_COLUMN_WORKFLOWBATCHID_WORKFLOWBATCHID_3);
			}
			else {
				bindWorkflowBatchId = true;

				sb.append(_FINDER_COLUMN_WORKFLOWBATCHID_WORKFLOWBATCHID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindWorkflowBatchId) {
					queryPos.add(workflowBatchId);
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

	private static final String
		_FINDER_COLUMN_WORKFLOWBATCHID_WORKFLOWBATCHID_2 =
			"localization.workflowBatchId = ?";

	private static final String
		_FINDER_COLUMN_WORKFLOWBATCHID_WORKFLOWBATCHID_3 =
			"(localization.workflowBatchId IS NULL OR localization.workflowBatchId = '')";

	private FinderPath _finderPathWithPaginationFindByChannelId;
	private FinderPath _finderPathWithoutPaginationFindByChannelId;
	private FinderPath _finderPathCountByChannelId;

	/**
	 * Returns all the localizations where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the matching localizations
	 */
	@Override
	public List<Localization> findByChannelId(long channelId) {
		return findByChannelId(
			channelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the localizations where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @return the range of matching localizations
	 */
	@Override
	public List<Localization> findByChannelId(
		long channelId, int start, int end) {

		return findByChannelId(channelId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the localizations where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching localizations
	 */
	@Override
	public List<Localization> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<Localization> orderByComparator) {

		return findByChannelId(channelId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the localizations where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching localizations
	 */
	@Override
	public List<Localization> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<Localization> orderByComparator,
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

		List<Localization> list = null;

		if (useFinderCache) {
			list = (List<Localization>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Localization localization : list) {
					if (channelId != localization.getChannelId()) {
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

			sb.append(_SQL_SELECT_LOCALIZATION_WHERE);

			sb.append(_FINDER_COLUMN_CHANNELID_CHANNELID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LocalizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				list = (List<Localization>)QueryUtil.list(
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
	 * Returns the first localization in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching localization
	 * @throws NoSuchLocalizationException if a matching localization could not be found
	 */
	@Override
	public Localization findByChannelId_First(
			long channelId, OrderByComparator<Localization> orderByComparator)
		throws NoSuchLocalizationException {

		Localization localization = fetchByChannelId_First(
			channelId, orderByComparator);

		if (localization != null) {
			return localization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append("}");

		throw new NoSuchLocalizationException(sb.toString());
	}

	/**
	 * Returns the first localization in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching localization, or <code>null</code> if a matching localization could not be found
	 */
	@Override
	public Localization fetchByChannelId_First(
		long channelId, OrderByComparator<Localization> orderByComparator) {

		List<Localization> list = findByChannelId(
			channelId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last localization in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching localization
	 * @throws NoSuchLocalizationException if a matching localization could not be found
	 */
	@Override
	public Localization findByChannelId_Last(
			long channelId, OrderByComparator<Localization> orderByComparator)
		throws NoSuchLocalizationException {

		Localization localization = fetchByChannelId_Last(
			channelId, orderByComparator);

		if (localization != null) {
			return localization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append("}");

		throw new NoSuchLocalizationException(sb.toString());
	}

	/**
	 * Returns the last localization in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching localization, or <code>null</code> if a matching localization could not be found
	 */
	@Override
	public Localization fetchByChannelId_Last(
		long channelId, OrderByComparator<Localization> orderByComparator) {

		int count = countByChannelId(channelId);

		if (count == 0) {
			return null;
		}

		List<Localization> list = findByChannelId(
			channelId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the localizations before and after the current localization in the ordered set where channelId = &#63;.
	 *
	 * @param localizationId the primary key of the current localization
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next localization
	 * @throws NoSuchLocalizationException if a localization with the primary key could not be found
	 */
	@Override
	public Localization[] findByChannelId_PrevAndNext(
			long localizationId, long channelId,
			OrderByComparator<Localization> orderByComparator)
		throws NoSuchLocalizationException {

		Localization localization = findByPrimaryKey(localizationId);

		Session session = null;

		try {
			session = openSession();

			Localization[] array = new LocalizationImpl[3];

			array[0] = getByChannelId_PrevAndNext(
				session, localization, channelId, orderByComparator, true);

			array[1] = localization;

			array[2] = getByChannelId_PrevAndNext(
				session, localization, channelId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Localization getByChannelId_PrevAndNext(
		Session session, Localization localization, long channelId,
		OrderByComparator<Localization> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LOCALIZATION_WHERE);

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
			sb.append(LocalizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(channelId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(localization)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Localization> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the localizations where channelId = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 */
	@Override
	public void removeByChannelId(long channelId) {
		for (Localization localization :
				findByChannelId(
					channelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(localization);
		}
	}

	/**
	 * Returns the number of localizations where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the number of matching localizations
	 */
	@Override
	public int countByChannelId(long channelId) {
		FinderPath finderPath = _finderPathCountByChannelId;

		Object[] finderArgs = new Object[] {channelId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LOCALIZATION_WHERE);

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
		"localization.channelId = ?";

	private FinderPath _finderPathWithPaginationFindByentityResourceId;
	private FinderPath _finderPathWithoutPaginationFindByentityResourceId;
	private FinderPath _finderPathCountByentityResourceId;

	/**
	 * Returns all the localizations where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the matching localizations
	 */
	@Override
	public List<Localization> findByentityResourceId(long entityResourceId) {
		return findByentityResourceId(
			entityResourceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the localizations where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @return the range of matching localizations
	 */
	@Override
	public List<Localization> findByentityResourceId(
		long entityResourceId, int start, int end) {

		return findByentityResourceId(entityResourceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the localizations where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching localizations
	 */
	@Override
	public List<Localization> findByentityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<Localization> orderByComparator) {

		return findByentityResourceId(
			entityResourceId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the localizations where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching localizations
	 */
	@Override
	public List<Localization> findByentityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<Localization> orderByComparator,
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

		List<Localization> list = null;

		if (useFinderCache) {
			list = (List<Localization>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Localization localization : list) {
					if (entityResourceId !=
							localization.getEntityResourceId()) {

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

			sb.append(_SQL_SELECT_LOCALIZATION_WHERE);

			sb.append(_FINDER_COLUMN_ENTITYRESOURCEID_ENTITYRESOURCEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LocalizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(entityResourceId);

				list = (List<Localization>)QueryUtil.list(
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
	 * Returns the first localization in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching localization
	 * @throws NoSuchLocalizationException if a matching localization could not be found
	 */
	@Override
	public Localization findByentityResourceId_First(
			long entityResourceId,
			OrderByComparator<Localization> orderByComparator)
		throws NoSuchLocalizationException {

		Localization localization = fetchByentityResourceId_First(
			entityResourceId, orderByComparator);

		if (localization != null) {
			return localization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("entityResourceId=");
		sb.append(entityResourceId);

		sb.append("}");

		throw new NoSuchLocalizationException(sb.toString());
	}

	/**
	 * Returns the first localization in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching localization, or <code>null</code> if a matching localization could not be found
	 */
	@Override
	public Localization fetchByentityResourceId_First(
		long entityResourceId,
		OrderByComparator<Localization> orderByComparator) {

		List<Localization> list = findByentityResourceId(
			entityResourceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last localization in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching localization
	 * @throws NoSuchLocalizationException if a matching localization could not be found
	 */
	@Override
	public Localization findByentityResourceId_Last(
			long entityResourceId,
			OrderByComparator<Localization> orderByComparator)
		throws NoSuchLocalizationException {

		Localization localization = fetchByentityResourceId_Last(
			entityResourceId, orderByComparator);

		if (localization != null) {
			return localization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("entityResourceId=");
		sb.append(entityResourceId);

		sb.append("}");

		throw new NoSuchLocalizationException(sb.toString());
	}

	/**
	 * Returns the last localization in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching localization, or <code>null</code> if a matching localization could not be found
	 */
	@Override
	public Localization fetchByentityResourceId_Last(
		long entityResourceId,
		OrderByComparator<Localization> orderByComparator) {

		int count = countByentityResourceId(entityResourceId);

		if (count == 0) {
			return null;
		}

		List<Localization> list = findByentityResourceId(
			entityResourceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the localizations before and after the current localization in the ordered set where entityResourceId = &#63;.
	 *
	 * @param localizationId the primary key of the current localization
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next localization
	 * @throws NoSuchLocalizationException if a localization with the primary key could not be found
	 */
	@Override
	public Localization[] findByentityResourceId_PrevAndNext(
			long localizationId, long entityResourceId,
			OrderByComparator<Localization> orderByComparator)
		throws NoSuchLocalizationException {

		Localization localization = findByPrimaryKey(localizationId);

		Session session = null;

		try {
			session = openSession();

			Localization[] array = new LocalizationImpl[3];

			array[0] = getByentityResourceId_PrevAndNext(
				session, localization, entityResourceId, orderByComparator,
				true);

			array[1] = localization;

			array[2] = getByentityResourceId_PrevAndNext(
				session, localization, entityResourceId, orderByComparator,
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

	protected Localization getByentityResourceId_PrevAndNext(
		Session session, Localization localization, long entityResourceId,
		OrderByComparator<Localization> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LOCALIZATION_WHERE);

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
			sb.append(LocalizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(entityResourceId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(localization)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Localization> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the localizations where entityResourceId = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 */
	@Override
	public void removeByentityResourceId(long entityResourceId) {
		for (Localization localization :
				findByentityResourceId(
					entityResourceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(localization);
		}
	}

	/**
	 * Returns the number of localizations where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the number of matching localizations
	 */
	@Override
	public int countByentityResourceId(long entityResourceId) {
		FinderPath finderPath = _finderPathCountByentityResourceId;

		Object[] finderArgs = new Object[] {entityResourceId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LOCALIZATION_WHERE);

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
			"localization.entityResourceId = ?";

	private FinderPath _finderPathWithPaginationFindByFeatureId;
	private FinderPath _finderPathWithoutPaginationFindByFeatureId;
	private FinderPath _finderPathCountByFeatureId;

	/**
	 * Returns all the localizations where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @return the matching localizations
	 */
	@Override
	public List<Localization> findByFeatureId(long featureId) {
		return findByFeatureId(
			featureId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the localizations where featureId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param featureId the feature ID
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @return the range of matching localizations
	 */
	@Override
	public List<Localization> findByFeatureId(
		long featureId, int start, int end) {

		return findByFeatureId(featureId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the localizations where featureId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param featureId the feature ID
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching localizations
	 */
	@Override
	public List<Localization> findByFeatureId(
		long featureId, int start, int end,
		OrderByComparator<Localization> orderByComparator) {

		return findByFeatureId(featureId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the localizations where featureId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param featureId the feature ID
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching localizations
	 */
	@Override
	public List<Localization> findByFeatureId(
		long featureId, int start, int end,
		OrderByComparator<Localization> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFeatureId;
				finderArgs = new Object[] {featureId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFeatureId;
			finderArgs = new Object[] {
				featureId, start, end, orderByComparator
			};
		}

		List<Localization> list = null;

		if (useFinderCache) {
			list = (List<Localization>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Localization localization : list) {
					if (featureId != localization.getFeatureId()) {
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

			sb.append(_SQL_SELECT_LOCALIZATION_WHERE);

			sb.append(_FINDER_COLUMN_FEATUREID_FEATUREID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LocalizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(featureId);

				list = (List<Localization>)QueryUtil.list(
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
	 * Returns the first localization in the ordered set where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching localization
	 * @throws NoSuchLocalizationException if a matching localization could not be found
	 */
	@Override
	public Localization findByFeatureId_First(
			long featureId, OrderByComparator<Localization> orderByComparator)
		throws NoSuchLocalizationException {

		Localization localization = fetchByFeatureId_First(
			featureId, orderByComparator);

		if (localization != null) {
			return localization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("featureId=");
		sb.append(featureId);

		sb.append("}");

		throw new NoSuchLocalizationException(sb.toString());
	}

	/**
	 * Returns the first localization in the ordered set where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching localization, or <code>null</code> if a matching localization could not be found
	 */
	@Override
	public Localization fetchByFeatureId_First(
		long featureId, OrderByComparator<Localization> orderByComparator) {

		List<Localization> list = findByFeatureId(
			featureId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last localization in the ordered set where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching localization
	 * @throws NoSuchLocalizationException if a matching localization could not be found
	 */
	@Override
	public Localization findByFeatureId_Last(
			long featureId, OrderByComparator<Localization> orderByComparator)
		throws NoSuchLocalizationException {

		Localization localization = fetchByFeatureId_Last(
			featureId, orderByComparator);

		if (localization != null) {
			return localization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("featureId=");
		sb.append(featureId);

		sb.append("}");

		throw new NoSuchLocalizationException(sb.toString());
	}

	/**
	 * Returns the last localization in the ordered set where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching localization, or <code>null</code> if a matching localization could not be found
	 */
	@Override
	public Localization fetchByFeatureId_Last(
		long featureId, OrderByComparator<Localization> orderByComparator) {

		int count = countByFeatureId(featureId);

		if (count == 0) {
			return null;
		}

		List<Localization> list = findByFeatureId(
			featureId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the localizations before and after the current localization in the ordered set where featureId = &#63;.
	 *
	 * @param localizationId the primary key of the current localization
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next localization
	 * @throws NoSuchLocalizationException if a localization with the primary key could not be found
	 */
	@Override
	public Localization[] findByFeatureId_PrevAndNext(
			long localizationId, long featureId,
			OrderByComparator<Localization> orderByComparator)
		throws NoSuchLocalizationException {

		Localization localization = findByPrimaryKey(localizationId);

		Session session = null;

		try {
			session = openSession();

			Localization[] array = new LocalizationImpl[3];

			array[0] = getByFeatureId_PrevAndNext(
				session, localization, featureId, orderByComparator, true);

			array[1] = localization;

			array[2] = getByFeatureId_PrevAndNext(
				session, localization, featureId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Localization getByFeatureId_PrevAndNext(
		Session session, Localization localization, long featureId,
		OrderByComparator<Localization> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LOCALIZATION_WHERE);

		sb.append(_FINDER_COLUMN_FEATUREID_FEATUREID_2);

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
			sb.append(LocalizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(featureId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(localization)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Localization> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the localizations where featureId = &#63; from the database.
	 *
	 * @param featureId the feature ID
	 */
	@Override
	public void removeByFeatureId(long featureId) {
		for (Localization localization :
				findByFeatureId(
					featureId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(localization);
		}
	}

	/**
	 * Returns the number of localizations where featureId = &#63;.
	 *
	 * @param featureId the feature ID
	 * @return the number of matching localizations
	 */
	@Override
	public int countByFeatureId(long featureId) {
		FinderPath finderPath = _finderPathCountByFeatureId;

		Object[] finderArgs = new Object[] {featureId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LOCALIZATION_WHERE);

			sb.append(_FINDER_COLUMN_FEATUREID_FEATUREID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(featureId);

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

	private static final String _FINDER_COLUMN_FEATUREID_FEATUREID_2 =
		"localization.featureId = ?";

	private FinderPath _finderPathWithPaginationFindByChannelId_FeatureId;
	private FinderPath _finderPathWithoutPaginationFindByChannelId_FeatureId;
	private FinderPath _finderPathCountByChannelId_FeatureId;

	/**
	 * Returns all the localizations where channelId = &#63; and featureId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param featureId the feature ID
	 * @return the matching localizations
	 */
	@Override
	public List<Localization> findByChannelId_FeatureId(
		long channelId, long featureId) {

		return findByChannelId_FeatureId(
			channelId, featureId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the localizations where channelId = &#63; and featureId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param featureId the feature ID
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @return the range of matching localizations
	 */
	@Override
	public List<Localization> findByChannelId_FeatureId(
		long channelId, long featureId, int start, int end) {

		return findByChannelId_FeatureId(
			channelId, featureId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the localizations where channelId = &#63; and featureId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param featureId the feature ID
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching localizations
	 */
	@Override
	public List<Localization> findByChannelId_FeatureId(
		long channelId, long featureId, int start, int end,
		OrderByComparator<Localization> orderByComparator) {

		return findByChannelId_FeatureId(
			channelId, featureId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the localizations where channelId = &#63; and featureId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param featureId the feature ID
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching localizations
	 */
	@Override
	public List<Localization> findByChannelId_FeatureId(
		long channelId, long featureId, int start, int end,
		OrderByComparator<Localization> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByChannelId_FeatureId;
				finderArgs = new Object[] {channelId, featureId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByChannelId_FeatureId;
			finderArgs = new Object[] {
				channelId, featureId, start, end, orderByComparator
			};
		}

		List<Localization> list = null;

		if (useFinderCache) {
			list = (List<Localization>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Localization localization : list) {
					if ((channelId != localization.getChannelId()) ||
						(featureId != localization.getFeatureId())) {

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

			sb.append(_SQL_SELECT_LOCALIZATION_WHERE);

			sb.append(_FINDER_COLUMN_CHANNELID_FEATUREID_CHANNELID_2);

			sb.append(_FINDER_COLUMN_CHANNELID_FEATUREID_FEATUREID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LocalizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				queryPos.add(featureId);

				list = (List<Localization>)QueryUtil.list(
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
	 * Returns the first localization in the ordered set where channelId = &#63; and featureId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching localization
	 * @throws NoSuchLocalizationException if a matching localization could not be found
	 */
	@Override
	public Localization findByChannelId_FeatureId_First(
			long channelId, long featureId,
			OrderByComparator<Localization> orderByComparator)
		throws NoSuchLocalizationException {

		Localization localization = fetchByChannelId_FeatureId_First(
			channelId, featureId, orderByComparator);

		if (localization != null) {
			return localization;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append(", featureId=");
		sb.append(featureId);

		sb.append("}");

		throw new NoSuchLocalizationException(sb.toString());
	}

	/**
	 * Returns the first localization in the ordered set where channelId = &#63; and featureId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching localization, or <code>null</code> if a matching localization could not be found
	 */
	@Override
	public Localization fetchByChannelId_FeatureId_First(
		long channelId, long featureId,
		OrderByComparator<Localization> orderByComparator) {

		List<Localization> list = findByChannelId_FeatureId(
			channelId, featureId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last localization in the ordered set where channelId = &#63; and featureId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching localization
	 * @throws NoSuchLocalizationException if a matching localization could not be found
	 */
	@Override
	public Localization findByChannelId_FeatureId_Last(
			long channelId, long featureId,
			OrderByComparator<Localization> orderByComparator)
		throws NoSuchLocalizationException {

		Localization localization = fetchByChannelId_FeatureId_Last(
			channelId, featureId, orderByComparator);

		if (localization != null) {
			return localization;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append(", featureId=");
		sb.append(featureId);

		sb.append("}");

		throw new NoSuchLocalizationException(sb.toString());
	}

	/**
	 * Returns the last localization in the ordered set where channelId = &#63; and featureId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching localization, or <code>null</code> if a matching localization could not be found
	 */
	@Override
	public Localization fetchByChannelId_FeatureId_Last(
		long channelId, long featureId,
		OrderByComparator<Localization> orderByComparator) {

		int count = countByChannelId_FeatureId(channelId, featureId);

		if (count == 0) {
			return null;
		}

		List<Localization> list = findByChannelId_FeatureId(
			channelId, featureId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the localizations before and after the current localization in the ordered set where channelId = &#63; and featureId = &#63;.
	 *
	 * @param localizationId the primary key of the current localization
	 * @param channelId the channel ID
	 * @param featureId the feature ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next localization
	 * @throws NoSuchLocalizationException if a localization with the primary key could not be found
	 */
	@Override
	public Localization[] findByChannelId_FeatureId_PrevAndNext(
			long localizationId, long channelId, long featureId,
			OrderByComparator<Localization> orderByComparator)
		throws NoSuchLocalizationException {

		Localization localization = findByPrimaryKey(localizationId);

		Session session = null;

		try {
			session = openSession();

			Localization[] array = new LocalizationImpl[3];

			array[0] = getByChannelId_FeatureId_PrevAndNext(
				session, localization, channelId, featureId, orderByComparator,
				true);

			array[1] = localization;

			array[2] = getByChannelId_FeatureId_PrevAndNext(
				session, localization, channelId, featureId, orderByComparator,
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

	protected Localization getByChannelId_FeatureId_PrevAndNext(
		Session session, Localization localization, long channelId,
		long featureId, OrderByComparator<Localization> orderByComparator,
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

		sb.append(_SQL_SELECT_LOCALIZATION_WHERE);

		sb.append(_FINDER_COLUMN_CHANNELID_FEATUREID_CHANNELID_2);

		sb.append(_FINDER_COLUMN_CHANNELID_FEATUREID_FEATUREID_2);

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
			sb.append(LocalizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(channelId);

		queryPos.add(featureId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(localization)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Localization> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the localizations where channelId = &#63; and featureId = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param featureId the feature ID
	 */
	@Override
	public void removeByChannelId_FeatureId(long channelId, long featureId) {
		for (Localization localization :
				findByChannelId_FeatureId(
					channelId, featureId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(localization);
		}
	}

	/**
	 * Returns the number of localizations where channelId = &#63; and featureId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param featureId the feature ID
	 * @return the number of matching localizations
	 */
	@Override
	public int countByChannelId_FeatureId(long channelId, long featureId) {
		FinderPath finderPath = _finderPathCountByChannelId_FeatureId;

		Object[] finderArgs = new Object[] {channelId, featureId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LOCALIZATION_WHERE);

			sb.append(_FINDER_COLUMN_CHANNELID_FEATUREID_CHANNELID_2);

			sb.append(_FINDER_COLUMN_CHANNELID_FEATUREID_FEATUREID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				queryPos.add(featureId);

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

	private static final String _FINDER_COLUMN_CHANNELID_FEATUREID_CHANNELID_2 =
		"localization.channelId = ? AND ";

	private static final String _FINDER_COLUMN_CHANNELID_FEATUREID_FEATUREID_2 =
		"localization.featureId = ?";

	public LocalizationPersistenceImpl() {
		setModelClass(Localization.class);

		setModelImplClass(LocalizationImpl.class);
		setModelPKClass(long.class);

		setTable(LocalizationTable.INSTANCE);
	}

	/**
	 * Caches the localization in the entity cache if it is enabled.
	 *
	 * @param localization the localization
	 */
	@Override
	public void cacheResult(Localization localization) {
		dummyEntityCache.putResult(
			LocalizationImpl.class, localization.getPrimaryKey(), localization);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the localizations in the entity cache if it is enabled.
	 *
	 * @param localizations the localizations
	 */
	@Override
	public void cacheResult(List<Localization> localizations) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (localizations.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Localization localization : localizations) {
			if (dummyEntityCache.getResult(
					LocalizationImpl.class, localization.getPrimaryKey()) ==
						null) {

				cacheResult(localization);
			}
		}
	}

	/**
	 * Clears the cache for all localizations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(LocalizationImpl.class);

		dummyFinderCache.clearCache(LocalizationImpl.class);
	}

	/**
	 * Clears the cache for the localization.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Localization localization) {
		dummyEntityCache.removeResult(LocalizationImpl.class, localization);
	}

	@Override
	public void clearCache(List<Localization> localizations) {
		for (Localization localization : localizations) {
			dummyEntityCache.removeResult(LocalizationImpl.class, localization);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(LocalizationImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(LocalizationImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new localization with the primary key. Does not add the localization to the database.
	 *
	 * @param localizationId the primary key for the new localization
	 * @return the new localization
	 */
	@Override
	public Localization create(long localizationId) {
		Localization localization = new LocalizationImpl();

		localization.setNew(true);
		localization.setPrimaryKey(localizationId);

		localization.setCompanyId(CompanyThreadLocal.getCompanyId());

		return localization;
	}

	/**
	 * Removes the localization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param localizationId the primary key of the localization
	 * @return the localization that was removed
	 * @throws NoSuchLocalizationException if a localization with the primary key could not be found
	 */
	@Override
	public Localization remove(long localizationId)
		throws NoSuchLocalizationException {

		return remove((Serializable)localizationId);
	}

	/**
	 * Removes the localization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the localization
	 * @return the localization that was removed
	 * @throws NoSuchLocalizationException if a localization with the primary key could not be found
	 */
	@Override
	public Localization remove(Serializable primaryKey)
		throws NoSuchLocalizationException {

		Session session = null;

		try {
			session = openSession();

			Localization localization = (Localization)session.get(
				LocalizationImpl.class, primaryKey);

			if (localization == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLocalizationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(localization);
		}
		catch (NoSuchLocalizationException noSuchEntityException) {
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
	protected Localization removeImpl(Localization localization) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(localization)) {
				localization = (Localization)session.get(
					LocalizationImpl.class, localization.getPrimaryKeyObj());
			}

			if (localization != null) {
				session.delete(localization);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (localization != null) {
			clearCache(localization);
		}

		return localization;
	}

	@Override
	public Localization updateImpl(Localization localization) {
		boolean isNew = localization.isNew();

		if (!(localization instanceof LocalizationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(localization.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					localization);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in localization proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Localization implementation " +
					localization.getClass());
		}

		LocalizationModelImpl localizationModelImpl =
			(LocalizationModelImpl)localization;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (localization.getCreateDate() == null)) {
			if (serviceContext == null) {
				localization.setCreateDate(date);
			}
			else {
				localization.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!localizationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				localization.setModifiedDate(date);
			}
			else {
				localization.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(localization);
			}
			else {
				localization = (Localization)session.merge(localization);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			LocalizationImpl.class, localizationModelImpl, false, true);

		if (isNew) {
			localization.setNew(false);
		}

		localization.resetOriginalValues();

		return localization;
	}

	/**
	 * Returns the localization with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the localization
	 * @return the localization
	 * @throws NoSuchLocalizationException if a localization with the primary key could not be found
	 */
	@Override
	public Localization findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLocalizationException {

		Localization localization = fetchByPrimaryKey(primaryKey);

		if (localization == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLocalizationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return localization;
	}

	/**
	 * Returns the localization with the primary key or throws a <code>NoSuchLocalizationException</code> if it could not be found.
	 *
	 * @param localizationId the primary key of the localization
	 * @return the localization
	 * @throws NoSuchLocalizationException if a localization with the primary key could not be found
	 */
	@Override
	public Localization findByPrimaryKey(long localizationId)
		throws NoSuchLocalizationException {

		return findByPrimaryKey((Serializable)localizationId);
	}

	/**
	 * Returns the localization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param localizationId the primary key of the localization
	 * @return the localization, or <code>null</code> if a localization with the primary key could not be found
	 */
	@Override
	public Localization fetchByPrimaryKey(long localizationId) {
		return fetchByPrimaryKey((Serializable)localizationId);
	}

	/**
	 * Returns all the localizations.
	 *
	 * @return the localizations
	 */
	@Override
	public List<Localization> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the localizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @return the range of localizations
	 */
	@Override
	public List<Localization> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the localizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of localizations
	 */
	@Override
	public List<Localization> findAll(
		int start, int end, OrderByComparator<Localization> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the localizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of localizations
	 * @param end the upper bound of the range of localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of localizations
	 */
	@Override
	public List<Localization> findAll(
		int start, int end, OrderByComparator<Localization> orderByComparator,
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

		List<Localization> list = null;

		if (useFinderCache) {
			list = (List<Localization>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LOCALIZATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LOCALIZATION;

				sql = sql.concat(LocalizationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Localization>)QueryUtil.list(
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
	 * Removes all the localizations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Localization localization : findAll()) {
			remove(localization);
		}
	}

	/**
	 * Returns the number of localizations.
	 *
	 * @return the number of localizations
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_LOCALIZATION);

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
		return "localizationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LOCALIZATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LocalizationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the localization persistence.
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

		_finderPathWithPaginationFindByChannelId_LanguageId_GlobalVersion =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByChannelId_LanguageId_GlobalVersion",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"channelId", "languageId", "globalVersion"},
				true);

		_finderPathWithoutPaginationFindByChannelId_LanguageId_GlobalVersion =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByChannelId_LanguageId_GlobalVersion",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName()
				},
				new String[] {"channelId", "languageId", "globalVersion"},
				true);

		_finderPathCountByChannelId_LanguageId_GlobalVersion = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByChannelId_LanguageId_GlobalVersion",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			new String[] {"channelId", "languageId", "globalVersion"}, false);

		_finderPathWithPaginationFindByWorkflowBatchId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByWorkflowBatchId",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"workflowBatchId"}, true);

		_finderPathWithoutPaginationFindByWorkflowBatchId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByWorkflowBatchId",
			new String[] {String.class.getName()},
			new String[] {"workflowBatchId"}, true);

		_finderPathCountByWorkflowBatchId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByWorkflowBatchId",
			new String[] {String.class.getName()},
			new String[] {"workflowBatchId"}, false);

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

		_finderPathWithPaginationFindByFeatureId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFeatureId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"featureId"}, true);

		_finderPathWithoutPaginationFindByFeatureId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFeatureId",
			new String[] {Long.class.getName()}, new String[] {"featureId"},
			true);

		_finderPathCountByFeatureId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFeatureId",
			new String[] {Long.class.getName()}, new String[] {"featureId"},
			false);

		_finderPathWithPaginationFindByChannelId_FeatureId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByChannelId_FeatureId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"channelId", "featureId"}, true);

		_finderPathWithoutPaginationFindByChannelId_FeatureId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByChannelId_FeatureId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"channelId", "featureId"}, true);

		_finderPathCountByChannelId_FeatureId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByChannelId_FeatureId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"channelId", "featureId"}, false);

		LocalizationUtil.setPersistence(this);
	}

	public void destroy() {
		LocalizationUtil.setPersistence(null);

		dummyEntityCache.removeCache(LocalizationImpl.class.getName());
	}

	private static final String _SQL_SELECT_LOCALIZATION =
		"SELECT localization FROM Localization localization";

	private static final String _SQL_SELECT_LOCALIZATION_WHERE =
		"SELECT localization FROM Localization localization WHERE ";

	private static final String _SQL_COUNT_LOCALIZATION =
		"SELECT COUNT(localization) FROM Localization localization";

	private static final String _SQL_COUNT_LOCALIZATION_WHERE =
		"SELECT COUNT(localization) FROM Localization localization WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "localization.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Localization exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Localization exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LocalizationPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}