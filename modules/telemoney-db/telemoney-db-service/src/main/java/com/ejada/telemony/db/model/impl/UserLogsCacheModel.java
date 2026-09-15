/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model.impl;

import com.ejada.telemony.db.model.UserLogs;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserLogs in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UserLogsCacheModel
	implements CacheModel<UserLogs>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserLogsCacheModel)) {
			return false;
		}

		UserLogsCacheModel userLogsCacheModel = (UserLogsCacheModel)object;

		if (logsId == userLogsCacheModel.logsId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, logsId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{logsId=");
		sb.append(logsId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", userActivity=");
		sb.append(userActivity);
		sb.append(", logTime=");
		sb.append(logTime);
		sb.append(", channelId=");
		sb.append(channelId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserLogs toEntityModel() {
		UserLogsImpl userLogsImpl = new UserLogsImpl();

		userLogsImpl.setLogsId(logsId);

		if (userName == null) {
			userLogsImpl.setUserName("");
		}
		else {
			userLogsImpl.setUserName(userName);
		}

		if (userActivity == null) {
			userLogsImpl.setUserActivity("");
		}
		else {
			userLogsImpl.setUserActivity(userActivity);
		}

		if (logTime == Long.MIN_VALUE) {
			userLogsImpl.setLogTime(null);
		}
		else {
			userLogsImpl.setLogTime(new Date(logTime));
		}

		userLogsImpl.setChannelId(channelId);

		userLogsImpl.resetOriginalValues();

		return userLogsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		logsId = objectInput.readLong();
		userName = objectInput.readUTF();
		userActivity = objectInput.readUTF();
		logTime = objectInput.readLong();

		channelId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(logsId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		if (userActivity == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userActivity);
		}

		objectOutput.writeLong(logTime);

		objectOutput.writeLong(channelId);
	}

	public long logsId;
	public String userName;
	public String userActivity;
	public long logTime;
	public long channelId;

}