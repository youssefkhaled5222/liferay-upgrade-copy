package com.ejada.telemoney.lovsApi.application;

import com.ejada.telemoney.db.constants.LanguageValues;
import com.ejada.telemoney.db.constants.TelemoneyConstants;
import com.ejada.telemony.db.service.ChannelsLocalService;
import com.ejada.telemony.db.service.LovsLocalService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

/**
 * @author adardir
 */
@Component(property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/lov",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Lovs.Rest", "oauth2.scopechecker.type=none",
		"auth.verifier.guest.allowed=true", }, service = Application.class)
public class LovsApisApplication extends Application {

	private static final Log LOG = LogFactoryUtil.getLog(LovsApisApplication.class);
	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getLovsAndData(String jsonRequest, @HeaderParam("language") String language,
			@HeaderParam("channel") String channel) {

		
		LOG.info("----------------LOV API-----------------");
		LOG.info("Channel Id: "+ channel);
		LOG.info("Language: "+ language);
		LOG.info("----------------Request Body-----------------");
		LOG.info(jsonRequest);
		
		JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
		JSONObject header = JSONFactoryUtil.createJSONObject();
		JSONArray response = JSONFactoryUtil.createJSONArray();

		jsonResponse.put("header", header);
		jsonResponse.put("body", response);

		if (channel == null) {
			header.put("statusCode", TelemoneyConstants.STATUS_CODE_MISSING_CHANNEL);
			header.put("statusDescription", TelemoneyConstants.STATUS_DESC_MISSING_CHANNEL);
			LOG.info("----------------Response Body-----------------");
			LOG.info(jsonResponse);
			return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
		} else if (language == null ) {
			header.put("statusCode", TelemoneyConstants.STATUS_CODE_MISSING_LANGUAGE);
			header.put("statusDescription", TelemoneyConstants.STATUS_DESC_MISSING_LANGUAGE);
			LOG.info("----------------Response Body-----------------");
			LOG.info(jsonResponse);
			return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
		}
		try {

			long startTime = System.nanoTime(); // Start time measurement
			long channelId = Long.parseLong(channel);
			if (!_channelLocalService.ifExist(channelId)) {
				header.put("statusCode", TelemoneyConstants.STATUS_CODE_UNKNOWN_CHANNEL);
				header.put("statusDescription", TelemoneyConstants.STATUS_DESC_UNKNOWN_CHANNEL +" "+ channelId);
				LOG.info("----------------Response Body-----------------");
				LOG.info(jsonResponse);
				return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
			}
			

			ObjectMapper objectMapper = new ObjectMapper();
			RequestBodyLovs requestBody = objectMapper.readValue(jsonRequest, RequestBodyLovs.class);

			String idss = requestBody.getIds();
			String[] sa = idss.split(",");
			Set<String> ids = new HashSet<>(Arrays.asList(sa));
			
			String languageName = LanguageValues.valueOf(language).getLanguage();
			for (String id : ids) {
				response.put(_lovsLocalService.getLovsAndRelatedDataByCode(id, languageName, channelId));

			}

			
			
			jsonResponse.put("body", response);
			header.put("statusCode", TelemoneyConstants.STATUS_CODE_SUCCESS);
			header.put("statusDescription", TelemoneyConstants.STATUS_DESC_SUCCESS);

			long endTime = System.nanoTime(); // End time measurement

			// Calculate the time difference in milliseconds
			long duration = (endTime - startTime) / 1_000_000;
			LOG.info("LOV Time taken: " + duration + " ms");
			
			return Response.ok(jsonResponse.toString()).build();

		} catch (JsonMappingException e) {
			LOG.info("----------------Response Body-----------------");
			LOG.info(jsonResponse);
			e.printStackTrace();
			header.put("status", "Bad Request");
			header.put("message", "Please provide valid parameters in body");
			return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			LOG.info("----------------Response Body-----------------");
			LOG.info(jsonResponse);
			e.printStackTrace();
			header.put("status", "Bad Request");
			header.put("message", "Please provide valid json format");
			return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOG.info("----------------Response Body-----------------");
			LOG.info(jsonResponse);
			e.printStackTrace();
			header.put("status", "Internal Server Error");
			header.put("message", e.getMessage());
			return Response.serverError().entity(jsonResponse.toString()).build();
		}

	}

	@Reference
	LovsLocalService _lovsLocalService;
	@Reference
	private ChannelsLocalService _channelLocalService;
}