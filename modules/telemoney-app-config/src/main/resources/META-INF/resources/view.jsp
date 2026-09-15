<%@page import="com.ejada.telemony.db.model.AppEnvironment"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>

<portlet:renderURL var="addAppConfig">
	<portlet:param name="myView" value="add"/>
</portlet:renderURL>
<portlet:actionURL name="deleteAppConfig" var="deleteAppConfig" />

<%
	List<AppEnvironment> records = (List<AppEnvironment>)request.getAttribute("records") != null
		? (List<AppEnvironment>)request.getAttribute("records")
		: new ArrayList<>();

	Map<AppEnvironment, Boolean> recordsWithPending =
		(Map<AppEnvironment, Boolean>)request.getAttribute("recordsWithPending");

	String errorMsg = (String)request.getAttribute("errorMessage") != null
		? (String)request.getAttribute("errorMessage")
		: "";
%>

<div>
	<h3 class="pb-4">List of App Environments</h3>
	<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />

	<div class="card">
		<div class="card-body">
			<% if (!isOther) { %>
			<div class="d-flex justify-content-end mb-3">
				<a href="<%= addAppConfig %>">
					<button type="button" class="btn btn-primary px-5 mr-3">Add New Environment</button>
				</a>
			</div>
			<% } %>

			<div class="my-3">
				<liferay-ui:error key="error" message="<%= errorMsg %>" />
			</div>

			<table class="table">
				<thead>
				<tr>
					<th>Environment</th>
					<th>Actions</th>
				</tr>
				</thead>
				<tbody>
				<%
					for (AppEnvironment record : records) {
						boolean isPending = false;

						if ((recordsWithPending != null) && recordsWithPending.containsKey(record)) {
							Boolean pending = recordsWithPending.get(record);
							isPending = (pending != null) && pending;
						}
				%>
				<tr>
					<td>
						<%= record.getEnvironmentName() != null ? record.getEnvironmentName() : "" %>
					</td>
					<td>
						<% if (isPending) { %>
						<span class="label label-warning">Pending</span>
						<% } else { %>
						<div class="dropdown">
							<button class="btn btn-secondary dropdown-toggle" type="button"
								id="dropdownMenuButton<%= record.getEnvironmentId() %>" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-three-dots-vertical" viewBox="0 0 16 16">
									<path
										d="M9.5 13a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z" />
								</svg>
							</button>
							<div class="dropdown-menu"
								aria-labelledby="dropdownMenuButton<%= record.getEnvironmentId() %>">
								<a class="dropdown-item"
									href="<portlet:renderURL><portlet:param name='myView' value='edit'/><portlet:param name='environmentId' value='<%=String.valueOf(record.getEnvironmentId()) %>'/></portlet:renderURL>"><%= isOther ? "View" : "Edit" %></a>
								<% if (!isOther) { %>
								<a class="dropdown-item"
									onclick="openAppConfigDeleteModal('<%= record.getEnvironmentId() %>')">Delete</a>
								<% } %>
							</div>
						</div>
						<% } %>
					</td>
				</tr>
				<%
					}
				%>
				</tbody>
			</table>
		</div>
	</div>

	<% if (!isOther) { %>
	<form action="<%= deleteAppConfig %>" method="post" name="<portlet:namespace/>appConfigDeleteForm"
		id="<portlet:namespace/>appConfigDeleteForm">
		<input type="hidden" name="<portlet:namespace/>selectedEnvironmentId"
			id="<portlet:namespace/>selectedEnvironmentId" />
	</form>

	<div class="modal hide fade" id="appConfigDeleteModal" tabindex="-1"
		role="dialog" aria-labelledby="appConfigDeleteModalTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered w-100" role="document">
			<div class="modal-content w-auto m-auto">
				<div class="modal-header">
					<h5 class="modal-title" id="appConfigDeleteModalTitle">Delete</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body text-5 text-center">Are you sure you want to delete this App Config ?</div>
				<div class="modal-footer justify-content-end">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary" onclick="confirmAppConfigDelete()">Confirm</button>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		function openAppConfigDeleteModal(environmentId) {
			var idField = document.getElementById('<portlet:namespace/>selectedEnvironmentId');
			idField.value = environmentId;
			$("#appConfigDeleteModal").modal("show");
			$("#appConfigDeleteModal").removeClass("hide");
		}

		function confirmAppConfigDelete() {
			document.getElementById('<portlet:namespace/>appConfigDeleteForm').submit();
		}

		function resetAppConfigDelete() {
			var idField = document.getElementById('<portlet:namespace/>selectedEnvironmentId');
			idField.value = "";
		}

		$('#appConfigDeleteModal').on('hidden.bs.modal', function() {
			resetAppConfigDelete();
			$("#appConfigDeleteModal").addClass("hide");
		});
	</script>
	<% } %>
</div>
