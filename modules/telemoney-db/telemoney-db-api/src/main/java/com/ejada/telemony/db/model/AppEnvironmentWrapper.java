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
 * This class is a wrapper for {@link AppEnvironment}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppEnvironment
 * @generated
 */
public class AppEnvironmentWrapper
	extends BaseModelWrapper<AppEnvironment>
	implements AppEnvironment, ModelWrapper<AppEnvironment> {

	public AppEnvironmentWrapper(AppEnvironment appEnvironment) {
		super(appEnvironment);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("environmentId", getEnvironmentId());
		attributes.put("channelId", getChannelId());
		attributes.put("environmentName", getEnvironmentName());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("status", getStatus());
		attributes.put("statusDate", getStatusDate());
		attributes.put("uuid_", getUuid_());
		attributes.put("originalEntityId", getOriginalEntityId());
		attributes.put("entityResourceId", getEntityResourceId());
		attributes.put("version", getVersion());
		attributes.put("workflowAction", getWorkflowAction());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long environmentId = (Long)attributes.get("environmentId");

		if (environmentId != null) {
			setEnvironmentId(environmentId);
		}

		Long channelId = (Long)attributes.get("channelId");

		if (channelId != null) {
			setChannelId(channelId);
		}

		String environmentName = (String)attributes.get("environmentName");

		if (environmentName != null) {
			setEnvironmentName(environmentName);
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

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		String uuid_ = (String)attributes.get("uuid_");

		if (uuid_ != null) {
			setUuid_(uuid_);
		}

		Long originalEntityId = (Long)attributes.get("originalEntityId");

		if (originalEntityId != null) {
			setOriginalEntityId(originalEntityId);
		}

		Long entityResourceId = (Long)attributes.get("entityResourceId");

		if (entityResourceId != null) {
			setEntityResourceId(entityResourceId);
		}

		Integer version = (Integer)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		String workflowAction = (String)attributes.get("workflowAction");

		if (workflowAction != null) {
			setWorkflowAction(workflowAction);
		}
	}

	@Override
	public AppEnvironment cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the channel ID of this app environment.
	 *
	 * @return the channel ID of this app environment
	 */
	@Override
	public long getChannelId() {
		return model.getChannelId();
	}

	/**
	 * Returns the company ID of this app environment.
	 *
	 * @return the company ID of this app environment
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this app environment.
	 *
	 * @return the create date of this app environment
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the entity resource ID of this app environment.
	 *
	 * @return the entity resource ID of this app environment
	 */
	@Override
	public long getEntityResourceId() {
		return model.getEntityResourceId();
	}

	/**
	 * Returns the environment ID of this app environment.
	 *
	 * @return the environment ID of this app environment
	 */
	@Override
	public long getEnvironmentId() {
		return model.getEnvironmentId();
	}

	/**
	 * Returns the environment name of this app environment.
	 *
	 * @return the environment name of this app environment
	 */
	@Override
	public String getEnvironmentName() {
		return model.getEnvironmentName();
	}

	/**
	 * Returns the group ID of this app environment.
	 *
	 * @return the group ID of this app environment
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this app environment.
	 *
	 * @return the modified date of this app environment
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the original entity ID of this app environment.
	 *
	 * @return the original entity ID of this app environment
	 */
	@Override
	public long getOriginalEntityId() {
		return model.getOriginalEntityId();
	}

	/**
	 * Returns the primary key of this app environment.
	 *
	 * @return the primary key of this app environment
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this app environment.
	 *
	 * @return the status of this app environment
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this app environment.
	 *
	 * @return the status by user ID of this app environment
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this app environment.
	 *
	 * @return the status by user name of this app environment
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this app environment.
	 *
	 * @return the status by user uuid of this app environment
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this app environment.
	 *
	 * @return the status date of this app environment
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the user ID of this app environment.
	 *
	 * @return the user ID of this app environment
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this app environment.
	 *
	 * @return the user name of this app environment
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this app environment.
	 *
	 * @return the user uuid of this app environment
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid_ of this app environment.
	 *
	 * @return the uuid_ of this app environment
	 */
	@Override
	public String getUuid_() {
		return model.getUuid_();
	}

	/**
	 * Returns the version of this app environment.
	 *
	 * @return the version of this app environment
	 */
	@Override
	public int getVersion() {
		return model.getVersion();
	}

	/**
	 * Returns the workflow action of this app environment.
	 *
	 * @return the workflow action of this app environment
	 */
	@Override
	public String getWorkflowAction() {
		return model.getWorkflowAction();
	}

	/**
	 * Returns <code>true</code> if this app environment is approved.
	 *
	 * @return <code>true</code> if this app environment is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this app environment is denied.
	 *
	 * @return <code>true</code> if this app environment is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this app environment is a draft.
	 *
	 * @return <code>true</code> if this app environment is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this app environment is expired.
	 *
	 * @return <code>true</code> if this app environment is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this app environment is inactive.
	 *
	 * @return <code>true</code> if this app environment is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this app environment is incomplete.
	 *
	 * @return <code>true</code> if this app environment is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this app environment is pending.
	 *
	 * @return <code>true</code> if this app environment is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this app environment is scheduled.
	 *
	 * @return <code>true</code> if this app environment is scheduled; <code>false</code> otherwise
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
	 * Sets the channel ID of this app environment.
	 *
	 * @param channelId the channel ID of this app environment
	 */
	@Override
	public void setChannelId(long channelId) {
		model.setChannelId(channelId);
	}

	/**
	 * Sets the company ID of this app environment.
	 *
	 * @param companyId the company ID of this app environment
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this app environment.
	 *
	 * @param createDate the create date of this app environment
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the entity resource ID of this app environment.
	 *
	 * @param entityResourceId the entity resource ID of this app environment
	 */
	@Override
	public void setEntityResourceId(long entityResourceId) {
		model.setEntityResourceId(entityResourceId);
	}

	/**
	 * Sets the environment ID of this app environment.
	 *
	 * @param environmentId the environment ID of this app environment
	 */
	@Override
	public void setEnvironmentId(long environmentId) {
		model.setEnvironmentId(environmentId);
	}

	/**
	 * Sets the environment name of this app environment.
	 *
	 * @param environmentName the environment name of this app environment
	 */
	@Override
	public void setEnvironmentName(String environmentName) {
		model.setEnvironmentName(environmentName);
	}

	/**
	 * Sets the group ID of this app environment.
	 *
	 * @param groupId the group ID of this app environment
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this app environment.
	 *
	 * @param modifiedDate the modified date of this app environment
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the original entity ID of this app environment.
	 *
	 * @param originalEntityId the original entity ID of this app environment
	 */
	@Override
	public void setOriginalEntityId(long originalEntityId) {
		model.setOriginalEntityId(originalEntityId);
	}

	/**
	 * Sets the primary key of this app environment.
	 *
	 * @param primaryKey the primary key of this app environment
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this app environment.
	 *
	 * @param status the status of this app environment
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this app environment.
	 *
	 * @param statusByUserId the status by user ID of this app environment
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this app environment.
	 *
	 * @param statusByUserName the status by user name of this app environment
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this app environment.
	 *
	 * @param statusByUserUuid the status by user uuid of this app environment
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this app environment.
	 *
	 * @param statusDate the status date of this app environment
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the user ID of this app environment.
	 *
	 * @param userId the user ID of this app environment
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this app environment.
	 *
	 * @param userName the user name of this app environment
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this app environment.
	 *
	 * @param userUuid the user uuid of this app environment
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid_ of this app environment.
	 *
	 * @param uuid_ the uuid_ of this app environment
	 */
	@Override
	public void setUuid_(String uuid_) {
		model.setUuid_(uuid_);
	}

	/**
	 * Sets the version of this app environment.
	 *
	 * @param version the version of this app environment
	 */
	@Override
	public void setVersion(int version) {
		model.setVersion(version);
	}

	/**
	 * Sets the workflow action of this app environment.
	 *
	 * @param workflowAction the workflow action of this app environment
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
	protected AppEnvironmentWrapper wrap(AppEnvironment appEnvironment) {
		return new AppEnvironmentWrapper(appEnvironment);
	}

}