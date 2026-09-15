/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ErrorCodeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ErrorCodeLocalService
 * @generated
 */
public class ErrorCodeLocalServiceWrapper
	implements ErrorCodeLocalService, ServiceWrapper<ErrorCodeLocalService> {

	public ErrorCodeLocalServiceWrapper() {
		this(null);
	}

	public ErrorCodeLocalServiceWrapper(
		ErrorCodeLocalService errorCodeLocalService) {

		_errorCodeLocalService = errorCodeLocalService;
	}

	@Override
	public String callServiceUpdate(
		String portalApiUrl,
		com.liferay.portal.kernel.json.JSONObject updatePayload,
		String XCorrelationId) {

		return _errorCodeLocalService.callServiceUpdate(
			portalApiUrl, updatePayload, XCorrelationId);
	}

	@Override
	public String getAllErrorCodes(
		String errorCodeUrl, String XCorrelationId, String userName,
		String password) {

		return _errorCodeLocalService.getAllErrorCodes(
			errorCodeUrl, XCorrelationId, userName, password);
	}

	@Override
	public String getAllLanguages(
		String langURL, String XCorrelationId, String userName,
		String password) {

		return _errorCodeLocalService.getAllLanguages(
			langURL, XCorrelationId, userName, password);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _errorCodeLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public void handleApprovedConfigEntity(
			com.ejada.telemony.db.model.ConfigurationEntity configurationEntity,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.json.JSONException {

		_errorCodeLocalService.handleApprovedConfigEntity(
			configurationEntity, serviceContext);
	}

	@Override
	public String searchByCode(
		String searchURL, String code, String XCorrelationId, String userName,
		String password) {

		return _errorCodeLocalService.searchByCode(
			searchURL, code, XCorrelationId, userName, password);
	}

	@Override
	public String searchBycodeAndDesc(
		String searchURL, String searchType, String searchValue, String LangId,
		String XCorrelationId, String userName, String password) {

		return _errorCodeLocalService.searchBycodeAndDesc(
			searchURL, searchType, searchValue, LangId, XCorrelationId,
			userName, password);
	}

	@Override
	public void updateErrorCode(
			String updateCodeURL, String XCorrelationId, String statusCode,
			String language, String description, String oldStatusCode,
			String oldLanguage, String oldDescription,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   com.liferay.portal.kernel.exception.PortalException {

		_errorCodeLocalService.updateErrorCode(
			updateCodeURL, XCorrelationId, statusCode, language, description,
			oldStatusCode, oldLanguage, oldDescription, serviceContext, user);
	}

	@Override
	public ErrorCodeLocalService getWrappedService() {
		return _errorCodeLocalService;
	}

	@Override
	public void setWrappedService(ErrorCodeLocalService errorCodeLocalService) {
		_errorCodeLocalService = errorCodeLocalService;
	}

	private ErrorCodeLocalService _errorCodeLocalService;

}