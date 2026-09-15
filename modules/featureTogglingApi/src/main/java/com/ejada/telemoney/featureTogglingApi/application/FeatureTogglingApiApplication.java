package com.ejada.telemoney.featureTogglingApi.application;

import com.ejada.telemoney.db.constants.TelemoneyConstants;
import com.ejada.telemony.db.model.Channels;
import com.ejada.telemony.db.service.ChannelsLocalService;
import com.ejada.telemony.db.service.FeatureLocalService;
import com.ejada.telemony.db.service.GlobalVersionLocalService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

/**
 * @author ShathaAR
 */
@Component(property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/feature",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Feature.Rest", "oauth2.scopechecker.type=none",
		"auth.verifier.guest.allowed=true",

}, service = Application.class)
public class FeatureTogglingApiApplication extends Application {

	private static final Log LOG = LogFactoryUtil.getLog(FeatureTogglingApiApplication.class);

	/**
	 * componentName value stored in the {@code GlobalVersion} table for the
	 * localization component. Matches {@code ComponentType.localizationVersion}.
	 */
	private static final String FEATURE_TOGGLE_COMPONENT_NAME = "FEATURE_TOGGLE";

	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getAllFeaturesForSegment(@HeaderParam("channel") String channel, String jsonRequest) {
		long time1 = System.currentTimeMillis();

		LOG.info("------------------- Feature Toggling API -------------------");
		LOG.info("------------------- Request Header -------------------");
		LOG.info("Channel: " + channel);
		LOG.info("------------------- Request Body -------------------");
		LOG.info("Segmnet Name: " + jsonRequest);

		JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
		JSONObject header = JSONFactoryUtil.createJSONObject();
		JSONObject body = JSONFactoryUtil.createJSONObject();
		JSONArray response = JSONFactoryUtil.createJSONArray();
		jsonResponse.put("header", header);
		jsonResponse.put("body", response);

		if (channel == null) {
			header.put("statusCode", TelemoneyConstants.STATUS_CODE_MISSING_CHANNEL);
			header.put("statusDescription", TelemoneyConstants.STATUS_DESC_MISSING_CHANNEL);
			LOG.info("------------------- Feature Toggling Response -------------------");
			LOG.info(jsonResponse);
			LOG.info("FT API Time: " + String.valueOf(System.currentTimeMillis() - time1));
			return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
		} else {
			long channelId = Long.parseLong(channel);
			if (!_channelLocalService.ifExist(channelId)) {
				header.put("statusCode", TelemoneyConstants.STATUS_CODE_UNKNOWN_CHANNEL);
				header.put("statusDescription", TelemoneyConstants.STATUS_DESC_UNKNOWN_CHANNEL + " " + channelId);
				LOG.info("------------------- Feature Toggling Response -------------------");
				LOG.info(jsonResponse);
				LOG.info("FT API Time: " + String.valueOf(System.currentTimeMillis() - time1));
				return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
			}
		}
		try {

			ObjectMapper objectMapper = new ObjectMapper();

			FeatureRequestBody requestBody = objectMapper.readValue(jsonRequest, FeatureRequestBody.class);

			String segmentName = null;
			String deviceType = null;
			String deviceVersion = null;

			if (requestBody.getSegmentName() == null) {
				header.put("statusCode", TelemoneyConstants.STATUS_CODE_MISSING_PARAMETERS);
				header.put("statusDescription", TelemoneyConstants.STATUS_DESC_MISSING_PARAMETERS);
				LOG.info("------------------- Feature Toggling Response -------------------");
				LOG.info(jsonResponse);
				LOG.info("FT API Time: " + String.valueOf(System.currentTimeMillis() - time1));
				return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
			} else {
				segmentName = requestBody.getSegmentName();
			}

			if (requestBody.getDeviceType() == null) {
				header.put("statusCode", TelemoneyConstants.STATUS_CODE_MISSING_PARAMETERS);
				header.put("statusDescription", TelemoneyConstants.STATUS_DESC_MISSING_PARAMETERS);
				LOG.info("------------------- Feature Toggling Response -------------------");
				LOG.info(jsonResponse);
				LOG.info("FT API Time: " + String.valueOf(System.currentTimeMillis() - time1));
				return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
			} else {
				deviceType = requestBody.getDeviceType();
			}

			if (requestBody.getDeviceVersion() == null) {
				header.put("statusCode", TelemoneyConstants.STATUS_CODE_MISSING_PARAMETERS);
				header.put("statusDescription", TelemoneyConstants.STATUS_DESC_MISSING_PARAMETERS);
				LOG.info("------------------- Feature Toggling Response -------------------");
				LOG.info(jsonResponse);
				LOG.info("FT API Time: " + String.valueOf(System.currentTimeMillis() - time1));
				return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
			} else {
				deviceVersion = requestBody.getDeviceVersion();
			}

			JSONArray result = _featureLocalService.getAllFeaturesForSegment(Long.parseLong(channel), segmentName,
					deviceType, deviceVersion);
			header.put("statusCode", TelemoneyConstants.STATUS_CODE_SUCCESS);
			header.put("statusDescription", TelemoneyConstants.STATUS_DESC_SUCCESS);

			body.put("features", result);

			jsonResponse.put("header", header);
			jsonResponse.put("body", body);

			LOG.info("------------------- Feature Toggling Response -------------------");
			LOG.info(jsonResponse);
			LOG.info("FT API Time: " + String.valueOf(System.currentTimeMillis() - time1));
			return Response.ok(jsonResponse.toString()).build();
		} catch (NumberFormatException e) {
			LOG.error("Invalid channel header in Feature Toggling request", e);
			header.put("statusCode", TelemoneyConstants.STATUS_CODE_INVALID_HEADERS);
			header.put("statusDescription", TelemoneyConstants.STATUS_DESC_INVALID_HEADERS);
			LOG.info("------------------- Feature Toggling Response -------------------");
			LOG.info(jsonResponse);
			LOG.info("FT API Time: " + String.valueOf(System.currentTimeMillis() - time1));
			return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
		} catch (JsonMappingException e) {
			LOG.error("Invalid parameters in Feature Toggling request body", e);
			header.put("statusCode", TelemoneyConstants.STATUS_CODE_INVALID_PARAMETERS);
			header.put("statusDescription", TelemoneyConstants.STATUS_DESC_INVALID_PARAMETERS);
			LOG.info("------------------- Feature Toggling Response -------------------");
			LOG.info(jsonResponse);
			LOG.info("FT API Time: " + String.valueOf(System.currentTimeMillis() - time1));
			return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
		} catch (JsonParseException e) {
			LOG.error("Invalid JSON body in Feature Toggling request", e);
			header.put("statusCode", TelemoneyConstants.STATUS_CODE_INVALID_BODY);
			header.put("statusDescription", TelemoneyConstants.STATUS_DESC_INVALID_BODY);
			LOG.info("------------------- Feature Toggling Response -------------------");
			LOG.info(jsonResponse);
			LOG.info("FT API Time: " + String.valueOf(System.currentTimeMillis() - time1));
			return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
		} catch (Exception e) {
			LOG.error("Error while processing Feature Toggling request", e);
			header.put("statusCode", TelemoneyConstants.STATUS_CODE_ERROR);
			header.put("statusDescription", e.getMessage());
			LOG.info("------------------- Feature Toggling Response -------------------");
			LOG.info(jsonResponse);
			LOG.info("FT API Time: " + String.valueOf(System.currentTimeMillis() - time1));
			return Response.serverError().entity(jsonResponse.toString()).build();
		}
	}

	@GET
	@Path("/v2")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getV2Features(
			@HeaderParam("channel") String channel,
			@QueryParam("whitelist") List<String> whitelistParam,
			@QueryParam("segments") List<String> segmentsParam) {

		long time1 = System.currentTimeMillis();

		LOG.info("------------------- V2 Feature Toggling API -------------------");
		LOG.info("Channel: " + channel);
		LOG.info("Whitelist: " + whitelistParam);
		LOG.info("Segments: " + segmentsParam);

		JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
		JSONObject header = JSONFactoryUtil.createJSONObject();
		JSONObject body = JSONFactoryUtil.createJSONObject();
		jsonResponse.put("header", header);
		jsonResponse.put("body", body);

		if (channel == null || channel.trim().isEmpty()) {
			header.put("statusCode", TelemoneyConstants.STATUS_CODE_MISSING_CHANNEL);
			header.put("statusDescription", TelemoneyConstants.STATUS_DESC_MISSING_CHANNEL);
			LOG.info("V2 FT API Time: " + String.valueOf(System.currentTimeMillis() - time1));
			return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
		}

		try {
			Channels channelEntity = _channelLocalService.getByName(channel);

			if (channelEntity == null) {
				header.put("statusCode", TelemoneyConstants.STATUS_CODE_UNKNOWN_CHANNEL);
				header.put("statusDescription", "No Channel exists with name " + channel);
				LOG.info("V2 FT API Time: " + String.valueOf(System.currentTimeMillis() - time1));
				return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
			}

			long channelId = channelEntity.getChannelId();

			List<String> whitelistFilter = normalizeParam(whitelistParam);
			List<String> segmentsFilter = normalizeParam(segmentsParam);

			JSONObject result = _featureLocalService.getBlueAppFeatures(channelId, whitelistFilter, segmentsFilter);

			header.put("statusCode", TelemoneyConstants.STATUS_CODE_SUCCESS);
			header.put("statusDescription", TelemoneyConstants.STATUS_DESC_SUCCESS);

			long featureToggleVersion = _globalVersionLocalService.getCurrentVersion(
					CompanyThreadLocal.getCompanyId(), channelId, FEATURE_TOGGLE_COMPONENT_NAME);
			body.put("version", featureToggleVersion);
			body.put("features", result);


			LOG.info("------------------- V2 Feature Toggling Response -------------------");
			LOG.info(jsonResponse);
			LOG.info("V2 FT API Time: " + String.valueOf(System.currentTimeMillis() - time1));
			return Response.ok(jsonResponse.toString()).build();
		} catch (Exception e) {
			LOG.error("Error while processing V2 Feature Toggling request", e);
			header.put("statusCode", TelemoneyConstants.STATUS_CODE_ERROR);
			header.put("statusDescription", e.getMessage());
			LOG.info("V2 FT API Time: " + String.valueOf(System.currentTimeMillis() - time1));
			return Response.serverError().entity(jsonResponse.toString()).build();
		}
	}

	private List<String> normalizeParam(List<String> values) {
		List<String> normalized = new ArrayList<>();
		if (values == null) {
			return normalized;
		}
		for (String value : values) {
			if (value == null) {
				continue;
			}
			for (String part : value.split(",")) {
				String trimmed = part.trim();
				if (!trimmed.isEmpty()) {
					normalized.add(trimmed);
				}
			}
		}
		return normalized;
	}

	@Reference
	FeatureLocalService _featureLocalService;

	@Reference
	private ChannelsLocalService _channelLocalService;


	@Reference
	private GlobalVersionLocalService _globalVersionLocalService;
}