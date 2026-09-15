package com.ejada.telemony.db.asset;

import com.ejada.telemony.db.model.Feature;
import com.ejada.telemony.db.service.BlocksLocalService;
import com.ejada.telemony.db.service.ChannelsLocalService;
import com.ejada.telemony.db.service.FeatureLocalService;
import com.ejada.telemony.db.service.FeatureLovMapLocalService;
import com.ejada.telemony.db.service.SegmentLocalService;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=com_ejada_telemoney_feature_toggling_TelemoneyFeatureTogglingPortlet",
                "search.class.name=com.ejada.telemony.db.model.Feature"
        },
        service = AssetRendererFactory.class
)
public class FeatureAssetRendererFactory extends BaseAssetRendererFactory<Feature> {

    @Reference
    private FeatureLocalService featureLocalService;

    @Reference
    private SegmentLocalService segmentLocalService;

    @Reference
    private ChannelsLocalService channelsLocalService;

    @Reference
    private BlocksLocalService blocksLocalService;

    @Reference
    private FeatureLovMapLocalService featureLovMapLocalService;

    public FeatureAssetRendererFactory() {
        setClassName(Feature.class.getName());
        setCategorizable(false);
        setLinkable(true);
        setPortletId("com_ejada_telemoney_feature_toggling_TelemoneyFeatureTogglingPortlet");
        setSearchable(true);
        setSelectable(true);
    }

    @Override
    public AssetRenderer<Feature> getAssetRenderer(long classPK, int type) {
        Feature feature = featureLocalService.fetchFeature(classPK);

        return new FeatureAssetRenderer(feature,
                classPK,
                featureLocalService,
                segmentLocalService,
                channelsLocalService,
                blocksLocalService,
                featureLovMapLocalService);
    }

    @Override
    public String getType() {
        return "Feature";
    }
}

