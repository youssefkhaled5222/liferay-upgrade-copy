package com.ejada.telemoney.login.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.BaseFilter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.osgi.service.component.annotations.Component;

@Component(
    immediate = true, 
    property = {
        "servlet-context-name=", 
        "dispatcher=FORWARD", 
        "dispatcher=REQUEST",
        "servlet-filter-name=API Filter", 
        "url-pattern=/o/oauth2/token",
        "url-pattern=/o/persona",
        "url-pattern=/o/lov",
        "url-pattern=/o/banner",
        "url-pattern=/o/feature",
        "url-pattern=/o/localization",
        "url-pattern=/o/getResource",
        "url-pattern=/o/locations",
        "url-pattern=/o/webcontents"
       
    }, 
    service = Filter.class
)
public class Oauth2Filter extends BaseFilter {
    
    private static final Log _log = LogFactoryUtil.getLog(Oauth2Filter.class);
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // Capture and log the request start time
        long startTime = System.currentTimeMillis();
        String formattedStartTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(startTime));
        _log.info("OAuth2 Token request received at: " + formattedStartTime);
        
        // Optionally, log request details (e.g., client_id, grant_type)
        //String clientId = request.getParameter("client_id");
        //String grantType = request.getParameter("grant_type");
        //_log.info("Client ID: " + clientId + ", Grant Type: " + grantType);
        
        // Proceed with the filter chain
        chain.doFilter(request, response);

        // After the request is processed, capture the end time and calculate the duration
        long endTime = System.currentTimeMillis();
        long processingTime = endTime - startTime;
        _log.info("OAuth2 Token request processing completed. Total time: " + processingTime + " ms.");
    }
    
    @Override
    protected Log getLog() {
        return _log;
    }
}
