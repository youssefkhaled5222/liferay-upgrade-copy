<%@ include file="/init.jsp"%>
<%@page import="com.ejada.telemony.db.service.SegmentLocalServiceUtil"%>
<%@page import="com.ejada.telemony.db.model.Segment"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>



<%
	long featureId = (Long) request.getAttribute("featureId") != null
			? (Long) request.getAttribute("featureId")
			: 0L;
	long segmentId = (Long) request.getAttribute("segmentId") != null
			? (Long) request.getAttribute("segmentId")
			: 0L;

	String segmentName = (String) request.getAttribute("segmentName") != null
			? (String) request.getAttribute("segmentName")
			: "";
	Boolean segmentStatus = request.getAttribute("segmentStatus") != null
			? (Boolean) request.getAttribute("segmentStatus")
			: false;
	String blockMethod = (String) request.getAttribute("blockMethod") != null
			? (String) request.getAttribute("blockMethod")
			: "";
	String popUpTitle = (String) request.getAttribute("popUpTitle") != null
			? (String) request.getAttribute("popUpTitle")
			: "";
	String popUpSubTitle = (String) request.getAttribute("popUpSubTitle") != null
			? (String) request.getAttribute("popUpSubTitle")
			: "";

	boolean hasPendingVersion = request.getAttribute("hasPendingVersion") != null
			? (Boolean) request.getAttribute("hasPendingVersion")
			: false;
	boolean isDisabled = isOther || hasPendingVersion;
%>

<portlet:actionURL name="editSegment" var="editSegment">
</portlet:actionURL>
<portlet:renderURL var="backToeditfeature">
	<portlet:param name="action" value="edit-feature" />
	<portlet:param name="featureId" value="<%=String.valueOf(featureId)%>" />
</portlet:renderURL>


<div>
	<h3 class="pb-4">Edit Customer Program</h3>
	<% if (hasPendingVersion) { %>
	<div class="alert alert-warning" role="alert">
		<strong>Pending Approval:</strong> This segment has a pending change awaiting approval. Editing is disabled until the change is approved or rejected.
	</div>
	<% } %>
	<liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />
	<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
	<liferay-ui:error key="hasPendingVersion" message="This segment has a pending version awaiting approval and cannot be modified." />
	<div class="card">
		<div class="card-body">
			<div class="row">
				<div class="col-md-12">
					<form method="post" action="<%=editSegment%>" id="segmentEditForm">
						<fieldset <%= isDisabled ? "disabled" : "" %>>
						<div class="mb-3">
							<input type="hidden" name="<portlet:namespace/>featureId"
								value="<%=featureId%>"> <input type="hidden"
								name="<portlet:namespace/>segmentId" value="<%=segmentId%>">
							<input type="hidden" name="<portlet:namespace/>segmentName"
								value="<%=segmentName%>">
							<input type="hidden" name="<portlet:namespace/>hasPendingVersion" value="<%=hasPendingVersion%>">
						</div>
						<div class="mb-3">
							<label class="form-label">Segment Name</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text"
								class="form-control" id="segmentName" value='<%=segmentName%>'
								disabled required>
						</div>
						<div class="mb-3">
							<label class="form-label">Status</label> <select pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed."
								class="custom-select" id="status"
								name="<portlet:namespace/>segmentStatus">
								<%
									if (segmentStatus == true) {
								%>
								<option value="true" selected>ON</option>
								<option value="false">OFF</option>
								<%
									} else {
								%>
								<option value="false" selected>OFF</option>
								<option value="true">ON</option>
								<%
									}
								%>
							</select>
						</div>
						<div class="mb-3">
							<label class="form-label">Method</label> <select pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed."
								class="custom-select methodComponent" id="method"
								name="<portlet:namespace/>blockMethod">
								<option value="0" <%=blockMethod.equals("0") ? "selected" : ""%>>Hide</option>
								<option value="1" <%=blockMethod.equals("1") ? "selected" : ""%>>Disable</option>
								<option value="2" <%=blockMethod.equals("2") ? "selected" : ""%>>Pop
									up</option>
							</select>
						</div>
						<div class="popUpComponent" id="popUpComponent">
							<div class="mb-3">
								<label class="form-label">Pop-up Title</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed."
									type="text" class="form-control " id="popupTitle"
									name="<portlet:namespace/>popUpTitle" value='<%=popUpTitle%>'
									required>
							</div>
							<div class="mb-3">
								<label class="form-label">Pop-up SubTitle</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed."
									type="text" class="form-control" id="popupSubTitle"
									name="<portlet:namespace/>popUpSubTitle"
									value='<%=popUpSubTitle%>' required>
							</div>
						</div>
						</fieldset>
						<div class="d-flex justify-content-end mt-3">
							<button type="button" class="btn btn-secondary px-5 mr-3"
								onclick="window.location.href='<%=backToeditfeature%>'"><%= isDisabled ? "BACK" : "CANCEL" %></button>
							<% if (!isDisabled) { %>
							<button type="button" class="btn btn-primary px-5" onclick="openSaveModal()">SAVE</button>
							<% } %>
						</div>
					</form>
				</div>
			</div>

		</div>
	</div>
</div>

<!-- Save Confirmation Modal -->
<div class="modal hide fade" id="telemoneySaveModal" tabindex="-1"
	role="dialog" aria-labelledby="telemoneySaveModalTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-100" role="document">
		<div class="modal-content w-auto m-auto">
			<div class="modal-header">
				<h5 class="modal-title" id="telemoneySaveModalTitle">Confirm Save</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body text-5 text-center">Are you sure you want to save this Segment?</div>
			<div class="modal-footer justify-content-end">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
				<button type="button" class="btn btn-primary" onclick="confirmSave()">Save</button>
			</div>
		</div>
	</div>
</div>

<script>
	function openSaveModal() {
		$("#telemoneySaveModal").modal("show");
		$("#telemoneySaveModal").removeClass("hide");
	}

	function closeSaveModal() {
		$("#telemoneySaveModal").modal("hide");
		$("#telemoneySaveModal").addClass("hide");
	}

	function confirmSave() {
		document.getElementById('segmentEditForm').submit();
		closeSaveModal();
	}
</script>

<script>
	var statusSelect = document.getElementById('status');
	var methodDropdown = document.getElementById("method");
	var popUpComponent = document.getElementById("popUpComponent");
	var popupTitleInput = document.getElementById("popupTitle");
	var popupSubTitleInput = document.getElementById("popupSubTitle");

	statusSelect.addEventListener('change', function() {
		if (statusSelect.value === 'true') {
			methodDropdown.disabled = true;
			popupTitleInput.disabled = true;
			popupSubTitleInput.disabled = true;
			$('.popUpComponent').hide();
		} else {
			methodDropdown.disabled = false;
			popupTitleInput.disabled = false;
			popupSubTitleInput.disabled = false;
			if (methodDropdown.value === "2") {
				$('.popUpComponent').show();
			}
		}
	});

	if (statusSelect.value === 'true') {
		methodDropdown.disabled = true;
		popupTitleInput.disabled = true;
		popupSubTitleInput.disabled = true;
		$('.popUpComponent').hide();
	} else {
		methodDropdown.disabled = false;
		popupTitleInput.disabled = false;
		popupSubTitleInput.disabled = false;
		if (methodDropdown.value === "2") {
			$('.popUpComponent').show();
		}
	}

	methodDropdown.addEventListener("change", function() {
		if (methodDropdown.value === "2") {
			popupTitleInput.removeAttribute("disabled");
			popupSubTitleInput.removeAttribute("disabled");
			$('.popUpComponent').show();
		} else {
			popupTitleInput.setAttribute("disabled", "disabled");
			popupSubTitleInput.setAttribute("disabled", "disabled");
			$('.popUpComponent').hide();
		}
	});

	if (methodDropdown.value === "2") {
		popupTitleInput.removeAttribute("disabled");
		popupSubTitleInput.removeAttribute("disabled");
		$('.popUpComponent').show();
	} else {
		popupTitleInput.setAttribute("disabled", "disabled");
		popupSubTitleInput.setAttribute("disabled", "disabled");
		$('.popUpComponent').hide();
	}
</script>