package com.ejada.telemoney.db.domain.model;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DropDownDataDTO {
	private int id;
	private String code;
	private String valueAr;
	private String valueEn;
	private List<String> allowedValues;
	private String relatedFieldCode;
	private String relatedFieldName;
	private int relatedFieldId;
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
	public String getValueAr() {
		return valueAr;
	}
	public void setValueAr(String valueAr) {
		this.valueAr = valueAr;
	}
	public String getValueEn() {
		return valueEn;
	}
	public void setValueEn(String valueEn) {
		this.valueEn = valueEn;
	}
	public List<String> getAllowedValues() {
		return allowedValues;
	}
	public void setAllowedValues(List<String> allowedValues) {
		this.allowedValues = allowedValues;
	}
	public String getRelatedFieldCode() {
		return relatedFieldCode;
	}
	public void setRelatedFieldCode(String relatedFieldCode) {
		this.relatedFieldCode = relatedFieldCode;
	}
	public String getRelatedFieldName() {
		return relatedFieldName;
	}
	public void setRelatedFieldName(String relatedFieldName) {
		this.relatedFieldName = relatedFieldName;
	}
	public int getRelatedFieldId() {
		return relatedFieldId;
	}
	public void setRelatedFieldId(int relatedFieldId) {
		this.relatedFieldId = relatedFieldId;
	}
	@Override
	public String toString() {
		return "DropDownDataDTO [id=" + id + ", code=" + code + ", valueAr=" + valueAr + ", valueEn=" + valueEn
				+ ", allowedValues=" + allowedValues + ", relatedFieldCode=" + relatedFieldCode + ", relatedFieldName="
				+ relatedFieldName + ", relatedFieldId=" + relatedFieldId + "]";
	}
	
	 public static DropDownDataDTO toDTO(JSONObject jsonObject) {
	        DropDownDataDTO dropDownDataDTO = new DropDownDataDTO();
	        dropDownDataDTO.setId(jsonObject.getInt("id"));
	        dropDownDataDTO.setCode(jsonObject.getString("code"));
	        dropDownDataDTO.setValueAr(jsonObject.getString("valueAr"));
	        dropDownDataDTO.setValueEn(jsonObject.getString("valueEn"));
	        dropDownDataDTO.setRelatedFieldCode(jsonObject.getString("relatedFieldCode"));
	        dropDownDataDTO.setRelatedFieldName(jsonObject.getString("relatedFieldName"));
	        dropDownDataDTO.setRelatedFieldId(jsonObject.getInt("relatedFieldId"));

	        JSONArray allowedValuesArray = jsonObject.getJSONArray("allowedValues");
	        List<String> allowedValuesList = new ArrayList<>();
	        for (int i = 0; i < allowedValuesArray.length(); i++) {
	            allowedValuesList.add(allowedValuesArray.getString(i));
	        }
	        dropDownDataDTO.setAllowedValues(allowedValuesList);

	        return dropDownDataDTO;
	    }
	 
	 public static List<DropDownDataDTO> fromJSONArray(JSONArray jsonArray) {
	        List<DropDownDataDTO> categoryDTOList = new ArrayList<>();

	        for (int i = 0; i < jsonArray.length(); i++) {
	            JSONObject jsonObject = jsonArray.getJSONObject(i);
	            DropDownDataDTO categoryDTO = DropDownDataDTO.toDTO(jsonObject);
	            categoryDTOList.add(categoryDTO);
	        }

	        return categoryDTOList;
	    }
}
