/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LocalizationService}.
 *
 * @author Brian Wing Shun Chan
 * @see LocalizationService
 * @generated
 */
public class LocalizationServiceWrapper
	implements LocalizationService, ServiceWrapper<LocalizationService> {

	public LocalizationServiceWrapper() {
		this(null);
	}

	public LocalizationServiceWrapper(LocalizationService localizationService) {
		_localizationService = localizationService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _localizationService.getOSGiServiceIdentifier();
	}

	@Override
	public LocalizationService getWrappedService() {
		return _localizationService;
	}

	@Override
	public void setWrappedService(LocalizationService localizationService) {
		_localizationService = localizationService;
	}

	private LocalizationService _localizationService;

}