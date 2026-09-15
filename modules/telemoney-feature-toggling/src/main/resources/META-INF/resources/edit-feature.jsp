<%@ include file="/init.jsp"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ejada.telemony.db.service.BlocksLocalServiceUtil"%>
<%@page import="com.ejada.telemony.db.model.Blocks"%>
<%@page import="java.util.List"%>
<%@page import="com.ejada.telemony.db.service.SegmentLocalServiceUtil"%>
<%@page import="com.ejada.telemony.db.model.Segment"%>
<%@page import="com.ejada.telemony.db.model.Feature"%>
<%@page import="com.ejada.telemony.db.service.FeatureLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>


<portlet:actionURL name="editFeature" var="editFeature">
</portlet:actionURL>
<portlet:renderURL var="backToview">
	<portlet:param name="action" value="view" />
</portlet:renderURL>

<%
	List<Feature> parentFeatures = request.getAttribute("parentFeatures") != null
			? (List<Feature>) request.getAttribute("parentFeatures")
			: new ArrayList();

	List<Segment> segments = (List<Segment>) request.getAttribute("segments") != null
			? (List<Segment>) request.getAttribute("segments")
			: new ArrayList();

	long featureId = (Long) request.getAttribute("featureId") != null
			? (Long) request.getAttribute("featureId")
			: 0L;

	String featureName = (String) request.getAttribute("featureName") != null
			? (String) request.getAttribute("featureName")
			: "";
	String pageType = (String) request.getAttribute("pageType") != null
			? (String) request.getAttribute("pageType")
			: "";
	long parentPage = (Long) request.getAttribute("parentPage") != null
			? (Long) request.getAttribute("parentPage")
			: 0L;

	long parentEntityResourceId = request.getAttribute("parentEntityResourceId") != null
			? (Long) request.getAttribute("parentEntityResourceId")
			: 0L;

	// status is a Boolean (feature on/off status)
	Boolean featureStatus = request.getAttribute("status") != null
			? (Boolean) request.getAttribute("status")
			: false;

	String routeId = (String) request.getAttribute("routeId") != null
			? (String) request.getAttribute("routeId")
			: "";
	String blockType = (String) request.getAttribute("blockType") != null
			? (String) request.getAttribute("blockType")
			: "";
	long blockId = (Long) request.getAttribute("blockId") != null ? (Long) request.getAttribute("blockId") : 0L;

	Date dateFrom = (Date) request.getAttribute("dateFrom") != null
			? (Date) request.getAttribute("dateFrom")
			: new Date();
	Calendar startCalendar = Calendar.getInstance();
	startCalendar.setTime(dateFrom);
	int startYear = startCalendar.get(Calendar.YEAR);
	int startMonth = startCalendar.get(Calendar.MONTH);
	int startDay = startCalendar.get(Calendar.DAY_OF_MONTH);

	Date dateTo = (Date) request.getAttribute("dateTo") != null
			? (Date) request.getAttribute("dateTo")
			: new Date();
	Calendar endCalendar = Calendar.getInstance();
	endCalendar.setTime(dateTo);
	int endYear = endCalendar.get(Calendar.YEAR);
	int endMonth = endCalendar.get(Calendar.MONTH);
	int endDay = endCalendar.get(Calendar.DAY_OF_MONTH);

	//get the data from the map for the title and description, 
	String androidVersion = (String) request.getAttribute("androidVersion") != null
			? (String) request.getAttribute("androidVersion")
			: "";

	String iosVersion = (String) request.getAttribute("iosVersion") != null
			? (String) request.getAttribute("iosVersion")
			: "";

	String webVersion = (String) request.getAttribute("webVersion") != null
			? (String) request.getAttribute("webVersion")
			: "";

	// Handle boolean values that could come as Boolean objects or primitives
	boolean androidCheck = false;
	if (request.getAttribute("androidCheck") != null) {
		Object androidCheckObj = request.getAttribute("androidCheck");
		if (androidCheckObj instanceof Boolean) {
			androidCheck = (Boolean) androidCheckObj;
		} else if (androidCheckObj instanceof Number) {
			androidCheck = ((Number) androidCheckObj).intValue() != 0;
		}
	}

	boolean iosCheck = false;
	if (request.getAttribute("iosCheck") != null) {
		Object iosCheckObj = request.getAttribute("iosCheck");
		if (iosCheckObj instanceof Boolean) {
			iosCheck = (Boolean) iosCheckObj;
		} else if (iosCheckObj instanceof Number) {
			iosCheck = ((Number) iosCheckObj).intValue() != 0;
		}
	}

	boolean webCheck = false;
	if (request.getAttribute("webCheck") != null) {
		Object webCheckObj = request.getAttribute("webCheck");
		if (webCheckObj instanceof Boolean) {
			webCheck = (Boolean) webCheckObj;
		} else if (webCheckObj instanceof Number) {
			webCheck = ((Number) webCheckObj).intValue() != 0;
		}
	}

	Map<String, Integer> androidBlock = (Map<String, Integer>) request.getAttribute("androidBlock") != null
			? (Map<String, Integer>) request.getAttribute("androidBlock")
			: new HashMap<String, Integer>() {
				{
					put("startYear", startYear);
					put("startMonth", startMonth);
					put("startDay", startDay);
					put("endYear", endYear);
					put("endMonth", endMonth);
					put("endDay", endDay);
				}
			};

	Map<String, Integer> iosBlock = (Map<String, Integer>) request.getAttribute("iosBlock") != null
			? (Map<String, Integer>) request.getAttribute("iosBlock")
			: new HashMap<String, Integer>() {
				{
					put("startYear", startYear);
					put("startMonth", startMonth);
					put("startDay", startDay);
					put("endYear", endYear);
					put("endMonth", endMonth);
					put("endDay", endDay);
				}
			};
	Map<String, Integer> webBlock = (Map<String, Integer>) request.getAttribute("webBlock") != null
			? (Map<String, Integer>) request.getAttribute("webBlock")
			: new HashMap<String, Integer>() {
				{
					put("startYear", startYear);
					put("startMonth", startMonth);
					put("startDay", startDay);
					put("endYear", endYear);
					put("endMonth", endMonth);
					put("endDay", endDay);
				}
			};

	boolean hasPendingVersion = request.getAttribute("hasPendingVersion") != null
			? (Boolean) request.getAttribute("hasPendingVersion")
			: false;
	boolean isDisabled = isOther || hasPendingVersion;
%>

<div>
	<h3 class="pb-4">Edit Feature</h3>
	<% if (hasPendingVersion) { %>
	<div class="alert alert-warning" role="alert">
		<strong>Pending Approval:</strong> This feature has a pending change awaiting approval. Editing is disabled until the change is approved or rejected.
	</div>
	<% } %>
	<liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />
	<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
	<liferay-ui:error key="hasPendingVersion" message="This feature has a pending version awaiting approval and cannot be modified." />
	<div class="card">
		<div class="card-body">
			<div class="row">
				<div class="col-md-12">
					<form method="post" action="<%=editFeature%>" id="featureEditForm">
						<fieldset <%= isDisabled ? "disabled" : "" %>>
						<div class="mb-3">
							<input type="hidden" name="<portlet:namespace/>featureId"
								value="<%=featureId%>">
							<input type="hidden" name="<portlet:namespace/>hasPendingVersion" value="<%=hasPendingVersion%>">
						</div>
						<div class="mb-3">
							<label class="form-label">Name</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text"
								class="form-control" id="featureName"
								name="<portlet:namespace/>featureName" value='<%=featureName%>'
								required>
						</div>
						<div class="mb-3">
							<label class="form-label">Type</label> <select pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed."
								class="custom-select" id="pageType"
								name="<portlet:namespace/>pageType">
								<%
									if (pageType.contains("0")) {
								%>
								<option value=<%=pageType%> selected>parent</option>
								<option value="1">child</option>
								<%
									} else {
								%>
								<option value=<%=pageType%> selected>child</option>
								<option value="0">parent</option>
								<%
									}
								%>
							</select>
						</div>
						<div class="mb-3" id="parentPageParent">
							<label class="form-label">Parent Page</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text"
								class="form-control" id="parentPageParent"
								name="<portlet:namespace/>parentPage"
								value='Already a parent page' disabled>
						</div>
						<div class="mb-3" id="parentPageChild">
							<label class="form-label">Parent Page</label> <select pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed."
								class="custom-select" name="<portlet:namespace/>parentPage">
								<%
									if (parentFeatures.isEmpty()) {
								%>
								<option selected>There are no parent features in this
									channel...</option>
								<%
									} else if (parentFeatures.size() == 1 && parentFeatures.get(0).getFeatureId() == featureId) {
								%>
								<option selected>There are no parent features in this
									channel...</option>
								<%
									} else {
										for (Feature f : parentFeatures) {
											if (f.getFeatureId() == featureId) {
												continue;
											} else if (f.getEntityResourceId() == parentEntityResourceId && pageType.contains("1")) {
								%>
								<option selected value='<%=f.getFeatureId()%>'><%=f.getFeatureName()%></option>
								<%
									continue;
											} else {
								%>
								<option value="<%=f.getFeatureId()%>"><%=f.getFeatureName()%></option>
								<%
									}
										}
									}
								%>

							</select>
						</div>
						<div class="mb-3">
							<label class="form-label">Route ID</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text"
								class="form-control" id="routeId"
								name="<portlet:namespace/>routeId" value='<%=routeId%>' required>
						</div>
						<div class="mb-3">
							<label class="form-label">Status</label> <select pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed."
								class="custom-select" id="status"
								name="<portlet:namespace/>featureStatus">
								<option value="true" <%=featureStatus ? "selected" : ""%>>ON</option>
								<option value="false" <%=!featureStatus ? "selected" : ""%>>OFF</option>
							</select>
						</div>

						<div class="mb-3">
							<h4>Block Details</h4>
							<div>this instance will be blocked on the following:</div>
							<div class="form-check d-flex align-items-center">
								<input name="<portlet:namespace/>androidCheck"
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
										<%-- <% if(foundBlock != null && !foundBlock.getAndroidBlockVersion().isEmpty()){ %>
								    		<option value="">None</option>
									    	<option selected><%=foundBlock.getAndroidBlockVersion()%></option>
									    <% }else{%>
									    	<option value="" selected>None</option>
									    <% }%> --%>

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
									<label class="form-label">Versions</label> <select pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed."
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
								<div class="mb-3" style="display: none">
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
						<div class="mb-3">
							<label class="form-label">Disabeling Type</label> <select
								class="custom-select" id="method"
								name="<portlet:namespace/>blockType">
								<option value="0" <%=blockType.equals("0") ? "selected" : ""%>>Hide</option>
								<option value="1" <%=blockType.equals("1") ? "selected" : ""%>>Disable</option>
								<option value="2" <%=blockType.equals("2") ? "selected" : ""%>>Pop
									up</option>
							</select>
						</div>

						<h4 class="pb-4">Customer Program</h4>
						<div>
							<table class="table">
								<thead>
									<tr>
										<th scope="col">Segment Name</th>
										<th scope="col">Status</th>
										<th scope="col">Method</th>
										<th scope="col"></th>
									</tr>
								</thead>
								<tbody>
									<%
										for (Segment segment : segments) {
									%>
									<tr>
										<td><%=segment.getName()%></td>
										<%
											if (segment.getSegmentStatus() != null && segment.getSegmentStatus() == true) {
										%>
										<td>ON</td>
										<td>Show</td>
										<%
											} else {
										%>
										<td>OFF</td>
										<%
											if (segment.getMethod().contains("0")) {
										%>
										<td>Hide</td>
										<%
											} else if (segment.getMethod().contains("1")) {
										%>
										<td>Disabled</td>
										<%
											} else if (segment.getMethod().contains("2")) {
										%>
										<td>Pop Up</td>
										<%
											}
										%>
										<%
											}
										%>


										<td>
										<a class=""
											href="
									    <portlet:actionURL  name="getSegmentDataForView" >
									    	<portlet:param name="selectedSegmentId" value="<%=String.valueOf(segment.getSegmentId())%>"/>
											<portlet:param name="featureId" value="<%=String.valueOf(featureId)%>"/>
											<portlet:param name="hasPendingVersion" value="<%=String.valueOf(hasPendingVersion)%>"/>
										</portlet:actionURL>">
												<%= isDisabled ? "View" : "Edit" %> </a>
										</td>
									</tr>
									<%
										}
									%>
								</tbody>
							</table>
						</div>
						</fieldset>
						<div class="d-flex justify-content-end mt-3">
							<button type="button" class="btn btn-secondary px-5 mr-3"
								onclick="window.location.href='<%=backToview%>'"><%= isDisabled ? "BACK" : "CANCEL" %></button>
							<% if (!isDisabled) { %>
							<button type="button" class="btn btn-primary px-5" onclick="openSaveModal()">SAVE</button>
							<% } %>
						</div>
					</form>
				</div>
			</div>

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
			<div class="modal-body text-5 text-center">Are you sure you want to save this Feature?</div>
			<div class="modal-footer justify-content-end">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
				<button type="button" class="btn btn-primary" onclick="confirmSave()">Save</button>
			</div>
		</div>
	</div>
</div>

<script>
	function openSaveModal() {
		$("#telemoneySaveModal").modal("show");
		$("#telemoneySaveModal").removeClass("hide");
	}

	function closeSaveModal() {
		$("#telemoneySaveModal").modal("hide");
		$("#telemoneySaveModal").addClass("hide");
	}

	function confirmSave() {
		document.getElementById('featureEditForm').submit();
		closeSaveModal();
	}
</script>

<script>
	$(document).ready(function() {
		if ($('#device').val() === 'iOS') {
			$('#iosDeviceVersion').show();
			$('#androidDeviceVersion').hide();
		} else {
			$('#androidDeviceVersion').show();
			$('#iosDeviceVersion').hide();
		}
	});

	$('#device').on('change', function() {

		if ($(this).val() === 'iOS') {
			$('#androidDeviceVersion').hide();
			$('#iosDeviceVersion').show();
		} else {
			$('#androidDeviceVersion').show();
			$('#iosDeviceVersion').hide();
		}
	});
	$(document).ready(function() {
		if ($('#pageType').val() === '0') {
			$('#parentPageParent').show();
			$('#parentPageChild').hide();
		} else {
			$('#parentPageParent').hide();
			$('#parentPageChild').show();
		}
	});
	$('#pageType').on('change', function() {

		if ($(this).val() === '0') {
			$('#parentPageParent').show();
			$('#parentPageChild').hide();
		} else {
			$('#parentPageParent').hide();
			$('#parentPageChild').show();
		}
	});

	$(".block-settings-checkbox").click(function() {
		var toggledItem = $(this).attr('id');
		if ($(this).is(":checked")) {
			$("." + toggledItem).show();
		} else {
			$("." + toggledItem).hide();
		}
	});

	var statusSelect = document.getElementById('status');
	var methodSelect = document.getElementById('method');

	statusSelect.addEventListener('change', function() {
		if (statusSelect.value === 'true') {
			methodSelect.disabled = true;
		} else {
			methodSelect.disabled = false;
		}
	});

	if (statusSelect.value === 'true') {
		methodSelect.disabled = true;
	}
</script>
