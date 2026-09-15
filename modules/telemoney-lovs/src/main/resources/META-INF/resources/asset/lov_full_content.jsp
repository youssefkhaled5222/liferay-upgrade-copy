<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page import="java.util.Objects" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ page import="com.ejada.telemony.db.model.Lovs" %>
<%@ page import="com.ejada.telemony.db.model.LovData" %>

<%!
    // Helper method to get request type display name
    private String getRequestTypeDisplay(String workflowAction) {
        if (workflowAction == null) return "Unknown";
        switch (workflowAction) {
            case "ADD_LOV": return "Add LOV";
            case "UPDATE_LOV": return "Update LOV";
            case "DELETE_LOV": return "Delete LOV";
            case "ADD_LOV_DATA": return "Add LOV Data";
            case "UPDATE_LOV_DATA": return "Update LOV Data";
            case "DELETE_LOV_DATA": return "Delete LOV Data";
            default: return workflowAction;
        }
    }
%>

<%
    // Check if LOV has been deleted (e.g., after DELETE workflow approval)
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

    // Get workflow action from request
    String workflowAction = (String) request.getAttribute("workflowAction");

    // Get LOV data
    Lovs editedLov = (Lovs) request.getAttribute("lov");
    Lovs originalLov = (Lovs) request.getAttribute("originalLov");
    List<LovData> editedLovDataList = (List<LovData>) request.getAttribute("lovDataList");
    List<LovData> originalLovDataList = (List<LovData>) request.getAttribute("originalLovDataList");

    // Get workflow states
    Boolean isAlreadyApproved = (Boolean) request.getAttribute("isAlreadyApproved");
    boolean showApprovedBadge = isAlreadyApproved != null && isAlreadyApproved;

    Boolean isRejected = (Boolean) request.getAttribute("isRejected");
    boolean showRejectedBadge = isRejected != null && isRejected;

    // Get operation type flags from renderer
    Boolean isAddLovFlag = (Boolean) request.getAttribute("isAddLov");
    Boolean isUpdateLovFlag = (Boolean) request.getAttribute("isUpdateLov");
    Boolean isDeleteLovFlag = (Boolean) request.getAttribute("isDeleteLov");
    Boolean isAddLovDataFlag = (Boolean) request.getAttribute("isAddLovData");
    Boolean isUpdateLovDataFlag = (Boolean) request.getAttribute("isUpdateLovData");
    Boolean isDeleteLovDataFlag = (Boolean) request.getAttribute("isDeleteLovData");

    boolean isAddLov = isAddLovFlag != null && isAddLovFlag;
    boolean isUpdateLov = isUpdateLovFlag != null && isUpdateLovFlag;
    boolean isDeleteLov = isDeleteLovFlag != null && isDeleteLovFlag;
    boolean isAddLovData = isAddLovDataFlag != null && isAddLovDataFlag;
    boolean isUpdateLovData = isUpdateLovDataFlag != null && isUpdateLovDataFlag;
    boolean isDeleteLovData = isDeleteLovDataFlag != null && isDeleteLovDataFlag;

    // Determine if this is a LOV operation or data operation
    boolean isLovOperation = isAddLov || isUpdateLov || isDeleteLov;
    boolean isDataOperation = isAddLovData || isUpdateLovData || isDeleteLovData;

    // Get channel names from request
    String channelName = (String) request.getAttribute("channelName");
    String originalChannelName = (String) request.getAttribute("originalChannelName");

    // Get localization maps from request
    Map<String, String> editedLovLocalizations = (Map<String, String>) request.getAttribute("lovLocalizations");
    Map<String, String> originalLovLocalizations = (Map<String, String>) request.getAttribute("originalLovLocalizations");
    Map<Long, Map<String, String>> editedLovDataLocalizations = (Map<Long, Map<String, String>>) request.getAttribute("lovDataLocalizations");
    Map<Long, Map<String, String>> originalLovDataLocalizations = (Map<Long, Map<String, String>>) request.getAttribute("originalLovDataLocalizations");

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    boolean hasEditedLov = editedLov != null;
    boolean hasOriginalLov = originalLov != null;
    boolean hasLovData = editedLovDataList != null && !editedLovDataList.isEmpty();

    String hyphen = "-";

    // Determine CSS classes based on operation type
    String fromClass = "";
    String toClass = "";

    if (isAddLov || isAddLovData) {
        toClass = "tm-to";
    } else if (isDeleteLov || isDeleteLovData) {
        fromClass = "tm-from";
    } else if (isUpdateLov || isUpdateLovData) {
        fromClass = "tm-from";
        toClass = "tm-to";
    }

    // LOV field values
    String lovCodeValue = hasEditedLov ? editedLov.getCode() : hyphen;

    // Check for LOV field changes (for update operations)
    boolean channelChanged = hasEditedLov && hasOriginalLov && !Objects.equals(editedLov.getChannelId(), originalLov.getChannelId());
    boolean codeChanged = hasEditedLov && hasOriginalLov && !Objects.equals(editedLov.getCode(), originalLov.getCode());
    boolean eventCodeChanged = hasEditedLov && hasOriginalLov && !Objects.equals(editedLov.getEventCode(), originalLov.getEventCode());

    // LOV field from/to values based on operation type
    String channelFrom = (isAddLov || isAddLovData) ? hyphen : (originalChannelName != null ? originalChannelName : (channelName != null ? channelName : hyphen));
    String channelTo = (isDeleteLov || isDeleteLovData) ? hyphen : (channelName != null ? channelName : hyphen);

    String codeFrom = (isAddLov || isAddLovData) ? hyphen : (hasOriginalLov ? originalLov.getCode() : lovCodeValue);
    String codeTo = (isDeleteLov || isDeleteLovData) ? hyphen : lovCodeValue;

    String eventCodeFrom = (isAddLov || isAddLovData) ? hyphen : (hasOriginalLov ? originalLov.getEventCode() : (hasEditedLov ? editedLov.getEventCode() : hyphen));
    String eventCodeTo = (isDeleteLov || isDeleteLovData) ? hyphen : (hasEditedLov ? editedLov.getEventCode() : hyphen);
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

<% if (isLovOperation) { %>
<!-- LOV Operations: Show full LOV details -->
<div class="table-responsive">
    <h3>LOV Information</h3>
    <table class="tm-table">
        <tbody>
        <tr>
            <td class="tm-meta-label"><strong>LOV Code</strong></td>
            <td class="tm-meta-value" colspan="2"><%= lovCodeValue %></td>
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
        <% if (!isUpdateLov || channelChanged) { %>
        <tr>
            <td><strong>Channel</strong></td>
            <td class="<%= fromClass %>"><%= channelFrom %></td>
            <td class="<%= toClass %>"><%= channelTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdateLov || codeChanged) { %>
        <tr>
            <td><strong>Code</strong></td>
            <td class="<%= fromClass %>"><%= codeFrom %></td>
            <td class="<%= toClass %>"><%= codeTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdateLov || eventCodeChanged) { %>
        <tr>
            <td><strong>Event Code</strong></td>
            <td class="<%= fromClass %>"><%= eventCodeFrom %></td>
            <td class="<%= toClass %>"><%= eventCodeTo %></td>
        </tr>
        <% } %>

        <%-- Display localized names --%>
        <%
            if (editedLovLocalizations != null || originalLovLocalizations != null) {
                Map<String, String> editedLocMap = editedLovLocalizations != null ? editedLovLocalizations : new HashMap<>();
                Map<String, String> originalLocMap = originalLovLocalizations != null ? originalLovLocalizations : new HashMap<>();

                // Get all unique languages
                java.util.Set<String> allLanguages = new java.util.HashSet<>();
                allLanguages.addAll(editedLocMap.keySet());
                allLanguages.addAll(originalLocMap.keySet());

                for (String language : allLanguages) {
                    String editedName = editedLocMap.get(language);
                    String originalName = originalLocMap.get(language);

                    boolean nameChanged = hasOriginalLov && !Objects.equals(editedName, originalName);

                    String nameFrom, nameTo;
                    if (isAddLov) {
                        nameFrom = hyphen;
                        nameTo = editedName != null ? editedName : hyphen;
                    } else if (isDeleteLov) {
                        nameFrom = editedName != null ? editedName : hyphen;
                        nameTo = hyphen;
                    } else {
                        nameFrom = originalName != null ? originalName : hyphen;
                        nameTo = editedName != null ? editedName : hyphen;
                    }

                    if (!isUpdateLov || nameChanged) {
        %>
        <tr>
            <td><strong>Name (<%= language %>)</strong></td>
            <td class="<%= fromClass %>"><%= nameFrom %></td>
            <td class="<%= toClass %>"><%= nameTo %></td>
        </tr>
        <%
                    }
                }
            }
        %>
        </tbody>
    </table>
</div>
<% } %>

<% if (isDataOperation) { %>
<!-- Data Operations: Show LOV info as context only -->
<div class="table-responsive">
    <h3>LOV Information (Context)</h3>
    <table class="tm-table">
        <tbody>
        <tr>
            <td class="tm-meta-label"><strong>LOV Code</strong></td>
            <td class="tm-meta-value"><%= lovCodeValue %></td>
        </tr>
        <tr>
            <td class="tm-meta-label"><strong>Channel</strong></td>
            <td class="tm-meta-value"><%= channelName != null ? channelName : hyphen %></td>
        </tr>
        <tr>
            <td class="tm-meta-label"><strong>Request</strong></td>
            <td class="tm-meta-value"><%= getRequestTypeDisplay(workflowAction) %></td>
        </tr>
        </tbody>
    </table>
</div>
<% } %>

<% if (hasLovData) { %>
<div class="table-responsive" style="margin-top: 30px;">
    <h3>LOV Data Changes</h3>
    <%
        for (LovData editedData : editedLovDataList) {
            LovData originalData = null;
            long dataOriginalEntityId = editedData.getOriginalEntityId();

            // Find original data
            if (originalLovDataList != null && dataOriginalEntityId != 0L) {
                for (LovData od : originalLovDataList) {
                    if (od.getId() == dataOriginalEntityId) {
                        originalData = od;
                        break;
                    }
                }
            }

            boolean hasOriginalData = originalData != null;

            // Determine data operation type
            boolean isDataAdd = isAddLovData || dataOriginalEntityId == 0L;
            boolean isDataDelete = isDeleteLovData;
            boolean isDataUpdate = isUpdateLovData;

            // Get localizations
            Map<String, String> editedDataLoc = null;
            if (editedLovDataLocalizations != null) {
                editedDataLoc = editedLovDataLocalizations.get(editedData.getId());
            }

            Map<String, String> originalDataLoc = null;
            if (hasOriginalData && originalLovDataLocalizations != null) {
                originalDataLoc = originalLovDataLocalizations.get(originalData.getId());
            }

            // Field values based on operation type
            String typeCodeFrom, typeCodeTo;
            String shortDescFrom, shortDescTo;

            if (isDataDelete) {
                typeCodeFrom = editedData.getRecordTypeCode() != null ? editedData.getRecordTypeCode() : hyphen;
                typeCodeTo = hyphen;
                shortDescFrom = editedData.getRecordShortDescription() != null ? editedData.getRecordShortDescription() : hyphen;
                shortDescTo = hyphen;
            } else if (isDataAdd) {
                typeCodeFrom = hyphen;
                typeCodeTo = editedData.getRecordTypeCode() != null ? editedData.getRecordTypeCode() : hyphen;
                shortDescFrom = hyphen;
                shortDescTo = editedData.getRecordShortDescription() != null ? editedData.getRecordShortDescription() : hyphen;
            } else {
                typeCodeFrom = hasOriginalData && originalData.getRecordTypeCode() != null ? originalData.getRecordTypeCode() : hyphen;
                typeCodeTo = editedData.getRecordTypeCode() != null ? editedData.getRecordTypeCode() : hyphen;
                shortDescFrom = hasOriginalData && originalData.getRecordShortDescription() != null ? originalData.getRecordShortDescription() : hyphen;
                shortDescTo = editedData.getRecordShortDescription() != null ? editedData.getRecordShortDescription() : hyphen;
            }

            // Check for changes (for update only)
            boolean typeCodeChanged = hasOriginalData && !Objects.equals(editedData.getRecordTypeCode(), originalData.getRecordTypeCode());
            boolean shortDescChanged = hasOriginalData && !Objects.equals(editedData.getRecordShortDescription(), originalData.getRecordShortDescription());

            String dataRequestType;
            if (isDataAdd) {
                dataRequestType = "Add";
            } else if (isDataDelete) {
                dataRequestType = "Delete";
            } else {
                dataRequestType = "Update";
            }

            String dataFromClass = (isDataUpdate || isDataDelete) ? "tm-from" : "";
            String dataToClass = (isDataUpdate || isDataAdd) ? "tm-to" : "";
    %>

    <table class="tm-table" style="margin-bottom: 20px;">
        <tbody>
        <tr>
            <td class="tm-meta-label"><strong>Type Code</strong></td>
            <td class="tm-meta-value" colspan="2"><%= editedData.getRecordTypeCode() != null ? editedData.getRecordTypeCode() : hyphen %></td>
        </tr>
        <tr>
            <td class="tm-meta-label"><strong>Request</strong></td>
            <td class="tm-meta-value" colspan="2"><%= dataRequestType %></td>
        </tr>
        <tr class="tm-header">
            <th scope="col">Field</th>
            <th scope="col">From</th>
            <th scope="col">To</th>
        </tr>
        <% if (!isDataUpdate || typeCodeChanged) { %>
        <tr>
            <td><strong>Type Code</strong></td>
            <td class="<%= dataFromClass %>"><%= typeCodeFrom %></td>
            <td class="<%= dataToClass %>"><%= typeCodeTo %></td>
        </tr>
        <% } %>
        <% if (!isDataUpdate || shortDescChanged) { %>
        <tr>
            <td><strong>Short Description</strong></td>
            <td class="<%= dataFromClass %>"><%= shortDescFrom %></td>
            <td class="<%= dataToClass %>"><%= shortDescTo %></td>
        </tr>
        <% } %>

        <%-- Display localized descriptions --%>
        <%
            if (editedDataLoc != null || originalDataLoc != null) {
                Map<String, String> editedLocMap = editedDataLoc != null ? editedDataLoc : new HashMap<>();
                Map<String, String> originalLocMap = originalDataLoc != null ? originalDataLoc : new HashMap<>();

                java.util.Set<String> allLanguages = new java.util.HashSet<>();
                allLanguages.addAll(editedLocMap.keySet());
                allLanguages.addAll(originalLocMap.keySet());

                for (String language : allLanguages) {
                    String editedDesc = editedLocMap.get(language);
                    String originalDesc = originalLocMap.get(language);

                    boolean descChanged = hasOriginalData && !Objects.equals(editedDesc, originalDesc);

                    String descFrom, descTo;
                    if (isDataAdd) {
                        descFrom = hyphen;
                        descTo = editedDesc != null ? editedDesc : hyphen;
                    } else if (isDataDelete) {
                        descFrom = editedDesc != null ? editedDesc : hyphen;
                        descTo = hyphen;
                    } else {
                        descFrom = originalDesc != null ? originalDesc : hyphen;
                        descTo = editedDesc != null ? editedDesc : hyphen;
                    }

                    if (!isDataUpdate || descChanged) {
        %>
        <tr>
            <td><strong>Description (<%= language %>)</strong></td>
            <td class="<%= dataFromClass %>"><%= descFrom %></td>
            <td class="<%= dataToClass %>"><%= descTo %></td>
        </tr>
        <%
                    }
                }
            }
        %>
        </tbody>
    </table>
    <%
        }
    %>
</div>
<% } %>

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

