/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SegmentService}.
 *
 * @author Brian Wing Shun Chan
 * @see SegmentService
 * @generated
 */
public class SegmentServiceWrapper
	implements SegmentService, ServiceWrapper<SegmentService> {

	public SegmentServiceWrapper() {
		this(null);
	}

	public SegmentServiceWrapper(SegmentService segmentService) {
		_segmentService = segmentService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _segmentService.getOSGiServiceIdentifier();
	}

	@Override
	public SegmentService getWrappedService() {
		return _segmentService;
	}

	@Override
	public void setWrappedService(SegmentService segmentService) {
		_segmentService = segmentService;
	}

	private SegmentService _segmentService;

}