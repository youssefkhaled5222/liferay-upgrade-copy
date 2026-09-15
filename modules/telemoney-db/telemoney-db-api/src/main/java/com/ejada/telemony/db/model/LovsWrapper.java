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
 * This class is a wrapper for {@link Lovs}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Lovs
 * @generated
 */
public class LovsWrapper
	extends BaseModelWrapper<Lovs> implements Lovs, ModelWrapper<Lovs> {

	public LovsWrapper(Lovs lovs) {
		super(lovs);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("defaultLanguageId", getDefaultLanguageId());
		attributes.put("id", getId());
		attributes.put("code", getCode());
		attributes.put("channelId", getChannelId());
		attributes.put("eventCode", getEventCode());
		attributes.put("count", getCount());
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
		String defaultLanguageId = (String)attributes.get("defaultLanguageId");

		if (defaultLanguageId != null) {
			setDefaultLanguageId(defaultLanguageId);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		Long channelId = (Long)attributes.get("channelId");

		if (channelId != null) {
			setChannelId(channelId);
		}

		String eventCode = (String)attributes.get("eventCode");

		if (eventCode != null) {
			setEventCode(eventCode);
		}

		Integer count = (Integer)attributes.get("count");

		if (count != null) {
			setCount(count);
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
	public Lovs cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the channel ID of this lovs.
	 *
	 * @return the channel ID of this lovs
	 */
	@Override
	public long getChannelId() {
		return model.getChannelId();
	}

	/**
	 * Returns the code of this lovs.
	 *
	 * @return the code of this lovs
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this lovs.
	 *
	 * @return the company ID of this lovs
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the count of this lovs.
	 *
	 * @return the count of this lovs
	 */
	@Override
	public int getCount() {
		return model.getCount();
	}

	/**
	 * Returns the create date of this lovs.
	 *
	 * @return the create date of this lovs
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the default language ID of this lovs.
	 *
	 * @return the default language ID of this lovs
	 */
	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the entity resource ID of this lovs.
	 *
	 * @return the entity resource ID of this lovs
	 */
	@Override
	public long getEntityResourceId() {
		return model.getEntityResourceId();
	}

	/**
	 * Returns the event code of this lovs.
	 *
	 * @return the event code of this lovs
	 */
	@Override
	public String getEventCode() {
		return model.getEventCode();
	}

	/**
	 * Returns the group ID of this lovs.
	 *
	 * @return the group ID of this lovs
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this lovs.
	 *
	 * @return the ID of this lovs
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	@Override
	public Map<String, String> getLanguageIdToNameMap() {
		return model.getLanguageIdToNameMap();
	}

	/**
	 * Returns the modified date of this lovs.
	 *
	 * @return the modified date of this lovs
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	@Override
	public String getName() {
		return model.getName();
	}

	@Override
	public String getName(String languageId) {
		return model.getName(languageId);
	}

	@Override
	public String getName(String languageId, boolean useDefault) {
		return model.getName(languageId, useDefault);
	}

	@Override
	public String getNameMapAsXML() {
		return model.getNameMapAsXML();
	}

	/**
	 * Returns the original entity ID of this lovs.
	 *
	 * @return the original entity ID of this lovs
	 */
	@Override
	public long getOriginalEntityId() {
		return model.getOriginalEntityId();
	}

	/**
	 * Returns the primary key of this lovs.
	 *
	 * @return the primary key of this lovs
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this lovs.
	 *
	 * @return the status of this lovs
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this lovs.
	 *
	 * @return the status by user ID of this lovs
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this lovs.
	 *
	 * @return the status by user name of this lovs
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this lovs.
	 *
	 * @return the status by user uuid of this lovs
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this lovs.
	 *
	 * @return the status date of this lovs
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the user ID of this lovs.
	 *
	 * @return the user ID of this lovs
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this lovs.
	 *
	 * @return the user name of this lovs
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this lovs.
	 *
	 * @return the user uuid of this lovs
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid_ of this lovs.
	 *
	 * @return the uuid_ of this lovs
	 */
	@Override
	public String getUuid_() {
		return model.getUuid_();
	}

	/**
	 * Returns the version of this lovs.
	 *
	 * @return the version of this lovs
	 */
	@Override
	public int getVersion() {
		return model.getVersion();
	}

	/**
	 * Returns the workflow action of this lovs.
	 *
	 * @return the workflow action of this lovs
	 */
	@Override
	public String getWorkflowAction() {
		return model.getWorkflowAction();
	}

	/**
	 * Returns <code>true</code> if this lovs is approved.
	 *
	 * @return <code>true</code> if this lovs is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this lovs is denied.
	 *
	 * @return <code>true</code> if this lovs is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this lovs is a draft.
	 *
	 * @return <code>true</code> if this lovs is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this lovs is expired.
	 *
	 * @return <code>true</code> if this lovs is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this lovs is inactive.
	 *
	 * @return <code>true</code> if this lovs is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this lovs is incomplete.
	 *
	 * @return <code>true</code> if this lovs is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this lovs is pending.
	 *
	 * @return <code>true</code> if this lovs is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this lovs is scheduled.
	 *
	 * @return <code>true</code> if this lovs is scheduled; <code>false</code> otherwise
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
	 * Sets the channel ID of this lovs.
	 *
	 * @param channelId the channel ID of this lovs
	 */
	@Override
	public void setChannelId(long channelId) {
		model.setChannelId(channelId);
	}

	/**
	 * Sets the code of this lovs.
	 *
	 * @param code the code of this lovs
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this lovs.
	 *
	 * @param companyId the company ID of this lovs
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the count of this lovs.
	 *
	 * @param count the count of this lovs
	 */
	@Override
	public void setCount(int count) {
		model.setCount(count);
	}

	/**
	 * Sets the create date of this lovs.
	 *
	 * @param createDate the create date of this lovs
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the default language ID of this lovs.
	 *
	 * @param defaultLanguageId the default language ID of this lovs
	 */
	@Override
	public void setDefaultLanguageId(String defaultLanguageId) {
		model.setDefaultLanguageId(defaultLanguageId);
	}

	/**
	 * Sets the entity resource ID of this lovs.
	 *
	 * @param entityResourceId the entity resource ID of this lovs
	 */
	@Override
	public void setEntityResourceId(long entityResourceId) {
		model.setEntityResourceId(entityResourceId);
	}

	/**
	 * Sets the event code of this lovs.
	 *
	 * @param eventCode the event code of this lovs
	 */
	@Override
	public void setEventCode(String eventCode) {
		model.setEventCode(eventCode);
	}

	/**
	 * Sets the group ID of this lovs.
	 *
	 * @param groupId the group ID of this lovs
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this lovs.
	 *
	 * @param id the ID of this lovs
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the modified date of this lovs.
	 *
	 * @param modifiedDate the modified date of this lovs
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the original entity ID of this lovs.
	 *
	 * @param originalEntityId the original entity ID of this lovs
	 */
	@Override
	public void setOriginalEntityId(long originalEntityId) {
		model.setOriginalEntityId(originalEntityId);
	}

	/**
	 * Sets the primary key of this lovs.
	 *
	 * @param primaryKey the primary key of this lovs
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this lovs.
	 *
	 * @param status the status of this lovs
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this lovs.
	 *
	 * @param statusByUserId the status by user ID of this lovs
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this lovs.
	 *
	 * @param statusByUserName the status by user name of this lovs
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this lovs.
	 *
	 * @param statusByUserUuid the status by user uuid of this lovs
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this lovs.
	 *
	 * @param statusDate the status date of this lovs
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the user ID of this lovs.
	 *
	 * @param userId the user ID of this lovs
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this lovs.
	 *
	 * @param userName the user name of this lovs
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this lovs.
	 *
	 * @param userUuid the user uuid of this lovs
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid_ of this lovs.
	 *
	 * @param uuid_ the uuid_ of this lovs
	 */
	@Override
	public void setUuid_(String uuid_) {
		model.setUuid_(uuid_);
	}

	/**
	 * Sets the version of this lovs.
	 *
	 * @param version the version of this lovs
	 */
	@Override
	public void setVersion(int version) {
		model.setVersion(version);
	}

	/**
	 * Sets the workflow action of this lovs.
	 *
	 * @param workflowAction the workflow action of this lovs
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
	protected LovsWrapper wrap(Lovs lovs) {
		return new LovsWrapper(lovs);
	}

}