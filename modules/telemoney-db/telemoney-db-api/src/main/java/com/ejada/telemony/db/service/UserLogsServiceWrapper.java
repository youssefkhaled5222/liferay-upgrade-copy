/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserLogsService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserLogsService
 * @generated
 */
public class UserLogsServiceWrapper
	implements ServiceWrapper<UserLogsService>, UserLogsService {

	public UserLogsServiceWrapper() {
		this(null);
	}

	public UserLogsServiceWrapper(UserLogsService userLogsService) {
		_userLogsService = userLogsService;
	}

	@Override
	public void addUserData(String userName, String userAction) {
		_userLogsService.addUserData(userName, userAction);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userLogsService.getOSGiServiceIdentifier();
	}

	@Override
	public UserLogsService getWrappedService() {
		return _userLogsService;
	}

	@Override
	public void setWrappedService(UserLogsService userLogsService) {
		_userLogsService = userLogsService;
	}

	private UserLogsService _userLogsService;

}