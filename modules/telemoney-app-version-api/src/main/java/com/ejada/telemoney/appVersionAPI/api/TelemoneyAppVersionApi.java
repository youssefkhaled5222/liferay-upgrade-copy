package com.ejada.telemoney.appVersionAPI.api;
import com.ejada.telemoney.db.constants.LanguageValues;
import com.ejada.telemoney.db.constants.TelemoneyConstants;
import com.ejada.telemony.db.service.AppVersionLocalService;
import com.ejada.telemony.db.service.ChannelsLocalService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.ws.rs.core.Response;

import java.util.Collections;
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

import io.swagger.v3.oas.annotations.headers.Header;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

/**
 * @author maismail
 */

@Component(property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/app-version",
        JaxrsWhiteboardConstants.JAX_RS_NAME + "=AppVersion.Rest" }, service = Application.class)
public class TelemoneyAppVersionApi extends Application {

    @Reference
    private ChannelsLocalService _channelLocalService;
    @Reference
    private AppVersionLocalService _appVersionLocalService;

    private static final Log LOG = LogFactoryUtil.getLog(TelemoneyAppVersionApi.class);
    public Set<Object> getSingletons() {
        return Collections.<Object>singleton(this);
    }

    @POST
    @Path("/getAppVersion")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAppVersion(@HeaderParam("channel") Long channelId,
                                  String JsonRequestBody)
    {
        long time1 = System.currentTimeMillis();
        LOG.info("------------------------- AppVersion API --------------------------");
        LOG.info("------------------------- Request Body --------------------------");
        LOG.info(JsonRequestBody);
        LOG.info("------------------------- Header --------------------------");
        LOG.info(channelId);
        JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
        JSONObject body = JSONFactoryUtil.createJSONObject();
        JSONObject header = JSONFactoryUtil.createJSONObject();
        try
        {
            ObjectMapper objectMapper = new ObjectMapper();
            AppVersionRequestBody appVerisonRequestBody = objectMapper.readValue(JsonRequestBody,AppVersionRequestBody.class);
            if(appVerisonRequestBody.getPlatform()==null)
            {   header.put("statusCode", TelemoneyConstants.STATUS_CODE_MISSING_PARAMETERS);
                header.put("statusDescription", TelemoneyConstants.STATUS_DESC_MISSING_PARAMETERS);
                jsonResponse.put("header", header);
                LOG.info("------------------------- AppVersion Response --------------------------");
                LOG.info(jsonResponse);
                LOG.info("AppVersion API Time: " + String.valueOf(System.currentTimeMillis() - time1));
                return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
            }
            else if (channelId == null) {
                header.put("statusCode", TelemoneyConstants.STATUS_CODE_MISSING_CHANNEL);
                header.put("statusDescription", TelemoneyConstants.STATUS_DESC_MISSING_CHANNEL);
                jsonResponse.put("header", header);
                LOG.info("------------------------- AppVersion Response --------------------------");
                LOG.info(jsonResponse);
                LOG.info("AppVersion API Time: " + String.valueOf(System.currentTimeMillis() - time1));
                return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();

            }
            else if (!_channelLocalService.ifExist(channelId)) {
                header.put("statusCode", TelemoneyConstants.STATUS_CODE_UNKNOWN_CHANNEL);
                header.put("statusDescription", TelemoneyConstants.STATUS_DESC_UNKNOWN_CHANNEL);
                jsonResponse.put("header", header);
                LOG.info("------------------------- AppVersion Response --------------------------");
                LOG.info(jsonResponse);
                LOG.info("AppVersion API Time: " + String.valueOf(System.currentTimeMillis() - time1));
                return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
            }
            body = _appVersionLocalService.getAppVersionDetailsLatestApproved(channelId, appVerisonRequestBody.getPlatform());
            if (body.length() == 0) {
                header.put("statusCode", TelemoneyConstants.STATUS_CODE_UNKNOWN_APP_VERSION_CODE);
                header.put("statusDescription", TelemoneyConstants.STATUS_DESC_UNKNOWN_APP_VERSION_CODE);

                jsonResponse.put("header", header);
                jsonResponse.put("body", body);
                LOG.info("------------------------- AppVersion Response --------------------------");
                LOG.info(jsonResponse);
                LOG.info("AppVersion API Time: " + String.valueOf(System.currentTimeMillis() - time1));
                return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
            }
            else {
                header.put("statusCode", TelemoneyConstants.STATUS_CODE_SUCCESS);
                header.put("statusDescription", TelemoneyConstants.STATUS_DESC_SUCCESS);
                jsonResponse.put("header", header);
                jsonResponse.put("body", body);
                LOG.info("-------------------------Response body---------------------------");
                LOG.info(jsonResponse);
            }
    } catch (JsonMappingException e) { // TODO Auto-generated catch block
            e.printStackTrace();
            header.put("statusCode", TelemoneyConstants.STATUS_CODE_INVALID_PARAMETERS);
            header.put("statusDescription", TelemoneyConstants.STATUS_DESC_INVALID_PARAMETERS);
            jsonResponse.put("header", header);
            LOG.info("------------------------- AppVersion Response --------------------------");
            LOG.info(jsonResponse);
            LOG.info("AppVersion API Time: " + String.valueOf(System.currentTimeMillis() - time1));
            return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
        } catch (JsonParseException e) { // TODO Auto-generated catch block
            e.printStackTrace();
            header.put("statusCode", TelemoneyConstants.STATUS_CODE_INVALID_BODY);
            header.put("statusDescription", TelemoneyConstants.STATUS_DESC_INVALID_BODY);
            jsonResponse.put("header", header);
            LOG.info("------------------------- AppVersion Response --------------------------");
            LOG.info(jsonResponse);
            LOG.info("AppVersion API Time: " + String.valueOf(System.currentTimeMillis() - time1));
            return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            header.put("statusCode", TelemoneyConstants.STATUS_CODE_INVALID_BODY);
            header.put("statusDescription", TelemoneyConstants.STATUS_DESC_INVALID_BODY);
            jsonResponse.put("header", header);
            LOG.info("------------------------- AppVersion Response --------------------------");
            LOG.info(jsonResponse);
            LOG.info("AppVersion API Time: " + String.valueOf(System.currentTimeMillis() - time1));
            return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            header.put("statusCode", TelemoneyConstants.STATUS_CODE_INVALID_HEADERS);
            header.put("statusDescription", TelemoneyConstants.STATUS_DESC_INVALID_HEADERS);
            jsonResponse.put("header", header);
            LOG.info("------------------------- AppVersion Response --------------------------");
            LOG.info(jsonResponse);
            LOG.info("AppVersions API Time: " + String.valueOf(System.currentTimeMillis() - time1));
            return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
        }  catch (Exception e) {
            e.printStackTrace();
            jsonResponse.put("header", header);
            LOG.info("------------------------- AppVersion Response --------------------------");
            LOG.info(jsonResponse);
            LOG.info("AppVersion API Time: " + String.valueOf(System.currentTimeMillis() - time1));
            return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
        }
        LOG.info("------------------------- AppVersion Response --------------------------");
        LOG.info(jsonResponse);
        LOG.info("AppVersion API Time: " + String.valueOf(System.currentTimeMillis() - time1));
        return Response.ok(jsonResponse.toString()).build();

    }
}