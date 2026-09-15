/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ConfigurationEntity}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConfigurationEntity
 * @generated
 */
public class ConfigurationEntityWrapper
	extends BaseModelWrapper<ConfigurationEntity>
	implements ConfigurationEntity, ModelWrapper<ConfigurationEntity> {

	public ConfigurationEntityWrapper(ConfigurationEntity configurationEntity) {
		super(configurationEntity);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("url", getUrl());
		attributes.put("oldData", getOldData());
		attributes.put("newData", getNewData());
		attributes.put("entityType", getEntityType());
		attributes.put("entityId", getEntityId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("uuid_", getUuid_());
		attributes.put("workflowAction", getWorkflowAction());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		String oldData = (String)attributes.get("oldData");

		if (oldData != null) {
			setOldData(oldData);
		}

		String newData = (String)attributes.get("newData");

		if (newData != null) {
			setNewData(newData);
		}

		String entityType = (String)attributes.get("entityType");

		if (entityType != null) {
			setEntityType(entityType);
		}

		String entityId = (String)attributes.get("entityId");

		if (entityId != null) {
			setEntityId(entityId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		String uuid_ = (String)attributes.get("uuid_");

		if (uuid_ != null) {
			setUuid_(uuid_);
		}

		String workflowAction = (String)attributes.get("workflowAction");

		if (workflowAction != null) {
			setWorkflowAction(workflowAction);
		}
	}

	@Override
	public ConfigurationEntity cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this configuration entity.
	 *
	 * @return the company ID of this configuration entity
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this configuration entity.
	 *
	 * @return the create date of this configuration entity
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the entity ID of this configuration entity.
	 *
	 * @return the entity ID of this configuration entity
	 */
	@Override
	public String getEntityId() {
		return model.getEntityId();
	}

	/**
	 * Returns the entity type of this configuration entity.
	 *
	 * @return the entity type of this configuration entity
	 */
	@Override
	public String getEntityType() {
		return model.getEntityType();
	}

	/**
	 * Returns the group ID of this configuration entity.
	 *
	 * @return the group ID of this configuration entity
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this configuration entity.
	 *
	 * @return the ID of this configuration entity
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the modified date of this configuration entity.
	 *
	 * @return the modified date of this configuration entity
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the new data of this configuration entity.
	 *
	 * @return the new data of this configuration entity
	 */
	@Override
	public String getNewData() {
		return model.getNewData();
	}

	/**
	 * Returns the old data of this configuration entity.
	 *
	 * @return the old data of this configuration entity
	 */
	@Override
	public String getOldData() {
		return model.getOldData();
	}

	/**
	 * Returns the primary key of this configuration entity.
	 *
	 * @return the primary key of this configuration entity
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this configuration entity.
	 *
	 * @return the status of this configuration entity
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this configuration entity.
	 *
	 * @return the status by user ID of this configuration entity
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this configuration entity.
	 *
	 * @return the status by user name of this configuration entity
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this configuration entity.
	 *
	 * @return the status by user uuid of this configuration entity
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this configuration entity.
	 *
	 * @return the status date of this configuration entity
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the url of this configuration entity.
	 *
	 * @return the url of this configuration entity
	 */
	@Override
	public String getUrl() {
		return model.getUrl();
	}

	/**
	 * Returns the user ID of this configuration entity.
	 *
	 * @return the user ID of this configuration entity
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this configuration entity.
	 *
	 * @return the user name of this configuration entity
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this configuration entity.
	 *
	 * @return the user uuid of this configuration entity
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid_ of this configuration entity.
	 *
	 * @return the uuid_ of this configuration entity
	 */
	@Override
	public String getUuid_() {
		return model.getUuid_();
	}

	/**
	 * Returns the workflow action of this configuration entity.
	 *
	 * @return the workflow action of this configuration entity
	 */
	@Override
	public String getWorkflowAction() {
		return model.getWorkflowAction();
	}

	/**
	 * Returns <code>true</code> if this configuration entity is approved.
	 *
	 * @return <code>true</code> if this configuration entity is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this configuration entity is denied.
	 *
	 * @return <code>true</code> if this configuration entity is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this configuration entity is a draft.
	 *
	 * @return <code>true</code> if this configuration entity is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this configuration entity is expired.
	 *
	 * @return <code>true</code> if this configuration entity is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this configuration entity is inactive.
	 *
	 * @return <code>true</code> if this configuration entity is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this configuration entity is incomplete.
	 *
	 * @return <code>true</code> if this configuration entity is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this configuration entity is pending.
	 *
	 * @return <code>true</code> if this configuration entity is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this configuration entity is scheduled.
	 *
	 * @return <code>true</code> if this configuration entity is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this configuration entity.
	 *
	 * @param companyId the company ID of this configuration entity
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this configuration entity.
	 *
	 * @param createDate the create date of this configuration entity
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the entity ID of this configuration entity.
	 *
	 * @param entityId the entity ID of this configuration entity
	 */
	@Override
	public void setEntityId(String entityId) {
		model.setEntityId(entityId);
	}

	/**
	 * Sets the entity type of this configuration entity.
	 *
	 * @param entityType the entity type of this configuration entity
	 */
	@Override
	public void setEntityType(String entityType) {
		model.setEntityType(entityType);
	}

	/**
	 * Sets the group ID of this configuration entity.
	 *
	 * @param groupId the group ID of this configuration entity
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this configuration entity.
	 *
	 * @param id the ID of this configuration entity
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the modified date of this configuration entity.
	 *
	 * @param modifiedDate the modified date of this configuration entity
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the new data of this configuration entity.
	 *
	 * @param newData the new data of this configuration entity
	 */
	@Override
	public void setNewData(String newData) {
		model.setNewData(newData);
	}

	/**
	 * Sets the old data of this configuration entity.
	 *
	 * @param oldData the old data of this configuration entity
	 */
	@Override
	public void setOldData(String oldData) {
		model.setOldData(oldData);
	}

	/**
	 * Sets the primary key of this configuration entity.
	 *
	 * @param primaryKey the primary key of this configuration entity
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this configuration entity.
	 *
	 * @param status the status of this configuration entity
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this configuration entity.
	 *
	 * @param statusByUserId the status by user ID of this configuration entity
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this configuration entity.
	 *
	 * @param statusByUserName the status by user name of this configuration entity
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this configuration entity.
	 *
	 * @param statusByUserUuid the status by user uuid of this configuration entity
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this configuration entity.
	 *
	 * @param statusDate the status date of this configuration entity
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the url of this configuration entity.
	 *
	 * @param url the url of this configuration entity
	 */
	@Override
	public void setUrl(String url) {
		model.setUrl(url);
	}

	/**
	 * Sets the user ID of this configuration entity.
	 *
	 * @param userId the user ID of this configuration entity
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this configuration entity.
	 *
	 * @param userName the user name of this configuration entity
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this configuration entity.
	 *
	 * @param userUuid the user uuid of this configuration entity
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid_ of this configuration entity.
	 *
	 * @param uuid_ the uuid_ of this configuration entity
	 */
	@Override
	public void setUuid_(String uuid_) {
		model.setUuid_(uuid_);
	}

	/**
	 * Sets the workflow action of this configuration entity.
	 *
	 * @param workflowAction the workflow action of this configuration entity
	 */
	@Override
	public void setWorkflowAction(String workflowAction) {
		model.setWorkflowAction(workflowAction);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected ConfigurationEntityWrapper wrap(
		ConfigurationEntity configurationEntity) {

		return new ConfigurationEntityWrapper(configurationEntity);
	}

}