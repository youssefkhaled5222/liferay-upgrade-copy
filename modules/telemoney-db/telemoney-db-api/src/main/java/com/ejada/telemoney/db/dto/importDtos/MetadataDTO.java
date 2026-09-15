package com.ejada.telemoney.db.dto.importDtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetadataDTO implements Serializable {
    private String packageId;
    private String checksum;
    private Component component;

    @Data
    public static class Component {
        private String type;
        private Long count;
    }
}
