/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;FeatureLovMap&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see FeatureLovMap
 * @generated
 */
public class FeatureLovMapTable extends BaseTable<FeatureLovMapTable> {

	public static final FeatureLovMapTable INSTANCE = new FeatureLovMapTable();

	public final Column<FeatureLovMapTable, Long> id = createColumn(
		"id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<FeatureLovMapTable, Long> featureId = createColumn(
		"featureId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FeatureLovMapTable, Long> featureEntityResourceId =
		createColumn(
			"featureEntityResourceId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<FeatureLovMapTable, Long> lovEntityResourceId =
		createColumn(
			"lovEntityResourceId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<FeatureLovMapTable, String> lovDataCode = createColumn(
		"lovDataCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FeatureLovMapTable, String> lovType = createColumn(
		"lovType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private FeatureLovMapTable() {
		super("FeatureLovMap", FeatureLovMapTable::new);
	}

}