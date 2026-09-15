package com.ejada.telemoney.biller.portlet;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PaymentTypeDTO {
	private int id;
	private String type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "PaymentTypeDTO [id=" + id + ", type=" + type + "]";
	}

	public static PaymentTypeDTO toDTO(JSONObject jsonObject) {
		PaymentTypeDTO paymentTypeDTO = new PaymentTypeDTO();
		paymentTypeDTO.setId(jsonObject.getInt("id"));
		paymentTypeDTO.setType(jsonObject.getString("type") != null ? jsonObject.getString("type") : "");
		return paymentTypeDTO;
	}

	public static List<PaymentTypeDTO> fromJSONArray(JSONArray jsonArray) {
		List<PaymentTypeDTO> paymentTypeDTOList = new ArrayList<>();

		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			PaymentTypeDTO paymentTypeDTO = PaymentTypeDTO.toDTO(jsonObject);
			paymentTypeDTOList.add(paymentTypeDTO);
		}

		return paymentTypeDTOList;
	}
}
