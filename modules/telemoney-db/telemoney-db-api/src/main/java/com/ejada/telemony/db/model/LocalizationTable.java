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
 * The table class for the &quot;LOCALIZATION&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Localization
 * @generated
 */
public class LocalizationTable extends BaseTable<LocalizationTable> {

	public static final LocalizationTable INSTANCE = new LocalizationTable();

	public final Column<LocalizationTable, Long> localizationId = createColumn(
		"localizationId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<LocalizationTable, String> localValue = createColumn(
		"localValue", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LocalizationTable, Long> version = createColumn(
		"version", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LocalizationTable, Long> languageId = createColumn(
		"languageId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LocalizationTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LocalizationTable, Long> channelId = createColumn(
		"channelId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LocalizationTable, Long> featureId = createColumn(
		"featureId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LocalizationTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LocalizationTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LocalizationTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LocalizationTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LocalizationTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LocalizationTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<LocalizationTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LocalizationTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<LocalizationTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LocalizationTable, String> uuid_ = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LocalizationTable, Long> originalEntityId =
		createColumn(
			"originalEntityId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LocalizationTable, Long> entityResourceId =
		createColumn(
			"entityResourceId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LocalizationTable, String> workflowBatchId =
		createColumn(
			"workflowBatchId", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<LocalizationTable, Long> globalVersion = createColumn(
		"globalVersion", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LocalizationTable, Long> importRequestId = createColumn(
		"importRequestId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private LocalizationTable() {
		super("LOCALIZATION", LocalizationTable::new);
	}

}