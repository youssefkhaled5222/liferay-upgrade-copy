package com.ejada.telemoney.db.dto.importDtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BannerImportDTO {

    private BannerData data;

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BannerData {
        private String bannerName;
        private String bannerType;
        private String container;
        private String dateFrom;
        private String dateTo;
        private String[] selectedPersonaIds;

        private BlockData block;
        private List<BannerContentData> bannerContents;
    }

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BlockData {
        private String type;

        private boolean androidBlock;
        private String androidBlockVersion;
        private String androidBlockFrom;
        private String androidBlockTo;

        private boolean iosBlock;
        private String iosBlockVersion;
        private String iosBlockFrom;
        private String iosBlockTo;

        private boolean webBlock;
        private String webBlockVersion;
        private String webBlockFrom;
        private String webBlockTo;
    }

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BannerContentData {
        private String contentName;
        private int contentOrder;
        private String defaultLanguageId;
        private String contentStatus;

        private List<LocalizationData> localizations;
    }

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class LocalizationData {
        private String languageId;
        private String titleValue;
        private String descriptionValue;
        private String bannerImage;
        private String imageOverlay;
        private String linkType;
        private String url;
    }
}

