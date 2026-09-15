/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * Provides the local service utility for SMS. This utility wraps
 * <code>com.ejada.telemony.db.service.impl.SMSLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SMSLocalService
 * @generated
 */
public class SMSLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.SMSLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static String getAdminPortalData(
		String ordersApiUrl, String XCorrelationId, String userName,
		String password) {

		return getService().getAdminPortalData(
			ordersApiUrl, XCorrelationId, userName, password);
	}

	public static String getAllSMS(
		String smsGetUrl, String XCorrelationId, String userName,
		String password) {

		return getService().getAllSMS(
			smsGetUrl, XCorrelationId, userName, password);
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

	public static void updateSMSDescByServiceId(
			String smsURL, String serviceId, String newEventDescription,
			String oldEventDescription, String descriptionRequestParam1,
			String descriptionRequestParam2, String XCorrelationId,
			String eventCode, com.liferay.portal.kernel.model.User user,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   PortalException {

		getService().updateSMSDescByServiceId(
			smsURL, serviceId, newEventDescription, oldEventDescription,
			descriptionRequestParam1, descriptionRequestParam2, XCorrelationId,
			eventCode, user, serviceContext);
	}

	public static void updateSMSServiceId(
			String smsURL, String oldServiceId, String newServiceId,
			String serviceRequestParam1, String serviceRequestParam2,
			String XCorrelationId, String eventCode,
			com.liferay.portal.kernel.model.User user,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   PortalException {

		getService().updateSMSServiceId(
			smsURL, oldServiceId, newServiceId, serviceRequestParam1,
			serviceRequestParam2, XCorrelationId, eventCode, user,
			serviceContext);
	}

	public static void updateSMSServiceIdAndDesc(
			String smsURLServiceUpdate, String smsURLDescriptionUpdate,
			String oldServiceId, String serviceId, String serviceRequestParam1,
			String serviceRequestParam2, String eventDescription,
			String oldEventDescription, String descriptionRequestParam1,
			String descriptionRequestParam2, String XCorrelationId,
			String eventCode, com.liferay.portal.kernel.model.User user,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   PortalException {

		getService().updateSMSServiceIdAndDesc(
			smsURLServiceUpdate, smsURLDescriptionUpdate, oldServiceId,
			serviceId, serviceRequestParam1, serviceRequestParam2,
			eventDescription, oldEventDescription, descriptionRequestParam1,
			descriptionRequestParam2, XCorrelationId, eventCode, user,
			serviceContext);
	}

	public static SMSLocalService getService() {
		return _service;
	}

	public static void setService(SMSLocalService service) {
		_service = service;
	}

	private static volatile SMSLocalService _service;

}