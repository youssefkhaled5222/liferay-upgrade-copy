<%@page import="com.ejada.telemony.db.model.AppVersion"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>

<portlet:renderURL var="addAppVersion">
	<portlet:param name="myView" value="add"/>
</portlet:renderURL>


<portlet:actionURL name="deleteAppVersion" var="deleteAppVersion" />
<portlet:actionURL name="editAppVersion" var="editAppVersion" />

<%
    List<AppVersion> records = (List<AppVersion>) request.getAttribute("records") != null
            ? (List<AppVersion>) request.getAttribute("records")
            : new ArrayList<>();

    Map<AppVersion, Boolean> recordsWithPending = (Map<AppVersion, Boolean>) request.getAttribute("recordsWithPending");

    String errorMsg = (String) request.getAttribute("errorMessage") != null
            ? (String) request.getAttribute("errorMessage")
            : "";
%>

<div>
	<h3 class="pb-4">List of App Versions</h3>
	<liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />	
	<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />

	<div class="card">
		<div class="card-body">
                <% if (!isOther) { %>
                <div class="d-flex justify-content-end mb-3">
                    <a href="<%= addAppVersion %>">
                        <button type="button" class="btn btn-primary px-5 mr-3">Add New App Version</button>
                    </a>
                </div>
                <% } %>

                <table class="table">
                    <thead>
                    <tr>
                        <th>Platform</th>
                        <th>Version Number</th>
                        <th>URL</th>
                        <th>Status</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        for (AppVersion record : records) {
                            boolean isPending = false;

                            if (recordsWithPending != null && recordsWithPending.containsKey(record)) {
                                Boolean pending = recordsWithPending.get(record);
                                isPending = pending != null && pending;
                            }
                    %>
                    <tr>
                        <td><%= record.getPlatform() %></td>
                        <td><%= record.getVersionNumber() %></td>
                        <td>
                            <a href="<%= record.getUrl() %>" target="_blank"><%= record.getUrl() %></a>
                        </td>
                        <td>
                            <%= record.getAppVersionStatus() ? "Active" : "Not Active" %>
                        </td>
                        <td>
                            <% if (isPending) { %>
                                <span class="label label-warning">Pending</span>
                            <% } else { %>
                                <div class="dropdown">
                                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton<%= record.getVersionId() %>" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <!-- Three vertical dots SVG icon -->
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                             fill="currentColor" class="bi bi-three-dots-vertical"
                                             viewBox="0 0 16 16">
                                            <path d="M9.5 13a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z"/>
                                        </svg>
                                    </button>
                                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton<%= record.getVersionId() %>">
                                        <a class="dropdown-item" href="<portlet:renderURL><portlet:param name='myView' value='edit'/><portlet:param name='versionId' value='<%=String.valueOf(record.getVersionId()) %>'/></portlet:renderURL>"><%= isOther ? "View" : "Edit" %></a>
                                        <% if (!isOther) { %>
                                        <form action="<%=deleteAppVersion%>" method="post"
                                              name="<portlet:namespace/>appVersionDeleteForm"
                                              id="<portlet:namespace/>appVersionDeleteForm">
                                            <a onclick="openAppVersionDeleteModal('<%=record.getVersionId()%>')"
                                               class="dropdown-item">Delete</a>
                                            <input type="text" class="d-none" name="<portlet:namespace/>selectedVersionId"
                                                   id="<portlet:namespace/>selectedVersionId" />
                                        </form>
                                        <% } %>
                                    </div>
                                </div>
                            <% } %>
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
<div class="modal hide fade" id="appVersionDeleteModal" tabindex="-1"
	 role="dialog" aria-labelledby="telemoneyDeleteModalCenteredTitle"
	 aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-100" role="document">
		<div class="modal-content w-auto m-auto">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">Delete
					Resource</h5>
				<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body text-5 text-center">Are you sure you
				want to delete this App Version ?</div>
			<div class="modal-footer justify-content-end">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="submit" class="btn btn-primary"
						onclick="confirmAppVersionDelete()">Confirm</button>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">

	function openAppVersionDeleteModal(versionId) {
		var idField = document.getElementById('<portlet:namespace/>selectedVersionId');
		idField.value = versionId;
		showModal();
	}

	function confirmAppVersionDelete() {
		document.getElementById('<portlet:namespace/>appVersionDeleteForm').submit();
	}

	function resetAppVersionDelete() {
		var idField = document.getElementById('<portlet:namespace/>selectedVersionId');
		idField.value = "";
	}

	function showModal() {
		$("#appVersionDeleteModal").modal("show");
		$("#appVersionDeleteModal").removeClass("hide");
	}

	function closeModal() {
		$("#appVersionDeleteModal").modal("hide");
		$("#appVersionDeleteModal").addClass("hide");
	}

	$('#appVersionDeleteModal').on('hidden.bs.modal', function(e) {
		resetAppVersionDelete();
	})

</script>