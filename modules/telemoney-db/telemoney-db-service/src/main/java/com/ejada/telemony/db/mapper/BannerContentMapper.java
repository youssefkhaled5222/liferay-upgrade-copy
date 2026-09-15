package com.ejada.telemony.db.mapper;

import com.ejada.telemony.db.model.BannerContent;
import com.ejada.telemony.db.model.BannerContentLocalization;
import com.liferay.portal.kernel.util.Validator;

public class BannerContentMapper {

    public static void copyDraftToOriginal(BannerContent source, BannerContent target) {
        target.setContentName(source.getContentName());
        target.setContentOrder(source.getContentOrder());
        target.setContentStatus(source.getContentStatus());
        target.setChannelId(source.getChannelId());
        target.setDefaultLanguageId(source.getDefaultLanguageId());
    }

    public static void copyDraftLocalizationToOriginal(BannerContentLocalization source, BannerContentLocalization target) {
        target.setTitleValue(source.getTitleValue());
        target.setDescriptionValue(source.getDescriptionValue());
        if (Validator.isNotNull(source.getBannerImage())) {
            target.setBannerImage(source.getBannerImage());
        }
        target.setImageOverlay(source.getImageOverlay());
        target.setLinkType(source.getLinkType());
        target.setUrl(source.getUrl());
    }

    public static void copyToTemp(BannerContent source, BannerContent target)
    {
        copyDraftToOriginal(source, target);
        target.setBannerId(source.getBannerId());
        target.setStatus(source.getStatus());
        target.setOriginalEntityId(source.getOriginalEntityId());


    }

}
