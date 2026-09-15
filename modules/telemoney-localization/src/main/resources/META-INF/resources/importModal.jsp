<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<portlet:actionURL name="importLocalization" var="importLocalizationURL" />
<portlet:actionURL name="confirmImportLocalization" var="confirmImportLocalizationURL" />

<%
	// Authorization variables are already defined in init.jsp
	boolean isAuthorized = isAdministrator || isPo || isTranslator;

	// These attributes are set by doView when import data has been parsed
	String importParsedLocalizations = (String) request.getAttribute("importParsedLocalizations");
	String importChannelsData = (String) request.getAttribute("importChannels");
	String importApprovedPagesByChannel = (String) request.getAttribute("importApprovedPagesByChannel");

	// hasPendingImport is already defined in add.jsp
%>

<% if (isAuthorized) { %>
<!-- ==================== FIRST MODAL: File Selection ==================== -->
<div class="modal hide fade" id="telemoneyImportModal" tabindex="-1"
	role="dialog" aria-labelledby="telemoneyImportModalTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered modal-sm" role="document" style="max-width: 450px;">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="telemoneyImportModalTitle">Import Localization</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<form action="<%=importLocalizationURL%>" method="post" enctype="multipart/form-data" id="importLocalizationForm">
				<div class="modal-body">
					<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
					<liferay-ui:error key="import-processing-error" message="Error processing import file. Please check the file format and try again." />
					<div class="form-group">
						<label for="importLocalizationFile">Select a ZIP file to import:</label>
						<input type="file" class="form-control-file" name="<portlet:namespace/>importFile"
							id="importLocalizationFile" accept=".zip" />
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
		<% if (hasPendingImport) { %>
		alert('There is already a pending import request. Please wait for it to be processed.');
		return;
		<% } %>
		$("#telemoneyImportModal").modal("show");
		$("#telemoneyImportModal").removeClass("hide");
	}

	function resetImportModal() {
		document.getElementById('importLocalizationFile').value = '';
	}

	function submitImport() {
		var fileInput = document.getElementById('importLocalizationFile');
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
		document.getElementById('importLocalizationForm').submit();
	}

	$('#telemoneyImportModal').on('hidden.bs.modal', function () {
		resetImportModal();
	});

	// ========== Second Modal (Review) Functions ==========

	// Data passed from server via request attributes
	var importParsedLocalizations = null;
	var importChannels = null;
	var importApprovedPagesByChannel = null;

	// Holds the user's final decisions: array of { index, action, channelId, updatePageId }
	var importUserDecisions = [];

	<% if (importParsedLocalizations != null) { %>
		importParsedLocalizations = <%=importParsedLocalizations%>;
		importChannels = <%=importChannelsData%>;
		importApprovedPagesByChannel = <%=importApprovedPagesByChannel%>;

		$(document).ready(function() {
			openImportReviewModal();
		});
	<% } %>

	function openImportReviewModal() {
		if (!importParsedLocalizations || importParsedLocalizations.length === 0) {
			alert('No localizations found in the imported file.');
			return;
		}
		buildImportReviewUI();
		$("#telemoneyImportReviewModal").modal("show");
		$("#telemoneyImportReviewModal").removeClass("hide");
	}

	function buildImportReviewUI() {
		var body = document.getElementById('importReviewBody');
		body.innerHTML = '';

		for (var i = 0; i < importParsedLocalizations.length; i++) {
			var localization = importParsedLocalizations[i];
			var row = document.createElement('div');
			row.className = 'border rounded p-3 mb-3';
			row.id = 'importLocalizationRow_' + i;

			var html = '';
			html += '<div class="d-flex justify-content-between align-items-center mb-2">';
			html += '  <h5 class="m-0">Localization #' + (i + 1) + '</h5>';
			html += '</div>';

			// Show languages included
			if (localization.languages && localization.languages.length > 0) {
				html += '<p class="text-muted mb-2">Languages: ' + localization.languages.join(', ') + '</p>';
			}

			// Channel selection
			html += '<div class="form-group mb-2">';
			html += '  <label><strong>Select Channel:</strong></label>';
			html += '  <select class="form-control" id="importChannel_' + i + '" onchange="onImportChannelChange(' + i + ')">';
			html += '    <option value="">-- Select Channel --</option>';
			for (var c = 0; c < importChannels.length; c++) {
				var ch = importChannels[c];
				html += '    <option value="' + ch.channelId + '">' + escapeHtml(ch.name) + '</option>';
			}
			html += '  </select>';
			html += '</div>';

			// Page selection container (populated after channel is selected)
			html += '<div id="importPageContainer_' + i + '"></div>';

			row.innerHTML = html;
			body.appendChild(row);
		}
	}

	function onImportChannelChange(index) {
		var channelSelect = document.getElementById('importChannel_' + index);
		var channelId = channelSelect.value;
		var pageContainer = document.getElementById('importPageContainer_' + index);

		pageContainer.innerHTML = '';

		if (!channelId) return;

		var pagesForChannel = importApprovedPagesByChannel[channelId] || [];

		if (pagesForChannel.length === 0) {
			pageContainer.innerHTML = '<p class="text-muted">No pages found for this channel.</p>';
			return;
		}

		var html = '<div class="form-group mb-0">';
		html += '  <label><strong>Select Page to link to:</strong></label>';
		html += '  <select class="form-control" id="importPage_' + index + '">';
		html += '    <option value="">-- Select Page --</option>';
		for (var p = 0; p < pagesForChannel.length; p++) {
			var page = pagesForChannel[p];
			html += '    <option value="' + page.featureId + '">' + escapeHtml(page.name) + '</option>';
		}
		html += '  </select>';
		html += '</div>';
		pageContainer.innerHTML = html;
	}

	function confirmImportReview() {
		importUserDecisions = [];

		for (var i = 0; i < importParsedLocalizations.length; i++) {
			var localization = importParsedLocalizations[i];

			var channelSelect = document.getElementById('importChannel_' + i);
			var channelId = channelSelect ? channelSelect.value : '';
			if (!channelId) {
				alert('Please select a channel for localization #' + (i + 1));
				return;
			}

			var pageSelect = document.getElementById('importPage_' + i);
			var pageId = pageSelect ? pageSelect.value : '';
			if (!pageId) {
				alert('Please select a page for localization #' + (i + 1));
				return;
			}

			var decision = {
				index: localization.index,
				action: 'update',
				channelId: parseInt(channelId),
				updatePageId: parseInt(pageId)
			};

			importUserDecisions.push(decision);
		}

		// Close the review modal
		$("#telemoneyImportReviewModal").modal("hide");
		$("#telemoneyImportReviewModal").addClass("hide");

		// Call portlet action with decisions
		var form = document.createElement('form');
		form.method = 'POST';
		form.action = '<%=confirmImportLocalizationURL%>';

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
		importParsedLocalizations = null;
		importChannels = null;
		importApprovedPagesByChannel = null;
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

