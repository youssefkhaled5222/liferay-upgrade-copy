<%@page import="java.util.ArrayList"%>
<%@page
	import="com.ejada.telemoney.telemoney.esb.constant.portlet.ESBDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@ include file="/init.jsp"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>

<%
	List<ESBDTO> items = request.getAttribute("records") != null
			? (List<ESBDTO>) request.getAttribute("records")
			: new ArrayList<>();

	List<ESBDTO> search = request.getAttribute("searchList") != null
			? (List<ESBDTO>) request.getAttribute("searchList")
			: new ArrayList<>();

	Set<String> pendingEsbConstantIds = (Set<String>) request.getAttribute("pendingEsbConstantIds");
	if (pendingEsbConstantIds == null) {
		pendingEsbConstantIds = new HashSet<>();
	}
%>

<portlet:actionURL name="searchInList" var="searchInList">
</portlet:actionURL>

<portlet:actionURL name="reload" var="reload">
</portlet:actionURL>

<portlet:renderURL var="cancel_update">
	<portlet:param name="action" value="view" />
</portlet:renderURL>



<div>
	<div class="d-flex pb-4 align-items-center">
		<h3 class="m-0">ESB Constant</h3>
			    <liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />	
		<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
		<liferay-ui:error key="hasPendingVersion" message="This ESB constant has a pending version and cannot be modified." />
		<% if (!isOther) { %>
		<form action=<%=reload%> method="post">
			<button class="btn btn-link" type="submit">
				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
					fill="currentColor" class="bi bi-arrow-repeat" viewBox="0 0 16 16">
					  <path
						d="M11.534 7h3.932a.25.25 0 0 1 .192.41l-1.966 2.36a.25.25 0 0 1-.384 0l-1.966-2.36a.25.25 0 0 1 .192-.41m-11 2h3.932a.25.25 0 0 0 .192-.41L2.692 6.23a.25.25 0 0 0-.384 0L.342 8.59A.25.25 0 0 0 .534 9" />
					  <path fill-rule="evenodd"
						d="M8 3c-1.552 0-2.94.707-3.857 1.818a.5.5 0 1 1-.771-.636A6.002 6.002 0 0 1 13.917 7H12.9A5 5 0 0 0 8 3M3.1 9a5.002 5.002 0 0 0 8.757 2.182.5.5 0 1 1 .771.636A6.002 6.002 0 0 1 2.083 9z" />
					</svg>
				Reload
			</button>
		</form>
		<% } %>
	</div>
	<div class="card">
		<div class="card-body">
			<form action=<%=searchInList%> method="post">
				<div class="row">
					<div class="col-md-6">
						<div class="d-flex align-items-end mb-3">
							<div>
								<label class="form-label">Search</label> <input type="text"
									class="form-control" id="search"
									name="<portlet:namespace/>search">
							</div>
							<div class="d-flex">
								<button type="submit" class="btn btn-primary px-5 ml-3">Search</button>
								<button type="button"
									onclick="window.location.href='<%=cancel_update%>'"
									class="btn btn-secondary px-5">Clear
								</button>

							</div>
						</div>
					</div>
				</div>
			</form>
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Service name <span style="cursor: pointer;"> <svg
										xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">Func ID <span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">Ip <span style="cursor: pointer;"> <svg
										xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">Port <span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">Path <span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">SC ID <span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">Branch ID <span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">Branch name <span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">User ID <span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">Agent ID <span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">SecInfo <span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">SecInfo Type <span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">Version <span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<%
							List<ESBDTO> records = search != null && search.size() != 0 && !search.isEmpty() ? search : items;

							for (ESBDTO item : records) {
								boolean isPending = pendingEsbConstantIds.contains(item.getServiceName());
						%>
						<tr>
							<td><%=item.getServiceName()%>
								<% if (isPending) { %>
									<span class="badge badge-warning" style="font-size: 0.7rem; vertical-align: middle; background-color: #f0ad4e; margin-left: 8px;">
										Pending Approval
									</span>
								<% } %>
							</td>
							<td><%=item.getFuncId()%></td>
							<td><%=item.getIp()%></td>
							<td><%=item.getPort()%></td>
							<td><%=item.getPath()%></td>
							<td><%=item.getSCId()%></td>
							<td><%=item.getBranchId()%></td>
							<td><%=item.getBranchName()%></td>
							<td><%=item.getUserId()%></td>
							<td><%=item.getAgentId()%></td>
							<td><%=item.getSecInfo()%></td>
							<td><%=item.getSecInfoType()%></td>
							<td><%=item.getVersion()%></td>
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


										<% if (!isOther) { %>
										<a
											href=<portlet:actionURL name="getESBConstantsReloadSearch" >
												<portlet:param name="entityServiceName" value="<%=item.getServiceName()%>" />
											</portlet:actionURL>
											class="dropdown-item"> Reload </a> 
										<% } %>
										<a
											href=<portlet:actionURL name="getESBviewId" >
														<portlet:param name="serviceName" value="<%=item.getServiceName()%>" />
													</portlet:actionURL>&<portlet:namespace/>hasPendingVersion=<%=isPending%>
											class="dropdown-item"> <%= isOther ? "View" : "Edit" %> </a>




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

<script>
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
