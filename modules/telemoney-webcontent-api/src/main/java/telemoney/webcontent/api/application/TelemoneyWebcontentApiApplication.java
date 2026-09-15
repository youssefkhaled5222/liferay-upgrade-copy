package telemoney.webcontent.api.application;

import com.ejada.telemoney.db.constants.LanguageValues;
import com.ejada.telemoney.db.constants.TelemoneyConstants;
import com.ejada.telemony.db.service.ChannelsLocalService;
import com.ejada.telemony.db.service.CustomWebContentLocalService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

/**
 * @author iatef
 */
@Component(property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/webcontents",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=WebContents.Rest" }, service = Application.class)
public class TelemoneyWebcontentApiApplication extends Application {
	private static final Log LOG = LogFactoryUtil.getLog(TelemoneyWebcontentApiApplication.class);

	public Set<Object> getSingletons() {
		final Set<Object> singletons = new HashSet<>();
		singletons.add(this);
		singletons.add(new WebContentFilter());
		return singletons;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response working(@HeaderParam("channel") String channel, @HeaderParam("language") String language,
			String jsonRequest) {
		long time1 = System.currentTimeMillis();
		LOG.info("------------------- WEB CONTENT API -------------------");
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
			LOG.info("Web Content API Time: " + String.valueOf(System.currentTimeMillis() - time1));
			return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
		} else if (channel == null) {
			header.put("statusCode", TelemoneyConstants.STATUS_CODE_MISSING_CHANNEL);
			header.put("statusDescription", TelemoneyConstants.STATUS_DESC_MISSING_CHANNEL);
			LOG.info("Web Content API Time: " + String.valueOf(System.currentTimeMillis() - time1));
			return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
		}
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			WebContentRequest req = objectMapper.readValue(jsonRequest, WebContentRequest.class);
			String LanguageID = LanguageValues.valueOf(language).getLanguageID();

			long channelId = Long.parseLong(channel);
			if (!_channelLocalService.ifExist(channelId)) {
				header.put("statusCode", TelemoneyConstants.STATUS_CODE_UNKNOWN_CHANNEL);
				header.put("statusDescription", TelemoneyConstants.STATUS_DESC_UNKNOWN_CHANNEL + channelId);
				LOG.info("Web Content API Time: " + String.valueOf(System.currentTimeMillis() - time1));
				return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
			}
			response = _customWebContentLocalService.getWebContentByTagName(req.getTagName(), LanguageID);
			header.put("statusCode", TelemoneyConstants.STATUS_CODE_SUCCESS);
			header.put("statusDescription", TelemoneyConstants.STATUS_DESC_SUCCESS);
			jsonResponse.put("header", header);
			jsonResponse.put("body", response);
			LOG.info("Web Content API Time: " + String.valueOf(System.currentTimeMillis() - time1));
			return Response.ok(jsonResponse.toString()).build();
		} catch (NumberFormatException e) {
			e.printStackTrace();
			header.put("statusCode", TelemoneyConstants.STATUS_CODE_INVALID_HEADERS);
			header.put("statusDescription", TelemoneyConstants.STATUS_DESC_INVALID_HEADERS);
			LOG.info("Web Content API Time: " + String.valueOf(System.currentTimeMillis() - time1));
			return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
		} catch (IllegalArgumentException e) { // TODO Auto-generated catch block
			e.printStackTrace();
			header.put("statusCode", TelemoneyConstants.STATUS_CODE_UNKNOWN_LANGUAGE);
			header.put("statusDescription", TelemoneyConstants.STATUS_DESC_UNKNOWN_LANGUAGE + language);
			LOG.info("Web Content API Time: " + String.valueOf(System.currentTimeMillis() - time1));
			return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
		} catch (Exception e) { // TODO Auto-generated catch block
			header.put("statusCode", TelemoneyConstants.STATUS_CODE_ERROR);
			header.put("statusDescription", e.getMessage());
			LOG.info("Web Content API Time: " + String.valueOf(System.currentTimeMillis() - time1));
			return Response.serverError().entity(jsonResponse.toString()).build();
		}

		// long languageId = Long.parseLong(language);
		// String languageName = LanguageValues.valueOf(language).getLanguage();
	}

	@Reference
	private ChannelsLocalService _channelLocalService;

	@Reference
	private CustomWebContentLocalService _customWebContentLocalService;
}