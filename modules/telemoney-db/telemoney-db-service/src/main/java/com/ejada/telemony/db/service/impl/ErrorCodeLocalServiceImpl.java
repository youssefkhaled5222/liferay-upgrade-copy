/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ejada.telemony.db.service.impl;

import com.ejada.telemony.db.constants.Constants;
import com.ejada.telemony.db.model.ConfigurationEntity;
import com.ejada.telemony.db.service.SMSLocalServiceUtil;
import com.ejada.telemony.db.service.base.ErrorCodeLocalServiceBaseImpl;
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
 * The implementation of the error code local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.ejada.telemony.db.service.ErrorCodeLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ErrorCodeLocalServiceBaseImpl
 */
public class ErrorCodeLocalServiceImpl extends ErrorCodeLocalServiceBaseImpl {

    private static final Log LOG = LogFactoryUtil.getLog(ErrorCodeLocalServiceImpl.class);


    public String getAllErrorCodes(String errorCodeUrl, String XCorrelationId, String userName, String password) {

        //String Url = "http://192.168.215.114:17428/api/v1/languages-management/status-code";
        return SMSLocalServiceUtil.getAdminPortalData(errorCodeUrl, XCorrelationId, userName, password);


    }

    public String callServiceUpdate(String portalApiUrl, JSONObject updatePayload, String XCorrelationId) {
        try {
            TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        public X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }

                        public void checkClientTrusted(X509Certificate[] certs, String authType) {
                        }

                        public void checkServerTrusted(X509Certificate[] certs, String authType) {
                        }
                    }
            };

            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // Disable hostname verification
            HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
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

    public void updateErrorCode(String updateCodeURL, String XCorrelationId, String statusCode, String language, String description,
                                String oldStatusCode, String oldLanguage, String oldDescription,
                                ServiceContext serviceContext, User user) throws PortalException, JsonProcessingException {
        //String smsURL = "http://192.168.215.114:17428/api/v1/languages-management/description-details";
        JSONObject updatePayload = JSONFactoryUtil.createJSONObject();
        updatePayload.put("statusCode", statusCode);
        updatePayload.put("language", language);
        updatePayload.put("description", description);

        JSONObject oldData = JSONFactoryUtil.createJSONObject();
        oldData.put("statusCode", oldStatusCode);
        oldData.put("language", oldLanguage);
        oldData.put("description", oldDescription);

        serviceContext.setAttribute("XCorrelationId", XCorrelationId);

        configurationEntityLocalService.handleConfigurationChange(updateCodeURL, oldData, updatePayload, Constants.UPDATE_ERROR_CODE, Constants.ERROR_CODE, statusCode,serviceContext, user);
    }

    public String getAllLanguages(String langURL, String XCorrelationId, String userName, String password) {
        //String langURL= "http://192.168.215.114:17428/api/v1/languages-management/languages";
        return SMSLocalServiceUtil.getAdminPortalData(langURL, XCorrelationId, userName, password);
    }

    public String searchByCode(String searchURL, String code, String XCorrelationId, String userName, String password) {
        //String searchUrl = "http://192.168.215.114:17428/api/v1/languages-management/status-code/"+code;
        String searchUrl = searchURL + "/" + code;
        return SMSLocalServiceUtil.getAdminPortalData(searchUrl, XCorrelationId, userName, password);

    }

    public String searchBycodeAndDesc(String searchURL, String searchType, String searchValue, String LangId, String XCorrelationId, String userName, String password) {
        try {
            URL url = new URL(searchURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.addRequestProperty("X-Correlation-id", XCorrelationId);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // Encode the username and password in Base64
            String credentials = Base64.getEncoder().encodeToString((userName + ":" + password).getBytes());
            JSONObject errorCodeParameters = JSONFactoryUtil.createJSONObject();
            errorCodeParameters.put("language", LangId);
            errorCodeParameters.put(searchType, searchValue);
            // Set the "Authorization" header with Basic Authentication
            connection.setRequestProperty("Authorization", "Basic " + credentials);
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = errorCodeParameters.toJSONString().getBytes("utf-8");
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

    public void handleApprovedConfigEntity(ConfigurationEntity configurationEntity, ServiceContext serviceContext) throws JSONException {
        String action = configurationEntity.getWorkflowAction();
        String xCorrelationId = (String) serviceContext.getAttribute("XCorrelationId");
        switch (action) {
            case Constants.UPDATE_ERROR_CODE:
                LOG.info("Handling update error code request for URL: " + configurationEntity.getUrl() + " with data: " + configurationEntity.getNewData());
                callServiceUpdate(configurationEntity.getUrl(), JSONFactoryUtil.createJSONObject(configurationEntity.getNewData()), xCorrelationId);
                LOG.info("Completed handling update error code request ");
                break;
            default:
                throw new IllegalArgumentException("Unsupported workflow action: " + action);
        }


    }
}