/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;AppConfigItem&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see AppConfigItem
 * @generated
 */
public class AppConfigItemTable extends BaseTable<AppConfigItemTable> {

	public static final AppConfigItemTable INSTANCE = new AppConfigItemTable();

	public final Column<AppConfigItemTable, Long> configItemId = createColumn(
		"configItemId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AppConfigItemTable, Long> environmentId = createColumn(
		"environmentId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppConfigItemTable, String> keyName = createColumn(
		"keyName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AppConfigItemTable, String> valueType = createColumn(
		"valueType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AppConfigItemTable, String> value = createColumn(
		"value", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AppConfigItemTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AppConfigItemTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private AppConfigItemTable() {
		super("AppConfigItem", AppConfigItemTable::new);
	}

}