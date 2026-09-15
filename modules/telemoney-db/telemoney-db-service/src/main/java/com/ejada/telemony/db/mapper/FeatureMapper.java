package com.ejada.telemony.db.mapper;

import com.ejada.telemony.db.model.Feature;

public class FeatureMapper {
    public static void copyDraftToOriginal(Feature source, Feature target)
    {
        target.setFeatureName(source.getFeatureName());
        target.setPageType(source.getPageType());
        target.setFeatureStatus(source.getFeatureStatus());
        target.setParentPage(source.getParentPage());
        target.setRouteId(source.getRouteId());
        target.setBlockId(source.getBlockId());
        target.setChannelId(source.getChannelId());
    }
}
