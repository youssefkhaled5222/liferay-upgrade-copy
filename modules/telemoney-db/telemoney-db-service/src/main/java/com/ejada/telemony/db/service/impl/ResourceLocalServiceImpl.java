/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ejada.telemony.db.service.impl;

import com.ejada.telemoney.db.constants.TelemoneyConstants;
import com.ejada.telemoney.db.dto.importDtos.ResourceImportDTO;
import com.ejada.telemoney.db.utils.ExportFileUtil;
import com.ejada.telemony.db.constants.ComponentType;
import com.ejada.telemony.db.constants.Constants;
import com.ejada.telemony.db.exception.NoSuchResourceException;
import com.ejada.telemony.db.exception.NoSuchResourceLocalizationException;
import com.ejada.telemony.db.model.Channels;
import com.ejada.telemony.db.model.ImportRequest;
import com.ejada.telemony.db.model.Languages;
import com.ejada.telemony.db.model.Resource;
import com.ejada.telemony.db.model.ResourceLocalization;
import com.ejada.telemony.db.service.ChannelsLocalServiceUtil;
import com.ejada.telemony.db.service.GlobalVersionLocalServiceUtil;
import com.ejada.telemony.db.service.LocalizationLocalServiceUtil;
import com.ejada.telemony.db.service.ResourceLocalServiceUtil;
import com.ejada.telemony.db.service.base.ResourceLocalServiceBaseImpl;
import com.ejada.telemony.db.service.persistence.ResourceLocalizationUtil;
import com.ejada.telemony.db.service.persistence.ResourceUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.model.DLVersionNumberIncrease;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import org.osgi.service.component.annotations.Reference;

import java.io.File;
import java.nio.file.Files;
import java.util.*;

import java.nio.file.Path;

import javax.servlet.http.HttpServletRequest;

import static java.io.File.createTempFile;

/**
 * The implementation of the resource local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.ejada.telemony.db.service.ResourceLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ResourceLocalServiceBaseImpl
 */
public class ResourceLocalServiceImpl extends ResourceLocalServiceBaseImpl {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. Use
     * <code>com.ejada.telemony.db.service.ResourceLocalService</code> via injection
     * or a <code>org.osgi.util.tracker.ServiceTracker</code> or use
     * <code>com.ejada.telemony.db.service.ResourceLocalServiceUtil</code>.
     */
    private static final Log LOG = LogFactoryUtil.getLog(ResourceLocalServiceImpl.class);

    /**
     * Channel whose resources are the assets exposed by the Asset Management
     * API. Matched strictly, case included.
     */
    private static final String BLUE_APP_CHANNEL_NAME = "Blue App";

    @Reference
    private DLAppService dlAppLocalService;

    public void addNewResource(String resourceCode, String resourceType, String urlType, Map<String, String> nameValues,
                               Map<String, String> attachValues, Map<String, String> attachfilesName,
                               Map<String, String> descriptionValues, Map<String, String> routeIdValues, Map<String, String> urlValues,
                               Long channelId, long featureId, ServiceContext serviceContext, User user) {

        try {
            Resource resourceLocal = createResourceEntity(0L, resourceCode, resourceType, urlType, nameValues, attachValues, attachfilesName,
                    descriptionValues, routeIdValues, urlValues, channelId, featureId, serviceContext, user);

            // Workflow support
            if (serviceContext != null && user != null) {
                startWorkflow(resourceLocal, serviceContext, user, 0L, Constants.CREATE);
            } else {
                this.resourcePersistence.update(resourceLocal);
            }
        } catch (NullPointerException e) {
            System.out.println("Null pointer exception: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Data validation error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error adding user data: " + e.getMessage());
        }
    }

    public void updateResource(Long resourceId, String resourceCode, String resourceType, String urlType,
                               Map<String, String> nameValues, Map<String, String> attachValues, Map<String, String> attachfilesName,
                               Map<String, String> descriptionValues, Map<String, String> routeIdValues, Map<String, String> urlValues,
                               Long channelId, long featureId, ServiceContext serviceContext, User user) throws Exception {
        Resource originalResource = this.resourcePersistence.fetchByPrimaryKey(resourceId);

        if (serviceContext != null && user != null) {
            // Block edits if there is any pending draft for the same entityResourceId
            if (hasPendingDraft(originalResource.getEntityResourceId())) {
                throw new Exception("This Resource is currently locked because there is a pending change awaiting approval.");
            }
            try {
                Resource draftResource = createResourceEntity(resourceId, resourceCode, resourceType, urlType, nameValues, attachValues, attachfilesName,
                        descriptionValues, routeIdValues, urlValues, channelId, featureId, serviceContext, user);
                startWorkflow(draftResource, serviceContext, user, resourceId, Constants.UPDATE);
            } catch (Exception e) {
                LOG.error("Error updating resource: " + e.getMessage());
                throw e;
            }
        }
    }

    public List<ResourceLocalization> getResourcesById(long resourceId) {
        return resourceLocalizationPersistence.findByResourceId(resourceId);
    }

    public JSONObject getResourceDetailsApi(HttpServletRequest request, String language, Long channelId, String jsonResourceRequestBody) {

        JSONObject resourceResult = JSONFactoryUtil.createJSONObject();
        JSONObject resourceData = JSONFactoryUtil.createJSONObject();
        JSONObject attachObject = JSONFactoryUtil.createJSONObject();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(jsonResourceRequestBody);
            String resourceCode = rootNode.path("resourceCode").asText();
            String portalURL = PortalUtil.getPortalURL(request);
            DynamicQuery resourceDynamicQuery = DynamicQueryFactoryUtil.forClass(Resource.class, getClassLoader());
            DynamicQuery resourceLocalizedDynamicQuery = DynamicQueryFactoryUtil.forClass(ResourceLocalization.class,
                    getClassLoader());

            resourceDynamicQuery.add(PropertyFactoryUtil.forName("channelId").eq(channelId));
            resourceDynamicQuery.add(PropertyFactoryUtil.forName("resourceCode").eq(resourceCode));

            List<Resource> resources = ResourceLocalServiceUtil.dynamicQuery(resourceDynamicQuery);
            if (resources.isEmpty()) {
                return resourceResult;

            } else {
                for (int i = 0; i < resources.size(); i++) {

                    resourceLocalizedDynamicQuery.add(PropertyFactoryUtil.forName("languageId").eq(language));
                    resourceLocalizedDynamicQuery
                            .add(PropertyFactoryUtil.forName("resourceId").eq(resources.get(i).getResourceId()));
                    List<ResourceLocalization> resourcesLocalized = ResourceLocalServiceUtil
                            .dynamicQuery(resourceLocalizedDynamicQuery);
                    if (resourcesLocalized.isEmpty()) {
                        return resourceResult;
                    } else {
                        resourceData.put("name", resourcesLocalized.get(i).getName());
                        attachObject.put("attachValue", portalURL + resourcesLocalized.get(i).getAttach());
                        resourceData.put("attach", attachObject);
                        resourceData.put("descrpition", resourcesLocalized.get(i).getDescription());
                        resourceData.put("routeId", resourcesLocalized.get(i).getRouteId());
                        resourceData.put("url", resourcesLocalized.get(i).getUrl());
                    }
                    resourceResult.put("resourceType", resources.get(i).getResourceType());
                    if (resources.get(i).getResourceType().equals("1"))
                        resourceResult.put("resourceSubType", resources.get(i).getUrlType());
                    else {
                        resourceResult.put("resourceSubType", "");
                    }
                    resourceResult.put("resourceData", resourceData);
                }

            }
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return resourceResult;

    }

    public JSONObject getResourceDetailsApiLatestApproved(HttpServletRequest request, String language, Long channelId, String jsonResourceRequestBody) {

        JSONObject resourceResult = JSONFactoryUtil.createJSONObject();
        JSONObject resourceData = JSONFactoryUtil.createJSONObject();
        JSONObject attachObject = JSONFactoryUtil.createJSONObject();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(jsonResourceRequestBody);
            String resourceCode = rootNode.path("resourceCode").asText();
            String portalURL = PortalUtil.getPortalURL(request);

            List<Resource> resources = getByResourceCodeLatestApproved(resourceCode, channelId);
            if (resources.isEmpty()) {
                return resourceResult;
            } else {
                Resource resource = resources.get(0);

                DynamicQuery resourceLocalizedDynamicQuery = DynamicQueryFactoryUtil.forClass(ResourceLocalization.class, getClassLoader());
                resourceLocalizedDynamicQuery.add(PropertyFactoryUtil.forName("languageId").eq(language));
                resourceLocalizedDynamicQuery.add(PropertyFactoryUtil.forName("resourceId").eq(resource.getResourceId()));
                List<ResourceLocalization> resourcesLocalized = ResourceLocalServiceUtil.dynamicQuery(resourceLocalizedDynamicQuery);

                if (resourcesLocalized.isEmpty()) {
                    return resourceResult;
                } else {
                    resourceData.put("name", resourcesLocalized.get(0).getName());
                    attachObject.put("attachValue", portalURL + resourcesLocalized.get(0).getAttach());
                    resourceData.put("attach", attachObject);
                    resourceData.put("descrpition", resourcesLocalized.get(0).getDescription());
                    resourceData.put("routeId", resourcesLocalized.get(0).getRouteId());
                    resourceData.put("url", resourcesLocalized.get(0).getUrl());
                }
                resourceResult.put("resourceType", resource.getResourceType());
                if (resource.getResourceType().equals("1"))
                    resourceResult.put("resourceSubType", resource.getUrlType());
                else {
                    resourceResult.put("resourceSubType", "");
                }
                resourceResult.put("resourceData", resourceData);
            }
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return resourceResult;
    }

    public List<Resource> searchResourceService(String searchTerm, Long chn) {
        DynamicQuery resourceDynamicQuery = DynamicQueryFactoryUtil.forClass(Resource.class, getClassLoader());
        resourceDynamicQuery.add(
                RestrictionsFactoryUtil.or(PropertyFactoryUtil.forName("resourceCode").like("%" + searchTerm + "%"),
                        PropertyFactoryUtil.forName("resourceType").like("%" + searchTerm + "%")));
        List<Resource> resources = ResourceLocalServiceUtil.dynamicQuery(resourceDynamicQuery);
        if (resources.isEmpty()) {
            System.out.println("Invalid Data for searrch ... there is no resource for search");
        }
        try {
            return resources;
        } catch (Exception e) {
            System.out.println("Error retrieving data: " + e.getMessage());
            return Collections.emptyList();
        }

    }

    public List<Resource> searchResourceByType(String resourceType, long channelId) {
        String resourceCodeNum = "";
        if (resourceType == null || resourceType.isEmpty())
            return resourcePersistence.findByChannelId(channelId);
        if ("url".contains(resourceType.toLowerCase()))
            resourceCodeNum = "1";
        else if ("attachment".contains(resourceType.toLowerCase()))
            resourceCodeNum = "2";
        else if ("terms and conditions".contains(resourceType.toLowerCase()))
            resourceCodeNum = "3";
        return resourcePersistence.findByResourceType(resourceCodeNum, channelId);
    }

    public List<Resource> getbyChannelId(Long channelId) {
        if (channelId == null) {
            System.out.println("channelId is null.");
            return Collections.emptyList();
        }
        try {
            return resourcePersistence.findByChannelId(channelId);
        } catch (Exception e) {
            System.out.println("Error retrieving data: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public List<Resource> getByResourceCode(String resourceCode, long channelId) {
        return resourcePersistence.findByResourceCode(resourceCode, channelId);
    }

    public List<Resource> getByResourceCodeLatestApproved(String resourceCode, long channelId) {
        DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Resource.class, getClassLoader());
        dq.add(RestrictionsFactoryUtil.eq("resourceCode", resourceCode));
        dq.add(RestrictionsFactoryUtil.eq("channelId", channelId));
        dq.add(RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_APPROVED));
        dq.addOrder(OrderFactoryUtil.asc("entityResourceId"));
        dq.addOrder(OrderFactoryUtil.desc("version"));

        List<Resource> allApproved = resourcePersistence.findWithDynamicQuery(dq);
        Map<Long, Resource> latestByResource = new LinkedHashMap<>();
        for (Resource resource : allApproved) {
            if (!latestByResource.containsKey(resource.getEntityResourceId())) {
                latestByResource.put(resource.getEntityResourceId(), resource);
            }
        }
        return new ArrayList<>(latestByResource.values());
    }

    public List<Resource> getByResourceCodeByName(String resourceName) throws NoSuchResourceException {
        List<ResourceLocalization> localizations;
        List<Resource> resources = new ArrayList<>();
        try {
            String likeSearchName = "%" + resourceName + "%";

            localizations = ResourceLocalizationUtil.findBynameAndLanguageId("English", likeSearchName);
            for (ResourceLocalization localization : localizations) {
                resources.add(ResourceUtil.findByPrimaryKey(localization.getResourceId()));
            }
        } catch (SystemException e) {
            // Handle exception
        }
        return resources;
    }

    public void deleteResourceLocalized(Long resourceId, Long channelId) {
        for (Languages language : languagesLocalService.getbyChannelId(channelId)) {
            String languageId = language.getLangName();
            try {
                resourceLocalizationPersistence.removeByResourceId_LanguageId(resourceId, languageId);
            } catch (NoSuchResourceLocalizationException e) {
                LOG.warn("No localization for resource " + resourceId + " and language " + languageId);
            }
        }
    }

    public void resourceDelete(Long resourceId, ServiceContext serviceContext, User user) throws Exception {
        try {
            Resource originalResource = resourceLocalService.getResource(resourceId);

            if (hasPendingDraft(originalResource.getEntityResourceId())) {
                throw new Exception("This Resource is currently locked because there is a pending change awaiting approval.");
            }

            // Create a draft copy for the workflow
            Resource draftResource = this.resourcePersistence.create(CounterLocalServiceUtil.increment());
            draftResource.setResourceCode(originalResource.getResourceCode());
            draftResource.setResourceType(originalResource.getResourceType());
            draftResource.setUrlType(originalResource.getUrlType());
            draftResource.setDefaultLanguageId(originalResource.getDefaultLanguageId());
            draftResource.setChannelId(originalResource.getChannelId());
            draftResource.setFeatureId(originalResource.getFeatureId());
            draftResource.setEntityResourceId(originalResource.getEntityResourceId());
            draftResource.setVersion(getMaxVersion(originalResource.getEntityResourceId()) + 1);

            startWorkflow(draftResource, serviceContext, user, resourceId, Constants.DELETE);
        } catch (Exception e) {
            LOG.error("Resource Delete Failed: " + e.getMessage());
            throw new Exception(e);
        }
    }

    public Resource updateStatus(long userId, long resourceId, int status,
                                 ServiceContext serviceContext) throws PortalException, SystemException {
        Resource resource = resourcePersistence.findByPrimaryKey(resourceId);

        resource.setStatusByUserId(userId);
        if (userId > 0) {
            resource.setStatusByUserName(UserLocalServiceUtil.getUser(userId).getFullName());
        }
        resource.setStatusDate(new Date());
        resource.setModifiedDate(new Date());
        resource = resourcePersistence.update(resource);

        if (status == WorkflowConstants.STATUS_APPROVED) {
            String workflowAction = resource.getWorkflowAction();

            // User Story 5 - Global Component Versioning. Only an approved
            // change bumps the internal version; draft / pending / rejected /
            // cancelled changes never reach this point.
            bumpGlobalVersion(resource);

            if (Constants.DELETE.equalsIgnoreCase(workflowAction)) {
                long entityResourceId = resource.getEntityResourceId();
                deleteBlueAppAttachments(resource);
                deleteAllByEntityResourceId(entityResourceId);
                LOG.info("All Resource versions deleted for entityResourceId: " + entityResourceId);
                return resource;
            }

            if (Constants.UPDATE.equalsIgnoreCase(workflowAction) ||
                    (Constants.IMPORT + "_" + Constants.UPDATE).equalsIgnoreCase(workflowAction)) {
                resource.setStatus(status);
                resourcePersistence.update(resource);
                LOG.info("Resource updated and approved: " + resource.getResourceCode());
                return resource;
            }

            if (Constants.ADD.equalsIgnoreCase(workflowAction) ||
                    (Constants.IMPORT + "_" + Constants.ADD).equalsIgnoreCase(workflowAction)) {
                resource.setStatus(status);
                resourcePersistence.update(resource);
                LOG.info("Resource created and approved: " + resource.getResourceCode());
                return resource;
            }

            return resource;
        }

        if (status == WorkflowConstants.STATUS_DENIED || status == WorkflowConstants.STATUS_EXPIRED) {
            resource.setStatus(status);
            resourcePersistence.update(resource);
            LOG.info("Resource rejected/expired: " + resource.getResourceCode());
        }

        return resource;
    }

    /**
     * User Story 5 - Global Component Versioning.
     *
     * <p>
     * An approved change to the Resource component (add / update / delete)
     * bumps the internal version for this company/channel. Runs in the same
     * transaction as the approval so both succeed or roll back together.
     * </p>
     */
    /**
     * Feature PKs change on every edit, so Resource.featureId stores the STABLE
     * entityResourceId of the feature instead. Idempotent: resolving an already
     * stable id returns itself.
     */
    private long toStableFeatureId(long featureId) {
        com.ejada.telemony.db.model.Feature feature =
                com.ejada.telemony.db.service.FeatureLocalServiceUtil.fetchFeature(featureId);

        if (feature == null) {
            return featureId;
        }

        return feature.getEntityResourceId();
    }

    private void bumpGlobalVersion(Resource resource) {
        GlobalVersionLocalServiceUtil.incrementApprovedVersion(
                resource.getCompanyId(),
                resource.getChannelId(),
                resolveComponentName(resource.getChannelId()));
    }

    /**
     * Blue App resources are the assets returned by the Asset Management API,
     * so their approved changes bump ASSET_MANAGEMENT. Every other channel
     * keeps bumping RESOURCE.
     */
    private String resolveComponentName(long channelId) {
        try {
            Channels channel = ChannelsLocalServiceUtil.fetchChannels(channelId);

            if ((channel != null) && BLUE_APP_CHANNEL_NAME.equals(channel.getName())) {
                return ComponentType.ASSET_MANAGEMENT.name();
            }
        } catch (Exception e) {
            LOG.error("Unable to resolve the channel name for channel " + channelId, e);
        }

        return ComponentType.RESOURCE.name();
    }

    /**
     * Blue App assets exist only for their resource, so an approved delete also
     * removes the uploaded files from Documents and Media. Other channels keep
     * the previous behaviour and leave their files in place.
     */
    private void deleteBlueAppAttachments(Resource resource) {
        String componentName = resolveComponentName(resource.getChannelId());

        LOG.info("Blue App attachment cleanup for channel " + resource.getChannelId()
                + " resolved the component " + componentName);

        if (!ComponentType.ASSET_MANAGEMENT.name().equals(componentName)) {
            return;
        }

        try {
            DynamicQuery query = DynamicQueryFactoryUtil.forClass(Resource.class, getClassLoader());
            query.add(RestrictionsFactoryUtil.eq("entityResourceId", resource.getEntityResourceId()));

            List<Resource> versions = resourceLocalService.dynamicQuery(query);

            for (Resource version : versions) {
                List<ResourceLocalization> localizations =
                        resourceLocalizationPersistence.findByResourceId(version.getResourceId());

                for (ResourceLocalization localization : localizations) {
                    deleteAttachment(localization);
                }
            }
        } catch (Exception e) {
            LOG.error("Unable to delete the Blue App attachments of resource "
                    + resource.getResourceId(), e);
        }
    }

    /**
     * The stored attach value is "/documents/{groupId}/{folderId}/{title}/", so
     * the file entry is located with the group and the folder it was uploaded
     * to.
     */
    private void deleteAttachment(ResourceLocalization localization) {
        String attach = localization.getAttach();
        String attachName = localization.getAttachName();

        if (attach == null || attach.isEmpty()) {
            return;
        }

        // ["", "documents", groupId, folderId, title]
        String[] parts = attach.split("/");

        if (parts.length < 5) {
            LOG.warn("Unexpected attach value, skipping deletion: " + attach);
            return;
        }

        long groupId;
        long folderId;

        try {
            groupId = Long.parseLong(parts[2]);
            folderId = Long.parseLong(parts[3]);
        } catch (NumberFormatException e) {
            LOG.warn("Unable to read the group and folder from " + attach);
            return;
        }

        // The URL keeps the title with '+' instead of spaces, so several
        // spellings are tried before giving up.
        List<String> titles = new ArrayList<>();

        if (attachName != null && !attachName.isEmpty()) {
            titles.add(attachName);
        }
        titles.add(parts[4]);
        titles.add(parts[4].replace('+', ' '));

        for (String title : titles) {
            try {
                FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(groupId, folderId, title);

                DLAppLocalServiceUtil.deleteFileEntry(fileEntry.getFileEntryId());

                LOG.info("Deleted the Blue App attachment '" + title + "' from folder " + folderId);

                return;
            } catch (Exception e) {
                // Try the next spelling.
            }
        }

        LOG.error("Unable to delete the Blue App attachment of " + attach
                + ". Tried the titles " + titles + " in group " + groupId
                + " and folder " + folderId);
    }

    private void startWorkflow(Resource resource, ServiceContext serviceContext, User user, Long id, String type) throws PortalException {
        resource = enrichWorkflow(resource, serviceContext, user, id, type, null);

        serviceContext.setAttribute(Constants.ENTITY_TYPE, Constants.RESOURCE);
        serviceContext.setAttribute(Constants.USER_NAME, user.getFullName());
        serviceContext.setAttribute(Constants.REQUEST_ID, resource.getResourceId());

        if (serviceContext.getScopeGroupId() <= 0) {
            serviceContext.setScopeGroupId(
                    GroupLocalServiceUtil.getCompanyGroup(
                            serviceContext.getCompanyId()
                    ).getGroupId()
            );
        }
        AssetEntryLocalServiceUtil.updateEntry(
                serviceContext.getUserId(),
                serviceContext.getScopeGroupId(),
                Resource.class.getName(),
                resource.getResourceId(),
                serviceContext.getAssetCategoryIds(),
                serviceContext.getAssetTagNames()
        );

        serviceContext.setAssetCategoryIds(null);
        serviceContext.setAssetTagNames(null);

        WorkflowHandlerRegistryUtil.startWorkflowInstance(
                serviceContext.getCompanyId(),
                serviceContext.getUserId(),
                Resource.class.getName(),
                resource.getPrimaryKey(),
                resource,
                serviceContext
        );
    }

    private Resource enrichWorkflow(Resource resource, ServiceContext serviceContext, User user, Long id, String type, ImportRequest importRequest) {
        if (serviceContext != null) {
            resource.setGroupId(serviceContext.getScopeGroupId());
            resource.setCompanyId(serviceContext.getCompanyId());
            resource.setUserId(serviceContext.getUserId());
            resource.setUserName(user.getFullName());
        } else {
            resource.setGroupId(importRequest.getGroupId());
            resource.setCompanyId(importRequest.getCompanyId());
            resource.setUserId(importRequest.getUserId());
            resource.setUserName(importRequest.getUserName());
        }

        if (resource.getCreateDate() == null) {
            resource.setCreateDate(new Date());
        }
        resource.setModifiedDate(new Date());

        if (resource.getUuid_() == null || resource.getUuid_().isEmpty()) {
            resource.setUuid_(PortalUUIDUtil.generate());
        }

        resource.setOriginalEntityId(id);
        resource.setStatus(WorkflowConstants.STATUS_DRAFT);
        resource.setStatusDate(new Date());

        if (Constants.ADD.equals(type) || Constants.CREATE.equals(type)) {
            resource.setWorkflowAction(Constants.ADD);
        } else if (Constants.UPDATE.equals(type)) {
            resource.setWorkflowAction(Constants.UPDATE);
        } else if (Constants.DELETE.equals(type)) {
            resource.setWorkflowAction(Constants.DELETE);
        } else {
            resource.setWorkflowAction(type);
        }

        resource = ResourceLocalServiceUtil.updateResource(resource);
        return resource;
    }

    private int getMaxVersion(long entityResourceId) {
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(Resource.class, getClassLoader());
        query.add(RestrictionsFactoryUtil.eq("entityResourceId", entityResourceId));
        query.setProjection(ProjectionFactoryUtil.max("version"));
        List<Integer> results = resourceLocalService.dynamicQuery(query);
        if (results != null && !results.isEmpty() && results.get(0) != null) {
            return results.get(0);
        }
        return 0;
    }

    public List<Resource> getLatestApprovedByChannelId(long channelId) {
        DynamicQuery dq = dynamicQuery();
        dq.add(RestrictionsFactoryUtil.eq("channelId", channelId));
        dq.add(RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_APPROVED));
        dq.addOrder(OrderFactoryUtil.asc("entityResourceId"));
        dq.addOrder(OrderFactoryUtil.desc("version"));

        List<Resource> allApproved = resourcePersistence.findWithDynamicQuery(dq);

        Map<Long, Resource> latestByResource = new LinkedHashMap<>();
        for (Resource resource : allApproved) {
            if (!latestByResource.containsKey(resource.getEntityResourceId())) {
                latestByResource.put(resource.getEntityResourceId(), resource);
            }
        }
        return new ArrayList<>(latestByResource.values());
    }

    public Map<Resource, Boolean> getLatestApprovedByChannelIdWithPending(long channelId) {
        List<Resource> latestApproved = getLatestApprovedByChannelId(channelId);
        Map<Resource, Boolean> result = new LinkedHashMap<>();
        for (Resource resource : latestApproved) {
            boolean pending = hasPendingDraft(resource.getEntityResourceId());
            result.put(resource, pending);
        }
        return result;
    }

    public boolean hasPendingDraft(long entityResourceId) {
        try {
            DynamicQuery query = DynamicQueryFactoryUtil.forClass(Resource.class, getClassLoader());
            query.add(RestrictionsFactoryUtil.eq("entityResourceId", entityResourceId));
            query.add(RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_DRAFT));
            List<Resource> versions = resourceLocalService.dynamicQuery(query);
            return !versions.isEmpty();
        } catch (Exception e) {
            LOG.error("Unable to evaluate pending drafts for entityResourceId " + entityResourceId, e);
            return true;
        }
    }

    public List<Resource> searchResourceServiceLatestApproved(String searchTerm, long channelId) {
        DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Resource.class, getClassLoader());
        dq.add(RestrictionsFactoryUtil.eq("channelId", channelId));
        dq.add(RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_APPROVED));
        dq.add(RestrictionsFactoryUtil.or(
                PropertyFactoryUtil.forName("resourceCode").like("%" + searchTerm + "%"),
                PropertyFactoryUtil.forName("resourceType").like("%" + searchTerm + "%")));
        dq.addOrder(OrderFactoryUtil.asc("entityResourceId"));
        dq.addOrder(OrderFactoryUtil.desc("version"));

        List<Resource> allApproved = resourcePersistence.findWithDynamicQuery(dq);
        Map<Long, Resource> latestByResource = new LinkedHashMap<>();
        for (Resource resource : allApproved) {
            if (!latestByResource.containsKey(resource.getEntityResourceId())) {
                latestByResource.put(resource.getEntityResourceId(), resource);
            }
        }
        return new ArrayList<>(latestByResource.values());
    }

    public List<Resource> getByResourceCodeByNameLatestApproved(String resourceName, long channelId) {
        String likeSearchName = "%" + resourceName + "%";
        List<ResourceLocalization> localizations = ResourceLocalizationUtil.findBynameAndLanguageId("English", likeSearchName);

        // Collect matching resourceIds from localizations
        List<Long> matchingIds = new ArrayList<>();
        for (ResourceLocalization loc : localizations) {
            matchingIds.add(loc.getResourceId());
        }
        if (matchingIds.isEmpty()) {
            return Collections.emptyList();
        }

        DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Resource.class, getClassLoader());
        dq.add(PropertyFactoryUtil.forName("resourceId").in(matchingIds));
        dq.add(RestrictionsFactoryUtil.eq("channelId", channelId));
        dq.add(RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_APPROVED));
        dq.addOrder(OrderFactoryUtil.asc("entityResourceId"));
        dq.addOrder(OrderFactoryUtil.desc("version"));

        List<Resource> allApproved = resourcePersistence.findWithDynamicQuery(dq);
        Map<Long, Resource> latestByResource = new LinkedHashMap<>();
        for (Resource resource : allApproved) {
            if (!latestByResource.containsKey(resource.getEntityResourceId())) {
                latestByResource.put(resource.getEntityResourceId(), resource);
            }
        }
        return new ArrayList<>(latestByResource.values());
    }

    public boolean hasApprovedOrDraftVersionByFeature(long featureId, long channelId) {
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(Resource.class, getClassLoader());
        query.add(RestrictionsFactoryUtil.eq("channelId", channelId));
        query.add(RestrictionsFactoryUtil.eq("featureId", toStableFeatureId(featureId)));
        query.add(RestrictionsFactoryUtil.or(
                RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_APPROVED),
                RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_DRAFT)
        ));
        return LocalizationLocalServiceUtil.dynamicQueryCount(query) > 0;
    }

    public List<Resource> searchResourceByTypeLatestApproved(String resourceType, long channelId) {
        if (resourceType == null || resourceType.isEmpty()) {
            return getLatestApprovedByChannelId(channelId);
        }
        String resourceCodeNum = "";
        if ("url".contains(resourceType.toLowerCase()))
            resourceCodeNum = "1";
        else if ("attachment".contains(resourceType.toLowerCase()))
            resourceCodeNum = "2";
        else if ("terms and conditions".contains(resourceType.toLowerCase()))
            resourceCodeNum = "3";

        DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Resource.class, getClassLoader());
        dq.add(RestrictionsFactoryUtil.eq("channelId", channelId));
        dq.add(RestrictionsFactoryUtil.eq("resourceType", resourceCodeNum));
        dq.add(RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_APPROVED));
        dq.addOrder(OrderFactoryUtil.asc("entityResourceId"));
        dq.addOrder(OrderFactoryUtil.desc("version"));

        List<Resource> allApproved = resourcePersistence.findWithDynamicQuery(dq);
        Map<Long, Resource> latestByResource = new LinkedHashMap<>();
        for (Resource resource : allApproved) {
            if (!latestByResource.containsKey(resource.getEntityResourceId())) {
                latestByResource.put(resource.getEntityResourceId(), resource);
            }
        }
        return new ArrayList<>(latestByResource.values());
    }

    private void deleteAllByEntityResourceId(long entityResourceId) {
        try {
            DynamicQuery query = DynamicQueryFactoryUtil.forClass(Resource.class, getClassLoader());
            query.add(RestrictionsFactoryUtil.eq("entityResourceId", entityResourceId));
            List<Resource> resources = resourceLocalService.dynamicQuery(query);
            for (Resource r : resources) {
                // Also delete localizations for this resource
                List<ResourceLocalization> localizations = resourceLocalizationPersistence.findByResourceId(r.getResourceId());
                for (ResourceLocalization loc : localizations) {
                    resourceLocalizationPersistence.remove(loc);
                }
                resourcePersistence.remove(r);
            }
        } catch (Exception e) {
            LOG.error("Unable to delete resources for entityResourceId " + entityResourceId, e);
            throw new RuntimeException("Failed to delete resources for entityResourceId " + entityResourceId, e);
        }
    }

    public void importResources(ImportRequest importRequest, JSONArray jsonArray) {
        try {
            Map<String, byte[]> attachmentFiles = new HashMap<>();
            String filePath = importRequest.getFilePath();
            if (filePath != null && !filePath.isEmpty()) {
                Path zipFilePath = java.nio.file.Paths.get(filePath);
                if (java.nio.file.Files.exists(zipFilePath)) {
                    attachmentFiles = ExportFileUtil.readAttachmentsFromZip(zipFilePath);
                    LOG.info("Loaded " + attachmentFiles.size() + " attachment files from ZIP");
                }
            }

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject entryJson = jsonArray.getJSONObject(i);
                String action = entryJson.getString("action");
                long channelId = entryJson.getLong("channelId");
                long affectedEntityId = entryJson.getLong("affectedEntityId", 0L);

                ResourceImportDTO resourceImportDTO = parseResource(entryJson);
                ResourceImportDTO.ResourceData data = resourceImportDTO.getData();

                User user = UserLocalServiceUtil.getUser(importRequest.getUserId());

                // For attachment-type resources, upload files to DL and update paths
                if ("2".equals(data.getResourceType()) && !attachmentFiles.isEmpty()) {
                    uploadAttachmentsFromZip(data, attachmentFiles, user, importRequest);
                }

                if ("add".equals(action)) {
                    List<Resource> result = getByResourceCodeLatestApproved(data.getResourceCode(), channelId);
                    if (result != null && !result.isEmpty())
                        throw new Exception("The resource code " + data.getResourceCode() + " already exists");
                    try {
                        importResourceAdd(importRequest, data, channelId, user);
                    } catch (Exception e) {
                        LOG.error("Failed to add resource from import at index " + i, e);
                    }
                } else if ("update".equals(action)) {
                    try {
                        importResourceUpdate(affectedEntityId, importRequest, data, channelId, user);
                    } catch (Exception e) {
                        LOG.error("Failed to update resource from import at index " + i, e);
                    }
                } else {
                    LOG.warn("Unknown action for resource import: " + action);
                }
            }
        } catch (Exception e) {
            LOG.error("Failed to import resources", e);
        }
    }

    private void uploadAttachmentsFromZip(ResourceImportDTO.ResourceData data,
                                          Map<String, byte[]> attachmentFiles, User user, ImportRequest importRequest) {
        if (data.getLocalizations() == null) {
            return;
        }

        try {
            long groupId = importRequest.getGroupId();
            if (groupId <= 0) {
                // Fallback to company group if site group is not set
                groupId = GroupLocalServiceUtil.getCompanyGroup(user.getCompanyId()).getGroupId();
                LOG.warn("ImportRequest groupId was 0, falling back to company group: " + groupId);
            }

            ServiceContext serviceContext = new com.liferay.portal.kernel.service.ServiceContext();
            serviceContext.setUserId(user.getUserId());
            serviceContext.setCompanyId(user.getCompanyId());
            serviceContext.setScopeGroupId(groupId);
            serviceContext.setAddGroupPermissions(true);
            serviceContext.setAddGuestPermissions(true);

            for (Map.Entry<String, ResourceImportDTO.LocalizationData> entry : data.getLocalizations().entrySet()) {
                String languageId = entry.getKey();
                ResourceImportDTO.LocalizationData loc = entry.getValue();

                if (loc.getAttachName() == null || loc.getAttachName().isEmpty()) {
                    continue;
                }
                String zipEntryPath = "attachments/" + data.getResourceCode() + "/" + languageId + "/" + loc.getAttachName();
                byte[] fileBytes = attachmentFiles.get(zipEntryPath);

                if (fileBytes == null) {
                    LOG.warn("Attachment file not found in ZIP: " + zipEntryPath);
                    continue;
                }
                String folderName = languageId + "attachFile";
                String sourceFileName = loc.getAttachName();

                try {
                    Folder folder;
                    try {
                        folder = dlAppLocalService.getFolder(groupId,
                                DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, folderName);
                    } catch (Exception e) {
                        folder = dlAppLocalService.addFolder("", groupId,
                                DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
                                folderName, "", serviceContext);
                    }

                    File tempFile = createTempFile("import_attach_", "_" + sourceFileName);
                    Files.write(tempFile.toPath(), fileBytes);

                    FileEntry fileEntry;
                    try {
                        fileEntry = dlAppLocalService.getFileEntry(groupId, folder.getFolderId(), sourceFileName);
                        dlAppLocalService.updateFileEntry(fileEntry.getFileEntryId(), sourceFileName,
                                "", sourceFileName, "", "", "",
                                DLVersionNumberIncrease.MINOR,
                                tempFile, null, null, serviceContext);
                    } catch (Exception e) {
                        fileEntry = dlAppLocalService.addFileEntry(groupId, folder.getFolderId(),
                                sourceFileName, "", sourceFileName, "", "", tempFile, serviceContext);
                    }

                    String attachURL = "/documents/" + groupId
                            + "/" + folder.getFolderId() + "/"
                            + StringUtil.replace(fileEntry.getTitle(), ' ', '+') + "/";

                    loc.setAttach(attachURL);

                    tempFile.delete();
                } catch (Exception e) {
                    LOG.error("Failed to upload attachment for resource " + data.getResourceCode()
                            + ", language " + languageId, e);
                }
            }
        } catch (Exception e) {
            LOG.error("Error uploading attachments from ZIP for resource " + data.getResourceCode(), e);
        }
    }

    private ResourceImportDTO parseResource(JSONObject entryJson) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(entryJson.toString(), ResourceImportDTO.class);
    }

    private Resource createResourceEntity(Long resourceId, String resourceCode, String resourceType, String urlType, Map<String, String> nameValues,
                                          Map<String, String> attachValues, Map<String, String> attachfilesName,
                                          Map<String, String> descriptionValues, Map<String, String> routeIdValues, Map<String, String> urlValues,
                                          Long channelId, long featureId, ServiceContext serviceContext, User user) {
        if (resourceCode == null || resourceType == null || urlType == null || nameValues.isEmpty()
                || channelId == null) {
            System.out.println("Invalid input: Null values detected.");
            throw new IllegalArgumentException("Required fields are missing or empty.");
        }

        Resource originalResource = null;
        Resource resourceLocal = this.resourcePersistence.create(counterLocalService.increment());

        // Blue App resources are created without a user supplied code: the
        // generated resource id is used as the resource code by default.
        if (resourceCode.trim().isEmpty()) {
            resourceCode = String.valueOf(resourceLocal.getResourceId());
        }

        if (!resourceId.equals(0L)) {
            originalResource = this.resourcePersistence.fetchByPrimaryKey(resourceId);
            if (!originalResource.getResourceCode().equals(resourceCode)) {
                throw new IllegalArgumentException("Resource code cannot be changed for existing resources.");
            }
        }
        resourceLocal.setResourceCode(resourceCode);
        resourceLocal.setResourceType(resourceType);
        resourceLocal.setUrlType(urlType);
        resourceLocal.setDefaultLanguageId(TelemoneyConstants.LANGUAGE_ENGLISH_NAME);
        resourceLocal.setChannelId(channelId);
        resourceLocal.setFeatureId(toStableFeatureId(featureId));
        if (!resourceId.equals(0L) && originalResource != null) {
            resourceLocal.setEntityResourceId(originalResource.getEntityResourceId());
            resourceLocal.setVersion(getMaxVersion(originalResource.getEntityResourceId()) + 1);
        } else {
            resourceLocal.setEntityResourceId(resourceLocal.getResourceId());
            resourceLocal.setVersion(getMaxVersion(resourceLocal.getEntityResourceId()) + 1);
        }

        this.resourcePersistence.update(resourceLocal);

        // Only the latest approved language versions of the channel must be
        // localized: getbyChannelId returns every row of the Languages table
        // (drafts, rejected and superseded versions included) which produced
        // duplicated and stale localizations.
        for (Languages language : languagesLocalService.getLatestApprovedByChannelId(channelId)) {

            String languageId = language.getLangName();

            ResourceLocalization resourceLocalized = resourceLocalizationPersistence
                    .create(counterLocalService.increment());
            resourceLocalized.setResourceId(resourceLocal.getResourceId());
            resourceLocalized.setLanguageId(languageId);

            if (resourceLocal.getResourceType().equals("1")) {
                resourceLocalized.setName(nameValues.get(languageId));
                if (resourceLocal.getUrlType().equals("1")) {
                    resourceLocalized.setRouteId(routeIdValues.get(languageId));
                } else {
                    resourceLocalized.setUrl(urlValues.get(languageId));

                }
            } else if (resourceLocal.getResourceType().equals("2")) {
                resourceLocalized.setName(nameValues.get(languageId));
                if (!resourceId.equals(0L) && attachValues.get(languageId) == null) {
                    ResourceLocalization origLoc = resourceLocalizationPersistence
                            .fetchByResourceId_LanguageId(resourceId, languageId);
                    if (origLoc != null) {
                        resourceLocalized.setAttach(origLoc.getAttach());
                        resourceLocalized.setAttachName(origLoc.getAttachName());
                    }
                } else {
                    resourceLocalized.setAttachName(attachfilesName.get(languageId));
                    resourceLocalized.setAttach(attachValues.get(languageId));
                }


            } else {
                resourceLocalized.setName(nameValues.get(languageId));
                resourceLocalized.setDescription(descriptionValues.get(languageId));
            }

            if (resourceId.equals(0L) && resourceLocalized.getName() == null) {
                throw new IllegalArgumentException("Name for language " + languageId + " is missing.");
            }
            resourceLocalizationPersistence.update(resourceLocalized);
        }
        return resourceLocal;
    }

    private void importResourceAdd(ImportRequest importRequest, ResourceImportDTO.ResourceData data, long channelId, User user) throws Exception {
        Map<String, String> nameValues = new HashMap<>();
        Map<String, String> attachValues = new HashMap<>();
        Map<String, String> attachfilesName = new HashMap<>();
        Map<String, String> descriptionValues = new HashMap<>();
        Map<String, String> routeIdValues = new HashMap<>();
        Map<String, String> urlValues = new HashMap<>();
        extractLocalizationMaps(data, nameValues, attachValues, attachfilesName, descriptionValues, routeIdValues, urlValues);

        Resource resource = createResourceEntity(0L, data.getResourceCode(), data.getResourceType(), data.getUrlType(), nameValues,
                attachValues, attachfilesName, descriptionValues, routeIdValues,
                urlValues, channelId, data.getSelectedFeatureId(), null, user);
        enrichWorkflow(resource, null, user, 0L, Constants.IMPORT + "_" + Constants.ADD, importRequest);
        updateStatus(user.getUserId(), resource.getResourceId(), WorkflowConstants.STATUS_APPROVED, null);

    }

    private void importResourceUpdate(long affectedEntityId, ImportRequest importRequest, ResourceImportDTO.ResourceData data, long channelId, User user) throws Exception {
        Map<String, String> nameValues = new HashMap<>();
        Map<String, String> attachValues = new HashMap<>();
        Map<String, String> attachfilesName = new HashMap<>();
        Map<String, String> descriptionValues = new HashMap<>();
        Map<String, String> routeIdValues = new HashMap<>();
        Map<String, String> urlValues = new HashMap<>();
        extractLocalizationMaps(data, nameValues, attachValues, attachfilesName, descriptionValues, routeIdValues, urlValues);

        Resource resource = createResourceEntity(affectedEntityId, data.getResourceCode(), data.getResourceType(), data.getUrlType(), nameValues,
                attachValues, attachfilesName, descriptionValues, routeIdValues,
                urlValues, channelId, data.getSelectedFeatureId(), null, user);
        enrichWorkflow(resource, null, user, 0L, Constants.IMPORT + "_" + Constants.UPDATE, importRequest);
        updateStatus(user.getUserId(), resource.getResourceId(), WorkflowConstants.STATUS_APPROVED, null);
    }

    private void extractLocalizationMaps(ResourceImportDTO.ResourceData data,
                                         Map<String, String> nameValues, Map<String, String> attachValues,
                                         Map<String, String> attachfilesName, Map<String, String> descriptionValues,
                                         Map<String, String> routeIdValues, Map<String, String> urlValues) {
        if (data.getLocalizations() == null) {
            return;
        }
        for (Map.Entry<String, ResourceImportDTO.LocalizationData> entry : data.getLocalizations().entrySet()) {
            String langKey = entry.getKey();
            ResourceImportDTO.LocalizationData loc = entry.getValue();
            if (loc.getName() != null) {
                nameValues.put(langKey, loc.getName());
            }
            if (loc.getAttach() != null) {
                attachValues.put(langKey, loc.getAttach());
            }
            if (loc.getAttachName() != null) {
                attachfilesName.put(langKey, loc.getAttachName());
            }
            if (loc.getDescription() != null) {
                descriptionValues.put(langKey, loc.getDescription());
            }
            if (loc.getRouteId() != null) {
                routeIdValues.put(langKey, loc.getRouteId());
            }
            if (loc.getUrl() != null) {
                urlValues.put(langKey, loc.getUrl());
            }
        }
    }
}
