/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model.impl;

import com.ejada.telemony.db.model.Blocks;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Blocks in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BlocksCacheModel implements CacheModel<Blocks>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BlocksCacheModel)) {
			return false;
		}

		BlocksCacheModel blocksCacheModel = (BlocksCacheModel)object;

		if (blockId == blocksCacheModel.blockId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, blockId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{blockId=");
		sb.append(blockId);
		sb.append(", channelId=");
		sb.append(channelId);
		sb.append(", type=");
		sb.append(type);
		sb.append(", androidBlock=");
		sb.append(androidBlock);
		sb.append(", androidBlockVersion=");
		sb.append(androidBlockVersion);
		sb.append(", androidBlockFrom=");
		sb.append(androidBlockFrom);
		sb.append(", androidBlockTo=");
		sb.append(androidBlockTo);
		sb.append(", iosBlock=");
		sb.append(iosBlock);
		sb.append(", iosBlockVersion=");
		sb.append(iosBlockVersion);
		sb.append(", iosBlockFrom=");
		sb.append(iosBlockFrom);
		sb.append(", iosBlockTo=");
		sb.append(iosBlockTo);
		sb.append(", webBlock=");
		sb.append(webBlock);
		sb.append(", webBlockVersion=");
		sb.append(webBlockVersion);
		sb.append(", webBlockFrom=");
		sb.append(webBlockFrom);
		sb.append(", webBlockTo=");
		sb.append(webBlockTo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Blocks toEntityModel() {
		BlocksImpl blocksImpl = new BlocksImpl();

		blocksImpl.setBlockId(blockId);
		blocksImpl.setChannelId(channelId);

		if (type == null) {
			blocksImpl.setType("");
		}
		else {
			blocksImpl.setType(type);
		}

		blocksImpl.setAndroidBlock(androidBlock);

		if (androidBlockVersion == null) {
			blocksImpl.setAndroidBlockVersion("");
		}
		else {
			blocksImpl.setAndroidBlockVersion(androidBlockVersion);
		}

		if (androidBlockFrom == Long.MIN_VALUE) {
			blocksImpl.setAndroidBlockFrom(null);
		}
		else {
			blocksImpl.setAndroidBlockFrom(new Date(androidBlockFrom));
		}

		if (androidBlockTo == Long.MIN_VALUE) {
			blocksImpl.setAndroidBlockTo(null);
		}
		else {
			blocksImpl.setAndroidBlockTo(new Date(androidBlockTo));
		}

		blocksImpl.setIosBlock(iosBlock);

		if (iosBlockVersion == null) {
			blocksImpl.setIosBlockVersion("");
		}
		else {
			blocksImpl.setIosBlockVersion(iosBlockVersion);
		}

		if (iosBlockFrom == Long.MIN_VALUE) {
			blocksImpl.setIosBlockFrom(null);
		}
		else {
			blocksImpl.setIosBlockFrom(new Date(iosBlockFrom));
		}

		if (iosBlockTo == Long.MIN_VALUE) {
			blocksImpl.setIosBlockTo(null);
		}
		else {
			blocksImpl.setIosBlockTo(new Date(iosBlockTo));
		}

		blocksImpl.setWebBlock(webBlock);

		if (webBlockVersion == null) {
			blocksImpl.setWebBlockVersion("");
		}
		else {
			blocksImpl.setWebBlockVersion(webBlockVersion);
		}

		if (webBlockFrom == Long.MIN_VALUE) {
			blocksImpl.setWebBlockFrom(null);
		}
		else {
			blocksImpl.setWebBlockFrom(new Date(webBlockFrom));
		}

		if (webBlockTo == Long.MIN_VALUE) {
			blocksImpl.setWebBlockTo(null);
		}
		else {
			blocksImpl.setWebBlockTo(new Date(webBlockTo));
		}

		blocksImpl.resetOriginalValues();

		return blocksImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		blockId = objectInput.readLong();

		channelId = objectInput.readLong();
		type = objectInput.readUTF();

		androidBlock = objectInput.readBoolean();
		androidBlockVersion = objectInput.readUTF();
		androidBlockFrom = objectInput.readLong();
		androidBlockTo = objectInput.readLong();

		iosBlock = objectInput.readBoolean();
		iosBlockVersion = objectInput.readUTF();
		iosBlockFrom = objectInput.readLong();
		iosBlockTo = objectInput.readLong();

		webBlock = objectInput.readBoolean();
		webBlockVersion = objectInput.readUTF();
		webBlockFrom = objectInput.readLong();
		webBlockTo = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(blockId);

		objectOutput.writeLong(channelId);

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}

		objectOutput.writeBoolean(androidBlock);

		if (androidBlockVersion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(androidBlockVersion);
		}

		objectOutput.writeLong(androidBlockFrom);
		objectOutput.writeLong(androidBlockTo);

		objectOutput.writeBoolean(iosBlock);

		if (iosBlockVersion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(iosBlockVersion);
		}

		objectOutput.writeLong(iosBlockFrom);
		objectOutput.writeLong(iosBlockTo);

		objectOutput.writeBoolean(webBlock);

		if (webBlockVersion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(webBlockVersion);
		}

		objectOutput.writeLong(webBlockFrom);
		objectOutput.writeLong(webBlockTo);
	}

	public long blockId;
	public long channelId;
	public String type;
	public boolean androidBlock;
	public String androidBlockVersion;
	public long androidBlockFrom;
	public long androidBlockTo;
	public boolean iosBlock;
	public String iosBlockVersion;
	public long iosBlockFrom;
	public long iosBlockTo;
	public boolean webBlock;
	public String webBlockVersion;
	public long webBlockFrom;
	public long webBlockTo;

}