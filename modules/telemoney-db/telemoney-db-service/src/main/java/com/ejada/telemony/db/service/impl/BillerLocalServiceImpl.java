/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ejada.telemony.db.service.impl;

import com.ejada.telemony.db.constants.Constants;
import com.ejada.telemony.db.model.ConfigurationEntity;
import com.ejada.telemony.db.service.base.BillerLocalServiceBaseImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * The implementation of the biller local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.ejada.telemony.db.service.BillerLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BillerLocalServiceBaseImpl
 */
public class BillerLocalServiceImpl extends BillerLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.ejada.telemony.db.service.BillerLocalService</code> via injection
	 * or a <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.ejada.telemony.db.service.BillerLocalServiceUtil</code>.
	 */
	private static final Log LOG = LogFactoryUtil.getLog(BillerLocalServiceImpl.class);

	public String getBillerData(String ordersApiUrl, String billerId, String billerName, String billerCategoryId) {
		try {
			TrustManager[] trustAllCerts = new TrustManager[] {
		            new X509TrustManager() {
		                public X509Certificate[] getAcceptedIssuers() { return null; }
		                public void checkClientTrusted(X509Certificate[] certs, String authType) {}
		                public void checkServerTrusted(X509Certificate[] certs, String authType) {}
		            }
		        };
 
	        SSLContext sc = SSLContext.getInstance("TLS");
		    sc.init(null, trustAllCerts, new SecureRandom());
		    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
 
		        // Disable hostname verification
	        HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
			URL url = new URL(ordersApiUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");

			connection.setRequestProperty("Content-Type", "application/json");
			connection.setDoOutput(true);

			JSONObject updatePayload = JSONFactoryUtil.createJSONObject();
			updatePayload.put("billerId", billerId);
			updatePayload.put("billerName", billerName);
			updatePayload.put("billerCategoryId", billerCategoryId);

			try (OutputStream os = connection.getOutputStream()) {
				byte[] input = updatePayload.toJSONString().getBytes("utf-8");
				os.write(input, 0, input.length);
			}

			int responseCode = connection.getResponseCode();

			if (responseCode == 200) {
				// The request was successful, so read the response
				InputStream inputStream = connection.getInputStream();
				InputStreamReader reader = new InputStreamReader(inputStream);
				BufferedReader bufferedReader = new BufferedReader(reader);
				StringBuilder response = new StringBuilder();
				String line;

				while ((line = bufferedReader.readLine()) != null) {
					response.append(line);
				}

				bufferedReader.close();
				return response.toString();
			} else {

				return null;
			}
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}

	public String getPaymentTypeData(String ordersApiUrl) {
		try {
			URL url = new URL(ordersApiUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			int responseCode = connection.getResponseCode();

			if (responseCode == 200) {
				// The request was successful, so read the response
				InputStream inputStream = connection.getInputStream();
				InputStreamReader reader = new InputStreamReader(inputStream);
				BufferedReader bufferedReader = new BufferedReader(reader);
				StringBuilder response = new StringBuilder();
				String line;

				while ((line = bufferedReader.readLine()) != null) {
					response.append(line);
				}

				bufferedReader.close();
				return response.toString();
			} else {

				return null;
			}
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}

	private void handleDeleteBiller(String ordersApiUrl) {
		try {
			URL url = new URL(ordersApiUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("DELETE");

			int responseCode = connection.getResponseCode();

			if (responseCode == 200) {
				// The request was successful, so read the response
				LOG.info("Biller deleted successfully with response code: " + responseCode);
			} else {
				LOG.info("Biller delete API call failed with response code: " + responseCode);

			}
		} catch (Exception e) {
			LOG.error("Error while calling service update for URL: " + ordersApiUrl);
			 throw new RuntimeException("Biller delete API failed", e);
		}
	}

	private void handleBillerRequest(String portalApiUrl, JSONObject updatePayload) {
		try {
			URL url = new URL(portalApiUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setDoOutput(true);

			try (OutputStream os = connection.getOutputStream()) {
				byte[] input = updatePayload.toJSONString().getBytes("utf-8");
				os.write(input, 0, input.length);
			}

			int responseCode = connection.getResponseCode();

			LOG.info("Biller update API response code: " + responseCode);

		} catch (Exception e) {
			LOG.error("Error while calling service update for URL: " + portalApiUrl);
			throw new RuntimeException("Biller API failed", e);
		}
	}

	public JSONObject createBillerPayload(String prePaidCode, String postPaidCode, String billerNameAr,
			String billerNameEn, String billerCategoryId, String labelNameAr, String labelNameEn, String paymentTypeId,
			String allowedFixedValues, double paymentMinAmount, double paymentMaxAmount, String allowedPaymentAmounts,
			String photoLink) {
		JSONObject updatePayload = JSONFactoryUtil.createJSONObject();
		updatePayload.put("prePaidCode", prePaidCode);
		updatePayload.put("postPaidCode", postPaidCode);
		updatePayload.put("billerNameAr", billerNameAr);
		updatePayload.put("billerNameEn", billerNameEn);
		updatePayload.put("billerCategoryId", billerCategoryId);
		updatePayload.put("labelNameAr", labelNameAr);
		updatePayload.put("labelNameEn", labelNameEn);
		updatePayload.put("payementTypeId", paymentTypeId);
		updatePayload.put("allowedFixedValues", allowedFixedValues);
		updatePayload.put("paymentMinAmount", paymentMinAmount);
		updatePayload.put("paymentMaxAmount", paymentMaxAmount);
		updatePayload.put("allowedPaymentAmounts", allowedPaymentAmounts);
		updatePayload.put("photoLink", photoLink);

		return updatePayload;
	}

	public void addBiller(String portalApiUrl, String prePaidCode, String postPaidCode, String billerNameAr,
							String billerNameEn, String billerCategoryId, String labelNameAr, String labelNameEn, String paymentTypeId,
							String allowedFixedValues, double paymentMinAmount, double paymentMaxAmount, String allowedPaymentAmounts,
							String photoLink, User user, ServiceContext serviceContext) throws PortalException, JsonProcessingException {
		JSONObject payload = createBillerPayload(prePaidCode, postPaidCode, billerNameAr, billerNameEn,
				billerCategoryId, labelNameAr, labelNameEn, paymentTypeId, allowedFixedValues, paymentMinAmount,
				paymentMaxAmount, allowedPaymentAmounts, photoLink);

		configurationEntityLocalService.handleConfigurationChange(portalApiUrl,null,payload,Constants.ADD_BILLER,Constants.BILLER,"0",serviceContext,user);
	}

	public void updateBiller(String portalApiUrl, String id, String prePaidCode, String postPaidCode,
			String billerNameAr, String billerNameEn, String billerCategoryId, String labelNameAr, String labelNameEn,
			String paymentTypeId, String allowedFixedValues, double paymentMinAmount, double paymentMaxAmount,
			String allowedPaymentAmounts, String photoLink,
			String oldPrePaidCode, String oldPostPaidCode, String oldBillerNameAr, String oldBillerNameEn,
			String oldBillerCategoryId, String oldLabelNameAr, String oldLabelNameEn, String oldPaymentTypeId,
			String oldAllowedFixedValues, double oldPaymentMinAmount, double oldPaymentMaxAmount,
			String oldAllowedPaymentAmounts, String oldPhotoLink,
			User user, ServiceContext serviceContext) throws PortalException, JsonProcessingException {

		JSONObject newData = createBillerPayload(prePaidCode, postPaidCode, billerNameAr, billerNameEn,
				billerCategoryId, labelNameAr, labelNameEn, paymentTypeId, allowedFixedValues, paymentMinAmount,
				paymentMaxAmount, allowedPaymentAmounts, photoLink);
		newData.put("id", id);

		JSONObject oldData = createBillerPayload(oldPrePaidCode, oldPostPaidCode, oldBillerNameAr, oldBillerNameEn,
				oldBillerCategoryId, oldLabelNameAr, oldLabelNameEn, oldPaymentTypeId, oldAllowedFixedValues,
				oldPaymentMinAmount, oldPaymentMaxAmount, oldAllowedPaymentAmounts, oldPhotoLink);
		oldData.put("id", id);

		configurationEntityLocalService.handleConfigurationChange(portalApiUrl, oldData, newData, Constants.UPDATE_BILLER, Constants.BILLER, id, serviceContext, user);
	}
	public void handleDeleteBillerWorkflow(String portalApiUrl, String id, String prePaidCode, String postPaidCode,
			String billerNameAr, String billerNameEn, String billerCategoryId, String labelNameAr, String labelNameEn,
			String paymentTypeId, String allowedFixedValues, double paymentMinAmount, double paymentMaxAmount,
			String allowedPaymentAmounts, String photoLink,
			User user, ServiceContext serviceContext) throws PortalException, JsonProcessingException {

		JSONObject oldData = createBillerPayload(prePaidCode, postPaidCode, billerNameAr, billerNameEn,
				billerCategoryId, labelNameAr, labelNameEn, paymentTypeId, allowedFixedValues, paymentMinAmount,
				paymentMaxAmount, allowedPaymentAmounts, photoLink);
		oldData.put("id", id);

		configurationEntityLocalService.handleConfigurationChange(portalApiUrl, oldData, null, Constants.DELETE_BILLER,Constants.BILLER, id,serviceContext, user);
	}

	public void deleteBiller(String deleteUrl, String id) {
		String url = deleteUrl + "/" + id;
		 handleDeleteBiller(url);
	}

	public String getAllPaymentType(String Url) {
		return this.getPaymentTypeData(Url);
	}

	public String getAllBillerCategory(String Url) {
		return this.getPaymentTypeData(Url);
	}

	public String getAllBillers(String errorCodeUrl, String billerId, String billerName, String billerCategoryId) {

		return this.getBillerData(errorCodeUrl, "", "", billerCategoryId);

	}

	public String searchBiller(String errorCodeUrl, String billerId, String billerName, String billerCategoryId) {
		return this.getBillerData(errorCodeUrl, billerId, billerName, billerCategoryId);
	}

	public List<Integer> convertStringToList(String str) {
		List<Integer> list = new ArrayList<>();
		String[] strArray = str.split(",");

		for (String s : strArray) {
			list.add(Integer.parseInt(s.trim()));
		}

		return list;
	}

	public String convertListToString(List<Integer> list) {
		StringBuilder sb = new StringBuilder();
		for (Integer num : list) {
			if (sb.length() > 0) {
				sb.append(", ");
			}
			sb.append(num);
		}
		return sb.toString();
	}

	private void handleBillerCategoryCreateAndUpdate(String portalApiUrl,JSONObject payload) {
		try {
			URL url = new URL(portalApiUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setDoOutput(true);

			try (OutputStream os = connection.getOutputStream()) {
				byte[] input = payload.toJSONString().getBytes("utf-8");
				os.write(input, 0, input.length);
			}

			int responseCode = connection.getResponseCode();

			LOG.info("Biller category API response code: " + responseCode);
		} catch (Exception e) {
			LOG.error("Error while calling service update for URL: " + portalApiUrl);
			throw new RuntimeException("Biller category API failed", e);
			}

	}

	public void createBillerCategory(String portalApiUrl, String categoryCode,
			String categoryNameAr, String categoryNameEn,User user, ServiceContext serviceContext) throws PortalException, JsonProcessingException {
		JSONObject payload = JSONFactoryUtil.createJSONObject();
		payload.put("categoryCode", categoryCode);
		payload.put("categoryNameAr", categoryNameAr);
		payload.put("categoryNameEn", categoryNameEn);
		configurationEntityLocalService.handleConfigurationChange(portalApiUrl,null,payload,Constants.ADD_BILLER_CATEGORY,Constants.BILLER_CATEGORY, "0", serviceContext,user);
	}
	
	public void updateBillerCategory(String portalApiUrl, String categoryId,
			String categoryNameAr, String categoryNameEn, String oldCategoryNameAr, String oldCategoryNameEn,
			User user, ServiceContext serviceContext) throws PortalException, JsonProcessingException {

		JSONObject oldData = JSONFactoryUtil.createJSONObject();
		oldData.put("categoryID", categoryId);
		oldData.put("categoryNameAr", oldCategoryNameAr);
		oldData.put("categoryNameEn", oldCategoryNameEn);

		JSONObject newData = JSONFactoryUtil.createJSONObject();
		newData.put("categoryID", categoryId);
		newData.put("categoryNameAr", categoryNameAr);
		newData.put("categoryNameEn", categoryNameEn);

		configurationEntityLocalService.handleConfigurationChange(portalApiUrl, oldData, newData, Constants.UPDATE_BILLER_CATEGORY, Constants.BILLER_CATEGORY, categoryId, serviceContext, user);
	}

	public void deleteBillerCategory(String portalApiUrl, String categoryId,
			String categoryNameAr, String categoryNameEn, String categoryCode,
			User user, ServiceContext serviceContext) throws PortalException, JsonProcessingException {

		JSONObject oldData = JSONFactoryUtil.createJSONObject();
		oldData.put("categoryID", categoryId);
		oldData.put("categoryCode", categoryCode);
		oldData.put("categoryNameAr", categoryNameAr);
		oldData.put("categoryNameEn", categoryNameEn);

		configurationEntityLocalService.handleConfigurationChange(portalApiUrl, oldData, null, Constants.DELETE_BILLER_CATEGORY, Constants.BILLER_CATEGORY, categoryId,serviceContext, user);
	}


	public void handleApprovedConfigEntity(ConfigurationEntity configurationEntity) throws JSONException {
		String action = configurationEntity.getWorkflowAction();
        switch (action) {
            case Constants.ADD_BILLER:
                LOG.info("Handling add biller request for URL: " + configurationEntity.getUrl() + " with data: " + configurationEntity.getNewData());
                handleBillerRequest(configurationEntity.getUrl(), JSONFactoryUtil.createJSONObject(configurationEntity.getNewData()));
                LOG.info("Biller added successfully");
                break;
            case Constants.UPDATE_BILLER:
                LOG.info("Handling update biller request for URL: " + configurationEntity.getUrl() + " with data: " + configurationEntity.getNewData());
                handleBillerRequest(configurationEntity.getUrl(), JSONFactoryUtil.createJSONObject(configurationEntity.getNewData()));
                LOG.info("Biller updated successfully");

                break;
            case Constants.DELETE_BILLER: {
                LOG.info("Handling delete biller request for URL: " + configurationEntity.getUrl() + " with data: " + configurationEntity.getOldData());
                deleteBiller(configurationEntity.getUrl(), configurationEntity.getEntityId());
                LOG.info("Biller deleted successfully");
                break;
            }
            case Constants.ADD_BILLER_CATEGORY:
            case Constants.UPDATE_BILLER_CATEGORY:
                LOG.info("Handling " + (action.equals(Constants.ADD_BILLER_CATEGORY) ? "add" : "update") + " biller category request for URL: " + configurationEntity.getUrl() + " with data: " + configurationEntity.getNewData());
                handleBillerCategoryCreateAndUpdate(configurationEntity.getUrl(), JSONFactoryUtil.createJSONObject(configurationEntity.getNewData()));
                LOG.info("Biller category " + (action.equals(Constants.ADD_BILLER_CATEGORY) ? "added" : "updated") + " successfully");
                break;
            case Constants.DELETE_BILLER_CATEGORY: {
                LOG.info("Handling delete biller category request for URL: " + configurationEntity.getUrl() + " with data: " + configurationEntity.getOldData());
                deleteBiller(configurationEntity.getUrl(),configurationEntity.getEntityId());
                LOG.info("Biller category deleted successfully");
                break;
            }
        }

	};


}