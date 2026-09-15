/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model.impl;

import com.ejada.telemony.db.model.BannerContent;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing BannerContent in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BannerContentCacheModel
	implements CacheModel<BannerContent>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BannerContentCacheModel)) {
			return false;
		}

		BannerContentCacheModel bannerContentCacheModel =
			(BannerContentCacheModel)object;

		if (contentId == bannerContentCacheModel.contentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, contentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{defaultLanguageId=");
		sb.append(defaultLanguageId);
		sb.append(", contentId=");
		sb.append(contentId);
		sb.append(", contentName=");
		sb.append(contentName);
		sb.append(", contentOrder=");
		sb.append(contentOrder);
		sb.append(", bannerId=");
		sb.append(bannerId);
		sb.append(", contentStatus=");
		sb.append(contentStatus);
		sb.append(", channelId=");
		sb.append(channelId);
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
	public BannerContent toEntityModel() {
		BannerContentImpl bannerContentImpl = new BannerContentImpl();

		if (defaultLanguageId == null) {
			bannerContentImpl.setDefaultLanguageId("");
		}
		else {
			bannerContentImpl.setDefaultLanguageId(defaultLanguageId);
		}

		bannerContentImpl.setContentId(contentId);

		if (contentName == null) {
			bannerContentImpl.setContentName("");
		}
		else {
			bannerContentImpl.setContentName(contentName);
		}

		bannerContentImpl.setContentOrder(contentOrder);
		bannerContentImpl.setBannerId(bannerId);

		if (contentStatus == null) {
			bannerContentImpl.setContentStatus("");
		}
		else {
			bannerContentImpl.setContentStatus(contentStatus);
		}

		bannerContentImpl.setChannelId(channelId);
		bannerContentImpl.setStatus(status);
		bannerContentImpl.setOriginalEntityId(originalEntityId);
		bannerContentImpl.setEntityResourceId(entityResourceId);

		bannerContentImpl.resetOriginalValues();

		return bannerContentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		defaultLanguageId = objectInput.readUTF();

		contentId = objectInput.readLong();
		contentName = objectInput.readUTF();

		contentOrder = objectInput.readInt();

		bannerId = objectInput.readLong();
		contentStatus = objectInput.readUTF();

		channelId = objectInput.readLong();

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

		objectOutput.writeLong(contentId);

		if (contentName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(contentName);
		}

		objectOutput.writeInt(contentOrder);

		objectOutput.writeLong(bannerId);

		if (contentStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(contentStatus);
		}

		objectOutput.writeLong(channelId);

		objectOutput.writeInt(status);

		objectOutput.writeLong(originalEntityId);

		objectOutput.writeLong(entityResourceId);
	}

	public String defaultLanguageId;
	public long contentId;
	public String contentName;
	public int contentOrder;
	public long bannerId;
	public String contentStatus;
	public long channelId;
	public int status;
	public long originalEntityId;
	public long entityResourceId;

}