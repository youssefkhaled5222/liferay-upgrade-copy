package com.ejada.telemony.db.mapper;

import com.ejada.telemony.db.model.Lovs;
import com.ejada.telemony.db.model.LovsLocalization;

public class LovMapper {


    public static void copyOriginalDataToDraft(Lovs source, Lovs target) {
        target.setChannelId(source.getChannelId());
        target.setCode(source.getCode());
        target.setDefaultLanguageId(source.getDefaultLanguageId());
        target.setEventCode(source.getEventCode());
    }


    public static void copyOriginalLocalizationToDraft(LovsLocalization source, LovsLocalization target) {
        target.setName(source.getName());
    }
}
