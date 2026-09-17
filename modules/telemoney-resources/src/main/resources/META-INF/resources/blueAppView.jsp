<%@ include file="/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@page import="com.ejada.telemoney.db.constants.TelemoneyConstants"%>
<%@page import="com.ejada.telemony.db.model.Feature"%>
<%@page import="com.ejada.telemony.db.model.Resource"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<%!
	private boolean isImageAttachment(String attachName) {
		if ((attachName == null) || attachName.isEmpty()) {
			return false;
		}

		String lower = attachName.toLowerCase();

		return lower.endsWith(".jpg") || lower.endsWith(".jpeg")
				|| lower.endsWith(".png") || lower.endsWith(".svg")
				|| lower.endsWith(".gif");
	}

	private static final String DOCUMENT_ICON =
			"<span class=\"blueapp-card-icon\">"
			+ "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"40\" height=\"40\""
			+ " fill=\"currentColor\" viewBox=\"0 0 16 16\">"
			+ "<path d=\"M4 0h5.293A1 1 0 0 1 10 .293L13.707 4a1 1 0 0 1 .293.707V14a2 2"
			+ " 0 0 1-2 2H4a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2zm5.5 1.5v2a1 1 0 0 0 1 1h2l-3-3z\" />"
			+ "</svg></span>";

	/**
	 * Renders the top of a card: the image as a background for pictures, the
	 * embedded first page for PDFs, and the document icon for everything else
	 * and whenever the browser cannot render the file.
	 */
	private String buildPreviewMarkup(String attachUrl, String attachName, boolean hasAttachment) {
		if (!hasAttachment) {
			return DOCUMENT_ICON;
		}

		if (isImageAttachment(attachName)) {

			// Drawn as a background rather than an <img>, because Liferay
			// rewrites an <img> that points at a document into a <picture>
			// carrying its adaptive media sources, and that rewrite was
			// leaving a stray character behind on the card. A background is
			// never rewritten, and covers the preview the same way.
			String cssUrl = attachUrl.replace("'", "%27");

			return "<span class=\"blueapp-card-image\" role=\"img\" aria-label=\""
					+ com.liferay.portal.kernel.util.HtmlUtil.escapeAttribute(attachName)
					+ "\" style=\"background-image: url('"
					+ com.liferay.portal.kernel.util.HtmlUtil.escapeAttribute(cssUrl)
					+ "')\"></span>";
		}

		if (!attachName.toLowerCase().endsWith(".pdf")) {
			return DOCUMENT_ICON;
		}

		// The portal only serves a thumbnail once it has generated one, which
		// needs preview generation to be enabled. Embedding the file instead
		// lets the browser's own PDF viewer draw the first page, and the icon
		// stays as the fallback for a browser that cannot render it.
		return "<object class=\"blueapp-card-pdf\" type=\"application/pdf\" data=\""
				+ com.liferay.portal.kernel.util.HtmlUtil.escapeAttribute(
					attachUrl + "#toolbar=0&navpanes=0&scrollbar=0&view=FitH")
				+ "\">" + DOCUMENT_ICON + "</object>";
	}
%>

<portlet:renderURL var="pageChangeURL" />

<portlet:actionURL name="deleteBlueAppResource" var="deleteBlueAppResource" />
<portlet:actionURL name="searchBlueAppResource" var="searchBlueAppResource" />
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

	// A search that matched nothing must show nothing, not the whole list.
	boolean searchPerformed = Boolean.TRUE.equals(request.getAttribute("searchPerformed"));
%>

<%-- Declared after the scriptlet so the page being viewed can be carried over
	 to the add screen and preselected there. --%>
<portlet:renderURL var="add_resource">
	<portlet:param name="myView" value="add" />
	<portlet:param name="selectedFeatureId"
		value="<%=String.valueOf(selectedFeatureId)%>" />
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
				<form action="${searchBlueAppResource}" method="post">
					<input type="hidden" name="<portlet:namespace/>selectedFeatureId"
						value="<%=String.valueOf(selectedFeatureId)%>" />
					<div class="col-md-12">
						<div class="d-flex align-items-end mb-3">
							<div>
								<label class="form-label">Search By File Name</label>
								<input type="text" name="<portlet:namespace/>searchTerm"
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
			<%
				boolean hasDisplayedResource = false;
			%>
			<div class="row blueapp-grid">
				<%
					if (searchResult != null) {
						List<Resource> listToDisplay = searchPerformed ? searchResult : viewResource;
						for (Resource currentResource : listToDisplay) {
							if (selectedFeatureId > 0 && currentResource.getFeatureId() != selectedFeatureId) {
								continue;
							}

							hasDisplayedResource = true;
							String attachUrl = currentResource
									.getAttach(TelemoneyConstants.LANGUAGE_ENGLISH_NAME);
							String attachName = currentResource
									.getAttachName(TelemoneyConstants.LANGUAGE_ENGLISH_NAME);
							boolean hasAttachment = (attachUrl != null) && !attachUrl.isEmpty()
									&& (attachName != null) && !attachName.isEmpty();
							String displayName = hasAttachment ? attachName : "No file";
							boolean isPending = false;
							if (resourcesWithPending != null && resourcesWithPending.containsKey(currentResource)) {
								Boolean pending = resourcesWithPending.get(currentResource);
								isPending = pending != null && pending;
							}
				%>
				<div class="col-lg-3 col-md-4 col-sm-6 mb-4">
					<div class="card blueapp-card h-100<%=hasAttachment ? " blueapp-card-clickable" : ""%>"
						<%=hasAttachment ? "data-href=\"" + HtmlUtil.escapeAttribute(attachUrl) + "\"" : ""%>
						onclick="blueAppOpenCard(event, this)">
						<div class="blueapp-card-preview">
							<span class="blueapp-card-check export-checkbox-column d-none">
								<input type="checkbox" class="export-resource-checkbox"
									value="<%=currentResource.getResourceId()%>" />
							</span>

							<%=buildPreviewMarkup(attachUrl, attachName, hasAttachment)%>
						</div>

						<div class="card-body blueapp-card-body">
							<div class="d-flex align-items-start justify-content-between">
								<%-- The card opens the file, so the name is plain text. --%>
								<span class="blueapp-card-name<%=hasAttachment ? "" : " text-muted"%>"
									title="<%=HtmlUtil.escapeAttribute(displayName)%>"><%=HtmlUtil.escape(displayName)%></span>

								<div class="dropdown blueapp-card-actions">
									<button class="btn btn-link p-0 text-secondary" type="button"
										data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
											fill="currentColor" class="bi bi-three-dots-vertical"
											viewBox="0 0 16 16">
											<path
												d="M9.5 13a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z" />
										</svg>
									</button>
									<div class="dropdown-menu dropdown-menu-right">
										<% if (isPending) { %>
										<a class="dropdown-item"
											href="<portlet:actionURL name="viewBlueAppResource">
											<portlet:param name="selectedResourceId" value="<%=String.valueOf(currentResource.getResourceId())%>" />
											<portlet:param name="action" value="view" />
											</portlet:actionURL>">View</a>
										<% } else { %>
										<a class="dropdown-item"
											href="<portlet:actionURL name="viewBlueAppResource">
											<portlet:param name="selectedResourceId" value="<%=String.valueOf(currentResource.getResourceId())%>" />
											<portlet:param name="action" value="update" />
											</portlet:actionURL>"><%= isOther ? "View" : "Edit" %></a>

										<% if (!isOther) { %>
										<a onclick="deleteResource('<%=currentResource.getResourceId()%>')"
											class="dropdown-item"> Delete </a>
										<% } %>
										<% } %>
									</div>
								</div>
							</div>

							<div class="blueapp-card-status">
								<% if (isPending) { %>
								<span class="label label-warning">Pending</span>
								<% } else { %>
								<span class="label label-success">Approved</span>
								<% } %>
							</div>
						</div>
					</div>
				</div>
				<%
						}
					}

					if (!hasDisplayedResource) {
				%>
				<div class="col-12">
					<p class="text-secondary text-center my-5">No resources to display.</p>
				</div>
				<%
					}
				%>
			</div>
		</div>
	</div>
</div>

<form action="<%=deleteBlueAppResource%>" method="post"
	name="<portlet:namespace/>resourceDeleteForm"
	id="<portlet:namespace/>resourceDeleteForm">
	<input type="hidden" name="<portlet:namespace/>selectedResourceId"
		id="<portlet:namespace/>selectedResourceId" />
</form>

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

	// The menu and the checkbox handle their own clicks. They must not stop the
	// event from bubbling, because Bootstrap listens for the dropdown toggle on
	// the document, so the card checks the origin instead.
	function blueAppHandlesOwnClick(node, card) {
		while (node && (node !== card)) {
			if (node.classList
					&& (node.classList.contains('blueapp-card-actions')
						|| node.classList.contains('blueapp-card-check'))) {
				return true;
			}

			node = node.parentNode;
		}

		return false;
	}

	// A card opens its file, except while picking resources for an export,
	// where clicking it selects instead.
	function blueAppOpenCard(event, card) {
		if (blueAppHandlesOwnClick(event.target, card)) {
			return;
		}

		if (exportMode) {
			var checkbox = card.querySelector('.export-resource-checkbox');

			if (checkbox) {
				checkbox.checked = !checkbox.checked;
			}

			return;
		}

		var href = card.getAttribute('data-href');

		if (href) {
			window.open(href, '_blank', 'noopener');
		}
	}

	function clearForm() {
		document.getElementById('searchInput').value = '';

		// Clearing drops the search, not the page being viewed.
		window.location.href = '<%=pageChangeURL%>'
			+ '&<portlet:namespace/>selectedFeatureId=<%=String.valueOf(selectedFeatureId)%>';
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
		$("#telemoneyExportModal").modal("show");
		$("#telemoneyExportModal").removeClass("hide");
	}

	function confirmExport() {
		var summary = document.getElementById('exportSummary').value.trim();

		var selected = document.querySelectorAll('.export-resource-checkbox:checked');
		var exportForm = document.getElementById('exportResourceForm');
		var container = document.getElementById('exportResourceIdsContainer');
		container.innerHTML = '';

		for (var i = 0; i < selected.length; i++) {
			var input = document.createElement('input');
			input.type = 'hidden';
			input.name = '<portlet:namespace/>resourceIds';
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

		exportForm.submit();

		document.getElementById('exportSummary').value = '';
		cancelExportMode();
	}
</script>

<style>
.blueapp-card-clickable {
	cursor: pointer;
}

.blueapp-card {
	/* The menu must not be clipped by the card. */
	overflow: visible;
}

.blueapp-card-preview {
	align-items: center;
	/* Holds no text, so nothing the portal may inject can show through. */
	font-size: 0;
	background-color: #fff;
	border-bottom: 1px solid rgba(0, 0, 0, 0.08);
	display: flex;
	height: 160px;
	justify-content: center;
	overflow: hidden;
	position: relative;
}

.blueapp-card-image {
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	display: block;
	height: 100%;
	width: 100%;
}

.blueapp-card-preview img {
	height: 100%;
	object-fit: cover;
	width: 100%;
}

.blueapp-card-pdf {
	border: 0;
	height: 100%;
	pointer-events: none;
	width: 100%;
}

.blueapp-card-icon {
	color: #9aa3ab;
}

.blueapp-card-check {
	left: 0.5rem;
	position: absolute;
	top: 0.5rem;
}

.blueapp-card-body {
	padding: 0.5rem 0.75rem;
}

.blueapp-card-name {
	display: block;
	line-height: 1.3;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}

.blueapp-card-status {
	margin-top: 0.25rem;
}

.blueapp-card-actions {
	flex-shrink: 0;
	margin-left: 0.5rem;
}

.blueapp-card-actions .btn:focus {
	box-shadow: none;
}
</style>

<!-- Hidden form for export -->
<form action="<%=exportResourceURL%>" method="post" id="exportResourceForm" class="d-none">
	<div id="exportResourceIdsContainer"></div>
</form>

<!-- Import Modal (separate JSP) -->
<%@ include file="/importModal.jsp"%>
