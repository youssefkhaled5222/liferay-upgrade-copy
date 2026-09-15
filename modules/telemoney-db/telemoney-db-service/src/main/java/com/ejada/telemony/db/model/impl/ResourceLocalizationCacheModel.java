/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model.impl;

import com.ejada.telemony.db.model.ResourceLocalization;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ResourceLocalization in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ResourceLocalizationCacheModel
	implements CacheModel<ResourceLocalization>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ResourceLocalizationCacheModel)) {
			return false;
		}

		ResourceLocalizationCacheModel resourceLocalizationCacheModel =
			(ResourceLocalizationCacheModel)object;

		if ((resourceLocalizationId ==
				resourceLocalizationCacheModel.resourceLocalizationId) &&
			(mvccVersion == resourceLocalizationCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, resourceLocalizationId);

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
		StringBundler sb = new StringBundler(23);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", resourceLocalizationId=");
		sb.append(resourceLocalizationId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", resourceId=");
		sb.append(resourceId);
		sb.append(", languageId=");
		sb.append(languageId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", attachName=");
		sb.append(attachName);
		sb.append(", attach=");
		sb.append(attach);
		sb.append(", description=");
		sb.append(description);
		sb.append(", routeId=");
		sb.append(routeId);
		sb.append(", url=");
		sb.append(url);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ResourceLocalization toEntityModel() {
		ResourceLocalizationImpl resourceLocalizationImpl =
			new ResourceLocalizationImpl();

		resourceLocalizationImpl.setMvccVersion(mvccVersion);
		resourceLocalizationImpl.setResourceLocalizationId(
			resourceLocalizationId);
		resourceLocalizationImpl.setCompanyId(companyId);
		resourceLocalizationImpl.setResourceId(resourceId);

		if (languageId == null) {
			resourceLocalizationImpl.setLanguageId("");
		}
		else {
			resourceLocalizationImpl.setLanguageId(languageId);
		}

		if (name == null) {
			resourceLocalizationImpl.setName("");
		}
		else {
			resourceLocalizationImpl.setName(name);
		}

		if (attachName == null) {
			resourceLocalizationImpl.setAttachName("");
		}
		else {
			resourceLocalizationImpl.setAttachName(attachName);
		}

		if (attach == null) {
			resourceLocalizationImpl.setAttach("");
		}
		else {
			resourceLocalizationImpl.setAttach(attach);
		}

		if (description == null) {
			resourceLocalizationImpl.setDescription("");
		}
		else {
			resourceLocalizationImpl.setDescription(description);
		}

		if (routeId == null) {
			resourceLocalizationImpl.setRouteId("");
		}
		else {
			resourceLocalizationImpl.setRouteId(routeId);
		}

		if (url == null) {
			resourceLocalizationImpl.setUrl("");
		}
		else {
			resourceLocalizationImpl.setUrl(url);
		}

		resourceLocalizationImpl.resetOriginalValues();

		return resourceLocalizationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();

		resourceLocalizationId = objectInput.readLong();

		companyId = objectInput.readLong();

		resourceId = objectInput.readLong();
		languageId = objectInput.readUTF();
		name = objectInput.readUTF();
		attachName = objectInput.readUTF();
		attach = objectInput.readUTF();
		description = objectInput.readUTF();
		routeId = objectInput.readUTF();
		url = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		objectOutput.writeLong(resourceLocalizationId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(resourceId);

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

		if (attachName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(attachName);
		}

		if (attach == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(attach);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (routeId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(routeId);
		}

		if (url == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(url);
		}
	}

	public long mvccVersion;
	public long resourceLocalizationId;
	public long companyId;
	public long resourceId;
	public String languageId;
	public String name;
	public String attachName;
	public String attach;
	public String description;
	public String routeId;
	public String url;

}