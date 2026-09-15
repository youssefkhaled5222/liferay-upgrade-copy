/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model.impl;

import com.ejada.telemony.db.model.LovsLocalization;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LovsLocalization in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LovsLocalizationCacheModel
	implements CacheModel<LovsLocalization>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LovsLocalizationCacheModel)) {
			return false;
		}

		LovsLocalizationCacheModel lovsLocalizationCacheModel =
			(LovsLocalizationCacheModel)object;

		if ((lovsLocalizationId ==
				lovsLocalizationCacheModel.lovsLocalizationId) &&
			(mvccVersion == lovsLocalizationCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, lovsLocalizationId);

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
		sb.append(", lovsLocalizationId=");
		sb.append(lovsLocalizationId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", id=");
		sb.append(id);
		sb.append(", languageId=");
		sb.append(languageId);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LovsLocalization toEntityModel() {
		LovsLocalizationImpl lovsLocalizationImpl = new LovsLocalizationImpl();

		lovsLocalizationImpl.setMvccVersion(mvccVersion);
		lovsLocalizationImpl.setLovsLocalizationId(lovsLocalizationId);
		lovsLocalizationImpl.setCompanyId(companyId);
		lovsLocalizationImpl.setId(id);

		if (languageId == null) {
			lovsLocalizationImpl.setLanguageId("");
		}
		else {
			lovsLocalizationImpl.setLanguageId(languageId);
		}

		if (name == null) {
			lovsLocalizationImpl.setName("");
		}
		else {
			lovsLocalizationImpl.setName(name);
		}

		lovsLocalizationImpl.resetOriginalValues();

		return lovsLocalizationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();

		lovsLocalizationId = objectInput.readLong();

		companyId = objectInput.readLong();

		id = objectInput.readLong();
		languageId = objectInput.readUTF();
		name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		objectOutput.writeLong(lovsLocalizationId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(id);

		if (languageId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(languageId);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public long mvccVersion;
	public long lovsLocalizationId;
	public long companyId;
	public long id;
	public String languageId;
	public String name;

}