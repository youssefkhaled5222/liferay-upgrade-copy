/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LovData}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LovData
 * @generated
 */
public class LovDataWrapper
	extends BaseModelWrapper<LovData>
	implements LovData, ModelWrapper<LovData> {

	public LovDataWrapper(LovData lovData) {
		super(lovData);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("defaultLanguageId", getDefaultLanguageId());
		attributes.put("id", getId());
		attributes.put("lovId", getLovId());
		attributes.put("lovType", getLovType());
		attributes.put("recordTypeCode", getRecordTypeCode());
		attributes.put("recordShortDescription", getRecordShortDescription());
		attributes.put("status", getStatus());
		attributes.put("originalEntityId", getOriginalEntityId());
		attributes.put("entityResourceId", getEntityResourceId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String defaultLanguageId = (String)attributes.get("defaultLanguageId");

		if (defaultLanguageId != null) {
			setDefaultLanguageId(defaultLanguageId);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long lovId = (Long)attributes.get("lovId");

		if (lovId != null) {
			setLovId(lovId);
		}

		String lovType = (String)attributes.get("lovType");

		if (lovType != null) {
			setLovType(lovType);
		}

		String recordTypeCode = (String)attributes.get("recordTypeCode");

		if (recordTypeCode != null) {
			setRecordTypeCode(recordTypeCode);
		}

		String recordShortDescription = (String)attributes.get(
			"recordShortDescription");

		if (recordShortDescription != null) {
			setRecordShortDescription(recordShortDescription);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long originalEntityId = (Long)attributes.get("originalEntityId");

		if (originalEntityId != null) {
			setOriginalEntityId(originalEntityId);
		}

		Long entityResourceId = (Long)attributes.get("entityResourceId");

		if (entityResourceId != null) {
			setEntityResourceId(entityResourceId);
		}
	}

	@Override
	public LovData cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the default language ID of this lov data.
	 *
	 * @return the default language ID of this lov data
	 */
	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the entity resource ID of this lov data.
	 *
	 * @return the entity resource ID of this lov data
	 */
	@Override
	public long getEntityResourceId() {
		return model.getEntityResourceId();
	}

	/**
	 * Returns the ID of this lov data.
	 *
	 * @return the ID of this lov data
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	@Override
	public Map<String, String> getLanguageIdToLovIdLocalizationMap() {
		return model.getLanguageIdToLovIdLocalizationMap();
	}

	@Override
	public Map<String, String> getLanguageIdToRecordDescriptionMap() {
		return model.getLanguageIdToRecordDescriptionMap();
	}

	/**
	 * Returns the lov ID of this lov data.
	 *
	 * @return the lov ID of this lov data
	 */
	@Override
	public long getLovId() {
		return model.getLovId();
	}

	@Override
	public String getLovIdLocalization() {
		return model.getLovIdLocalization();
	}

	@Override
	public String getLovIdLocalization(String languageId) {
		return model.getLovIdLocalization(languageId);
	}

	@Override
	public String getLovIdLocalization(String languageId, boolean useDefault) {
		return model.getLovIdLocalization(languageId, useDefault);
	}

	@Override
	public String getLovIdLocalizationMapAsXML() {
		return model.getLovIdLocalizationMapAsXML();
	}

	/**
	 * Returns the lov type of this lov data.
	 *
	 * @return the lov type of this lov data
	 */
	@Override
	public String getLovType() {
		return model.getLovType();
	}

	/**
	 * Returns the original entity ID of this lov data.
	 *
	 * @return the original entity ID of this lov data
	 */
	@Override
	public long getOriginalEntityId() {
		return model.getOriginalEntityId();
	}

	/**
	 * Returns the primary key of this lov data.
	 *
	 * @return the primary key of this lov data
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public String getRecordDescription() {
		return model.getRecordDescription();
	}

	@Override
	public String getRecordDescription(String languageId) {
		return model.getRecordDescription(languageId);
	}

	@Override
	public String getRecordDescription(String languageId, boolean useDefault) {
		return model.getRecordDescription(languageId, useDefault);
	}

	@Override
	public String getRecordDescriptionMapAsXML() {
		return model.getRecordDescriptionMapAsXML();
	}

	/**
	 * Returns the record short description of this lov data.
	 *
	 * @return the record short description of this lov data
	 */
	@Override
	public String getRecordShortDescription() {
		return model.getRecordShortDescription();
	}

	/**
	 * Returns the record type code of this lov data.
	 *
	 * @return the record type code of this lov data
	 */
	@Override
	public String getRecordTypeCode() {
		return model.getRecordTypeCode();
	}

	/**
	 * Returns the status of this lov data.
	 *
	 * @return the status of this lov data
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the default language ID of this lov data.
	 *
	 * @param defaultLanguageId the default language ID of this lov data
	 */
	@Override
	public void setDefaultLanguageId(String defaultLanguageId) {
		model.setDefaultLanguageId(defaultLanguageId);
	}

	/**
	 * Sets the entity resource ID of this lov data.
	 *
	 * @param entityResourceId the entity resource ID of this lov data
	 */
	@Override
	public void setEntityResourceId(long entityResourceId) {
		model.setEntityResourceId(entityResourceId);
	}

	/**
	 * Sets the ID of this lov data.
	 *
	 * @param id the ID of this lov data
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the lov ID of this lov data.
	 *
	 * @param lovId the lov ID of this lov data
	 */
	@Override
	public void setLovId(long lovId) {
		model.setLovId(lovId);
	}

	/**
	 * Sets the lov type of this lov data.
	 *
	 * @param lovType the lov type of this lov data
	 */
	@Override
	public void setLovType(String lovType) {
		model.setLovType(lovType);
	}

	/**
	 * Sets the original entity ID of this lov data.
	 *
	 * @param originalEntityId the original entity ID of this lov data
	 */
	@Override
	public void setOriginalEntityId(long originalEntityId) {
		model.setOriginalEntityId(originalEntityId);
	}

	/**
	 * Sets the primary key of this lov data.
	 *
	 * @param primaryKey the primary key of this lov data
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the record short description of this lov data.
	 *
	 * @param recordShortDescription the record short description of this lov data
	 */
	@Override
	public void setRecordShortDescription(String recordShortDescription) {
		model.setRecordShortDescription(recordShortDescription);
	}

	/**
	 * Sets the record type code of this lov data.
	 *
	 * @param recordTypeCode the record type code of this lov data
	 */
	@Override
	public void setRecordTypeCode(String recordTypeCode) {
		model.setRecordTypeCode(recordTypeCode);
	}

	/**
	 * Sets the status of this lov data.
	 *
	 * @param status the status of this lov data
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected LovDataWrapper wrap(LovData lovData) {
		return new LovDataWrapper(lovData);
	}

}