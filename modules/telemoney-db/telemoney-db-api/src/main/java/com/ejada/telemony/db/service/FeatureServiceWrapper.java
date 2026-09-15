/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FeatureService}.
 *
 * @author Brian Wing Shun Chan
 * @see FeatureService
 * @generated
 */
public class FeatureServiceWrapper
	implements FeatureService, ServiceWrapper<FeatureService> {

	public FeatureServiceWrapper() {
		this(null);
	}

	public FeatureServiceWrapper(FeatureService featureService) {
		_featureService = featureService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _featureService.getOSGiServiceIdentifier();
	}

	@Override
	public FeatureService getWrappedService() {
		return _featureService;
	}

	@Override
	public void setWrappedService(FeatureService featureService) {
		_featureService = featureService;
	}

	private FeatureService _featureService;

}