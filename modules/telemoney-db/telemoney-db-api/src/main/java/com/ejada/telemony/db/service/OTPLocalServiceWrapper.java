/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link OTPLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see OTPLocalService
 * @generated
 */
public class OTPLocalServiceWrapper
	implements OTPLocalService, ServiceWrapper<OTPLocalService> {

	public OTPLocalServiceWrapper() {
		this(null);
	}

	public OTPLocalServiceWrapper(OTPLocalService otpLocalService) {
		_otpLocalService = otpLocalService;
	}

	@Override
	public String callServiceUpdate(
		String portalApiUrl,
		com.liferay.portal.kernel.json.JSONObject updatePayload,
		String XCorrelationId) {

		return _otpLocalService.callServiceUpdate(
			portalApiUrl, updatePayload, XCorrelationId);
	}

	@Override
	public String getAdminPortalData(
		String portalApiUrl, String XCorrelationId, String userName,
		String password) {

		return _otpLocalService.getAdminPortalData(
			portalApiUrl, XCorrelationId, userName, password);
	}

	@Override
	public String getAllOTPEvents(
		String portalApiUrl, String XCorrelationId, String userName,
		String password) {

		return _otpLocalService.getAllOTPEvents(
			portalApiUrl, XCorrelationId, userName, password);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _otpLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public void handleApprovedConfigEntity(
			com.ejada.telemony.db.model.ConfigurationEntity configurationEntity,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.json.JSONException {

		_otpLocalService.handleApprovedConfigEntity(
			configurationEntity, serviceContext);
	}

	@Override
	public void updateOTPEvent(
			String requestParam1, String requestParam2, String requestParam3,
			String requestParam4, String portalApiUrl,
			com.ejada.telemoney.db.dto.OtpRequestDto otpRequestDto,
			com.ejada.telemoney.db.dto.OtpRequestDto oldData,
			String XCorrelationId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   com.liferay.portal.kernel.exception.PortalException {

		_otpLocalService.updateOTPEvent(
			requestParam1, requestParam2, requestParam3, requestParam4,
			portalApiUrl, otpRequestDto, oldData, XCorrelationId,
			serviceContext, user);
	}

	@Override
	public OTPLocalService getWrappedService() {
		return _otpLocalService;
	}

	@Override
	public void setWrappedService(OTPLocalService otpLocalService) {
		_otpLocalService = otpLocalService;
	}

	private OTPLocalService _otpLocalService;

}