package com.ejada.telemoney.configuration.dto;

public class Configuration {
	
	private String key;
	private String value;
	private String type;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Configuration [key=" + key + ", value=" + value + ", type=" + type + "]";
	}
	
	public String toJsonString() {
        return String.format("{\"key\":\"%s\", \"value\":\"%s\"" + ", \"type\":\"%s\"}"
        		, key, value, type);
    }
	
	
	
	
	
}
