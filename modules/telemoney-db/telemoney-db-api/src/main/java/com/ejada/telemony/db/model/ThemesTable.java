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
 * The table class for the &quot;THEMES&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Themes
 * @generated
 */
public class ThemesTable extends BaseTable<ThemesTable> {

	public static final ThemesTable INSTANCE = new ThemesTable();

	public final Column<ThemesTable, Long> themeId = createColumn(
		"themeId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ThemesTable, Long> channelId = createColumn(
		"channelId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ThemesTable, String> themeEnName = createColumn(
		"themeEnName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ThemesTable, String> themeArName = createColumn(
		"themeArName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ThemesTable, Boolean> darkTheme = createColumn(
		"darkTheme", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ThemesTable, String> primaryColors = createColumn(
		"primaryColors", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ThemesTable, String> secondaryColors = createColumn(
		"secondaryColors", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ThemesTable, String> neutralColors = createColumn(
		"neutralColors", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ThemesTable, String> successColors = createColumn(
		"successColors", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ThemesTable, String> errorColors = createColumn(
		"errorColors", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ThemesTable, String> warningColors = createColumn(
		"warningColors", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ThemesTable, String> supportColors = createColumn(
		"supportColors", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ThemesTable, String> gradientColors = createColumn(
		"gradientColors", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ThemesTable, String> splashBg = createColumn(
		"splashBg", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ThemesTable, String> splashAnimation = createColumn(
		"splashAnimation", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ThemesTable, String> headerBg = createColumn(
		"headerBg", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ThemesTable, String> balanceBg = createColumn(
		"balanceBg", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ThemesTable, Boolean> defaultTheme = createColumn(
		"defaultTheme", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ThemesTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ThemesTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ThemesTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ThemesTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ThemesTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ThemesTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ThemesTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ThemesTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ThemesTable, String> statusByUserName = createColumn(
		"statusByUserName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ThemesTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ThemesTable, String> uuid_ = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ThemesTable, Long> originalEntityId = createColumn(
		"originalEntityId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ThemesTable, Long> entityResourceId = createColumn(
		"entityResourceId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ThemesTable, Integer> version = createColumn(
		"version", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ThemesTable, String> workflowAction = createColumn(
		"workflowAction", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ThemesTable, Long> importRequestId = createColumn(
		"importRequestId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private ThemesTable() {
		super("THEMES", ThemesTable::new);
	}

}