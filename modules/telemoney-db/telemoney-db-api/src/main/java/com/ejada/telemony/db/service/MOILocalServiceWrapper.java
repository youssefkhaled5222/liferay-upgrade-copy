/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MOILocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MOILocalService
 * @generated
 */
public class MOILocalServiceWrapper
	implements MOILocalService, ServiceWrapper<MOILocalService> {

	public MOILocalServiceWrapper() {
		this(null);
	}

	public MOILocalServiceWrapper(MOILocalService moiLocalService) {
		_moiLocalService = moiLocalService;
	}

	@Override
	public void callMOIDeleteRequest(String ordersApiUrl) {
		_moiLocalService.callMOIDeleteRequest(ordersApiUrl);
	}

	@Override
	public String getMOIBiller(
		String moiBillerApiUrl, String refundTypeCode, String languageId) {

		return _moiLocalService.getMOIBiller(
			moiBillerApiUrl, refundTypeCode, languageId);
	}

	@Override
	public String getMOIBillerAPI(String moiApiUrl, String languageId) {
		return _moiLocalService.getMOIBillerAPI(moiApiUrl, languageId);
	}

	@Override
	public String getMOIBillerService(
		String moiBillerApiUrl, String getSearchkeyword, String languageId) {

		return _moiLocalService.getMOIBillerService(
			moiBillerApiUrl, getSearchkeyword, languageId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _moiLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public void handleApprovedConfigEntity(
			com.ejada.telemony.db.model.ConfigurationEntity configurationEntity,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.json.JSONException {

		_moiLocalService.handleApprovedConfigEntity(
			configurationEntity, serviceContext);
	}

	@Override
	public void handleDeleteMOIBiller(
			String portalApiUrl, String id, String oldBillerId,
			String oldBillerCode, String oldBillerName,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   com.liferay.portal.kernel.exception.PortalException {

		_moiLocalService.handleDeleteMOIBiller(
			portalApiUrl, id, oldBillerId, oldBillerCode, oldBillerName,
			serviceContext, user);
	}

	@Override
	public void handleDeleteMOIService(
			String portalApiUrl, String id, String oldSubServiceId,
			String oldSubServiceCode, String oldSubServiceName,
			String oldMoiServiceId, String oldBillerName,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   com.liferay.portal.kernel.exception.PortalException {

		_moiLocalService.handleDeleteMOIService(
			portalApiUrl, id, oldSubServiceId, oldSubServiceCode,
			oldSubServiceName, oldMoiServiceId, oldBillerName, serviceContext,
			user);
	}

	@Override
	public void handleMOIFieldAndDropDownUpdate(
			String portalApiUrl, String id, String subServiceId, String code,
			String name, int fieldDetailsId, int fixedValueFlag,
			String fixedValue, int dateFlag, int dropDownFlag, int dropDownId,
			String dropDownCode, String dropDownValueAr, String dropDownValueEn,
			String relatedFieldCode, String relatedFieldName,
			String relatedFieldId, java.util.List<Integer> allowedValues,
			String oldFieldId, String oldFieldCode, String oldFieldName,
			String oldFieldDetailsId, String oldFixedValueFlag,
			String oldFixedValue, String oldDateFlag, String oldDropDownFlag,
			String oldDropDownId, String oldCode, String oldValueAr,
			String oldValueEn, String oldRelatedFieldCode,
			String oldRelatedFieldName, String oldRelatedFieldId,
			java.util.List<Integer> oldAllowedValues,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   com.liferay.portal.kernel.exception.PortalException {

		_moiLocalService.handleMOIFieldAndDropDownUpdate(
			portalApiUrl, id, subServiceId, code, name, fieldDetailsId,
			fixedValueFlag, fixedValue, dateFlag, dropDownFlag, dropDownId,
			dropDownCode, dropDownValueAr, dropDownValueEn, relatedFieldCode,
			relatedFieldName, relatedFieldId, allowedValues, oldFieldId,
			oldFieldCode, oldFieldName, oldFieldDetailsId, oldFixedValueFlag,
			oldFixedValue, oldDateFlag, oldDropDownFlag, oldDropDownId, oldCode,
			oldValueAr, oldValueEn, oldRelatedFieldCode, oldRelatedFieldName,
			oldRelatedFieldId, oldAllowedValues, serviceContext, user);
	}

	@Override
	public void handleMOIFieldUpdate(
			String portalApiUrl, String id, String subServiceId, String code,
			String name, int fieldDetailsId, int fixedValueFlag,
			String fixedValue, int dateFlag, int dropDownFlag,
			java.util.List<com.ejada.telemoney.db.domain.model.DropDownDataDTO>
				dropDowns,
			String oldFieldId, String oldFieldCode, String oldFieldName,
			String oldFieldDetailsId, String oldFixedValueFlag,
			String oldFixedValue, String oldDateFlag, String oldDropDownFlag,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   com.liferay.portal.kernel.exception.PortalException {

		_moiLocalService.handleMOIFieldUpdate(
			portalApiUrl, id, subServiceId, code, name, fieldDetailsId,
			fixedValueFlag, fixedValue, dateFlag, dropDownFlag, dropDowns,
			oldFieldId, oldFieldCode, oldFieldName, oldFieldDetailsId,
			oldFixedValueFlag, oldFixedValue, oldDateFlag, oldDropDownFlag,
			serviceContext, user);
	}

	@Override
	public void handleMOIServiceUpdate(
			String portalApiUrl, String subServiceId, String subServiceName,
			String subServiceCode, String id, String languageId,
			String oldSubServiceId, String oldSubServiceName,
			String oldSubServiceCode, String oldMoiServiceId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   com.liferay.portal.kernel.exception.PortalException {

		_moiLocalService.handleMOIServiceUpdate(
			portalApiUrl, subServiceId, subServiceName, subServiceCode, id,
			languageId, oldSubServiceId, oldSubServiceName, oldSubServiceCode,
			oldMoiServiceId, serviceContext, user);
	}

	@Override
	public void handleMOIUpdate(
			String portalApiUrl, String serviceTypeFlag, String serviceName,
			String serviceCode, String id, String languageId,
			String oldBillerId, String oldBillerCode, String oldBillerName,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   com.liferay.portal.kernel.exception.PortalException {

		_moiLocalService.handleMOIUpdate(
			portalApiUrl, serviceTypeFlag, serviceName, serviceCode, id,
			languageId, oldBillerId, oldBillerCode, oldBillerName,
			serviceContext, user);
	}

	@Override
	public MOILocalService getWrappedService() {
		return _moiLocalService;
	}

	@Override
	public void setWrappedService(MOILocalService moiLocalService) {
		_moiLocalService = moiLocalService;
	}

	private MOILocalService _moiLocalService;

}