/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BannerContentService}.
 *
 * @author Brian Wing Shun Chan
 * @see BannerContentService
 * @generated
 */
public class BannerContentServiceWrapper
	implements BannerContentService, ServiceWrapper<BannerContentService> {

	public BannerContentServiceWrapper() {
		this(null);
	}

	public BannerContentServiceWrapper(
		BannerContentService bannerContentService) {

		_bannerContentService = bannerContentService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bannerContentService.getOSGiServiceIdentifier();
	}

	@Override
	public BannerContentService getWrappedService() {
		return _bannerContentService;
	}

	@Override
	public void setWrappedService(BannerContentService bannerContentService) {
		_bannerContentService = bannerContentService;
	}

	private BannerContentService _bannerContentService;

}