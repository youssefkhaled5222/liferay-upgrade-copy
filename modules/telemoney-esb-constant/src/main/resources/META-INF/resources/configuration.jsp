<%@page import="com.ejada.telemoney.telemoney.esb.constant.portlet.ViewESBConfiguration"%>
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
	ViewESBConfiguration configuration = (ViewESBConfiguration) GetterUtil
							.getObject(renderRequest.getAttribute(ViewESBConfiguration.class.getName()));
String esbUrl = ""; 
String esbReloadUrl = ""; 
String searchUrl = ""; 
String entityReloadUrl = ""; 
String XCorrelationId = "";  
String userName = ""; 
String password = ""; 
String esbUpdateUrl = "";
if (Validator.isNotNull(configuration)) 
	{ 
	esbUrl =	portletPreferences.getValue("esbUrl", configuration.esbUrl());
	esbReloadUrl =	portletPreferences.getValue("esbReloadUrl", configuration.esbReloadUrl());
	searchUrl =	portletPreferences.getValue("searchUrl", configuration.searchUrl());
	entityReloadUrl =	portletPreferences.getValue("entityReloadUrl", configuration.entityReloadUrl());
	XCorrelationId = portletPreferences.getValue("XCorrelationId", configuration.XCorrelationId()); 
	userName =	portletPreferences.getValue("userName", configuration.userName());
	password =	portletPreferences.getValue("password", configuration.password());
	esbUpdateUrl =	portletPreferences.getValue("esbUpdateUrl", configuration.esbUpdateUrl());
	
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
		<aui:input name="esbUrl" label="get all url" value="<%= esbUrl %>"/>
		<aui:input name="esbReloadUrl" label="esb Reload Url" value="<%= esbReloadUrl %>"/>
		<aui:input name="searchUrl" label="search Url" value="<%= searchUrl %>"/>
		<aui:input name="entityReloadUrl" label="entity Reload Url" value="<%= entityReloadUrl %>"/>
		<aui:input name="esbUpdateUrl" label="esb Update Url" value="<%= esbUpdateUrl %>"/>
		<aui:input name="XCorrelationId" label="XCorrelationId" value="<%= XCorrelationId %>"/>
		<aui:input name="userName" label="userName" value="<%= userName %>"/>
		<aui:input name="password" label="password" value="<%= password %>"/>
		
		<aui:button-row>
			<aui:button type="submit"></aui:button>
		</aui:button-row>
	</aui:form>

</div>