package com.ejada.telemoney.db.dto.importDtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangeLogDTO implements Serializable {
    private String summary;
    private LocalDateTime exportedAt;
    private ExportedBy exportedBy;

    @Data
    public static class ExportedBy {
        private Long userId;
        private String userName;
    }
}
