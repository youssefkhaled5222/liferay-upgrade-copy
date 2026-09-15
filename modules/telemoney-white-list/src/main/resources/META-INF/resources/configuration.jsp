<%@page import="com.ejada.telemoney.whiteList.configuration.WhiteListConfiguration"%>
<%@page import="javax.portlet.PortletPreferences"%>
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
	WhiteListConfiguration configuration = (WhiteListConfiguration) GetterUtil
			.getObject(renderRequest.getAttribute(WhiteListConfiguration.class.getName()));
	System.out.println("configuration.jsp file: "+ configuration);
	
	String getAllWhiteListed = ""; 
	String updateWhiteListedStatus = ""; 
	String XCorrelationId = ""; 
	String defaultPOI = ""; 
	
	
	if (Validator.isNotNull(configuration)) { 
		getAllWhiteListed = portletPreferences.getValue("getAllWhiteListed", configuration.getAllWhiteListed());
		updateWhiteListedStatus = portletPreferences.getValue("updateWhiteListedStatus", configuration.updateWhiteListedStatus());
		XCorrelationId = portletPreferences.getValue("XCorrelationId", configuration.XCorrelationId());
		defaultPOI = portletPreferences.getValue("defaultPOI", configuration.defaultPOI());

		
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
		<aui:input name="getAllWhiteListed" label="Get all White Listed Users" value="<%= getAllWhiteListed %>"/>
		<aui:input name="updateWhiteListedStatus" label="Update White Listed Users" value="<%= updateWhiteListedStatus %>"/>
		<aui:input name="XCorrelationId" label="XCorrelationId" value="<%= XCorrelationId %>"/>
		<aui:input name="defaultPOI" label="defaultPOI" value="<%= defaultPOI %>"/>
		
		
		<aui:button-row>
			<aui:button type="submit"></aui:button>
		</aui:button-row>
	</aui:form>

</div>