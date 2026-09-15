<%@page import="com.ejada.telemoney.sms.template.portlet.ViewSMSConfiguration"%>
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
	ViewSMSConfiguration configuration = (ViewSMSConfiguration) GetterUtil
							.getObject(renderRequest.getAttribute(ViewSMSConfiguration.class.getName()));
String smsURLGetAll = ""; 
String smsURLServiceUpdate = ""; 
String smsURLDescriptionUpdate = "";
String XCorrelationId = ""; 
String serviceRequestParam1 = ""; 
String serviceRequestParam2 = ""; 
String descriptionRequestParam1 = ""; 
String descriptionRequestParam2 = ""; 
String userName = ""; 
String password = ""; 
if (Validator.isNotNull(configuration)) 
	{ 
	smsURLGetAll = portletPreferences.getValue("smsURLGetAll", configuration.smsURLGetAll());
	smsURLServiceUpdate = portletPreferences.getValue("smsURLServiceUpdate", configuration.smsURLServiceUpdate()); 
	smsURLDescriptionUpdate = portletPreferences.getValue("smsURLDescriptionUpdate", configuration.smsURLDescriptionUpdate());
	XCorrelationId = portletPreferences.getValue("XCorrelationId", configuration.XCorrelationId()); 
	serviceRequestParam1 =	portletPreferences.getValue("serviceRequestParam1", configuration.serviceRequestParam1());
	serviceRequestParam2 =	portletPreferences.getValue("serviceRequestParam2", configuration.serviceRequestParam2());
	descriptionRequestParam1 =	portletPreferences.getValue("descriptionRequestParam1", configuration.descriptionRequestParam1());
	descriptionRequestParam2 =	portletPreferences.getValue("descriptionRequestParam2", configuration.descriptionRequestParam2());
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
		<aui:input name="smsURLGetAll" label="get all url" value="<%= smsURLGetAll %>"/>
		<aui:input name="smsURLServiceUpdate" label="sms Service Update URL" value="<%= smsURLServiceUpdate %>"/>
		<aui:input name="smsURLDescriptionUpdate" label="sms Description Update URL" value="<%= smsURLDescriptionUpdate %>"/>
		<aui:input name="XCorrelationId" label="XCorrelationId" value="<%= XCorrelationId %>"/>
		<aui:input name="serviceRequestParam1" label="serviceRequestParam1" value="<%= serviceRequestParam1 %>"/>
		<aui:input name="serviceRequestParam2" label="serviceRequestParam2" value="<%= serviceRequestParam2 %>"/>
		<aui:input name="descriptionRequestParam1" label="descriptionRequestParam1" value="<%= descriptionRequestParam1 %>"/>
		<aui:input name="descriptionRequestParam2" label="descriptionRequestParam2" value="<%= descriptionRequestParam2 %>"/>
		<aui:input name="userName" label="userName" value="<%= userName %>"/>
		<aui:input name="password" label="password" value="<%= password %>"/>
		
		<aui:button-row>
			<aui:button type="submit"></aui:button>
		</aui:button-row>
	</aui:form>

</div>