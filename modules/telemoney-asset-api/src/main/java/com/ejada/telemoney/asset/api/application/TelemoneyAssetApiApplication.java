package com.ejada.telemoney.asset.api.application;

import com.ejada.telemoney.asset.api.constants.AssetVersionConstants;
import com.ejada.telemoney.db.constants.LanguageValues;
import com.ejada.telemoney.db.constants.TelemoneyConstants;
import com.ejada.telemony.db.model.Channels;
import com.ejada.telemony.db.service.ChannelsLocalService;
import com.ejada.telemony.db.service.GlobalVersionLocalService;

import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.document.library.kernel.service.DLFolderLocalService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.URLCodec;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

/**
 * User Story 7 - Asset Management API.
 *
 * <p>
 * The assets of a channel are the attachments uploaded from the Resources
 * module. Those attachments are stored in Documents &amp; Media in one folder
 * per channel and language, named {@code channelName_langName_attachFile} (for
 * example {@code Blue App_English_attachFile}).
 * </p>
 *
 * <p>
 * The caller sends the {@code channel} and the {@code language} headers; the
 * language code (for example {@code en}) is resolved to the language name
 * ({@code English}) and the matching folder is listed through Liferay's
 * {@link DLAppService}.
 * </p>
 *
 * <p>
 * Response body: {@code { "Version": <version>, "Assets": [ ... ] }} wrapped in
 * the standard telemoney {@code header}/{@code body} envelope.
 * </p>
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/asset",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Asset.Rest",
		"auth.verifier.guest.allowed=true", "oauth2.scopechecker.type=none"
	},
	service = Application.class
)
public class TelemoneyAssetApiApplication extends Application {

	@Override
	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAssets(
		@Context HttpServletRequest request,
		@HeaderParam("channel") String channel,
		@HeaderParam("language") String language) {

		long startTime = System.currentTimeMillis();

		_log.info("------------------- ASSET API -------------------");
		_log.info("Channel: " + channel);
		_log.info("Language: " + language);

		JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
		JSONObject header = JSONFactoryUtil.createJSONObject();
		JSONObject body = JSONFactoryUtil.createJSONObject();

		jsonResponse.put("header", header);
		jsonResponse.put("body", body);

		if (channel == null) {
			header.put(
				"statusCode", TelemoneyConstants.STATUS_CODE_MISSING_CHANNEL);
			header.put(
				"statusDescription",
				TelemoneyConstants.STATUS_DESC_MISSING_CHANNEL);

			return Response.status(
				Response.Status.BAD_REQUEST
			).entity(
				jsonResponse.toString()
			).build();
		}

		if (language == null) {
			header.put(
				"statusCode", TelemoneyConstants.STATUS_CODE_MISSING_LANGUAGE);
			header.put(
				"statusDescription",
				TelemoneyConstants.STATUS_DESC_MISSING_LANGUAGE);

			return Response.status(
				Response.Status.BAD_REQUEST
			).entity(
				jsonResponse.toString()
			).build();
		}

		try {
			long channelId = Long.parseLong(channel.trim());

			Channels channels = _channelsLocalService.fetchChannels(channelId);

			if (channels == null) {
				header.put(
					"statusCode",
					TelemoneyConstants.STATUS_CODE_UNKNOWN_CHANNEL);
				header.put(
					"statusDescription",
					TelemoneyConstants.STATUS_DESC_UNKNOWN_CHANNEL + channelId);

				return Response.status(
					Response.Status.BAD_REQUEST
				).entity(
					jsonResponse.toString()
				).build();
			}

			// "en" -> "English": the folders are named after the language name
			// used by the Resources module.

			String languageName = _resolveLanguageName(language);

			long companyId = PortalUtil.getCompanyId(request);

			String folderName =
				channels.getName() + "_" + languageName + "_attachFile";

			_log.info("Asset folder: " + folderName);

			JSONArray assets = JSONFactoryUtil.createJSONArray();

			DLFolder dlFolder = _fetchFolder(companyId, folderName);

			if (dlFolder == null) {
				_log.warn(
					"No Documents & Media folder named " + folderName +
						" for company " + companyId);
			}
			else {
				String baseUrl = _resolveBaseUrl(request);

				List<FileEntry> fileEntries = _dlAppService.getFileEntries(
					dlFolder.getRepositoryId(), dlFolder.getFolderId());

				for (FileEntry fileEntry : fileEntries) {
					JSONObject asset = JSONFactoryUtil.createJSONObject();

					asset.put("id", "a_" + fileEntry.getFileEntryId());
					asset.put(
						"key",
						FileUtil.stripExtension(fileEntry.getFileName()));
					asset.put("mimeType", fileEntry.getMimeType());
					asset.put("url", _buildUrl(baseUrl, fileEntry));

					assets.put(asset);
				}
			}

			// Bumped by the Resources module when a Blue App resource change
			// is approved.

			long version = _globalVersionLocalService.getCurrentVersion(
				companyId, channelId,
				AssetVersionConstants.GLOBAL_COMPONENT_NAME);

			body.put("Version", version);
			body.put("Assets", assets);

			header.put("statusCode", TelemoneyConstants.STATUS_CODE_SUCCESS);
			header.put(
				"statusDescription", TelemoneyConstants.STATUS_DESC_SUCCESS);

			_log.info(
				"Asset API time: " + (System.currentTimeMillis() - startTime) +
					" ms");

			return Response.ok(
				jsonResponse.toString()
			).build();
		}
		catch (NumberFormatException numberFormatException) {
			header.put(
				"statusCode", TelemoneyConstants.STATUS_CODE_INVALID_HEADERS);
			header.put(
				"statusDescription",
				TelemoneyConstants.STATUS_DESC_INVALID_HEADERS);

			return Response.status(
				Response.Status.BAD_REQUEST
			).entity(
				jsonResponse.toString()
			).build();
		}
		catch (IllegalArgumentException illegalArgumentException) {
			header.put(
				"statusCode", TelemoneyConstants.STATUS_CODE_UNKNOWN_LANGUAGE);
			header.put(
				"statusDescription",
				TelemoneyConstants.STATUS_DESC_UNKNOWN_LANGUAGE + language);

			return Response.status(
				Response.Status.BAD_REQUEST
			).entity(
				jsonResponse.toString()
			).build();
		}
		catch (Exception exception) {
			_log.error("Asset API error", exception);

			header.put("statusCode", TelemoneyConstants.STATUS_CODE_ERROR);
			header.put("statusDescription", exception.getMessage());

			return Response.serverError(
			).entity(
				jsonResponse.toString()
			).build();
		}
	}

	private String _buildUrl(String baseUrl, FileEntry fileEntry) {
		StringBuilder sb = new StringBuilder();

		sb.append(baseUrl);
		sb.append("/documents/");
		sb.append(fileEntry.getGroupId());
		sb.append("/");
		sb.append(fileEntry.getFolderId());
		sb.append("/");
		sb.append(URLCodec.encodeURL(fileEntry.getFileName()));
		sb.append("/");
		sb.append(fileEntry.getUuid());

		return sb.toString();
	}

	/**
	 * Looks the asset folder up by name so no folder id has to be configured.
	 */
	private DLFolder _fetchFolder(long companyId, String folderName) {
		DynamicQuery dynamicQuery = _dlFolderLocalService.dynamicQuery();

		dynamicQuery.add(RestrictionsFactoryUtil.eq("companyId", companyId));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("name", folderName));
		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"parentFolderId",
				DLFolderConstants.DEFAULT_PARENT_FOLDER_ID));

		List<DLFolder> dlFolders = _dlFolderLocalService.dynamicQuery(
			dynamicQuery);

		if (dlFolders.isEmpty()) {
			return null;
		}

		return dlFolders.get(0);
	}

	private String _resolveBaseUrl(HttpServletRequest request) {
		if (request != null) {
			return _stripTrailingSlash(PortalUtil.getPortalURL(request));
		}

		return "";
	}

	/**
	 * Resolves a language code ("en", "ar", ...) to the language name used by
	 * the Resources module ("English", "Arabic", ...).
	 */
	private String _resolveLanguageName(String language) {
		LanguageValues languageValues = LanguageValues.valueOf(
			StringUtil.toUpperCase(language.trim()));

		return languageValues.getLanguage();
	}

	private String _stripTrailingSlash(String url) {
		if ((url != null) && url.endsWith("/")) {
			return url.substring(0, url.length() - 1);
		}

		return url;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		TelemoneyAssetApiApplication.class);

	@Reference
	private ChannelsLocalService _channelsLocalService;

	@Reference
	private DLAppService _dlAppService;

	@Reference
	private DLFolderLocalService _dlFolderLocalService;

	@Reference
	private GlobalVersionLocalService _globalVersionLocalService;

}

