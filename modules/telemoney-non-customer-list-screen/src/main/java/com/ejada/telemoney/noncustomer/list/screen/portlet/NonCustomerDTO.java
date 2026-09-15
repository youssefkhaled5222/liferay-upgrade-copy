package com.ejada.telemoney.noncustomer.list.screen.portlet;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NonCustomerDTO {

	private String POI;
    private String POIType;
    private String mobileNumber;
	public String getPOI() {
		return POI;
	}
	public void setPOI(String pOI) {
		POI = pOI;
	}
	public String getPOIType() {
		return POIType;
	}
	public void setPOIType(String pOIType) {
		POIType = pOIType;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "NonCustomerDTO [POI=" + POI + ", POIType=" + POIType + ", mobileNumber=" + mobileNumber + "]";
	}
	
	 public static NonCustomerDTO toDTO(JSONObject jsonObject) {
		 NonCustomerDTO customerDTO = new NonCustomerDTO();
	        customerDTO.setPOI(jsonObject.getString("POI")!=null?jsonObject.getString("POI"):"");
	        customerDTO.setPOIType(jsonObject.getString("POIType")!=null?jsonObject.getString("POIType"):"");
	        customerDTO.setMobileNumber(jsonObject.getString("mobileNumber")!=null?jsonObject.getString("mobileNumber"):"");
	        return customerDTO;
	    }

	 public static List<NonCustomerDTO> fromJSONArray(JSONArray jsonArray) {
	        List<NonCustomerDTO> customerDTOList = new ArrayList<>();

	        for (int i = 0; i < jsonArray.length(); i++) {
	            JSONObject jsonObject = jsonArray.getJSONObject(i);
	            NonCustomerDTO customerDTO = NonCustomerDTO.toDTO(jsonObject);
	            customerDTOList.add(customerDTO);
	        }

	        return customerDTOList;
	    }

}
