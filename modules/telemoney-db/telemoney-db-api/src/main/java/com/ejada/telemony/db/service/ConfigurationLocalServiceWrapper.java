/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ConfigurationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ConfigurationLocalService
 * @generated
 */
public class ConfigurationLocalServiceWrapper
	implements ConfigurationLocalService,
			   ServiceWrapper<ConfigurationLocalService> {

	public ConfigurationLocalServiceWrapper() {
		this(null);
	}

	public ConfigurationLocalServiceWrapper(
		ConfigurationLocalService configurationLocalService) {

		_configurationLocalService = configurationLocalService;
	}

	@Override
	public String getAdminPortalData(
		String portalApiUrl, String userName, String password) {

		return _configurationLocalService.getAdminPortalData(
			portalApiUrl, userName, password);
	}

	@Override
	public String getAllConfigurations(
		String portalApiUrl, String userName, String password) {

		return _configurationLocalService.getAllConfigurations(
			portalApiUrl, userName, password);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _configurationLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public void handleApprovedConfigEntity(
			com.ejada.telemony.db.model.ConfigurationEntity configurationEntity,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.json.JSONException {

		_configurationLocalService.handleApprovedConfigEntity(
			configurationEntity, serviceContext);
	}

	@Override
	public void updateConfiguration(
			String requestParam1, String requestParam2, String portalApiUrl,
			String key, String newValue, String oldKey, String oldValue,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   com.liferay.portal.kernel.exception.PortalException {

		_configurationLocalService.updateConfiguration(
			requestParam1, requestParam2, portalApiUrl, key, newValue, oldKey,
			oldValue, serviceContext, user);
	}

	@Override
	public ConfigurationLocalService getWrappedService() {
		return _configurationLocalService;
	}

	@Override
	public void setWrappedService(
		ConfigurationLocalService configurationLocalService) {

		_configurationLocalService = configurationLocalService;
	}

	private ConfigurationLocalService _configurationLocalService;

}