/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model.impl;

import com.ejada.telemony.db.model.AppConfigItem;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AppConfigItem in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AppConfigItemCacheModel
	implements CacheModel<AppConfigItem>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AppConfigItemCacheModel)) {
			return false;
		}

		AppConfigItemCacheModel appConfigItemCacheModel =
			(AppConfigItemCacheModel)object;

		if (configItemId == appConfigItemCacheModel.configItemId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, configItemId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{configItemId=");
		sb.append(configItemId);
		sb.append(", environmentId=");
		sb.append(environmentId);
		sb.append(", keyName=");
		sb.append(keyName);
		sb.append(", valueType=");
		sb.append(valueType);
		sb.append(", value=");
		sb.append(value);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AppConfigItem toEntityModel() {
		AppConfigItemImpl appConfigItemImpl = new AppConfigItemImpl();

		appConfigItemImpl.setConfigItemId(configItemId);
		appConfigItemImpl.setEnvironmentId(environmentId);

		if (keyName == null) {
			appConfigItemImpl.setKeyName("");
		}
		else {
			appConfigItemImpl.setKeyName(keyName);
		}

		if (valueType == null) {
			appConfigItemImpl.setValueType("");
		}
		else {
			appConfigItemImpl.setValueType(valueType);
		}

		if (value == null) {
			appConfigItemImpl.setValue("");
		}
		else {
			appConfigItemImpl.setValue(value);
		}

		if (createDate == Long.MIN_VALUE) {
			appConfigItemImpl.setCreateDate(null);
		}
		else {
			appConfigItemImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			appConfigItemImpl.setModifiedDate(null);
		}
		else {
			appConfigItemImpl.setModifiedDate(new Date(modifiedDate));
		}

		appConfigItemImpl.resetOriginalValues();

		return appConfigItemImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		configItemId = objectInput.readLong();

		environmentId = objectInput.readLong();
		keyName = objectInput.readUTF();
		valueType = objectInput.readUTF();
		value = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(configItemId);

		objectOutput.writeLong(environmentId);

		if (keyName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(keyName);
		}

		if (valueType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(valueType);
		}

		if (value == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(value);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long configItemId;
	public long environmentId;
	public String keyName;
	public String valueType;
	public String value;
	public long createDate;
	public long modifiedDate;

}