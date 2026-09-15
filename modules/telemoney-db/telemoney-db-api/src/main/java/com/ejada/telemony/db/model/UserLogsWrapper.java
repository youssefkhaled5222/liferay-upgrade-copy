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
 * This class is a wrapper for {@link UserLogs}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserLogs
 * @generated
 */
public class UserLogsWrapper
	extends BaseModelWrapper<UserLogs>
	implements ModelWrapper<UserLogs>, UserLogs {

	public UserLogsWrapper(UserLogs userLogs) {
		super(userLogs);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("logsId", getLogsId());
		attributes.put("userName", getUserName());
		attributes.put("userActivity", getUserActivity());
		attributes.put("logTime", getLogTime());
		attributes.put("channelId", getChannelId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long logsId = (Long)attributes.get("logsId");

		if (logsId != null) {
			setLogsId(logsId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		String userActivity = (String)attributes.get("userActivity");

		if (userActivity != null) {
			setUserActivity(userActivity);
		}

		Date logTime = (Date)attributes.get("logTime");

		if (logTime != null) {
			setLogTime(logTime);
		}

		Long channelId = (Long)attributes.get("channelId");

		if (channelId != null) {
			setChannelId(channelId);
		}
	}

	@Override
	public UserLogs cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the channel ID of this user logs.
	 *
	 * @return the channel ID of this user logs
	 */
	@Override
	public long getChannelId() {
		return model.getChannelId();
	}

	/**
	 * Returns the logs ID of this user logs.
	 *
	 * @return the logs ID of this user logs
	 */
	@Override
	public long getLogsId() {
		return model.getLogsId();
	}

	/**
	 * Returns the log time of this user logs.
	 *
	 * @return the log time of this user logs
	 */
	@Override
	public Date getLogTime() {
		return model.getLogTime();
	}

	/**
	 * Returns the primary key of this user logs.
	 *
	 * @return the primary key of this user logs
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user activity of this user logs.
	 *
	 * @return the user activity of this user logs
	 */
	@Override
	public String getUserActivity() {
		return model.getUserActivity();
	}

	/**
	 * Returns the user name of this user logs.
	 *
	 * @return the user name of this user logs
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the channel ID of this user logs.
	 *
	 * @param channelId the channel ID of this user logs
	 */
	@Override
	public void setChannelId(long channelId) {
		model.setChannelId(channelId);
	}

	/**
	 * Sets the logs ID of this user logs.
	 *
	 * @param logsId the logs ID of this user logs
	 */
	@Override
	public void setLogsId(long logsId) {
		model.setLogsId(logsId);
	}

	/**
	 * Sets the log time of this user logs.
	 *
	 * @param logTime the log time of this user logs
	 */
	@Override
	public void setLogTime(Date logTime) {
		model.setLogTime(logTime);
	}

	/**
	 * Sets the primary key of this user logs.
	 *
	 * @param primaryKey the primary key of this user logs
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user activity of this user logs.
	 *
	 * @param userActivity the user activity of this user logs
	 */
	@Override
	public void setUserActivity(String userActivity) {
		model.setUserActivity(userActivity);
	}

	/**
	 * Sets the user name of this user logs.
	 *
	 * @param userName the user name of this user logs
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected UserLogsWrapper wrap(UserLogs userLogs) {
		return new UserLogsWrapper(userLogs);
	}

}