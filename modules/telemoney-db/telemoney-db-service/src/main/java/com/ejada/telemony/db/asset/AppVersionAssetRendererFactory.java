package com.ejada.telemony.db.asset;

import com.ejada.telemony.db.model.AppVersion;
import com.ejada.telemony.db.service.AppVersionLocalService;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=com_ejada_telemoney_app_version_TelemoneyAppVersionPortlet",
                "search.class.name=com.ejada.telemony.db.model.AppVersion"
        },
        service = AssetRendererFactory.class
)
public class AppVersionAssetRendererFactory extends BaseAssetRendererFactory<AppVersion> {

    private static final Log LOG = LogFactoryUtil.getLog(AppVersionAssetRendererFactory.class);

    @Reference
    private AppVersionLocalService appVersionLocalService;

    public AppVersionAssetRendererFactory() {
        setClassName(AppVersion.class.getName());
        setCategorizable(false);
        setLinkable(true);
        setPortletId("com_ejada_telemoney_app_version_TelemoneyAppVersionPortlet");
        setSearchable(true);
        setSelectable(true);
    }

    @Override
    public AssetRenderer<AppVersion> getAssetRenderer(long classPK, int type) throws PortalException {
        try {
            AppVersion appVersion = appVersionLocalService.getAppVersion(classPK);
            return new AppVersionAssetRenderer(appVersion, appVersionLocalService);
        } catch (PortalException e) {
            return new DeletedAppVersionAssetRenderer(classPK);
        }
    }

    @Override
    public String getType() {
        return "appversion";
    }
}

