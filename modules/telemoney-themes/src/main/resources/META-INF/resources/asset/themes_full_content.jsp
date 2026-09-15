<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Objects" %>
<%@ page import="com.liferay.portal.kernel.json.JSONArray" %>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.json.JSONObject" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ page import="com.ejada.telemony.db.model.Themes" %>

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
    <strong class="lead">Entry Deleted:</strong> This Theme entry (ID: <%= deletedEntryId %>) has been deleted and is no longer available.
</div>
<%
        return;
    }

    Themes editedTheme = (Themes) request.getAttribute("editedTheme");
    Themes originalTheme = (Themes) request.getAttribute("originalTheme");
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    boolean hasEditedTheme = editedTheme != null;
    boolean hasOriginalTheme = originalTheme != null;

    String hyphen = "-";

    // Get workflow action from request attribute (set by renderer)
    String workflowAction = (String) request.getAttribute("workflowAction");
    if (workflowAction == null && hasEditedTheme) {
        workflowAction = editedTheme.getWorkflowAction();
    }
    String requestType = (workflowAction == null) ? hyphen : workflowAction;

    // Get workflow states from renderer
    Boolean isAlreadyApproved = (Boolean) request.getAttribute("isAlreadyApproved");
    boolean showApprovedBadge = isAlreadyApproved != null && isAlreadyApproved;

    Boolean isRejected = (Boolean) request.getAttribute("isRejected");
    boolean showRejectedBadge = isRejected != null && isRejected;

    // Get operation type flags from renderer
    Boolean isAddThemeFlag = (Boolean) request.getAttribute("isAddTheme");
    Boolean isUpdateThemeFlag = (Boolean) request.getAttribute("isUpdateTheme");
    Boolean isDeleteThemeFlag = (Boolean) request.getAttribute("isDeleteTheme");

    boolean isAddOperation = isAddThemeFlag != null ? isAddThemeFlag : "ADD".equalsIgnoreCase(workflowAction);
    boolean isUpdateOperation = isUpdateThemeFlag != null ? isUpdateThemeFlag : "UPDATE".equalsIgnoreCase(workflowAction);
    boolean isDeleteOperation = isDeleteThemeFlag != null ? isDeleteThemeFlag : "DELETE".equalsIgnoreCase(workflowAction);

    // Get channel name from renderer
    String channelName = (String) request.getAttribute("channelName");
    String originalChannelName = (String) request.getAttribute("originalChannelName");

    // Keep the changed flags only for UI highlighting (From/To styles)
    boolean enNameChanged = hasEditedTheme && hasOriginalTheme && !Objects.equals(editedTheme.getThemeEnName(), originalTheme.getThemeEnName());
    boolean arNameChanged = hasEditedTheme && hasOriginalTheme && !Objects.equals(editedTheme.getThemeArName(), originalTheme.getThemeArName());
    boolean channelChanged = hasEditedTheme && hasOriginalTheme && !Objects.equals(editedTheme.getChannelId(), originalTheme.getChannelId());
    boolean darkThemeChanged = hasEditedTheme && hasOriginalTheme && editedTheme.getDarkTheme() != originalTheme.getDarkTheme();
    boolean defaultThemeChanged = hasEditedTheme && hasOriginalTheme && editedTheme.getDefaultTheme() != originalTheme.getDefaultTheme();
    boolean primaryColorsChanged = hasEditedTheme && hasOriginalTheme && !Objects.equals(editedTheme.getPrimaryColors(), originalTheme.getPrimaryColors());
    boolean secondaryColorsChanged = hasEditedTheme && hasOriginalTheme && !Objects.equals(editedTheme.getSecondaryColors(), originalTheme.getSecondaryColors());
    boolean neutralColorsChanged = hasEditedTheme && hasOriginalTheme && !Objects.equals(editedTheme.getNeutralColors(), originalTheme.getNeutralColors());
    boolean successColorsChanged = hasEditedTheme && hasOriginalTheme && !Objects.equals(editedTheme.getSuccessColors(), originalTheme.getSuccessColors());
    boolean errorColorsChanged = hasEditedTheme && hasOriginalTheme && !Objects.equals(editedTheme.getErrorColors(), originalTheme.getErrorColors());
    boolean warningColorsChanged = hasEditedTheme && hasOriginalTheme && !Objects.equals(editedTheme.getWarningColors(), originalTheme.getWarningColors());
    boolean supportColorsChanged = hasEditedTheme && hasOriginalTheme && !Objects.equals(editedTheme.getSupportColors(), originalTheme.getSupportColors());
    boolean gradientColorsChanged = hasEditedTheme && hasOriginalTheme && !Objects.equals(editedTheme.getGradientColors(), originalTheme.getGradientColors());

    String codeValue = hasEditedTheme ? String.valueOf(editedTheme.getThemeId()) : hyphen;

    String enNameFrom = isAddOperation ? hyphen : (hasOriginalTheme ? originalTheme.getThemeEnName() : (hasEditedTheme ? editedTheme.getThemeEnName() : hyphen));
    String enNameTo = isDeleteOperation ? hyphen : (hasEditedTheme ? editedTheme.getThemeEnName() : hyphen);

    String arNameFrom = isAddOperation ? hyphen : (hasOriginalTheme ? originalTheme.getThemeArName() : (hasEditedTheme ? editedTheme.getThemeArName() : hyphen));
    String arNameTo = isDeleteOperation ? hyphen : (hasEditedTheme ? editedTheme.getThemeArName() : hyphen);

    // Use channel names instead of IDs
    String channelFrom = isAddOperation ? hyphen : (hasOriginalTheme ? (originalChannelName != null ? originalChannelName : String.valueOf(originalTheme.getChannelId())) : (channelName != null ? channelName : hyphen));
    String channelTo = isDeleteOperation ? hyphen : (channelName != null ? channelName : (hasEditedTheme ? String.valueOf(editedTheme.getChannelId()) : hyphen));

    String darkThemeFrom = isAddOperation ? hyphen : (hasOriginalTheme ? (originalTheme.getDarkTheme() ? "Yes" : "No") : (hasEditedTheme ? (editedTheme.getDarkTheme() ? "Yes" : "No") : hyphen));
    String darkThemeTo = isDeleteOperation ? hyphen : (hasEditedTheme ? (editedTheme.getDarkTheme() ? "Yes" : "No") : hyphen);

    String defaultThemeFrom = isAddOperation ? hyphen : (hasOriginalTheme ? (originalTheme.getDefaultTheme() ? "Yes" : "No") : (hasEditedTheme ? (editedTheme.getDefaultTheme() ? "Yes" : "No") : hyphen));
    String defaultThemeTo = isDeleteOperation ? hyphen : (hasEditedTheme ? (editedTheme.getDefaultTheme() ? "Yes" : "No") : hyphen);

    // Image fields - check for changes
    boolean splashBgChanged = hasEditedTheme && hasOriginalTheme && !Objects.equals(editedTheme.getSplashBg(), originalTheme.getSplashBg());
    boolean splashAnimationChanged = hasEditedTheme && hasOriginalTheme && !Objects.equals(editedTheme.getSplashAnimation(), originalTheme.getSplashAnimation());
    boolean headerBgChanged = hasEditedTheme && hasOriginalTheme && !Objects.equals(editedTheme.getHeaderBg(), originalTheme.getHeaderBg());
    boolean balanceBgChanged = hasEditedTheme && hasOriginalTheme && !Objects.equals(editedTheme.getBalanceBg(), originalTheme.getBalanceBg());

    String fromClass = (isUpdateOperation || isDeleteOperation) ? "tm-from" : "";
    String toClass = (isUpdateOperation || isAddOperation) ? "tm-to" : "";
%>

<%!
    // Helper method to render color swatches from JSON object
    private String renderColorSwatches(String colorJson, boolean isHyphen) {
        if (isHyphen || colorJson == null || colorJson.isEmpty()) {
            return "-";
        }
        try {
            JSONObject colors = JSONFactoryUtil.createJSONObject(colorJson);
            if (colors.length() == 0) {
                return "-";
            }
            StringBuilder sb = new StringBuilder();
            sb.append("<div class='tm-color-swatches'>");
            java.util.Iterator<String> keys = colors.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                String colorValue = colors.getString(key);
                if (colorValue != null && !colorValue.isEmpty()) {
                    String label = formatColorLabel(key);
                    sb.append("<div class='tm-color-item'>");
                    sb.append("<span class='tm-color-box' style='background-color:").append(colorValue).append(";'></span>");
                    sb.append("<span class='tm-color-label'>").append(label).append(":</span>");
                    sb.append("<span class='tm-color-hex'>").append(colorValue).append("</span>");
                    sb.append("</div>");
                }
            }
            sb.append("</div>");
            return sb.toString();
        } catch (Exception e) {
            try {
                JSONArray colorsArray = JSONFactoryUtil.createJSONArray(colorJson);
                if (colorsArray.length() == 0) {
                    return "-";
                }
                StringBuilder sb = new StringBuilder();
                sb.append("<div class='tm-color-swatches'>");
                for (int i = 0; i < colorsArray.length(); i++) {
                    String color = colorsArray.getString(i);
                    if (color != null && !color.isEmpty()) {
                        sb.append("<div class='tm-color-item'>");
                        sb.append("<span class='tm-color-box' style='background-color:").append(color).append(";'></span>");
                        sb.append("<span class='tm-color-hex'>").append(color).append("</span>");
                        sb.append("</div>");
                    }
                }
                sb.append("</div>");
                return sb.toString();
            } catch (Exception e2) {
                return colorJson;
            }
        }
    }

    private String formatColorLabel(String key) {
        if (key == null || key.isEmpty()) return key;
        StringBuilder result = new StringBuilder();
        result.append(Character.toUpperCase(key.charAt(0)));
        for (int i = 1; i < key.length(); i++) {
            char c = key.charAt(i);
            if (Character.isUpperCase(c)) {
                result.append(' ');
            }
            result.append(c);
        }
        return result.toString();
    }

    // Helper method to render image preview from base64 or URL
    private String renderImagePreview(String imageData, boolean isHyphen) {
        if (isHyphen || imageData == null || imageData.isEmpty()) {
            return "-";
        }
        StringBuilder sb = new StringBuilder();
        String imgSrc;

        if (imageData.startsWith("data:")) {
            imgSrc = imageData;
        } else if (imageData.startsWith("http://") || imageData.startsWith("https://") || imageData.startsWith("/")) {
            imgSrc = imageData;
        } else {
            String mimeType = "image/png";
            if (imageData.startsWith("/9j/")) {
                mimeType = "image/jpeg";
            } else if (imageData.startsWith("iVBOR")) {
                mimeType = "image/png";
            } else if (imageData.startsWith("R0lGOD")) {
                mimeType = "image/gif";
            } else if (imageData.startsWith("UklGR")) {
                mimeType = "image/webp";
            } else if (imageData.startsWith("PHN2Zw") || imageData.startsWith("PD94bW")) {
                mimeType = "image/svg+xml";
            }
            imgSrc = "data:" + mimeType + ";base64," + imageData;
        }

        sb.append("<div class='tm-image-preview'>");
        sb.append("<img src='").append(imgSrc).append("' class='tm-image-thumb' onerror=\"this.classList.add('tm-image-error');\" />");
        sb.append("</div>");
        return sb.toString();
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
        <% if (!isUpdateOperation || enNameChanged) { %>
        <tr>
            <td><strong>Name (English)</strong></td>
            <td class="<%= fromClass %>"><%= enNameFrom %></td>
            <td class="<%= toClass %>"><%= enNameTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdateOperation || arNameChanged) { %>
        <tr>
            <td><strong>Name (Arabic)</strong></td>
            <td class="<%= fromClass %>"><%= arNameFrom %></td>
            <td class="<%= toClass %>"><%= arNameTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdateOperation || channelChanged) { %>
        <tr>
            <td><strong>Channel</strong></td>
            <td class="<%= fromClass %>"><%= channelFrom %></td>
            <td class="<%= toClass %>"><%= channelTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdateOperation || darkThemeChanged) { %>
        <tr>
            <td><strong>Dark Theme</strong></td>
            <td class="<%= fromClass %>"><%= darkThemeFrom %></td>
            <td class="<%= toClass %>"><%= darkThemeTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdateOperation || defaultThemeChanged) { %>
        <tr>
            <td><strong>Default Theme</strong></td>
            <td class="<%= fromClass %>"><%= defaultThemeFrom %></td>
            <td class="<%= toClass %>"><%= defaultThemeTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdateOperation || primaryColorsChanged) { %>
        <tr>
            <td><strong>Primary Colors</strong></td>
            <td class="<%= fromClass %>"><%= renderColorSwatches(isAddOperation ? null : (hasOriginalTheme ? originalTheme.getPrimaryColors() : (hasEditedTheme ? editedTheme.getPrimaryColors() : null)), isAddOperation) %></td>
            <td class="<%= toClass %>"><%= renderColorSwatches(isDeleteOperation ? null : (hasEditedTheme ? editedTheme.getPrimaryColors() : null), isDeleteOperation) %></td>
        </tr>
        <% } %>
        <% if (!isUpdateOperation || secondaryColorsChanged) { %>
        <tr>
            <td><strong>Secondary Colors</strong></td>
            <td class="<%= fromClass %>"><%= renderColorSwatches(isAddOperation ? null : (hasOriginalTheme ? originalTheme.getSecondaryColors() : (hasEditedTheme ? editedTheme.getSecondaryColors() : null)), isAddOperation) %></td>
            <td class="<%= toClass %>"><%= renderColorSwatches(isDeleteOperation ? null : (hasEditedTheme ? editedTheme.getSecondaryColors() : null), isDeleteOperation) %></td>
        </tr>
        <% } %>
        <% if (!isUpdateOperation || neutralColorsChanged) { %>
        <tr>
            <td><strong>Neutral Colors</strong></td>
            <td class="<%= fromClass %>"><%= renderColorSwatches(isAddOperation ? null : (hasOriginalTheme ? originalTheme.getNeutralColors() : (hasEditedTheme ? editedTheme.getNeutralColors() : null)), isAddOperation) %></td>
            <td class="<%= toClass %>"><%= renderColorSwatches(isDeleteOperation ? null : (hasEditedTheme ? editedTheme.getNeutralColors() : null), isDeleteOperation) %></td>
        </tr>
        <% } %>
        <% if (!isUpdateOperation || successColorsChanged) { %>
        <tr>
            <td><strong>Success Colors</strong></td>
            <td class="<%= fromClass %>"><%= renderColorSwatches(isAddOperation ? null : (hasOriginalTheme ? originalTheme.getSuccessColors() : (hasEditedTheme ? editedTheme.getSuccessColors() : null)), isAddOperation) %></td>
            <td class="<%= toClass %>"><%= renderColorSwatches(isDeleteOperation ? null : (hasEditedTheme ? editedTheme.getSuccessColors() : null), isDeleteOperation) %></td>
        </tr>
        <% } %>
        <% if (!isUpdateOperation || errorColorsChanged) { %>
        <tr>
            <td><strong>Error Colors</strong></td>
            <td class="<%= fromClass %>"><%= renderColorSwatches(isAddOperation ? null : (hasOriginalTheme ? originalTheme.getErrorColors() : (hasEditedTheme ? editedTheme.getErrorColors() : null)), isAddOperation) %></td>
            <td class="<%= toClass %>"><%= renderColorSwatches(isDeleteOperation ? null : (hasEditedTheme ? editedTheme.getErrorColors() : null), isDeleteOperation) %></td>
        </tr>
        <% } %>
        <% if (!isUpdateOperation || warningColorsChanged) { %>
        <tr>
            <td><strong>Warning Colors</strong></td>
            <td class="<%= fromClass %>"><%= renderColorSwatches(isAddOperation ? null : (hasOriginalTheme ? originalTheme.getWarningColors() : (hasEditedTheme ? editedTheme.getWarningColors() : null)), isAddOperation) %></td>
            <td class="<%= toClass %>"><%= renderColorSwatches(isDeleteOperation ? null : (hasEditedTheme ? editedTheme.getWarningColors() : null), isDeleteOperation) %></td>
        </tr>
        <% } %>
        <% if (!isUpdateOperation || supportColorsChanged) { %>
        <tr>
            <td><strong>Support Colors</strong></td>
            <td class="<%= fromClass %>"><%= renderColorSwatches(isAddOperation ? null : (hasOriginalTheme ? originalTheme.getSupportColors() : (hasEditedTheme ? editedTheme.getSupportColors() : null)), isAddOperation) %></td>
            <td class="<%= toClass %>"><%= renderColorSwatches(isDeleteOperation ? null : (hasEditedTheme ? editedTheme.getSupportColors() : null), isDeleteOperation) %></td>
        </tr>
        <% } %>
        <% if (!isUpdateOperation || gradientColorsChanged) { %>
        <tr>
            <td><strong>Gradient Colors</strong></td>
            <td class="<%= fromClass %>"><%= renderColorSwatches(isAddOperation ? null : (hasOriginalTheme ? originalTheme.getGradientColors() : (hasEditedTheme ? editedTheme.getGradientColors() : null)), isAddOperation) %></td>
            <td class="<%= toClass %>"><%= renderColorSwatches(isDeleteOperation ? null : (hasEditedTheme ? editedTheme.getGradientColors() : null), isDeleteOperation) %></td>
        </tr>
        <% } %>
        <% if (!isUpdateOperation || splashBgChanged) { %>
        <tr>
            <td><strong>Splash Background</strong></td>
            <td class="<%= fromClass %>"><%= renderImagePreview(isAddOperation ? null : (hasOriginalTheme ? originalTheme.getSplashBg() : (hasEditedTheme ? editedTheme.getSplashBg() : null)), isAddOperation) %></td>
            <td class="<%= toClass %>"><%= renderImagePreview(isDeleteOperation ? null : (hasEditedTheme ? editedTheme.getSplashBg() : null), isDeleteOperation) %></td>
        </tr>
        <% } %>
        <% if (!isUpdateOperation || splashAnimationChanged) { %>
        <tr>
            <td><strong>Splash Animation</strong></td>
            <td class="<%= fromClass %>"><%= renderImagePreview(isAddOperation ? null : (hasOriginalTheme ? originalTheme.getSplashAnimation() : (hasEditedTheme ? editedTheme.getSplashAnimation() : null)), isAddOperation) %></td>
            <td class="<%= toClass %>"><%= renderImagePreview(isDeleteOperation ? null : (hasEditedTheme ? editedTheme.getSplashAnimation() : null), isDeleteOperation) %></td>
        </tr>
        <% } %>
        <% if (!isUpdateOperation || headerBgChanged) { %>
        <tr>
            <td><strong>Header Background</strong></td>
            <td class="<%= fromClass %>"><%= renderImagePreview(isAddOperation ? null : (hasOriginalTheme ? originalTheme.getHeaderBg() : (hasEditedTheme ? editedTheme.getHeaderBg() : null)), isAddOperation) %></td>
            <td class="<%= toClass %>"><%= renderImagePreview(isDeleteOperation ? null : (hasEditedTheme ? editedTheme.getHeaderBg() : null), isDeleteOperation) %></td>
        </tr>
        <% } %>
        <% if (!isUpdateOperation || balanceBgChanged) { %>
        <tr>
            <td><strong>Balance Background</strong></td>
            <td class="<%= fromClass %>"><%= renderImagePreview(isAddOperation ? null : (hasOriginalTheme ? originalTheme.getBalanceBg() : (hasEditedTheme ? editedTheme.getBalanceBg() : null)), isAddOperation) %></td>
            <td class="<%= toClass %>"><%= renderImagePreview(isDeleteOperation ? null : (hasEditedTheme ? editedTheme.getBalanceBg() : null), isDeleteOperation) %></td>
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
        padding: 12px 10px;
        text-align: left;
        vertical-align: top;
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
/* .tm-from {
    background-color: #fef2f2;
} */
    .tm-from .tm-color-hex {
        text-decoration: line-through;
        color: #dc2626;
    }
    .tm-from .tm-image-thumb {
        opacity: 0.6;
        border-color: #dc2626;
    }
/* .tm-to {
    background-color: #f0fdf4;
} */
    .tm-to .tm-color-hex {
        color: #16a34a;
    }
    .tm-to .tm-image-thumb {
        border-color: #16a34a;
    }
    /* Color Swatch Styles */
    .tm-color-swatches {
        display: flex;
        flex-direction: column;
        gap: 6px;
    }
    .tm-color-item {
        display: inline-flex;
        align-items: center;
        gap: 8px;
        background: #ffffff;
        border: 1px solid #e5e7eb;
        border-radius: 6px;
        padding: 6px 10px;
    }
    .tm-color-box {
        display: inline-block;
        width: 24px;
        height: 24px;
        border-radius: 4px;
        border: 1px solid #d1d5db;
        box-shadow: 0 1px 2px rgba(0,0,0,0.1), inset 0 0 0 1px rgba(255,255,255,0.2);
        flex-shrink: 0;
    }
    .tm-color-label {
        font-size: 12px;
        font-weight: 600;
        color: #6b7280;
        min-width: 60px;
        text-transform: capitalize;
    }
    .tm-color-hex {
        font-family: 'Courier New', Courier, monospace;
        font-size: 12px;
        color: #374151;
        font-weight: 500;
    }
    /* Image Preview Styles */
    .tm-image-preview {
        display: inline-flex;
        align-items: center;
        justify-content: center;
        padding: 8px;
        background: #f9fafb;
        border: 1px solid #e5e7eb;
        border-radius: 8px;
    }
    .tm-image-thumb {
        max-width: 120px;
        max-height: 120px;
        border: 2px solid #d1d5db;
        border-radius: 6px;
        object-fit: contain;
        background: #ffffff;
    }
    .tm-image-thumb.tm-image-error {
        display: none;
    }
    .tm-image-thumb.tm-image-error + .tm-image-fallback {
        display: block;
    }
</style>
