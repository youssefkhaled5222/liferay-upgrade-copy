package com.ejada.telemoney.biller.portlet;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BillerDTO {

	private String id;
	private String prepaidCode;
	private String postpaidCode;
	private String billerId;
	private String billerCategoryId;
	private String categoryCode;
	private String categoryNameAr;
	private String categoryNameEn;
	private String billerNameAr;
	private String billerNameEn;
	private String paymentType;
	private String labelNameAr;
	private String labelNameEn;
	private String order;
	private String allowedFixedValues;
	private double paymentMinAmount;
	private double paymentMaxAmount;
	private String photoLink;
	private List<Integer> allowedPaymentAmounts;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPrepaidCode() {
		return prepaidCode;
	}

	public void setPrepaidCode(String prepaidCode) {
		this.prepaidCode = prepaidCode;
	}

	public String getPostpaidCode() {
		return postpaidCode;
	}

	public void setPostpaidCode(String postpaidCode) {
		this.postpaidCode = postpaidCode;
	}

	public String getBillerId() {
		return billerId;
	}

	public void setBillerId(String billerId) {
		this.billerId = billerId;
	}

	public String getBillerCategoryId() {
		return billerCategoryId;
	}

	public void setBillerCategoryId(String billerCategoryId) {
		this.billerCategoryId = billerCategoryId;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryNameAr() {
		return categoryNameAr;
	}

	public void setCategoryNameAr(String categoryNameAr) {
		this.categoryNameAr = categoryNameAr;
	}

	public String getCategoryNameEn() {
		return categoryNameEn;
	}

	public void setCategoryNameEn(String categoryNameEn) {
		this.categoryNameEn = categoryNameEn;
	}

	public String getBillerNameAr() {
		return billerNameAr;
	}

	public void setBillerNameAr(String billerNameAr) {
		this.billerNameAr = billerNameAr;
	}

	public String getBillerNameEn() {
		return billerNameEn;
	}

	public void setBillerNameEn(String billerNameEn) {
		this.billerNameEn = billerNameEn;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getLabelNameAr() {
		return labelNameAr;
	}

	public void setLabelNameAr(String labelNameAr) {
		this.labelNameAr = labelNameAr;
	}

	public String getLabelNameEn() {
		return labelNameEn;
	}

	public void setLabelNameEn(String labelNameEn) {
		this.labelNameEn = labelNameEn;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getAllowedFixedValues() {
		return allowedFixedValues;
	}

	public void setAllowedFixedValues(String allowedFixedValues) {
		this.allowedFixedValues = allowedFixedValues;
	}

	public double getPaymentMinAmount() {
		return paymentMinAmount;
	}

	public void setPaymentMinAmount(double paymentMinAmount) {
		this.paymentMinAmount = paymentMinAmount;
	}

	public double getPaymentMaxAmount() {
		return paymentMaxAmount;
	}

	public void setPaymentMaxAmount(double paymentMaxAmount) {
		this.paymentMaxAmount = paymentMaxAmount;
	}

	public String getPhotoLink() {
		return photoLink;
	}

	public void setPhotoLink(String photoLink) {
		this.photoLink = photoLink;
	}

	public List<Integer> getAllowedPaymentAmounts() {
		return allowedPaymentAmounts;
	}

	public void setAllowedPaymentAmounts(List<Integer> allowedPaymentAmounts) {
		this.allowedPaymentAmounts = allowedPaymentAmounts;
	}

	// Convenience method to convert allowedPaymentAmounts list to comma-separated string
	public String getAllowedPaymentAmountsAsString() {
		if (allowedPaymentAmounts == null || allowedPaymentAmounts.isEmpty()) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for (Integer num : allowedPaymentAmounts) {
			if (sb.length() > 0) {
				sb.append(", ");
			}
			sb.append(num);
		}
		return sb.toString();
	}

	@Override
	public String toString() {
		return "BillerDTO [id=" + id + ", prepaidCode=" + prepaidCode + ", postpaidCode=" + postpaidCode + ", billerId="
				+ billerId + ", billerCategoryId=" + billerCategoryId + ", categoryCode=" + categoryCode
				+ ", categoryNameAr=" + categoryNameAr + ", categoryNameEn=" + categoryNameEn + ", billerNameAr="
				+ billerNameAr + ", billerNameEn=" + billerNameEn + ", paymentType=" + paymentType + ", labelNameAr="
				+ labelNameAr + ", labelNameEn=" + labelNameEn + ", order=" + order + ", allowedFixedValues="
				+ allowedFixedValues + ", paymentMinAmount=" + paymentMinAmount + ", paymentMaxAmount="
				+ paymentMaxAmount + ", photoLink=" + photoLink + ", allowedPaymentAmounts=" + allowedPaymentAmounts
				+ "]";
	}

	public static BillerDTO toDTO(JSONObject jsonObject) {
		BillerDTO billerResponseDTO = new BillerDTO();
		billerResponseDTO.setId(jsonObject.getString("id") != null ? jsonObject.getString("id") : "");
		billerResponseDTO
				.setPrepaidCode(jsonObject.getString("prepaidCode") != null ? jsonObject.getString("prepaidCode") : "");
		billerResponseDTO.setPostpaidCode(
				jsonObject.getString("postpaidCode") != null ? jsonObject.getString("postpaidCode") : "");
		billerResponseDTO.setBillerId(jsonObject.getString("billerId") != null ? jsonObject.getString("billerId") : "");
		billerResponseDTO.setBillerCategoryId(
				jsonObject.getString("billerCategoryId") != null ? jsonObject.getString("billerCategoryId") : "");
		billerResponseDTO.setCategoryCode(
				jsonObject.getString("categoryCode") != null ? jsonObject.getString("categoryCode") : "");
		billerResponseDTO.setCategoryNameAr(
				jsonObject.getString("categoryNameAr") != null ? jsonObject.getString("categoryNameAr") : "");
		billerResponseDTO.setCategoryNameEn(
				jsonObject.getString("categoryNameEn") != null ? jsonObject.getString("categoryNameEn") : "");
		billerResponseDTO.setBillerNameAr(
				jsonObject.getString("billerNameAr") != null ? jsonObject.getString("billerNameAr") : "");
		billerResponseDTO.setBillerNameEn(
				jsonObject.getString("billerNameEn") != null ? jsonObject.getString("billerNameEn") : "");
		billerResponseDTO
				.setPaymentType(jsonObject.getString("paymentType") != null ? jsonObject.getString("paymentType") : "");
		billerResponseDTO
				.setLabelNameAr(jsonObject.getString("labelNameAr") != null ? jsonObject.getString("labelNameAr") : "");
		billerResponseDTO
				.setLabelNameEn(jsonObject.getString("labelNameEn") != null ? jsonObject.getString("labelNameEn") : "");
		billerResponseDTO.setOrder(jsonObject.getString("order") != null ? jsonObject.getString("order") : "");
		billerResponseDTO.setAllowedFixedValues(
				jsonObject.getString("allowedFixedValues") != null ? jsonObject.getString("allowedFixedValues") : "");
		billerResponseDTO.setPaymentMinAmount(jsonObject.getDouble("paymentMinAmount"));
		billerResponseDTO.setPaymentMaxAmount(jsonObject.getDouble("paymentMaxAmount"));
		billerResponseDTO
				.setPhotoLink(jsonObject.getString("photoLink") != null ? jsonObject.getString("photoLink") : "");

		JSONArray allowedPaymentAmountsArray = jsonObject.getJSONArray("allowedPaymentAmounts");
		List<Integer> allowedPaymentAmounts = new ArrayList<>();
		for (int i = 0; i < allowedPaymentAmountsArray.length(); i++) {
			allowedPaymentAmounts.add(allowedPaymentAmountsArray.getInt(i));
		}
		billerResponseDTO.setAllowedPaymentAmounts(allowedPaymentAmounts);

		return billerResponseDTO;
	}

	public static List<BillerDTO> fromJSONArray(JSONArray jsonArray) {
		List<BillerDTO> billerResponseDTOList = new ArrayList<>();

		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			BillerDTO billerResponseDTO = BillerDTO.toDTO(jsonObject);
			billerResponseDTOList.add(billerResponseDTO);
		}

		return billerResponseDTOList;
	}

}
