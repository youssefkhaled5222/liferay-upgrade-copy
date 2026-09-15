/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CustomWebContentService}.
 *
 * @author Brian Wing Shun Chan
 * @see CustomWebContentService
 * @generated
 */
public class CustomWebContentServiceWrapper
	implements CustomWebContentService,
			   ServiceWrapper<CustomWebContentService> {

	public CustomWebContentServiceWrapper() {
		this(null);
	}

	public CustomWebContentServiceWrapper(
		CustomWebContentService customWebContentService) {

		_customWebContentService = customWebContentService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _customWebContentService.getOSGiServiceIdentifier();
	}

	@Override
	public CustomWebContentService getWrappedService() {
		return _customWebContentService;
	}

	@Override
	public void setWrappedService(
		CustomWebContentService customWebContentService) {

		_customWebContentService = customWebContentService;
	}

	private CustomWebContentService _customWebContentService;

}