/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.ejada.telemony.db.model.ConfigurationEntity;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Biller. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see BillerLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface BillerLocalService extends BaseLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.BillerLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the biller local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link BillerLocalServiceUtil} if injection and service tracking are not available.
	 */
	public void addBiller(
			String portalApiUrl, String prePaidCode, String postPaidCode,
			String billerNameAr, String billerNameEn, String billerCategoryId,
			String labelNameAr, String labelNameEn, String paymentTypeId,
			String allowedFixedValues, double paymentMinAmount,
			double paymentMaxAmount, String allowedPaymentAmounts,
			String photoLink, User user, ServiceContext serviceContext)
		throws JsonProcessingException, PortalException;

	public String convertListToString(List<Integer> list);

	public List<Integer> convertStringToList(String str);

	public void createBillerCategory(
			String portalApiUrl, String categoryCode, String categoryNameAr,
			String categoryNameEn, User user, ServiceContext serviceContext)
		throws JsonProcessingException, PortalException;

	public JSONObject createBillerPayload(
		String prePaidCode, String postPaidCode, String billerNameAr,
		String billerNameEn, String billerCategoryId, String labelNameAr,
		String labelNameEn, String paymentTypeId, String allowedFixedValues,
		double paymentMinAmount, double paymentMaxAmount,
		String allowedPaymentAmounts, String photoLink);

	public void deleteBiller(String deleteUrl, String id);

	public void deleteBillerCategory(
			String portalApiUrl, String categoryId, String categoryNameAr,
			String categoryNameEn, String categoryCode, User user,
			ServiceContext serviceContext)
		throws JsonProcessingException, PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getAllBillerCategory(String Url);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getAllBillers(
		String errorCodeUrl, String billerId, String billerName,
		String billerCategoryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getAllPaymentType(String Url);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getBillerData(
		String ordersApiUrl, String billerId, String billerName,
		String billerCategoryId);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getPaymentTypeData(String ordersApiUrl);

	public void handleApprovedConfigEntity(
			ConfigurationEntity configurationEntity)
		throws JSONException;

	public void handleDeleteBillerWorkflow(
			String portalApiUrl, String id, String prePaidCode,
			String postPaidCode, String billerNameAr, String billerNameEn,
			String billerCategoryId, String labelNameAr, String labelNameEn,
			String paymentTypeId, String allowedFixedValues,
			double paymentMinAmount, double paymentMaxAmount,
			String allowedPaymentAmounts, String photoLink, User user,
			ServiceContext serviceContext)
		throws JsonProcessingException, PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String searchBiller(
		String errorCodeUrl, String billerId, String billerName,
		String billerCategoryId);

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
			String oldPhotoLink, User user, ServiceContext serviceContext)
		throws JsonProcessingException, PortalException;

	public void updateBillerCategory(
			String portalApiUrl, String categoryId, String categoryNameAr,
			String categoryNameEn, String oldCategoryNameAr,
			String oldCategoryNameEn, User user, ServiceContext serviceContext)
		throws JsonProcessingException, PortalException;

}