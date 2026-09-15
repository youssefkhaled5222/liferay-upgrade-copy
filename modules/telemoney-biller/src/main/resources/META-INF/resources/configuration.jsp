
<%@page import="com.ejada.telemoney.biller.portlet.ViewBillerConfiguration"%>
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
	ViewBillerConfiguration configuration = (ViewBillerConfiguration) GetterUtil
							.getObject(renderRequest.getAttribute(ViewBillerConfiguration.class.getName()));
String getAllBillers = ""; 
String updateBiller = ""; 
String addBiller = ""; 
String getAllPaymentTypes = ""; 
String deleteBiller = "";  
String defaultBillerId = ""; 
String defaultBillerName = ""; 
String defaultBillerCategoryId = ""; 
String getAllBillerCategory = ""; 
String addBillerCategory = "";
String updateBillerCategory = "";
String deleteBillerCategory = "";

if (Validator.isNotNull(configuration)) 
	{ 
	getAllBillers =	portletPreferences.getValue("getAllBillers", configuration.getAllBillers());
	updateBiller =	portletPreferences.getValue("updateBiller", configuration.updateBiller());
	addBiller =	portletPreferences.getValue("addBiller", configuration.addBiller());
	getAllPaymentTypes =	portletPreferences.getValue("getAllPaymentTypes", configuration.getAllPaymentTypes());
	deleteBiller = portletPreferences.getValue("deleteBiller", configuration.deleteBiller()); 
	defaultBillerId =	portletPreferences.getValue("defaultBillerId", configuration.defaultBillerId());
	defaultBillerName =	portletPreferences.getValue("defaultBillerName", configuration.defaultBillerName());
	defaultBillerCategoryId =	portletPreferences.getValue("defaultBillerCategoryId", configuration.defaultBillerCategoryId());
	getAllBillerCategory =	portletPreferences.getValue("getAllBillerCategory", configuration.getAllBillerCategory());
	addBillerCategory =	portletPreferences.getValue("addBillerCategory", configuration.addBillerCategory());
	updateBillerCategory =	portletPreferences.getValue("updateBillerCategory", configuration.updateBillerCategory());
	deleteBillerCategory =	portletPreferences.getValue("deleteBillerCategory", configuration.deleteBillerCategory());

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
		<aui:input name="getAllBillers" label="get all url" value="<%= getAllBillers %>"/>
		<aui:input name="updateBiller" label="Update Biller" value="<%= updateBiller %>"/>
		<aui:input name="addBiller" label="Add Biller" value="<%= addBiller %>"/>
		<aui:input name="getAllPaymentTypes" label="Get All Payment Types" value="<%= getAllPaymentTypes %>"/>
		<aui:input name="deleteBiller" label="Delete Biller" value="<%= deleteBiller %>"/>
		<aui:input name="defaultBillerId" label="Default BillerId" value="<%= defaultBillerId %>"/>
		<aui:input name="defaultBillerName" label="Default BillerName" value="<%= defaultBillerName %>"/>
		<aui:input name="defaultBillerCategoryId" label="Default Biller CategoryId" value="<%= defaultBillerCategoryId %>"/>
		<aui:input name="getAllBillerCategory" label="Get All Biller Categories" value="<%= getAllBillerCategory %>"/>
		<aui:input name="addBillerCategory" label="Add New Biller Category" value="<%= addBillerCategory %>"/>
		<aui:input name="updateBillerCategory" label="Update Biller Category" value="<%= updateBillerCategory %>"/>
		<aui:input name="deleteBillerCategory" label="delete Biller Category" value="<%= deleteBillerCategory %>"/>

		<aui:button-row>
			<aui:button type="submit"></aui:button>
		</aui:button-row>
	</aui:form>

</div>