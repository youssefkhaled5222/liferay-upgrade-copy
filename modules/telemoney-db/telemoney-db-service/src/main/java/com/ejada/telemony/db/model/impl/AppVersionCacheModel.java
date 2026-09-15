/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model.impl;

import com.ejada.telemony.db.model.AppVersion;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AppVersion in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AppVersionCacheModel
	implements CacheModel<AppVersion>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AppVersionCacheModel)) {
			return false;
		}

		AppVersionCacheModel appVersionCacheModel =
			(AppVersionCacheModel)object;

		if (versionId == appVersionCacheModel.versionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, versionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{versionId=");
		sb.append(versionId);
		sb.append(", channelId=");
		sb.append(channelId);
		sb.append(", platform=");
		sb.append(platform);
		sb.append(", versionNumber=");
		sb.append(versionNumber);
		sb.append(", url=");
		sb.append(url);
		sb.append(", appVersionStatus=");
		sb.append(appVersionStatus);
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
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
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
	public AppVersion toEntityModel() {
		AppVersionImpl appVersionImpl = new AppVersionImpl();

		appVersionImpl.setVersionId(versionId);
		appVersionImpl.setChannelId(channelId);

		if (platform == null) {
			appVersionImpl.setPlatform("");
		}
		else {
			appVersionImpl.setPlatform(platform);
		}

		if (versionNumber == null) {
			appVersionImpl.setVersionNumber("");
		}
		else {
			appVersionImpl.setVersionNumber(versionNumber);
		}

		if (url == null) {
			appVersionImpl.setUrl("");
		}
		else {
			appVersionImpl.setUrl(url);
		}

		appVersionImpl.setAppVersionStatus(appVersionStatus);
		appVersionImpl.setGroupId(groupId);
		appVersionImpl.setCompanyId(companyId);
		appVersionImpl.setUserId(userId);

		if (userName == null) {
			appVersionImpl.setUserName("");
		}
		else {
			appVersionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			appVersionImpl.setCreateDate(null);
		}
		else {
			appVersionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			appVersionImpl.setModifiedDate(null);
		}
		else {
			appVersionImpl.setModifiedDate(new Date(modifiedDate));
		}

		appVersionImpl.setStatus(status);
		appVersionImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			appVersionImpl.setStatusByUserName("");
		}
		else {
			appVersionImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			appVersionImpl.setStatusDate(null);
		}
		else {
			appVersionImpl.setStatusDate(new Date(statusDate));
		}

		if (uuid_ == null) {
			appVersionImpl.setUuid_("");
		}
		else {
			appVersionImpl.setUuid_(uuid_);
		}

		appVersionImpl.setOriginalEntityId(originalEntityId);
		appVersionImpl.setEntityResourceId(entityResourceId);
		appVersionImpl.setVersion(version);

		if (workflowAction == null) {
			appVersionImpl.setWorkflowAction("");
		}
		else {
			appVersionImpl.setWorkflowAction(workflowAction);
		}

		appVersionImpl.resetOriginalValues();

		return appVersionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		versionId = objectInput.readLong();

		channelId = objectInput.readLong();
		platform = objectInput.readUTF();
		versionNumber = objectInput.readUTF();
		url = objectInput.readUTF();

		appVersionStatus = objectInput.readBoolean();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		uuid_ = objectInput.readUTF();

		originalEntityId = objectInput.readLong();

		entityResourceId = objectInput.readLong();

		version = objectInput.readInt();
		workflowAction = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(versionId);

		objectOutput.writeLong(channelId);

		if (platform == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(platform);
		}

		if (versionNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(versionNumber);
		}

		if (url == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(url);
		}

		objectOutput.writeBoolean(appVersionStatus);

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

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

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

	public long versionId;
	public long channelId;
	public String platform;
	public String versionNumber;
	public String url;
	public boolean appVersionStatus;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public String uuid_;
	public long originalEntityId;
	public long entityResourceId;
	public int version;
	public String workflowAction;

}