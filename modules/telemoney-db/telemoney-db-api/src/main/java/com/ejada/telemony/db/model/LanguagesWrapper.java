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
 * This class is a wrapper for {@link Languages}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Languages
 * @generated
 */
public class LanguagesWrapper
	extends BaseModelWrapper<Languages>
	implements Languages, ModelWrapper<Languages> {

	public LanguagesWrapper(Languages languages) {
		super(languages);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("languageId", getLanguageId());
		attributes.put("channelId", getChannelId());
		attributes.put("langName", getLangName());
		attributes.put("local", getLocal());
		attributes.put("primaryLanguage", isPrimaryLanguage());
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
		Long languageId = (Long)attributes.get("languageId");

		if (languageId != null) {
			setLanguageId(languageId);
		}

		Long channelId = (Long)attributes.get("channelId");

		if (channelId != null) {
			setChannelId(channelId);
		}

		String langName = (String)attributes.get("langName");

		if (langName != null) {
			setLangName(langName);
		}

		String local = (String)attributes.get("local");

		if (local != null) {
			setLocal(local);
		}

		Boolean primaryLanguage = (Boolean)attributes.get("primaryLanguage");

		if (primaryLanguage != null) {
			setPrimaryLanguage(primaryLanguage);
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
	public Languages cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the channel ID of this languages.
	 *
	 * @return the channel ID of this languages
	 */
	@Override
	public long getChannelId() {
		return model.getChannelId();
	}

	/**
	 * Returns the company ID of this languages.
	 *
	 * @return the company ID of this languages
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this languages.
	 *
	 * @return the create date of this languages
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the entity resource ID of this languages.
	 *
	 * @return the entity resource ID of this languages
	 */
	@Override
	public long getEntityResourceId() {
		return model.getEntityResourceId();
	}

	/**
	 * Returns the group ID of this languages.
	 *
	 * @return the group ID of this languages
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the lang name of this languages.
	 *
	 * @return the lang name of this languages
	 */
	@Override
	public String getLangName() {
		return model.getLangName();
	}

	/**
	 * Returns the language ID of this languages.
	 *
	 * @return the language ID of this languages
	 */
	@Override
	public long getLanguageId() {
		return model.getLanguageId();
	}

	/**
	 * Returns the local of this languages.
	 *
	 * @return the local of this languages
	 */
	@Override
	public String getLocal() {
		return model.getLocal();
	}

	/**
	 * Returns the modified date of this languages.
	 *
	 * @return the modified date of this languages
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the original entity ID of this languages.
	 *
	 * @return the original entity ID of this languages
	 */
	@Override
	public long getOriginalEntityId() {
		return model.getOriginalEntityId();
	}

	/**
	 * Returns the primary key of this languages.
	 *
	 * @return the primary key of this languages
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the primary language of this languages.
	 *
	 * @return the primary language of this languages
	 */
	@Override
	public boolean getPrimaryLanguage() {
		return model.getPrimaryLanguage();
	}

	/**
	 * Returns the status of this languages.
	 *
	 * @return the status of this languages
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this languages.
	 *
	 * @return the status by user ID of this languages
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this languages.
	 *
	 * @return the status by user name of this languages
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this languages.
	 *
	 * @return the status by user uuid of this languages
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this languages.
	 *
	 * @return the status date of this languages
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the user ID of this languages.
	 *
	 * @return the user ID of this languages
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this languages.
	 *
	 * @return the user name of this languages
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this languages.
	 *
	 * @return the user uuid of this languages
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid_ of this languages.
	 *
	 * @return the uuid_ of this languages
	 */
	@Override
	public String getUuid_() {
		return model.getUuid_();
	}

	/**
	 * Returns the version of this languages.
	 *
	 * @return the version of this languages
	 */
	@Override
	public int getVersion() {
		return model.getVersion();
	}

	/**
	 * Returns the workflow action of this languages.
	 *
	 * @return the workflow action of this languages
	 */
	@Override
	public String getWorkflowAction() {
		return model.getWorkflowAction();
	}

	/**
	 * Returns <code>true</code> if this languages is approved.
	 *
	 * @return <code>true</code> if this languages is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this languages is denied.
	 *
	 * @return <code>true</code> if this languages is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this languages is a draft.
	 *
	 * @return <code>true</code> if this languages is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this languages is expired.
	 *
	 * @return <code>true</code> if this languages is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this languages is inactive.
	 *
	 * @return <code>true</code> if this languages is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this languages is incomplete.
	 *
	 * @return <code>true</code> if this languages is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this languages is pending.
	 *
	 * @return <code>true</code> if this languages is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this languages is primary language.
	 *
	 * @return <code>true</code> if this languages is primary language; <code>false</code> otherwise
	 */
	@Override
	public boolean isPrimaryLanguage() {
		return model.isPrimaryLanguage();
	}

	/**
	 * Returns <code>true</code> if this languages is scheduled.
	 *
	 * @return <code>true</code> if this languages is scheduled; <code>false</code> otherwise
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
	 * Sets the channel ID of this languages.
	 *
	 * @param channelId the channel ID of this languages
	 */
	@Override
	public void setChannelId(long channelId) {
		model.setChannelId(channelId);
	}

	/**
	 * Sets the company ID of this languages.
	 *
	 * @param companyId the company ID of this languages
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this languages.
	 *
	 * @param createDate the create date of this languages
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the entity resource ID of this languages.
	 *
	 * @param entityResourceId the entity resource ID of this languages
	 */
	@Override
	public void setEntityResourceId(long entityResourceId) {
		model.setEntityResourceId(entityResourceId);
	}

	/**
	 * Sets the group ID of this languages.
	 *
	 * @param groupId the group ID of this languages
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the lang name of this languages.
	 *
	 * @param langName the lang name of this languages
	 */
	@Override
	public void setLangName(String langName) {
		model.setLangName(langName);
	}

	/**
	 * Sets the language ID of this languages.
	 *
	 * @param languageId the language ID of this languages
	 */
	@Override
	public void setLanguageId(long languageId) {
		model.setLanguageId(languageId);
	}

	/**
	 * Sets the local of this languages.
	 *
	 * @param local the local of this languages
	 */
	@Override
	public void setLocal(String local) {
		model.setLocal(local);
	}

	/**
	 * Sets the modified date of this languages.
	 *
	 * @param modifiedDate the modified date of this languages
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the original entity ID of this languages.
	 *
	 * @param originalEntityId the original entity ID of this languages
	 */
	@Override
	public void setOriginalEntityId(long originalEntityId) {
		model.setOriginalEntityId(originalEntityId);
	}

	/**
	 * Sets the primary key of this languages.
	 *
	 * @param primaryKey the primary key of this languages
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets whether this languages is primary language.
	 *
	 * @param primaryLanguage the primary language of this languages
	 */
	@Override
	public void setPrimaryLanguage(boolean primaryLanguage) {
		model.setPrimaryLanguage(primaryLanguage);
	}

	/**
	 * Sets the status of this languages.
	 *
	 * @param status the status of this languages
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this languages.
	 *
	 * @param statusByUserId the status by user ID of this languages
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this languages.
	 *
	 * @param statusByUserName the status by user name of this languages
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this languages.
	 *
	 * @param statusByUserUuid the status by user uuid of this languages
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this languages.
	 *
	 * @param statusDate the status date of this languages
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the user ID of this languages.
	 *
	 * @param userId the user ID of this languages
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this languages.
	 *
	 * @param userName the user name of this languages
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this languages.
	 *
	 * @param userUuid the user uuid of this languages
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid_ of this languages.
	 *
	 * @param uuid_ the uuid_ of this languages
	 */
	@Override
	public void setUuid_(String uuid_) {
		model.setUuid_(uuid_);
	}

	/**
	 * Sets the version of this languages.
	 *
	 * @param version the version of this languages
	 */
	@Override
	public void setVersion(int version) {
		model.setVersion(version);
	}

	/**
	 * Sets the workflow action of this languages.
	 *
	 * @param workflowAction the workflow action of this languages
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
	protected LanguagesWrapper wrap(Languages languages) {
		return new LanguagesWrapper(languages);
	}

}