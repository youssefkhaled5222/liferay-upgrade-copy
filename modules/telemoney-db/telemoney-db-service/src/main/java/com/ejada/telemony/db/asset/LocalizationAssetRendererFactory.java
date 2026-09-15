package com.ejada.telemony.db.asset;

import com.ejada.telemony.db.model.Localization;
import com.ejada.telemony.db.service.LocalizationLocalService;
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
                "javax.portlet.name=com_ejada_telemoney_localization_TelemoneyLocalizationPortlet"
        },
        service = AssetRendererFactory.class
)
public class LocalizationAssetRendererFactory extends BaseAssetRendererFactory<Localization> {

    private static final Log LOG = LogFactoryUtil.getLog(LocalizationAssetRendererFactory.class);

    @Reference
    private LocalizationLocalService localizationLocalService;

    public LocalizationAssetRendererFactory() {
        setClassName(Localization.class.getName());
        setCategorizable(false);
        setLinkable(true);
        setPortletId("com_ejada_telemoney_localization_TelemoneyLocalizationPortlet");
        setSearchable(true);
        setSelectable(true);
    }

    @Override
    public AssetRenderer<Localization> getAssetRenderer(long classPK, int type) throws PortalException {
        try {
            Localization localization = localizationLocalService.getLocalization(classPK);
            return new LocalizationAssetRenderer(localization, localizationLocalService);
        } catch (PortalException e) {
            return new DeletedLocalizationAssetRenderer(classPK);
        }
    }

    @Override
    public String getType() {
        return "Localization";
    }
}

