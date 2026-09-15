package com.ejada.telemoney.sms.template.portlet;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SMSDTO {
    private String eventCode;
    private String eventDescription;
    private String serviceId;
    
    

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    // You can also override toString() method for better logging/debugging
    @Override
    public String toString() {
        return "EventDTO{" +
                "eventCode='" + eventCode + '\'' +
                ", eventDescription='" + eventDescription + '\'' +
                ", serviceId='" + serviceId + '\'' +
                '}';
    }

    // toDTO function to convert JsonObject to EventDTO
    public static SMSDTO toDTO(JSONObject jsonObject) {
    	SMSDTO eventDTO = new SMSDTO();
        eventDTO.setEventCode(jsonObject.getString("eventCode").isEmpty()?"":jsonObject.getString("eventCode"));
        eventDTO.setEventDescription(jsonObject.getString("eventDescription").isEmpty()?"":jsonObject.getString("eventDescription"));
        eventDTO.setServiceId(jsonObject.getString("serviceId").isEmpty()?"":jsonObject.getString("serviceId"));
        return eventDTO;
    }

   

    public static List<SMSDTO> fromJSONArray(JSONArray jsonArray) {
        List<SMSDTO> eventDTOList = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            SMSDTO eventDTO = SMSDTO.toDTO(jsonObject);
            eventDTOList.add(eventDTO);
        }

        return eventDTOList;
    }
}
