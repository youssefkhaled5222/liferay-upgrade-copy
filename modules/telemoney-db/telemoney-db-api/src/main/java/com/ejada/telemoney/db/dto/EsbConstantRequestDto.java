package com.ejada.telemoney.db.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EsbConstantRequestDto implements Serializable {
    private String sanitizedServiceName;
    private String serviceName;
    private String funcId;
    private String ip;
    private String port;
    private String path;
    private String scId;
    private String branchId;
    private String branchName;
    private String userId;
    private String agentId;
    private String secInfo;
    private String secInfoType;
    private String version;

}
