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
 * This class is a wrapper for {@link LovsLocalization}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LovsLocalization
 * @generated
 */
public class LovsLocalizationWrapper
	extends BaseModelWrapper<LovsLocalization>
	implements LovsLocalization, ModelWrapper<LovsLocalization> {

	public LovsLocalizationWrapper(LovsLocalization lovsLocalization) {
		super(lovsLocalization);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("lovsLocalizationId", getLovsLocalizationId());
		attributes.put("companyId", getCompanyId());
		attributes.put("id", getId());
		attributes.put("languageId", getLanguageId());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		Long lovsLocalizationId = (Long)attributes.get("lovsLocalizationId");

		if (lovsLocalizationId != null) {
			setLovsLocalizationId(lovsLocalizationId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String languageId = (String)attributes.get("languageId");

		if (languageId != null) {
			setLanguageId(languageId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	@Override
	public LovsLocalization cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this lovs localization.
	 *
	 * @return the company ID of this lovs localization
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the ID of this lovs localization.
	 *
	 * @return the ID of this lovs localization
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the language ID of this lovs localization.
	 *
	 * @return the language ID of this lovs localization
	 */
	@Override
	public String getLanguageId() {
		return model.getLanguageId();
	}

	/**
	 * Returns the lovs localization ID of this lovs localization.
	 *
	 * @return the lovs localization ID of this lovs localization
	 */
	@Override
	public long getLovsLocalizationId() {
		return model.getLovsLocalizationId();
	}

	/**
	 * Returns the mvcc version of this lovs localization.
	 *
	 * @return the mvcc version of this lovs localization
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the name of this lovs localization.
	 *
	 * @return the name of this lovs localization
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this lovs localization.
	 *
	 * @return the primary key of this lovs localization
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Sets the company ID of this lovs localization.
	 *
	 * @param companyId the company ID of this lovs localization
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the ID of this lovs localization.
	 *
	 * @param id the ID of this lovs localization
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the language ID of this lovs localization.
	 *
	 * @param languageId the language ID of this lovs localization
	 */
	@Override
	public void setLanguageId(String languageId) {
		model.setLanguageId(languageId);
	}

	/**
	 * Sets the lovs localization ID of this lovs localization.
	 *
	 * @param lovsLocalizationId the lovs localization ID of this lovs localization
	 */
	@Override
	public void setLovsLocalizationId(long lovsLocalizationId) {
		model.setLovsLocalizationId(lovsLocalizationId);
	}

	/**
	 * Sets the mvcc version of this lovs localization.
	 *
	 * @param mvccVersion the mvcc version of this lovs localization
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the name of this lovs localization.
	 *
	 * @param name the name of this lovs localization
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this lovs localization.
	 *
	 * @param primaryKey the primary key of this lovs localization
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected LovsLocalizationWrapper wrap(LovsLocalization lovsLocalization) {
		return new LovsLocalizationWrapper(lovsLocalization);
	}

}