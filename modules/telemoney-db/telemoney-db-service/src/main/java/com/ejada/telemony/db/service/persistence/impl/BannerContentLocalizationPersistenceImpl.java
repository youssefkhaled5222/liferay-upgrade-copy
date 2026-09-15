/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence.impl;

import com.ejada.telemony.db.exception.NoSuchBannerContentLocalizationException;
import com.ejada.telemony.db.model.BannerContentLocalization;
import com.ejada.telemony.db.model.BannerContentLocalizationTable;
import com.ejada.telemony.db.model.impl.BannerContentLocalizationImpl;
import com.ejada.telemony.db.model.impl.BannerContentLocalizationModelImpl;
import com.ejada.telemony.db.service.persistence.BannerContentLocalizationPersistence;
import com.ejada.telemony.db.service.persistence.BannerContentLocalizationUtil;

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
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the banner content localization service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BannerContentLocalizationPersistenceImpl
	extends BasePersistenceImpl<BannerContentLocalization>
	implements BannerContentLocalizationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BannerContentLocalizationUtil</code> to access the banner content localization persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BannerContentLocalizationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByContentId;
	private FinderPath _finderPathWithoutPaginationFindByContentId;
	private FinderPath _finderPathCountByContentId;

	/**
	 * Returns all the banner content localizations where contentId = &#63;.
	 *
	 * @param contentId the content ID
	 * @return the matching banner content localizations
	 */
	@Override
	public List<BannerContentLocalization> findByContentId(long contentId) {
		return findByContentId(
			contentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the banner content localizations where contentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param contentId the content ID
	 * @param start the lower bound of the range of banner content localizations
	 * @param end the upper bound of the range of banner content localizations (not inclusive)
	 * @return the range of matching banner content localizations
	 */
	@Override
	public List<BannerContentLocalization> findByContentId(
		long contentId, int start, int end) {

		return findByContentId(contentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the banner content localizations where contentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param contentId the content ID
	 * @param start the lower bound of the range of banner content localizations
	 * @param end the upper bound of the range of banner content localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching banner content localizations
	 */
	@Override
	public List<BannerContentLocalization> findByContentId(
		long contentId, int start, int end,
		OrderByComparator<BannerContentLocalization> orderByComparator) {

		return findByContentId(contentId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the banner content localizations where contentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param contentId the content ID
	 * @param start the lower bound of the range of banner content localizations
	 * @param end the upper bound of the range of banner content localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching banner content localizations
	 */
	@Override
	public List<BannerContentLocalization> findByContentId(
		long contentId, int start, int end,
		OrderByComparator<BannerContentLocalization> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByContentId;
				finderArgs = new Object[] {contentId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByContentId;
			finderArgs = new Object[] {
				contentId, start, end, orderByComparator
			};
		}

		List<BannerContentLocalization> list = null;

		if (useFinderCache) {
			list = (List<BannerContentLocalization>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BannerContentLocalization bannerContentLocalization :
						list) {

					if (contentId != bannerContentLocalization.getContentId()) {
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

			sb.append(_SQL_SELECT_BANNERCONTENTLOCALIZATION_WHERE);

			sb.append(_FINDER_COLUMN_CONTENTID_CONTENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BannerContentLocalizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(contentId);

				list = (List<BannerContentLocalization>)QueryUtil.list(
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
	 * Returns the first banner content localization in the ordered set where contentId = &#63;.
	 *
	 * @param contentId the content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner content localization
	 * @throws NoSuchBannerContentLocalizationException if a matching banner content localization could not be found
	 */
	@Override
	public BannerContentLocalization findByContentId_First(
			long contentId,
			OrderByComparator<BannerContentLocalization> orderByComparator)
		throws NoSuchBannerContentLocalizationException {

		BannerContentLocalization bannerContentLocalization =
			fetchByContentId_First(contentId, orderByComparator);

		if (bannerContentLocalization != null) {
			return bannerContentLocalization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("contentId=");
		sb.append(contentId);

		sb.append("}");

		throw new NoSuchBannerContentLocalizationException(sb.toString());
	}

	/**
	 * Returns the first banner content localization in the ordered set where contentId = &#63;.
	 *
	 * @param contentId the content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner content localization, or <code>null</code> if a matching banner content localization could not be found
	 */
	@Override
	public BannerContentLocalization fetchByContentId_First(
		long contentId,
		OrderByComparator<BannerContentLocalization> orderByComparator) {

		List<BannerContentLocalization> list = findByContentId(
			contentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last banner content localization in the ordered set where contentId = &#63;.
	 *
	 * @param contentId the content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner content localization
	 * @throws NoSuchBannerContentLocalizationException if a matching banner content localization could not be found
	 */
	@Override
	public BannerContentLocalization findByContentId_Last(
			long contentId,
			OrderByComparator<BannerContentLocalization> orderByComparator)
		throws NoSuchBannerContentLocalizationException {

		BannerContentLocalization bannerContentLocalization =
			fetchByContentId_Last(contentId, orderByComparator);

		if (bannerContentLocalization != null) {
			return bannerContentLocalization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("contentId=");
		sb.append(contentId);

		sb.append("}");

		throw new NoSuchBannerContentLocalizationException(sb.toString());
	}

	/**
	 * Returns the last banner content localization in the ordered set where contentId = &#63;.
	 *
	 * @param contentId the content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner content localization, or <code>null</code> if a matching banner content localization could not be found
	 */
	@Override
	public BannerContentLocalization fetchByContentId_Last(
		long contentId,
		OrderByComparator<BannerContentLocalization> orderByComparator) {

		int count = countByContentId(contentId);

		if (count == 0) {
			return null;
		}

		List<BannerContentLocalization> list = findByContentId(
			contentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the banner content localizations before and after the current banner content localization in the ordered set where contentId = &#63;.
	 *
	 * @param bannerContentLocalizationId the primary key of the current banner content localization
	 * @param contentId the content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next banner content localization
	 * @throws NoSuchBannerContentLocalizationException if a banner content localization with the primary key could not be found
	 */
	@Override
	public BannerContentLocalization[] findByContentId_PrevAndNext(
			long bannerContentLocalizationId, long contentId,
			OrderByComparator<BannerContentLocalization> orderByComparator)
		throws NoSuchBannerContentLocalizationException {

		BannerContentLocalization bannerContentLocalization = findByPrimaryKey(
			bannerContentLocalizationId);

		Session session = null;

		try {
			session = openSession();

			BannerContentLocalization[] array =
				new BannerContentLocalizationImpl[3];

			array[0] = getByContentId_PrevAndNext(
				session, bannerContentLocalization, contentId,
				orderByComparator, true);

			array[1] = bannerContentLocalization;

			array[2] = getByContentId_PrevAndNext(
				session, bannerContentLocalization, contentId,
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

	protected BannerContentLocalization getByContentId_PrevAndNext(
		Session session, BannerContentLocalization bannerContentLocalization,
		long contentId,
		OrderByComparator<BannerContentLocalization> orderByComparator,
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

		sb.append(_SQL_SELECT_BANNERCONTENTLOCALIZATION_WHERE);

		sb.append(_FINDER_COLUMN_CONTENTID_CONTENTID_2);

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
			sb.append(BannerContentLocalizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(contentId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						bannerContentLocalization)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BannerContentLocalization> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the banner content localizations where contentId = &#63; from the database.
	 *
	 * @param contentId the content ID
	 */
	@Override
	public void removeByContentId(long contentId) {
		for (BannerContentLocalization bannerContentLocalization :
				findByContentId(
					contentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(bannerContentLocalization);
		}
	}

	/**
	 * Returns the number of banner content localizations where contentId = &#63;.
	 *
	 * @param contentId the content ID
	 * @return the number of matching banner content localizations
	 */
	@Override
	public int countByContentId(long contentId) {
		FinderPath finderPath = _finderPathCountByContentId;

		Object[] finderArgs = new Object[] {contentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BANNERCONTENTLOCALIZATION_WHERE);

			sb.append(_FINDER_COLUMN_CONTENTID_CONTENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(contentId);

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

	private static final String _FINDER_COLUMN_CONTENTID_CONTENTID_2 =
		"bannerContentLocalization.contentId = ?";

	private FinderPath _finderPathFetchByContentId_LanguageId;

	/**
	 * Returns the banner content localization where contentId = &#63; and languageId = &#63; or throws a <code>NoSuchBannerContentLocalizationException</code> if it could not be found.
	 *
	 * @param contentId the content ID
	 * @param languageId the language ID
	 * @return the matching banner content localization
	 * @throws NoSuchBannerContentLocalizationException if a matching banner content localization could not be found
	 */
	@Override
	public BannerContentLocalization findByContentId_LanguageId(
			long contentId, String languageId)
		throws NoSuchBannerContentLocalizationException {

		BannerContentLocalization bannerContentLocalization =
			fetchByContentId_LanguageId(contentId, languageId);

		if (bannerContentLocalization == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("contentId=");
			sb.append(contentId);

			sb.append(", languageId=");
			sb.append(languageId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchBannerContentLocalizationException(sb.toString());
		}

		return bannerContentLocalization;
	}

	/**
	 * Returns the banner content localization where contentId = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param contentId the content ID
	 * @param languageId the language ID
	 * @return the matching banner content localization, or <code>null</code> if a matching banner content localization could not be found
	 */
	@Override
	public BannerContentLocalization fetchByContentId_LanguageId(
		long contentId, String languageId) {

		return fetchByContentId_LanguageId(contentId, languageId, true);
	}

	/**
	 * Returns the banner content localization where contentId = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param contentId the content ID
	 * @param languageId the language ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching banner content localization, or <code>null</code> if a matching banner content localization could not be found
	 */
	@Override
	public BannerContentLocalization fetchByContentId_LanguageId(
		long contentId, String languageId, boolean useFinderCache) {

		languageId = Objects.toString(languageId, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {contentId, languageId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByContentId_LanguageId, finderArgs, this);
		}

		if (result instanceof BannerContentLocalization) {
			BannerContentLocalization bannerContentLocalization =
				(BannerContentLocalization)result;

			if ((contentId != bannerContentLocalization.getContentId()) ||
				!Objects.equals(
					languageId, bannerContentLocalization.getLanguageId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_BANNERCONTENTLOCALIZATION_WHERE);

			sb.append(_FINDER_COLUMN_CONTENTID_LANGUAGEID_CONTENTID_2);

			boolean bindLanguageId = false;

			if (languageId.isEmpty()) {
				sb.append(_FINDER_COLUMN_CONTENTID_LANGUAGEID_LANGUAGEID_3);
			}
			else {
				bindLanguageId = true;

				sb.append(_FINDER_COLUMN_CONTENTID_LANGUAGEID_LANGUAGEID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(contentId);

				if (bindLanguageId) {
					queryPos.add(languageId);
				}

				List<BannerContentLocalization> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByContentId_LanguageId, finderArgs,
							list);
					}
				}
				else {
					BannerContentLocalization bannerContentLocalization =
						list.get(0);

					result = bannerContentLocalization;

					cacheResult(bannerContentLocalization);
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
			return (BannerContentLocalization)result;
		}
	}

	/**
	 * Removes the banner content localization where contentId = &#63; and languageId = &#63; from the database.
	 *
	 * @param contentId the content ID
	 * @param languageId the language ID
	 * @return the banner content localization that was removed
	 */
	@Override
	public BannerContentLocalization removeByContentId_LanguageId(
			long contentId, String languageId)
		throws NoSuchBannerContentLocalizationException {

		BannerContentLocalization bannerContentLocalization =
			findByContentId_LanguageId(contentId, languageId);

		return remove(bannerContentLocalization);
	}

	/**
	 * Returns the number of banner content localizations where contentId = &#63; and languageId = &#63;.
	 *
	 * @param contentId the content ID
	 * @param languageId the language ID
	 * @return the number of matching banner content localizations
	 */
	@Override
	public int countByContentId_LanguageId(long contentId, String languageId) {
		BannerContentLocalization bannerContentLocalization =
			fetchByContentId_LanguageId(contentId, languageId);

		if (bannerContentLocalization == null) {
			return 0;
		}

		return 1;
	}

	private static final String
		_FINDER_COLUMN_CONTENTID_LANGUAGEID_CONTENTID_2 =
			"bannerContentLocalization.contentId = ? AND ";

	private static final String
		_FINDER_COLUMN_CONTENTID_LANGUAGEID_LANGUAGEID_2 =
			"bannerContentLocalization.languageId = ?";

	private static final String
		_FINDER_COLUMN_CONTENTID_LANGUAGEID_LANGUAGEID_3 =
			"(bannerContentLocalization.languageId IS NULL OR bannerContentLocalization.languageId = '')";

	private FinderPath _finderPathWithPaginationFindByLanguage;
	private FinderPath _finderPathWithoutPaginationFindByLanguage;
	private FinderPath _finderPathCountByLanguage;

	/**
	 * Returns all the banner content localizations where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @return the matching banner content localizations
	 */
	@Override
	public List<BannerContentLocalization> findByLanguage(String languageId) {
		return findByLanguage(
			languageId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the banner content localizations where languageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param start the lower bound of the range of banner content localizations
	 * @param end the upper bound of the range of banner content localizations (not inclusive)
	 * @return the range of matching banner content localizations
	 */
	@Override
	public List<BannerContentLocalization> findByLanguage(
		String languageId, int start, int end) {

		return findByLanguage(languageId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the banner content localizations where languageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param start the lower bound of the range of banner content localizations
	 * @param end the upper bound of the range of banner content localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching banner content localizations
	 */
	@Override
	public List<BannerContentLocalization> findByLanguage(
		String languageId, int start, int end,
		OrderByComparator<BannerContentLocalization> orderByComparator) {

		return findByLanguage(languageId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the banner content localizations where languageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param start the lower bound of the range of banner content localizations
	 * @param end the upper bound of the range of banner content localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching banner content localizations
	 */
	@Override
	public List<BannerContentLocalization> findByLanguage(
		String languageId, int start, int end,
		OrderByComparator<BannerContentLocalization> orderByComparator,
		boolean useFinderCache) {

		languageId = Objects.toString(languageId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByLanguage;
				finderArgs = new Object[] {languageId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByLanguage;
			finderArgs = new Object[] {
				languageId, start, end, orderByComparator
			};
		}

		List<BannerContentLocalization> list = null;

		if (useFinderCache) {
			list = (List<BannerContentLocalization>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BannerContentLocalization bannerContentLocalization :
						list) {

					if (!languageId.equals(
							bannerContentLocalization.getLanguageId())) {

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

			sb.append(_SQL_SELECT_BANNERCONTENTLOCALIZATION_WHERE);

			boolean bindLanguageId = false;

			if (languageId.isEmpty()) {
				sb.append(_FINDER_COLUMN_LANGUAGE_LANGUAGEID_3);
			}
			else {
				bindLanguageId = true;

				sb.append(_FINDER_COLUMN_LANGUAGE_LANGUAGEID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BannerContentLocalizationModelImpl.ORDER_BY_JPQL);
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

				list = (List<BannerContentLocalization>)QueryUtil.list(
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
	 * Returns the first banner content localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner content localization
	 * @throws NoSuchBannerContentLocalizationException if a matching banner content localization could not be found
	 */
	@Override
	public BannerContentLocalization findByLanguage_First(
			String languageId,
			OrderByComparator<BannerContentLocalization> orderByComparator)
		throws NoSuchBannerContentLocalizationException {

		BannerContentLocalization bannerContentLocalization =
			fetchByLanguage_First(languageId, orderByComparator);

		if (bannerContentLocalization != null) {
			return bannerContentLocalization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("languageId=");
		sb.append(languageId);

		sb.append("}");

		throw new NoSuchBannerContentLocalizationException(sb.toString());
	}

	/**
	 * Returns the first banner content localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner content localization, or <code>null</code> if a matching banner content localization could not be found
	 */
	@Override
	public BannerContentLocalization fetchByLanguage_First(
		String languageId,
		OrderByComparator<BannerContentLocalization> orderByComparator) {

		List<BannerContentLocalization> list = findByLanguage(
			languageId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last banner content localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner content localization
	 * @throws NoSuchBannerContentLocalizationException if a matching banner content localization could not be found
	 */
	@Override
	public BannerContentLocalization findByLanguage_Last(
			String languageId,
			OrderByComparator<BannerContentLocalization> orderByComparator)
		throws NoSuchBannerContentLocalizationException {

		BannerContentLocalization bannerContentLocalization =
			fetchByLanguage_Last(languageId, orderByComparator);

		if (bannerContentLocalization != null) {
			return bannerContentLocalization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("languageId=");
		sb.append(languageId);

		sb.append("}");

		throw new NoSuchBannerContentLocalizationException(sb.toString());
	}

	/**
	 * Returns the last banner content localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner content localization, or <code>null</code> if a matching banner content localization could not be found
	 */
	@Override
	public BannerContentLocalization fetchByLanguage_Last(
		String languageId,
		OrderByComparator<BannerContentLocalization> orderByComparator) {

		int count = countByLanguage(languageId);

		if (count == 0) {
			return null;
		}

		List<BannerContentLocalization> list = findByLanguage(
			languageId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the banner content localizations before and after the current banner content localization in the ordered set where languageId = &#63;.
	 *
	 * @param bannerContentLocalizationId the primary key of the current banner content localization
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next banner content localization
	 * @throws NoSuchBannerContentLocalizationException if a banner content localization with the primary key could not be found
	 */
	@Override
	public BannerContentLocalization[] findByLanguage_PrevAndNext(
			long bannerContentLocalizationId, String languageId,
			OrderByComparator<BannerContentLocalization> orderByComparator)
		throws NoSuchBannerContentLocalizationException {

		languageId = Objects.toString(languageId, "");

		BannerContentLocalization bannerContentLocalization = findByPrimaryKey(
			bannerContentLocalizationId);

		Session session = null;

		try {
			session = openSession();

			BannerContentLocalization[] array =
				new BannerContentLocalizationImpl[3];

			array[0] = getByLanguage_PrevAndNext(
				session, bannerContentLocalization, languageId,
				orderByComparator, true);

			array[1] = bannerContentLocalization;

			array[2] = getByLanguage_PrevAndNext(
				session, bannerContentLocalization, languageId,
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

	protected BannerContentLocalization getByLanguage_PrevAndNext(
		Session session, BannerContentLocalization bannerContentLocalization,
		String languageId,
		OrderByComparator<BannerContentLocalization> orderByComparator,
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

		sb.append(_SQL_SELECT_BANNERCONTENTLOCALIZATION_WHERE);

		boolean bindLanguageId = false;

		if (languageId.isEmpty()) {
			sb.append(_FINDER_COLUMN_LANGUAGE_LANGUAGEID_3);
		}
		else {
			bindLanguageId = true;

			sb.append(_FINDER_COLUMN_LANGUAGE_LANGUAGEID_2);
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
			sb.append(BannerContentLocalizationModelImpl.ORDER_BY_JPQL);
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
						bannerContentLocalization)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BannerContentLocalization> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the banner content localizations where languageId = &#63; from the database.
	 *
	 * @param languageId the language ID
	 */
	@Override
	public void removeByLanguage(String languageId) {
		for (BannerContentLocalization bannerContentLocalization :
				findByLanguage(
					languageId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(bannerContentLocalization);
		}
	}

	/**
	 * Returns the number of banner content localizations where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @return the number of matching banner content localizations
	 */
	@Override
	public int countByLanguage(String languageId) {
		languageId = Objects.toString(languageId, "");

		FinderPath finderPath = _finderPathCountByLanguage;

		Object[] finderArgs = new Object[] {languageId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BANNERCONTENTLOCALIZATION_WHERE);

			boolean bindLanguageId = false;

			if (languageId.isEmpty()) {
				sb.append(_FINDER_COLUMN_LANGUAGE_LANGUAGEID_3);
			}
			else {
				bindLanguageId = true;

				sb.append(_FINDER_COLUMN_LANGUAGE_LANGUAGEID_2);
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

	private static final String _FINDER_COLUMN_LANGUAGE_LANGUAGEID_2 =
		"bannerContentLocalization.languageId = ?";

	private static final String _FINDER_COLUMN_LANGUAGE_LANGUAGEID_3 =
		"(bannerContentLocalization.languageId IS NULL OR bannerContentLocalization.languageId = '')";

	public BannerContentLocalizationPersistenceImpl() {
		setModelClass(BannerContentLocalization.class);

		setModelImplClass(BannerContentLocalizationImpl.class);
		setModelPKClass(long.class);

		setTable(BannerContentLocalizationTable.INSTANCE);
	}

	/**
	 * Caches the banner content localization in the entity cache if it is enabled.
	 *
	 * @param bannerContentLocalization the banner content localization
	 */
	@Override
	public void cacheResult(
		BannerContentLocalization bannerContentLocalization) {

		entityCache.putResult(
			BannerContentLocalizationImpl.class,
			bannerContentLocalization.getPrimaryKey(),
			bannerContentLocalization);

		finderCache.putResult(
			_finderPathFetchByContentId_LanguageId,
			new Object[] {
				bannerContentLocalization.getContentId(),
				bannerContentLocalization.getLanguageId()
			},
			bannerContentLocalization);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the banner content localizations in the entity cache if it is enabled.
	 *
	 * @param bannerContentLocalizations the banner content localizations
	 */
	@Override
	public void cacheResult(
		List<BannerContentLocalization> bannerContentLocalizations) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (bannerContentLocalizations.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (BannerContentLocalization bannerContentLocalization :
				bannerContentLocalizations) {

			if (entityCache.getResult(
					BannerContentLocalizationImpl.class,
					bannerContentLocalization.getPrimaryKey()) == null) {

				cacheResult(bannerContentLocalization);
			}
		}
	}

	/**
	 * Clears the cache for all banner content localizations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BannerContentLocalizationImpl.class);

		finderCache.clearCache(BannerContentLocalizationImpl.class);
	}

	/**
	 * Clears the cache for the banner content localization.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		BannerContentLocalization bannerContentLocalization) {

		entityCache.removeResult(
			BannerContentLocalizationImpl.class, bannerContentLocalization);
	}

	@Override
	public void clearCache(
		List<BannerContentLocalization> bannerContentLocalizations) {

		for (BannerContentLocalization bannerContentLocalization :
				bannerContentLocalizations) {

			entityCache.removeResult(
				BannerContentLocalizationImpl.class, bannerContentLocalization);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(BannerContentLocalizationImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				BannerContentLocalizationImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		BannerContentLocalizationModelImpl bannerContentLocalizationModelImpl) {

		Object[] args = new Object[] {
			bannerContentLocalizationModelImpl.getContentId(),
			bannerContentLocalizationModelImpl.getLanguageId()
		};

		finderCache.putResult(
			_finderPathFetchByContentId_LanguageId, args,
			bannerContentLocalizationModelImpl);
	}

	/**
	 * Creates a new banner content localization with the primary key. Does not add the banner content localization to the database.
	 *
	 * @param bannerContentLocalizationId the primary key for the new banner content localization
	 * @return the new banner content localization
	 */
	@Override
	public BannerContentLocalization create(long bannerContentLocalizationId) {
		BannerContentLocalization bannerContentLocalization =
			new BannerContentLocalizationImpl();

		bannerContentLocalization.setNew(true);
		bannerContentLocalization.setPrimaryKey(bannerContentLocalizationId);

		return bannerContentLocalization;
	}

	/**
	 * Removes the banner content localization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bannerContentLocalizationId the primary key of the banner content localization
	 * @return the banner content localization that was removed
	 * @throws NoSuchBannerContentLocalizationException if a banner content localization with the primary key could not be found
	 */
	@Override
	public BannerContentLocalization remove(long bannerContentLocalizationId)
		throws NoSuchBannerContentLocalizationException {

		return remove((Serializable)bannerContentLocalizationId);
	}

	/**
	 * Removes the banner content localization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the banner content localization
	 * @return the banner content localization that was removed
	 * @throws NoSuchBannerContentLocalizationException if a banner content localization with the primary key could not be found
	 */
	@Override
	public BannerContentLocalization remove(Serializable primaryKey)
		throws NoSuchBannerContentLocalizationException {

		Session session = null;

		try {
			session = openSession();

			BannerContentLocalization bannerContentLocalization =
				(BannerContentLocalization)session.get(
					BannerContentLocalizationImpl.class, primaryKey);

			if (bannerContentLocalization == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBannerContentLocalizationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(bannerContentLocalization);
		}
		catch (NoSuchBannerContentLocalizationException noSuchEntityException) {
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
	protected BannerContentLocalization removeImpl(
		BannerContentLocalization bannerContentLocalization) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bannerContentLocalization)) {
				bannerContentLocalization =
					(BannerContentLocalization)session.get(
						BannerContentLocalizationImpl.class,
						bannerContentLocalization.getPrimaryKeyObj());
			}

			if (bannerContentLocalization != null) {
				session.delete(bannerContentLocalization);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (bannerContentLocalization != null) {
			clearCache(bannerContentLocalization);
		}

		return bannerContentLocalization;
	}

	@Override
	public BannerContentLocalization updateImpl(
		BannerContentLocalization bannerContentLocalization) {

		boolean isNew = bannerContentLocalization.isNew();

		if (!(bannerContentLocalization instanceof
				BannerContentLocalizationModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(bannerContentLocalization.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					bannerContentLocalization);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in bannerContentLocalization proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom BannerContentLocalization implementation " +
					bannerContentLocalization.getClass());
		}

		BannerContentLocalizationModelImpl bannerContentLocalizationModelImpl =
			(BannerContentLocalizationModelImpl)bannerContentLocalization;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(bannerContentLocalization);
			}
			else {
				bannerContentLocalization =
					(BannerContentLocalization)session.merge(
						bannerContentLocalization);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			BannerContentLocalizationImpl.class,
			bannerContentLocalizationModelImpl, false, true);

		cacheUniqueFindersCache(bannerContentLocalizationModelImpl);

		if (isNew) {
			bannerContentLocalization.setNew(false);
		}

		bannerContentLocalization.resetOriginalValues();

		return bannerContentLocalization;
	}

	/**
	 * Returns the banner content localization with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the banner content localization
	 * @return the banner content localization
	 * @throws NoSuchBannerContentLocalizationException if a banner content localization with the primary key could not be found
	 */
	@Override
	public BannerContentLocalization findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBannerContentLocalizationException {

		BannerContentLocalization bannerContentLocalization = fetchByPrimaryKey(
			primaryKey);

		if (bannerContentLocalization == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBannerContentLocalizationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return bannerContentLocalization;
	}

	/**
	 * Returns the banner content localization with the primary key or throws a <code>NoSuchBannerContentLocalizationException</code> if it could not be found.
	 *
	 * @param bannerContentLocalizationId the primary key of the banner content localization
	 * @return the banner content localization
	 * @throws NoSuchBannerContentLocalizationException if a banner content localization with the primary key could not be found
	 */
	@Override
	public BannerContentLocalization findByPrimaryKey(
			long bannerContentLocalizationId)
		throws NoSuchBannerContentLocalizationException {

		return findByPrimaryKey((Serializable)bannerContentLocalizationId);
	}

	/**
	 * Returns the banner content localization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bannerContentLocalizationId the primary key of the banner content localization
	 * @return the banner content localization, or <code>null</code> if a banner content localization with the primary key could not be found
	 */
	@Override
	public BannerContentLocalization fetchByPrimaryKey(
		long bannerContentLocalizationId) {

		return fetchByPrimaryKey((Serializable)bannerContentLocalizationId);
	}

	/**
	 * Returns all the banner content localizations.
	 *
	 * @return the banner content localizations
	 */
	@Override
	public List<BannerContentLocalization> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the banner content localizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of banner content localizations
	 * @param end the upper bound of the range of banner content localizations (not inclusive)
	 * @return the range of banner content localizations
	 */
	@Override
	public List<BannerContentLocalization> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the banner content localizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of banner content localizations
	 * @param end the upper bound of the range of banner content localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of banner content localizations
	 */
	@Override
	public List<BannerContentLocalization> findAll(
		int start, int end,
		OrderByComparator<BannerContentLocalization> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the banner content localizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of banner content localizations
	 * @param end the upper bound of the range of banner content localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of banner content localizations
	 */
	@Override
	public List<BannerContentLocalization> findAll(
		int start, int end,
		OrderByComparator<BannerContentLocalization> orderByComparator,
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

		List<BannerContentLocalization> list = null;

		if (useFinderCache) {
			list = (List<BannerContentLocalization>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BANNERCONTENTLOCALIZATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BANNERCONTENTLOCALIZATION;

				sql = sql.concat(
					BannerContentLocalizationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<BannerContentLocalization>)QueryUtil.list(
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
	 * Removes all the banner content localizations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BannerContentLocalization bannerContentLocalization : findAll()) {
			remove(bannerContentLocalization);
		}
	}

	/**
	 * Returns the number of banner content localizations.
	 *
	 * @return the number of banner content localizations
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
					_SQL_COUNT_BANNERCONTENTLOCALIZATION);

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
		return "bannerContentLocalizationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_BANNERCONTENTLOCALIZATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BannerContentLocalizationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the banner content localization persistence.
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

		_finderPathWithPaginationFindByContentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByContentId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"contentId"}, true);

		_finderPathWithoutPaginationFindByContentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByContentId",
			new String[] {Long.class.getName()}, new String[] {"contentId"},
			true);

		_finderPathCountByContentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByContentId",
			new String[] {Long.class.getName()}, new String[] {"contentId"},
			false);

		_finderPathFetchByContentId_LanguageId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByContentId_LanguageId",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"contentId", "languageId"}, true);

		_finderPathWithPaginationFindByLanguage = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLanguage",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"languageId"}, true);

		_finderPathWithoutPaginationFindByLanguage = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLanguage",
			new String[] {String.class.getName()}, new String[] {"languageId"},
			true);

		_finderPathCountByLanguage = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLanguage",
			new String[] {String.class.getName()}, new String[] {"languageId"},
			false);

		BannerContentLocalizationUtil.setPersistence(this);
	}

	public void destroy() {
		BannerContentLocalizationUtil.setPersistence(null);

		entityCache.removeCache(BannerContentLocalizationImpl.class.getName());
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_BANNERCONTENTLOCALIZATION =
		"SELECT bannerContentLocalization FROM BannerContentLocalization bannerContentLocalization";

	private static final String _SQL_SELECT_BANNERCONTENTLOCALIZATION_WHERE =
		"SELECT bannerContentLocalization FROM BannerContentLocalization bannerContentLocalization WHERE ";

	private static final String _SQL_COUNT_BANNERCONTENTLOCALIZATION =
		"SELECT COUNT(bannerContentLocalization) FROM BannerContentLocalization bannerContentLocalization";

	private static final String _SQL_COUNT_BANNERCONTENTLOCALIZATION_WHERE =
		"SELECT COUNT(bannerContentLocalization) FROM BannerContentLocalization bannerContentLocalization WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"bannerContentLocalization.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No BannerContentLocalization exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No BannerContentLocalization exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BannerContentLocalizationPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}