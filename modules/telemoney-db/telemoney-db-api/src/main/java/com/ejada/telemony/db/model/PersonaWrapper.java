/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Persona}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Persona
 * @generated
 */
public class PersonaWrapper
	extends BaseModelWrapper<Persona>
	implements ModelWrapper<Persona>, Persona {

	public PersonaWrapper(Persona persona) {
		super(persona);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("personaId", getPersonaId());
		attributes.put("channelId", getChannelId());
		attributes.put("darkThemeId", getDarkThemeId());
		attributes.put("lightThemeId", getLightThemeId());
		attributes.put("name", getName());
		attributes.put("startAge", getStartAge());
		attributes.put("endAge", getEndAge());
		attributes.put("nationality", getNationality());
		attributes.put("customerSegment", getCustomerSegment());
		attributes.put("personaStatus", getPersonaStatus());
		attributes.put("sector", getSector());
		attributes.put("minIncome", getMinIncome());
		attributes.put("maxIncome", getMaxIncome());
		attributes.put("description", getDescription());
		attributes.put("gender", getGender());
		attributes.put("priority", getPriority());
		attributes.put("dateFrom", getDateFrom());
		attributes.put("dateTo", getDateTo());
		attributes.put("defaultPersona", isDefaultPersona());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("uuid_", getUuid_());
		attributes.put("originalEntityId", getOriginalEntityId());
		attributes.put("entityResourceId", getEntityResourceId());
		attributes.put("version", getVersion());
		attributes.put("workflowAction", getWorkflowAction());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long personaId = (Long)attributes.get("personaId");

		if (personaId != null) {
			setPersonaId(personaId);
		}

		Long channelId = (Long)attributes.get("channelId");

		if (channelId != null) {
			setChannelId(channelId);
		}

		Long darkThemeId = (Long)attributes.get("darkThemeId");

		if (darkThemeId != null) {
			setDarkThemeId(darkThemeId);
		}

		Long lightThemeId = (Long)attributes.get("lightThemeId");

		if (lightThemeId != null) {
			setLightThemeId(lightThemeId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer startAge = (Integer)attributes.get("startAge");

		if (startAge != null) {
			setStartAge(startAge);
		}

		Integer endAge = (Integer)attributes.get("endAge");

		if (endAge != null) {
			setEndAge(endAge);
		}

		String nationality = (String)attributes.get("nationality");

		if (nationality != null) {
			setNationality(nationality);
		}

		String customerSegment = (String)attributes.get("customerSegment");

		if (customerSegment != null) {
			setCustomerSegment(customerSegment);
		}

		String personaStatus = (String)attributes.get("personaStatus");

		if (personaStatus != null) {
			setPersonaStatus(personaStatus);
		}

		String sector = (String)attributes.get("sector");

		if (sector != null) {
			setSector(sector);
		}

		Integer minIncome = (Integer)attributes.get("minIncome");

		if (minIncome != null) {
			setMinIncome(minIncome);
		}

		Integer maxIncome = (Integer)attributes.get("maxIncome");

		if (maxIncome != null) {
			setMaxIncome(maxIncome);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		Integer priority = (Integer)attributes.get("priority");

		if (priority != null) {
			setPriority(priority);
		}

		Date dateFrom = (Date)attributes.get("dateFrom");

		if (dateFrom != null) {
			setDateFrom(dateFrom);
		}

		Date dateTo = (Date)attributes.get("dateTo");

		if (dateTo != null) {
			setDateTo(dateTo);
		}

		Boolean defaultPersona = (Boolean)attributes.get("defaultPersona");

		if (defaultPersona != null) {
			setDefaultPersona(defaultPersona);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		String uuid_ = (String)attributes.get("uuid_");

		if (uuid_ != null) {
			setUuid_(uuid_);
		}

		Long originalEntityId = (Long)attributes.get("originalEntityId");

		if (originalEntityId != null) {
			setOriginalEntityId(originalEntityId);
		}

		Long entityResourceId = (Long)attributes.get("entityResourceId");

		if (entityResourceId != null) {
			setEntityResourceId(entityResourceId);
		}

		Integer version = (Integer)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		String workflowAction = (String)attributes.get("workflowAction");

		if (workflowAction != null) {
			setWorkflowAction(workflowAction);
		}
	}

	@Override
	public Persona cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the channel ID of this persona.
	 *
	 * @return the channel ID of this persona
	 */
	@Override
	public long getChannelId() {
		return model.getChannelId();
	}

	/**
	 * Returns the company ID of this persona.
	 *
	 * @return the company ID of this persona
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this persona.
	 *
	 * @return the create date of this persona
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the customer segment of this persona.
	 *
	 * @return the customer segment of this persona
	 */
	@Override
	public String getCustomerSegment() {
		return model.getCustomerSegment();
	}

	/**
	 * Returns the dark theme ID of this persona.
	 *
	 * @return the dark theme ID of this persona
	 */
	@Override
	public Long getDarkThemeId() {
		return model.getDarkThemeId();
	}

	/**
	 * Returns the date from of this persona.
	 *
	 * @return the date from of this persona
	 */
	@Override
	public Date getDateFrom() {
		return model.getDateFrom();
	}

	/**
	 * Returns the date to of this persona.
	 *
	 * @return the date to of this persona
	 */
	@Override
	public Date getDateTo() {
		return model.getDateTo();
	}

	/**
	 * Returns the default persona of this persona.
	 *
	 * @return the default persona of this persona
	 */
	@Override
	public boolean getDefaultPersona() {
		return model.getDefaultPersona();
	}

	/**
	 * Returns the description of this persona.
	 *
	 * @return the description of this persona
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the end age of this persona.
	 *
	 * @return the end age of this persona
	 */
	@Override
	public int getEndAge() {
		return model.getEndAge();
	}

	/**
	 * Returns the entity resource ID of this persona.
	 *
	 * @return the entity resource ID of this persona
	 */
	@Override
	public long getEntityResourceId() {
		return model.getEntityResourceId();
	}

	/**
	 * Returns the gender of this persona.
	 *
	 * @return the gender of this persona
	 */
	@Override
	public String getGender() {
		return model.getGender();
	}

	/**
	 * Returns the group ID of this persona.
	 *
	 * @return the group ID of this persona
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the light theme ID of this persona.
	 *
	 * @return the light theme ID of this persona
	 */
	@Override
	public Long getLightThemeId() {
		return model.getLightThemeId();
	}

	/**
	 * Returns the max income of this persona.
	 *
	 * @return the max income of this persona
	 */
	@Override
	public int getMaxIncome() {
		return model.getMaxIncome();
	}

	/**
	 * Returns the min income of this persona.
	 *
	 * @return the min income of this persona
	 */
	@Override
	public int getMinIncome() {
		return model.getMinIncome();
	}

	/**
	 * Returns the modified date of this persona.
	 *
	 * @return the modified date of this persona
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this persona.
	 *
	 * @return the name of this persona
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the nationality of this persona.
	 *
	 * @return the nationality of this persona
	 */
	@Override
	public String getNationality() {
		return model.getNationality();
	}

	/**
	 * Returns the original entity ID of this persona.
	 *
	 * @return the original entity ID of this persona
	 */
	@Override
	public long getOriginalEntityId() {
		return model.getOriginalEntityId();
	}

	/**
	 * Returns the persona ID of this persona.
	 *
	 * @return the persona ID of this persona
	 */
	@Override
	public long getPersonaId() {
		return model.getPersonaId();
	}

	/**
	 * Returns the persona status of this persona.
	 *
	 * @return the persona status of this persona
	 */
	@Override
	public String getPersonaStatus() {
		return model.getPersonaStatus();
	}

	/**
	 * Returns the primary key of this persona.
	 *
	 * @return the primary key of this persona
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the priority of this persona.
	 *
	 * @return the priority of this persona
	 */
	@Override
	public int getPriority() {
		return model.getPriority();
	}

	/**
	 * Returns the sector of this persona.
	 *
	 * @return the sector of this persona
	 */
	@Override
	public String getSector() {
		return model.getSector();
	}

	/**
	 * Returns the start age of this persona.
	 *
	 * @return the start age of this persona
	 */
	@Override
	public int getStartAge() {
		return model.getStartAge();
	}

	/**
	 * Returns the status of this persona.
	 *
	 * @return the status of this persona
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this persona.
	 *
	 * @return the status by user ID of this persona
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this persona.
	 *
	 * @return the status by user name of this persona
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this persona.
	 *
	 * @return the status by user uuid of this persona
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this persona.
	 *
	 * @return the status date of this persona
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the user ID of this persona.
	 *
	 * @return the user ID of this persona
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this persona.
	 *
	 * @return the user name of this persona
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this persona.
	 *
	 * @return the user uuid of this persona
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid_ of this persona.
	 *
	 * @return the uuid_ of this persona
	 */
	@Override
	public String getUuid_() {
		return model.getUuid_();
	}

	/**
	 * Returns the version of this persona.
	 *
	 * @return the version of this persona
	 */
	@Override
	public int getVersion() {
		return model.getVersion();
	}

	/**
	 * Returns the workflow action of this persona.
	 *
	 * @return the workflow action of this persona
	 */
	@Override
	public String getWorkflowAction() {
		return model.getWorkflowAction();
	}

	/**
	 * Returns <code>true</code> if this persona is approved.
	 *
	 * @return <code>true</code> if this persona is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this persona is default persona.
	 *
	 * @return <code>true</code> if this persona is default persona; <code>false</code> otherwise
	 */
	@Override
	public boolean isDefaultPersona() {
		return model.isDefaultPersona();
	}

	/**
	 * Returns <code>true</code> if this persona is denied.
	 *
	 * @return <code>true</code> if this persona is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this persona is a draft.
	 *
	 * @return <code>true</code> if this persona is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this persona is expired.
	 *
	 * @return <code>true</code> if this persona is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this persona is inactive.
	 *
	 * @return <code>true</code> if this persona is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this persona is incomplete.
	 *
	 * @return <code>true</code> if this persona is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this persona is pending.
	 *
	 * @return <code>true</code> if this persona is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this persona is scheduled.
	 *
	 * @return <code>true</code> if this persona is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the channel ID of this persona.
	 *
	 * @param channelId the channel ID of this persona
	 */
	@Override
	public void setChannelId(long channelId) {
		model.setChannelId(channelId);
	}

	/**
	 * Sets the company ID of this persona.
	 *
	 * @param companyId the company ID of this persona
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this persona.
	 *
	 * @param createDate the create date of this persona
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the customer segment of this persona.
	 *
	 * @param customerSegment the customer segment of this persona
	 */
	@Override
	public void setCustomerSegment(String customerSegment) {
		model.setCustomerSegment(customerSegment);
	}

	/**
	 * Sets the dark theme ID of this persona.
	 *
	 * @param darkThemeId the dark theme ID of this persona
	 */
	@Override
	public void setDarkThemeId(Long darkThemeId) {
		model.setDarkThemeId(darkThemeId);
	}

	/**
	 * Sets the date from of this persona.
	 *
	 * @param dateFrom the date from of this persona
	 */
	@Override
	public void setDateFrom(Date dateFrom) {
		model.setDateFrom(dateFrom);
	}

	/**
	 * Sets the date to of this persona.
	 *
	 * @param dateTo the date to of this persona
	 */
	@Override
	public void setDateTo(Date dateTo) {
		model.setDateTo(dateTo);
	}

	/**
	 * Sets whether this persona is default persona.
	 *
	 * @param defaultPersona the default persona of this persona
	 */
	@Override
	public void setDefaultPersona(boolean defaultPersona) {
		model.setDefaultPersona(defaultPersona);
	}

	/**
	 * Sets the description of this persona.
	 *
	 * @param description the description of this persona
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the end age of this persona.
	 *
	 * @param endAge the end age of this persona
	 */
	@Override
	public void setEndAge(int endAge) {
		model.setEndAge(endAge);
	}

	/**
	 * Sets the entity resource ID of this persona.
	 *
	 * @param entityResourceId the entity resource ID of this persona
	 */
	@Override
	public void setEntityResourceId(long entityResourceId) {
		model.setEntityResourceId(entityResourceId);
	}

	/**
	 * Sets the gender of this persona.
	 *
	 * @param gender the gender of this persona
	 */
	@Override
	public void setGender(String gender) {
		model.setGender(gender);
	}

	/**
	 * Sets the group ID of this persona.
	 *
	 * @param groupId the group ID of this persona
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the light theme ID of this persona.
	 *
	 * @param lightThemeId the light theme ID of this persona
	 */
	@Override
	public void setLightThemeId(Long lightThemeId) {
		model.setLightThemeId(lightThemeId);
	}

	/**
	 * Sets the max income of this persona.
	 *
	 * @param maxIncome the max income of this persona
	 */
	@Override
	public void setMaxIncome(int maxIncome) {
		model.setMaxIncome(maxIncome);
	}

	/**
	 * Sets the min income of this persona.
	 *
	 * @param minIncome the min income of this persona
	 */
	@Override
	public void setMinIncome(int minIncome) {
		model.setMinIncome(minIncome);
	}

	/**
	 * Sets the modified date of this persona.
	 *
	 * @param modifiedDate the modified date of this persona
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this persona.
	 *
	 * @param name the name of this persona
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the nationality of this persona.
	 *
	 * @param nationality the nationality of this persona
	 */
	@Override
	public void setNationality(String nationality) {
		model.setNationality(nationality);
	}

	/**
	 * Sets the original entity ID of this persona.
	 *
	 * @param originalEntityId the original entity ID of this persona
	 */
	@Override
	public void setOriginalEntityId(long originalEntityId) {
		model.setOriginalEntityId(originalEntityId);
	}

	/**
	 * Sets the persona ID of this persona.
	 *
	 * @param personaId the persona ID of this persona
	 */
	@Override
	public void setPersonaId(long personaId) {
		model.setPersonaId(personaId);
	}

	/**
	 * Sets the persona status of this persona.
	 *
	 * @param personaStatus the persona status of this persona
	 */
	@Override
	public void setPersonaStatus(String personaStatus) {
		model.setPersonaStatus(personaStatus);
	}

	/**
	 * Sets the primary key of this persona.
	 *
	 * @param primaryKey the primary key of this persona
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the priority of this persona.
	 *
	 * @param priority the priority of this persona
	 */
	@Override
	public void setPriority(int priority) {
		model.setPriority(priority);
	}

	/**
	 * Sets the sector of this persona.
	 *
	 * @param sector the sector of this persona
	 */
	@Override
	public void setSector(String sector) {
		model.setSector(sector);
	}

	/**
	 * Sets the start age of this persona.
	 *
	 * @param startAge the start age of this persona
	 */
	@Override
	public void setStartAge(int startAge) {
		model.setStartAge(startAge);
	}

	/**
	 * Sets the status of this persona.
	 *
	 * @param status the status of this persona
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this persona.
	 *
	 * @param statusByUserId the status by user ID of this persona
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this persona.
	 *
	 * @param statusByUserName the status by user name of this persona
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this persona.
	 *
	 * @param statusByUserUuid the status by user uuid of this persona
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this persona.
	 *
	 * @param statusDate the status date of this persona
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the user ID of this persona.
	 *
	 * @param userId the user ID of this persona
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this persona.
	 *
	 * @param userName the user name of this persona
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this persona.
	 *
	 * @param userUuid the user uuid of this persona
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid_ of this persona.
	 *
	 * @param uuid_ the uuid_ of this persona
	 */
	@Override
	public void setUuid_(String uuid_) {
		model.setUuid_(uuid_);
	}

	/**
	 * Sets the version of this persona.
	 *
	 * @param version the version of this persona
	 */
	@Override
	public void setVersion(int version) {
		model.setVersion(version);
	}

	/**
	 * Sets the workflow action of this persona.
	 *
	 * @param workflowAction the workflow action of this persona
	 */
	@Override
	public void setWorkflowAction(String workflowAction) {
		model.setWorkflowAction(workflowAction);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected PersonaWrapper wrap(Persona persona) {
		return new PersonaWrapper(persona);
	}

}