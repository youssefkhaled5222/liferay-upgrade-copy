<%@page import="com.ejada.telemony.db.model.AppConfigItem"%>
<%@page import="com.ejada.telemony.db.model.AppEnvironment"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<%
	Boolean entryDeleted = (Boolean)request.getAttribute("entryDeleted");
	if (Boolean.TRUE.equals(entryDeleted)) {
		Long deletedEntryId = (Long)request.getAttribute("deletedEntryId");
%>
<div class="alert alert-warning" role="alert">
	<strong class="lead">Entry Deleted:</strong>
	This App Config entry (ID: <%= deletedEntryId %>) has been deleted and is no longer available.
</div>
<%
		return;
	}

	AppEnvironment editedAppEnvironment =
		(AppEnvironment)request.getAttribute("editedAppEnvironment");
	AppEnvironment originalAppEnvironment =
		(AppEnvironment)request.getAttribute("originalAppEnvironment");

	List<AppConfigItem> editedConfigItems =
		(List<AppConfigItem>)request.getAttribute("editedConfigItems");
	List<AppConfigItem> originalConfigItems =
		(List<AppConfigItem>)request.getAttribute("originalConfigItems");

	if (editedConfigItems == null) {
		editedConfigItems = Collections.emptyList();
	}

	if (originalConfigItems == null) {
		originalConfigItems = Collections.emptyList();
	}

	String hyphen = "-";
	boolean hasEdited = editedAppEnvironment != null;
	boolean hasOriginal = originalAppEnvironment != null;

	String workflowAction = hasEdited ? editedAppEnvironment.getWorkflowAction() : null;
	String requestType = (workflowAction == null) ? hyphen : workflowAction;

	boolean isAddOperation = "ADD".equalsIgnoreCase(workflowAction);
	boolean isUpdateOperation = "UPDATE".equalsIgnoreCase(workflowAction);
	boolean isDeleteOperation = "DELETE".equalsIgnoreCase(workflowAction);

	String codeValue = hasEdited ? String.valueOf(editedAppEnvironment.getEnvironmentId()) : hyphen;
	String environmentNameFrom = isAddOperation ? hyphen :
		(hasOriginal ? originalAppEnvironment.getEnvironmentName() : hyphen);
	String environmentNameTo = isDeleteOperation ? hyphen :
		(hasEdited ? editedAppEnvironment.getEnvironmentName() : hyphen);
%>

<div class="table-responsive">
	<table class="tm-table">
		<tbody>
		<tr>
			<td class="tm-meta-label"><strong>Code</strong></td>
			<td class="tm-meta-value" colspan="2"><%= codeValue %></td>
		</tr>
		<tr>
			<td class="tm-meta-label"><strong>Request</strong></td>
			<td class="tm-meta-value" colspan="2"><%= requestType %></td>
		</tr>
		<tr>
			<td><strong>Environment Name</strong></td>
			<td colspan="2"><%= isDeleteOperation ? environmentNameFrom : environmentNameTo %></td>
		</tr>
		</tbody>
	</table>
</div>

<% if (hasOriginal && (isUpdateOperation || isDeleteOperation)) { %>
<div class="mt-3">
	<h5>Config Items - From</h5>
	<div class="table-responsive">
		<table class="tm-table">
			<thead class="tm-header">
			<tr>
				<th scope="col">Key</th>
				<th scope="col">Type</th>
				<th scope="col">Value</th>
			</tr>
			</thead>
			<tbody>
			<% if (originalConfigItems.isEmpty()) { %>
			<tr>
				<td colspan="3"><%= hyphen %></td>
			</tr>
			<% } else { %>
			<% for (AppConfigItem item : originalConfigItems) { %>
			<tr>
				<td><%= item.getKeyName() %></td>
				<td><%= item.getValueType() %></td>
				<td><%= item.getValue() %></td>
			</tr>
			<% } %>
			<% } %>
			</tbody>
		</table>
	</div>
</div>
<% } %>

<div class="mt-3">
	<h5>Config Items - To</h5>
	<div class="table-responsive">
		<table class="tm-table">
			<thead class="tm-header">
			<tr>
				<th scope="col">Key</th>
				<th scope="col">Type</th>
				<th scope="col">Value</th>
			</tr>
			</thead>
			<tbody>
			<% if (editedConfigItems.isEmpty() || isDeleteOperation) { %>
			<tr>
				<td colspan="3"><%= hyphen %></td>
			</tr>
			<% } else { %>
			<% for (AppConfigItem item : editedConfigItems) { %>
			<tr>
				<td><%= item.getKeyName() %></td>
				<td><%= item.getValueType() %></td>
				<td><%= item.getValue() %></td>
			</tr>
			<% } %>
			<% } %>
			</tbody>
		</table>
	</div>
</div>


<style>
	.tm-table {
		width: 100%;
		border-collapse: collapse;
		font-family: "Helvetica", "Arial", sans-serif;
	}
	.tm-table th, .tm-table td {
		border: 1px solid #d1d5db;
		padding: 8px 10px;
		text-align: left;
	}
	.tm-meta-label {
		font-weight: 700;
		width: 180px;
	}
	.tm-meta-value {
		font-weight: 400;
	}
	.tm-header th {
		background-color: #f3f4f6;
		font-weight: 700;
	}
	.tm-from {
		color: #dc2626;
		text-decoration: line-through;
	}
	.tm-to {
		color: #16a34a;
	}
</style>
