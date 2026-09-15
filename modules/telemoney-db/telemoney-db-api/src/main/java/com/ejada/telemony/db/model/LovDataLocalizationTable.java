/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;LovDataLocalization&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see LovDataLocalization
 * @generated
 */
public class LovDataLocalizationTable
	extends BaseTable<LovDataLocalizationTable> {

	public static final LovDataLocalizationTable INSTANCE =
		new LovDataLocalizationTable();

	public final Column<LovDataLocalizationTable, Long> mvccVersion =
		createColumn(
			"mvccVersion", Long.class, Types.BIGINT, Column.FLAG_NULLITY);
	public final Column<LovDataLocalizationTable, Long> lovDataLocalizationId =
		createColumn(
			"lovDataLocalizationId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<LovDataLocalizationTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LovDataLocalizationTable, String> languageId =
		createColumn(
			"languageId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LovDataLocalizationTable, String> recordDescription =
		createColumn(
			"recordDescription", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<LovDataLocalizationTable, String> lovIdLocalization =
		createColumn(
			"lov_id", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private LovDataLocalizationTable() {
		super("LovDataLocalization", LovDataLocalizationTable::new);
	}

}