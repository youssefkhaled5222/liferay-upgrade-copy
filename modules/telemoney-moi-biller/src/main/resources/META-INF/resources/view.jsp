<%@page import="com.ejada.telemoney.db.domain.model.MoiServiceDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@ include file="/init.jsp"%>
<%@taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<portlet:actionURL name="getRefundType" var="getRefundType">
</portlet:actionURL>

<portlet:actionURL name="getLanguageId" var="getLanguageId">
</portlet:actionURL>

<portlet:actionURL name="getUpdateMoiServiceData"
	var="getUpdateMoiServiceData">
</portlet:actionURL>

<portlet:actionURL name="deleteMoiService" var="deleteMoiService">
</portlet:actionURL>

<portlet:actionURL name="openSubService" var="openSubService">
</portlet:actionURL>

<%
	List<MoiServiceDTO> items = request.getAttribute("records") != null
			? (List<MoiServiceDTO>) request.getAttribute("records")
			: new ArrayList();
	String subServiceName = request.getAttribute("refundType") != null
			? (String) request.getAttribute("refundType")
			: "1";

	String languageId = request.getAttribute("languageId") != null
			? (String) request.getAttribute("languageId")
			: "EN";

	// Get pending MOI biller IDs
	Set<String> pendingMoiBillerIds = (Set<String>) request.getAttribute("pendingMoiBillerIds");
	if (pendingMoiBillerIds == null) {
		pendingMoiBillerIds = new HashSet<>();
	}

%>

<div>
	<div class="d-flex pb-4 align-items-center">
		<h3 class="m-0">MOI Biller</h3>
		<liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />
		<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
		<liferay-ui:error key="hasPendingVersion" message="This MOI biller has a pending version awaiting approval and cannot be modified." />
	</div>
	<div class="card">
		<div class="card-body">
			<div class="row">
				<div class="col-md-12">
					<div class="mb-3">

						<form action=<%=getRefundType%> method="post"
							name="<portlet:namespace/>refundTypeForm"
							id="<portlet:namespace/>refundTypeForm">

							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio"
									name="<portlet:namespace/>refundType" id="inlineRadio1"
									value="1" onclick="getRefundType(1)"
									<%=subServiceName.equals("1") ? "checked" : ""%>> <label
									class="form-check-label mx-2" for="inlineRadio1">Payment</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio"
									name="<portlet:namespace/>refundType" id="inlineRadio2"
									value="2" onclick="getRefundType(2)"
									<%=subServiceName.equals("2") ? "checked" : ""%>> <label
									class="form-check-label mx-2" for="inlineRadio2">Refund</label>
							</div>

							<button type="submit" class="btn btn-primary px-5 mr-3">Get</button>
						</form>
					</div>

					<div class="mb-3">
						<form action="<%=getLanguageId%>" method="post"
							name="<portlet:namespace/>languageIdForm"
							id="<portlet:namespace/>languageIdForm">

							<div class="btn-group" role="group" aria-label="Language toggle">
								<input type="hidden" name="<portlet:namespace/>languageId"
									id="<portlet:namespace/>languageId" value="<%=languageId%>" />

								<button type="button"
									class="btn btn-outline-primary <%=languageId.equals("EN") ? "active" : ""%>"
									onclick="setLanguageId('EN')">English</button>
								<button type="button"
									class="btn btn-outline-primary <%=languageId.equals("AR") ? "active" : ""%>"
									onclick="setLanguageId('AR')">Arabic</button>
							</div>
						</form>
					</div>

				</div>
			</div>
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
							<th scope="col">Biller ID <span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">Biller code <span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">Biller name <span style="cursor: pointer;">
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
							for (MoiServiceDTO record : items) {
								boolean hasPendingVersion = pendingMoiBillerIds.contains(String.valueOf(record.getId()));
						%>
						<tr>
							<td><%=record.getId()%></td>
							<td><%=record.getServiceCode()%></td>
							<td>
								<%=record.getServiceName()%>
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
											href=<portlet:actionURL name="openSubService" >
										 			<portlet:param name="moiServiceId" value="<%=String.valueOf(record.getId())%>" />
										 			<portlet:param name="billerName" value="<%=record.getServiceName()%>" />
													<portlet:param name="parentHasPendingVersion" value="<%= String.valueOf(hasPendingVersion) %>" />
											  </portlet:actionURL>
											class="dropdown-item">View Services</a>

										<% if (hasPendingVersion) { %>
											<!-- Only View option when pending -->
											<a
												href=<portlet:actionURL name="getUpdateMoiServiceData" >
														<portlet:param name="billerId" value="<%=String.valueOf(record.getId())%>" />
														<portlet:param name="billerCode" value="<%=record.getServiceCode()%>" />
														<portlet:param name="billerName" value="<%=record.getServiceName()%>" />
														<portlet:param name="hasPendingVersion" value="true" />
													</portlet:actionURL>
												class="dropdown-item">View</a>
										<% } else { %>
											<!-- Full options when not pending -->
											<a
												href=<portlet:actionURL name="getUpdateMoiServiceData" >
														<portlet:param name="billerId" value="<%=String.valueOf(record.getId())%>" />
														<portlet:param name="billerCode" value="<%=record.getServiceCode()%>" />
														<portlet:param name="billerName" value="<%=record.getServiceName()%>" />
														<portlet:param name="hasPendingVersion" value="false" />
													</portlet:actionURL>
												class="dropdown-item"> <%= isOther ? "View" : "Edit" %> </a>
											<% if (!isOther) { %>
												<a onclick="deleteMoi('<%=String.valueOf(record.getId())%>', '<%=record.getServiceCode()%>', '<%=record.getServiceName()%>')"
													class="dropdown-item"> Delete </a>
											<% } %>
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
<form action="<%=deleteMoiService%>" method="post"
	name="<portlet:namespace/>moiDeleteForm"
	id="<portlet:namespace/>moiDeleteForm">
	<input type="hidden" name="<portlet:namespace/>billerId" id="<portlet:namespace/>billerId" />
	<input type="hidden" name="<portlet:namespace/>oldBillerId" id="<portlet:namespace/>oldBillerId" />
	<input type="hidden" name="<portlet:namespace/>oldBillerCode" id="<portlet:namespace/>oldBillerCode" />
	<input type="hidden" name="<portlet:namespace/>oldBillerName" id="<portlet:namespace/>oldBillerName" />
</form>

<div class="modal hide fade" id="telemoneyDeleteModal" tabindex="-1"
	role="dialog" aria-labelledby="telemoneyDeleteModalCenteredTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-100" role="document">
		<div class="modal-content w-auto m-auto">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">Delete Moi</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body text-5 text-center">Are you sure you
				want to delete this moi?</div>
			<div class="modal-footer justify-content-end">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="submit" class="btn btn-primary"
					onclick="deleteMoiConfirm()">Confirm</button>
			</div>
		</div>
	</div>
</div>
<script>
	function deleteMoi(recordId, billerCode, billerName) {
		var recordIdField = document
				.getElementById('<portlet:namespace/>billerId');
		recordIdField.value = recordId;

		// Set old values for comparison
		var oldBillerIdField = document
				.getElementById('<portlet:namespace/>oldBillerId');
		oldBillerIdField.value = recordId;

		var oldBillerCodeField = document
				.getElementById('<portlet:namespace/>oldBillerCode');
		oldBillerCodeField.value = billerCode;

		var oldBillerNameField = document
				.getElementById('<portlet:namespace/>oldBillerName');
		oldBillerNameField.value = billerName;


		openModal();
	}

	function deleteMoiConfirm() {
		document.getElementById('<portlet:namespace/>moiDeleteForm').submit();
	}
	function resetDelete() {
		var recordIdField = document
				.getElementById('<portlet:namespace/>billerId');
		recordIdField.value = "";

		var oldBillerIdField = document
				.getElementById('<portlet:namespace/>oldBillerId');
		oldBillerIdField.value = "";

		var oldBillerCodeField = document
				.getElementById('<portlet:namespace/>oldBillerCode');
		oldBillerCodeField.value = "";

		var oldBillerNameField = document
				.getElementById('<portlet:namespace/>oldBillerName');
		oldBillerNameField.value = "";
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

<script>
	function getRefundType(refundType) {
		var recordIdField = document
				.getElementById('<portlet:namespace/>refundType');

		recordIdField.value = refundType;

		document.getElementById('<portlet:namespace/>refundTypeForm').submit();
	}
</script>

<script>
	function setLanguageId(languageId) {
		document.getElementById('<portlet:namespace/>languageId').value = languageId;
		document.getElementById('<portlet:namespace/>languageIdForm').submit();
	}
</script>
