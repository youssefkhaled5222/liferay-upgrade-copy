<%@ page import="com.ejada.telemony.db.model.Languages" %>
<%@ page import="java.util.Objects" %>
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
    <strong class="lead">Entry Deleted:</strong> This Language entry (ID: <%= deletedEntryId %>) has been deleted and is no longer available.
</div>
<%
        return;
    }

    Languages editedLanguage = (Languages) request.getAttribute("editedLanguage");
    Languages originalLanguage = (Languages) request.getAttribute("originalLanguage");

    boolean hasEdited = editedLanguage != null;
    boolean hasOriginal = originalLanguage != null;

    String hyphen = "-";

    // Request type is driven by persisted workflowAction (ADD/UPDATE/DELETE)
    String workflowAction = hasEdited ? editedLanguage.getWorkflowAction() : null;
    String requestType = (workflowAction == null) ? hyphen : workflowAction;

    boolean isAdd = "ADD".equalsIgnoreCase(workflowAction);
    boolean isUpdate = "UPDATE".equalsIgnoreCase(workflowAction);
    boolean isDelete = "DELETE".equalsIgnoreCase(workflowAction);

    // Prefer the edited key for code; fall back to original if needed
    String codeValue = hasEdited ? String.valueOf(editedLanguage.getLanguageId())
            : (hasOriginal ? String.valueOf(originalLanguage.getLanguageId()) : hyphen);

    String nameFrom = isAdd ? hyphen : (hasOriginal ? originalLanguage.getLangName() : hyphen);
    String nameTo = isDelete ? hyphen : (hasEdited ? editedLanguage.getLangName() : hyphen);

    String localFrom = isAdd ? hyphen : (hasOriginal ? originalLanguage.getLocal() : hyphen);
    String localTo = isDelete ? hyphen : (hasEdited ? editedLanguage.getLocal() : hyphen);

    String channelFrom = isAdd ? hyphen : (hasOriginal ? String.valueOf(originalLanguage.getChannelId()) : hyphen);
    String channelTo = isDelete ? hyphen : (hasEdited ? String.valueOf(editedLanguage.getChannelId()) : hyphen);

    String primaryFrom = isAdd ? hyphen : (hasOriginal ? (originalLanguage.getPrimaryLanguage() ? "Yes" : "No") : hyphen);
    String primaryTo = isDelete ? hyphen : (hasEdited ? (editedLanguage.getPrimaryLanguage() ? "Yes" : "No") : hyphen);

    boolean nameChanged = hasEdited && hasOriginal && !Objects.equals(nameFrom, nameTo);
    boolean localChanged = hasEdited && hasOriginal && !Objects.equals(localFrom, localTo);
    boolean channelChanged = hasEdited && hasOriginal && !Objects.equals(channelFrom, channelTo);
    boolean primaryChanged = hasEdited && hasOriginal && !Objects.equals(primaryFrom, primaryTo);

    String fromClass = (isUpdate || isDelete) ? "tm-from" : "";
    String toClass = (isUpdate || isAdd) ? "tm-to" : "";
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
        <% if (!isUpdate || nameChanged) { %>
        <tr>
            <td><strong>Name</strong></td>
            <td class="<%= fromClass %>"><%= nameFrom %></td>
            <td class="<%= toClass %>"><%= nameTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdate || localChanged) { %>
        <tr>
            <td><strong>Locale</strong></td>
            <td class="<%= fromClass %>"><%= localFrom %></td>
            <td class="<%= toClass %>"><%= localTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdate || channelChanged) { %>
        <tr>
            <td><strong>Channel ID</strong></td>
            <td class="<%= fromClass %>"><%= channelFrom %></td>
            <td class="<%= toClass %>"><%= channelTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdate || primaryChanged) { %>
        <tr>
            <td><strong>Primary Language</strong></td>
            <td class="<%= fromClass %>"><%= primaryFrom %></td>
            <td class="<%= toClass %>"><%= primaryTo %></td>
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
