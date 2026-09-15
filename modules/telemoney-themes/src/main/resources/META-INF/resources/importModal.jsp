<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<portlet:actionURL name="importTheme" var="importThemeURL" />
<portlet:actionURL name="confirmImportTheme" var="confirmImportThemeURL" />

<%
	// Authorization variables are already defined in init.jsp
	boolean isAuthorized = isAdministrator || isPo || isMarketing;

	// These attributes are set by doView when import data has been parsed
	String importParsedThemes = (String) request.getAttribute("importParsedThemes");
	String importChannels = (String) request.getAttribute("importChannels");
	String importApprovedThemesByChannel = (String) request.getAttribute("importApprovedThemesByChannel");
%>

<% if (isAuthorized) { %>
<!-- ==================== FIRST MODAL: File Selection ==================== -->
<div class="modal hide fade" id="telemoneyImportModal" tabindex="-1"
	role="dialog" aria-labelledby="telemoneyImportModalTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered modal-sm" role="document" style="max-width: 450px;">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="telemoneyImportModalTitle">Import Theme</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<form action="<%=importThemeURL%>" method="post" enctype="multipart/form-data" id="importThemeForm">
				<div class="modal-body">
					<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
					<liferay-ui:error key="import-processing-error" message="Error processing import file. Please check the file format and try again." />
					<div class="form-group">
						<label for="importThemeFile">Select a ZIP file to import:</label>
						<input type="file" class="form-control-file" name="<portlet:namespace/>importFile"
							id="importThemeFile" accept=".zip" />
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
		document.getElementById('importThemeFile').value = '';
	}

	function submitImport() {
		var fileInput = document.getElementById('importThemeFile');
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
		document.getElementById('importThemeForm').submit();
	}

	$('#telemoneyImportModal').on('hidden.bs.modal', function () {
		resetImportModal();
	});

	// ========== Second Modal (Review) Functions ==========

	// Data passed from server via request attributes
	var importParsedThemes = null;
	var importChannels = null;
	var importApprovedThemesByChannel = null;

	// Holds the user's final decisions: array of { index, name, action, channelId, updateThemeId }
	var importUserDecisions = [];

	<% if (importParsedThemes != null) { %>
		importParsedThemes = <%=importParsedThemes%>;
		importChannels = <%=importChannels%>;
		importApprovedThemesByChannel = <%=importApprovedThemesByChannel%>;

		$(document).ready(function() {
			openImportReviewModal();
		});
	<% } %>

	function openImportReviewModal() {
		if (!importParsedThemes || importParsedThemes.length === 0) {
			alert('No themes found in the imported file.');
			return;
		}
		buildImportReviewUI();
		$("#telemoneyImportReviewModal").modal("show");
		$("#telemoneyImportReviewModal").removeClass("hide");
	}

	function buildImportReviewUI() {
		var body = document.getElementById('importReviewBody');
		body.innerHTML = '';

		for (var i = 0; i < importParsedThemes.length; i++) {
			var theme = importParsedThemes[i];
			var row = document.createElement('div');
			row.className = 'border rounded p-3 mb-3';
			row.id = 'importThemeRow_' + i;

			var html = '';
			html += '<div class="d-flex justify-content-between align-items-center mb-2">';
			html += '  <h5 class="m-0">' + escapeHtml(theme.name) + '</h5>';
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

			// Conditional container (channel dropdown for Add, theme dropdown for Update)
			html += '<div id="importActionDetail_' + i + '"></div>';

			row.innerHTML = html;
			body.appendChild(row);
		}
	}

	function onImportActionChange(index) {
		var actionSelect = document.getElementById('importAction_' + index);
		var detailContainer = document.getElementById('importActionDetail_' + index);
		var action = actionSelect.value;

		detailContainer.innerHTML = '';

		if (action === 'add') {
			// Show dropdown of approved channels
			var html = '<div class="form-group mb-0">';
			html += '  <label><strong>Select Channel to add to:</strong></label>';
			html += '  <select class="form-control" id="importChannel_' + index + '">';
			html += '    <option value="">-- Select Channel --</option>';
			for (var c = 0; c < importChannels.length; c++) {
				var ch = importChannels[c];
				html += '    <option value="' + ch.channelId + '">' + escapeHtml(ch.name) + '</option>';
			}
			html += '  </select>';
			html += '</div>';
			detailContainer.innerHTML = html;

		} else if (action === 'update') {
			// Show dropdown: first pick channel, then pick existing theme to update
			var html = '<div class="form-group mb-2">';
			html += '  <label><strong>Select Channel:</strong></label>';
			html += '  <select class="form-control" id="importUpdateChannel_' + index + '" onchange="onImportUpdateChannelChange(' + index + ')">';
			html += '    <option value="">-- Select Channel --</option>';
			for (var c = 0; c < importChannels.length; c++) {
				var ch = importChannels[c];
				html += '    <option value="' + ch.channelId + '">' + escapeHtml(ch.name) + '</option>';
			}
			html += '  </select>';
			html += '</div>';
			html += '<div id="importUpdateThemeContainer_' + index + '"></div>';
			detailContainer.innerHTML = html;
		}
	}

	function onImportUpdateChannelChange(index) {
		var channelSelect = document.getElementById('importUpdateChannel_' + index);
		var channelId = channelSelect.value;
		var themeContainer = document.getElementById('importUpdateThemeContainer_' + index);

		themeContainer.innerHTML = '';

		if (!channelId) return;

		var themesForChannel = importApprovedThemesByChannel[channelId] || [];

		// Filter themes to match the dark/light mode of the imported theme
		var importedTheme = importParsedThemes[index];
		var importedIsDark = importedTheme.isDarkTheme;
		var filteredThemes = [];
		for (var t = 0; t < themesForChannel.length; t++) {
			var th = themesForChannel[t];
			if (th.isDarkTheme === importedIsDark) {
				filteredThemes.push(th);
			}
		}

		if (filteredThemes.length === 0) {
			var modeLabel = importedIsDark ? 'dark' : 'light';
			themeContainer.innerHTML = '<p class="text-muted">No approved ' + modeLabel + ' themes found for this channel.</p>';
			return;
		}

		var html = '<div class="form-group mb-0">';
		html += '  <label><strong>Select Theme to update:</strong></label>';
		html += '  <select class="form-control" id="importUpdateTheme_' + index + '">';
		html += '    <option value="">-- Select Theme --</option>';
		for (var t = 0; t < filteredThemes.length; t++) {
			var th = filteredThemes[t];
			html += '    <option value="' + th.themeId + '" data-entity-resource-id="' + th.entityResourceId + '">' + escapeHtml(th.name) + '</option>';
		}
		html += '  </select>';
		html += '</div>';
		themeContainer.innerHTML = html;
	}

	function confirmImportReview() {
		importUserDecisions = [];

		for (var i = 0; i < importParsedThemes.length; i++) {
			var theme = importParsedThemes[i];
			var actionSelect = document.getElementById('importAction_' + i);
			var action = actionSelect ? actionSelect.value : '';

			if (!action) {
				alert('Please select an action for theme: ' + theme.name);
				return;
			}

			var decision = {
				index: theme.index,
				name: theme.name,
				action: action,
				channelId: 0,
				updateThemeId: 0
			};

			if (action === 'add') {
				var channelSelect = document.getElementById('importChannel_' + i);
				var channelId = channelSelect ? channelSelect.value : '';
				if (!channelId) {
					alert('Please select a channel for theme: ' + theme.name);
					return;
				}
				decision.channelId = parseInt(channelId);

			} else if (action === 'update') {
				var updateChannelSelect = document.getElementById('importUpdateChannel_' + i);
				var updateChannelId = updateChannelSelect ? updateChannelSelect.value : '';
				if (!updateChannelId) {
					alert('Please select a channel for theme: ' + theme.name);
					return;
				}
				decision.channelId = parseInt(updateChannelId);

				var updateThemeSelect = document.getElementById('importUpdateTheme_' + i);
				var updateThemeId = updateThemeSelect ? updateThemeSelect.value : '';
				if (!updateThemeId) {
					alert('Please select a theme to update for: ' + theme.name);
					return;
				}
				decision.updateThemeId = parseInt(updateThemeId);
			}

			importUserDecisions.push(decision);
		}

		// Close the review modal
		$("#telemoneyImportReviewModal").modal("hide");
		$("#telemoneyImportReviewModal").addClass("hide");

		// The importUserDecisions variable now holds all user choices
		console.log('Import user decisions:', JSON.stringify(importUserDecisions));

		// Call portlet action with decisions
		var form = document.createElement('form');
		form.method = 'POST';
		form.action = '<%=confirmImportThemeURL%>';

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
		importParsedThemes = null;
		importChannels = null;
		importApprovedThemesByChannel = null;
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

