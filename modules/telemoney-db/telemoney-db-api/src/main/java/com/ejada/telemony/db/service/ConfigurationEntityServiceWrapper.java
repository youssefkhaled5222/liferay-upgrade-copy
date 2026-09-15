/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ConfigurationEntityService}.
 *
 * @author Brian Wing Shun Chan
 * @see ConfigurationEntityService
 * @generated
 */
public class ConfigurationEntityServiceWrapper
	implements ConfigurationEntityService,
			   ServiceWrapper<ConfigurationEntityService> {

	public ConfigurationEntityServiceWrapper() {
		this(null);
	}

	public ConfigurationEntityServiceWrapper(
		ConfigurationEntityService configurationEntityService) {

		_configurationEntityService = configurationEntityService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _configurationEntityService.getOSGiServiceIdentifier();
	}

	@Override
	public ConfigurationEntityService getWrappedService() {
		return _configurationEntityService;
	}

	@Override
	public void setWrappedService(
		ConfigurationEntityService configurationEntityService) {

		_configurationEntityService = configurationEntityService;
	}

	private ConfigurationEntityService _configurationEntityService;

}