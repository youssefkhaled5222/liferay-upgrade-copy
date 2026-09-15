/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model.impl;

import com.ejada.telemony.db.model.Segment;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Segment in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SegmentCacheModel implements CacheModel<Segment>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SegmentCacheModel)) {
			return false;
		}

		SegmentCacheModel segmentCacheModel = (SegmentCacheModel)object;

		if (segmentId == segmentCacheModel.segmentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, segmentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{segmentId=");
		sb.append(segmentId);
		sb.append(", featureId=");
		sb.append(featureId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", segmentStatus=");
		sb.append(segmentStatus);
		sb.append(", method=");
		sb.append(method);
		sb.append(", popUpTitle=");
		sb.append(popUpTitle);
		sb.append(", popUpSubTitle=");
		sb.append(popUpSubTitle);
		sb.append(", status=");
		sb.append(status);
		sb.append(", originalEntityId=");
		sb.append(originalEntityId);
		sb.append(", entityResourceId=");
		sb.append(entityResourceId);
		sb.append(", childResourceId=");
		sb.append(childResourceId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Segment toEntityModel() {
		SegmentImpl segmentImpl = new SegmentImpl();

		segmentImpl.setSegmentId(segmentId);
		segmentImpl.setFeatureId(featureId);

		if (name == null) {
			segmentImpl.setName("");
		}
		else {
			segmentImpl.setName(name);
		}

		segmentImpl.setSegmentStatus(segmentStatus);

		if (method == null) {
			segmentImpl.setMethod("");
		}
		else {
			segmentImpl.setMethod(method);
		}

		if (popUpTitle == null) {
			segmentImpl.setPopUpTitle("");
		}
		else {
			segmentImpl.setPopUpTitle(popUpTitle);
		}

		if (popUpSubTitle == null) {
			segmentImpl.setPopUpSubTitle("");
		}
		else {
			segmentImpl.setPopUpSubTitle(popUpSubTitle);
		}

		segmentImpl.setStatus(status);
		segmentImpl.setOriginalEntityId(originalEntityId);
		segmentImpl.setEntityResourceId(entityResourceId);
		segmentImpl.setChildResourceId(childResourceId);

		segmentImpl.resetOriginalValues();

		return segmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		segmentId = objectInput.readLong();

		featureId = objectInput.readLong();
		name = objectInput.readUTF();

		segmentStatus = objectInput.readBoolean();
		method = objectInput.readUTF();
		popUpTitle = objectInput.readUTF();
		popUpSubTitle = objectInput.readUTF();

		status = objectInput.readInt();

		originalEntityId = objectInput.readLong();

		entityResourceId = objectInput.readLong();

		childResourceId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(segmentId);

		objectOutput.writeLong(featureId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeBoolean(segmentStatus);

		if (method == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(method);
		}

		if (popUpTitle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(popUpTitle);
		}

		if (popUpSubTitle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(popUpSubTitle);
		}

		objectOutput.writeInt(status);

		objectOutput.writeLong(originalEntityId);

		objectOutput.writeLong(entityResourceId);

		objectOutput.writeLong(childResourceId);
	}

	public long segmentId;
	public long featureId;
	public String name;
	public boolean segmentStatus;
	public String method;
	public String popUpTitle;
	public String popUpSubTitle;
	public int status;
	public long originalEntityId;
	public long entityResourceId;
	public long childResourceId;

}