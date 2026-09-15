package com.ejada.telemony.db.asset;

import com.ejada.telemony.db.model.AppEnvironment;
import com.ejada.telemony.db.service.AppConfigItemLocalService;
import com.ejada.telemony.db.service.AppEnvironmentLocalService;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=com_ejada_telemoney_app_config_TelemoneyAppConfigPortlet",
		"search.class.name=com.ejada.telemony.db.model.AppEnvironment"
	},
	service = AssetRendererFactory.class
)
public class AppEnvironmentAssetRendererFactory
	extends BaseAssetRendererFactory<AppEnvironment> {

	@Reference
	private AppConfigItemLocalService _appConfigItemLocalService;

	@Reference
	private AppEnvironmentLocalService _appEnvironmentLocalService;

	public AppEnvironmentAssetRendererFactory() {
		setClassName(AppEnvironment.class.getName());
		setCategorizable(false);
		setLinkable(true);
		setPortletId("com_ejada_telemoney_app_config_TelemoneyAppConfigPortlet");
		setSearchable(true);
		setSelectable(true);
	}

	@Override
	public AssetRenderer<AppEnvironment> getAssetRenderer(
			long classPK, int type)
		throws PortalException {

		try {
			AppEnvironment appEnvironment =
				_appEnvironmentLocalService.getAppEnvironment(classPK);

			return new AppEnvironmentAssetRenderer(
				appEnvironment, _appConfigItemLocalService,
				_appEnvironmentLocalService);
		}
		catch (PortalException portalException) {
			return new DeletedAppEnvironmentAssetRenderer(classPK);
		}
	}

	@Override
	public String getType() {
		return "appenvironment";
	}

}
