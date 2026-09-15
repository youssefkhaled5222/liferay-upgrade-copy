package com.ejada.telemoney.db.domain.model;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MoiServiceDTO {

	 private int id;
	    private String serviceName;
	    private String serviceCode;

	    // Getters and Setters
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getServiceName() {
	        return serviceName;
	    }

	    public void setServiceName(String serviceName) {
	        this.serviceName = serviceName;
	    }

	    public String getServiceCode() {
	        return serviceCode;
	    }

	    public void setServiceCode(String serviceCode) {
	        this.serviceCode = serviceCode;
	    }
	    
	    
	    
	    @Override
		public String toString() {
			return "MoiServiceDTO [id=" + id + ", serviceName=" + serviceName + ", serviceCode=" + serviceCode + "]";
		}

		public static MoiServiceDTO toDTO(JSONObject jsonObject) {
	    	MoiServiceDTO serviceDTO = new MoiServiceDTO();
	        serviceDTO.setId(jsonObject.getInt("id"));
	        serviceDTO.setServiceName(jsonObject.getString("serviceName"));
	        serviceDTO.setServiceCode(jsonObject.getString("serviceCode"));
	        return serviceDTO;
	    }

	    public static List<MoiServiceDTO> fromJSONArray(JSONArray jsonArray) {
	        List<MoiServiceDTO> serviceDTOList = new ArrayList<>();

	        for (int i = 0; i < jsonArray.length(); i++) {
	            JSONObject jsonObject = jsonArray.getJSONObject(i);
	            MoiServiceDTO serviceDTO = MoiServiceDTO.toDTO(jsonObject);
	            serviceDTOList.add(serviceDTO);
	        }

	        return serviceDTOList;
	    }
}
