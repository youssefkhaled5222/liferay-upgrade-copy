package com.ejada.telemony.db.mapper;

import com.ejada.telemony.db.model.Segment;

public class SegmentMapper {

    public static void copyDraftToOriginal(Segment source, Segment target)
    {
        target.setName(source.getName());
        target.setSegmentStatus(source.getSegmentStatus());
        target.setMethod(source.getMethod());
        target.setPopUpTitle(source.getPopUpTitle());
        target.setPopUpSubTitle(source.getPopUpSubTitle());
    }
}
