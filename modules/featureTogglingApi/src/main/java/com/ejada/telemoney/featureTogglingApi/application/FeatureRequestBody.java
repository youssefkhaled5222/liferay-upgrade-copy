package com.ejada.telemoney.featureTogglingApi.application;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FeatureRequestBody {
	@JsonProperty("segmentName")
	private String segmentName;
	
	@JsonProperty("deviceType")
	private String deviceType;
	
	@JsonProperty("deviceVersion")
	private String deviceVersion;

	public String getSegmentName() {
		return segmentName;
	}

	public void setSegmentName(String segmentName) {
		this.segmentName = segmentName;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getDeviceVersion() {
		return deviceVersion;
	}

	public void setDeviceVersion(String deviceVersion) {
		this.deviceVersion = deviceVersion;
	}
}
