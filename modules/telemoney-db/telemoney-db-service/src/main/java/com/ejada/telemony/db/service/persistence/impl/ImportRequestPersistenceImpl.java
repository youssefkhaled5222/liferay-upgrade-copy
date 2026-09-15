/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence.impl;

import com.ejada.telemony.db.exception.NoSuchImportRequestException;
import com.ejada.telemony.db.model.ImportRequest;
import com.ejada.telemony.db.model.ImportRequestTable;
import com.ejada.telemony.db.model.impl.ImportRequestImpl;
import com.ejada.telemony.db.model.impl.ImportRequestModelImpl;
import com.ejada.telemony.db.service.persistence.ImportRequestPersistence;
import com.ejada.telemony.db.service.persistence.ImportRequestUtil;

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
 * The persistence implementation for the import request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ImportRequestPersistenceImpl
	extends BasePersistenceImpl<ImportRequest>
	implements ImportRequestPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ImportRequestUtil</code> to access the import request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ImportRequestImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBytypeAndStatus;
	private FinderPath _finderPathWithoutPaginationFindBytypeAndStatus;
	private FinderPath _finderPathCountBytypeAndStatus;

	/**
	 * Returns all the import requests where type = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param status the status
	 * @return the matching import requests
	 */
	@Override
	public List<ImportRequest> findBytypeAndStatus(String type, int status) {
		return findBytypeAndStatus(
			type, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the import requests where type = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportRequestModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param status the status
	 * @param start the lower bound of the range of import requests
	 * @param end the upper bound of the range of import requests (not inclusive)
	 * @return the range of matching import requests
	 */
	@Override
	public List<ImportRequest> findBytypeAndStatus(
		String type, int status, int start, int end) {

		return findBytypeAndStatus(type, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the import requests where type = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportRequestModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param status the status
	 * @param start the lower bound of the range of import requests
	 * @param end the upper bound of the range of import requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching import requests
	 */
	@Override
	public List<ImportRequest> findBytypeAndStatus(
		String type, int status, int start, int end,
		OrderByComparator<ImportRequest> orderByComparator) {

		return findBytypeAndStatus(
			type, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the import requests where type = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportRequestModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param status the status
	 * @param start the lower bound of the range of import requests
	 * @param end the upper bound of the range of import requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching import requests
	 */
	@Override
	public List<ImportRequest> findBytypeAndStatus(
		String type, int status, int start, int end,
		OrderByComparator<ImportRequest> orderByComparator,
		boolean useFinderCache) {

		type = Objects.toString(type, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBytypeAndStatus;
				finderArgs = new Object[] {type, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBytypeAndStatus;
			finderArgs = new Object[] {
				type, status, start, end, orderByComparator
			};
		}

		List<ImportRequest> list = null;

		if (useFinderCache) {
			list = (List<ImportRequest>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ImportRequest importRequest : list) {
					if (!type.equals(importRequest.getType()) ||
						(status != importRequest.getStatus())) {

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

			sb.append(_SQL_SELECT_IMPORTREQUEST_WHERE);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_TYPEANDSTATUS_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_TYPEANDSTATUS_TYPE_2);
			}

			sb.append(_FINDER_COLUMN_TYPEANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ImportRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindType) {
					queryPos.add(type);
				}

				queryPos.add(status);

				list = (List<ImportRequest>)QueryUtil.list(
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
	 * Returns the first import request in the ordered set where type = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import request
	 * @throws NoSuchImportRequestException if a matching import request could not be found
	 */
	@Override
	public ImportRequest findBytypeAndStatus_First(
			String type, int status,
			OrderByComparator<ImportRequest> orderByComparator)
		throws NoSuchImportRequestException {

		ImportRequest importRequest = fetchBytypeAndStatus_First(
			type, status, orderByComparator);

		if (importRequest != null) {
			return importRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("type=");
		sb.append(type);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchImportRequestException(sb.toString());
	}

	/**
	 * Returns the first import request in the ordered set where type = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import request, or <code>null</code> if a matching import request could not be found
	 */
	@Override
	public ImportRequest fetchBytypeAndStatus_First(
		String type, int status,
		OrderByComparator<ImportRequest> orderByComparator) {

		List<ImportRequest> list = findBytypeAndStatus(
			type, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last import request in the ordered set where type = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import request
	 * @throws NoSuchImportRequestException if a matching import request could not be found
	 */
	@Override
	public ImportRequest findBytypeAndStatus_Last(
			String type, int status,
			OrderByComparator<ImportRequest> orderByComparator)
		throws NoSuchImportRequestException {

		ImportRequest importRequest = fetchBytypeAndStatus_Last(
			type, status, orderByComparator);

		if (importRequest != null) {
			return importRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("type=");
		sb.append(type);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchImportRequestException(sb.toString());
	}

	/**
	 * Returns the last import request in the ordered set where type = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import request, or <code>null</code> if a matching import request could not be found
	 */
	@Override
	public ImportRequest fetchBytypeAndStatus_Last(
		String type, int status,
		OrderByComparator<ImportRequest> orderByComparator) {

		int count = countBytypeAndStatus(type, status);

		if (count == 0) {
			return null;
		}

		List<ImportRequest> list = findBytypeAndStatus(
			type, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the import requests before and after the current import request in the ordered set where type = &#63; and status = &#63;.
	 *
	 * @param id the primary key of the current import request
	 * @param type the type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next import request
	 * @throws NoSuchImportRequestException if a import request with the primary key could not be found
	 */
	@Override
	public ImportRequest[] findBytypeAndStatus_PrevAndNext(
			long id, String type, int status,
			OrderByComparator<ImportRequest> orderByComparator)
		throws NoSuchImportRequestException {

		type = Objects.toString(type, "");

		ImportRequest importRequest = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ImportRequest[] array = new ImportRequestImpl[3];

			array[0] = getBytypeAndStatus_PrevAndNext(
				session, importRequest, type, status, orderByComparator, true);

			array[1] = importRequest;

			array[2] = getBytypeAndStatus_PrevAndNext(
				session, importRequest, type, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ImportRequest getBytypeAndStatus_PrevAndNext(
		Session session, ImportRequest importRequest, String type, int status,
		OrderByComparator<ImportRequest> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_IMPORTREQUEST_WHERE);

		boolean bindType = false;

		if (type.isEmpty()) {
			sb.append(_FINDER_COLUMN_TYPEANDSTATUS_TYPE_3);
		}
		else {
			bindType = true;

			sb.append(_FINDER_COLUMN_TYPEANDSTATUS_TYPE_2);
		}

		sb.append(_FINDER_COLUMN_TYPEANDSTATUS_STATUS_2);

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
			sb.append(ImportRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindType) {
			queryPos.add(type);
		}

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						importRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ImportRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the import requests where type = &#63; and status = &#63; from the database.
	 *
	 * @param type the type
	 * @param status the status
	 */
	@Override
	public void removeBytypeAndStatus(String type, int status) {
		for (ImportRequest importRequest :
				findBytypeAndStatus(
					type, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(importRequest);
		}
	}

	/**
	 * Returns the number of import requests where type = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param status the status
	 * @return the number of matching import requests
	 */
	@Override
	public int countBytypeAndStatus(String type, int status) {
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountBytypeAndStatus;

		Object[] finderArgs = new Object[] {type, status};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_IMPORTREQUEST_WHERE);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_TYPEANDSTATUS_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_TYPEANDSTATUS_TYPE_2);
			}

			sb.append(_FINDER_COLUMN_TYPEANDSTATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindType) {
					queryPos.add(type);
				}

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

	private static final String _FINDER_COLUMN_TYPEANDSTATUS_TYPE_2 =
		"importRequest.type = ? AND ";

	private static final String _FINDER_COLUMN_TYPEANDSTATUS_TYPE_3 =
		"(importRequest.type IS NULL OR importRequest.type = '') AND ";

	private static final String _FINDER_COLUMN_TYPEANDSTATUS_STATUS_2 =
		"importRequest.status = ?";

	public ImportRequestPersistenceImpl() {
		setModelClass(ImportRequest.class);

		setModelImplClass(ImportRequestImpl.class);
		setModelPKClass(long.class);

		setTable(ImportRequestTable.INSTANCE);
	}

	/**
	 * Caches the import request in the entity cache if it is enabled.
	 *
	 * @param importRequest the import request
	 */
	@Override
	public void cacheResult(ImportRequest importRequest) {
		dummyEntityCache.putResult(
			ImportRequestImpl.class, importRequest.getPrimaryKey(),
			importRequest);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the import requests in the entity cache if it is enabled.
	 *
	 * @param importRequests the import requests
	 */
	@Override
	public void cacheResult(List<ImportRequest> importRequests) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (importRequests.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ImportRequest importRequest : importRequests) {
			if (dummyEntityCache.getResult(
					ImportRequestImpl.class, importRequest.getPrimaryKey()) ==
						null) {

				cacheResult(importRequest);
			}
		}
	}

	/**
	 * Clears the cache for all import requests.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(ImportRequestImpl.class);

		dummyFinderCache.clearCache(ImportRequestImpl.class);
	}

	/**
	 * Clears the cache for the import request.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ImportRequest importRequest) {
		dummyEntityCache.removeResult(ImportRequestImpl.class, importRequest);
	}

	@Override
	public void clearCache(List<ImportRequest> importRequests) {
		for (ImportRequest importRequest : importRequests) {
			dummyEntityCache.removeResult(
				ImportRequestImpl.class, importRequest);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(ImportRequestImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(ImportRequestImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new import request with the primary key. Does not add the import request to the database.
	 *
	 * @param id the primary key for the new import request
	 * @return the new import request
	 */
	@Override
	public ImportRequest create(long id) {
		ImportRequest importRequest = new ImportRequestImpl();

		importRequest.setNew(true);
		importRequest.setPrimaryKey(id);

		importRequest.setCompanyId(CompanyThreadLocal.getCompanyId());

		return importRequest;
	}

	/**
	 * Removes the import request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the import request
	 * @return the import request that was removed
	 * @throws NoSuchImportRequestException if a import request with the primary key could not be found
	 */
	@Override
	public ImportRequest remove(long id) throws NoSuchImportRequestException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the import request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the import request
	 * @return the import request that was removed
	 * @throws NoSuchImportRequestException if a import request with the primary key could not be found
	 */
	@Override
	public ImportRequest remove(Serializable primaryKey)
		throws NoSuchImportRequestException {

		Session session = null;

		try {
			session = openSession();

			ImportRequest importRequest = (ImportRequest)session.get(
				ImportRequestImpl.class, primaryKey);

			if (importRequest == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchImportRequestException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(importRequest);
		}
		catch (NoSuchImportRequestException noSuchEntityException) {
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
	protected ImportRequest removeImpl(ImportRequest importRequest) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(importRequest)) {
				importRequest = (ImportRequest)session.get(
					ImportRequestImpl.class, importRequest.getPrimaryKeyObj());
			}

			if (importRequest != null) {
				session.delete(importRequest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (importRequest != null) {
			clearCache(importRequest);
		}

		return importRequest;
	}

	@Override
	public ImportRequest updateImpl(ImportRequest importRequest) {
		boolean isNew = importRequest.isNew();

		if (!(importRequest instanceof ImportRequestModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(importRequest.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					importRequest);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in importRequest proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ImportRequest implementation " +
					importRequest.getClass());
		}

		ImportRequestModelImpl importRequestModelImpl =
			(ImportRequestModelImpl)importRequest;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (importRequest.getCreateDate() == null)) {
			if (serviceContext == null) {
				importRequest.setCreateDate(date);
			}
			else {
				importRequest.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!importRequestModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				importRequest.setModifiedDate(date);
			}
			else {
				importRequest.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(importRequest);
			}
			else {
				importRequest = (ImportRequest)session.merge(importRequest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			ImportRequestImpl.class, importRequestModelImpl, false, true);

		if (isNew) {
			importRequest.setNew(false);
		}

		importRequest.resetOriginalValues();

		return importRequest;
	}

	/**
	 * Returns the import request with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the import request
	 * @return the import request
	 * @throws NoSuchImportRequestException if a import request with the primary key could not be found
	 */
	@Override
	public ImportRequest findByPrimaryKey(Serializable primaryKey)
		throws NoSuchImportRequestException {

		ImportRequest importRequest = fetchByPrimaryKey(primaryKey);

		if (importRequest == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchImportRequestException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return importRequest;
	}

	/**
	 * Returns the import request with the primary key or throws a <code>NoSuchImportRequestException</code> if it could not be found.
	 *
	 * @param id the primary key of the import request
	 * @return the import request
	 * @throws NoSuchImportRequestException if a import request with the primary key could not be found
	 */
	@Override
	public ImportRequest findByPrimaryKey(long id)
		throws NoSuchImportRequestException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the import request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the import request
	 * @return the import request, or <code>null</code> if a import request with the primary key could not be found
	 */
	@Override
	public ImportRequest fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the import requests.
	 *
	 * @return the import requests
	 */
	@Override
	public List<ImportRequest> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the import requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of import requests
	 * @param end the upper bound of the range of import requests (not inclusive)
	 * @return the range of import requests
	 */
	@Override
	public List<ImportRequest> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the import requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of import requests
	 * @param end the upper bound of the range of import requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of import requests
	 */
	@Override
	public List<ImportRequest> findAll(
		int start, int end,
		OrderByComparator<ImportRequest> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the import requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of import requests
	 * @param end the upper bound of the range of import requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of import requests
	 */
	@Override
	public List<ImportRequest> findAll(
		int start, int end, OrderByComparator<ImportRequest> orderByComparator,
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

		List<ImportRequest> list = null;

		if (useFinderCache) {
			list = (List<ImportRequest>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_IMPORTREQUEST);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_IMPORTREQUEST;

				sql = sql.concat(ImportRequestModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ImportRequest>)QueryUtil.list(
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
	 * Removes all the import requests from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ImportRequest importRequest : findAll()) {
			remove(importRequest);
		}
	}

	/**
	 * Returns the number of import requests.
	 *
	 * @return the number of import requests
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_IMPORTREQUEST);

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
		return "id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_IMPORTREQUEST;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ImportRequestModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the import request persistence.
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

		_finderPathWithPaginationFindBytypeAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBytypeAndStatus",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"type", "status"}, true);

		_finderPathWithoutPaginationFindBytypeAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBytypeAndStatus",
			new String[] {String.class.getName(), Integer.class.getName()},
			new String[] {"type", "status"}, true);

		_finderPathCountBytypeAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytypeAndStatus",
			new String[] {String.class.getName(), Integer.class.getName()},
			new String[] {"type", "status"}, false);

		ImportRequestUtil.setPersistence(this);
	}

	public void destroy() {
		ImportRequestUtil.setPersistence(null);

		dummyEntityCache.removeCache(ImportRequestImpl.class.getName());
	}

	private static final String _SQL_SELECT_IMPORTREQUEST =
		"SELECT importRequest FROM ImportRequest importRequest";

	private static final String _SQL_SELECT_IMPORTREQUEST_WHERE =
		"SELECT importRequest FROM ImportRequest importRequest WHERE ";

	private static final String _SQL_COUNT_IMPORTREQUEST =
		"SELECT COUNT(importRequest) FROM ImportRequest importRequest";

	private static final String _SQL_COUNT_IMPORTREQUEST_WHERE =
		"SELECT COUNT(importRequest) FROM ImportRequest importRequest WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "importRequest.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ImportRequest exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ImportRequest exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ImportRequestPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}