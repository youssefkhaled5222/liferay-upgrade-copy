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
 * The table class for the &quot;AppVersion&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see AppVersion
 * @generated
 */
public class AppVersionTable extends BaseTable<AppVersionTable> {

	public static final AppVersionTable INSTANCE = new AppVersionTable();

	public final Column<AppVersionTable, Long> versionId = createColumn(
		"versionId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AppVersionTable, Long> channelId = createColumn(
		"channelId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppVersionTable, String> platform = createColumn(
		"platform", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AppVersionTable, String> versionNumber = createColumn(
		"versionNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AppVersionTable, String> url = createColumn(
		"url", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AppVersionTable, Boolean> appVersionStatus =
		createColumn(
			"appVersionStatus", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<AppVersionTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppVersionTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppVersionTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppVersionTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AppVersionTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AppVersionTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AppVersionTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<AppVersionTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppVersionTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<AppVersionTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AppVersionTable, String> uuid_ = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AppVersionTable, Long> originalEntityId = createColumn(
		"originalEntityId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppVersionTable, Long> entityResourceId = createColumn(
		"entityResourceId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppVersionTable, Integer> version = createColumn(
		"version", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<AppVersionTable, String> workflowAction = createColumn(
		"workflowAction", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private AppVersionTable() {
		super("AppVersion", AppVersionTable::new);
	}

}