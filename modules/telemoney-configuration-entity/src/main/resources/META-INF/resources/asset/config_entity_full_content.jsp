<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page import="java.util.Objects" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>

<portlet:renderURL var="cancel_Lang">
    <portlet:param name="action" value="view" />
</portlet:renderURL>

<%!
    // Helper method to get request type display name
    private String getRequestTypeDisplay(String workflowAction) {
        if (workflowAction == null) return "Unknown";

        String prefix = "";
        String entityPart = workflowAction;

        if (workflowAction.startsWith("ADD_")) {
            prefix = "Add ";
            entityPart = workflowAction.substring(4);
        } else if (workflowAction.startsWith("UPDATE_")) {
            prefix = "Update ";
            entityPart = workflowAction.substring(7);
        } else if (workflowAction.startsWith("DELETE_")) {
            prefix = "Delete ";
            entityPart = workflowAction.substring(7);
        }

        // Convert UPPER_CASE entity part to Title Case (e.g. "BILLER_CATEGORY" -> "Biller Category")
        StringBuilder sb = new StringBuilder();
        for (String word : entityPart.split("_")) {
            if (sb.length() > 0) sb.append(" ");
            if (word.length() > 0) {
                sb.append(Character.toUpperCase(word.charAt(0)));
                if (word.length() > 1) {
                    sb.append(word.substring(1).toLowerCase());
                }
            }
        }
        return prefix + sb.toString();
    }
%>

<%
    // Check if configuration entity has been deleted
    Boolean isDeleted = (Boolean) request.getAttribute("isDeleted");
    if (isDeleted != null && isDeleted) {
%>
<div class="container-fluid container-fluid-max-xl">
    <div class="alert alert-info" role="alert">
        <span class="alert-indicator">
            <svg class="lexicon-icon lexicon-icon-info-circle" focusable="false" role="presentation">
                <use href="/o/classic-theme/images/lexicon/icons.svg#info-circle"></use>
            </svg>
        </span>
        <strong class="lead">Asset Removed</strong>
        <p class="mb-0">The asset associated with this workflow task no longer exists. It may have been deleted or removed from the system.</p>
    </div>
</div>
<%
        return;
    }

    // Get attributes from request
    String workflowAction = (String) request.getAttribute("workflowAction");
    String workflowActionDisplay = (String) request.getAttribute("workflowActionDisplay");
    String entityType = (String) request.getAttribute("entityType");
    String entityTypeDisplay = (String) request.getAttribute("entityTypeDisplay");

    java.util.Map<String, String> oldDataMap = (java.util.Map<String, String>) request.getAttribute("oldDataMap");
    java.util.Map<String, String> newDataMap = (java.util.Map<String, String>) request.getAttribute("newDataMap");
    java.util.Map<String, String[]> changesMap = (java.util.Map<String, String[]>) request.getAttribute("changesMap");

    Boolean hasOldData = (Boolean) request.getAttribute("hasOldData");
    Boolean hasNewData = (Boolean) request.getAttribute("hasNewData");
    Boolean hasChanges = (Boolean) request.getAttribute("hasChanges");
    Boolean isAdd = (Boolean) request.getAttribute("isAdd");
    Boolean isUpdate = (Boolean) request.getAttribute("isUpdate");
    Boolean isDelete = (Boolean) request.getAttribute("isDelete");

    // Get workflow states
    Boolean isAlreadyApproved = (Boolean) request.getAttribute("isAlreadyApproved");
    boolean showApprovedBadge = isAlreadyApproved != null && isAlreadyApproved;

    Boolean isRejected = (Boolean) request.getAttribute("isRejected");
    boolean showRejectedBadge = isRejected != null && isRejected;

    Boolean isIncomplete = (Boolean) request.getAttribute("isIncomplete");
    boolean showIncompleteBadge = isIncomplete != null && isIncomplete;

    // Safe null checks
    if (hasOldData == null) hasOldData = false;
    if (hasNewData == null) hasNewData = false;
    if (hasChanges == null) hasChanges = false;
    if (isAdd == null) isAdd = false;
    if (isUpdate == null) isUpdate = false;
    if (isDelete == null) isDelete = false;
    if (oldDataMap == null) oldDataMap = new java.util.HashMap<>();
    if (newDataMap == null) newDataMap = new java.util.HashMap<>();
    if (changesMap == null) changesMap = new java.util.HashMap<>();

    String hyphen = "-";

    // Determine CSS classes based on operation type
    String fromClass = "";
    String toClass = "";

    if (isAdd) {
        toClass = "tm-to";
    } else if (isDelete) {
        fromClass = "tm-from";
    } else if (isUpdate) {
        fromClass = "tm-from";
        toClass = "tm-to";
    }
%>

<% if (showApprovedBadge) { %>
<div class="alert alert-success" style="margin-bottom: 20px;">
    <strong>APPROVED:</strong> This workflow has been successfully approved and processed.
</div>
<% } %>

<% if (showRejectedBadge) { %>
<div class="alert alert-danger" style="margin-bottom: 20px;">
    <strong>REJECTED:</strong> This workflow has been rejected. The changes shown below were not applied.
</div>
<% } %>

<% if (showIncompleteBadge) { %>
<div class="alert alert-warning" style="margin-bottom: 20px;">
    <strong>INCOMPLETE:</strong> This workflow is incomplete due to an external API calling failure.
</div>
<% } %>

<!-- Configuration Entity Operations -->
<div class="table-responsive">
    <h3><%= entityTypeDisplay != null ? entityTypeDisplay : "Configuration" %> Information</h3>
    <table class="tm-table">
        <tbody>
        <tr>
            <td class="tm-meta-label"><strong>Entity Type</strong></td>
            <td class="tm-meta-value" colspan="2"><%= entityTypeDisplay != null ? entityTypeDisplay : "N/A" %></td>
        </tr>
        <tr>
            <td class="tm-meta-label"><strong>Request</strong></td>
            <td class="tm-meta-value" colspan="2"><%= getRequestTypeDisplay(workflowAction) %></td>
        </tr>
        <tr class="tm-header">
            <th scope="col">Field</th>
            <th scope="col">From</th>
            <th scope="col">To</th>
        </tr>

        <% if (isAdd && hasNewData) { %>
            <!-- ADD Operation - Show new data -->
            <% for (java.util.Map.Entry<String, String> entry : newDataMap.entrySet()) { %>
            <tr>
                <td><strong><%= entry.getKey() %></strong></td>
                <td class="<%= fromClass %>"><%= hyphen %></td>
                <td class="<%= toClass %>"><%= entry.getValue() != null ? entry.getValue() : hyphen %></td>
            </tr>
            <% } %>

        <% } else if (isUpdate && hasChanges) { %>
            <!-- UPDATE Operation - Show changes only -->
            <% for (java.util.Map.Entry<String, String[]> entry : changesMap.entrySet()) {
                String[] values = entry.getValue();
                String oldVal = values[0];
                String newVal = values[1];
            %>
            <tr>
                <td><strong><%= entry.getKey() %></strong></td>
                <td class="<%= fromClass %>"><%= oldVal != null && !oldVal.isEmpty() ? oldVal : hyphen %></td>
                <td class="<%= toClass %>"><%= newVal != null && !newVal.isEmpty() ? newVal : hyphen %></td>
            </tr>
            <% } %>

        <% } else if (isDelete && hasOldData) { %>
            <!-- DELETE Operation - Show data being deleted -->
            <% for (java.util.Map.Entry<String, String> entry : oldDataMap.entrySet()) { %>
            <tr>
                <td><strong><%= entry.getKey() %></strong></td>
                <td class="<%= fromClass %>"><%= entry.getValue() != null ? entry.getValue() : hyphen %></td>
                <td class="<%= toClass %>"><%= hyphen %></td>
            </tr>
            <% } %>

        <% } else { %>
            <!-- No changes detected -->
            <tr>
                <td colspan="3" style="text-align: center; color: #6c757d; font-style: italic; padding: 20px;">
                    No changes detected or data not available.
                </td>
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
    .tm-language-header td {
        background-color: #e5e7eb;
        font-weight: 600;
        font-size: 14px;
        color: #1f2937;
    }
    .tm-from {
        color: #dc2626;
        text-decoration: line-through;
    }
    .tm-to {
        color: #16a34a;
    }
    h3 {
        margin-bottom: 15px;
        color: #374151;
        font-family: "Helvetica", "Arial", sans-serif;
    }
</style>
</div>
