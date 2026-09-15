package com.ejada.telemony.db.asset;

import com.ejada.telemony.db.model.Lovs;
import com.ejada.telemony.db.service.ChannelsLocalService;
import com.ejada.telemony.db.service.LanguagesLocalService;
import com.ejada.telemony.db.service.LovDataLocalService;
import com.ejada.telemony.db.service.LovsLocalService;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=com_ejada_telemoney_lovs_TelemoneyLovsPortlet",
                "search.class.name=com.ejada.telemony.db.model.Lovs"
        },
        service = AssetRendererFactory.class
)
public class LovsAssetRendererFactory extends BaseAssetRendererFactory<Lovs> {

    @Reference
    private LovsLocalService lovsLocalService;

    @Reference
    private LovDataLocalService lovDataLocalService;

    @Reference
    private ChannelsLocalService channelsLocalService;

    @Reference
    private LanguagesLocalService languagesLocalService;

    public LovsAssetRendererFactory() {
        setClassName(Lovs.class.getName());
        setCategorizable(false);
        setLinkable(true);
        setPortletId("com_ejada_telemoney_lovs_TelemoneyLovsPortlet");
        setSearchable(true);
        setSelectable(true);
    }

    @Override
    public AssetRenderer<Lovs> getAssetRenderer(long classPK, int type) {
        Lovs lovs = lovsLocalService.fetchLovs(classPK);

        return new LovsAssetRenderer(lovs,
                classPK,
                lovsLocalService,
                lovDataLocalService,
                channelsLocalService,
                languagesLocalService);
    }

    @Override
    public String getType() {
        return "Lovs";
    }
}

