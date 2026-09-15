/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;LOVDATA&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see LovData
 * @generated
 */
public class LovDataTable extends BaseTable<LovDataTable> {

	public static final LovDataTable INSTANCE = new LovDataTable();

	public final Column<LovDataTable, String> defaultLanguageId = createColumn(
		"defaultLanguageId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LovDataTable, Long> id = createColumn(
		"id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<LovDataTable, Long> lovId = createColumn(
		"lov_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LovDataTable, String> lovType = createColumn(
		"lov_type", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LovDataTable, String> recordTypeCode = createColumn(
		"record_type_Code", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LovDataTable, String> recordShortDescription =
		createColumn(
			"record_short_description", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<LovDataTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<LovDataTable, Long> originalEntityId = createColumn(
		"originalEntityId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LovDataTable, Long> entityResourceId = createColumn(
		"entityResourceId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private LovDataTable() {
		super("LOVDATA", LovDataTable::new);
	}

}