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
 * The extended model interface for the AppEnvironment service. Represents a row in the &quot;AppEnvironment&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see AppEnvironmentModel
 * @generated
 */
@ImplementationClassName("com.ejada.telemony.db.model.impl.AppEnvironmentImpl")
@ProviderType
public interface AppConfig extends AppEnvironmentModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ejada.telemony.db.model.impl.AppEnvironmentImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AppConfig, Long> ENVIRONMENT_ID_ACCESSOR =
		new Accessor<AppConfig, Long>() {

			@Override
			public Long get(AppConfig appEnvironment) {
				return appEnvironment.getEnvironmentId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<AppConfig> getTypeClass() {
				return AppConfig.class;
			}

		};

}