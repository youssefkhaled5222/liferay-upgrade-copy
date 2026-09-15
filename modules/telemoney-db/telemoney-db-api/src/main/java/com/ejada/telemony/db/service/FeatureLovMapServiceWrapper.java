/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FeatureLovMapService}.
 *
 * @author Brian Wing Shun Chan
 * @see FeatureLovMapService
 * @generated
 */
public class FeatureLovMapServiceWrapper
	implements FeatureLovMapService, ServiceWrapper<FeatureLovMapService> {

	public FeatureLovMapServiceWrapper() {
		this(null);
	}

	public FeatureLovMapServiceWrapper(
		FeatureLovMapService featureLovMapService) {

		_featureLovMapService = featureLovMapService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _featureLovMapService.getOSGiServiceIdentifier();
	}

	@Override
	public FeatureLovMapService getWrappedService() {
		return _featureLovMapService;
	}

	@Override
	public void setWrappedService(FeatureLovMapService featureLovMapService) {
		_featureLovMapService = featureLovMapService;
	}

	private FeatureLovMapService _featureLovMapService;

}