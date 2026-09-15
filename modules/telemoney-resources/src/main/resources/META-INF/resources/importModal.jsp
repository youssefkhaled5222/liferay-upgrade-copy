<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<portlet:actionURL name="importResource" var="importResourceURL" />
<portlet:actionURL name="confirmImportResource" var="confirmImportResourceURL" />

<%
	// Authorization variables are already defined in init.jsp
	boolean isAuthorized = isAdministrator || isPo;

	// These attributes are set by doView when import data has been parsed
	String importParsedResources = (String) request.getAttribute("importParsedResources");
	String importChannelsData = (String) request.getAttribute("importChannels");
	String importApprovedPagesByChannel = (String) request.getAttribute("importApprovedPagesByChannel");
	String importApprovedResourcesByChannelAndPage = (String) request.getAttribute("importApprovedResourcesByChannelAndPage");
%>

<% if (isAuthorized) { %>
<!-- ==================== FIRST MODAL: File Selection ==================== -->
<div class="modal hide fade" id="telemoneyImportModal" tabindex="-1"
	role="dialog" aria-labelledby="telemoneyImportModalTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered modal-sm" role="document" style="max-width: 450px;">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="telemoneyImportModalTitle">Import Resource</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<form action="<%=importResourceURL%>" method="post" enctype="multipart/form-data" id="importResourceForm">
				<div class="modal-body">
					<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
					<liferay-ui:error key="import-processing-error" message="Error processing import file. Please check the file format and try again." />
					<liferay-ui:error key="no-importable-resources" message="None of the selected resources can be imported. Only attachment resources can be imported into the Blue App channel." />
					<div class="form-group">
						<label for="importResourceFile">Select a ZIP file to import:</label>
						<input type="file" class="form-control-file" name="<portlet:namespace/>importFile"
							id="importResourceFile" accept=".zip" />
					</div>
				</div>
				<div class="modal-footer justify-content-end">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal" onclick="resetImportModal()">Cancel</button>
					<button type="button" class="btn btn-primary"
						onclick="submitImport()">Import</button>
				</div>
			</form>
		</div>
	</div>
</div>

<!-- ==================== SECOND MODAL: Import Review ==================== -->
<div class="modal hide fade" id="telemoneyImportReviewModal" tabindex="-1"
	role="dialog" aria-labelledby="telemoneyImportReviewModalTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document" style="max-width: 600px;">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="telemoneyImportReviewModalTitle">Review Import</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body" id="importReviewBody" style="max-height: 60vh; overflow-y: auto;">
				<!-- Dynamically populated by JavaScript -->
			</div>
			<div class="modal-footer justify-content-end">
				<button type="button" class="btn btn-secondary"
					data-dismiss="modal" onclick="cancelImportReview()">Cancel</button>
				<button type="button" class="btn btn-primary"
					onclick="confirmImportReview()">Confirm</button>
			</div>
		</div>
	</div>
</div>

<script>
	// ========== First Modal Functions ==========
	function openImportModal() {
		$("#telemoneyImportModal").modal("show");
		$("#telemoneyImportModal").removeClass("hide");
	}

	function resetImportModal() {
		document.getElementById('importResourceFile').value = '';
	}

	function submitImport() {
		var fileInput = document.getElementById('importResourceFile');
		if (!fileInput.files || fileInput.files.length === 0) {
			alert('Please select a ZIP file to import.');
			return;
		}

		var file = fileInput.files[0];
		if (!file.name.toLowerCase().endsWith('.zip')) {
			alert('Please select a valid ZIP file.');
			return;
		}

		$("#telemoneyImportModal").modal("hide");
		$("#telemoneyImportModal").addClass("hide");

		// Submit the form; server will parse the ZIP and redirect back
		// The review modal will open automatically on re-render
		document.getElementById('importResourceForm').submit();
	}

	$('#telemoneyImportModal').on('hidden.bs.modal', function () {
		resetImportModal();
	});

	// ========== Second Modal (Review) Functions ==========

	// Data passed from server via request attributes
	var importParsedResources = null;
	var importChannels = null;
	var importApprovedPagesByChannel = null;
	var importApprovedResourcesByChannelAndPage = null;

	// Holds the user's final decisions
	var importUserDecisions = [];

	<% if (importParsedResources != null) { %>
		importParsedResources = <%=importParsedResources%>;
		importChannels = <%=importChannelsData%>;
		importApprovedPagesByChannel = <%=importApprovedPagesByChannel%>;
		importApprovedResourcesByChannelAndPage = <%=importApprovedResourcesByChannelAndPage%>;

		$(document).ready(function() {
			openImportReviewModal();
		});
	<% } %>

	function openImportReviewModal() {
		if (!importParsedResources || importParsedResources.length === 0) {
			alert('No resources found in the imported file.');
			return;
		}
		buildImportReviewUI();
		$("#telemoneyImportReviewModal").modal("show");
		$("#telemoneyImportReviewModal").removeClass("hide");
	}

	function buildImportReviewUI() {
		var body = document.getElementById('importReviewBody');
		body.innerHTML = '';

		for (var i = 0; i < importParsedResources.length; i++) {
			var resource = importParsedResources[i];
			var row = document.createElement('div');
			row.className = 'border rounded p-3 mb-3';
			row.id = 'importResourceRow_' + i;

			var html = '';
			html += '<div class="d-flex justify-content-between align-items-center mb-2">';
			html += '  <h5 class="m-0">' + escapeHtml(resource.name) + '</h5>';
			html += '</div>';

			// Action select
			html += '<div class="form-group mb-2">';
			html += '  <label><strong>Action:</strong></label>';
			html += '  <select class="form-control" id="importAction_' + i + '" onchange="onImportActionChange(' + i + ')">';
			html += '    <option value="">-- Select Action --</option>';
			html += '    <option value="add">Add</option>';
			html += '    <option value="update">Update</option>';
			html += '  </select>';
			html += '</div>';

			// Conditional container (channel, page, resource dropdowns)
			html += '<div id="importActionDetail_' + i + '"></div>';

			row.innerHTML = html;
			body.appendChild(row);
		}
	}

	// Blue App only holds attachment resources ("2"). Any other type can still
	// be routed to it, but it is neglected by the server instead of imported.
	function findImportChannel(channelId) {
		for (var c = 0; c < importChannels.length; c++) {
			if (String(importChannels[c].channelId) === String(channelId)) {
				return importChannels[c];
			}
		}
		return null;
	}

	function isNeglectedForChannel(index, channelId) {
		if (!channelId) return false;
		var channel = findImportChannel(channelId);
		if (!channel || !channel.blueApp) return false;
		return importParsedResources[index].resourceType !== '2';
	}

	function buildImportChannelOptions(index) {
		var html = '<option value="">-- Select Channel --</option>';
		for (var c = 0; c < importChannels.length; c++) {
			var ch = importChannels[c];
			var label = ch.name;
			if (ch.blueApp && importParsedResources[index].resourceType !== '2') {
				label += ' (not an attachment - will be neglected)';
			}
			html += '<option value="' + ch.channelId + '">' + escapeHtml(label) + '</option>';
		}
		return html;
	}

	function neglectedWarningHtml() {
		return '<div class="alert alert-warning py-2 mb-0" role="alert">'
			+ 'Blue App only supports attachment resources, so this resource will be '
			+ 'neglected and will not be imported.'
			+ '</div>';
	}

	function onImportActionChange(index) {
		var actionSelect = document.getElementById('importAction_' + index);
		var detailContainer = document.getElementById('importActionDetail_' + index);
		var action = actionSelect.value;

		detailContainer.innerHTML = '';

		if (action === 'add') {
			// Show channel dropdown then page dropdown
			var html = '<div class="form-group mb-2">';
			html += '  <label><strong>Select Channel:</strong></label>';
			html += '  <select class="form-control" id="importChannel_' + index + '" onchange="onImportChannelChangeForAdd(' + index + ')">';
			html += buildImportChannelOptions(index);
			html += '  </select>';
			html += '</div>';
			html += '<div id="importPageContainerAdd_' + index + '"></div>';
			detailContainer.innerHTML = html;

		} else if (action === 'update') {
			// Show channel dropdown, then page dropdown, then resource dropdown
			var html = '<div class="form-group mb-2">';
			html += '  <label><strong>Select Channel:</strong></label>';
			html += '  <select class="form-control" id="importUpdateChannel_' + index + '" onchange="onImportChannelChangeForUpdate(' + index + ')">';
			html += buildImportChannelOptions(index);
			html += '  </select>';
			html += '</div>';
			html += '<div id="importPageContainerUpdate_' + index + '"></div>';
			html += '<div id="importUpdateResourceContainer_' + index + '"></div>';
			detailContainer.innerHTML = html;
		}
	}

	function onImportChannelChangeForAdd(index) {
		var channelSelect = document.getElementById('importChannel_' + index);
		var channelId = channelSelect.value;
		var pageContainer = document.getElementById('importPageContainerAdd_' + index);

		pageContainer.innerHTML = '';

		if (!channelId) return;

		// A neglected resource is never imported, so there is no page to pick.
		if (isNeglectedForChannel(index, channelId)) {
			pageContainer.innerHTML = neglectedWarningHtml();
			return;
		}

		var pagesForChannel = importApprovedPagesByChannel[channelId] || [];

		if (pagesForChannel.length === 0) {
			pageContainer.innerHTML = '<p class="text-muted">No pages found for this channel.</p>';
			return;
		}

		var html = '<div class="form-group mb-0">';
		html += '  <label><strong>Select Page:</strong></label>';
		html += '  <select class="form-control" id="importPageAdd_' + index + '">';
		html += '    <option value="">-- Select Page --</option>';
		for (var p = 0; p < pagesForChannel.length; p++) {
			var page = pagesForChannel[p];
			html += '    <option value="' + page.featureId + '">' + escapeHtml(page.name) + '</option>';
		}
		html += '  </select>';
		html += '</div>';
		pageContainer.innerHTML = html;
	}

	function onImportChannelChangeForUpdate(index) {
		var channelSelect = document.getElementById('importUpdateChannel_' + index);
		var channelId = channelSelect.value;
		var pageContainer = document.getElementById('importPageContainerUpdate_' + index);
		var resourceContainer = document.getElementById('importUpdateResourceContainer_' + index);

		pageContainer.innerHTML = '';
		resourceContainer.innerHTML = '';

		if (!channelId) return;

		// A neglected resource is never imported, so there is no page to pick.
		if (isNeglectedForChannel(index, channelId)) {
			pageContainer.innerHTML = neglectedWarningHtml();
			return;
		}

		var pagesForChannel = importApprovedPagesByChannel[channelId] || [];

		if (pagesForChannel.length === 0) {
			pageContainer.innerHTML = '<p class="text-muted">No pages found for this channel.</p>';
			return;
		}

		var html = '<div class="form-group mb-2">';
		html += '  <label><strong>Select Page:</strong></label>';
		html += '  <select class="form-control" id="importPageUpdate_' + index + '" onchange="onImportPageChangeForUpdate(' + index + ')">';
		html += '    <option value="">-- Select Page --</option>';
		for (var p = 0; p < pagesForChannel.length; p++) {
			var page = pagesForChannel[p];
			html += '    <option value="' + page.featureId + '">' + escapeHtml(page.name) + '</option>';
		}
		html += '  </select>';
		html += '</div>';
		pageContainer.innerHTML = html;
	}

	function onImportPageChangeForUpdate(index) {
		var channelSelect = document.getElementById('importUpdateChannel_' + index);
		var channelId = channelSelect.value;
		var pageSelect = document.getElementById('importPageUpdate_' + index);
		var pageId = pageSelect.value;
		var resourceContainer = document.getElementById('importUpdateResourceContainer_' + index);

		resourceContainer.innerHTML = '';

		if (!channelId || !pageId) return;

		var resourcesByPage = importApprovedResourcesByChannelAndPage[channelId] || {};
		var resourcesForPage = resourcesByPage[pageId] || [];

		var html = '<div class="form-group mb-0">';
		html += '  <label><strong>Select Resource to update:</strong></label>';
		html += '  <select class="form-control" id="importUpdateResource_' + index + '">';
		if (resourcesForPage.length === 0) {
			html += '    <option value="" disabled selected>-- Not Found --</option>';
		} else {
			html += '    <option value="">-- Select Resource --</option>';
			for (var r = 0; r < resourcesForPage.length; r++) {
				var res = resourcesForPage[r];
				html += '    <option value="' + res.resourceId + '" data-entity-resource-id="' + res.entityResourceId + '">' + escapeHtml(res.name) + '</option>';
			}
		}
		html += '  </select>';
		html += '</div>';
		resourceContainer.innerHTML = html;
	}

	function confirmImportReview() {
		importUserDecisions = [];

		for (var i = 0; i < importParsedResources.length; i++) {
			var resource = importParsedResources[i];
			var actionSelect = document.getElementById('importAction_' + i);
			var action = actionSelect ? actionSelect.value : '';

			if (!action) {
				alert('Please select an action for resource: ' + resource.name);
				return;
			}

			var decision = {
				index: resource.index,
				name: resource.name,
				action: action,
				channelId: 0,
				featureId: 0,
				updateResourceId: 0
			};

			if (action === 'add') {
				var channelSelect = document.getElementById('importChannel_' + i);
				var channelId = channelSelect ? channelSelect.value : '';
				if (!channelId) {
					alert('Please select a channel for resource: ' + resource.name);
					return;
				}
				decision.channelId = parseInt(channelId);

				// Neglected resources carry no page: the server drops them.
				if (isNeglectedForChannel(i, channelId)) {
					importUserDecisions.push(decision);
					continue;
				}

				var pageSelect = document.getElementById('importPageAdd_' + i);
				var pageId = pageSelect ? pageSelect.value : '';
				if (!pageId) {
					alert('Please select a page for resource: ' + resource.name);
					return;
				}
				decision.featureId = parseInt(pageId);

			} else if (action === 'update') {
				var updateChannelSelect = document.getElementById('importUpdateChannel_' + i);
				var updateChannelId = updateChannelSelect ? updateChannelSelect.value : '';
				if (!updateChannelId) {
					alert('Please select a channel for resource: ' + resource.name);
					return;
				}
				decision.channelId = parseInt(updateChannelId);

				// Neglected resources carry no page: the server drops them.
				if (isNeglectedForChannel(i, updateChannelId)) {
					importUserDecisions.push(decision);
					continue;
				}

				var updatePageSelect = document.getElementById('importPageUpdate_' + i);
				var updatePageId = updatePageSelect ? updatePageSelect.value : '';
				if (!updatePageId) {
					alert('Please select a page for resource: ' + resource.name);
					return;
				}
				decision.featureId = parseInt(updatePageId);

				var updateResourceSelect = document.getElementById('importUpdateResource_' + i);
				var updateResourceId = updateResourceSelect ? updateResourceSelect.value : '';
				if (!updateResourceId) {
					alert('Please select a resource to update for: ' + resource.name);
					return;
				}
				decision.updateResourceId = parseInt(updateResourceId);
			}

			importUserDecisions.push(decision);
		}

		// Close the review modal
		$("#telemoneyImportReviewModal").modal("hide");
		$("#telemoneyImportReviewModal").addClass("hide");

		// Call portlet action with decisions
		var form = document.createElement('form');
		form.method = 'POST';
		form.action = '<%=confirmImportResourceURL%>';

		var decisionsInput = document.createElement('input');
		decisionsInput.type = 'hidden';
		decisionsInput.name = '<portlet:namespace/>importDecisions';
		decisionsInput.value = JSON.stringify(importUserDecisions);
		form.appendChild(decisionsInput);

		document.body.appendChild(form);
		form.submit();
	}

	function cancelImportReview() {
		importUserDecisions = [];
		importParsedResources = null;
		importChannels = null;
		importApprovedPagesByChannel = null;
		importApprovedResourcesByChannelAndPage = null;
	}

	$('#telemoneyImportReviewModal').on('hidden.bs.modal', function () {
		// Do not clear decisions here to allow confirmImportReview to use them
	});

	function escapeHtml(text) {
		if (!text) return '';
		var div = document.createElement('div');
		div.appendChild(document.createTextNode(text));
		return div.innerHTML;
	}
</script>
<% } %>

