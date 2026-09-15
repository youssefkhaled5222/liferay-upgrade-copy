/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ThemesService}.
 *
 * @author Brian Wing Shun Chan
 * @see ThemesService
 * @generated
 */
public class ThemesServiceWrapper
	implements ServiceWrapper<ThemesService>, ThemesService {

	public ThemesServiceWrapper() {
		this(null);
	}

	public ThemesServiceWrapper(ThemesService themesService) {
		_themesService = themesService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _themesService.getOSGiServiceIdentifier();
	}

	@Override
	public ThemesService getWrappedService() {
		return _themesService;
	}

	@Override
	public void setWrappedService(ThemesService themesService) {
		_themesService = themesService;
	}

	private ThemesService _themesService;

}