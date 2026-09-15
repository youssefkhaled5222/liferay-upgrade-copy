<%@page import="java.util.ArrayList"%>
<%@page import="com.ejada.telemony.db.model.Persona"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ include file="/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>


<portlet:renderURL var="add_persona">
	<portlet:param name="mvcPath" value="/add.jsp" />
</portlet:renderURL>

<portlet:actionURL name="personaDelete" var="personaDelete">
</portlet:actionURL>

<portlet:actionURL name="getPersonaUpdateId" var="getPersonaUpdateId">
</portlet:actionURL>

<portlet:actionURL name="getPersonaViewId" var="getPersonaViewId">
</portlet:actionURL>

<portlet:actionURL name="getPendingPersonaViewId" var="getPendingPersonaViewId">
</portlet:actionURL>

<portlet:actionURL name="beforeCreatePersona" var="beforeCreatePersona">
</portlet:actionURL>

<%
	List<Persona> records = (List<Persona>) request.getAttribute("records") != null
			? (List<Persona>) request.getAttribute("records")
			: new ArrayList<>();

	List<Persona> defualtPersonas = (List<Persona>) request.getAttribute("defaultPersonas") != null
			? (List<Persona>) request.getAttribute("defaultPersonas")
			: new ArrayList<>();

	Map<Persona, Boolean> recordsWithPending = (Map<Persona, Boolean>) request.getAttribute("recordsWithPending");
	Map<Persona, Boolean> defaultPersonasWithPending = (Map<Persona, Boolean>) request.getAttribute("defaultPersonasWithPending");
%>

<div>
	<h3 class="pb-4">Persona List</h3>
	<h4 class="mb-3">Original Persona</h4>
	<liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />
	<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
	<liferay-ui:error key="linkedToBanner" message='<%= "This persona is currently linked to the following banner(s): " + request.getAttribute("linkedBannerNames") + ". Please unlink it from the banner(s) first." %>' />
	<div class="my-3 pb-5">
		<%
			for (Persona record : defualtPersonas) {
				boolean isPending = false;
				if (defaultPersonasWithPending != null && defaultPersonasWithPending.containsKey(record)) {
					Boolean pending = defaultPersonasWithPending.get(record);
					isPending = pending != null && pending;
				}
		%>
		<div class="col-md-2 mb-4">
			<div class="card bg-info text-white h-100">
				<div class="card-body d-flex flex-column h-100">
					<div class="icon d-flex justify-content-end">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-person-square"
							viewBox="0 0 16 16">
						  <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
						  <path
								d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm12 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1v-1c0-1-1-4-6-4s-6 3-6 4v1a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12z" />
						</svg>
					</div>
					<div class="h2 pt-5"><%=record.getName()%></div>
					<div class="h5 pt-3">
						Priority:
						<%=record.getPriority()%></div>
					<div class="mt-auto">
						<% if (isPending) { %>
							<div class="d-flex align-items-center justify-content-between">
								<span class="label label-warning">Pending</span>
								<div class="dropdown dropright">
									<button class="btn text-white dropdown-toggle p-0" type="button"
										id="dropdownMenuButtonPending0" data-toggle="dropdown"
										aria-haspopup="true" aria-expanded="false">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
											fill="currentColor" class="bi bi-three-dots-vertical"
											viewBox="0 0 16 16">
										  <path
												d="M9.5 13a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z" />
										</svg>
									</button>
									<div class="dropdown-menu" aria-labelledby="dropdownMenuButtonPending0">
										<form action=<%=getPendingPersonaViewId%> method="post"
											name="<portlet:namespace/>pendingPersonaViewForm"
											id="<portlet:namespace/>pendingPersonaViewForm">
											<a onclick="viewPendingPersona('<%=record.getPersonaId()%>')"
												class="dropdown-item"> View </a> <input type="text"
												class="d-none" name="<portlet:namespace/>pendingPersonaId"
												id="<portlet:namespace/>pendingPersonaId" />
										</form>
									</div>
								</div>
							</div>
						<% } else { %>
						<div class="dropdown d-flex justify-content-end dropright">
							<button class="btn text-white dropdown-toggle p-0" type="button"
								id="dropdownMenuButton0" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-three-dots-vertical"
									viewBox="0 0 16 16">
							  <path
										d="M9.5 13a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z" />
							</svg>
							</button>
							<div class="dropdown-menu" aria-labelledby="dropdownMenuButton0">

								<% if (isAdministrator || isPo || isMarketing) { %>
								<form action=<%=getPersonaUpdateId%> method="post"
									name="<portlet:namespace/>personaIdUpdateForm"
									id="<portlet:namespace/>personaIdUpdateForm">
									<a onclick="updatePersona('<%=record.getPersonaId()%>')"
										class="dropdown-item"> View / Update </a> <input type="text"
										class="d-none" name="<portlet:namespace/>personaId"
										id="<portlet:namespace/>personaId" />
								</form>
								<% } else { %>
								<form action=<%=getPersonaViewId%> method="post"
									name="<portlet:namespace/>personaIdViewForm"
									id="<portlet:namespace/>personaIdViewForm">
									<a onclick="viewPersona('<%=record.getPersonaId()%>')"
										class="dropdown-item"> View </a> <input type="text"
										class="d-none" name="<portlet:namespace/>singlepersonaId"
										id="<portlet:namespace/>singlepersonaId" />
								</form>
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
	</div>

	<div class="my-3">
		<h4>Custom Personas</h4>
		<div class="row">
			<%
				for (Persona record : records) {
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
								fill="currentColor" class="bi bi-person-square"
								viewBox="0 0 16 16">
						  <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
						  <path
									d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm12 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1v-1c0-1-1-4-6-4s-6 3-6 4v1a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12z" />
						</svg>
						</div>
						<div class="h2 pt-5"><%=record.getName()%></div>
						<div class="h5 pt-3">
							Priority:
							<%=record.getPriority()%></div>
						<div class="mt-auto">
							<% if (isPending) { %>
								<div class="d-flex align-items-center justify-content-between">
									<span class="label label-warning">Pending</span>
									<div class="dropdown dropright">
										<button class="btn text-white dropdown-toggle p-0" type="button"
											id="dropdownMenuButtonPending1" data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="false">
											<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
												fill="currentColor" class="bi bi-three-dots-vertical"
												viewBox="0 0 16 16">
											  <path
													d="M9.5 13a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z" />
											</svg>
										</button>
										<div class="dropdown-menu" aria-labelledby="dropdownMenuButtonPending1">
											<form action=<%=getPendingPersonaViewId%> method="post"
												name="<portlet:namespace/>pendingPersonaViewFormCustom"
												id="<portlet:namespace/>pendingPersonaViewFormCustom">
												<a onclick="viewPendingPersonaCustom('<%=record.getPersonaId()%>')"
													class="dropdown-item"> View </a> <input type="text"
													class="d-none" name="<portlet:namespace/>pendingPersonaId"
													id="<portlet:namespace/>pendingPersonaIdCustom" />
											</form>
										</div>
									</div>
								</div>
							<% } else { %>
							<div class="dropdown d-flex justify-content-end dropright">
								<button class="btn text-white dropdown-toggle p-0" type="button"
									id="dropdownMenuButton0" data-toggle="dropdown"
									aria-haspopup="true" aria-expanded="false">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-three-dots-vertical"
										viewBox="0 0 16 16">
							  <path
											d="M9.5 13a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z" />
							</svg>
								</button>
								<div class="dropdown-menu" aria-labelledby="dropdownMenuButton0">
									<% if (isAdministrator || isPo || isMarketing) { %>
									<form action=<%=getPersonaUpdateId%> method="post"
										name="<portlet:namespace/>personaIdUpdateForm"
										id="<portlet:namespace/>personaIdUpdateForm">
										<a onclick="updatePersona('<%=record.getPersonaId()%>')"
											class="dropdown-item"> View / Update </a> <input type="text"
											class="d-none" name="<portlet:namespace/>personaId"
											id="<portlet:namespace/>personaId" />
									</form>

									<form action=<%=personaDelete%> method="post"
										name="<portlet:namespace/>personaDeleteForm"
										id="<portlet:namespace/>personaDeleteForm">
										<a onclick="deletePersona('<%=record.getPersonaId()%>')"
											class="dropdown-item"> Delete </a> <input type="text"
											class="d-none" name="<portlet:namespace/>deleteId"
											id="<portlet:namespace/>deleteId" />
									</form>
									<% } else { %>
									<form action=<%=getPersonaViewId%> method="post"
										name="<portlet:namespace/>personaIdViewForm"
										id="<portlet:namespace/>personaIdViewForm">
										<a onclick="viewPersona('<%=record.getPersonaId()%>')"
											class="dropdown-item"> View </a> <input type="text"
											class="d-none" name="<portlet:namespace/>singlepersonaId"
											id="<portlet:namespace/>singlepersonaId" />
									</form>
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
			<% if (isAdministrator || isPo || isMarketing) { %>
			<div class="col-md-2 mb-4">
				<div class="card bg-light text-dark h-100">
					<div class="card-body d-flex flex-column h-100">
						<div class="icon d-flex justify-content-end">
							<a href="<%=beforeCreatePersona%>">
								<button class="btn p-0">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-plus-lg" viewBox="0 0 16 16">
							  <path fill-rule="evenodd"
											d="M8 2a.5.5 0 0 1 .5.5v5h5a.5.5 0 0 1 0 1h-5v5a.5.5 0 0 1-1 0v-5h-5a.5.5 0 0 1 0-1h5v-5A.5.5 0 0 1 8 2Z" />
							</svg>
								</button>
							</a>
						</div>
						<div class="h2 pt-5 mt-auto">Add Persona</div>
					</div>
				</div>
			</div>
			<% } %>
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
					Persona</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body text-5 text-center">Are you sure you
				want to delete this persona?</div>
			<div class="modal-footer justify-content-end">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="submit" class="btn btn-primary"
					onclick="deletePersonaConfirm()">Confirm</button>
			</div>
		</div>
	</div>
</div>

<script>
	function deletePersona(recordId) {
		var recordIdField = document
				.getElementById('<portlet:namespace/>deleteId');

		recordIdField.value = recordId;
		openModal();

		/* 		document.getElementById('<portlet:namespace/>personaDeleteForm')
		 .submit(); */
	}

	function deletePersonaConfirm() {
		document.getElementById('<portlet:namespace/>personaDeleteForm')
				.submit();
		
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

	function updatePersona(Id) {
		var recordIdField = document
				.getElementById('<portlet:namespace/>personaId');

		recordIdField.value = Id;

		document.getElementById('<portlet:namespace/>personaIdUpdateForm')
				.submit();
	}

	function viewPersona(recoId) {
		var recordIdField = document
				.getElementById('<portlet:namespace/>singlepersonaId');

		recordIdField.value = recoId;

		document.getElementById('<portlet:namespace/>personaIdViewForm')
				.submit();
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

	function viewPendingPersona(Id) {
		var recordIdField = document
				.getElementById('<portlet:namespace/>pendingPersonaId');

		recordIdField.value = Id;

		document.getElementById('<portlet:namespace/>pendingPersonaViewForm')
				.submit();
	}

	function viewPendingPersonaCustom(Id) {
		var recordIdField = document
				.getElementById('<portlet:namespace/>pendingPersonaIdCustom');

		recordIdField.value = Id;

		document.getElementById('<portlet:namespace/>pendingPersonaViewFormCustom')
				.submit();
	}
</script>
