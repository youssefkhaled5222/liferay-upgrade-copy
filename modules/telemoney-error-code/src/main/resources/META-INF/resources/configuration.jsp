<%@page import="com.ejada.telemoney.error.code.portlet.ViewErrorCodeConfiguration"%>
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
	ViewErrorCodeConfiguration configuration = (ViewErrorCodeConfiguration) GetterUtil
							.getObject(renderRequest.getAttribute(ViewErrorCodeConfiguration.class.getName()));
String errorCodeUrl = ""; 
String updateErrorCode = ""; 
String getAllLanguages = ""; 
String searchByCode = ""; 
String XCorrelationId = "";  
String userName = ""; 
String password = ""; 
if (Validator.isNotNull(configuration)) 
	{ 
	errorCodeUrl =	portletPreferences.getValue("errorCodeUrl", configuration.errorCodeUrl());
	updateErrorCode =	portletPreferences.getValue("updateErrorCode", configuration.updateErrorCode());
	getAllLanguages =	portletPreferences.getValue("getAllLanguages", configuration.getAllLanguages());
	searchByCode =	portletPreferences.getValue("searchByCode", configuration.searchByCode());
	XCorrelationId = portletPreferences.getValue("XCorrelationId", configuration.XCorrelationId()); 
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
		<aui:input name="errorCodeUrl" label="get all url" value="<%= errorCodeUrl %>"/>
		<aui:input name="updateErrorCode" label="update Error Code URL" value="<%= updateErrorCode %>"/>
		<aui:input name="getAllLanguages" label="get All Languages" value="<%= getAllLanguages %>"/>
		<aui:input name="searchByCode" label="search By Code URL" value="<%= searchByCode %>"/>
		<aui:input name="XCorrelationId" label="XCorrelationId" value="<%= XCorrelationId %>"/>
		<aui:input name="userName" label="userName" value="<%= userName %>"/>
		<aui:input name="password" label="password" value="<%= password %>"/>
		
		<aui:button-row>
			<aui:button type="submit"></aui:button>
		</aui:button-row>
	</aui:form>

</div>