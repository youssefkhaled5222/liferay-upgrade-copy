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
 * This class is a wrapper for {@link ResourceLocalization}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ResourceLocalization
 * @generated
 */
public class ResourceLocalizationWrapper
	extends BaseModelWrapper<ResourceLocalization>
	implements ModelWrapper<ResourceLocalization>, ResourceLocalization {

	public ResourceLocalizationWrapper(
		ResourceLocalization resourceLocalization) {

		super(resourceLocalization);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("resourceLocalizationId", getResourceLocalizationId());
		attributes.put("companyId", getCompanyId());
		attributes.put("resourceId", getResourceId());
		attributes.put("languageId", getLanguageId());
		attributes.put("name", getName());
		attributes.put("attachName", getAttachName());
		attributes.put("attach", getAttach());
		attributes.put("description", getDescription());
		attributes.put("routeId", getRouteId());
		attributes.put("url", getUrl());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		Long resourceLocalizationId = (Long)attributes.get(
			"resourceLocalizationId");

		if (resourceLocalizationId != null) {
			setResourceLocalizationId(resourceLocalizationId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long resourceId = (Long)attributes.get("resourceId");

		if (resourceId != null) {
			setResourceId(resourceId);
		}

		String languageId = (String)attributes.get("languageId");

		if (languageId != null) {
			setLanguageId(languageId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String attachName = (String)attributes.get("attachName");

		if (attachName != null) {
			setAttachName(attachName);
		}

		String attach = (String)attributes.get("attach");

		if (attach != null) {
			setAttach(attach);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String routeId = (String)attributes.get("routeId");

		if (routeId != null) {
			setRouteId(routeId);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}
	}

	@Override
	public ResourceLocalization cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the attach of this resource localization.
	 *
	 * @return the attach of this resource localization
	 */
	@Override
	public String getAttach() {
		return model.getAttach();
	}

	/**
	 * Returns the attach name of this resource localization.
	 *
	 * @return the attach name of this resource localization
	 */
	@Override
	public String getAttachName() {
		return model.getAttachName();
	}

	/**
	 * Returns the company ID of this resource localization.
	 *
	 * @return the company ID of this resource localization
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the description of this resource localization.
	 *
	 * @return the description of this resource localization
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the language ID of this resource localization.
	 *
	 * @return the language ID of this resource localization
	 */
	@Override
	public String getLanguageId() {
		return model.getLanguageId();
	}

	/**
	 * Returns the mvcc version of this resource localization.
	 *
	 * @return the mvcc version of this resource localization
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the name of this resource localization.
	 *
	 * @return the name of this resource localization
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this resource localization.
	 *
	 * @return the primary key of this resource localization
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the resource ID of this resource localization.
	 *
	 * @return the resource ID of this resource localization
	 */
	@Override
	public long getResourceId() {
		return model.getResourceId();
	}

	/**
	 * Returns the resource localization ID of this resource localization.
	 *
	 * @return the resource localization ID of this resource localization
	 */
	@Override
	public long getResourceLocalizationId() {
		return model.getResourceLocalizationId();
	}

	/**
	 * Returns the route ID of this resource localization.
	 *
	 * @return the route ID of this resource localization
	 */
	@Override
	public String getRouteId() {
		return model.getRouteId();
	}

	/**
	 * Returns the url of this resource localization.
	 *
	 * @return the url of this resource localization
	 */
	@Override
	public String getUrl() {
		return model.getUrl();
	}

	/**
	 * Sets the attach of this resource localization.
	 *
	 * @param attach the attach of this resource localization
	 */
	@Override
	public void setAttach(String attach) {
		model.setAttach(attach);
	}

	/**
	 * Sets the attach name of this resource localization.
	 *
	 * @param attachName the attach name of this resource localization
	 */
	@Override
	public void setAttachName(String attachName) {
		model.setAttachName(attachName);
	}

	/**
	 * Sets the company ID of this resource localization.
	 *
	 * @param companyId the company ID of this resource localization
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the description of this resource localization.
	 *
	 * @param description the description of this resource localization
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the language ID of this resource localization.
	 *
	 * @param languageId the language ID of this resource localization
	 */
	@Override
	public void setLanguageId(String languageId) {
		model.setLanguageId(languageId);
	}

	/**
	 * Sets the mvcc version of this resource localization.
	 *
	 * @param mvccVersion the mvcc version of this resource localization
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the name of this resource localization.
	 *
	 * @param name the name of this resource localization
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this resource localization.
	 *
	 * @param primaryKey the primary key of this resource localization
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the resource ID of this resource localization.
	 *
	 * @param resourceId the resource ID of this resource localization
	 */
	@Override
	public void setResourceId(long resourceId) {
		model.setResourceId(resourceId);
	}

	/**
	 * Sets the resource localization ID of this resource localization.
	 *
	 * @param resourceLocalizationId the resource localization ID of this resource localization
	 */
	@Override
	public void setResourceLocalizationId(long resourceLocalizationId) {
		model.setResourceLocalizationId(resourceLocalizationId);
	}

	/**
	 * Sets the route ID of this resource localization.
	 *
	 * @param routeId the route ID of this resource localization
	 */
	@Override
	public void setRouteId(String routeId) {
		model.setRouteId(routeId);
	}

	/**
	 * Sets the url of this resource localization.
	 *
	 * @param url the url of this resource localization
	 */
	@Override
	public void setUrl(String url) {
		model.setUrl(url);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected ResourceLocalizationWrapper wrap(
		ResourceLocalization resourceLocalization) {

		return new ResourceLocalizationWrapper(resourceLocalization);
	}

}