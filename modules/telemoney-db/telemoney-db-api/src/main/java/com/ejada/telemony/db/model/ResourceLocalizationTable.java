/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;ResourceLocalization&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ResourceLocalization
 * @generated
 */
public class ResourceLocalizationTable
	extends BaseTable<ResourceLocalizationTable> {

	public static final ResourceLocalizationTable INSTANCE =
		new ResourceLocalizationTable();

	public final Column<ResourceLocalizationTable, Long> mvccVersion =
		createColumn(
			"mvccVersion", Long.class, Types.BIGINT, Column.FLAG_NULLITY);
	public final Column<ResourceLocalizationTable, Long>
		resourceLocalizationId = createColumn(
			"resourceLocalizationId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<ResourceLocalizationTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ResourceLocalizationTable, Long> resourceId =
		createColumn(
			"resourceId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ResourceLocalizationTable, String> languageId =
		createColumn(
			"languageId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ResourceLocalizationTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ResourceLocalizationTable, String> attachName =
		createColumn(
			"attachName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ResourceLocalizationTable, String> attach =
		createColumn(
			"attach", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ResourceLocalizationTable, String> description =
		createColumn(
			"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ResourceLocalizationTable, String> routeId =
		createColumn(
			"routeId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ResourceLocalizationTable, String> url = createColumn(
		"url", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ResourceLocalizationTable() {
		super("ResourceLocalization", ResourceLocalizationTable::new);
	}

}