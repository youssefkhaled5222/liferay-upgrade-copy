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
 * The table class for the &quot;BLOCKS&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Blocks
 * @generated
 */
public class BlocksTable extends BaseTable<BlocksTable> {

	public static final BlocksTable INSTANCE = new BlocksTable();

	public final Column<BlocksTable, Long> blockId = createColumn(
		"blockId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<BlocksTable, Long> channelId = createColumn(
		"channelId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BlocksTable, String> type = createColumn(
		"type", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BlocksTable, Boolean> androidBlock = createColumn(
		"androidBlock", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<BlocksTable, String> androidBlockVersion = createColumn(
		"androidBlockVersion", String.class, Types.VARCHAR,
		Column.FLAG_DEFAULT);
	public final Column<BlocksTable, Date> androidBlockFrom = createColumn(
		"androidBlockFrom", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BlocksTable, Date> androidBlockTo = createColumn(
		"androidBlockTo", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BlocksTable, Boolean> iosBlock = createColumn(
		"iosBlock", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<BlocksTable, String> iosBlockVersion = createColumn(
		"iosBlockVersion", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BlocksTable, Date> iosBlockFrom = createColumn(
		"iosBlockFrom", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BlocksTable, Date> iosBlockTo = createColumn(
		"iosBlockTo", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BlocksTable, Boolean> webBlock = createColumn(
		"webBlock", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<BlocksTable, String> webBlockVersion = createColumn(
		"webBlockVersion", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BlocksTable, Date> webBlockFrom = createColumn(
		"webBlockFrom", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BlocksTable, Date> webBlockTo = createColumn(
		"webBlockTo", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private BlocksTable() {
		super("BLOCKS", BlocksTable::new);
	}

}