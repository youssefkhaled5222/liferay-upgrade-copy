/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.ejada.telemony.db.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchFeatureLovMapException extends NoSuchModelException {

	public NoSuchFeatureLovMapException() {
	}

	public NoSuchFeatureLovMapException(String msg) {
		super(msg);
	}

	public NoSuchFeatureLovMapException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchFeatureLovMapException(Throwable throwable) {
		super(throwable);
	}

}