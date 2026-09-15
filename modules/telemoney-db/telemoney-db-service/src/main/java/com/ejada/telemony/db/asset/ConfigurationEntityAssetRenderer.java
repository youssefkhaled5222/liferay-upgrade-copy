package com.ejada.telemony.db.asset;

import com.ejada.telemony.db.model.ConfigurationEntity;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

public class ConfigurationEntityAssetRenderer extends BaseJSPAssetRenderer<ConfigurationEntity> {
    private static final Log LOG = LogFactoryUtil.getLog(ConfigurationEntityAssetRenderer.class);

    private final ConfigurationEntity _configurationEntity;
    private final long _classPK;

    public ConfigurationEntityAssetRenderer(ConfigurationEntity configurationEntity, long classPK) {
        _configurationEntity = configurationEntity;
        _classPK = classPK;
    }

    @Override
    public ConfigurationEntity getAssetObject() {
        return _configurationEntity;
    }

    @Override
    public long getGroupId() {
        return _configurationEntity != null ? _configurationEntity.getGroupId() : 0;
    }

    @Override
    public long getUserId() {
        return _configurationEntity != null ? _configurationEntity.getUserId() : 0;
    }

    @Override
    public String getUserName() {
        return _configurationEntity != null ? _configurationEntity.getUserName() : "";
    }

    @Override
    public String getUuid() {
        return _configurationEntity != null ? _configurationEntity.getUuid_() : "";
    }

    @Override
    public String getClassName() {
        return ConfigurationEntity.class.getName();
    }

    @Override
    public long getClassPK() {
        return _classPK;
    }

    @Override
    public String getTitle(Locale locale) {
        if (_configurationEntity == null) {
            return "Configuration Entity (Deleted)";
        }
        String entityType = _configurationEntity.getEntityType();
        String workflowAction = _configurationEntity.getWorkflowAction();
        return getEntityTypeDisplayName(entityType) + " - " + getActionDisplayName(workflowAction);
    }

    @Override
    public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
        if (_configurationEntity == null) {
            return "This configuration entity has been deleted.";
        }
        return "Entity Type: " + getEntityTypeDisplayName(_configurationEntity.getEntityType()) +
               ", Action: " + getActionDisplayName(_configurationEntity.getWorkflowAction());
    }

    @Override
    public String getJspPath(HttpServletRequest request, String template) {
        if (!TEMPLATE_FULL_CONTENT.equals(template)) {
            return StringPool.BLANK;
        }

        // Handle deleted entity case
        if (_configurationEntity == null) {
            LOG.info("ConfigurationEntity with ID " + _classPK + " has been deleted");
            request.setAttribute("isDeleted", true);
            return "/asset/config_entity_full_content.jsp";
        }

        int status = _configurationEntity.getStatus();
        String workflowAction = _configurationEntity.getWorkflowAction();
        String entityType = _configurationEntity.getEntityType();



        // Workflow states
        boolean isApproved = status == WorkflowConstants.STATUS_APPROVED ||
                             status == WorkflowConstants.STATUS_INACTIVE;
        boolean isRejected = status == WorkflowConstants.STATUS_DENIED ||
                             status == WorkflowConstants.STATUS_IN_TRASH;
        boolean isIncomplete = status == WorkflowConstants.STATUS_INCOMPLETE;

        // Determine action type
        boolean isAdd = workflowAction.startsWith("ADD_");
        boolean isUpdate = workflowAction.startsWith("UPDATE_");
        boolean isDelete = workflowAction.startsWith("DELETE_");

        // Set attributes for JSP
        request.setAttribute("configurationEntity", _configurationEntity);
        request.setAttribute("workflowAction", workflowAction);
        request.setAttribute("workflowActionDisplay", getActionDisplayName(workflowAction));
        request.setAttribute("entityType", entityType);
        request.setAttribute("entityTypeDisplay", getEntityTypeDisplayName(entityType));
        request.setAttribute("isAlreadyApproved", isApproved);
        request.setAttribute("isRejected", isRejected);
        request.setAttribute("isIncomplete", isIncomplete);
        request.setAttribute("isAdd", isAdd);
        request.setAttribute("isUpdate", isUpdate);
        request.setAttribute("isDelete", isDelete);

        // Parse old and new data JSON
        setDataAttributes(request);

        return "/asset/config_entity_full_content.jsp";
    }

    private void setDataAttributes(HttpServletRequest request) {
        String oldDataStr = _configurationEntity.getOldData();
        String newDataStr = _configurationEntity.getNewData();

        Map<String, String> oldDataMap = new HashMap<>();
        Map<String, String> newDataMap = new HashMap<>();
        Map<String, String[]> changesMap = new HashMap<>();

        try {
            // Parse old data
            if (oldDataStr != null && !oldDataStr.isEmpty()) {
                JSONObject oldDataJson = JSONFactoryUtil.createJSONObject(oldDataStr);
                oldDataMap = jsonToMap(oldDataJson);
            }

            // Parse new data
            if (newDataStr != null && !newDataStr.isEmpty()) {
                JSONObject newDataJson = JSONFactoryUtil.createJSONObject(newDataStr);
                newDataMap = jsonToMap(newDataJson);
            }

            // Calculate changes (for update operations)
            if (!oldDataMap.isEmpty() && !newDataMap.isEmpty()) {
                for (String key : newDataMap.keySet()) {
                    String oldValue = oldDataMap.get(key);
                    String newValue = newDataMap.get(key);

                    if (oldValue == null) oldValue = "";
                    if (newValue == null) newValue = "";

                    if (!oldValue.equals(newValue)) {
                        changesMap.put(key, new String[]{oldValue, newValue});
                    }
                }
                // Check for keys in old but not in new
                for (String key : oldDataMap.keySet()) {
                    if (!newDataMap.containsKey(key)) {
                        changesMap.put(key, new String[]{oldDataMap.get(key), ""});
                    }
                }
            }

        } catch (JSONException e) {
            LOG.error("Error parsing JSON data", e);
        }

        request.setAttribute("oldDataMap", oldDataMap);
        request.setAttribute("newDataMap", newDataMap);
        request.setAttribute("changesMap", changesMap);
        request.setAttribute("hasOldData", !oldDataMap.isEmpty());
        request.setAttribute("hasNewData", !newDataMap.isEmpty());
        request.setAttribute("hasChanges", !changesMap.isEmpty());
    }

    private Map<String, String> jsonToMap(JSONObject jsonObject) {
        Map<String, String> map = new HashMap<>();
        if (jsonObject == null) return map;

        Iterator<String> keys = jsonObject.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            Object value = jsonObject.get(key);

            if (value instanceof com.liferay.portal.kernel.json.JSONArray) {
                // Handle array: loop through items
               JSONArray array =
                        (JSONArray) value;

                for (int i = 0; i < array.length(); i++) {
                    Object item = array.get(i);
                    if (item instanceof JSONObject) {
                        // Flatten nested object fields
                        JSONObject nested = (JSONObject) item;
                        Iterator<String> nestedKeys = nested.keys();
                        while (nestedKeys.hasNext()) {
                            String nestedKey = nestedKeys.next();
                            String nestedValue = nested.get(nestedKey) != null ? nested.get(nestedKey).toString() : "";
                            nestedValue = getValueDisplayName(nestedKey, nestedValue);
                            map.put(getFieldDisplayName(nestedKey), nestedValue);
                        }
                    } else {
                        map.put(getFieldDisplayName(key), item != null ? item.toString() : "");
                    }
                }

            } else if (value instanceof JSONObject) {
                // Handle nested object
                JSONObject nested = (JSONObject) value;
                Iterator<String> nestedKeys = nested.keys();
                while (nestedKeys.hasNext()) {
                    String nestedKey = nestedKeys.next();
                    String nestedValue = nested.get(nestedKey) != null ? nested.get(nestedKey).toString() : "";
                    nestedValue = getValueDisplayName(nestedKey, nestedValue);
                    map.put(getFieldDisplayName(key) + " › " + getFieldDisplayName(nestedKey), nestedValue);
                }

            } else {
                // Simple value
                String strValue = value != null ? value.toString() : "";
                strValue = getValueDisplayName(key, strValue);
                map.put(getFieldDisplayName(key), strValue);
            }
        }

        return map;
    }

    /**
     * Translate known field values from IDs to human-readable display names
     */
    private String getValueDisplayName(String fieldName, String value) {
        if (fieldName == null || value == null || value.isEmpty()) return value;

        switch (fieldName) {
            case "payementTypeId":
                switch (value) {
                    case "1": return "Postpaid";
                    case "2": return "Prepaid";
                    case "3": return "Both";
                    default: return value;
                }
            case "allowedFixedValues":
                switch (value) {
                    case "1": return "Yes";
                    case "2": return "No";
                    default: return value;
                }
            default:
                return value;
        }
    }

    /**
     * Convert camelCase field names to display-friendly format dynamically.
     * Handles: camelCase splitting, Ar/En language suffixes, ID/URL abbreviations.
     * Examples:
     *   "categoryNameAr" -> "Category Name (Arabic)"
     *   "billerCategoryId" -> "Biller Category ID"
     *   "paymentMinAmount" -> "Payment Min Amount"
     *   "photoLink" -> "Photo Link"
     *   "id" -> "ID"
     */
    private String getFieldDisplayName(String fieldName) {
        if (fieldName == null || fieldName.isEmpty()) return "";

        // Special case: standalone "id"
        if (fieldName.equals("id")) return "ID";

        // Check for language suffix (Ar/En) and strip it
        String suffix = "";
        if (fieldName.endsWith("Ar") && fieldName.length() > 2) {
            suffix = " (Arabic)";
            fieldName = fieldName.substring(0, fieldName.length() - 2);
        } else if (fieldName.endsWith("En") && fieldName.length() > 2) {
            suffix = " (English)";
            fieldName = fieldName.substring(0, fieldName.length() - 2);
        }

        // Split camelCase into words
        StringBuilder result = new StringBuilder();
        int wordStart = 0;
        for (int i = 1; i <= fieldName.length(); i++) {
            boolean isBoundary = (i == fieldName.length())
                    || (Character.isUpperCase(fieldName.charAt(i)) && (i + 1 >= fieldName.length() || Character.isLowerCase(fieldName.charAt(i + 1))))
                    || (Character.isUpperCase(fieldName.charAt(i)) && !Character.isUpperCase(fieldName.charAt(i - 1)));

            if (isBoundary) {
                String word = fieldName.substring(wordStart, i);
                if (result.length() > 0) result.append(' ');

                // Uppercase known abbreviations
                String upper = word.toUpperCase();
                if (upper.equals("ID") || upper.equals("URL") || upper.equals("API")) {
                    result.append(upper);
                } else {
                    result.append(Character.toUpperCase(word.charAt(0)));
                    if (word.length() > 1) {
                        result.append(word.substring(1));
                    }
                }
                wordStart = i;
            }
        }

        return result.toString() + suffix;
    }

    /**
     * Convert UPPER_CASE entity type to Title Case dynamically.
     * Examples:
     *   "BILLER" -> "Biller"
     *   "BILLER_CATEGORY" -> "Biller Category"
     *   "LOV_DATA" -> "Lov Data"
     */
    private String getEntityTypeDisplayName(String entityType) {
        if (entityType == null || entityType.isEmpty()) return "Unknown";

        StringBuilder sb = new StringBuilder();
        for (String word : entityType.split("_")) {
            if (sb.length() > 0) sb.append(" ");
            if (word.length() > 0) {
                sb.append(Character.toUpperCase(word.charAt(0)));
                if (word.length() > 1) {
                    sb.append(word.substring(1).toLowerCase());
                }
            }
        }
        return sb.toString();
    }

    /**
     * Get display name for workflow action dynamically.
     * Examples:
     *   "ADD_BILLER" -> "Add"
     *   "UPDATE_BILLER_CATEGORY" -> "Update"
     *   "DELETE_LOV" -> "Delete"
     */
    private String getActionDisplayName(String workflowAction) {
        if (workflowAction == null) return "Unknown";

        if (workflowAction.startsWith("ADD_")) {
            return "Add";
        } else if (workflowAction.startsWith("UPDATE_")) {
            return "Update";
        } else if (workflowAction.startsWith("DELETE_")) {
            return "Delete";
        }

        return workflowAction;
    }
}

