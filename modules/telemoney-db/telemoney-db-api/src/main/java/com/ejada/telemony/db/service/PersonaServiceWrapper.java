/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PersonaService}.
 *
 * @author Brian Wing Shun Chan
 * @see PersonaService
 * @generated
 */
public class PersonaServiceWrapper
	implements PersonaService, ServiceWrapper<PersonaService> {

	public PersonaServiceWrapper() {
		this(null);
	}

	public PersonaServiceWrapper(PersonaService personaService) {
		_personaService = personaService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _personaService.getOSGiServiceIdentifier();
	}

	@Override
	public PersonaService getWrappedService() {
		return _personaService;
	}

	@Override
	public void setWrappedService(PersonaService personaService) {
		_personaService = personaService;
	}

	private PersonaService _personaService;

}