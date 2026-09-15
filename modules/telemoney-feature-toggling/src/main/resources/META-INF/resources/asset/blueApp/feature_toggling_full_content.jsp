<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.Objects" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ page import="com.ejada.telemony.db.model.Feature" %>

<%!
    // Helper method to get request type display name
    private String getRequestTypeDisplay(String workflowAction) {
        if (workflowAction == null) return "Unknown";
        switch (workflowAction) {
            case "ADD_FEATURE": return "Add Feature";
            case "UPDATE_FEATURE": return "Update Feature";
            case "DELETE_FEATURE": return "Delete Feature";
            default: return workflowAction;
        }
    }

    // Helper method to display feature status
    private String getFeatureStatusDisplay(Boolean status) {
        if (status == null) return "-";
        return status ? "On" : "Off";
    }

    // Helper method to render a list of codes as a comma-separated string
    private String joinCodes(List<String> codes) {
        if (codes == null || codes.isEmpty()) return "-";
        return String.join(", ", codes);
    }
%>

<%
    // Check if Feature has been deleted (e.g., after DELETE workflow approval)
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

    // Get Feature data
    Feature editedFeature = (Feature) request.getAttribute("feature");
    Feature originalFeature = (Feature) request.getAttribute("originalFeature");

    // Get workflow states
    Boolean isAlreadyApproved = (Boolean) request.getAttribute("isAlreadyApproved");
    boolean showApprovedBadge = isAlreadyApproved != null && isAlreadyApproved;

    Boolean isRejected = (Boolean) request.getAttribute("isRejected");
    boolean showRejectedBadge = isRejected != null && isRejected;

    // Get operation type flags from renderer
    Boolean isAddFeatureFlag = (Boolean) request.getAttribute("isAddFeature");
    Boolean isUpdateFeatureFlag = (Boolean) request.getAttribute("isUpdateFeature");
    Boolean isDeleteFeatureFlag = (Boolean) request.getAttribute("isDeleteFeature");

    boolean isAddFeature = isAddFeatureFlag != null && isAddFeatureFlag;
    boolean isUpdateFeature = isUpdateFeatureFlag != null && isUpdateFeatureFlag;
    boolean isDeleteFeature = isDeleteFeatureFlag != null && isDeleteFeatureFlag;

    // Get channel names from request
    String channelName = (String) request.getAttribute("channelName");
    String originalChannelName = (String) request.getAttribute("originalChannelName");

    // Get Whitelist/Segments LOV codes
    List<String> whitelistCodes = (List<String>) request.getAttribute("whitelistCodes");
    List<String> segmentsCodes = (List<String>) request.getAttribute("segmentsCodes");
    List<String> originalWhitelistCodes = (List<String>) request.getAttribute("originalWhitelistCodes");
    List<String> originalSegmentsCodes = (List<String>) request.getAttribute("originalSegmentsCodes");

    boolean hasEditedFeature = editedFeature != null;
    boolean hasOriginalFeature = originalFeature != null;

    String hyphen = "-";

    // Determine CSS classes based on operation type
    String fromClass = "";
    String toClass = "";

    if (isAddFeature) {
        toClass = "tm-to";
    } else if (isDeleteFeature) {
        fromClass = "tm-from";
    } else if (isUpdateFeature) {
        fromClass = "tm-from";
        toClass = "tm-to";
    }

    // Feature field values
    String featureNameValue = hasEditedFeature ? editedFeature.getFeatureName() : hyphen;

    // Check for Feature field changes (for update operations)
    boolean channelChanged = hasEditedFeature && hasOriginalFeature && !Objects.equals(editedFeature.getChannelId(), originalFeature.getChannelId());
    boolean featureNameChanged = hasEditedFeature && hasOriginalFeature && !Objects.equals(editedFeature.getFeatureName(), originalFeature.getFeatureName());
    boolean statusChanged = hasEditedFeature && hasOriginalFeature && !Objects.equals(editedFeature.getFeatureStatus(), originalFeature.getFeatureStatus());
    boolean whitelistChanged = !Objects.equals(joinCodes(whitelistCodes), joinCodes(originalWhitelistCodes));
    boolean segmentsChanged = !Objects.equals(joinCodes(segmentsCodes), joinCodes(originalSegmentsCodes));

    // Feature field from/to values based on operation type
    String channelFrom = isAddFeature ? hyphen : (originalChannelName != null ? originalChannelName : (channelName != null ? channelName : hyphen));
    String channelTo = isDeleteFeature ? hyphen : (channelName != null ? channelName : hyphen);

    String featureNameFrom = isAddFeature ? hyphen : (hasOriginalFeature ? originalFeature.getFeatureName() : featureNameValue);
    String featureNameTo = isDeleteFeature ? hyphen : featureNameValue;

    String statusFrom = isAddFeature ? hyphen : (hasOriginalFeature ? getFeatureStatusDisplay(originalFeature.getFeatureStatus()) : (hasEditedFeature ? getFeatureStatusDisplay(editedFeature.getFeatureStatus()) : hyphen));
    String statusTo = isDeleteFeature ? hyphen : (hasEditedFeature ? getFeatureStatusDisplay(editedFeature.getFeatureStatus()) : hyphen);

    String whitelistFrom = isAddFeature ? hyphen : joinCodes(originalWhitelistCodes != null ? originalWhitelistCodes : whitelistCodes);
    String whitelistTo = isDeleteFeature ? hyphen : joinCodes(whitelistCodes);

    String segmentsFrom = isAddFeature ? hyphen : joinCodes(originalSegmentsCodes != null ? originalSegmentsCodes : segmentsCodes);
    String segmentsTo = isDeleteFeature ? hyphen : joinCodes(segmentsCodes);
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

<div class="table-responsive">
    <h3 class="section-title">Feature Information</h3>
    <table class="tm-table">
        <tbody>
        <tr>
            <td class="tm-meta-label"><strong>Feature Name</strong></td>
            <td class="tm-meta-value" colspan="2"><%= featureNameValue %></td>
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
        <% if (!isUpdateFeature || channelChanged) { %>
        <tr>
            <td><strong>Channel</strong></td>
            <td class="<%= fromClass %>"><%= channelFrom %></td>
            <td class="<%= toClass %>"><%= channelTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdateFeature || featureNameChanged) { %>
        <tr>
            <td><strong>Feature Name</strong></td>
            <td class="<%= fromClass %>"><%= featureNameFrom %></td>
            <td class="<%= toClass %>"><%= featureNameTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdateFeature || statusChanged) { %>
        <tr>
            <td><strong>Status</strong></td>
            <td class="<%= fromClass %>"><%= statusFrom %></td>
            <td class="<%= toClass %>"><%= statusTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdateFeature || whitelistChanged) { %>
        <tr>
            <td><strong>Whitelist</strong></td>
            <td class="<%= fromClass %>"><%= whitelistFrom %></td>
            <td class="<%= toClass %>"><%= whitelistTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdateFeature || segmentsChanged) { %>
        <tr>
            <td><strong>Segments</strong></td>
            <td class="<%= fromClass %>"><%= segmentsFrom %></td>
            <td class="<%= toClass %>"><%= segmentsTo %></td>
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
    .section-title {
        margin-top: 20px;
        margin-bottom: 15px;
        color: #374151;
        font-family: "Helvetica", "Arial", sans-serif;
    }
</style>
