<%@ include file="/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@page import="com.ejada.telemony.db.model.UserLogs"%>
<%@page import="com.ejada.telemony.db.model.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>
<portlet:defineObjects />

<%
	ThemeDisplay themeDisplayView = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

	String personasUrl = (String) themeDisplayView.getPortalURL()
			+ PropsUtil.get("com.ejada.telemoney.personas") != null
					? (String) themeDisplayView.getPortalURL() + PropsUtil.get("com.ejada.telemoney.personas")
					: "";
	String bannersUrl = (String) themeDisplayView.getPortalURL()
			+ PropsUtil.get("com.ejada.telemoney.banners") != null
					? (String) themeDisplayView.getPortalURL() + PropsUtil.get("com.ejada.telemoney.banners")
					: "";
	String languagesUrl = (String) themeDisplayView.getPortalURL()
			+ PropsUtil.get("com.ejada.telemoney.languages") != null
					? (String) themeDisplayView.getPortalURL() + PropsUtil.get("com.ejada.telemoney.languages")
					: "";

	String themesUrl = (String) themeDisplayView.getPortalURL()
			+ PropsUtil.get("com.ejada.telemoney.themes") != null
					? (String) themeDisplayView.getPortalURL() + PropsUtil.get("com.ejada.telemoney.themes")
					: "";

	String listOfValuesUrl = (String) themeDisplayView.getPortalURL()
			+ PropsUtil.get("com.ejada.telemoney.listOfValues") != null
					? (String) themeDisplayView.getPortalURL()
							+ PropsUtil.get("com.ejada.telemoney.listOfValues")
					: "";
	String resourcesUrl = (String) themeDisplayView.getPortalURL()
			+ PropsUtil.get("com.ejada.telemoney.resources") != null
					? (String) themeDisplayView.getPortalURL() + PropsUtil.get("com.ejada.telemoney.resources")
					: "";
	String localizationsUrl = (String) themeDisplayView.getPortalURL()
			+ PropsUtil.get("com.ejada.telemoney.localizations") != null
					? (String) themeDisplayView.getPortalURL()
							+ PropsUtil.get("com.ejada.telemoney.localizations")
					: "";
	String featuresTogglingUrl = (String) themeDisplayView.getPortalURL()
			+ PropsUtil.get("com.ejada.telemoney.featuresToggling") != null
					? (String) themeDisplayView.getPortalURL()
							+ PropsUtil.get("com.ejada.telemoney.featuresToggling")
					: "";
%>

<div>
	<div class="pb-4">
		<h3>
			Welcome,

			<%
			List<UserLogs> userLogs = (List<UserLogs>) request.getAttribute("list_of_logs") != null
					? (List<UserLogs>) request.getAttribute("list_of_logs")
					: new ArrayList<>();
			if (userLogs.isEmpty()) {
				out.print("No user logs available");
			} else {
				int indexToDisplay = 0;
				if (indexToDisplay >= 0 && indexToDisplay < userLogs.size()) {
					UserLogs userLog = userLogs.get(indexToDisplay);
					out.print(userLog.getUserName());
				} else {
					out.print("User not found");
				}
			}
		%>
		</h3>
		<div
			class="d-inline-flex align-items-center badge badge-pill badge-primary">
			<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
				fill="currentColor" class="bi bi-clock-history mr-1"
				viewBox="0 0 16 16">
			  <path
					d="M8.515 1.019A7 7 0 0 0 8 1V0a8 8 0 0 1 .589.022l-.074.997zm2.004.45a7.003 7.003 0 0 0-.985-.299l.219-.976c.383.086.76.2 1.126.342l-.36.933zm1.37.71a7.01 7.01 0 0 0-.439-.27l.493-.87a8.025 8.025 0 0 1 .979.654l-.615.789a6.996 6.996 0 0 0-.418-.302zm1.834 1.79a6.99 6.99 0 0 0-.653-.796l.724-.69c.27.285.52.59.747.91l-.818.576zm.744 1.352a7.08 7.08 0 0 0-.214-.468l.893-.45a7.976 7.976 0 0 1 .45 1.088l-.95.313a7.023 7.023 0 0 0-.179-.483zm.53 2.507a6.991 6.991 0 0 0-.1-1.025l.985-.17c.067.386.106.778.116 1.17l-1 .025zm-.131 1.538c.033-.17.06-.339.081-.51l.993.123a7.957 7.957 0 0 1-.23 1.155l-.964-.267c.046-.165.086-.332.12-.501zm-.952 2.379c.184-.29.346-.594.486-.908l.914.405c-.16.36-.345.706-.555 1.038l-.845-.535zm-.964 1.205c.122-.122.239-.248.35-.378l.758.653a8.073 8.073 0 0 1-.401.432l-.707-.707z" />
			  <path
					d="M8 1a7 7 0 1 0 4.95 11.95l.707.707A8.001 8.001 0 1 1 8 0v1z" />
			  <path
					d="M7.5 3a.5.5 0 0 1 .5.5v5.21l3.248 1.856a.5.5 0 0 1-.496.868l-3.5-2A.5.5 0 0 1 7 9V3.5a.5.5 0 0 1 .5-.5z" />
			</svg>
			Last Active 06-06-2023 12:14 PM
		</div>
	</div>
	<div class="row justify-content-between">
		<div class="col-md-7">
			<div class="row">
				<div class="col-md-3 mb-4">
					<div class="card bg-info text-white h-100 cursor-pointer">
						<div class="card-body d-flex flex-column h-100">
							<div class="icon d-flex justify-content-end">
								<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25"
									fill="currentColor" class="bi bi-person-square"
									viewBox="0 0 16 16">
								  <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
								  <path
										d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm12 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1v-1c0-1-1-4-6-4s-6 3-6 4v1a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12z" />
								</svg>
							</div>
							<div onclick="window.location='<%=personasUrl%>'"
								style="cursor: pointer;">
								<div class="h1 pt-2 mt-auto"><%=renderRequest.getAttribute("getNumberOfPersona")%></div>
								<div>Personas</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-3 mb-4">
					<div class="card bg-info text-white h-100 cursor-pointer">
						<div class="card-body d-flex flex-column h-100">
							<div class="icon d-flex justify-content-end">
								<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25"
									fill="currentColor" class="bi bi-image" viewBox="0 0 16 16">
								  <path d="M6.002 5.5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z" />
								  <path
										d="M2.002 1a2 2 0 0 0-2 2v10a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V3a2 2 0 0 0-2-2h-12zm12 1a1 1 0 0 1 1 1v6.5l-3.777-1.947a.5.5 0 0 0-.577.093l-3.71 3.71-2.66-1.772a.5.5 0 0 0-.63.062L1.002 12V3a1 1 0 0 1 1-1h12z" />
								</svg>
							</div>

							<div onclick="window.location='<%=bannersUrl%>'"
								style="cursor: pointer;">
								<div class="h1 pt-2 mt-auto"><%=renderRequest.getAttribute("getNumberOfBanner")%></div>
								<div>Banners</div>
							</div>


						</div>
					</div>
				</div>
				<div class="col-md-3 mb-4">
					<div class="card bg-info text-white h-100">
						<div class="card-body d-flex flex-column h-100 cursor-pointer">
							<div class="icon d-flex justify-content-end">
								<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25"
									fill="currentColor" class="bi bi-x-octagon" viewBox="0 0 16 16">
								  <path
										d="M4.54.146A.5.5 0 0 1 4.893 0h6.214a.5.5 0 0 1 .353.146l4.394 4.394a.5.5 0 0 1 .146.353v6.214a.5.5 0 0 1-.146.353l-4.394 4.394a.5.5 0 0 1-.353.146H4.893a.5.5 0 0 1-.353-.146L.146 11.46A.5.5 0 0 1 0 11.107V4.893a.5.5 0 0 1 .146-.353L4.54.146zM5.1 1 1 5.1v5.8L5.1 15h5.8l4.1-4.1V5.1L10.9 1H5.1z" />
								  <path
										d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z" />
								</svg>
							</div>
							<div onclick="window.location='<%=languagesUrl%>'"
								style="cursor: pointer;">
								<div class="h1 pt-2 mt-auto"><%=renderRequest.getAttribute("getNnumberOfLanguages")%></div>
								<div>Languages</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-3 mb-4">
					<div class="card bg-info text-white h-100">
						<div class="card-body d-flex flex-column h-100 cursor-pointer">
							<div class="icon d-flex justify-content-end">
								<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25"
									fill="currentColor" class="bi bi-palette-fill"
									viewBox="0 0 16 16">
								  <path
										d="M12.433 10.07C14.133 10.585 16 11.15 16 8a8 8 0 1 0-8 8c1.996 0 1.826-1.504 1.649-3.08-.124-1.101-.252-2.237.351-2.92.465-.527 1.42-.237 2.433.07zM8 5a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3zm4.5 3a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3zM5 6.5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm.5 6.5a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3z" />
								</svg>
							</div>

							<div onclick="window.location='<%=themesUrl%>'"
								style="cursor: pointer;">
								<div class="h1 pt-2 mt-auto"><%=renderRequest.getAttribute("getNumberOfThemes")%></div>
								<div>Themes</div>
							</div>
						</div>
					</div>
				</div>

				<div class="col-md-3 mb-4">
					<div class="card bg-info text-white h-100">
						<div class="card-body d-flex flex-column h-100 cursor-pointer">
							<div class="icon d-flex justify-content-end">
								<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25"
									fill="currentColor" class="bi bi-palette-fill"
									viewBox="0 0 16 16">
								  <path
										d="M12.433 10.07C14.133 10.585 16 11.15 16 8a8 8 0 1 0-8 8c1.996 0 1.826-1.504 1.649-3.08-.124-1.101-.252-2.237.351-2.92.465-.527 1.42-.237 2.433.07zM8 5a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3zm4.5 3a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3zM5 6.5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm.5 6.5a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3z" />
								</svg>
							</div>
							<div onclick="window.location='<%=listOfValuesUrl%>'"
								style="cursor: pointer;">
								<div class="h1 pt-2 mt-auto"><%=renderRequest.getAttribute("getNnumberOfLOV")%></div>
								<div>List Of Value</div>
							</div>

						</div>
					</div>
				</div>

				<div class="col-md-3 mb-4">
					<div class="card bg-info text-white h-100">
						<div class="card-body d-flex flex-column h-100 cursor-pointer">
							<div class="icon d-flex justify-content-end">
								<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25"
									fill="currentColor" class="bi bi-palette-fill"
									viewBox="0 0 16 16">
								  <path
										d="M12.433 10.07C14.133 10.585 16 11.15 16 8a8 8 0 1 0-8 8c1.996 0 1.826-1.504 1.649-3.08-.124-1.101-.252-2.237.351-2.92.465-.527 1.42-.237 2.433.07zM8 5a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3zm4.5 3a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3zM5 6.5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm.5 6.5a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3z" />
								</svg>
							</div>

							<div onclick="window.location='<%=resourcesUrl%>'"
								style="cursor: pointer;">
								<div class="h1 pt-2 mt-auto"><%=renderRequest.getAttribute("getNnumberOfResources")%></div>
								<div>Resources</div>
							</div>

						</div>
					</div>
				</div>

				<div class="col-md-3 mb-4">
					<div class="card bg-info text-white h-100">
						<div class="card-body d-flex flex-column h-100 cursor-pointer">
							<div class="icon d-flex justify-content-end">
								<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25"
									fill="currentColor" class="bi bi-palette-fill"
									viewBox="0 0 16 16">
								  <path
										d="M12.433 10.07C14.133 10.585 16 11.15 16 8a8 8 0 1 0-8 8c1.996 0 1.826-1.504 1.649-3.08-.124-1.101-.252-2.237.351-2.92.465-.527 1.42-.237 2.433.07zM8 5a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3zm4.5 3a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3zM5 6.5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm.5 6.5a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3z" />
								</svg>
							</div>

							<div onclick="window.location='<%=localizationsUrl%>'"
								style="cursor: pointer;">
								<div class="h1 pt-2 mt-auto"><%=renderRequest.getAttribute("getNnumberOfLanguages")%></div>
								<div>Localization</div>
							</div>

						</div>
					</div>
				</div>

				<div class="col-md-3 mb-4">
					<div class="card bg-info text-white h-100">
						<div class="card-body d-flex flex-column h-100 cursor-pointer">
							<div class="icon d-flex justify-content-end">
								<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25"
									fill="currentColor" class="bi bi-palette-fill"
									viewBox="0 0 16 16">
								  <path
										d="M12.433 10.07C14.133 10.585 16 11.15 16 8a8 8 0 1 0-8 8c1.996 0 1.826-1.504 1.649-3.08-.124-1.101-.252-2.237.351-2.92.465-.527 1.42-.237 2.433.07zM8 5a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3zm4.5 3a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3zM5 6.5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm.5 6.5a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3z" />
								</svg>
							</div>
							<div onclick="window.location='<%=featuresTogglingUrl%>'"
								style="cursor: pointer;">
								<div class="h1 pt-2 mt-auto"><%=renderRequest.getAttribute("getNnumberOfFT")%></div>
								<div>Feature Toggiling</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-4">
			<div class="card">
				<div class="card-header">
					<h3>Log Stream</h3>
				</div>
				<ul class="list-group list-group-flush">
					<%
						if (userLogs.isEmpty()) {
					%>
					<h3 class="text-center py-2">No user logs available</h3>
					<%
						}
						for (UserLogs userLog : userLogs) {
					%>
					<li class="list-group-item py-2">
						<div class="d-flex align-items-center">
							<div class="pr-3 text-success">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-person-square"
									viewBox="0 0 16 16">
							  <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
							  <path
										d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm12 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1v-1c0-1-1-4-6-4s-6 3-6 4v1a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12z" />
							</svg>
							</div>
							<div>
								<%=userLog.getUserName()%>
								<%=userLog.getUserActivity()%>
								<br /> <span class="badge badge-pill badge-primary"> <%=userLog.getLogTime()%>
								</span>
							</div>
						</div>
					</li>
					<%
						}
					%>
				</ul>
			</div>
		</div>
	</div>
</div>
<style>
.cursor-pointer {
	cursor: pointer;
}
</style>