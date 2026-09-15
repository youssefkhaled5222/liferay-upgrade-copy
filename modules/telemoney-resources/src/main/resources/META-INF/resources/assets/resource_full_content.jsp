<%@ page import="com.ejada.telemony.db.model.Resource" %>
<%@ page import="com.ejada.telemony.db.model.ResourceLocalization" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.LinkedHashSet" %>
<%@ page import="java.util.Objects" %>
<%!
    private String getResourceTypeLabel(String type) {
        if (type == null || "-1".equals(type)) return "Type Not Identified";
        switch (type) {
            case "1": return "URL";
            case "2": return "Attachment";
            case "3": return "Terms and Condition";
            default: return "Type Not Identified";
        }
    }
    private String getUrlTypeLabel(String type) {
        if (type == null || "-1".equals(type)) return "Not Identified";
        switch (type) {
            case "1": return "Internal URL";
            case "2": return "External URL";
            default: return "Not Identified";
        }
    }
%>
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
    <strong class="lead">Entry Deleted:</strong> This Resource entry (ID: <%= deletedEntryId %>) has been deleted and is no longer available.
</div>
<%
        return;
    }

    Resource editedResource = (Resource) request.getAttribute("editedResource");
    Resource originalResource = (Resource) request.getAttribute("originalResource");

    boolean hasEdited = editedResource != null;
    boolean hasOriginal = originalResource != null;

    String hyphen = "-";

    String workflowAction = hasEdited ? editedResource.getWorkflowAction() : null;
    String requestType = (workflowAction == null) ? hyphen : workflowAction;

    boolean isAdd = "ADD".equalsIgnoreCase(workflowAction);
    boolean isUpdate = "UPDATE".equalsIgnoreCase(workflowAction);
    boolean isDelete = "DELETE".equalsIgnoreCase(workflowAction);

    String codeValue = hasEdited ? String.valueOf(editedResource.getResourceId()) : (hasOriginal ? String.valueOf(originalResource.getResourceId()) : hyphen);

    String resourceCodeFrom = isAdd ? hyphen : (hasOriginal ? originalResource.getResourceCode() : hyphen);
    String resourceCodeTo = isDelete ? hyphen : (hasEdited ? editedResource.getResourceCode() : hyphen);

    String resourceTypeFrom = isAdd ? hyphen : (hasOriginal ? getResourceTypeLabel(originalResource.getResourceType()) : hyphen);
    String resourceTypeTo = isDelete ? hyphen : (hasEdited ? getResourceTypeLabel(editedResource.getResourceType()) : hyphen);

    String urlTypeFrom = isAdd ? hyphen : (hasOriginal ? getUrlTypeLabel(originalResource.getUrlType()) : hyphen);
    String urlTypeTo = isDelete ? hyphen : (hasEdited ? getUrlTypeLabel(editedResource.getUrlType()) : hyphen);

    String channelName = (String) request.getAttribute("channelName");
    String originalChannelName = (String) request.getAttribute("originalChannelName");
    String channelFrom = isAdd ? hyphen : (hasOriginal ? (originalChannelName != null ? originalChannelName : String.valueOf(originalResource.getChannelId())) : hyphen);
    String channelTo = isDelete ? hyphen : (channelName != null ? channelName : (hasEdited ? String.valueOf(editedResource.getChannelId()) : hyphen));

    List<ResourceLocalization> editedLocalizations = (List<ResourceLocalization>) request.getAttribute("editedLocalizations");
    List<ResourceLocalization> originalLocalizations = (List<ResourceLocalization>) request.getAttribute("originalLocalizations");

    boolean resourceCodeChanged = hasEdited && hasOriginal && !Objects.equals(resourceCodeFrom, resourceCodeTo);
    boolean resourceTypeChanged = hasEdited && hasOriginal && !Objects.equals(resourceTypeFrom, resourceTypeTo);
    boolean urlTypeChanged = hasEdited && hasOriginal && !Objects.equals(urlTypeFrom, urlTypeTo);
    boolean channelChanged = hasEdited && hasOriginal && !Objects.equals(channelFrom, channelTo);

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
        <% if (!isUpdate || resourceCodeChanged) { %>
        <tr>
            <td><strong>Resource Code</strong></td>
            <td class="<%= fromClass %>"><%= resourceCodeFrom %></td>
            <td class="<%= toClass %>"><%= resourceCodeTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdate || resourceTypeChanged) { %>
        <tr>
            <td><strong>Resource Type</strong></td>
            <td class="<%= fromClass %>"><%= resourceTypeFrom %></td>
            <td class="<%= toClass %>"><%= resourceTypeTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdate || urlTypeChanged) { %>
        <tr>
            <td><strong>URL Type</strong></td>
            <td class="<%= fromClass %>"><%= urlTypeFrom %></td>
            <td class="<%= toClass %>"><%= urlTypeTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdate || channelChanged) { %>
        <tr>
            <td><strong>Channel</strong></td>
            <td class="<%= fromClass %>"><%= channelFrom %></td>
            <td class="<%= toClass %>"><%= channelTo %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>

<%
    String resType = hasEdited ? editedResource.getResourceType() : (hasOriginal ? originalResource.getResourceType() : "");
    String uType = hasEdited ? editedResource.getUrlType() : (hasOriginal ? originalResource.getUrlType() : "");

    // Build lookup maps by languageId
    Map<String, ResourceLocalization> editedLocMap = new HashMap<>();
    Map<String, ResourceLocalization> originalLocMap = new HashMap<>();
    if (editedLocalizations != null) {
        for (ResourceLocalization loc : editedLocalizations) {
            editedLocMap.put(loc.getLanguageId(), loc);
        }
    }
    if (originalLocalizations != null) {
        for (ResourceLocalization loc : originalLocalizations) {
            originalLocMap.put(loc.getLanguageId(), loc);
        }
    }

    // Collect all language keys preserving order
    Set<String> allLanguages = new LinkedHashSet<>();
    allLanguages.addAll(editedLocMap.keySet());
    allLanguages.addAll(originalLocMap.keySet());

    if (!allLanguages.isEmpty()) {
%>
<h4 style="margin-top:16px;">Resource Localizations</h4>
<%
        for (String langId : allLanguages) {
            ResourceLocalization editedLoc = editedLocMap.get(langId);
            ResourceLocalization originalLoc = originalLocMap.get(langId);

            // Resolve from/to values for Name
            String nameFrom = isAdd ? hyphen : (originalLoc != null && originalLoc.getName() != null && !originalLoc.getName().isEmpty() ? originalLoc.getName() : hyphen);
            String nameTo = isDelete ? hyphen : (editedLoc != null && editedLoc.getName() != null && !editedLoc.getName().isEmpty() ? editedLoc.getName() : hyphen);
            boolean nameChanged = !Objects.equals(nameFrom, nameTo);

            // Resolve type-specific field
            String fieldLabel = "";
            String fieldFrom = hyphen;
            String fieldTo = hyphen;
            boolean fieldChanged = false;
            boolean isAttachField = false;
            String attachFromUrl = null;
            String attachToUrl = null;

            if ("1".equals(resType)) {
                if ("1".equals(uType)) {
                    fieldLabel = "Route ID";
                    fieldFrom = isAdd ? hyphen : (originalLoc != null && originalLoc.getRouteId() != null && !originalLoc.getRouteId().isEmpty() ? originalLoc.getRouteId() : hyphen);
                    fieldTo = isDelete ? hyphen : (editedLoc != null && editedLoc.getRouteId() != null && !editedLoc.getRouteId().isEmpty() ? editedLoc.getRouteId() : hyphen);
                } else {
                    fieldLabel = "URL";
                    fieldFrom = isAdd ? hyphen : (originalLoc != null && originalLoc.getUrl() != null && !originalLoc.getUrl().isEmpty() ? originalLoc.getUrl() : hyphen);
                    fieldTo = isDelete ? hyphen : (editedLoc != null && editedLoc.getUrl() != null && !editedLoc.getUrl().isEmpty() ? editedLoc.getUrl() : hyphen);
                }
                fieldChanged = !Objects.equals(fieldFrom, fieldTo);
            } else if ("2".equals(resType)) {
                fieldLabel = "Attachment";
                isAttachField = true;
                fieldFrom = isAdd ? hyphen : (originalLoc != null && originalLoc.getAttachName() != null && !originalLoc.getAttachName().isEmpty() ? originalLoc.getAttachName() : hyphen);
                fieldTo = isDelete ? hyphen : (editedLoc != null && editedLoc.getAttachName() != null && !editedLoc.getAttachName().isEmpty() ? editedLoc.getAttachName() : hyphen);
                attachFromUrl = originalLoc != null ? originalLoc.getAttach() : null;
                attachToUrl = editedLoc != null ? editedLoc.getAttach() : null;
                fieldChanged = !Objects.equals(fieldFrom, fieldTo);
            } else if ("3".equals(resType)) {
                fieldLabel = "Description";
                fieldFrom = isAdd ? hyphen : (originalLoc != null && originalLoc.getDescription() != null && !originalLoc.getDescription().isEmpty() ? originalLoc.getDescription() : hyphen);
                fieldTo = isDelete ? hyphen : (editedLoc != null && editedLoc.getDescription() != null && !editedLoc.getDescription().isEmpty() ? editedLoc.getDescription() : hyphen);
                fieldChanged = !Objects.equals(fieldFrom, fieldTo);
            }

            boolean hasAnyChange = nameChanged || fieldChanged;
            if (isUpdate && !hasAnyChange) continue;
%>
    <div class="language-section mb-4">
        <h5 class="language-header"><%= langId %></h5>
        <table class="tm-table">
            <thead>
                <tr class="tm-header">
                    <th>Field</th>
                    <th>From</th>
                    <th>To</th>
                </tr>
            </thead>
            <tbody>
                <% if (!isUpdate || nameChanged) { %>
                <tr>
                    <td><strong>Name</strong></td>
                    <td class="<%= fromClass %>"><%= nameFrom %></td>
                    <td class="<%= toClass %>"><%= nameTo %></td>
                </tr>
                <% } %>
                <% if (!fieldLabel.isEmpty() && (!isUpdate || fieldChanged)) { %>
                <tr>
                    <td><strong><%= fieldLabel %></strong></td>
                    <td class="<%= fromClass %>">
                        <% if (isAttachField && attachFromUrl != null && !attachFromUrl.isEmpty() && !hyphen.equals(fieldFrom)) { %>
                            <a href="<%= attachFromUrl %>" target="_blank" download><%= fieldFrom %></a>
                        <% } else { %>
                            <%= fieldFrom %>
                        <% } %>
                    </td>
                    <td class="<%= toClass %>">
                        <% if (isAttachField && attachToUrl != null && !attachToUrl.isEmpty() && !hyphen.equals(fieldTo)) { %>
                            <a href="<%= attachToUrl %>" target="_blank" download><%= fieldTo %></a>
                        <% } else { %>
                            <%= fieldTo %>
                        <% } %>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
<%
        }
    }
%>

<style>
    .tm-table { width: 100%; border-collapse: collapse; font-family: "Helvetica", "Arial", sans-serif; }
    .tm-table th, .tm-table td { border: 1px solid #d1d5db; padding: 8px 10px; text-align: left; }
    .tm-meta-label { font-weight: 700; width: 180px; }
    .tm-meta-value { font-weight: 400; }
    .tm-header th { background-color: #f3f4f6; font-weight: 700; }
    .tm-from { color: #dc2626; text-decoration: line-through; }
    .tm-to { color: #16a34a; }
    .language-header { background-color: #e5e7eb; padding: 10px; margin-bottom: 10px; border-radius: 4px; }
    .language-section { border: 1px solid #e5e7eb; padding: 15px; border-radius: 8px; margin-bottom: 15px; }
</style>

