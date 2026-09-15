<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ page import="com.liferay.portal.kernel.model.Role" %>
<%@ page import="java.util.List" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
	List<Role> roles = user.getRoles();
	boolean isAdministrator = roles.stream().anyMatch(
		role -> role.getName().equalsIgnoreCase("Administrator"));
	boolean isPo = roles.stream().anyMatch(
		role -> role.getName().equalsIgnoreCase("po"));
	//boolean isOther = !isAdministrator && !isPo;
	boolean isOther = false;
%>
