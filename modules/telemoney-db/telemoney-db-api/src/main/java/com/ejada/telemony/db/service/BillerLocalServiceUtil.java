/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

/**
 * Provides the local service utility for Biller. This utility wraps
 * <code>com.ejada.telemony.db.service.impl.BillerLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see BillerLocalService
 * @generated
 */
public class BillerLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.BillerLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addBiller(
			String portalApiUrl, String prePaidCode, String postPaidCode,
			String billerNameAr, String billerNameEn, String billerCategoryId,
			String labelNameAr, String labelNameEn, String paymentTypeId,
			String allowedFixedValues, double paymentMinAmount,
			double paymentMaxAmount, String allowedPaymentAmounts,
			String photoLink, com.liferay.portal.kernel.model.User user,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   PortalException {

		getService().addBiller(
			portalApiUrl, prePaidCode, postPaidCode, billerNameAr, billerNameEn,
			billerCategoryId, labelNameAr, labelNameEn, paymentTypeId,
			allowedFixedValues, paymentMinAmount, paymentMaxAmount,
			allowedPaymentAmounts, photoLink, user, serviceContext);
	}

	public static String convertListToString(List<Integer> list) {
		return getService().convertListToString(list);
	}

	public static List<Integer> convertStringToList(String str) {
		return getService().convertStringToList(str);
	}

	public static void createBillerCategory(
			String portalApiUrl, String categoryCode, String categoryNameAr,
			String categoryNameEn, com.liferay.portal.kernel.model.User user,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   PortalException {

		getService().createBillerCategory(
			portalApiUrl, categoryCode, categoryNameAr, categoryNameEn, user,
			serviceContext);
	}

	public static com.liferay.portal.kernel.json.JSONObject createBillerPayload(
		String prePaidCode, String postPaidCode, String billerNameAr,
		String billerNameEn, String billerCategoryId, String labelNameAr,
		String labelNameEn, String paymentTypeId, String allowedFixedValues,
		double paymentMinAmount, double paymentMaxAmount,
		String allowedPaymentAmounts, String photoLink) {

		return getService().createBillerPayload(
			prePaidCode, postPaidCode, billerNameAr, billerNameEn,
			billerCategoryId, labelNameAr, labelNameEn, paymentTypeId,
			allowedFixedValues, paymentMinAmount, paymentMaxAmount,
			allowedPaymentAmounts, photoLink);
	}

	public static void deleteBiller(String deleteUrl, String id) {
		getService().deleteBiller(deleteUrl, id);
	}

	public static void deleteBillerCategory(
			String portalApiUrl, String categoryId, String categoryNameAr,
			String categoryNameEn, String categoryCode,
			com.liferay.portal.kernel.model.User user,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   PortalException {

		getService().deleteBillerCategory(
			portalApiUrl, categoryId, categoryNameAr, categoryNameEn,
			categoryCode, user, serviceContext);
	}

	public static String getAllBillerCategory(String Url) {
		return getService().getAllBillerCategory(Url);
	}

	public static String getAllBillers(
		String errorCodeUrl, String billerId, String billerName,
		String billerCategoryId) {

		return getService().getAllBillers(
			errorCodeUrl, billerId, billerName, billerCategoryId);
	}

	public static String getAllPaymentType(String Url) {
		return getService().getAllPaymentType(Url);
	}

	public static String getBillerData(
		String ordersApiUrl, String billerId, String billerName,
		String billerCategoryId) {

		return getService().getBillerData(
			ordersApiUrl, billerId, billerName, billerCategoryId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static String getPaymentTypeData(String ordersApiUrl) {
		return getService().getPaymentTypeData(ordersApiUrl);
	}

	public static void handleApprovedConfigEntity(
			com.ejada.telemony.db.model.ConfigurationEntity configurationEntity)
		throws com.liferay.portal.kernel.json.JSONException {

		getService().handleApprovedConfigEntity(configurationEntity);
	}

	public static void handleDeleteBillerWorkflow(
			String portalApiUrl, String id, String prePaidCode,
			String postPaidCode, String billerNameAr, String billerNameEn,
			String billerCategoryId, String labelNameAr, String labelNameEn,
			String paymentTypeId, String allowedFixedValues,
			double paymentMinAmount, double paymentMaxAmount,
			String allowedPaymentAmounts, String photoLink,
			com.liferay.portal.kernel.model.User user,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   PortalException {

		getService().handleDeleteBillerWorkflow(
			portalApiUrl, id, prePaidCode, postPaidCode, billerNameAr,
			billerNameEn, billerCategoryId, labelNameAr, labelNameEn,
			paymentTypeId, allowedFixedValues, paymentMinAmount,
			paymentMaxAmount, allowedPaymentAmounts, photoLink, user,
			serviceContext);
	}

	public static String searchBiller(
		String errorCodeUrl, String billerId, String billerName,
		String billerCategoryId) {

		return getService().searchBiller(
			errorCodeUrl, billerId, billerName, billerCategoryId);
	}

	public static void updateBiller(
			String portalApiUrl, String id, String prePaidCode,
			String postPaidCode, String billerNameAr, String billerNameEn,
			String billerCategoryId, String labelNameAr, String labelNameEn,
			String paymentTypeId, String allowedFixedValues,
			double paymentMinAmount, double paymentMaxAmount,
			String allowedPaymentAmounts, String photoLink,
			String oldPrePaidCode, String oldPostPaidCode,
			String oldBillerNameAr, String oldBillerNameEn,
			String oldBillerCategoryId, String oldLabelNameAr,
			String oldLabelNameEn, String oldPaymentTypeId,
			String oldAllowedFixedValues, double oldPaymentMinAmount,
			double oldPaymentMaxAmount, String oldAllowedPaymentAmounts,
			String oldPhotoLink, com.liferay.portal.kernel.model.User user,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   PortalException {

		getService().updateBiller(
			portalApiUrl, id, prePaidCode, postPaidCode, billerNameAr,
			billerNameEn, billerCategoryId, labelNameAr, labelNameEn,
			paymentTypeId, allowedFixedValues, paymentMinAmount,
			paymentMaxAmount, allowedPaymentAmounts, photoLink, oldPrePaidCode,
			oldPostPaidCode, oldBillerNameAr, oldBillerNameEn,
			oldBillerCategoryId, oldLabelNameAr, oldLabelNameEn,
			oldPaymentTypeId, oldAllowedFixedValues, oldPaymentMinAmount,
			oldPaymentMaxAmount, oldAllowedPaymentAmounts, oldPhotoLink, user,
			serviceContext);
	}

	public static void updateBillerCategory(
			String portalApiUrl, String categoryId, String categoryNameAr,
			String categoryNameEn, String oldCategoryNameAr,
			String oldCategoryNameEn, com.liferay.portal.kernel.model.User user,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   PortalException {

		getService().updateBillerCategory(
			portalApiUrl, categoryId, categoryNameAr, categoryNameEn,
			oldCategoryNameAr, oldCategoryNameEn, user, serviceContext);
	}

	public static BillerLocalService getService() {
		return _service;
	}

	public static void setService(BillerLocalService service) {
		_service = service;
	}

	private static volatile BillerLocalService _service;

}