/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * Provides the local service utility for ESB. This utility wraps
 * <code>com.ejada.telemony.db.service.impl.ESBLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ESBLocalService
 * @generated
 */
public class ESBLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.ESBLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static String callServiceUpdate(
		String portalApiUrl,
		com.liferay.portal.kernel.json.JSONObject updatePayload) {

		return getService().callServiceUpdate(portalApiUrl, updatePayload);
	}

	public static String getConstantList(
		String esbUrl, String XCorrelationId, String userName,
		String password) {

		return getService().getConstantList(
			esbUrl, XCorrelationId, userName, password);
	}

	public static String getConstantListSearch(
		String searchUrl, String getSearchkeyword, String XCorrelationId,
		String userName, String password) {

		return getService().getConstantListSearch(
			searchUrl, getSearchkeyword, XCorrelationId, userName, password);
	}

	public static String getESBConstantsReload(
		String esbReloadUrl, String XCorrelationId, String userName,
		String password) {

		return getService().getESBConstantsReload(
			esbReloadUrl, XCorrelationId, userName, password);
	}

	public static String getESBConstantsReloadSearch(
		String entityReloadUrl, String reloadSearchkeyword,
		String XCorrelationId, String userName, String password) {

		return getService().getESBConstantsReloadSearch(
			entityReloadUrl, reloadSearchkeyword, XCorrelationId, userName,
			password);
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

	public static void updateESB(
			String esbUpdateUrl,
			com.ejada.telemoney.db.dto.EsbConstantRequestDto oldData,
			com.ejada.telemoney.db.dto.EsbConstantRequestDto newData,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   PortalException {

		getService().updateESB(
			esbUpdateUrl, oldData, newData, serviceContext, user);
	}

	public static ESBLocalService getService() {
		return _service;
	}

	public static void setService(ESBLocalService service) {
		_service = service;
	}

	private static volatile ESBLocalService _service;

}