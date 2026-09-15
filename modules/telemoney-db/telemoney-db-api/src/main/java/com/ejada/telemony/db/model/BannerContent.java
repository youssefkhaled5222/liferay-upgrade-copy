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
 * The extended model interface for the BannerContent service. Represents a row in the &quot;BANNER_CONTENT&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see BannerContentModel
 * @generated
 */
@ImplementationClassName("com.ejada.telemony.db.model.impl.BannerContentImpl")
@ProviderType
public interface BannerContent extends BannerContentModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ejada.telemony.db.model.impl.BannerContentImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<BannerContent, Long> CONTENT_ID_ACCESSOR =
		new Accessor<BannerContent, Long>() {

			@Override
			public Long get(BannerContent bannerContent) {
				return bannerContent.getContentId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<BannerContent> getTypeClass() {
				return BannerContent.class;
			}

		};

}