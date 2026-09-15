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
 * This class is a wrapper for {@link Banner}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Banner
 * @generated
 */
public class BannerWrapper
	extends BaseModelWrapper<Banner> implements Banner, ModelWrapper<Banner> {

	public BannerWrapper(Banner banner) {
		super(banner);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bannerId", getBannerId());
		attributes.put("channelId", getChannelId());
		attributes.put("bannerName", getBannerName());
		attributes.put("bannerType", getBannerType());
		attributes.put("container", getContainer());
		attributes.put("dateFrom", getDateFrom());
		attributes.put("dateTo", getDateTo());
		attributes.put("blockId", getBlockId());
		attributes.put("persona", getPersona());
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
		attributes.put("importRequestId", getImportRequestId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long bannerId = (Long)attributes.get("bannerId");

		if (bannerId != null) {
			setBannerId(bannerId);
		}

		Long channelId = (Long)attributes.get("channelId");

		if (channelId != null) {
			setChannelId(channelId);
		}

		String bannerName = (String)attributes.get("bannerName");

		if (bannerName != null) {
			setBannerName(bannerName);
		}

		String bannerType = (String)attributes.get("bannerType");

		if (bannerType != null) {
			setBannerType(bannerType);
		}

		String container = (String)attributes.get("container");

		if (container != null) {
			setContainer(container);
		}

		Date dateFrom = (Date)attributes.get("dateFrom");

		if (dateFrom != null) {
			setDateFrom(dateFrom);
		}

		Date dateTo = (Date)attributes.get("dateTo");

		if (dateTo != null) {
			setDateTo(dateTo);
		}

		Long blockId = (Long)attributes.get("blockId");

		if (blockId != null) {
			setBlockId(blockId);
		}

		String persona = (String)attributes.get("persona");

		if (persona != null) {
			setPersona(persona);
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

		Long importRequestId = (Long)attributes.get("importRequestId");

		if (importRequestId != null) {
			setImportRequestId(importRequestId);
		}
	}

	@Override
	public Banner cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the banner ID of this banner.
	 *
	 * @return the banner ID of this banner
	 */
	@Override
	public long getBannerId() {
		return model.getBannerId();
	}

	/**
	 * Returns the banner name of this banner.
	 *
	 * @return the banner name of this banner
	 */
	@Override
	public String getBannerName() {
		return model.getBannerName();
	}

	/**
	 * Returns the banner type of this banner.
	 *
	 * @return the banner type of this banner
	 */
	@Override
	public String getBannerType() {
		return model.getBannerType();
	}

	/**
	 * Returns the block ID of this banner.
	 *
	 * @return the block ID of this banner
	 */
	@Override
	public long getBlockId() {
		return model.getBlockId();
	}

	/**
	 * Returns the channel ID of this banner.
	 *
	 * @return the channel ID of this banner
	 */
	@Override
	public long getChannelId() {
		return model.getChannelId();
	}

	/**
	 * Returns the company ID of this banner.
	 *
	 * @return the company ID of this banner
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the container of this banner.
	 *
	 * @return the container of this banner
	 */
	@Override
	public String getContainer() {
		return model.getContainer();
	}

	/**
	 * Returns the create date of this banner.
	 *
	 * @return the create date of this banner
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the date from of this banner.
	 *
	 * @return the date from of this banner
	 */
	@Override
	public Date getDateFrom() {
		return model.getDateFrom();
	}

	/**
	 * Returns the date to of this banner.
	 *
	 * @return the date to of this banner
	 */
	@Override
	public Date getDateTo() {
		return model.getDateTo();
	}

	/**
	 * Returns the entity resource ID of this banner.
	 *
	 * @return the entity resource ID of this banner
	 */
	@Override
	public long getEntityResourceId() {
		return model.getEntityResourceId();
	}

	/**
	 * Returns the group ID of this banner.
	 *
	 * @return the group ID of this banner
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the import request ID of this banner.
	 *
	 * @return the import request ID of this banner
	 */
	@Override
	public long getImportRequestId() {
		return model.getImportRequestId();
	}

	/**
	 * Returns the modified date of this banner.
	 *
	 * @return the modified date of this banner
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the original entity ID of this banner.
	 *
	 * @return the original entity ID of this banner
	 */
	@Override
	public long getOriginalEntityId() {
		return model.getOriginalEntityId();
	}

	/**
	 * Returns the persona of this banner.
	 *
	 * @return the persona of this banner
	 */
	@Override
	public String getPersona() {
		return model.getPersona();
	}

	/**
	 * Returns the primary key of this banner.
	 *
	 * @return the primary key of this banner
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this banner.
	 *
	 * @return the status of this banner
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this banner.
	 *
	 * @return the status by user ID of this banner
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this banner.
	 *
	 * @return the status by user name of this banner
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this banner.
	 *
	 * @return the status by user uuid of this banner
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this banner.
	 *
	 * @return the status date of this banner
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the user ID of this banner.
	 *
	 * @return the user ID of this banner
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this banner.
	 *
	 * @return the user name of this banner
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this banner.
	 *
	 * @return the user uuid of this banner
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid_ of this banner.
	 *
	 * @return the uuid_ of this banner
	 */
	@Override
	public String getUuid_() {
		return model.getUuid_();
	}

	/**
	 * Returns the version of this banner.
	 *
	 * @return the version of this banner
	 */
	@Override
	public int getVersion() {
		return model.getVersion();
	}

	/**
	 * Returns the workflow action of this banner.
	 *
	 * @return the workflow action of this banner
	 */
	@Override
	public String getWorkflowAction() {
		return model.getWorkflowAction();
	}

	/**
	 * Returns <code>true</code> if this banner is approved.
	 *
	 * @return <code>true</code> if this banner is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this banner is denied.
	 *
	 * @return <code>true</code> if this banner is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this banner is a draft.
	 *
	 * @return <code>true</code> if this banner is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this banner is expired.
	 *
	 * @return <code>true</code> if this banner is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this banner is inactive.
	 *
	 * @return <code>true</code> if this banner is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this banner is incomplete.
	 *
	 * @return <code>true</code> if this banner is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this banner is pending.
	 *
	 * @return <code>true</code> if this banner is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this banner is scheduled.
	 *
	 * @return <code>true</code> if this banner is scheduled; <code>false</code> otherwise
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
	 * Sets the banner ID of this banner.
	 *
	 * @param bannerId the banner ID of this banner
	 */
	@Override
	public void setBannerId(long bannerId) {
		model.setBannerId(bannerId);
	}

	/**
	 * Sets the banner name of this banner.
	 *
	 * @param bannerName the banner name of this banner
	 */
	@Override
	public void setBannerName(String bannerName) {
		model.setBannerName(bannerName);
	}

	/**
	 * Sets the banner type of this banner.
	 *
	 * @param bannerType the banner type of this banner
	 */
	@Override
	public void setBannerType(String bannerType) {
		model.setBannerType(bannerType);
	}

	/**
	 * Sets the block ID of this banner.
	 *
	 * @param blockId the block ID of this banner
	 */
	@Override
	public void setBlockId(long blockId) {
		model.setBlockId(blockId);
	}

	/**
	 * Sets the channel ID of this banner.
	 *
	 * @param channelId the channel ID of this banner
	 */
	@Override
	public void setChannelId(long channelId) {
		model.setChannelId(channelId);
	}

	/**
	 * Sets the company ID of this banner.
	 *
	 * @param companyId the company ID of this banner
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the container of this banner.
	 *
	 * @param container the container of this banner
	 */
	@Override
	public void setContainer(String container) {
		model.setContainer(container);
	}

	/**
	 * Sets the create date of this banner.
	 *
	 * @param createDate the create date of this banner
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the date from of this banner.
	 *
	 * @param dateFrom the date from of this banner
	 */
	@Override
	public void setDateFrom(Date dateFrom) {
		model.setDateFrom(dateFrom);
	}

	/**
	 * Sets the date to of this banner.
	 *
	 * @param dateTo the date to of this banner
	 */
	@Override
	public void setDateTo(Date dateTo) {
		model.setDateTo(dateTo);
	}

	/**
	 * Sets the entity resource ID of this banner.
	 *
	 * @param entityResourceId the entity resource ID of this banner
	 */
	@Override
	public void setEntityResourceId(long entityResourceId) {
		model.setEntityResourceId(entityResourceId);
	}

	/**
	 * Sets the group ID of this banner.
	 *
	 * @param groupId the group ID of this banner
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the import request ID of this banner.
	 *
	 * @param importRequestId the import request ID of this banner
	 */
	@Override
	public void setImportRequestId(long importRequestId) {
		model.setImportRequestId(importRequestId);
	}

	/**
	 * Sets the modified date of this banner.
	 *
	 * @param modifiedDate the modified date of this banner
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the original entity ID of this banner.
	 *
	 * @param originalEntityId the original entity ID of this banner
	 */
	@Override
	public void setOriginalEntityId(long originalEntityId) {
		model.setOriginalEntityId(originalEntityId);
	}

	/**
	 * Sets the persona of this banner.
	 *
	 * @param persona the persona of this banner
	 */
	@Override
	public void setPersona(String persona) {
		model.setPersona(persona);
	}

	/**
	 * Sets the primary key of this banner.
	 *
	 * @param primaryKey the primary key of this banner
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this banner.
	 *
	 * @param status the status of this banner
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this banner.
	 *
	 * @param statusByUserId the status by user ID of this banner
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this banner.
	 *
	 * @param statusByUserName the status by user name of this banner
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this banner.
	 *
	 * @param statusByUserUuid the status by user uuid of this banner
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this banner.
	 *
	 * @param statusDate the status date of this banner
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the user ID of this banner.
	 *
	 * @param userId the user ID of this banner
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this banner.
	 *
	 * @param userName the user name of this banner
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this banner.
	 *
	 * @param userUuid the user uuid of this banner
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid_ of this banner.
	 *
	 * @param uuid_ the uuid_ of this banner
	 */
	@Override
	public void setUuid_(String uuid_) {
		model.setUuid_(uuid_);
	}

	/**
	 * Sets the version of this banner.
	 *
	 * @param version the version of this banner
	 */
	@Override
	public void setVersion(int version) {
		model.setVersion(version);
	}

	/**
	 * Sets the workflow action of this banner.
	 *
	 * @param workflowAction the workflow action of this banner
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
	protected BannerWrapper wrap(Banner banner) {
		return new BannerWrapper(banner);
	}

}