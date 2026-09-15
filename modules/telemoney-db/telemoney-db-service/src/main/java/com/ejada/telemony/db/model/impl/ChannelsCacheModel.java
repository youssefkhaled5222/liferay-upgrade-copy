/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model.impl;

import com.ejada.telemony.db.model.Channels;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Channels in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ChannelsCacheModel
	implements CacheModel<Channels>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ChannelsCacheModel)) {
			return false;
		}

		ChannelsCacheModel channelsCacheModel = (ChannelsCacheModel)object;

		if (channelId == channelsCacheModel.channelId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, channelId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{channelId=");
		sb.append(channelId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", type=");
		sb.append(type);
		sb.append(", description=");
		sb.append(description);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Channels toEntityModel() {
		ChannelsImpl channelsImpl = new ChannelsImpl();

		channelsImpl.setChannelId(channelId);

		if (name == null) {
			channelsImpl.setName("");
		}
		else {
			channelsImpl.setName(name);
		}

		if (type == null) {
			channelsImpl.setType("");
		}
		else {
			channelsImpl.setType(type);
		}

		if (description == null) {
			channelsImpl.setDescription("");
		}
		else {
			channelsImpl.setDescription(description);
		}

		channelsImpl.setGroupId(groupId);
		channelsImpl.setCompanyId(companyId);
		channelsImpl.setUserId(userId);

		if (userName == null) {
			channelsImpl.setUserName("");
		}
		else {
			channelsImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			channelsImpl.setCreateDate(null);
		}
		else {
			channelsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			channelsImpl.setModifiedDate(null);
		}
		else {
			channelsImpl.setModifiedDate(new Date(modifiedDate));
		}

		channelsImpl.setStatus(status);
		channelsImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			channelsImpl.setStatusByUserName("");
		}
		else {
			channelsImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			channelsImpl.setStatusDate(null);
		}
		else {
			channelsImpl.setStatusDate(new Date(statusDate));
		}

		if (uuid_ == null) {
			channelsImpl.setUuid_("");
		}
		else {
			channelsImpl.setUuid_(uuid_);
		}

		channelsImpl.resetOriginalValues();

		return channelsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		channelId = objectInput.readLong();
		name = objectInput.readUTF();
		type = objectInput.readUTF();
		description = objectInput.readUTF();

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
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(channelId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
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
	}

	public long channelId;
	public String name;
	public String type;
	public String description;
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

}