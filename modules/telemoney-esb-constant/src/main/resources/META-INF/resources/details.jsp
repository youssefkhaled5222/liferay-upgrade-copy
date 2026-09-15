<%@ include file="/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>


<%
	String ServiceName = (String) request.getAttribute("serviceName") != null
			? (String) request.getAttribute("serviceName")
			: "";


	String FuncId = (String) request.getAttribute("FuncId") != null ? (String) request.getAttribute("FuncId")
			: "";

	String Ip = (String) request.getAttribute("Ip") != null ? (String) request.getAttribute("Ip") : "";

	String Port = (String) request.getAttribute("Port") != null ? (String) request.getAttribute("Port") : "";

	String eventDescription = (String) request.getAttribute("eventdescription") != null
			? (String) request.getAttribute("eventdescription")
			: "";

	String serviceId = (String) request.getAttribute("serviceid") != null
			? (String) request.getAttribute("serviceid")
			: "";

	String Path = (String) request.getAttribute("Path") != null ? (String) request.getAttribute("Path") : "";

	String SCId = (String) request.getAttribute("SCId") != null ? (String) request.getAttribute("SCId") : "";

	String BranchId = (String) request.getAttribute("BranchId") != null
			? (String) request.getAttribute("BranchId")
			: "";

	String BranchName = (String) request.getAttribute("BranchName") != null
			? (String) request.getAttribute("BranchName")
			: "";

	String UserId = (String) request.getAttribute("UserId") != null ? (String) request.getAttribute("UserId")
			: "";

	String AgentId = (String) request.getAttribute("AgentId") != null ? (String) request.getAttribute("AgentId")
			: "";
	String SecInfo = (String) request.getAttribute("SecInfo") != null ? (String) request.getAttribute("SecInfo")
			: "";
	String SecInfoType = (String) request.getAttribute("SecInfoType") != null
			? (String) request.getAttribute("SecInfoType")
			: "";

	String Version = (String) request.getAttribute("Version") != null ? (String) request.getAttribute("Version")
			: "";

	Boolean hasPendingVersion = (Boolean) request.getAttribute("hasPendingVersion");
	if (hasPendingVersion == null) {
		hasPendingVersion = false;
	}
	boolean isLocked = isOther || hasPendingVersion;
%>

<portlet:actionURL name="updateESB" var="updateESB">
</portlet:actionURL>

<portlet:renderURL var="cancel_update">
	<portlet:param name="action" value="view" />
</portlet:renderURL>

<div>
	<h3 class="pb-4">ESB Constant details</h3>
		    <liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />	
	<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
	<liferay-ui:error key="hasPendingVersion" message="This ESB constant has a pending version and cannot be modified." />

	<% if (hasPendingVersion) { %>
	<div class="alert alert-warning" role="alert">
		<strong>Pending Approval:</strong> This ESB constant has a pending version awaiting approval and cannot be modified.
	</div>
	<% } %>

	<div class="card">
		<div class="card-body">
			<form action="<%=updateESB%>" method="post">
				<input type="hidden" name="<portlet:namespace/>oldFuncId" value="<%=FuncId%>">
				<input type="hidden" name="<portlet:namespace/>oldIp" value="<%=Ip%>">
				<input type="hidden" name="<portlet:namespace/>oldPort" value="<%=Port%>">
				<input type="hidden" name="<portlet:namespace/>oldPath" value="<%=Path%>">
				<input type="hidden" name="<portlet:namespace/>oldSCId" value="<%=SCId%>">
				<input type="hidden" name="<portlet:namespace/>oldBranchId" value="<%=BranchId%>">
				<input type="hidden" name="<portlet:namespace/>oldBranchName" value="<%=BranchName%>">
				<input type="hidden" name="<portlet:namespace/>oldUserId" value="<%=UserId%>">
				<input type="hidden" name="<portlet:namespace/>oldAgentId" value="<%=AgentId%>">
				<input type="hidden" name="<portlet:namespace/>oldSecInfo" value="<%=SecInfo%>">
				<input type="hidden" name="<portlet:namespace/>oldSecInfoType" value="<%=SecInfoType%>">
				<input type="hidden" name="<portlet:namespace/>oldVersion" value="<%=Version%>">
				<fieldset <%= isLocked ? "disabled" : "" %>>
				<div class="mb-3">
					<input type="hidden" class="form-control" id=""
						name="<portlet:namespace/>serviceName" value="<%=ServiceName%>">
				</div>
				<div class="mb-3">
					<label class="form-label">Func ID</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text"
						class="form-control" id="" name="<portlet:namespace/>FuncId"
						value="<%=FuncId%>">
				</div>
				<div class="mb-3">
					<label class="form-label">Ip</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text"
						class="form-control" id="" name="<portlet:namespace/>Ip"
						value="<%=Ip%>">
				</div>
				<div class="mb-3">
					<label class="form-label">Port</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text"
						class="form-control" id="" name="<portlet:namespace/>Port"
						value="<%=Port%>">
				</div>
				<div class="mb-3">
					<label class="form-label">Path</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text"
						class="form-control" id="" name="<portlet:namespace/>Path"
						value="<%=Path%>">
				</div>
				<div class="mb-3">
					<label class="form-label">SC ID</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text"
						class="form-control" id="" name="<portlet:namespace/>SCId"
						value="<%=SCId%>">
				</div>
				<div class="mb-3">
					<label class="form-label">Branch ID</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text"
						class="form-control" id="" name="<portlet:namespace/>BranchId"
						value="<%=BranchId%>">
				</div>
				<div class="mb-3">
					<label class="form-label">Branch name</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text"
						class="form-control" id="" name="<portlet:namespace/>BranchName"
						value="<%=BranchName%>">
				</div>
				<div class="mb-3">
					<label class="form-label">User ID</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text"
						class="form-control" id="" name="<portlet:namespace/>UserId"
						value="<%=UserId%>">
				</div>
				<div class="mb-3">
					<label class="form-label">Agent ID</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text"
						class="form-control" id="" name="<portlet:namespace/>AgentId"
						value="<%=AgentId%>">
				</div>
				<div class="mb-3">
					<label class="form-label">SecInfo</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text"
						class="form-control" id="" name="<portlet:namespace/>SecInfo"
						value="<%=SecInfo%>">
				</div>
				<div class="mb-3">
					<label class="form-label">SecInfo Type</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text"
						class="form-control" id="" name="<portlet:namespace/>SecInfoType"
						value="<%=SecInfoType%>">
				</div>
				<div class="mb-3">
					<label class="form-label">Version</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text"
						class="form-control" id="" name="<portlet:namespace/>Version"
						value="<%=Version%>">
				</div>
				</fieldset>
				<div class="d-flex justify-content-end">
					<button type="button"
						onclick="window.location.href='<%=cancel_update%>'"
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
				<h5 class="modal-title" id="exampleModalLongTitle">Update ESB Constant</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body text-5 text-center">Are you sure you want to update this ESB constant?</div>
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
		var form = document.querySelector('form[action="<%=updateESB%>"]');
		if (form) {
			form.submit();
		}
	}

	$('#telemoneyUpdateModal').on('hidden.bs.modal', function(e) {
		// Nothing to reset for update
	});
</script>
