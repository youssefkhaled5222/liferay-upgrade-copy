package com.ejada.telemoney.db.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IvrEventsRequestDto {
    String eventCode;
    String eventName;
    String eventClass;
    String eventSubClass;
    String eventType;
    String eventSource;
}