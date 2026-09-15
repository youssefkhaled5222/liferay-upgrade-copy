<%@page import="com.ejada.telemoney.ivr.events.dto.IvrEventObject"%>
<%@ include file="/init.jsp"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>


<%
	
	IvrEventObject ivrEventInfo = (IvrEventObject) request.getAttribute("ivrEventInfo") != null
			? (IvrEventObject) request.getAttribute("ivrEventInfo")
					: new IvrEventObject();

	Boolean hasPendingVersion = (Boolean) request.getAttribute("hasPendingVersion");
	if (hasPendingVersion == null) {
		hasPendingVersion = false;
	}
	boolean isLocked = isOther || hasPendingVersion;
%>

<portlet:actionURL var="updateIvrEvent" name="updateIvrEvent">
</portlet:actionURL>

<portlet:renderURL var="backToview">
    <portlet:param name="action" value="view" />
</portlet:renderURL>

<div>
	<h3 class="pb-4">IVR Event details</h3>
			    <liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />
	<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
	<liferay-ui:error key="hasPendingVersion" message="This IVR event has a pending version and cannot be modified." />

	<% if (hasPendingVersion) { %>
	<div class="alert alert-warning" role="alert">
		<strong>Pending Approval:</strong> This IVR event has a pending version awaiting approval and cannot be modified.
	</div>
	<% } %>

	<div class="card">
		<div class="card-body">
			<form method="post" action="<%=updateIvrEvent%>">
				<input type="hidden" name="<portlet:namespace/>oldEventCode" value="<%=ivrEventInfo.getEventCode()%>" >
				<input type="hidden" name="<portlet:namespace/>oldEventName" value="<%=ivrEventInfo.getEventName()%>" >
		         <input type="hidden" name="<portlet:namespace/>oldEventClass" value="<%=ivrEventInfo.getEventClass()%>" >
				<input type="hidden" name="<portlet:namespace/>oldEventSubClass" value="<%=ivrEventInfo.getEventSubClass()%>" >
				<input type="hidden" name="<portlet:namespace/>oldEventType" value="<%=ivrEventInfo.getEventType()%>" >
				<input type="hidden" name="<portlet:namespace/>oldEventSource" value="<%=ivrEventInfo.getEventSource()%>" >


				<fieldset <%= isLocked ? "disabled" : "" %>>
				<div class="mb-3">
					<label class="form-label">Event code</label> 
					<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id="" name="<portlet:namespace/>eventCode" required
								value="<%=ivrEventInfo.getEventCode()%>" readonly>
				</div>
				<div class="mb-3">
					<label class="form-label">Event name</label> 
					<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id="" name="<portlet:namespace/>eventName" required
								value="<%=ivrEventInfo.getEventName()%>" >
				</div>
				<div class="mb-3">
					<label class="form-label">Event class</label> 
					<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id="" name="<portlet:namespace/>eventClass" required
								value="<%=ivrEventInfo.getEventClass()%>" >
				</div>
				<div class="mb-3">
					<label class="form-label">Event sub-class</label> 
					<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id="" name="<portlet:namespace/>eventSubClass" required
								value="<%=ivrEventInfo.getEventSubClass()%>" >
				</div>
				<div class="mb-3">
					<label class="form-label">Event version</label> 
					<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id="" name="<portlet:namespace/>eventVersion" required
								value="<%=ivrEventInfo.getEventVersion()%>" disabled>
				</div>
				<div class="mb-3">
					<label class="form-label">Event type</label> 
					<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id="" name="<portlet:namespace/>eventType" required
								value="<%=ivrEventInfo.getEventType()%>" >
				</div>
				<div class="mb-3">
					<label class="form-label">Event source</label> 
					<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id="" name="<portlet:namespace/>eventSource" required
								value="<%=ivrEventInfo.getEventSource()%>" >
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
				<h5 class="modal-title" id="exampleModalLongTitle">Update IVR Event</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body text-5 text-center">Are you sure you want to update this IVR event?</div>
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
		var form = document.querySelector('form[action="<%=updateIvrEvent%>"]');
		if (form) {
			form.submit();
		}
	}

	$('#telemoneyUpdateModal').on('hidden.bs.modal', function(e) {
		// Nothing to reset for update
	});
</script>
