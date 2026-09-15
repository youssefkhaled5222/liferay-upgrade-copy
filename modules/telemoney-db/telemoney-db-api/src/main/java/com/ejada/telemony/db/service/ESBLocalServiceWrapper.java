/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ESBLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ESBLocalService
 * @generated
 */
public class ESBLocalServiceWrapper
	implements ESBLocalService, ServiceWrapper<ESBLocalService> {

	public ESBLocalServiceWrapper() {
		this(null);
	}

	public ESBLocalServiceWrapper(ESBLocalService esbLocalService) {
		_esbLocalService = esbLocalService;
	}

	@Override
	public String callServiceUpdate(
		String portalApiUrl,
		com.liferay.portal.kernel.json.JSONObject updatePayload) {

		return _esbLocalService.callServiceUpdate(portalApiUrl, updatePayload);
	}

	@Override
	public String getConstantList(
		String esbUrl, String XCorrelationId, String userName,
		String password) {

		return _esbLocalService.getConstantList(
			esbUrl, XCorrelationId, userName, password);
	}

	@Override
	public String getConstantListSearch(
		String searchUrl, String getSearchkeyword, String XCorrelationId,
		String userName, String password) {

		return _esbLocalService.getConstantListSearch(
			searchUrl, getSearchkeyword, XCorrelationId, userName, password);
	}

	@Override
	public String getESBConstantsReload(
		String esbReloadUrl, String XCorrelationId, String userName,
		String password) {

		return _esbLocalService.getESBConstantsReload(
			esbReloadUrl, XCorrelationId, userName, password);
	}

	@Override
	public String getESBConstantsReloadSearch(
		String entityReloadUrl, String reloadSearchkeyword,
		String XCorrelationId, String userName, String password) {

		return _esbLocalService.getESBConstantsReloadSearch(
			entityReloadUrl, reloadSearchkeyword, XCorrelationId, userName,
			password);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _esbLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public void handleApprovedConfigEntity(
			com.ejada.telemony.db.model.ConfigurationEntity configurationEntity,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.json.JSONException {

		_esbLocalService.handleApprovedConfigEntity(
			configurationEntity, serviceContext);
	}

	@Override
	public void updateESB(
			String esbUpdateUrl,
			com.ejada.telemoney.db.dto.EsbConstantRequestDto oldData,
			com.ejada.telemoney.db.dto.EsbConstantRequestDto newData,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   com.liferay.portal.kernel.exception.PortalException {

		_esbLocalService.updateESB(
			esbUpdateUrl, oldData, newData, serviceContext, user);
	}

	@Override
	public ESBLocalService getWrappedService() {
		return _esbLocalService;
	}

	@Override
	public void setWrappedService(ESBLocalService esbLocalService) {
		_esbLocalService = esbLocalService;
	}

	private ESBLocalService _esbLocalService;

}