package com.ejada.telemoney.error.code.portlet;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ErrorCodeDTO {

	private String statusCode;
	private String languages;
	private String description;
	private String language;

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ErrorCodeDTO [statusCode=" + statusCode + ", languages=" + languages + ", description=" + description
				+ ", language=" + language + "]";
	}

	public static ErrorCodeDTO toDTO(JSONObject jsonObject) {
		ErrorCodeDTO errorCodeDTO = new ErrorCodeDTO();
		errorCodeDTO
				.setStatusCode(jsonObject.getString("statusCode") != null ? jsonObject.getString("statusCode") : "");
		errorCodeDTO.setLanguages(jsonObject.getString("languages") != null ? jsonObject.getString("languages") : "");
		errorCodeDTO
				.setDescription(jsonObject.getString("description") != null ? jsonObject.getString("description") : "");
		errorCodeDTO.setLanguage(jsonObject.getString("language") != null ? jsonObject.getString("language") : "");
		return errorCodeDTO;
	}

	public static List<ErrorCodeDTO> fromJSONArray(JSONArray jsonArray) {
		List<ErrorCodeDTO> errorCodeDTOList = new ArrayList<>();

		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			ErrorCodeDTO errorCodeDTO = ErrorCodeDTO.toDTO(jsonObject);
			errorCodeDTOList.add(errorCodeDTO);
		}

		return errorCodeDTOList;
	}
}
