<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ejada.telemony.db.model.Channels"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>

<portlet:actionURL name="getChannelId" var="getChannelId">
</portlet:actionURL>
<%
	HttpSession sessions = request.getSession();
	List<Channels> channels = (List<Channels>) request.getAttribute("channels") != null
			? (List<Channels>) request.getAttribute("channels")
			: new ArrayList<>();
	String chn = request.getAttribute("chn") != null
			? (String) request.getAttribute("chn")
			: "no channel in the session";
%>

<div class="telemoney-header">
	<div class="container">
		<div class="d-flex justify-content-between text-bg-primary py-2">

			<div class="d-flex align-items-center">
				<a class="logo"> <svg xmlns="http://www.w3.org/2000/svg"
						width="30" height="30" fill="currentColor" class="bi bi-coin"
						viewBox="0 0 16 16">
					  <path
							d="M5.5 9.511c.076.954.83 1.697 2.182 1.785V12h.6v-.709c1.4-.098 2.218-.846 2.218-1.932 0-.987-.626-1.496-1.745-1.76l-.473-.112V5.57c.6.068.982.396 1.074.85h1.052c-.076-.919-.864-1.638-2.126-1.716V4h-.6v.719c-1.195.117-2.01.836-2.01 1.853 0 .9.606 1.472 1.613 1.707l.397.098v2.034c-.615-.093-1.022-.43-1.114-.9H5.5zm2.177-2.166c-.59-.137-.91-.416-.91-.836 0-.47.345-.822.915-.925v1.76h-.005zm.692 1.193c.717.166 1.048.435 1.048.91 0 .542-.412.914-1.135.982V8.518l.087.02z" />
					  <path
							d="M8 15A7 7 0 1 1 8 x`1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z" />
					  <path
							d="M8 13.5a5.5 5.5 0 1 1 0-11 5.5 5.5 0 0 1 0 11zm0 .5A6 6 0 1 0 8 2a6 6 0 0 0 0 12z" />
					</svg>
				</a>
				<div class="nav-item dropdown">
					<a class="nav-link dropdown-toggle px-2" data-toggle="dropdown"
						href="#" role="button" aria-expanded="false"> <%=chn%> <svg
							xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-chevron-down"
							viewBox="0 0 16 16">
						  <path fill-rule="evenodd"
								d="M1.646 4.646a.5.5 0 0 1 .708 0L8 10.293l5.646-5.647a.5.5 0 0 1 .708.708l-6 6a.5.5 0 0 1-.708 0l-6-6a.5.5 0 0 1 0-.708z" />
						</svg>
					</a>
					<div class="dropdown-menu">


						<form action=<%=getChannelId%> method="post"
							name="<portlet:namespace/>chnnelIdForm"
							id="<portlet:namespace/>chnnelIdForm">
							<%
								for (Channels channel : channels) {
							%>
							<button class="dropdown-item"
								onclick="getChannelId('<%=channel.getChannelId()%>')">
								<%=channel.getName()%></button>
							<input type="text" class="d-none"
								name="<portlet:namespace/>channelId"
								id="<portlet:namespace/>channelId" />


							<%
								}
							%>
						</form>

					</div>
				</div>
			</div>

			<div class="d-flex align-items-center">
				<%
					if (themeDisplay.isSignedIn()) {
				%>
				<liferay-portlet:runtime portletName="com_liferay_product_navigation_user_personal_bar_web_portlet_ProductNavigationUserPersonalBarPortlet" />
				<%
					} else {
				%>
				<a class="nav-link" href="<%= themeDisplay.getURLSignIn() %>">Sign In</a>
				<%
					}
				%>

				<!-- <div class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
						role="button" aria-expanded="false"> username <svg
							xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-chevron-down"
							viewBox="0 0 16 16">
						  <path fill-rule="evenodd"
								d="M1.646 4.646a.5.5 0 0 1 .708 0L8 10.293l5.646-5.647a.5.5 0 0 1 .708.708l-6 6a.5.5 0 0 1-.708 0l-6-6a.5.5 0 0 1 0-.708z" />
						</svg>
					</a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">Action</a> <a
							class="dropdown-item" href="#">Another action</a> <a
							class="dropdown-item" href="#">Something else here</a>
					</div>
				</div>
				<div class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
						role="button" aria-expanded="false"> <svg
							xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-gear" viewBox="0 0 16 16">
						  <path
								d="M8 4.754a3.246 3.246 0 1 0 0 6.492 3.246 3.246 0 0 0 0-6.492zM5.754 8a2.246 2.246 0 1 1 4.492 0 2.246 2.246 0 0 1-4.492 0z" />
						  <path
								d="M9.796 1.343c-.527-1.79-3.065-1.79-3.592 0l-.094.319a.873.873 0 0 1-1.255.52l-.292-.16c-1.64-.892-3.433.902-2.54 2.541l.159.292a.873.873 0 0 1-.52 1.255l-.319.094c-1.79.527-1.79 3.065 0 3.592l.319.094a.873.873 0 0 1 .52 1.255l-.16.292c-.892 1.64.901 3.434 2.541 2.54l.292-.159a.873.873 0 0 1 1.255.52l.094.319c.527 1.79 3.065 1.79 3.592 0l.094-.319a.873.873 0 0 1 1.255-.52l.292.16c1.64.893 3.434-.902 2.54-2.541l-.159-.292a.873.873 0 0 1 .52-1.255l.319-.094c1.79-.527 1.79-3.065 0-3.592l-.319-.094a.873.873 0 0 1-.52-1.255l.16-.292c.893-1.64-.902-3.433-2.541-2.54l-.292.159a.873.873 0 0 1-1.255-.52l-.094-.319zm-2.633.283c.246-.835 1.428-.835 1.674 0l.094.319a1.873 1.873 0 0 0 2.693 1.115l.291-.16c.764-.415 1.6.42 1.184 1.185l-.159.292a1.873 1.873 0 0 0 1.116 2.692l.318.094c.835.246.835 1.428 0 1.674l-.319.094a1.873 1.873 0 0 0-1.115 2.693l.16.291c.415.764-.42 1.6-1.185 1.184l-.291-.159a1.873 1.873 0 0 0-2.693 1.116l-.094.318c-.246.835-1.428.835-1.674 0l-.094-.319a1.873 1.873 0 0 0-2.692-1.115l-.292.16c-.764.415-1.6-.42-1.184-1.185l.159-.291A1.873 1.873 0 0 0 1.945 8.93l-.319-.094c-.835-.246-.835-1.428 0-1.674l.319-.094A1.873 1.873 0 0 0 3.06 4.377l-.16-.292c-.415-.764.42-1.6 1.185-1.184l.292.159a1.873 1.873 0 0 0 2.692-1.115l.094-.319z" />
						</svg>
					</a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">Action</a> <a
							class="dropdown-item" href="#">Another action</a> <a
							class="dropdown-item" href="#">Something else here</a>
					</div>
				</div>
				<div class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
						role="button" aria-expanded="false"> <svg
							xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-bell" viewBox="0 0 16 16">
						  <path
								d="M8 16a2 2 0 0 0 2-2H6a2 2 0 0 0 2 2zM8 1.918l-.797.161A4.002 4.002 0 0 0 4 6c0 .628-.134 2.197-.459 3.742-.16.767-.376 1.566-.663 2.258h10.244c-.287-.692-.502-1.49-.663-2.258C12.134 8.197 12 6.628 12 6a4.002 4.002 0 0 0-3.203-3.92L8 1.917zM14.22 12c.223.447.481.801.78 1H1c.299-.199.557-.553.78-1C2.68 10.2 3 6.88 3 6c0-2.42 1.72-4.44 4.005-4.901a1 1 0 1 1 1.99 0A5.002 5.002 0 0 1 13 6c0 .88.32 4.2 1.22 6z" />
						</svg>
					</a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">Action</a> <a
							class="dropdown-item" href="#">Another action</a> <a
							class="dropdown-item" href="#">Something else here</a>
					</div>
				</div>
			 -->
			</div>
		</div>
	</div>
</div>

<script>
	function getChannelId(chanlId) {
		var recordIdField = document
				.getElementById('<portlet:namespace/>channelId');

		recordIdField.value = chanlId;

		document.getElementById('<portlet:namespace/>chnnelIdForm').submit();
	}
</script>