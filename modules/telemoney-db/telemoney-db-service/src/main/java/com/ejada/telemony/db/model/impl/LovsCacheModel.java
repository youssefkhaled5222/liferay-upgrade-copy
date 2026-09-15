/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model.impl;

import com.ejada.telemony.db.model.Lovs;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Lovs in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LovsCacheModel implements CacheModel<Lovs>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LovsCacheModel)) {
			return false;
		}

		LovsCacheModel lovsCacheModel = (LovsCacheModel)object;

		if (id == lovsCacheModel.id) {
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
		StringBundler sb = new StringBundler(43);

		sb.append("{defaultLanguageId=");
		sb.append(defaultLanguageId);
		sb.append(", id=");
		sb.append(id);
		sb.append(", code=");
		sb.append(code);
		sb.append(", channelId=");
		sb.append(channelId);
		sb.append(", eventCode=");
		sb.append(eventCode);
		sb.append(", count=");
		sb.append(count);
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
	public Lovs toEntityModel() {
		LovsImpl lovsImpl = new LovsImpl();

		if (defaultLanguageId == null) {
			lovsImpl.setDefaultLanguageId("");
		}
		else {
			lovsImpl.setDefaultLanguageId(defaultLanguageId);
		}

		lovsImpl.setId(id);

		if (code == null) {
			lovsImpl.setCode("");
		}
		else {
			lovsImpl.setCode(code);
		}

		lovsImpl.setChannelId(channelId);

		if (eventCode == null) {
			lovsImpl.setEventCode("");
		}
		else {
			lovsImpl.setEventCode(eventCode);
		}

		lovsImpl.setCount(count);
		lovsImpl.setGroupId(groupId);
		lovsImpl.setCompanyId(companyId);
		lovsImpl.setUserId(userId);

		if (userName == null) {
			lovsImpl.setUserName("");
		}
		else {
			lovsImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			lovsImpl.setCreateDate(null);
		}
		else {
			lovsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			lovsImpl.setModifiedDate(null);
		}
		else {
			lovsImpl.setModifiedDate(new Date(modifiedDate));
		}

		lovsImpl.setStatus(status);
		lovsImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			lovsImpl.setStatusByUserName("");
		}
		else {
			lovsImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			lovsImpl.setStatusDate(null);
		}
		else {
			lovsImpl.setStatusDate(new Date(statusDate));
		}

		if (uuid_ == null) {
			lovsImpl.setUuid_("");
		}
		else {
			lovsImpl.setUuid_(uuid_);
		}

		lovsImpl.setOriginalEntityId(originalEntityId);
		lovsImpl.setEntityResourceId(entityResourceId);
		lovsImpl.setVersion(version);

		if (workflowAction == null) {
			lovsImpl.setWorkflowAction("");
		}
		else {
			lovsImpl.setWorkflowAction(workflowAction);
		}

		lovsImpl.resetOriginalValues();

		return lovsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		defaultLanguageId = objectInput.readUTF();

		id = objectInput.readLong();
		code = objectInput.readUTF();

		channelId = objectInput.readLong();
		eventCode = objectInput.readUTF();

		count = objectInput.readInt();

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
		if (defaultLanguageId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(defaultLanguageId);
		}

		objectOutput.writeLong(id);

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}

		objectOutput.writeLong(channelId);

		if (eventCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(eventCode);
		}

		objectOutput.writeInt(count);

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

	public String defaultLanguageId;
	public long id;
	public String code;
	public long channelId;
	public String eventCode;
	public int count;
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