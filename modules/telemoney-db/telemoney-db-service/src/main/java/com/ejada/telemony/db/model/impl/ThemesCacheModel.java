/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model.impl;

import com.ejada.telemony.db.model.Themes;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Themes in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ThemesCacheModel implements CacheModel<Themes>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ThemesCacheModel)) {
			return false;
		}

		ThemesCacheModel themesCacheModel = (ThemesCacheModel)object;

		if (themeId == themesCacheModel.themeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, themeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(69);

		sb.append("{themeId=");
		sb.append(themeId);
		sb.append(", channelId=");
		sb.append(channelId);
		sb.append(", themeEnName=");
		sb.append(themeEnName);
		sb.append(", themeArName=");
		sb.append(themeArName);
		sb.append(", darkTheme=");
		sb.append(darkTheme);
		sb.append(", primaryColors=");
		sb.append(primaryColors);
		sb.append(", secondaryColors=");
		sb.append(secondaryColors);
		sb.append(", neutralColors=");
		sb.append(neutralColors);
		sb.append(", successColors=");
		sb.append(successColors);
		sb.append(", errorColors=");
		sb.append(errorColors);
		sb.append(", warningColors=");
		sb.append(warningColors);
		sb.append(", supportColors=");
		sb.append(supportColors);
		sb.append(", gradientColors=");
		sb.append(gradientColors);
		sb.append(", splashBg=");
		sb.append(splashBg);
		sb.append(", splashAnimation=");
		sb.append(splashAnimation);
		sb.append(", headerBg=");
		sb.append(headerBg);
		sb.append(", balanceBg=");
		sb.append(balanceBg);
		sb.append(", defaultTheme=");
		sb.append(defaultTheme);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", uuid_=");
		sb.append(uuid_);
		sb.append(", originalEntityId=");
		sb.append(originalEntityId);
		sb.append(", entityResourceId=");
		sb.append(entityResourceId);
		sb.append(", version=");
		sb.append(version);
		sb.append(", workflowAction=");
		sb.append(workflowAction);
		sb.append(", importRequestId=");
		sb.append(importRequestId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Themes toEntityModel() {
		ThemesImpl themesImpl = new ThemesImpl();

		themesImpl.setThemeId(themeId);
		themesImpl.setChannelId(channelId);

		if (themeEnName == null) {
			themesImpl.setThemeEnName("");
		}
		else {
			themesImpl.setThemeEnName(themeEnName);
		}

		if (themeArName == null) {
			themesImpl.setThemeArName("");
		}
		else {
			themesImpl.setThemeArName(themeArName);
		}

		themesImpl.setDarkTheme(darkTheme);

		if (primaryColors == null) {
			themesImpl.setPrimaryColors("");
		}
		else {
			themesImpl.setPrimaryColors(primaryColors);
		}

		if (secondaryColors == null) {
			themesImpl.setSecondaryColors("");
		}
		else {
			themesImpl.setSecondaryColors(secondaryColors);
		}

		if (neutralColors == null) {
			themesImpl.setNeutralColors("");
		}
		else {
			themesImpl.setNeutralColors(neutralColors);
		}

		if (successColors == null) {
			themesImpl.setSuccessColors("");
		}
		else {
			themesImpl.setSuccessColors(successColors);
		}

		if (errorColors == null) {
			themesImpl.setErrorColors("");
		}
		else {
			themesImpl.setErrorColors(errorColors);
		}

		if (warningColors == null) {
			themesImpl.setWarningColors("");
		}
		else {
			themesImpl.setWarningColors(warningColors);
		}

		if (supportColors == null) {
			themesImpl.setSupportColors("");
		}
		else {
			themesImpl.setSupportColors(supportColors);
		}

		if (gradientColors == null) {
			themesImpl.setGradientColors("");
		}
		else {
			themesImpl.setGradientColors(gradientColors);
		}

		if (splashBg == null) {
			themesImpl.setSplashBg("");
		}
		else {
			themesImpl.setSplashBg(splashBg);
		}

		if (splashAnimation == null) {
			themesImpl.setSplashAnimation("");
		}
		else {
			themesImpl.setSplashAnimation(splashAnimation);
		}

		if (headerBg == null) {
			themesImpl.setHeaderBg("");
		}
		else {
			themesImpl.setHeaderBg(headerBg);
		}

		if (balanceBg == null) {
			themesImpl.setBalanceBg("");
		}
		else {
			themesImpl.setBalanceBg(balanceBg);
		}

		themesImpl.setDefaultTheme(defaultTheme);
		themesImpl.setGroupId(groupId);
		themesImpl.setCompanyId(companyId);
		themesImpl.setUserId(userId);

		if (userName == null) {
			themesImpl.setUserName("");
		}
		else {
			themesImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			themesImpl.setCreateDate(null);
		}
		else {
			themesImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			themesImpl.setModifiedDate(null);
		}
		else {
			themesImpl.setModifiedDate(new Date(modifiedDate));
		}

		themesImpl.setStatus(status);
		themesImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			themesImpl.setStatusByUserName("");
		}
		else {
			themesImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			themesImpl.setStatusDate(null);
		}
		else {
			themesImpl.setStatusDate(new Date(statusDate));
		}

		if (uuid_ == null) {
			themesImpl.setUuid_("");
		}
		else {
			themesImpl.setUuid_(uuid_);
		}

		themesImpl.setOriginalEntityId(originalEntityId);
		themesImpl.setEntityResourceId(entityResourceId);
		themesImpl.setVersion(version);

		if (workflowAction == null) {
			themesImpl.setWorkflowAction("");
		}
		else {
			themesImpl.setWorkflowAction(workflowAction);
		}

		themesImpl.setImportRequestId(importRequestId);

		themesImpl.resetOriginalValues();

		return themesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		themeId = objectInput.readLong();

		channelId = objectInput.readLong();
		themeEnName = objectInput.readUTF();
		themeArName = objectInput.readUTF();

		darkTheme = objectInput.readBoolean();
		primaryColors = objectInput.readUTF();
		secondaryColors = objectInput.readUTF();
		neutralColors = objectInput.readUTF();
		successColors = objectInput.readUTF();
		errorColors = objectInput.readUTF();
		warningColors = objectInput.readUTF();
		supportColors = objectInput.readUTF();
		gradientColors = objectInput.readUTF();
		splashBg = objectInput.readUTF();
		splashAnimation = objectInput.readUTF();
		headerBg = objectInput.readUTF();
		balanceBg = objectInput.readUTF();

		defaultTheme = objectInput.readBoolean();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		uuid_ = objectInput.readUTF();

		originalEntityId = objectInput.readLong();

		entityResourceId = objectInput.readLong();

		version = objectInput.readInt();
		workflowAction = objectInput.readUTF();

		importRequestId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(themeId);

		objectOutput.writeLong(channelId);

		if (themeEnName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(themeEnName);
		}

		if (themeArName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(themeArName);
		}

		objectOutput.writeBoolean(darkTheme);

		if (primaryColors == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(primaryColors);
		}

		if (secondaryColors == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(secondaryColors);
		}

		if (neutralColors == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(neutralColors);
		}

		if (successColors == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(successColors);
		}

		if (errorColors == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(errorColors);
		}

		if (warningColors == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(warningColors);
		}

		if (supportColors == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(supportColors);
		}

		if (gradientColors == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gradientColors);
		}

		if (splashBg == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(splashBg);
		}

		if (splashAnimation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(splashAnimation);
		}

		if (headerBg == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(headerBg);
		}

		if (balanceBg == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(balanceBg);
		}

		objectOutput.writeBoolean(defaultTheme);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		if (uuid_ == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid_);
		}

		objectOutput.writeLong(originalEntityId);

		objectOutput.writeLong(entityResourceId);

		objectOutput.writeInt(version);

		if (workflowAction == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(workflowAction);
		}

		objectOutput.writeLong(importRequestId);
	}

	public long themeId;
	public long channelId;
	public String themeEnName;
	public String themeArName;
	public boolean darkTheme;
	public String primaryColors;
	public String secondaryColors;
	public String neutralColors;
	public String successColors;
	public String errorColors;
	public String warningColors;
	public String supportColors;
	public String gradientColors;
	public String splashBg;
	public String splashAnimation;
	public String headerBg;
	public String balanceBg;
	public boolean defaultTheme;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public String uuid_;
	public long originalEntityId;
	public long entityResourceId;
	public int version;
	public String workflowAction;
	public long importRequestId;

}