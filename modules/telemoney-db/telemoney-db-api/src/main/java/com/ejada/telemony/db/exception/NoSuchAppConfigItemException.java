/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.ejada.telemony.db.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchAppConfigItemException extends NoSuchModelException {

	public NoSuchAppConfigItemException() {
	}

	public NoSuchAppConfigItemException(String msg) {
		super(msg);
	}

	public NoSuchAppConfigItemException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchAppConfigItemException(Throwable throwable) {
		super(throwable);
	}

}