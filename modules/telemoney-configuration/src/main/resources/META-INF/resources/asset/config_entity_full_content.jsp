<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<liferay-theme:defineObjects />

<%
    // Get attributes from request
    Boolean isDeleted = (Boolean) request.getAttribute("isDeleted");
    Boolean isAlreadyApproved = (Boolean) request.getAttribute("isAlreadyApproved");
    Boolean isRejected = (Boolean) request.getAttribute("isRejected");
    Boolean isAdd = (Boolean) request.getAttribute("isAdd");
    Boolean isUpdate = (Boolean) request.getAttribute("isUpdate");



    String workflowAction = (String) request.getAttribute("workflowAction");
    String workflowActionDisplay = (String) request.getAttribute("workflowActionDisplay");
    String entityType = (String) request.getAttribute("entityType");
    String entityTypeDisplay = (String) request.getAttribute("entityTypeDisplay");



    java.util.Map<String, String> newDataMap = (java.util.Map<String, String>) request.getAttribute("newDataMap");
    java.util.Map<String, String[]> changesMap = (java.util.Map<String, String[]>) request.getAttribute("changesMap");

    Boolean hasOldData = (Boolean) request.getAttribute("hasOldData");
    Boolean hasNewData = (Boolean) request.getAttribute("hasNewData");


    if (isDeleted == null) isDeleted = false;
    if (isAlreadyApproved == null) isAlreadyApproved = false;
    if (isRejected == null) isRejected = false;


    if (hasOldData == null) hasOldData = false;
    if (hasNewData == null) hasNewData = false;
    if (hasChanges == null) hasChanges = false;
    if (oldDataMap == null) oldDataMap = new java.util.HashMap<>();
    if (newDataMap == null) newDataMap = new java.util.HashMap<>();

%>

<style>
    .config-entity-container {
        padding: 20px;
        font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif;
    }
    .status-banner {
        padding: 12px 20px;
        border-radius: 4px;
        margin-bottom: 20px;
        font-weight: 500;
    }
    .status-approved {
        background-color: #d4edda;
        color: #155724;
        border: 1px solid #c3e6cb;
    }
    .status-rejected {
        background-color: #f8d7da;
        color: #721c24;
        border: 1px solid #f5c6cb;
    }
    .status-deleted {
        background-color: #fff3cd;
        color: #856404;
        border: 1px solid #ffeeba;
    }
    .section-header {
        background-color: #f8f9fa;
        padding: 12px 15px;
        border-radius: 4px;
        margin-bottom: 15px;
        font-weight: 600;
        color: #495057;
    }
    .info-row {
        display: flex;
        padding: 10px 15px;
        border-bottom: 1px solid #e9ecef;
    }
    .info-row:last-child {
        border-bottom: none;
    }
    .info-label {
        flex: 0 0 200px;
        font-weight: 500;
        color: #6c757d;
    }
    .info-value {
        flex: 1;
        color: #212529;
    }
    .comparison-table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 10px;
    }
    .comparison-table th {
        background-color: #f8f9fa;
        padding: 12px 15px;
        text-align: left;
        font-weight: 600;
        border-bottom: 2px solid #dee2e6;
    }
    .comparison-table td {
        padding: 12px 15px;
        border-bottom: 1px solid #e9ecef;
        vertical-align: top;
    }
    .comparison-table tr:hover {
        background-color: #f8f9fa;
    }
    .value-changed {
        background-color: #fff3cd;
    }
    .value-old {
        color: #dc3545;
        text-decoration: line-through;
    }
    .value-new {
        color: #28a745;
        font-weight: 500;
    }
    .value-added {
        color: #28a745;
    }
    .value-removed {
        color: #dc3545;
    }
    .card {
        border: 1px solid #dee2e6;
        border-radius: 4px;
        margin-bottom: 20px;
        background: #fff;
    }
    .card-header {
        background-color: #f8f9fa;
        padding: 12px 15px;
        border-bottom: 1px solid #dee2e6;
        font-weight: 600;
    }
    .card-body {
        padding: 15px;
    }
    .badge {
        display: inline-block;
        padding: 4px 8px;
        border-radius: 4px;
        font-size: 12px;
        font-weight: 500;
    }
    .badge-add {
        background-color: #d4edda;
        color: #155724;
    }
    .badge-update {
        background-color: #fff3cd;
        color: #856404;
    }
    .badge-delete {
        background-color: #f8d7da;
        color: #721c24;
    }
    .no-changes {
        color: #6c757d;
        font-style: italic;
        padding: 20px;
        text-align: center;
    }
</style>

<div class="config-entity-container">

    <!-- Deleted Entity -->
    <% if (isDeleted) { %>
        <div class="status-banner status-deleted">
            <strong>This configuration entity has been deleted.</strong>
        </div>
    <% } else { %>

        <!-- Already Approved/Rejected Status -->
        <% if (isAlreadyApproved) { %>
            <div class="status-banner status-approved">
                <strong>APPROVED</strong> - This request has been approved.

        <% } %>

        <% if (isRejected) { %>
            <div class="status-banner status-rejected">
                <strong>REJECTED</strong> - This request has been rejected.
            </div>
        <% } %>


        <div class="card">
            <div class="card-header">

            </div>
            <div class="card-body">
                <div class="info-row">
                    <span class="info-label">Entity Type:</span>

                </div>
                <div class="info-row">

                    <span class="info-value">
                        <% if (isAdd) { %>
                            <span class="badge badge-add">Add</span>

                            <span class="badge badge-update">Update</span>
                        <% } else if (isDelete) { %>
                            <span class="badge badge-delete">Delete</span>

                            <%= workflowActionDisplay != null ? workflowActionDisplay : "N/A" %>
                        <% } %>
                    </span>
                </div>
            </div>
        </div>


        <% if (isAdd && hasNewData) { %>
            <div class="card">
                <div class="card-header">
                    New <%= entityTypeDisplay %> Details
                </div>
                <div class="card-body">
                    <table class="comparison-table">
                        <thead>
                            <tr>
                                <th style="width: 30%;">Field</th>
                                <th>Value</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (java.util.Map.Entry<String, String> entry : newDataMap.entrySet()) { %>
                                <tr>
                                    <td><%= entry.getKey() %></td>

                                </tr>
                            <% } %>
                        </tbody>
                    </table>
                </div>
            </div>
        <% } %>

        <!-- UPDATE Operation - Show Changes -->
        <% if (isUpdate) { %>
            <div class="card">
                <div class="card-header">
                    <%= entityTypeDisplay %> Changes
                </div>
                <div class="card-body">

                        <table class="comparison-table">
                            <thead>
                                <tr>
                                    <th style="width: 25%;">Field</th>
                                    <th style="width: 37.5%;">Original Value</th>
                                    <th style="width: 37.5%;">New Value</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% for (java.util.Map.Entry<String, String[]> entry : changesMap.entrySet()) {
                                    String[] values = entry.getValue();
                                    String oldVal = values[0];

                                %>
                                    <tr class="value-changed">
                                        <td><%= entry.getKey() %></td>
                                        <td class="value-old"><%= oldVal != null && !oldVal.isEmpty() ? oldVal : "(empty)" %></td>
                                        <td class="value-new"><%= newVal != null && !newVal.isEmpty() ? newVal : "(empty)" %></td>
                                    </tr>

                            </tbody>
                        </table>
                    <% } else { %>
                        <div class="no-changes">No changes detected.</div>
                    <% } %>
                </div>
            </div>
        <% } %>

        <!-- DELETE Operation - Show Data Being Deleted -->
                                <% for (java.util.Map.Entry<String, String[]> entry : changesMap.entrySet()) {
            <div class="card">
                <div class="card-header">
                    <%= entityTypeDisplay %> Being Deleted
                </div>
                <div class="card-body">
                    <table class="comparison-table">
                        <thead>
                            <tr>
                                <th style="width: 30%;">Field</th>
                                <th>Value</th>
                            </tr>

                        </thead>
                        <tbody>
                                <% for (java.util.Map.Entry<String, String[]> entry : changesMap.entrySet()) {
                                <tr>
                                    <td><%= entry.getKey() %></td>
                                    <td class="value-removed"><%= entry.getValue() != null ? entry.getValue() : "" %></td>
                                </tr>
                            <% } %>
                        </tbody>

                </div>
            </div>
        <% } %>



    <% } %>
</div>


