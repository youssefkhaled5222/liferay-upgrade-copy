/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model.impl;

import com.ejada.telemony.db.model.Languages;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Languages in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LanguagesCacheModel
	implements CacheModel<Languages>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LanguagesCacheModel)) {
			return false;
		}

		LanguagesCacheModel languagesCacheModel = (LanguagesCacheModel)object;

		if (languageId == languagesCacheModel.languageId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, languageId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{languageId=");
		sb.append(languageId);
		sb.append(", channelId=");
		sb.append(channelId);
		sb.append(", langName=");
		sb.append(langName);
		sb.append(", local=");
		sb.append(local);
		sb.append(", primaryLanguage=");
		sb.append(primaryLanguage);
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
	public Languages toEntityModel() {
		LanguagesImpl languagesImpl = new LanguagesImpl();

		languagesImpl.setLanguageId(languageId);
		languagesImpl.setChannelId(channelId);

		if (langName == null) {
			languagesImpl.setLangName("");
		}
		else {
			languagesImpl.setLangName(langName);
		}

		if (local == null) {
			languagesImpl.setLocal("");
		}
		else {
			languagesImpl.setLocal(local);
		}

		languagesImpl.setPrimaryLanguage(primaryLanguage);
		languagesImpl.setGroupId(groupId);
		languagesImpl.setCompanyId(companyId);
		languagesImpl.setUserId(userId);

		if (userName == null) {
			languagesImpl.setUserName("");
		}
		else {
			languagesImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			languagesImpl.setCreateDate(null);
		}
		else {
			languagesImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			languagesImpl.setModifiedDate(null);
		}
		else {
			languagesImpl.setModifiedDate(new Date(modifiedDate));
		}

		languagesImpl.setStatus(status);
		languagesImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			languagesImpl.setStatusByUserName("");
		}
		else {
			languagesImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			languagesImpl.setStatusDate(null);
		}
		else {
			languagesImpl.setStatusDate(new Date(statusDate));
		}

		if (uuid_ == null) {
			languagesImpl.setUuid_("");
		}
		else {
			languagesImpl.setUuid_(uuid_);
		}

		languagesImpl.setOriginalEntityId(originalEntityId);
		languagesImpl.setEntityResourceId(entityResourceId);
		languagesImpl.setVersion(version);

		if (workflowAction == null) {
			languagesImpl.setWorkflowAction("");
		}
		else {
			languagesImpl.setWorkflowAction(workflowAction);
		}

		languagesImpl.resetOriginalValues();

		return languagesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		languageId = objectInput.readLong();

		channelId = objectInput.readLong();
		langName = objectInput.readUTF();
		local = objectInput.readUTF();

		primaryLanguage = objectInput.readBoolean();

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
		objectOutput.writeLong(languageId);

		objectOutput.writeLong(channelId);

		if (langName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(langName);
		}

		if (local == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(local);
		}

		objectOutput.writeBoolean(primaryLanguage);

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

	public long languageId;
	public long channelId;
	public String langName;
	public String local;
	public boolean primaryLanguage;
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