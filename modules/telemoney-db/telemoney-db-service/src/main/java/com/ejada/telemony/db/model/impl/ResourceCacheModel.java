/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model.impl;

import com.ejada.telemony.db.model.Resource;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Resource in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ResourceCacheModel
	implements CacheModel<Resource>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ResourceCacheModel)) {
			return false;
		}

		ResourceCacheModel resourceCacheModel = (ResourceCacheModel)object;

		if (resourceId == resourceCacheModel.resourceId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, resourceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{defaultLanguageId=");
		sb.append(defaultLanguageId);
		sb.append(", resourceId=");
		sb.append(resourceId);
		sb.append(", channelId=");
		sb.append(channelId);
		sb.append(", resourceCode=");
		sb.append(resourceCode);
		sb.append(", resourceType=");
		sb.append(resourceType);
		sb.append(", urlType=");
		sb.append(urlType);
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
		sb.append(", featureId=");
		sb.append(featureId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Resource toEntityModel() {
		ResourceImpl resourceImpl = new ResourceImpl();

		if (defaultLanguageId == null) {
			resourceImpl.setDefaultLanguageId("");
		}
		else {
			resourceImpl.setDefaultLanguageId(defaultLanguageId);
		}

		resourceImpl.setResourceId(resourceId);
		resourceImpl.setChannelId(channelId);

		if (resourceCode == null) {
			resourceImpl.setResourceCode("");
		}
		else {
			resourceImpl.setResourceCode(resourceCode);
		}

		if (resourceType == null) {
			resourceImpl.setResourceType("");
		}
		else {
			resourceImpl.setResourceType(resourceType);
		}

		if (urlType == null) {
			resourceImpl.setUrlType("");
		}
		else {
			resourceImpl.setUrlType(urlType);
		}

		resourceImpl.setGroupId(groupId);
		resourceImpl.setCompanyId(companyId);
		resourceImpl.setUserId(userId);

		if (userName == null) {
			resourceImpl.setUserName("");
		}
		else {
			resourceImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			resourceImpl.setCreateDate(null);
		}
		else {
			resourceImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			resourceImpl.setModifiedDate(null);
		}
		else {
			resourceImpl.setModifiedDate(new Date(modifiedDate));
		}

		resourceImpl.setStatus(status);
		resourceImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			resourceImpl.setStatusByUserName("");
		}
		else {
			resourceImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			resourceImpl.setStatusDate(null);
		}
		else {
			resourceImpl.setStatusDate(new Date(statusDate));
		}

		if (uuid_ == null) {
			resourceImpl.setUuid_("");
		}
		else {
			resourceImpl.setUuid_(uuid_);
		}

		resourceImpl.setOriginalEntityId(originalEntityId);
		resourceImpl.setEntityResourceId(entityResourceId);
		resourceImpl.setVersion(version);

		if (workflowAction == null) {
			resourceImpl.setWorkflowAction("");
		}
		else {
			resourceImpl.setWorkflowAction(workflowAction);
		}

		resourceImpl.setFeatureId(featureId);

		resourceImpl.resetOriginalValues();

		return resourceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		defaultLanguageId = objectInput.readUTF();

		resourceId = objectInput.readLong();

		channelId = objectInput.readLong();
		resourceCode = objectInput.readUTF();
		resourceType = objectInput.readUTF();
		urlType = objectInput.readUTF();

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

		featureId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (defaultLanguageId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(defaultLanguageId);
		}

		objectOutput.writeLong(resourceId);

		objectOutput.writeLong(channelId);

		if (resourceCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(resourceCode);
		}

		if (resourceType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(resourceType);
		}

		if (urlType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(urlType);
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

		objectOutput.writeLong(originalEntityId);

		objectOutput.writeLong(entityResourceId);

		objectOutput.writeInt(version);

		if (workflowAction == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(workflowAction);
		}

		objectOutput.writeLong(featureId);
	}

	public String defaultLanguageId;
	public long resourceId;
	public long channelId;
	public String resourceCode;
	public String resourceType;
	public String urlType;
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
	public long featureId;

}