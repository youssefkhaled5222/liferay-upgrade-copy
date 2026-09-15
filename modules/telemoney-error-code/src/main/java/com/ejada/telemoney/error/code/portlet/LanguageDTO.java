package com.ejada.telemoney.error.code.portlet;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class LanguageDTO {

	private int id;
	private String languageCode;
	private String languageName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	@Override
	public String toString() {
		return "LanguageDTO{" + "id=" + id + ", languageCode='" + languageCode + '\'' + ", languageName='"
				+ languageName + '\'' + '}';
	}

	public static LanguageDTO toDTO(JSONObject jsonObject) {
		LanguageDTO languageDTO = new LanguageDTO();
		languageDTO.setId(jsonObject.getInt("id"));
		languageDTO.setLanguageCode(
				jsonObject.getString("languageCode") != null ? jsonObject.getString("languageCode") : "");
		languageDTO.setLanguageName(
				jsonObject.getString("languageName") != null ? jsonObject.getString("languageName") : "");
		return languageDTO;
	}

	public static List<LanguageDTO> fromJSONArray(JSONArray jsonArray) {
		List<LanguageDTO> languageDTOList = new ArrayList<>();

		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			LanguageDTO languageDTO = LanguageDTO.toDTO(jsonObject);
			languageDTOList.add(languageDTO);
		}

		return languageDTOList;
	}
}
