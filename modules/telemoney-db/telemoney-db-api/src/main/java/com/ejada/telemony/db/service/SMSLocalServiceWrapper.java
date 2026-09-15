/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SMSLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SMSLocalService
 * @generated
 */
public class SMSLocalServiceWrapper
	implements ServiceWrapper<SMSLocalService>, SMSLocalService {

	public SMSLocalServiceWrapper() {
		this(null);
	}

	public SMSLocalServiceWrapper(SMSLocalService smsLocalService) {
		_smsLocalService = smsLocalService;
	}

	@Override
	public String getAdminPortalData(
		String ordersApiUrl, String XCorrelationId, String userName,
		String password) {

		return _smsLocalService.getAdminPortalData(
			ordersApiUrl, XCorrelationId, userName, password);
	}

	@Override
	public String getAllSMS(
		String smsGetUrl, String XCorrelationId, String userName,
		String password) {

		return _smsLocalService.getAllSMS(
			smsGetUrl, XCorrelationId, userName, password);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _smsLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public void handleApprovedConfigEntity(
			com.ejada.telemony.db.model.ConfigurationEntity configurationEntity,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.json.JSONException {

		_smsLocalService.handleApprovedConfigEntity(
			configurationEntity, serviceContext);
	}

	@Override
	public void updateSMSDescByServiceId(
			String smsURL, String serviceId, String newEventDescription,
			String oldEventDescription, String descriptionRequestParam1,
			String descriptionRequestParam2, String XCorrelationId,
			String eventCode, com.liferay.portal.kernel.model.User user,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   com.liferay.portal.kernel.exception.PortalException {

		_smsLocalService.updateSMSDescByServiceId(
			smsURL, serviceId, newEventDescription, oldEventDescription,
			descriptionRequestParam1, descriptionRequestParam2, XCorrelationId,
			eventCode, user, serviceContext);
	}

	@Override
	public void updateSMSServiceId(
			String smsURL, String oldServiceId, String newServiceId,
			String serviceRequestParam1, String serviceRequestParam2,
			String XCorrelationId, String eventCode,
			com.liferay.portal.kernel.model.User user,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   com.liferay.portal.kernel.exception.PortalException {

		_smsLocalService.updateSMSServiceId(
			smsURL, oldServiceId, newServiceId, serviceRequestParam1,
			serviceRequestParam2, XCorrelationId, eventCode, user,
			serviceContext);
	}

	@Override
	public void updateSMSServiceIdAndDesc(
			String smsURLServiceUpdate, String smsURLDescriptionUpdate,
			String oldServiceId, String serviceId, String serviceRequestParam1,
			String serviceRequestParam2, String eventDescription,
			String oldEventDescription, String descriptionRequestParam1,
			String descriptionRequestParam2, String XCorrelationId,
			String eventCode, com.liferay.portal.kernel.model.User user,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   com.liferay.portal.kernel.exception.PortalException {

		_smsLocalService.updateSMSServiceIdAndDesc(
			smsURLServiceUpdate, smsURLDescriptionUpdate, oldServiceId,
			serviceId, serviceRequestParam1, serviceRequestParam2,
			eventDescription, oldEventDescription, descriptionRequestParam1,
			descriptionRequestParam2, XCorrelationId, eventCode, user,
			serviceContext);
	}

	@Override
	public SMSLocalService getWrappedService() {
		return _smsLocalService;
	}

	@Override
	public void setWrappedService(SMSLocalService smsLocalService) {
		_smsLocalService = smsLocalService;
	}

	private SMSLocalService _smsLocalService;

}