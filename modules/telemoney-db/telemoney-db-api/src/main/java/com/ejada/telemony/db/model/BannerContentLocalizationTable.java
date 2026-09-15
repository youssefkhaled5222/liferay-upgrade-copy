/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;BannerContentLocalization&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see BannerContentLocalization
 * @generated
 */
public class BannerContentLocalizationTable
	extends BaseTable<BannerContentLocalizationTable> {

	public static final BannerContentLocalizationTable INSTANCE =
		new BannerContentLocalizationTable();

	public final Column<BannerContentLocalizationTable, Long> mvccVersion =
		createColumn(
			"mvccVersion", Long.class, Types.BIGINT, Column.FLAG_NULLITY);
	public final Column<BannerContentLocalizationTable, Long>
		bannerContentLocalizationId = createColumn(
			"bannerContentLocalizationId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<BannerContentLocalizationTable, Long> contentId =
		createColumn(
			"contentId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BannerContentLocalizationTable, String> languageId =
		createColumn(
			"languageId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BannerContentLocalizationTable, String> bannerImage =
		createColumn(
			"bannerImage", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BannerContentLocalizationTable, String> imageOverlay =
		createColumn(
			"imageOverlay", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BannerContentLocalizationTable, String> linkType =
		createColumn(
			"linkType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BannerContentLocalizationTable, String> url =
		createColumn("url", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BannerContentLocalizationTable, String> titleValue =
		createColumn(
			"titleValue", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BannerContentLocalizationTable, String>
		descriptionValue = createColumn(
			"descriptionValue", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	private BannerContentLocalizationTable() {
		super("BannerContentLocalization", BannerContentLocalizationTable::new);
	}

}