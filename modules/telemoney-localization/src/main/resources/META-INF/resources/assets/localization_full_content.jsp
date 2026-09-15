<%@ page import="com.ejada.telemony.db.model.Localization" %>
<%@ page import="com.ejada.telemony.db.model.Languages" %>
<%@ page import="com.ejada.telemony.db.model.Feature" %>
<%@ page import="com.ejada.telemony.db.service.LanguagesLocalServiceUtil" %>
<%@ page import="com.ejada.telemony.db.service.FeatureLocalServiceUtil" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.json.JSONObject" %>
<%@ page import="java.text.SimpleDateFormat" %>
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
    <strong class="lead">Entry Deleted:</strong> This Localization entry (ID: <%= deletedEntryId %>) has been deleted and is no longer available.
</div>
<%
        return;
    }

    Localization currentLocalization = (Localization) request.getAttribute("currentLocalization");
    List<Localization> batchLocalizations = (List<Localization>) request.getAttribute("batchLocalizations");

    if (batchLocalizations == null) {
        batchLocalizations = new ArrayList<>();
        if (currentLocalization != null) {
            batchLocalizations.add(currentLocalization);
        }
    }

    String hyphen = "-";
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    // Get feature name for display
    String featureName = hyphen;
    if (currentLocalization != null && currentLocalization.getFeatureId() > 0) {
        try {
            Feature feature = FeatureLocalServiceUtil.getFeature(currentLocalization.getFeatureId());
            featureName = feature.getFeatureName();
        } catch (Exception e) {
            featureName = "Feature ID: " + currentLocalization.getFeatureId();
        }
    }

    String modifiedBy = currentLocalization != null ? currentLocalization.getUserName() : hyphen;
    String modifiedDate = currentLocalization != null && currentLocalization.getModifiedDate() != null
            ? dateFormat.format(currentLocalization.getModifiedDate()) : hyphen;
%>

<div class="localization-workflow-content">
    <div class="table-responsive mb-4">
        <table class="tm-table">
            <tbody>
                <tr>
                    <td class="tm-meta-label"><strong>Page</strong></td>
                    <td class="tm-meta-value"><%= featureName %></td>
                </tr>
                <tr>
                    <td class="tm-meta-label"><strong>Modified By</strong></td>
                    <td class="tm-meta-value"><%= modifiedBy %></td>
                </tr>
                <tr>
                    <td class="tm-meta-label"><strong>Modified Date</strong></td>
                    <td class="tm-meta-value"><%= modifiedDate %></td>
                </tr>
                <tr>
                    <td class="tm-meta-label"><strong>Languages Changed</strong></td>
                    <td class="tm-meta-value"><%= batchLocalizations.size() %></td>
                </tr>
            </tbody>
        </table>
    </div>

    <% for (Localization loc : batchLocalizations) {
        String langName = hyphen;
        try {
            Languages lang = LanguagesLocalServiceUtil.getLanguages(loc.getLanguageId());
            langName = lang.getLangName();
        } catch (Exception e) {
            langName = "Language ID: " + loc.getLanguageId();
        }

        // Get current (new) and original (old) local values
        String newLocalValue = loc.getLocalValue() != null ? loc.getLocalValue() : "{}";
        String oldLocalValue = "{}";

        // Try to get original localization if exists
        if (loc.getOriginalEntityId() > 0) {
            try {
                Localization originalLoc = com.ejada.telemony.db.service.LocalizationLocalServiceUtil.getLocalization(loc.getOriginalEntityId());
                oldLocalValue = originalLoc.getLocalValue() != null ? originalLoc.getLocalValue() : "{}";
            } catch (Exception e) {
                // Original not found, keep empty
            }
        }

        // Parse JSON and detect changes
        JSONObject newJson = JSONFactoryUtil.createJSONObject(newLocalValue);
        JSONObject oldJson = JSONFactoryUtil.createJSONObject(oldLocalValue);

        Set<String> newKeys = newJson.keySet();
        Set<String> oldKeys = oldJson.keySet();

        // Added keys (in new but not in old)
        Set<String> addedKeys = new HashSet<>(newKeys);
        addedKeys.removeAll(oldKeys);

        // Deleted keys (in old but not in new)
        Set<String> deletedKeys = new HashSet<>(oldKeys);
        deletedKeys.removeAll(newKeys);

        // Changed values (common keys with different values)
        Set<String> commonKeys = new HashSet<>(newKeys);
        commonKeys.retainAll(oldKeys);

        List<String[]> changedValues = new ArrayList<>();
        for (String key : commonKeys) {
            String oldVal = oldJson.getString(key);
            String newVal = newJson.getString(key);
            if (!oldVal.equals(newVal)) {
                changedValues.add(new String[]{key, oldVal, newVal});
            }
        }

        boolean hasChanges = !addedKeys.isEmpty() || !deletedKeys.isEmpty() || !changedValues.isEmpty();
    %>

    <div class="language-section mb-4">
        <h4 class="language-header"><%= langName %></h4>

        <% if (!hasChanges) { %>
            <p class="text-muted">No changes detected for this language.</p>
        <% } else { %>
            <table class="tm-table">
                <thead>
                    <tr class="tm-header">
                        <th>Key</th>
                        <th>From</th>
                        <th>To</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (String key : addedKeys) { %>
                    <tr>
                        <td><strong><%= key %></strong></td>
                        <td class="tm-from"><%= hyphen %></td>
                        <td class="tm-to"><%= newJson.getString(key) %></td>
                    </tr>
                    <% } %>

                    <% for (String key : deletedKeys) { %>
                    <tr>
                        <td><strong><%= key %></strong></td>
                        <td class="tm-from"><%= oldJson.getString(key) %></td>
                        <td class="tm-to"><%= hyphen %></td>
                    </tr>
                    <% } %>

                    <% for (String[] change : changedValues) { %>
                    <tr>
                        <td><strong><%= change[0] %></strong></td>
                        <td class="tm-from"><%= change[1] %></td>
                        <td class="tm-to"><%= change[2] %></td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        <% } %>
    </div>

    <% } %>
</div>

<style>
    .localization-workflow-content { font-family: "Helvetica", "Arial", sans-serif; }
    .tm-table { width: 100%; border-collapse: collapse; margin-bottom: 10px; }
    .tm-table th, .tm-table td { border: 1px solid #d1d5db; padding: 8px 10px; text-align: left; word-break: break-word; }
    .tm-meta-label { font-weight: 700; width: 180px; background-color: #f9fafb; }
    .tm-meta-value { font-weight: 400; }
    .tm-header th { background-color: #f3f4f6; font-weight: 700; }
    .tm-from { color: #dc2626; text-decoration: line-through; }
    .tm-to { color: #16a34a; }
    .language-header { background-color: #e5e7eb; padding: 10px; margin-bottom: 10px; border-radius: 4px; }
    .language-section { border: 1px solid #e5e7eb; padding: 15px; border-radius: 8px; }
</style>

