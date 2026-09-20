<%@ include file="/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>

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

<portlet:renderURL var="back">
	<portlet:param name="action" value="view" />
</portlet:renderURL>

<%
	Long resourceId = (Long) request.getAttribute("resourceId") != null
			? (Long) request.getAttribute("resourceId")
			: 1;

	String action = (String) request.getAttribute("action") != null
			? (String) request.getAttribute("action")
			: "add";

	List<String> languagesNames = (List<String>) request.getAttribute("languagesName") != null
			? (List<String>) request.getAttribute("languagesName")
			: new ArrayList<>();

	// Escaped because the message carries the rejected file name and its
	// reported content type, neither of which the portal controls.
	String errorMsg = (String) request.getAttribute("errorMsg") != null
			? HtmlUtil.escape((String) request.getAttribute("errorMsg"))
			: "";

	Map<String, String> attachfilesName = (Map<String, String>) request.getAttribute("attachfilesName") != null
			? (Map<String, String>) request.getAttribute("attachfilesName")
			: new HashMap<>();

	Map<String, String> attachValues = (Map<String, String>) request.getAttribute("attachValues") != null
			? (Map<String, String>) request.getAttribute("attachValues")
			: new HashMap<>();

	boolean isAdd = action.equals("add");

	Integer resourceStatus = (Integer) request.getAttribute("resourceStatus");
	boolean isPending = (resourceStatus == null)
			|| (resourceStatus.intValue() != WorkflowConstants.STATUS_APPROVED);

	List<com.ejada.telemony.db.model.Feature> pages =
			(List<com.ejada.telemony.db.model.Feature>) request.getAttribute("pages") != null
					? (List<com.ejada.telemony.db.model.Feature>) request.getAttribute("pages")
					: new ArrayList<>();

	long selectedFeatureId = request.getAttribute("selectedFeatureId") != null
			? (Long) request.getAttribute("selectedFeatureId")
			: 0;
%>

<portlet:actionURL name="addBlueAppResource" var="addBlueAppResource">
	<portlet:param name="action" value="add" />
</portlet:actionURL>

<portlet:actionURL name="editBlueAppResource" var="editBlueAppResource">
	<portlet:param name="action" value="update" />
	<portlet:param name="selectedResourceId"
		value="<%=String.valueOf(resourceId)%>" />
</portlet:actionURL>

<%
	String formAction = isAdd ? addBlueAppResource : editBlueAppResource;
%>

<div>
	<h3 class="pb-4"><%= isAdd ? "Add New Resource" : "Resource Details" %></h3>
	<liferay-ui:error key="file-upload-error" message="File upload error. Allowed file types: pdf, doc, docx, jpg, jpeg, svg (max 10 MB)." />
	<liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />
	<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
	<liferay-ui:error key="error" message="<%=errorMsg%>" />
	<div class="card">
		<div class="card-body">
			<form action="<%=formAction%>" method="post"
				enctype="multipart/form-data"
				name="<portlet:namespace/>addUpdateResourceForm"
				id="<portlet:namespace/>addUpdateResourceForm">
				<fieldset <%= isOther ? "disabled" : "" %>>

				<% if (!pages.isEmpty()) { %>
				<div class="form-group row mb-4">
					<label for="pageSelect" class="col-auto col-form-label">Page</label>
					<div class="col-sm-3">
						<select class="form-control" id="pageSelect"
							name="<portlet:namespace/>selectedFeatureId">
							<%
								for (com.ejada.telemony.db.model.Feature featurePage : pages) {
							%>
							<option value="<%=featurePage.getEntityResourceId()%>"
								<%=featurePage.getEntityResourceId() == selectedFeatureId ? "selected" : ""%>><%=featurePage.getFeatureName()%></option>
							<%
								}
							%>
						</select>
					</div>
				</div>
				<% } %>

				<div class="attachments-container">

					<%
						if (languagesNames.size() != 0) {
					%>
					<label class="form-label">Attachments</label>

					<ul class="nav nav-tabs">
						<%
							for (int i = 0; i < languagesNames.size(); i++) {
						%>
						<li><a data-toggle="tab" href="#AttachTab<%=i%>"
							class="nav-link <%=i == 0 ? "active" : ""%>"><%=languagesNames.get(i)%></a></li>
						<%
							}
						%>
					</ul>

					<div class="tab-content">
						<%
							for (int i = 0; i < languagesNames.size(); i++) {
								String language = languagesNames.get(i);

								String storedName = attachfilesName.get(language);
								String storedUrl = attachValues.get(language);

								boolean hasAttachment = (storedUrl != null) && !storedUrl.isEmpty()
										&& (storedName != null) && !storedName.isEmpty();
						%>
						<div id="AttachTab<%=i%>"
							class="tab-pane fade in <%=i == 0 ? "active" : ""%> px-0 pt-3">
							<div class="row blueapp-grid">
								<div class="col-lg-3 col-md-4 col-sm-6 mb-4">
									<div class="card blueapp-card h-100<%=hasAttachment ? " blueapp-card-clickable" : ""%>"
										id="blueAppCard<%=language%>"
										<%=hasAttachment ? "data-href=\"" + HtmlUtil.escapeAttribute(storedUrl) + "\"" : ""%>
										onclick="blueAppOpenCard(event, this)">
										<div class="blueapp-card-preview"
											id="blueAppPreview<%=language%>">
											<%=buildPreviewMarkup(storedUrl, storedName, hasAttachment)%>
										</div>

										<div class="card-body blueapp-card-body">
											<div class="d-flex align-items-start justify-content-between">
												<%-- The card opens the file, so the name is plain text: an
													 anchor would keep pointing at the stored file after a
													 new one is picked. --%>
												<span class="blueapp-card-name<%=hasAttachment ? "" : " text-muted"%>"
													id="blueAppName<%=language%>"
													title="<%=hasAttachment ? HtmlUtil.escapeAttribute(storedName) : ""%>"><%=hasAttachment ? HtmlUtil.escape(storedName) : "No file chosen"%></span>

												<% if (!isOther && !action.equals("view")) { %>
												<div class="dropdown blueapp-card-actions">
													<button class="btn btn-link p-0 text-secondary"
														type="button" data-toggle="dropdown"
														aria-haspopup="true" aria-expanded="false">
														<svg xmlns="http://www.w3.org/2000/svg" width="16"
															height="16" fill="currentColor"
															class="bi bi-three-dots-vertical" viewBox="0 0 16 16">
															<path
																d="M9.5 13a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z" />
														</svg>
													</button>
													<div class="dropdown-menu dropdown-menu-right">
														<a class="dropdown-item"
															onclick="browseBlueAppFile('<%=language%>')">Browse</a>
													</div>
												</div>
												<% } %>
											</div>

											<% if (!isAdd) { %>
											<div class="blueapp-card-status">
												<% if (isPending) { %>
												<span class="label label-warning">Pending</span>
												<% } else { %>
												<span class="label label-success">Approved</span>
												<% } %>
											</div>
											<% } %>
										</div>
									</div>

									<input type="file" class="d-none blueapp-file-input"
										accept=".pdf,.doc,.docx,.jpg,.jpeg,.svg"
										data-language="<%=language%>"
										name="<portlet:namespace/><%=language%>attachFile"
										id="<portlet:namespace/><%=language%>attachFile" />
								</div>
							</div>

							<small class="form-text text-muted">Allowed file types:
								pdf, doc, docx, jpg, jpeg, svg.</small>
						</div>
						<%
							}
						%>
					</div>
					<%
						}
					%>
				</div>
				</fieldset>
				<div class="d-flex justify-content-end mt-3">
					<button type="button" class="btn btn-secondary px-5 mr-3"
						onclick="window.location.href='<%=back%>'"><%= (isOther || action.equals("view")) ? "BACK" : "CANCEL" %></button>
					<% if (!isOther && !action.equals("view")) { %>
					<button type="button" id="submitBtn" class="btn btn-primary px-5">SAVE</button>
					<% } %>
				</div>
			</form>
		</div>
	</div>
</div>

<div class="modal hide fade" id="telemoneyAddUpdateModal" tabindex="-1"
	role="dialog" aria-labelledby="telemoneyAddUpdateModalCenteredTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-100" role="document">
		<div class="modal-content w-auto m-auto">
			<div class="modal-header">
				<h5 class="modal-title" id="addUpdateModalTitle"><%= isAdd ? "Add Resource" : "Update Resource" %></h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body text-5 text-center">
				<%= isAdd ? "Are you sure you want to add this resource?" : "Are you sure you want to update this resource?" %>
			</div>
			<div class="modal-footer justify-content-end">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary"
					onclick="addUpdateResourceConfirm()">Confirm</button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	// The file inputs are hidden: each language card opens its own through the
	// Browse action and then shows the chosen file name.
	function browseBlueAppFile(language) {
		var input = document.getElementById('<portlet:namespace/>' + language + 'attachFile');

		if (input) {
			input.click();
		}
	}

	var blueAppDocumentIcon = '<%=DOCUMENT_ICON%>';

	// The menu handles its own click and must not stop the event, because
	// Bootstrap listens for the dropdown toggle on the document.
	function blueAppHandlesOwnClick(node, card) {
		while (node && (node !== card)) {
			if (node.classList
					&& node.classList.contains('blueapp-card-actions')) {
				return true;
			}

			node = node.parentNode;
		}

		return false;
	}

	function blueAppOpenCard(event, card) {
		if (blueAppHandlesOwnClick(event.target, card)) {
			return;
		}

		var href = card.getAttribute('data-href');

		if (href) {
			window.open(href, '_blank', 'noopener');
		}
	}

	function blueAppRenderPreview(preview, url, fileName) {
		var lower = fileName.toLowerCase();

		if (/\.(jpg|jpeg|png|svg|gif)$/.test(lower)) {
			preview.innerHTML = '<img alt="" src="' + url + '">';
		}
		else if (/\.pdf$/.test(lower)) {
			preview.innerHTML = '<object class="blueapp-card-pdf"'
				+ ' type="application/pdf" data="' + url
				+ '#toolbar=0&navpanes=0&scrollbar=0&view=FitH"></object>';
		}
		else {
			preview.innerHTML = blueAppDocumentIcon;
		}
	}

	$('.blueapp-file-input').on('change', function(e) {
		var language = $(this).data('language');
		var label = document.getElementById('blueAppName' + language);
		var card = document.getElementById('blueAppCard' + language);

		if (!label || !e.target.files || !e.target.files[0]) {
			return;
		}

		var file = e.target.files[0];

		$(label).text(file.name);
		$(label).removeClass('text-muted');
		label.setAttribute('title', file.name);

		// The card must show and open the file just picked, not the stored one
		// it still points at until the form is saved.
		var url = window.URL && window.URL.createObjectURL
			? window.URL.createObjectURL(file) : null;

		if (url && card) {
			var previousUrl = card.getAttribute('data-object-url');

			if (previousUrl && window.URL.revokeObjectURL) {
				window.URL.revokeObjectURL(previousUrl);
			}

			card.setAttribute('data-href', url);
			card.setAttribute('data-object-url', url);
			card.classList.add('blueapp-card-clickable');
		}

		var preview = document.getElementById('blueAppPreview' + language);

		if (preview && url) {
			blueAppRenderPreview(preview, url, file.name);
		}
	})

	$('.nav-tabs a').click(function() {
		$(this).tab('show');
	})

	function openAddUpdateModal() {
		$("#telemoneyAddUpdateModal").modal("show");
		$("#telemoneyAddUpdateModal").removeClass("hide");
	}

	function closeAddUpdateModal() {
		$("#telemoneyAddUpdateModal").modal("hide");
		$("#telemoneyAddUpdateModal").addClass("hide");
	}

	function addUpdateResourceConfirm() {
		$("#<portlet:namespace/>addUpdateResourceForm").submit();
	}

	// The "accept" attribute is only a hint for the file picker: it is bypassed
	// by switching the dialog to "All files". These checks mirror
	// FileValidatorUtil.validateBlueAppAttachmentFile so a rejected file is
	// reported before the form is submitted. The server still validates.
	var blueAppLanguages = [<%
		for (int i = 0; i < languagesNames.size(); i++) {
	%>"<%=languagesNames.get(i)%>"<%=i < (languagesNames.size() - 1) ? "," : ""%><%
		}
	%>];

	var blueAppAllowedExtensions = [ "pdf", "doc", "docx", "jpg", "jpeg", "svg" ];
	var blueAppMaxFileSize = 10 * 1024 * 1024;

	function validateBlueAppAttachments() {
		for (var i = 0; i < blueAppLanguages.length; i++) {
			var language = blueAppLanguages[i];
			var input = document.getElementById('<portlet:namespace/>' + language + 'attachFile');

			if (!input || !input.files || input.files.length === 0) {
				continue;
			}

			var file = input.files[0];
			var fileName = file.name || '';

			if ((fileName.split('.').length - 1) !== 1) {
				alert('The ' + language + ' file name must contain exactly one "." character.');
				input.focus();
				return false;
			}

			var extension = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();

			if (blueAppAllowedExtensions.indexOf(extension) === -1) {
				alert('The ' + language + ' file type "' + extension + '" is not allowed. '
					+ 'Allowed file types: ' + blueAppAllowedExtensions.join(', ') + '.');
				input.focus();
				return false;
			}

			if (file.size > blueAppMaxFileSize) {
				alert('The ' + language + ' file exceeds the maximum allowed size of 10 MB.');
				input.focus();
				return false;
			}
		}

		return true;
	}

	$('#submitBtn').click(function() {
		if (validateBlueAppAttachments()) {
			openAddUpdateModal();
		}
	});
</script>
<style>
.nav-tabs a.active {
	border-bottom-color: #80acff !important;
	border-width: 3px;
}

.blueapp-card {
	/* The menu must not be clipped by the card. */
	overflow: visible;
}

.blueapp-card-clickable {
	cursor: pointer;
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

.blueapp-card-actions .dropdown-item {
	cursor: pointer;
}
</style>

