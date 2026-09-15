/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ResourceLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ResourceLocalService
 * @generated
 */
public class ResourceLocalServiceWrapper
	implements ResourceLocalService, ServiceWrapper<ResourceLocalService> {

	public ResourceLocalServiceWrapper() {
		this(null);
	}

	public ResourceLocalServiceWrapper(
		ResourceLocalService resourceLocalService) {

		_resourceLocalService = resourceLocalService;
	}

	@Override
	public void addNewResource(
		String resourceCode, String resourceType, String urlType,
		java.util.Map<String, String> nameValues,
		java.util.Map<String, String> attachValues,
		java.util.Map<String, String> attachfilesName,
		java.util.Map<String, String> descriptionValues,
		java.util.Map<String, String> routeIdValues,
		java.util.Map<String, String> urlValues, Long channelId, long featureId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		com.liferay.portal.kernel.model.User user) {

		_resourceLocalService.addNewResource(
			resourceCode, resourceType, urlType, nameValues, attachValues,
			attachfilesName, descriptionValues, routeIdValues, urlValues,
			channelId, featureId, serviceContext, user);
	}

	/**
	 * Adds the resource to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResourceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param resource the resource
	 * @return the resource that was added
	 */
	@Override
	public com.ejada.telemony.db.model.Resource addResource(
		com.ejada.telemony.db.model.Resource resource) {

		return _resourceLocalService.addResource(resource);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _resourceLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new resource with the primary key. Does not add the resource to the database.
	 *
	 * @param resourceId the primary key for the new resource
	 * @return the new resource
	 */
	@Override
	public com.ejada.telemony.db.model.Resource createResource(
		long resourceId) {

		return _resourceLocalService.createResource(resourceId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _resourceLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the resource with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResourceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param resourceId the primary key of the resource
	 * @return the resource that was removed
	 * @throws PortalException if a resource with the primary key could not be found
	 */
	@Override
	public com.ejada.telemony.db.model.Resource deleteResource(long resourceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _resourceLocalService.deleteResource(resourceId);
	}

	/**
	 * Deletes the resource from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResourceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param resource the resource
	 * @return the resource that was removed
	 */
	@Override
	public com.ejada.telemony.db.model.Resource deleteResource(
		com.ejada.telemony.db.model.Resource resource) {

		return _resourceLocalService.deleteResource(resource);
	}

	@Override
	public void deleteResourceLocalized(Long resourceId, Long channelId) {
		_resourceLocalService.deleteResourceLocalized(resourceId, channelId);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _resourceLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _resourceLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _resourceLocalService.dynamicQuery();
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

		return _resourceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.ResourceModelImpl</code>.
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

		return _resourceLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.ResourceModelImpl</code>.
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

		return _resourceLocalService.dynamicQuery(
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

		return _resourceLocalService.dynamicQueryCount(dynamicQuery);
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

		return _resourceLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.telemony.db.model.Resource fetchResource(long resourceId) {
		return _resourceLocalService.fetchResource(resourceId);
	}

	@Override
	public com.ejada.telemony.db.model.ResourceLocalization
		fetchResourceLocalization(long resourceId, String languageId) {

		return _resourceLocalService.fetchResourceLocalization(
			resourceId, languageId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _resourceLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Resource> getbyChannelId(
		Long channelId) {

		return _resourceLocalService.getbyChannelId(channelId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Resource>
		getByResourceCode(String resourceCode, long channelId) {

		return _resourceLocalService.getByResourceCode(resourceCode, channelId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Resource>
			getByResourceCodeByName(String resourceName)
		throws com.ejada.telemony.db.exception.NoSuchResourceException {

		return _resourceLocalService.getByResourceCodeByName(resourceName);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Resource>
		getByResourceCodeByNameLatestApproved(
			String resourceName, long channelId) {

		return _resourceLocalService.getByResourceCodeByNameLatestApproved(
			resourceName, channelId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Resource>
		getByResourceCodeLatestApproved(String resourceCode, long channelId) {

		return _resourceLocalService.getByResourceCodeLatestApproved(
			resourceCode, channelId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _resourceLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Resource>
		getLatestApprovedByChannelId(long channelId) {

		return _resourceLocalService.getLatestApprovedByChannelId(channelId);
	}

	@Override
	public java.util.Map<com.ejada.telemony.db.model.Resource, Boolean>
		getLatestApprovedByChannelIdWithPending(long channelId) {

		return _resourceLocalService.getLatestApprovedByChannelIdWithPending(
			channelId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _resourceLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _resourceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the resource with the primary key.
	 *
	 * @param resourceId the primary key of the resource
	 * @return the resource
	 * @throws PortalException if a resource with the primary key could not be found
	 */
	@Override
	public com.ejada.telemony.db.model.Resource getResource(long resourceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _resourceLocalService.getResource(resourceId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getResourceDetailsApi(
		javax.servlet.http.HttpServletRequest request, String language,
		Long channelId, String jsonResourceRequestBody) {

		return _resourceLocalService.getResourceDetailsApi(
			request, language, channelId, jsonResourceRequestBody);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject
		getResourceDetailsApiLatestApproved(
			javax.servlet.http.HttpServletRequest request, String language,
			Long channelId, String jsonResourceRequestBody) {

		return _resourceLocalService.getResourceDetailsApiLatestApproved(
			request, language, channelId, jsonResourceRequestBody);
	}

	@Override
	public com.ejada.telemony.db.model.ResourceLocalization
			getResourceLocalization(long resourceId, String languageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _resourceLocalService.getResourceLocalization(
			resourceId, languageId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.ResourceLocalization>
		getResourceLocalizations(long resourceId) {

		return _resourceLocalService.getResourceLocalizations(resourceId);
	}

	/**
	 * Returns a range of all the resources.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.ResourceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resources
	 * @param end the upper bound of the range of resources (not inclusive)
	 * @return the range of resources
	 */
	@Override
	public java.util.List<com.ejada.telemony.db.model.Resource> getResources(
		int start, int end) {

		return _resourceLocalService.getResources(start, end);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.ResourceLocalization>
		getResourcesById(long resourceId) {

		return _resourceLocalService.getResourcesById(resourceId);
	}

	/**
	 * Returns the number of resources.
	 *
	 * @return the number of resources
	 */
	@Override
	public int getResourcesCount() {
		return _resourceLocalService.getResourcesCount();
	}

	@Override
	public boolean hasApprovedOrDraftVersionByFeature(
		long featureId, long channelId) {

		return _resourceLocalService.hasApprovedOrDraftVersionByFeature(
			featureId, channelId);
	}

	@Override
	public boolean hasPendingDraft(long entityResourceId) {
		return _resourceLocalService.hasPendingDraft(entityResourceId);
	}

	@Override
	public void importResources(
		com.ejada.telemony.db.model.ImportRequest importRequest,
		com.liferay.portal.kernel.json.JSONArray jsonArray) {

		_resourceLocalService.importResources(importRequest, jsonArray);
	}

	@Override
	public void resourceDelete(
			Long resourceId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws Exception {

		_resourceLocalService.resourceDelete(resourceId, serviceContext, user);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Resource>
		searchResourceByType(String resourceType, long channelId) {

		return _resourceLocalService.searchResourceByType(
			resourceType, channelId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Resource>
		searchResourceByTypeLatestApproved(
			String resourceType, long channelId) {

		return _resourceLocalService.searchResourceByTypeLatestApproved(
			resourceType, channelId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Resource>
		searchResourceService(String searchTerm, Long chn) {

		return _resourceLocalService.searchResourceService(searchTerm, chn);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Resource>
		searchResourceServiceLatestApproved(String searchTerm, long channelId) {

		return _resourceLocalService.searchResourceServiceLatestApproved(
			searchTerm, channelId);
	}

	@Override
	public void updateResource(
			Long resourceId, String resourceCode, String resourceType,
			String urlType, java.util.Map<String, String> nameValues,
			java.util.Map<String, String> attachValues,
			java.util.Map<String, String> attachfilesName,
			java.util.Map<String, String> descriptionValues,
			java.util.Map<String, String> routeIdValues,
			java.util.Map<String, String> urlValues, Long channelId,
			long featureId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws Exception {

		_resourceLocalService.updateResource(
			resourceId, resourceCode, resourceType, urlType, nameValues,
			attachValues, attachfilesName, descriptionValues, routeIdValues,
			urlValues, channelId, featureId, serviceContext, user);
	}

	/**
	 * Updates the resource in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResourceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param resource the resource
	 * @return the resource that was updated
	 */
	@Override
	public com.ejada.telemony.db.model.Resource updateResource(
		com.ejada.telemony.db.model.Resource resource) {

		return _resourceLocalService.updateResource(resource);
	}

	@Override
	public com.ejada.telemony.db.model.ResourceLocalization
			updateResourceLocalization(
				com.ejada.telemony.db.model.Resource resource,
				String languageId, String name, String attachName,
				String attach, String description, String routeId, String url)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _resourceLocalService.updateResourceLocalization(
			resource, languageId, name, attachName, attach, description,
			routeId, url);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.ResourceLocalization>
			updateResourceLocalizations(
				com.ejada.telemony.db.model.Resource resource,
				java.util.Map<String, String> nameMap,
				java.util.Map<String, String> attachNameMap,
				java.util.Map<String, String> attachMap,
				java.util.Map<String, String> descriptionMap,
				java.util.Map<String, String> routeIdMap,
				java.util.Map<String, String> urlMap)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _resourceLocalService.updateResourceLocalizations(
			resource, nameMap, attachNameMap, attachMap, descriptionMap,
			routeIdMap, urlMap);
	}

	@Override
	public com.ejada.telemony.db.model.Resource updateStatus(
			long userId, long resourceId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _resourceLocalService.updateStatus(
			userId, resourceId, status, serviceContext);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _resourceLocalService.getBasePersistence();
	}

	@Override
	public ResourceLocalService getWrappedService() {
		return _resourceLocalService;
	}

	@Override
	public void setWrappedService(ResourceLocalService resourceLocalService) {
		_resourceLocalService = resourceLocalService;
	}

	private ResourceLocalService _resourceLocalService;

}