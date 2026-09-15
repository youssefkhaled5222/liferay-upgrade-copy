/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model.impl;

import com.ejada.telemony.db.model.GlobalVersion;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GlobalVersion in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class GlobalVersionCacheModel
	implements CacheModel<GlobalVersion>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof GlobalVersionCacheModel)) {
			return false;
		}

		GlobalVersionCacheModel globalVersionCacheModel =
			(GlobalVersionCacheModel)object;

		if (versionId == globalVersionCacheModel.versionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, versionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{versionId=");
		sb.append(versionId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", channelId=");
		sb.append(channelId);
		sb.append(", componentName=");
		sb.append(componentName);
		sb.append(", version=");
		sb.append(version);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public GlobalVersion toEntityModel() {
		GlobalVersionImpl globalVersionImpl = new GlobalVersionImpl();

		globalVersionImpl.setVersionId(versionId);
		globalVersionImpl.setCompanyId(companyId);
		globalVersionImpl.setChannelId(channelId);

		if (componentName == null) {
			globalVersionImpl.setComponentName("");
		}
		else {
			globalVersionImpl.setComponentName(componentName);
		}

		globalVersionImpl.setVersion(version);

		if (modifiedDate == Long.MIN_VALUE) {
			globalVersionImpl.setModifiedDate(null);
		}
		else {
			globalVersionImpl.setModifiedDate(new Date(modifiedDate));
		}

		globalVersionImpl.resetOriginalValues();

		return globalVersionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		versionId = objectInput.readLong();

		companyId = objectInput.readLong();

		channelId = objectInput.readLong();
		componentName = objectInput.readUTF();

		version = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(versionId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(channelId);

		if (componentName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(componentName);
		}

		objectOutput.writeLong(version);
		objectOutput.writeLong(modifiedDate);
	}

	public long versionId;
	public long companyId;
	public long channelId;
	public String componentName;
	public long version;
	public long modifiedDate;

}