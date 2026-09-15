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
 * The table class for the &quot;USER_LOGS&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see UserLogs
 * @generated
 */
public class UserLogsTable extends BaseTable<UserLogsTable> {

	public static final UserLogsTable INSTANCE = new UserLogsTable();

	public final Column<UserLogsTable, Long> logsId = createColumn(
		"logsId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<UserLogsTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UserLogsTable, String> userActivity = createColumn(
		"userActivity", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UserLogsTable, Date> logTime = createColumn(
		"logTime", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<UserLogsTable, Long> channelId = createColumn(
		"channelId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private UserLogsTable() {
		super("USER_LOGS", UserLogsTable::new);
	}

}