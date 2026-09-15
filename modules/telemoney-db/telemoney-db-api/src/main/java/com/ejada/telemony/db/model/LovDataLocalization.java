/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the LovDataLocalization service. Represents a row in the &quot;LovDataLocalization&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see LovDataLocalizationModel
 * @generated
 */
@ImplementationClassName(
	"com.ejada.telemony.db.model.impl.LovDataLocalizationImpl"
)
@ProviderType
public interface LovDataLocalization extends LovDataLocalizationModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ejada.telemony.db.model.impl.LovDataLocalizationImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<LovDataLocalization, Long>
		LOV_DATA_LOCALIZATION_ID_ACCESSOR =
			new Accessor<LovDataLocalization, Long>() {

				@Override
				public Long get(LovDataLocalization lovDataLocalization) {
					return lovDataLocalization.getLovDataLocalizationId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<LovDataLocalization> getTypeClass() {
					return LovDataLocalization.class;
				}

			};

}