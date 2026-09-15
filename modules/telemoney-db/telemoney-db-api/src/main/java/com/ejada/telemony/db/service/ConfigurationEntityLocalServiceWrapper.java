/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ConfigurationEntityLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ConfigurationEntityLocalService
 * @generated
 */
public class ConfigurationEntityLocalServiceWrapper
	implements ConfigurationEntityLocalService,
			   ServiceWrapper<ConfigurationEntityLocalService> {

	public ConfigurationEntityLocalServiceWrapper() {
		this(null);
	}

	public ConfigurationEntityLocalServiceWrapper(
		ConfigurationEntityLocalService configurationEntityLocalService) {

		_configurationEntityLocalService = configurationEntityLocalService;
	}

	/**
	 * Adds the configuration entity to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConfigurationEntityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param configurationEntity the configuration entity
	 * @return the configuration entity that was added
	 */
	@Override
	public com.ejada.telemony.db.model.ConfigurationEntity
		addConfigurationEntity(
			com.ejada.telemony.db.model.ConfigurationEntity
				configurationEntity) {

		return _configurationEntityLocalService.addConfigurationEntity(
			configurationEntity);
	}

	@Override
	public String callService(
		com.ejada.telemony.db.model.ConfigurationEntity configurationEntity,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _configurationEntityLocalService.callService(
			configurationEntity, serviceContext);
	}

	/**
	 * Creates a new configuration entity with the primary key. Does not add the configuration entity to the database.
	 *
	 * @param id the primary key for the new configuration entity
	 * @return the new configuration entity
	 */
	@Override
	public com.ejada.telemony.db.model.ConfigurationEntity
		createConfigurationEntity(long id) {

		return _configurationEntityLocalService.createConfigurationEntity(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _configurationEntityLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the configuration entity from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConfigurationEntityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param configurationEntity the configuration entity
	 * @return the configuration entity that was removed
	 */
	@Override
	public com.ejada.telemony.db.model.ConfigurationEntity
		deleteConfigurationEntity(
			com.ejada.telemony.db.model.ConfigurationEntity
				configurationEntity) {

		return _configurationEntityLocalService.deleteConfigurationEntity(
			configurationEntity);
	}

	/**
	 * Deletes the configuration entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConfigurationEntityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the configuration entity
	 * @return the configuration entity that was removed
	 * @throws PortalException if a configuration entity with the primary key could not be found
	 */
	@Override
	public com.ejada.telemony.db.model.ConfigurationEntity
			deleteConfigurationEntity(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _configurationEntityLocalService.deleteConfigurationEntity(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _configurationEntityLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _configurationEntityLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _configurationEntityLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _configurationEntityLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _configurationEntityLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.ConfigurationEntityModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _configurationEntityLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.ConfigurationEntityModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _configurationEntityLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _configurationEntityLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _configurationEntityLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.telemony.db.model.ConfigurationEntity
		fetchConfigurationEntity(long id) {

		return _configurationEntityLocalService.fetchConfigurationEntity(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _configurationEntityLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the configuration entities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.ConfigurationEntityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of configuration entities
	 * @param end the upper bound of the range of configuration entities (not inclusive)
	 * @return the range of configuration entities
	 */
	@Override
	public java.util.List<com.ejada.telemony.db.model.ConfigurationEntity>
		getConfigurationEntities(int start, int end) {

		return _configurationEntityLocalService.getConfigurationEntities(
			start, end);
	}

	/**
	 * Returns the number of configuration entities.
	 *
	 * @return the number of configuration entities
	 */
	@Override
	public int getConfigurationEntitiesCount() {
		return _configurationEntityLocalService.getConfigurationEntitiesCount();
	}

	/**
	 * Returns the configuration entity with the primary key.
	 *
	 * @param id the primary key of the configuration entity
	 * @return the configuration entity
	 * @throws PortalException if a configuration entity with the primary key could not be found
	 */
	@Override
	public com.ejada.telemony.db.model.ConfigurationEntity
			getConfigurationEntity(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _configurationEntityLocalService.getConfigurationEntity(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _configurationEntityLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _configurationEntityLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.Set<String> getPendingEntityIdsByType(String entityType) {
		return _configurationEntityLocalService.getPendingEntityIdsByType(
			entityType);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _configurationEntityLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public void handleConfigurationChange(
			String url, com.liferay.portal.kernel.json.JSONObject oldData,
			com.liferay.portal.kernel.json.JSONObject newData, String action,
			String entityType, String entityId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   com.liferay.portal.kernel.exception.PortalException {

		_configurationEntityLocalService.handleConfigurationChange(
			url, oldData, newData, action, entityType, entityId, serviceContext,
			user);
	}

	/**
	 * Updates the configuration entity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConfigurationEntityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param configurationEntity the configuration entity
	 * @return the configuration entity that was updated
	 */
	@Override
	public com.ejada.telemony.db.model.ConfigurationEntity
		updateConfigurationEntity(
			com.ejada.telemony.db.model.ConfigurationEntity
				configurationEntity) {

		return _configurationEntityLocalService.updateConfigurationEntity(
			configurationEntity);
	}

	@Override
	public com.ejada.telemony.db.model.ConfigurationEntity updateStatus(
			long userId, long id, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.ejada.telemony.db.exception.
			NoSuchConfigurationEntityException,
			   com.liferay.portal.kernel.json.JSONException {

		return _configurationEntityLocalService.updateStatus(
			userId, id, status, serviceContext);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _configurationEntityLocalService.getBasePersistence();
	}

	@Override
	public ConfigurationEntityLocalService getWrappedService() {
		return _configurationEntityLocalService;
	}

	@Override
	public void setWrappedService(
		ConfigurationEntityLocalService configurationEntityLocalService) {

		_configurationEntityLocalService = configurationEntityLocalService;
	}

	private ConfigurationEntityLocalService _configurationEntityLocalService;

}