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
 * This class is a wrapper for {@link Themes}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Themes
 * @generated
 */
public class ThemesWrapper
	extends BaseModelWrapper<Themes> implements ModelWrapper<Themes>, Themes {

	public ThemesWrapper(Themes themes) {
		super(themes);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("themeId", getThemeId());
		attributes.put("channelId", getChannelId());
		attributes.put("themeEnName", getThemeEnName());
		attributes.put("themeArName", getThemeArName());
		attributes.put("darkTheme", isDarkTheme());
		attributes.put("primaryColors", getPrimaryColors());
		attributes.put("secondaryColors", getSecondaryColors());
		attributes.put("neutralColors", getNeutralColors());
		attributes.put("successColors", getSuccessColors());
		attributes.put("errorColors", getErrorColors());
		attributes.put("warningColors", getWarningColors());
		attributes.put("supportColors", getSupportColors());
		attributes.put("gradientColors", getGradientColors());
		attributes.put("splashBg", getSplashBg());
		attributes.put("splashAnimation", getSplashAnimation());
		attributes.put("headerBg", getHeaderBg());
		attributes.put("balanceBg", getBalanceBg());
		attributes.put("defaultTheme", isDefaultTheme());
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
		Long themeId = (Long)attributes.get("themeId");

		if (themeId != null) {
			setThemeId(themeId);
		}

		Long channelId = (Long)attributes.get("channelId");

		if (channelId != null) {
			setChannelId(channelId);
		}

		String themeEnName = (String)attributes.get("themeEnName");

		if (themeEnName != null) {
			setThemeEnName(themeEnName);
		}

		String themeArName = (String)attributes.get("themeArName");

		if (themeArName != null) {
			setThemeArName(themeArName);
		}

		Boolean darkTheme = (Boolean)attributes.get("darkTheme");

		if (darkTheme != null) {
			setDarkTheme(darkTheme);
		}

		String primaryColors = (String)attributes.get("primaryColors");

		if (primaryColors != null) {
			setPrimaryColors(primaryColors);
		}

		String secondaryColors = (String)attributes.get("secondaryColors");

		if (secondaryColors != null) {
			setSecondaryColors(secondaryColors);
		}

		String neutralColors = (String)attributes.get("neutralColors");

		if (neutralColors != null) {
			setNeutralColors(neutralColors);
		}

		String successColors = (String)attributes.get("successColors");

		if (successColors != null) {
			setSuccessColors(successColors);
		}

		String errorColors = (String)attributes.get("errorColors");

		if (errorColors != null) {
			setErrorColors(errorColors);
		}

		String warningColors = (String)attributes.get("warningColors");

		if (warningColors != null) {
			setWarningColors(warningColors);
		}

		String supportColors = (String)attributes.get("supportColors");

		if (supportColors != null) {
			setSupportColors(supportColors);
		}

		String gradientColors = (String)attributes.get("gradientColors");

		if (gradientColors != null) {
			setGradientColors(gradientColors);
		}

		String splashBg = (String)attributes.get("splashBg");

		if (splashBg != null) {
			setSplashBg(splashBg);
		}

		String splashAnimation = (String)attributes.get("splashAnimation");

		if (splashAnimation != null) {
			setSplashAnimation(splashAnimation);
		}

		String headerBg = (String)attributes.get("headerBg");

		if (headerBg != null) {
			setHeaderBg(headerBg);
		}

		String balanceBg = (String)attributes.get("balanceBg");

		if (balanceBg != null) {
			setBalanceBg(balanceBg);
		}

		Boolean defaultTheme = (Boolean)attributes.get("defaultTheme");

		if (defaultTheme != null) {
			setDefaultTheme(defaultTheme);
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
	public Themes cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the balance bg of this themes.
	 *
	 * @return the balance bg of this themes
	 */
	@Override
	public String getBalanceBg() {
		return model.getBalanceBg();
	}

	/**
	 * Returns the channel ID of this themes.
	 *
	 * @return the channel ID of this themes
	 */
	@Override
	public long getChannelId() {
		return model.getChannelId();
	}

	/**
	 * Returns the company ID of this themes.
	 *
	 * @return the company ID of this themes
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this themes.
	 *
	 * @return the create date of this themes
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the dark theme of this themes.
	 *
	 * @return the dark theme of this themes
	 */
	@Override
	public boolean getDarkTheme() {
		return model.getDarkTheme();
	}

	/**
	 * Returns the default theme of this themes.
	 *
	 * @return the default theme of this themes
	 */
	@Override
	public boolean getDefaultTheme() {
		return model.getDefaultTheme();
	}

	/**
	 * Returns the entity resource ID of this themes.
	 *
	 * @return the entity resource ID of this themes
	 */
	@Override
	public long getEntityResourceId() {
		return model.getEntityResourceId();
	}

	/**
	 * Returns the error colors of this themes.
	 *
	 * @return the error colors of this themes
	 */
	@Override
	public String getErrorColors() {
		return model.getErrorColors();
	}

	/**
	 * Returns the gradient colors of this themes.
	 *
	 * @return the gradient colors of this themes
	 */
	@Override
	public String getGradientColors() {
		return model.getGradientColors();
	}

	/**
	 * Returns the group ID of this themes.
	 *
	 * @return the group ID of this themes
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the header bg of this themes.
	 *
	 * @return the header bg of this themes
	 */
	@Override
	public String getHeaderBg() {
		return model.getHeaderBg();
	}

	/**
	 * Returns the import request ID of this themes.
	 *
	 * @return the import request ID of this themes
	 */
	@Override
	public long getImportRequestId() {
		return model.getImportRequestId();
	}

	/**
	 * Returns the modified date of this themes.
	 *
	 * @return the modified date of this themes
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the neutral colors of this themes.
	 *
	 * @return the neutral colors of this themes
	 */
	@Override
	public String getNeutralColors() {
		return model.getNeutralColors();
	}

	/**
	 * Returns the original entity ID of this themes.
	 *
	 * @return the original entity ID of this themes
	 */
	@Override
	public long getOriginalEntityId() {
		return model.getOriginalEntityId();
	}

	/**
	 * Returns the primary colors of this themes.
	 *
	 * @return the primary colors of this themes
	 */
	@Override
	public String getPrimaryColors() {
		return model.getPrimaryColors();
	}

	/**
	 * Returns the primary key of this themes.
	 *
	 * @return the primary key of this themes
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the secondary colors of this themes.
	 *
	 * @return the secondary colors of this themes
	 */
	@Override
	public String getSecondaryColors() {
		return model.getSecondaryColors();
	}

	/**
	 * Returns the splash animation of this themes.
	 *
	 * @return the splash animation of this themes
	 */
	@Override
	public String getSplashAnimation() {
		return model.getSplashAnimation();
	}

	/**
	 * Returns the splash bg of this themes.
	 *
	 * @return the splash bg of this themes
	 */
	@Override
	public String getSplashBg() {
		return model.getSplashBg();
	}

	/**
	 * Returns the status of this themes.
	 *
	 * @return the status of this themes
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this themes.
	 *
	 * @return the status by user ID of this themes
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this themes.
	 *
	 * @return the status by user name of this themes
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this themes.
	 *
	 * @return the status by user uuid of this themes
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this themes.
	 *
	 * @return the status date of this themes
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the success colors of this themes.
	 *
	 * @return the success colors of this themes
	 */
	@Override
	public String getSuccessColors() {
		return model.getSuccessColors();
	}

	/**
	 * Returns the support colors of this themes.
	 *
	 * @return the support colors of this themes
	 */
	@Override
	public String getSupportColors() {
		return model.getSupportColors();
	}

	/**
	 * Returns the theme ar name of this themes.
	 *
	 * @return the theme ar name of this themes
	 */
	@Override
	public String getThemeArName() {
		return model.getThemeArName();
	}

	/**
	 * Returns the theme en name of this themes.
	 *
	 * @return the theme en name of this themes
	 */
	@Override
	public String getThemeEnName() {
		return model.getThemeEnName();
	}

	/**
	 * Returns the theme ID of this themes.
	 *
	 * @return the theme ID of this themes
	 */
	@Override
	public long getThemeId() {
		return model.getThemeId();
	}

	/**
	 * Returns the user ID of this themes.
	 *
	 * @return the user ID of this themes
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this themes.
	 *
	 * @return the user name of this themes
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this themes.
	 *
	 * @return the user uuid of this themes
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid_ of this themes.
	 *
	 * @return the uuid_ of this themes
	 */
	@Override
	public String getUuid_() {
		return model.getUuid_();
	}

	/**
	 * Returns the version of this themes.
	 *
	 * @return the version of this themes
	 */
	@Override
	public int getVersion() {
		return model.getVersion();
	}

	/**
	 * Returns the warning colors of this themes.
	 *
	 * @return the warning colors of this themes
	 */
	@Override
	public String getWarningColors() {
		return model.getWarningColors();
	}

	/**
	 * Returns the workflow action of this themes.
	 *
	 * @return the workflow action of this themes
	 */
	@Override
	public String getWorkflowAction() {
		return model.getWorkflowAction();
	}

	/**
	 * Returns <code>true</code> if this themes is approved.
	 *
	 * @return <code>true</code> if this themes is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this themes is dark theme.
	 *
	 * @return <code>true</code> if this themes is dark theme; <code>false</code> otherwise
	 */
	@Override
	public boolean isDarkTheme() {
		return model.isDarkTheme();
	}

	/**
	 * Returns <code>true</code> if this themes is default theme.
	 *
	 * @return <code>true</code> if this themes is default theme; <code>false</code> otherwise
	 */
	@Override
	public boolean isDefaultTheme() {
		return model.isDefaultTheme();
	}

	/**
	 * Returns <code>true</code> if this themes is denied.
	 *
	 * @return <code>true</code> if this themes is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this themes is a draft.
	 *
	 * @return <code>true</code> if this themes is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this themes is expired.
	 *
	 * @return <code>true</code> if this themes is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this themes is inactive.
	 *
	 * @return <code>true</code> if this themes is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this themes is incomplete.
	 *
	 * @return <code>true</code> if this themes is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this themes is pending.
	 *
	 * @return <code>true</code> if this themes is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this themes is scheduled.
	 *
	 * @return <code>true</code> if this themes is scheduled; <code>false</code> otherwise
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
	 * Sets the balance bg of this themes.
	 *
	 * @param balanceBg the balance bg of this themes
	 */
	@Override
	public void setBalanceBg(String balanceBg) {
		model.setBalanceBg(balanceBg);
	}

	/**
	 * Sets the channel ID of this themes.
	 *
	 * @param channelId the channel ID of this themes
	 */
	@Override
	public void setChannelId(long channelId) {
		model.setChannelId(channelId);
	}

	/**
	 * Sets the company ID of this themes.
	 *
	 * @param companyId the company ID of this themes
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this themes.
	 *
	 * @param createDate the create date of this themes
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this themes is dark theme.
	 *
	 * @param darkTheme the dark theme of this themes
	 */
	@Override
	public void setDarkTheme(boolean darkTheme) {
		model.setDarkTheme(darkTheme);
	}

	/**
	 * Sets whether this themes is default theme.
	 *
	 * @param defaultTheme the default theme of this themes
	 */
	@Override
	public void setDefaultTheme(boolean defaultTheme) {
		model.setDefaultTheme(defaultTheme);
	}

	/**
	 * Sets the entity resource ID of this themes.
	 *
	 * @param entityResourceId the entity resource ID of this themes
	 */
	@Override
	public void setEntityResourceId(long entityResourceId) {
		model.setEntityResourceId(entityResourceId);
	}

	/**
	 * Sets the error colors of this themes.
	 *
	 * @param errorColors the error colors of this themes
	 */
	@Override
	public void setErrorColors(String errorColors) {
		model.setErrorColors(errorColors);
	}

	/**
	 * Sets the gradient colors of this themes.
	 *
	 * @param gradientColors the gradient colors of this themes
	 */
	@Override
	public void setGradientColors(String gradientColors) {
		model.setGradientColors(gradientColors);
	}

	/**
	 * Sets the group ID of this themes.
	 *
	 * @param groupId the group ID of this themes
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the header bg of this themes.
	 *
	 * @param headerBg the header bg of this themes
	 */
	@Override
	public void setHeaderBg(String headerBg) {
		model.setHeaderBg(headerBg);
	}

	/**
	 * Sets the import request ID of this themes.
	 *
	 * @param importRequestId the import request ID of this themes
	 */
	@Override
	public void setImportRequestId(long importRequestId) {
		model.setImportRequestId(importRequestId);
	}

	/**
	 * Sets the modified date of this themes.
	 *
	 * @param modifiedDate the modified date of this themes
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the neutral colors of this themes.
	 *
	 * @param neutralColors the neutral colors of this themes
	 */
	@Override
	public void setNeutralColors(String neutralColors) {
		model.setNeutralColors(neutralColors);
	}

	/**
	 * Sets the original entity ID of this themes.
	 *
	 * @param originalEntityId the original entity ID of this themes
	 */
	@Override
	public void setOriginalEntityId(long originalEntityId) {
		model.setOriginalEntityId(originalEntityId);
	}

	/**
	 * Sets the primary colors of this themes.
	 *
	 * @param primaryColors the primary colors of this themes
	 */
	@Override
	public void setPrimaryColors(String primaryColors) {
		model.setPrimaryColors(primaryColors);
	}

	/**
	 * Sets the primary key of this themes.
	 *
	 * @param primaryKey the primary key of this themes
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the secondary colors of this themes.
	 *
	 * @param secondaryColors the secondary colors of this themes
	 */
	@Override
	public void setSecondaryColors(String secondaryColors) {
		model.setSecondaryColors(secondaryColors);
	}

	/**
	 * Sets the splash animation of this themes.
	 *
	 * @param splashAnimation the splash animation of this themes
	 */
	@Override
	public void setSplashAnimation(String splashAnimation) {
		model.setSplashAnimation(splashAnimation);
	}

	/**
	 * Sets the splash bg of this themes.
	 *
	 * @param splashBg the splash bg of this themes
	 */
	@Override
	public void setSplashBg(String splashBg) {
		model.setSplashBg(splashBg);
	}

	/**
	 * Sets the status of this themes.
	 *
	 * @param status the status of this themes
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this themes.
	 *
	 * @param statusByUserId the status by user ID of this themes
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this themes.
	 *
	 * @param statusByUserName the status by user name of this themes
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this themes.
	 *
	 * @param statusByUserUuid the status by user uuid of this themes
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this themes.
	 *
	 * @param statusDate the status date of this themes
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the success colors of this themes.
	 *
	 * @param successColors the success colors of this themes
	 */
	@Override
	public void setSuccessColors(String successColors) {
		model.setSuccessColors(successColors);
	}

	/**
	 * Sets the support colors of this themes.
	 *
	 * @param supportColors the support colors of this themes
	 */
	@Override
	public void setSupportColors(String supportColors) {
		model.setSupportColors(supportColors);
	}

	/**
	 * Sets the theme ar name of this themes.
	 *
	 * @param themeArName the theme ar name of this themes
	 */
	@Override
	public void setThemeArName(String themeArName) {
		model.setThemeArName(themeArName);
	}

	/**
	 * Sets the theme en name of this themes.
	 *
	 * @param themeEnName the theme en name of this themes
	 */
	@Override
	public void setThemeEnName(String themeEnName) {
		model.setThemeEnName(themeEnName);
	}

	/**
	 * Sets the theme ID of this themes.
	 *
	 * @param themeId the theme ID of this themes
	 */
	@Override
	public void setThemeId(long themeId) {
		model.setThemeId(themeId);
	}

	/**
	 * Sets the user ID of this themes.
	 *
	 * @param userId the user ID of this themes
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this themes.
	 *
	 * @param userName the user name of this themes
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this themes.
	 *
	 * @param userUuid the user uuid of this themes
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid_ of this themes.
	 *
	 * @param uuid_ the uuid_ of this themes
	 */
	@Override
	public void setUuid_(String uuid_) {
		model.setUuid_(uuid_);
	}

	/**
	 * Sets the version of this themes.
	 *
	 * @param version the version of this themes
	 */
	@Override
	public void setVersion(int version) {
		model.setVersion(version);
	}

	/**
	 * Sets the warning colors of this themes.
	 *
	 * @param warningColors the warning colors of this themes
	 */
	@Override
	public void setWarningColors(String warningColors) {
		model.setWarningColors(warningColors);
	}

	/**
	 * Sets the workflow action of this themes.
	 *
	 * @param workflowAction the workflow action of this themes
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
	protected ThemesWrapper wrap(Themes themes) {
		return new ThemesWrapper(themes);
	}

}