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
 * The table class for the &quot;AppEnvironment&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see AppEnvironment
 * @generated
 */
public class AppEnvironmentTable extends BaseTable<AppEnvironmentTable> {

	public static final AppEnvironmentTable INSTANCE =
		new AppEnvironmentTable();

	public final Column<AppEnvironmentTable, Long> environmentId = createColumn(
		"environmentId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AppEnvironmentTable, Long> channelId = createColumn(
		"channelId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppEnvironmentTable, String> environmentName =
		createColumn(
			"environmentName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<AppEnvironmentTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppEnvironmentTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppEnvironmentTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppEnvironmentTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AppEnvironmentTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AppEnvironmentTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AppEnvironmentTable, Long> statusByUserId =
		createColumn(
			"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppEnvironmentTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<AppEnvironmentTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<AppEnvironmentTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AppEnvironmentTable, String> uuid_ = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AppEnvironmentTable, Long> originalEntityId =
		createColumn(
			"originalEntityId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppEnvironmentTable, Long> entityResourceId =
		createColumn(
			"entityResourceId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppEnvironmentTable, Integer> version = createColumn(
		"version", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<AppEnvironmentTable, String> workflowAction =
		createColumn(
			"workflowAction", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private AppEnvironmentTable() {
		super("AppEnvironment", AppEnvironmentTable::new);
	}

}