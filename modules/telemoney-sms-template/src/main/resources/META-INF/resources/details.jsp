<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>

<portlet:actionURL name="updateSMS" var="updateSMS">
</portlet:actionURL>

<portlet:renderURL var="cancel_update">
	<portlet:param name="action" value="view" />
</portlet:renderURL>

<%
 String eventCode = (String)request.getAttribute("eventcode") != null
			? (String) request.getAttribute("eventcode")
			: "";
			
 String eventDescription = (String)request.getAttribute("eventdescription") != null
			? (String) request.getAttribute("eventdescription")
			: "";
			
 String serviceId = (String)request.getAttribute("serviceid") != null
			? (String) request.getAttribute("serviceid")
			: "";

 boolean hasPendingVersion = ParamUtil.getBoolean(request, "hasPendingVersion", false);
 boolean isDisabled = isOther || hasPendingVersion;
%>

<div>
	<h3 class="pb-4">SMS templates details</h3>
	<% if (hasPendingVersion) { %>
	<div class="alert alert-warning" role="alert">
		<strong>Pending Approval:</strong> This SMS template has a pending change awaiting approval. Editing is disabled until the change is approved or rejected.
	</div>
	<% } %>
	<liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />	
	<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
	<liferay-ui:error key="hasPendingVersion" message="This SMS template has a pending version awaiting approval and cannot be modified." />

	<div class="card">
		<div class="card-body">
				<liferay-ui:error key="error" message="Error In SMS Update" />
			<form action="<%=updateSMS%>" method="post">
				<fieldset <%= isDisabled ? "disabled" : "" %>>
				<div class="mb-3">
					<label class="form-label">Event Code</label> 
					<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" readonly class="form-control" name="<portlet:namespace/>eventCode" value= "<%=eventCode %>">
				</div>
				<div class="mb-3">
					<label class="form-label">Service ID</label> 
					<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" required class="form-control" name="<portlet:namespace/>serviceId" value= "<%=serviceId %>">
				</div>
				<div class="mb-3">
					<label class="form-label">Event description</label> 
					<textarea pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed."
						class="form-control" required name="<portlet:namespace/>eventDescription" rows="7"><%=eventDescription %></textarea>
				</div>
				</fieldset>
				<div class="d-flex justify-content-end">
					<button type="button"
						onclick="window.location.href='<%=cancel_update%>'"
						class="btn btn-secondary px-5 mr-3"><%= isDisabled ? "BACK" : "CANCEL" %></button>
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
				<h5 class="modal-title" id="exampleModalLongTitle">Update SMS Template</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body text-5 text-center">Are you sure you want to update this SMS template?</div>
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
		var form = document.querySelector('form[action="<%=updateSMS%>"]');
		if (form) {
			form.submit();
		}
	}

	$('#telemoneyUpdateModal').on('hidden.bs.modal', function(e) {
		// Nothing to reset for update
	});
</script>
