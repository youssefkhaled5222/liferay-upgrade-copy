<%@page import="java.util.ArrayList"%>
<%@page import="com.ejada.telemoney.whiteList.DTO.WhiteListDTO"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>


<portlet:actionURL name="beforeUpdateStatus" var="beforeUpdateStatus">
</portlet:actionURL>

<portlet:actionURL name="searchRes" var="search">
</portlet:actionURL>

<portlet:actionURL name="exportCsv" var="exportCsv">
</portlet:actionURL>

<%
	Date dateFrom = new Date();
	Calendar startCalendar = Calendar.getInstance();
	startCalendar.setTime(dateFrom);
	int startYear = startCalendar.get(Calendar.YEAR);
	int startMonth = startCalendar.get(Calendar.MONTH) ; // Adjust for zero-based indexing
	int startDay = startCalendar.get(Calendar.DAY_OF_MONTH);

	Date dateTo = new Date();
	Calendar endCalendar = Calendar.getInstance();
	endCalendar.setTime(dateTo);
	int endYear = endCalendar.get(Calendar.YEAR);
	int endMonth = endCalendar.get(Calendar.MONTH) ; // Adjust for zero-based indexing
	int endDay = endCalendar.get(Calendar.DAY_OF_MONTH);

	List<WhiteListDTO> records = (List<WhiteListDTO>) request.getAttribute("records") != null
			? (List<WhiteListDTO>) request.getAttribute("records")
			: new ArrayList<>();
	List<WhiteListDTO> types = request.getAttribute("searchResult") != null
			? (List<WhiteListDTO>) request.getAttribute("searchResult")
			: new ArrayList<>();
%>
<div>
	<div class="d-flex pb-4 align-items-center">
		<h3 class="m-0">Customers</h3>
	</div>
	<div class="card">
		<div class="card-body">
	    <!-- Filter Section -->
	    <form action="<%=search%>" method="post" onsubmit="return validateDates()">
	        <div class="row">
	            <!-- Date Filters -->
	            <div class="col-md-9">
	                <div class="row align-items-end mb-3">
	                    <div class="col-md-3">
	                        <label class="form-label">Date From *</label>
	                        <liferay-ui:input-date name="startDate"
	                            yearValue="<%=startYear%>" dayValue="<%=startDay%>"
	                            monthValue="<%=startMonth%>" cssClass="form-control" />
	                    </div>
	                    <div class="col-md-3">
	                        <label class="form-label">Date To *</label>
	                        <liferay-ui:input-date name="endDate" yearValue="<%=endYear%>"
	                            dayValue="<%=endDay%>" monthValue="<%=endMonth%>"
	                            cssClass="form-control" />
	                    </div>
	                    <div class="col-md-3">
	                        <label class="form-label">Search By</label>
	                        <select class="custom-select" id="filterDropdown" onchange="toggleFilterFields()">
	                            <option value="">--Select a filter--</option>
	                            <option value="poi">POI</option>
	                            <option value="poiType">POI Type</option>
	                            <option value="cif">CIF</option>
	                            <option value="nameEn">English Name</option>
	                            <option value="nameAr">Arabic Name</option>
	                            <option value="mobile">Mobile</option>
	                            <option value="allow">Allow</option>
	                        </select>
	                    </div>
	                    <!-- Search and Cancel Buttons -->
	                    <div class="col-md-3 d-flex justify-content-end">
	                        <button type="submit" class="btn btn-primary px-4 mr-2">Search</button>
	                        <button type="reset" class="btn btn-outline-secondary px-4">Cancel</button>
	                    </div>
	                </div>
	
	                <!-- Conditional Filter Fields -->
	                <div class="row">
	                    <div class="col-md-3 filter-field" id="poiField" style="display: none;">
	                        <label class="form-label">POI</label>
	                        <input type="text" class="form-control" id="poi" name="<portlet:namespace/>poi">
	                    </div>
	
	                    <div class="col-md-3 filter-field" id="poiTypeField" style="display: none;">
	                        <label class="form-label">POI Type</label>
	                        <select class="custom-select" id="poiType" name="<portlet:namespace/>poiType">
	                            <option value="">--Please choose an option--</option>
	                            <option value="1">National</option>
	                            <option value="2">Copy Of Iqama</option>
	                        </select>
	                    </div>
	
	                    <div class="col-md-3 filter-field" id="cifField" style="display: none;">
	                        <label class="form-label">CIF</label>
	                        <input type="text" class="form-control" id="cif" name="<portlet:namespace/>cif">
	                    </div>
	
	                    <div class="col-md-3 filter-field" id="nameEnField" style="display: none;">
	                        <label class="form-label">English Name</label>
	                        <input type="text" class="form-control" id="nameEn" name="<portlet:namespace/>nameEn">
	                    </div>
	
	                    <div class="col-md-3 filter-field" id="nameArField" style="display: none;">
	                        <label class="form-label">Arabic Name</label>
	                        <input type="text" class="form-control" id="nameAr" name="<portlet:namespace/>nameAr">
	                    </div>
	
	                    <div class="col-md-3 filter-field" id="mobileField" style="display: none;">
	                        <label class="form-label">Mobile</label>
	                        <input type="text" class="form-control" id="mobile" name="<portlet:namespace/>mobile"
	                            pattern="966[0-9]{8,}" title="Mobile number must start with 966 and be followed by 8 or more digits"
	                            placeholder="966xxxxxxxx">
	                    </div>
	
	                    <div class="col-md-3 filter-field" id="allowField" style="display: none;">
	                        <label class="form-label">Allow</label>
	                        <select class="custom-select" id="allow" name="<portlet:namespace/>allow">
	                            <option value="">--Please choose an option--</option>
	                            <option value="Y">YES</option>
	                            <option value="N">NO</option>
	                        </select>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </form>
	
	    <!-- Export Button -->
	    <div class="row mt-3">
	        <div class="col-md-12 d-flex justify-content-end">
	            <portlet:actionURL name="exportCsv" var="exportCsvUrl" />
	            <button class="btn btn-primary px-3" onclick="location.href='<%= exportCsvUrl %>'">Export as CSV</button>
	        </div>
	    </div>
	</div>


			<!-- Table Section -->
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">
							Created Date
								<span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrows-vertical" viewBox="0 0 16 16">
									  <path d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z"/>
									</svg>
								</span>
							</th>
							<th scope="col">
							POI
								<span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrows-vertical" viewBox="0 0 16 16">
									  <path d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z"/>
									</svg>
								</span>
							</th>
							<th scope="col">
							POI Type
								<span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrows-vertical" viewBox="0 0 16 16">
									  <path d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z"/>
									</svg>
								</span>
							</th>
							<th scope="col">CIF
								<span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrows-vertical" viewBox="0 0 16 16">
									  <path d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z"/>
									</svg>
								</span>
							</th>
							<th scope="col">
							English Name
								<span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrows-vertical" viewBox="0 0 16 16">
									  <path d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z"/>
									</svg>
								</span>
							</th>
							<th scope="col">
							Arabic Name
								<span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrows-vertical" viewBox="0 0 16 16">
									  <path d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z"/>
									</svg>
								</span>
							</th>
							<th scope="col">
							Mobile
								<span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrows-vertical" viewBox="0 0 16 16">
									  <path d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z"/>
									</svg>
								</span>
							</th>
							<th scope="col">
							Allow
								<span style="cursor: pointer;">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrows-vertical" viewBox="0 0 16 16">
									  <path d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z"/>
									</svg>
								</span>
							</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						<%
							List<WhiteListDTO> displayList = (types != null && !types.isEmpty()) ? types : records;
							for (WhiteListDTO record : displayList) {
						%>
						<tr>
							<td><%=record.getCreatedDate()%></td>
							<td><%=record.getPoi()%></td>
							<td><%=record.getPoiType()%></td>
							<td><%=record.getCif()%></td>
							<td><%=record.getNameEn()%></td>
							<td><%=record.getNameAr()%></td>
							<td><%=record.getMobile()%></td>
							<td><%=record.getAllow()%></td>
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
											href=<portlet:actionURL name="beforeUpdateStatus" >
													<portlet:param name="poi" value="<%=record.getPoi()%>" />
													<portlet:param name="allow" value="<%=record.getAllow()%>" />
													<portlet:param name="enName" value="<%=record.getNameEn()%>" />
													<portlet:param name="arName" value="<%=record.getNameAr()%>" />
													<portlet:param name="cif" value="<%=record.getCif()%>" />
													<portlet:param name="mobile" value="<%=record.getMobile()%>" />
												</portlet:actionURL>
											class="dropdown-item"> Edit </a>
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

	function validateDates() {
		var startDate = new Date(document
				.getElementById('<portlet:namespace/>startDate').value);
		var endDate = new Date(document
				.getElementById('<portlet:namespace/>endDate').value);

		if (startDate >= endDate) {
			alert('End date must be later than start date.');
			return false; // Prevent form submission
		}

		return true; // Allow form submission
	}
	
	function toggleFilterFields() {
        // Hide all filter fields initially
        document.querySelectorAll('.filter-field').forEach(field => field.style.display = 'none');

        // Show selected filter field based on dropdown
        const selectedFilter = document.getElementById('filterDropdown').value;
        if (selectedFilter) {
            document.getElementById(selectedFilter + 'Field').style.display = 'block';
        }
    }
</script>