<%@page import="com.ejada.telemoney.otp.events.DTO.OtpEventDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@ include file="/init.jsp"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>


<%
	List<OtpEventDTO> otpEvents = request.getAttribute("otpEvents") != null
			? (List<OtpEventDTO>) request.getAttribute("otpEvents")
			: new ArrayList<>();

	Set<String> pendingOtpEventIds = (Set<String>) request.getAttribute("pendingOtpEventIds");
	if (pendingOtpEventIds == null) {
		pendingOtpEventIds = new HashSet<>();
	}
%>

<portlet:actionURL var="updatedOtpEvent" name="getOtpEventInfoForUpdate">
</portlet:actionURL>

<div>
	<h3 class="pb-4">OTP Events</h3>
	<liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />	
	<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
	<liferay-ui:error key="hasPendingVersion" message="This OTP event has a pending version and cannot be modified." />

	<div class="card">
		<div class="card-body">
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
							<th scope="col">Event Description <span
								style="cursor: pointer;"> <svg
										xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">Event Reason (en) <span
								style="cursor: pointer;"> <svg
										xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">Event Reason (ar) <span
								style="cursor: pointer;"> <svg
										xmlns="http://www.w3.org/2000/svg" width="16" height="16"
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
						<tr>
							<%
								if (!otpEvents.isEmpty()) {
									for (OtpEventDTO event : otpEvents) {
										boolean isPending = pendingOtpEventIds.contains(event.getEventCode());
							%>
							<td><%=event.getEventCode()%>
								<% if (isPending) { %>
									<span class="badge badge-warning" style="font-size: 0.7rem; vertical-align: middle; background-color: #f0ad4e; margin-left: 8px;">
										Pending Approval
									</span>
								<% } %>
							</td>
							<td><%=event.getEventDescription()%></td>
							<td><%=event.getEventReasonEn()%></td>
							<td><%=event.getEventReasonAr()%></td>
							<td>
									<div class="dropdown">
										<button class="btn btn-secondary dropdown-toggle"
											type="button" id="dropdownMenuButton" data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="false">
											<svg xmlns="http://www.w3.org/2000/svg" width="16"
												height="16" fill="currentColor"
												class="bi bi-three-dots-vertical" viewBox="0 0 16 16">
               								 <path
													d="M9.5 13a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z" />
           									 </svg>
										</button>
										<div class="dropdown-menu"
											aria-labelledby="dropdownMenuButton">
											<form action="<%=updatedOtpEvent%>" method="post"
												name="<portlet:namespace/>eventUpdateForm"
												id="<portlet:namespace/>eventUpdateForm">
												<a
													onclick="updateEvent(
							                        '<%=event.getEventCode()%>',
							                        '<%=event.getEventDescription()%>',
							                        '<%=event.getEventReasonEn()%>',
							                        '<%=event.getEventReasonAr()%>',
							                        '<%=isPending%>'
							                    )"
													class="dropdown-item"><%= isOther ? "View" : "Edit" %></a> <input type="text"
													class="d-none" name="<portlet:namespace/>eventCode"
													id="<portlet:namespace/>eventCode" /> <input type="text"
													class="d-none" name="<portlet:namespace/>eventDescription"
													id="<portlet:namespace/>eventDescription" /> <input
													type="text" class="d-none"
													name="<portlet:namespace/>eventReasonEn"
													id="<portlet:namespace/>eventReasonEn" /> <input
													type="text" class="d-none"
													name="<portlet:namespace/>eventReasonAr"
													id="<portlet:namespace/>eventReasonAr" />
												<input type="hidden"
													name="<portlet:namespace/>hasPendingVersion"
													id="<portlet:namespace/>hasPendingVersion" />
											</form>
										</div>
									</div>

							</td>
						</tr>
						<%
							}
							} else {
						%>
						<div class="my-2">
							<div
								class="d-flex justify-content-between align-items-center py-3 border-bottom">
								<div>
									<h5>No OTP events found.</h5>
								</div>
							</div>
						</div>
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

	function updateEvent(eventCode, eventDescription, eventReasonAr,
			eventReasonEn, hasPendingVersion) {
		var eventCodeField = document
				.getElementById('<portlet:namespace/>eventCode');
		var eventDescriptionField = document
				.getElementById('<portlet:namespace/>eventDescription');
		var eventReasonArField = document
				.getElementById('<portlet:namespace/>eventReasonAr');
		var eventReasonEnField = document
				.getElementById('<portlet:namespace/>eventReasonEn');
		var hasPendingField = document
				.getElementById('<portlet:namespace/>hasPendingVersion');

		eventCodeField.value = eventCode;
		eventDescriptionField.value = eventDescription;
		eventReasonArField.value = eventReasonAr;
		eventReasonEnField.value = eventReasonEn;
		hasPendingField.value = hasPendingVersion;

		document.getElementById('<portlet:namespace/>eventUpdateForm').submit();
	}
</script>