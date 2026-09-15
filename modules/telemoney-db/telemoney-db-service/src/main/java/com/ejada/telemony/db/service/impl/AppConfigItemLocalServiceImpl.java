/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.impl;

import com.ejada.telemony.db.model.AppConfigItem;
import com.ejada.telemony.db.service.base.AppConfigItemLocalServiceBaseImpl;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class AppConfigItemLocalServiceImpl
	extends AppConfigItemLocalServiceBaseImpl {

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AppConfigItem> getAppConfigItemsByEnvironmentId(
		long environmentId) {

		return appConfigItemPersistence.findByenvironmentId(environmentId);
	}

	public void deleteAppConfigItemsByEnvironmentId(long environmentId) {
		appConfigItemPersistence.removeByenvironmentId(environmentId);
	}
}