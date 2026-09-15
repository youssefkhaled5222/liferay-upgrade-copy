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
 * The extended model interface for the ConfigurationEntity service. Represents a row in the &quot;ConfigurationEntity&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ConfigurationEntityModel
 * @generated
 */
@ImplementationClassName(
	"com.ejada.telemony.db.model.impl.ConfigurationEntityImpl"
)
@ProviderType
public interface ConfigurationEntity
	extends ConfigurationEntityModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ejada.telemony.db.model.impl.ConfigurationEntityImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ConfigurationEntity, Long> ID_ACCESSOR =
		new Accessor<ConfigurationEntity, Long>() {

			@Override
			public Long get(ConfigurationEntity configurationEntity) {
				return configurationEntity.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ConfigurationEntity> getTypeClass() {
				return ConfigurationEntity.class;
			}

		};

}