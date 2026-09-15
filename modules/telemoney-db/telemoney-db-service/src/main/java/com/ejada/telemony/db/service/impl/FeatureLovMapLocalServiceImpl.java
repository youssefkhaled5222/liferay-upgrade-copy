/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.impl;

import com.ejada.telemony.db.model.FeatureLovMap;
import com.ejada.telemony.db.service.base.FeatureLovMapLocalServiceBaseImpl;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class FeatureLovMapLocalServiceImpl
	extends FeatureLovMapLocalServiceBaseImpl {

	public List<FeatureLovMap> findByFeatureId(long featureId) {
		return featureLovMapPersistence.findByFeatureId(featureId);
	}

	public List<FeatureLovMap> findByFeatureEntityResourceId(long featureEntityResourceId) {
		return featureLovMapPersistence.findByFeatureEntityResourceId(featureEntityResourceId);
	}

	public List<FeatureLovMap> findByFeatureIdAndLovType(long featureId, String lovType) {
		return featureLovMapPersistence.findByFeatureIdAndLovType(featureId, lovType);
	}

	public List<FeatureLovMap> findByFeatureEntityResourceIdAndLovType(
			long featureEntityResourceId, String lovType) {
		return featureLovMapPersistence.findByFeatureEntityResourceIdAndLovType(
				featureEntityResourceId, lovType);
	}

	public List<FeatureLovMap> findByLovEntityResourceIdAndLovDataCode(
			long lovEntityResourceId, String lovDataCode) {
		return featureLovMapPersistence.findByLovEntityResourceIdAndLovDataCode(
				lovEntityResourceId, lovDataCode);
	}
}