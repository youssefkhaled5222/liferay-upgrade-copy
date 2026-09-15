/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

/**
 * Provides the remote service utility for UserLogs. This utility wraps
 * <code>com.ejada.telemony.db.service.impl.UserLogsServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see UserLogsService
 * @generated
 */
public class UserLogsServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.UserLogsServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addUserData(
		java.lang.String userName, java.lang.String userAction) {

		getService().addUserData(userName, userAction);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static UserLogsService getService() {
		return _service;
	}

	public static void setService(UserLogsService service) {
		_service = service;
	}

	private static volatile UserLogsService _service;

}