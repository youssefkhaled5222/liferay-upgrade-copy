/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model.impl;

import com.ejada.telemony.db.model.BannerContentLocalization;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing BannerContentLocalization in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BannerContentLocalizationCacheModel
	implements CacheModel<BannerContentLocalization>, Externalizable,
			   MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BannerContentLocalizationCacheModel)) {
			return false;
		}

		BannerContentLocalizationCacheModel
			bannerContentLocalizationCacheModel =
				(BannerContentLocalizationCacheModel)object;

		if ((bannerContentLocalizationId ==
				bannerContentLocalizationCacheModel.
					bannerContentLocalizationId) &&
			(mvccVersion == bannerContentLocalizationCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, bannerContentLocalizationId);

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
		StringBundler sb = new StringBundler(21);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", bannerContentLocalizationId=");
		sb.append(bannerContentLocalizationId);
		sb.append(", contentId=");
		sb.append(contentId);
		sb.append(", languageId=");
		sb.append(languageId);
		sb.append(", bannerImage=");
		sb.append(bannerImage);
		sb.append(", imageOverlay=");
		sb.append(imageOverlay);
		sb.append(", linkType=");
		sb.append(linkType);
		sb.append(", url=");
		sb.append(url);
		sb.append(", titleValue=");
		sb.append(titleValue);
		sb.append(", descriptionValue=");
		sb.append(descriptionValue);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BannerContentLocalization toEntityModel() {
		BannerContentLocalizationImpl bannerContentLocalizationImpl =
			new BannerContentLocalizationImpl();

		bannerContentLocalizationImpl.setMvccVersion(mvccVersion);
		bannerContentLocalizationImpl.setBannerContentLocalizationId(
			bannerContentLocalizationId);
		bannerContentLocalizationImpl.setContentId(contentId);

		if (languageId == null) {
			bannerContentLocalizationImpl.setLanguageId("");
		}
		else {
			bannerContentLocalizationImpl.setLanguageId(languageId);
		}

		if (bannerImage == null) {
			bannerContentLocalizationImpl.setBannerImage("");
		}
		else {
			bannerContentLocalizationImpl.setBannerImage(bannerImage);
		}

		if (imageOverlay == null) {
			bannerContentLocalizationImpl.setImageOverlay("");
		}
		else {
			bannerContentLocalizationImpl.setImageOverlay(imageOverlay);
		}

		if (linkType == null) {
			bannerContentLocalizationImpl.setLinkType("");
		}
		else {
			bannerContentLocalizationImpl.setLinkType(linkType);
		}

		if (url == null) {
			bannerContentLocalizationImpl.setUrl("");
		}
		else {
			bannerContentLocalizationImpl.setUrl(url);
		}

		if (titleValue == null) {
			bannerContentLocalizationImpl.setTitleValue("");
		}
		else {
			bannerContentLocalizationImpl.setTitleValue(titleValue);
		}

		if (descriptionValue == null) {
			bannerContentLocalizationImpl.setDescriptionValue("");
		}
		else {
			bannerContentLocalizationImpl.setDescriptionValue(descriptionValue);
		}

		bannerContentLocalizationImpl.resetOriginalValues();

		return bannerContentLocalizationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();

		bannerContentLocalizationId = objectInput.readLong();

		contentId = objectInput.readLong();
		languageId = objectInput.readUTF();
		bannerImage = objectInput.readUTF();
		imageOverlay = objectInput.readUTF();
		linkType = objectInput.readUTF();
		url = objectInput.readUTF();
		titleValue = objectInput.readUTF();
		descriptionValue = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		objectOutput.writeLong(bannerContentLocalizationId);

		objectOutput.writeLong(contentId);

		if (languageId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(languageId);
		}

		if (bannerImage == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bannerImage);
		}

		if (imageOverlay == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(imageOverlay);
		}

		if (linkType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(linkType);
		}

		if (url == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(url);
		}

		if (titleValue == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(titleValue);
		}

		if (descriptionValue == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(descriptionValue);
		}
	}

	public long mvccVersion;
	public long bannerContentLocalizationId;
	public long contentId;
	public String languageId;
	public String bannerImage;
	public String imageOverlay;
	public String linkType;
	public String url;
	public String titleValue;
	public String descriptionValue;

}