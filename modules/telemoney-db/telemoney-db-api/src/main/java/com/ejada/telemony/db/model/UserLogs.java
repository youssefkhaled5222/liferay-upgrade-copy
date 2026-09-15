/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the UserLogs service. Represents a row in the &quot;USER_LOGS&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see UserLogsModel
 * @generated
 */
@ImplementationClassName("com.ejada.telemony.db.model.impl.UserLogsImpl")
@ProviderType
public interface UserLogs extends PersistedModel, UserLogsModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ejada.telemony.db.model.impl.UserLogsImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<UserLogs, Long> LOGS_ID_ACCESSOR =
		new Accessor<UserLogs, Long>() {

			@Override
			public Long get(UserLogs userLogs) {
				return userLogs.getLogsId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<UserLogs> getTypeClass() {
				return UserLogs.class;
			}

		};

}