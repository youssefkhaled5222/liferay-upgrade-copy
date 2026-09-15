package com.ejada.telemoney.db.dto.importDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImportResultDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private ChangeLogDTO changeLog;
    private MetadataDTO metadata;
    private List<ComponentEntryDto> components;
    private transient Map<String, byte[]> attachmentFiles = new HashMap<>();

    public ImportResultDTO(ChangeLogDTO changeLog, MetadataDTO metadata, List<ComponentEntryDto> components) {
        this.changeLog = changeLog;
        this.metadata = metadata;
        this.components = components;
        this.attachmentFiles = new HashMap<>();
    }
}

