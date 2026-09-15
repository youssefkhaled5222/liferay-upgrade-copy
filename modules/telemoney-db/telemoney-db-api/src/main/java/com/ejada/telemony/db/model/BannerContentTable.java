/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;BANNER_CONTENT&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see BannerContent
 * @generated
 */
public class BannerContentTable extends BaseTable<BannerContentTable> {

	public static final BannerContentTable INSTANCE = new BannerContentTable();

	public final Column<BannerContentTable, String> defaultLanguageId =
		createColumn(
			"defaultLanguageId", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<BannerContentTable, Long> contentId = createColumn(
		"contentId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<BannerContentTable, String> contentName = createColumn(
		"contentName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BannerContentTable, Integer> contentOrder =
		createColumn(
			"contentOrder", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<BannerContentTable, Long> bannerId = createColumn(
		"bannerId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BannerContentTable, String> contentStatus =
		createColumn(
			"contentStatus", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BannerContentTable, Long> channelId = createColumn(
		"channelId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BannerContentTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<BannerContentTable, Long> originalEntityId =
		createColumn(
			"originalEntityId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BannerContentTable, Long> entityResourceId =
		createColumn(
			"entityResourceId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private BannerContentTable() {
		super("BANNER_CONTENT", BannerContentTable::new);
	}

}