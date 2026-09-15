/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model.impl;

import com.ejada.telemony.db.model.FeatureLovMap;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing FeatureLovMap in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FeatureLovMapCacheModel
	implements CacheModel<FeatureLovMap>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FeatureLovMapCacheModel)) {
			return false;
		}

		FeatureLovMapCacheModel featureLovMapCacheModel =
			(FeatureLovMapCacheModel)object;

		if (id == featureLovMapCacheModel.id) {
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
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(id);
		sb.append(", featureId=");
		sb.append(featureId);
		sb.append(", featureEntityResourceId=");
		sb.append(featureEntityResourceId);
		sb.append(", lovEntityResourceId=");
		sb.append(lovEntityResourceId);
		sb.append(", lovDataCode=");
		sb.append(lovDataCode);
		sb.append(", lovType=");
		sb.append(lovType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FeatureLovMap toEntityModel() {
		FeatureLovMapImpl featureLovMapImpl = new FeatureLovMapImpl();

		featureLovMapImpl.setId(id);
		featureLovMapImpl.setFeatureId(featureId);
		featureLovMapImpl.setFeatureEntityResourceId(featureEntityResourceId);
		featureLovMapImpl.setLovEntityResourceId(lovEntityResourceId);

		if (lovDataCode == null) {
			featureLovMapImpl.setLovDataCode("");
		}
		else {
			featureLovMapImpl.setLovDataCode(lovDataCode);
		}

		if (lovType == null) {
			featureLovMapImpl.setLovType("");
		}
		else {
			featureLovMapImpl.setLovType(lovType);
		}

		featureLovMapImpl.resetOriginalValues();

		return featureLovMapImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		featureId = objectInput.readLong();

		featureEntityResourceId = objectInput.readLong();

		lovEntityResourceId = objectInput.readLong();
		lovDataCode = objectInput.readUTF();
		lovType = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(featureId);

		objectOutput.writeLong(featureEntityResourceId);

		objectOutput.writeLong(lovEntityResourceId);

		if (lovDataCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lovDataCode);
		}

		if (lovType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lovType);
		}
	}

	public long id;
	public long featureId;
	public long featureEntityResourceId;
	public long lovEntityResourceId;
	public String lovDataCode;
	public String lovType;

}