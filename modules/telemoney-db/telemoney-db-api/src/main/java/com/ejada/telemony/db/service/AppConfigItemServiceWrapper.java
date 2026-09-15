/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AppConfigItemService}.
 *
 * @author Brian Wing Shun Chan
 * @see AppConfigItemService
 * @generated
 */
public class AppConfigItemServiceWrapper
	implements AppConfigItemService, ServiceWrapper<AppConfigItemService> {

	public AppConfigItemServiceWrapper() {
		this(null);
	}

	public AppConfigItemServiceWrapper(
		AppConfigItemService appConfigItemService) {

		_appConfigItemService = appConfigItemService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _appConfigItemService.getOSGiServiceIdentifier();
	}

	@Override
	public AppConfigItemService getWrappedService() {
		return _appConfigItemService;
	}

	@Override
	public void setWrappedService(AppConfigItemService appConfigItemService) {
		_appConfigItemService = appConfigItemService;
	}

	private AppConfigItemService _appConfigItemService;

}