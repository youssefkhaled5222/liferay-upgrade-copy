<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.ejada.telemoney.otp.events.configuration.OTPConfiguration"%>
<%@ include file="/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>
<% 

	// Obtain OTPConfiguration object from render request attribute
	OTPConfiguration configuration = (OTPConfiguration) GetterUtil
			.getObject(renderRequest.getAttribute(OTPConfiguration.class.getName()));
	System.out.println("configuration.jsp file: "+ configuration);
	
	String getAllOTPEventsURL = ""; 
	String updateOTPEventURL = ""; 
	String XCorrelationId = ""; 
	String requestParam1 = ""; 
	String requestParam2 = ""; 
	String requestParam3 = ""; 
	String requestParam4 = ""; 
	String userName = ""; 
	String password = ""; 
	
	if (Validator.isNotNull(configuration)) { 
		getAllOTPEventsURL = portletPreferences.getValue("getAllOTPEventsURL", configuration.getAllOTPEventsURL());
		updateOTPEventURL = portletPreferences.getValue("updateOTPEventURL", configuration.updateOTPEventURL());
		XCorrelationId = portletPreferences.getValue("XCorrelationId", configuration.XCorrelationId()); 
		requestParam1 =	portletPreferences.getValue("requestParam1", configuration.requestParam1());
		requestParam2 =	portletPreferences.getValue("requestParam2", configuration.requestParam2());
		requestParam3 =	portletPreferences.getValue("requestParam3", configuration.requestParam3());
		requestParam4 =	portletPreferences.getValue("requestParam4", configuration.requestParam4());
		userName =	portletPreferences.getValue("userName", configuration.userName());
		password =	portletPreferences.getValue("password", configuration.password());

		
		} 
%>
<liferay-portlet:actionURL portletConfiguration="<%=true%>"
	var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="<%=true%>"
	var="configurationRenderURL" />

<div class="container py-4">
	<aui:form action="<%=configurationActionURL%>" method="post" name="fm">
		<aui:input name="redirect" type="hidden"
			value="<%=configurationRenderURL%>" />
		<aui:input name="<%=Constants.CMD%>" type="hidden"
			value="<%=Constants.UPDATE%>" />
		<aui:input name="getAllOTPEventsURL" label="Get all OTP Events URL" value="<%= getAllOTPEventsURL %>"/>
		<aui:input name="updateOTPEventURL" label="Update OTP Event URL" value="<%= updateOTPEventURL %>"/>
		<aui:input name="XCorrelationId" label="XCorrelationId" value="<%= XCorrelationId %>"/>
		<aui:input name="requestParam1" label="requestParam1" value="<%= requestParam1 %>"/>
		<aui:input name="requestParam2" label="requestParam2" value="<%= requestParam2 %>"/>
		<aui:input name="requestParam3" label="requestParam3" value="<%= requestParam3 %>"/>
		<aui:input name="requestParam4" label="requestParam4" value="<%= requestParam4 %>"/>
		<aui:input name="userName" label="userName" value="<%= userName %>"/>
		<aui:input name="password" label="password" value="<%= password %>"/>
		
		<aui:button-row>
			<aui:button type="submit"></aui:button>
		</aui:button-row>
	</aui:form>

</div>