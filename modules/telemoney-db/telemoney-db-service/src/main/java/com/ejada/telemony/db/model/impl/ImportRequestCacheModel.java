/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model.impl;

import com.ejada.telemony.db.model.ImportRequest;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ImportRequest in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ImportRequestCacheModel
	implements CacheModel<ImportRequest>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ImportRequestCacheModel)) {
			return false;
		}

		ImportRequestCacheModel importRequestCacheModel =
			(ImportRequestCacheModel)object;

		if (id == importRequestCacheModel.id) {
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
		StringBundler sb = new StringBundler(31);

		sb.append("{id=");
		sb.append(id);
		sb.append(", type=");
		sb.append(type);
		sb.append(", fileName=");
		sb.append(fileName);
		sb.append(", filePath=");
		sb.append(filePath);
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
	public ImportRequest toEntityModel() {
		ImportRequestImpl importRequestImpl = new ImportRequestImpl();

		importRequestImpl.setId(id);

		if (type == null) {
			importRequestImpl.setType("");
		}
		else {
			importRequestImpl.setType(type);
		}

		if (fileName == null) {
			importRequestImpl.setFileName("");
		}
		else {
			importRequestImpl.setFileName(fileName);
		}

		if (filePath == null) {
			importRequestImpl.setFilePath("");
		}
		else {
			importRequestImpl.setFilePath(filePath);
		}

		importRequestImpl.setGroupId(groupId);
		importRequestImpl.setCompanyId(companyId);
		importRequestImpl.setUserId(userId);

		if (userName == null) {
			importRequestImpl.setUserName("");
		}
		else {
			importRequestImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			importRequestImpl.setCreateDate(null);
		}
		else {
			importRequestImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			importRequestImpl.setModifiedDate(null);
		}
		else {
			importRequestImpl.setModifiedDate(new Date(modifiedDate));
		}

		importRequestImpl.setStatus(status);
		importRequestImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			importRequestImpl.setStatusByUserName("");
		}
		else {
			importRequestImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			importRequestImpl.setStatusDate(null);
		}
		else {
			importRequestImpl.setStatusDate(new Date(statusDate));
		}

		if (uuid_ == null) {
			importRequestImpl.setUuid_("");
		}
		else {
			importRequestImpl.setUuid_(uuid_);
		}

		importRequestImpl.resetOriginalValues();

		return importRequestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		type = objectInput.readUTF();
		fileName = objectInput.readUTF();
		filePath = objectInput.readUTF();

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
		objectOutput.writeLong(id);

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (fileName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fileName);
		}

		if (filePath == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(filePath);
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

	public long id;
	public String type;
	public String fileName;
	public String filePath;
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