<%@page import="java.util.ArrayList"%>
<%@page import="com.ejada.telemoney.configuration.dto.Configuration"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@ include file="/init.jsp"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>


<%
	List<Configuration> configurations = request.getAttribute("configurations") != null
			? (List<Configuration>) request.getAttribute("configurations")
			: new ArrayList<>();
	String searchValue = request.getAttribute("searchValue") != null
			? (String) request.getAttribute("searchValue")
			: "";

	Set<String> pendingConfigurationIds = (Set<String>) request.getAttribute("pendingConfigurationIds");
	if (pendingConfigurationIds == null) {
		pendingConfigurationIds = new HashSet<>();
	}
%>

<portlet:actionURL var="getConfigurationInfoForUpdate"
	name="getConfigurationInfoForUpdate">
</portlet:actionURL>

<portlet:actionURL name="searchByTypeOrKey" var="searchByTypeOrKey">
</portlet:actionURL>

<portlet:renderURL var="renderView">
	<portlet:param name="action" value="view" />
</portlet:renderURL>


<div>
	<h3 class="pb-4">Configurations</h3>
	    <liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />
	<liferay-ui:error key="hasPendingVersion" message="This configuration has a pending version and cannot be modified." />

	<div class="card">
		<div class="card-body">
			<!--<div class="row">
				<div class="col-md-6">
					 <div class="d-flex align-items-end mb-3"> -->
			<form action=<%=searchByTypeOrKey%> method="post">
				<div class="row">
					<div class="col-md-4">
						<div class="d-flex align-items-end mb-3">
							<div class="flex-grow-1">
								<label class="form-label">Search by Key or Type</label> <input
									type="text" class="form-control" id="searchValue"
									name="<portlet:namespace/>searchValue" value="<%=searchValue%>">
							</div>
							<div class="d-flex">
								<button type="submit" class="btn btn-primary px-5 ml-3">Search</button>
								<button onclick="window.location.href='<%=renderView%>'"
									class="btn btn-link px-5 ml-3">Clear</button>
							</div>
						</div>
					</div>
				</div>
			</form>

			<!-- <div>
							<label class="form-label">Search by Key or Type</label> 
							<input type="text" class="form-control" id="">
						</div>
						<div class="d-flex">
							<button type="submit" class="btn btn-primary px-5 ml-3">Search</button>
							<button type="submit" class="btn btn-link px-5 ml-3">Clear</button>
						</div>
					</div> 
				</div>
			</div>-->
			<div>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Key <span style="cursor: pointer;"> <svg
										xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">Value <span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">Type <span style="cursor: pointer;">
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
						<tr>
							<%
								if (!configurations.isEmpty()) {
									for (Configuration configuration : configurations) {
										boolean isPending = pendingConfigurationIds.contains(configuration.getKey());
							%>
							<td><%=configuration.getKey()%>
								<% if (isPending) { %>
									<span class="badge badge-warning" style="font-size: 0.7rem; vertical-align: middle; background-color: #f0ad4e; margin-left: 8px;">
										Pending Approval
									</span>
								<% } %>
							</td>
							<td><%=configuration.getValue()%></td>
							<td><%=configuration.getType()%></td>
							<td>
									<div class="dropdown">
										<button class="btn btn-secondary dropdown-toggle"
											type="button" id="dropdownMenuButton" data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="false">
											<svg xmlns="http://www.w3.org/2000/svg" width="16"
												height="16" fill="currentColor"
												class="bi bi-three-dots-vertical" viewBox="0 0 16 16">
               								 <path
													d="M9.5 13a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z" />
          			 						 </svg>
										</button>
										<div class="dropdown-menu"
											aria-labelledby="dropdownMenuButton">
											<form action="<%=getConfigurationInfoForUpdate%>"
												method="post"
												name="<portlet:namespace/>configurationUpdateForm"
												id="<portlet:namespace/>configurationUpdateForm">
												<a
													onclick="updateConfiguration('<%=configuration.getKey()%>', 
                    							'<%=configuration.getValue()%>', 
                   									 '<%=configuration.getType()%>',
                   									 '<%=isPending%>')"
													class="dropdown-item"><%= isOther ? "View" : "Edit" %></a> <input type="text"
													class="d-none" name="<portlet:namespace/>key"
													id="<portlet:namespace/>key" /> <input type="text"
													class="d-none" name="<portlet:namespace/>value"
													id="<portlet:namespace/>value" /> <input type="text"
													class="d-none" name="<portlet:namespace/>type"
													id="<portlet:namespace/>type" />
												<input type="hidden"
													name="<portlet:namespace/>hasPendingVersion"
													id="<portlet:namespace/>hasPendingVersion" />
											</form>
										</div>
									</div>


							</td>
						</tr>
						<%
							}
							} else {
						%>
						<!-- <div class="my-2">
							<div class="d-flex justify-content-between align-items-center py-3 border-bottom">
								<div>
									<h5>No configurations found.</h5>
								</div>
							</div>
						</div> -->
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

	function updateConfiguration(key, value, type, hasPendingVersion) {
		console.log("inside updateConfiguration!")
		var keyField = document.getElementById('<portlet:namespace/>key');
		var valueField = document.getElementById('<portlet:namespace/>value');
		var typeField = document.getElementById('<portlet:namespace/>type');
		var hasPendingField = document.getElementById('<portlet:namespace/>hasPendingVersion');

		keyField.value = key;
		valueField.value = value;
		typeField.value = type;
		hasPendingField.value = hasPendingVersion;

		document.getElementById('<portlet:namespace/>configurationUpdateForm')
				.submit();
	}
	function clearSearch() {
		document.getElementById('searchValue').value = '';
	}
</script>