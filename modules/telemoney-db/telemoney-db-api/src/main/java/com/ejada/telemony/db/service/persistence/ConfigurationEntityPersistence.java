/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.exception.NoSuchConfigurationEntityException;
import com.ejada.telemony.db.model.ConfigurationEntity;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the configuration entity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConfigurationEntityUtil
 * @generated
 */
@ProviderType
public interface ConfigurationEntityPersistence
	extends BasePersistence<ConfigurationEntity> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ConfigurationEntityUtil} to access the configuration entity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the configuration entities where entityId = &#63;.
	 *
	 * @param entityId the entity ID
	 * @return the matching configuration entities
	 */
	public java.util.List<ConfigurationEntity> findByentityId(String entityId);

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
	public java.util.List<ConfigurationEntity> findByentityId(
		String entityId, int start, int end);

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
	public java.util.List<ConfigurationEntity> findByentityId(
		String entityId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConfigurationEntity>
			orderByComparator);

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
	public java.util.List<ConfigurationEntity> findByentityId(
		String entityId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConfigurationEntity>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first configuration entity in the ordered set where entityId = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching configuration entity
	 * @throws NoSuchConfigurationEntityException if a matching configuration entity could not be found
	 */
	public ConfigurationEntity findByentityId_First(
			String entityId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ConfigurationEntity> orderByComparator)
		throws NoSuchConfigurationEntityException;

	/**
	 * Returns the first configuration entity in the ordered set where entityId = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching configuration entity, or <code>null</code> if a matching configuration entity could not be found
	 */
	public ConfigurationEntity fetchByentityId_First(
		String entityId,
		com.liferay.portal.kernel.util.OrderByComparator<ConfigurationEntity>
			orderByComparator);

	/**
	 * Returns the last configuration entity in the ordered set where entityId = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching configuration entity
	 * @throws NoSuchConfigurationEntityException if a matching configuration entity could not be found
	 */
	public ConfigurationEntity findByentityId_Last(
			String entityId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ConfigurationEntity> orderByComparator)
		throws NoSuchConfigurationEntityException;

	/**
	 * Returns the last configuration entity in the ordered set where entityId = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching configuration entity, or <code>null</code> if a matching configuration entity could not be found
	 */
	public ConfigurationEntity fetchByentityId_Last(
		String entityId,
		com.liferay.portal.kernel.util.OrderByComparator<ConfigurationEntity>
			orderByComparator);

	/**
	 * Returns the configuration entities before and after the current configuration entity in the ordered set where entityId = &#63;.
	 *
	 * @param id the primary key of the current configuration entity
	 * @param entityId the entity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next configuration entity
	 * @throws NoSuchConfigurationEntityException if a configuration entity with the primary key could not be found
	 */
	public ConfigurationEntity[] findByentityId_PrevAndNext(
			long id, String entityId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ConfigurationEntity> orderByComparator)
		throws NoSuchConfigurationEntityException;

	/**
	 * Removes all the configuration entities where entityId = &#63; from the database.
	 *
	 * @param entityId the entity ID
	 */
	public void removeByentityId(String entityId);

	/**
	 * Returns the number of configuration entities where entityId = &#63;.
	 *
	 * @param entityId the entity ID
	 * @return the number of matching configuration entities
	 */
	public int countByentityId(String entityId);

	/**
	 * Returns all the configuration entities where entityId = &#63; and entityType = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param entityType the entity type
	 * @return the matching configuration entities
	 */
	public java.util.List<ConfigurationEntity> findByentityIdAndType(
		String entityId, String entityType);

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
	public java.util.List<ConfigurationEntity> findByentityIdAndType(
		String entityId, String entityType, int start, int end);

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
	public java.util.List<ConfigurationEntity> findByentityIdAndType(
		String entityId, String entityType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConfigurationEntity>
			orderByComparator);

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
	public java.util.List<ConfigurationEntity> findByentityIdAndType(
		String entityId, String entityType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConfigurationEntity>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first configuration entity in the ordered set where entityId = &#63; and entityType = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param entityType the entity type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching configuration entity
	 * @throws NoSuchConfigurationEntityException if a matching configuration entity could not be found
	 */
	public ConfigurationEntity findByentityIdAndType_First(
			String entityId, String entityType,
			com.liferay.portal.kernel.util.OrderByComparator
				<ConfigurationEntity> orderByComparator)
		throws NoSuchConfigurationEntityException;

	/**
	 * Returns the first configuration entity in the ordered set where entityId = &#63; and entityType = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param entityType the entity type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching configuration entity, or <code>null</code> if a matching configuration entity could not be found
	 */
	public ConfigurationEntity fetchByentityIdAndType_First(
		String entityId, String entityType,
		com.liferay.portal.kernel.util.OrderByComparator<ConfigurationEntity>
			orderByComparator);

	/**
	 * Returns the last configuration entity in the ordered set where entityId = &#63; and entityType = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param entityType the entity type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching configuration entity
	 * @throws NoSuchConfigurationEntityException if a matching configuration entity could not be found
	 */
	public ConfigurationEntity findByentityIdAndType_Last(
			String entityId, String entityType,
			com.liferay.portal.kernel.util.OrderByComparator
				<ConfigurationEntity> orderByComparator)
		throws NoSuchConfigurationEntityException;

	/**
	 * Returns the last configuration entity in the ordered set where entityId = &#63; and entityType = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param entityType the entity type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching configuration entity, or <code>null</code> if a matching configuration entity could not be found
	 */
	public ConfigurationEntity fetchByentityIdAndType_Last(
		String entityId, String entityType,
		com.liferay.portal.kernel.util.OrderByComparator<ConfigurationEntity>
			orderByComparator);

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
	public ConfigurationEntity[] findByentityIdAndType_PrevAndNext(
			long id, String entityId, String entityType,
			com.liferay.portal.kernel.util.OrderByComparator
				<ConfigurationEntity> orderByComparator)
		throws NoSuchConfigurationEntityException;

	/**
	 * Removes all the configuration entities where entityId = &#63; and entityType = &#63; from the database.
	 *
	 * @param entityId the entity ID
	 * @param entityType the entity type
	 */
	public void removeByentityIdAndType(String entityId, String entityType);

	/**
	 * Returns the number of configuration entities where entityId = &#63; and entityType = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param entityType the entity type
	 * @return the number of matching configuration entities
	 */
	public int countByentityIdAndType(String entityId, String entityType);

	/**
	 * Returns all the configuration entities where entityType = &#63; and status = &#63;.
	 *
	 * @param entityType the entity type
	 * @param status the status
	 * @return the matching configuration entities
	 */
	public java.util.List<ConfigurationEntity> findByentityTypeAndStatus(
		String entityType, int status);

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
	public java.util.List<ConfigurationEntity> findByentityTypeAndStatus(
		String entityType, int status, int start, int end);

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
	public java.util.List<ConfigurationEntity> findByentityTypeAndStatus(
		String entityType, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConfigurationEntity>
			orderByComparator);

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
	public java.util.List<ConfigurationEntity> findByentityTypeAndStatus(
		String entityType, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConfigurationEntity>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first configuration entity in the ordered set where entityType = &#63; and status = &#63;.
	 *
	 * @param entityType the entity type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching configuration entity
	 * @throws NoSuchConfigurationEntityException if a matching configuration entity could not be found
	 */
	public ConfigurationEntity findByentityTypeAndStatus_First(
			String entityType, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<ConfigurationEntity> orderByComparator)
		throws NoSuchConfigurationEntityException;

	/**
	 * Returns the first configuration entity in the ordered set where entityType = &#63; and status = &#63;.
	 *
	 * @param entityType the entity type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching configuration entity, or <code>null</code> if a matching configuration entity could not be found
	 */
	public ConfigurationEntity fetchByentityTypeAndStatus_First(
		String entityType, int status,
		com.liferay.portal.kernel.util.OrderByComparator<ConfigurationEntity>
			orderByComparator);

	/**
	 * Returns the last configuration entity in the ordered set where entityType = &#63; and status = &#63;.
	 *
	 * @param entityType the entity type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching configuration entity
	 * @throws NoSuchConfigurationEntityException if a matching configuration entity could not be found
	 */
	public ConfigurationEntity findByentityTypeAndStatus_Last(
			String entityType, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<ConfigurationEntity> orderByComparator)
		throws NoSuchConfigurationEntityException;

	/**
	 * Returns the last configuration entity in the ordered set where entityType = &#63; and status = &#63;.
	 *
	 * @param entityType the entity type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching configuration entity, or <code>null</code> if a matching configuration entity could not be found
	 */
	public ConfigurationEntity fetchByentityTypeAndStatus_Last(
		String entityType, int status,
		com.liferay.portal.kernel.util.OrderByComparator<ConfigurationEntity>
			orderByComparator);

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
	public ConfigurationEntity[] findByentityTypeAndStatus_PrevAndNext(
			long id, String entityType, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<ConfigurationEntity> orderByComparator)
		throws NoSuchConfigurationEntityException;

	/**
	 * Removes all the configuration entities where entityType = &#63; and status = &#63; from the database.
	 *
	 * @param entityType the entity type
	 * @param status the status
	 */
	public void removeByentityTypeAndStatus(String entityType, int status);

	/**
	 * Returns the number of configuration entities where entityType = &#63; and status = &#63;.
	 *
	 * @param entityType the entity type
	 * @param status the status
	 * @return the number of matching configuration entities
	 */
	public int countByentityTypeAndStatus(String entityType, int status);

	/**
	 * Caches the configuration entity in the entity cache if it is enabled.
	 *
	 * @param configurationEntity the configuration entity
	 */
	public void cacheResult(ConfigurationEntity configurationEntity);

	/**
	 * Caches the configuration entities in the entity cache if it is enabled.
	 *
	 * @param configurationEntities the configuration entities
	 */
	public void cacheResult(
		java.util.List<ConfigurationEntity> configurationEntities);

	/**
	 * Creates a new configuration entity with the primary key. Does not add the configuration entity to the database.
	 *
	 * @param id the primary key for the new configuration entity
	 * @return the new configuration entity
	 */
	public ConfigurationEntity create(long id);

	/**
	 * Removes the configuration entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the configuration entity
	 * @return the configuration entity that was removed
	 * @throws NoSuchConfigurationEntityException if a configuration entity with the primary key could not be found
	 */
	public ConfigurationEntity remove(long id)
		throws NoSuchConfigurationEntityException;

	public ConfigurationEntity updateImpl(
		ConfigurationEntity configurationEntity);

	/**
	 * Returns the configuration entity with the primary key or throws a <code>NoSuchConfigurationEntityException</code> if it could not be found.
	 *
	 * @param id the primary key of the configuration entity
	 * @return the configuration entity
	 * @throws NoSuchConfigurationEntityException if a configuration entity with the primary key could not be found
	 */
	public ConfigurationEntity findByPrimaryKey(long id)
		throws NoSuchConfigurationEntityException;

	/**
	 * Returns the configuration entity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the configuration entity
	 * @return the configuration entity, or <code>null</code> if a configuration entity with the primary key could not be found
	 */
	public ConfigurationEntity fetchByPrimaryKey(long id);

	/**
	 * Returns all the configuration entities.
	 *
	 * @return the configuration entities
	 */
	public java.util.List<ConfigurationEntity> findAll();

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
	public java.util.List<ConfigurationEntity> findAll(int start, int end);

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
	public java.util.List<ConfigurationEntity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConfigurationEntity>
			orderByComparator);

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
	public java.util.List<ConfigurationEntity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConfigurationEntity>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the configuration entities from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of configuration entities.
	 *
	 * @return the number of configuration entities
	 */
	public int countAll();

}