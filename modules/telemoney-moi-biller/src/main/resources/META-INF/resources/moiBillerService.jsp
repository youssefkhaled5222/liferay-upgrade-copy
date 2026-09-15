<%@page import="com.ejada.telemoney.db.domain.model.MoiSubServiceDTO"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@ include file="/init.jsp"%>
<%@taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<%
	List<MoiSubServiceDTO> items = request.getAttribute("records") != null
			? (List<MoiSubServiceDTO>) request.getAttribute("records")
			: new ArrayList();

	String billerName = request.getAttribute("billerName") != null
			? (String) request.getAttribute("billerName")
			: "";
	String billerId = request.getAttribute("billerId") != null ? (String) request.getAttribute("billerId") : "";
	boolean parentHasPendingVersion = (Boolean) request.getAttribute("parentHasPendingVersion");
	Set<String> pendingMoiServiceIds = (Set<String>) request.getAttribute("pendingMoiServiceIds");

%>

<portlet:actionURL name="getUpdateMoiSubServiceData"
	var="getUpdateMoiSubServiceData">
</portlet:actionURL>

<portlet:actionURL name="openSubServiceField" var="openSubServiceField">
</portlet:actionURL>
<portlet:actionURL name="deleteMoiSubService" var="deleteMoiSubService">
</portlet:actionURL>

<div>
	<div class="d-flex pb-4 align-items-center">
		<h3 class="m-0">MOI Biller service</h3>
						    <liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />	
		<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
		<liferay-ui:error key="hasPendingVersion" message="This MOI biller has a pending version awaiting approval and cannot be modified." />

	</div>
	<div class="card">
		<div class="card-body">
			<div class="row">
				<div class="col-md-6">
					<div class="d-flex align-items-end mb-3">
						<div>
							<label class="form-label">Search</label> <input type="text"
								class="form-control" id="">
						</div>
						<div class="d-flex">
							<button type="submit" class="btn btn-primary px-5 ml-3">Search</button>
							<button type="submit" class="btn btn-link px-5 ml-3">Cancel</button>
						</div>
					</div>
				</div>
			</div>
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Biller name <span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">Service ID <span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">Service code <span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">Service name <span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (MoiSubServiceDTO record : items) {
								boolean hasPendingVersion = parentHasPendingVersion || pendingMoiServiceIds.contains(String.valueOf(record.getId()));

						%>
						<tr>
							<td><%=billerName%></td>
							<td><%=record.getId()%></td>
							<td><%=record.getSubServiceCode()%></td>
							<td><%=record.getSubServiceName()%>
								<% if (hasPendingVersion) { %>
								<span class="badge badge-warning" style="font-size: 0.7rem; vertical-align: middle; background-color: #f0ad4e; margin-left: 8px;">
									Pending Approval
								</span>
								<% } %>
							</td>
							<td>
								<div class="dropdown">
									<button class="btn btn-secondary dropdown-toggle" type="button"
										id="dropdownMenuButton" data-toggle="dropdown"
										aria-haspopup="true" aria-expanded="false">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
											fill="currentColor" class="bi bi-three-dots-vertical"
											viewBox="0 0 16 16">
								  <path
												d="M9.5 13a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z" />
								</svg>
									</button>
									<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
										<a
											href=<portlet:actionURL name="openSubServiceField" >
										 			<portlet:param name="billerName" value="<%=billerName%>" />
										 			<portlet:param name="serviceName" value="<%=record.getSubServiceName()%>" />
										 			<portlet:param name="subServiceId" value="<%=String.valueOf(record.getId())%>" />
													<portlet:param name="billerId" value="<%=billerId%>" />
													<portlet:param name="parentHasPendingVersion" value="<%= String.valueOf(hasPendingVersion) %>" />
											  </portlet:actionURL>
											class="dropdown-item">View Field</a> 
											
											<% if (hasPendingVersion) { %>
												<a
													href=<portlet:actionURL name="getUpdateMoiSubServiceData" >
															<portlet:param name="subServiceId" value="<%=String.valueOf(record.getId())%>" />
															<portlet:param name="subServiceCode" value="<%=record.getSubServiceCode()%>" />
															<portlet:param name="subServiceName" value="<%=record.getSubServiceName()%>" />
															<portlet:param name="billerName" value="<%=billerName%>" />
															<portlet:param name="billerId" value="<%=billerId%>" />
															<portlet:param name="moiServiceId" value="<%=billerId%>" />
															<portlet:param name="parentHasPendingVersion" value="<%= String.valueOf(parentHasPendingVersion) %>" />
															<portlet:param name="hasPendingVersion" value="<%= String.valueOf(hasPendingVersion) %>" />
														</portlet:actionURL>
													class="dropdown-item"> View </a>
											<% } else { %>
												<a
													href=<portlet:actionURL name="getUpdateMoiSubServiceData" >
															<portlet:param name="subServiceId" value="<%=String.valueOf(record.getId())%>" />
															<portlet:param name="subServiceCode" value="<%=record.getSubServiceCode()%>" />
															<portlet:param name="subServiceName" value="<%=record.getSubServiceName()%>" />
															<portlet:param name="billerName" value="<%=billerName%>" />
															<portlet:param name="billerId" value="<%=billerId%>" />
															<portlet:param name="moiServiceId" value="<%=billerId%>" />
															<portlet:param name="parentHasPendingVersion" value="<%= String.valueOf(parentHasPendingVersion) %>" />
															<portlet:param name="hasPendingVersion" value="<%= String.valueOf(hasPendingVersion) %>" />
														</portlet:actionURL>
													class="dropdown-item"> Edit </a>
													<a class="dropdown-item"
														onclick="deleteMoiService('<%=String.valueOf(record.getId())%>', '<%=record.getSubServiceCode()%>', '<%=record.getSubServiceName()%>', '<%=billerId%>', '<%=billerName%>')">Delete</a>
											<% } %>
									</div>
								</div>
							</td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<!-- Delete Form - Outside the loop to avoid duplicate IDs -->
<form action="<%=deleteMoiSubService%>" method="post"
	name="<portlet:namespace/>moiServiceDeleteForm"
	id="<portlet:namespace/>moiServiceDeleteForm">
	<input type="hidden" name="<portlet:namespace/>subBillerId" id="<portlet:namespace/>subBillerId" />
	<input type="hidden" name="<portlet:namespace/>oldSubServiceId" id="<portlet:namespace/>oldSubServiceId" />
	<input type="hidden" name="<portlet:namespace/>oldSubServiceCode" id="<portlet:namespace/>oldSubServiceCode" />
	<input type="hidden" name="<portlet:namespace/>oldSubServiceName" id="<portlet:namespace/>oldSubServiceName" />
	<input type="hidden" name="<portlet:namespace/>oldMoiServiceId" id="<portlet:namespace/>oldMoiServiceId" />
	<input type="hidden" name="<portlet:namespace/>oldBillerName" id="<portlet:namespace/>oldBillerName" />
</form>

<div class="modal hide fade" id="telemoneyDeleteModal" tabindex="-1"
	role="dialog" aria-labelledby="telemoneyDeleteModalCenteredTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-100" role="document">
		<div class="modal-content w-auto m-auto">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">Delete
					MoiService</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body text-5 text-center">Are you sure you
				want to delete this MoiService?</div>
			<div class="modal-footer justify-content-end">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="submit" class="btn btn-primary"
					onclick="deleteMoiServiceConfirm()">Confirm</button>
			</div>
		</div>
	</div>
</div>
<script>
	function deleteMoiService(subServiceId, subServiceCode, subServiceName, moiServiceId, billerName) {
		// Set the ID for deletion
		var subBillerIdField = document.getElementById('<portlet:namespace/>subBillerId');
		subBillerIdField.value = subServiceId;

		// Set old values for workflow comparison
		var oldSubServiceIdField = document.getElementById('<portlet:namespace/>oldSubServiceId');
		oldSubServiceIdField.value = subServiceId;

		var oldSubServiceCodeField = document.getElementById('<portlet:namespace/>oldSubServiceCode');
		oldSubServiceCodeField.value = subServiceCode;

		var oldSubServiceNameField = document.getElementById('<portlet:namespace/>oldSubServiceName');
		oldSubServiceNameField.value = subServiceName;

		var oldMoiServiceIdField = document.getElementById('<portlet:namespace/>oldMoiServiceId');
		oldMoiServiceIdField.value = moiServiceId;

		var oldBillerNameField = document.getElementById('<portlet:namespace/>oldBillerName');
		oldBillerNameField.value = billerName;


		openModal();
	}

	function deleteMoiServiceConfirm() {
		document.getElementById('<portlet:namespace/>moiServiceDeleteForm')
				.submit();
	}

	function resetDelete() {
		document.getElementById('<portlet:namespace/>subBillerId').value = "";
		document.getElementById('<portlet:namespace/>oldSubServiceId').value = "";
		document.getElementById('<portlet:namespace/>oldSubServiceCode').value = "";
		document.getElementById('<portlet:namespace/>oldSubServiceName').value = "";
		document.getElementById('<portlet:namespace/>oldMoiServiceId').value = "";
		document.getElementById('<portlet:namespace/>oldBillerName').value = "";
	}

	function openModal() {
		$("#telemoneyDeleteModal").modal("show");
		$("#telemoneyDeleteModal").removeClass("hide");
	}

	function closeModal() {
		$("#telemoneyDeleteModal").modal("hide");
		$("#telemoneyDeleteModal").addClass("hide");
	}

	$('#telemoneyDeleteModal').on('hidden.bs.modal', function(e) {
		resetDelete();
	})
	$('th').click(
			function() {
				var table = $(this).parents('table').eq(0)
				var rows = table.find('tr:gt(0)').toArray().sort(
						comparer($(this).index()))
				this.asc = !this.asc
				if (!this.asc) {
					rows = rows.reverse()
				}
				for (var i = 0; i < rows.length; i++) {
					table.append(rows[i])
				}
			})
	function comparer(index) {
		return function(a, b) {
			var valA = getCellValue(a, index), valB = getCellValue(b, index)
			return $.isNumeric(valA) && $.isNumeric(valB) ? valA - valB : valA
					.toString().localeCompare(valB)
		}
	}
	function getCellValue(row, index) {
		return $(row).children('td').eq(index).text()
	}
</script>