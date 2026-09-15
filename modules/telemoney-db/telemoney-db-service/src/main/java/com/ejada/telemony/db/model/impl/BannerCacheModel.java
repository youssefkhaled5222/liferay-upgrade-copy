/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model.impl;

import com.ejada.telemony.db.model.Banner;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Banner in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BannerCacheModel implements CacheModel<Banner>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BannerCacheModel)) {
			return false;
		}

		BannerCacheModel bannerCacheModel = (BannerCacheModel)object;

		if (bannerId == bannerCacheModel.bannerId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, bannerId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(51);

		sb.append("{bannerId=");
		sb.append(bannerId);
		sb.append(", channelId=");
		sb.append(channelId);
		sb.append(", bannerName=");
		sb.append(bannerName);
		sb.append(", bannerType=");
		sb.append(bannerType);
		sb.append(", container=");
		sb.append(container);
		sb.append(", dateFrom=");
		sb.append(dateFrom);
		sb.append(", dateTo=");
		sb.append(dateTo);
		sb.append(", blockId=");
		sb.append(blockId);
		sb.append(", persona=");
		sb.append(persona);
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
		sb.append(", importRequestId=");
		sb.append(importRequestId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Banner toEntityModel() {
		BannerImpl bannerImpl = new BannerImpl();

		bannerImpl.setBannerId(bannerId);
		bannerImpl.setChannelId(channelId);

		if (bannerName == null) {
			bannerImpl.setBannerName("");
		}
		else {
			bannerImpl.setBannerName(bannerName);
		}

		if (bannerType == null) {
			bannerImpl.setBannerType("");
		}
		else {
			bannerImpl.setBannerType(bannerType);
		}

		if (container == null) {
			bannerImpl.setContainer("");
		}
		else {
			bannerImpl.setContainer(container);
		}

		if (dateFrom == Long.MIN_VALUE) {
			bannerImpl.setDateFrom(null);
		}
		else {
			bannerImpl.setDateFrom(new Date(dateFrom));
		}

		if (dateTo == Long.MIN_VALUE) {
			bannerImpl.setDateTo(null);
		}
		else {
			bannerImpl.setDateTo(new Date(dateTo));
		}

		bannerImpl.setBlockId(blockId);

		if (persona == null) {
			bannerImpl.setPersona("");
		}
		else {
			bannerImpl.setPersona(persona);
		}

		bannerImpl.setGroupId(groupId);
		bannerImpl.setCompanyId(companyId);
		bannerImpl.setUserId(userId);

		if (userName == null) {
			bannerImpl.setUserName("");
		}
		else {
			bannerImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			bannerImpl.setCreateDate(null);
		}
		else {
			bannerImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			bannerImpl.setModifiedDate(null);
		}
		else {
			bannerImpl.setModifiedDate(new Date(modifiedDate));
		}

		bannerImpl.setStatus(status);
		bannerImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			bannerImpl.setStatusByUserName("");
		}
		else {
			bannerImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			bannerImpl.setStatusDate(null);
		}
		else {
			bannerImpl.setStatusDate(new Date(statusDate));
		}

		if (uuid_ == null) {
			bannerImpl.setUuid_("");
		}
		else {
			bannerImpl.setUuid_(uuid_);
		}

		bannerImpl.setOriginalEntityId(originalEntityId);
		bannerImpl.setEntityResourceId(entityResourceId);
		bannerImpl.setVersion(version);

		if (workflowAction == null) {
			bannerImpl.setWorkflowAction("");
		}
		else {
			bannerImpl.setWorkflowAction(workflowAction);
		}

		bannerImpl.setImportRequestId(importRequestId);

		bannerImpl.resetOriginalValues();

		return bannerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		bannerId = objectInput.readLong();

		channelId = objectInput.readLong();
		bannerName = objectInput.readUTF();
		bannerType = objectInput.readUTF();
		container = objectInput.readUTF();
		dateFrom = objectInput.readLong();
		dateTo = objectInput.readLong();

		blockId = objectInput.readLong();
		persona = objectInput.readUTF();

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

		importRequestId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(bannerId);

		objectOutput.writeLong(channelId);

		if (bannerName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bannerName);
		}

		if (bannerType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bannerType);
		}

		if (container == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(container);
		}

		objectOutput.writeLong(dateFrom);
		objectOutput.writeLong(dateTo);

		objectOutput.writeLong(blockId);

		if (persona == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(persona);
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

		objectOutput.writeLong(importRequestId);
	}

	public long bannerId;
	public long channelId;
	public String bannerName;
	public String bannerType;
	public String container;
	public long dateFrom;
	public long dateTo;
	public long blockId;
	public String persona;
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
	public long importRequestId;

}