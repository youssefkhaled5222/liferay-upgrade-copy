/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link WhiteListLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see WhiteListLocalService
 * @generated
 */
public class WhiteListLocalServiceWrapper
	implements ServiceWrapper<WhiteListLocalService>, WhiteListLocalService {

	public WhiteListLocalServiceWrapper() {
		this(null);
	}

	public WhiteListLocalServiceWrapper(
		WhiteListLocalService whiteListLocalService) {

		_whiteListLocalService = whiteListLocalService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _whiteListLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public String getWhiteListed(
		String getAllWhiteListed, String XCorrelationId, String fromDt,
		String toDt, String poi, String poiType, String cif, String nameEn,
		String nameAr, String mobile, String allow) {

		return _whiteListLocalService.getWhiteListed(
			getAllWhiteListed, XCorrelationId, fromDt, toDt, poi, poiType, cif,
			nameEn, nameAr, mobile, allow);
	}

	@Override
	public String updateCustomerStatus(
		String UpdateURL, String XCorrelationId, String poi, String allow) {

		return _whiteListLocalService.updateCustomerStatus(
			UpdateURL, XCorrelationId, poi, allow);
	}

	@Override
	public WhiteListLocalService getWrappedService() {
		return _whiteListLocalService;
	}

	@Override
	public void setWrappedService(WhiteListLocalService whiteListLocalService) {
		_whiteListLocalService = whiteListLocalService;
	}

	private WhiteListLocalService _whiteListLocalService;

}