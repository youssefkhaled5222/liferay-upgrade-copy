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
 * The table class for the &quot;LOVS&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Lovs
 * @generated
 */
public class LovsTable extends BaseTable<LovsTable> {

	public static final LovsTable INSTANCE = new LovsTable();

	public final Column<LovsTable, String> defaultLanguageId = createColumn(
		"defaultLanguageId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LovsTable, Long> id = createColumn(
		"id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<LovsTable, String> code = createColumn(
		"code", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LovsTable, Long> channelId = createColumn(
		"channelId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LovsTable, String> eventCode = createColumn(
		"eventCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LovsTable, Integer> count = createColumn(
		"count", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<LovsTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LovsTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LovsTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LovsTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LovsTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LovsTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LovsTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<LovsTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LovsTable, String> statusByUserName = createColumn(
		"statusByUserName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LovsTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LovsTable, String> uuid_ = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LovsTable, Long> originalEntityId = createColumn(
		"originalEntityId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LovsTable, Long> entityResourceId = createColumn(
		"entityResourceId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LovsTable, Integer> version = createColumn(
		"version", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<LovsTable, String> workflowAction = createColumn(
		"workflowAction", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private LovsTable() {
		super("LOVS", LovsTable::new);
	}

}