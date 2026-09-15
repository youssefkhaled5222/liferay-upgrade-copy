/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model.impl;

import com.ejada.telemony.db.model.ConfigurationEntity;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ConfigurationEntity in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ConfigurationEntityCacheModel
	implements CacheModel<ConfigurationEntity>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ConfigurationEntityCacheModel)) {
			return false;
		}

		ConfigurationEntityCacheModel configurationEntityCacheModel =
			(ConfigurationEntityCacheModel)object;

		if (id == configurationEntityCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{id=");
		sb.append(id);
		sb.append(", url=");
		sb.append(url);
		sb.append(", oldData=");
		sb.append(oldData);
		sb.append(", newData=");
		sb.append(newData);
		sb.append(", entityType=");
		sb.append(entityType);
		sb.append(", entityId=");
		sb.append(entityId);
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
		sb.append(", workflowAction=");
		sb.append(workflowAction);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ConfigurationEntity toEntityModel() {
		ConfigurationEntityImpl configurationEntityImpl =
			new ConfigurationEntityImpl();

		configurationEntityImpl.setId(id);

		if (url == null) {
			configurationEntityImpl.setUrl("");
		}
		else {
			configurationEntityImpl.setUrl(url);
		}

		if (oldData == null) {
			configurationEntityImpl.setOldData("");
		}
		else {
			configurationEntityImpl.setOldData(oldData);
		}

		if (newData == null) {
			configurationEntityImpl.setNewData("");
		}
		else {
			configurationEntityImpl.setNewData(newData);
		}

		if (entityType == null) {
			configurationEntityImpl.setEntityType("");
		}
		else {
			configurationEntityImpl.setEntityType(entityType);
		}

		if (entityId == null) {
			configurationEntityImpl.setEntityId("");
		}
		else {
			configurationEntityImpl.setEntityId(entityId);
		}

		configurationEntityImpl.setGroupId(groupId);
		configurationEntityImpl.setCompanyId(companyId);
		configurationEntityImpl.setUserId(userId);

		if (userName == null) {
			configurationEntityImpl.setUserName("");
		}
		else {
			configurationEntityImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			configurationEntityImpl.setCreateDate(null);
		}
		else {
			configurationEntityImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			configurationEntityImpl.setModifiedDate(null);
		}
		else {
			configurationEntityImpl.setModifiedDate(new Date(modifiedDate));
		}

		configurationEntityImpl.setStatus(status);
		configurationEntityImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			configurationEntityImpl.setStatusByUserName("");
		}
		else {
			configurationEntityImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			configurationEntityImpl.setStatusDate(null);
		}
		else {
			configurationEntityImpl.setStatusDate(new Date(statusDate));
		}

		if (uuid_ == null) {
			configurationEntityImpl.setUuid_("");
		}
		else {
			configurationEntityImpl.setUuid_(uuid_);
		}

		if (workflowAction == null) {
			configurationEntityImpl.setWorkflowAction("");
		}
		else {
			configurationEntityImpl.setWorkflowAction(workflowAction);
		}

		configurationEntityImpl.resetOriginalValues();

		return configurationEntityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		url = objectInput.readUTF();
		oldData = objectInput.readUTF();
		newData = objectInput.readUTF();
		entityType = objectInput.readUTF();
		entityId = objectInput.readUTF();

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
		workflowAction = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		if (url == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(url);
		}

		if (oldData == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(oldData);
		}

		if (newData == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(newData);
		}

		if (entityType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(entityType);
		}

		if (entityId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(entityId);
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

		if (workflowAction == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(workflowAction);
		}
	}

	public long id;
	public String url;
	public String oldData;
	public String newData;
	public String entityType;
	public String entityId;
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
	public String workflowAction;

}