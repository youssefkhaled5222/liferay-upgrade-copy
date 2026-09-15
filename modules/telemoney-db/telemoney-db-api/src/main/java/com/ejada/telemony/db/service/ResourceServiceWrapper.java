/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ResourceService}.
 *
 * @author Brian Wing Shun Chan
 * @see ResourceService
 * @generated
 */
public class ResourceServiceWrapper
	implements ResourceService, ServiceWrapper<ResourceService> {

	public ResourceServiceWrapper() {
		this(null);
	}

	public ResourceServiceWrapper(ResourceService resourceService) {
		_resourceService = resourceService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _resourceService.getOSGiServiceIdentifier();
	}

	@Override
	public ResourceService getWrappedService() {
		return _resourceService;
	}

	@Override
	public void setWrappedService(ResourceService resourceService) {
		_resourceService = resourceService;
	}

	private ResourceService _resourceService;

}