/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;LovsLocalization&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see LovsLocalization
 * @generated
 */
public class LovsLocalizationTable extends BaseTable<LovsLocalizationTable> {

	public static final LovsLocalizationTable INSTANCE =
		new LovsLocalizationTable();

	public final Column<LovsLocalizationTable, Long> mvccVersion = createColumn(
		"mvccVersion", Long.class, Types.BIGINT, Column.FLAG_NULLITY);
	public final Column<LovsLocalizationTable, Long> lovsLocalizationId =
		createColumn(
			"lovsLocalizationId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<LovsLocalizationTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LovsLocalizationTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LovsLocalizationTable, String> languageId =
		createColumn(
			"languageId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LovsLocalizationTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private LovsLocalizationTable() {
		super("LovsLocalization", LovsLocalizationTable::new);
	}

}