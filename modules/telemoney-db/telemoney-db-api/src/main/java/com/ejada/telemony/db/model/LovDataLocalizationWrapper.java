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
 * This class is a wrapper for {@link LovDataLocalization}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LovDataLocalization
 * @generated
 */
public class LovDataLocalizationWrapper
	extends BaseModelWrapper<LovDataLocalization>
	implements LovDataLocalization, ModelWrapper<LovDataLocalization> {

	public LovDataLocalizationWrapper(LovDataLocalization lovDataLocalization) {
		super(lovDataLocalization);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("lovDataLocalizationId", getLovDataLocalizationId());
		attributes.put("id", getId());
		attributes.put("languageId", getLanguageId());
		attributes.put("recordDescription", getRecordDescription());
		attributes.put("lovIdLocalization", getLovIdLocalization());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		Long lovDataLocalizationId = (Long)attributes.get(
			"lovDataLocalizationId");

		if (lovDataLocalizationId != null) {
			setLovDataLocalizationId(lovDataLocalizationId);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String languageId = (String)attributes.get("languageId");

		if (languageId != null) {
			setLanguageId(languageId);
		}

		String recordDescription = (String)attributes.get("recordDescription");

		if (recordDescription != null) {
			setRecordDescription(recordDescription);
		}

		String lovIdLocalization = (String)attributes.get("lovIdLocalization");

		if (lovIdLocalization != null) {
			setLovIdLocalization(lovIdLocalization);
		}
	}

	@Override
	public LovDataLocalization cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the ID of this lov data localization.
	 *
	 * @return the ID of this lov data localization
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the language ID of this lov data localization.
	 *
	 * @return the language ID of this lov data localization
	 */
	@Override
	public String getLanguageId() {
		return model.getLanguageId();
	}

	/**
	 * Returns the lov data localization ID of this lov data localization.
	 *
	 * @return the lov data localization ID of this lov data localization
	 */
	@Override
	public long getLovDataLocalizationId() {
		return model.getLovDataLocalizationId();
	}

	/**
	 * Returns the lov ID localization of this lov data localization.
	 *
	 * @return the lov ID localization of this lov data localization
	 */
	@Override
	public String getLovIdLocalization() {
		return model.getLovIdLocalization();
	}

	/**
	 * Returns the mvcc version of this lov data localization.
	 *
	 * @return the mvcc version of this lov data localization
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the primary key of this lov data localization.
	 *
	 * @return the primary key of this lov data localization
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the record description of this lov data localization.
	 *
	 * @return the record description of this lov data localization
	 */
	@Override
	public String getRecordDescription() {
		return model.getRecordDescription();
	}

	/**
	 * Sets the ID of this lov data localization.
	 *
	 * @param id the ID of this lov data localization
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the language ID of this lov data localization.
	 *
	 * @param languageId the language ID of this lov data localization
	 */
	@Override
	public void setLanguageId(String languageId) {
		model.setLanguageId(languageId);
	}

	/**
	 * Sets the lov data localization ID of this lov data localization.
	 *
	 * @param lovDataLocalizationId the lov data localization ID of this lov data localization
	 */
	@Override
	public void setLovDataLocalizationId(long lovDataLocalizationId) {
		model.setLovDataLocalizationId(lovDataLocalizationId);
	}

	/**
	 * Sets the lov ID localization of this lov data localization.
	 *
	 * @param lovIdLocalization the lov ID localization of this lov data localization
	 */
	@Override
	public void setLovIdLocalization(String lovIdLocalization) {
		model.setLovIdLocalization(lovIdLocalization);
	}

	/**
	 * Sets the mvcc version of this lov data localization.
	 *
	 * @param mvccVersion the mvcc version of this lov data localization
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the primary key of this lov data localization.
	 *
	 * @param primaryKey the primary key of this lov data localization
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the record description of this lov data localization.
	 *
	 * @param recordDescription the record description of this lov data localization
	 */
	@Override
	public void setRecordDescription(String recordDescription) {
		model.setRecordDescription(recordDescription);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected LovDataLocalizationWrapper wrap(
		LovDataLocalization lovDataLocalization) {

		return new LovDataLocalizationWrapper(lovDataLocalization);
	}

}