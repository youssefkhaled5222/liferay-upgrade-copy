/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.ejada.telemony.db.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchAppEnvironmentException extends NoSuchModelException {

	public NoSuchAppEnvironmentException() {
	}

	public NoSuchAppEnvironmentException(String msg) {
		super(msg);
	}

	public NoSuchAppEnvironmentException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchAppEnvironmentException(Throwable throwable) {
		super(throwable);
	}

}