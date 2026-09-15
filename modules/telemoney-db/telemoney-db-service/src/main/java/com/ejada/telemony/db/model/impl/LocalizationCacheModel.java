/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model.impl;

import com.ejada.telemony.db.model.Localization;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Localization in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LocalizationCacheModel
	implements CacheModel<Localization>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LocalizationCacheModel)) {
			return false;
		}

		LocalizationCacheModel localizationCacheModel =
			(LocalizationCacheModel)object;

		if (localizationId == localizationCacheModel.localizationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, localizationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{localizationId=");
		sb.append(localizationId);
		sb.append(", localValue=");
		sb.append(localValue);
		sb.append(", version=");
		sb.append(version);
		sb.append(", languageId=");
		sb.append(languageId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", channelId=");
		sb.append(channelId);
		sb.append(", featureId=");
		sb.append(featureId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
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
		sb.append(", workflowBatchId=");
		sb.append(workflowBatchId);
		sb.append(", globalVersion=");
		sb.append(globalVersion);
		sb.append(", importRequestId=");
		sb.append(importRequestId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Localization toEntityModel() {
		LocalizationImpl localizationImpl = new LocalizationImpl();

		localizationImpl.setLocalizationId(localizationId);

		if (localValue == null) {
			localizationImpl.setLocalValue("");
		}
		else {
			localizationImpl.setLocalValue(localValue);
		}

		localizationImpl.setVersion(version);
		localizationImpl.setLanguageId(languageId);

		if (userName == null) {
			localizationImpl.setUserName("");
		}
		else {
			localizationImpl.setUserName(userName);
		}

		localizationImpl.setChannelId(channelId);
		localizationImpl.setFeatureId(featureId);
		localizationImpl.setGroupId(groupId);
		localizationImpl.setCompanyId(companyId);
		localizationImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			localizationImpl.setCreateDate(null);
		}
		else {
			localizationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			localizationImpl.setModifiedDate(null);
		}
		else {
			localizationImpl.setModifiedDate(new Date(modifiedDate));
		}

		localizationImpl.setStatus(status);
		localizationImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			localizationImpl.setStatusByUserName("");
		}
		else {
			localizationImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			localizationImpl.setStatusDate(null);
		}
		else {
			localizationImpl.setStatusDate(new Date(statusDate));
		}

		if (uuid_ == null) {
			localizationImpl.setUuid_("");
		}
		else {
			localizationImpl.setUuid_(uuid_);
		}

		localizationImpl.setOriginalEntityId(originalEntityId);
		localizationImpl.setEntityResourceId(entityResourceId);

		if (workflowBatchId == null) {
			localizationImpl.setWorkflowBatchId("");
		}
		else {
			localizationImpl.setWorkflowBatchId(workflowBatchId);
		}

		localizationImpl.setGlobalVersion(globalVersion);
		localizationImpl.setImportRequestId(importRequestId);

		localizationImpl.resetOriginalValues();

		return localizationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		localizationId = objectInput.readLong();
		localValue = objectInput.readUTF();

		version = objectInput.readLong();

		languageId = objectInput.readLong();
		userName = objectInput.readUTF();

		channelId = objectInput.readLong();

		featureId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		uuid_ = objectInput.readUTF();

		originalEntityId = objectInput.readLong();

		entityResourceId = objectInput.readLong();
		workflowBatchId = objectInput.readUTF();

		globalVersion = objectInput.readLong();

		importRequestId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(localizationId);

		if (localValue == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(localValue);
		}

		objectOutput.writeLong(version);

		objectOutput.writeLong(languageId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(channelId);

		objectOutput.writeLong(featureId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
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

		if (workflowBatchId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(workflowBatchId);
		}

		objectOutput.writeLong(globalVersion);

		objectOutput.writeLong(importRequestId);
	}

	public long localizationId;
	public String localValue;
	public long version;
	public long languageId;
	public String userName;
	public long channelId;
	public long featureId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public String uuid_;
	public long originalEntityId;
	public long entityResourceId;
	public String workflowBatchId;
	public long globalVersion;
	public long importRequestId;

}