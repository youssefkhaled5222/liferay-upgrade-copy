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

import com.ejada.telemoney.db.dto.importDtos.ImportResultDTO;
import com.ejada.telemony.db.constants.Constants;
import com.ejada.telemony.db.model.Banner;
import com.ejada.telemony.db.model.ImportRequest;
import com.ejada.telemony.db.service.base.ImportRequestLocalServiceBaseImpl;
import com.ejada.telemony.db.service.persistence.ImportRequestUtil;
import com.ejada.telemoney.db.utils.ExportFileUtil;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.ejada.telemony.db.model.Channels;
import com.ejada.telemony.db.model.Themes;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONArray;

import java.nio.file.Path;

import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The implementation of the import request local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.ejada.telemony.db.service.ImportRequestLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImportRequestLocalServiceBaseImpl
 */
public class ImportRequestLocalServiceImpl
        extends ImportRequestLocalServiceBaseImpl {
    private static final Log LOG = LogFactoryUtil.getLog(ImportRequestLocalServiceImpl.class);

    public boolean hasPendingImportRequest(String type) {
        List<ImportRequest> pendingList = importRequestPersistence.findBytypeAndStatus(type, WorkflowConstants.STATUS_DRAFT);
        return !pendingList.isEmpty();
    }




    public void startImportRequestWorkflow(ImportResultDTO importResultDTO, String path, User user, ServiceContext serviceContext) throws PortalException {
        String fileName = Paths.get(path).getFileName().toString();
        ImportRequest importRequest = ImportRequestUtil.create(counterLocalService.increment());
        importRequest.setType(importResultDTO.getMetadata().getComponent().getType());
        importRequest.setFileName(fileName);
        importRequest.setFilePath(path);
        startWorkflow(importRequest, serviceContext, user, Constants.IMPORT_OPERATION);
    }



    public Path buildZip(ImportResultDTO importResultDTO) {
        JSONObject changeLogJson = ExportFileUtil.changeLogToJson(importResultDTO.getChangeLog());
        JSONObject metadataJson = ExportFileUtil.metadataToJson(importResultDTO.getMetadata());
        JSONArray dataJson = ExportFileUtil.componentsToJson(importResultDTO.getComponents());
        byte[] zipFile = ExportFileUtil.buildZipWithAttachments(changeLogJson, metadataJson, dataJson,
                importResultDTO.getAttachmentFiles());

        String componentType = importResultDTO.getMetadata().getComponent().getType();
        String packageId = ExportFileUtil.renameFile(componentType);
        String fileName = packageId + ".zip";

        return ExportFileUtil.saveZipToServer(zipFile, componentType, fileName);

    }

    public ImportRequest updateStatus(long userId, long id, int status, ServiceContext serviceContext) {

        try {
            if (status != WorkflowConstants.STATUS_APPROVED &&
                    status != WorkflowConstants.STATUS_DENIED ) {
                LOG.info("ImportRequest ID " + id + " is still pending approval");
                return null;
            }

            ImportRequest importRequest = importRequestPersistence.findByPrimaryKey(id);

            switch (status) {
                case WorkflowConstants.STATUS_APPROVED:
                    LOG.info("ImportRequest approved with ID: " + id);
                    handleApprovedImportRequest(importRequest);
                    break;

                case WorkflowConstants.STATUS_DENIED:
                    LOG.info("ImportRequest denied with ID: " + id);
                    break;
            }

            importRequest.setStatus(status);
            importRequest.setStatusByUserId(userId);

            if (serviceContext != null && userId > 0) {
                importRequest.setStatusByUserName(
                        UserLocalServiceUtil.getUser(userId).getFullName()
                );
            }
            importRequest.setStatusDate(new Date());
            importRequestPersistence.update(importRequest);

            return importRequest;

        } catch (RuntimeException e) {
            LOG.error("Error while updating status for ImportRequest ID: " + id, e);
            throw new RuntimeException(e);

        } catch (PortalException e) {
            throw new RuntimeException(e);
        }

    }


	private void handleApprovedImportRequest(ImportRequest importRequest)
	{
		Path zipFilePath = Paths.get(importRequest.getFilePath());
		LOG.info("Retrieving zip file for approved ImportRequest ID: " + importRequest.getId() + " from: " + zipFilePath);

		JSONArray dataJson = ExportFileUtil.readDataJsonFromZip(zipFilePath);
		LOG.info("Extracted data.json with " + dataJson.length() + " entries from ImportRequest ID: " + importRequest.getId());

        switch (importRequest.getType()) {
            case Constants.THEMES:
                LOG.info("Processing THEMES entries for ImportRequest ID: " + importRequest.getId());
                themesLocalService.importThemes(importRequest,dataJson);
                break;
            case Constants.BANNER:
                LOG.info("Processing Banner entries for ImportRequest ID: " + importRequest.getId());
                bannerLocalService.importBanners(importRequest,dataJson);
                break;
            case Constants.LOCALIZATION:
                LOG.info("Processing LOCALIZATION entries for ImportRequest ID: " + importRequest.getId());
                localizationLocalService.importLocalization(importRequest,dataJson);
                break;
            case Constants.RESOURCE:
                LOG.info("Processing RESOURCE entries for ImportRequest ID: " + importRequest.getId());
                resourceLocalService.importResources(importRequest, dataJson);
                break;
            default:
                LOG.warn("Unknown component type: " + importRequest.getType() + " for ImportRequest ID: " + importRequest.getId());
        }
	}

    private void startWorkflow(ImportRequest importRequest, ServiceContext serviceContext, User user, String type) throws PortalException {

        serviceContext.setAttribute("entityType", "ImportRequest");
        serviceContext.setAttribute("userName", user.getFullName());
        serviceContext.setAttribute("requestId", importRequest.getId());
        serviceContext.setAttribute(Constants.OPERATION_TYPE, type);


        importRequest.setStatus(WorkflowConstants.STATUS_DRAFT);
        importRequest.setGroupId(serviceContext.getScopeGroupId());
        importRequest.setCompanyId(serviceContext.getCompanyId());
        importRequest.setUserId(serviceContext.getUserId());
        importRequest.setUserName(user.getFullName());
        importRequest.setCreateDate(new Date());
        importRequest.setModifiedDate(new Date());
        importRequest.setUuid_(PortalUUIDUtil.generate());

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
                ImportRequest.class.getName(),
                importRequest.getId(),
                serviceContext.getAssetCategoryIds(),
                serviceContext.getAssetTagNames()
        );

        serviceContext.setAssetCategoryIds(null);
        serviceContext.setAssetTagNames(null);

        importRequestLocalService.updateImportRequest(importRequest);

        WorkflowHandlerRegistryUtil.startWorkflowInstance(
                serviceContext.getCompanyId(),
                serviceContext.getUserId(),
                ImportRequest.class.getName(),
                importRequest.getPrimaryKey(),
                importRequest,
                serviceContext
        );
    }

    /**
     * Reads the zip file for the given ImportRequest, enriches the data by
     * resolving channelId to channel name and entityResourceId to latest approved entity name.
     *
     * @param importRequestId the ID of the ImportRequest
     * @return a map with keys: metadataJson, changeLogJson, enrichedDataJson
     */
    public Map<String, String> getImportRequestViewData(long importRequestId) throws PortalException {
        ImportRequest importRequest = importRequestPersistence.findByPrimaryKey(importRequestId);
        Path zipFilePath = Paths.get(importRequest.getFilePath());

        JSONObject metadataJson = ExportFileUtil.readMetadataJsonFromZip(zipFilePath);
        JSONObject changeLogJson = ExportFileUtil.readChangeLogJsonFromZip(zipFilePath);
        JSONArray dataJson = ExportFileUtil.readDataJsonFromZip(zipFilePath);

        JSONArray enrichedData = enrichDataJson(dataJson, importRequest.getType());

        Map<String, String> result = new HashMap<>();
        result.put("metadataJson", metadataJson.toString(2));
        result.put("changeLogJson", changeLogJson.toString(2));
        result.put("enrichedDataJson", enrichedData.toString(2));

        return result;
    }

    private JSONArray enrichDataJson(JSONArray dataJson, String type) throws JSONException {
        JSONArray enriched = JSONFactoryUtil.createJSONArray();

        for (int i = 0; i < dataJson.length(); i++) {
            JSONObject entry = dataJson.getJSONObject(i);
            JSONObject enrichedEntry = JSONFactoryUtil.createJSONObject(entry.toString());

            // Resolve channel name
            long channelId = entry.getLong("channelId", 0);
            if (channelId > 0) {
                String channelName = resolveChannelName(channelId);
                enrichedEntry.put("channelName", channelName);
                enrichedEntry.remove("channelId");
            }


            // Resolve affectedEntityId to entity name
            long affectedEntityId = entry.getLong("affectedEntityId", 0);
            if (affectedEntityId > 0) {
                String affectedEntityName = resolveAffectedEntityName(affectedEntityId, type);
                enrichedEntry.put("affectedEntityName", affectedEntityName);
            }
            enrichedEntry.remove("affectedEntityId");

            enriched.put(enrichedEntry);
        }

        return enriched;
    }

    private String resolveChannelName(long channelId) {
        try {
            Channels channel = channelsLocalService.getChannels(channelId);
            return channel.getName();
        } catch (Exception e) {
            LOG.warn("Could not resolve channel name for ID: " + channelId, e);
            return String.valueOf(channelId);
        }
    }


    private String resolveAffectedEntityName(long affectedEntityId, String type) {
        try {
            switch (type) {
                case Constants.THEMES:
                    Themes theme = themesLocalService.getThemes(affectedEntityId);
                    if (theme != null) {
                        return theme.getThemeEnName();
                    }
                    break;
                case Constants.BANNER:
                    Banner banner = bannerLocalService.getBanner(affectedEntityId);
                    if (banner != null) {
                        return banner.getBannerName();
                    }
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            LOG.warn("Could not resolve affected entity name for ID: " + affectedEntityId + " type: " + type, e);
        }
        return String.valueOf(affectedEntityId);
    }

}