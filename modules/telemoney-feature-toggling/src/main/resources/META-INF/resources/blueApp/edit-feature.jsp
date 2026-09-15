<%@ include file="/init.jsp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.ejada.telemony.db.model.LovData"%>
<%@page import="com.ejada.telemony.db.model.Feature"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<portlet:actionURL name="editFeature" var="editFeature">
</portlet:actionURL>
<portlet:renderURL var="backToview">
	<portlet:param name="action" value="view" />
</portlet:renderURL>

<style>
	select.multi-select { display: none; }
</style>

<%
	long featureId = (Long) request.getAttribute("featureId") != null
			? (Long) request.getAttribute("featureId")
			: 0L;

	String featureName = (String) request.getAttribute("featureName") != null
			? (String) request.getAttribute("featureName")
			: "";

	Boolean featureStatus = request.getAttribute("status") != null
			? (Boolean) request.getAttribute("status")
			: false;

	List<LovData> whitelistLovs = request.getAttribute("whitelistLovs") != null
			? (List<LovData>) request.getAttribute("whitelistLovs")
			: new ArrayList<>();

	List<LovData> segmentsLovs = request.getAttribute("segmentsLovs") != null
			? (List<LovData>) request.getAttribute("segmentsLovs")
			: new ArrayList<>();

	List<String> selectedWhitelist = request.getAttribute("selectedWhitelist") != null
			? (List<String>) request.getAttribute("selectedWhitelist")
			: new ArrayList<>();

	List<String> selectedSegments = request.getAttribute("selectedSegments") != null
			? (List<String>) request.getAttribute("selectedSegments")
			: new ArrayList<>();

	boolean hasPendingVersion = request.getAttribute("hasPendingVersion") != null
			? (Boolean) request.getAttribute("hasPendingVersion")
			: false;
	boolean isDisabled = isOther || hasPendingVersion;
%>

<div>
	<h3 class="pb-4">Edit Feature</h3>
	<% if (hasPendingVersion) { %>
	<div class="alert alert-warning" role="alert">
		<strong>Pending Approval:</strong> This feature has a pending change awaiting approval. Editing is disabled until the change is approved or rejected.
	</div>
	<% } %>
	<liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />
	<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
	<liferay-ui:error key="hasPendingVersion" message="This feature has a pending version awaiting approval and cannot be modified." />
	<div class="card">
		<div class="card-body">
			<div class="row">
				<div class="col-md-12">
					<form method="post" action="<%=editFeature%>" id="featureEditForm">
						<fieldset <%= isDisabled ? "disabled" : "" %>>
						<input type="hidden" name="<portlet:namespace/>featureId" value="<%=featureId%>">
						<input type="hidden" name="<portlet:namespace/>hasPendingVersion" value="<%=hasPendingVersion%>">

						<div class="mb-3">
							<label class="form-label">Name</label>
							<input pattern="^[^<>&quot;&#39;]+$"
								title="Special characters like < > ' &quot; are not allowed."
								type="text" class="form-control" id="featureName"
								name="<portlet:namespace/>featureName" value='<%=featureName%>'
								required>
						</div>

						<div class="mb-3">
							<label class="form-label">Whitelist</label>
							<select class="custom-select multi-select" id="whitelist"
								name="<portlet:namespace/>whitelist" multiple required>
								<% for (LovData lov : whitelistLovs) {
									String code = lov.getRecordTypeCode();
									boolean selected = selectedWhitelist.contains(code);
								%>
								<option value="<%=code%>" <%= selected ? "selected" : "" %>><%=code%></option>
								<% } %>
							</select>
						</div>

						<div class="mb-3">
							<label class="form-label">Segments</label>
							<select class="custom-select multi-select" id="segments"
								name="<portlet:namespace/>segments" multiple required>
								<% for (LovData lov : segmentsLovs) {
									String code = lov.getRecordTypeCode();
									boolean selected = selectedSegments.contains(code);
								%>
								<option value="<%=code%>" <%= selected ? "selected" : "" %>><%=code%></option>
								<% } %>
							</select>
						</div>

						<div class="mb-3">
							<label class="form-label">Status</label>
							<select class="custom-select" id="featureStatus"
								name="<portlet:namespace/>featureStatus" required>
								<option value="false" <%= !featureStatus ? "selected" : "" %>>OFF</option>
								<option value="true" <%= featureStatus ? "selected" : "" %>>ON</option>
							</select>
						</div>

						<div class="d-flex justify-content-end">
							<button type="button" class="btn btn-secondary px-5 mr-3"
								onclick="window.location.href='<%=backToview%>'">CANCEL</button>
							<% if (!isDisabled) { %>
							<button type="button" class="btn btn-primary px-5" onclick="openSaveModal()">SAVE</button>
							<% } %>
						</div>
						</fieldset>
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
			<div class="modal-body text-5 text-center">Are you sure you want to save this Feature?</div>
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
		document.getElementById('featureEditForm').submit();
		closeSaveModal();
	}
</script>
<script src="<%=request.getContextPath()%>/js/multiselect-dropdown.js"></script>
