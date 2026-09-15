package com.ejada.telemony.db.mapper;

import com.ejada.telemony.db.model.LovData;
import com.ejada.telemony.db.model.LovDataLocalization;

public class LovDataMapper {
    public static void copyOriginalDataToDraft(LovData source, LovData target) {
        if (source != null) {
            if (source.getDefaultLanguageId() != null) {
                target.setDefaultLanguageId(source.getDefaultLanguageId());
            }
            if (source.getLovType() != null) {
                target.setLovType(source.getLovType());
            }
            if (source.getRecordTypeCode() != null) {
                target.setRecordTypeCode(source.getRecordTypeCode());
            }
            if (source.getRecordShortDescription() != null) {
                target.setRecordShortDescription(source.getRecordShortDescription());
            }
        }
    }


    public static void copyOriginalLocalizationToDraft(LovDataLocalization source, LovDataLocalization target) {
        if (source != null) {
            if (source.getLanguageId() != null) {
                target.setLanguageId(source.getLanguageId());
            }
            if (source.getRecordDescription() != null) {
                target.setRecordDescription(source.getRecordDescription());
            }
        }
    }

}
