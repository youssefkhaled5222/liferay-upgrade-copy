<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page import="java.util.Objects" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ page import="com.ejada.telemony.db.model.Banner" %>
<%@ page import="com.ejada.telemony.db.model.BannerContent" %>
<%@ page import="com.ejada.telemony.db.model.BannerContentLocalization" %>
<%@ page import="com.ejada.telemony.db.model.Blocks" %>

<portlet:renderURL var="cancel_Lang">
    <portlet:param name="action" value="view" />
</portlet:renderURL>

<%!
    // Helper method to map container value to name
    private String mapContainerValue(String container) {
        if (container == null || container.equals("-")) return container;
        switch (container) {
            case "0": return "Dashboard";
            case "1": return "Transfer";
            default: return container;
        }
    }

    // Helper method to map banner type value to name
    private String mapBannerTypeValue(String bannerType, String container) {
        if (bannerType == null || bannerType.equals("-")) return bannerType;
        if (container != null && container.equals("1")) {
            return "Half Width";
        }
        switch (bannerType) {
            case "0": return "Full Width";
            case "1": return "Vertical";
            default: return bannerType;
        }
    }

    // Helper method to map link type value to name
    private String mapLinkTypeValue(String linkType) {
        if (linkType == null || linkType.equals("-")) return linkType;
        switch (linkType) {
            case "0": return "Internal";
            case "1": return "External";
            case "2": return "Deep Link";
            default: return linkType;
        }
    }

    // Helper method to map content status value to name
    private String mapContentStatusValue(String contentStatus) {
        if (contentStatus == null || contentStatus.equals("-")) return contentStatus;
        switch (contentStatus) {
            case "0": return "Publish";
            case "1": return "Draft";
            default: return contentStatus;
        }
    }

    // Helper method to map URL to feature name for internal URLs
    private String mapUrlToFeatureName(String url, String linkType, Map<String, String> featureMap) {
        if (url == null || url.equals("-")) return url;
        // Only map for internal URLs (linkType = 0)
        if ("0".equals(linkType) && featureMap != null && featureMap.containsKey(url)) {
            return featureMap.get(url);
        }
        return url;
    }

    // Helper method to get request type display name
    private String getRequestTypeDisplay(String workflowAction) {
        if (workflowAction == null) return "Unknown";
        switch (workflowAction) {
            case "ADD_BANNER": return "Add Banner";
            case "UPDATE_BANNER": return "Update Banner";
            case "DELETE_BANNER": return "Delete Banner";
            case "ADD_BANNER_CONTENT": return "Add Banner Content";
            case "UPDATE_BANNER_CONTENT": return "Update Banner Content";
            case "DELETE_BANNER_CONTENT": return "Delete Banner Content";
            default: return workflowAction;
        }
    }
%>

<%
    // Check if banner has been deleted (e.g., after DELETE workflow approval)
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

    // Get banner data
    Banner editedBanner = (Banner) request.getAttribute("banner");
    Banner originalBanner = (Banner) request.getAttribute("originalBanner");
    List<BannerContent> editedBannerContents = (List<BannerContent>) request.getAttribute("bannerContents");
    List<BannerContent> originalBannerContents = (List<BannerContent>) request.getAttribute("originalBannerContents");

    // Get workflow states
    Boolean isAlreadyApproved = (Boolean) request.getAttribute("isAlreadyApproved");
    boolean showApprovedBadge = isAlreadyApproved != null && isAlreadyApproved;

    Boolean isRejected = (Boolean) request.getAttribute("isRejected");
    boolean showRejectedBadge = isRejected != null && isRejected;

    // Get operation type flags from renderer
    Boolean isAddBannerFlag = (Boolean) request.getAttribute("isAddBanner");
    Boolean isUpdateBannerFlag = (Boolean) request.getAttribute("isUpdateBanner");
    Boolean isDeleteBannerFlag = (Boolean) request.getAttribute("isDeleteBanner");
    Boolean isAddBannerContentFlag = (Boolean) request.getAttribute("isAddBannerContent");
    Boolean isUpdateBannerContentFlag = (Boolean) request.getAttribute("isUpdateBannerContent");
    Boolean isDeleteBannerContentFlag = (Boolean) request.getAttribute("isDeleteBannerContent");

    boolean isAddBanner = isAddBannerFlag != null && isAddBannerFlag;
    boolean isUpdateBanner = isUpdateBannerFlag != null && isUpdateBannerFlag;
    boolean isDeleteBanner = isDeleteBannerFlag != null && isDeleteBannerFlag;
    boolean isAddBannerContent = isAddBannerContentFlag != null && isAddBannerContentFlag;
    boolean isUpdateBannerContent = isUpdateBannerContentFlag != null && isUpdateBannerContentFlag;
    boolean isDeleteBannerContent = isDeleteBannerContentFlag != null && isDeleteBannerContentFlag;

    // Determine if this is a banner operation or content operation
    boolean isBannerOperation = isAddBanner || isUpdateBanner || isDeleteBanner;
    boolean isContentOperation = isAddBannerContent || isUpdateBannerContent || isDeleteBannerContent;

    // Get persona names from request (now a List)
    List<String> personaNames = (List<String>) request.getAttribute("personaName");
    List<String> originalPersonaNames = (List<String>) request.getAttribute("originalPersonaName");

    // Get blocks from request
    Blocks block = (Blocks) request.getAttribute("block");
    Blocks originalBlock = (Blocks) request.getAttribute("originalBlock");

    // Get feature route to name map for URL display
    Map<String, String> featureRouteToNameMap = (Map<String, String>) request.getAttribute("featureRouteToNameMap");

    // Get channel names from request
    String channelName = (String) request.getAttribute("channelName");
    String originalChannelName = (String) request.getAttribute("originalChannelName");

    // Get localization maps from request
    Map<Long, List<BannerContentLocalization>> editedLocalizationsMap =
        (Map<Long, List<BannerContentLocalization>>) request.getAttribute("bannerContentLocalization");
    Map<Long, List<BannerContentLocalization>> originalLocalizationsMap =
        (Map<Long, List<BannerContentLocalization>>) request.getAttribute("originalBannerContentLocalization");

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    boolean hasEditedBanner = editedBanner != null;
    boolean hasOriginalBanner = originalBanner != null;
    boolean hasBannerContents = editedBannerContents != null && !editedBannerContents.isEmpty();

    String hyphen = "-";

    // Determine CSS classes based on operation type
    String fromClass = "";
    String toClass = "";

    if (isAddBanner || isAddBannerContent) {
        toClass = "tm-to";
    } else if (isDeleteBanner || isDeleteBannerContent) {
        fromClass = "tm-from";
    } else if (isUpdateBanner || isUpdateBannerContent) {
        fromClass = "tm-from";
        toClass = "tm-to";
    }

    // Banner field values
    String bannerNameValue = hasEditedBanner ? editedBanner.getBannerName() : hyphen;

    // Check for Banner field changes (for update operations)
    boolean channelChanged = hasEditedBanner && hasOriginalBanner && !Objects.equals(editedBanner.getChannelId(), originalBanner.getChannelId());
    boolean bannerNameChanged = hasEditedBanner && hasOriginalBanner && !Objects.equals(editedBanner.getBannerName(), originalBanner.getBannerName());
    boolean bannerTypeChanged = hasEditedBanner && hasOriginalBanner && !Objects.equals(editedBanner.getBannerType(), originalBanner.getBannerType());
    boolean containerChanged = hasEditedBanner && hasOriginalBanner && !Objects.equals(editedBanner.getContainer(), originalBanner.getContainer());
    boolean dateFromChanged = hasEditedBanner && hasOriginalBanner && !Objects.equals(editedBanner.getDateFrom(), originalBanner.getDateFrom());
    boolean dateToChanged = hasEditedBanner && hasOriginalBanner && !Objects.equals(editedBanner.getDateTo(), originalBanner.getDateTo());
    boolean personaChanged = hasEditedBanner && hasOriginalBanner && !Objects.equals(editedBanner.getPersona(), originalBanner.getPersona());

    // Banner field from/to values based on operation type
    String channelFrom = (isAddBanner || isAddBannerContent) ? hyphen : (originalChannelName != null ? originalChannelName : (channelName != null ? channelName : hyphen));
    String channelTo = (isDeleteBanner || isDeleteBannerContent) ? hyphen : (channelName != null ? channelName : hyphen);

    String bannerNameFrom = (isAddBanner || isAddBannerContent) ? hyphen : (hasOriginalBanner ? originalBanner.getBannerName() : bannerNameValue);
    String bannerNameTo = (isDeleteBanner || isDeleteBannerContent) ? hyphen : bannerNameValue;

    String bannerTypeFrom = (isAddBanner || isAddBannerContent) ? hyphen : (hasOriginalBanner ? mapBannerTypeValue(originalBanner.getBannerType(), originalBanner.getContainer()) : (hasEditedBanner ? mapBannerTypeValue(editedBanner.getBannerType(), editedBanner.getContainer()) : hyphen));
    String bannerTypeTo = (isDeleteBanner || isDeleteBannerContent) ? hyphen : (hasEditedBanner ? mapBannerTypeValue(editedBanner.getBannerType(), editedBanner.getContainer()) : hyphen);

    String containerFrom = (isAddBanner || isAddBannerContent) ? hyphen : (hasOriginalBanner ? mapContainerValue(originalBanner.getContainer()) : (hasEditedBanner ? mapContainerValue(editedBanner.getContainer()) : hyphen));
    String containerTo = (isDeleteBanner || isDeleteBannerContent) ? hyphen : (hasEditedBanner ? mapContainerValue(editedBanner.getContainer()) : hyphen);

    String dateFromVal = (isAddBanner || isAddBannerContent) ? hyphen : (hasOriginalBanner && originalBanner.getDateFrom() != null ? dateFormat.format(originalBanner.getDateFrom()) : (hasEditedBanner && editedBanner.getDateFrom() != null ? dateFormat.format(editedBanner.getDateFrom()) : hyphen));
    String dateFromTo = (isDeleteBanner || isDeleteBannerContent) ? hyphen : (hasEditedBanner && editedBanner.getDateFrom() != null ? dateFormat.format(editedBanner.getDateFrom()) : hyphen);

    String dateToVal = (isAddBanner || isAddBannerContent) ? hyphen : (hasOriginalBanner && originalBanner.getDateTo() != null ? dateFormat.format(originalBanner.getDateTo()) : (hasEditedBanner && editedBanner.getDateTo() != null ? dateFormat.format(editedBanner.getDateTo()) : hyphen));
    String dateToTo = (isDeleteBanner || isDeleteBannerContent) ? hyphen : (hasEditedBanner && editedBanner.getDateTo() != null ? dateFormat.format(editedBanner.getDateTo()) : hyphen);

    String personaNamesFrom = (isAddBanner || isAddBannerContent) ? hyphen : ((originalPersonaNames != null) ? String.join(", ", originalPersonaNames) : ((personaNames != null && !personaNames.isEmpty()) ? String.join(", ", personaNames) : hyphen));
    String personaNamesTo = (isDeleteBanner || isDeleteBannerContent) ? hyphen : (personaNames != null && !personaNames.isEmpty() ? String.join(", ", personaNames) : hyphen);
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

<% if (isBannerOperation) { %>
<!-- Banner Operations: Show full banner details -->
<div class="table-responsive">
    <h3>Banner Information</h3>
    <table class="tm-table">
        <tbody>
        <tr>
            <td class="tm-meta-label"><strong>Banner Name</strong></td>
            <td class="tm-meta-value" colspan="2"><%= bannerNameValue %></td>
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
        <% if (!isUpdateBanner || channelChanged) { %>
        <tr>
            <td><strong>Channel</strong></td>
            <td class="<%= fromClass %>"><%= channelFrom %></td>
            <td class="<%= toClass %>"><%= channelTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdateBanner || bannerNameChanged) { %>
        <tr>
            <td><strong>Banner Name</strong></td>
            <td class="<%= fromClass %>"><%= bannerNameFrom %></td>
            <td class="<%= toClass %>"><%= bannerNameTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdateBanner || bannerTypeChanged) { %>
        <tr>
            <td><strong>Banner Type</strong></td>
            <td class="<%= fromClass %>"><%= bannerTypeFrom %></td>
            <td class="<%= toClass %>"><%= bannerTypeTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdateBanner || containerChanged) { %>
        <tr>
            <td><strong>Container</strong></td>
            <td class="<%= fromClass %>"><%= containerFrom %></td>
            <td class="<%= toClass %>"><%= containerTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdateBanner || dateFromChanged) { %>
        <tr>
            <td><strong>Date From</strong></td>
            <td class="<%= fromClass %>"><%= dateFromVal %></td>
            <td class="<%= toClass %>"><%= dateFromTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdateBanner || dateToChanged) { %>
        <tr>
            <td><strong>Date To</strong></td>
            <td class="<%= fromClass %>"><%= dateToVal %></td>
            <td class="<%= toClass %>"><%= dateToTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdateBanner || personaChanged) { %>
        <tr>
            <td><strong>Persona</strong></td>
            <td class="<%= fromClass %>"><%= personaNamesFrom %></td>
            <td class="<%= toClass %>"><%= personaNamesTo %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>

<% if (isBannerOperation && (block != null || originalBlock != null)) {
    // Block field change detection
    boolean blockTypeChanged = block != null && originalBlock != null && !Objects.equals(block.getType(), originalBlock.getType());
    boolean androidBlockChanged = block != null && originalBlock != null && block.getAndroidBlock() != originalBlock.getAndroidBlock();
    boolean androidVersionChanged = block != null && originalBlock != null && !Objects.equals(block.getAndroidBlockVersion(), originalBlock.getAndroidBlockVersion());
    boolean androidFromChanged = block != null && originalBlock != null && !Objects.equals(block.getAndroidBlockFrom(), originalBlock.getAndroidBlockFrom());
    boolean androidToChanged = block != null && originalBlock != null && !Objects.equals(block.getAndroidBlockTo(), originalBlock.getAndroidBlockTo());
    boolean iosBlockChanged = block != null && originalBlock != null && block.getIosBlock() != originalBlock.getIosBlock();
    boolean iosVersionChanged = block != null && originalBlock != null && !Objects.equals(block.getIosBlockVersion(), originalBlock.getIosBlockVersion());
    boolean iosFromChanged = block != null && originalBlock != null && !Objects.equals(block.getIosBlockFrom(), originalBlock.getIosBlockFrom());
    boolean iosToChanged = block != null && originalBlock != null && !Objects.equals(block.getIosBlockTo(), originalBlock.getIosBlockTo());
    boolean webBlockChanged = block != null && originalBlock != null && block.getWebBlock() != originalBlock.getWebBlock();
    boolean webVersionChanged = block != null && originalBlock != null && !Objects.equals(block.getWebBlockVersion(), originalBlock.getWebBlockVersion());
    boolean webFromChanged = block != null && originalBlock != null && !Objects.equals(block.getWebBlockFrom(), originalBlock.getWebBlockFrom());
    boolean webToChanged = block != null && originalBlock != null && !Objects.equals(block.getWebBlockTo(), originalBlock.getWebBlockTo());

    boolean hasBlockChanges = blockTypeChanged || androidBlockChanged || androidVersionChanged || androidFromChanged || androidToChanged ||
            iosBlockChanged || iosVersionChanged || iosFromChanged || iosToChanged ||
            webBlockChanged || webVersionChanged || webFromChanged || webToChanged;

    // Block to use for values
    Blocks displayBlock = block != null ? block : originalBlock;

    // Block field values
    String blockTypeFrom = isAddBanner ? hyphen : (originalBlock != null ? originalBlock.getType() : (displayBlock != null ? displayBlock.getType() : hyphen));
    String blockTypeTo = isDeleteBanner ? hyphen : (block != null ? block.getType() : hyphen);

    // Android block values
    String androidBlockFromVal = isAddBanner ? hyphen : (originalBlock != null ? (originalBlock.getAndroidBlock() ? "Yes" : "No") : (displayBlock != null ? (displayBlock.getAndroidBlock() ? "Yes" : "No") : hyphen));
    String androidBlockToVal = isDeleteBanner ? hyphen : (block != null ? (block.getAndroidBlock() ? "Yes" : "No") : hyphen);
    String androidVersionFrom = isAddBanner ? hyphen : (originalBlock != null && originalBlock.getAndroidBlockVersion() != null ? originalBlock.getAndroidBlockVersion() : (displayBlock != null && displayBlock.getAndroidBlockVersion() != null ? displayBlock.getAndroidBlockVersion() : hyphen));
    String androidVersionTo = isDeleteBanner ? hyphen : (block != null && block.getAndroidBlockVersion() != null ? block.getAndroidBlockVersion() : hyphen);
    String androidDateFromVal = isAddBanner ? hyphen : (originalBlock != null && originalBlock.getAndroidBlockFrom() != null ? dateFormat.format(originalBlock.getAndroidBlockFrom()) : (displayBlock != null && displayBlock.getAndroidBlockFrom() != null ? dateFormat.format(displayBlock.getAndroidBlockFrom()) : hyphen));
    String androidDateFromTo = isDeleteBanner ? hyphen : (block != null && block.getAndroidBlockFrom() != null ? dateFormat.format(block.getAndroidBlockFrom()) : hyphen);
    String androidDateToVal = isAddBanner ? hyphen : (originalBlock != null && originalBlock.getAndroidBlockTo() != null ? dateFormat.format(originalBlock.getAndroidBlockTo()) : (displayBlock != null && displayBlock.getAndroidBlockTo() != null ? dateFormat.format(displayBlock.getAndroidBlockTo()) : hyphen));
    String androidDateToTo = isDeleteBanner ? hyphen : (block != null && block.getAndroidBlockTo() != null ? dateFormat.format(block.getAndroidBlockTo()) : hyphen);

    // iOS block values
    String iosBlockFromVal = isAddBanner ? hyphen : (originalBlock != null ? (originalBlock.getIosBlock() ? "Yes" : "No") : (displayBlock != null ? (displayBlock.getIosBlock() ? "Yes" : "No") : hyphen));
    String iosBlockToVal = isDeleteBanner ? hyphen : (block != null ? (block.getIosBlock() ? "Yes" : "No") : hyphen);
    String iosVersionFrom = isAddBanner ? hyphen : (originalBlock != null && originalBlock.getIosBlockVersion() != null ? originalBlock.getIosBlockVersion() : (displayBlock != null && displayBlock.getIosBlockVersion() != null ? displayBlock.getIosBlockVersion() : hyphen));
    String iosVersionTo = isDeleteBanner ? hyphen : (block != null && block.getIosBlockVersion() != null ? block.getIosBlockVersion() : hyphen);
    String iosDateFromVal = isAddBanner ? hyphen : (originalBlock != null && originalBlock.getIosBlockFrom() != null ? dateFormat.format(originalBlock.getIosBlockFrom()) : (displayBlock != null && displayBlock.getIosBlockFrom() != null ? dateFormat.format(displayBlock.getIosBlockFrom()) : hyphen));
    String iosDateFromTo = isDeleteBanner ? hyphen : (block != null && block.getIosBlockFrom() != null ? dateFormat.format(block.getIosBlockFrom()) : hyphen);
    String iosDateToVal = isAddBanner ? hyphen : (originalBlock != null && originalBlock.getIosBlockTo() != null ? dateFormat.format(originalBlock.getIosBlockTo()) : (displayBlock != null && displayBlock.getIosBlockTo() != null ? dateFormat.format(displayBlock.getIosBlockTo()) : hyphen));
    String iosDateToTo = isDeleteBanner ? hyphen : (block != null && block.getIosBlockTo() != null ? dateFormat.format(block.getIosBlockTo()) : hyphen);

    // Web block values
    String webBlockFromVal = isAddBanner ? hyphen : (originalBlock != null ? (originalBlock.getWebBlock() ? "Yes" : "No") : (displayBlock != null ? (displayBlock.getWebBlock() ? "Yes" : "No") : hyphen));
    String webBlockToVal = isDeleteBanner ? hyphen : (block != null ? (block.getWebBlock() ? "Yes" : "No") : hyphen);
    String webVersionFrom = isAddBanner ? hyphen : (originalBlock != null && originalBlock.getWebBlockVersion() != null ? originalBlock.getWebBlockVersion() : (displayBlock != null && displayBlock.getWebBlockVersion() != null ? displayBlock.getWebBlockVersion() : hyphen));
    String webVersionTo = isDeleteBanner ? hyphen : (block != null && block.getWebBlockVersion() != null ? block.getWebBlockVersion() : hyphen);
    String webDateFromVal = isAddBanner ? hyphen : (originalBlock != null && originalBlock.getWebBlockFrom() != null ? dateFormat.format(originalBlock.getWebBlockFrom()) : (displayBlock != null && displayBlock.getWebBlockFrom() != null ? dateFormat.format(displayBlock.getWebBlockFrom()) : hyphen));
    String webDateFromTo = isDeleteBanner ? hyphen : (block != null && block.getWebBlockFrom() != null ? dateFormat.format(block.getWebBlockFrom()) : hyphen);
    String webDateToVal = isAddBanner ? hyphen : (originalBlock != null && originalBlock.getWebBlockTo() != null ? dateFormat.format(originalBlock.getWebBlockTo()) : (displayBlock != null && displayBlock.getWebBlockTo() != null ? dateFormat.format(displayBlock.getWebBlockTo()) : hyphen));
    String webDateToTo = isDeleteBanner ? hyphen : (block != null && block.getWebBlockTo() != null ? dateFormat.format(block.getWebBlockTo()) : hyphen);

    // Only show Block Details if there are changes (for update) or if it's add/delete operation
    boolean showBlockDetails = !isUpdateBanner || hasBlockChanges;
%>
<% if (showBlockDetails) { %>
<div class="table-responsive" style="margin-top: 30px;">
    <h3>Block Details</h3>
    <table class="tm-table">
        <tbody>
        <tr class="tm-header">
            <th scope="col">Field</th>
            <th scope="col">From</th>
            <th scope="col">To</th>
        </tr>
        <% if (!isUpdateBanner || blockTypeChanged) { %>
        <tr>
            <td><strong>Block Type</strong></td>
            <td class="<%= fromClass %>"><%= blockTypeFrom %></td>
            <td class="<%= toClass %>"><%= blockTypeTo %></td>
        </tr>
        <% } %>

        <!-- Android Block Section -->
        <tr class="tm-language-header">
            <td colspan="3"><strong>Android Settings</strong></td>
        </tr>
        <% if (!isUpdateBanner || androidBlockChanged) { %>
        <tr>
            <td><strong>Android Block Enabled</strong></td>
            <td class="<%= fromClass %>"><%= androidBlockFromVal %></td>
            <td class="<%= toClass %>"><%= androidBlockToVal %></td>
        </tr>
        <% } %>
        <% if (!isUpdateBanner || androidVersionChanged) { %>
        <tr>
            <td><strong>Android Version</strong></td>
            <td class="<%= fromClass %>"><%= androidVersionFrom %></td>
            <td class="<%= toClass %>"><%= androidVersionTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdateBanner || androidFromChanged) { %>
        <tr>
            <td><strong>Android Block From</strong></td>
            <td class="<%= fromClass %>"><%= androidDateFromVal %></td>
            <td class="<%= toClass %>"><%= androidDateFromTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdateBanner || androidToChanged) { %>
        <tr>
            <td><strong>Android Block To</strong></td>
            <td class="<%= fromClass %>"><%= androidDateToVal %></td>
            <td class="<%= toClass %>"><%= androidDateToTo %></td>
        </tr>
        <% } %>

        <!-- iOS Block Section -->
        <tr class="tm-language-header">
            <td colspan="3"><strong>iOS Settings</strong></td>
        </tr>
        <% if (!isUpdateBanner || iosBlockChanged) { %>
        <tr>
            <td><strong>iOS Block Enabled</strong></td>
            <td class="<%= fromClass %>"><%= iosBlockFromVal %></td>
            <td class="<%= toClass %>"><%= iosBlockToVal %></td>
        </tr>
        <% } %>
        <% if (!isUpdateBanner || iosVersionChanged) { %>
        <tr>
            <td><strong>iOS Version</strong></td>
            <td class="<%= fromClass %>"><%= iosVersionFrom %></td>
            <td class="<%= toClass %>"><%= iosVersionTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdateBanner || iosFromChanged) { %>
        <tr>
            <td><strong>iOS Block From</strong></td>
            <td class="<%= fromClass %>"><%= iosDateFromVal %></td>
            <td class="<%= toClass %>"><%= iosDateFromTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdateBanner || iosToChanged) { %>
        <tr>
            <td><strong>iOS Block To</strong></td>
            <td class="<%= fromClass %>"><%= iosDateToVal %></td>
            <td class="<%= toClass %>"><%= iosDateToTo %></td>
        </tr>
        <% } %>

        <!-- Web Block Section -->
        <tr class="tm-language-header">
            <td colspan="3"><strong>Web Settings</strong></td>
        </tr>
        <% if (!isUpdateBanner || webBlockChanged) { %>
        <tr>
            <td><strong>Web Block Enabled</strong></td>
            <td class="<%= fromClass %>"><%= webBlockFromVal %></td>
            <td class="<%= toClass %>"><%= webBlockToVal %></td>
        </tr>
        <% } %>
        <% if (!isUpdateBanner || webVersionChanged) { %>
        <tr>
            <td><strong>Web Version</strong></td>
            <td class="<%= fromClass %>"><%= webVersionFrom %></td>
            <td class="<%= toClass %>"><%= webVersionTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdateBanner || webFromChanged) { %>
        <tr>
            <td><strong>Web Block From</strong></td>
            <td class="<%= fromClass %>"><%= webDateFromVal %></td>
            <td class="<%= toClass %>"><%= webDateFromTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdateBanner || webToChanged) { %>
        <tr>
            <td><strong>Web Block To</strong></td>
            <td class="<%= fromClass %>"><%= webDateToVal %></td>
            <td class="<%= toClass %>"><%= webDateToTo %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
<% } %> <%-- End showBlockDetails --%>
<% } %> <%-- End block != null || originalBlock != null --%>
<% } %> <%-- End isBannerOperation --%>

<% if (isContentOperation) { %>
<!-- Content Operations: Show banner info as context only -->
<div class="table-responsive">
    <h3>Banner Information (Context)</h3>
    <table class="tm-table">
        <tbody>
        <tr>
            <td class="tm-meta-label"><strong>Banner Name</strong></td>
            <td class="tm-meta-value"><%= bannerNameValue %></td>
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

<% if (hasBannerContents) { %>
<div class="table-responsive" style="margin-top: 30px;">
    <%
        // For UPDATE_BANNER, content changes are ONLY order changes
        String contentSectionTitle = isUpdateBanner ? "Banner Content Order Changes" : "Banner Content Changes";

        // DEBUG LOGS
        System.out.println("=== DEBUG: Banner Content Section ===");
        System.out.println("isUpdateBanner: " + isUpdateBanner);
        System.out.println("editedBannerContents size: " + (editedBannerContents != null ? editedBannerContents.size() : "null"));
        System.out.println("originalBannerContents size: " + (originalBannerContents != null ? originalBannerContents.size() : "null"));
    %>
    <h3><%= contentSectionTitle %></h3>
    <%
        for (BannerContent editedContent : editedBannerContents) {
            BannerContent originalContent = null;
            long contentOriginalEntityId = editedContent.getOriginalEntityId();

            // DEBUG LOGS for each edited content
            System.out.println("--- Edited Content ---");
            System.out.println("editedContent.getContentId(): " + editedContent.getContentId());
            System.out.println("editedContent.getContentName(): " + editedContent.getContentName());
            System.out.println("editedContent.getContentOrder(): " + editedContent.getContentOrder());
            System.out.println("editedContent.getOriginalEntityId(): " + contentOriginalEntityId);
            System.out.println("editedContent.getEntityResourceId(): " + editedContent.getEntityResourceId());
            System.out.println("editedContent.getBannerId(): " + editedContent.getBannerId());

            // For UPDATE_BANNER, use originalEntityId to find the matching original content
            if (isUpdateBanner && contentOriginalEntityId != 0L) {
                if (originalBannerContents != null) {
                    System.out.println("Searching originalBannerContents for contentId == " + contentOriginalEntityId);
                    for (BannerContent oc : originalBannerContents) {
                        System.out.println("  Checking oc.getContentId(): " + oc.getContentId() + ", oc.getContentName(): " + oc.getContentName() + ", oc.getContentOrder(): " + oc.getContentOrder());
                        if (oc.getContentId() == contentOriginalEntityId) {
                            originalContent = oc;
                            System.out.println("  MATCH FOUND!");
                            break;
                        }
                    }
                }
            } else {
                // For other operations, find the matching original content
                if (originalBannerContents != null && contentOriginalEntityId != 0L) {
                    for (BannerContent oc : originalBannerContents) {
                        if (oc.getContentId() == contentOriginalEntityId) {
                            originalContent = oc;
                            break;
                        }
                    }
                }

                // Fallback: match by resourceId
                if (originalBannerContents != null && originalContent == null) {
                    for (BannerContent oc : originalBannerContents) {
                        if (oc.getEntityResourceId() == editedContent.getEntityResourceId()) {
                            originalContent = oc;
                            break;
                        }
                    }
                }
            }

            boolean hasOriginalContent = originalContent != null;

            // DEBUG: Show matching result
            System.out.println("hasOriginalContent: " + hasOriginalContent);
            if (hasOriginalContent) {
                System.out.println("originalContent.getContentId(): " + originalContent.getContentId());
                System.out.println("originalContent.getContentName(): " + originalContent.getContentName());
                System.out.println("originalContent.getContentOrder(): " + originalContent.getContentOrder());
            }

            // For UPDATE_BANNER, only show order changes
            if (isUpdateBanner) {
                // Skip if no original content found or no order change
                if (!hasOriginalContent) {
                    System.out.println("SKIPPING: No original content found");
                    continue;
                }
                if (editedContent.getContentOrder() == originalContent.getContentOrder()) {
                    System.out.println("SKIPPING: Order not changed (both are " + editedContent.getContentOrder() + ")");
                    continue;
                }

                System.out.println("DISPLAYING ORDER CHANGE: " + originalContent.getContentOrder() + " -> " + editedContent.getContentOrder());

                String contentNameValue = editedContent.getContentName();
                int orderFrom = originalContent.getContentOrder();
                int orderTo = editedContent.getContentOrder();
    %>
    <table class="tm-table" style="margin-bottom: 20px;">
        <tbody>
        <tr>
            <td class="tm-meta-label"><strong>Content Name</strong></td>
            <td class="tm-meta-value" colspan="2"><%= contentNameValue %></td>
        </tr>
        <tr>
            <td class="tm-meta-label"><strong>Request</strong></td>
            <td class="tm-meta-value" colspan="2">Order Change</td>
        </tr>
        <tr class="tm-header">
            <th scope="col">Field</th>
            <th scope="col">From</th>
            <th scope="col">To</th>
        </tr>
        <tr>
            <td><strong>Content Order</strong></td>
            <td class="tm-from"><%= orderFrom %></td>
            <td class="tm-to"><%= orderTo %></td>
        </tr>
        </tbody>
    </table>
    <%
            } else {
                // Non-UPDATE_BANNER operations (ADD, DELETE, UPDATE_BANNER_CONTENT, etc.)
                // Determine content operation type based on parent workflow action
                boolean isContentAdd = isAddBanner || isAddBannerContent || contentOriginalEntityId == 0L;
                boolean isContentDelete = isDeleteBanner || isDeleteBannerContent;
                boolean isContentUpdate = isUpdateBannerContent;

                // Get localizations
                List<BannerContentLocalization> editedLocalizations = null;
                if (editedLocalizationsMap != null) {
                    editedLocalizations = editedLocalizationsMap.get(editedContent.getContentId());
                }

                List<BannerContentLocalization> originalLocalizations = null;
                if (hasOriginalContent && originalLocalizationsMap != null) {
                    originalLocalizations = originalLocalizationsMap.get(originalContent.getContentId());
                }

                String contentNameValue = editedContent.getContentName();

                // Field values based on operation type
                String contentNameFrom, contentNameTo;
                String contentOrderFrom, contentOrderTo;
                String contentStatusFrom, contentStatusTo;

                if (isContentDelete) {
                    contentNameFrom = editedContent.getContentName();
                    contentNameTo = hyphen;
                    contentOrderFrom = String.valueOf(editedContent.getContentOrder());
                    contentOrderTo = hyphen;
                    contentStatusFrom = mapContentStatusValue(editedContent.getContentStatus());
                    contentStatusTo = hyphen;
                } else if (isContentAdd) {
                    contentNameFrom = hyphen;
                    contentNameTo = editedContent.getContentName();
                    contentOrderFrom = hyphen;
                    contentOrderTo = String.valueOf(editedContent.getContentOrder());
                    contentStatusFrom = hyphen;
                    contentStatusTo = mapContentStatusValue(editedContent.getContentStatus());
                } else {
                    contentNameFrom = hasOriginalContent ? originalContent.getContentName() : hyphen;
                    contentNameTo = editedContent.getContentName();
                    contentOrderFrom = hasOriginalContent ? String.valueOf(originalContent.getContentOrder()) : hyphen;
                    contentOrderTo = String.valueOf(editedContent.getContentOrder());
                    contentStatusFrom = hasOriginalContent ? mapContentStatusValue(originalContent.getContentStatus()) : hyphen;
                    contentStatusTo = mapContentStatusValue(editedContent.getContentStatus());
                }

                // Check for changes (for update only)
                boolean contentNameChanged = hasOriginalContent && !Objects.equals(editedContent.getContentName(), originalContent.getContentName());
                boolean contentOrderChanged = hasOriginalContent && editedContent.getContentOrder() != originalContent.getContentOrder();
                boolean contentStatusChanged = hasOriginalContent && !Objects.equals(editedContent.getContentStatus(), originalContent.getContentStatus());

                String contentRequestType;
                if (isContentAdd) {
                    contentRequestType = "Add";
                } else if (isContentDelete) {
                    contentRequestType = "Delete";
                } else {
                    contentRequestType = "Update";
                }

                String contentFromClass = (isContentUpdate || isContentDelete) ? "tm-from" : "";
                String contentToClass = (isContentUpdate || isContentAdd) ? "tm-to" : "";
    %>

    <table class="tm-table" style="margin-bottom: 20px;">
        <tbody>
        <tr>
            <td class="tm-meta-label"><strong>Content Name</strong></td>
            <td class="tm-meta-value" colspan="2"><%= contentNameValue %></td>
        </tr>
        <tr>
            <td class="tm-meta-label"><strong>Request</strong></td>
            <td class="tm-meta-value" colspan="2"><%= contentRequestType %></td>
        </tr>
        <tr class="tm-header">
            <th scope="col">Field</th>
            <th scope="col">From</th>
            <th scope="col">To</th>
        </tr>
        <% if (!isContentUpdate || contentNameChanged) { %>
        <tr>
            <td><strong>Content Name</strong></td>
            <td class="<%= contentFromClass %>"><%= contentNameFrom %></td>
            <td class="<%= contentToClass %>"><%= contentNameTo %></td>
        </tr>
        <% } %>
        <% if (!isContentUpdate || contentOrderChanged) { %>
        <tr>
            <td><strong>Content Order</strong></td>
            <td class="<%= contentFromClass %>"><%= contentOrderFrom %></td>
            <td class="<%= contentToClass %>"><%= contentOrderTo %></td>
        </tr>
        <% } %>
        <% if (!isContentUpdate || contentStatusChanged) { %>
        <tr>
            <td><strong>Content Status</strong></td>
            <td class="<%= contentFromClass %>"><%= contentStatusFrom %></td>
            <td class="<%= contentToClass %>"><%= contentStatusTo %></td>
        </tr>
        <% } %>

        <%
            // Display localized fields only for non-UPDATE_BANNER operations
            if (editedLocalizations != null && !editedLocalizations.isEmpty()) {
                Map<String, BannerContentLocalization> editedLocMap = new HashMap<>();
                for (BannerContentLocalization loc : editedLocalizations) {
                    editedLocMap.put(loc.getLanguageId(), loc);
                }

                Map<String, BannerContentLocalization> originalLocMap = new HashMap<>();
                if (originalLocalizations != null) {
                    for (BannerContentLocalization loc : originalLocalizations) {
                        originalLocMap.put(loc.getLanguageId(), loc);
                    }
                }

                for (Map.Entry<String, BannerContentLocalization> entry : editedLocMap.entrySet()) {
                    String language = entry.getKey();
                    BannerContentLocalization editedLoc = entry.getValue();
                    BannerContentLocalization originalLoc = originalLocMap.get(language);
                    boolean hasOriginalLoc = originalLoc != null;

                    // Check if has any values
                    boolean editedHasValues = (editedLoc.getBannerImage() != null && !editedLoc.getBannerImage().isEmpty()) ||
                            (editedLoc.getImageOverlay() != null && !editedLoc.getImageOverlay().isEmpty()) ||
                            (editedLoc.getLinkType() != null && !editedLoc.getLinkType().isEmpty()) ||
                            (editedLoc.getUrl() != null && !editedLoc.getUrl().isEmpty()) ||
                            (editedLoc.getTitleValue() != null && !editedLoc.getTitleValue().isEmpty()) ||
                            (editedLoc.getDescriptionValue() != null && !editedLoc.getDescriptionValue().isEmpty());

                    // Skip if no values
                    if (!editedHasValues && !hasOriginalLoc) continue;

                    // Localized field values based on operation type
                    String bannerImageFrom, bannerImageTo;
                    String imageOverlayFrom, imageOverlayTo;
                    String linkTypeFrom, linkTypeTo;
                    String urlFrom, urlTo;
                    String titleFrom, titleTo;
                    String descriptionFrom, descriptionTo;

                    if (isContentDelete) {
                        bannerImageFrom = editedLoc.getBannerImage() != null ? editedLoc.getBannerImage() : hyphen;
                        bannerImageTo = hyphen;
                        imageOverlayFrom = editedLoc.getImageOverlay() != null ? editedLoc.getImageOverlay() : hyphen;
                        imageOverlayTo = hyphen;
                        String rawLinkType = editedLoc.getLinkType();
                        linkTypeFrom = rawLinkType != null ? mapLinkTypeValue(rawLinkType) : hyphen;
                        linkTypeTo = hyphen;
                        urlFrom = editedLoc.getUrl() != null ? mapUrlToFeatureName(editedLoc.getUrl(), rawLinkType, featureRouteToNameMap) : hyphen;
                        urlTo = hyphen;
                        titleFrom = editedLoc.getTitleValue() != null ? editedLoc.getTitleValue() : hyphen;
                        titleTo = hyphen;
                        descriptionFrom = editedLoc.getDescriptionValue() != null ? editedLoc.getDescriptionValue() : hyphen;
                        descriptionTo = hyphen;
                    } else if (isContentAdd) {
                        bannerImageFrom = hyphen;
                        bannerImageTo = editedLoc.getBannerImage() != null ? editedLoc.getBannerImage() : hyphen;
                        imageOverlayFrom = hyphen;
                        imageOverlayTo = editedLoc.getImageOverlay() != null ? editedLoc.getImageOverlay() : hyphen;
                        linkTypeFrom = hyphen;
                        String rawLinkType = editedLoc.getLinkType();
                        linkTypeTo = rawLinkType != null ? mapLinkTypeValue(rawLinkType) : hyphen;
                        urlFrom = hyphen;
                        urlTo = editedLoc.getUrl() != null ? mapUrlToFeatureName(editedLoc.getUrl(), rawLinkType, featureRouteToNameMap) : hyphen;
                        titleFrom = hyphen;
                        titleTo = editedLoc.getTitleValue() != null ? editedLoc.getTitleValue() : hyphen;
                        descriptionFrom = hyphen;
                        descriptionTo = editedLoc.getDescriptionValue() != null ? editedLoc.getDescriptionValue() : hyphen;
                    } else {
                        // Update operation
                        String rawLinkTypeFrom = hasOriginalLoc && originalLoc.getLinkType() != null ? originalLoc.getLinkType() : null;
                        String rawLinkTypeTo = editedLoc.getLinkType() != null ? editedLoc.getLinkType() : null;
                        bannerImageFrom = hasOriginalLoc && originalLoc.getBannerImage() != null ? originalLoc.getBannerImage() : hyphen;
                        bannerImageTo = editedLoc.getBannerImage() != null ? editedLoc.getBannerImage() : hyphen;
                        imageOverlayFrom = hasOriginalLoc && originalLoc.getImageOverlay() != null ? originalLoc.getImageOverlay() : hyphen;
                        imageOverlayTo = editedLoc.getImageOverlay() != null ? editedLoc.getImageOverlay() : hyphen;
                        linkTypeFrom = hasOriginalLoc && originalLoc.getLinkType() != null ? mapLinkTypeValue(originalLoc.getLinkType()) : hyphen;
                        linkTypeTo = editedLoc.getLinkType() != null ? mapLinkTypeValue(editedLoc.getLinkType()) : hyphen;
                        urlFrom = hasOriginalLoc && originalLoc.getUrl() != null ? mapUrlToFeatureName(originalLoc.getUrl(), rawLinkTypeFrom, featureRouteToNameMap) : hyphen;
                        urlTo = editedLoc.getUrl() != null ? mapUrlToFeatureName(editedLoc.getUrl(), rawLinkTypeTo, featureRouteToNameMap) : hyphen;
                        titleFrom = hasOriginalLoc && originalLoc.getTitleValue() != null ? originalLoc.getTitleValue() : hyphen;
                        titleTo = editedLoc.getTitleValue() != null ? editedLoc.getTitleValue() : hyphen;
                        descriptionFrom = hasOriginalLoc && originalLoc.getDescriptionValue() != null ? originalLoc.getDescriptionValue() : hyphen;
                        descriptionTo = editedLoc.getDescriptionValue() != null ? editedLoc.getDescriptionValue() : hyphen;
                    }

                    // Check for changes (for update operation filtering)
                    boolean bannerImageChanged = hasOriginalLoc && !Objects.equals(editedLoc.getBannerImage(), originalLoc.getBannerImage());
                    boolean imageOverlayChanged = hasOriginalLoc && !Objects.equals(editedLoc.getImageOverlay(), originalLoc.getImageOverlay());
                    boolean linkTypeChanged = hasOriginalLoc && !Objects.equals(editedLoc.getLinkType(), originalLoc.getLinkType());
                    boolean urlChanged = hasOriginalLoc && !Objects.equals(editedLoc.getUrl(), originalLoc.getUrl());
                    boolean titleChanged = hasOriginalLoc && !Objects.equals(editedLoc.getTitleValue(), originalLoc.getTitleValue());
                    boolean descChanged = hasOriginalLoc && !Objects.equals(editedLoc.getDescriptionValue(), originalLoc.getDescriptionValue());

                    // For update, skip if nothing changed in this language
                    if (isContentUpdate && !bannerImageChanged && !imageOverlayChanged && !linkTypeChanged && !urlChanged && !titleChanged && !descChanged) {
                        continue;
                    }
        %>

        <tr class="tm-language-header">
            <td colspan="3"><strong>Language: <%= language %></strong></td>
        </tr>

        <% if (!isContentUpdate || bannerImageChanged) { %>
        <tr>
            <td><strong>Banner Image</strong></td>
            <td class="<%= contentFromClass %>">
                <% if (!bannerImageFrom.equals(hyphen) && !bannerImageFrom.isEmpty()) { %>
                    <img src="data:image/jpeg;base64,<%= bannerImageFrom %>" alt="Original Banner Image" style="max-width: 150px; max-height: 100px; object-fit: contain;" />
                <% } else { %>
                    <%= hyphen %>
                <% } %>
            </td>
            <td class="<%= contentToClass %>">
                <% if (!bannerImageTo.equals(hyphen) && !bannerImageTo.isEmpty()) { %>
                    <img src="data:image/jpeg;base64,<%= bannerImageTo %>" alt="Edited Banner Image" style="max-width: 150px; max-height: 100px; object-fit: contain;" />
                <% } else { %>
                    <%= hyphen %>
                <% } %>
            </td>
        </tr>
        <% } %>
        <% if (!isContentUpdate || imageOverlayChanged) { %>
        <tr>
            <td><strong>Image Overlay</strong></td>
            <td class="<%= contentFromClass %>"><%= imageOverlayFrom %></td>
            <td class="<%= contentToClass %>"><%= imageOverlayTo %></td>
        </tr>
        <% } %>
        <% if (!isContentUpdate || linkTypeChanged) { %>
        <tr>
            <td><strong>Link Type</strong></td>
            <td class="<%= contentFromClass %>"><%= linkTypeFrom %></td>
            <td class="<%= contentToClass %>"><%= linkTypeTo %></td>
        </tr>
        <% } %>
        <% if (!isContentUpdate || urlChanged) { %>
        <tr>
            <td><strong>URL</strong></td>
            <td class="<%= contentFromClass %>"><%= urlFrom %></td>
            <td class="<%= contentToClass %>"><%= urlTo %></td>
        </tr>
        <% } %>
        <% if (!isContentUpdate || titleChanged) { %>
        <tr>
            <td><strong>Title</strong></td>
            <td class="<%= contentFromClass %>"><%= titleFrom %></td>
            <td class="<%= contentToClass %>"><%= titleTo %></td>
        </tr>
        <% } %>
        <% if (!isContentUpdate || descChanged) { %>
        <tr>
            <td><strong>Description</strong></td>
            <td class="<%= contentFromClass %>"><%= descriptionFrom %></td>
            <td class="<%= contentToClass %>"><%= descriptionTo %></td>
        </tr>
        <% } %>

        <%
                }
            }
        %>
        </tbody>
    </table>
    <%
            } // End of else (non-UPDATE_BANNER operations)
        } // End of for loop
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

