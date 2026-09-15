/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CustomWebContentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CustomWebContentLocalService
 * @generated
 */
public class CustomWebContentLocalServiceWrapper
	implements CustomWebContentLocalService,
			   ServiceWrapper<CustomWebContentLocalService> {

	public CustomWebContentLocalServiceWrapper() {
		this(null);
	}

	public CustomWebContentLocalServiceWrapper(
		CustomWebContentLocalService customWebContentLocalService) {

		_customWebContentLocalService = customWebContentLocalService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _customWebContentLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getWebContentByTagName(
			String tagName, String language)
		throws Exception {

		return _customWebContentLocalService.getWebContentByTagName(
			tagName, language);
	}

	@Override
	public CustomWebContentLocalService getWrappedService() {
		return _customWebContentLocalService;
	}

	@Override
	public void setWrappedService(
		CustomWebContentLocalService customWebContentLocalService) {

		_customWebContentLocalService = customWebContentLocalService;
	}

	private CustomWebContentLocalService _customWebContentLocalService;

}