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
 * The table class for the &quot;Resource&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Resource
 * @generated
 */
public class ResourceTable extends BaseTable<ResourceTable> {

	public static final ResourceTable INSTANCE = new ResourceTable();

	public final Column<ResourceTable, String> defaultLanguageId = createColumn(
		"defaultLanguageId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ResourceTable, Long> resourceId = createColumn(
		"resourceId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ResourceTable, Long> channelId = createColumn(
		"channelId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ResourceTable, String> resourceCode = createColumn(
		"resourceCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ResourceTable, String> resourceType = createColumn(
		"resourceType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ResourceTable, String> urlType = createColumn(
		"urlType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ResourceTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ResourceTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ResourceTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ResourceTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ResourceTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ResourceTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ResourceTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ResourceTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ResourceTable, String> statusByUserName = createColumn(
		"statusByUserName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ResourceTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ResourceTable, String> uuid_ = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ResourceTable, Long> originalEntityId = createColumn(
		"originalEntityId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ResourceTable, Long> entityResourceId = createColumn(
		"entityResourceId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ResourceTable, Integer> version = createColumn(
		"version", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ResourceTable, String> workflowAction = createColumn(
		"workflowAction", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ResourceTable, Long> featureId = createColumn(
		"featureId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private ResourceTable() {
		super("Resource", ResourceTable::new);
	}

}