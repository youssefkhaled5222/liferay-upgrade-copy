package com.ejada.telemoney.cspFilter.portlet;

import java.io.IOException;
 
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.osgi.service.component.annotations.Component;
 
@Component(
    immediate = true,
    property = {
        "servlet-context-name=",
        "servlet-filter-name=Content Security Policy Filter",
        "url-pattern=/*"
    },
    service = Filter.class
)
public class CSPFilter implements Filter {
 
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
 
    @Override
    public void doFilter(
            ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
 
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		Cookie[] cookieArr=httpServletRequest.getCookies();
		boolean firstHeader = true;
        for (Cookie cookie : cookieArr) {
            String name = cookie.getName();
            String value = cookie.getValue();

            // Skip system-managed cookies (e.g., JSESSIONID, LFR_SESSION_STATE)
            if ("JSESSIONID".equalsIgnoreCase(name) || name.startsWith("LFR_")) {
                continue;
            }

            httpServletResponse.addHeader("Set-Cookie",
                    name + "=" + value + "; Path=/; HttpOnly; Secure; SameSite=Lax");
        }

//        if(cookieArr!=null) {
//			for(int i=0;i<cookieArr.length;i++) {
//					cookieArr[i].setSecure(true);
//					cookieArr[i].setHttpOnly(true);
//					httpServletResponse.setHeader("Set-Cookie", ""+cookieArr[i].getName()+"="+cookieArr[i].getValue()+"; HttpOnly; SameSite=Lax; Secure");
//			}
//		}
 
            
		
		  httpServletResponse.setHeader("Strict-Transport-Security",
		  "max-age=63072000; includeSubDomains; preload");

		  httpServletResponse.setHeader("X-Frame-Options", "SAMEORIGIN");
		  httpServletResponse.setHeader("X-Content-Type-Options", "nosniff");
		  httpServletResponse.setHeader("X-XSS-Protection", "1; mode=block");
		 
      httpServletResponse.setHeader("Referrer-Policy", "strict-origin-when-cross-origin");
      httpServletResponse.setHeader("Permissions-Policy", "geolocation=(), microphone=()");
//      httpServletResponse.setHeader("Content-Security-Policy",
//    		    "style-src 'self' 'unsafe-inline'; object-src 'none'; img-src 'self' ; connect-src 'self'; frame-ancestors 'none';");
        httpServletResponse.setHeader("Content-Security-Policy",
                "default-src 'self'; script-src 'self' 'unsafe-inline'; style-src 'self' 'unsafe-inline'; img-src * data:; connect-src *; frame-ancestors 'self';");


        chain.doFilter(request, response);
    }
 
    @Override
    public void destroy() {
    }
}