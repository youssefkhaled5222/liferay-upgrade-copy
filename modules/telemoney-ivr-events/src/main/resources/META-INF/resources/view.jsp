<%@page import="java.util.ArrayList"%>
<%@page import="com.ejada.telemoney.ivr.events.dto.IvrEventObject"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@ include file="/init.jsp"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>


<%
	List<IvrEventObject> ivrEvents = request.getAttribute("ivrEvents") != null
			? (List<IvrEventObject>) request.getAttribute("ivrEvents")
			: new ArrayList<>();

	Set<String> pendingIvrEventIds = (Set<String>) request.getAttribute("pendingIvrEventIds");
	if (pendingIvrEventIds == null) {
		pendingIvrEventIds = new HashSet<>();
	}

	System.out.println(ivrEvents);
%>

<portlet:actionURL var="getIvrEventInfoForUpdate"
	name="getIvrEventInfoForUpdate">
</portlet:actionURL>

<div>
	<h3 class="pb-4">IVR Events</h3>
		    <liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />	
	<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
	<liferay-ui:error key="hasPendingVersion" message="This IVR event has a pending version and cannot be modified." />

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
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Status Code <span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">Event name <span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">Event class <span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">Event sub class <span
								style="cursor: pointer;"> <svg
										xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">Event version <span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">Event type <span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">Event source <span style="cursor: pointer;">
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
							if (!ivrEvents.isEmpty()) {
								for (IvrEventObject event : ivrEvents) {
									boolean isPending = pendingIvrEventIds.contains(event.getEventCode());
						%>
						<td><%=event.getEventCode()%>
							<% if (isPending) { %>
								<span class="badge badge-warning" style="font-size: 0.7rem; vertical-align: middle; background-color: #f0ad4e; margin-left: 8px;">
									Pending Approval
								</span>
							<% } %>
						</td>
						<td><%=event.getEventName()%></td>
						<td><%=event.getEventClass()%></td>
						<td><%=event.getEventSubClass()%></td>
						<td><%=event.getEventVersion()%></td>
						<td><%=event.getEventType()%></td>
						<td><%=event.getEventSource()%></td>
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
										<form action="<%=getIvrEventInfoForUpdate%>" method="post"
											name="<portlet:namespace/>eventUpdateForm"
											id="<portlet:namespace/>eventUpdateForm">
											<a
												onclick="updateEvent(
						                        '<%=event.getEventCode()%>',
						                        '<%=event.getEventName()%>',
						                        '<%=event.getEventClass()%>',
						                        '<%=event.getEventSubClass()%>',
						                        '<%=event.getEventVersion()%>',
						                        '<%=event.getEventType()%>',
						                        '<%=event.getEventSource()%>',
						                        '<%=isPending%>'
						                    )"
												class="dropdown-item"><%= isOther ? "View" : "Edit" %></a> <input type="text"
												class="d-none" name="<portlet:namespace/>eventCode"
												id="<portlet:namespace/>eventCode" /> <input type="text"
												class="d-none" name="<portlet:namespace/>eventName"
												id="<portlet:namespace/>eventName" /> <input type="text"
												class="d-none" name="<portlet:namespace/>eventClass"
												id="<portlet:namespace/>eventClass" /> <input type="text"
												class="d-none" name="<portlet:namespace/>eventSubClass"
												id="<portlet:namespace/>eventSubClass" /> <input
												type="text" class="d-none"
												name="<portlet:namespace/>eventVersion"
												id="<portlet:namespace/>eventVersion" /> <input type="text"
												class="d-none" name="<portlet:namespace/>eventType"
												id="<portlet:namespace/>eventType" /> <input type="text"
												class="d-none" name="<portlet:namespace/>eventSource"
												id="<portlet:namespace/>eventSource" />
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
									<h5>No IVR Events found.</h5>
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

	function updateEvent(eventCode, eventName, eventClass, eventSubClass,
			eventVersion, eventType, eventSource, hasPendingVersion) {
		var eventCodeField = document
				.getElementById('<portlet:namespace/>eventCode');
		var eventNameField = document
				.getElementById('<portlet:namespace/>eventName');
		var eventClassField = document
				.getElementById('<portlet:namespace/>eventClass');
		var eventSubClassField = document
				.getElementById('<portlet:namespace/>eventSubClass');
		var eventVersionField = document
				.getElementById('<portlet:namespace/>eventVersion');
		var eventTypeField = document
				.getElementById('<portlet:namespace/>eventType');
		var eventSourceField = document
				.getElementById('<portlet:namespace/>eventSource');
		var hasPendingField = document
				.getElementById('<portlet:namespace/>hasPendingVersion');

		eventCodeField.value = eventCode;
		eventNameField.value = eventName;
		eventClassField.value = eventClass;
		eventSubClassField.value = eventSubClass;
		eventVersionField.value = eventVersion;
		eventTypeField.value = eventType;
		eventSourceField.value = eventSource;
		hasPendingField.value = hasPendingVersion;

		document.getElementById('<portlet:namespace/>eventUpdateForm').submit();
	}
</script>
