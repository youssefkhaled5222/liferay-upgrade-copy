<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>

<portlet:actionURL name="importBanner" var="importBannerURL" />
<portlet:actionURL name="confirmImportBanner" var="confirmImportBannerURL" />

<%
	// Authorization variables are already defined in init.jsp
	boolean isAuthorized = isAdministrator || isPo || isMarketing;

	String importParsedBanners = (String) request.getAttribute("importParsedBanners");
	String importChannels = (String) request.getAttribute("importChannels");
	String importApprovedPersonasByChannel = (String) request.getAttribute("importApprovedPersonasByChannel");
	String importApprovedBannersByChannel = (String) request.getAttribute("importApprovedBannersByChannel");
%>

<% if (isAuthorized) { %>
<!-- ==================== FIRST MODAL: File Selection ==================== -->
<div class="modal hide fade" id="telemoneyImportModal" tabindex="-1"
	role="dialog" aria-labelledby="telemoneyImportModalTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered modal-sm" role="document" style="max-width: 450px;">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="telemoneyImportModalTitle">Import Banner</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<form action="<%=importBannerURL%>" method="post" enctype="multipart/form-data" id="importBannerForm">
				<div class="modal-body">
					<div class="form-group">
						<label for="importBannerFile">Select a ZIP file to import:</label>
						<input type="file" class="form-control-file" name="<portlet:namespace/>importFile"
							id="importBannerFile" accept=".zip" />
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
	<div class="modal-dialog modal-dialog-centered" role="document" style="max-width: 650px;">
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
		document.getElementById('importBannerFile').value = '';
	}

	function submitImport() {
		var fileInput = document.getElementById('importBannerFile');
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

		document.getElementById('importBannerForm').submit();
	}

	$('#telemoneyImportModal').on('hidden.bs.modal', function () {
		resetImportModal();
	});

	// ========== Second Modal (Review) Functions ==========

	var importParsedBanners = null;
	var importChannels = null;
	var importApprovedPersonasByChannel = null;
	var importApprovedBannersByChannel = null;

	var importUserDecisions = [];

	<% if (importParsedBanners != null) { %>
		importParsedBanners = <%=importParsedBanners%>;
		importChannels = <%=importChannels%>;
		importApprovedPersonasByChannel = <%=importApprovedPersonasByChannel%>;
		importApprovedBannersByChannel = <%=importApprovedBannersByChannel%>;

		$(document).ready(function() {
			openImportReviewModal();
		});
	<% } %>

	function openImportReviewModal() {
		if (!importParsedBanners || importParsedBanners.length === 0) {
			alert('No banners found in the imported file.');
			return;
		}
		buildImportReviewUI();
		$("#telemoneyImportReviewModal").modal("show");
		$("#telemoneyImportReviewModal").removeClass("hide");
	}

	function buildImportReviewUI() {
		var body = document.getElementById('importReviewBody');
		body.innerHTML = '';

		for (var i = 0; i < importParsedBanners.length; i++) {
			var banner = importParsedBanners[i];
			var row = document.createElement('div');
			row.className = 'border rounded p-3 mb-3';
			row.id = 'importBannerRow_' + i;

			var html = '';
			html += '<div class="d-flex justify-content-between align-items-center mb-2">';
			html += '  <h5 class="m-0">' + escapeHtml(banner.name) + '</h5>';
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

			// Conditional container
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
			var html = '<div class="form-group mb-2">';
			html += '  <label><strong>Select Channel to add to:</strong></label>';
			html += '  <select class="form-control" id="importChannel_' + index + '" onchange="onImportChannelChangeForPersona(' + index + ', \'add\')">';
			html += '    <option value="">-- Select Channel --</option>';
			for (var c = 0; c < importChannels.length; c++) {
				var ch = importChannels[c];
				html += '    <option value="' + ch.channelId + '">' + escapeHtml(ch.name) + '</option>';
			}
			html += '  </select>';
			html += '</div>';
			html += '<div id="importPersonaContainer_' + index + '"></div>';
			detailContainer.innerHTML = html;

		} else if (action === 'update') {
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
			html += '<div id="importUpdateBannerContainer_' + index + '"></div>';
			html += '<div id="importPersonaContainer_' + index + '"></div>';
			detailContainer.innerHTML = html;
		}
	}

	function onImportChannelChangeForPersona(index, action) {
		var channelId;
		if (action === 'add') {
			channelId = document.getElementById('importChannel_' + index).value;
		} else {
			channelId = document.getElementById('importUpdateChannel_' + index).value;
		}
		var personaContainer = document.getElementById('importPersonaContainer_' + index);
		personaContainer.innerHTML = '';

		if (!channelId) return;

		var personasForChannel = importApprovedPersonasByChannel[channelId] || [];

		if (personasForChannel.length === 0) {
			personaContainer.innerHTML = '<p class="text-muted">No approved personas found for this channel.</p>';
			return;
		}

		var html = '<div class="form-group mb-0">';
		html += '  <label><strong>Select Persona(s):</strong></label>';
		html += '  <div class="border rounded p-2" style="max-height: 150px; overflow-y: auto;">';
		for (var p = 0; p < personasForChannel.length; p++) {
			var persona = personasForChannel[p];
			html += '    <div class="form-check">';
			html += '      <input class="form-check-input import-persona-checkbox-' + index + '" type="checkbox" value="' + persona.personaId + '" id="importPersona_' + index + '_' + persona.personaId + '">';
			html += '      <label class="form-check-label" for="importPersona_' + index + '_' + persona.personaId + '">' + escapeHtml(persona.name) + '</label>';
			html += '    </div>';
		}
		html += '  </div>';
		html += '</div>';
		personaContainer.innerHTML = html;
	}

	function onImportUpdateChannelChange(index) {
		var channelSelect = document.getElementById('importUpdateChannel_' + index);
		var channelId = channelSelect.value;
		var bannerContainer = document.getElementById('importUpdateBannerContainer_' + index);
		var personaContainer = document.getElementById('importPersonaContainer_' + index);

		bannerContainer.innerHTML = '';
		personaContainer.innerHTML = '';

		if (!channelId) return;

		var bannersForChannel = importApprovedBannersByChannel[channelId] || [];

		if (bannersForChannel.length === 0) {
			bannerContainer.innerHTML = '<p class="text-muted">No approved banners found for this channel.</p>';
			return;
		}

		var html = '<div class="form-group mb-2">';
		html += '  <label><strong>Select Banner to update:</strong></label>';
		html += '  <select class="form-control" id="importUpdateBanner_' + index + '">';
		html += '    <option value="">-- Select Banner --</option>';
		for (var b = 0; b < bannersForChannel.length; b++) {
			var bn = bannersForChannel[b];
			html += '    <option value="' + bn.bannerId + '">' + escapeHtml(bn.name) + '</option>';
		}
		html += '  </select>';
		html += '</div>';
		bannerContainer.innerHTML = html;

		// Also show persona multiselect
		onImportChannelChangeForPersona(index, 'update');
	}

	function confirmImportReview() {
		importUserDecisions = [];

		for (var i = 0; i < importParsedBanners.length; i++) {
			var banner = importParsedBanners[i];
			var actionSelect = document.getElementById('importAction_' + i);
			var action = actionSelect ? actionSelect.value : '';

			if (!action) {
				alert('Please select an action for banner: ' + banner.name);
				return;
			}

			var decision = {
				index: banner.index,
				name: banner.name,
				action: action,
				channelId: 0,
				updateBannerId: 0,
				personaIds: []
			};

			if (action === 'add') {
				var channelSelect = document.getElementById('importChannel_' + i);
				var channelId = channelSelect ? channelSelect.value : '';
				if (!channelId) {
					alert('Please select a channel for banner: ' + banner.name);
					return;
				}
				decision.channelId = parseInt(channelId);

			} else if (action === 'update') {
				var updateChannelSelect = document.getElementById('importUpdateChannel_' + i);
				var updateChannelId = updateChannelSelect ? updateChannelSelect.value : '';
				if (!updateChannelId) {
					alert('Please select a channel for banner: ' + banner.name);
					return;
				}
				decision.channelId = parseInt(updateChannelId);

				var updateBannerSelect = document.getElementById('importUpdateBanner_' + i);
				var updateBannerId = updateBannerSelect ? updateBannerSelect.value : '';
				if (!updateBannerId) {
					alert('Please select a banner to update for: ' + banner.name);
					return;
				}
				decision.updateBannerId = parseInt(updateBannerId);
			}

			// Collect selected persona IDs
			var personaCheckboxes = document.querySelectorAll('.import-persona-checkbox-' + i + ':checked');
			for (var j = 0; j < personaCheckboxes.length; j++) {
				decision.personaIds.push(parseInt(personaCheckboxes[j].value));
			}

			importUserDecisions.push(decision);
		}

		// Close the review modal
		$("#telemoneyImportReviewModal").modal("hide");
		$("#telemoneyImportReviewModal").addClass("hide");

		// Submit decisions to server
		var form = document.createElement('form');
		form.method = 'POST';
		form.action = '<%=confirmImportBannerURL%>';

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
		importParsedBanners = null;
		importChannels = null;
		importApprovedPersonasByChannel = null;
		importApprovedBannersByChannel = null;
	}

	$('#telemoneyImportReviewModal').on('hidden.bs.modal', function () {
		// Do not clear decisions here
	});

	function escapeHtml(text) {
		if (!text) return '';
		var div = document.createElement('div');
		div.appendChild(document.createTextNode(text));
		return div.innerHTML;
	}
</script>
<% } %>

