/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.ejada.telemony.db.model.Resource;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for Resource. This utility wraps
 * <code>com.ejada.telemony.db.service.impl.ResourceLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ResourceLocalService
 * @generated
 */
public class ResourceLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.ResourceLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addNewResource(
		String resourceCode, String resourceType, String urlType,
		Map<String, String> nameValues, Map<String, String> attachValues,
		Map<String, String> attachfilesName,
		Map<String, String> descriptionValues,
		Map<String, String> routeIdValues, Map<String, String> urlValues,
		Long channelId, long featureId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		com.liferay.portal.kernel.model.User user) {

		getService().addNewResource(
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
	public static Resource addResource(Resource resource) {
		return getService().addResource(resource);
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
	 * Creates a new resource with the primary key. Does not add the resource to the database.
	 *
	 * @param resourceId the primary key for the new resource
	 * @return the new resource
	 */
	public static Resource createResource(long resourceId) {
		return getService().createResource(resourceId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static Resource deleteResource(long resourceId)
		throws PortalException {

		return getService().deleteResource(resourceId);
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
	public static Resource deleteResource(Resource resource) {
		return getService().deleteResource(resource);
	}

	public static void deleteResourceLocalized(
		Long resourceId, Long channelId) {

		getService().deleteResourceLocalized(resourceId, channelId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.ResourceModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.ResourceModelImpl</code>.
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

	public static Resource fetchResource(long resourceId) {
		return getService().fetchResource(resourceId);
	}

	public static com.ejada.telemony.db.model.ResourceLocalization
		fetchResourceLocalization(long resourceId, String languageId) {

		return getService().fetchResourceLocalization(resourceId, languageId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<Resource> getbyChannelId(Long channelId) {
		return getService().getbyChannelId(channelId);
	}

	public static List<Resource> getByResourceCode(
		String resourceCode, long channelId) {

		return getService().getByResourceCode(resourceCode, channelId);
	}

	public static List<Resource> getByResourceCodeByName(String resourceName)
		throws com.ejada.telemony.db.exception.NoSuchResourceException {

		return getService().getByResourceCodeByName(resourceName);
	}

	public static List<Resource> getByResourceCodeByNameLatestApproved(
		String resourceName, long channelId) {

		return getService().getByResourceCodeByNameLatestApproved(
			resourceName, channelId);
	}

	public static List<Resource> getByResourceCodeLatestApproved(
		String resourceCode, long channelId) {

		return getService().getByResourceCodeLatestApproved(
			resourceCode, channelId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static List<Resource> getLatestApprovedByChannelId(long channelId) {
		return getService().getLatestApprovedByChannelId(channelId);
	}

	public static Map<Resource, Boolean>
		getLatestApprovedByChannelIdWithPending(long channelId) {

		return getService().getLatestApprovedByChannelIdWithPending(channelId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the resource with the primary key.
	 *
	 * @param resourceId the primary key of the resource
	 * @return the resource
	 * @throws PortalException if a resource with the primary key could not be found
	 */
	public static Resource getResource(long resourceId) throws PortalException {
		return getService().getResource(resourceId);
	}

	public static com.liferay.portal.kernel.json.JSONObject
		getResourceDetailsApi(
			javax.servlet.http.HttpServletRequest request, String language,
			Long channelId, String jsonResourceRequestBody) {

		return getService().getResourceDetailsApi(
			request, language, channelId, jsonResourceRequestBody);
	}

	public static com.liferay.portal.kernel.json.JSONObject
		getResourceDetailsApiLatestApproved(
			javax.servlet.http.HttpServletRequest request, String language,
			Long channelId, String jsonResourceRequestBody) {

		return getService().getResourceDetailsApiLatestApproved(
			request, language, channelId, jsonResourceRequestBody);
	}

	public static com.ejada.telemony.db.model.ResourceLocalization
			getResourceLocalization(long resourceId, String languageId)
		throws PortalException {

		return getService().getResourceLocalization(resourceId, languageId);
	}

	public static List<com.ejada.telemony.db.model.ResourceLocalization>
		getResourceLocalizations(long resourceId) {

		return getService().getResourceLocalizations(resourceId);
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
	public static List<Resource> getResources(int start, int end) {
		return getService().getResources(start, end);
	}

	public static List<com.ejada.telemony.db.model.ResourceLocalization>
		getResourcesById(long resourceId) {

		return getService().getResourcesById(resourceId);
	}

	/**
	 * Returns the number of resources.
	 *
	 * @return the number of resources
	 */
	public static int getResourcesCount() {
		return getService().getResourcesCount();
	}

	public static boolean hasApprovedOrDraftVersionByFeature(
		long featureId, long channelId) {

		return getService().hasApprovedOrDraftVersionByFeature(
			featureId, channelId);
	}

	public static boolean hasPendingDraft(long entityResourceId) {
		return getService().hasPendingDraft(entityResourceId);
	}

	public static void importResources(
		com.ejada.telemony.db.model.ImportRequest importRequest,
		com.liferay.portal.kernel.json.JSONArray jsonArray) {

		getService().importResources(importRequest, jsonArray);
	}

	public static void resourceDelete(
			Long resourceId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws Exception {

		getService().resourceDelete(resourceId, serviceContext, user);
	}

	public static List<Resource> searchResourceByType(
		String resourceType, long channelId) {

		return getService().searchResourceByType(resourceType, channelId);
	}

	public static List<Resource> searchResourceByTypeLatestApproved(
		String resourceType, long channelId) {

		return getService().searchResourceByTypeLatestApproved(
			resourceType, channelId);
	}

	public static List<Resource> searchResourceService(
		String searchTerm, Long chn) {

		return getService().searchResourceService(searchTerm, chn);
	}

	public static List<Resource> searchResourceServiceLatestApproved(
		String searchTerm, long channelId) {

		return getService().searchResourceServiceLatestApproved(
			searchTerm, channelId);
	}

	public static void updateResource(
			Long resourceId, String resourceCode, String resourceType,
			String urlType, Map<String, String> nameValues,
			Map<String, String> attachValues,
			Map<String, String> attachfilesName,
			Map<String, String> descriptionValues,
			Map<String, String> routeIdValues, Map<String, String> urlValues,
			Long channelId, long featureId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws Exception {

		getService().updateResource(
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
	public static Resource updateResource(Resource resource) {
		return getService().updateResource(resource);
	}

	public static com.ejada.telemony.db.model.ResourceLocalization
			updateResourceLocalization(
				Resource resource, String languageId, String name,
				String attachName, String attach, String description,
				String routeId, String url)
		throws PortalException {

		return getService().updateResourceLocalization(
			resource, languageId, name, attachName, attach, description,
			routeId, url);
	}

	public static List<com.ejada.telemony.db.model.ResourceLocalization>
			updateResourceLocalizations(
				Resource resource, Map<String, String> nameMap,
				Map<String, String> attachNameMap,
				Map<String, String> attachMap,
				Map<String, String> descriptionMap,
				Map<String, String> routeIdMap, Map<String, String> urlMap)
		throws PortalException {

		return getService().updateResourceLocalizations(
			resource, nameMap, attachNameMap, attachMap, descriptionMap,
			routeIdMap, urlMap);
	}

	public static Resource updateStatus(
			long userId, long resourceId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		return getService().updateStatus(
			userId, resourceId, status, serviceContext);
	}

	public static ResourceLocalService getService() {
		return _service;
	}

	public static void setService(ResourceLocalService service) {
		_service = service;
	}

	private static volatile ResourceLocalService _service;

}