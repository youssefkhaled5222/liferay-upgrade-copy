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

import com.ejada.telemoney.db.dto.EsbConstantRequestDto;
import com.ejada.telemony.db.constants.Constants;
import com.ejada.telemony.db.model.ConfigurationEntity;
import com.ejada.telemony.db.service.SMSLocalServiceUtil;
import com.ejada.telemony.db.service.base.ESBLocalServiceBaseImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

/**
 * The implementation of the esb local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.ejada.telemony.db.service.ESBLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ESBLocalServiceBaseImpl
 */
public class ESBLocalServiceImpl extends ESBLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.ejada.telemony.db.service.ESBLocalService</code> via injection or a
	 * <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.ejada.telemony.db.service.ESBLocalServiceUtil</code>.
	 */
	private static final Log LOG = LogFactoryUtil.getLog(ESBLocalServiceImpl.class);

	public String getConstantList(String esbUrl,String XCorrelationId,String userName,String password) {
		//String Url = "http://192.168.215.114:17950/constants/list";
		return SMSLocalServiceUtil.getAdminPortalData(esbUrl,XCorrelationId,userName,password);
	}

	public String getESBConstantsReload(String esbReloadUrl,String XCorrelationId,String userName,String password) {
		//String Url = "http://192.168.215.114:17950/constants/reload";
		return SMSLocalServiceUtil.getAdminPortalData(esbReloadUrl,XCorrelationId,userName,password);
	}

	public String getConstantListSearch(String searchUrl,String getSearchkeyword,String XCorrelationId,String userName,String password) {
		
		// "http://192.168.215.114:17950/constants/"
	    StringBuilder urlBuilder = new StringBuilder(searchUrl)
	                                    .append(getSearchkeyword)
	                                    .append("/get");

	    String url = urlBuilder.toString();
	    
	    return SMSLocalServiceUtil.getAdminPortalData(url,XCorrelationId,userName,password);
	}

	public String getESBConstantsReloadSearch(String entityReloadUrl,String reloadSearchkeyword,String XCorrelationId,String userName,String password) {
		//   "http://192.168.215.114:17950/constants/"
		String Url = entityReloadUrl + reloadSearchkeyword + "/reload";
		return SMSLocalServiceUtil.getAdminPortalData(Url,XCorrelationId,userName,password);
	}

	public void updateESB(String esbUpdateUrl, EsbConstantRequestDto oldData, EsbConstantRequestDto newData , ServiceContext serviceContext, User user) throws PortalException, JsonProcessingException {
		//  "http://192.168.215.114:17950/constants/"
		String smsURL =  esbUpdateUrl+ newData.getSanitizedServiceName() + "/update";
		JSONObject updatePayload = createPayload(newData);
		JSONObject oldPayload = createPayload(oldData);
		configurationEntityLocalService.handleConfigurationChange(smsURL,oldPayload,updatePayload, Constants.UPDATE_ESB_CONSTANT, Constants.ESB_CONSTANT,newData.getServiceName() ,serviceContext, user);
	}

	public String callServiceUpdate(String portalApiUrl, JSONObject updatePayload) {
		try {
			URL url = new URL(portalApiUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("PUT");
			connection.addRequestProperty("x-correlation-id", "1234");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setDoOutput(true);
			String username = "TeleMoneyWrapper";
			String password = "9(Te1cwdM7K071DQ,qwCZ+xtF[5jmBRd";
			// Encode the username and password in Base64
			String credentials = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
			// Set the "Authorization" header with Basic Authentication
			connection.setRequestProperty("Authorization", "Basic " + credentials);
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

	public void handleApprovedConfigEntity(ConfigurationEntity configurationEntity, ServiceContext serviceContext) throws JSONException {
		String action = configurationEntity.getWorkflowAction();
        if (action.equals(Constants.UPDATE_ESB_CONSTANT)) {
            LOG.info("Handling update esb constant request for URL: " + configurationEntity.getUrl() + " with data: " + configurationEntity.getNewData());
            callServiceUpdate(configurationEntity.getUrl(), JSONFactoryUtil.createJSONObject(configurationEntity.getNewData()));
            LOG.info("Completed handling update error code request ");
        } else {
            throw new IllegalArgumentException("Unsupported workflow action: " + action);
        }
	}

	private JSONObject createPayload(EsbConstantRequestDto esbConstantRequestDto)
	{
		JSONObject updatePayload = JSONFactoryUtil.createJSONObject();
		updatePayload.put("FuncId", esbConstantRequestDto.getFuncId());
		updatePayload.put("Ip", esbConstantRequestDto.getIp());
		updatePayload.put("Port", esbConstantRequestDto.getPort());
		updatePayload.put("Path", esbConstantRequestDto.getPath());
		updatePayload.put("SCId", esbConstantRequestDto.getScId());
		updatePayload.put("BranchId", esbConstantRequestDto.getBranchId());
		updatePayload.put("BranchName", esbConstantRequestDto.getBranchName());
		updatePayload.put("UserId", esbConstantRequestDto.getUserId());
		updatePayload.put("AgentId", esbConstantRequestDto.getAgentId());
		updatePayload.put("SecInfo", esbConstantRequestDto.getSecInfo());
		updatePayload.put("SecInfoType", esbConstantRequestDto.getSecInfoType());
		updatePayload.put("Version", esbConstantRequestDto.getVersion());
		return updatePayload;
	}



}