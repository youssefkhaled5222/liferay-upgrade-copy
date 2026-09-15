package com.ejada.telemony.db.service.upgrade;

import com.ejada.telemony.db.model.impl.AppEnvironmentModelImpl;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

public class AppEnvironmentUpgradeProcess extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		if (!hasTable(AppEnvironmentModelImpl.TABLE_NAME)) {
			runSQL(AppEnvironmentModelImpl.TABLE_SQL_CREATE);
			runSQL(
				"create index IX_AppEnvironment_channelId on AppEnvironment (channelId)");
			runSQL(
				"create index IX_AppEnvironment_entityResourceId on AppEnvironment (entityResourceId)");
			runSQL(
				"create index IX_AppEnvironment_channelId_status on AppEnvironment (channelId, status)");
		}

		if (!hasColumn("AppEnvironment", "environmentName")) {
			alterTableAddColumn("AppEnvironment", "environmentName", "VARCHAR(75) null");
		}
	}

}
