<%@page import="com.ejada.telemoney.db.domain.model.FieldDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@ include file="/init.jsp" %>
<%@taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<%
	List<FieldDTO> items = request.getAttribute("fields") != null
			? (List<FieldDTO>) request.getAttribute("fields")
			: new ArrayList();

	String billerName = request.getAttribute("billerName") != null
			? (String) request.getAttribute("billerName")
			: "";
	String subServiceId = request.getAttribute("subServiceId") != null
			? (String) request.getAttribute("subServiceId")
			: "";
	String serviceName = request.getAttribute("serviceName") != null
			? (String) request.getAttribute("serviceName")
			: "";
	String billerId = request.getAttribute("billerId") != null
			? (String) request.getAttribute("billerId")
			: "";
	boolean parentHasPendingVersion = (Boolean) request.getAttribute("parentHasPendingVersion");
	Set<String> pendingMoiFieldIds = (Set<String>) request.getAttribute("pendingMoiFieldIds");

%>

<div>
	<div class="d-flex pb-4 align-items-center">
		<h3 class="m-0">MOI Billers fields</h3>
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
							<label class="form-label">Search</label> 
							<input type="text" class="form-control" id="">
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
							<th scope="col">
								Biller name
								<span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrows-vertical" viewBox="0 0 16 16">
									  <path d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z"/>
									</svg>
								</span>
							</th>
							<th scope="col">
								Service ID 
								<span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrows-vertical" viewBox="0 0 16 16">
									  <path d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z"/>
									</svg>
								</span>
							</th>
							<th scope="col">
								Service code
								<span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrows-vertical" viewBox="0 0 16 16">
									  <path d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z"/>
									</svg>
								</span>
							</th>
							<th scope="col">
								Service name
								<span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrows-vertical" viewBox="0 0 16 16">
									  <path d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z"/>
									</svg>
								</span>
							</th>
						</tr>
					</thead>
					<tbody>
					<%for(FieldDTO field :items) {
						boolean hasPendingVersion = parentHasPendingVersion || pendingMoiFieldIds.contains(String.valueOf(field.getId()));

					%>
						<tr>
							<td><%=billerName %></td>
							<td><%=field.getId() %></td>
							<td><%=field.getCode() %></td>
							<td><%=field.getName() %>
								<% if (hasPendingVersion) { %>
									<span class="badge badge-warning" style="font-size: 0.7rem; vertical-align: middle; background-color: #f0ad4e; margin-left: 8px;">
										Pending Approval
									</span>
								<% } %>
							</td>
							<td>
								<div class="dropdown">
								  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-three-dots-vertical" viewBox="0 0 16 16">
								  <path d="M9.5 13a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z"/>
								</svg>
								  </button>
								  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
								    <% if (hasPendingVersion) { %>
										<a
											href=<portlet:actionURL name="getUpdateFieldData" >
													<portlet:param name="fieldId" value="<%=String.valueOf(field.getId())%>" />
													<portlet:param name="fieldCode" value="<%=field.getCode()%>" />
													<portlet:param name="fieldName" value="<%=field.getName()%>" />
													<portlet:param name="fixedValueFlag" value="<%=String.valueOf(field.getFixedValueFlag())%>" />
													<portlet:param name="fixedValue" value="<%=field.getFixedValue()%>" />
													<portlet:param name="dateFlag" value="<%=String.valueOf(field.getDateFlag())%>" />
													<portlet:param name="dropDownFlag" value="<%=String.valueOf(field.getDropDownFlag())%>" />
													<portlet:param name="subServiceId" value="<%=subServiceId%>" />
													<portlet:param name="subServiceName" value="<%=serviceName%>" />
													<portlet:param name="billerName" value="<%=billerName%>" />
													<portlet:param name="billerId" value="<%=billerId%>" />
													<portlet:param name="parentHasPendingVersion" value="<%= String.valueOf(hasPendingVersion) %>" />
												</portlet:actionURL>
											class="dropdown-item"> View </a>
									<% } else { %>
										<a
											href=<portlet:actionURL name="getUpdateFieldData" >
													<portlet:param name="fieldId" value="<%=String.valueOf(field.getId())%>" />
													<portlet:param name="fieldCode" value="<%=field.getCode()%>" />
													<portlet:param name="fieldName" value="<%=field.getName()%>" />
													<portlet:param name="fixedValueFlag" value="<%=String.valueOf(field.getFixedValueFlag())%>" />
													<portlet:param name="fixedValue" value="<%=field.getFixedValue()%>" />
													<portlet:param name="dateFlag" value="<%=String.valueOf(field.getDateFlag())%>" />
													<portlet:param name="dropDownFlag" value="<%=String.valueOf(field.getDropDownFlag())%>" />
													<portlet:param name="subServiceId" value="<%=subServiceId%>" />
													<portlet:param name="subServiceName" value="<%=serviceName%>" />
													<portlet:param name="billerName" value="<%=billerName%>" />
													<portlet:param name="billerId" value="<%=billerId%>" />
													<portlet:param name="parentHasPendingVersion" value="<%= String.valueOf(hasPendingVersion) %>" />
												</portlet:actionURL>
											class="dropdown-item"> Edit </a>
									<% } %>
								   
								  </div>
								</div>
							</td>
						</tr>
					<%} %>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<script>
$('th').click(function(){
    var table = $(this).parents('table').eq(0)
    var rows = table.find('tr:gt(0)').toArray().sort(comparer($(this).index()))
    this.asc = !this.asc
    if (!this.asc){rows = rows.reverse()}
    for (var i = 0; i < rows.length; i++){table.append(rows[i])}
})
function comparer(index) {
    return function(a, b) {
        var valA = getCellValue(a, index), valB = getCellValue(b, index)
        return $.isNumeric(valA) && $.isNumeric(valB) ? valA - valB : valA.toString().localeCompare(valB)
    }
}
function getCellValue(row, index){ return $(row).children('td').eq(index).text() }
</script>