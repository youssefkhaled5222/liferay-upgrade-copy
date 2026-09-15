<%@ page import="com.ejada.telemony.db.model.Persona" %>
<%@ page import="java.util.Objects" %>
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
    <strong class="lead">Entry Deleted:</strong> This Persona entry (ID: <%= deletedEntryId %>) has been deleted and is no longer available.
</div>
<%
        return;
    }

    Persona editedPersona = (Persona) request.getAttribute("editedPersona");
    Persona originalPersona = (Persona) request.getAttribute("originalPersona");

    boolean hasEdited = editedPersona != null;
    boolean hasOriginal = originalPersona != null;

    String hyphen = "-";

    // Request type is driven by persisted workflowAction (ADD/UPDATE/DELETE)
    String workflowAction = hasEdited ? editedPersona.getWorkflowAction() : null;
    String requestType = (workflowAction == null) ? hyphen : workflowAction;

    boolean isAdd = "ADD".equalsIgnoreCase(workflowAction);
    boolean isUpdate = "UPDATE".equalsIgnoreCase(workflowAction);
    boolean isDelete = "DELETE".equalsIgnoreCase(workflowAction);

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    // Prefer the edited key for code; fall back to original if the renderer only had original
    String codeValue = hasEdited ? String.valueOf(editedPersona.getPersonaId()) : (hasOriginal ? String.valueOf(originalPersona.getPersonaId()) : hyphen);

    String nameFrom = isAdd ? hyphen : (hasOriginal ? originalPersona.getName() : hyphen);
    String nameTo = isDelete ? hyphen : (hasEdited ? editedPersona.getName() : hyphen);

    String descFrom = isAdd ? hyphen : (hasOriginal ? originalPersona.getDescription() : hyphen);
    String descTo = isDelete ? hyphen : (hasEdited ? editedPersona.getDescription() : hyphen);

    String channelFrom = isAdd ? hyphen : (hasOriginal ? String.valueOf(originalPersona.getChannelId()) : hyphen);
    String channelTo = isDelete ? hyphen : (hasEdited ? String.valueOf(editedPersona.getChannelId()) : hyphen);

    String darkThemeFrom = isAdd ? hyphen : (hasOriginal && originalPersona.getDarkThemeId() != null ? String.valueOf(originalPersona.getDarkThemeId()) : hyphen);
    String darkThemeTo = isDelete ? hyphen : (hasEdited && editedPersona.getDarkThemeId() != null ? String.valueOf(editedPersona.getDarkThemeId()) : hyphen);

    String lightThemeFrom = isAdd ? hyphen : (hasOriginal && originalPersona.getLightThemeId() != null ? String.valueOf(originalPersona.getLightThemeId()) : hyphen);
    String lightThemeTo = isDelete ? hyphen : (hasEdited && editedPersona.getLightThemeId() != null ? String.valueOf(editedPersona.getLightThemeId()) : hyphen);

    String priorityFrom = isAdd ? hyphen : (hasOriginal ? String.valueOf(originalPersona.getPriority()) : hyphen);
    String priorityTo = isDelete ? hyphen : (hasEdited ? String.valueOf(editedPersona.getPriority()) : hyphen);

    String startAgeFrom = isAdd ? hyphen : (hasOriginal ? String.valueOf(originalPersona.getStartAge()) : hyphen);
    String startAgeTo = isDelete ? hyphen : (hasEdited ? String.valueOf(editedPersona.getStartAge()) : hyphen);

    String endAgeFrom = isAdd ? hyphen : (hasOriginal ? String.valueOf(originalPersona.getEndAge()) : hyphen);
    String endAgeTo = isDelete ? hyphen : (hasEdited ? String.valueOf(editedPersona.getEndAge()) : hyphen);

    String nationalityFrom = isAdd ? hyphen : (hasOriginal ? originalPersona.getNationality() : hyphen);
    String nationalityTo = isDelete ? hyphen : (hasEdited ? editedPersona.getNationality() : hyphen);

    String segmentFrom = isAdd ? hyphen : (hasOriginal ? originalPersona.getCustomerSegment() : hyphen);
    String segmentTo = isDelete ? hyphen : (hasEdited ? editedPersona.getCustomerSegment() : hyphen);

    String genderFrom = isAdd ? hyphen : (hasOriginal ? originalPersona.getGender() : hyphen);
    String genderTo = isDelete ? hyphen : (hasEdited ? editedPersona.getGender() : hyphen);

    String sectorFrom = isAdd ? hyphen : (hasOriginal ? originalPersona.getSector() : hyphen);
    String sectorTo = isDelete ? hyphen : (hasEdited ? editedPersona.getSector() : hyphen);

    String incomeFrom = isAdd ? hyphen : (hasOriginal ? (originalPersona.getMinIncome() + " - " + originalPersona.getMaxIncome()) : hyphen);
    String incomeTo = isDelete ? hyphen : (hasEdited ? (editedPersona.getMinIncome() + " - " + editedPersona.getMaxIncome()) : hyphen);

    String defaultFrom = isAdd ? hyphen : (hasOriginal ? (originalPersona.getDefaultPersona() ? "Yes" : "No") : hyphen);
    String defaultTo = isDelete ? hyphen : (hasEdited ? (editedPersona.getDefaultPersona() ? "Yes" : "No") : hyphen);

    String statusFrom = isAdd ? hyphen : (hasOriginal ? originalPersona.getPersonaStatus() : hyphen);
    String statusTo = isDelete ? hyphen : (hasEdited ? editedPersona.getPersonaStatus() : hyphen);

    String dateFromVal = isAdd ? hyphen : (hasOriginal && originalPersona.getDateFrom() != null ? dateFormat.format(originalPersona.getDateFrom()) : hyphen);
    String dateFromTo = isDelete ? hyphen : (hasEdited && editedPersona.getDateFrom() != null ? dateFormat.format(editedPersona.getDateFrom()) : hyphen);

    String dateToVal = isAdd ? hyphen : (hasOriginal && originalPersona.getDateTo() != null ? dateFormat.format(originalPersona.getDateTo()) : hyphen);
    String dateToTo = isDelete ? hyphen : (hasEdited && editedPersona.getDateTo() != null ? dateFormat.format(editedPersona.getDateTo()) : hyphen);

    boolean nameChanged = hasEdited && hasOriginal && !Objects.equals(nameFrom, nameTo);
    boolean descChanged = hasEdited && hasOriginal && !Objects.equals(descFrom, descTo);
    boolean channelChanged = hasEdited && hasOriginal && !Objects.equals(channelFrom, channelTo);
    boolean darkThemeChanged = hasEdited && hasOriginal && !Objects.equals(darkThemeFrom, darkThemeTo);
    boolean lightThemeChanged = hasEdited && hasOriginal && !Objects.equals(lightThemeFrom, lightThemeTo);
    boolean priorityChanged = hasEdited && hasOriginal && !Objects.equals(priorityFrom, priorityTo);
    boolean startAgeChanged = hasEdited && hasOriginal && !Objects.equals(startAgeFrom, startAgeTo);
    boolean endAgeChanged = hasEdited && hasOriginal && !Objects.equals(endAgeFrom, endAgeTo);
    boolean nationalityChanged = hasEdited && hasOriginal && !Objects.equals(nationalityFrom, nationalityTo);
    boolean segmentChanged = hasEdited && hasOriginal && !Objects.equals(segmentFrom, segmentTo);
    boolean genderChanged = hasEdited && hasOriginal && !Objects.equals(genderFrom, genderTo);
    boolean sectorChanged = hasEdited && hasOriginal && !Objects.equals(sectorFrom, sectorTo);
    boolean incomeChanged = hasEdited && hasOriginal && !Objects.equals(incomeFrom, incomeTo);
    boolean defaultChanged = hasEdited && hasOriginal && !Objects.equals(defaultFrom, defaultTo);
    boolean statusChanged = hasEdited && hasOriginal && !Objects.equals(statusFrom, statusTo);
    boolean dateFromChanged = hasEdited && hasOriginal && !Objects.equals(dateFromVal, dateFromTo);
    boolean dateToChanged = hasEdited && hasOriginal && !Objects.equals(dateToVal, dateToTo);

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
        <% if (!isUpdate || nameChanged) { %>
        <tr>
            <td><strong>Name</strong></td>
            <td class="<%= fromClass %>"><%= nameFrom %></td>
            <td class="<%= toClass %>"><%= nameTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdate || descChanged) { %>
        <tr>
            <td><strong>Description</strong></td>
            <td class="<%= fromClass %>"><%= descFrom %></td>
            <td class="<%= toClass %>"><%= descTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdate || channelChanged) { %>
        <tr>
            <td><strong>Channel ID</strong></td>
            <td class="<%= fromClass %>"><%= channelFrom %></td>
            <td class="<%= toClass %>"><%= channelTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdate || darkThemeChanged) { %>
        <tr>
            <td><strong>Dark Theme ID</strong></td>
            <td class="<%= fromClass %>"><%= darkThemeFrom %></td>
            <td class="<%= toClass %>"><%= darkThemeTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdate || lightThemeChanged) { %>
        <tr>
            <td><strong>Light Theme ID</strong></td>
            <td class="<%= fromClass %>"><%= lightThemeFrom %></td>
            <td class="<%= toClass %>"><%= lightThemeTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdate || priorityChanged) { %>
        <tr>
            <td><strong>Priority</strong></td>
            <td class="<%= fromClass %>"><%= priorityFrom %></td>
            <td class="<%= toClass %>"><%= priorityTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdate || startAgeChanged) { %>
        <tr>
            <td><strong>Start Age</strong></td>
            <td class="<%= fromClass %>"><%= startAgeFrom %></td>
            <td class="<%= toClass %>"><%= startAgeTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdate || endAgeChanged) { %>
        <tr>
            <td><strong>End Age</strong></td>
            <td class="<%= fromClass %>"><%= endAgeFrom %></td>
            <td class="<%= toClass %>"><%= endAgeTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdate || nationalityChanged) { %>
        <tr>
            <td><strong>Nationality</strong></td>
            <td class="<%= fromClass %>"><%= nationalityFrom %></td>
            <td class="<%= toClass %>"><%= nationalityTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdate || segmentChanged) { %>
        <tr>
            <td><strong>Customer Segment</strong></td>
            <td class="<%= fromClass %>"><%= segmentFrom %></td>
            <td class="<%= toClass %>"><%= segmentTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdate || genderChanged) { %>
        <tr>
            <td><strong>Gender</strong></td>
            <td class="<%= fromClass %>"><%= genderFrom %></td>
            <td class="<%= toClass %>"><%= genderTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdate || sectorChanged) { %>
        <tr>
            <td><strong>Sector</strong></td>
            <td class="<%= fromClass %>"><%= sectorFrom %></td>
            <td class="<%= toClass %>"><%= sectorTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdate || incomeChanged) { %>
        <tr>
            <td><strong>Income Range</strong></td>
            <td class="<%= fromClass %>"><%= incomeFrom %></td>
            <td class="<%= toClass %>"><%= incomeTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdate || defaultChanged) { %>
        <tr>
            <td><strong>Default Persona</strong></td>
            <td class="<%= fromClass %>"><%= defaultFrom %></td>
            <td class="<%= toClass %>"><%= defaultTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdate || statusChanged) { %>
        <tr>
            <td><strong>Status</strong></td>
            <td class="<%= fromClass %>"><%= statusFrom %></td>
            <td class="<%= toClass %>"><%= statusTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdate || dateFromChanged) { %>
        <tr>
            <td><strong>Date From</strong></td>
            <td class="<%= fromClass %>"><%= dateFromVal %></td>
            <td class="<%= toClass %>"><%= dateFromTo %></td>
        </tr>
        <% } %>
        <% if (!isUpdate || dateToChanged) { %>
        <tr>
            <td><strong>Date To</strong></td>
            <td class="<%= fromClass %>"><%= dateToVal %></td>
            <td class="<%= toClass %>"><%= dateToTo %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>

<style>
    .tm-table { width: 100%; border-collapse: collapse; font-family: "Helvetica", "Arial", sans-serif; }
    .tm-table th, .tm-table td { border: 1px solid #d1d5db; padding: 8px 10px; text-align: left; }
    .tm-meta-label { font-weight: 700; width: 180px; }
    .tm-meta-value { font-weight: 400; }
    .tm-header th { background-color: #f3f4f6; font-weight: 700; }
    .tm-from { color: #dc2626; text-decoration: line-through; }
    .tm-to { color: #16a34a; }
</style>
