package com.ejada.telemoney.db.domain.model;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FieldDTO implements Serializable{
	private int id;
	private String code;
	private String name;
	private String mappedFieldName;
	private int fixedValueFlag;
	private String fixedValue;
	private int dropDownFlag;
	private int dateFlag;
	private List<DropDownDataDTO> dropDownDataDTOs;

	public List<DropDownDataDTO> getDropDownDataDTOs() {
		return dropDownDataDTOs;
	}

	public void setDropDownDataDTOs(List<DropDownDataDTO> dropDownDataDTOs) {
		this.dropDownDataDTOs = dropDownDataDTOs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMappedFieldName() {
		return mappedFieldName;
	}

	public void setMappedFieldName(String mappedFieldName) {
		this.mappedFieldName = mappedFieldName;
	}

	public int getFixedValueFlag() {
		return fixedValueFlag;
	}

	public void setFixedValueFlag(int fixedValueFlag) {
		this.fixedValueFlag = fixedValueFlag;
	}

	public String getFixedValue() {
		return fixedValue;
	}

	public void setFixedValue(String fixedValue) {
		this.fixedValue = fixedValue;
	}

	public int getDropDownFlag() {
		return dropDownFlag;
	}

	public void setDropDownFlag(int dropDownFlag) {
		this.dropDownFlag = dropDownFlag;
	}

	public int getDateFlag() {
		return dateFlag;
	}

	public void setDateFlag(int dateFlag) {
		this.dateFlag = dateFlag;
	}

	@Override
	public String toString() {
		return "FieldDTO [id=" + id + ", code=" + code + ", name=" + name + ", mappedFieldName=" + mappedFieldName
				+ ", fixedValueFlag=" + fixedValueFlag + ", fixedValue=" + fixedValue + ", dropDownFlag=" + dropDownFlag
				+ ", dateFlag=" + dateFlag + ", dropDownDataDTOs=" + dropDownDataDTOs + "]";
	}

	public static FieldDTO toDTO(JSONObject jsonObject) {
		FieldDTO fieldDTO = new FieldDTO();
		fieldDTO.setId(jsonObject.getInt("id"));
		fieldDTO.setCode(jsonObject.getString("code"));
		fieldDTO.setName(jsonObject.getString("name"));
		fieldDTO.setMappedFieldName(jsonObject.getString("mappedFieldName"));
		fieldDTO.setFixedValueFlag(jsonObject.getInt("fixedValueFlag"));
		fieldDTO.setFixedValue(jsonObject.getString("fixedValue"));
		fieldDTO.setDropDownFlag(jsonObject.getInt("dropDownFlag"));
		fieldDTO.setDateFlag(jsonObject.getInt("dateFlag"));
		JSONArray fieldsDataArray = jsonObject.getJSONArray("dropDownData");
		List<DropDownDataDTO>dropDownDataDTOs = DropDownDataDTO.fromJSONArray(fieldsDataArray);
		fieldDTO.setDropDownDataDTOs(dropDownDataDTOs);
		return fieldDTO;
	}

	public static List<FieldDTO> fromJSONArray(JSONArray jsonArray) {
		List<FieldDTO> fieldsDataList = new ArrayList<>();

		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			FieldDTO fieldDTO = FieldDTO.toDTO(jsonObject);
			fieldsDataList.add(fieldDTO);
		}

		return fieldsDataList;

	}
}
