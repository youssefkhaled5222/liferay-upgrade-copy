/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BillerLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BillerLocalService
 * @generated
 */
public class BillerLocalServiceWrapper
	implements BillerLocalService, ServiceWrapper<BillerLocalService> {

	public BillerLocalServiceWrapper() {
		this(null);
	}

	public BillerLocalServiceWrapper(BillerLocalService billerLocalService) {
		_billerLocalService = billerLocalService;
	}

	@Override
	public void addBiller(
			String portalApiUrl, String prePaidCode, String postPaidCode,
			String billerNameAr, String billerNameEn, String billerCategoryId,
			String labelNameAr, String labelNameEn, String paymentTypeId,
			String allowedFixedValues, double paymentMinAmount,
			double paymentMaxAmount, String allowedPaymentAmounts,
			String photoLink, com.liferay.portal.kernel.model.User user,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   com.liferay.portal.kernel.exception.PortalException {

		_billerLocalService.addBiller(
			portalApiUrl, prePaidCode, postPaidCode, billerNameAr, billerNameEn,
			billerCategoryId, labelNameAr, labelNameEn, paymentTypeId,
			allowedFixedValues, paymentMinAmount, paymentMaxAmount,
			allowedPaymentAmounts, photoLink, user, serviceContext);
	}

	@Override
	public String convertListToString(java.util.List<Integer> list) {
		return _billerLocalService.convertListToString(list);
	}

	@Override
	public java.util.List<Integer> convertStringToList(String str) {
		return _billerLocalService.convertStringToList(str);
	}

	@Override
	public void createBillerCategory(
			String portalApiUrl, String categoryCode, String categoryNameAr,
			String categoryNameEn, com.liferay.portal.kernel.model.User user,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   com.liferay.portal.kernel.exception.PortalException {

		_billerLocalService.createBillerCategory(
			portalApiUrl, categoryCode, categoryNameAr, categoryNameEn, user,
			serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject createBillerPayload(
		String prePaidCode, String postPaidCode, String billerNameAr,
		String billerNameEn, String billerCategoryId, String labelNameAr,
		String labelNameEn, String paymentTypeId, String allowedFixedValues,
		double paymentMinAmount, double paymentMaxAmount,
		String allowedPaymentAmounts, String photoLink) {

		return _billerLocalService.createBillerPayload(
			prePaidCode, postPaidCode, billerNameAr, billerNameEn,
			billerCategoryId, labelNameAr, labelNameEn, paymentTypeId,
			allowedFixedValues, paymentMinAmount, paymentMaxAmount,
			allowedPaymentAmounts, photoLink);
	}

	@Override
	public void deleteBiller(String deleteUrl, String id) {
		_billerLocalService.deleteBiller(deleteUrl, id);
	}

	@Override
	public void deleteBillerCategory(
			String portalApiUrl, String categoryId, String categoryNameAr,
			String categoryNameEn, String categoryCode,
			com.liferay.portal.kernel.model.User user,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   com.liferay.portal.kernel.exception.PortalException {

		_billerLocalService.deleteBillerCategory(
			portalApiUrl, categoryId, categoryNameAr, categoryNameEn,
			categoryCode, user, serviceContext);
	}

	@Override
	public String getAllBillerCategory(String Url) {
		return _billerLocalService.getAllBillerCategory(Url);
	}

	@Override
	public String getAllBillers(
		String errorCodeUrl, String billerId, String billerName,
		String billerCategoryId) {

		return _billerLocalService.getAllBillers(
			errorCodeUrl, billerId, billerName, billerCategoryId);
	}

	@Override
	public String getAllPaymentType(String Url) {
		return _billerLocalService.getAllPaymentType(Url);
	}

	@Override
	public String getBillerData(
		String ordersApiUrl, String billerId, String billerName,
		String billerCategoryId) {

		return _billerLocalService.getBillerData(
			ordersApiUrl, billerId, billerName, billerCategoryId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _billerLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public String getPaymentTypeData(String ordersApiUrl) {
		return _billerLocalService.getPaymentTypeData(ordersApiUrl);
	}

	@Override
	public void handleApprovedConfigEntity(
			com.ejada.telemony.db.model.ConfigurationEntity configurationEntity)
		throws com.liferay.portal.kernel.json.JSONException {

		_billerLocalService.handleApprovedConfigEntity(configurationEntity);
	}

	@Override
	public void handleDeleteBillerWorkflow(
			String portalApiUrl, String id, String prePaidCode,
			String postPaidCode, String billerNameAr, String billerNameEn,
			String billerCategoryId, String labelNameAr, String labelNameEn,
			String paymentTypeId, String allowedFixedValues,
			double paymentMinAmount, double paymentMaxAmount,
			String allowedPaymentAmounts, String photoLink,
			com.liferay.portal.kernel.model.User user,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   com.liferay.portal.kernel.exception.PortalException {

		_billerLocalService.handleDeleteBillerWorkflow(
			portalApiUrl, id, prePaidCode, postPaidCode, billerNameAr,
			billerNameEn, billerCategoryId, labelNameAr, labelNameEn,
			paymentTypeId, allowedFixedValues, paymentMinAmount,
			paymentMaxAmount, allowedPaymentAmounts, photoLink, user,
			serviceContext);
	}

	@Override
	public String searchBiller(
		String errorCodeUrl, String billerId, String billerName,
		String billerCategoryId) {

		return _billerLocalService.searchBiller(
			errorCodeUrl, billerId, billerName, billerCategoryId);
	}

	@Override
	public void updateBiller(
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
			   com.liferay.portal.kernel.exception.PortalException {

		_billerLocalService.updateBiller(
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

	@Override
	public void updateBillerCategory(
			String portalApiUrl, String categoryId, String categoryNameAr,
			String categoryNameEn, String oldCategoryNameAr,
			String oldCategoryNameEn, com.liferay.portal.kernel.model.User user,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   com.liferay.portal.kernel.exception.PortalException {

		_billerLocalService.updateBillerCategory(
			portalApiUrl, categoryId, categoryNameAr, categoryNameEn,
			oldCategoryNameAr, oldCategoryNameEn, user, serviceContext);
	}

	@Override
	public BillerLocalService getWrappedService() {
		return _billerLocalService;
	}

	@Override
	public void setWrappedService(BillerLocalService billerLocalService) {
		_billerLocalService = billerLocalService;
	}

	private BillerLocalService _billerLocalService;

}