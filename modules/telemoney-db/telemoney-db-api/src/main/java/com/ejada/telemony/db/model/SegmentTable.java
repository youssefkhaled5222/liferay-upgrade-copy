/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;SEGMENT&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Segment
 * @generated
 */
public class SegmentTable extends BaseTable<SegmentTable> {

	public static final SegmentTable INSTANCE = new SegmentTable();

	public final Column<SegmentTable, Long> segmentId = createColumn(
		"segmentId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<SegmentTable, Long> featureId = createColumn(
		"featureId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SegmentTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SegmentTable, Boolean> segmentStatus = createColumn(
		"segmentStatus", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<SegmentTable, String> method = createColumn(
		"method", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SegmentTable, String> popUpTitle = createColumn(
		"popUpTitle", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SegmentTable, String> popUpSubTitle = createColumn(
		"popUpSubTitle", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SegmentTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<SegmentTable, Long> originalEntityId = createColumn(
		"originalEntityId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SegmentTable, Long> entityResourceId = createColumn(
		"entityResourceId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SegmentTable, Long> childResourceId = createColumn(
		"childResourceId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private SegmentTable() {
		super("SEGMENT", SegmentTable::new);
	}

}