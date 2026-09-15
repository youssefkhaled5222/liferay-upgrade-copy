package com.ejada.telemoney.db.dto.importDtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourceImportDTO {

    private ResourceData data;

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ResourceData {
        private String resourceCode;
        private String resourceType;
        private String urlType;
        private String defaultLanguageId;
        private long selectedFeatureId;
        private Map<String, LocalizationData> localizations;
    }

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class LocalizationData {
        private String languageId;
        private String name;
        private String attach;
        private String attachName;
        private String description;
        private String routeId;
        private String url;
    }
}
