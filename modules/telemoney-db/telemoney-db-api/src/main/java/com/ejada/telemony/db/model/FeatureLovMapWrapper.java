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
 * This class is a wrapper for {@link FeatureLovMap}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FeatureLovMap
 * @generated
 */
public class FeatureLovMapWrapper
	extends BaseModelWrapper<FeatureLovMap>
	implements FeatureLovMap, ModelWrapper<FeatureLovMap> {

	public FeatureLovMapWrapper(FeatureLovMap featureLovMap) {
		super(featureLovMap);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("featureId", getFeatureId());
		attributes.put("featureEntityResourceId", getFeatureEntityResourceId());
		attributes.put("lovEntityResourceId", getLovEntityResourceId());
		attributes.put("lovDataCode", getLovDataCode());
		attributes.put("lovType", getLovType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long featureId = (Long)attributes.get("featureId");

		if (featureId != null) {
			setFeatureId(featureId);
		}

		Long featureEntityResourceId = (Long)attributes.get(
			"featureEntityResourceId");

		if (featureEntityResourceId != null) {
			setFeatureEntityResourceId(featureEntityResourceId);
		}

		Long lovEntityResourceId = (Long)attributes.get("lovEntityResourceId");

		if (lovEntityResourceId != null) {
			setLovEntityResourceId(lovEntityResourceId);
		}

		String lovDataCode = (String)attributes.get("lovDataCode");

		if (lovDataCode != null) {
			setLovDataCode(lovDataCode);
		}

		String lovType = (String)attributes.get("lovType");

		if (lovType != null) {
			setLovType(lovType);
		}
	}

	@Override
	public FeatureLovMap cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the feature entity resource ID of this feature lov map.
	 *
	 * @return the feature entity resource ID of this feature lov map
	 */
	@Override
	public long getFeatureEntityResourceId() {
		return model.getFeatureEntityResourceId();
	}

	/**
	 * Returns the feature ID of this feature lov map.
	 *
	 * @return the feature ID of this feature lov map
	 */
	@Override
	public long getFeatureId() {
		return model.getFeatureId();
	}

	/**
	 * Returns the ID of this feature lov map.
	 *
	 * @return the ID of this feature lov map
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the lov data code of this feature lov map.
	 *
	 * @return the lov data code of this feature lov map
	 */
	@Override
	public String getLovDataCode() {
		return model.getLovDataCode();
	}

	/**
	 * Returns the lov entity resource ID of this feature lov map.
	 *
	 * @return the lov entity resource ID of this feature lov map
	 */
	@Override
	public long getLovEntityResourceId() {
		return model.getLovEntityResourceId();
	}

	/**
	 * Returns the lov type of this feature lov map.
	 *
	 * @return the lov type of this feature lov map
	 */
	@Override
	public String getLovType() {
		return model.getLovType();
	}

	/**
	 * Returns the primary key of this feature lov map.
	 *
	 * @return the primary key of this feature lov map
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the feature entity resource ID of this feature lov map.
	 *
	 * @param featureEntityResourceId the feature entity resource ID of this feature lov map
	 */
	@Override
	public void setFeatureEntityResourceId(long featureEntityResourceId) {
		model.setFeatureEntityResourceId(featureEntityResourceId);
	}

	/**
	 * Sets the feature ID of this feature lov map.
	 *
	 * @param featureId the feature ID of this feature lov map
	 */
	@Override
	public void setFeatureId(long featureId) {
		model.setFeatureId(featureId);
	}

	/**
	 * Sets the ID of this feature lov map.
	 *
	 * @param id the ID of this feature lov map
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the lov data code of this feature lov map.
	 *
	 * @param lovDataCode the lov data code of this feature lov map
	 */
	@Override
	public void setLovDataCode(String lovDataCode) {
		model.setLovDataCode(lovDataCode);
	}

	/**
	 * Sets the lov entity resource ID of this feature lov map.
	 *
	 * @param lovEntityResourceId the lov entity resource ID of this feature lov map
	 */
	@Override
	public void setLovEntityResourceId(long lovEntityResourceId) {
		model.setLovEntityResourceId(lovEntityResourceId);
	}

	/**
	 * Sets the lov type of this feature lov map.
	 *
	 * @param lovType the lov type of this feature lov map
	 */
	@Override
	public void setLovType(String lovType) {
		model.setLovType(lovType);
	}

	/**
	 * Sets the primary key of this feature lov map.
	 *
	 * @param primaryKey the primary key of this feature lov map
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
	protected FeatureLovMapWrapper wrap(FeatureLovMap featureLovMap) {
		return new FeatureLovMapWrapper(featureLovMap);
	}

}