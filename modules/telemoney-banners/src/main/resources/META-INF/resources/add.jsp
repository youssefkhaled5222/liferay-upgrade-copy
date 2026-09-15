<%@page import="com.ejada.telemony.db.model.BannerContent"%>
<%@page import="com.ejada.telemony.db.model.Blocks"%>
<%@ include file="/init.jsp"%>

<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ page import="java.sql.Blob"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Base64"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.ejada.telemony.db.model.Persona"%>
<%@page import="com.liferay.portal.kernel.util.FileUtil"%>

<portlet:renderURL var="back">
	<portlet:param name="action" value="view" />
</portlet:renderURL>
<%
	Long bannerId = (Long) request.getAttribute("bannerId") != null
			? (Long) request.getAttribute("bannerId")
			: 0;

	Long blockId = (Long) request.getAttribute("blockId") != null ? (Long) request.getAttribute("blockId") : 0;

	String bannerName = (String) request.getAttribute("bannerName") != null
			? (String) request.getAttribute("bannerName")
			: "";

	String container = (String) request.getAttribute("container") != null
			? (String) request.getAttribute("container")
			: "";

	String bannerType = (String) request.getAttribute("bannerType") != null
			? (String) request.getAttribute("bannerType")
			: "";

	String linkType = (String) request.getAttribute("linkType") != null
			? (String) request.getAttribute("linkType")
			: "";

	String selectedPersonas = (String) request.getAttribute("selectedPersonas") != null
			? (String) request.getAttribute("selectedPersonas")
			: "";

	JSONArray selectedPersonasJSON = JSONFactoryUtil.createJSONArray(selectedPersonas);

	Date dateFrom = (Date) request.getAttribute("dateFrom") != null
			? (Date) request.getAttribute("dateFrom")
			: new Date();
	Calendar startCalendar = Calendar.getInstance();
	startCalendar.setTime(dateFrom);
	int startYearBanner = startCalendar.get(Calendar.YEAR);
	int startMonthBanner = startCalendar.get(Calendar.MONTH);
	int startDayBanner = startCalendar.get(Calendar.DAY_OF_MONTH);

	Date dateTo = (Date) request.getAttribute("dateTo") != null
			? (Date) request.getAttribute("dateTo")
			: new Date();
	Calendar endCalendar = Calendar.getInstance();
	endCalendar.setTime(dateTo);
	int endYearBanner = endCalendar.get(Calendar.YEAR);
	int endMonthBanner = endCalendar.get(Calendar.MONTH);
	int endDayBanner = endCalendar.get(Calendar.DAY_OF_MONTH);

	//get the data from the map for the title and description, 

	List<Persona> personas = (List<Persona>) request.getAttribute("personas") != null
			? (List<Persona>) request.getAttribute("personas")
			: new ArrayList<>();

	List<BannerContent> bannerContents = (List<BannerContent>) request.getAttribute("bannerContents") != null
			? (List<BannerContent>) request.getAttribute("bannerContents")
			: new ArrayList<>();

	String androidVersion = (String) request.getAttribute("androidVersion") != null
			? (String) request.getAttribute("androidVersion")
			: "";

	String iosVersion = (String) request.getAttribute("iosVersion") != null
			? (String) request.getAttribute("iosVersion")
			: "";

	String webVersion = (String) request.getAttribute("webVersion") != null
			? (String) request.getAttribute("webVersion")
			: "";

	boolean androidCheck = request.getAttribute("androidCheck") != null
			? (boolean) request.getAttribute("androidCheck")
			: false;

	boolean iosCheck = request.getAttribute("iosCheck") != null
			? (boolean) request.getAttribute("iosCheck")
			: false;

	boolean webCheck = request.getAttribute("webCheck") != null
			? (boolean) request.getAttribute("webCheck")
			: false;

	boolean hasPendingVersion = request.getAttribute("hasPendingVersion") != null
			? (boolean) request.getAttribute("hasPendingVersion")
			: false;

	Map<String, Integer> androidBlock = (Map<String, Integer>) request.getAttribute("androidBlock") != null
			? (Map<String, Integer>) request.getAttribute("androidBlock")
			: new HashMap<String, Integer>() {
				{
					put("startYear", startYearBanner);
					put("startMonth", startMonthBanner);
					put("startDay", startDayBanner);
					put("endYear", endYearBanner);
					put("endMonth", endMonthBanner);
					put("endDay", endDayBanner);
				}
			};

	Map<String, Integer> iosBlock = (Map<String, Integer>) request.getAttribute("iosBlock") != null
			? (Map<String, Integer>) request.getAttribute("iosBlock")
			: new HashMap<String, Integer>() {
				{
					put("startYear", startYearBanner);
					put("startMonth", startMonthBanner);
					put("startDay", startDayBanner);
					put("endYear", endYearBanner);
					put("endMonth", endMonthBanner);
					put("endDay", endDayBanner);
				}
			};
	Map<String, Integer> webBlock = (Map<String, Integer>) request.getAttribute("webBlock") != null
			? (Map<String, Integer>) request.getAttribute("webBlock")
			: new HashMap<String, Integer>() {
				{
					put("startYear", startYearBanner);
					put("startMonth", startMonthBanner);
					put("startDay", startDayBanner);
					put("endYear", endYearBanner);
					put("endMonth", endMonthBanner);
					put("endDay", endDayBanner);
				}
			};
%>


<portlet:actionURL name="addBannerLocalized" var="addBannerLocalized">
	<portlet:param name="selectedBannerId"
		value="<%=String.valueOf(bannerId)%>" />
	<portlet:param name="blockId" value="<%=String.valueOf(blockId)%>" />
</portlet:actionURL>
<portlet:renderURL var="newContent">
	<portlet:param name="myview" value="addContent" />
	<portlet:param name="bannerId" value="<%=String.valueOf(bannerId)%>" />
	<portlet:param name="hasPendingVersion" value="<%=String.valueOf(hasPendingVersion)%>" />
</portlet:renderURL>



<div>
	<h3 class="pb-4">Add/Edit Banner</h3>
	<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
	<liferay-ui:error
			key="hasPendingVersion"
			message="This banner has a pending draft version and cannot be modified until it is approved or discarded." />


	<% if (hasPendingVersion) { %>
	<div class="alert alert-warning" role="alert" style="background-color: #fff3cd; border-color: #ffeaa7; color: #856404;">
		<strong>Pending Approval:</strong> This banner has changes pending approval. You cannot make edits until the pending changes are reviewed.
	</div>
	<% } %>

	<div class="card">
		<div class="card-body">

			<form action="<%=addBannerLocalized%>" method="post" id="bannerAddForm" onsubmit="<%= hasPendingVersion ? "return false;" : "return validateAllDates();" %>">
				<!-- Hidden input for server-side validation -->
				<input type="hidden" name="<portlet:namespace/>hasPendingVersion" value="<%= hasPendingVersion %>" />
				<fieldset <%= isOther ? "disabled" : "" %>>
				<h4>Basic</h4>
				<div class="row">
					<div class="col-md-6">
						<div class="mb-3">
							<label class="form-label">Title</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed."
								name="<portlet:namespace/>bannerName" type="text"
								class="form-control" id="bannerName" value="<%=bannerName%>"
								required />
						</div>
						<div class="mb-3">
							<label class="form-label">Container</label> <select pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed."
								name="<portlet:namespace/>container" class="custom-select"
								id="inputGroupSelect05" required>
								<option disabled <%=container != "" ? "" : "selected"%>>Choose...</option>
								<option value="0" <%=container.equals("0") ? "selected" : ""%>>Dashboard</option>
								<option value="1" <%=container.equals("1") ? "selected" : ""%>>Transfer</option>
							</select>
						</div>
						<div class="mb-3">
							<label class="form-label">Banner Type</label> <select disabled
								name="<portlet:namespace/>bannerType" class="custom-select"
								id="inputGroupSelect06" required pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed.">
								<option disabled selected>Choose...</option>
							</select>
						</div>
						<div class="mb-3">
							<h4>Block Details</h4>
							<div>this instance will be blocked on the following:</div>
							<div class="form-check d-flex align-items-center">
								<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." name="<portlet:namespace/>androidCheck"
									class="form-check-input block-settings-checkbox"
									type="checkbox" id="blockDetailsCheck1"
									<%=androidCheck ? "checked" : ""%>> <label
									class="form-check-label d-flex align-items-center mx-2"
									for="blockDetailsCheck1"> <svg
										xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-android2" viewBox="0 0 16 16">
								  <path
											d="m10.213 1.471.691-1.26c.046-.083.03-.147-.048-.192-.085-.038-.15-.019-.195.058l-.7 1.27A4.832 4.832 0 0 0 8.005.941c-.688 0-1.34.135-1.956.404l-.7-1.27C5.303 0 5.239-.018 5.154.02c-.078.046-.094.11-.049.193l.691 1.259a4.25 4.25 0 0 0-1.673 1.476A3.697 3.697 0 0 0 3.5 5.02h9c0-.75-.208-1.44-.623-2.072a4.266 4.266 0 0 0-1.664-1.476ZM6.22 3.303a.367.367 0 0 1-.267.11.35.35 0 0 1-.263-.11.366.366 0 0 1-.107-.264.37.37 0 0 1 .107-.265.351.351 0 0 1 .263-.11c.103 0 .193.037.267.11a.36.36 0 0 1 .112.265.36.36 0 0 1-.112.264Zm4.101 0a.351.351 0 0 1-.262.11.366.366 0 0 1-.268-.11.358.358 0 0 1-.112-.264c0-.103.037-.191.112-.265a.367.367 0 0 1 .268-.11c.104 0 .19.037.262.11a.367.367 0 0 1 .107.265c0 .102-.035.19-.107.264ZM3.5 11.77c0 .294.104.544.311.75.208.204.46.307.76.307h.758l.01 2.182c0 .276.097.51.292.703a.961.961 0 0 0 .7.288.973.973 0 0 0 .71-.288.95.95 0 0 0 .292-.703v-2.182h1.343v2.182c0 .276.097.51.292.703a.972.972 0 0 0 .71.288.973.973 0 0 0 .71-.288.95.95 0 0 0 .292-.703v-2.182h.76c.291 0 .54-.103.749-.308.207-.205.311-.455.311-.75V5.365h-9v6.404Zm10.495-6.587a.983.983 0 0 0-.702.278.91.91 0 0 0-.293.685v4.063c0 .271.098.501.293.69a.97.97 0 0 0 .702.284c.28 0 .517-.095.712-.284a.924.924 0 0 0 .293-.69V6.146a.91.91 0 0 0-.293-.685.995.995 0 0 0-.712-.278Zm-12.702.283a.985.985 0 0 1 .712-.283c.273 0 .507.094.702.283a.913.913 0 0 1 .293.68v4.063a.932.932 0 0 1-.288.69.97.97 0 0 1-.707.284.986.986 0 0 1-.712-.284.924.924 0 0 1-.293-.69V6.146c0-.264.098-.491.293-.68Z" />
								</svg> Android
								</label>
							</div>
							<div class="m-2 block-settings blockDetailsCheck1"
								style="display: <%=androidCheck ? "block" : "none"%>;">
								<div class="mb-3">
									<label class="form-label">Versions</label> <select pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed."
										class="custom-select" id="inputGroupSelect02"
										name="<portlet:namespace />androidVersion">
										<option value="5"
											<%=androidVersion.equals("5") ? "selected" : ""%>>Android
											5</option>
										<option value="6"
											<%=androidVersion.equals("6") ? "selected" : ""%>>Android
											6</option>
										<option value="7"
											<%=androidVersion.equals("7") ? "selected" : ""%>>Android
											7</option>
										<option value="8"
											<%=androidVersion.equals("8") ? "selected" : ""%>>Android
											8</option>
										<option value="9"
											<%=androidVersion.equals("9") ? "selected" : ""%>>Android
											9</option>
										<option value="10"
											<%=androidVersion.equals("10") ? "selected" : ""%>>Android
											10</option>
										<option value="11"
											<%=androidVersion.equals("11") ? "selected" : ""%>>Android
											11</option>
										<option value="12"
											<%=androidVersion.equals("12") ? "selected" : ""%>>Android
											12</option>
										<option value="13"
											<%=androidVersion.equals("13") ? "selected" : ""%>>Android
											13</option>
										<option value="14"
											<%=androidVersion.equals("14") ? "selected" : ""%>>Android
											14</option>
									</select>
								</div>
								<div class="row mb-3">
									<div class="col-md-4">
										<label class="form-label">From</label>
										<liferay-ui:input-date name="androidStartDate"
											yearValue="<%=androidBlock.get("startYear")%>"
											dayValue="<%=androidBlock.get("startDay")%>"
											monthValue="<%=androidBlock.get("startMonth")%>" />
									</div>
									<div class="col-md-4">
										<label class="form-label">To</label>
										<liferay-ui:input-date name="androidEndDate"
											yearValue="<%=androidBlock.get("endYear")%>"
											dayValue="<%=androidBlock.get("endDay")%>"
											monthValue="<%=androidBlock.get("endMonth")%>" />
									</div>
								</div>
							</div>
							<div class="form-check d-flex align-items-center">
								<input class="form-check-input block-settings-checkbox"
									name="<portlet:namespace/>iosCheck" type="checkbox"
									id="blockDetailsCheck2" <%=iosCheck ? "checked" : ""%>>
								<label class="form-check-label d-flex align-items-center mx-2"
									for="blockDetailsCheck2"> <svg
										xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-apple" viewBox="0 0 16 16">
								  <path
											d="M11.182.008C11.148-.03 9.923.023 8.857 1.18c-1.066 1.156-.902 2.482-.878 2.516.024.034 1.52.087 2.475-1.258.955-1.345.762-2.391.728-2.43Zm3.314 11.733c-.048-.096-2.325-1.234-2.113-3.422.212-2.189 1.675-2.789 1.698-2.854.023-.065-.597-.79-1.254-1.157a3.692 3.692 0 0 0-1.563-.434c-.108-.003-.483-.095-1.254.116-.508.139-1.653.589-1.968.607-.316.018-1.256-.522-2.267-.665-.647-.125-1.333.131-1.824.328-.49.196-1.422.754-2.074 2.237-.652 1.482-.311 3.83-.067 4.56.244.729.625 1.924 1.273 2.796.576.984 1.34 1.667 1.659 1.899.319.232 1.219.386 1.843.067.502-.308 1.408-.485 1.766-.472.357.013 1.061.154 1.782.539.571.197 1.111.115 1.652-.105.541-.221 1.324-1.059 2.238-2.758.347-.79.505-1.217.473-1.282Z" />
								  <path
											d="M11.182.008C11.148-.03 9.923.023 8.857 1.18c-1.066 1.156-.902 2.482-.878 2.516.024.034 1.52.087 2.475-1.258.955-1.345.762-2.391.728-2.43Zm3.314 11.733c-.048-.096-2.325-1.234-2.113-3.422.212-2.189 1.675-2.789 1.698-2.854.023-.065-.597-.79-1.254-1.157a3.692 3.692 0 0 0-1.563-.434c-.108-.003-.483-.095-1.254.116-.508.139-1.653.589-1.968.607-.316.018-1.256-.522-2.267-.665-.647-.125-1.333.131-1.824.328-.49.196-1.422.754-2.074 2.237-.652 1.482-.311 3.83-.067 4.56.244.729.625 1.924 1.273 2.796.576.984 1.34 1.667 1.659 1.899.319.232 1.219.386 1.843.067.502-.308 1.408-.485 1.766-.472.357.013 1.061.154 1.782.539.571.197 1.111.115 1.652-.105.541-.221 1.324-1.059 2.238-2.758.347-.79.505-1.217.473-1.282Z" />
								</svg> IOS
								</label>
							</div>
							<div class="m-2 block-settings blockDetailsCheck2"
								style="display: <%=iosCheck ? "block" : "none"%>;">
								<div class="mb-3">
									<label class="form-label">Versions</label> <select
										class="custom-select" id="inputGroupSelect03"
										name="<portlet:namespace />iosVersion">
										<option value="13"
											<%=iosVersion.equals("13") ? "selected" : ""%>>IOS
											13</option>
										<option value="14"
											<%=iosVersion.equals("14") ? "selected" : ""%>>IOS
											14</option>
										<option value="15"
											<%=iosVersion.equals("15") ? "selected" : ""%>>IOS
											15</option>
										<option value="16"
											<%=iosVersion.equals("16") ? "selected" : ""%>>IOS
											16</option>
										<option value="17"
											<%=iosVersion.equals("17") ? "selected" : ""%>>IOS
											17</option>
									</select>
								</div>
								<div class="row mb-3">
									<div class="col-md-4">
										<label class="form-label">From</label>
										<liferay-ui:input-date name="iosStartDate"
											yearValue="<%=iosBlock.get("startYear")%>"
											dayValue="<%=iosBlock.get("startDay")%>"
											monthValue="<%=iosBlock.get("startMonth")%>" />
									</div>
									<div class="col-md-4">
										<label class="form-label">To</label>
										<liferay-ui:input-date name="iosEndDate"
											yearValue="<%=iosBlock.get("endYear")%>"
											dayValue="<%=iosBlock.get("endDay")%>"
											monthValue="<%=iosBlock.get("endMonth")%>" />
									</div>
								</div>
							</div>
							<div class="form-check d-flex align-items-center">
								<input class="form-check-input block-settings-checkbox"
									type="checkbox" id="blockDetailsCheck3"
									name="<portlet:namespace/>webCheck"
									<%=webCheck ? "checked" : ""%>> <label
									class="form-check-label d-flex align-items-center mx-2"
									for="blockDetailsCheck3"> <svg
										xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-laptop" viewBox="0 0 16 16">
								  <path
											d="M13.5 3a.5.5 0 0 1 .5.5V11H2V3.5a.5.5 0 0 1 .5-.5h11zm-11-1A1.5 1.5 0 0 0 1 3.5V12h14V3.5A1.5 1.5 0 0 0 13.5 2h-11zM0 12.5h16a1.5 1.5 0 0 1-1.5 1.5h-13A1.5 1.5 0 0 1 0 12.5z" />
								</svg> Web
								</label>
							</div>
							<div class="m-2 block-settings blockDetailsCheck3"
								style="display: <%=webCheck ? "block" : "none"%>;">
								<div class="mb-3">
									<label class="form-label">Versions</label> <select pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed."
										class="custom-select" id="inputGroupSelect04"
										name="<portlet:namespace/>webVersion">
										<option value="1"
											<%=webVersion.equals("1") ? "selected" : ""%>>One</option>
										<option value="2"
											<%=webVersion.equals("2") ? "selected" : ""%>>Two</option>
										<option value="3"
											<%=webVersion.equals("3") ? "selected" : ""%>>Three</option>
									</select>
								</div>
								<div class="row mb-3">
									<div class="col-md-4">
										<label class="form-label">From</label>
										<liferay-ui:input-date name="webStartDate"
											yearValue="<%=webBlock.get("startYear")%>"
											dayValue="<%=webBlock.get("startDay")%>"
											monthValue="<%=webBlock.get("startMonth")%>" />
									</div>
									<div class="col-md-4">
										<label class="form-label">To</label>
										<liferay-ui:input-date name="webEndDate"
											yearValue="<%=webBlock.get("endYear")%>"
											dayValue="<%=webBlock.get("endDay")%>"
											monthValue="<%=webBlock.get("endMonth")%>" />
									</div>
								</div>
							</div>
						</div>
						<div>
							<h4>For Personas</h4>
							<div class="mb-2">This instance of the content will ONLY be
								available for the following personas</div>
							<%
								if (personas.isEmpty()) {
							%>
							<div class="alert alert-info" role="alert">No personas
								found in current channel</div>
							<%
								}
							%>
							<div class="mb-3">
								<label class="form-label">Select Personas</label> <select
									class="custom-select multi-select" multiple
									id="inputSelectPersonas" required
									name="<portlet:namespace />selectedPersonas">
									<%
										for (Persona persona : personas) {
											boolean found = false;
											for (int i = 0; i < selectedPersonasJSON.length(); i++) {
												long currentElement = selectedPersonasJSON.getLong(i);

												if (currentElement == persona.getPersonaId()) {
													found = true;
													break; // Element found, no need to continue searching
												}
											}
									%>
									<option value="<%=persona.getPersonaId()%>"
										<%=(found) ? "selected" : ""%>><%=persona.getName()%></option>
									<%
										}
									%>
								</select>
							</div>
						</div>
						<div>
							<h4>Date Range</h4>
							<div>Banner will be available on this range only:</div>
							<div class="row mb-3">
								<div class="col-md-4">
									<label class="form-label">From</label>
									<liferay-ui:input-date name="startDateBanner"
										yearValue="<%=startYearBanner%>"
										dayValue="<%=startDayBanner%>"
										monthValue="<%=startMonthBanner%>" />
								</div>
								<div class="col-md-4">
									<label class="form-label">To</label>
									<liferay-ui:input-date name="endDateBanner"
										yearValue="<%=endYearBanner%>" dayValue="<%=endDayBanner%>"
										monthValue="<%=endMonthBanner%>" />
								</div>
							</div>
						</div>
					</div>
				</div>
				<%
					if (bannerId > 0) {
				%>
				<hr />
				<div class="my-3">
					<div class="d-flex justify-content-between mb-3">
						<h3>Content</h3>
						<% if (hasPendingVersion) { %>
							<span style="color: #856404; font-style: italic;">Cannot add content while pending approval</span>
						<% } else if (!isOther) { %>
							<a href="<%=newContent%>">Add New Content</a>
						<% } %>
					</div>
					<div class="table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th scope="col"></th>
									<th scope="col">Banner Order</th>
									<th scope="col">Banner Name</th>
									<th scope="col">Banner Status</th>
									<th scope="col"></th>
								</tr>
							</thead>
							<tbody>
								<%
									if (!bannerContents.isEmpty()) {
											for (BannerContent bannerContent : bannerContents) {
								%>
								<tr order="<%=bannerContent.getContentOrder()%>">
									<td>
										<% if (!hasPendingVersion) { %>
											<a class="up">&#x2191;</a> <a class="down">&#x2193;</a>
										<% } %>
									</td>
									<td><input id="" type="hidden" value=""
										name="<portlet:namespace /><%=bannerContent.getContentName()%>TargetOrder">
										<span><%=bannerContent.getContentOrder()%></span></td>
									<td><%=bannerContent.getContentName()%></td>
									<td><%=bannerContent.getContentStatus() != null
								? bannerContent.getContentStatus().equals("0") ? "Publish" : "Draft"
								: ""%></td>
									<td><div class="mt-auto">
											<% if (hasPendingVersion) { %>
											<div class="dropdown d-flex justify-content-end dropright">
												<button class="btn text-white dropdown-toggle p-0"
													type="button"
													id="dropdownMenuButton<%=bannerContent.getContentId()%>"
													data-toggle="dropdown" aria-haspopup="true"
													aria-expanded="false">
													<svg xmlns="http://www.w3.org/2000/svg" width="16"
														height="16" fill="dark" class="bi bi-three-dots-vertical"
														viewBox="0 0 16 16">
							  <path
															d="M9.5 13a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z" />
							</svg>
												</button>
												<div class="dropdown-menu"
													aria-labelledby="dropdownMenuButton<%=bannerContent.getContentId()%>">
													<a class="dropdown-item"
														href="<portlet:actionURL name="getBannerContentIdForView">
															<portlet:param name="selectedBannerContentId" value="<%=String.valueOf(bannerContent.getContentId())%>" />
															<portlet:param name="bannerId" value="<%=String.valueOf(bannerId)%>" />
														</portlet:actionURL>">View</a>
												</div>
											</div>
											<% } else { %>
											<div class="dropdown d-flex justify-content-end dropright">
												<button class="btn text-white dropdown-toggle p-0"
													type="button"
													id="dropdownMenuButton<%=bannerContent.getContentId()%>"
													data-toggle="dropdown" aria-haspopup="true"
													aria-expanded="false">
													<svg xmlns="http://www.w3.org/2000/svg" width="16"
														height="16" fill="dark" class="bi bi-three-dots-vertical"
														viewBox="0 0 16 16">
							  <path
															d="M9.5 13a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z" />
							</svg>
												</button>
												<div class="dropdown-menu"
													aria-labelledby="dropdownMenuButton<%=bannerContent.getContentId()%>">

														<a class="dropdown-item"
															href="<portlet:actionURL  name="getBannerContentIdForView" >
											<portlet:param name="selectedBannerContentId" value="<%=String.valueOf(bannerContent.getContentId())%>" />	<portlet:param name="bannerId" value="<%=String.valueOf(bannerId)%>" />
											
											</portlet:actionURL>">Edit</a>


														<button type="button" class="dropdown-item"
															onclick="openModal('<%=bannerContent.getContentId()%>')">Delete</button>

												</div>
											</div>
											<% } %>
										</div></td>
								</tr>
								<%
											}
										} else {
								%><tr>
									<td colspan="4"
										class="h3 p-4 mb-4 text-secondary text-dark text-center">No
										Contents found in current Banner</td>
								</tr>
								<%
									}
								%>
							</tbody>
						</table>
					</div>
				</div>
				<%
					}
				%>
				</fieldset>
				<div class="d-flex justify-content-end">
					<button type="button" onclick="window.location.href='<%=back%>'"
						class="btn btn-secondary px-5 mr-3">BACK</button>
					<% if (hasPendingVersion) { %>
						<button type="button" class="btn btn-primary px-5" disabled title="This banner has pending changes awaiting approval">
							SAVE (Pending Approval)
						</button>
					<% } else if (!isOther) { %>
						<button type="button" class="btn btn-primary px-5" onclick="openSaveModal()">SAVE</button>
					<% } %>
				</div>
			</form>
		</div>
	</div>
</div>
<!-- Save Confirmation Modal -->
<div class="modal hide fade" id="telemoneySaveModal" tabindex="-1"
	role="dialog" aria-labelledby="telemoneySaveModalTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-100" role="document">
		<div class="modal-content w-auto m-auto">
			<div class="modal-header">
				<h5 class="modal-title" id="telemoneySaveModalTitle">Confirm Save</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body text-5 text-center">Are you sure you want to save this Banner?</div>
			<div class="modal-footer justify-content-end">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
				<button type="button" class="btn btn-primary" onclick="confirmSave()">Save</button>
			</div>
		</div>
	</div>
</div>

<div class="modal hide fade" id="telemoneyDeleteModal" tabindex="-1"
	role="dialog" aria-labelledby="telemoneyDeleteModalCenteredTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-100" role="document">
		<div class="modal-content w-auto m-auto">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">Delete
					Content</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body text-5 text-center">Are you sure you
				want to delete this content?</div>
			<div class="modal-footer justify-content-end">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary"
					onclick="submitDeleteForm()">Confirm</button>
			</div>
		</div>
	</div>
</div>
<!-- Hidden form for delete content action -->
<portlet:actionURL name="deleteContent" var="deleteContentAction" />
<form id="deleteContentForm" method="post" action="<%=deleteContentAction%>" style="display:none;">
	<input type="hidden" name="<portlet:namespace/>selectedBannerContentId" id="deleteContentId" value="" />
	<input type="hidden" name="<portlet:namespace/>selectedBannerId" value="<%=bannerId%>" />
</form>

<style>
	#inputSelectPersonas + .multiselect-dropdown .multiselect-dropdown-list {
		max-height: 150px;
		overflow-y: scroll;
	}
</style>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/multiselect-dropdown.js"></script>
<script>
	var deleteContentId = "";

	function openSaveModal() {
		if (!validateAllDates()) {
			return;
		}
		var form = document.getElementById('bannerAddForm');
		if (!form.checkValidity()) {
			form.reportValidity();
			return;
		}
		$("#telemoneySaveModal").modal("show");
		$("#telemoneySaveModal").removeClass("hide");
	}

	function closeSaveModal() {
		$("#telemoneySaveModal").modal("hide");
		$("#telemoneySaveModal").addClass("hide");
	}

	function confirmSave() {
		document.getElementById('bannerAddForm').submit();
		closeSaveModal();
	}

//	$(".block-settings").hide();
	$(".block-settings-checkbox").click(function() {
		var toggledItem = $(this).attr('id');
		if ($(this).is(":checked")) {
			$("." + toggledItem).show();
		} else {
			$("." + toggledItem).hide();
		}
	});
	$('.custom-file-input').on('change', function(e) {
		var fileName = 'Choose file';
		var imageElement = e.target.parentElement.nextElementSibling;
		if (e.target.files[0]) {
			fileName = e.target.files[0].name;
			var imgFile = e.target.files[0];
			imageElement.src = URL.createObjectURL(imgFile);
			$(this).next('.custom-file-label').html(fileName);
		} else {
			$(this).next('.custom-file-label').html(fileName);
		}
	})
	function openModal(contentId) {
		$("#telemoneyDeleteModal").modal("show");
		$("#telemoneyDeleteModal").removeClass("hide");
		deleteContentId = contentId;
	}

	function closeModal() {
		$("#telemoneyDeleteModal").modal("hide");
		$("#telemoneyDeleteModal").addClass("hide");
	}

	function submitDeleteForm() {
		document.getElementById("deleteContentId").value = deleteContentId;
		document.getElementById("deleteContentForm").submit();
	}

	$(document).ready(function() {
		function orderBannerTable() {
			$("tbody tr").each(function(index) {
				$(this).find('td input').first().val(index + 1);
				$(this).find('td span').first().text(index + 1);
			});
		}
		$(".up,.down").click(function() {
			var row = $(this).parents("tr:first");
			if ($(this).is(".up")) {
				row.insertBefore(row.prev());
			} else {
				row.insertAfter(row.next());
			}
			orderBannerTable();
		});
	});
	
	
	var containerSelect = document.getElementById("inputGroupSelect05");
	var bannerTypeSelect = document.getElementById("inputGroupSelect06");
	var bannerContainerOptions = {
			dashboard:["0","1"],
			transfer:["0"]
	}

	function loadBannerOptions(containerValue){
			if(containerValue === "0"){
				bannerTypeSelect.innerHTML="";
				bannerTypeSelect.disabled=false;
				bannerContainerOptions.dashboard.forEach(option=>{
					var dashboardOption = document.createElement("option");
					dashboardOption.value = option;
					dashboardOption.selected = '<%=bannerType%>' === option ? true : false;
					dashboardOption.textContent = option === "1" ? "Vertical" : "Full Width";
	                bannerTypeSelect.appendChild(dashboardOption);
				});
			}
			else if(containerValue === "1"){
				bannerTypeSelect.innerHTML="";
				bannerTypeSelect.disabled=false;
				bannerContainerOptions.transfer.map(option=>{
					var transferOption = document.createElement("option");
					transferOption.value = option;
					transferOption.textContent ="Half Width";
	            	bannerTypeSelect.appendChild(transferOption);
			});
		}
	}
	
	containerSelect.onchange = (e)=>{
		var containerValue = e.target.value;
		loadBannerOptions(containerValue);
	}
	
	
	if(containerSelect.value === "0" || containerSelect.value === "1"){
		loadBannerOptions(containerSelect.value);
	}
	
	function validateAllDates() {
	    return validateDates() && validateAndroidDates() && validateIOSDates() && validateWebDates();
	}

	function validateDates() {
	    var startDate = new Date(document.getElementById('<portlet:namespace/>startDateBanner').value);
	    var endDate = new Date(document.getElementById('<portlet:namespace/>endDateBanner').value);

	    if (startDate > endDate) {
	        alert('End date must be later than start date.');
	        return false; // Prevent form submission
	    }

	    return true; // Allow form submission
	}

	function validateAndroidDates() {
	    var androidStartDate = new Date(document.getElementById('<portlet:namespace/>androidStartDate').value);
	    var androidEndDate = new Date(document.getElementById('<portlet:namespace/>androidEndDate').value);

	    if (androidStartDate > androidEndDate) {
	        alert('Android end date must be later than Android start date.');
	        return false; // Prevent form submission
	        console.log("hhhhhhhhhhhhhhhhh");
	    }

	    return true; // Allow form submission
	}

	function validateIOSDates() {
	    var iosStartDate = new Date(document.getElementById('<portlet:namespace/>iosStartDate').value);
	    var iosEndDate = new Date(document.getElementById('<portlet:namespace/>iosEndDate').value);

	    if (iosStartDate > iosEndDate) {
	        alert('iOS end date must be later than iOS start date.');
	        return false; // Prevent form submission
	    }

	    return true; // Allow form submission
	}

	function validateWebDates() {
	    var webStartDate = new Date(document.getElementById('<portlet:namespace/>webStartDate').value);
	    var webEndDate = new Date(document.getElementById('<portlet:namespace/>webEndDate').value);

	    if (webStartDate > webEndDate) {
	        alert('Web end date must be later than Web start date.');
	        return false; // Prevent form submission
	    }

	    return true; // Allow form submission
	}



</script>