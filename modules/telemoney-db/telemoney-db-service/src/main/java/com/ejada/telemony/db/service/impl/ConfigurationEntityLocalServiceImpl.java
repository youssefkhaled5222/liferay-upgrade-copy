/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ejada.telemony.db.service.impl;

import com.ejada.telemony.db.constants.Constants;
import com.ejada.telemony.db.exception.NoSuchConfigurationEntityException;
import com.ejada.telemony.db.model.ConfigurationEntity;
import com.ejada.telemony.db.service.BillerLocalService;
import com.ejada.telemony.db.service.ConfigurationEntityLocalServiceUtil;
import com.ejada.telemony.db.service.base.ConfigurationEntityLocalServiceBaseImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import org.osgi.service.component.annotations.Reference;

import java.io.Serializable;
import java.util.*;

/**
 * The implementation of the configuration entity local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.ejada.telemony.db.service.ConfigurationEntityLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConfigurationEntityLocalServiceBaseImpl
 */
public class ConfigurationEntityLocalServiceImpl
	extends ConfigurationEntityLocalServiceBaseImpl {
	private static final Log LOG = LogFactoryUtil.getLog(ConfigurationEntityLocalServiceImpl.class);



	public void handleConfigurationChange(String url,JSONObject oldData, JSONObject newData,String action,String entityType,String entityId,ServiceContext serviceContext, User user) throws PortalException, JsonProcessingException
	{
		LOG.info("Handling configuration change for entity type: " + entityType + ", action: " + action);
		LOG.info("Old Data: " + oldData);
		LOG.info("New Data: " + newData);
		if (isSame(oldData, newData)) {
			LOG.info("No changes detected. Skipping workflow.");
			return;
		}
		ConfigurationEntity configurationEntity = ConfigurationEntityLocalServiceUtil.createConfigurationEntity(counterLocalService.increment());
		configurationEntity.setEntityType(entityType);
		configurationEntity.setEntityId(entityId);
		configurationEntity.setWorkflowAction(action);
		if (Objects.nonNull(oldData)){
		configurationEntity.setOldData(oldData.toString());
		}
		if (Objects.nonNull(newData)){
		configurationEntity.setNewData(newData.toString());
		}
		configurationEntity.setUrl(url);
		startWorkflow(configurationEntity, serviceContext, user, action, entityType);
	}
	private boolean isSame(JSONObject oldData, JSONObject newData)
			throws JsonProcessingException {

		if (oldData == null && newData == null) return true;
		if (oldData == null || newData == null) return false;

		ObjectMapper mapper = new ObjectMapper();

		JsonNode oldNode = mapper.readTree(oldData.toString());
		JsonNode newNode = mapper.readTree(newData.toString());

		return oldNode.equals(newNode);
	}





	private void startWorkflow(ConfigurationEntity configurationEntity, ServiceContext serviceContext, User user,String type, String entityType) throws PortalException, JsonProcessingException {


		serviceContext.setAttribute(Constants.ENTITY_TYPE, entityType);
		serviceContext.setAttribute(Constants.USER_NAME, user.getFullName());
		serviceContext.setAttribute(Constants.REQUEST_ID, configurationEntity.getId());
		serviceContext.setAttribute(Constants.OPERATION_TYPE, type);


		configurationEntity.setStatus(WorkflowConstants.STATUS_DRAFT);
		configurationEntity.setGroupId(serviceContext.getScopeGroupId());
		configurationEntity.setCompanyId(serviceContext.getCompanyId());
		configurationEntity.setUserId(serviceContext.getUserId());
		configurationEntity.setUserName(user.getFullName());
		configurationEntity.setCreateDate(new Date());
		configurationEntity.setModifiedDate(new Date());
		configurationEntity.setUuid_(PortalUUIDUtil.generate());

		configurationEntityPersistence.update(configurationEntity);

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
				ConfigurationEntity.class.getName(),
				configurationEntity.getId(),
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames()
		);

		serviceContext.setAssetCategoryIds(null);
		serviceContext.setAssetTagNames(null);

		LOG.info("Starting workflow");
		WorkflowHandlerRegistryUtil.startWorkflowInstance(
				serviceContext.getCompanyId(),
				serviceContext.getUserId(),
				ConfigurationEntity.class.getName(),
				configurationEntity.getPrimaryKey(),
				configurationEntity,
				serviceContext
		);
		LOG.info("Workflow started successfully for " +entityType+ " ID: " + configurationEntity.getId());
	}



	public String callService(ConfigurationEntity configurationEntity, ServiceContext serviceContext)
	{

		String entityType = " ";
		try {
			entityType = configurationEntity.getEntityType();

			if (configurationEntity.getEntityType().equals(Constants.BILLER) ||
					configurationEntity.getEntityType().equals(Constants.BILLER_CATEGORY)) {
				billerLocalService.handleApprovedConfigEntity(configurationEntity);
			}
			if (configurationEntity.getEntityType().equals(Constants.MOI_BILLER) ||
					configurationEntity.getEntityType().equals(Constants.MOI_SERVICE) ||
					configurationEntity.getEntityType().equals(Constants.MOI_FIELD)) {
				moiLocalService.handleApprovedConfigEntity(configurationEntity,serviceContext);
			}
			if (configurationEntity.getEntityType().equals(Constants.SMS) ||
					configurationEntity.getEntityType().equals(Constants.UPDATE_SMS_SERVICE_DESC)) {
				smsLocalService.handleApprovedConfigEntity(configurationEntity,serviceContext);
			}
			if (configurationEntity.getEntityType().equals(Constants.ERROR_CODE)) {
				errorCodeLocalService.handleApprovedConfigEntity(configurationEntity,serviceContext);
			}
			if (configurationEntity.getEntityType().equals(Constants.ESB_CONSTANT)) {
				esbLocalService.handleApprovedConfigEntity(configurationEntity,serviceContext);
			}
			if (configurationEntity.getEntityType().equals(Constants.OTP)) {
				otpLocalService.handleApprovedConfigEntity(configurationEntity,serviceContext);
			}
			if (configurationEntity.getEntityType().equals(Constants.IVR)) {
				ivrLocalService.handleApprovedConfigEntity(configurationEntity,serviceContext);
			}
			if (configurationEntity.getEntityType().equals(Constants.CONFIGURATION)) {
				configurationLocalService.handleApprovedConfigEntity(configurationEntity,serviceContext);
			}
		}catch (Exception e) {
			LOG.error("Error while calling service for ConfigurationEntity ID: " + configurationEntity.getId() + " and entity type: " + entityType);
			return "false";
		}
		return "true";
	}

	public ConfigurationEntity updateStatus(long userId, long id, int status,
											ServiceContext serviceContext) throws NoSuchConfigurationEntityException, JSONException {

		try {
			if (status != WorkflowConstants.STATUS_APPROVED && status != WorkflowConstants.STATUS_DENIED
					&& status != WorkflowConstants.STATUS_INCOMPLETE) {
				LOG.info("ConfigurationEntity ID " + id + " is still pending approval");
				return null;
			}
			ConfigurationEntity configurationEntity = configurationEntityPersistence.findByPrimaryKey(id);

			switch (status) {
				case WorkflowConstants.STATUS_APPROVED:
					LOG.info("ConfigurationEntity approved with ID: " + id);
					String result = callService(configurationEntity, serviceContext);
					if (result.equals("false")) {
						status = WorkflowConstants.STATUS_INCOMPLETE;
					}
					break;
				case WorkflowConstants.STATUS_DENIED:
					LOG.info("ConfigurationEntity denied with ID: " + id);
					break;
			}

			configurationEntity.setStatus(status);
			configurationEntity.setStatusByUserId(userId);
			if (serviceContext != null && userId > 0) {
				configurationEntity.setStatusByUserName(UserLocalServiceUtil.getUser(userId).getFullName());
			}
			configurationEntity.setStatusDate(new Date());
			configurationEntityPersistence.update(configurationEntity);
			return configurationEntity;

		} catch (RuntimeException e) {
			LOG.error("Error while updating status for ConfigurationEntity ID: " + id, e);
			throw new RuntimeException(e);
		} catch (PortalException e) {
            throw new RuntimeException(e);
        }

    }
	public Set<String> getPendingEntityIdsByType(String entityType) {
		Set<String> pendingIds = new HashSet<>();

		List<ConfigurationEntity> pendingVersions =
				configurationEntityPersistence.findByentityTypeAndStatus(entityType, 2);

		for (ConfigurationEntity version : pendingVersions) {
			pendingIds.add(version.getEntityId());
		}
		return pendingIds;
	}


}