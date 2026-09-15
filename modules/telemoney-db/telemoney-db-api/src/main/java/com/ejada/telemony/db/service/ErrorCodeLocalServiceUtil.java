/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * Provides the local service utility for ErrorCode. This utility wraps
 * <code>com.ejada.telemony.db.service.impl.ErrorCodeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ErrorCodeLocalService
 * @generated
 */
public class ErrorCodeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.ErrorCodeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static String callServiceUpdate(
		String portalApiUrl,
		com.liferay.portal.kernel.json.JSONObject updatePayload,
		String XCorrelationId) {

		return getService().callServiceUpdate(
			portalApiUrl, updatePayload, XCorrelationId);
	}

	public static String getAllErrorCodes(
		String errorCodeUrl, String XCorrelationId, String userName,
		String password) {

		return getService().getAllErrorCodes(
			errorCodeUrl, XCorrelationId, userName, password);
	}

	public static String getAllLanguages(
		String langURL, String XCorrelationId, String userName,
		String password) {

		return getService().getAllLanguages(
			langURL, XCorrelationId, userName, password);
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

	public static String searchByCode(
		String searchURL, String code, String XCorrelationId, String userName,
		String password) {

		return getService().searchByCode(
			searchURL, code, XCorrelationId, userName, password);
	}

	public static String searchBycodeAndDesc(
		String searchURL, String searchType, String searchValue, String LangId,
		String XCorrelationId, String userName, String password) {

		return getService().searchBycodeAndDesc(
			searchURL, searchType, searchValue, LangId, XCorrelationId,
			userName, password);
	}

	public static void updateErrorCode(
			String updateCodeURL, String XCorrelationId, String statusCode,
			String language, String description, String oldStatusCode,
			String oldLanguage, String oldDescription,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   PortalException {

		getService().updateErrorCode(
			updateCodeURL, XCorrelationId, statusCode, language, description,
			oldStatusCode, oldLanguage, oldDescription, serviceContext, user);
	}

	public static ErrorCodeLocalService getService() {
		return _service;
	}

	public static void setService(ErrorCodeLocalService service) {
		_service = service;
	}

	private static volatile ErrorCodeLocalService _service;

}