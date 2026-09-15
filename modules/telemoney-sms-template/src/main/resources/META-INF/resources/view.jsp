<%@page import="java.util.List"%>
<%@page import="com.ejada.telemoney.sms.template.portlet.SMSDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ include file="/init.jsp"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>


<%
	List<SMSDTO> items = (List<SMSDTO>) request.getAttribute("records") != null
			? (List<SMSDTO>) request.getAttribute("records")
			: new ArrayList();

	Set<String> pendingSmsIds = (Set<String>) request.getAttribute("pendingSmsIds");
	if (pendingSmsIds == null) {
		pendingSmsIds = new HashSet<>();
	}
%>
<div>
	<h3 class="pb-4">SMS templates</h3>
	<liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />	
	<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
	<liferay-ui:error key="hasPendingVersion" message="This SMS template has a pending version awaiting approval and cannot be modified." />

	<div class="card">
		<div class="card-body">
			<liferay-ui:error key="error"
				message="Error In SMS Update. Please Choose a Valid Service Id" />
			<div class="row">
				<div class="col-md-6">
					<div class="d-flex align-items-end mb-3">
						<div>
							<label class="form-label">Search</label> <input type="text"
								class="form-control" id="">
						</div>
						<div class="d-flex">
							<button type="submit" class="btn btn-primary px-5 ml-3">Search</button>
							<button type="submit" class="btn btn-link px-5 ml-3">Clear</button>
						</div>
					</div>
				</div>
			</div>
			<div>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Event Code <span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">Event description <span
								style="cursor: pointer;"> <svg
										xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">Service ID <span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<%
							for (SMSDTO item : items) {
								boolean hasPendingVersion = pendingSmsIds.contains(item.getEventCode());
								boolean isLocked = hasPendingVersion; // No category pending for SMS templates
						%>
						<tr>
							<td><%=item.getEventCode()%></td>
							<td>
								<%=item.getEventDescription()%>
								<% if (hasPendingVersion) { %>
								<span class="badge badge-warning" style="font-size: 0.7rem; vertical-align: middle; background-color: #f0ad4e; margin-left: 8px;">
									Pending Approval
								</span>
								<% } %>
							</td>
							<td><%=item.getServiceId()%></td>
							<td>
								<div class="dropdown">
									<button class="btn btn-secondary dropdown-toggle" type="button"
										id="dropdownMenuButton" data-toggle="dropdown"
										aria-haspopup="true" aria-expanded="false">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
											fill="currentColor" class="bi bi-three-dots-vertical"
											viewBox="0 0 16 16">
								  <path
												d="M9.5 13a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z" />
								</svg>
									</button>
									<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
										<% if (isLocked) { %>
											<!-- Only View option when SMS template is pending -->
											<a
												href=<portlet:actionURL name="getSMSviewId" >
														<portlet:param name="eventCode" value="<%=item.getEventCode()%>" />
														<portlet:param name="eventDescription" value="<%=item.getEventDescription()%>" />
														<portlet:param name="serviceId" value="<%=item.getServiceId()%>" />
														<portlet:param name="hasPendingVersion" value="true" />
													</portlet:actionURL>
												class="dropdown-item">View</a>
										<% } else { %>
											<!-- Full options when not pending -->
											<a
												href=<portlet:actionURL name="getSMSviewId" >
														<portlet:param name="eventCode" value="<%=item.getEventCode()%>" />
														<portlet:param name="eventDescription" value="<%=item.getEventDescription()%>" />
														<portlet:param name="serviceId" value="<%=item.getServiceId()%>" />
														<portlet:param name="hasPendingVersion" value="false" />
													</portlet:actionURL>
												class="dropdown-item"> <%= isOther ? "View" : "Edit" %> </a>
										<% } %>
									</div>
								</div>
							</td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<script>
	$('th').click(
			function() {
				var table = $(this).parents('table').eq(0)
				var rows = table.find('tr:gt(0)').toArray().sort(
						comparer($(this).index()))
				this.asc = !this.asc
				if (!this.asc) {
					rows = rows.reverse()
				}
				for (var i = 0; i < rows.length; i++) {
					table.append(rows[i])
				}
			})
	function comparer(index) {
		return function(a, b) {
			var valA = getCellValue(a, index), valB = getCellValue(b, index)
			return $.isNumeric(valA) && $.isNumeric(valB) ? valA - valB : valA
					.toString().localeCompare(valB)
		}
	}
	function getCellValue(row, index) {
		return $(row).children('td').eq(index).text()
	}
</script>
