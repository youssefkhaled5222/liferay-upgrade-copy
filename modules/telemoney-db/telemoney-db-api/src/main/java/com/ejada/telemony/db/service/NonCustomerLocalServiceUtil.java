/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

/**
 * Provides the local service utility for NonCustomer. This utility wraps
 * <code>com.ejada.telemony.db.service.impl.NonCustomerLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see NonCustomerLocalService
 * @generated
 */
public class NonCustomerLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.NonCustomerLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static java.lang.String getAllNonCustomer(
		java.lang.String nonCustomerUrl, java.lang.String XCorrelationId,
		java.lang.String userName, java.lang.String password) {

		return getService().getAllNonCustomer(
			nonCustomerUrl, XCorrelationId, userName, password);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static NonCustomerLocalService getService() {
		return _service;
	}

	public static void setService(NonCustomerLocalService service) {
		_service = service;
	}

	private static volatile NonCustomerLocalService _service;

}