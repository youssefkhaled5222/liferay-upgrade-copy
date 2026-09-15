/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.ejada.telemoney.db.domain.model.DropDownDataDTO;
import com.ejada.telemony.db.model.ConfigurationEntity;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for MOI. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see MOILocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface MOILocalService extends BaseLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.MOILocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the moi local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link MOILocalServiceUtil} if injection and service tracking are not available.
	 */
	public void callMOIDeleteRequest(String ordersApiUrl);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getMOIBiller(
		String moiBillerApiUrl, String refundTypeCode, String languageId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getMOIBillerAPI(String moiApiUrl, String languageId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getMOIBillerService(
		String moiBillerApiUrl, String getSearchkeyword, String languageId);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	public void handleApprovedConfigEntity(
			ConfigurationEntity configurationEntity,
			ServiceContext serviceContext)
		throws JSONException;

	public void handleDeleteMOIBiller(
			String portalApiUrl, String id, String oldBillerId,
			String oldBillerCode, String oldBillerName,
			ServiceContext serviceContext, User user)
		throws JsonProcessingException, PortalException;

	public void handleDeleteMOIService(
			String portalApiUrl, String id, String oldSubServiceId,
			String oldSubServiceCode, String oldSubServiceName,
			String oldMoiServiceId, String oldBillerName,
			ServiceContext serviceContext, User user)
		throws JsonProcessingException, PortalException;

	public void handleMOIFieldAndDropDownUpdate(
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
			List<Integer> oldAllowedValues, ServiceContext serviceContext,
			User user)
		throws JsonProcessingException, PortalException;

	public void handleMOIFieldUpdate(
			String portalApiUrl, String id, String subServiceId, String code,
			String name, int fieldDetailsId, int fixedValueFlag,
			String fixedValue, int dateFlag, int dropDownFlag,
			List<DropDownDataDTO> dropDowns, String oldFieldId,
			String oldFieldCode, String oldFieldName, String oldFieldDetailsId,
			String oldFixedValueFlag, String oldFixedValue, String oldDateFlag,
			String oldDropDownFlag, ServiceContext serviceContext, User user)
		throws JsonProcessingException, PortalException;

	public void handleMOIServiceUpdate(
			String portalApiUrl, String subServiceId, String subServiceName,
			String subServiceCode, String id, String languageId,
			String oldSubServiceId, String oldSubServiceName,
			String oldSubServiceCode, String oldMoiServiceId,
			ServiceContext serviceContext, User user)
		throws JsonProcessingException, PortalException;

	public void handleMOIUpdate(
			String portalApiUrl, String serviceTypeFlag, String serviceName,
			String serviceCode, String id, String languageId,
			String oldBillerId, String oldBillerCode, String oldBillerName,
			ServiceContext serviceContext, User user)
		throws JsonProcessingException, PortalException;

}