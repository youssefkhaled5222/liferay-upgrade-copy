package com.ejada.telemoney.whiteList.DTO;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class WhiteListDTO {
    private LocalDate createdDate;
    private String poi;
    private String poiType;
    private String cif;
    private String nameEn;
    private String nameAr;
    private String mobile;
    private String allow;
    private String notify;

    // Getters and setters...

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public String getPoi() {
        return poi;
    }

    public void setPoi(String poi) {
        this.poi = poi;
    }

    public String getPoiType() {
        return poiType;
    }

    public void setPoiType(String poiType) {
        this.poiType = poiType;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameAr() {
        return nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAllow() {
        return allow;
    }

    public void setAllow(String allow) {
        this.allow = allow;
    }

    public String getNotify() {
        return notify;
    }

    public void setNotify(String notify) {
        this.notify = notify;
    }

    @Override
    public String toString() {
        return "WhiteListDTO [createdDate=" + createdDate + ", poi=" + poi + ", poiType=" + poiType + ", cif=" + cif
                + ", nameEn=" + nameEn + ", nameAr=" + nameAr + ", mobile=" + mobile + ", allow=" + allow + ", notify="
                + notify + "]";
    }

    // Convert JSONObject to WhiteListDTO
    public static WhiteListDTO toDTO(JSONObject jsonObject) {
        WhiteListDTO whiteListDTO = new WhiteListDTO();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String createdDateString = jsonObject.getString("createdDate");
        
        whiteListDTO.setCreatedDate(createdDateString != null ? LocalDate.parse(createdDateString, formatter) : null);
        whiteListDTO.setPoi(jsonObject.getString("poi") != null ? jsonObject.getString("poi") : "");
        whiteListDTO.setPoiType(jsonObject.getString("poiType") != null ? jsonObject.getString("poiType") : "");
        whiteListDTO.setCif(jsonObject.getString("cif") != null ? jsonObject.getString("cif") : "");
        whiteListDTO.setNameEn(jsonObject.getString("nameEn") != null ? jsonObject.getString("nameEn") : "");
        whiteListDTO.setNameAr(jsonObject.getString("nameAr") != null ? jsonObject.getString("nameAr") : "");
        whiteListDTO.setMobile(jsonObject.getString("mobile") != null ? jsonObject.getString("mobile") : "");
        whiteListDTO.setAllow(jsonObject.getString("allow") != null ? jsonObject.getString("allow") : "");
        whiteListDTO.setNotify(jsonObject.getString("notify") != null ? jsonObject.getString("notify") : "");

        return whiteListDTO;
    }

    // Convert JSONArray to List<WhiteListDTO>
    public static List<WhiteListDTO> fromJSONArray(JSONArray jsonArray) {
        List<WhiteListDTO> whiteListDTOList = new ArrayList<>();
        LOG.info("the json object to be converted in DTO class"+jsonArray);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            WhiteListDTO whiteListDTO = WhiteListDTO.toDTO(jsonObject);
            whiteListDTOList.add(whiteListDTO);
        }

        return whiteListDTOList;
    }
    
    private static final Log LOG = LogFactoryUtil.getLog(WhiteListDTO.class);
}
