package com.ejada.telemoney.db.domain.model;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MoiSubServiceDTO {
	private int id;
	private String subServiceName;
	private String subServiceCode;
	private List<FieldDTO> fieldsData;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubServiceName() {
		return subServiceName;
	}

	public void setSubServiceName(String subServiceName) {
		this.subServiceName = subServiceName;
	}

	public String getSubServiceCode() {
		return subServiceCode;
	}

	public void setSubServiceCode(String subServiceCode) {
		this.subServiceCode = subServiceCode;
	}

	public List<FieldDTO> getFieldsData() {
		return fieldsData;
	}

	public void setFieldsData(List<FieldDTO> fieldsData) {
		this.fieldsData = fieldsData;
	}

	@Override
	public String toString() {
		return "MoiSubServiceDTO [id=" + id + ", subServiceName=" + subServiceName + ", subServiceCode="
				+ subServiceCode + ", fieldsData=" + fieldsData + "]";
	}

	public static MoiSubServiceDTO toDTO(JSONObject jsonObject) {
		MoiSubServiceDTO moiSubServiceDTO = new MoiSubServiceDTO();
		moiSubServiceDTO.setId(jsonObject.getInt("id"));
		moiSubServiceDTO.setSubServiceName(jsonObject.getString("subServiceName"));
		moiSubServiceDTO.setSubServiceCode(jsonObject.getString("subServiceCode"));
		JSONArray fieldsDataArray = jsonObject.getJSONArray("fieldsData");
		List<FieldDTO> fieldsData = FieldDTO.fromJSONArray(fieldsDataArray);
		moiSubServiceDTO.setFieldsData(fieldsData);
		return moiSubServiceDTO;
	}

	public static List<MoiSubServiceDTO> fromJSONArray(JSONArray jsonArray) {
		List<MoiSubServiceDTO> subServiceDTOList = new ArrayList<>();

		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			MoiSubServiceDTO serviceDTO = MoiSubServiceDTO.toDTO(jsonObject);
			subServiceDTOList.add(serviceDTO);
		}

		return subServiceDTOList;
	}
}
