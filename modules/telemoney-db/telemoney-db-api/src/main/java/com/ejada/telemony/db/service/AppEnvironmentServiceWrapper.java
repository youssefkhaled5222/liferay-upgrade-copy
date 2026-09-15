/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AppEnvironmentService}.
 *
 * @author Brian Wing Shun Chan
 * @see AppEnvironmentService
 * @generated
 */
public class AppEnvironmentServiceWrapper
	implements AppEnvironmentService, ServiceWrapper<AppEnvironmentService> {

	public AppEnvironmentServiceWrapper() {
		this(null);
	}

	public AppEnvironmentServiceWrapper(
		AppEnvironmentService appEnvironmentService) {

		_appEnvironmentService = appEnvironmentService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _appEnvironmentService.getOSGiServiceIdentifier();
	}

	@Override
	public AppEnvironmentService getWrappedService() {
		return _appEnvironmentService;
	}

	@Override
	public void setWrappedService(AppEnvironmentService appEnvironmentService) {
		_appEnvironmentService = appEnvironmentService;
	}

	private AppEnvironmentService _appEnvironmentService;

}