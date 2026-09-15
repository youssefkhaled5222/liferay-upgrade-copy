/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.ejada.telemony.db.exception.NoSuchResourceException;
import com.ejada.telemony.db.model.ImportRequest;
import com.ejada.telemony.db.model.Resource;
import com.ejada.telemony.db.model.ResourceLocalization;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.*;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Resource. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see ResourceLocalServiceUtil
 * @generated
 */
@OSGiBeanProperties(
	property = {"model.class.name=com.ejada.telemony.db.model.Resource"}
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ResourceLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.ResourceLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the resource local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ResourceLocalServiceUtil} if injection and service tracking are not available.
	 */
	public void addNewResource(
		String resourceCode, String resourceType, String urlType,
		Map<String, String> nameValues, Map<String, String> attachValues,
		Map<String, String> attachfilesName,
		Map<String, String> descriptionValues,
		Map<String, String> routeIdValues, Map<String, String> urlValues,
		Long channelId, long featureId, ServiceContext serviceContext,
		User user);

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
	@Indexable(type = IndexableType.REINDEX)
	public Resource addResource(Resource resource);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new resource with the primary key. Does not add the resource to the database.
	 *
	 * @param resourceId the primary key for the new resource
	 * @return the new resource
	 */
	@Transactional(enabled = false)
	public Resource createResource(long resourceId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public Resource deleteResource(long resourceId) throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public Resource deleteResource(Resource resource);

	public void deleteResourceLocalized(Long resourceId, Long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Resource fetchResource(long resourceId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ResourceLocalization fetchResourceLocalization(
		long resourceId, String languageId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Resource> getbyChannelId(Long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Resource> getByResourceCode(
		String resourceCode, long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Resource> getByResourceCodeByName(String resourceName)
		throws NoSuchResourceException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Resource> getByResourceCodeByNameLatestApproved(
		String resourceName, long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Resource> getByResourceCodeLatestApproved(
		String resourceCode, long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Resource> getLatestApprovedByChannelId(long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Map<Resource, Boolean> getLatestApprovedByChannelIdWithPending(
		long channelId);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Returns the resource with the primary key.
	 *
	 * @param resourceId the primary key of the resource
	 * @return the resource
	 * @throws PortalException if a resource with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Resource getResource(long resourceId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getResourceDetailsApi(
		HttpServletRequest request, String language, Long channelId,
		String jsonResourceRequestBody);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getResourceDetailsApiLatestApproved(
		HttpServletRequest request, String language, Long channelId,
		String jsonResourceRequestBody);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ResourceLocalization getResourceLocalization(
			long resourceId, String languageId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ResourceLocalization> getResourceLocalizations(long resourceId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Resource> getResources(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ResourceLocalization> getResourcesById(long resourceId);

	/**
	 * Returns the number of resources.
	 *
	 * @return the number of resources
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getResourcesCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasApprovedOrDraftVersionByFeature(
		long featureId, long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasPendingDraft(long entityResourceId);

	public void importResources(
		ImportRequest importRequest, JSONArray jsonArray);

	public void resourceDelete(
			Long resourceId, ServiceContext serviceContext, User user)
		throws Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Resource> searchResourceByType(
		String resourceType, long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Resource> searchResourceByTypeLatestApproved(
		String resourceType, long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Resource> searchResourceService(String searchTerm, Long chn);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Resource> searchResourceServiceLatestApproved(
		String searchTerm, long channelId);

	public void updateResource(
			Long resourceId, String resourceCode, String resourceType,
			String urlType, Map<String, String> nameValues,
			Map<String, String> attachValues,
			Map<String, String> attachfilesName,
			Map<String, String> descriptionValues,
			Map<String, String> routeIdValues, Map<String, String> urlValues,
			Long channelId, long featureId, ServiceContext serviceContext,
			User user)
		throws Exception;

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
	@Indexable(type = IndexableType.REINDEX)
	public Resource updateResource(Resource resource);

	public ResourceLocalization updateResourceLocalization(
			Resource resource, String languageId, String name,
			String attachName, String attach, String description,
			String routeId, String url)
		throws PortalException;

	public List<ResourceLocalization> updateResourceLocalizations(
			Resource resource, Map<String, String> nameMap,
			Map<String, String> attachNameMap, Map<String, String> attachMap,
			Map<String, String> descriptionMap, Map<String, String> routeIdMap,
			Map<String, String> urlMap)
		throws PortalException;

	public Resource updateStatus(
			long userId, long resourceId, int status,
			ServiceContext serviceContext)
		throws PortalException, SystemException;

}