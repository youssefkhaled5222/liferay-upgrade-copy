/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * Provides the local service utility for IVR. This utility wraps
 * <code>com.ejada.telemony.db.service.impl.IVRLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see IVRLocalService
 * @generated
 */
public class IVRLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.IVRLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static String getAdminPortalData(
		String portalApiUrl, String XCorrelationId, String userName,
		String password) {

		return getService().getAdminPortalData(
			portalApiUrl, XCorrelationId, userName, password);
	}

	public static String getAllIVREvents(
		String portalApiUrl, String XCorrelationId, String userName,
		String password) {

		return getService().getAllIVREvents(
			portalApiUrl, XCorrelationId, userName, password);
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

	public static void updateIVREvent(
			String requestParam1, String requestParam2, String requestParam3,
			String requestParam4, String requestParam5, String requestParam6,
			String portalApiUrl,
			com.ejada.telemoney.db.dto.IvrEventsRequestDto ivrEventsRequestDto,
			com.ejada.telemoney.db.dto.IvrEventsRequestDto oldData,
			String XCorrelationId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   PortalException {

		getService().updateIVREvent(
			requestParam1, requestParam2, requestParam3, requestParam4,
			requestParam5, requestParam6, portalApiUrl, ivrEventsRequestDto,
			oldData, XCorrelationId, serviceContext, user);
	}

	public static IVRLocalService getService() {
		return _service;
	}

	public static void setService(IVRLocalService service) {
		_service = service;
	}

	private static volatile IVRLocalService _service;

}