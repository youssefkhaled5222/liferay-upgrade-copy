<%@page import="com.ejada.telemoney.db.constants.TelemoneyConstants"%>
<%@ include file="/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@page import="com.ejada.telemony.db.model.Resource"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="com.ejada.telemony.db.model.Feature"%>

<portlet:renderURL var="add_resource">
	<portlet:param name="myView" value="add" />
</portlet:renderURL>

<portlet:actionURL name="deleteResources" var="deleteResources">
</portlet:actionURL>
<portlet:actionURL name="searchRes" var="searchRes" />
<portlet:actionURL name="exportResource" var="exportResourceURL" />

<%
	List<Resource> viewResource = (List<Resource>) request.getAttribute("resource") != null
			? (List<Resource>) request.getAttribute("resource")
			: new ArrayList<>();
	List<Resource> searchResult = (List<Resource>) request.getAttribute("searchResult") != null
			? (List<Resource>) request.getAttribute("searchResult")
			: new ArrayList<>();
	Map<Resource, Boolean> resourcesWithPending = (Map<Resource, Boolean>) request.getAttribute("resourcesWithPending");
	List<Feature> pages = (List<Feature>) request.getAttribute("pages") != null
			? (List<Feature>) request.getAttribute("pages")
			: new ArrayList<>();
	long selectedFeatureId = request.getAttribute("selectedFeatureId") != null
			? (Long) request.getAttribute("selectedFeatureId")
			: 0;

	Boolean hasPendingImport = (Boolean) request.getAttribute("hasPendingImport");
	if (hasPendingImport == null) hasPendingImport = false;
%>

<portlet:renderURL var="pageChangeURL">
</portlet:renderURL>
<div>
	<div class="my-4 d-flex justify-content-between align-items-center">
		<div>
			<h1>List of Resources</h1>
			<p class="text-secondary">Manage or Add Resources</p>
		</div>
		<% if (!isOther) { %>
		<div>
			<% if (!hasPendingImport) { %>
			<button type="button" class="btn btn-secondary mr-2" onclick="openImportModal();">
				Import
			</button>
			<% } %>
			<button type="button" class="btn btn-primary" id="exportBtn" onclick="toggleExportMode()">
				Export
			</button>
			<button type="button" class="btn btn-success d-none" id="confirmExportBtn" onclick="submitExport()">
				Confirm Export
			</button>
			<button type="button" class="btn btn-secondary d-none ml-2" id="cancelExportBtn" onclick="cancelExportMode()">
				Cancel
			</button>
		</div>
		<% } %>
	</div>

	<liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />
	<liferay-ui:error key="file-upload-error" message="File upload error" />
	<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
	<liferay-ui:error key="noDataToExport" message="No data available to export. Please ensure there are entries to export and try again." />
	<liferay-ui:error key="zipSizeExceeded" message="Export failed: The generated ZIP file exceeds the 10MB size limit. Please reduce the number of selected items and try again." />
	<liferay-ui:error key="import-processing-error" message="An error occurred while processing the import. Please check if you uploaded the correct file, then try again."/>

	<div class="card">
		<div class="card-body">
			<% if (!isOther) { %>
			<div class="d-flex justify-content-end">
				<a href="<%=add_resource%>">
					<button type="submit" class="btn btn-primary px-5 mr-3">Add
						New Resource</button>
				</a>
			</div>
			<% } %>

			<% if (!pages.isEmpty()) { %>
			<div class="form-group row mb-4">
				<label for="pageSelect" class="col-auto col-form-label">Page</label>
				<div class="col-sm-3">
					<select class="form-control" id="pageSelect" onchange="onPageChange(this)">
						<% for (Feature featurePage : pages) { %>
							<option value="<%=featurePage.getEntityResourceId()%>" <%=featurePage.getEntityResourceId() == selectedFeatureId ? "selected" : ""%>><%=featurePage.getFeatureName()%></option>
						<% } %>
					</select>
				</div>
			</div>
			<% } %>

			<div class="row">
				<form action="${searchRes}" method="post">
					<div class="col-md-12">
						<div class="d-flex align-items-end mb-3">
							<div>
								<label class="form-label">Search By</label> <select required
									class="custom-select mb-2" id="searchBy"
									name="<portlet:namespace/>searchBy">
									<option value="">Choose...</option>
									<option value="name">Name</option>
									<option value="code">CODE</option>
									<option value="type">TYPE</option>
								</select> <input type="text" name="<portlet:namespace/>searchTerm"
									class="form-control" id="searchInput" required>
							</div>
							<div>
								<button type="submit" class="btn btn-primary px-5 ml-3">Search</button>
								<button type="button" class="btn btn-secondary px-5 ml-3"
									onclick="clearForm()">Clear</button>
							</div>
						</div>
					</div>
				</form>
			</div>
			<div>
				<table class="table">

					<thead>
						<tr>
							<th scope="col" class="export-checkbox-column d-none" style="width: 50px;"></th>
							<th scope="col">Code</th>
							<th scope="col">Type</th>
							<th scope="col">Name in English</th>
							<th scope="col">Status</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<%
							if (searchResult != null) {
								List<Resource> listToDisplay = !searchResult.isEmpty() ? searchResult : viewResource;
								for (Resource currentResource : listToDisplay) {
									if (selectedFeatureId > 0 && currentResource.getFeatureId() != selectedFeatureId) {
										continue;
									}
									String englishName = (String) currentResource
											.getName(TelemoneyConstants.LANGUAGE_ENGLISH_NAME) != null
													? currentResource.getName(TelemoneyConstants.LANGUAGE_ENGLISH_NAME)
													: "Non";
									boolean isPending = false;
									if (resourcesWithPending != null && resourcesWithPending.containsKey(currentResource)) {
										Boolean pending = resourcesWithPending.get(currentResource);
										isPending = pending != null && pending;
									}
						%>
						<tr>
							<td class="export-checkbox-column d-none">
								<% if (!isPending) { %>
								<input type="checkbox" class="export-resource-checkbox" value="<%=currentResource.getResourceId()%>" />
								<% } %>
							</td>
							<td><%=currentResource.getResourceCode()%></td>
							<td><liferay-ui:message
									key="<%=LanguageUtil.get(request, "tm.resource.type." + currentResource.getResourceType())%>" /></td>
							<td><%=englishName%></td>
							<td>
								<% if (isPending) { %>
									<span class="label label-warning">Pending</span>
								<% } else { %>
									<span class="label label-success">Approved</span>
								<% } %>
							</td>
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
										<% if (isPending) { %>
										<a class="dropdown-item"
											href="<portlet:actionURL name="getResourceIdForView">
											<portlet:param name="selectedResourceId" value="<%=String.valueOf(currentResource.getResourceId())%>" />
											<portlet:param name="action" value="view" />
											</portlet:actionURL>">View</a>
										<% } else { %>
										<a class="dropdown-item"
											href="<portlet:actionURL name="getResourceIdForView">
											<portlet:param name="selectedResourceId" value="<%=String.valueOf(currentResource.getResourceId())%>" />
											<portlet:param name="action" value="update" />
											</portlet:actionURL>"><%= isOther ? "View" : "Edit" %></a>


										<% if (!isOther) { %>
										<form action=<%=deleteResources%> method="post"
											name="<portlet:namespace/>resourceDeleteForm"
											id="<portlet:namespace/>resourceDeleteForm">
											<a
												onclick="deleteResource('<%=currentResource.getResourceId()%>')"
												class="dropdown-item"> Delete </a> <input type="text"
												class="d-none" name="<portlet:namespace/>selectedResourceId"
												id="<portlet:namespace/>selectedResourceId" />
										</form>
										<% } %>
										<% } %>
									</div>
								</div>
							</td>
						</tr>
						<%
							}
							}
						%>


					</tbody>

				</table>
			</div>
		</div>
	</div>
</div>

<div class="modal hide fade" id="telemoneyExportModal" tabindex="-1"
	role="dialog" aria-labelledby="telemoneyExportModalTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered modal-sm" role="document" style="max-width: 450px;">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="telemoneyExportModalTitle">Export Summary</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<label for="exportSummary">Export Summary (optional):</label>
					<textarea class="form-control" id="exportSummary" rows="3"
						placeholder="Enter export summary..."></textarea>
				</div>
			</div>
			<div class="modal-footer justify-content-end">
				<button type="button" class="btn btn-secondary"
					data-dismiss="modal">Cancel</button>
				<button type="button" class="btn btn-primary"
					onclick="confirmExport()">Confirm Export</button>
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
					Resource</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body text-5 text-center">Are you sure you
				want to delete this resource?</div>
			<div class="modal-footer justify-content-end">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="submit" class="btn btn-primary"
					onclick="deleteResourceConfirm()">Confirm</button>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	function onPageChange(selectElement) {
		var selectedFeatureId = selectElement.value;
		var baseUrl = '<%=pageChangeURL%>';
		window.location.href = baseUrl + '&<portlet:namespace/>selectedFeatureId=' + selectedFeatureId;
	}

	function clearForm() {
		document.getElementById('searchInput').value = '';
		window.location.href = window.location.pathname;
	}

	function deleteResource(recordId) {
		var recordIdField = document
				.getElementById('<portlet:namespace/>selectedResourceId');

		recordIdField.value = recordId;
		openModal();

	}

	function deleteResourceConfirm() {

		document.getElementById('<portlet:namespace/>resourceDeleteForm')
				.submit();
	}

	function resetDelete() {
		var recordIdField = document
				.getElementById('<portlet:namespace/>selectedResourceId');

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



	// Export mode functions
	var exportMode = false;

	function toggleExportMode() {
		exportMode = true;
		document.getElementById('exportBtn').classList.add('d-none');
		document.getElementById('confirmExportBtn').classList.remove('d-none');
		document.getElementById('cancelExportBtn').classList.remove('d-none');
		// Show all checkboxes
		var checkboxColumns = document.querySelectorAll('.export-checkbox-column');
		for (var i = 0; i < checkboxColumns.length; i++) {
			checkboxColumns[i].classList.remove('d-none');
		}
	}

	function cancelExportMode() {
		exportMode = false;
		document.getElementById('exportBtn').classList.remove('d-none');
		document.getElementById('confirmExportBtn').classList.add('d-none');
		document.getElementById('cancelExportBtn').classList.add('d-none');
		// Hide all checkboxes and uncheck them
		var checkboxColumns = document.querySelectorAll('.export-checkbox-column');
		for (var i = 0; i < checkboxColumns.length; i++) {
			checkboxColumns[i].classList.add('d-none');
		}
		var inputs = document.querySelectorAll('.export-resource-checkbox');
		for (var j = 0; j < inputs.length; j++) {
			inputs[j].checked = false;
		}
	}

	function submitExport() {
		var selected = document.querySelectorAll('.export-resource-checkbox:checked');
		if (selected.length === 0) {
			alert('Please select at least one resource to export.');
			return;
		}
		// Show the export summary modal
		$("#telemoneyExportModal").modal("show");
		$("#telemoneyExportModal").removeClass("hide");
	}

	function confirmExport() {
		var summary = document.getElementById('exportSummary').value.trim();

		var selected = document.querySelectorAll('.export-resource-checkbox:checked');
		var exportForm = document.getElementById('exportResourceForm');
		// Clear previous hidden inputs
		var container = document.getElementById('exportResourceIdsContainer');
		container.innerHTML = '';

		// Add resource IDs
		for (var i = 0; i < selected.length; i++) {
			var input = document.createElement('input');
			input.type = 'hidden';
			input.name = '<portlet:namespace/>resourceIds';
			input.value = selected[i].value;
			container.appendChild(input);
		}

		// Add summary
		var summaryInput = document.createElement('input');
		summaryInput.type = 'hidden';
		summaryInput.name = '<portlet:namespace/>exportSummary';
		summaryInput.value = summary;
		container.appendChild(summaryInput);

		// Close modal
		$("#telemoneyExportModal").modal("hide");
		$("#telemoneyExportModal").addClass("hide");

		// Submit form
		exportForm.submit();

		// Reset
		document.getElementById('exportSummary').value = '';
		cancelExportMode();
	}
</script>

<!-- Hidden form for export -->
<form action="<%=exportResourceURL%>" method="post" id="exportResourceForm" class="d-none">
	<div id="exportResourceIdsContainer"></div>
</form>

<!-- Import Modal (separate JSP) -->
<%@ include file="/importModal.jsp"%>
