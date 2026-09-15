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

import com.ejada.telemoney.db.domain.model.DropDownDataDTO;
import com.ejada.telemony.db.constants.Constants;
import com.ejada.telemony.db.model.ConfigurationEntity;
import com.ejada.telemony.db.service.base.MOILocalServiceBaseImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * The implementation of the moi local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.ejada.telemony.db.service.MOILocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MOILocalServiceBaseImpl
 */
public class MOILocalServiceImpl extends MOILocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.ejada.telemony.db.service.MOILocalService</code> via injection or a
	 * <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.ejada.telemony.db.service.MOILocalServiceUtil</code>.
	 */
	private static final Log LOG = LogFactoryUtil.getLog(MOILocalServiceImpl.class);

	public String getMOIBillerAPI(String moiApiUrl,String languageId) {
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

			URL url = new URL(moiApiUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.addRequestProperty("Language", languageId);
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

	public String getMOIBiller(String moiBillerApiUrl, String refundTypeCode,String languageId) {

		StringBuilder urlBuilder = new StringBuilder(moiBillerApiUrl).append(refundTypeCode);

		return getMOIBillerAPI(urlBuilder.toString(),languageId);
	}

	public String getMOIBillerService(String moiBillerApiUrl, String getSearchkeyword,String languageId) {

		StringBuilder urlBuilder = new StringBuilder(moiBillerApiUrl).append(getSearchkeyword);

		return getMOIBillerAPI(urlBuilder.toString(),languageId);
	}
	/*
	 * public String getMOIService(String moiServiceApiUrl,String getSearchkeyword)
	 * { StringBuilder urlBuilder = new StringBuilder(moiServiceApiUrl)
	 * .append(getSearchkeyword); return getMOIBillerAPI(urlBuilder.toString()); }
	 * 
	 */

	public void handleMOIUpdate(String portalApiUrl, String serviceTypeFlag, String serviceName, String serviceCode,
								  String id, String languageId, String oldBillerId, String oldBillerCode,
								  String oldBillerName, ServiceContext serviceContext, User user) throws PortalException, JsonProcessingException {

			JSONObject oldData = JSONFactoryUtil.createJSONObject();
			oldData.put("serviceTypeFlag", serviceTypeFlag);
			oldData.put("serviceName", oldBillerName);
			oldData.put("serviceCode", oldBillerCode);
			oldData.put("id", oldBillerId);

			JSONObject updatePayload = JSONFactoryUtil.createJSONObject();
			updatePayload.put("serviceTypeFlag", serviceTypeFlag);
			updatePayload.put("serviceName", serviceName);
			updatePayload.put("serviceCode", serviceCode);
			updatePayload.put("id", id);

			serviceContext.setAttribute("languageId", languageId);
			configurationEntityLocalService.handleConfigurationChange(portalApiUrl, oldData, updatePayload,
					Constants.UPDATE_MOI_BILLER, Constants.MOI_BILLER, id, serviceContext, user);
	}


	public void handleMOIServiceUpdate(String portalApiUrl, String subServiceId, String subServiceName,
			String subServiceCode, String id, String languageId, String oldSubServiceId, String oldSubServiceName,
			String oldSubServiceCode, String oldMoiServiceId, ServiceContext serviceContext, User user)
			throws PortalException, JsonProcessingException {

			JSONObject oldData = JSONFactoryUtil.createJSONObject();
			oldData.put("subServiceId", oldSubServiceId);
			oldData.put("subServiceName", oldSubServiceName);
			oldData.put("subServiceCode", oldSubServiceCode);
			oldData.put("id", oldMoiServiceId);

			JSONObject updatePayload = JSONFactoryUtil.createJSONObject();
			updatePayload.put("subServiceId", subServiceId);
			updatePayload.put("subServiceName", subServiceName);
			updatePayload.put("subServiceCode", subServiceCode);
			updatePayload.put("id", id);

			serviceContext.setAttribute("languageId", languageId);

			configurationEntityLocalService.handleConfigurationChange(portalApiUrl, oldData, updatePayload,
					Constants.UPDATE_MOI_SERVICE, Constants.MOI_SERVICE, id, serviceContext, user);
	}



	public void handleMOIFieldUpdate(String portalApiUrl, String id, String subServiceId, String code, String name,
			int fieldDetailsId, int fixedValueFlag, String fixedValue, int dateFlag, int dropDownFlag,
			List<DropDownDataDTO> dropDowns,
			String oldFieldId, String oldFieldCode, String oldFieldName, String oldFieldDetailsId,
			String oldFixedValueFlag, String oldFixedValue, String oldDateFlag, String oldDropDownFlag,
			ServiceContext serviceContext, User user) throws PortalException, JsonProcessingException {

			// Build old data
			JSONObject oldData = JSONFactoryUtil.createJSONObject();
			JSONObject oldFieldsDataObject = JSONFactoryUtil.createJSONObject();
			JSONArray oldFieldsData = JSONFactoryUtil.createJSONArray();
			oldData.put("subServiceId", subServiceId);
			oldFieldsDataObject.put("id", oldFieldId);
			oldFieldsDataObject.put("code", oldFieldCode);
			oldFieldsDataObject.put("name", oldFieldName);
			oldFieldsDataObject.put("fieldDetailsId", oldFieldDetailsId);
			oldFieldsDataObject.put("fixedValueFlag", oldFixedValueFlag);
			oldFieldsDataObject.put("fixedValue", oldFixedValue);
			oldFieldsDataObject.put("dateFlag", oldDateFlag);
			oldFieldsDataObject.put("dropDownFlag", oldDropDownFlag);
			oldFieldsDataObject.put("dropDownData", JSONFactoryUtil.createJSONArray());
			oldFieldsData.put(oldFieldsDataObject);
			oldData.put("fieldsData", oldFieldsData);

			// Build new data
			JSONObject updatePayload = JSONFactoryUtil.createJSONObject();
			JSONObject fieldsDataObject = JSONFactoryUtil.createJSONObject();
			JSONArray fieldsData = JSONFactoryUtil.createJSONArray();
			JSONArray dropDownDataArray = JSONFactoryUtil.createJSONArray();

			updatePayload.put("subServiceId", subServiceId);
			fieldsDataObject.put("id", id);
			fieldsDataObject.put("code", code);
			fieldsDataObject.put("name", name);
			fieldsDataObject.put("fieldDetailsId", fieldDetailsId);
			fieldsDataObject.put("fixedValueFlag", fixedValueFlag);
			fieldsDataObject.put("fixedValue", fixedValue);
			fieldsDataObject.put("dateFlag", dateFlag);
			fieldsDataObject.put("dropDownFlag", dropDownFlag);
			fieldsDataObject.put("dropDownData", "");
			if (dropDownFlag == 1) {
				for (DropDownDataDTO dropDown : dropDowns) {
					JSONObject dropDownData = JSONFactoryUtil.createJSONObject();
					dropDownData.put("id", dropDown.getId());
					dropDownData.put("code", dropDown.getCode());
					dropDownData.put("valueAr", dropDown.getValueAr());
					dropDownData.put("valueEn", dropDown.getValueEn());
					dropDownData.put("relatedFieldCode", dropDown.getRelatedFieldCode());
					dropDownData.put("relatedFieldName", dropDown.getRelatedFieldName());
					dropDownData.put("relatedFieldId", dropDown.getRelatedFieldId());
					dropDownData.put("allowedValues", dropDown.getAllowedValues());
					dropDownDataArray.put(dropDownData);

					fieldsDataObject.put("dropDownData", dropDownDataArray);
				}
			}else {
				fieldsDataObject.put("dropDownData", dropDownDataArray);
			}
			fieldsData.put(fieldsDataObject);
			updatePayload.put("fieldsData", fieldsData);
			configurationEntityLocalService.handleConfigurationChange(portalApiUrl, oldData, updatePayload,
					Constants.UPDATE_MOI_FIELD, Constants.MOI_FIELD, id, serviceContext, user);
	}




	public void handleMOIFieldAndDropDownUpdate(String portalApiUrl, String id, String subServiceId, String code,
			String name, int fieldDetailsId, int fixedValueFlag, String fixedValue, int dateFlag, int dropDownFlag,
			int dropDownId, String dropDownCode, String dropDownValueAr, String dropDownValueEn,
			String relatedFieldCode, String relatedFieldName, String relatedFieldId, List<Integer> allowedValues,
			String oldFieldId, String oldFieldCode, String oldFieldName, String oldFieldDetailsId,
			String oldFixedValueFlag, String oldFixedValue, String oldDateFlag, String oldDropDownFlag,
			String oldDropDownId, String oldCode, String oldValueAr, String oldValueEn,
			String oldRelatedFieldCode, String oldRelatedFieldName, String oldRelatedFieldId, List<Integer> oldAllowedValues,
			ServiceContext serviceContext, User user) throws PortalException, JsonProcessingException {

			// Build old data
			JSONObject oldData = JSONFactoryUtil.createJSONObject();
			JSONObject oldFieldsDataObject = JSONFactoryUtil.createJSONObject();
			JSONArray oldDropDownDataArray = JSONFactoryUtil.createJSONArray();
			JSONArray oldFieldsData = JSONFactoryUtil.createJSONArray();
			oldData.put("subServiceId", subServiceId);
			oldFieldsDataObject.put("id", oldFieldId);
			oldFieldsDataObject.put("code", oldFieldCode);
			oldFieldsDataObject.put("name", oldFieldName);
			oldFieldsDataObject.put("fieldDetailsId", oldFieldDetailsId);
			oldFieldsDataObject.put("fixedValueFlag", oldFixedValueFlag);
			oldFieldsDataObject.put("fixedValue", oldFixedValue);
			oldFieldsDataObject.put("dateFlag", oldDateFlag);
			oldFieldsDataObject.put("dropDownFlag", oldDropDownFlag);

			JSONObject oldDropDownData = JSONFactoryUtil.createJSONObject();
			oldDropDownData.put("id", oldDropDownId);
			oldDropDownData.put("code", oldCode);
			oldDropDownData.put("valueAr", oldValueAr);
			oldDropDownData.put("valueEn", oldValueEn);
			oldDropDownData.put("relatedFieldCode", oldRelatedFieldCode);
			oldDropDownData.put("relatedFieldName", oldRelatedFieldName);
			oldDropDownData.put("relatedFieldId", oldRelatedFieldId);
			oldDropDownData.put("allowedValues", oldAllowedValues);
			oldDropDownDataArray.put(oldDropDownData);
			oldFieldsDataObject.put("dropDownData", oldDropDownDataArray);
			oldFieldsData.put(oldFieldsDataObject);
			oldData.put("fieldsData", oldFieldsData);

			// Build new data
			JSONObject updatePayload = JSONFactoryUtil.createJSONObject();
			JSONObject fieldsDataObject = JSONFactoryUtil.createJSONObject();
			JSONArray dropDownDataArray = JSONFactoryUtil.createJSONArray();
			JSONArray fieldsData = JSONFactoryUtil.createJSONArray();
			updatePayload.put("subServiceId", subServiceId);
			fieldsDataObject.put("id", id);
			fieldsDataObject.put("code", code);
			fieldsDataObject.put("name", name);
			fieldsDataObject.put("fieldDetailsId", fieldDetailsId); // field don't have this field
			fieldsDataObject.put("fixedValueFlag", fixedValueFlag);
			fieldsDataObject.put("fixedValue", fixedValue);
			fieldsDataObject.put("dateFlag", dateFlag);
			fieldsDataObject.put("dropDownFlag", dropDownFlag);
			fieldsDataObject.put("dropDownData", "");

			JSONObject dropDownData = JSONFactoryUtil.createJSONObject();
			dropDownData.put("id", dropDownId);
			dropDownData.put("code", dropDownCode);
			dropDownData.put("valueAr", dropDownValueAr);
			dropDownData.put("valueEn", dropDownValueEn);
			dropDownData.put("relatedFieldCode", relatedFieldCode);
			dropDownData.put("relatedFieldName", relatedFieldName);
			dropDownData.put("relatedFieldId", relatedFieldId);
			dropDownData.put("allowedValues", allowedValues);
			dropDownDataArray.put(dropDownData);

			fieldsDataObject.put("dropDownData", dropDownDataArray);
			fieldsData.put(fieldsDataObject);
			updatePayload.put("fieldsData", fieldsData);

			configurationEntityLocalService.handleConfigurationChange(portalApiUrl, oldData, updatePayload,
					Constants.UPDATE_MOI_FIELD, Constants.MOI_FIELD, id, serviceContext, user);

	}


	private void callMOIUpdateRequest(String portalApiUrl, JSONObject updatePayload,String languageId)
	{
		try {

			URL url = new URL(portalApiUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.addRequestProperty("Language", languageId);
			connection.setRequestProperty("Content-Type", "application/json");

			connection.setDoOutput(true);
			try (OutputStream os = connection.getOutputStream()) {
				byte[] input = updatePayload.toJSONString().getBytes("utf-8");
				os.write(input, 0, input.length);
			}

			int responseCode = connection.getResponseCode();

			LOG.info("MOI update API response code: " + responseCode);

		} catch (Exception e) {
			LOG.error("Error while calling service update for URL: " + portalApiUrl);
			throw new RuntimeException("Error while calling MOI update API: " + e.getMessage(), e);
		}


	}
	private void callMOIFieldUpdateRequest(String portalApiUrl, JSONObject updatePayload)
	{
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

			LOG.info("MOI field update API response code: " + responseCode);
		} catch (Exception e) {
			LOG.error("Error while calling service update for URL: " + portalApiUrl);
			throw new RuntimeException("Error while calling MOI field update API: " + e.getMessage(), e);
		}

	}

	public void callMOIDeleteRequest(String ordersApiUrl) {
		try {
			URL url = new URL(ordersApiUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("DELETE");

			int responseCode = connection.getResponseCode();

			if (responseCode == 200) {
				LOG.info("MOI delete API call successful with response code: " + responseCode);
			} else {
				LOG.info("MOI delete API call failed with response code: " + responseCode);
				throw new RuntimeException("MOI delete API call failed with response code: " + responseCode);
			}
		} catch (Exception e) {
			 LOG.error("Error while calling service update for URL: " + ordersApiUrl);
			 throw new RuntimeException("Error while calling MOI delete API: " + e.getMessage(), e);
		}
	}
	public void handleDeleteMOIBiller(String portalApiUrl, String id, String oldBillerId,
			String oldBillerCode, String oldBillerName, ServiceContext serviceContext, User user)
			throws PortalException, JsonProcessingException {

		// Create oldData JSON object with all old values for comparison
		JSONObject oldData = JSONFactoryUtil.createJSONObject();
		oldData.put("id", oldBillerId);
		oldData.put("serviceCode", oldBillerCode);
		oldData.put("serviceName", oldBillerName);


		configurationEntityLocalService.handleConfigurationChange(portalApiUrl, oldData, null,
				Constants.DELETE_MOI_BILLER, Constants.MOI_BILLER, id, serviceContext, user);
	}

	public void handleDeleteMOIService(String portalApiUrl, String id, String oldSubServiceId,
			String oldSubServiceCode, String oldSubServiceName, String oldMoiServiceId, String oldBillerName,
			ServiceContext serviceContext, User user) throws PortalException, JsonProcessingException {

		JSONObject oldData = JSONFactoryUtil.createJSONObject();
		oldData.put("subServiceId", oldSubServiceId);
		oldData.put("subServiceCode", oldSubServiceCode);
		oldData.put("subServiceName", oldSubServiceName);
		oldData.put("billerId", oldMoiServiceId);
		oldData.put("billerName", oldBillerName);

		configurationEntityLocalService.handleConfigurationChange(portalApiUrl, oldData, null,
				Constants.DELETE_MOI_SERVICE, Constants.MOI_SERVICE, id, serviceContext, user);
	}

	private void deleteMOIBiller(String deleteUrl, String id) {
		String url = deleteUrl + id;
		callMOIDeleteRequest(url);
	}

	public void handleApprovedConfigEntity(ConfigurationEntity configurationEntity, ServiceContext serviceContext) throws JSONException {
		String action = configurationEntity.getWorkflowAction();
		switch (action) {
			case Constants.UPDATE_MOI_BILLER: {
				String languageId = GetterUtil.getString(serviceContext.getAttribute("languageId"));
				LOG.info("Calling MOI update API for Biller with URL: " + configurationEntity.getUrl() + " and payload: " + configurationEntity.getNewData() + " and languageId: " + languageId);
				callMOIUpdateRequest(configurationEntity.getUrl(), JSONFactoryUtil.createJSONObject(configurationEntity.getNewData()), languageId);
				LOG.info("MOI Biller updated successfully");
				break;
			}
			case Constants.DELETE_MOI_BILLER:
				LOG.info("Calling MOI delete API for Biller with URL: " + configurationEntity.getUrl() + " and ID: " + configurationEntity.getEntityId());
				deleteMOIBiller(configurationEntity.getUrl(), configurationEntity.getEntityId());
				LOG.info("MOI Biller deleted successfully");
				break;
			case Constants.UPDATE_MOI_SERVICE: {
				String languageId = GetterUtil.getString(serviceContext.getAttribute("languageId"));
				LOG.info("Calling MOI update API for Service with URL: " + configurationEntity.getUrl() + " and payload: " + configurationEntity.getNewData() + " and languageId: " + languageId);
				callMOIUpdateRequest(configurationEntity.getUrl(), JSONFactoryUtil.createJSONObject(configurationEntity.getNewData()), languageId);
				LOG.info("MOI Service updated successfully");
				break;
			}
			case Constants.DELETE_MOI_SERVICE:
				LOG.info("Calling MOI delete API for Service with URL: " + configurationEntity.getUrl() + " and ID: " + configurationEntity.getEntityId());
				deleteMOIBiller(configurationEntity.getUrl(), configurationEntity.getEntityId());
				LOG.info("MOI Service  deleted successfully");
				break;
			case Constants.UPDATE_MOI_FIELD: {
				LOG.info("Calling MOI update API for Field with URL: " + configurationEntity.getUrl() + " and payload: " + configurationEntity.getNewData());
				callMOIFieldUpdateRequest(configurationEntity.getUrl(), JSONFactoryUtil.createJSONObject(configurationEntity.getNewData()));
				LOG.info("MOI Field updated successfully");
				break;
			}
		}
	}

}