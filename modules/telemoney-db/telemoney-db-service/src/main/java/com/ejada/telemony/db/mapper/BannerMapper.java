package com.ejada.telemony.db.mapper;

import com.ejada.telemony.db.model.Banner;

public class BannerMapper {

    public static void copyDraftToOriginal(Banner source, Banner target) {

        // Business fields
        target.setChannelId(source.getChannelId());
        target.setBannerName(source.getBannerName());
        target.setBannerType(source.getBannerType());
        target.setContainer(source.getContainer());
        target.setDateFrom(source.getDateFrom());
        target.setDateTo(source.getDateTo());
        target.setPersona(source.getPersona());
        target.setBlockId(source.getBlockId());

        // Liferay base fields
        target.setGroupId(source.getGroupId());
        target.setCompanyId(source.getCompanyId());
        target.setUserId(source.getUserId());
        target.setUserName(source.getUserName());
        target.setCreateDate(source.getCreateDate());
        target.setModifiedDate(source.getModifiedDate());

        // Workflow / status fields
        target.setStatus(source.getStatus());
        target.setStatusByUserId(source.getStatusByUserId());
        target.setStatusByUserName(source.getStatusByUserName());
        target.setStatusDate(source.getStatusDate());
    }
}
