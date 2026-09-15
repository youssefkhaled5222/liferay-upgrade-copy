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
 * This class is a wrapper for {@link Resource}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Resource
 * @generated
 */
public class ResourceWrapper
	extends BaseModelWrapper<Resource>
	implements ModelWrapper<Resource>, Resource {

	public ResourceWrapper(Resource resource) {
		super(resource);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("defaultLanguageId", getDefaultLanguageId());
		attributes.put("resourceId", getResourceId());
		attributes.put("channelId", getChannelId());
		attributes.put("resourceCode", getResourceCode());
		attributes.put("resourceType", getResourceType());
		attributes.put("urlType", getUrlType());
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
		attributes.put("featureId", getFeatureId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String defaultLanguageId = (String)attributes.get("defaultLanguageId");

		if (defaultLanguageId != null) {
			setDefaultLanguageId(defaultLanguageId);
		}

		Long resourceId = (Long)attributes.get("resourceId");

		if (resourceId != null) {
			setResourceId(resourceId);
		}

		Long channelId = (Long)attributes.get("channelId");

		if (channelId != null) {
			setChannelId(channelId);
		}

		String resourceCode = (String)attributes.get("resourceCode");

		if (resourceCode != null) {
			setResourceCode(resourceCode);
		}

		String resourceType = (String)attributes.get("resourceType");

		if (resourceType != null) {
			setResourceType(resourceType);
		}

		String urlType = (String)attributes.get("urlType");

		if (urlType != null) {
			setUrlType(urlType);
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

		Long featureId = (Long)attributes.get("featureId");

		if (featureId != null) {
			setFeatureId(featureId);
		}
	}

	@Override
	public Resource cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String getAttach() {
		return model.getAttach();
	}

	@Override
	public String getAttach(String languageId) {
		return model.getAttach(languageId);
	}

	@Override
	public String getAttach(String languageId, boolean useDefault) {
		return model.getAttach(languageId, useDefault);
	}

	@Override
	public String getAttachMapAsXML() {
		return model.getAttachMapAsXML();
	}

	@Override
	public String getAttachName() {
		return model.getAttachName();
	}

	@Override
	public String getAttachName(String languageId) {
		return model.getAttachName(languageId);
	}

	@Override
	public String getAttachName(String languageId, boolean useDefault) {
		return model.getAttachName(languageId, useDefault);
	}

	@Override
	public String getAttachNameMapAsXML() {
		return model.getAttachNameMapAsXML();
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the channel ID of this resource.
	 *
	 * @return the channel ID of this resource
	 */
	@Override
	public long getChannelId() {
		return model.getChannelId();
	}

	/**
	 * Returns the company ID of this resource.
	 *
	 * @return the company ID of this resource
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this resource.
	 *
	 * @return the create date of this resource
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the default language ID of this resource.
	 *
	 * @return the default language ID of this resource
	 */
	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	@Override
	public String getDescription() {
		return model.getDescription();
	}

	@Override
	public String getDescription(String languageId) {
		return model.getDescription(languageId);
	}

	@Override
	public String getDescription(String languageId, boolean useDefault) {
		return model.getDescription(languageId, useDefault);
	}

	@Override
	public String getDescriptionMapAsXML() {
		return model.getDescriptionMapAsXML();
	}

	/**
	 * Returns the entity resource ID of this resource.
	 *
	 * @return the entity resource ID of this resource
	 */
	@Override
	public long getEntityResourceId() {
		return model.getEntityResourceId();
	}

	/**
	 * Returns the feature ID of this resource.
	 *
	 * @return the feature ID of this resource
	 */
	@Override
	public long getFeatureId() {
		return model.getFeatureId();
	}

	/**
	 * Returns the group ID of this resource.
	 *
	 * @return the group ID of this resource
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	@Override
	public Map<String, String> getLanguageIdToAttachMap() {
		return model.getLanguageIdToAttachMap();
	}

	@Override
	public Map<String, String> getLanguageIdToAttachNameMap() {
		return model.getLanguageIdToAttachNameMap();
	}

	@Override
	public Map<String, String> getLanguageIdToDescriptionMap() {
		return model.getLanguageIdToDescriptionMap();
	}

	@Override
	public Map<String, String> getLanguageIdToNameMap() {
		return model.getLanguageIdToNameMap();
	}

	@Override
	public Map<String, String> getLanguageIdToRouteIdMap() {
		return model.getLanguageIdToRouteIdMap();
	}

	@Override
	public Map<String, String> getLanguageIdToUrlMap() {
		return model.getLanguageIdToUrlMap();
	}

	/**
	 * Returns the modified date of this resource.
	 *
	 * @return the modified date of this resource
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
	 * Returns the original entity ID of this resource.
	 *
	 * @return the original entity ID of this resource
	 */
	@Override
	public long getOriginalEntityId() {
		return model.getOriginalEntityId();
	}

	/**
	 * Returns the primary key of this resource.
	 *
	 * @return the primary key of this resource
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the resource code of this resource.
	 *
	 * @return the resource code of this resource
	 */
	@Override
	public String getResourceCode() {
		return model.getResourceCode();
	}

	/**
	 * Returns the resource ID of this resource.
	 *
	 * @return the resource ID of this resource
	 */
	@Override
	public long getResourceId() {
		return model.getResourceId();
	}

	/**
	 * Returns the resource type of this resource.
	 *
	 * @return the resource type of this resource
	 */
	@Override
	public String getResourceType() {
		return model.getResourceType();
	}

	@Override
	public String getRouteId() {
		return model.getRouteId();
	}

	@Override
	public String getRouteId(String languageId) {
		return model.getRouteId(languageId);
	}

	@Override
	public String getRouteId(String languageId, boolean useDefault) {
		return model.getRouteId(languageId, useDefault);
	}

	@Override
	public String getRouteIdMapAsXML() {
		return model.getRouteIdMapAsXML();
	}

	/**
	 * Returns the status of this resource.
	 *
	 * @return the status of this resource
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this resource.
	 *
	 * @return the status by user ID of this resource
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this resource.
	 *
	 * @return the status by user name of this resource
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this resource.
	 *
	 * @return the status by user uuid of this resource
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this resource.
	 *
	 * @return the status date of this resource
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	@Override
	public String getUrl() {
		return model.getUrl();
	}

	@Override
	public String getUrl(String languageId) {
		return model.getUrl(languageId);
	}

	@Override
	public String getUrl(String languageId, boolean useDefault) {
		return model.getUrl(languageId, useDefault);
	}

	@Override
	public String getUrlMapAsXML() {
		return model.getUrlMapAsXML();
	}

	/**
	 * Returns the url type of this resource.
	 *
	 * @return the url type of this resource
	 */
	@Override
	public String getUrlType() {
		return model.getUrlType();
	}

	/**
	 * Returns the user ID of this resource.
	 *
	 * @return the user ID of this resource
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this resource.
	 *
	 * @return the user name of this resource
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this resource.
	 *
	 * @return the user uuid of this resource
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid_ of this resource.
	 *
	 * @return the uuid_ of this resource
	 */
	@Override
	public String getUuid_() {
		return model.getUuid_();
	}

	/**
	 * Returns the version of this resource.
	 *
	 * @return the version of this resource
	 */
	@Override
	public int getVersion() {
		return model.getVersion();
	}

	/**
	 * Returns the workflow action of this resource.
	 *
	 * @return the workflow action of this resource
	 */
	@Override
	public String getWorkflowAction() {
		return model.getWorkflowAction();
	}

	/**
	 * Returns <code>true</code> if this resource is approved.
	 *
	 * @return <code>true</code> if this resource is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this resource is denied.
	 *
	 * @return <code>true</code> if this resource is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this resource is a draft.
	 *
	 * @return <code>true</code> if this resource is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this resource is expired.
	 *
	 * @return <code>true</code> if this resource is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this resource is inactive.
	 *
	 * @return <code>true</code> if this resource is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this resource is incomplete.
	 *
	 * @return <code>true</code> if this resource is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this resource is pending.
	 *
	 * @return <code>true</code> if this resource is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this resource is scheduled.
	 *
	 * @return <code>true</code> if this resource is scheduled; <code>false</code> otherwise
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
	 * Sets the channel ID of this resource.
	 *
	 * @param channelId the channel ID of this resource
	 */
	@Override
	public void setChannelId(long channelId) {
		model.setChannelId(channelId);
	}

	/**
	 * Sets the company ID of this resource.
	 *
	 * @param companyId the company ID of this resource
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this resource.
	 *
	 * @param createDate the create date of this resource
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the default language ID of this resource.
	 *
	 * @param defaultLanguageId the default language ID of this resource
	 */
	@Override
	public void setDefaultLanguageId(String defaultLanguageId) {
		model.setDefaultLanguageId(defaultLanguageId);
	}

	/**
	 * Sets the entity resource ID of this resource.
	 *
	 * @param entityResourceId the entity resource ID of this resource
	 */
	@Override
	public void setEntityResourceId(long entityResourceId) {
		model.setEntityResourceId(entityResourceId);
	}

	/**
	 * Sets the feature ID of this resource.
	 *
	 * @param featureId the feature ID of this resource
	 */
	@Override
	public void setFeatureId(long featureId) {
		model.setFeatureId(featureId);
	}

	/**
	 * Sets the group ID of this resource.
	 *
	 * @param groupId the group ID of this resource
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this resource.
	 *
	 * @param modifiedDate the modified date of this resource
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the original entity ID of this resource.
	 *
	 * @param originalEntityId the original entity ID of this resource
	 */
	@Override
	public void setOriginalEntityId(long originalEntityId) {
		model.setOriginalEntityId(originalEntityId);
	}

	/**
	 * Sets the primary key of this resource.
	 *
	 * @param primaryKey the primary key of this resource
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the resource code of this resource.
	 *
	 * @param resourceCode the resource code of this resource
	 */
	@Override
	public void setResourceCode(String resourceCode) {
		model.setResourceCode(resourceCode);
	}

	/**
	 * Sets the resource ID of this resource.
	 *
	 * @param resourceId the resource ID of this resource
	 */
	@Override
	public void setResourceId(long resourceId) {
		model.setResourceId(resourceId);
	}

	/**
	 * Sets the resource type of this resource.
	 *
	 * @param resourceType the resource type of this resource
	 */
	@Override
	public void setResourceType(String resourceType) {
		model.setResourceType(resourceType);
	}

	/**
	 * Sets the status of this resource.
	 *
	 * @param status the status of this resource
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this resource.
	 *
	 * @param statusByUserId the status by user ID of this resource
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this resource.
	 *
	 * @param statusByUserName the status by user name of this resource
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this resource.
	 *
	 * @param statusByUserUuid the status by user uuid of this resource
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this resource.
	 *
	 * @param statusDate the status date of this resource
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the url type of this resource.
	 *
	 * @param urlType the url type of this resource
	 */
	@Override
	public void setUrlType(String urlType) {
		model.setUrlType(urlType);
	}

	/**
	 * Sets the user ID of this resource.
	 *
	 * @param userId the user ID of this resource
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this resource.
	 *
	 * @param userName the user name of this resource
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this resource.
	 *
	 * @param userUuid the user uuid of this resource
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid_ of this resource.
	 *
	 * @param uuid_ the uuid_ of this resource
	 */
	@Override
	public void setUuid_(String uuid_) {
		model.setUuid_(uuid_);
	}

	/**
	 * Sets the version of this resource.
	 *
	 * @param version the version of this resource
	 */
	@Override
	public void setVersion(int version) {
		model.setVersion(version);
	}

	/**
	 * Sets the workflow action of this resource.
	 *
	 * @param workflowAction the workflow action of this resource
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
	protected ResourceWrapper wrap(Resource resource) {
		return new ResourceWrapper(resource);
	}

}