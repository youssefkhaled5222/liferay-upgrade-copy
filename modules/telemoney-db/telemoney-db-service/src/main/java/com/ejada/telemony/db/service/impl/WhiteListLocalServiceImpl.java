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

import com.ejada.telemony.db.service.base.WhiteListLocalServiceBaseImpl;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.*;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

/**
 * The implementation of the white list local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.ejada.telemony.db.service.WhiteListLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WhiteListLocalServiceBaseImpl
 */
public class WhiteListLocalServiceImpl extends WhiteListLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.ejada.telemony.db.service.WhiteListLocalService</code> via
	 * injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.ejada.telemony.db.service.WhiteListLocalServiceUtil</code>.
	 */

	public String getWhiteListed(String getAllWhiteListed,String XCorrelationId, String fromDt, String toDt, String poi, String poiType,
			String cif, String nameEn, String nameAr, String mobile, String allow) {

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
		        
			URL url = new URL(getAllWhiteListed);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.addRequestProperty("X-Correlation-id", XCorrelationId);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setDoOutput(true);

			JSONObject WhiteListGetRequestParams = JSONFactoryUtil.createJSONObject();
			WhiteListGetRequestParams.put("fromDt", fromDt);
			WhiteListGetRequestParams.put("toDt", toDt);
			WhiteListGetRequestParams.put("poi", poi.isEmpty()? org.json.JSONObject.NULL:poi);
			WhiteListGetRequestParams.put("poiType", poiType.isEmpty()? org.json.JSONObject.NULL:poiType);
			WhiteListGetRequestParams.put("cif", cif.isEmpty()? org.json.JSONObject.NULL:cif);
			WhiteListGetRequestParams.put("nameEn", nameEn.isEmpty()? org.json.JSONObject.NULL:nameEn);
			WhiteListGetRequestParams.put("nameAr", nameAr.isEmpty()? org.json.JSONObject.NULL:nameAr);
			WhiteListGetRequestParams.put("mobile", mobile.isEmpty()? org.json.JSONObject.NULL:mobile);
			WhiteListGetRequestParams.put("allow", allow.isEmpty()? org.json.JSONObject.NULL:allow);
			WhiteListGetRequestParams.put("notify", org.json.JSONObject.NULL);
			
			LOG.info("WhiteListGetRequestParams: " + WhiteListGetRequestParams + "in localService");

			try (OutputStream os = connection.getOutputStream()) {
				byte[] input = WhiteListGetRequestParams.toJSONString().getBytes("utf-8");
				os.write(input, 0, input.length);
			}

			int responseCode = connection.getResponseCode();
			LOG.info("responseCode: "+responseCode);
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
				LOG.info("response: " + response.toString() + "in localService");
				return response.toString();
			} else {

				return null;
			}

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}


	}
	
	public String updateCustomerStatus(String UpdateURL,String XCorrelationId,String poi, String allow) {
		
		try {
		URL url = new URL(UpdateURL);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("PUT");
		connection.addRequestProperty("X-Correlation-Id", XCorrelationId);
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setDoOutput(true);

		JSONObject updatePayload = JSONFactoryUtil.createJSONObject();
		updatePayload.put("poi", poi);
		updatePayload.put("allow", allow);
		
		try (OutputStream os = connection.getOutputStream()) {
			byte[] input = updatePayload.toJSONString().getBytes("utf-8");
			os.write(input, 0, input.length);
		}
		
		System.out.println(updatePayload);

		int responseCode = connection.getResponseCode();

		return Integer.toString(responseCode);
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}
	
	private static final Log LOG = LogFactoryUtil.getLog(WhiteListLocalServiceImpl.class);
}