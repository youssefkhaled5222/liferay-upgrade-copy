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

import com.ejada.telemony.db.constants.ComponentType;
import com.ejada.telemony.db.constants.Constants;
import com.ejada.telemony.db.model.AppVersion;
import com.ejada.telemony.db.service.AppVersionLocalServiceUtil;
import com.ejada.telemony.db.service.GlobalVersionLocalServiceUtil;
import com.ejada.telemony.db.service.base.AppVersionLocalServiceBaseImpl;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.util.*;

/**
 * The implementation of the app version local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.ejada.telemony.db.service.AppVersionLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppVersionLocalServiceBaseImpl
 */
public class AppVersionLocalServiceImpl extends AppVersionLocalServiceBaseImpl {

    private static final Log LOG = LogFactoryUtil.getLog(AppVersionLocalServiceImpl.class);

    public AppVersion addAppVersion(String platform, String versionNumber, Boolean appVersionStatus, String url, Long channelId, ServiceContext serviceContext,User user) {

        if (platform == null) {
            LOG.info("Invalid input: platform is null.");
            throw new BadRequestException("Invalid input: platform is null.");
        }
        if (versionNumber == null) {
            LOG.info("Invalid input: versionNumber is null.");
            throw new BadRequestException("Invalid input: versionNumber is null.");
        }
        if (appVersionStatus == null) {
            LOG.info("Invalid input: status is null.");
            throw new BadRequestException("Invalid input: status is null.");
        }
        if (channelId == null) {
            LOG.info("Invalid input: channelId is null.");
            throw new BadRequestException("Invalid input: channelId is null.");
        }
        if (url == null) {
            LOG.info("Invalid input: url is null.");
            throw new BadRequestException("Invalid input: url is null.");
        }
        
        // Check for existing approved platform on this channel
        DynamicQuery platformCheck = DynamicQueryFactoryUtil.forClass(AppVersion.class, getClassLoader());
        platformCheck.add(RestrictionsFactoryUtil.ilike("platform", platform));
        platformCheck.add(PropertyFactoryUtil.forName("channelId").eq(channelId));
        platformCheck.add(PropertyFactoryUtil.forName("status").eq(WorkflowConstants.STATUS_APPROVED));
        if (!AppVersionLocalServiceUtil.dynamicQuery(platformCheck).isEmpty()) {
            LOG.info("AppVersion Exists");
            throw new NotFoundException("AppVersion Exists");
        }
        
        AppVersion appVersion = createAppVersion(counterLocalService.increment());
        appVersion.setPlatform(platform);
        appVersion.setVersionNumber(versionNumber);
        appVersion.setAppVersionStatus(appVersionStatus);
        appVersion.setUrl(url);
        appVersion.setChannelId(channelId);
        appVersion.setEntityResourceId(appVersion.getVersionId());
        appVersion.setVersion(getMaxVersion(appVersion.getEntityResourceId())+1);
        
        prepareForWorkflow(appVersion, appVersionStatus, serviceContext, user, 0L, Constants.ADD);
        
        AppVersion savedAppVersion = appVersionPersistence.update(appVersion);
        startWorkflow(savedAppVersion, serviceContext, user);
        LOG.info("AppVersion created with ID " + savedAppVersion.getVersionId());
        return savedAppVersion;
    }


    public AppVersion updateAppVersion(Long versionId, String versionNumber, Boolean status, String url, Long channelId, ServiceContext serviceContext) {
        AppVersion original = this.appVersionPersistence.fetchByPrimaryKey(versionId);
        if (original == null) {
            LOG.info("No AppVersion found for version id " + versionId);
            return null;
        }

        // Block edits if there is any pending draft for the same entityResourceId
        if (hasPendingDraft(original.getEntityResourceId())) {
            throw new BadRequestException("This AppVersion is currently locked because there is a pending change awaiting approval.");
        }

        try {
            // create a draft row mirroring persona flow
            AppVersion draft = createAppVersion(counterLocalService.increment());
            draft.setPlatform(original.getPlatform());
            draft.setVersionNumber(versionNumber);
            draft.setAppVersionStatus(status);
            draft.setUrl(url);
            draft.setChannelId(channelId);
            draft.setEntityResourceId(original.getEntityResourceId());
            draft.setVersion(getMaxVersion(original.getEntityResourceId())+1);

            User user = resolveUser(serviceContext);
            
            if (isAppVersionUpdated(original, draft)) {
                prepareForWorkflow(draft, status, serviceContext, user, original.getVersionId(), Constants.UPDATE);
                AppVersion savedDraft = appVersionPersistence.update(draft);
                startWorkflow(savedDraft, serviceContext, user);
                LOG.info("Draft AppVersion created for update of ID " + versionId + " -> draft ID " + savedDraft.getVersionId());
                return savedDraft;
            } else {
                LOG.info("No changes detected for AppVersion ID " + versionId);
                return original;
            }
        } catch (Exception e) {
            LOG.error("Error updating AppVersion with id " + versionId + ": " + e.getMessage());
            return null;
        }
    }

    public void deleteAppVersion(Long versionId, ServiceContext serviceContext, User user) {
        try {
            AppVersion original = this.appVersionPersistence.fetchByPrimaryKey(versionId);
            if (original == null) {
                LOG.info("No AppVersion found for version id " + versionId);
                return;
            }

            // Block edits if there is any pending draft for the same entityResourceId
            if (hasPendingDraft(original.getEntityResourceId())) {
                throw new BadRequestException("This AppVersion is currently locked because there is a pending change awaiting approval.");
            }

            AppVersion draft = createAppVersion(counterLocalService.increment());
            draft.setPlatform(original.getPlatform());
            draft.setVersionNumber(original.getVersionNumber());
            draft.setAppVersionStatus(original.getAppVersionStatus());
            draft.setUrl(original.getUrl());
            draft.setChannelId(original.getChannelId());
            draft.setEntityResourceId(original.getEntityResourceId());
            draft.setVersion(getMaxVersion(original.getEntityResourceId())+1);
            
            prepareForWorkflow(draft, original.getAppVersionStatus(), serviceContext, user, versionId, Constants.DELETE);
            
            AppVersion savedDraft = appVersionPersistence.update(draft);
            startWorkflow(savedDraft, serviceContext, user);
            LOG.info("Draft AppVersion created for delete of ID " + versionId);
            
        } catch (Exception e) {
            LOG.error("Error deleting AppVersion with ID " + versionId + ": " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

//    public List<AppVersion> getbyChannelId(Long channelId) {
//        if (channelId == null) {
//            LOG.info("channelId is null.");
//            return Collections.emptyList();
//        }
//        try {
//            // finder does not include workflow status; filter approved manually
//            List<AppVersion> all = appVersionPersistence.findByChannelId(channelId);
//            List<AppVersion> approved = new java.util.ArrayList<>();
//            for (AppVersion av : all) {
//                if (av.getStatus() == WorkflowConstants.STATUS_APPROVED) {
//                    approved.add(av);
//                }
//            }
//            return approved;
//        } catch (Exception e) {
//            LOG.error("Error retrieving data: " + e.getMessage());
//            return Collections.emptyList();
//        }
//    }

    public JSONObject getAppVersionDetails(Long channelId, String platform) {
        JSONObject appVersionResult = JSONFactoryUtil.createJSONObject();
        try {
            DynamicQuery appVersionDynamicQuery = DynamicQueryFactoryUtil.forClass(AppVersion.class, getClassLoader());
            appVersionDynamicQuery.add(PropertyFactoryUtil.forName("channelId").eq(channelId));
            appVersionDynamicQuery.add(RestrictionsFactoryUtil.ilike("platform",  platform));
            appVersionDynamicQuery.add(PropertyFactoryUtil.forName("status").eq(WorkflowConstants.STATUS_APPROVED));

            List<AppVersion> appVersion = AppVersionLocalServiceUtil.dynamicQuery(appVersionDynamicQuery);
            if (appVersion.isEmpty()) {
                return appVersionResult;
            }
            appVersionResult.put("platform", appVersion.get(0).getPlatform());
            appVersionResult.put("status", appVersion.get(0).getAppVersionStatus());
            appVersionResult.put("url", appVersion.get(0).getUrl());
            appVersionResult.put("versionNumber", appVersion.get(0).getVersionNumber());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return appVersionResult;
    }

    public JSONObject getAppVersionDetailsLatestApproved(Long channelId, String platform) {
        JSONObject appVersionResult = JSONFactoryUtil.createJSONObject();
        try {
            DynamicQuery dq = DynamicQueryFactoryUtil.forClass(AppVersion.class, getClassLoader());
            dq.add(PropertyFactoryUtil.forName("channelId").eq(channelId));
            dq.add(RestrictionsFactoryUtil.ilike("platform", platform));
            dq.add(PropertyFactoryUtil.forName("status").eq(WorkflowConstants.STATUS_APPROVED));
            dq.addOrder(OrderFactoryUtil.asc("entityResourceId"));
            dq.addOrder(OrderFactoryUtil.desc("version"));

            List<AppVersion> allApproved = appVersionPersistence.findWithDynamicQuery(dq);

            // Keep only the latest version per entityResourceId
            Map<Long, AppVersion> latestByResource = new LinkedHashMap<>();
            for (AppVersion av : allApproved) {
                latestByResource.putIfAbsent(av.getEntityResourceId(), av);
            }

            if (latestByResource.isEmpty()) {
                return appVersionResult;
            }

            AppVersion latest = latestByResource.values().iterator().next();
            appVersionResult.put("platform", latest.getPlatform());
            appVersionResult.put("status", latest.getAppVersionStatus());
            appVersionResult.put("url", latest.getUrl());
            appVersionResult.put("versionNumber", latest.getVersionNumber());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return appVersionResult;
    }

    public AppVersion updateStatus(long userId, long versionId, int status,
                                   ServiceContext serviceContext) throws PortalException {
//        if (status != WorkflowConstants.STATUS_APPROVED && status != WorkflowConstants.STATUS_DENIED) {
//            LOG.info("Version ID " + versionId + " is still pending approval");
//            return null;
//        }
        AppVersion draft = appVersionPersistence.findByPrimaryKey(versionId);
        //draft.setStatus(status);
        draft.setStatusByUserId(userId);
        if (serviceContext != null && userId > 0) {

            draft.setStatusByUserName(UserLocalServiceUtil.getUser(userId).getFullName());
        }
        draft.setStatusDate(new Date());
        draft.setModifiedDate(new Date());
        draft = appVersionPersistence.update(draft);

        if (status == WorkflowConstants.STATUS_APPROVED) {


            // operation type is now persisted on the draft row as workflowAction
            String workflowAction = draft.getWorkflowAction();

            //DELETE action
            if (Constants.DELETE.equalsIgnoreCase(workflowAction)) {
                // For approved deletion: remove ALL versions for this entityResourceId
                // (draft + any historical/approved versions)
                long entityResourceId = draft.getEntityResourceId();

                appVersionPersistence.removeByEntityResourceId(entityResourceId);

                incrementGlobalVersion(draft);
                return draft;
            }

            // UPDATE action
            if (Constants.UPDATE.equalsIgnoreCase(workflowAction)) {
               // AppVersion original = appVersionPersistence.fetchByPrimaryKey(draft.getOriginalEntityId());
                //if (original != null) {
//                    original.setVersionNumber(draft.getVersionNumber());
//                    original.setAppVersionStatus(draft.getAppVersionStatus());
//                    original.setUrl(draft.getUrl());
//                    original.setChannelId(draft.getChannelId());
//                    original.setModifiedDate(new Date());
//                    original.setStatus(WorkflowConstants.STATUS_APPROVED);
//                    original.setStatusByUserId(userId);
//                    original.setStatusByUserName(draft.getStatusByUserName());
//                    original.setStatusDate(new Date());
                  //  appVersionPersistence.update(original);
                //}
                draft.setStatus(status);
                appVersionPersistence.update(draft);
                //appVersionPersistence.remove(draft);
                incrementGlobalVersion(draft);
                return draft;
            }
            // ADD action
            if(Constants.ADD.equalsIgnoreCase(workflowAction)) {
                draft.setStatus(status);
                appVersionPersistence.update(draft);
                incrementGlobalVersion(draft);
                return draft;
            }


            return draft;
        }

        if (status == WorkflowConstants.STATUS_DENIED || status == WorkflowConstants.STATUS_EXPIRED) {
             draft.setStatus(status);
             appVersionPersistence.update(draft);
        }

        return draft;
    }

    private User resolveUser(ServiceContext serviceContext) {
        if (serviceContext == null || serviceContext.getUserId() <= 0) {
            return null;
        }
        try {
            return UserLocalServiceUtil.getUser(serviceContext.getUserId());
        } catch (PortalException e) {
            LOG.error("Unable to fetch user for workflow", e);
            return null;
        }
    }

    private void prepareForWorkflow(AppVersion appVersion, Boolean appVersionStatus, ServiceContext serviceContext, User user, Long originalId, String operationType) {
        appVersion.setAppVersionStatus(appVersionStatus);

        // Persist workflow action on the entity (DB column: workflowAction)
        // Allowed values are ADD / UPDATE / DELETE.
        if (Constants.ADD.equals(operationType)) {
            appVersion.setWorkflowAction("ADD");
        } else if (Constants.UPDATE.equals(operationType)) {
            appVersion.setWorkflowAction("UPDATE");
        } else if (Constants.DELETE.equals(operationType)) {
            appVersion.setWorkflowAction("DELETE");
        } else {
            // fallback to ADD to keep behavior consistent for unexpected values
            appVersion.setWorkflowAction("ADD");
        }

        if (serviceContext != null) {
            appVersion.setGroupId(serviceContext.getScopeGroupId());
            appVersion.setCompanyId(serviceContext.getCompanyId());
            appVersion.setUserId(serviceContext.getUserId());
            appVersion.setUserName(user != null ? user.getFullName() : "");
            serviceContext.setAttribute(Constants.ENTITY_TYPE, "AppVersion");
            serviceContext.setAttribute(Constants.USER_NAME, user != null ? user.getFullName() : "");
            serviceContext.setAttribute(Constants.REQUEST_ID, appVersion.getVersionId());
            // NOTE: no longer storing operation type in service context

            if (serviceContext.getScopeGroupId() <= 0) {
                try {
                    serviceContext.setScopeGroupId(
                            GroupLocalServiceUtil.getCompanyGroup(serviceContext.getCompanyId()).getGroupId());
                } catch (PortalException e) {
                    LOG.error("Unable to resolve company group", e);
                }
            }
            
            // Update AssetEntry
            try {
                AssetEntryLocalServiceUtil.updateEntry(
                    serviceContext.getUserId(),
                    serviceContext.getScopeGroupId(),
                    AppVersion.class.getName(),
                    appVersion.getVersionId(),
                    serviceContext.getAssetCategoryIds(),
                    serviceContext.getAssetTagNames()
                );
            } catch (PortalException e) {
                LOG.error("Error updating asset entry", e);
            }
        }
        if (appVersion.getCreateDate() == null) {
            appVersion.setCreateDate(new Date());
        }
        appVersion.setModifiedDate(new Date());
        if (appVersion.getUuid_() == null || appVersion.getUuid_().isEmpty()) {
            appVersion.setUuid_(PortalUUIDUtil.generate());
        }
        appVersion.setOriginalEntityId(originalId);
        appVersion.setStatus(WorkflowConstants.STATUS_DRAFT);

        appVersion.setStatusDate(new Date());
    }

    private void startWorkflow(AppVersion appVersion, ServiceContext serviceContext, User user) {
        if (serviceContext == null || user == null) {
            return;
        }
        try {
            WorkflowHandlerRegistryUtil.startWorkflowInstance(
                    serviceContext.getCompanyId(),
                    serviceContext.getUserId(),
                    AppVersion.class.getName(),
                    appVersion.getVersionId(),
                    appVersion,
                    serviceContext);
        } catch (PortalException e) {
            LOG.error("Failed to start workflow for AppVersion " + appVersion.getVersionId(), e);
        }
    }
    
    private boolean isAppVersionUpdated(AppVersion original, AppVersion draft) {
        if (!Objects.equals(original.getVersionNumber(), draft.getVersionNumber())) return true;
        if (!Objects.equals(original.getAppVersionStatus(), draft.getAppVersionStatus())) return true;
        if (!Objects.equals(original.getUrl(), draft.getUrl())) return true;
        return false;
    }
    private int getMaxVersion(long entityResourceId)
    {
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(AppVersion.class, getClassLoader());
        query.add(RestrictionsFactoryUtil.eq("entityResourceId", entityResourceId));
        query.setProjection(ProjectionFactoryUtil.max("version"));
        List<Integer> results = AppVersionLocalServiceUtil.dynamicQuery(query);
        if (results != null && !results.isEmpty() && results.get(0) != null) {
            return results.get(0);
        }
        return 0;
    }

    public List<AppVersion> getLatestApprovedByChannelId(long channelId) {

        DynamicQuery dq = dynamicQuery();

        dq.add(RestrictionsFactoryUtil.eq("channelId", channelId));
        dq.add(RestrictionsFactoryUtil.eq(
                "status", WorkflowConstants.STATUS_APPROVED));

        dq.addOrder(OrderFactoryUtil.asc("entityResourceId"));
        dq.addOrder(OrderFactoryUtil.desc("version"));
        List<AppVersion> allApproved =
                appVersionPersistence.findWithDynamicQuery(dq);

        // Keep only latest version per resourceId
        Map<Long, AppVersion> latestByResource = new LinkedHashMap<>();

        for (AppVersion appVersion : allApproved) {
            if (!latestByResource.containsKey(appVersion.getEntityResourceId())) {
                latestByResource.put(appVersion.getEntityResourceId(), appVersion);
            }
        }

        return new ArrayList<>(latestByResource.values());
    }

    /**
     * Returns latest APPROVED AppVersion entries for the channel along with a flag indicating whether
     * that AppVersion (entityResourceId) currently has a pending draft awaiting approval.
     *
     * Map key: latest approved AppVersion for an entityResourceId
     * Map value: true if there is any STATUS_DRAFT row for that entityResourceId
     */
    public Map<AppVersion, Boolean> getLatestApprovedByChannelIdWithPending(long channelId) {
        List<AppVersion> latestApproved = getLatestApprovedByChannelId(channelId);

        Map<AppVersion, Boolean> result = new LinkedHashMap<>();

        for (AppVersion appVersion : latestApproved) {
            boolean pending = hasPendingDraft(appVersion.getEntityResourceId());
            result.put(appVersion, pending);
        }

        return result;
    }

    private boolean hasPendingDraft(long entityResourceId) {
        try {
            List<AppVersion> versions = appVersionPersistence.findByEntityResourceId(entityResourceId);

            for (AppVersion v : versions) {
                if (v.getStatus() == WorkflowConstants.STATUS_DRAFT) {
                    return true;
                }
            }

            return false;
        } catch (Exception e) {
            LOG.error("Unable to evaluate pending drafts for entityResourceId " + entityResourceId, e);
            // Fail closed: better to block edits than allow concurrent conflicting drafts.
            return true;
        }
    }

    /**
     * User Story 5 - Global Component Versioning.
     *
     * <p>
     * A change to the AppVersion component (add/update/delete) has been
     * approved, so bump the internal {@code appVersionVersion} version for this
     * company/channel. Runs in the same transaction as the approval so both
     * succeed or roll back together.
     * </p>
     */
    private void incrementGlobalVersion(AppVersion draft) {
        GlobalVersionLocalServiceUtil.incrementApprovedVersion(
                draft.getCompanyId(),
                draft.getChannelId(),
                ComponentType.APP_VERSION.name());
    }


}
