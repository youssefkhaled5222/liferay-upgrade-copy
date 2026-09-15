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
 * This class is a wrapper for {@link Localization}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Localization
 * @generated
 */
public class LocalizationWrapper
	extends BaseModelWrapper<Localization>
	implements Localization, ModelWrapper<Localization> {

	public LocalizationWrapper(Localization localization) {
		super(localization);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("localizationId", getLocalizationId());
		attributes.put("localValue", getLocalValue());
		attributes.put("version", getVersion());
		attributes.put("languageId", getLanguageId());
		attributes.put("userName", getUserName());
		attributes.put("channelId", getChannelId());
		attributes.put("featureId", getFeatureId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("uuid_", getUuid_());
		attributes.put("originalEntityId", getOriginalEntityId());
		attributes.put("entityResourceId", getEntityResourceId());
		attributes.put("workflowBatchId", getWorkflowBatchId());
		attributes.put("globalVersion", getGlobalVersion());
		attributes.put("importRequestId", getImportRequestId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long localizationId = (Long)attributes.get("localizationId");

		if (localizationId != null) {
			setLocalizationId(localizationId);
		}

		String localValue = (String)attributes.get("localValue");

		if (localValue != null) {
			setLocalValue(localValue);
		}

		Long version = (Long)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		Long languageId = (Long)attributes.get("languageId");

		if (languageId != null) {
			setLanguageId(languageId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Long channelId = (Long)attributes.get("channelId");

		if (channelId != null) {
			setChannelId(channelId);
		}

		Long featureId = (Long)attributes.get("featureId");

		if (featureId != null) {
			setFeatureId(featureId);
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

		String workflowBatchId = (String)attributes.get("workflowBatchId");

		if (workflowBatchId != null) {
			setWorkflowBatchId(workflowBatchId);
		}

		Long globalVersion = (Long)attributes.get("globalVersion");

		if (globalVersion != null) {
			setGlobalVersion(globalVersion);
		}

		Long importRequestId = (Long)attributes.get("importRequestId");

		if (importRequestId != null) {
			setImportRequestId(importRequestId);
		}
	}

	@Override
	public Localization cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the channel ID of this localization.
	 *
	 * @return the channel ID of this localization
	 */
	@Override
	public long getChannelId() {
		return model.getChannelId();
	}

	/**
	 * Returns the company ID of this localization.
	 *
	 * @return the company ID of this localization
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this localization.
	 *
	 * @return the create date of this localization
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the entity resource ID of this localization.
	 *
	 * @return the entity resource ID of this localization
	 */
	@Override
	public long getEntityResourceId() {
		return model.getEntityResourceId();
	}

	/**
	 * Returns the feature ID of this localization.
	 *
	 * @return the feature ID of this localization
	 */
	@Override
	public long getFeatureId() {
		return model.getFeatureId();
	}

	/**
	 * Returns the global version of this localization.
	 *
	 * @return the global version of this localization
	 */
	@Override
	public long getGlobalVersion() {
		return model.getGlobalVersion();
	}

	/**
	 * Returns the group ID of this localization.
	 *
	 * @return the group ID of this localization
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the import request ID of this localization.
	 *
	 * @return the import request ID of this localization
	 */
	@Override
	public long getImportRequestId() {
		return model.getImportRequestId();
	}

	/**
	 * Returns the language ID of this localization.
	 *
	 * @return the language ID of this localization
	 */
	@Override
	public long getLanguageId() {
		return model.getLanguageId();
	}

	/**
	 * Returns the localization ID of this localization.
	 *
	 * @return the localization ID of this localization
	 */
	@Override
	public long getLocalizationId() {
		return model.getLocalizationId();
	}

	/**
	 * Returns the local value of this localization.
	 *
	 * @return the local value of this localization
	 */
	@Override
	public String getLocalValue() {
		return model.getLocalValue();
	}

	/**
	 * Returns the modified date of this localization.
	 *
	 * @return the modified date of this localization
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the original entity ID of this localization.
	 *
	 * @return the original entity ID of this localization
	 */
	@Override
	public long getOriginalEntityId() {
		return model.getOriginalEntityId();
	}

	/**
	 * Returns the primary key of this localization.
	 *
	 * @return the primary key of this localization
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this localization.
	 *
	 * @return the status of this localization
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this localization.
	 *
	 * @return the status by user ID of this localization
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this localization.
	 *
	 * @return the status by user name of this localization
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this localization.
	 *
	 * @return the status by user uuid of this localization
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this localization.
	 *
	 * @return the status date of this localization
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the user ID of this localization.
	 *
	 * @return the user ID of this localization
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this localization.
	 *
	 * @return the user name of this localization
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this localization.
	 *
	 * @return the user uuid of this localization
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid_ of this localization.
	 *
	 * @return the uuid_ of this localization
	 */
	@Override
	public String getUuid_() {
		return model.getUuid_();
	}

	/**
	 * Returns the version of this localization.
	 *
	 * @return the version of this localization
	 */
	@Override
	public long getVersion() {
		return model.getVersion();
	}

	/**
	 * Returns the workflow batch ID of this localization.
	 *
	 * @return the workflow batch ID of this localization
	 */
	@Override
	public String getWorkflowBatchId() {
		return model.getWorkflowBatchId();
	}

	/**
	 * Returns <code>true</code> if this localization is approved.
	 *
	 * @return <code>true</code> if this localization is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this localization is denied.
	 *
	 * @return <code>true</code> if this localization is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this localization is a draft.
	 *
	 * @return <code>true</code> if this localization is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this localization is expired.
	 *
	 * @return <code>true</code> if this localization is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this localization is inactive.
	 *
	 * @return <code>true</code> if this localization is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this localization is incomplete.
	 *
	 * @return <code>true</code> if this localization is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this localization is pending.
	 *
	 * @return <code>true</code> if this localization is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this localization is scheduled.
	 *
	 * @return <code>true</code> if this localization is scheduled; <code>false</code> otherwise
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
	 * Sets the channel ID of this localization.
	 *
	 * @param channelId the channel ID of this localization
	 */
	@Override
	public void setChannelId(long channelId) {
		model.setChannelId(channelId);
	}

	/**
	 * Sets the company ID of this localization.
	 *
	 * @param companyId the company ID of this localization
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this localization.
	 *
	 * @param createDate the create date of this localization
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the entity resource ID of this localization.
	 *
	 * @param entityResourceId the entity resource ID of this localization
	 */
	@Override
	public void setEntityResourceId(long entityResourceId) {
		model.setEntityResourceId(entityResourceId);
	}

	/**
	 * Sets the feature ID of this localization.
	 *
	 * @param featureId the feature ID of this localization
	 */
	@Override
	public void setFeatureId(long featureId) {
		model.setFeatureId(featureId);
	}

	/**
	 * Sets the global version of this localization.
	 *
	 * @param globalVersion the global version of this localization
	 */
	@Override
	public void setGlobalVersion(long globalVersion) {
		model.setGlobalVersion(globalVersion);
	}

	/**
	 * Sets the group ID of this localization.
	 *
	 * @param groupId the group ID of this localization
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the import request ID of this localization.
	 *
	 * @param importRequestId the import request ID of this localization
	 */
	@Override
	public void setImportRequestId(long importRequestId) {
		model.setImportRequestId(importRequestId);
	}

	/**
	 * Sets the language ID of this localization.
	 *
	 * @param languageId the language ID of this localization
	 */
	@Override
	public void setLanguageId(long languageId) {
		model.setLanguageId(languageId);
	}

	/**
	 * Sets the localization ID of this localization.
	 *
	 * @param localizationId the localization ID of this localization
	 */
	@Override
	public void setLocalizationId(long localizationId) {
		model.setLocalizationId(localizationId);
	}

	/**
	 * Sets the local value of this localization.
	 *
	 * @param localValue the local value of this localization
	 */
	@Override
	public void setLocalValue(String localValue) {
		model.setLocalValue(localValue);
	}

	/**
	 * Sets the modified date of this localization.
	 *
	 * @param modifiedDate the modified date of this localization
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the original entity ID of this localization.
	 *
	 * @param originalEntityId the original entity ID of this localization
	 */
	@Override
	public void setOriginalEntityId(long originalEntityId) {
		model.setOriginalEntityId(originalEntityId);
	}

	/**
	 * Sets the primary key of this localization.
	 *
	 * @param primaryKey the primary key of this localization
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this localization.
	 *
	 * @param status the status of this localization
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this localization.
	 *
	 * @param statusByUserId the status by user ID of this localization
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this localization.
	 *
	 * @param statusByUserName the status by user name of this localization
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this localization.
	 *
	 * @param statusByUserUuid the status by user uuid of this localization
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this localization.
	 *
	 * @param statusDate the status date of this localization
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the user ID of this localization.
	 *
	 * @param userId the user ID of this localization
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this localization.
	 *
	 * @param userName the user name of this localization
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this localization.
	 *
	 * @param userUuid the user uuid of this localization
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid_ of this localization.
	 *
	 * @param uuid_ the uuid_ of this localization
	 */
	@Override
	public void setUuid_(String uuid_) {
		model.setUuid_(uuid_);
	}

	/**
	 * Sets the version of this localization.
	 *
	 * @param version the version of this localization
	 */
	@Override
	public void setVersion(long version) {
		model.setVersion(version);
	}

	/**
	 * Sets the workflow batch ID of this localization.
	 *
	 * @param workflowBatchId the workflow batch ID of this localization
	 */
	@Override
	public void setWorkflowBatchId(String workflowBatchId) {
		model.setWorkflowBatchId(workflowBatchId);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected LocalizationWrapper wrap(Localization localization) {
		return new LocalizationWrapper(localization);
	}

}