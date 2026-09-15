<%@page import="com.ejada.telemony.db.service.LovsLocalServiceUtil"%>
<%@page import="com.ejada.telemony.db.model.LovData"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>





<portlet:actionURL name="newLovDataForm" var="newLovDataForm">
</portlet:actionURL>

<portlet:actionURL var="getLovDataUpdateId" name="getLovDataUpdateId">
</portlet:actionURL>

<portlet:actionURL var="lovDataDelete" name="lovDataDelete">
</portlet:actionURL>

<portlet:actionURL var="search" name="search">
</portlet:actionURL>

<portlet:renderURL var="clear">
	<portlet:param name="action" value="view" />
</portlet:renderURL>

<portlet:actionURL name="viewData" var="iteratorURL">
</portlet:actionURL>
<%-- <portlet:actionURL name="viewData" var="viewData">
</portlet:actionURL>

<portlet:renderURL var="viewLovData">
	<portlet:param name="viewLovData" value="viewLovData" />
</portlet:renderURL>
 --%>

<%
	List<LovData> records = request.getAttribute("lovdata") != null
			? (List<LovData>) request.getAttribute("lovdata")
			: new ArrayList<>();

	/* List<LovData> entries = request.getAttribute("entries") != null
			? (List<LovData>) request.getAttribute("entries")
			: new ArrayList<>();
 */
 	List<LovData> data = request.getAttribute("data") != null
			? (List<LovData>) request.getAttribute("data")
			: new ArrayList<>();
 
	 Long parentId = request.getAttribute("parentId") != null ? (Long) request.getAttribute("parentId") : 1;
	String lovType = LovsLocalServiceUtil.getLovs(parentId).getName("English"); 

	List<LovData> displayList = (data != null && !data.isEmpty()) ? data : records;

	// Check for pending version
	Boolean hasPendingVersionObj = (Boolean) request.getAttribute("hasPendingVersion");
	boolean hasPendingVersion = hasPendingVersionObj != null && hasPendingVersionObj;

	// Get set of lov data with pending versions
	java.util.Set<Long> lovDataWithPendingVersions = (java.util.Set<Long>) request.getAttribute("lovDataWithPendingVersions");
	if (lovDataWithPendingVersions == null) {
		lovDataWithPendingVersions = new java.util.HashSet<>();
	}

%>

<h3 class="pb-4">LOVS Data
	<% if (hasPendingVersion) { %>
	<span class="badge badge-warning ml-2" style="font-size: 0.65rem; vertical-align: middle; background-color: #f0ad4e;">
		Pending Approval - View Only
	</span>
	<% } %>
</h3>

<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
<liferay-ui:error key="hasPendingVersion" message="This LOV has a pending draft version and cannot be modified until it is approved or discarded." />
<liferay-ui:error key="lovDataLinkedToFeature" message="This value cannot be deleted because it is currently linked to one or more Blue App features. Please remove it from those features first." />

<div class="card">
	<div class="card-body">
		
	<% if (!isOther && !hasPendingVersion) { %>
	<div class="d-flex justify-content-end">
			<form action=<%=newLovDataForm%> method="post"
				name="<portlet:namespace/>lovDataCreation"
				id="<portlet:namespace/>lovDataCreation">
				<a onclick="setNewData('<%=parentId%>','<%=lovType%>')"
					class="btn btn-primary px-5 mr-3"> Create New Data </a> <input
					type="text" class="d-none" name="<portlet:namespace/>lovId"
					id="<portlet:namespace/>lovId" /> <input type="text"
					class="d-none" name="<portlet:namespace/>lovType"
					id="<portlet:namespace/>lovType" />
			</form>
		</div>
	<% } %>
<form action=<%=search%> method="post">
			<div class="row">
				<div class="col-md-4">
					<div class="d-flex align-items-end mb-3">
						

						<div>
							<label class="form-label" >Search By</label>
								<select required
									class="custom-select mb-2" id="searchBy"
									name="<portlet:namespace/>searchBy">
									<option value="">Choose...</option>
									<option value="name">Name</option>
									<option value="code">CODE</option>
								</select>
							    <input type="text" required
							    style="width: 200px; " 
								class="form-control" id="searchInput"
								name="<portlet:namespace/>dataSearchName">
								<input
								type="hidden" class="form-control" id="typeIdd"
								name="<portlet:namespace/>typeIdd" value="<%=parentId%>">
						</div>
						<div class="d-flex">
							<button type="submit" class="btn btn-primary px-5 ml-3">Search</button> 
							<button type="button" class="btn btn-secondary px-5 ml-3"
									onclick="clearForm()">Clear</button>
						</div>
					</div>
				</div>
			</div>
		</form>

		<div class="row">
				<div class="col-md-4">
					<div class="d-flex align-items-end mb-3">
						<div>
							<h4 class="form-label">*The Type is: <%= lovType %></h4> 
						</div>
					</div>
					
					<div>
							<h4 class="form-label">*The Type ID is: <%= parentId %></h4> 
					</div>
					
				</div>
		</div>

		<liferay-ui:search-container 
			delta="10"
			emptyResultsMessage="Sorry. There are no records to display."
			total = "<%= displayList.size() %>"
			deltaConfigurable="true"
			>



			<liferay-ui:search-container-results 
			results="<%= ListUtil.subList(displayList,searchContainer.getStart(), searchContainer.getEnd()) %>">			
			<%-- <%
				results = entries ;
				total = records.size();
				pageContext.setAttribute("results", results);
		        pageContext.setAttribute("total", total);  
			%>		 --%>	
			</liferay-ui:search-container-results>



			<liferay-ui:search-container-row
				className="com.ejada.telemony.db.model.LovData" 
				keyProperty="id"
				modelVar="entry"
			>
				<%
					boolean entryHasPending = lovDataWithPendingVersions.contains(entry.getId());
				%>

				<liferay-ui:search-container-column-text name="Type Code">
					<%=entry.getRecordTypeCode()%>
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text
					value="<%=entry.getRecordDescription("English")%>"
					name=" Description" />
				<liferay-ui:search-container-column-text
					value="<%=entry.getRecordShortDescription()%>"
					name="Short Description" />


				<liferay-ui:search-container-column-text
					
					name="Action" >
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

									<% if (hasPendingVersion || entryHasPending) { %>
									<!-- Only show View option when there's a pending version -->
									<form action=<%=getLovDataUpdateId%> method="post"
										name="<portlet:namespace/>dataViewForm<%=entry.getId()%>"
										id="<portlet:namespace/>dataViewForm<%=entry.getId()%>">

										<a onclick="viewDataOnly('<%=entry.getId()%>')"
											class="dropdown-item"> View </a>
										<input type="hidden" name="<portlet:namespace/>lovDataId" value="<%=entry.getId()%>" />
										<input type="hidden" name="<portlet:namespace/>hasPendingVersion" value="true" />

									</form>
									<% } else if (!isOther) { %>
									<form action=<%=getLovDataUpdateId%> method="post"
										name="<portlet:namespace/>dataUpdateForm"
										id="<portlet:namespace/>dataUpdateForm">

										<a onclick="updateData('<%=entry.getId()%>')"
											class="dropdown-item"> Update Data </a> <input type="text"
											class="d-none" name="<portlet:namespace/>lovDataId"
											id="<portlet:namespace/>lovDataId" />
										<input type="hidden" name="<portlet:namespace/>hasPendingVersion" value="false" />

									</form>


									<form action="<%=lovDataDelete%>" method="post"
										name="<portlet:namespace/>dataDeleteForm"
										id="<portlet:namespace/>dataDeleteForm">
										<a onclick="deleteData('<%=entry.getId()%>')"
											class="dropdown-item"> Delete </a> <input type="text"
											class="d-none" name="<portlet:namespace/>deleteId"
											id="<portlet:namespace/>deleteId" />

									</form>
									<% } else { %>
									<form action=<%=getLovDataUpdateId%> method="post"
										name="<portlet:namespace/>dataUpdateForm"
										id="<portlet:namespace/>dataUpdateForm">

										<a onclick="updateData('<%=entry.getId()%>')"
											class="dropdown-item"> View </a> <input type="text"
											class="d-none" name="<portlet:namespace/>lovDataId"
											id="<portlet:namespace/>lovDataId" />


									</form>
									<% } %>
								</div>
							</div>
					
				</liferay-ui:search-container-column-text>
				
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator markupView="lexicon" />
		</liferay-ui:search-container>

	</div>

</div>

<div class="modal hide fade" id="telemoneyDeleteModal" tabindex="-1"
	role="dialog" aria-labelledby="telemoneyDeleteModalCenteredTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-100" role="document">
		<div class="modal-content w-auto m-auto">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">Delete
					Data</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body text-5 text-center">Are you sure you
				want to delete this data?</div>
			<div class="modal-footer justify-content-end">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="submit" class="btn btn-primary"
					onclick="deleteDataConfirm()">Confirm</button>
			</div>
		</div>
	</div>
</div>


<script>
	function deleteData(deletedId) {
		var recordIdFieldDelete = document
				.getElementById('<portlet:namespace/>deleteId');

		recordIdFieldDelete.value = deletedId;

		openModal();
	}

	function deleteDataConfirm() {
		document.getElementById('<portlet:namespace/>dataDeleteForm').submit();
	}
	function resetDelete() {
		var recordIdField = document
				.getElementById('<portlet:namespace/>deleteId');

		recordIdField.value = "";
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
	
	
	function setNewData(recordId, recordEnName) {
		var recordIdField = document
				.getElementById('<portlet:namespace/>lovId');
		var recordEnNameField = document
				.getElementById('<portlet:namespace/>lovType');
		recordIdField.value = recordId;
		recordEnNameField.value = recordEnName;
		document.getElementById('<portlet:namespace/>dataSubmitForm').submit();
	}

	function updateData(recordId) {
		var recordField = document
				.getElementById('<portlet:namespace/>lovDataId');

		recordField.value = recordId;

		document.getElementById('<portlet:namespace/>dataUpdateForm').submit();
	}

	function viewDataOnly(recordId) {
		document.getElementById('<portlet:namespace/>dataViewForm' + recordId).submit();
	}

	function setNewData(recordId, recordName) {
		var recordIdField = document
				.getElementById('<portlet:namespace/>lovId');
		var recordNameField = document
				.getElementById('<portlet:namespace/>lovType');

		recordIdField.value = recordId;
		recordNameField.value = recordName;

		document.getElementById('<portlet:namespace/>lovDataCreation').submit();
	}
	
	function clearForm() {
		document.getElementById('searchInput').value = '';
		window.location.href = window.location.pathname;
	}
</script>
