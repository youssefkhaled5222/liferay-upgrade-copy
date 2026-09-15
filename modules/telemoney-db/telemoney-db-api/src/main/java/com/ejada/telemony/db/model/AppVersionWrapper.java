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
 * This class is a wrapper for {@link AppVersion}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppVersion
 * @generated
 */
public class AppVersionWrapper
	extends BaseModelWrapper<AppVersion>
	implements AppVersion, ModelWrapper<AppVersion> {

	public AppVersionWrapper(AppVersion appVersion) {
		super(appVersion);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("versionId", getVersionId());
		attributes.put("channelId", getChannelId());
		attributes.put("platform", getPlatform());
		attributes.put("versionNumber", getVersionNumber());
		attributes.put("url", getUrl());
		attributes.put("appVersionStatus", getAppVersionStatus());
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
		attributes.put("originalEntityId", getOriginalEntityId());
		attributes.put("entityResourceId", getEntityResourceId());
		attributes.put("version", getVersion());
		attributes.put("workflowAction", getWorkflowAction());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long versionId = (Long)attributes.get("versionId");

		if (versionId != null) {
			setVersionId(versionId);
		}

		Long channelId = (Long)attributes.get("channelId");

		if (channelId != null) {
			setChannelId(channelId);
		}

		String platform = (String)attributes.get("platform");

		if (platform != null) {
			setPlatform(platform);
		}

		String versionNumber = (String)attributes.get("versionNumber");

		if (versionNumber != null) {
			setVersionNumber(versionNumber);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		Boolean appVersionStatus = (Boolean)attributes.get("appVersionStatus");

		if (appVersionStatus != null) {
			setAppVersionStatus(appVersionStatus);
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
	public AppVersion cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the app version status of this app version.
	 *
	 * @return the app version status of this app version
	 */
	@Override
	public Boolean getAppVersionStatus() {
		return model.getAppVersionStatus();
	}

	/**
	 * Returns the channel ID of this app version.
	 *
	 * @return the channel ID of this app version
	 */
	@Override
	public long getChannelId() {
		return model.getChannelId();
	}

	/**
	 * Returns the company ID of this app version.
	 *
	 * @return the company ID of this app version
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this app version.
	 *
	 * @return the create date of this app version
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the entity resource ID of this app version.
	 *
	 * @return the entity resource ID of this app version
	 */
	@Override
	public long getEntityResourceId() {
		return model.getEntityResourceId();
	}

	/**
	 * Returns the group ID of this app version.
	 *
	 * @return the group ID of this app version
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this app version.
	 *
	 * @return the modified date of this app version
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the original entity ID of this app version.
	 *
	 * @return the original entity ID of this app version
	 */
	@Override
	public long getOriginalEntityId() {
		return model.getOriginalEntityId();
	}

	/**
	 * Returns the platform of this app version.
	 *
	 * @return the platform of this app version
	 */
	@Override
	public String getPlatform() {
		return model.getPlatform();
	}

	/**
	 * Returns the primary key of this app version.
	 *
	 * @return the primary key of this app version
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this app version.
	 *
	 * @return the status of this app version
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this app version.
	 *
	 * @return the status by user ID of this app version
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this app version.
	 *
	 * @return the status by user name of this app version
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this app version.
	 *
	 * @return the status by user uuid of this app version
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this app version.
	 *
	 * @return the status date of this app version
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the url of this app version.
	 *
	 * @return the url of this app version
	 */
	@Override
	public String getUrl() {
		return model.getUrl();
	}

	/**
	 * Returns the user ID of this app version.
	 *
	 * @return the user ID of this app version
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this app version.
	 *
	 * @return the user name of this app version
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this app version.
	 *
	 * @return the user uuid of this app version
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid_ of this app version.
	 *
	 * @return the uuid_ of this app version
	 */
	@Override
	public String getUuid_() {
		return model.getUuid_();
	}

	/**
	 * Returns the version of this app version.
	 *
	 * @return the version of this app version
	 */
	@Override
	public int getVersion() {
		return model.getVersion();
	}

	/**
	 * Returns the version ID of this app version.
	 *
	 * @return the version ID of this app version
	 */
	@Override
	public long getVersionId() {
		return model.getVersionId();
	}

	/**
	 * Returns the version number of this app version.
	 *
	 * @return the version number of this app version
	 */
	@Override
	public String getVersionNumber() {
		return model.getVersionNumber();
	}

	/**
	 * Returns the workflow action of this app version.
	 *
	 * @return the workflow action of this app version
	 */
	@Override
	public String getWorkflowAction() {
		return model.getWorkflowAction();
	}

	/**
	 * Returns <code>true</code> if this app version is approved.
	 *
	 * @return <code>true</code> if this app version is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this app version is denied.
	 *
	 * @return <code>true</code> if this app version is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this app version is a draft.
	 *
	 * @return <code>true</code> if this app version is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this app version is expired.
	 *
	 * @return <code>true</code> if this app version is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this app version is inactive.
	 *
	 * @return <code>true</code> if this app version is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this app version is incomplete.
	 *
	 * @return <code>true</code> if this app version is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this app version is pending.
	 *
	 * @return <code>true</code> if this app version is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this app version is scheduled.
	 *
	 * @return <code>true</code> if this app version is scheduled; <code>false</code> otherwise
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
	 * Sets the app version status of this app version.
	 *
	 * @param appVersionStatus the app version status of this app version
	 */
	@Override
	public void setAppVersionStatus(Boolean appVersionStatus) {
		model.setAppVersionStatus(appVersionStatus);
	}

	/**
	 * Sets the channel ID of this app version.
	 *
	 * @param channelId the channel ID of this app version
	 */
	@Override
	public void setChannelId(long channelId) {
		model.setChannelId(channelId);
	}

	/**
	 * Sets the company ID of this app version.
	 *
	 * @param companyId the company ID of this app version
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this app version.
	 *
	 * @param createDate the create date of this app version
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the entity resource ID of this app version.
	 *
	 * @param entityResourceId the entity resource ID of this app version
	 */
	@Override
	public void setEntityResourceId(long entityResourceId) {
		model.setEntityResourceId(entityResourceId);
	}

	/**
	 * Sets the group ID of this app version.
	 *
	 * @param groupId the group ID of this app version
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this app version.
	 *
	 * @param modifiedDate the modified date of this app version
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the original entity ID of this app version.
	 *
	 * @param originalEntityId the original entity ID of this app version
	 */
	@Override
	public void setOriginalEntityId(long originalEntityId) {
		model.setOriginalEntityId(originalEntityId);
	}

	/**
	 * Sets the platform of this app version.
	 *
	 * @param platform the platform of this app version
	 */
	@Override
	public void setPlatform(String platform) {
		model.setPlatform(platform);
	}

	/**
	 * Sets the primary key of this app version.
	 *
	 * @param primaryKey the primary key of this app version
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this app version.
	 *
	 * @param status the status of this app version
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this app version.
	 *
	 * @param statusByUserId the status by user ID of this app version
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this app version.
	 *
	 * @param statusByUserName the status by user name of this app version
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this app version.
	 *
	 * @param statusByUserUuid the status by user uuid of this app version
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this app version.
	 *
	 * @param statusDate the status date of this app version
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the url of this app version.
	 *
	 * @param url the url of this app version
	 */
	@Override
	public void setUrl(String url) {
		model.setUrl(url);
	}

	/**
	 * Sets the user ID of this app version.
	 *
	 * @param userId the user ID of this app version
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this app version.
	 *
	 * @param userName the user name of this app version
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this app version.
	 *
	 * @param userUuid the user uuid of this app version
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid_ of this app version.
	 *
	 * @param uuid_ the uuid_ of this app version
	 */
	@Override
	public void setUuid_(String uuid_) {
		model.setUuid_(uuid_);
	}

	/**
	 * Sets the version of this app version.
	 *
	 * @param version the version of this app version
	 */
	@Override
	public void setVersion(int version) {
		model.setVersion(version);
	}

	/**
	 * Sets the version ID of this app version.
	 *
	 * @param versionId the version ID of this app version
	 */
	@Override
	public void setVersionId(long versionId) {
		model.setVersionId(versionId);
	}

	/**
	 * Sets the version number of this app version.
	 *
	 * @param versionNumber the version number of this app version
	 */
	@Override
	public void setVersionNumber(String versionNumber) {
		model.setVersionNumber(versionNumber);
	}

	/**
	 * Sets the workflow action of this app version.
	 *
	 * @param workflowAction the workflow action of this app version
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
	protected AppVersionWrapper wrap(AppVersion appVersion) {
		return new AppVersionWrapper(appVersion);
	}

}