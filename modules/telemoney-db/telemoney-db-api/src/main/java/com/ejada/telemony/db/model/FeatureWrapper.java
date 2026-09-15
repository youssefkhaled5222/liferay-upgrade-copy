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
 * This class is a wrapper for {@link Feature}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Feature
 * @generated
 */
public class FeatureWrapper
	extends BaseModelWrapper<Feature>
	implements Feature, ModelWrapper<Feature> {

	public FeatureWrapper(Feature feature) {
		super(feature);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("featureId", getFeatureId());
		attributes.put("featureName", getFeatureName());
		attributes.put("pageType", getPageType());
		attributes.put("parentPage", getParentPage());
		attributes.put("routeId", getRouteId());
		attributes.put("featureStatus", getFeatureStatus());
		attributes.put("blockId", getBlockId());
		attributes.put("channelId", getChannelId());
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
		attributes.put("childResourceId", getChildResourceId());
		attributes.put("version", getVersion());
		attributes.put("workflowAction", getWorkflowAction());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long featureId = (Long)attributes.get("featureId");

		if (featureId != null) {
			setFeatureId(featureId);
		}

		String featureName = (String)attributes.get("featureName");

		if (featureName != null) {
			setFeatureName(featureName);
		}

		String pageType = (String)attributes.get("pageType");

		if (pageType != null) {
			setPageType(pageType);
		}

		Long parentPage = (Long)attributes.get("parentPage");

		if (parentPage != null) {
			setParentPage(parentPage);
		}

		String routeId = (String)attributes.get("routeId");

		if (routeId != null) {
			setRouteId(routeId);
		}

		Boolean featureStatus = (Boolean)attributes.get("featureStatus");

		if (featureStatus != null) {
			setFeatureStatus(featureStatus);
		}

		Long blockId = (Long)attributes.get("blockId");

		if (blockId != null) {
			setBlockId(blockId);
		}

		Long channelId = (Long)attributes.get("channelId");

		if (channelId != null) {
			setChannelId(channelId);
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

		Long childResourceId = (Long)attributes.get("childResourceId");

		if (childResourceId != null) {
			setChildResourceId(childResourceId);
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
	public Feature cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the block ID of this feature.
	 *
	 * @return the block ID of this feature
	 */
	@Override
	public long getBlockId() {
		return model.getBlockId();
	}

	/**
	 * Returns the channel ID of this feature.
	 *
	 * @return the channel ID of this feature
	 */
	@Override
	public long getChannelId() {
		return model.getChannelId();
	}

	/**
	 * Returns the child resource ID of this feature.
	 *
	 * @return the child resource ID of this feature
	 */
	@Override
	public long getChildResourceId() {
		return model.getChildResourceId();
	}

	/**
	 * Returns the company ID of this feature.
	 *
	 * @return the company ID of this feature
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this feature.
	 *
	 * @return the create date of this feature
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the entity resource ID of this feature.
	 *
	 * @return the entity resource ID of this feature
	 */
	@Override
	public long getEntityResourceId() {
		return model.getEntityResourceId();
	}

	/**
	 * Returns the feature ID of this feature.
	 *
	 * @return the feature ID of this feature
	 */
	@Override
	public long getFeatureId() {
		return model.getFeatureId();
	}

	/**
	 * Returns the feature name of this feature.
	 *
	 * @return the feature name of this feature
	 */
	@Override
	public String getFeatureName() {
		return model.getFeatureName();
	}

	/**
	 * Returns the feature status of this feature.
	 *
	 * @return the feature status of this feature
	 */
	@Override
	public Boolean getFeatureStatus() {
		return model.getFeatureStatus();
	}

	/**
	 * Returns the group ID of this feature.
	 *
	 * @return the group ID of this feature
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this feature.
	 *
	 * @return the modified date of this feature
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the original entity ID of this feature.
	 *
	 * @return the original entity ID of this feature
	 */
	@Override
	public long getOriginalEntityId() {
		return model.getOriginalEntityId();
	}

	/**
	 * Returns the page type of this feature.
	 *
	 * @return the page type of this feature
	 */
	@Override
	public String getPageType() {
		return model.getPageType();
	}

	/**
	 * Returns the parent page of this feature.
	 *
	 * @return the parent page of this feature
	 */
	@Override
	public long getParentPage() {
		return model.getParentPage();
	}

	/**
	 * Returns the primary key of this feature.
	 *
	 * @return the primary key of this feature
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the route ID of this feature.
	 *
	 * @return the route ID of this feature
	 */
	@Override
	public String getRouteId() {
		return model.getRouteId();
	}

	/**
	 * Returns the status of this feature.
	 *
	 * @return the status of this feature
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this feature.
	 *
	 * @return the status by user ID of this feature
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this feature.
	 *
	 * @return the status by user name of this feature
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this feature.
	 *
	 * @return the status by user uuid of this feature
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this feature.
	 *
	 * @return the status date of this feature
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the user ID of this feature.
	 *
	 * @return the user ID of this feature
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this feature.
	 *
	 * @return the user name of this feature
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this feature.
	 *
	 * @return the user uuid of this feature
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid_ of this feature.
	 *
	 * @return the uuid_ of this feature
	 */
	@Override
	public String getUuid_() {
		return model.getUuid_();
	}

	/**
	 * Returns the version of this feature.
	 *
	 * @return the version of this feature
	 */
	@Override
	public int getVersion() {
		return model.getVersion();
	}

	/**
	 * Returns the workflow action of this feature.
	 *
	 * @return the workflow action of this feature
	 */
	@Override
	public String getWorkflowAction() {
		return model.getWorkflowAction();
	}

	/**
	 * Returns <code>true</code> if this feature is approved.
	 *
	 * @return <code>true</code> if this feature is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this feature is denied.
	 *
	 * @return <code>true</code> if this feature is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this feature is a draft.
	 *
	 * @return <code>true</code> if this feature is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this feature is expired.
	 *
	 * @return <code>true</code> if this feature is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this feature is inactive.
	 *
	 * @return <code>true</code> if this feature is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this feature is incomplete.
	 *
	 * @return <code>true</code> if this feature is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this feature is pending.
	 *
	 * @return <code>true</code> if this feature is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this feature is scheduled.
	 *
	 * @return <code>true</code> if this feature is scheduled; <code>false</code> otherwise
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
	 * Sets the block ID of this feature.
	 *
	 * @param blockId the block ID of this feature
	 */
	@Override
	public void setBlockId(long blockId) {
		model.setBlockId(blockId);
	}

	/**
	 * Sets the channel ID of this feature.
	 *
	 * @param channelId the channel ID of this feature
	 */
	@Override
	public void setChannelId(long channelId) {
		model.setChannelId(channelId);
	}

	/**
	 * Sets the child resource ID of this feature.
	 *
	 * @param childResourceId the child resource ID of this feature
	 */
	@Override
	public void setChildResourceId(long childResourceId) {
		model.setChildResourceId(childResourceId);
	}

	/**
	 * Sets the company ID of this feature.
	 *
	 * @param companyId the company ID of this feature
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this feature.
	 *
	 * @param createDate the create date of this feature
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the entity resource ID of this feature.
	 *
	 * @param entityResourceId the entity resource ID of this feature
	 */
	@Override
	public void setEntityResourceId(long entityResourceId) {
		model.setEntityResourceId(entityResourceId);
	}

	/**
	 * Sets the feature ID of this feature.
	 *
	 * @param featureId the feature ID of this feature
	 */
	@Override
	public void setFeatureId(long featureId) {
		model.setFeatureId(featureId);
	}

	/**
	 * Sets the feature name of this feature.
	 *
	 * @param featureName the feature name of this feature
	 */
	@Override
	public void setFeatureName(String featureName) {
		model.setFeatureName(featureName);
	}

	/**
	 * Sets the feature status of this feature.
	 *
	 * @param featureStatus the feature status of this feature
	 */
	@Override
	public void setFeatureStatus(Boolean featureStatus) {
		model.setFeatureStatus(featureStatus);
	}

	/**
	 * Sets the group ID of this feature.
	 *
	 * @param groupId the group ID of this feature
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this feature.
	 *
	 * @param modifiedDate the modified date of this feature
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the original entity ID of this feature.
	 *
	 * @param originalEntityId the original entity ID of this feature
	 */
	@Override
	public void setOriginalEntityId(long originalEntityId) {
		model.setOriginalEntityId(originalEntityId);
	}

	/**
	 * Sets the page type of this feature.
	 *
	 * @param pageType the page type of this feature
	 */
	@Override
	public void setPageType(String pageType) {
		model.setPageType(pageType);
	}

	/**
	 * Sets the parent page of this feature.
	 *
	 * @param parentPage the parent page of this feature
	 */
	@Override
	public void setParentPage(long parentPage) {
		model.setParentPage(parentPage);
	}

	/**
	 * Sets the primary key of this feature.
	 *
	 * @param primaryKey the primary key of this feature
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the route ID of this feature.
	 *
	 * @param routeId the route ID of this feature
	 */
	@Override
	public void setRouteId(String routeId) {
		model.setRouteId(routeId);
	}

	/**
	 * Sets the status of this feature.
	 *
	 * @param status the status of this feature
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this feature.
	 *
	 * @param statusByUserId the status by user ID of this feature
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this feature.
	 *
	 * @param statusByUserName the status by user name of this feature
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this feature.
	 *
	 * @param statusByUserUuid the status by user uuid of this feature
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this feature.
	 *
	 * @param statusDate the status date of this feature
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the user ID of this feature.
	 *
	 * @param userId the user ID of this feature
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this feature.
	 *
	 * @param userName the user name of this feature
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this feature.
	 *
	 * @param userUuid the user uuid of this feature
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid_ of this feature.
	 *
	 * @param uuid_ the uuid_ of this feature
	 */
	@Override
	public void setUuid_(String uuid_) {
		model.setUuid_(uuid_);
	}

	/**
	 * Sets the version of this feature.
	 *
	 * @param version the version of this feature
	 */
	@Override
	public void setVersion(int version) {
		model.setVersion(version);
	}

	/**
	 * Sets the workflow action of this feature.
	 *
	 * @param workflowAction the workflow action of this feature
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
	protected FeatureWrapper wrap(Feature feature) {
		return new FeatureWrapper(feature);
	}

}