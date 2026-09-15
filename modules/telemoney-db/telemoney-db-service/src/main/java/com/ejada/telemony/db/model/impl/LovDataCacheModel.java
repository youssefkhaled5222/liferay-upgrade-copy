/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model.impl;

import com.ejada.telemony.db.model.LovData;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LovData in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LovDataCacheModel implements CacheModel<LovData>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LovDataCacheModel)) {
			return false;
		}

		LovDataCacheModel lovDataCacheModel = (LovDataCacheModel)object;

		if (id == lovDataCacheModel.id) {
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
		StringBundler sb = new StringBundler(19);

		sb.append("{defaultLanguageId=");
		sb.append(defaultLanguageId);
		sb.append(", id=");
		sb.append(id);
		sb.append(", lovId=");
		sb.append(lovId);
		sb.append(", lovType=");
		sb.append(lovType);
		sb.append(", recordTypeCode=");
		sb.append(recordTypeCode);
		sb.append(", recordShortDescription=");
		sb.append(recordShortDescription);
		sb.append(", status=");
		sb.append(status);
		sb.append(", originalEntityId=");
		sb.append(originalEntityId);
		sb.append(", entityResourceId=");
		sb.append(entityResourceId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LovData toEntityModel() {
		LovDataImpl lovDataImpl = new LovDataImpl();

		if (defaultLanguageId == null) {
			lovDataImpl.setDefaultLanguageId("");
		}
		else {
			lovDataImpl.setDefaultLanguageId(defaultLanguageId);
		}

		lovDataImpl.setId(id);
		lovDataImpl.setLovId(lovId);

		if (lovType == null) {
			lovDataImpl.setLovType("");
		}
		else {
			lovDataImpl.setLovType(lovType);
		}

		if (recordTypeCode == null) {
			lovDataImpl.setRecordTypeCode("");
		}
		else {
			lovDataImpl.setRecordTypeCode(recordTypeCode);
		}

		if (recordShortDescription == null) {
			lovDataImpl.setRecordShortDescription("");
		}
		else {
			lovDataImpl.setRecordShortDescription(recordShortDescription);
		}

		lovDataImpl.setStatus(status);
		lovDataImpl.setOriginalEntityId(originalEntityId);
		lovDataImpl.setEntityResourceId(entityResourceId);

		lovDataImpl.resetOriginalValues();

		return lovDataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		defaultLanguageId = objectInput.readUTF();

		id = objectInput.readLong();

		lovId = objectInput.readLong();
		lovType = objectInput.readUTF();
		recordTypeCode = objectInput.readUTF();
		recordShortDescription = objectInput.readUTF();

		status = objectInput.readInt();

		originalEntityId = objectInput.readLong();

		entityResourceId = objectInput.readLong();
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

		objectOutput.writeLong(lovId);

		if (lovType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lovType);
		}

		if (recordTypeCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(recordTypeCode);
		}

		if (recordShortDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(recordShortDescription);
		}

		objectOutput.writeInt(status);

		objectOutput.writeLong(originalEntityId);

		objectOutput.writeLong(entityResourceId);
	}

	public String defaultLanguageId;
	public long id;
	public long lovId;
	public String lovType;
	public String recordTypeCode;
	public String recordShortDescription;
	public int status;
	public long originalEntityId;
	public long entityResourceId;

}