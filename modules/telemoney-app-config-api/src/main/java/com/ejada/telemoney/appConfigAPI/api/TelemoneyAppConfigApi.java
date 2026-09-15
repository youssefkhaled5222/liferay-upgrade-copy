package com.ejada.telemoney.appConfigAPI.api;

import com.ejada.telemoney.db.constants.TelemoneyConstants;
import com.ejada.telemony.db.model.AppConfigItem;
import com.ejada.telemony.db.model.AppEnvironment;
import com.ejada.telemony.db.service.AppConfigItemLocalService;
import com.ejada.telemony.db.service.AppEnvironmentLocalService;
import com.ejada.telemony.db.service.ChannelsLocalService;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/app-config",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=AppConfig.Rest"
	},
	service = Application.class
)
public class TelemoneyAppConfigApi extends Application {

	private static final Log LOG = LogFactoryUtil.getLog(
		TelemoneyAppConfigApi.class);

	@Override
	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAppConfig(
		@HeaderParam("channel") Long channelId,
		@QueryParam("environment") String environment) {

		long startTime = System.currentTimeMillis();
		JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
		JSONObject body = JSONFactoryUtil.createJSONObject();
		JSONObject header = JSONFactoryUtil.createJSONObject();

		try {
			if ((environment == null) || environment.trim().isEmpty()) {

				header.put(
					"statusCode", TelemoneyConstants.STATUS_CODE_MISSING_PARAMETERS);
				header.put(
					"statusDescription",
					TelemoneyConstants.STATUS_DESC_MISSING_QUERY_PARAM);
				jsonResponse.put("header", header);

				return Response.status(
					Response.Status.BAD_REQUEST
				).entity(
					jsonResponse.toString()
				).build();
			}
			else if (channelId == null) {
				header.put(
					"statusCode", TelemoneyConstants.STATUS_CODE_MISSING_CHANNEL);
				header.put(
					"statusDescription",
					TelemoneyConstants.STATUS_DESC_MISSING_CHANNEL);
				jsonResponse.put("header", header);

				return Response.status(
					Response.Status.BAD_REQUEST
				).entity(
					jsonResponse.toString()
				).build();
			}
			else if (!_channelsLocalService.ifExist(channelId)) {
				header.put(
					"statusCode", TelemoneyConstants.STATUS_CODE_UNKNOWN_CHANNEL);
				header.put(
					"statusDescription",
					TelemoneyConstants.STATUS_DESC_UNKNOWN_CHANNEL);
				jsonResponse.put("header", header);

				return Response.status(
					Response.Status.BAD_REQUEST
				).entity(
					jsonResponse.toString()
				).build();
			}

			String environmentName = environment.trim();
			AppEnvironment appEnvironment = getLatestApprovedEnvironment(
				channelId, environmentName);

			if (appEnvironment == null) {
				header.put(
					"statusCode",
					TelemoneyConstants.STATUS_CODE_UNKNOWN_APP_CONFIG_CODE);
				header.put(
					"statusDescription",
					TelemoneyConstants.STATUS_DESC_UNKNOWN_APP_CONFIG_CODE +
						environmentName);

				jsonResponse.put("header", header);
				jsonResponse.put("body", body);

				return Response.status(
					Response.Status.BAD_REQUEST
				).entity(
					jsonResponse.toString()
				).build();
			}

			body.put("environment", appEnvironment.getEnvironmentName());
			body.put("configVersion", appEnvironment.getVersion());

			List<AppConfigItem> appConfigItems =
				_appConfigItemLocalService.getAppConfigItemsByEnvironmentId(
					appEnvironment.getEnvironmentId());

			for (AppConfigItem appConfigItem : appConfigItems) {
				String keyName = appConfigItem.getKeyName();

				if ((keyName == null) || keyName.trim().isEmpty()) {
					continue;
				}

				body.put(
					keyName.trim(),
					convertByValueType(
						appConfigItem.getValueType(), appConfigItem.getValue()));
			}

			header.put("statusCode", TelemoneyConstants.STATUS_CODE_SUCCESS);
			header.put(
				"statusDescription", TelemoneyConstants.STATUS_DESC_SUCCESS);
			jsonResponse.put("header", header);
			jsonResponse.put("body", body);
		}
		catch (IllegalArgumentException exception) {
			header.put(
				"statusCode", TelemoneyConstants.STATUS_CODE_ERROR);
			header.put(
				"statusDescription",
				TelemoneyConstants.STATUS_DESC_GENERIC_ERROR);
			jsonResponse.put("header", header);
			return Response.status(
				Response.Status.INTERNAL_SERVER_ERROR
			).entity(
				jsonResponse.toString()
			).build();
		}
		catch (Exception exception) {
			LOG.error("Error in app config API", exception);
			header.put("statusCode", TelemoneyConstants.STATUS_CODE_ERROR);
			jsonResponse.put("header", header);

			return Response.status(
				Response.Status.BAD_REQUEST
			).entity(
				jsonResponse.toString()
			).build();
		}

		LOG.info("AppConfig API Time: " + (System.currentTimeMillis() - startTime));

		return Response.ok(jsonResponse.toString()).build();
	}

	private AppEnvironment getLatestApprovedEnvironment(
		Long channelId, String environmentName) {

		List<AppEnvironment> approvedAppEnvironments =
			_appEnvironmentLocalService.getLatestApprovedByChannelId(channelId);

		for (AppEnvironment appEnvironment : approvedAppEnvironments) {
			if ((appEnvironment.getEnvironmentName() != null) &&
				appEnvironment.getEnvironmentName().equalsIgnoreCase(
					environmentName)) {

				return appEnvironment;
			}
		}

		return null;
	}

	private Object convertByValueType(String valueType, String value) {
		String normalizedType = valueType == null ? "String" : valueType.trim();
		String normalizedValue = value == null ? "" : value.trim();

		if ("Integer".equalsIgnoreCase(normalizedType)) {
			return Integer.parseInt(normalizedValue);
		}

		if ("Double".equalsIgnoreCase(normalizedType)) {
			return Double.parseDouble(normalizedValue);
		}

		if ("Boolean".equalsIgnoreCase(normalizedType)) {
			String booleanValue = normalizedValue.toLowerCase(Locale.ROOT);

			if (!"true".equals(booleanValue) && !"false".equals(booleanValue)) {
				throw new IllegalArgumentException("Invalid boolean value");
			}

			return Boolean.valueOf(booleanValue);
		}

		return normalizedValue;
	}

	@Reference
	private ChannelsLocalService _channelsLocalService;

	@Reference
	private AppEnvironmentLocalService _appEnvironmentLocalService;

	@Reference
	private AppConfigItemLocalService _appConfigItemLocalService;
}
