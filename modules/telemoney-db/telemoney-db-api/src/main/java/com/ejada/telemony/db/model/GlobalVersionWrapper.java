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
 * This class is a wrapper for {@link GlobalVersion}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GlobalVersion
 * @generated
 */
public class GlobalVersionWrapper
	extends BaseModelWrapper<GlobalVersion>
	implements GlobalVersion, ModelWrapper<GlobalVersion> {

	public GlobalVersionWrapper(GlobalVersion globalVersion) {
		super(globalVersion);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("versionId", getVersionId());
		attributes.put("companyId", getCompanyId());
		attributes.put("channelId", getChannelId());
		attributes.put("componentName", getComponentName());
		attributes.put("version", getVersion());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long versionId = (Long)attributes.get("versionId");

		if (versionId != null) {
			setVersionId(versionId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long channelId = (Long)attributes.get("channelId");

		if (channelId != null) {
			setChannelId(channelId);
		}

		String componentName = (String)attributes.get("componentName");

		if (componentName != null) {
			setComponentName(componentName);
		}

		Long version = (Long)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public GlobalVersion cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the channel ID of this global version.
	 *
	 * @return the channel ID of this global version
	 */
	@Override
	public long getChannelId() {
		return model.getChannelId();
	}

	/**
	 * Returns the company ID of this global version.
	 *
	 * @return the company ID of this global version
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the component name of this global version.
	 *
	 * @return the component name of this global version
	 */
	@Override
	public String getComponentName() {
		return model.getComponentName();
	}

	/**
	 * Returns the modified date of this global version.
	 *
	 * @return the modified date of this global version
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this global version.
	 *
	 * @return the primary key of this global version
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the version of this global version.
	 *
	 * @return the version of this global version
	 */
	@Override
	public long getVersion() {
		return model.getVersion();
	}

	/**
	 * Returns the version ID of this global version.
	 *
	 * @return the version ID of this global version
	 */
	@Override
	public long getVersionId() {
		return model.getVersionId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the channel ID of this global version.
	 *
	 * @param channelId the channel ID of this global version
	 */
	@Override
	public void setChannelId(long channelId) {
		model.setChannelId(channelId);
	}

	/**
	 * Sets the company ID of this global version.
	 *
	 * @param companyId the company ID of this global version
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the component name of this global version.
	 *
	 * @param componentName the component name of this global version
	 */
	@Override
	public void setComponentName(String componentName) {
		model.setComponentName(componentName);
	}

	/**
	 * Sets the modified date of this global version.
	 *
	 * @param modifiedDate the modified date of this global version
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this global version.
	 *
	 * @param primaryKey the primary key of this global version
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the version of this global version.
	 *
	 * @param version the version of this global version
	 */
	@Override
	public void setVersion(long version) {
		model.setVersion(version);
	}

	/**
	 * Sets the version ID of this global version.
	 *
	 * @param versionId the version ID of this global version
	 */
	@Override
	public void setVersionId(long versionId) {
		model.setVersionId(versionId);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected GlobalVersionWrapper wrap(GlobalVersion globalVersion) {
		return new GlobalVersionWrapper(globalVersion);
	}

}