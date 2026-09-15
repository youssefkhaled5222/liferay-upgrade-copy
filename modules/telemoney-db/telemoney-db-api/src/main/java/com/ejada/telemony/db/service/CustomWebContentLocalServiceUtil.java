/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

/**
 * Provides the local service utility for CustomWebContent. This utility wraps
 * <code>com.ejada.telemony.db.service.impl.CustomWebContentLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CustomWebContentLocalService
 * @generated
 */
public class CustomWebContentLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.CustomWebContentLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.json.JSONArray
			getWebContentByTagName(
				java.lang.String tagName, java.lang.String language)
		throws java.lang.Exception {

		return getService().getWebContentByTagName(tagName, language);
	}

	public static CustomWebContentLocalService getService() {
		return _service;
	}

	public static void setService(CustomWebContentLocalService service) {
		_service = service;
	}

	private static volatile CustomWebContentLocalService _service;

}