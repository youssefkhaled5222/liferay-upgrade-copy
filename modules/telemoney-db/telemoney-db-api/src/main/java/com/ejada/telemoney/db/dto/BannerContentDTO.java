package com.ejada.telemoney.db.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BannerContentDTO implements Serializable {

    private Long contentId;
    private String contentName;
    private int contentOrder;
    private Long bannerId;
    private String contentStatus;
    private Long channelId;
    private int status;
    private Long originalEntityId;

    // 🔹 Localized fields (languageId → value)
    private Map<String, String> titleValues;
    private Map<String, String> descriptionValues;
    private Map<String, String> bannerImages;
    private Map<String, String> imageOverlays;
    private Map<String, String> links;
    private Map<String, String> urls;
}
