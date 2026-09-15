<%@ page import="com.ejada.telemony.db.model.Channels" %>
<%
    Channels channel = (Channels) request.getAttribute("CHANNEL");

    String requestType = "Add";
    String hyphen = "-";
    String fromClass = "";
    String toClass = "tm-to";
%>

<div class="table-responsive">
    <table class="tm-table">
        <tbody>
        <tr>
            <td class="tm-meta-label"><strong>Code</strong></td>
            <td class="tm-meta-value" colspan="2"><%= channel != null ? channel.getChannelId() : hyphen %></td>
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
        <tr>
            <td><strong>Name</strong></td>
            <td class="<%= fromClass %>"><%= hyphen %></td>
            <td class="<%= toClass %>"><%= channel != null ? channel.getName() : hyphen %></td>
        </tr>
        <tr>
            <td><strong>Type</strong></td>
            <td class="<%= fromClass %>"><%= hyphen %></td>
            <td class="<%= toClass %>"><%= channel != null ? ("1".equals(channel.getType()) ? "Web" : "0".equals(channel.getType()) ? "Mobile" : channel.getType()) : hyphen %></td>
        </tr>
        <tr>
            <td><strong>Description</strong></td>
            <td class="<%= fromClass %>"><%= hyphen %></td>
            <td class="<%= toClass %>"><%= channel != null ? channel.getDescription() : hyphen %></td>
        </tr>
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
    .tm-to {
        color: #16a34a;
    }
</style>
