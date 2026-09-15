<%@page import="java.util.ArrayList"%>
<%@page import="com.ejada.telemony.db.model.Lovs"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>

<portlet:renderURL var="add_lovs">
	<portlet:param name="mvcPath" value="/add.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addType" var="addType">
</portlet:actionURL>

<portlet:actionURL name="lovListDelete" var="lovListDelete">
</portlet:actionURL>

<portlet:actionURL name="getLovsUpdateId" var="getLovsUpdateId">
</portlet:actionURL>

<portlet:actionURL name="newLovDataForm" var="newLovDataForm">
</portlet:actionURL>

<portlet:actionURL name="viewData" var="viewData">
</portlet:actionURL>

<portlet:actionURL name="searchByName" var="searchByName">
</portlet:actionURL>

<portlet:renderURL var="clear">
	<portlet:param name="action" value="view" />
</portlet:renderURL>



<%-- <portlet:actionURL name="getTypeCounter" var="getTypeCounter">
</portlet:actionURL> --%>



<%
	List<Lovs> records = (List<Lovs>) request.getAttribute("records") != null
			? (List<Lovs>) request.getAttribute("records")
			: new ArrayList<>();
	List<Lovs> types = request.getAttribute("types") != null
			? (List<Lovs>) request.getAttribute("types")
			: new ArrayList<>();

	// Get LOVs with pending versions
	java.util.Set<Long> lovsWithPendingVersions = (java.util.Set<Long>) request.getAttribute("lovsWithPendingVersions");
	if (lovsWithPendingVersions == null) {
		lovsWithPendingVersions = new java.util.HashSet<>();
	}
%>

<div>
	<h3 class="pb-4">LOVS Types</h3>
	<liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />
	<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
	<liferay-ui:error key="hasPendingVersion" message="This LOV has a pending draft version and cannot be modified until it is approved or discarded." />
	<div class="card">
		<div class="card-body">
			<% if (!isOther) { %>
			<div class="d-flex justify-content-end">
				<a href="<%=addType%>    ">
					<button type="submit" class="btn btn-primary px-5 mr-3">Add
						Type</button>
				</a>


			</div>
			<% } %>
			<form action=<%=searchByName%> method="post">
				<div class="row">
					<div class="col-md-4">
						<div class="d-flex align-items-end mb-3">
							<div>
								<label class="form-label">Search By</label>
								<select required
									class="custom-select mb-2" id="searchType"
									name="<portlet:namespace/>searchType">
									<option value="">Choose...</option>
									<option value="name">Name</option>
									<option value="code">CODE</option>
								</select>
								 <input  style="width: 200px;"
									type="text" class="form-control" id="searchName" required
									name="<portlet:namespace/>searchName">
							</div>
							<div class="d-flex">
								<button type="submit" class="btn btn-primary px-5 ml-3"
									id="searchButton">Search</button>
								<button type="button" class="btn btn-secondary px-5 ml-3"
									onclick="window.location.href='<%=clear%>'">Clear</button>
							</div>
						</div>
					</div>
				</div>
			</form>
			<div>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Type Name</th>
							<th scope="col">Type Code</th>
							<th scope="col">Event Code</th>
							<th scope="col">Count</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<%
							List<Lovs> displayList = (types != null && !types.isEmpty()) ? types : records;
							for (Lovs record : displayList) {
								boolean hasPendingVersion = lovsWithPendingVersions.contains(record.getId());
						%>
						<tr>
							<td>
								<%=record.getName("English") != null ? record.getName("English") : ""%>
								<% if (hasPendingVersion) { %>
								<span class="badge badge-warning" style="font-size: 0.7rem; vertical-align: middle; background-color: #f0ad4e; margin-left: 8px;">
									Pending Approval
								</span>
								<% } %>
							</td>
							<td><%=record.getCode()%></td>
							<td><%=record.getEventCode()%></td>
							<td><%=record.getCount()%></td>
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
										<% if (hasPendingVersion) { %>
										<!-- View LOV Details (view-only mode) -->
										<form action=<%=getLovsUpdateId%> method="post"
											name="<portlet:namespace/>viewLovForm<%=record.getId()%>"
											id="<portlet:namespace/>viewLovForm<%=record.getId()%>">
											<a onclick="viewLovWithPending('<%=record.getId()%>')"
												class="dropdown-item"> View </a>
											<input type="hidden" name="<portlet:namespace/>lovsId" value="<%=record.getId()%>" />
											<input type="hidden" name="<portlet:namespace/>hasPendingVersion" value="true" />
										</form>
										<!-- View LOV Data (view-only mode) -->
										<form action=<%=viewData%> method="post"
											name="<portlet:namespace/>dataView<%=record.getId()%>"
											id="<portlet:namespace/>dataView<%=record.getId()%>">
											<a onclick="viewDataWithPending('<%=record.getId()%>')"
												class="dropdown-item"> View Data </a>
											<input type="hidden" name="<portlet:namespace/>parentId" value="<%=record.getId()%>" />
											<input type="hidden" name="<portlet:namespace/>hasPendingVersion" value="true" />
										</form>
										<% } else { %>
										<!-- View LOV Data -->
										<form action=<%=viewData%> method="post"
											name="<portlet:namespace/>dataView"
											id="<portlet:namespace/>dataView">
											<a onclick="viewData('<%=record.getId()%>')"
												class="dropdown-item"> View Data </a>
											<input type="text" class="d-none"
												name="<portlet:namespace/>parentId"
												id="<portlet:namespace/>parentId" />
										</form>
										<% if (!isOther) { %>
										<!-- Edit LOV (same as View for non-pending) -->
										<form action=<%=getLovsUpdateId%> method="post"
											name="<portlet:namespace/>dataUpdateForm"
											id="<portlet:namespace/>dataUpdateForm">
											<a onclick="updateData('<%=record.getId()%>')"
												class="dropdown-item"> Edit </a> <input type="text"
												class="d-none" name="<portlet:namespace/>lovsId"
												id="<portlet:namespace/>lovsId" />
											<input type="hidden" name="<portlet:namespace/>hasPendingVersion" value="false" />
										</form>

										<form action=<%=lovListDelete%> method="post"
											name="<portlet:namespace/>lovsDeleteForm"
											id="<portlet:namespace/>lovsDeleteForm">
											<a onclick="deleteLov('<%=record.getId()%>')"
												class="dropdown-item"> Delete </a> <input type="text"
												class="d-none" name="<portlet:namespace/>deleteId"
												id="<portlet:namespace/>deleteId" />
										</form>
										<% } %>
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
<div class="modal hide fade" id="telemoneyDeleteModal" tabindex="-1"
	role="dialog" aria-labelledby="telemoneyDeleteModalCenteredTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-100" role="document">
		<div class="modal-content w-auto m-auto">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">Delete Type</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body text-5 text-center">Are you sure you
				want to delete this type?</div>
			<div class="modal-footer justify-content-end">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="submit" class="btn btn-primary"
					onclick="deleteTypeConfirm()">Confirm</button>
			</div>
		</div>
	</div>
</div>

<script>
	function clearForm() {
		document.getElementById('searchName').value = '';
		document.getElementById('searchButton').click();
	}
	function deleteLov(recordId) {
		var recordIdField = document
				.getElementById('<portlet:namespace/>deleteId');

		recordIdField.value = recordId;
		openModal();
	}

	function deleteTypeConfirm() {
		document.getElementById('<portlet:namespace/>lovsDeleteForm').submit();
	}
	function resetDelete() {
		var recordIdField = document
				.getElementById('<portlet:namespace/>deleteId');

		recordIdField.value = "";
	}

	function openModal() {
		$("#telemoneyDeleteModal").modal("show");
		$("#telemoneyDeleteModal").removeClass("hide");
	}

	function closeModal() {
		$("#telemoneyDeleteModal").modal("hide");
		$("#telemoneyDeleteModal").addClass("hide");
	}

	$('#telemoneyDeleteModal').on('hidden.bs.modal', function(e) {
		resetDelete();
	})

	function viewDataWithPending(recordId) {
		document.getElementById('<portlet:namespace/>dataView' + recordId).submit();
	}

	function viewLovWithPending(recordId) {
		document.getElementById('<portlet:namespace/>viewLovForm' + recordId).submit();
	}


	function updateData(recordId) {
		var recordIdField = document
				.getElementById('<portlet:namespace/>lovsId');

		recordIdField.value = recordId;

		document.getElementById('<portlet:namespace/>dataUpdateForm').submit();
	}

	function setNewData(recordId, recordName) {
		var recordIdField = document
				.getElementById('<portlet:namespace/>lovId');
		var recordNameField = document
				.getElementById('<portlet:namespace/>lovType');

		recordIdField.value = recordId;
		recordNameField.value = recordName;

		document.getElementById('<portlet:namespace/>lovDataCreation').submit();
	}

	function viewData(recordId) {
		var recordIdField = document
				.getElementById('<portlet:namespace/>parentId');

		recordIdField.value = recordId;

		document.getElementById('<portlet:namespace/>dataView').submit();
	}
</script>
