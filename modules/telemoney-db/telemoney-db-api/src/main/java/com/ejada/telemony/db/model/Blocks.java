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
 * The extended model interface for the Blocks service. Represents a row in the &quot;BLOCKS&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see BlocksModel
 * @generated
 */
@ImplementationClassName("com.ejada.telemony.db.model.impl.BlocksImpl")
@ProviderType
public interface Blocks extends BlocksModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ejada.telemony.db.model.impl.BlocksImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Blocks, Long> BLOCK_ID_ACCESSOR =
		new Accessor<Blocks, Long>() {

			@Override
			public Long get(Blocks blocks) {
				return blocks.getBlockId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Blocks> getTypeClass() {
				return Blocks.class;
			}

		};

}