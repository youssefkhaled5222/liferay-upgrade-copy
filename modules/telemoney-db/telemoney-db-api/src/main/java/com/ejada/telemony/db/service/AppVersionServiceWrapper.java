/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AppVersionService}.
 *
 * @author Brian Wing Shun Chan
 * @see AppVersionService
 * @generated
 */
public class AppVersionServiceWrapper
	implements AppVersionService, ServiceWrapper<AppVersionService> {

	public AppVersionServiceWrapper() {
		this(null);
	}

	public AppVersionServiceWrapper(AppVersionService appVersionService) {
		_appVersionService = appVersionService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _appVersionService.getOSGiServiceIdentifier();
	}

	@Override
	public AppVersionService getWrappedService() {
		return _appVersionService;
	}

	@Override
	public void setWrappedService(AppVersionService appVersionService) {
		_appVersionService = appVersionService;
	}

	private AppVersionService _appVersionService;

}