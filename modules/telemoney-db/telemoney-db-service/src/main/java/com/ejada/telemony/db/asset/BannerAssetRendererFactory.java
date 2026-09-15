package com.ejada.telemony.db.asset;

import com.ejada.telemony.db.model.Banner;
import com.ejada.telemony.db.service.BannerContentLocalService;
import com.ejada.telemony.db.service.BannerLocalService;
import com.ejada.telemony.db.service.BlocksLocalService;
import com.ejada.telemony.db.service.ChannelsLocalService;
import com.ejada.telemony.db.service.FeatureLocalService;
import com.ejada.telemony.db.service.PersonaLocalService;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(
        immediate = true,
        property = {
                "javax.portlet.name=com_ejada_telemoney_banners_TelemoneyBannersPortlet",
                "search.class.name=com.ejada.telemony.db.model.Banner"
        },
        service = AssetRendererFactory.class
)
public class BannerAssetRendererFactory
        extends BaseAssetRendererFactory<Banner> {

    @Reference
    private BannerLocalService bannerLocalService;
    @Reference
    private BannerLocalService bannerService;
    @Reference
    private BannerContentLocalService bannerContentLocalService;
    @Reference
    private BlocksLocalService blocksLocalService;
    @Reference
    private PersonaLocalService personaLocalService;
    @Reference
    private FeatureLocalService featureLocalService;
    @Reference
    private ChannelsLocalService channelsLocalService;

    public BannerAssetRendererFactory() {
        setClassName(Banner.class.getName());
        setCategorizable(false);
        setLinkable(true);
        setPortletId("com_ejada_telemoney_banners_TelemoneyBannersPortlet");
        setSearchable(true);
        setSelectable(true);
    }

    @Override
    public AssetRenderer<Banner> getAssetRenderer(
            long classPK, int type) {

        Banner banner = bannerLocalService.fetchBanner(classPK);

        return new BannerAssetRenderer(banner,
                classPK,
                bannerService,
                bannerContentLocalService,
                blocksLocalService,
                personaLocalService,
                featureLocalService,
                channelsLocalService);
    }

    @Override
    public String getType() {
        return "Banner";
    }
}

