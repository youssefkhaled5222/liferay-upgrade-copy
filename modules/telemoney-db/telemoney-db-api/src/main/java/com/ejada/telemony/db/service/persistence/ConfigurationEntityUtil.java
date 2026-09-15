/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.model.ConfigurationEntity;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the configuration entity service. This utility wraps <code>com.ejada.telemony.db.service.persistence.impl.ConfigurationEntityPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConfigurationEntityPersistence
 * @generated
 */
public class ConfigurationEntityUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(ConfigurationEntity configurationEntity) {
		getPersistence().clearCache(configurationEntity);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, ConfigurationEntity> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ConfigurationEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ConfigurationEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ConfigurationEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ConfigurationEntity> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ConfigurationEntity update(
		ConfigurationEntity configurationEntity) {

		return getPersistence().update(configurationEntity);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ConfigurationEntity update(
		ConfigurationEntity configurationEntity,
		ServiceContext serviceContext) {

		return getPersistence().update(configurationEntity, serviceContext);
	}

	/**
	 * Returns all the configuration entities where entityId = &#63;.
	 *
	 * @param entityId the entity ID
	 * @return the matching configuration entities
	 */
	public static List<ConfigurationEntity> findByentityId(String entityId) {
		return getPersistence().findByentityId(entityId);
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
	public static List<ConfigurationEntity> findByentityId(
		String entityId, int start, int end) {

		return getPersistence().findByentityId(entityId, start, end);
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
	public static List<ConfigurationEntity> findByentityId(
		String entityId, int start, int end,
		OrderByComparator<ConfigurationEntity> orderByComparator) {

		return getPersistence().findByentityId(
			entityId, start, end, orderByComparator);
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
	public static List<ConfigurationEntity> findByentityId(
		String entityId, int start, int end,
		OrderByComparator<ConfigurationEntity> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByentityId(
			entityId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first configuration entity in the ordered set where entityId = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching configuration entity
	 * @throws NoSuchConfigurationEntityException if a matching configuration entity could not be found
	 */
	public static ConfigurationEntity findByentityId_First(
			String entityId,
			OrderByComparator<ConfigurationEntity> orderByComparator)
		throws com.ejada.telemony.db.exception.
			NoSuchConfigurationEntityException {

		return getPersistence().findByentityId_First(
			entityId, orderByComparator);
	}

	/**
	 * Returns the first configuration entity in the ordered set where entityId = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching configuration entity, or <code>null</code> if a matching configuration entity could not be found
	 */
	public static ConfigurationEntity fetchByentityId_First(
		String entityId,
		OrderByComparator<ConfigurationEntity> orderByComparator) {

		return getPersistence().fetchByentityId_First(
			entityId, orderByComparator);
	}

	/**
	 * Returns the last configuration entity in the ordered set where entityId = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching configuration entity
	 * @throws NoSuchConfigurationEntityException if a matching configuration entity could not be found
	 */
	public static ConfigurationEntity findByentityId_Last(
			String entityId,
			OrderByComparator<ConfigurationEntity> orderByComparator)
		throws com.ejada.telemony.db.exception.
			NoSuchConfigurationEntityException {

		return getPersistence().findByentityId_Last(
			entityId, orderByComparator);
	}

	/**
	 * Returns the last configuration entity in the ordered set where entityId = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching configuration entity, or <code>null</code> if a matching configuration entity could not be found
	 */
	public static ConfigurationEntity fetchByentityId_Last(
		String entityId,
		OrderByComparator<ConfigurationEntity> orderByComparator) {

		return getPersistence().fetchByentityId_Last(
			entityId, orderByComparator);
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
	public static ConfigurationEntity[] findByentityId_PrevAndNext(
			long id, String entityId,
			OrderByComparator<ConfigurationEntity> orderByComparator)
		throws com.ejada.telemony.db.exception.
			NoSuchConfigurationEntityException {

		return getPersistence().findByentityId_PrevAndNext(
			id, entityId, orderByComparator);
	}

	/**
	 * Removes all the configuration entities where entityId = &#63; from the database.
	 *
	 * @param entityId the entity ID
	 */
	public static void removeByentityId(String entityId) {
		getPersistence().removeByentityId(entityId);
	}

	/**
	 * Returns the number of configuration entities where entityId = &#63;.
	 *
	 * @param entityId the entity ID
	 * @return the number of matching configuration entities
	 */
	public static int countByentityId(String entityId) {
		return getPersistence().countByentityId(entityId);
	}

	/**
	 * Returns all the configuration entities where entityId = &#63; and entityType = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param entityType the entity type
	 * @return the matching configuration entities
	 */
	public static List<ConfigurationEntity> findByentityIdAndType(
		String entityId, String entityType) {

		return getPersistence().findByentityIdAndType(entityId, entityType);
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
	public static List<ConfigurationEntity> findByentityIdAndType(
		String entityId, String entityType, int start, int end) {

		return getPersistence().findByentityIdAndType(
			entityId, entityType, start, end);
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
	public static List<ConfigurationEntity> findByentityIdAndType(
		String entityId, String entityType, int start, int end,
		OrderByComparator<ConfigurationEntity> orderByComparator) {

		return getPersistence().findByentityIdAndType(
			entityId, entityType, start, end, orderByComparator);
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
	public static List<ConfigurationEntity> findByentityIdAndType(
		String entityId, String entityType, int start, int end,
		OrderByComparator<ConfigurationEntity> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByentityIdAndType(
			entityId, entityType, start, end, orderByComparator,
			useFinderCache);
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
	public static ConfigurationEntity findByentityIdAndType_First(
			String entityId, String entityType,
			OrderByComparator<ConfigurationEntity> orderByComparator)
		throws com.ejada.telemony.db.exception.
			NoSuchConfigurationEntityException {

		return getPersistence().findByentityIdAndType_First(
			entityId, entityType, orderByComparator);
	}

	/**
	 * Returns the first configuration entity in the ordered set where entityId = &#63; and entityType = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param entityType the entity type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching configuration entity, or <code>null</code> if a matching configuration entity could not be found
	 */
	public static ConfigurationEntity fetchByentityIdAndType_First(
		String entityId, String entityType,
		OrderByComparator<ConfigurationEntity> orderByComparator) {

		return getPersistence().fetchByentityIdAndType_First(
			entityId, entityType, orderByComparator);
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
	public static ConfigurationEntity findByentityIdAndType_Last(
			String entityId, String entityType,
			OrderByComparator<ConfigurationEntity> orderByComparator)
		throws com.ejada.telemony.db.exception.
			NoSuchConfigurationEntityException {

		return getPersistence().findByentityIdAndType_Last(
			entityId, entityType, orderByComparator);
	}

	/**
	 * Returns the last configuration entity in the ordered set where entityId = &#63; and entityType = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param entityType the entity type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching configuration entity, or <code>null</code> if a matching configuration entity could not be found
	 */
	public static ConfigurationEntity fetchByentityIdAndType_Last(
		String entityId, String entityType,
		OrderByComparator<ConfigurationEntity> orderByComparator) {

		return getPersistence().fetchByentityIdAndType_Last(
			entityId, entityType, orderByComparator);
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
	public static ConfigurationEntity[] findByentityIdAndType_PrevAndNext(
			long id, String entityId, String entityType,
			OrderByComparator<ConfigurationEntity> orderByComparator)
		throws com.ejada.telemony.db.exception.
			NoSuchConfigurationEntityException {

		return getPersistence().findByentityIdAndType_PrevAndNext(
			id, entityId, entityType, orderByComparator);
	}

	/**
	 * Removes all the configuration entities where entityId = &#63; and entityType = &#63; from the database.
	 *
	 * @param entityId the entity ID
	 * @param entityType the entity type
	 */
	public static void removeByentityIdAndType(
		String entityId, String entityType) {

		getPersistence().removeByentityIdAndType(entityId, entityType);
	}

	/**
	 * Returns the number of configuration entities where entityId = &#63; and entityType = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param entityType the entity type
	 * @return the number of matching configuration entities
	 */
	public static int countByentityIdAndType(
		String entityId, String entityType) {

		return getPersistence().countByentityIdAndType(entityId, entityType);
	}

	/**
	 * Returns all the configuration entities where entityType = &#63; and status = &#63;.
	 *
	 * @param entityType the entity type
	 * @param status the status
	 * @return the matching configuration entities
	 */
	public static List<ConfigurationEntity> findByentityTypeAndStatus(
		String entityType, int status) {

		return getPersistence().findByentityTypeAndStatus(entityType, status);
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
	public static List<ConfigurationEntity> findByentityTypeAndStatus(
		String entityType, int status, int start, int end) {

		return getPersistence().findByentityTypeAndStatus(
			entityType, status, start, end);
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
	public static List<ConfigurationEntity> findByentityTypeAndStatus(
		String entityType, int status, int start, int end,
		OrderByComparator<ConfigurationEntity> orderByComparator) {

		return getPersistence().findByentityTypeAndStatus(
			entityType, status, start, end, orderByComparator);
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
	public static List<ConfigurationEntity> findByentityTypeAndStatus(
		String entityType, int status, int start, int end,
		OrderByComparator<ConfigurationEntity> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByentityTypeAndStatus(
			entityType, status, start, end, orderByComparator, useFinderCache);
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
	public static ConfigurationEntity findByentityTypeAndStatus_First(
			String entityType, int status,
			OrderByComparator<ConfigurationEntity> orderByComparator)
		throws com.ejada.telemony.db.exception.
			NoSuchConfigurationEntityException {

		return getPersistence().findByentityTypeAndStatus_First(
			entityType, status, orderByComparator);
	}

	/**
	 * Returns the first configuration entity in the ordered set where entityType = &#63; and status = &#63;.
	 *
	 * @param entityType the entity type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching configuration entity, or <code>null</code> if a matching configuration entity could not be found
	 */
	public static ConfigurationEntity fetchByentityTypeAndStatus_First(
		String entityType, int status,
		OrderByComparator<ConfigurationEntity> orderByComparator) {

		return getPersistence().fetchByentityTypeAndStatus_First(
			entityType, status, orderByComparator);
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
	public static ConfigurationEntity findByentityTypeAndStatus_Last(
			String entityType, int status,
			OrderByComparator<ConfigurationEntity> orderByComparator)
		throws com.ejada.telemony.db.exception.
			NoSuchConfigurationEntityException {

		return getPersistence().findByentityTypeAndStatus_Last(
			entityType, status, orderByComparator);
	}

	/**
	 * Returns the last configuration entity in the ordered set where entityType = &#63; and status = &#63;.
	 *
	 * @param entityType the entity type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching configuration entity, or <code>null</code> if a matching configuration entity could not be found
	 */
	public static ConfigurationEntity fetchByentityTypeAndStatus_Last(
		String entityType, int status,
		OrderByComparator<ConfigurationEntity> orderByComparator) {

		return getPersistence().fetchByentityTypeAndStatus_Last(
			entityType, status, orderByComparator);
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
	public static ConfigurationEntity[] findByentityTypeAndStatus_PrevAndNext(
			long id, String entityType, int status,
			OrderByComparator<ConfigurationEntity> orderByComparator)
		throws com.ejada.telemony.db.exception.
			NoSuchConfigurationEntityException {

		return getPersistence().findByentityTypeAndStatus_PrevAndNext(
			id, entityType, status, orderByComparator);
	}

	/**
	 * Removes all the configuration entities where entityType = &#63; and status = &#63; from the database.
	 *
	 * @param entityType the entity type
	 * @param status the status
	 */
	public static void removeByentityTypeAndStatus(
		String entityType, int status) {

		getPersistence().removeByentityTypeAndStatus(entityType, status);
	}

	/**
	 * Returns the number of configuration entities where entityType = &#63; and status = &#63;.
	 *
	 * @param entityType the entity type
	 * @param status the status
	 * @return the number of matching configuration entities
	 */
	public static int countByentityTypeAndStatus(
		String entityType, int status) {

		return getPersistence().countByentityTypeAndStatus(entityType, status);
	}

	/**
	 * Caches the configuration entity in the entity cache if it is enabled.
	 *
	 * @param configurationEntity the configuration entity
	 */
	public static void cacheResult(ConfigurationEntity configurationEntity) {
		getPersistence().cacheResult(configurationEntity);
	}

	/**
	 * Caches the configuration entities in the entity cache if it is enabled.
	 *
	 * @param configurationEntities the configuration entities
	 */
	public static void cacheResult(
		List<ConfigurationEntity> configurationEntities) {

		getPersistence().cacheResult(configurationEntities);
	}

	/**
	 * Creates a new configuration entity with the primary key. Does not add the configuration entity to the database.
	 *
	 * @param id the primary key for the new configuration entity
	 * @return the new configuration entity
	 */
	public static ConfigurationEntity create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the configuration entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the configuration entity
	 * @return the configuration entity that was removed
	 * @throws NoSuchConfigurationEntityException if a configuration entity with the primary key could not be found
	 */
	public static ConfigurationEntity remove(long id)
		throws com.ejada.telemony.db.exception.
			NoSuchConfigurationEntityException {

		return getPersistence().remove(id);
	}

	public static ConfigurationEntity updateImpl(
		ConfigurationEntity configurationEntity) {

		return getPersistence().updateImpl(configurationEntity);
	}

	/**
	 * Returns the configuration entity with the primary key or throws a <code>NoSuchConfigurationEntityException</code> if it could not be found.
	 *
	 * @param id the primary key of the configuration entity
	 * @return the configuration entity
	 * @throws NoSuchConfigurationEntityException if a configuration entity with the primary key could not be found
	 */
	public static ConfigurationEntity findByPrimaryKey(long id)
		throws com.ejada.telemony.db.exception.
			NoSuchConfigurationEntityException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the configuration entity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the configuration entity
	 * @return the configuration entity, or <code>null</code> if a configuration entity with the primary key could not be found
	 */
	public static ConfigurationEntity fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the configuration entities.
	 *
	 * @return the configuration entities
	 */
	public static List<ConfigurationEntity> findAll() {
		return getPersistence().findAll();
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
	public static List<ConfigurationEntity> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<ConfigurationEntity> findAll(
		int start, int end,
		OrderByComparator<ConfigurationEntity> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<ConfigurationEntity> findAll(
		int start, int end,
		OrderByComparator<ConfigurationEntity> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the configuration entities from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of configuration entities.
	 *
	 * @return the number of configuration entities
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ConfigurationEntityPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		ConfigurationEntityPersistence persistence) {

		_persistence = persistence;
	}

	private static volatile ConfigurationEntityPersistence _persistence;

}