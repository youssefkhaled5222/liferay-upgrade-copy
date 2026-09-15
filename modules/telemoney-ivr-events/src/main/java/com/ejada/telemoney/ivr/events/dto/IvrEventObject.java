package com.ejada.telemoney.ivr.events.dto;

public class IvrEventObject {

	private String eventCode;
	private String eventName;
	private String eventClass;
	private String eventSubClass;
	private String eventVersion;
	private String eventType;
	private String eventSource;
	
	
	public String getEventCode() {
		return eventCode;
	}
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventClass() {
		return eventClass;
	}
	public void setEventClass(String eventClass) {
		this.eventClass = eventClass;
	}
	public String getEventSubClass() {
		return eventSubClass;
	}
	public void setEventSubClass(String eventSubClass) {
		this.eventSubClass = eventSubClass;
	}
	public String getEventVersion() {
		return eventVersion;
	}
	public void setEventVersion(String eventVersion) {
		this.eventVersion = eventVersion;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getEventSource() {
		return eventSource;
	}
	public void setEventSource(String eventSource) {
		this.eventSource = eventSource;
	}
	@Override
	public String toString() {
		return "IvrEventObject [eventCode=" + eventCode + ", eventName=" + eventName + ", eventClass=" + eventClass
				+ ", eventSubClass=" + eventSubClass + ", eventVersion=" + eventVersion + ", eventType=" + eventType
				+ ", eventSource=" + eventSource + "]";
	}
	
	public String toJsonString() {
        return String.format("{\"eventCode\":\"%s\", \"eventName\":\"%s\""
        		+ ", \"eventClass\":\"%s\", \"eventSubClass\":\"%s\", "
        		+ "\"eventType\":\"%s\", \"eventSource\":\"%s\"}",
        		eventCode, eventName, eventClass, eventSubClass,
        		eventType, eventSource);
    }
}
