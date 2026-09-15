package com.ejada.telemony.db.service.upgrade;

import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator.Registry;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class AppEnvironmentUpgradeStepRegistrator
	implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		registry.register(
			"1.0.0", "1.0.1", new AppEnvironmentUpgradeProcess());
		registry.register(
			"1.0.1", "1.0.2", new AppEnvironmentUpgradeProcess());
		registry.register(
			"1.0.2", "1.0.3", new AppEnvironmentUpgradeProcess());
		registry.register(
			"1.0.3", "1.0.4", new AppConfigItemUpgradeProcess(_extDataSource));
	}

	@Reference(target = "(bean.id=extDS)")
	private DataSource _extDataSource;

}

