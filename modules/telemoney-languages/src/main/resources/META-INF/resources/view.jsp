<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="com.ejada.telemony.db.model.Languages"%>
<%@ include file="/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>


<portlet:actionURL name="languageDelete" var="languageDelete">
</portlet:actionURL>

<portlet:actionURL name="getLanguageUpdateId" var="getLanguageUpdateId">
</portlet:actionURL>

<portlet:actionURL name="getLanguageViewId" var="getLanguageViewId">
</portlet:actionURL>

<portlet:actionURL name="getPendingLanguageViewId" var="getPendingLanguageViewId">
</portlet:actionURL>

<portlet:renderURL var="add_language">
	<portlet:param name="mvcPath" value="/add.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addLanguagereq" var="addLanguagereq">
</portlet:actionURL>




<%
	List<Languages> records = (List<Languages>) request.getAttribute("records") != null
			? (List<Languages>) request.getAttribute("records")
			: new ArrayList<>();

	Map<Languages, Boolean> recordsWithPending = (Map<Languages, Boolean>) request.getAttribute("recordsWithPending");
%>





<div>
	<h3 class="pb-4">
		Languages
		</h5>
		<liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />
		<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />

		<div class="row">

			<%
				for (Languages record : records) {
					boolean isPending = false;
					if (recordsWithPending != null && recordsWithPending.containsKey(record)) {
						Boolean pending = recordsWithPending.get(record);
						isPending = pending != null && pending;
					}
			%>
			<div class="col-md-2 mb-4">



				<div class="card bg-info text-white h-100">
					<div class="card-body d-flex flex-column h-100">
						<div class="icon d-flex justify-content-end">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								fill="currentColor" class="bi bi-globe" viewBox="0 0 16 16">
<path
									d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm7.5-6.923c-.67.204-1.335.82-1.887 1.855A7.97 7.97 0 0 0 5.145 4H7.5V1.077zM4.09 4a9.267 9.267 0 0 1 .64-1.539 6.7 6.7 0 0 1 .597-.933A7.025 7.025 0 0 0 2.255 4H4.09zm-.582 3.5c.03-.877.138-1.718.312-2.5H1.674a6.958 6.958 0 0 0-.656 2.5h2.49zM4.847 5a12.5 12.5 0 0 0-.338 2.5H7.5V5H4.847zM8.5 5v2.5h2.99a12.495 12.495 0 0 0-.337-2.5H8.5zM4.51 8.5a12.5 12.5 0 0 0 .337 2.5H7.5V8.5H4.51zm3.99 0V11h2.653c.187-.765.306-1.608.338-2.5H8.5zM5.145 12c.138.386.295.744.468 1.068.552 1.035 1.218 1.65 1.887 1.855V12H5.145zm.182 2.472a6.696 6.696 0 0 1-.597-.933A9.268 9.268 0 0 1 4.09 12H2.255a7.024 7.024 0 0 0 3.072 2.472zM3.82 11a13.652 13.652 0 0 1-.312-2.5h-2.49c.062.89.291 1.733.656 2.5H3.82zm6.853 3.472A7.024 7.024 0 0 0 13.745 12H11.91a9.27 9.27 0 0 1-.64 1.539 6.688 6.688 0 0 1-.597.933zM8.5 12v2.923c.67-.204 1.335-.82 1.887-1.855.173-.324.33-.682.468-1.068H8.5zm3.68-1h2.146c.365-.767.594-1.61.656-2.5h-2.49a13.65 13.65 0 0 1-.312 2.5zm2.802-3.5a6.959 6.959 0 0 0-.656-2.5H12.18c.174.782.282 1.623.312 2.5h2.49zM11.27 2.461c.247.464.462.98.64 1.539h1.835a7.024 7.024 0 0 0-3.072-2.472c.218.284.418.598.597.933zM10.855 4a7.966 7.966 0 0 0-.468-1.068C9.835 1.897 9.17 1.282 8.5 1.077V4h2.355z" />
</svg>
						</div>



						<div class="h2 pt-5"><%=record.getLangName()%></div>
						<div class="font-weight-bold"><%=record.getPrimaryLanguage() ? "PRIMARY" : ""%></div>
						<div class="mt-auto">
							<% if (isPending) { %>
								<div class="d-flex align-items-center justify-content-between">
									<span class="label label-warning">Pending</span>
									<div class="dropdown dropright">
										<button class="btn text-white dropdown-toggle p-0" type="button"
											id="dropdownMenuButtonPending" data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="false">
											<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
												fill="currentColor" class="bi bi-three-dots-vertical"
												viewBox="0 0 16 16">
												<path d="M9.5 13a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z" />
											</svg>
										</button>
										<div class="dropdown-menu" aria-labelledby="dropdownMenuButtonPending">
											<form action="<%=getPendingLanguageViewId%>" method="post"
												name="<portlet:namespace/>pendingLangViewForm"
												id="<portlet:namespace/>pendingLangViewForm">
												<a onclick="viewPendingLang('<%=record.getLanguageId()%>')"
													class="dropdown-item"> View </a>
												<input type="text" class="d-none"
													name="<portlet:namespace/>pendingLanguageId"
													id="<portlet:namespace/>pendingLanguageId" />
											</form>
										</div>
									</div>
								</div>
							<% } else { %>
							<div class="dropdown d-flex justify-content-end dropright">
								<button class="btn text-white dropdown-toggle p-0" type="button"
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
									<form action=<%=getLanguageViewId%> method="post"
										name="<portlet:namespace/>langVieweForm"
										id="<portlet:namespace/>langVieweForm">
										<a onclick="viewLang('<%=record.getLanguageId()%>')"
											class="dropdown-item"> View </a> <input type="text"
											class="d-none" name="<portlet:namespace/>viewedId"
											id="<portlet:namespace/>viewedId" />
									</form>

									<% if (isAdministrator || isPo ) { %>
									<%
										if (!record.getPrimaryLanguage()) {
									%>
									<form action=<%=languageDelete%> method="post"
										name="<portlet:namespace/>langDeleteForm"
										id="<portlet:namespace/>langDeleteForm">
										<a onclick="deleteLanguage('<%=record.getLanguageId()%>')"
											class="dropdown-item"> Delete </a> <input type="text"
											class="d-none" name="<portlet:namespace/>deleteId"
											id="<portlet:namespace/>deleteId" />
									</form>
									<%
										}

									%>
									<% } %>

								</div>
							</div>
							<% } %>


						</div>
					</div>
				</div>
			</div>
			<%
				}
			%>
			<% if (isAdministrator || isPo) { %>
			<div class="col-md-2 mb-4">
				<div class="card bg-light text-dark h-100">
					<div class="card-body d-flex flex-column h-100">
						<div class="icon d-flex justify-content-end">
							<a href="<%=addLanguagereq%>">
								<button class="btn p-0">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-plus-lg" viewBox="0 0 16 16">
<path fill-rule="evenodd"
											d="M8 2a.5.5 0 0 1 .5.5v5h5a.5.5 0 0 1 0 1h-5v5a.5.5 0 0 1-1 0v-5h-5a.5.5 0 0 1 0-1h5v-5A.5.5 0 0 1 8 2Z" />
</svg>
								</button>
							</a>
						</div>
						<div class="h2 pt-5 mt-auto">Add Language</div>
					</div>
				</div>
			</div>
			<% } %>
		</div>
</div>
<div class="modal hide fade" id="telemoneyDeleteModal" tabindex="-1"
	role="dialog" aria-labelledby="telemoneyDeleteModalCenteredTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-100" role="document">
		<div class="modal-content w-auto m-auto">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">Delete
					Language</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body text-5 text-center">Are you sure you
				want to delete this langauge?</div>
			<div class="modal-footer justify-content-end">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="submit" class="btn btn-primary"
					onclick="deleteLangConfirm()">Confirm</button>
			</div>
		</div>
	</div>
</div>
<script>
	function deleteLanguage(recordId) {
		console.log("dardiiiiiiiiir");
		var recordIdField = document
				.getElementById('<portlet:namespace/>deleteId');

		recordIdField.value = recordId;
		openModal();
		/* 		document.getElementById('<portlet:namespace/>langDeleteForm').submit();
		 */
	}

	function deleteLangConfirm() {

		document.getElementById('<portlet:namespace/>langDeleteForm').submit();
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

	function updateLang(langId) {
		var recordIdField = document
				.getElementById('<portlet:namespace/>langId');

		recordIdField.value = langId;

		document.getElementById('<portlet:namespace/>langUpdateForm').submit();
	}

	function viewLang(langId) {
		var recordIdField = document
				.getElementById('<portlet:namespace/>viewedId');

		recordIdField.value = langId;

		document.getElementById('<portlet:namespace/>langVieweForm').submit();
	}

	function viewPendingLang(langId) {
		var recordIdField = document
				.getElementById('<portlet:namespace/>pendingLanguageId');

		recordIdField.value = langId;

		document.getElementById('<portlet:namespace/>pendingLangViewForm').submit();
	}
</script>



