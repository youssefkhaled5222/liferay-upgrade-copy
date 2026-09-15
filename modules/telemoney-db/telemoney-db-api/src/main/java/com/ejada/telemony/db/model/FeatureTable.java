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
 * The table class for the &quot;FEATURE&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Feature
 * @generated
 */
public class FeatureTable extends BaseTable<FeatureTable> {

	public static final FeatureTable INSTANCE = new FeatureTable();

	public final Column<FeatureTable, Long> featureId = createColumn(
		"featureId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<FeatureTable, String> featureName = createColumn(
		"featureName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FeatureTable, String> pageType = createColumn(
		"pageType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FeatureTable, Long> parentPage = createColumn(
		"parentPage", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FeatureTable, String> routeId = createColumn(
		"routeId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FeatureTable, Boolean> featureStatus = createColumn(
		"featureStatus", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<FeatureTable, Long> blockId = createColumn(
		"blockId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FeatureTable, Long> channelId = createColumn(
		"channelId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FeatureTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FeatureTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FeatureTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FeatureTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FeatureTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FeatureTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FeatureTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<FeatureTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FeatureTable, String> statusByUserName = createColumn(
		"statusByUserName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FeatureTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FeatureTable, String> uuid_ = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FeatureTable, Long> originalEntityId = createColumn(
		"originalEntityId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FeatureTable, Long> entityResourceId = createColumn(
		"entityResourceId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FeatureTable, Long> childResourceId = createColumn(
		"childResourceId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FeatureTable, Integer> version = createColumn(
		"version", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<FeatureTable, String> workflowAction = createColumn(
		"workflowAction", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private FeatureTable() {
		super("FEATURE", FeatureTable::new);
	}

}