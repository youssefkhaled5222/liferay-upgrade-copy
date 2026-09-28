package telemoney.localization.api.application;

import com.ejada.telemoney.db.constants.LanguageValues;
import com.ejada.telemoney.db.constants.TelemoneyConstants;
import com.ejada.telemony.db.constants.ComponentType;
import com.ejada.telemony.db.model.Languages;
import com.ejada.telemony.db.service.ChannelsLocalService;
import com.ejada.telemony.db.service.GlobalVersionLocalService;
import com.ejada.telemony.db.service.LanguagesLocalService;
import com.ejada.telemony.db.service.LocalizationLocalService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
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
@Component(property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/localization",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=localization.Rest" }, service = Application.class)
public class TelemoneyLocalizationApiApplication extends Application {


	private static final Log LOG = LogFactoryUtil.getLog(TelemoneyLocalizationApiApplication.class);


	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	private JSONObject replaceEscapedNewlines(JSONObject jsonObject) {
		for (String key : jsonObject.keySet()) {
			Object value = jsonObject.get(key);
			if (value instanceof String) {
				jsonObject.put(key, ((String) value).replace("\\n", "\n"));
			} else if (value instanceof JSONObject) {
				jsonObject.put(key, replaceEscapedNewlines((JSONObject) value));
			}
		}
		return jsonObject;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getLocalization(@HeaderParam("channel") String channel,
									@HeaderParam("language") String language,
			String jsonRequest) {
		long time1 = System.currentTimeMillis();
		LOG.info("------------------- LOCALIZATION API -------------------");
		LOG.info("------------------- Header -------------------");
		LOG.info("Channel: " + channel);
		LOG.info("language: " + language);

		JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
		JSONObject header = JSONFactoryUtil.createJSONObject();
		JSONObject response = JSONFactoryUtil.createJSONObject();
		jsonResponse.put("header", header);
		jsonResponse.put("body", response);
		if (language == null) {
			header.put("statusCode", TelemoneyConstants.STATUS_CODE_MISSING_LANGUAGE);
			header.put("statusDescription", TelemoneyConstants.STATUS_DESC_MISSING_LANGUAGE);
			LOG.info("------------------- LOCALIZATION Response -------------------");
			LOG.info(jsonResponse);
			LOG.info("Localization API Time: " + String.valueOf(System.currentTimeMillis() - time1));
			return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
		} else if (channel == null) {
			header.put("statusCode", TelemoneyConstants.STATUS_CODE_MISSING_CHANNEL);
			header.put("statusDescription", TelemoneyConstants.STATUS_DESC_MISSING_CHANNEL);
			LOG.info("------------------- LOCALIZATION Response -------------------");
			LOG.info(jsonResponse);
			LOG.info("Localization API Time: " + String.valueOf(System.currentTimeMillis() - time1));

			return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
		}
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			LocalizationBodyRequest req = objectMapper.readValue(jsonRequest, LocalizationBodyRequest.class);

			System.out.println(req.getVersion());
			long channelId = Long.parseLong(channel);
			if (!_channelLocalService.ifExist(channelId)) {
				header.put("statusCode", TelemoneyConstants.STATUS_CODE_UNKNOWN_CHANNEL);
				header.put("statusDescription", TelemoneyConstants.STATUS_DESC_UNKNOWN_CHANNEL + channelId);
				LOG.info("------------------- LOCALIZATION Response -------------------");
				LOG.info(jsonResponse);
				LOG.info("Localization API Time: " + String.valueOf(System.currentTimeMillis() - time1));
				return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
			}

			// long languageId = Long.parseLong(language);
			String languageName = LanguageValues.valueOf(language).getLanguage();
			response = _localizationLocalService.getLocalizationAPI(channelId, languageName, language,
					req.getVersion());
			response = replaceEscapedNewlines(response);
			header.put("statusCode", TelemoneyConstants.STATUS_CODE_SUCCESS);
			header.put("statusDescription", TelemoneyConstants.STATUS_DESC_SUCCESS);
			jsonResponse.put("header", header);
			jsonResponse.put("body", response);
			LOG.info("------------------- LOCALIZATION Response -------------------");
			LOG.info(jsonResponse);
			LOG.info("Localization API Time: " + String.valueOf(System.currentTimeMillis() - time1));
			return Response.ok(jsonResponse.toString()).build();
		} catch (NumberFormatException e) {
			LOG.error("Invalid headers/parameters for the localization POST API", e);
			header.put("statusCode", TelemoneyConstants.STATUS_CODE_INVALID_HEADERS);
			header.put("statusDescription", TelemoneyConstants.STATUS_DESC_INVALID_HEADERS);
			LOG.info("------------------- LOCALIZATION Response -------------------");
			LOG.info(jsonResponse);
			LOG.info("Localization API Time: " + String.valueOf(System.currentTimeMillis() - time1));
			return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
		} catch (JsonMappingException e) {
			LOG.error("Invalid parameters in the localization request body", e);
			header.put("statusCode", TelemoneyConstants.STATUS_CODE_INVALID_PARAMETERS);
			header.put("statusDescription", TelemoneyConstants.STATUS_DESC_INVALID_PARAMETERS);
			LOG.info("------------------- BANNER Response -------------------");
			LOG.info(jsonResponse);
			LOG.info("Localization API Time: " + String.valueOf(System.currentTimeMillis() - time1));
			return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
		} catch (JsonParseException e) {
			LOG.error("Invalid localization request body", e);
			header.put("statusCode", TelemoneyConstants.STATUS_CODE_INVALID_BODY);
			header.put("statusDescription", TelemoneyConstants.STATUS_DESC_INVALID_BODY);
			LOG.info("------------------- BANNER Response -------------------");
			LOG.info(jsonResponse);
			LOG.info("Localization API Time: " + String.valueOf(System.currentTimeMillis() - time1));
			return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
		} catch (IllegalArgumentException e) {
			LOG.error("Unknown language requested: " + language, e);
			header.put("statusCode", TelemoneyConstants.STATUS_CODE_UNKNOWN_LANGUAGE);
			header.put("statusDescription", TelemoneyConstants.STATUS_DESC_UNKNOWN_LANGUAGE + language);
			LOG.info("------------------- LOCALIZATION Response -------------------");
			LOG.info(jsonResponse);
			LOG.info("Localization API Time: " + String.valueOf(System.currentTimeMillis() - time1));
			return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
		} catch (Exception e) {
			LOG.error("Error while serving the localization POST API", e);
			header.put("statusCode", TelemoneyConstants.STATUS_CODE_ERROR);
			header.put("statusDescription", e.getMessage());
			LOG.info("------------------- LOCALIZATION Response -------------------");
			LOG.info(jsonResponse);
			LOG.info("Localization API Time: " + String.valueOf(System.currentTimeMillis() - time1));
			return Response.serverError().entity(jsonResponse.toString()).build();
		}

	}

	/**
	 * GET variant of the localization API, served on the same path as the POST
	 * endpoint.
	 * <p>
	 * When the {@code language} header is provided it behaves like the POST
	 * endpoint and returns the localization of that single language. When the
	 * {@code language} header is missing, the localizations of every language
	 * configured for the channel are returned, each one built the same way a
	 * single localization is built (latest approved rows merged across all
	 * features).
	 * </p>
	 * <p>
	 * The client version - which the POST endpoint reads from the request body -
	 * is taken from the optional {@code version} query parameter, since a GET
	 * request has no body.
	 * </p>
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLocalizations(@HeaderParam("channel") String channel,
									 @HeaderParam("language") String language,
			@QueryParam("version") @DefaultValue("-1") String version) {
		long time1 = System.currentTimeMillis();
		LOG.info("------------------- LOCALIZATION API (GET) -------------------");
		LOG.info("------------------- Header -------------------");
		LOG.info("Channel: " + channel);
		LOG.info("language: " + language);
		LOG.info("version: " + version);

		JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
		JSONObject header = JSONFactoryUtil.createJSONObject();
		JSONObject response = JSONFactoryUtil.createJSONObject();
		jsonResponse.put("header", header);
		jsonResponse.put("body", response);

		if (channel == null) {
			header.put("statusCode", TelemoneyConstants.STATUS_CODE_MISSING_CHANNEL);
			header.put("statusDescription", TelemoneyConstants.STATUS_DESC_MISSING_CHANNEL);
			LOG.info("------------------- LOCALIZATION Response -------------------");
			LOG.info(jsonResponse);
			LOG.info("Localization API Time: " + (System.currentTimeMillis() - time1));

			return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
		}
		try {
			long channelId = Long.parseLong(channel);
			int requestedVersion = Integer.parseInt(version);

			if (!_channelLocalService.ifExist(channelId)) {
				header.put("statusCode", TelemoneyConstants.STATUS_CODE_UNKNOWN_CHANNEL);
				header.put("statusDescription", TelemoneyConstants.STATUS_DESC_UNKNOWN_CHANNEL + channelId);
				LOG.info("------------------- LOCALIZATION Response -------------------");
				LOG.info(jsonResponse);
				LOG.info("Localization API Time: " + (System.currentTimeMillis() - time1));
				return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
			}

			if (language == null) {
				// No language provided in the header: return the localizations of
				// every language configured for the channel.
				response = getAllLocalizations(channelId);
			} else {
				String languageName = LanguageValues.valueOf(language).getLanguage();
				response = _localizationLocalService.getLocalizationAPI(channelId, languageName, language,
						requestedVersion);
				response = replaceEscapedNewlines(response);
			}

			header.put("statusCode", TelemoneyConstants.STATUS_CODE_SUCCESS);
			header.put("statusDescription", TelemoneyConstants.STATUS_DESC_SUCCESS);
			jsonResponse.put("header", header);
			jsonResponse.put("body", response);
			LOG.info("------------------- LOCALIZATION Response -------------------");
			LOG.info("Localization API Time: " + (System.currentTimeMillis() - time1));
			return Response.ok(jsonResponse.toString()).build();
		} catch (NumberFormatException e) {
			LOG.error("Invalid headers/parameters for the localization GET API", e);
			header.put("statusCode", TelemoneyConstants.STATUS_CODE_INVALID_HEADERS);
			header.put("statusDescription", TelemoneyConstants.STATUS_DESC_INVALID_HEADERS);
			LOG.info("------------------- LOCALIZATION Response -------------------");
			LOG.info(jsonResponse);
			LOG.info("Localization API Time: " + (System.currentTimeMillis() - time1));
			return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
		} catch (IllegalArgumentException e) {
			LOG.error("Unknown language requested: " + language, e);
			header.put("statusCode", TelemoneyConstants.STATUS_CODE_UNKNOWN_LANGUAGE);
			header.put("statusDescription", TelemoneyConstants.STATUS_DESC_UNKNOWN_LANGUAGE + language);
			LOG.info("------------------- LOCALIZATION Response -------------------");
			LOG.info(jsonResponse);
			LOG.info("Localization API Time: " + (System.currentTimeMillis() - time1));
			return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
		} catch (Exception e) {
			LOG.error("Error while serving the localization GET API", e);
			header.put("statusCode", TelemoneyConstants.STATUS_CODE_ERROR);
			header.put("statusDescription", e.getMessage());
			LOG.info("------------------- LOCALIZATION Response -------------------");
			LOG.info(jsonResponse);
			LOG.info("Localization API Time: " + (System.currentTimeMillis() - time1));
			return Response.serverError().entity(jsonResponse.toString()).build();
		}
	}

	/**
	 * Builds a response containing the localizations of every language configured
	 * for the given channel. Each language block is produced exactly the same way
	 * a single-language request is served (latest approved rows merged across all
	 * features), so it always reflects the latest approved workflow state.
	 *
	 * Example body:
	 * <pre>
	 * {
	 *   "version": 20,
	 *   "en": { ... },
	 *   "ar": { ... }
	 * }
	 * </pre>
	 */
	private JSONObject getAllLocalizations(long channelId) {
		JSONObject result = JSONFactoryUtil.createJSONObject();

		List<Languages> languages = _languageLocalService.getLatestApprovedByChannelId(channelId);
		for (Languages language : languages) {
			String languageName = language.getLangName();
			String languageCode = resolveLanguageCode(languageName);
			if (languageCode == null) {
				LOG.info("Skipping unmapped language: " + languageName);
				continue;
			}
			try {
				// Reuse the exact same path used to serve a single localization.
				// Passing an impossible version (-1) guarantees the merged data is
				// returned instead of the "already up to date" short response.
				JSONObject single = _localizationLocalService.getLocalizationAPI(channelId, languageName,
						languageCode, -1);
				JSONObject langBody = single.getJSONObject(languageCode.toLowerCase());
				if (langBody == null) {
					langBody = JSONFactoryUtil.createJSONObject();
				}
				result.put(languageCode.toLowerCase(), replaceEscapedNewlines(langBody));
			} catch (Exception e) {
				LOG.error("Unable to build localization for language: " + languageName, e);
			}
		}

		// Return the localizationVersion tracked in the GlobalVersion table for
		// this company/channel (bumped only after an approved localization
		// change), instead of the max per-language version.
		long localizationVersion = _globalVersionLocalService.getCurrentVersion(
				CompanyThreadLocal.getCompanyId(), channelId, ComponentType.LOCALIZATION.name());
		result.put("version", localizationVersion);
		return result;
	}

	private String resolveLanguageCode(String languageName) {
		for (LanguageValues value : LanguageValues.values()) {
			if (value.getLanguage().equalsIgnoreCase(languageName)) {
				return value.name();
			}
		}
		return null;
	}

	@Reference
	private LocalizationLocalService _localizationLocalService;

	@Reference
	private ChannelsLocalService _channelLocalService;

	@Reference
	private LanguagesLocalService _languageLocalService;

	@Reference
	private GlobalVersionLocalService _globalVersionLocalService;
}