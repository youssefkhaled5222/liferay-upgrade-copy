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
 * The table class for the &quot;GlobalVersion&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see GlobalVersion
 * @generated
 */
public class GlobalVersionTable extends BaseTable<GlobalVersionTable> {

	public static final GlobalVersionTable INSTANCE = new GlobalVersionTable();

	public final Column<GlobalVersionTable, Long> versionId = createColumn(
		"versionId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<GlobalVersionTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<GlobalVersionTable, Long> channelId = createColumn(
		"channelId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<GlobalVersionTable, String> componentName =
		createColumn(
			"componentName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<GlobalVersionTable, Long> version = createColumn(
		"version", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<GlobalVersionTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private GlobalVersionTable() {
		super("GlobalVersion", GlobalVersionTable::new);
	}

}