/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model.impl;

import com.ejada.telemony.db.model.AppEnvironment;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AppEnvironment in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AppEnvironmentCacheModel
	implements CacheModel<AppEnvironment>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AppEnvironmentCacheModel)) {
			return false;
		}

		AppEnvironmentCacheModel appEnvironmentCacheModel =
			(AppEnvironmentCacheModel)object;

		if (environmentId == appEnvironmentCacheModel.environmentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, environmentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{environmentId=");
		sb.append(environmentId);
		sb.append(", channelId=");
		sb.append(channelId);
		sb.append(", environmentName=");
		sb.append(environmentName);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", uuid_=");
		sb.append(uuid_);
		sb.append(", originalEntityId=");
		sb.append(originalEntityId);
		sb.append(", entityResourceId=");
		sb.append(entityResourceId);
		sb.append(", version=");
		sb.append(version);
		sb.append(", workflowAction=");
		sb.append(workflowAction);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AppEnvironment toEntityModel() {
		AppEnvironmentImpl appEnvironmentImpl = new AppEnvironmentImpl();

		appEnvironmentImpl.setEnvironmentId(environmentId);
		appEnvironmentImpl.setChannelId(channelId);

		if (environmentName == null) {
			appEnvironmentImpl.setEnvironmentName("");
		}
		else {
			appEnvironmentImpl.setEnvironmentName(environmentName);
		}

		appEnvironmentImpl.setGroupId(groupId);
		appEnvironmentImpl.setCompanyId(companyId);
		appEnvironmentImpl.setUserId(userId);

		if (userName == null) {
			appEnvironmentImpl.setUserName("");
		}
		else {
			appEnvironmentImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			appEnvironmentImpl.setCreateDate(null);
		}
		else {
			appEnvironmentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			appEnvironmentImpl.setModifiedDate(null);
		}
		else {
			appEnvironmentImpl.setModifiedDate(new Date(modifiedDate));
		}

		appEnvironmentImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			appEnvironmentImpl.setStatusByUserName("");
		}
		else {
			appEnvironmentImpl.setStatusByUserName(statusByUserName);
		}

		appEnvironmentImpl.setStatus(status);

		if (statusDate == Long.MIN_VALUE) {
			appEnvironmentImpl.setStatusDate(null);
		}
		else {
			appEnvironmentImpl.setStatusDate(new Date(statusDate));
		}

		if (uuid_ == null) {
			appEnvironmentImpl.setUuid_("");
		}
		else {
			appEnvironmentImpl.setUuid_(uuid_);
		}

		appEnvironmentImpl.setOriginalEntityId(originalEntityId);
		appEnvironmentImpl.setEntityResourceId(entityResourceId);
		appEnvironmentImpl.setVersion(version);

		if (workflowAction == null) {
			appEnvironmentImpl.setWorkflowAction("");
		}
		else {
			appEnvironmentImpl.setWorkflowAction(workflowAction);
		}

		appEnvironmentImpl.resetOriginalValues();

		return appEnvironmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		environmentId = objectInput.readLong();

		channelId = objectInput.readLong();
		environmentName = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();

		status = objectInput.readInt();
		statusDate = objectInput.readLong();
		uuid_ = objectInput.readUTF();

		originalEntityId = objectInput.readLong();

		entityResourceId = objectInput.readLong();

		version = objectInput.readInt();
		workflowAction = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(environmentId);

		objectOutput.writeLong(channelId);

		if (environmentName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(environmentName);
		}

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeInt(status);
		objectOutput.writeLong(statusDate);

		if (uuid_ == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid_);
		}

		objectOutput.writeLong(originalEntityId);

		objectOutput.writeLong(entityResourceId);

		objectOutput.writeInt(version);

		if (workflowAction == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(workflowAction);
		}
	}

	public long environmentId;
	public long channelId;
	public String environmentName;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long statusByUserId;
	public String statusByUserName;
	public int status;
	public long statusDate;
	public String uuid_;
	public long originalEntityId;
	public long entityResourceId;
	public int version;
	public String workflowAction;

}