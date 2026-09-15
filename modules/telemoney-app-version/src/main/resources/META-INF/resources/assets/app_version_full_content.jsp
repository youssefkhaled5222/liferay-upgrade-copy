<%@page import="com.ejada.telemony.db.model.AppVersion"%>
<%@page import="java.util.Objects"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>

<%
    // Check if entry was deleted
    Boolean entryDeleted = (Boolean) request.getAttribute("entryDeleted");
    if (Boolean.TRUE.equals(entryDeleted)) {
        Long deletedEntryId = (Long) request.getAttribute("deletedEntryId");
%>
<div class="alert alert-warning" role="alert">
    <span class="alert-indicator">
        <svg class="lexicon-icon lexicon-icon-warning-full" focusable="false" role="presentation" viewBox="0 0 512 512">
            <path class="lexicon-icon-outline" d="M506.3,427L293.2,55.1c-17.5-30.6-61-30.6-78.5,0L1.7,427c-17.5,30.5,4.4,68.6,39.3,68.6h426.1C501.9,495.6,523.8,457.5,506.3,427z M256,432c-17.6,0-32-14.4-32-32s14.4-32,32-32s32,14.4,32,32S273.6,432,256,432z M288,320c0,17.6-14.4,32-32,32s-32-14.4-32-32V192c0-17.6,14.4-32,32-32s32,14.4,32,32V320z"></path>
        </svg>
    </span>
    <strong class="lead">Entry Deleted:</strong> This App Version entry (ID: <%= deletedEntryId %>) has been deleted and is no longer available.
</div>
<%
        return;
    }

    AppVersion editedAppVersion = (AppVersion) request.getAttribute("editedAppVersion");
    AppVersion originalAppVersion = (AppVersion) request.getAttribute("originalAppVersion");

    boolean hasEdited = editedAppVersion != null;
    boolean hasOriginal = originalAppVersion != null;

    String hyphen = "-";

    // Request type is driven by persisted workflowAction (ADD/UPDATE/DELETE)
    String workflowAction = hasEdited ? editedAppVersion.getWorkflowAction() : null;
    String requestType = (workflowAction == null) ? hyphen : workflowAction;

    boolean isAddOperation = "ADD".equalsIgnoreCase(workflowAction);
    boolean isUpdateOperation = "UPDATE".equalsIgnoreCase(workflowAction);
    boolean isDeleteOperation = "DELETE".equalsIgnoreCase(workflowAction);

    // Keep the changed flags only for UI highlighting (From/To styles)
    boolean platformChanged = hasEdited && hasOriginal && !Objects.equals(editedAppVersion.getPlatform(), originalAppVersion.getPlatform());
    boolean versionChanged = hasEdited && hasOriginal && !Objects.equals(editedAppVersion.getVersionNumber(), originalAppVersion.getVersionNumber());
    boolean urlChanged = hasEdited && hasOriginal && !Objects.equals(editedAppVersion.getUrl(), originalAppVersion.getUrl());
    boolean statusChanged = hasEdited && hasOriginal && !Objects.equals(editedAppVersion.getAppVersionStatus(), originalAppVersion.getAppVersionStatus());


    String codeValue = hasEdited ? String.valueOf(editedAppVersion.getVersionId()) : hyphen;

    String platformFrom = isAddOperation ? hyphen : (hasOriginal ? originalAppVersion.getPlatform() : hyphen);
    String platformTo = isDeleteOperation ? hyphen : (hasEdited ? editedAppVersion.getPlatform() : hyphen);

    String versionFrom = isAddOperation ? hyphen : (hasOriginal ? originalAppVersion.getVersionNumber() : hyphen);
    String versionTo = isDeleteOperation ? hyphen : (hasEdited ? editedAppVersion.getVersionNumber() : hyphen);

    String urlFrom = isAddOperation ? hyphen : (hasOriginal ? originalAppVersion.getUrl() : hyphen);
    String urlTo = isDeleteOperation ? hyphen : (hasEdited ? editedAppVersion.getUrl() : hyphen);

    String statusFrom = isAddOperation ? hyphen : (hasOriginal ? (originalAppVersion.getAppVersionStatus() ? "Active" : "Not Active") : hyphen);
    String statusTo = isDeleteOperation ? hyphen : (hasEdited ? (editedAppVersion.getAppVersionStatus() ? "Active" : "Not Active") : hyphen);

    String fromClass = (isUpdateOperation || isDeleteOperation) ? "tm-from" : "";
    String toClass = (isUpdateOperation || isAddOperation) ? "tm-to" : "";
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
        <tr class="tm-header">
            <th scope="col">Field</th>
            <th scope="col">From</th>
            <th scope="col">To</th>
        </tr>
        <% if (!isUpdateOperation || platformChanged) { %>
        <tr>
            <td><strong>Platform</strong></td>
            <td class="<%= fromClass %>"><%= platformFrom %></td>
            <td class="<%= toClass %>"><%= platformTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdateOperation || versionChanged) { %>
        <tr>
            <td><strong>Version Number</strong></td>
            <td class="<%= fromClass %>"><%= versionFrom %></td>
            <td class="<%= toClass %>"><%= versionTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdateOperation || urlChanged) { %>
        <tr>
            <td><strong>URL</strong></td>
            <td class="<%= fromClass %>"><%= urlFrom %></td>
            <td class="<%= toClass %>"><%= urlTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdateOperation || statusChanged) { %>
        <tr>
            <td><strong>Status</strong></td>
            <td class="<%= fromClass %>"><%= statusFrom %></td>
            <td class="<%= toClass %>"><%= statusTo %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
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
