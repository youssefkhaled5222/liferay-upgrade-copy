/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BannerService}.
 *
 * @author Brian Wing Shun Chan
 * @see BannerService
 * @generated
 */
public class BannerServiceWrapper
	implements BannerService, ServiceWrapper<BannerService> {

	public BannerServiceWrapper() {
		this(null);
	}

	public BannerServiceWrapper(BannerService bannerService) {
		_bannerService = bannerService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bannerService.getOSGiServiceIdentifier();
	}

	@Override
	public BannerService getWrappedService() {
		return _bannerService;
	}

	@Override
	public void setWrappedService(BannerService bannerService) {
		_bannerService = bannerService;
	}

	private BannerService _bannerService;

}