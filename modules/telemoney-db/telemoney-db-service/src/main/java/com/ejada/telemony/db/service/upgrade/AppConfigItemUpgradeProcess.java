package com.ejada.telemony.db.service.upgrade;

import com.ejada.telemony.db.model.impl.AppConfigItemModelImpl;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

public class AppConfigItemUpgradeProcess extends UpgradeProcess {

	public AppConfigItemUpgradeProcess(DataSource extDataSource) {
		_extDataSource = extDataSource;
	}

	@Override
	protected void doUpgrade() throws Exception {
		try (Connection extCon = _extDataSource.getConnection()) {
			if (!hasExtTable(extCon, AppConfigItemModelImpl.TABLE_NAME)) {
				runSQL(extCon, AppConfigItemModelImpl.TABLE_SQL_CREATE);
			}
		}
	}

	private boolean hasExtTable(Connection connection, String tableName)
		throws Exception {

		String sql =
			"SELECT 1 FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = ?";

		try (PreparedStatement preparedStatement = connection.prepareStatement(
				sql)) {

			preparedStatement.setString(1, tableName);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				return resultSet.next();
			}
		}
	}

	private final DataSource _extDataSource;

}
