package com.ejada.telemoney.db.dto.importDtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ThemeDTO {

    private themeData data;

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class themeData {
        private String themeEnName;
        private String themeArName;
        private boolean darkTheme;
        private JsonNode neutralColors;
        private JsonNode primaryColors;
        private JsonNode secondaryColors;
        private JsonNode successColors;
        private JsonNode errorColors;
        private JsonNode warningColors;
        private JsonNode supportColors;
        private JsonNode gradientColors;
        private String splashBg;
        private String splashAnimation;
        private String headerBg;
        private String balanceBg;
        private boolean defaultTheme;

        private static String nodeToString(JsonNode node) {
            if (node == null || node.isNull()) return null;
            if (node.isTextual()) return node.asText();
            return node.toString();
        }

        public String getNeutralColors() { return nodeToString(neutralColors); }
        public String getPrimaryColors() { return nodeToString(primaryColors); }
        public String getSecondaryColors() { return nodeToString(secondaryColors); }
        public String getSuccessColors() { return nodeToString(successColors); }
        public String getErrorColors() { return nodeToString(errorColors); }
        public String getWarningColors() { return nodeToString(warningColors); }
        public String getSupportColors() { return nodeToString(supportColors); }
        public String getGradientColors() { return nodeToString(gradientColors); }
    }

}
