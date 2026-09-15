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
import com.ejada.telemony.db.service.base.ConfigurationLocalServiceBaseImpl;
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
import java.util.Base64;

/**
 * The implementation of the configuration local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.ejada.telemony.db.service.ConfigurationLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConfigurationLocalServiceBaseImpl
 */
public class ConfigurationLocalServiceImpl
        extends ConfigurationLocalServiceBaseImpl {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. Use <code>com.ejada.telemony.db.service.ConfigurationLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ejada.telemony.db.service.ConfigurationLocalServiceUtil</code>.
     */

	private static final Log LOG = LogFactoryUtil.getLog(ConfigurationLocalServiceImpl.class);

	public String getAdminPortalData(String portalApiUrl, String userName, String password) {
        try {
            URL url = null;
            url = new URL(portalApiUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");


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

    public String getAllConfigurations(String portalApiUrl, String userName, String password) {
        return getAdminPortalData(portalApiUrl, userName, password);
    }

    private String callServiceUpdate(String portalApiUrl, JSONObject updatePayload) {
        try {
            URL url = new URL(portalApiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");

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

    public void updateConfiguration(String requestParam1, String requestParam2,
                                      String portalApiUrl, String key, String newValue, String oldKey, String oldValue, ServiceContext serviceContext, User user) throws PortalException, JsonProcessingException {

        JSONObject updatePayload = JSONFactoryUtil.createJSONObject();
        updatePayload.put(requestParam1, key);
        updatePayload.put(requestParam2, newValue);

        JSONObject oldPayload = JSONFactoryUtil.createJSONObject();
        oldPayload.put(requestParam1, oldKey);
        oldPayload.put(requestParam2, oldValue);

        configurationEntityLocalService.handleConfigurationChange(portalApiUrl, oldPayload, updatePayload, Constants.UPDATE_CONFIGURATION, Constants.CONFIGURATION, key, serviceContext, user);

    }


	public void handleApprovedConfigEntity(ConfigurationEntity configurationEntity, ServiceContext serviceContext) throws JSONException {
		String action = configurationEntity.getWorkflowAction();
		if (action.equals(Constants.UPDATE_CONFIGURATION)) {
			LOG.info("Handling update IVR request for URL: " + configurationEntity.getUrl() + " with data: " + configurationEntity.getNewData());
			callServiceUpdate(configurationEntity.getUrl(), JSONFactoryUtil.createJSONObject(configurationEntity.getNewData()));
			LOG.info("Completed handling update error code request ");
		} else {
			throw new IllegalArgumentException("Unsupported workflow action: " + action);
		}
	}



}