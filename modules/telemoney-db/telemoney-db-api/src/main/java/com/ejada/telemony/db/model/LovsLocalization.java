/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the LovsLocalization service. Represents a row in the &quot;LovsLocalization&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see LovsLocalizationModel
 * @generated
 */
@ImplementationClassName(
	"com.ejada.telemony.db.model.impl.LovsLocalizationImpl"
)
@ProviderType
public interface LovsLocalization extends LovsLocalizationModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ejada.telemony.db.model.impl.LovsLocalizationImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<LovsLocalization, Long>
		LOVS_LOCALIZATION_ID_ACCESSOR = new Accessor<LovsLocalization, Long>() {

			@Override
			public Long get(LovsLocalization lovsLocalization) {
				return lovsLocalization.getLovsLocalizationId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<LovsLocalization> getTypeClass() {
				return LovsLocalization.class;
			}

		};

}