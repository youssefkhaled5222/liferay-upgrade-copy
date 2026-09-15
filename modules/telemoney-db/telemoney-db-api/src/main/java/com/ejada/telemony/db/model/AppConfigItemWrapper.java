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
 * This class is a wrapper for {@link AppConfigItem}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppConfigItem
 * @generated
 */
public class AppConfigItemWrapper
	extends BaseModelWrapper<AppConfigItem>
	implements AppConfigItem, ModelWrapper<AppConfigItem> {

	public AppConfigItemWrapper(AppConfigItem appConfigItem) {
		super(appConfigItem);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("configItemId", getConfigItemId());
		attributes.put("environmentId", getEnvironmentId());
		attributes.put("keyName", getKeyName());
		attributes.put("valueType", getValueType());
		attributes.put("value", getValue());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long configItemId = (Long)attributes.get("configItemId");

		if (configItemId != null) {
			setConfigItemId(configItemId);
		}

		Long environmentId = (Long)attributes.get("environmentId");

		if (environmentId != null) {
			setEnvironmentId(environmentId);
		}

		String keyName = (String)attributes.get("keyName");

		if (keyName != null) {
			setKeyName(keyName);
		}

		String valueType = (String)attributes.get("valueType");

		if (valueType != null) {
			setValueType(valueType);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public AppConfigItem cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the config item ID of this app config item.
	 *
	 * @return the config item ID of this app config item
	 */
	@Override
	public long getConfigItemId() {
		return model.getConfigItemId();
	}

	/**
	 * Returns the create date of this app config item.
	 *
	 * @return the create date of this app config item
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the environment ID of this app config item.
	 *
	 * @return the environment ID of this app config item
	 */
	@Override
	public long getEnvironmentId() {
		return model.getEnvironmentId();
	}

	/**
	 * Returns the key name of this app config item.
	 *
	 * @return the key name of this app config item
	 */
	@Override
	public String getKeyName() {
		return model.getKeyName();
	}

	/**
	 * Returns the modified date of this app config item.
	 *
	 * @return the modified date of this app config item
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this app config item.
	 *
	 * @return the primary key of this app config item
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the value of this app config item.
	 *
	 * @return the value of this app config item
	 */
	@Override
	public String getValue() {
		return model.getValue();
	}

	/**
	 * Returns the value type of this app config item.
	 *
	 * @return the value type of this app config item
	 */
	@Override
	public String getValueType() {
		return model.getValueType();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the config item ID of this app config item.
	 *
	 * @param configItemId the config item ID of this app config item
	 */
	@Override
	public void setConfigItemId(long configItemId) {
		model.setConfigItemId(configItemId);
	}

	/**
	 * Sets the create date of this app config item.
	 *
	 * @param createDate the create date of this app config item
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the environment ID of this app config item.
	 *
	 * @param environmentId the environment ID of this app config item
	 */
	@Override
	public void setEnvironmentId(long environmentId) {
		model.setEnvironmentId(environmentId);
	}

	/**
	 * Sets the key name of this app config item.
	 *
	 * @param keyName the key name of this app config item
	 */
	@Override
	public void setKeyName(String keyName) {
		model.setKeyName(keyName);
	}

	/**
	 * Sets the modified date of this app config item.
	 *
	 * @param modifiedDate the modified date of this app config item
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this app config item.
	 *
	 * @param primaryKey the primary key of this app config item
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the value of this app config item.
	 *
	 * @param value the value of this app config item
	 */
	@Override
	public void setValue(String value) {
		model.setValue(value);
	}

	/**
	 * Sets the value type of this app config item.
	 *
	 * @param valueType the value type of this app config item
	 */
	@Override
	public void setValueType(String valueType) {
		model.setValueType(valueType);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected AppConfigItemWrapper wrap(AppConfigItem appConfigItem) {
		return new AppConfigItemWrapper(appConfigItem);
	}

}