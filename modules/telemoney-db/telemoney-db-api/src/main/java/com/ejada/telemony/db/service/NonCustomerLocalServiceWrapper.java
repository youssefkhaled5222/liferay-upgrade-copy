/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link NonCustomerLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see NonCustomerLocalService
 * @generated
 */
public class NonCustomerLocalServiceWrapper
	implements NonCustomerLocalService,
			   ServiceWrapper<NonCustomerLocalService> {

	public NonCustomerLocalServiceWrapper() {
		this(null);
	}

	public NonCustomerLocalServiceWrapper(
		NonCustomerLocalService nonCustomerLocalService) {

		_nonCustomerLocalService = nonCustomerLocalService;
	}

	@Override
	public String getAllNonCustomer(
		String nonCustomerUrl, String XCorrelationId, String userName,
		String password) {

		return _nonCustomerLocalService.getAllNonCustomer(
			nonCustomerUrl, XCorrelationId, userName, password);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _nonCustomerLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public NonCustomerLocalService getWrappedService() {
		return _nonCustomerLocalService;
	}

	@Override
	public void setWrappedService(
		NonCustomerLocalService nonCustomerLocalService) {

		_nonCustomerLocalService = nonCustomerLocalService;
	}

	private NonCustomerLocalService _nonCustomerLocalService;

}