/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model.impl;

import com.ejada.telemony.db.model.Persona;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Persona in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PersonaCacheModel implements CacheModel<Persona>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PersonaCacheModel)) {
			return false;
		}

		PersonaCacheModel personaCacheModel = (PersonaCacheModel)object;

		if (personaId == personaCacheModel.personaId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, personaId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(69);

		sb.append("{personaId=");
		sb.append(personaId);
		sb.append(", channelId=");
		sb.append(channelId);
		sb.append(", darkThemeId=");
		sb.append(darkThemeId);
		sb.append(", lightThemeId=");
		sb.append(lightThemeId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", startAge=");
		sb.append(startAge);
		sb.append(", endAge=");
		sb.append(endAge);
		sb.append(", nationality=");
		sb.append(nationality);
		sb.append(", customerSegment=");
		sb.append(customerSegment);
		sb.append(", personaStatus=");
		sb.append(personaStatus);
		sb.append(", sector=");
		sb.append(sector);
		sb.append(", minIncome=");
		sb.append(minIncome);
		sb.append(", maxIncome=");
		sb.append(maxIncome);
		sb.append(", description=");
		sb.append(description);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", priority=");
		sb.append(priority);
		sb.append(", dateFrom=");
		sb.append(dateFrom);
		sb.append(", dateTo=");
		sb.append(dateTo);
		sb.append(", defaultPersona=");
		sb.append(defaultPersona);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Persona toEntityModel() {
		PersonaImpl personaImpl = new PersonaImpl();

		personaImpl.setPersonaId(personaId);
		personaImpl.setChannelId(channelId);
		personaImpl.setDarkThemeId(darkThemeId);
		personaImpl.setLightThemeId(lightThemeId);

		if (name == null) {
			personaImpl.setName("");
		}
		else {
			personaImpl.setName(name);
		}

		personaImpl.setStartAge(startAge);
		personaImpl.setEndAge(endAge);

		if (nationality == null) {
			personaImpl.setNationality("");
		}
		else {
			personaImpl.setNationality(nationality);
		}

		if (customerSegment == null) {
			personaImpl.setCustomerSegment("");
		}
		else {
			personaImpl.setCustomerSegment(customerSegment);
		}

		if (personaStatus == null) {
			personaImpl.setPersonaStatus("");
		}
		else {
			personaImpl.setPersonaStatus(personaStatus);
		}

		if (sector == null) {
			personaImpl.setSector("");
		}
		else {
			personaImpl.setSector(sector);
		}

		personaImpl.setMinIncome(minIncome);
		personaImpl.setMaxIncome(maxIncome);

		if (description == null) {
			personaImpl.setDescription("");
		}
		else {
			personaImpl.setDescription(description);
		}

		if (gender == null) {
			personaImpl.setGender("");
		}
		else {
			personaImpl.setGender(gender);
		}

		personaImpl.setPriority(priority);

		if (dateFrom == Long.MIN_VALUE) {
			personaImpl.setDateFrom(null);
		}
		else {
			personaImpl.setDateFrom(new Date(dateFrom));
		}

		if (dateTo == Long.MIN_VALUE) {
			personaImpl.setDateTo(null);
		}
		else {
			personaImpl.setDateTo(new Date(dateTo));
		}

		personaImpl.setDefaultPersona(defaultPersona);
		personaImpl.setGroupId(groupId);
		personaImpl.setCompanyId(companyId);
		personaImpl.setUserId(userId);

		if (userName == null) {
			personaImpl.setUserName("");
		}
		else {
			personaImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			personaImpl.setCreateDate(null);
		}
		else {
			personaImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			personaImpl.setModifiedDate(null);
		}
		else {
			personaImpl.setModifiedDate(new Date(modifiedDate));
		}

		personaImpl.setStatus(status);
		personaImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			personaImpl.setStatusByUserName("");
		}
		else {
			personaImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			personaImpl.setStatusDate(null);
		}
		else {
			personaImpl.setStatusDate(new Date(statusDate));
		}

		if (uuid_ == null) {
			personaImpl.setUuid_("");
		}
		else {
			personaImpl.setUuid_(uuid_);
		}

		personaImpl.setOriginalEntityId(originalEntityId);
		personaImpl.setEntityResourceId(entityResourceId);
		personaImpl.setVersion(version);

		if (workflowAction == null) {
			personaImpl.setWorkflowAction("");
		}
		else {
			personaImpl.setWorkflowAction(workflowAction);
		}

		personaImpl.resetOriginalValues();

		return personaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		personaId = objectInput.readLong();

		channelId = objectInput.readLong();

		darkThemeId = objectInput.readLong();

		lightThemeId = objectInput.readLong();
		name = objectInput.readUTF();

		startAge = objectInput.readInt();

		endAge = objectInput.readInt();
		nationality = objectInput.readUTF();
		customerSegment = objectInput.readUTF();
		personaStatus = objectInput.readUTF();
		sector = objectInput.readUTF();

		minIncome = objectInput.readInt();

		maxIncome = objectInput.readInt();
		description = objectInput.readUTF();
		gender = objectInput.readUTF();

		priority = objectInput.readInt();
		dateFrom = objectInput.readLong();
		dateTo = objectInput.readLong();

		defaultPersona = objectInput.readBoolean();

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
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(personaId);

		objectOutput.writeLong(channelId);

		objectOutput.writeLong(darkThemeId);

		objectOutput.writeLong(lightThemeId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeInt(startAge);

		objectOutput.writeInt(endAge);

		if (nationality == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nationality);
		}

		if (customerSegment == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(customerSegment);
		}

		if (personaStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(personaStatus);
		}

		if (sector == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sector);
		}

		objectOutput.writeInt(minIncome);

		objectOutput.writeInt(maxIncome);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (gender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gender);
		}

		objectOutput.writeInt(priority);
		objectOutput.writeLong(dateFrom);
		objectOutput.writeLong(dateTo);

		objectOutput.writeBoolean(defaultPersona);

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
	}

	public long personaId;
	public long channelId;
	public long darkThemeId;
	public long lightThemeId;
	public String name;
	public int startAge;
	public int endAge;
	public String nationality;
	public String customerSegment;
	public String personaStatus;
	public String sector;
	public int minIncome;
	public int maxIncome;
	public String description;
	public String gender;
	public int priority;
	public long dateFrom;
	public long dateTo;
	public boolean defaultPersona;
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

}