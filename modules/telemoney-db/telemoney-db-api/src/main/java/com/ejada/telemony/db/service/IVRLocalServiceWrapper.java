/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link IVRLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see IVRLocalService
 * @generated
 */
public class IVRLocalServiceWrapper
	implements IVRLocalService, ServiceWrapper<IVRLocalService> {

	public IVRLocalServiceWrapper() {
		this(null);
	}

	public IVRLocalServiceWrapper(IVRLocalService ivrLocalService) {
		_ivrLocalService = ivrLocalService;
	}

	@Override
	public String getAdminPortalData(
		String portalApiUrl, String XCorrelationId, String userName,
		String password) {

		return _ivrLocalService.getAdminPortalData(
			portalApiUrl, XCorrelationId, userName, password);
	}

	@Override
	public String getAllIVREvents(
		String portalApiUrl, String XCorrelationId, String userName,
		String password) {

		return _ivrLocalService.getAllIVREvents(
			portalApiUrl, XCorrelationId, userName, password);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ivrLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public void handleApprovedConfigEntity(
			com.ejada.telemony.db.model.ConfigurationEntity configurationEntity,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.json.JSONException {

		_ivrLocalService.handleApprovedConfigEntity(
			configurationEntity, serviceContext);
	}

	@Override
	public void updateIVREvent(
			String requestParam1, String requestParam2, String requestParam3,
			String requestParam4, String requestParam5, String requestParam6,
			String portalApiUrl,
			com.ejada.telemoney.db.dto.IvrEventsRequestDto ivrEventsRequestDto,
			com.ejada.telemoney.db.dto.IvrEventsRequestDto oldData,
			String XCorrelationId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   com.liferay.portal.kernel.exception.PortalException {

		_ivrLocalService.updateIVREvent(
			requestParam1, requestParam2, requestParam3, requestParam4,
			requestParam5, requestParam6, portalApiUrl, ivrEventsRequestDto,
			oldData, XCorrelationId, serviceContext, user);
	}

	@Override
	public IVRLocalService getWrappedService() {
		return _ivrLocalService;
	}

	@Override
	public void setWrappedService(IVRLocalService ivrLocalService) {
		_ivrLocalService = ivrLocalService;
	}

	private IVRLocalService _ivrLocalService;

}