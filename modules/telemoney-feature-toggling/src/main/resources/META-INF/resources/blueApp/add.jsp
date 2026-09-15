<%@page import="com.ejada.telemony.db.model.LovData"%>
<%@page import="com.ejada.telemony.db.model.Feature"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ include file="/init.jsp"%>

<portlet:actionURL var="createFeature" name="createFeature">
</portlet:actionURL>

<portlet:renderURL var="backToview">
	<portlet:param name="action" value="view" />
</portlet:renderURL>

<style>
	select.multi-select { display: none; }
</style>

<%
	String featureName = "";
	Boolean featureStatus = null;

	List<LovData> whitelistLovs = request.getAttribute("whitelistLovs") != null
		? (List<LovData>) request.getAttribute("whitelistLovs")
		: new ArrayList<>();

	List<LovData> segmentsLovs = request.getAttribute("segmentsLovs") != null
		? (List<LovData>) request.getAttribute("segmentsLovs")
		: new ArrayList<>();
%>
<div>
	<h3 class="pb-4">Add Feature</h3>
	<liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />
	<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
	<div class="card">
		<div class="card-body">
			<form method="post" action="<%=createFeature%>" id="featureAddForm">
				<fieldset <%= isOther ? "disabled" : "" %>>
				<div class="mb-3">
					<label class="form-label">Feature Name</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text"
						class="form-control" id="featureName"
						name="<portlet:namespace/>featureName" required>
				</div>
				<div class="mb-3">
					<label class="form-label">Whitelist</label>
					<select class="custom-select multi-select" id="whitelist"
						name="<portlet:namespace/>whitelist" multiple required>
						<% for (LovData lov : whitelistLovs) { %>
							<option value="<%=lov.getRecordTypeCode()%>"><%=lov.getRecordTypeCode()%></option>
						<% } %>
					</select>
				</div>
				<div class="mb-3">
					<label class="form-label">Segments</label>
					<select class="custom-select multi-select" id="segments"
						name="<portlet:namespace/>segments" multiple required>
						<% for (LovData lov : segmentsLovs) { %>
							<option value="<%=lov.getRecordTypeCode()%>"><%=lov.getRecordTypeCode()%></option>
						<% } %>
					</select>
				</div>
				<div class="mb-3">
					<label class="form-label">Status</label> <select pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed."
						class="custom-select" id="featureStatus"
						name="<portlet:namespace/>featureStatus" required>
						<option selected>Choose...</option>
						<option value="false">OFF</option>
						<option value="true">ON</option>
					</select>
				</div>
				<div class="d-flex justify-content-end">
					<button type="button" class="btn btn-secondary px-5 mr-3"
						onclick="window.location.href='<%=backToview%>'">CANCEL</button>
					<button type="button" class="btn btn-primary px-5" onclick="openSaveModal()">SAVE</button>
				</div>
				</fieldset>
			</form>
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
		document.getElementById('featureAddForm').submit();
		closeSaveModal();
	}
</script>
<script
	src="<%=request.getContextPath()%>/js/multiselect-dropdown.js"></script>
