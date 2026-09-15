/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence.impl;

import com.ejada.telemony.db.exception.NoSuchResourceLocalizationException;
import com.ejada.telemony.db.model.ResourceLocalization;
import com.ejada.telemony.db.model.ResourceLocalizationTable;
import com.ejada.telemony.db.model.impl.ResourceLocalizationImpl;
import com.ejada.telemony.db.model.impl.ResourceLocalizationModelImpl;
import com.ejada.telemony.db.service.persistence.ResourceLocalizationPersistence;
import com.ejada.telemony.db.service.persistence.ResourceLocalizationUtil;

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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the resource localization service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ResourceLocalizationPersistenceImpl
	extends BasePersistenceImpl<ResourceLocalization>
	implements ResourceLocalizationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ResourceLocalizationUtil</code> to access the resource localization persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ResourceLocalizationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByResourceId;
	private FinderPath _finderPathWithoutPaginationFindByResourceId;
	private FinderPath _finderPathCountByResourceId;

	/**
	 * Returns all the resource localizations where resourceId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @return the matching resource localizations
	 */
	@Override
	public List<ResourceLocalization> findByResourceId(long resourceId) {
		return findByResourceId(
			resourceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the resource localizations where resourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param resourceId the resource ID
	 * @param start the lower bound of the range of resource localizations
	 * @param end the upper bound of the range of resource localizations (not inclusive)
	 * @return the range of matching resource localizations
	 */
	@Override
	public List<ResourceLocalization> findByResourceId(
		long resourceId, int start, int end) {

		return findByResourceId(resourceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the resource localizations where resourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param resourceId the resource ID
	 * @param start the lower bound of the range of resource localizations
	 * @param end the upper bound of the range of resource localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resource localizations
	 */
	@Override
	public List<ResourceLocalization> findByResourceId(
		long resourceId, int start, int end,
		OrderByComparator<ResourceLocalization> orderByComparator) {

		return findByResourceId(
			resourceId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the resource localizations where resourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param resourceId the resource ID
	 * @param start the lower bound of the range of resource localizations
	 * @param end the upper bound of the range of resource localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resource localizations
	 */
	@Override
	public List<ResourceLocalization> findByResourceId(
		long resourceId, int start, int end,
		OrderByComparator<ResourceLocalization> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByResourceId;
				finderArgs = new Object[] {resourceId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByResourceId;
			finderArgs = new Object[] {
				resourceId, start, end, orderByComparator
			};
		}

		List<ResourceLocalization> list = null;

		if (useFinderCache) {
			list = (List<ResourceLocalization>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ResourceLocalization resourceLocalization : list) {
					if (resourceId != resourceLocalization.getResourceId()) {
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

			sb.append(_SQL_SELECT_RESOURCELOCALIZATION_WHERE);

			sb.append(_FINDER_COLUMN_RESOURCEID_RESOURCEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ResourceLocalizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(resourceId);

				list = (List<ResourceLocalization>)QueryUtil.list(
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
	 * Returns the first resource localization in the ordered set where resourceId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource localization
	 * @throws NoSuchResourceLocalizationException if a matching resource localization could not be found
	 */
	@Override
	public ResourceLocalization findByResourceId_First(
			long resourceId,
			OrderByComparator<ResourceLocalization> orderByComparator)
		throws NoSuchResourceLocalizationException {

		ResourceLocalization resourceLocalization = fetchByResourceId_First(
			resourceId, orderByComparator);

		if (resourceLocalization != null) {
			return resourceLocalization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("resourceId=");
		sb.append(resourceId);

		sb.append("}");

		throw new NoSuchResourceLocalizationException(sb.toString());
	}

	/**
	 * Returns the first resource localization in the ordered set where resourceId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource localization, or <code>null</code> if a matching resource localization could not be found
	 */
	@Override
	public ResourceLocalization fetchByResourceId_First(
		long resourceId,
		OrderByComparator<ResourceLocalization> orderByComparator) {

		List<ResourceLocalization> list = findByResourceId(
			resourceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last resource localization in the ordered set where resourceId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource localization
	 * @throws NoSuchResourceLocalizationException if a matching resource localization could not be found
	 */
	@Override
	public ResourceLocalization findByResourceId_Last(
			long resourceId,
			OrderByComparator<ResourceLocalization> orderByComparator)
		throws NoSuchResourceLocalizationException {

		ResourceLocalization resourceLocalization = fetchByResourceId_Last(
			resourceId, orderByComparator);

		if (resourceLocalization != null) {
			return resourceLocalization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("resourceId=");
		sb.append(resourceId);

		sb.append("}");

		throw new NoSuchResourceLocalizationException(sb.toString());
	}

	/**
	 * Returns the last resource localization in the ordered set where resourceId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource localization, or <code>null</code> if a matching resource localization could not be found
	 */
	@Override
	public ResourceLocalization fetchByResourceId_Last(
		long resourceId,
		OrderByComparator<ResourceLocalization> orderByComparator) {

		int count = countByResourceId(resourceId);

		if (count == 0) {
			return null;
		}

		List<ResourceLocalization> list = findByResourceId(
			resourceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the resource localizations before and after the current resource localization in the ordered set where resourceId = &#63;.
	 *
	 * @param resourceLocalizationId the primary key of the current resource localization
	 * @param resourceId the resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource localization
	 * @throws NoSuchResourceLocalizationException if a resource localization with the primary key could not be found
	 */
	@Override
	public ResourceLocalization[] findByResourceId_PrevAndNext(
			long resourceLocalizationId, long resourceId,
			OrderByComparator<ResourceLocalization> orderByComparator)
		throws NoSuchResourceLocalizationException {

		ResourceLocalization resourceLocalization = findByPrimaryKey(
			resourceLocalizationId);

		Session session = null;

		try {
			session = openSession();

			ResourceLocalization[] array = new ResourceLocalizationImpl[3];

			array[0] = getByResourceId_PrevAndNext(
				session, resourceLocalization, resourceId, orderByComparator,
				true);

			array[1] = resourceLocalization;

			array[2] = getByResourceId_PrevAndNext(
				session, resourceLocalization, resourceId, orderByComparator,
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

	protected ResourceLocalization getByResourceId_PrevAndNext(
		Session session, ResourceLocalization resourceLocalization,
		long resourceId,
		OrderByComparator<ResourceLocalization> orderByComparator,
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

		sb.append(_SQL_SELECT_RESOURCELOCALIZATION_WHERE);

		sb.append(_FINDER_COLUMN_RESOURCEID_RESOURCEID_2);

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
			sb.append(ResourceLocalizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(resourceId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						resourceLocalization)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ResourceLocalization> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the resource localizations where resourceId = &#63; from the database.
	 *
	 * @param resourceId the resource ID
	 */
	@Override
	public void removeByResourceId(long resourceId) {
		for (ResourceLocalization resourceLocalization :
				findByResourceId(
					resourceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(resourceLocalization);
		}
	}

	/**
	 * Returns the number of resource localizations where resourceId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @return the number of matching resource localizations
	 */
	@Override
	public int countByResourceId(long resourceId) {
		FinderPath finderPath = _finderPathCountByResourceId;

		Object[] finderArgs = new Object[] {resourceId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RESOURCELOCALIZATION_WHERE);

			sb.append(_FINDER_COLUMN_RESOURCEID_RESOURCEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(resourceId);

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

	private static final String _FINDER_COLUMN_RESOURCEID_RESOURCEID_2 =
		"resourceLocalization.resourceId = ?";

	private FinderPath _finderPathFetchByResourceId_LanguageId;

	/**
	 * Returns the resource localization where resourceId = &#63; and languageId = &#63; or throws a <code>NoSuchResourceLocalizationException</code> if it could not be found.
	 *
	 * @param resourceId the resource ID
	 * @param languageId the language ID
	 * @return the matching resource localization
	 * @throws NoSuchResourceLocalizationException if a matching resource localization could not be found
	 */
	@Override
	public ResourceLocalization findByResourceId_LanguageId(
			long resourceId, String languageId)
		throws NoSuchResourceLocalizationException {

		ResourceLocalization resourceLocalization =
			fetchByResourceId_LanguageId(resourceId, languageId);

		if (resourceLocalization == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("resourceId=");
			sb.append(resourceId);

			sb.append(", languageId=");
			sb.append(languageId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchResourceLocalizationException(sb.toString());
		}

		return resourceLocalization;
	}

	/**
	 * Returns the resource localization where resourceId = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param resourceId the resource ID
	 * @param languageId the language ID
	 * @return the matching resource localization, or <code>null</code> if a matching resource localization could not be found
	 */
	@Override
	public ResourceLocalization fetchByResourceId_LanguageId(
		long resourceId, String languageId) {

		return fetchByResourceId_LanguageId(resourceId, languageId, true);
	}

	/**
	 * Returns the resource localization where resourceId = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param resourceId the resource ID
	 * @param languageId the language ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching resource localization, or <code>null</code> if a matching resource localization could not be found
	 */
	@Override
	public ResourceLocalization fetchByResourceId_LanguageId(
		long resourceId, String languageId, boolean useFinderCache) {

		languageId = Objects.toString(languageId, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {resourceId, languageId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByResourceId_LanguageId, finderArgs, this);
		}

		if (result instanceof ResourceLocalization) {
			ResourceLocalization resourceLocalization =
				(ResourceLocalization)result;

			if ((resourceId != resourceLocalization.getResourceId()) ||
				!Objects.equals(
					languageId, resourceLocalization.getLanguageId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_RESOURCELOCALIZATION_WHERE);

			sb.append(_FINDER_COLUMN_RESOURCEID_LANGUAGEID_RESOURCEID_2);

			boolean bindLanguageId = false;

			if (languageId.isEmpty()) {
				sb.append(_FINDER_COLUMN_RESOURCEID_LANGUAGEID_LANGUAGEID_3);
			}
			else {
				bindLanguageId = true;

				sb.append(_FINDER_COLUMN_RESOURCEID_LANGUAGEID_LANGUAGEID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(resourceId);

				if (bindLanguageId) {
					queryPos.add(languageId);
				}

				List<ResourceLocalization> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByResourceId_LanguageId, finderArgs,
							list);
					}
				}
				else {
					ResourceLocalization resourceLocalization = list.get(0);

					result = resourceLocalization;

					cacheResult(resourceLocalization);
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
			return (ResourceLocalization)result;
		}
	}

	/**
	 * Removes the resource localization where resourceId = &#63; and languageId = &#63; from the database.
	 *
	 * @param resourceId the resource ID
	 * @param languageId the language ID
	 * @return the resource localization that was removed
	 */
	@Override
	public ResourceLocalization removeByResourceId_LanguageId(
			long resourceId, String languageId)
		throws NoSuchResourceLocalizationException {

		ResourceLocalization resourceLocalization = findByResourceId_LanguageId(
			resourceId, languageId);

		return remove(resourceLocalization);
	}

	/**
	 * Returns the number of resource localizations where resourceId = &#63; and languageId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @param languageId the language ID
	 * @return the number of matching resource localizations
	 */
	@Override
	public int countByResourceId_LanguageId(
		long resourceId, String languageId) {

		ResourceLocalization resourceLocalization =
			fetchByResourceId_LanguageId(resourceId, languageId);

		if (resourceLocalization == null) {
			return 0;
		}

		return 1;
	}

	private static final String
		_FINDER_COLUMN_RESOURCEID_LANGUAGEID_RESOURCEID_2 =
			"resourceLocalization.resourceId = ? AND ";

	private static final String
		_FINDER_COLUMN_RESOURCEID_LANGUAGEID_LANGUAGEID_2 =
			"resourceLocalization.languageId = ?";

	private static final String
		_FINDER_COLUMN_RESOURCEID_LANGUAGEID_LANGUAGEID_3 =
			"(resourceLocalization.languageId IS NULL OR resourceLocalization.languageId = '')";

	private FinderPath _finderPathWithPaginationFindByLanguage;
	private FinderPath _finderPathWithoutPaginationFindByLanguage;
	private FinderPath _finderPathCountByLanguage;

	/**
	 * Returns all the resource localizations where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @return the matching resource localizations
	 */
	@Override
	public List<ResourceLocalization> findByLanguage(String languageId) {
		return findByLanguage(
			languageId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the resource localizations where languageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param start the lower bound of the range of resource localizations
	 * @param end the upper bound of the range of resource localizations (not inclusive)
	 * @return the range of matching resource localizations
	 */
	@Override
	public List<ResourceLocalization> findByLanguage(
		String languageId, int start, int end) {

		return findByLanguage(languageId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the resource localizations where languageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param start the lower bound of the range of resource localizations
	 * @param end the upper bound of the range of resource localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resource localizations
	 */
	@Override
	public List<ResourceLocalization> findByLanguage(
		String languageId, int start, int end,
		OrderByComparator<ResourceLocalization> orderByComparator) {

		return findByLanguage(languageId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the resource localizations where languageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param start the lower bound of the range of resource localizations
	 * @param end the upper bound of the range of resource localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resource localizations
	 */
	@Override
	public List<ResourceLocalization> findByLanguage(
		String languageId, int start, int end,
		OrderByComparator<ResourceLocalization> orderByComparator,
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

		List<ResourceLocalization> list = null;

		if (useFinderCache) {
			list = (List<ResourceLocalization>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ResourceLocalization resourceLocalization : list) {
					if (!languageId.equals(
							resourceLocalization.getLanguageId())) {

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

			sb.append(_SQL_SELECT_RESOURCELOCALIZATION_WHERE);

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
				sb.append(ResourceLocalizationModelImpl.ORDER_BY_JPQL);
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

				list = (List<ResourceLocalization>)QueryUtil.list(
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
	 * Returns the first resource localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource localization
	 * @throws NoSuchResourceLocalizationException if a matching resource localization could not be found
	 */
	@Override
	public ResourceLocalization findByLanguage_First(
			String languageId,
			OrderByComparator<ResourceLocalization> orderByComparator)
		throws NoSuchResourceLocalizationException {

		ResourceLocalization resourceLocalization = fetchByLanguage_First(
			languageId, orderByComparator);

		if (resourceLocalization != null) {
			return resourceLocalization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("languageId=");
		sb.append(languageId);

		sb.append("}");

		throw new NoSuchResourceLocalizationException(sb.toString());
	}

	/**
	 * Returns the first resource localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource localization, or <code>null</code> if a matching resource localization could not be found
	 */
	@Override
	public ResourceLocalization fetchByLanguage_First(
		String languageId,
		OrderByComparator<ResourceLocalization> orderByComparator) {

		List<ResourceLocalization> list = findByLanguage(
			languageId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last resource localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource localization
	 * @throws NoSuchResourceLocalizationException if a matching resource localization could not be found
	 */
	@Override
	public ResourceLocalization findByLanguage_Last(
			String languageId,
			OrderByComparator<ResourceLocalization> orderByComparator)
		throws NoSuchResourceLocalizationException {

		ResourceLocalization resourceLocalization = fetchByLanguage_Last(
			languageId, orderByComparator);

		if (resourceLocalization != null) {
			return resourceLocalization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("languageId=");
		sb.append(languageId);

		sb.append("}");

		throw new NoSuchResourceLocalizationException(sb.toString());
	}

	/**
	 * Returns the last resource localization in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource localization, or <code>null</code> if a matching resource localization could not be found
	 */
	@Override
	public ResourceLocalization fetchByLanguage_Last(
		String languageId,
		OrderByComparator<ResourceLocalization> orderByComparator) {

		int count = countByLanguage(languageId);

		if (count == 0) {
			return null;
		}

		List<ResourceLocalization> list = findByLanguage(
			languageId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the resource localizations before and after the current resource localization in the ordered set where languageId = &#63;.
	 *
	 * @param resourceLocalizationId the primary key of the current resource localization
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource localization
	 * @throws NoSuchResourceLocalizationException if a resource localization with the primary key could not be found
	 */
	@Override
	public ResourceLocalization[] findByLanguage_PrevAndNext(
			long resourceLocalizationId, String languageId,
			OrderByComparator<ResourceLocalization> orderByComparator)
		throws NoSuchResourceLocalizationException {

		languageId = Objects.toString(languageId, "");

		ResourceLocalization resourceLocalization = findByPrimaryKey(
			resourceLocalizationId);

		Session session = null;

		try {
			session = openSession();

			ResourceLocalization[] array = new ResourceLocalizationImpl[3];

			array[0] = getByLanguage_PrevAndNext(
				session, resourceLocalization, languageId, orderByComparator,
				true);

			array[1] = resourceLocalization;

			array[2] = getByLanguage_PrevAndNext(
				session, resourceLocalization, languageId, orderByComparator,
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

	protected ResourceLocalization getByLanguage_PrevAndNext(
		Session session, ResourceLocalization resourceLocalization,
		String languageId,
		OrderByComparator<ResourceLocalization> orderByComparator,
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

		sb.append(_SQL_SELECT_RESOURCELOCALIZATION_WHERE);

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
			sb.append(ResourceLocalizationModelImpl.ORDER_BY_JPQL);
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
						resourceLocalization)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ResourceLocalization> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the resource localizations where languageId = &#63; from the database.
	 *
	 * @param languageId the language ID
	 */
	@Override
	public void removeByLanguage(String languageId) {
		for (ResourceLocalization resourceLocalization :
				findByLanguage(
					languageId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(resourceLocalization);
		}
	}

	/**
	 * Returns the number of resource localizations where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @return the number of matching resource localizations
	 */
	@Override
	public int countByLanguage(String languageId) {
		languageId = Objects.toString(languageId, "");

		FinderPath finderPath = _finderPathCountByLanguage;

		Object[] finderArgs = new Object[] {languageId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RESOURCELOCALIZATION_WHERE);

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
		"resourceLocalization.languageId = ?";

	private static final String _FINDER_COLUMN_LANGUAGE_LANGUAGEID_3 =
		"(resourceLocalization.languageId IS NULL OR resourceLocalization.languageId = '')";

	private FinderPath _finderPathWithPaginationFindBynameAndLanguageId;
	private FinderPath _finderPathWithPaginationCountBynameAndLanguageId;

	/**
	 * Returns all the resource localizations where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @return the matching resource localizations
	 */
	@Override
	public List<ResourceLocalization> findBynameAndLanguageId(
		String languageId, String name) {

		return findBynameAndLanguageId(
			languageId, name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the resource localizations where languageId = &#63; and name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @param start the lower bound of the range of resource localizations
	 * @param end the upper bound of the range of resource localizations (not inclusive)
	 * @return the range of matching resource localizations
	 */
	@Override
	public List<ResourceLocalization> findBynameAndLanguageId(
		String languageId, String name, int start, int end) {

		return findBynameAndLanguageId(languageId, name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the resource localizations where languageId = &#63; and name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @param start the lower bound of the range of resource localizations
	 * @param end the upper bound of the range of resource localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resource localizations
	 */
	@Override
	public List<ResourceLocalization> findBynameAndLanguageId(
		String languageId, String name, int start, int end,
		OrderByComparator<ResourceLocalization> orderByComparator) {

		return findBynameAndLanguageId(
			languageId, name, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the resource localizations where languageId = &#63; and name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @param start the lower bound of the range of resource localizations
	 * @param end the upper bound of the range of resource localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resource localizations
	 */
	@Override
	public List<ResourceLocalization> findBynameAndLanguageId(
		String languageId, String name, int start, int end,
		OrderByComparator<ResourceLocalization> orderByComparator,
		boolean useFinderCache) {

		languageId = Objects.toString(languageId, "");
		name = Objects.toString(name, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindBynameAndLanguageId;
		finderArgs = new Object[] {
			languageId, name, start, end, orderByComparator
		};

		List<ResourceLocalization> list = null;

		if (useFinderCache) {
			list = (List<ResourceLocalization>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ResourceLocalization resourceLocalization : list) {
					if (!languageId.equals(
							resourceLocalization.getLanguageId()) ||
						!StringUtil.wildcardMatches(
							resourceLocalization.getName(), name, '_', '%',
							'\\', true)) {

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

			sb.append(_SQL_SELECT_RESOURCELOCALIZATION_WHERE);

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
				sb.append(ResourceLocalizationModelImpl.ORDER_BY_JPQL);
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

				list = (List<ResourceLocalization>)QueryUtil.list(
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
	 * Returns the first resource localization in the ordered set where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource localization
	 * @throws NoSuchResourceLocalizationException if a matching resource localization could not be found
	 */
	@Override
	public ResourceLocalization findBynameAndLanguageId_First(
			String languageId, String name,
			OrderByComparator<ResourceLocalization> orderByComparator)
		throws NoSuchResourceLocalizationException {

		ResourceLocalization resourceLocalization =
			fetchBynameAndLanguageId_First(languageId, name, orderByComparator);

		if (resourceLocalization != null) {
			return resourceLocalization;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("languageId=");
		sb.append(languageId);

		sb.append(", nameLIKE");
		sb.append(name);

		sb.append("}");

		throw new NoSuchResourceLocalizationException(sb.toString());
	}

	/**
	 * Returns the first resource localization in the ordered set where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource localization, or <code>null</code> if a matching resource localization could not be found
	 */
	@Override
	public ResourceLocalization fetchBynameAndLanguageId_First(
		String languageId, String name,
		OrderByComparator<ResourceLocalization> orderByComparator) {

		List<ResourceLocalization> list = findBynameAndLanguageId(
			languageId, name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last resource localization in the ordered set where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource localization
	 * @throws NoSuchResourceLocalizationException if a matching resource localization could not be found
	 */
	@Override
	public ResourceLocalization findBynameAndLanguageId_Last(
			String languageId, String name,
			OrderByComparator<ResourceLocalization> orderByComparator)
		throws NoSuchResourceLocalizationException {

		ResourceLocalization resourceLocalization =
			fetchBynameAndLanguageId_Last(languageId, name, orderByComparator);

		if (resourceLocalization != null) {
			return resourceLocalization;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("languageId=");
		sb.append(languageId);

		sb.append(", nameLIKE");
		sb.append(name);

		sb.append("}");

		throw new NoSuchResourceLocalizationException(sb.toString());
	}

	/**
	 * Returns the last resource localization in the ordered set where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource localization, or <code>null</code> if a matching resource localization could not be found
	 */
	@Override
	public ResourceLocalization fetchBynameAndLanguageId_Last(
		String languageId, String name,
		OrderByComparator<ResourceLocalization> orderByComparator) {

		int count = countBynameAndLanguageId(languageId, name);

		if (count == 0) {
			return null;
		}

		List<ResourceLocalization> list = findBynameAndLanguageId(
			languageId, name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the resource localizations before and after the current resource localization in the ordered set where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param resourceLocalizationId the primary key of the current resource localization
	 * @param languageId the language ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource localization
	 * @throws NoSuchResourceLocalizationException if a resource localization with the primary key could not be found
	 */
	@Override
	public ResourceLocalization[] findBynameAndLanguageId_PrevAndNext(
			long resourceLocalizationId, String languageId, String name,
			OrderByComparator<ResourceLocalization> orderByComparator)
		throws NoSuchResourceLocalizationException {

		languageId = Objects.toString(languageId, "");
		name = Objects.toString(name, "");

		ResourceLocalization resourceLocalization = findByPrimaryKey(
			resourceLocalizationId);

		Session session = null;

		try {
			session = openSession();

			ResourceLocalization[] array = new ResourceLocalizationImpl[3];

			array[0] = getBynameAndLanguageId_PrevAndNext(
				session, resourceLocalization, languageId, name,
				orderByComparator, true);

			array[1] = resourceLocalization;

			array[2] = getBynameAndLanguageId_PrevAndNext(
				session, resourceLocalization, languageId, name,
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

	protected ResourceLocalization getBynameAndLanguageId_PrevAndNext(
		Session session, ResourceLocalization resourceLocalization,
		String languageId, String name,
		OrderByComparator<ResourceLocalization> orderByComparator,
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

		sb.append(_SQL_SELECT_RESOURCELOCALIZATION_WHERE);

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
			sb.append(ResourceLocalizationModelImpl.ORDER_BY_JPQL);
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
						resourceLocalization)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ResourceLocalization> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the resource localizations where languageId = &#63; and name LIKE &#63; from the database.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 */
	@Override
	public void removeBynameAndLanguageId(String languageId, String name) {
		for (ResourceLocalization resourceLocalization :
				findBynameAndLanguageId(
					languageId, name, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(resourceLocalization);
		}
	}

	/**
	 * Returns the number of resource localizations where languageId = &#63; and name LIKE &#63;.
	 *
	 * @param languageId the language ID
	 * @param name the name
	 * @return the number of matching resource localizations
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

			sb.append(_SQL_COUNT_RESOURCELOCALIZATION_WHERE);

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
		"resourceLocalization.languageId = ? AND ";

	private static final String _FINDER_COLUMN_NAMEANDLANGUAGEID_LANGUAGEID_3 =
		"(resourceLocalization.languageId IS NULL OR resourceLocalization.languageId = '') AND ";

	private static final String _FINDER_COLUMN_NAMEANDLANGUAGEID_NAME_2 =
		"resourceLocalization.name LIKE ?";

	private static final String _FINDER_COLUMN_NAMEANDLANGUAGEID_NAME_3 =
		"(resourceLocalization.name IS NULL OR resourceLocalization.name LIKE '')";

	public ResourceLocalizationPersistenceImpl() {
		setModelClass(ResourceLocalization.class);

		setModelImplClass(ResourceLocalizationImpl.class);
		setModelPKClass(long.class);

		setTable(ResourceLocalizationTable.INSTANCE);
	}

	/**
	 * Caches the resource localization in the entity cache if it is enabled.
	 *
	 * @param resourceLocalization the resource localization
	 */
	@Override
	public void cacheResult(ResourceLocalization resourceLocalization) {
		entityCache.putResult(
			ResourceLocalizationImpl.class,
			resourceLocalization.getPrimaryKey(), resourceLocalization);

		finderCache.putResult(
			_finderPathFetchByResourceId_LanguageId,
			new Object[] {
				resourceLocalization.getResourceId(),
				resourceLocalization.getLanguageId()
			},
			resourceLocalization);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the resource localizations in the entity cache if it is enabled.
	 *
	 * @param resourceLocalizations the resource localizations
	 */
	@Override
	public void cacheResult(List<ResourceLocalization> resourceLocalizations) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (resourceLocalizations.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ResourceLocalization resourceLocalization :
				resourceLocalizations) {

			if (entityCache.getResult(
					ResourceLocalizationImpl.class,
					resourceLocalization.getPrimaryKey()) == null) {

				cacheResult(resourceLocalization);
			}
		}
	}

	/**
	 * Clears the cache for all resource localizations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ResourceLocalizationImpl.class);

		finderCache.clearCache(ResourceLocalizationImpl.class);
	}

	/**
	 * Clears the cache for the resource localization.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ResourceLocalization resourceLocalization) {
		entityCache.removeResult(
			ResourceLocalizationImpl.class, resourceLocalization);
	}

	@Override
	public void clearCache(List<ResourceLocalization> resourceLocalizations) {
		for (ResourceLocalization resourceLocalization :
				resourceLocalizations) {

			entityCache.removeResult(
				ResourceLocalizationImpl.class, resourceLocalization);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ResourceLocalizationImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				ResourceLocalizationImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ResourceLocalizationModelImpl resourceLocalizationModelImpl) {

		Object[] args = new Object[] {
			resourceLocalizationModelImpl.getResourceId(),
			resourceLocalizationModelImpl.getLanguageId()
		};

		finderCache.putResult(
			_finderPathFetchByResourceId_LanguageId, args,
			resourceLocalizationModelImpl);
	}

	/**
	 * Creates a new resource localization with the primary key. Does not add the resource localization to the database.
	 *
	 * @param resourceLocalizationId the primary key for the new resource localization
	 * @return the new resource localization
	 */
	@Override
	public ResourceLocalization create(long resourceLocalizationId) {
		ResourceLocalization resourceLocalization =
			new ResourceLocalizationImpl();

		resourceLocalization.setNew(true);
		resourceLocalization.setPrimaryKey(resourceLocalizationId);

		resourceLocalization.setCompanyId(CompanyThreadLocal.getCompanyId());

		return resourceLocalization;
	}

	/**
	 * Removes the resource localization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param resourceLocalizationId the primary key of the resource localization
	 * @return the resource localization that was removed
	 * @throws NoSuchResourceLocalizationException if a resource localization with the primary key could not be found
	 */
	@Override
	public ResourceLocalization remove(long resourceLocalizationId)
		throws NoSuchResourceLocalizationException {

		return remove((Serializable)resourceLocalizationId);
	}

	/**
	 * Removes the resource localization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the resource localization
	 * @return the resource localization that was removed
	 * @throws NoSuchResourceLocalizationException if a resource localization with the primary key could not be found
	 */
	@Override
	public ResourceLocalization remove(Serializable primaryKey)
		throws NoSuchResourceLocalizationException {

		Session session = null;

		try {
			session = openSession();

			ResourceLocalization resourceLocalization =
				(ResourceLocalization)session.get(
					ResourceLocalizationImpl.class, primaryKey);

			if (resourceLocalization == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchResourceLocalizationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(resourceLocalization);
		}
		catch (NoSuchResourceLocalizationException noSuchEntityException) {
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
	protected ResourceLocalization removeImpl(
		ResourceLocalization resourceLocalization) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(resourceLocalization)) {
				resourceLocalization = (ResourceLocalization)session.get(
					ResourceLocalizationImpl.class,
					resourceLocalization.getPrimaryKeyObj());
			}

			if (resourceLocalization != null) {
				session.delete(resourceLocalization);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (resourceLocalization != null) {
			clearCache(resourceLocalization);
		}

		return resourceLocalization;
	}

	@Override
	public ResourceLocalization updateImpl(
		ResourceLocalization resourceLocalization) {

		boolean isNew = resourceLocalization.isNew();

		if (!(resourceLocalization instanceof ResourceLocalizationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(resourceLocalization.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					resourceLocalization);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in resourceLocalization proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ResourceLocalization implementation " +
					resourceLocalization.getClass());
		}

		ResourceLocalizationModelImpl resourceLocalizationModelImpl =
			(ResourceLocalizationModelImpl)resourceLocalization;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(resourceLocalization);
			}
			else {
				resourceLocalization = (ResourceLocalization)session.merge(
					resourceLocalization);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ResourceLocalizationImpl.class, resourceLocalizationModelImpl,
			false, true);

		cacheUniqueFindersCache(resourceLocalizationModelImpl);

		if (isNew) {
			resourceLocalization.setNew(false);
		}

		resourceLocalization.resetOriginalValues();

		return resourceLocalization;
	}

	/**
	 * Returns the resource localization with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the resource localization
	 * @return the resource localization
	 * @throws NoSuchResourceLocalizationException if a resource localization with the primary key could not be found
	 */
	@Override
	public ResourceLocalization findByPrimaryKey(Serializable primaryKey)
		throws NoSuchResourceLocalizationException {

		ResourceLocalization resourceLocalization = fetchByPrimaryKey(
			primaryKey);

		if (resourceLocalization == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchResourceLocalizationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return resourceLocalization;
	}

	/**
	 * Returns the resource localization with the primary key or throws a <code>NoSuchResourceLocalizationException</code> if it could not be found.
	 *
	 * @param resourceLocalizationId the primary key of the resource localization
	 * @return the resource localization
	 * @throws NoSuchResourceLocalizationException if a resource localization with the primary key could not be found
	 */
	@Override
	public ResourceLocalization findByPrimaryKey(long resourceLocalizationId)
		throws NoSuchResourceLocalizationException {

		return findByPrimaryKey((Serializable)resourceLocalizationId);
	}

	/**
	 * Returns the resource localization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param resourceLocalizationId the primary key of the resource localization
	 * @return the resource localization, or <code>null</code> if a resource localization with the primary key could not be found
	 */
	@Override
	public ResourceLocalization fetchByPrimaryKey(long resourceLocalizationId) {
		return fetchByPrimaryKey((Serializable)resourceLocalizationId);
	}

	/**
	 * Returns all the resource localizations.
	 *
	 * @return the resource localizations
	 */
	@Override
	public List<ResourceLocalization> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the resource localizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resource localizations
	 * @param end the upper bound of the range of resource localizations (not inclusive)
	 * @return the range of resource localizations
	 */
	@Override
	public List<ResourceLocalization> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the resource localizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resource localizations
	 * @param end the upper bound of the range of resource localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of resource localizations
	 */
	@Override
	public List<ResourceLocalization> findAll(
		int start, int end,
		OrderByComparator<ResourceLocalization> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the resource localizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceLocalizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resource localizations
	 * @param end the upper bound of the range of resource localizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of resource localizations
	 */
	@Override
	public List<ResourceLocalization> findAll(
		int start, int end,
		OrderByComparator<ResourceLocalization> orderByComparator,
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

		List<ResourceLocalization> list = null;

		if (useFinderCache) {
			list = (List<ResourceLocalization>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_RESOURCELOCALIZATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_RESOURCELOCALIZATION;

				sql = sql.concat(ResourceLocalizationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ResourceLocalization>)QueryUtil.list(
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
	 * Removes all the resource localizations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ResourceLocalization resourceLocalization : findAll()) {
			remove(resourceLocalization);
		}
	}

	/**
	 * Returns the number of resource localizations.
	 *
	 * @return the number of resource localizations
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
					_SQL_COUNT_RESOURCELOCALIZATION);

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
		return "resourceLocalizationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_RESOURCELOCALIZATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ResourceLocalizationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the resource localization persistence.
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

		_finderPathWithPaginationFindByResourceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByResourceId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"resourceId"}, true);

		_finderPathWithoutPaginationFindByResourceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByResourceId",
			new String[] {Long.class.getName()}, new String[] {"resourceId"},
			true);

		_finderPathCountByResourceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByResourceId",
			new String[] {Long.class.getName()}, new String[] {"resourceId"},
			false);

		_finderPathFetchByResourceId_LanguageId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByResourceId_LanguageId",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"resourceId", "languageId"}, true);

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

		ResourceLocalizationUtil.setPersistence(this);
	}

	public void destroy() {
		ResourceLocalizationUtil.setPersistence(null);

		entityCache.removeCache(ResourceLocalizationImpl.class.getName());
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_RESOURCELOCALIZATION =
		"SELECT resourceLocalization FROM ResourceLocalization resourceLocalization";

	private static final String _SQL_SELECT_RESOURCELOCALIZATION_WHERE =
		"SELECT resourceLocalization FROM ResourceLocalization resourceLocalization WHERE ";

	private static final String _SQL_COUNT_RESOURCELOCALIZATION =
		"SELECT COUNT(resourceLocalization) FROM ResourceLocalization resourceLocalization";

	private static final String _SQL_COUNT_RESOURCELOCALIZATION_WHERE =
		"SELECT COUNT(resourceLocalization) FROM ResourceLocalization resourceLocalization WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"resourceLocalization.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ResourceLocalization exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ResourceLocalization exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ResourceLocalizationPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}