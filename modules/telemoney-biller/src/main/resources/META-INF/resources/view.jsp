<%@page import="com.ejada.telemoney.biller.portlet.BillerDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ include file="/init.jsp"%>

<%
	List<BillerDTO> items = request.getAttribute("records") != null
			? (List<BillerDTO>) request.getAttribute("records")
			: new ArrayList();
	String billerCategoryId = (String) request.getAttribute("billerCategoryId");

	Set<String> pendingBillerIds = (Set<String>) request.getAttribute("pendingBillerIds");
	if (pendingBillerIds == null) {
		pendingBillerIds = new HashSet<>();
	}

	// Check if the parent category is pending
	Boolean isCategoryPending = (Boolean) request.getAttribute("isCategoryPending");
	if (isCategoryPending == null) {
		isCategoryPending = false;
	}

	// CSV strings for passing to child actions (avoids re-querying DB)
	String pendingCategoryIdsCsv = request.getAttribute("pendingCategoryIdsCsv") != null
			? (String) request.getAttribute("pendingCategoryIdsCsv") : "";
	String pendingBillerIdsCsv = String.join(",", pendingBillerIds);
%>

<portlet:actionURL name="beforeCreateBiller" var="beforeCreateBiller">
</portlet:actionURL>

<portlet:actionURL name="getUpdateData" var="getUpdateData">
</portlet:actionURL>

<portlet:actionURL name="deleteBiller" var="deleteBiller">
</portlet:actionURL>
<div>
	<h3 class="pb-4">Biller</h3>
	<liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />
	<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
	<liferay-ui:error key="hasPendingVersion" message="This biller has a pending version awaiting approval and cannot be modified." />

	<% if (isCategoryPending) { %>
	<div class="alert alert-warning" role="alert">
		<strong>Category Pending Approval:</strong> The parent category has a pending version awaiting approval. All billers in this category are currently locked for editing.
	</div>
	<% } %>

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
				<div class="col-md-6 d-flex justify-content-end">
					<% if (!isOther && !isCategoryPending) { %>
					<a href="<portlet:actionURL name="beforeCreateBiller">
							<portlet:param name="categoryId" value="<%=billerCategoryId%>" />
							<portlet:param name="pendingCategoryIds" value="<%=pendingCategoryIdsCsv%>" />
						</portlet:actionURL>">
						<button class="btn btn-link">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								fill="currentColor" class="bi bi-plus-circle-fill"
								viewBox="0 0 16 16">
						  <path
									d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM8.5 4.5a.5.5 0 0 0-1 0v3h-3a.5.5 0 0 0 0 1h3v3a.5.5 0 0 0 1 0v-3h3a.5.5 0 0 0 0-1h-3v-3z" />
							</svg>
							Add
						</button>
					</a>
					<% } %>
				</div>
			</div>
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Biller category <span
								style="cursor: pointer;"> <svg
										xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">Prepaid code <span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">Postpaid code <span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">Arabic description <span
								style="cursor: pointer;"> <svg
										xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">English description <span
								style="cursor: pointer;"> <svg
										xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">Payment type <span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (BillerDTO item : items) {
								boolean hasPendingVersion = pendingBillerIds.contains(item.getId());
								boolean isLocked = hasPendingVersion || isCategoryPending;
						%>
						<tr>
							<td><%=item.getBillerCategoryId()%></td>
							<td><%=item.getPrepaidCode()%></td>
							<td><%=item.getPostpaidCode()%></td>
							<td><%=item.getBillerNameAr()%></td>
							<td>
								<%=item.getBillerNameEn()%>
								<% if (hasPendingVersion) { %>
								<span class="badge badge-warning" style="font-size: 0.7rem; vertical-align: middle; background-color: #f0ad4e; margin-left: 8px;">
									Pending Approval
								</span>
								<% } else if (isCategoryPending) { %>
								<span class="badge badge-warning" style="font-size: 0.7rem; vertical-align: middle; background-color: #f0ad4e; margin-left: 8px;">
									Category Pending
								</span>
								<% } %>
							</td>
							<td><%=item.getPaymentType()%></td>
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
										<% if (isLocked) { %>
											<!-- Only View option when biller is pending or parent category is pending -->
											<a
												href=<portlet:actionURL name="getUpdateData" >
														<portlet:param name="billerId" value="<%=item.getPrepaidCode()%>" />
														<portlet:param name="billerName" value="<%=item.getBillerNameEn()%>" />
														<portlet:param name="hasPendingVersion" value="true" />
														<portlet:param name="isCategoryPending" value="<%=String.valueOf(isCategoryPending)%>" />
														<portlet:param name="pendingCategoryIds" value="<%=pendingCategoryIdsCsv%>" />
													</portlet:actionURL>
												class="dropdown-item">View</a>
										<% } else { %>
											<!-- Full options when not pending -->
											<a
												href=<portlet:actionURL name="getUpdateData" >
														<portlet:param name="billerId" value="<%=item.getPrepaidCode()%>" />
														<portlet:param name="billerName" value="<%=item.getBillerNameEn()%>" />
														<portlet:param name="hasPendingVersion" value="false" />
														<portlet:param name="isCategoryPending" value="<%=String.valueOf(isCategoryPending)%>" />
														<portlet:param name="pendingCategoryIds" value="<%=pendingCategoryIdsCsv%>" />
													</portlet:actionURL>
												class="dropdown-item"> <%= isOther ? "View" : "Edit" %> </a>
											<% if (!isOther) { %>
												<a onclick="deleteBiller('<%=item.getId()%>', '<%=item.getPrepaidCode()%>', '<%=item.getPostpaidCode()%>', '<%=item.getBillerNameAr()%>', '<%=item.getBillerNameEn()%>', '<%=item.getBillerCategoryId()%>', '<%=item.getLabelNameAr()%>', '<%=item.getLabelNameEn()%>', '<%=item.getPaymentType()%>', '<%=item.getAllowedFixedValues()%>', '<%=item.getPaymentMinAmount()%>', '<%=item.getPaymentMaxAmount()%>', '<%=item.getAllowedPaymentAmountsAsString()%>', '<%=item.getPhotoLink()%>')"
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
<form action="<%=deleteBiller%>" method="post"
	name="<portlet:namespace/>billerDeleteForm"
	id="<portlet:namespace/>billerDeleteForm">
	<input type="hidden" name="<portlet:namespace/>billerDeleteId" id="<portlet:namespace/>billerDeleteId" />
	<input type="hidden" name="<portlet:namespace/>deletePrePaidCode" id="<portlet:namespace/>deletePrePaidCode" />
	<input type="hidden" name="<portlet:namespace/>deletePostPaidCode" id="<portlet:namespace/>deletePostPaidCode" />
	<input type="hidden" name="<portlet:namespace/>deleteBillerNameAr" id="<portlet:namespace/>deleteBillerNameAr" />
	<input type="hidden" name="<portlet:namespace/>deleteBillerNameEn" id="<portlet:namespace/>deleteBillerNameEn" />
	<input type="hidden" name="<portlet:namespace/>deleteBillerCategoryId" id="<portlet:namespace/>deleteBillerCategoryId" />
	<input type="hidden" name="<portlet:namespace/>deleteLabelNameAr" id="<portlet:namespace/>deleteLabelNameAr" />
	<input type="hidden" name="<portlet:namespace/>deleteLabelNameEn" id="<portlet:namespace/>deleteLabelNameEn" />
	<input type="hidden" name="<portlet:namespace/>deletePaymentTypeId" id="<portlet:namespace/>deletePaymentTypeId" />
	<input type="hidden" name="<portlet:namespace/>deleteAllowedFixedValues" id="<portlet:namespace/>deleteAllowedFixedValues" />
	<input type="hidden" name="<portlet:namespace/>deletePaymentMinAmount" id="<portlet:namespace/>deletePaymentMinAmount" />
	<input type="hidden" name="<portlet:namespace/>deletePaymentMaxAmount" id="<portlet:namespace/>deletePaymentMaxAmount" />
	<input type="hidden" name="<portlet:namespace/>deleteAllowedPaymentAmounts" id="<portlet:namespace/>deleteAllowedPaymentAmounts" />
	<input type="hidden" name="<portlet:namespace/>deletePhotoLink" id="<portlet:namespace/>deletePhotoLink" />
</form>

<!-- Delete Confirmation Modal -->
<div class="modal hide fade" id="telemoneyDeleteModal" tabindex="-1"
	role="dialog" aria-labelledby="telemoneyDeleteModalCenteredTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-100" role="document">
		<div class="modal-content w-auto m-auto">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">Delete
					Biller</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body text-5 text-center">Are you sure you
				want to delete this biller?</div>
			<div class="modal-footer justify-content-end">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="submit" class="btn btn-primary"
					onclick="deleteBillerConfirm()">Confirm</button>
			</div>
		</div>
	</div>
</div>
<script>
	function deleteBiller(recordId, prePaidCode, postPaidCode, billerNameAr, billerNameEn,
			billerCategoryId, labelNameAr, labelNameEn, paymentTypeId, allowedFixedValues,
			paymentMinAmount, paymentMaxAmount, allowedPaymentAmounts, photoLink) {
		var recordIdField = document.getElementById('<portlet:namespace/>billerDeleteId');
		var prePaidCodeField = document.getElementById('<portlet:namespace/>deletePrePaidCode');
		var postPaidCodeField = document.getElementById('<portlet:namespace/>deletePostPaidCode');
		var billerNameArField = document.getElementById('<portlet:namespace/>deleteBillerNameAr');
		var billerNameEnField = document.getElementById('<portlet:namespace/>deleteBillerNameEn');
		var billerCategoryIdField = document.getElementById('<portlet:namespace/>deleteBillerCategoryId');
		var labelNameArField = document.getElementById('<portlet:namespace/>deleteLabelNameAr');
		var labelNameEnField = document.getElementById('<portlet:namespace/>deleteLabelNameEn');
		var paymentTypeIdField = document.getElementById('<portlet:namespace/>deletePaymentTypeId');
		var allowedFixedValuesField = document.getElementById('<portlet:namespace/>deleteAllowedFixedValues');
		var paymentMinAmountField = document.getElementById('<portlet:namespace/>deletePaymentMinAmount');
		var paymentMaxAmountField = document.getElementById('<portlet:namespace/>deletePaymentMaxAmount');
		var allowedPaymentAmountsField = document.getElementById('<portlet:namespace/>deleteAllowedPaymentAmounts');
		var photoLinkField = document.getElementById('<portlet:namespace/>deletePhotoLink');

		recordIdField.value = recordId;
		prePaidCodeField.value = prePaidCode;
		postPaidCodeField.value = postPaidCode;
		billerNameArField.value = billerNameAr;
		billerNameEnField.value = billerNameEn;
		billerCategoryIdField.value = billerCategoryId;
		labelNameArField.value = labelNameAr;
		labelNameEnField.value = labelNameEn;
		paymentTypeIdField.value = paymentTypeId;
		allowedFixedValuesField.value = allowedFixedValues;
		paymentMinAmountField.value = paymentMinAmount;
		paymentMaxAmountField.value = paymentMaxAmount;
		allowedPaymentAmountsField.value = allowedPaymentAmounts;
		photoLinkField.value = photoLink;


		openModal();
	}

	function deleteBillerConfirm() {
		document.getElementById('<portlet:namespace/>billerDeleteForm')
				.submit();
	}
	function resetDelete() {
		var recordIdField = document.getElementById('<portlet:namespace/>billerDeleteId');
		var prePaidCodeField = document.getElementById('<portlet:namespace/>deletePrePaidCode');
		var postPaidCodeField = document.getElementById('<portlet:namespace/>deletePostPaidCode');
		var billerNameArField = document.getElementById('<portlet:namespace/>deleteBillerNameAr');
		var billerNameEnField = document.getElementById('<portlet:namespace/>deleteBillerNameEn');
		var billerCategoryIdField = document.getElementById('<portlet:namespace/>deleteBillerCategoryId');
		var labelNameArField = document.getElementById('<portlet:namespace/>deleteLabelNameAr');
		var labelNameEnField = document.getElementById('<portlet:namespace/>deleteLabelNameEn');
		var paymentTypeIdField = document.getElementById('<portlet:namespace/>deletePaymentTypeId');
		var allowedFixedValuesField = document.getElementById('<portlet:namespace/>deleteAllowedFixedValues');
		var paymentMinAmountField = document.getElementById('<portlet:namespace/>deletePaymentMinAmount');
		var paymentMaxAmountField = document.getElementById('<portlet:namespace/>deletePaymentMaxAmount');
		var allowedPaymentAmountsField = document.getElementById('<portlet:namespace/>deleteAllowedPaymentAmounts');
		var photoLinkField = document.getElementById('<portlet:namespace/>deletePhotoLink');

		recordIdField.value = "";
		prePaidCodeField.value = "";
		postPaidCodeField.value = "";
		billerNameArField.value = "";
		billerNameEnField.value = "";
		billerCategoryIdField.value = "";
		labelNameArField.value = "";
		labelNameEnField.value = "";
		paymentTypeIdField.value = "";
		allowedFixedValuesField.value = "";
		paymentMinAmountField.value = "";
		paymentMaxAmountField.value = "";
		allowedPaymentAmountsField.value = "";
		photoLinkField.value = "";
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