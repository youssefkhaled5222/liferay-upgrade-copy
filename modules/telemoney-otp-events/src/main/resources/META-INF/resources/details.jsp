<%@page import="com.ejada.telemoney.otp.events.DTO.OtpEventDTO"%>
<%@ include file="/init.jsp"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>


<%
	
OtpEventDTO otpEventInfo = (OtpEventDTO) request.getAttribute("otpEventInfo") != null
			? (OtpEventDTO) request.getAttribute("otpEventInfo")
					: new OtpEventDTO();

	Boolean hasPendingVersion = (Boolean) request.getAttribute("hasPendingVersion");
	if (hasPendingVersion == null) {
		hasPendingVersion = false;
	}
	boolean isLocked = isOther || hasPendingVersion;
%>

<portlet:actionURL var="updateOtpEvent" name="updateOtpEvent">
</portlet:actionURL>

<portlet:renderURL var="backToview">
    <portlet:param name="action" value="view" />
</portlet:renderURL>

<div>
	<h3 class="pb-4">OTP details</h3>
	<liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />	
	<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
	<liferay-ui:error key="hasPendingVersion" message="This OTP event has a pending version and cannot be modified." />

	<% if (hasPendingVersion) { %>
	<div class="alert alert-warning" role="alert">
		<strong>Pending Approval:</strong> This OTP event has a pending version awaiting approval and cannot be modified.
	</div>
	<% } %>

	<div class="card">
		<div class="card-body">
			<form method="post" action="<%=updateOtpEvent%>">
				<input type="hidden" name="<portlet:namespace/>oldEventCode" value="<%=otpEventInfo.getEventCode()%>">
				<input type="hidden" name="<portlet:namespace/>oldEventDescription" value="<%=otpEventInfo.getEventDescription()%>">
				<input type="hidden" name="<portlet:namespace/>oldEventReasonAr" value="<%=otpEventInfo.getEventReasonAr()%>">
				<input type="hidden" name="<portlet:namespace/>oldEventReasonEn" value="<%=otpEventInfo.getEventReasonEn()%>">

				<fieldset <%= isLocked ? "disabled" : "" %>>
				<div class="mb-3">
					<label class="form-label">Event code</label> 
					<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" name="<portlet:namespace/>eventCode" required
								value="<%=otpEventInfo.getEventCode()%>" readonly>
				</div>
				<div class="mb-3">
					<label class="form-label">Event Description</label> 
					<textarea pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." class="form-control" name="<portlet:namespace/>eventDescription" required rows="7">
					    <%=otpEventInfo.getEventDescription()%>
					</textarea>
				</div>
				<div class="mb-3">
					<label class="form-label">Event reason (en)</label> 
					<textarea pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." class="form-control" name="<portlet:namespace/>eventReasonAr" required rows="7">
					    <%=otpEventInfo.getEventReasonAr()%>
					</textarea>
					
				</div>
				<div class="mb-3">
					<label class="form-label">Event reason (ar)</label> 
					<textarea pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." class="form-control" name="<portlet:namespace/>eventReasonEn" required rows="7">
					    <%=otpEventInfo.getEventReasonEn()%>
					</textarea>
					
				</div>
				</fieldset>
				<div class="d-flex justify-content-end">
					<button type="button"
						onclick="window.location.href='<%=backToview%>'"
						class="btn btn-secondary px-5 mr-3"><%= isLocked ? "BACK" : "CANCEL" %></button>
					<% if (!isLocked) { %>
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
				<h5 class="modal-title" id="exampleModalLongTitle">Update OTP Event</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body text-5 text-center">Are you sure you want to update this OTP event?</div>
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
		var form = document.querySelector('form[action="<%=updateOtpEvent%>"]');
		if (form) {
			form.submit();
		}
	}

	$('#telemoneyUpdateModal').on('hidden.bs.modal', function(e) {
		// Nothing to reset for update
	});
</script>
