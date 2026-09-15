<%@ include file="/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

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

	String errorMsg = (String) request.getAttribute("errorMsg") != null
			? (String) request.getAttribute("errorMsg")
			: "";

	Map<String, String> nameValues = (Map<String, String>) request.getAttribute("nameValues") != null
			? (Map<String, String>) request.getAttribute("nameValues")
			: new HashMap<>();

	Map<String, String> attachfilesName = (Map<String, String>) request.getAttribute("attachfilesName") != null
			? (Map<String, String>) request.getAttribute("attachfilesName")
			: new HashMap<>();

	Map<String, String> attachValues = (Map<String, String>) request.getAttribute("attachValues") != null
			? (Map<String, String>) request.getAttribute("attachValues")
			: new HashMap<>();

	boolean isAdd = action.equals("add");

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
	<liferay-ui:error key="file-upload-error" message="File upload error" />
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

				<div class="attachments-container">

					<%
						if (languagesNames.size() != 0) {
					%>
					<ul class="nav nav-tabs">
						<%
							for (int i = 0; i < languagesNames.size(); i++) {
						%>
						<li><a data-toggle="tab" href="#AttachTab<%=i%>"
							class="nav-link  <%=i == 0 ? "active" : ""%>"><%=languagesNames.get(i)%></a></li>
						<%
							}
						%>
					</ul>
					<div class="tab-content">
						<%
							for (int i = 0; i < languagesNames.size(); i++) {
						%>
						<div id="AttachTab<%=i%>"
							class="tab-pane fade in <%=i == 0 ? "active" : ""%> px-0">
							<div class="mb-3">
								<label class="form-label">Name</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text"
									name="<portlet:namespace/><%=languagesNames.get(i)%>attachName"
									id="<portlet:namespace/><%=languagesNames.get(i)%>attachName"
									value="<%=(nameValues.get(languagesNames.get(i)) != null)
							? nameValues.get(languagesNames.get(i))
							: ""%>"
									class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Attachments</label>
								<div class="input-group">
									<div class="w-100">
										<input type="file" class="custom-file-input"
											accept=".pdf,.doc,.docx,.jpg,.jpeg,.svg"
											onchange="$('.<%=languagesNames.get(i)%>lang-file-name').html(this.files[0].name)"
											name="<portlet:namespace/><%=languagesNames.get(i)%>attachFile"
											id="<portlet:namespace/><%=languagesNames.get(i)%>attachFile"
											value="<%=(attachValues.get(languagesNames.get(i)) != null)
							? attachValues.get(languagesNames.get(i))
							: ""%>" />
										<label
											class="custom-file-label <%=languagesNames.get(i)%>lang-file-name"
											name="<portlet:namespace/><%=languagesNames.get(i)%>custom-file-label"
											id="<portlet:namespace/><%=languagesNames.get(i)%>custom-file-label"
											for="inputGroupFile01"><%=(attachfilesName.get(languagesNames.get(i)) != null)
							? attachfilesName.get(languagesNames.get(i))
							: "Choose file"%> </label>
									</div>
								</div>
								<small class="form-text text-muted">Allowed file types:
									pdf, doc, docx, jpg, jpeg, svg.</small>
							</div>
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
	$('.custom-file-input').on('change', function(e) {
		var fileName = 'Choose file';
		if (e.target.files[0]) {
			fileName = e.target.files[0].name;
			$(this).next('.custom-file-label').html(fileName);
		} else {
			$(this).next('.custom-file-label').html(fileName);
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

	$('#submitBtn').click(function() {
		openAddUpdateModal();
	});
</script>
<style>
.nav-tabs a.active {
	border-bottom-color: #80acff !important;
	border-width: 3px;
}
</style>

