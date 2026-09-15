/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

/**
 * Provides the local service utility for WhiteList. This utility wraps
 * <code>com.ejada.telemony.db.service.impl.WhiteListLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see WhiteListLocalService
 * @generated
 */
public class WhiteListLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.WhiteListLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.lang.String getWhiteListed(
		java.lang.String getAllWhiteListed, java.lang.String XCorrelationId,
		java.lang.String fromDt, java.lang.String toDt, java.lang.String poi,
		java.lang.String poiType, java.lang.String cif, java.lang.String nameEn,
		java.lang.String nameAr, java.lang.String mobile,
		java.lang.String allow) {

		return getService().getWhiteListed(
			getAllWhiteListed, XCorrelationId, fromDt, toDt, poi, poiType, cif,
			nameEn, nameAr, mobile, allow);
	}

	public static java.lang.String updateCustomerStatus(
		java.lang.String UpdateURL, java.lang.String XCorrelationId,
		java.lang.String poi, java.lang.String allow) {

		return getService().updateCustomerStatus(
			UpdateURL, XCorrelationId, poi, allow);
	}

	public static WhiteListLocalService getService() {
		return _service;
	}

	public static void setService(WhiteListLocalService service) {
		_service = service;
	}

	private static volatile WhiteListLocalService _service;

}