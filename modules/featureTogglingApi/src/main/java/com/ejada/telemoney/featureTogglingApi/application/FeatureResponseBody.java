package com.ejada.telemoney.featureTogglingApi.application;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FeatureResponseBody {
	@JsonProperty("routeId")
	private String routeId;
	
	@JsonProperty("blockMethod")
	private String blockMethod;
	
	@JsonInclude(Include.ALWAYS)
	@JsonProperty("popUpTitle")
	private String popUpTitle;
	
	@JsonInclude(Include.ALWAYS)
	@JsonProperty("popUpSubTitle")
	private String popUpSubTitle;

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public String getBlockMethod() {
		return blockMethod;
	}

	public void setBlockMethod(String blockMethod) {
		this.blockMethod = blockMethod;
	}

	public String getPopUpTitle() {
		return popUpTitle;
	}

	public void setPopUpTitle(String popUpTitle) {
		this.popUpTitle = popUpTitle;
	}

	public String getPopUpSubTitle() {
		return popUpSubTitle;
	}

	public void setPopUpSubTitle(String popUpSubTitle) {
		this.popUpSubTitle = popUpSubTitle;
	}
	
}
