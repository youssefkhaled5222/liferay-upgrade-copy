package com.ejada.telemoney.db.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OtpRequestDto {
    String eventCode;
    String eventReasonAr;
    String eventReasonEn;
    String eventDescription;
}
