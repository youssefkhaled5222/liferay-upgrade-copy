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

import com.ejada.telemoney.db.dto.IvrEventsRequestDto;
import com.ejada.telemony.db.constants.Constants;
import com.ejada.telemony.db.model.ConfigurationEntity;
import com.ejada.telemony.db.service.base.IVRLocalServiceBaseImpl;
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
 * The implementation of the ivr local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.ejada.telemony.db.service.IVRLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IVRLocalServiceBaseImpl
 */
public class IVRLocalServiceImpl extends IVRLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.ejada.telemony.db.service.IVRLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ejada.telemony.db.service.IVRLocalServiceUtil</code>.
	 */
	private static final Log LOG = LogFactoryUtil.getLog(IVRLocalServiceImpl.class);

	public String getAdminPortalData(String portalApiUrl, String XCorrelationId,String userName,String password) {
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
			URL url = null;
				url = new URL(portalApiUrl);
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
	
	public String getAllIVREvents(String portalApiUrl,String XCorrelationId,String userName,String password) {
		return getAdminPortalData(portalApiUrl,XCorrelationId,userName,password);
	}
	
	private String callServiceUpdate(String portalApiUrl,JSONObject updatePayload, String XCorrelationId ) {
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

	public void updateIVREvent(String requestParam1, String requestParam2,
								 String requestParam3, String requestParam4, String requestParam5, String requestParam6,
								 String portalApiUrl, IvrEventsRequestDto  ivrEventsRequestDto ,
								 IvrEventsRequestDto oldData, String XCorrelationId, ServiceContext serviceContext , User user) throws PortalException, JsonProcessingException {

		JSONObject updatePayload = JSONFactoryUtil.createJSONObject();
		updatePayload.put(requestParam1, ivrEventsRequestDto.getEventCode());
		updatePayload.put(requestParam2, ivrEventsRequestDto.getEventClass());
		updatePayload.put(requestParam3, ivrEventsRequestDto.getEventSubClass());
		updatePayload.put(requestParam4, ivrEventsRequestDto.getEventName());
		updatePayload.put(requestParam5, ivrEventsRequestDto.getEventSource());
		updatePayload.put(requestParam6, ivrEventsRequestDto.getEventType());

		JSONObject oldDataJson = JSONFactoryUtil.createJSONObject();
		oldDataJson.put(requestParam1, oldData.getEventCode());
		oldDataJson.put(requestParam2, oldData.getEventClass());
		oldDataJson.put(requestParam3, oldData.getEventSubClass());
		oldDataJson.put(requestParam4, oldData.getEventName());
		oldDataJson.put(requestParam5, oldData.getEventSource());
		oldDataJson.put(requestParam6, oldData.getEventType());


		serviceContext.setAttribute("xCorrelationId", XCorrelationId);
		configurationEntityLocalService.handleConfigurationChange(
				portalApiUrl, oldDataJson, updatePayload, Constants.UPDATE_IVR, Constants.IVR, ivrEventsRequestDto.getEventCode(), serviceContext, user);
	}

	public void handleApprovedConfigEntity(ConfigurationEntity configurationEntity, ServiceContext serviceContext) throws JSONException {
		String action = configurationEntity.getWorkflowAction();
		String xCorrelationId = (String) serviceContext.getAttribute("xCorrelationId");
		if (action.equals(Constants.UPDATE_IVR)) {
			LOG.info("Handling update IVR request for URL: " + configurationEntity.getUrl() + " with data: " + configurationEntity.getNewData());
			callServiceUpdate(configurationEntity.getUrl(), JSONFactoryUtil.createJSONObject(configurationEntity.getNewData()),xCorrelationId);
			LOG.info("Completed handling update error code request ");
		} else {
			throw new IllegalArgumentException("Unsupported workflow action: " + action);
		}
	}
}