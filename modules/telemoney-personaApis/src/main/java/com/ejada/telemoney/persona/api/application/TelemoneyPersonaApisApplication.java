package com.ejada.telemoney.persona.api.application;

import com.ejada.telemoney.db.constants.TelemoneyConstants;
import com.ejada.telemony.db.service.ChannelsLocalService;
import com.ejada.telemony.db.service.PersonaLocalService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Collections;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
@Component(property = {JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/persona",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Personas.Rest", "oauth2.scopechecker.type=none",
		"auth.verifier.guest.allowed=true"}, service = Application.class)
public class TelemoneyPersonaApisApplication extends Application {
	private static final Log LOG = LogFactoryUtil.getLog(TelemoneyPersonaApisApplication.class);

	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getDesiredData(String jsonRequest, @HeaderParam("channel") String channel) throws JSONException {
		LOG.info("----------------Persona API-----------------");
		LOG.info("Channel Id: "+ channel);
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
			LOG.info(maskSplashScreen(jsonResponse));
			return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
		}
		try {
			
			long channelId = Long.parseLong(channel);
			if (!_channelLocalService.ifExist(channelId)) {
				header.put("statusCode", TelemoneyConstants.STATUS_CODE_UNKNOWN_CHANNEL);
				header.put("statusDescription", TelemoneyConstants.STATUS_DESC_UNKNOWN_CHANNEL +" "+ channelId);
				LOG.info("----------------Response Body-----------------");
				LOG.info(maskSplashScreen(jsonResponse));
				return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
			}
			
			

			ObjectMapper objectMapper = new ObjectMapper();
			RequestBodyPersona req = objectMapper.readValue(jsonRequest, RequestBodyPersona.class);
			boolean isEmptyRequest = isEmpty(req.getNationality()) &&
		               req.getAge() <= 0 &&
		               req.getIncom() <= 0 &&
		               isEmpty(req.getCustomerSegment()) &&
		               isEmpty(req.getGender()) &&
		               isEmpty(req.getSector());
			if(isEmptyRequest) {
				response = _PersonaLocalService.getDefaultPersona(channelId);
			}else {
				long startTime = System.nanoTime(); // Start time measurement
				String nationality = req.getNationality()!=null?req.getNationality():"";
				int ageRange = req.getAge()>0?req.getAge():0;
				int incomeRange = req.getIncom()>0?req.getIncom():0;
				String customerSegment = req.getCustomerSegment()!=null?req.getCustomerSegment():"";
				String gender = req.getGender()!=null?req.getGender():"";
				String sector = req.getSector()!=null?req.getSector():"";
				
				
				
				response =  _PersonaLocalService.getPersonaForApiLatestApproved(nationality, ageRange, incomeRange, customerSegment, gender,
						sector, channelId);
				
				long endTime = System.nanoTime(); // End time measurement

				// Calculate the time difference in milliseconds
				long duration = (endTime - startTime) / 1_000_000;
				LOG.info("Persona Time taken: " + duration + " ms");
			}
			
			if(response==null || response.length()==0) {
				header.put("status", "Bad Request");
				header.put("message", "No Data");
				LOG.info("----------------Response Body-----------------");
				LOG.info(maskSplashScreen(jsonResponse));
				return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
				
			}else {
			jsonResponse.put("body", response);
			header.put("statusCode", TelemoneyConstants.STATUS_CODE_SUCCESS);
			header.put("statusDescription", TelemoneyConstants.STATUS_DESC_SUCCESS);
			

			}
			LOG.info("----------------Response Body-----------------");
			LOG.info(maskSplashScreen(jsonResponse));
			return Response.ok(jsonResponse.toString()).build();
		} catch (JsonMappingException e) { 
			e.printStackTrace();
			header.put("status", "Bad Request");
			header.put("message", "Please provide valid parameters in body");
			LOG.info("----------------Response Body-----------------");
			LOG.info(maskSplashScreen(jsonResponse));
			return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
		} catch (JsonParseException e) {
			
			e.printStackTrace();
			header.put("status", "Bad Request");
			header.put("message", "Please provide valid json format");
			LOG.info("----------------Response Body-----------------");
			LOG.info(maskSplashScreen(jsonResponse));
			return Response.status(Response.Status.BAD_REQUEST).entity(jsonResponse.toString()).build();
		} catch (Exception e) {
			
			e.printStackTrace();
			header.put("status", "Internal Server Error");
			header.put("message", e.getMessage());
			LOG.info("----------------Response Body-----------------");
			LOG.info(maskSplashScreen(jsonResponse));
			return Response.serverError().entity(jsonResponse.toString()).build();
		}
		
	}
	private JSONObject maskSplashScreen(JSONObject jsonResponse) throws JSONException {
		JSONObject copy = JSONFactoryUtil.createJSONObject(jsonResponse.toString());

		if (copy.has("body")) {
			JSONArray body = copy.getJSONArray("body");
			for (int i = 0; i < body.length(); i++) {
				JSONObject personaObj = body.getJSONObject(i);

				if (personaObj.has("lightTheme")) {
					personaObj.getJSONObject("lightTheme").remove("splashScreen");
				}
				if (personaObj.has("darkTheme")) {
					personaObj.getJSONObject("darkTheme").remove("splashScreen");
				}
			}
		}
		return copy;
	}


	private static boolean isEmpty(String value) {
		return value == null || value.trim().isEmpty();
	}

	@Reference
	PersonaLocalService _PersonaLocalService;
	@Reference
	private ChannelsLocalService _channelLocalService;
}