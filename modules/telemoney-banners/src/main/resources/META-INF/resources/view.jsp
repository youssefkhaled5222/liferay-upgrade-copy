<%@ include file="/init.jsp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@page import="com.ejada.telemony.db.model.Banner"%>

<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>

<portlet:renderURL var="add_banner">
	<portlet:param name="myview" value="add" />
</portlet:renderURL>
<portlet:actionURL name="exportBanner" var="exportBannerURL" />

<%
	List<Banner> banners = (List<Banner>) request.getAttribute("banners") != null
			? (List<Banner>) request.getAttribute("banners")
			: new ArrayList<>();
	java.util.Set<Long> bannersWithPendingVersions = (java.util.Set<Long>) request.getAttribute("bannersWithPendingVersions");
	if (bannersWithPendingVersions == null) {
		bannersWithPendingVersions = new java.util.HashSet<>();
	}
	Boolean hasPendingImport = (Boolean) request.getAttribute("hasPendingImport");
	if (hasPendingImport == null) hasPendingImport = false;
%>

<div>
	<div class="my-4 d-flex justify-content-between align-items-center">
		<div>
			<h3 class="mb-0">Banners</h3>
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
	    <liferay-ui:error
			key="hasPendingVersion"
			message="This banner has a pending draft version and cannot be modified until it is approved or discarded." />
		<liferay-ui:error key="noDataToExport" message="No data available to export. Please ensure there are entries to export and try again." />
	<liferay-ui:error key="zipSizeExceeded" message="Export failed: The generated ZIP file exceeds the 10MB size limit. Please reduce the number of selected items and try again." />
	<liferay-ui:error key="import-processing-error" message="An error occurred while processing the import. Please check if you uploaded the correct file, then try again."/>
	<liferay-ui:error key="no-import-decisions" message="No import decisions were received. Please try again." />
	<!-- <div>Quick Filters</div>
	<div class="my-3">
		<div class="filter btn bg-light h5 active">Published</div>
		<div class="filter btn bg-light h5">Draft</div>
		<div class="filter btn bg-light h5">Scheduled</div>
		<div class="filter btn bg-light h5 dropdown-toggle" type="button"
			id="dropdownMenuButtonFilter" data-toggle="dropdown"
			aria-haspopup="true" aria-expanded="false">
			More
			<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
				fill="currentColor" class="bi bi-chevron-compact-down"
				viewBox="0 0 16 16">
			  <path fill-rule="evenodd"
					d="M1.553 6.776a.5.5 0 0 1 .67-.223L8 9.44l5.776-2.888a.5.5 0 1 1 .448.894l-6 3a.5.5 0 0 1-.448 0l-6-3a.5.5 0 0 1-.223-.67z" />
			</svg>
		</div>
		<div class="dropdown-menu" aria-labelledby="dropdownMenuButtonFilter">
			<a class="dropdown-item" href="#">View</a> <a class="dropdown-item"
				href="#">Delete</a>
		</div>
	</div> -->
	<div class="row">
		<%
			for (Banner banner : banners) {
		%>
		<portlet:actionURL name="deleteBannerPortlet"
			var="deleteBannerPortlet">
			<portlet:param name="selectedBannerId"
				value="<%=String.valueOf(banner.getBannerId())%>" />
		</portlet:actionURL>
		<div class="col-md-4 mb-4">
			<div class="card bg-info text-white h-100" style="position:relative;">
				<%
					boolean hasPendingVersion = bannersWithPendingVersions.contains(banner.getBannerId());
				%>
				<% if (!hasPendingVersion) { %>
				<div class="export-checkbox d-none" style="position:absolute; top:10px; left:10px; z-index:10;">
					<input type="checkbox" class="export-banner-checkbox" value="<%=String.valueOf(banner.getBannerId())%>" />
				</div>
				<% } %>
				<div class="card-body d-flex flex-column h-100">
					<div class="icon">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-cloud-check-fill mr-2"
							viewBox="0 0 16 16">
						  <path
								d="M8 2a5.53 5.53 0 0 0-3.594 1.342c-.766.66-1.321 1.52-1.464 2.383C1.266 6.095 0 7.555 0 9.318 0 11.366 1.708 13 3.781 13h8.906C14.502 13 16 11.57 16 9.773c0-1.636-1.242-2.969-2.834-3.194C12.923 3.999 10.69 2 8 2zm2.354 4.854-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 1 1 .708-.708L7 8.793l2.646-2.647a.5.5 0 0 1 .708.708z" />
						</svg>
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-calendar-week-fill"
							viewBox="0 0 16 16">
						  <path
								d="M4 .5a.5.5 0 0 0-1 0V1H2a2 2 0 0 0-2 2v1h16V3a2 2 0 0 0-2-2h-1V.5a.5.5 0 0 0-1 0V1H4V.5zM16 14V5H0v9a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2zM9.5 7h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1a.5.5 0 0 1 .5-.5zm3 0h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1a.5.5 0 0 1 .5-.5zM2 10.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm3.5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1a.5.5 0 0 1 .5-.5z" />
						</svg>
					</div>
					<div class="h2 pt-5">
						<%=banner.getBannerName()%>
						<%
							if (hasPendingVersion) {
						%>
						<span class="badge badge-warning" style="font-size: 0.7rem; vertical-align: middle; background-color: #f0ad4e; margin-left: 8px;">
							Pending Approval
						</span>
						<%
							}
						%>
					</div>
					<div class="mt-auto">
						<div class="dropdown d-flex justify-content-end dropright">
							<button class="btn text-white dropdown-toggle p-0" type="button"
								id="dropdownMenuButton0" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-three-dots-vertical"
									viewBox="0 0 16 16">
							  <path
										d="M9.5 13a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z" />
							</svg>
							</button>
							<div class="dropdown-menu" aria-labelledby="dropdownMenuButton0">
								<%
									if (hasPendingVersion) {
										// Only show View option for banners with pending versions
								%>
								<a class="dropdown-item"
									href="<portlet:actionURL  name="getBannerIdForView" >
											<portlet:param name="selectedBannerId" value="<%=String.valueOf(banner.getBannerId())%>" />
											<portlet:param name="hasPendingVersion" value="true" />
											</portlet:actionURL>">View</a>
								<%
									} else if (isAdministrator || isPo || isMarketing) {
								%>
								<a class="dropdown-item"
									href="<portlet:actionURL  name="getBannerIdForView" >
											<portlet:param name="selectedBannerId" value="<%=String.valueOf(banner.getBannerId())%>" />
											<portlet:param name="hasPendingVersion" value="false" />
											</portlet:actionURL>">View
									/ Update</a> <a class="dropdown-item"
									href="<portlet:renderURL>
										<portlet:param name="myview" value="addContent" />
											<portlet:param name="bannerId" value="<%=String.valueOf(banner.getBannerId())%>" />
											</portlet:renderURL>">Add
									new content</a>
								<button class="dropdown-item"
									onclick="openModal('<%=deleteBannerPortlet%>')">Delete</button>
								<% } else { %>
								<a class="dropdown-item"
									href="<portlet:actionURL  name="getBannerIdForView" >
											<portlet:param name="selectedBannerId" value="<%=String.valueOf(banner.getBannerId())%>" />
											<portlet:param name="hasPendingVersion" value="false" />
											</portlet:actionURL>">View</a>
								<% } %>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<%
			}
		%>
		<% if (isAdministrator || isPo || isMarketing) { %>
		<div class="col-md-2 mb-4">
			<div class="card bg-light text-dark h-100">
				<div class="card-body d-flex flex-column h-100">
					<div class="icon d-flex justify-content-end">
						<a href="<%=add_banner%>">
							<button class="btn p-0">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-plus-lg" viewBox="0 0 16 16">
							  <path fill-rule="evenodd"
										d="M8 2a.5.5 0 0 1 .5.5v5h5a.5.5 0 0 1 0 1h-5v5a.5.5 0 0 1-1 0v-5h-5a.5.5 0 0 1 0-1h5v-5A.5.5 0 0 1 8 2Z" />
							</svg>
							</button>
						</a>
					</div>
					<div class="h2 pt-5 mt-auto">Add Banner</div>
				</div>
			</div>
		</div>
		<% } %>
	</div>

</div>
<style>
.filter {
	border-radius: 2.2rem;
}

.filter.active {
	background: #0b5fff !important;
	color: #fff;
}
</style>
<div class="modal hide fade" id="telemoneyDeleteModal" tabindex="-1"
	role="dialog" aria-labelledby="telemoneyDeleteModalCenteredTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-100" role="document">
		<div class="modal-content w-auto m-auto">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">Delete
					Banner</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body text-5 text-center">Are you sure you
				want to delete this Banner?</div>
			<div class="modal-footer justify-content-end">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary"
					onclick="deleteBanner()">Confirm</button>
			</div>
		</div>
	</div>
</div>
<script>
	var deleteBannerLink = "";
	$(".filter").click(function() {
		$(".filter").removeClass('active');
		$(this).addClass('active');
	});

	/* 	function confirmDelete(bannerId) {
	 var confirmDelete = confirm("Are you sure you want to delete this banner?");

	 if (confirmDelete) {
	 deleteBannerPortlet(bannerId);
	 } else {
	 System.out
	 .println("You can't delete any banner without confirm that");
	 }
	 }

	 function deleteBannerPortlet(bannerId) {
	 var form = document.createElement("form");
	 form.setAttribute("method", "POST");
	 form.setAttribute("action",
	 "<portlet:actionURL name='deleteBannerPortlet' />");

	 var inputBannerId = document.createElement("input");

	 inputBannerId.setAttribute("type", "hidden");
	 inputBannerId.setAttribute("name", "selectedBannerId");
	 inputBannerId.setAttribute("value", bannerId);

	 form.appendChild(inputBannerId);

	 document.body.appendChild(form);
	 form.submit();
	 } */

	function openModal(targetLink) {
		$("#telemoneyDeleteModal").modal("show");
		$("#telemoneyDeleteModal").removeClass("hide");
		deleteBannerLink = targetLink;
	}

	function closeModal() {
		$("#telemoneyDeleteModal").modal("hide");
		$("#telemoneyDeleteModal").addClass("hide");
	}

	function deleteBanner() {
		window.location.href = deleteBannerLink;
	}
	function showURLOption(event) {
		var urlValue = "";
		var currElement = "";
		if (event.target) {
			urlValue = event.target.value;
			currElement = event.target;
		} else {
			urlValue = event.value;
			currElement = event;
		}
		if (urlValue === "internal") {
			currElement.parentElement.nextElementSibling.classList
					.remove("d-none");
			currElement.parentElement.nextElementSibling.nextElementSibling.classList
					.add("d-none");
		} else if (urlValue === "external") {
			currElement.parentElement.nextElementSibling.classList
					.add("d-none");
			currElement.parentElement.nextElementSibling.nextElementSibling.classList
					.remove("d-none");
		}

	}
	/* 	window.onload =()=>{
	 var mySelectElements = document.querySelectorAll(".custom-select.link-type-banner-content");
	 console.log("Loaded")
	 mySelectElements.forEach((select)=>{
	 showURLOption(select);
	 });
	 } */

	// Export mode functions
	var exportMode = false;

	function toggleExportMode() {
		exportMode = true;
		document.getElementById('exportBtn').classList.add('d-none');
		document.getElementById('confirmExportBtn').classList.remove('d-none');
		document.getElementById('cancelExportBtn').classList.remove('d-none');
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
		var checkboxes = document.querySelectorAll('.export-checkbox');
		for (var i = 0; i < checkboxes.length; i++) {
			checkboxes[i].classList.add('d-none');
		}
		var inputs = document.querySelectorAll('.export-banner-checkbox');
		for (var j = 0; j < inputs.length; j++) {
			inputs[j].checked = false;
		}
	}

	function submitExport() {
		var selected = document.querySelectorAll('.export-banner-checkbox:checked');
		if (selected.length === 0) {
			alert('Please select at least one banner to export.');
			return;
		}
		$("#telemoneyExportModal").modal("show");
		$("#telemoneyExportModal").removeClass("hide");
	}

	function confirmExport() {
		var summary = document.getElementById('exportSummary').value.trim();
		var selected = document.querySelectorAll('.export-banner-checkbox:checked');
		var container = document.getElementById('exportBannerIdsContainer');
		container.innerHTML = '';

		for (var i = 0; i < selected.length; i++) {
			var input = document.createElement('input');
			input.type = 'hidden';
			input.name = '<portlet:namespace/>bannerIds';
			input.value = selected[i].value;
			container.appendChild(input);
		}

		var summaryInput = document.createElement('input');
		summaryInput.type = 'hidden';
		summaryInput.name = '<portlet:namespace/>exportSummary';
		summaryInput.value = summary;
		container.appendChild(summaryInput);

		$("#telemoneyExportModal").modal("hide");
		$("#telemoneyExportModal").addClass("hide");

		document.getElementById('exportBannerForm').submit();

		document.getElementById('exportSummary').value = '';
		cancelExportMode();
	}

	function openImportModal() {
		$("#telemoneyImportModal").modal("show");
		$("#telemoneyImportModal").removeClass("hide");
	}
</script>

<!-- Export Summary Modal -->
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

<!-- Hidden form for export -->
<form action="<%=exportBannerURL%>" method="post" id="exportBannerForm" class="d-none">
	<div id="exportBannerIdsContainer"></div>
</form>

<!-- Import Modal (separate JSP) -->
<%@ include file="/importModal.jsp"%>
