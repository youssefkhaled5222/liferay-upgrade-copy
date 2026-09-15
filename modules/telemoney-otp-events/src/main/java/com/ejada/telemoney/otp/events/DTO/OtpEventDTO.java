package com.ejada.telemoney.otp.events.DTO;

public class OtpEventDTO {
	
	
	private String eventCode;
	private String eventDescription;
	private String eventReasonAr;
	private String eventReasonEn;
	
	
	public String getEventCode() {
		return eventCode;
	}
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}
	public String getEventDescription() {
		return eventDescription;
	}
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	public String getEventReasonAr() {
		return eventReasonAr;
	}
	public void setEventReasonAr(String eventReasonAr) {
		this.eventReasonAr = eventReasonAr;
	}
	public String getEventReasonEn() {
		return eventReasonEn;
	}
	public void setEventReasonEn(String eventReasonEn) {
		this.eventReasonEn = eventReasonEn;
	}
	@Override
	public String toString() {
		return "OtpEventObject [eventCode=" + eventCode + ", eventDescription=" + eventDescription + ", eventReasonAr="
				+ eventReasonAr + ", eventReasonEn=" + eventReasonEn + "]";
	}
	public String toJsonString() {
        return String.format("{\"eventCode\":\"%s\", \"eventDescription\":\"%s\""
        		+ ", \"eventReasonAr\":\"%s\", \"eventReasonEn\":\"%s\"}",
        		eventCode, eventDescription, eventReasonAr, eventReasonEn);
    }
	
}
