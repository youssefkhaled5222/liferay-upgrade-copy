<%@page import="java.util.ArrayList"%>
<%@page import="com.ejada.telemony.db.model.Themes"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ include file="/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>


<portlet:renderURL var="add">
	<portlet:param name="mvcPath" value="/add.jsp" />
</portlet:renderURL>

<portlet:actionURL name="editTheme" var="editTheme" />
<portlet:actionURL name="viewTheme" var="viewTheme" />
<portlet:actionURL name="getPendingThemeViewId" var="getPendingThemeViewId" />

<portlet:actionURL name="deleteTheme" var="deleteTheme" />
<portlet:actionURL name="exportTheme" var="exportThemeURL" />


<%
	List<Themes> nonDefaultThemes = (List<Themes>) request.getAttribute("nonDefaultThemes") != null
			? (List<Themes>) request.getAttribute("nonDefaultThemes")
			: new ArrayList<>();
	List<Themes> defaultThemes = (List<Themes>) request.getAttribute("defaultThemes") != null
			? (List<Themes>) request.getAttribute("defaultThemes")
			: new ArrayList<>();

	Map<Themes, Boolean> nonDefaultThemesWithPending = (Map<Themes, Boolean>) request.getAttribute("nonDefaultThemesWithPending");
	Map<Themes, Boolean> defaultThemesWithPending = (Map<Themes, Boolean>) request.getAttribute("defaultThemesWithPending");

	Boolean hasPendingImport = (Boolean) request.getAttribute("hasPendingImport");
	if (hasPendingImport == null) hasPendingImport = false;
%>
<form method="post" action="<%=editTheme%>" id="themeForm">
	<div>
		<liferay-ui:error key="error" message="Theme is currently in use" />
		<input type="text" name="<portlet:namespace/>clickedTheme"
			id="clickedTheme" class="d-none" /> <input type="text"
			name="<portlet:namespace/>targetAction" id="targetAction"
			class="d-none" value="edit" />
		<div class="my-4 d-flex justify-content-between align-items-center">
			<div>
				<h1>Themes List</h1>
				<p class="text-secondary">Manage or Add Theme</p>
			</div>
			<% if (isAdministrator || isPo || isMarketing) { %>
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

		<div class="my-3 pb-5">
			<h4 class="mb-3">Original Themes</h4>
			<div class="row m-0" style="gap: 15px">
				<%
					int indexDefault = 0;
					for (Themes resultThemeDefault : defaultThemes) {
						String primaryColor = (String) JSONFactoryUtil.createJSONObject(resultThemeDefault.getPrimaryColors()).get("default");
						boolean isPending = false;
						if (defaultThemesWithPending != null && defaultThemesWithPending.containsKey(resultThemeDefault)) {
							Boolean pending = defaultThemesWithPending.get(resultThemeDefault);
							isPending = pending != null && pending;
						}
				%>
				<div class="col-md-2 p-0" style="position:relative;">
					<% if (!isPending) { %>
					<div class="export-checkbox d-none" style="position:absolute; top:10px; left:10px; z-index:10;">
						<input type="checkbox" class="export-theme-checkbox" value="<%=resultThemeDefault.getThemeId()%>" />
					</div>
					<% } %>
					<div class="top d-flex align-items-end p-3 rounded-top"
						style="height: 150px; background:<%=primaryColor%>;">
						<%
							if (resultThemeDefault.getDarkTheme()) {
						%>
						<span class="badge badge-dark py-1 px-2">Dark</span>
						<%
							} else {
						%>
						<span class="badge badge-light py-1 px-2">Light</span>
						<%
							}
						%>
					</div>
					<div class="bg-light p-3 rounded-bottom">
						<div class="d-flex justify-content-between align-items-center">
							<h4 class="m-0"><%=resultThemeDefault.getThemeEnName()%></h4>
							<% if (isPending) { %>
							<div class="d-flex align-items-center">
								<span class="label label-warning mr-2">Pending</span>
								<div class="dropdown dropright">
									<button class="btn dropdown-toggle p-0" type="button"
										id="dropdownMenuButtonPendingDefault<%=indexDefault%>" data-toggle="dropdown"
										aria-haspopup="true" aria-expanded="false">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
											fill="dark" class="bi bi-three-dots-vertical"
											viewBox="0 0 16 16">
										  <path
												d="M9.5 13a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z" />
										</svg>
									</button>
									<div class="dropdown-menu"
										aria-labelledby="dropdownMenuButtonPendingDefault<%=indexDefault%>">
										<button class="dropdown-item"
											onclick="viewPendingTheme(<%=resultThemeDefault.getThemeId()%>)">View</button>
									</div>
								</div>
							</div>
							<% } else { %>
							<div class="dropdown d-flex justify-content-end dropright">
								<button class="btn dropdown-toggle p-0" type="button"
									id="dropdownMenuButton<%=indexDefault%>" data-toggle="dropdown"
									aria-haspopup="true" aria-expanded="false">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="dark" class="bi bi-three-dots-vertical"
										viewBox="0 0 16 16">
							  <path
											d="M9.5 13a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z" />
							</svg>
								</button>
								<div class="dropdown-menu"
									aria-labelledby="dropdownMenuButton<%=indexDefault%>">
									<% if (isAdministrator || isPo || isMarketing) { %>
									<button class="dropdown-item"
										onclick="sendClickedTheme(<%=resultThemeDefault.getThemeId()%>, 'edit')">View
										/ Update</button>
									<% } else { %>
									<button class="dropdown-item"
										onclick="sendClickedTheme(<%=resultThemeDefault.getThemeId()%>, 'view')">View</button>
									<% } %>
								</div>
							</div>
							<% } %>
						</div>
					</div>
				</div>
				<%
					indexDefault++;
					}
				%>
			</div>
		</div>

		<div class="my-3">
			<h4 class="mb-3">Custom Themes</h4>
			<div class="row m-0" style="gap: 15px">
				<%
					int index = 0;
					for (Themes resultTheme : nonDefaultThemes) {
						String primaryColor = (String) JSONFactoryUtil.createJSONObject(resultTheme.getPrimaryColors()).get("default");
						boolean isPending = false;
						if (nonDefaultThemesWithPending != null && nonDefaultThemesWithPending.containsKey(resultTheme)) {
							Boolean pending = nonDefaultThemesWithPending.get(resultTheme);
							isPending = pending != null && pending;
						}
				%>
				<div class="col-md-2 p-0" style="position:relative;">
					<% if (!isPending) { %>
					<div class="export-checkbox d-none" style="position:absolute; top:10px; left:10px; z-index:10;">
						<input type="checkbox" class="export-theme-checkbox" value="<%=resultTheme.getThemeId()%>" />
					</div>
					<% } %>
					<div class="top d-flex align-items-end p-3 rounded-top"
						style="height: 150px; background:<%=primaryColor%>;">
						<%
							if (resultTheme.getDarkTheme()) {
						%>
						<span class="badge badge-dark py-1 px-2">Dark</span>
						<%
							} else {
						%>
						<span class="badge badge-light py-1 px-2">Light</span>
						<%
							}
						%>
					</div>
					<div class="bg-light p-3 rounded-bottom">
						<div class="d-flex justify-content-between align-items-center">
							<h4 class="m-0"><%=resultTheme.getThemeEnName()%></h4>
							<% if (isPending) { %>
							<div class="d-flex align-items-center">
								<span class="label label-warning mr-2">Pending</span>
								<div class="dropdown dropright">
									<button class="btn dropdown-toggle p-0" type="button"
										id="dropdownMenuButtonPending<%=index%>" data-toggle="dropdown"
										aria-haspopup="true" aria-expanded="false">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
											fill="dark" class="bi bi-three-dots-vertical"
											viewBox="0 0 16 16">
										  <path
												d="M9.5 13a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z" />
										</svg>
									</button>
									<div class="dropdown-menu"
										aria-labelledby="dropdownMenuButtonPending<%=index%>">
										<button class="dropdown-item"
											onclick="viewPendingTheme(<%=resultTheme.getThemeId()%>)">View</button>
									</div>
								</div>
							</div>
							<% } else { %>
							<div class="dropdown d-flex justify-content-end dropright">
								<button class="btn dropdown-toggle p-0" type="button"
									id="dropdownMenuButton<%=index%>" data-toggle="dropdown"
									aria-haspopup="true" aria-expanded="false">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="dark" class="bi bi-three-dots-vertical"
										viewBox="0 0 16 16">
							  <path
											d="M9.5 13a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z" />
							</svg>
								</button>
								<div class="dropdown-menu"
									aria-labelledby="dropdownMenuButton<%=index%>">
									<% if (isAdministrator || isPo || isMarketing) { %>
									<button class="dropdown-item"
										onclick="sendClickedTheme(<%=resultTheme.getThemeId()%>, 'edit')">View
										/ Update</button>
									<button class="dropdown-item" type="button"
										onclick="deleteTheme(<%=resultTheme.getThemeId()%>)">Delete
									</button>
									<% } else { %>
									<button class="dropdown-item"
										onclick="sendClickedTheme(<%=resultTheme.getThemeId()%>, 'view')">View</button>
									<% } %>
								</div>
							</div>
							<% } %>
						</div>
					</div>
				</div>
				<%
					index++;
					}
				%>
				<% if (isAdministrator || isPo || isMarketing) { %>
				<div class="col-md-2 p-0">
					<div class="card bg-light text-dark h-100">
						<div class="card-body d-flex flex-column h-100">
							<div class="icon d-flex justify-content-end">
								<button class="btn p-0" type="button"
									onclick="window.location.href='<%=add%>'">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-plus-lg" viewBox="0 0 16 16">
							  <path fill-rule="evenodd"
											d="M8 2a.5.5 0 0 1 .5.5v5h5a.5.5 0 0 1 0 1h-5v5a.5.5 0 0 1-1 0v-5h-5a.5.5 0 0 1 0-1h5v-5A.5.5 0 0 1 8 2Z" />
							</svg>
								</button>
							</div>
							<div class="h2 pt-5 mt-auto">Create New Theme</div>
						</div>
					</div>
				</div>
				<% } %>
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
						Theme</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body text-5 text-center">Are you sure you
					want to delete this theme?</div>
				<div class="modal-footer justify-content-end">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="submit" class="btn btn-primary"
						onclick="closeModal()">Confirm</button>
				</div>
			</div>
		</div>
	</div>
</form>


<script>
	var themeForm = document.getElementById("themeForm");
	var clickedTheme = document.getElementById("clickedTheme");
	var targetAction = document.getElementById("targetAction");

	function sendClickedTheme(id, action) {
		clickedTheme.value = id;
		if(action === 'view') {
			themeForm.action = '<%= viewTheme %>';
		}
		themeForm.submit();
	}
	
	function viewPendingTheme(id) {
		document.getElementById('pendingThemeId').value = id;
		document.getElementById('pendingThemeForm').submit();
	}

	function deleteTheme(id){
		clickedTheme.value = id;
		targetAction.value="delete";
 		openModal();

	}
	
	function resetDelete(){
		clickedTheme.value = 0;
		targetAction.value="edit";
		console.log("Reseeeeet")
	}
	
	function openModal() {
		  $("#telemoneyDeleteModal").modal("show");
		  $("#telemoneyDeleteModal").removeClass("hide");
		}
	
	function closeModal(){
		  $("#telemoneyDeleteModal").modal("hide");
		  $("#telemoneyDeleteModal").addClass("hide");
	}
	
	$('#telemoneyDeleteModal').on('hidden.bs.modal', function (e) {
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
		var checkboxes = document.querySelectorAll('.export-checkbox');
		for (var i = 0; i < checkboxes.length; i++) {
			checkboxes[i].classList.remove('d-none');
		}
	}

	function cancelExportMode() {
		exportMode = false;
		document.getElementById('exportBtn').classList.remove('d-none');
		document.getElementById('confirmExportBtn').classList.add('d-none');
		document.getElementById('cancelExportBtn').classList.add('d-none');
		// Hide all checkboxes and uncheck them
		var checkboxes = document.querySelectorAll('.export-checkbox');
		for (var i = 0; i < checkboxes.length; i++) {
			checkboxes[i].classList.add('d-none');
		}
		var inputs = document.querySelectorAll('.export-theme-checkbox');
		for (var j = 0; j < inputs.length; j++) {
			inputs[j].checked = false;
		}
	}

function submitExport() {
	var selected = document.querySelectorAll('.export-theme-checkbox:checked');
	if (selected.length === 0) {
		alert('Please select at least one theme to export.');
		return;
	}
	// Show the export summary modal
	$("#telemoneyExportModal").modal("show");
	$("#telemoneyExportModal").removeClass("hide");
}

function confirmExport() {
	var summary = document.getElementById('exportSummary').value.trim();

	var selected = document.querySelectorAll('.export-theme-checkbox:checked');
	var exportForm = document.getElementById('exportThemeForm');
	// Clear previous hidden inputs
	var container = document.getElementById('exportThemeIdsContainer');
	container.innerHTML = '';

	// Add theme IDs
	for (var i = 0; i < selected.length; i++) {
		var input = document.createElement('input');
		input.type = 'hidden';
		input.name = '<portlet:namespace/>themeIds';
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
<form action="<%=exportThemeURL%>" method="post" id="exportThemeForm" class="d-none">
	<div id="exportThemeIdsContainer"></div>
</form>

<!-- Import Modal (separate JSP) -->
<%@ include file="/importModal.jsp"%>

<!-- Hidden form for pending theme view -->
<form action="<%=getPendingThemeViewId%>" method="post" id="pendingThemeForm" class="d-none">
	<input type="hidden" name="<portlet:namespace/>pendingThemeId" id="pendingThemeId" />
</form>
