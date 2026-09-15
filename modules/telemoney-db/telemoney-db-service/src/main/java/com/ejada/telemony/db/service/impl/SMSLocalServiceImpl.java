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
import com.ejada.telemony.db.service.base.SMSLocalServiceBaseImpl;
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
import java.util.Base64;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * The implementation of the sms local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.ejada.telemony.db.service.SMSLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SMSLocalServiceBaseImpl
 */
public class SMSLocalServiceImpl extends SMSLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.ejada.telemony.db.service.SMSLocalService</code> via injection or a
	 * <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.ejada.telemony.db.service.SMSLocalServiceUtil</code>.
	 */
	private static final Log LOG = LogFactoryUtil.getLog(SMSLocalServiceImpl.class);

	public String getAdminPortalData(String ordersApiUrl,String XCorrelationId,String userName,String password) {
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
			connection.setRequestMethod("GET");
			connection.addRequestProperty("x-correlation-id",XCorrelationId );

			
			// Encode the username and password in Base64
			String credentials = Base64.getEncoder().encodeToString((userName + ":" + password).getBytes());

			// Set the "Authorization" header with Basic Authentication
			connection.setRequestProperty("Authorization", "Basic " + credentials);

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

	public String getAllSMS(String smsGetUrl,String XCorrelationId,String userName,String password) {

		//String smsURL = "http://192.168.215.114:17491/api/v1/sms";
		return getAdminPortalData(smsGetUrl,XCorrelationId,userName,password);
	}

	private String handleServiceUpdate(String portalApiUrl,String XCorrelationId,JSONObject updatePayload) {
		try {
			URL url = new URL(portalApiUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("PUT");
			connection.addRequestProperty("x-correlation-id", XCorrelationId);

			connection.setRequestProperty("Content-Type", "application/json");
			connection.setDoOutput(true);

			try (OutputStream os = connection.getOutputStream()) {
				byte[] input = updatePayload.toJSONString().getBytes("utf-8");
				os.write(input, 0, input.length);
			}

			int responseCode = connection.getResponseCode();

			return Integer.toString(responseCode);

		} catch (Exception e) {
			LOG.error("Error while calling service update for URL: " + portalApiUrl);
			throw new RuntimeException("Error while calling service update: " + e.getMessage(), e);
		}

	}

	public void updateSMSServiceId(String smsURL, String oldServiceId, String newServiceId
			, String serviceRequestParam1, String serviceRequestParam2, String XCorrelationId, String eventCode, User user, ServiceContext serviceContext) throws PortalException, JsonProcessingException {
		//String smsURL = "http://192.168.215.114:17491/api/v1/sms/service-id";
		//String requestParam1 = "oldServiceId";
		//String requestParam2 = "newServiceId";
		JSONObject updatePayload = JSONFactoryUtil.createJSONObject();
		updatePayload.put(serviceRequestParam1, oldServiceId);
		updatePayload.put(serviceRequestParam2, newServiceId);

		// Prepare old payload for workflow comparison
		JSONObject oldPayload = JSONFactoryUtil.createJSONObject();
		oldPayload.put(serviceRequestParam1, oldServiceId);
		oldPayload.put(serviceRequestParam2, oldServiceId);
		serviceContext.setAttribute("XCorrelationId", XCorrelationId);
		configurationEntityLocalService.handleConfigurationChange(smsURL,oldPayload,updatePayload, Constants.UPDATE_SMS,Constants.SMS,eventCode,serviceContext,user);
	}

	public void updateSMSDescByServiceId(String smsURL,String serviceId, String newEventDescription
			,String oldEventDescription,String descriptionRequestParam1,String descriptionRequestParam2,String XCorrelationId, String eventCode,User user, ServiceContext serviceContext) throws PortalException, JsonProcessingException {
		//String smsURL = "http://192.168.215.114:17491/api/v1/sms/description";
		//String requestParam1 = "serviceId";
		//String requestParam2 = "newEventDescription";
		JSONObject updatePayload = JSONFactoryUtil.createJSONObject();
		updatePayload.put(descriptionRequestParam1, serviceId);
		updatePayload.put(descriptionRequestParam2, newEventDescription);

		// Prepare old payload for workflow comparison
		JSONObject oldPayload = JSONFactoryUtil.createJSONObject();
		oldPayload.put(descriptionRequestParam1, serviceId);
		oldPayload.put(descriptionRequestParam2, oldEventDescription);
		serviceContext.setAttribute("XCorrelationId", XCorrelationId);
		configurationEntityLocalService.handleConfigurationChange(smsURL,oldPayload,updatePayload, Constants.UPDATE_SMS,Constants.SMS,eventCode,serviceContext,user);
	}

	public void updateSMSServiceIdAndDesc(String smsURLServiceUpdate,
										  String smsURLDescriptionUpdate,
										  String oldServiceId,
										  String serviceId,
										  String serviceRequestParam1,
										  String serviceRequestParam2,
										  String eventDescription,
										  String oldEventDescription,
										  String descriptionRequestParam1,
										  String descriptionRequestParam2,
										  String XCorrelationId,
										  String eventCode,
										  User user,
										  ServiceContext serviceContext)  throws PortalException, JsonProcessingException
	{
		JSONObject newDataJson = JSONFactoryUtil.createJSONObject();
		JSONObject oldDataJson = JSONFactoryUtil.createJSONObject();

		JSONObject descUpdateJson = JSONFactoryUtil.createJSONObject();
		descUpdateJson.put(descriptionRequestParam1, oldServiceId);
		descUpdateJson.put(descriptionRequestParam2, eventDescription);

		JSONObject serviceIdUpdateJson = JSONFactoryUtil.createJSONObject();
		serviceIdUpdateJson.put(serviceRequestParam1, oldServiceId);
		serviceIdUpdateJson.put(serviceRequestParam2, serviceId);

		newDataJson.put("newServiceId", serviceId);
		newDataJson.put("newEventDescription", eventDescription);

		oldDataJson.put("newServiceId", oldServiceId);
		oldDataJson.put("newEventDescription", oldEventDescription);

		serviceContext.setAttribute("XCorrelationId", XCorrelationId);
		serviceContext.setAttribute("smsURLServiceUpdate", smsURLServiceUpdate);
		serviceContext.setAttribute("smsURLDescriptionUpdate", smsURLDescriptionUpdate);
		serviceContext.setAttribute("descriptionUpdate", descUpdateJson.toString());
		serviceContext.setAttribute("serviceIdUpdate", serviceIdUpdateJson.toString());




		configurationEntityLocalService.handleConfigurationChange(smsURLServiceUpdate + " , "+smsURLDescriptionUpdate,oldDataJson,newDataJson, Constants.UPDATE_SMS_SERVICE_DESC,Constants.SMS,eventCode,serviceContext,user);

	}


	public void handleApprovedConfigEntity(ConfigurationEntity configurationEntity,ServiceContext serviceContext) throws JSONException {
		String action = configurationEntity.getWorkflowAction();
		String xCorrelationId = (String) serviceContext.getAttribute("XCorrelationId");
		String response="";
		String descriptionResponse="";
		switch (action) {
			case Constants.UPDATE_SMS:
				LOG.info("Handling update sms request for URL: " + configurationEntity.getUrl() + " with data: " + configurationEntity.getNewData());
				JSONObject payload = JSONFactoryUtil.createJSONObject(configurationEntity.getNewData());
				response = handleServiceUpdate(configurationEntity.getUrl(),xCorrelationId, payload);
				LOG.info("Completed handling update sms request ");
				break;

			case Constants.UPDATE_SMS_SERVICE_DESC:
				JSONObject serviceUpdateJson = JSONFactoryUtil.createJSONObject((String) serviceContext.getAttribute("serviceIdUpdate"));
				JSONObject descriptionUpdateJson = JSONFactoryUtil.createJSONObject((String) serviceContext.getAttribute("descriptionUpdate"));

				String smsURLServiceUpdate = (String) serviceContext.getAttribute("smsURLServiceUpdate");
				String smsURLDescriptionUpdate = (String) serviceContext.getAttribute("smsURLDescriptionUpdate");
				LOG.info("Handling update sms service id request for URL: " + smsURLServiceUpdate + " with data: " +serviceUpdateJson);
				LOG.info("Handling update sms description request for URL: " +smsURLDescriptionUpdate+ " with data: " + descriptionUpdateJson);

				response =handleServiceUpdate(smsURLServiceUpdate,xCorrelationId, serviceUpdateJson);
				descriptionResponse = handleServiceUpdate(smsURLDescriptionUpdate,xCorrelationId, descriptionUpdateJson);
				LOG.info("Completed handling update sms request ");


//				if (serviceIdResponse.equals("500") || serviceIdResponse.equals("400") || descriptionResponse.equals("500")
//					|| descriptionResponse.equals("400")) {
//				SessionErrors.add(actionRequest, "error");
//			}
			default:
				break;
		}
		if (response.equals("500") || response.equals("400") || descriptionResponse.equals("500")
					|| descriptionResponse.equals("400"))
		{
//				SessionErrors.add(actionRequest, "error");
		}
	}
}