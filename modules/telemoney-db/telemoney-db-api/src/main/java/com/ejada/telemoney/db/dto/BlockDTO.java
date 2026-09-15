package com.ejada.telemoney.db.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlockDTO implements Serializable {

    private long blockId;
    private long channelId;
    private String type;

    private boolean androidBlock;
    private String androidBlockVersion;
    private Date androidBlockFrom;
    private Date androidBlockTo;

    private boolean iosBlock;
    private String iosBlockVersion;
    private Date iosBlockFrom;
    private Date iosBlockTo;

    private boolean webBlock;
    private String webBlockVersion;
    private Date webBlockFrom;
    private Date webBlockTo;
}
