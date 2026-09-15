/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * Provides the local service utility for Configuration. This utility wraps
 * <code>com.ejada.telemony.db.service.impl.ConfigurationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ConfigurationLocalService
 * @generated
 */
public class ConfigurationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.ConfigurationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static String getAdminPortalData(
		String portalApiUrl, String userName, String password) {

		return getService().getAdminPortalData(
			portalApiUrl, userName, password);
	}

	public static String getAllConfigurations(
		String portalApiUrl, String userName, String password) {

		return getService().getAllConfigurations(
			portalApiUrl, userName, password);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static void handleApprovedConfigEntity(
			com.ejada.telemony.db.model.ConfigurationEntity configurationEntity,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.json.JSONException {

		getService().handleApprovedConfigEntity(
			configurationEntity, serviceContext);
	}

	public static void updateConfiguration(
			String requestParam1, String requestParam2, String portalApiUrl,
			String key, String newValue, String oldKey, String oldValue,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   PortalException {

		getService().updateConfiguration(
			requestParam1, requestParam2, portalApiUrl, key, newValue, oldKey,
			oldValue, serviceContext, user);
	}

	public static ConfigurationLocalService getService() {
		return _service;
	}

	public static void setService(ConfigurationLocalService service) {
		_service = service;
	}

	private static volatile ConfigurationLocalService _service;

}