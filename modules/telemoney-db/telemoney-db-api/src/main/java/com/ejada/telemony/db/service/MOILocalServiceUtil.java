/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

/**
 * Provides the local service utility for MOI. This utility wraps
 * <code>com.ejada.telemony.db.service.impl.MOILocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see MOILocalService
 * @generated
 */
public class MOILocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.MOILocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void callMOIDeleteRequest(String ordersApiUrl) {
		getService().callMOIDeleteRequest(ordersApiUrl);
	}

	public static String getMOIBiller(
		String moiBillerApiUrl, String refundTypeCode, String languageId) {

		return getService().getMOIBiller(
			moiBillerApiUrl, refundTypeCode, languageId);
	}

	public static String getMOIBillerAPI(String moiApiUrl, String languageId) {
		return getService().getMOIBillerAPI(moiApiUrl, languageId);
	}

	public static String getMOIBillerService(
		String moiBillerApiUrl, String getSearchkeyword, String languageId) {

		return getService().getMOIBillerService(
			moiBillerApiUrl, getSearchkeyword, languageId);
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

	public static void handleDeleteMOIBiller(
			String portalApiUrl, String id, String oldBillerId,
			String oldBillerCode, String oldBillerName,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   PortalException {

		getService().handleDeleteMOIBiller(
			portalApiUrl, id, oldBillerId, oldBillerCode, oldBillerName,
			serviceContext, user);
	}

	public static void handleDeleteMOIService(
			String portalApiUrl, String id, String oldSubServiceId,
			String oldSubServiceCode, String oldSubServiceName,
			String oldMoiServiceId, String oldBillerName,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   PortalException {

		getService().handleDeleteMOIService(
			portalApiUrl, id, oldSubServiceId, oldSubServiceCode,
			oldSubServiceName, oldMoiServiceId, oldBillerName, serviceContext,
			user);
	}

	public static void handleMOIFieldAndDropDownUpdate(
			String portalApiUrl, String id, String subServiceId, String code,
			String name, int fieldDetailsId, int fixedValueFlag,
			String fixedValue, int dateFlag, int dropDownFlag, int dropDownId,
			String dropDownCode, String dropDownValueAr, String dropDownValueEn,
			String relatedFieldCode, String relatedFieldName,
			String relatedFieldId, List<Integer> allowedValues,
			String oldFieldId, String oldFieldCode, String oldFieldName,
			String oldFieldDetailsId, String oldFixedValueFlag,
			String oldFixedValue, String oldDateFlag, String oldDropDownFlag,
			String oldDropDownId, String oldCode, String oldValueAr,
			String oldValueEn, String oldRelatedFieldCode,
			String oldRelatedFieldName, String oldRelatedFieldId,
			List<Integer> oldAllowedValues,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   PortalException {

		getService().handleMOIFieldAndDropDownUpdate(
			portalApiUrl, id, subServiceId, code, name, fieldDetailsId,
			fixedValueFlag, fixedValue, dateFlag, dropDownFlag, dropDownId,
			dropDownCode, dropDownValueAr, dropDownValueEn, relatedFieldCode,
			relatedFieldName, relatedFieldId, allowedValues, oldFieldId,
			oldFieldCode, oldFieldName, oldFieldDetailsId, oldFixedValueFlag,
			oldFixedValue, oldDateFlag, oldDropDownFlag, oldDropDownId, oldCode,
			oldValueAr, oldValueEn, oldRelatedFieldCode, oldRelatedFieldName,
			oldRelatedFieldId, oldAllowedValues, serviceContext, user);
	}

	public static void handleMOIFieldUpdate(
			String portalApiUrl, String id, String subServiceId, String code,
			String name, int fieldDetailsId, int fixedValueFlag,
			String fixedValue, int dateFlag, int dropDownFlag,
			List<com.ejada.telemoney.db.domain.model.DropDownDataDTO> dropDowns,
			String oldFieldId, String oldFieldCode, String oldFieldName,
			String oldFieldDetailsId, String oldFixedValueFlag,
			String oldFixedValue, String oldDateFlag, String oldDropDownFlag,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   PortalException {

		getService().handleMOIFieldUpdate(
			portalApiUrl, id, subServiceId, code, name, fieldDetailsId,
			fixedValueFlag, fixedValue, dateFlag, dropDownFlag, dropDowns,
			oldFieldId, oldFieldCode, oldFieldName, oldFieldDetailsId,
			oldFixedValueFlag, oldFixedValue, oldDateFlag, oldDropDownFlag,
			serviceContext, user);
	}

	public static void handleMOIServiceUpdate(
			String portalApiUrl, String subServiceId, String subServiceName,
			String subServiceCode, String id, String languageId,
			String oldSubServiceId, String oldSubServiceName,
			String oldSubServiceCode, String oldMoiServiceId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   PortalException {

		getService().handleMOIServiceUpdate(
			portalApiUrl, subServiceId, subServiceName, subServiceCode, id,
			languageId, oldSubServiceId, oldSubServiceName, oldSubServiceCode,
			oldMoiServiceId, serviceContext, user);
	}

	public static void handleMOIUpdate(
			String portalApiUrl, String serviceTypeFlag, String serviceName,
			String serviceCode, String id, String languageId,
			String oldBillerId, String oldBillerCode, String oldBillerName,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   PortalException {

		getService().handleMOIUpdate(
			portalApiUrl, serviceTypeFlag, serviceName, serviceCode, id,
			languageId, oldBillerId, oldBillerCode, oldBillerName,
			serviceContext, user);
	}

	public static MOILocalService getService() {
		return _service;
	}

	public static void setService(MOILocalService service) {
		_service = service;
	}

	private static volatile MOILocalService _service;

}