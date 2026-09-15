/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model.impl;

import com.ejada.telemony.db.model.Feature;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Feature in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FeatureCacheModel implements CacheModel<Feature>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FeatureCacheModel)) {
			return false;
		}

		FeatureCacheModel featureCacheModel = (FeatureCacheModel)object;

		if (featureId == featureCacheModel.featureId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, featureId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{featureId=");
		sb.append(featureId);
		sb.append(", featureName=");
		sb.append(featureName);
		sb.append(", pageType=");
		sb.append(pageType);
		sb.append(", parentPage=");
		sb.append(parentPage);
		sb.append(", routeId=");
		sb.append(routeId);
		sb.append(", featureStatus=");
		sb.append(featureStatus);
		sb.append(", blockId=");
		sb.append(blockId);
		sb.append(", channelId=");
		sb.append(channelId);
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
		sb.append(", childResourceId=");
		sb.append(childResourceId);
		sb.append(", version=");
		sb.append(version);
		sb.append(", workflowAction=");
		sb.append(workflowAction);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Feature toEntityModel() {
		FeatureImpl featureImpl = new FeatureImpl();

		featureImpl.setFeatureId(featureId);

		if (featureName == null) {
			featureImpl.setFeatureName("");
		}
		else {
			featureImpl.setFeatureName(featureName);
		}

		if (pageType == null) {
			featureImpl.setPageType("");
		}
		else {
			featureImpl.setPageType(pageType);
		}

		featureImpl.setParentPage(parentPage);

		if (routeId == null) {
			featureImpl.setRouteId("");
		}
		else {
			featureImpl.setRouteId(routeId);
		}

		featureImpl.setFeatureStatus(featureStatus);
		featureImpl.setBlockId(blockId);
		featureImpl.setChannelId(channelId);
		featureImpl.setGroupId(groupId);
		featureImpl.setCompanyId(companyId);
		featureImpl.setUserId(userId);

		if (userName == null) {
			featureImpl.setUserName("");
		}
		else {
			featureImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			featureImpl.setCreateDate(null);
		}
		else {
			featureImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			featureImpl.setModifiedDate(null);
		}
		else {
			featureImpl.setModifiedDate(new Date(modifiedDate));
		}

		featureImpl.setStatus(status);
		featureImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			featureImpl.setStatusByUserName("");
		}
		else {
			featureImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			featureImpl.setStatusDate(null);
		}
		else {
			featureImpl.setStatusDate(new Date(statusDate));
		}

		if (uuid_ == null) {
			featureImpl.setUuid_("");
		}
		else {
			featureImpl.setUuid_(uuid_);
		}

		featureImpl.setOriginalEntityId(originalEntityId);
		featureImpl.setEntityResourceId(entityResourceId);
		featureImpl.setChildResourceId(childResourceId);
		featureImpl.setVersion(version);

		if (workflowAction == null) {
			featureImpl.setWorkflowAction("");
		}
		else {
			featureImpl.setWorkflowAction(workflowAction);
		}

		featureImpl.resetOriginalValues();

		return featureImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		featureId = objectInput.readLong();
		featureName = objectInput.readUTF();
		pageType = objectInput.readUTF();

		parentPage = objectInput.readLong();
		routeId = objectInput.readUTF();

		featureStatus = objectInput.readBoolean();

		blockId = objectInput.readLong();

		channelId = objectInput.readLong();

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

		childResourceId = objectInput.readLong();

		version = objectInput.readInt();
		workflowAction = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(featureId);

		if (featureName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(featureName);
		}

		if (pageType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pageType);
		}

		objectOutput.writeLong(parentPage);

		if (routeId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(routeId);
		}

		objectOutput.writeBoolean(featureStatus);

		objectOutput.writeLong(blockId);

		objectOutput.writeLong(channelId);

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

		objectOutput.writeLong(childResourceId);

		objectOutput.writeInt(version);

		if (workflowAction == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(workflowAction);
		}
	}

	public long featureId;
	public String featureName;
	public String pageType;
	public long parentPage;
	public String routeId;
	public boolean featureStatus;
	public long blockId;
	public long channelId;
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
	public long childResourceId;
	public int version;
	public String workflowAction;

}