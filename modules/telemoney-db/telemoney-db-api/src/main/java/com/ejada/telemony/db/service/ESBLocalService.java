/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.ejada.telemoney.db.dto.EsbConstantRequestDto;
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

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for ESB. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see ESBLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ESBLocalService extends BaseLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.ESBLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the esb local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ESBLocalServiceUtil} if injection and service tracking are not available.
	 */
	public String callServiceUpdate(
		String portalApiUrl, JSONObject updatePayload);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getConstantList(
		String esbUrl, String XCorrelationId, String userName, String password);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getConstantListSearch(
		String searchUrl, String getSearchkeyword, String XCorrelationId,
		String userName, String password);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getESBConstantsReload(
		String esbReloadUrl, String XCorrelationId, String userName,
		String password);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getESBConstantsReloadSearch(
		String entityReloadUrl, String reloadSearchkeyword,
		String XCorrelationId, String userName, String password);

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

	public void updateESB(
			String esbUpdateUrl, EsbConstantRequestDto oldData,
			EsbConstantRequestDto newData, ServiceContext serviceContext,
			User user)
		throws JsonProcessingException, PortalException;

}