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
 * The table class for the &quot;ConfigurationEntity&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ConfigurationEntity
 * @generated
 */
public class ConfigurationEntityTable
	extends BaseTable<ConfigurationEntityTable> {

	public static final ConfigurationEntityTable INSTANCE =
		new ConfigurationEntityTable();

	public final Column<ConfigurationEntityTable, Long> id = createColumn(
		"id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ConfigurationEntityTable, String> url = createColumn(
		"url", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ConfigurationEntityTable, String> oldData =
		createColumn(
			"oldData", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ConfigurationEntityTable, String> newData =
		createColumn(
			"newData", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ConfigurationEntityTable, String> entityType =
		createColumn(
			"entityType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ConfigurationEntityTable, String> entityId =
		createColumn(
			"entityId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ConfigurationEntityTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ConfigurationEntityTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ConfigurationEntityTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ConfigurationEntityTable, String> userName =
		createColumn(
			"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ConfigurationEntityTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ConfigurationEntityTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ConfigurationEntityTable, Integer> status =
		createColumn(
			"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ConfigurationEntityTable, Long> statusByUserId =
		createColumn(
			"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ConfigurationEntityTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ConfigurationEntityTable, Date> statusDate =
		createColumn(
			"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ConfigurationEntityTable, String> uuid_ = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ConfigurationEntityTable, String> workflowAction =
		createColumn(
			"workflowAction", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ConfigurationEntityTable() {
		super("ConfigurationEntity", ConfigurationEntityTable::new);
	}

}