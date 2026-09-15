/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LanguagesService}.
 *
 * @author Brian Wing Shun Chan
 * @see LanguagesService
 * @generated
 */
public class LanguagesServiceWrapper
	implements LanguagesService, ServiceWrapper<LanguagesService> {

	public LanguagesServiceWrapper() {
		this(null);
	}

	public LanguagesServiceWrapper(LanguagesService languagesService) {
		_languagesService = languagesService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _languagesService.getOSGiServiceIdentifier();
	}

	@Override
	public LanguagesService getWrappedService() {
		return _languagesService;
	}

	@Override
	public void setWrappedService(LanguagesService languagesService) {
		_languagesService = languagesService;
	}

	private LanguagesService _languagesService;

}