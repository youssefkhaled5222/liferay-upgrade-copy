/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence.impl;

import com.ejada.telemony.db.exception.NoSuchConfigurationEntityException;
import com.ejada.telemony.db.model.ConfigurationEntity;
import com.ejada.telemony.db.model.ConfigurationEntityTable;
import com.ejada.telemony.db.model.impl.ConfigurationEntityImpl;
import com.ejada.telemony.db.model.impl.ConfigurationEntityModelImpl;
import com.ejada.telemony.db.service.persistence.ConfigurationEntityPersistence;
import com.ejada.telemony.db.service.persistence.ConfigurationEntityUtil;

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
 * The persistence implementation for the configuration entity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ConfigurationEntityPersistenceImpl
	extends BasePersistenceImpl<ConfigurationEntity>
	implements ConfigurationEntityPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ConfigurationEntityUtil</code> to access the configuration entity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ConfigurationEntityImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByentityId;
	private FinderPath _finderPathWithoutPaginationFindByentityId;
	private FinderPath _finderPathCountByentityId;

	/**
	 * Returns all the configuration entities where entityId = &#63;.
	 *
	 * @param entityId the entity ID
	 * @return the matching configuration entities
	 */
	@Override
	public List<ConfigurationEntity> findByentityId(String entityId) {
		return findByentityId(
			entityId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the configuration entities where entityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConfigurationEntityModelImpl</code>.
	 * </p>
	 *
	 * @param entityId the entity ID
	 * @param start the lower bound of the range of configuration entities
	 * @param end the upper bound of the range of configuration entities (not inclusive)
	 * @return the range of matching configuration entities
	 */
	@Override
	public List<ConfigurationEntity> findByentityId(
		String entityId, int start, int end) {

		return findByentityId(entityId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the configuration entities where entityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConfigurationEntityModelImpl</code>.
	 * </p>
	 *
	 * @param entityId the entity ID
	 * @param start the lower bound of the range of configuration entities
	 * @param end the upper bound of the range of configuration entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching configuration entities
	 */
	@Override
	public List<ConfigurationEntity> findByentityId(
		String entityId, int start, int end,
		OrderByComparator<ConfigurationEntity> orderByComparator) {

		return findByentityId(entityId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the configuration entities where entityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConfigurationEntityModelImpl</code>.
	 * </p>
	 *
	 * @param entityId the entity ID
	 * @param start the lower bound of the range of configuration entities
	 * @param end the upper bound of the range of configuration entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching configuration entities
	 */
	@Override
	public List<ConfigurationEntity> findByentityId(
		String entityId, int start, int end,
		OrderByComparator<ConfigurationEntity> orderByComparator,
		boolean useFinderCache) {

		entityId = Objects.toString(entityId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByentityId;
				finderArgs = new Object[] {entityId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByentityId;
			finderArgs = new Object[] {entityId, start, end, orderByComparator};
		}

		List<ConfigurationEntity> list = null;

		if (useFinderCache) {
			list = (List<ConfigurationEntity>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ConfigurationEntity configurationEntity : list) {
					if (!entityId.equals(configurationEntity.getEntityId())) {
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

			sb.append(_SQL_SELECT_CONFIGURATIONENTITY_WHERE);

			boolean bindEntityId = false;

			if (entityId.isEmpty()) {
				sb.append(_FINDER_COLUMN_ENTITYID_ENTITYID_3);
			}
			else {
				bindEntityId = true;

				sb.append(_FINDER_COLUMN_ENTITYID_ENTITYID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ConfigurationEntityModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEntityId) {
					queryPos.add(entityId);
				}

				list = (List<ConfigurationEntity>)QueryUtil.list(
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
	 * Returns the first configuration entity in the ordered set where entityId = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching configuration entity
	 * @throws NoSuchConfigurationEntityException if a matching configuration entity could not be found
	 */
	@Override
	public ConfigurationEntity findByentityId_First(
			String entityId,
			OrderByComparator<ConfigurationEntity> orderByComparator)
		throws NoSuchConfigurationEntityException {

		ConfigurationEntity configurationEntity = fetchByentityId_First(
			entityId, orderByComparator);

		if (configurationEntity != null) {
			return configurationEntity;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("entityId=");
		sb.append(entityId);

		sb.append("}");

		throw new NoSuchConfigurationEntityException(sb.toString());
	}

	/**
	 * Returns the first configuration entity in the ordered set where entityId = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching configuration entity, or <code>null</code> if a matching configuration entity could not be found
	 */
	@Override
	public ConfigurationEntity fetchByentityId_First(
		String entityId,
		OrderByComparator<ConfigurationEntity> orderByComparator) {

		List<ConfigurationEntity> list = findByentityId(
			entityId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last configuration entity in the ordered set where entityId = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching configuration entity
	 * @throws NoSuchConfigurationEntityException if a matching configuration entity could not be found
	 */
	@Override
	public ConfigurationEntity findByentityId_Last(
			String entityId,
			OrderByComparator<ConfigurationEntity> orderByComparator)
		throws NoSuchConfigurationEntityException {

		ConfigurationEntity configurationEntity = fetchByentityId_Last(
			entityId, orderByComparator);

		if (configurationEntity != null) {
			return configurationEntity;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("entityId=");
		sb.append(entityId);

		sb.append("}");

		throw new NoSuchConfigurationEntityException(sb.toString());
	}

	/**
	 * Returns the last configuration entity in the ordered set where entityId = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching configuration entity, or <code>null</code> if a matching configuration entity could not be found
	 */
	@Override
	public ConfigurationEntity fetchByentityId_Last(
		String entityId,
		OrderByComparator<ConfigurationEntity> orderByComparator) {

		int count = countByentityId(entityId);

		if (count == 0) {
			return null;
		}

		List<ConfigurationEntity> list = findByentityId(
			entityId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the configuration entities before and after the current configuration entity in the ordered set where entityId = &#63;.
	 *
	 * @param id the primary key of the current configuration entity
	 * @param entityId the entity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next configuration entity
	 * @throws NoSuchConfigurationEntityException if a configuration entity with the primary key could not be found
	 */
	@Override
	public ConfigurationEntity[] findByentityId_PrevAndNext(
			long id, String entityId,
			OrderByComparator<ConfigurationEntity> orderByComparator)
		throws NoSuchConfigurationEntityException {

		entityId = Objects.toString(entityId, "");

		ConfigurationEntity configurationEntity = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ConfigurationEntity[] array = new ConfigurationEntityImpl[3];

			array[0] = getByentityId_PrevAndNext(
				session, configurationEntity, entityId, orderByComparator,
				true);

			array[1] = configurationEntity;

			array[2] = getByentityId_PrevAndNext(
				session, configurationEntity, entityId, orderByComparator,
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

	protected ConfigurationEntity getByentityId_PrevAndNext(
		Session session, ConfigurationEntity configurationEntity,
		String entityId,
		OrderByComparator<ConfigurationEntity> orderByComparator,
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

		sb.append(_SQL_SELECT_CONFIGURATIONENTITY_WHERE);

		boolean bindEntityId = false;

		if (entityId.isEmpty()) {
			sb.append(_FINDER_COLUMN_ENTITYID_ENTITYID_3);
		}
		else {
			bindEntityId = true;

			sb.append(_FINDER_COLUMN_ENTITYID_ENTITYID_2);
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
			sb.append(ConfigurationEntityModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindEntityId) {
			queryPos.add(entityId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						configurationEntity)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ConfigurationEntity> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the configuration entities where entityId = &#63; from the database.
	 *
	 * @param entityId the entity ID
	 */
	@Override
	public void removeByentityId(String entityId) {
		for (ConfigurationEntity configurationEntity :
				findByentityId(
					entityId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(configurationEntity);
		}
	}

	/**
	 * Returns the number of configuration entities where entityId = &#63;.
	 *
	 * @param entityId the entity ID
	 * @return the number of matching configuration entities
	 */
	@Override
	public int countByentityId(String entityId) {
		entityId = Objects.toString(entityId, "");

		FinderPath finderPath = _finderPathCountByentityId;

		Object[] finderArgs = new Object[] {entityId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CONFIGURATIONENTITY_WHERE);

			boolean bindEntityId = false;

			if (entityId.isEmpty()) {
				sb.append(_FINDER_COLUMN_ENTITYID_ENTITYID_3);
			}
			else {
				bindEntityId = true;

				sb.append(_FINDER_COLUMN_ENTITYID_ENTITYID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEntityId) {
					queryPos.add(entityId);
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

	private static final String _FINDER_COLUMN_ENTITYID_ENTITYID_2 =
		"configurationEntity.entityId = ?";

	private static final String _FINDER_COLUMN_ENTITYID_ENTITYID_3 =
		"(configurationEntity.entityId IS NULL OR configurationEntity.entityId = '')";

	private FinderPath _finderPathWithPaginationFindByentityIdAndType;
	private FinderPath _finderPathWithoutPaginationFindByentityIdAndType;
	private FinderPath _finderPathCountByentityIdAndType;

	/**
	 * Returns all the configuration entities where entityId = &#63; and entityType = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param entityType the entity type
	 * @return the matching configuration entities
	 */
	@Override
	public List<ConfigurationEntity> findByentityIdAndType(
		String entityId, String entityType) {

		return findByentityIdAndType(
			entityId, entityType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the configuration entities where entityId = &#63; and entityType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConfigurationEntityModelImpl</code>.
	 * </p>
	 *
	 * @param entityId the entity ID
	 * @param entityType the entity type
	 * @param start the lower bound of the range of configuration entities
	 * @param end the upper bound of the range of configuration entities (not inclusive)
	 * @return the range of matching configuration entities
	 */
	@Override
	public List<ConfigurationEntity> findByentityIdAndType(
		String entityId, String entityType, int start, int end) {

		return findByentityIdAndType(entityId, entityType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the configuration entities where entityId = &#63; and entityType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConfigurationEntityModelImpl</code>.
	 * </p>
	 *
	 * @param entityId the entity ID
	 * @param entityType the entity type
	 * @param start the lower bound of the range of configuration entities
	 * @param end the upper bound of the range of configuration entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching configuration entities
	 */
	@Override
	public List<ConfigurationEntity> findByentityIdAndType(
		String entityId, String entityType, int start, int end,
		OrderByComparator<ConfigurationEntity> orderByComparator) {

		return findByentityIdAndType(
			entityId, entityType, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the configuration entities where entityId = &#63; and entityType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConfigurationEntityModelImpl</code>.
	 * </p>
	 *
	 * @param entityId the entity ID
	 * @param entityType the entity type
	 * @param start the lower bound of the range of configuration entities
	 * @param end the upper bound of the range of configuration entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching configuration entities
	 */
	@Override
	public List<ConfigurationEntity> findByentityIdAndType(
		String entityId, String entityType, int start, int end,
		OrderByComparator<ConfigurationEntity> orderByComparator,
		boolean useFinderCache) {

		entityId = Objects.toString(entityId, "");
		entityType = Objects.toString(entityType, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByentityIdAndType;
				finderArgs = new Object[] {entityId, entityType};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByentityIdAndType;
			finderArgs = new Object[] {
				entityId, entityType, start, end, orderByComparator
			};
		}

		List<ConfigurationEntity> list = null;

		if (useFinderCache) {
			list = (List<ConfigurationEntity>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ConfigurationEntity configurationEntity : list) {
					if (!entityId.equals(configurationEntity.getEntityId()) ||
						!entityType.equals(
							configurationEntity.getEntityType())) {

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

			sb.append(_SQL_SELECT_CONFIGURATIONENTITY_WHERE);

			boolean bindEntityId = false;

			if (entityId.isEmpty()) {
				sb.append(_FINDER_COLUMN_ENTITYIDANDTYPE_ENTITYID_3);
			}
			else {
				bindEntityId = true;

				sb.append(_FINDER_COLUMN_ENTITYIDANDTYPE_ENTITYID_2);
			}

			boolean bindEntityType = false;

			if (entityType.isEmpty()) {
				sb.append(_FINDER_COLUMN_ENTITYIDANDTYPE_ENTITYTYPE_3);
			}
			else {
				bindEntityType = true;

				sb.append(_FINDER_COLUMN_ENTITYIDANDTYPE_ENTITYTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ConfigurationEntityModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEntityId) {
					queryPos.add(entityId);
				}

				if (bindEntityType) {
					queryPos.add(entityType);
				}

				list = (List<ConfigurationEntity>)QueryUtil.list(
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
	 * Returns the first configuration entity in the ordered set where entityId = &#63; and entityType = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param entityType the entity type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching configuration entity
	 * @throws NoSuchConfigurationEntityException if a matching configuration entity could not be found
	 */
	@Override
	public ConfigurationEntity findByentityIdAndType_First(
			String entityId, String entityType,
			OrderByComparator<ConfigurationEntity> orderByComparator)
		throws NoSuchConfigurationEntityException {

		ConfigurationEntity configurationEntity = fetchByentityIdAndType_First(
			entityId, entityType, orderByComparator);

		if (configurationEntity != null) {
			return configurationEntity;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("entityId=");
		sb.append(entityId);

		sb.append(", entityType=");
		sb.append(entityType);

		sb.append("}");

		throw new NoSuchConfigurationEntityException(sb.toString());
	}

	/**
	 * Returns the first configuration entity in the ordered set where entityId = &#63; and entityType = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param entityType the entity type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching configuration entity, or <code>null</code> if a matching configuration entity could not be found
	 */
	@Override
	public ConfigurationEntity fetchByentityIdAndType_First(
		String entityId, String entityType,
		OrderByComparator<ConfigurationEntity> orderByComparator) {

		List<ConfigurationEntity> list = findByentityIdAndType(
			entityId, entityType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last configuration entity in the ordered set where entityId = &#63; and entityType = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param entityType the entity type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching configuration entity
	 * @throws NoSuchConfigurationEntityException if a matching configuration entity could not be found
	 */
	@Override
	public ConfigurationEntity findByentityIdAndType_Last(
			String entityId, String entityType,
			OrderByComparator<ConfigurationEntity> orderByComparator)
		throws NoSuchConfigurationEntityException {

		ConfigurationEntity configurationEntity = fetchByentityIdAndType_Last(
			entityId, entityType, orderByComparator);

		if (configurationEntity != null) {
			return configurationEntity;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("entityId=");
		sb.append(entityId);

		sb.append(", entityType=");
		sb.append(entityType);

		sb.append("}");

		throw new NoSuchConfigurationEntityException(sb.toString());
	}

	/**
	 * Returns the last configuration entity in the ordered set where entityId = &#63; and entityType = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param entityType the entity type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching configuration entity, or <code>null</code> if a matching configuration entity could not be found
	 */
	@Override
	public ConfigurationEntity fetchByentityIdAndType_Last(
		String entityId, String entityType,
		OrderByComparator<ConfigurationEntity> orderByComparator) {

		int count = countByentityIdAndType(entityId, entityType);

		if (count == 0) {
			return null;
		}

		List<ConfigurationEntity> list = findByentityIdAndType(
			entityId, entityType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the configuration entities before and after the current configuration entity in the ordered set where entityId = &#63; and entityType = &#63;.
	 *
	 * @param id the primary key of the current configuration entity
	 * @param entityId the entity ID
	 * @param entityType the entity type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next configuration entity
	 * @throws NoSuchConfigurationEntityException if a configuration entity with the primary key could not be found
	 */
	@Override
	public ConfigurationEntity[] findByentityIdAndType_PrevAndNext(
			long id, String entityId, String entityType,
			OrderByComparator<ConfigurationEntity> orderByComparator)
		throws NoSuchConfigurationEntityException {

		entityId = Objects.toString(entityId, "");
		entityType = Objects.toString(entityType, "");

		ConfigurationEntity configurationEntity = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ConfigurationEntity[] array = new ConfigurationEntityImpl[3];

			array[0] = getByentityIdAndType_PrevAndNext(
				session, configurationEntity, entityId, entityType,
				orderByComparator, true);

			array[1] = configurationEntity;

			array[2] = getByentityIdAndType_PrevAndNext(
				session, configurationEntity, entityId, entityType,
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

	protected ConfigurationEntity getByentityIdAndType_PrevAndNext(
		Session session, ConfigurationEntity configurationEntity,
		String entityId, String entityType,
		OrderByComparator<ConfigurationEntity> orderByComparator,
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

		sb.append(_SQL_SELECT_CONFIGURATIONENTITY_WHERE);

		boolean bindEntityId = false;

		if (entityId.isEmpty()) {
			sb.append(_FINDER_COLUMN_ENTITYIDANDTYPE_ENTITYID_3);
		}
		else {
			bindEntityId = true;

			sb.append(_FINDER_COLUMN_ENTITYIDANDTYPE_ENTITYID_2);
		}

		boolean bindEntityType = false;

		if (entityType.isEmpty()) {
			sb.append(_FINDER_COLUMN_ENTITYIDANDTYPE_ENTITYTYPE_3);
		}
		else {
			bindEntityType = true;

			sb.append(_FINDER_COLUMN_ENTITYIDANDTYPE_ENTITYTYPE_2);
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
			sb.append(ConfigurationEntityModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindEntityId) {
			queryPos.add(entityId);
		}

		if (bindEntityType) {
			queryPos.add(entityType);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						configurationEntity)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ConfigurationEntity> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the configuration entities where entityId = &#63; and entityType = &#63; from the database.
	 *
	 * @param entityId the entity ID
	 * @param entityType the entity type
	 */
	@Override
	public void removeByentityIdAndType(String entityId, String entityType) {
		for (ConfigurationEntity configurationEntity :
				findByentityIdAndType(
					entityId, entityType, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(configurationEntity);
		}
	}

	/**
	 * Returns the number of configuration entities where entityId = &#63; and entityType = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param entityType the entity type
	 * @return the number of matching configuration entities
	 */
	@Override
	public int countByentityIdAndType(String entityId, String entityType) {
		entityId = Objects.toString(entityId, "");
		entityType = Objects.toString(entityType, "");

		FinderPath finderPath = _finderPathCountByentityIdAndType;

		Object[] finderArgs = new Object[] {entityId, entityType};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CONFIGURATIONENTITY_WHERE);

			boolean bindEntityId = false;

			if (entityId.isEmpty()) {
				sb.append(_FINDER_COLUMN_ENTITYIDANDTYPE_ENTITYID_3);
			}
			else {
				bindEntityId = true;

				sb.append(_FINDER_COLUMN_ENTITYIDANDTYPE_ENTITYID_2);
			}

			boolean bindEntityType = false;

			if (entityType.isEmpty()) {
				sb.append(_FINDER_COLUMN_ENTITYIDANDTYPE_ENTITYTYPE_3);
			}
			else {
				bindEntityType = true;

				sb.append(_FINDER_COLUMN_ENTITYIDANDTYPE_ENTITYTYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEntityId) {
					queryPos.add(entityId);
				}

				if (bindEntityType) {
					queryPos.add(entityType);
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

	private static final String _FINDER_COLUMN_ENTITYIDANDTYPE_ENTITYID_2 =
		"configurationEntity.entityId = ? AND ";

	private static final String _FINDER_COLUMN_ENTITYIDANDTYPE_ENTITYID_3 =
		"(configurationEntity.entityId IS NULL OR configurationEntity.entityId = '') AND ";

	private static final String _FINDER_COLUMN_ENTITYIDANDTYPE_ENTITYTYPE_2 =
		"configurationEntity.entityType = ?";

	private static final String _FINDER_COLUMN_ENTITYIDANDTYPE_ENTITYTYPE_3 =
		"(configurationEntity.entityType IS NULL OR configurationEntity.entityType = '')";

	private FinderPath _finderPathWithPaginationFindByentityTypeAndStatus;
	private FinderPath _finderPathWithoutPaginationFindByentityTypeAndStatus;
	private FinderPath _finderPathCountByentityTypeAndStatus;

	/**
	 * Returns all the configuration entities where entityType = &#63; and status = &#63;.
	 *
	 * @param entityType the entity type
	 * @param status the status
	 * @return the matching configuration entities
	 */
	@Override
	public List<ConfigurationEntity> findByentityTypeAndStatus(
		String entityType, int status) {

		return findByentityTypeAndStatus(
			entityType, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the configuration entities where entityType = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConfigurationEntityModelImpl</code>.
	 * </p>
	 *
	 * @param entityType the entity type
	 * @param status the status
	 * @param start the lower bound of the range of configuration entities
	 * @param end the upper bound of the range of configuration entities (not inclusive)
	 * @return the range of matching configuration entities
	 */
	@Override
	public List<ConfigurationEntity> findByentityTypeAndStatus(
		String entityType, int status, int start, int end) {

		return findByentityTypeAndStatus(entityType, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the configuration entities where entityType = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConfigurationEntityModelImpl</code>.
	 * </p>
	 *
	 * @param entityType the entity type
	 * @param status the status
	 * @param start the lower bound of the range of configuration entities
	 * @param end the upper bound of the range of configuration entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching configuration entities
	 */
	@Override
	public List<ConfigurationEntity> findByentityTypeAndStatus(
		String entityType, int status, int start, int end,
		OrderByComparator<ConfigurationEntity> orderByComparator) {

		return findByentityTypeAndStatus(
			entityType, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the configuration entities where entityType = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConfigurationEntityModelImpl</code>.
	 * </p>
	 *
	 * @param entityType the entity type
	 * @param status the status
	 * @param start the lower bound of the range of configuration entities
	 * @param end the upper bound of the range of configuration entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching configuration entities
	 */
	@Override
	public List<ConfigurationEntity> findByentityTypeAndStatus(
		String entityType, int status, int start, int end,
		OrderByComparator<ConfigurationEntity> orderByComparator,
		boolean useFinderCache) {

		entityType = Objects.toString(entityType, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByentityTypeAndStatus;
				finderArgs = new Object[] {entityType, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByentityTypeAndStatus;
			finderArgs = new Object[] {
				entityType, status, start, end, orderByComparator
			};
		}

		List<ConfigurationEntity> list = null;

		if (useFinderCache) {
			list = (List<ConfigurationEntity>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ConfigurationEntity configurationEntity : list) {
					if (!entityType.equals(
							configurationEntity.getEntityType()) ||
						(status != configurationEntity.getStatus())) {

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

			sb.append(_SQL_SELECT_CONFIGURATIONENTITY_WHERE);

			boolean bindEntityType = false;

			if (entityType.isEmpty()) {
				sb.append(_FINDER_COLUMN_ENTITYTYPEANDSTATUS_ENTITYTYPE_3);
			}
			else {
				bindEntityType = true;

				sb.append(_FINDER_COLUMN_ENTITYTYPEANDSTATUS_ENTITYTYPE_2);
			}

			sb.append(_FINDER_COLUMN_ENTITYTYPEANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ConfigurationEntityModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEntityType) {
					queryPos.add(entityType);
				}

				queryPos.add(status);

				list = (List<ConfigurationEntity>)QueryUtil.list(
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
	 * Returns the first configuration entity in the ordered set where entityType = &#63; and status = &#63;.
	 *
	 * @param entityType the entity type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching configuration entity
	 * @throws NoSuchConfigurationEntityException if a matching configuration entity could not be found
	 */
	@Override
	public ConfigurationEntity findByentityTypeAndStatus_First(
			String entityType, int status,
			OrderByComparator<ConfigurationEntity> orderByComparator)
		throws NoSuchConfigurationEntityException {

		ConfigurationEntity configurationEntity =
			fetchByentityTypeAndStatus_First(
				entityType, status, orderByComparator);

		if (configurationEntity != null) {
			return configurationEntity;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("entityType=");
		sb.append(entityType);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchConfigurationEntityException(sb.toString());
	}

	/**
	 * Returns the first configuration entity in the ordered set where entityType = &#63; and status = &#63;.
	 *
	 * @param entityType the entity type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching configuration entity, or <code>null</code> if a matching configuration entity could not be found
	 */
	@Override
	public ConfigurationEntity fetchByentityTypeAndStatus_First(
		String entityType, int status,
		OrderByComparator<ConfigurationEntity> orderByComparator) {

		List<ConfigurationEntity> list = findByentityTypeAndStatus(
			entityType, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last configuration entity in the ordered set where entityType = &#63; and status = &#63;.
	 *
	 * @param entityType the entity type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching configuration entity
	 * @throws NoSuchConfigurationEntityException if a matching configuration entity could not be found
	 */
	@Override
	public ConfigurationEntity findByentityTypeAndStatus_Last(
			String entityType, int status,
			OrderByComparator<ConfigurationEntity> orderByComparator)
		throws NoSuchConfigurationEntityException {

		ConfigurationEntity configurationEntity =
			fetchByentityTypeAndStatus_Last(
				entityType, status, orderByComparator);

		if (configurationEntity != null) {
			return configurationEntity;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("entityType=");
		sb.append(entityType);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchConfigurationEntityException(sb.toString());
	}

	/**
	 * Returns the last configuration entity in the ordered set where entityType = &#63; and status = &#63;.
	 *
	 * @param entityType the entity type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching configuration entity, or <code>null</code> if a matching configuration entity could not be found
	 */
	@Override
	public ConfigurationEntity fetchByentityTypeAndStatus_Last(
		String entityType, int status,
		OrderByComparator<ConfigurationEntity> orderByComparator) {

		int count = countByentityTypeAndStatus(entityType, status);

		if (count == 0) {
			return null;
		}

		List<ConfigurationEntity> list = findByentityTypeAndStatus(
			entityType, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the configuration entities before and after the current configuration entity in the ordered set where entityType = &#63; and status = &#63;.
	 *
	 * @param id the primary key of the current configuration entity
	 * @param entityType the entity type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next configuration entity
	 * @throws NoSuchConfigurationEntityException if a configuration entity with the primary key could not be found
	 */
	@Override
	public ConfigurationEntity[] findByentityTypeAndStatus_PrevAndNext(
			long id, String entityType, int status,
			OrderByComparator<ConfigurationEntity> orderByComparator)
		throws NoSuchConfigurationEntityException {

		entityType = Objects.toString(entityType, "");

		ConfigurationEntity configurationEntity = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ConfigurationEntity[] array = new ConfigurationEntityImpl[3];

			array[0] = getByentityTypeAndStatus_PrevAndNext(
				session, configurationEntity, entityType, status,
				orderByComparator, true);

			array[1] = configurationEntity;

			array[2] = getByentityTypeAndStatus_PrevAndNext(
				session, configurationEntity, entityType, status,
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

	protected ConfigurationEntity getByentityTypeAndStatus_PrevAndNext(
		Session session, ConfigurationEntity configurationEntity,
		String entityType, int status,
		OrderByComparator<ConfigurationEntity> orderByComparator,
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

		sb.append(_SQL_SELECT_CONFIGURATIONENTITY_WHERE);

		boolean bindEntityType = false;

		if (entityType.isEmpty()) {
			sb.append(_FINDER_COLUMN_ENTITYTYPEANDSTATUS_ENTITYTYPE_3);
		}
		else {
			bindEntityType = true;

			sb.append(_FINDER_COLUMN_ENTITYTYPEANDSTATUS_ENTITYTYPE_2);
		}

		sb.append(_FINDER_COLUMN_ENTITYTYPEANDSTATUS_STATUS_2);

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
			sb.append(ConfigurationEntityModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindEntityType) {
			queryPos.add(entityType);
		}

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						configurationEntity)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ConfigurationEntity> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the configuration entities where entityType = &#63; and status = &#63; from the database.
	 *
	 * @param entityType the entity type
	 * @param status the status
	 */
	@Override
	public void removeByentityTypeAndStatus(String entityType, int status) {
		for (ConfigurationEntity configurationEntity :
				findByentityTypeAndStatus(
					entityType, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(configurationEntity);
		}
	}

	/**
	 * Returns the number of configuration entities where entityType = &#63; and status = &#63;.
	 *
	 * @param entityType the entity type
	 * @param status the status
	 * @return the number of matching configuration entities
	 */
	@Override
	public int countByentityTypeAndStatus(String entityType, int status) {
		entityType = Objects.toString(entityType, "");

		FinderPath finderPath = _finderPathCountByentityTypeAndStatus;

		Object[] finderArgs = new Object[] {entityType, status};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CONFIGURATIONENTITY_WHERE);

			boolean bindEntityType = false;

			if (entityType.isEmpty()) {
				sb.append(_FINDER_COLUMN_ENTITYTYPEANDSTATUS_ENTITYTYPE_3);
			}
			else {
				bindEntityType = true;

				sb.append(_FINDER_COLUMN_ENTITYTYPEANDSTATUS_ENTITYTYPE_2);
			}

			sb.append(_FINDER_COLUMN_ENTITYTYPEANDSTATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEntityType) {
					queryPos.add(entityType);
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

	private static final String
		_FINDER_COLUMN_ENTITYTYPEANDSTATUS_ENTITYTYPE_2 =
			"configurationEntity.entityType = ? AND ";

	private static final String
		_FINDER_COLUMN_ENTITYTYPEANDSTATUS_ENTITYTYPE_3 =
			"(configurationEntity.entityType IS NULL OR configurationEntity.entityType = '') AND ";

	private static final String _FINDER_COLUMN_ENTITYTYPEANDSTATUS_STATUS_2 =
		"configurationEntity.status = ?";

	public ConfigurationEntityPersistenceImpl() {
		setModelClass(ConfigurationEntity.class);

		setModelImplClass(ConfigurationEntityImpl.class);
		setModelPKClass(long.class);

		setTable(ConfigurationEntityTable.INSTANCE);
	}

	/**
	 * Caches the configuration entity in the entity cache if it is enabled.
	 *
	 * @param configurationEntity the configuration entity
	 */
	@Override
	public void cacheResult(ConfigurationEntity configurationEntity) {
		dummyEntityCache.putResult(
			ConfigurationEntityImpl.class, configurationEntity.getPrimaryKey(),
			configurationEntity);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the configuration entities in the entity cache if it is enabled.
	 *
	 * @param configurationEntities the configuration entities
	 */
	@Override
	public void cacheResult(List<ConfigurationEntity> configurationEntities) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (configurationEntities.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ConfigurationEntity configurationEntity : configurationEntities) {
			if (dummyEntityCache.getResult(
					ConfigurationEntityImpl.class,
					configurationEntity.getPrimaryKey()) == null) {

				cacheResult(configurationEntity);
			}
		}
	}

	/**
	 * Clears the cache for all configuration entities.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(ConfigurationEntityImpl.class);

		dummyFinderCache.clearCache(ConfigurationEntityImpl.class);
	}

	/**
	 * Clears the cache for the configuration entity.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ConfigurationEntity configurationEntity) {
		dummyEntityCache.removeResult(
			ConfigurationEntityImpl.class, configurationEntity);
	}

	@Override
	public void clearCache(List<ConfigurationEntity> configurationEntities) {
		for (ConfigurationEntity configurationEntity : configurationEntities) {
			dummyEntityCache.removeResult(
				ConfigurationEntityImpl.class, configurationEntity);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(ConfigurationEntityImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(
				ConfigurationEntityImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new configuration entity with the primary key. Does not add the configuration entity to the database.
	 *
	 * @param id the primary key for the new configuration entity
	 * @return the new configuration entity
	 */
	@Override
	public ConfigurationEntity create(long id) {
		ConfigurationEntity configurationEntity = new ConfigurationEntityImpl();

		configurationEntity.setNew(true);
		configurationEntity.setPrimaryKey(id);

		configurationEntity.setCompanyId(CompanyThreadLocal.getCompanyId());

		return configurationEntity;
	}

	/**
	 * Removes the configuration entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the configuration entity
	 * @return the configuration entity that was removed
	 * @throws NoSuchConfigurationEntityException if a configuration entity with the primary key could not be found
	 */
	@Override
	public ConfigurationEntity remove(long id)
		throws NoSuchConfigurationEntityException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the configuration entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the configuration entity
	 * @return the configuration entity that was removed
	 * @throws NoSuchConfigurationEntityException if a configuration entity with the primary key could not be found
	 */
	@Override
	public ConfigurationEntity remove(Serializable primaryKey)
		throws NoSuchConfigurationEntityException {

		Session session = null;

		try {
			session = openSession();

			ConfigurationEntity configurationEntity =
				(ConfigurationEntity)session.get(
					ConfigurationEntityImpl.class, primaryKey);

			if (configurationEntity == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchConfigurationEntityException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(configurationEntity);
		}
		catch (NoSuchConfigurationEntityException noSuchEntityException) {
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
	protected ConfigurationEntity removeImpl(
		ConfigurationEntity configurationEntity) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(configurationEntity)) {
				configurationEntity = (ConfigurationEntity)session.get(
					ConfigurationEntityImpl.class,
					configurationEntity.getPrimaryKeyObj());
			}

			if (configurationEntity != null) {
				session.delete(configurationEntity);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (configurationEntity != null) {
			clearCache(configurationEntity);
		}

		return configurationEntity;
	}

	@Override
	public ConfigurationEntity updateImpl(
		ConfigurationEntity configurationEntity) {

		boolean isNew = configurationEntity.isNew();

		if (!(configurationEntity instanceof ConfigurationEntityModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(configurationEntity.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					configurationEntity);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in configurationEntity proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ConfigurationEntity implementation " +
					configurationEntity.getClass());
		}

		ConfigurationEntityModelImpl configurationEntityModelImpl =
			(ConfigurationEntityModelImpl)configurationEntity;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (configurationEntity.getCreateDate() == null)) {
			if (serviceContext == null) {
				configurationEntity.setCreateDate(date);
			}
			else {
				configurationEntity.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!configurationEntityModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				configurationEntity.setModifiedDate(date);
			}
			else {
				configurationEntity.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(configurationEntity);
			}
			else {
				configurationEntity = (ConfigurationEntity)session.merge(
					configurationEntity);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			ConfigurationEntityImpl.class, configurationEntityModelImpl, false,
			true);

		if (isNew) {
			configurationEntity.setNew(false);
		}

		configurationEntity.resetOriginalValues();

		return configurationEntity;
	}

	/**
	 * Returns the configuration entity with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the configuration entity
	 * @return the configuration entity
	 * @throws NoSuchConfigurationEntityException if a configuration entity with the primary key could not be found
	 */
	@Override
	public ConfigurationEntity findByPrimaryKey(Serializable primaryKey)
		throws NoSuchConfigurationEntityException {

		ConfigurationEntity configurationEntity = fetchByPrimaryKey(primaryKey);

		if (configurationEntity == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchConfigurationEntityException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return configurationEntity;
	}

	/**
	 * Returns the configuration entity with the primary key or throws a <code>NoSuchConfigurationEntityException</code> if it could not be found.
	 *
	 * @param id the primary key of the configuration entity
	 * @return the configuration entity
	 * @throws NoSuchConfigurationEntityException if a configuration entity with the primary key could not be found
	 */
	@Override
	public ConfigurationEntity findByPrimaryKey(long id)
		throws NoSuchConfigurationEntityException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the configuration entity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the configuration entity
	 * @return the configuration entity, or <code>null</code> if a configuration entity with the primary key could not be found
	 */
	@Override
	public ConfigurationEntity fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the configuration entities.
	 *
	 * @return the configuration entities
	 */
	@Override
	public List<ConfigurationEntity> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the configuration entities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConfigurationEntityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of configuration entities
	 * @param end the upper bound of the range of configuration entities (not inclusive)
	 * @return the range of configuration entities
	 */
	@Override
	public List<ConfigurationEntity> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the configuration entities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConfigurationEntityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of configuration entities
	 * @param end the upper bound of the range of configuration entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of configuration entities
	 */
	@Override
	public List<ConfigurationEntity> findAll(
		int start, int end,
		OrderByComparator<ConfigurationEntity> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the configuration entities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConfigurationEntityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of configuration entities
	 * @param end the upper bound of the range of configuration entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of configuration entities
	 */
	@Override
	public List<ConfigurationEntity> findAll(
		int start, int end,
		OrderByComparator<ConfigurationEntity> orderByComparator,
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

		List<ConfigurationEntity> list = null;

		if (useFinderCache) {
			list = (List<ConfigurationEntity>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CONFIGURATIONENTITY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CONFIGURATIONENTITY;

				sql = sql.concat(ConfigurationEntityModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ConfigurationEntity>)QueryUtil.list(
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
	 * Removes all the configuration entities from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ConfigurationEntity configurationEntity : findAll()) {
			remove(configurationEntity);
		}
	}

	/**
	 * Returns the number of configuration entities.
	 *
	 * @return the number of configuration entities
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_CONFIGURATIONENTITY);

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
		return _SQL_SELECT_CONFIGURATIONENTITY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ConfigurationEntityModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the configuration entity persistence.
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

		_finderPathWithPaginationFindByentityId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByentityId",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"entityId"}, true);

		_finderPathWithoutPaginationFindByentityId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByentityId",
			new String[] {String.class.getName()}, new String[] {"entityId"},
			true);

		_finderPathCountByentityId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByentityId",
			new String[] {String.class.getName()}, new String[] {"entityId"},
			false);

		_finderPathWithPaginationFindByentityIdAndType = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByentityIdAndType",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"entityId", "entityType"}, true);

		_finderPathWithoutPaginationFindByentityIdAndType = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByentityIdAndType",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"entityId", "entityType"}, true);

		_finderPathCountByentityIdAndType = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByentityIdAndType",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"entityId", "entityType"}, false);

		_finderPathWithPaginationFindByentityTypeAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByentityTypeAndStatus",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"entityType", "status"}, true);

		_finderPathWithoutPaginationFindByentityTypeAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByentityTypeAndStatus",
			new String[] {String.class.getName(), Integer.class.getName()},
			new String[] {"entityType", "status"}, true);

		_finderPathCountByentityTypeAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByentityTypeAndStatus",
			new String[] {String.class.getName(), Integer.class.getName()},
			new String[] {"entityType", "status"}, false);

		ConfigurationEntityUtil.setPersistence(this);
	}

	public void destroy() {
		ConfigurationEntityUtil.setPersistence(null);

		dummyEntityCache.removeCache(ConfigurationEntityImpl.class.getName());
	}

	private static final String _SQL_SELECT_CONFIGURATIONENTITY =
		"SELECT configurationEntity FROM ConfigurationEntity configurationEntity";

	private static final String _SQL_SELECT_CONFIGURATIONENTITY_WHERE =
		"SELECT configurationEntity FROM ConfigurationEntity configurationEntity WHERE ";

	private static final String _SQL_COUNT_CONFIGURATIONENTITY =
		"SELECT COUNT(configurationEntity) FROM ConfigurationEntity configurationEntity";

	private static final String _SQL_COUNT_CONFIGURATIONENTITY_WHERE =
		"SELECT COUNT(configurationEntity) FROM ConfigurationEntity configurationEntity WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "configurationEntity.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ConfigurationEntity exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ConfigurationEntity exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ConfigurationEntityPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}