package com.ejada.telemony.db.mapper;


import com.ejada.telemony.db.model.Blocks;

public class BlocksMapper {

    public static void copyDraftToOriginal(Blocks source, Blocks target) {


        target.setChannelId(source.getChannelId());
        target.setType(source.getType());

        // Android
        target.setAndroidBlock(source.isAndroidBlock());
        target.setAndroidBlockVersion(source.getAndroidBlockVersion());
        target.setAndroidBlockFrom(source.getAndroidBlockFrom());
        target.setAndroidBlockTo(source.getAndroidBlockTo());

        // iOS
        target.setIosBlock(source.isIosBlock());
        target.setIosBlockVersion(source.getIosBlockVersion());
        target.setIosBlockFrom(source.getIosBlockFrom());
        target.setIosBlockTo(source.getIosBlockTo());

        // Web
        target.setWebBlock(source.isWebBlock());
        target.setWebBlockVersion(source.getWebBlockVersion());
        target.setWebBlockFrom(source.getWebBlockFrom());
        target.setWebBlockTo(source.getWebBlockTo());
    }

}
