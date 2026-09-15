<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui" %>

<portlet:renderURL var="cancel_update">
	<portlet:param name="action" value="view" />
</portlet:renderURL>
<portlet:actionURL name="UpdateMoiService" var="UpdateMoiService">
</portlet:actionURL>

<%
String billerId  = (String)request.getAttribute("billerId");
String billerCode  = (String)request.getAttribute("billerCode");
String billerName  = (String)request.getAttribute("billerName");

// Get hasPendingVersion flag from request
Boolean hasPendingVersionObj = (Boolean)request.getAttribute("hasPendingVersion");
boolean hasPendingVersion = hasPendingVersionObj != null ? hasPendingVersionObj : false;

// Disable editing if pending version exists or if user is "other" role
boolean isDisabled = isOther || hasPendingVersion;
%>
<div>
	<h3 class="pb-4">
		<% if (hasPendingVersion) { %>
		View MOI Biller
		<span class="badge badge-warning ml-2" style="font-size: 0.65rem; vertical-align: middle; background-color: #f0ad4e;">
			Pending Approval - View Only
		</span>
		<% } else { %>
		<%= isOther ? "View" : "Edit" %> MOI Biller
		<% } %>
	</h3>
	<liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />
	<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
	<liferay-ui:error key="hasPendingVersion" message="This MOI biller has a pending version awaiting approval and cannot be modified." />

	<% if (hasPendingVersion) { %>
	<div class="alert alert-warning" role="alert" style="background-color: #fff3cd; border-color: #ffeaa7; color: #856404;">
		<strong>Pending Approval:</strong> This MOI biller has changes pending approval. You cannot make edits until the pending changes are reviewed.
	</div>
	<% } %>
	<div class="card">
		<div class="card-body">
			<form  action="<%=UpdateMoiService%>" method="post">
				<!-- Hidden fields for old values -->
				<input type="hidden" name="<portlet:namespace/>oldBillerId" value="<%=billerId %>">
				<input type="hidden" name="<portlet:namespace/>oldBillerCode" value="<%=billerCode %>">
				<input type="hidden" name="<portlet:namespace/>oldBillerName" value="<%=billerName %>">


				<fieldset <%= isDisabled ? "disabled" : "" %>>
				<div class="mb-3">
					<label class="form-label">Biller ID</label> 
					<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id=""
					name="<portlet:namespace/>billerId" 
					value="<%=billerId %>">
				</div>
				<div class="mb-3">
					<label class="form-label">Biller code</label> 
					<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id=""
					name="<portlet:namespace/>billerCode" 
					value="<%=billerCode %>">
				</div>
				<div class="mb-3">
					<label class="form-label">Biller name</label> 
					<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id=""
					name="<portlet:namespace/>billerName" 
					value="<%=billerName %>">
				</div>
				</fieldset>
				<div class="d-flex justify-content-end">
					<button type="button"
						onclick="window.location.href='<%=cancel_update%>'"
						class="btn btn-secondary px-5 mr-3">BACK</button>
					<% if (!isDisabled) { %>
					<button type="button" class="btn btn-primary px-5" onclick="showUpdateConfirmation()">Update</button>
					<% } %>
				</div>
			</form>
		</div>
	</div>
</div>

<!-- Update Confirmation Modal -->
<div class="modal hide fade" id="telemoneyUpdateModal" tabindex="-1"
	role="dialog" aria-labelledby="telemoneyUpdateModalCenteredTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-100" role="document">
		<div class="modal-content w-auto m-auto">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">Update MOI Biller</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body text-5 text-center">Are you sure you want to update this MOI biller?</div>
			<div class="modal-footer justify-content-end">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary" onclick="confirmUpdate()">Confirm</button>
			</div>
		</div>
	</div>
</div>

<script>
	function showUpdateConfirmation() {
		$("#telemoneyUpdateModal").modal("show");
		$("#telemoneyUpdateModal").removeClass("hide");
	}

	function confirmUpdate() {
		// Find the form and submit it
		var form = document.querySelector('form[action="<%=UpdateMoiService%>"]');
		if (form) {
			form.submit();
		}
	}

	$('#telemoneyUpdateModal').on('hidden.bs.modal', function(e) {
		// Nothing to reset for update
	});

// Prevent form submission if user tries to bypass disabled state through developer tools
document.addEventListener('DOMContentLoaded', function() {
	const form = document.querySelector('form[action*="UpdateMoiService"]');
	if (form && <%= isDisabled %>) {
		form.addEventListener('submit', function(e) {
			e.preventDefault();
			alert('This MOI biller cannot be modified due to pending approval or insufficient permissions.');
			return false;
		});
	}
});
</script>
