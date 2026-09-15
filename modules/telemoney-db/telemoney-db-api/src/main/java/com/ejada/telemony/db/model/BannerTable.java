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
 * The table class for the &quot;BANNER&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Banner
 * @generated
 */
public class BannerTable extends BaseTable<BannerTable> {

	public static final BannerTable INSTANCE = new BannerTable();

	public final Column<BannerTable, Long> bannerId = createColumn(
		"bannerId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<BannerTable, Long> channelId = createColumn(
		"channelId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BannerTable, String> bannerName = createColumn(
		"bannerName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BannerTable, String> bannerType = createColumn(
		"bannerType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BannerTable, String> container = createColumn(
		"container", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BannerTable, Date> dateFrom = createColumn(
		"dateFrom", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BannerTable, Date> dateTo = createColumn(
		"dateTo", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BannerTable, Long> blockId = createColumn(
		"blockId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BannerTable, String> persona = createColumn(
		"persona", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BannerTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BannerTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BannerTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BannerTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BannerTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BannerTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BannerTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<BannerTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BannerTable, String> statusByUserName = createColumn(
		"statusByUserName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BannerTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BannerTable, String> uuid_ = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BannerTable, Long> originalEntityId = createColumn(
		"originalEntityId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BannerTable, Long> entityResourceId = createColumn(
		"entityResourceId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BannerTable, Integer> version = createColumn(
		"version", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<BannerTable, String> workflowAction = createColumn(
		"workflowAction", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BannerTable, Long> importRequestId = createColumn(
		"importRequestId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private BannerTable() {
		super("BANNER", BannerTable::new);
	}

}