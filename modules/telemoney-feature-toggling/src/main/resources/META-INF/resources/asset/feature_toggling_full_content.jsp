<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page import="java.util.Objects" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ page import="com.ejada.telemony.db.model.Feature" %>
<%@ page import="com.ejada.telemony.db.model.Segment" %>
<%@ page import="com.ejada.telemony.db.model.Blocks" %>

<%!
    // Helper method to get request type display name
    private String getRequestTypeDisplay(String workflowAction) {
        if (workflowAction == null) return "Unknown";
        switch (workflowAction) {
            case "ADD_FEATURE": return "Add Feature";
            case "UPDATE_FEATURE": return "Update Feature";
            case "DELETE_FEATURE": return "Delete Feature";
            case "UPDATE_SEGMENT": return "Update Segment";
            default: return workflowAction;
        }
    }

    // Helper method to display feature status
    private String getFeatureStatusDisplay(Boolean status) {
        if (status == null) return "-";
        return status ? "On" : "Off";
    }

    // Helper method to display segment status
    private String getSegmentStatusDisplay(Boolean status) {
        if (status == null) return "-";
        return status ? "On" : "Off";
    }

    // Helper method to display block type
    private String getBlockTypeDisplay(String type) {
        if (type == null || type.isEmpty()) return "-";
        switch (type) {
            case "0": return "Hide";
            case "1": return "Disable";
            case "2": return "Pop Up";
            default: return type;
        }
    }

    // Helper method to display segment method (convert 0, 1, 2 to text)
    private String getSegmentMethodDisplay(String method) {
        if (method == null || method.isEmpty()) return "-";
        switch (method) {
            case "0": return "Hide";
            case "1": return "Disable";
            case "2": return "Pop Up";
            default: return method;
        }
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

    // Get Segments
    List<Segment> editedSegments = (List<Segment>) request.getAttribute("segments");
    List<Segment> originalSegments = (List<Segment>) request.getAttribute("originalSegments");

    // For segment update
    Segment draftSegment = (Segment) request.getAttribute("draftSegment");
    Segment originalSegment = (Segment) request.getAttribute("originalSegment");

    // Get Blocks
    Blocks editedBlock = (Blocks) request.getAttribute("block");
    Blocks originalBlock = (Blocks) request.getAttribute("originalBlock");

    // Get workflow states
    Boolean isAlreadyApproved = (Boolean) request.getAttribute("isAlreadyApproved");
    boolean showApprovedBadge = isAlreadyApproved != null && isAlreadyApproved;

    Boolean isRejected = (Boolean) request.getAttribute("isRejected");
    boolean showRejectedBadge = isRejected != null && isRejected;

    // Get operation type flags from renderer
    Boolean isAddFeatureFlag = (Boolean) request.getAttribute("isAddFeature");
    Boolean isUpdateFeatureFlag = (Boolean) request.getAttribute("isUpdateFeature");
    Boolean isDeleteFeatureFlag = (Boolean) request.getAttribute("isDeleteFeature");
    Boolean isUpdateSegmentFlag = (Boolean) request.getAttribute("isUpdateSegment");

    boolean isAddFeature = isAddFeatureFlag != null && isAddFeatureFlag;
    boolean isUpdateFeature = isUpdateFeatureFlag != null && isUpdateFeatureFlag;
    boolean isDeleteFeature = isDeleteFeatureFlag != null && isDeleteFeatureFlag;
    boolean isUpdateSegment = isUpdateSegmentFlag != null && isUpdateSegmentFlag;

    // Determine if this is a Feature operation or Segment operation
    boolean isFeatureOperation = isAddFeature || isUpdateFeature || isDeleteFeature;
    boolean isSegmentOperation = isUpdateSegment;

    // Get channel names from request
    String channelName = (String) request.getAttribute("channelName");
    String originalChannelName = (String) request.getAttribute("originalChannelName");

    // Get page type displays
    String pageTypeDisplay = (String) request.getAttribute("pageTypeDisplay");
    String originalPageTypeDisplay = (String) request.getAttribute("originalPageTypeDisplay");

    // Get parent feature names
    String parentFeatureName = (String) request.getAttribute("parentFeatureName");
    String originalParentFeatureName = (String) request.getAttribute("originalParentFeatureName");

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

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
    } else if (isUpdateFeature || isUpdateSegment) {
        fromClass = "tm-from";
        toClass = "tm-to";
    }

    // Feature field values
    String featureNameValue = hasEditedFeature ? editedFeature.getFeatureName() : hyphen;

    // Check for Feature field changes (for update operations)
    boolean channelChanged = hasEditedFeature && hasOriginalFeature && !Objects.equals(editedFeature.getChannelId(), originalFeature.getChannelId());
    boolean featureNameChanged = hasEditedFeature && hasOriginalFeature && !Objects.equals(editedFeature.getFeatureName(), originalFeature.getFeatureName());
    boolean pageTypeChanged = hasEditedFeature && hasOriginalFeature && !Objects.equals(editedFeature.getPageType(), originalFeature.getPageType());
    boolean routeIdChanged = hasEditedFeature && hasOriginalFeature && !Objects.equals(editedFeature.getRouteId(), originalFeature.getRouteId());
    boolean statusChanged = hasEditedFeature && hasOriginalFeature && !Objects.equals(editedFeature.getFeatureStatus(), originalFeature.getFeatureStatus());
    boolean parentPageChanged = hasEditedFeature && hasOriginalFeature && !Objects.equals(editedFeature.getParentPage(), originalFeature.getParentPage());

    // Feature field from/to values based on operation type
    String channelFrom = isAddFeature ? hyphen : (originalChannelName != null ? originalChannelName : (channelName != null ? channelName : hyphen));
    String channelTo = isDeleteFeature ? hyphen : (channelName != null ? channelName : hyphen);

    String featureNameFrom = isAddFeature ? hyphen : (hasOriginalFeature ? originalFeature.getFeatureName() : featureNameValue);
    String featureNameTo = isDeleteFeature ? hyphen : featureNameValue;

    String pageTypeFrom = isAddFeature ? hyphen : (originalPageTypeDisplay != null ? originalPageTypeDisplay : (pageTypeDisplay != null ? pageTypeDisplay : hyphen));
    String pageTypeTo = isDeleteFeature ? hyphen : (pageTypeDisplay != null ? pageTypeDisplay : hyphen);

    String routeIdFrom = isAddFeature ? hyphen : (hasOriginalFeature ? originalFeature.getRouteId() : (hasEditedFeature ? editedFeature.getRouteId() : hyphen));
    String routeIdTo = isDeleteFeature ? hyphen : (hasEditedFeature ? editedFeature.getRouteId() : hyphen);

    String statusFrom = isAddFeature ? hyphen : (hasOriginalFeature ? getFeatureStatusDisplay(originalFeature.getFeatureStatus()) : (hasEditedFeature ? getFeatureStatusDisplay(editedFeature.getFeatureStatus()) : hyphen));
    String statusTo = isDeleteFeature ? hyphen : (hasEditedFeature ? getFeatureStatusDisplay(editedFeature.getFeatureStatus()) : hyphen);

    String parentPageFrom = isAddFeature ? hyphen : (originalParentFeatureName != null ? originalParentFeatureName : hyphen);
    String parentPageTo = isDeleteFeature ? hyphen : (parentFeatureName != null ? parentFeatureName : hyphen);
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

<% if (isFeatureOperation) { %>
<!-- Feature Operations: Show full Feature details -->
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
        <% if (!isUpdateFeature || pageTypeChanged) { %>
        <tr>
            <td><strong>Page Type</strong></td>
            <td class="<%= fromClass %>"><%= pageTypeFrom %></td>
            <td class="<%= toClass %>"><%= pageTypeTo %></td>
        </tr>
        <% } %>
        <% if (("1".equals(hasEditedFeature ? editedFeature.getPageType() : "") || "1".equals(hasOriginalFeature ? originalFeature.getPageType() : "")) && (!isUpdateFeature || parentPageChanged)) { %>
        <tr>
            <td><strong>Parent Page</strong></td>
            <td class="<%= fromClass %>"><%= parentPageFrom %></td>
            <td class="<%= toClass %>"><%= parentPageTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdateFeature || routeIdChanged) { %>
        <tr>
            <td><strong>Route ID</strong></td>
            <td class="<%= fromClass %>"><%= routeIdFrom %></td>
            <td class="<%= toClass %>"><%= routeIdTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdateFeature || statusChanged) { %>
        <tr>
            <td><strong>Status</strong></td>
            <td class="<%= fromClass %>"><%= statusFrom %></td>
            <td class="<%= toClass %>"><%= statusTo %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>

<!-- Block Details (if exists and changed) -->
<%
    boolean hasBlockChanges = (editedBlock != null || originalBlock != null);

    if (hasBlockChanges) {
        // Check if block was added or removed
        boolean blockAdded = (editedBlock != null && originalBlock == null);
        boolean blockRemoved = (editedBlock == null && originalBlock != null);

        // Check for changes in existing blocks
        boolean blockTypeChanged = (editedBlock != null && originalBlock != null) && !Objects.equals(editedBlock.getType(), originalBlock.getType());
        boolean androidBlockChanged = (editedBlock != null && originalBlock != null) && editedBlock.getAndroidBlock() != originalBlock.getAndroidBlock();
        boolean iosBlockChanged = (editedBlock != null && originalBlock != null) && editedBlock.getIosBlock() != originalBlock.getIosBlock();
        boolean webBlockChanged = (editedBlock != null && originalBlock != null) && editedBlock.getWebBlock() != originalBlock.getWebBlock();
        boolean androidVersionChanged = (editedBlock != null && originalBlock != null) && !Objects.equals(editedBlock.getAndroidBlockVersion(), originalBlock.getAndroidBlockVersion());
        boolean iosVersionChanged = (editedBlock != null && originalBlock != null) && !Objects.equals(editedBlock.getIosBlockVersion(), originalBlock.getIosBlockVersion());
        boolean webVersionChanged = (editedBlock != null && originalBlock != null) && !Objects.equals(editedBlock.getWebBlockVersion(), originalBlock.getWebBlockVersion());

        // Check for date changes
        boolean androidDateFromChanged = (editedBlock != null && originalBlock != null) && !Objects.equals(editedBlock.getAndroidBlockFrom(), originalBlock.getAndroidBlockFrom());
        boolean androidDateToChanged = (editedBlock != null && originalBlock != null) && !Objects.equals(editedBlock.getAndroidBlockTo(), originalBlock.getAndroidBlockTo());
        boolean iosDateFromChanged = (editedBlock != null && originalBlock != null) && !Objects.equals(editedBlock.getIosBlockFrom(), originalBlock.getIosBlockFrom());
        boolean iosDateToChanged = (editedBlock != null && originalBlock != null) && !Objects.equals(editedBlock.getIosBlockTo(), originalBlock.getIosBlockTo());
        boolean webDateFromChanged = (editedBlock != null && originalBlock != null) && !Objects.equals(editedBlock.getWebBlockFrom(), originalBlock.getWebBlockFrom());
        boolean webDateToChanged = (editedBlock != null && originalBlock != null) && !Objects.equals(editedBlock.getWebBlockTo(), originalBlock.getWebBlockTo());



        // Show block section if it's add/delete OR if block was added/removed/changed
        if (isAddFeature || isDeleteFeature || blockAdded || blockRemoved || blockTypeChanged || androidBlockChanged ||
            iosBlockChanged || webBlockChanged || androidVersionChanged || iosVersionChanged || webVersionChanged ||
            androidDateFromChanged || androidDateToChanged || iosDateFromChanged || iosDateToChanged ||
            webDateFromChanged || webDateToChanged) {
%>
<div class="table-responsive">
    <h3 class="section-title">Block Details</h3>
    <table class="tm-table">
        <tbody>
        <tr class="tm-header">
            <th scope="col">Field</th>
            <th scope="col">From</th>
            <th scope="col">To</th>
        </tr>
        <% if (!isUpdateFeature || blockTypeChanged || blockAdded || blockRemoved) { %>
        <tr>
            <td><strong>Block Type</strong></td>
            <td class="<%= fromClass %>"><%= originalBlock != null ? getBlockTypeDisplay(originalBlock.getType()) : hyphen %></td>
            <td class="<%= toClass %>"><%= editedBlock != null ? getBlockTypeDisplay(editedBlock.getType()) : hyphen %></td>
        </tr>
        <% } %>
        <% if (!isUpdateFeature || androidBlockChanged || blockAdded || blockRemoved) { %>
        <tr>
            <td><strong>Android Block</strong></td>
            <td class="<%= fromClass %>"><%= originalBlock != null ? (originalBlock.getAndroidBlock() ? "Yes" : "No") : hyphen %></td>
            <td class="<%= toClass %>"><%= editedBlock != null ? (editedBlock.getAndroidBlock() ? "Yes" : "No") : hyphen %></td>
        </tr>
        <% } %>
        <% if (((editedBlock != null && editedBlock.getAndroidBlock()) || (originalBlock != null && originalBlock.getAndroidBlock())) &&
               (!isUpdateFeature || androidVersionChanged || blockAdded || blockRemoved)) { %>
        <tr>
            <td><strong>Android Version</strong></td>
            <td class="<%= fromClass %>"><%= originalBlock != null && originalBlock.getAndroidBlockVersion() != null ? originalBlock.getAndroidBlockVersion() : hyphen %></td>
            <td class="<%= toClass %>"><%= editedBlock != null && editedBlock.getAndroidBlockVersion() != null ? editedBlock.getAndroidBlockVersion() : hyphen %></td>
        </tr>
        <% } %>
        <% if (((editedBlock != null && (editedBlock.getAndroidBlockFrom() != null || editedBlock.getAndroidBlockTo() != null)) ||
                (originalBlock != null && (originalBlock.getAndroidBlockFrom() != null || originalBlock.getAndroidBlockTo() != null))) &&
               (!isUpdateFeature || androidDateFromChanged || androidDateToChanged || blockAdded || blockRemoved)) { %>
        <tr>
            <td><strong>Android Date From</strong></td>
            <td class="<%= fromClass %>"><%= originalBlock != null && originalBlock.getAndroidBlockFrom() != null ? dateFormat.format(originalBlock.getAndroidBlockFrom()) : hyphen %></td>
            <td class="<%= toClass %>"><%= editedBlock != null && editedBlock.getAndroidBlockFrom() != null ? dateFormat.format(editedBlock.getAndroidBlockFrom()) : hyphen %></td>
        </tr>
        <tr>
            <td><strong>Android Date To</strong></td>
            <td class="<%= fromClass %>"><%= originalBlock != null && originalBlock.getAndroidBlockTo() != null ? dateFormat.format(originalBlock.getAndroidBlockTo()) : hyphen %></td>
            <td class="<%= toClass %>"><%= editedBlock != null && editedBlock.getAndroidBlockTo() != null ? dateFormat.format(editedBlock.getAndroidBlockTo()) : hyphen %></td>
        </tr>
        <% } %>
        <% if (!isUpdateFeature || iosBlockChanged || blockAdded || blockRemoved) { %>
        <tr>
            <td><strong>iOS Block</strong></td>
            <td class="<%= fromClass %>"><%= originalBlock != null ? (originalBlock.getIosBlock() ? "Yes" : "No") : hyphen %></td>
            <td class="<%= toClass %>"><%= editedBlock != null ? (editedBlock.getIosBlock() ? "Yes" : "No") : hyphen %></td>
        </tr>
        <% } %>
        <% if (((editedBlock != null && editedBlock.getIosBlock()) || (originalBlock != null && originalBlock.getIosBlock())) &&
               (!isUpdateFeature || iosVersionChanged || blockAdded || blockRemoved)) { %>
        <tr>
            <td><strong>iOS Version</strong></td>
            <td class="<%= fromClass %>"><%= originalBlock != null && originalBlock.getIosBlockVersion() != null ? originalBlock.getIosBlockVersion() : hyphen %></td>
            <td class="<%= toClass %>"><%= editedBlock != null && editedBlock.getIosBlockVersion() != null ? editedBlock.getIosBlockVersion() : hyphen %></td>
        </tr>
        <% } %>
        <% if (((editedBlock != null && (editedBlock.getIosBlockFrom() != null || editedBlock.getIosBlockTo() != null)) ||
                (originalBlock != null && (originalBlock.getIosBlockFrom() != null || originalBlock.getIosBlockTo() != null))) &&
               (!isUpdateFeature || iosDateFromChanged || iosDateToChanged || blockAdded || blockRemoved)) { %>
        <tr>
            <td><strong>iOS Date From</strong></td>
            <td class="<%= fromClass %>"><%= originalBlock != null && originalBlock.getIosBlockFrom() != null ? dateFormat.format(originalBlock.getIosBlockFrom()) : hyphen %></td>
            <td class="<%= toClass %>"><%= editedBlock != null && editedBlock.getIosBlockFrom() != null ? dateFormat.format(editedBlock.getIosBlockFrom()) : hyphen %></td>
        </tr>
        <tr>
            <td><strong>iOS Date To</strong></td>
            <td class="<%= fromClass %>"><%= originalBlock != null && originalBlock.getIosBlockTo() != null ? dateFormat.format(originalBlock.getIosBlockTo()) : hyphen %></td>
            <td class="<%= toClass %>"><%= editedBlock != null && editedBlock.getIosBlockTo() != null ? dateFormat.format(editedBlock.getIosBlockTo()) : hyphen %></td>
        </tr>
        <% } %>
        <% if (!isUpdateFeature || webBlockChanged || blockAdded || blockRemoved) { %>
        <tr>
            <td><strong>Web Block</strong></td>
            <td class="<%= fromClass %>"><%= originalBlock != null ? (originalBlock.getWebBlock() ? "Yes" : "No") : hyphen %></td>
            <td class="<%= toClass %>"><%= editedBlock != null ? (editedBlock.getWebBlock() ? "Yes" : "No") : hyphen %></td>
        </tr>
        <% } %>
        <% if (((editedBlock != null && editedBlock.getWebBlock()) || (originalBlock != null && originalBlock.getWebBlock())) &&
               (!isUpdateFeature || webVersionChanged || blockAdded || blockRemoved)) { %>
        <tr>
            <td><strong>Web Version</strong></td>
            <td class="<%= fromClass %>"><%= originalBlock != null && originalBlock.getWebBlockVersion() != null ? originalBlock.getWebBlockVersion() : hyphen %></td>
            <td class="<%= toClass %>"><%= editedBlock != null && editedBlock.getWebBlockVersion() != null ? editedBlock.getWebBlockVersion() : hyphen %></td>
        </tr>
        <% } %>
        <% if (((editedBlock != null && (editedBlock.getWebBlockFrom() != null || editedBlock.getWebBlockTo() != null)) ||
                (originalBlock != null && (originalBlock.getWebBlockFrom() != null || originalBlock.getWebBlockTo() != null))) &&
               (!isUpdateFeature || webDateFromChanged || webDateToChanged || blockAdded || blockRemoved)) { %>
        <tr>
            <td><strong>Web Date From</strong></td>
            <td class="<%= fromClass %>"><%= originalBlock != null && originalBlock.getWebBlockFrom() != null ? dateFormat.format(originalBlock.getWebBlockFrom()) : hyphen %></td>
            <td class="<%= toClass %>"><%= editedBlock != null && editedBlock.getWebBlockFrom() != null ? dateFormat.format(editedBlock.getWebBlockFrom()) : hyphen %></td>
        </tr>
        <tr>
            <td><strong>Web Date To</strong></td>
            <td class="<%= fromClass %>"><%= originalBlock != null && originalBlock.getWebBlockTo() != null ? dateFormat.format(originalBlock.getWebBlockTo()) : hyphen %></td>
            <td class="<%= toClass %>"><%= editedBlock != null && editedBlock.getWebBlockTo() != null ? dateFormat.format(editedBlock.getWebBlockTo()) : hyphen %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
<%
        }
    }
%>

<!-- Segments Section for Add/Delete Feature -->
<%
    if (isAddFeature && editedSegments != null && !editedSegments.isEmpty()) {
%>
<div class="table-responsive">
    <h3 class="section-title">Segments (New)</h3>
    <table class="tm-table">
        <thead>
        <tr class="tm-header">
            <th>Segment Name</th>
            <th>Status</th>
            <th>Method</th>
        </tr>
        </thead>
        <tbody>
        <% for (Segment seg : editedSegments) { %>
        <tr>
            <td class="tm-to"><%= seg.getName() %></td>
            <td class="tm-to"><%= getSegmentStatusDisplay(seg.getSegmentStatus()) %></td>
            <td class="tm-to"><%= seg.getMethod() != null ? seg.getMethod() : hyphen %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
<%
    }
%>
<% } %>

<% if (isSegmentOperation) {
    // Debug logging
    System.out.println("=== SEGMENT UPDATE DEBUG ===");
    System.out.println("isSegmentOperation: " + isSegmentOperation);
    System.out.println("draftSegment: " + (draftSegment != null ? draftSegment.getSegmentId() : "NULL"));
    System.out.println("originalSegment: " + (originalSegment != null ? originalSegment.getSegmentId() : "NULL"));
    System.out.println("editedFeature ID: " + (editedFeature != null ? editedFeature.getFeatureId() : "NULL"));
%>

<% if (draftSegment != null) { %>
<!-- Segment Update Operation -->
<div class="table-responsive">
    <h3 class="section-title">Feature Information (Context)</h3>
    <table class="tm-table">
        <tbody>
        <tr>
            <td class="tm-meta-label"><strong>Feature Name</strong></td>
            <td class="tm-meta-value"><%= featureNameValue %></td>
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

<div class="table-responsive">
    <h3 class="section-title">Segment Changes</h3>
    <table class="tm-table">
        <tbody>
        <tr>
            <td class="tm-meta-label"><strong>Segment Name</strong></td>
            <td class="tm-meta-value" colspan="2"><%= draftSegment.getName() %></td>
        </tr>
        <tr class="tm-header">
            <th scope="col">Field</th>
            <th scope="col">From</th>
            <th scope="col">To</th>
        </tr>
        <%
            boolean segStatusChanged = originalSegment != null && !Objects.equals(draftSegment.getSegmentStatus(), originalSegment.getSegmentStatus());
            boolean segMethodChanged = originalSegment != null && !Objects.equals(draftSegment.getMethod(), originalSegment.getMethod());
            boolean segPopupTitleChanged = originalSegment != null && !Objects.equals(draftSegment.getPopUpTitle(), originalSegment.getPopUpTitle());
            boolean segPopupSubTitleChanged = originalSegment != null && !Objects.equals(draftSegment.getPopUpSubTitle(), originalSegment.getPopUpSubTitle());
        %>
        <% if (segStatusChanged) { %>
        <tr>
            <td><strong>Status</strong></td>
            <td class="tm-from"><%= originalSegment != null ? getSegmentStatusDisplay(originalSegment.getSegmentStatus()) : hyphen %></td>
            <td class="tm-to"><%= getSegmentStatusDisplay(draftSegment.getSegmentStatus()) %></td>
        </tr>
        <% } %>
        <% if (segMethodChanged) { %>
        <tr>
            <td><strong>Method</strong></td>
            <td class="tm-from"><%= originalSegment != null && originalSegment.getMethod() != null ? getSegmentMethodDisplay(originalSegment.getMethod()) : hyphen %></td>
            <td class="tm-to"><%= draftSegment.getMethod() != null ? getSegmentMethodDisplay(draftSegment.getMethod()) : hyphen %></td>
        </tr>
        <% } %>
        <% if (segPopupTitleChanged) { %>
        <tr>
            <td><strong>Popup Title</strong></td>
            <td class="tm-from"><%= originalSegment != null && originalSegment.getPopUpTitle() != null ? originalSegment.getPopUpTitle() : hyphen %></td>
            <td class="tm-to"><%= draftSegment.getPopUpTitle() != null ? draftSegment.getPopUpTitle() : hyphen %></td>
        </tr>
        <% } %>
        <% if (segPopupSubTitleChanged) { %>
        <tr>
            <td><strong>Popup Subtitle</strong></td>
            <td class="tm-from"><%= originalSegment != null && originalSegment.getPopUpSubTitle() != null ? originalSegment.getPopUpSubTitle() : hyphen %></td>
            <td class="tm-to"><%= draftSegment.getPopUpSubTitle() != null ? draftSegment.getPopUpSubTitle() : hyphen %></td>
        </tr>
        <% } %>
        <% if (!segStatusChanged && !segMethodChanged && !segPopupTitleChanged && !segPopupSubTitleChanged) { %>
        <tr>
            <td colspan="3" style="text-align: center;">No changes detected in segment fields.</td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
<% } else { %>
<!-- draftSegment is null - show error -->
<div class="alert alert-warning" role="alert">
    <strong>Warning:</strong> Could not load segment data for this workflow.
    Feature ID: <%= editedFeature != null ? editedFeature.getFeatureId() : "N/A" %>
</div>
<% } %>
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
    .section-title {
        margin-top: 20px;
        margin-bottom: 15px;
        color: #374151;
        font-family: "Helvetica", "Arial", sans-serif;
    }
</style>
