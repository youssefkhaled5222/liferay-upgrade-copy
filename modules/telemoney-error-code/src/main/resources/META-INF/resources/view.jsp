<%@page import="com.ejada.telemoney.error.code.portlet.ErrorCodeDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ include file="/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ page import="com.liferay.portal.kernel.util.ListUtil"%>
<%
	List<ErrorCodeDTO> items = request.getAttribute("records") != null
			? (List<ErrorCodeDTO>) request.getAttribute("records")
			: new ArrayList();

	List<ErrorCodeDTO> search = request.getAttribute("search") != null
			? (List<ErrorCodeDTO>) request.getAttribute("search")
			: new ArrayList();
	
	List<ErrorCodeDTO> displayList = (search != null && !search.isEmpty()) ? search : items;

	Set<String> pendingErrorCodeIds = (Set<String>) request.getAttribute("pendingErrorCodeIds");
	if (pendingErrorCodeIds == null) {
		pendingErrorCodeIds = new HashSet<>();
	}
%>



<portlet:actionURL name="searchByCode" var="searchByCode">
</portlet:actionURL>

<portlet:renderURL var="clear">
	<portlet:param name="action" value="/view.jsp" />
</portlet:renderURL>

<div>
	<h3 class="pb-4">Error Code test</h3>
	<liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />	
	<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
	<liferay-ui:error key="hasPendingVersion" message="This error code has a pending version and cannot be modified." />

	<div class="card">
		<div class="card-body">
			<form action=<%=searchByCode%> method="post">
				<div class="row">
				    <div class="col-md-9">
				        <div class="d-flex flex-wrap align-items-end mb-3">

				            <div class="me-6 mx-3" style="width: 150px;">
				                <label class="form-label">Search</label>
				                <input type="text" class="form-control" id="searchName" name="<portlet:namespace/>searchName">
				            </div>
				

				            <div class="me-6 mx-3" style="width: 150px;">
				                <label class="form-label">Filter By</label>
				                <select required class="custom-select" id="filter" name="<portlet:namespace/>searchType">
				                    <option value="statusCode" selected>Status Code</option>
				                    <option value="description">Description</option>
				                </select>
				            </div>
				

				            <div class="me-6 mx-3">
				                <label class="form-label">Language</label>
				                <div class="d-flex align-items-center">
				                    <div class="form-check form-check-inline">
				                        <input class="form-check-input" type="radio" id="langEng" name="<portlet:namespace/>LangId" value="EN" checked>
				                        <label class="form-check-label" for="langEng">EN</label>
				                    </div>
				                    <div class="form-check form-check-inline">
				                        <input class="form-check-input" type="radio" id="langAr" name="<portlet:namespace/>LangId" value="AR">
				                        <label class="form-check-label" for="langAr">AR</label>
				                    </div>
				                </div>
				            </div>
				
				            <div class="d-flex">
				                <button type="submit" class="btn btn-primary mx-3 me-6 px-4">Search</button>
				                <button type="button" class="btn btn-secondary px-4" onclick="window.location.href='<%=clear%>'">Clear</button>
				            </div>
				        </div>
				    </div>
				</div>

			</form>
			<div>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Status Code <span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">Languages <span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-arrows-vertical"
										viewBox="0 0 16 16">
									  <path
											d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z" />
									</svg>
							</span>
							</th>
							<th scope="col">Description <span style="cursor: pointer;">
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
						<liferay-ui:search-container delta="10"
							emptyResultsMessage="Sorry. There are no records to display."
							total="<%=displayList.size()%>" deltaConfigurable="true">
						<liferay-ui:search-container-results
								results="<%=ListUtil.subList(displayList, searchContainer.getStart(), searchContainer.getEnd())%>">
						</liferay-ui:search-container-results>
						<liferay-ui:search-container-row
							className="com.ejada.telemoney.error.code.portlet.ErrorCodeDTO"
							keyProperty="statusCode" modelVar="item">
					<tbody>

							<liferay-ui:search-container-column-text name="Status Code">
								<%=item.getStatusCode()%>
								<% if (pendingErrorCodeIds.contains(item.getStatusCode())) { %>
									<span class="badge badge-warning" style="font-size: 0.7rem; vertical-align: middle; background-color: #f0ad4e; margin-left: 8px;">
										Pending Approval
									</span>
								<% } %>
							</liferay-ui:search-container-column-text>
							<liferay-ui:search-container-column-text
								value="<%=search != null && !search.isEmpty() ? item.getLanguage() : item.getLanguages()%>"
								name="Language" />
							<liferay-ui:search-container-column-text
								value="<%=item.getDescription()%>" name="Description" />
							<liferay-ui:search-container-column-text name="Actions">
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
										<%
											boolean isPending = pendingErrorCodeIds.contains(item.getStatusCode());
										%>
										<a class="dropdown-item"
											href="<portlet:actionURL name='getErrorCodeviewId'>
                    <portlet:param name='statusCode' value='<%=item.getStatusCode()%>' />
                    <portlet:param name='languages' value='<%=item.getLanguages()%>' />
                    <portlet:param name='description' value='<%=item.getDescription()%>' />
                    <portlet:param name='hasPendingVersion' value='<%=String.valueOf(isPending)%>' />
                </portlet:actionURL>"><%= isOther ? "View" : "Edit" %></a>
									</div>
								</div>
							</liferay-ui:search-container-column-text>
					</tbody>
				</liferay-ui:search-container-row>
				<liferay-ui:search-iterator markupView="lexicon" />
				</liferay-ui:search-container>
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