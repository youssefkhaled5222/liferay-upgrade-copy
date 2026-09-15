package com.ejada.telemoney.whiteList.portlet;

import com.ejada.telemoney.whiteList.DTO.WhiteListDTO;
import com.ejada.telemoney.whiteList.configuration.WhiteListConfiguration;
import com.ejada.telemoney.whiteList.constants.TelemoneyWhiteListPortletKeys;
import com.ejada.telemony.db.service.WhiteListLocalService;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

/**
 * @author tentawy
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=TelemoneyWhiteList",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TelemoneyWhiteListPortletKeys.TELEMONEYWHITELIST,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TelemoneyWhiteListPortlet extends MVCPortlet {

	public void getDefaultData(String getAllWhiteListed, String XCorrelationId, String defaultPOI, RenderRequest renderRequest, PortletSession pSession)
	{
		JSONObject originalData = null;
		//date stuff
		LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);      
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");      
        String todayFormatted = today.format(formatter);
        String yesterdayFormatted = yesterday.format(formatter);
		String customers = _whiteListLocalService.getWhiteListed(getAllWhiteListed, XCorrelationId,
				yesterdayFormatted, todayFormatted	, "", "", "", "", "", "", "");
		try {
			LOG.info("yesterdayFormatted: "+yesterdayFormatted + " todayFormatted: "+todayFormatted+
					" defaultPOI: "+defaultPOI+" getAllWhiteListedURL: "+getAllWhiteListed
					+" customers: "+customers + " XCorrelationId: " + XCorrelationId);
			if(customers!=null) {					
				originalData = JSONFactoryUtil.createJSONObject(customers);
				JSONArray jsonItems = originalData.getJSONObject("body").getJSONArray("whiteListedUsers");
				LOG.info("json items from get API"+jsonItems);
				List<WhiteListDTO> items = WhiteListDTO.fromJSONArray(jsonItems);
				
				renderRequest.setAttribute("records", items);
				pSession.setAttribute("records", items);

			}else {
				renderRequest.setAttribute("records", new ArrayList<WhiteListDTO>());
				pSession.setAttribute("records",  new ArrayList<WhiteListDTO>());

			}

		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		PortletSession pSession = renderRequest.getPortletSession();
		PortletPreferences portletPreferences = renderRequest.getPreferences();
		String getAllWhiteListed = portletPreferences.getValue("getAllWhiteListed",
				String.valueOf(_whiteListConfiguration.getAllWhiteListed()));
		String XCorrelationId = portletPreferences.getValue("XCorrelationId",
				String.valueOf(_whiteListConfiguration.XCorrelationId()));
		String defaultPOI = portletPreferences.getValue("defaultPOI",
				String.valueOf(_whiteListConfiguration.defaultPOI()));
		String personaviewUrl = "/META-INF/resources/view.jsp";
		renderRequest.setAttribute("personaviewUrl", personaviewUrl);
		String myview = "view";

        String dateFrom = ParamUtil.getString(renderRequest, "startDate", "");
		String dateTo = ParamUtil.getString(renderRequest, "endDate", "");
		if(dateFrom.isEmpty() && dateTo.isEmpty()) 
		{
			getPortletContext().setAttribute("globalData", 0);
		}
		if (renderRequest.getAttribute("myview") != null && renderRequest.getAttribute("myview") != "view") {
			myview = (String) renderRequest.getAttribute("myview");
		} else {
			if (((int)getPortletContext().getAttribute("globalData") == 0)) {
				pSession.removeAttribute("searchResult");
				getDefaultData(getAllWhiteListed, XCorrelationId, defaultPOI,renderRequest,pSession);
			}
		}
		
		String view = "/" + myview + ".jsp";
		renderRequest.setAttribute(WhiteListConfiguration.class.getName(), _whiteListConfiguration);
		PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(view);
		dispatcher.include(renderRequest, renderResponse);
	}
	
	public void searchRes(ActionRequest actionRequest, ActionResponse actionResponse){
		PortletSession pSession = actionRequest.getPortletSession();
		getPortletContext().setAttribute("globalData", 1);
		PortletPreferences portletPreferences = actionRequest.getPreferences();
		String getAllWhiteListed = portletPreferences.getValue("getAllWhiteListed",
				String.valueOf(_whiteListConfiguration.getAllWhiteListed()));
		String XCorrelationId = portletPreferences.getValue("XCorrelationId",
				String.valueOf(_whiteListConfiguration.XCorrelationId()));

		String dateFrom = ParamUtil.getString(actionRequest, "startDate", "");
		String dateTo = ParamUtil.getString(actionRequest, "endDate", "");
		String poi = ParamUtil.getString(actionRequest, "poi", "");
		String poiType = ParamUtil.getString(actionRequest, "poiType", "");
		String cif = ParamUtil.getString(actionRequest, "cif", "");
		String nameEn = ParamUtil.getString(actionRequest, "nameEn", "");
		String nameAr = ParamUtil.getString(actionRequest, "nameAr", "");
		String mobile = ParamUtil.getString(actionRequest, "mobile", "");
		String allow = ParamUtil.getString(actionRequest, "allow", "");
		
		JSONObject originalData;
		
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDateFrom = null;
		String formattedDateTo = null;
		try {
		    if (!dateFrom.isEmpty()) {
		        LocalDate parsedDateFrom = LocalDate.parse(dateFrom, inputFormatter);
		        formattedDateFrom = parsedDateFrom.format(outputFormatter); // Converts to "yyyy-MM-dd"
		    }
		    if (!dateTo.isEmpty()) {
		        LocalDate parsedDateTo = LocalDate.parse(dateTo, inputFormatter);
		        formattedDateTo = parsedDateTo.format(outputFormatter); // Converts to "yyyy-MM-dd"
		    }
		} catch (DateTimeParseException e) {
		    // Log or handle invalid date format
		    e.printStackTrace();
		}
	    
		String customers = _whiteListLocalService.getWhiteListed(getAllWhiteListed, XCorrelationId,
				formattedDateFrom, formattedDateTo	, poi, poiType, cif, nameEn, nameAr,mobile, allow);
		try {
			originalData = JSONFactoryUtil.createJSONObject(customers);
			JSONArray jsonItems = originalData.getJSONObject("body").getJSONArray("whiteListedUsers");
			List<WhiteListDTO> items = WhiteListDTO.fromJSONArray(jsonItems);

			actionRequest.setAttribute("searchResult", items);
			
			pSession.setAttribute("searchResult", items);


		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void exportCsv(ActionRequest actionRequest, ActionResponse actionResponse) {
	    PortletSession pSession = actionRequest.getPortletSession();
	    getPortletContext().setAttribute("globalData", 1);
	    @SuppressWarnings("unchecked")
	    List<WhiteListDTO> allRecords = (List<WhiteListDTO>) pSession.getAttribute("records");
	    @SuppressWarnings("unchecked")
	    List<WhiteListDTO> searchRecords = (List<WhiteListDTO>) pSession.getAttribute("searchResult");
	    List<WhiteListDTO> recordsToExport = (searchRecords != null && !searchRecords.isEmpty()) ? searchRecords : allRecords;
	    if (recordsToExport == null || recordsToExport.isEmpty()) {
	        return;
	    }

	    try {
	        HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(actionResponse);
	        httpResponse.setContentType("text/csv; charset=UTF-8");
	        httpResponse.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"CustomersWhiteList.csv\"");
	        httpResponse.setCharacterEncoding("UTF-8");
	        PrintWriter writer = httpResponse.getWriter();
	        writer.write('\uFEFF');
	        writer.println("Created Date,POI,POI Type,CIF,English Name,Arabic Name,Mobile,Allow");


	        for (WhiteListDTO record : recordsToExport) {
	            writer.println(
	                record.getCreatedDate() + "," +
	                record.getPoi() + "," +
	                record.getPoiType() + "," +
	                record.getCif() + "," +
	                "\"" + record.getNameEn()+ "\"," + 
	                "\"" + record.getNameAr() + "\"," +
	                record.getMobile() + "," +
	                record.getAllow()
	            );
	        }

	        writer.flush();
	        writer.close();


	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public void beforeUpdateStatus(ActionRequest actionRequest, ActionResponse actionResponse) {
		
		String poi = ParamUtil.getString(actionRequest, "poi", "");
		String allow = ParamUtil.getString(actionRequest, "allow", "");
		String enName = ParamUtil.getString(actionRequest, "enName", "");
		String arName = ParamUtil.getString(actionRequest, "arName", "");
		String cif = ParamUtil.getString(actionRequest, "cif", "");
		String mobile = ParamUtil.getString(actionRequest, "mobile", "");
		
		actionRequest.setAttribute("poi", poi);
		actionRequest.setAttribute("allow", allow);
		actionRequest.setAttribute("enName", enName);
		actionRequest.setAttribute("arName", arName);
		actionRequest.setAttribute("cif", cif);
		actionRequest.setAttribute("mobile", mobile);
		
		actionRequest.setAttribute("myview", "edit");
	}
	
	public void updateStatus(ActionRequest actionRequest, ActionResponse actionResponse) {
		PortletPreferences portletPreferences = actionRequest.getPreferences();
		String updateWhiteListedStatus = portletPreferences.getValue("updateWhiteListedStatus",
				String.valueOf(_whiteListConfiguration.updateWhiteListedStatus()));
		String XCorrelationId = portletPreferences.getValue("XCorrelationId",
				String.valueOf(_whiteListConfiguration.XCorrelationId()));
		String poi = ParamUtil.getString(actionRequest, "poi", "");
		String allow = ParamUtil.getString(actionRequest, "allow", "");
		_whiteListLocalService.updateCustomerStatus(updateWhiteListedStatus, XCorrelationId,
				poi, allow);
	}
	
	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_whiteListConfiguration = ConfigurableUtil.createConfigurable(WhiteListConfiguration.class,
				properties);
	}
	
	@Reference
	private WhiteListLocalService _whiteListLocalService;

	private volatile WhiteListConfiguration _whiteListConfiguration;
	
	private static final Log LOG = LogFactoryUtil.getLog(TelemoneyWhiteListPortlet.class);
}