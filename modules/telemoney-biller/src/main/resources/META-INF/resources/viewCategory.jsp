<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="com.ejada.telemoney.biller.portlet.CategoryDTO"%>
<%@page
	import="com.ejada.telemoney.biller.portlet.BillerConfigurationAction"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>

<%
	List<CategoryDTO> categories = request.getAttribute("records") != null
			? (List<CategoryDTO>) request.getAttribute("records")
			: new ArrayList();

	Set<String> pendingCategoryIds = (Set<String>) request.getAttribute("pendingCategoryIds");
	if (pendingCategoryIds == null) {
		pendingCategoryIds = new HashSet<>();
	}

	// Build CSV for passing to child actions
	String pendingCategoryIdsCsv = String.join(",", pendingCategoryIds);
%>

<portlet:actionURL name="beforeUpdateCategory"
	var="beforeUpdateCategory">
</portlet:actionURL>

<portlet:actionURL name="beforeCreateCategory"
	var="beforeCreateCategory">
</portlet:actionURL>

<portlet:actionURL name="deleteCategory" var="deleteCategory">
</portlet:actionURL>

<portlet:actionURL name="getBillerByCategory" var="getBillerByCategory">
</portlet:actionURL>
<div>
	<div class="d-flex pb-4 align-items-center">
		<h3 class="m-0">Biller category</h3>
			    <liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />	
	    <liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
	    <liferay-ui:error key="hasPendingVersion" message="This category has a pending version awaiting approval and cannot be modified." />
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
				<div class="col-md-6 d-flex justify-content-end">
					<% if (!isOther) { %>
					<a href="<%=beforeCreateCategory%>">
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

							<th scope="col">Category code <span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">Category name English <span
								style="cursor: pointer;"> <svg
										xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">Category name Arabic <span
								style="cursor: pointer;"> <svg
										xmlns="http://www.w3.org/2000/svg" width="16" height="16"
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
							for (CategoryDTO category : categories) {
								boolean hasPendingVersion = pendingCategoryIds.contains(String.valueOf(category.getCategoryId()));
						%>
						<tr>
							<td><%=category.getCategoryCode()%></td>
							<td>
								<%=category.getCategoryNameEn()%>
								<% if (hasPendingVersion) { %>
								<span class="badge badge-warning" style="font-size: 0.7rem; vertical-align: middle; background-color: #f0ad4e; margin-left: 8px;">
									Pending Approval
								</span>
								<% } %>
							</td>
							<td><%=category.getCategoryNameAr()%></td>
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
											href=<portlet:actionURL name="getBillerByCategory" >
													<portlet:param name="categoryId" value="<%=String.valueOf(category.getCategoryId())%>" />
													<portlet:param name="isCategoryPending" value="<%=String.valueOf(hasPendingVersion)%>" />
													<portlet:param name="pendingCategoryIds" value="<%=pendingCategoryIdsCsv%>" />
												</portlet:actionURL>
											class="dropdown-item"> View Billers </a>

										<% if (hasPendingVersion) { %>
											<!-- Only View option when pending -->
											<a
												href=<portlet:actionURL name="beforeUpdateCategory" >
														<portlet:param name="categoryID" value="<%=String.valueOf(category.getCategoryId())%>" />
														<portlet:param name="categoryNameAr" value="<%=category.getCategoryNameAr()%>" />
														<portlet:param name="categoryNameEn" value="<%=category.getCategoryNameEn()%>" />
														<portlet:param name="categoryCode" value="<%=category.getCategoryCode()%>" />
														<portlet:param name="hasPendingVersion" value="true" />
													</portlet:actionURL>
												class="dropdown-item">View</a>
										<% } else { %>
											<!-- Full options when not pending -->
											<a
												href=<portlet:actionURL name="beforeUpdateCategory" >
														<portlet:param name="categoryID" value="<%=String.valueOf(category.getCategoryId())%>" />
														<portlet:param name="categoryNameAr" value="<%=category.getCategoryNameAr()%>" />
														<portlet:param name="categoryNameEn" value="<%=category.getCategoryNameEn()%>" />
														<portlet:param name="categoryCode" value="<%=category.getCategoryCode()%>" />
														<portlet:param name="hasPendingVersion" value="false" />
													</portlet:actionURL>
												class="dropdown-item"> <%= isOther ? "View" : "Edit" %> </a>

											<% if (!isOther) { %>
											<form action=<%=deleteCategory%> method="post"
												name="<portlet:namespace/>billerDeleteForm"
												id="<portlet:namespace/>billerDeleteForm">
												<a onclick="deleteBiller('<%=String.valueOf(category.getCategoryId())%>', '<%=category.getCategoryNameAr()%>', '<%=category.getCategoryNameEn()%>', '<%=category.getCategoryCode()%>')"
													class="dropdown-item"> Delete </a>
												<input type="hidden" name="<portlet:namespace/>categoryDeleteId" id="<portlet:namespace/>categoryDeleteId" />
												<input type="hidden" name="<portlet:namespace/>deleteCategoryNameAr" id="<portlet:namespace/>deleteCategoryNameAr" />
												<input type="hidden" name="<portlet:namespace/>deleteCategoryNameEn" id="<portlet:namespace/>deleteCategoryNameEn" />
												<input type="hidden" name="<portlet:namespace/>deleteCategoryCode" id="<portlet:namespace/>deleteCategoryCode" />
											</form>
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
				want to delete this biller category?</div>
			<div class="modal-footer justify-content-end">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="submit" class="btn btn-primary"
					onclick="deleteBillerConfirm()">Confirm</button>
			</div>
		</div>
	</div>
</div>
<script>
	function deleteBiller(recordId, categoryNameAr, categoryNameEn, categoryCode) {
		var recordIdField = document.getElementById('<portlet:namespace/>categoryDeleteId');
		var categoryNameArField = document.getElementById('<portlet:namespace/>deleteCategoryNameAr');
		var categoryNameEnField = document.getElementById('<portlet:namespace/>deleteCategoryNameEn');
		var categoryCodeField = document.getElementById('<portlet:namespace/>deleteCategoryCode');

		recordIdField.value = recordId;
		categoryNameArField.value = categoryNameAr;
		categoryNameEnField.value = categoryNameEn;
		categoryCodeField.value = categoryCode;
		openModal();
	}

	function deleteBillerConfirm() {
		document.getElementById('<portlet:namespace/>billerDeleteForm')
				.submit();
	}
	function resetDelete() {
		var recordIdField = document.getElementById('<portlet:namespace/>categoryDeleteId');
		var categoryNameArField = document.getElementById('<portlet:namespace/>deleteCategoryNameAr');
		var categoryNameEnField = document.getElementById('<portlet:namespace/>deleteCategoryNameEn');
		var categoryCodeField = document.getElementById('<portlet:namespace/>deleteCategoryCode');

		recordIdField.value = "";
		categoryNameArField.value = "";
		categoryNameEnField.value = "";
		categoryCodeField.value = "";
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