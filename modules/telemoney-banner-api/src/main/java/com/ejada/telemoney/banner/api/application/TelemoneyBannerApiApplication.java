package com.ejada.telemoney.banner.api.application;

import com.ejada.telemoney.db.constants.LanguageValues;
import com.ejada.telemoney.db.constants.TelemoneyConstants;
import com.ejada.telemony.db.service.BannerLocalService;
import com.ejada.telemony.db.service.ChannelsLocalService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Collections;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

/**
 * @author iatef
 */
@Component(property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/banner",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Banners.Rest" }, service = Application.class)
public class TelemoneyBannerApiApplication extends Application {
	private static final Log LOG = LogFactoryUtil.getLog(TelemoneyBannerApiApplication.class);

	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBanners(@HeaderParam("channel") String channel, @HeaderParam("language") String language,
			String jsonRequest) {
		long time1 = System.currentTimeMillis();
		LOG.info("------------------- BANNER API -------------------");
		LOG.info("------------------- Body Request -------------------");
		LOG.info(jsonRequest);
		LOG.info("------------------- Header -------------------");
		LOG.info("Channel: " + channel);
		LOG.info("language: " + language);

		JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
		JSONObject header = JSONFactoryUtil.createJSONObject();
		JSONArray response = JSONFactoryUtil.createJSONArray();

		jsonResponse.put("header", header);
		jsonResponse.put("body", response);
		if (language == null) {
			header.put("statusCode", TelemoneyConstants.STATUS_CODE_MISSING_LANGUAGE);
			header.put("statusDescription", TelemoneyConstants.STATUS_DESC_MISSING_LANGUAGE);
			LOG.info("------------------- BANNER Response -------------------");
			LOG.info(jsonResponse.get("header"));
			LOG.info("Banner API Time: " + String.valueOf(System.currentTimeMillis() - time1));
			return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
		} else if (channel == null) {
			header.put("statusCode", TelemoneyConstants.STATUS_CODE_MISSING_CHANNEL);
			header.put("statusDescription", TelemoneyConstants.STATUS_DESC_MISSING_CHANNEL);
			LOG.info("------------------- BANNER Response -------------------");
			LOG.info(jsonResponse.get("header"));
			LOG.info("Banner API Time: " + String.valueOf(System.currentTimeMillis() - time1));
			return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
		} else if (language != TelemoneyConstants.LANGUAGE_ENGLISH_ID
				|| language != TelemoneyConstants.LANGUAGE_ARABIC_ID) {

		}

		try {
			ObjectMapper objectMapper = new ObjectMapper();
			BannerRequestBody req = objectMapper.readValue(jsonRequest, BannerRequestBody.class);

			if (req.getPlatform() == null) {
				header.put("statusCode", TelemoneyConstants.STATUS_CODE_MISSING_PARAMETERS);
				header.put("statusDescription", TelemoneyConstants.STATUS_DESC_MISSING_PARAMETERS);
				LOG.info(jsonResponse.get("header"));
				LOG.info("------------------- BANNER Response -------------------");
				LOG.info("Banner API Time: " + String.valueOf(System.currentTimeMillis() - time1));
				return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
			}

			long channelId = Long.parseLong(channel);
			if (!_channelLocalService.ifExist(channelId)) {
				header.put("statusCode", TelemoneyConstants.STATUS_CODE_UNKNOWN_CHANNEL);
				header.put("statusDescription", TelemoneyConstants.STATUS_DESC_UNKNOWN_CHANNEL + channelId);
				LOG.info("------------------- BANNER Response -------------------");
				LOG.info(jsonResponse.get("header"));
				LOG.info("Banner API Time: " + String.valueOf(System.currentTimeMillis() - time1));
				return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
			}

			// long languageId = Long.parseLong(language);
			String languageName = LanguageValues.valueOf(language).getLanguage();
			System.out.println(languageName);
			response = _bannerLocalService.getBannersAPI(channelId, languageName, req.getPlatform(), req.getPersonaId(),
					req.getVersion());

			jsonResponse.put("body", response);
			header.put("statusCode", TelemoneyConstants.STATUS_CODE_SUCCESS);
			header.put("statusDescription", TelemoneyConstants.STATUS_DESC_SUCCESS);
			LOG.info("------------------- BANNER Response -------------------");

			LOG.info(jsonResponse.get("header"));
			LOG.info("Banner API Time: " + String.valueOf(System.currentTimeMillis() - time1));
			return Response.ok(jsonResponse.toString()).build();
		} catch (NumberFormatException e) {
			e.printStackTrace();
			header.put("statusCode", TelemoneyConstants.STATUS_CODE_INVALID_HEADERS);
			header.put("statusDescription", TelemoneyConstants.STATUS_DESC_INVALID_HEADERS);
			LOG.info("------------------- BANNER Response -------------------");
			LOG.info(jsonResponse.get("header"));
			LOG.info("Banner API Time: " + String.valueOf(System.currentTimeMillis() - time1));
			return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
		} catch (JsonMappingException e) { // TODO Auto-generated catch block
			e.printStackTrace();
			header.put("statusCode", TelemoneyConstants.STATUS_CODE_INVALID_PARAMETERS);
			header.put("statusDescription", TelemoneyConstants.STATUS_DESC_INVALID_PARAMETERS);
			LOG.info("------------------- BANNER Response -------------------");
			LOG.info(jsonResponse.get("header"));
			LOG.info("Banner API Time: " + String.valueOf(System.currentTimeMillis() - time1));
			return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
		} catch (JsonParseException e) { // TODO Auto-generated catch block
			e.printStackTrace();
			header.put("statusCode", TelemoneyConstants.STATUS_CODE_INVALID_BODY);
			header.put("statusDescription", TelemoneyConstants.STATUS_DESC_INVALID_BODY);
			LOG.info("------------------- BANNER Response -------------------");
			LOG.info(jsonResponse.get("header"));
			LOG.info("Banner API Time: " + String.valueOf(System.currentTimeMillis() - time1));
			return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
		} catch (IllegalArgumentException e) { // TODO Auto-generated catch block
			e.printStackTrace();
			header.put("statusCode", TelemoneyConstants.STATUS_CODE_UNKNOWN_LANGUAGE);
			header.put("statusDescription", TelemoneyConstants.STATUS_DESC_UNKNOWN_LANGUAGE + language);
			LOG.info("------------------- BANNER Response -------------------");
			LOG.info(jsonResponse.get("header"));
			LOG.info("Banner API Time: " + String.valueOf(System.currentTimeMillis() - time1));
			return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
		} catch (Exception e) { // TODO Auto-generated catch block
			e.printStackTrace();
			header.put("statusCode", TelemoneyConstants.STATUS_CODE_ERROR);
			header.put("statusDescription", e.getMessage());
			LOG.info("------------------- BANNER Response -------------------");
			LOG.info(jsonResponse.get("header"));
			LOG.info("Banner API Time: " + String.valueOf(System.currentTimeMillis() - time1));
			return Response.serverError().entity(jsonResponse.toString()).build();
		}
	}

	@Reference
	private BannerLocalService _bannerLocalService;

	@Reference
	private ChannelsLocalService _channelLocalService;

}