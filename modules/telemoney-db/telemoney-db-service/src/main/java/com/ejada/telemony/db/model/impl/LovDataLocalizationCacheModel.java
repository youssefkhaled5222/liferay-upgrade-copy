/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model.impl;

import com.ejada.telemony.db.model.LovDataLocalization;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LovDataLocalization in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LovDataLocalizationCacheModel
	implements CacheModel<LovDataLocalization>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LovDataLocalizationCacheModel)) {
			return false;
		}

		LovDataLocalizationCacheModel lovDataLocalizationCacheModel =
			(LovDataLocalizationCacheModel)object;

		if ((lovDataLocalizationId ==
				lovDataLocalizationCacheModel.lovDataLocalizationId) &&
			(mvccVersion == lovDataLocalizationCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, lovDataLocalizationId);

		return HashUtil.hash(hashCode, mvccVersion);
	}

	@Override
	public long getMvccVersion() {
		return mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", lovDataLocalizationId=");
		sb.append(lovDataLocalizationId);
		sb.append(", id=");
		sb.append(id);
		sb.append(", languageId=");
		sb.append(languageId);
		sb.append(", recordDescription=");
		sb.append(recordDescription);
		sb.append(", lovIdLocalization=");
		sb.append(lovIdLocalization);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LovDataLocalization toEntityModel() {
		LovDataLocalizationImpl lovDataLocalizationImpl =
			new LovDataLocalizationImpl();

		lovDataLocalizationImpl.setMvccVersion(mvccVersion);
		lovDataLocalizationImpl.setLovDataLocalizationId(lovDataLocalizationId);
		lovDataLocalizationImpl.setId(id);

		if (languageId == null) {
			lovDataLocalizationImpl.setLanguageId("");
		}
		else {
			lovDataLocalizationImpl.setLanguageId(languageId);
		}

		if (recordDescription == null) {
			lovDataLocalizationImpl.setRecordDescription("");
		}
		else {
			lovDataLocalizationImpl.setRecordDescription(recordDescription);
		}

		if (lovIdLocalization == null) {
			lovDataLocalizationImpl.setLovIdLocalization("");
		}
		else {
			lovDataLocalizationImpl.setLovIdLocalization(lovIdLocalization);
		}

		lovDataLocalizationImpl.resetOriginalValues();

		return lovDataLocalizationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();

		lovDataLocalizationId = objectInput.readLong();

		id = objectInput.readLong();
		languageId = objectInput.readUTF();
		recordDescription = objectInput.readUTF();
		lovIdLocalization = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		objectOutput.writeLong(lovDataLocalizationId);

		objectOutput.writeLong(id);

		if (languageId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(languageId);
		}

		if (recordDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(recordDescription);
		}

		if (lovIdLocalization == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lovIdLocalization);
		}
	}

	public long mvccVersion;
	public long lovDataLocalizationId;
	public long id;
	public String languageId;
	public String recordDescription;
	public String lovIdLocalization;

}