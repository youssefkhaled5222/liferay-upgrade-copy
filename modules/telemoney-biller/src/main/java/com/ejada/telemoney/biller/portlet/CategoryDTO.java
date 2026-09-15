package com.ejada.telemoney.biller.portlet;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class CategoryDTO {

    private int categoryId;
    private String categoryCode;
    private String categoryNameEn;
    private String categoryNameAr;
    private int order;

    // Getters and Setters
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryNameEn() {
        return categoryNameEn;
    }

    public void setCategoryNameEn(String categoryNameEn) {
        this.categoryNameEn = categoryNameEn;
    }

    public String getCategoryNameAr() {
        return categoryNameAr;
    }

    public void setCategoryNameAr(String categoryNameAr) {
        this.categoryNameAr = categoryNameAr;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    // Conversion methods
    public static CategoryDTO toDTO(JSONObject jsonObject) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryId(jsonObject.getInt("categoryId"));
        categoryDTO.setCategoryCode(jsonObject.getString("categoryCode"));
        categoryDTO.setCategoryNameEn(jsonObject.getString("categoryNameEn"));
        categoryDTO.setCategoryNameAr(jsonObject.getString("categoryNameAr"));
        categoryDTO.setOrder(jsonObject.getInt("order"));
        return categoryDTO;
    }

    public static List<CategoryDTO> fromJSONArray(JSONArray jsonArray) {
        List<CategoryDTO> categoryDTOList = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            CategoryDTO categoryDTO = CategoryDTO.toDTO(jsonObject);
            categoryDTOList.add(categoryDTO);
        }

        return categoryDTOList;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "categoryId=" + categoryId +
                ", categoryCode='" + categoryCode + '\'' +
                ", categoryNameEn='" + categoryNameEn + '\'' +
                ", categoryNameAr='" + categoryNameAr + '\'' +
                ", order=" + order +
                '}';
    }
}
