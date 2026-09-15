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
 * The table class for the &quot;PERSONA&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Persona
 * @generated
 */
public class PersonaTable extends BaseTable<PersonaTable> {

	public static final PersonaTable INSTANCE = new PersonaTable();

	public final Column<PersonaTable, Long> personaId = createColumn(
		"personaId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PersonaTable, Long> channelId = createColumn(
		"channelId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PersonaTable, Long> darkThemeId = createColumn(
		"darkThemeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PersonaTable, Long> lightThemeId = createColumn(
		"lightThemeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PersonaTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PersonaTable, Integer> startAge = createColumn(
		"startAge", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<PersonaTable, Integer> endAge = createColumn(
		"endAge", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<PersonaTable, String> nationality = createColumn(
		"nationality", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PersonaTable, String> customerSegment = createColumn(
		"customerSegment", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PersonaTable, String> personaStatus = createColumn(
		"personaStatus", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PersonaTable, String> sector = createColumn(
		"sector", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PersonaTable, Integer> minIncome = createColumn(
		"minIncome", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<PersonaTable, Integer> maxIncome = createColumn(
		"maxIncome", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<PersonaTable, String> description = createColumn(
		"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PersonaTable, String> gender = createColumn(
		"gender", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PersonaTable, Integer> priority = createColumn(
		"priority", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<PersonaTable, Date> dateFrom = createColumn(
		"dateFrom", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PersonaTable, Date> dateTo = createColumn(
		"dateTo", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PersonaTable, Boolean> defaultPersona = createColumn(
		"defaultPersona", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<PersonaTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PersonaTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PersonaTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PersonaTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PersonaTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PersonaTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PersonaTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<PersonaTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PersonaTable, String> statusByUserName = createColumn(
		"statusByUserName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PersonaTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PersonaTable, String> uuid_ = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PersonaTable, Long> originalEntityId = createColumn(
		"originalEntityId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PersonaTable, Long> entityResourceId = createColumn(
		"entityResourceId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PersonaTable, Integer> version = createColumn(
		"version", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<PersonaTable, String> workflowAction = createColumn(
		"workflowAction", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private PersonaTable() {
		super("PERSONA", PersonaTable::new);
	}

}