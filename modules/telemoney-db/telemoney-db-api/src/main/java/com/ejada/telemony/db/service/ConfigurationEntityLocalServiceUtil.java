/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.ejada.telemony.db.model.ConfigurationEntity;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Set;

/**
 * Provides the local service utility for ConfigurationEntity. This utility wraps
 * <code>com.ejada.telemony.db.service.impl.ConfigurationEntityLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ConfigurationEntityLocalService
 * @generated
 */
public class ConfigurationEntityLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.ConfigurationEntityLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static ConfigurationEntity addConfigurationEntity(
		ConfigurationEntity configurationEntity) {

		return getService().addConfigurationEntity(configurationEntity);
	}

	public static String callService(
		ConfigurationEntity configurationEntity,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().callService(configurationEntity, serviceContext);
	}

	/**
	 * Creates a new configuration entity with the primary key. Does not add the configuration entity to the database.
	 *
	 * @param id the primary key for the new configuration entity
	 * @return the new configuration entity
	 */
	public static ConfigurationEntity createConfigurationEntity(long id) {
		return getService().createConfigurationEntity(id);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static ConfigurationEntity deleteConfigurationEntity(
		ConfigurationEntity configurationEntity) {

		return getService().deleteConfigurationEntity(configurationEntity);
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
	public static ConfigurationEntity deleteConfigurationEntity(long id)
		throws PortalException {

		return getService().deleteConfigurationEntity(id);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static ConfigurationEntity fetchConfigurationEntity(long id) {
		return getService().fetchConfigurationEntity(id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	public static List<ConfigurationEntity> getConfigurationEntities(
		int start, int end) {

		return getService().getConfigurationEntities(start, end);
	}

	/**
	 * Returns the number of configuration entities.
	 *
	 * @return the number of configuration entities
	 */
	public static int getConfigurationEntitiesCount() {
		return getService().getConfigurationEntitiesCount();
	}

	/**
	 * Returns the configuration entity with the primary key.
	 *
	 * @param id the primary key of the configuration entity
	 * @return the configuration entity
	 * @throws PortalException if a configuration entity with the primary key could not be found
	 */
	public static ConfigurationEntity getConfigurationEntity(long id)
		throws PortalException {

		return getService().getConfigurationEntity(id);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Set<String> getPendingEntityIdsByType(String entityType) {
		return getService().getPendingEntityIdsByType(entityType);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static void handleConfigurationChange(
			String url, com.liferay.portal.kernel.json.JSONObject oldData,
			com.liferay.portal.kernel.json.JSONObject newData, String action,
			String entityType, String entityId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   PortalException {

		getService().handleConfigurationChange(
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
	public static ConfigurationEntity updateConfigurationEntity(
		ConfigurationEntity configurationEntity) {

		return getService().updateConfigurationEntity(configurationEntity);
	}

	public static ConfigurationEntity updateStatus(
			long userId, long id, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.ejada.telemony.db.exception.
			NoSuchConfigurationEntityException,
			   com.liferay.portal.kernel.json.JSONException {

		return getService().updateStatus(userId, id, status, serviceContext);
	}

	public static ConfigurationEntityLocalService getService() {
		return _service;
	}

	public static void setService(ConfigurationEntityLocalService service) {
		_service = service;
	}

	private static volatile ConfigurationEntityLocalService _service;

}