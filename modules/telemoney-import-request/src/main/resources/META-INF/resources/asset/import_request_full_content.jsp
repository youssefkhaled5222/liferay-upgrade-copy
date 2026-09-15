<%@ include file="/init.jsp" %>

<%
    boolean isDeleted = GetterUtil.getBoolean(request.getAttribute("isDeleted"), false);
    boolean zipReadError = GetterUtil.getBoolean(request.getAttribute("zipReadError"), false);

    // Get workflow states
    Boolean isAlreadyApproved = (Boolean) request.getAttribute("isAlreadyApproved");
    boolean showApprovedBadge = isAlreadyApproved != null && isAlreadyApproved;

    Boolean isRejected = (Boolean) request.getAttribute("isRejected");
    boolean showRejectedBadge = isRejected != null && isRejected;
%>

<c:choose>
    <c:when test="<%= isDeleted %>">
        <%
            String deletedEntryName = (String) request.getAttribute("deletedEntryName");
        %>
        <div class="container-fluid container-fluid-max-xl">
            <div class="alert alert-info" role="alert">
                <span class="alert-indicator">
                    <svg class="lexicon-icon lexicon-icon-info-circle" focusable="false" role="presentation">
                        <use href="/o/classic-theme/images/lexicon/icons.svg#info-circle"></use>
                    </svg>
                </span>
                <strong class="lead">Asset Removed</strong>
                <c:choose>
                    <c:when test="<%= deletedEntryName != null && !deletedEntryName.isEmpty() %>">
                        <p class="mb-0">The import request "<%= deletedEntryName %>" has been deleted or removed from the system.</p>
                    </c:when>
                    <c:otherwise>
                        <p class="mb-0">The import request (ID: <%= request.getAttribute("deletedEntryId") %>) has been deleted or removed from the system.</p>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </c:when>
    <c:when test="<%= zipReadError %>">
        <div class="alert alert-danger">
            <strong>Error reading import data from zip file.</strong>
        </div>
    </c:when>
    <c:otherwise>
        <%
            com.ejada.telemony.db.model.ImportRequest importRequest =
                (com.ejada.telemony.db.model.ImportRequest) request.getAttribute("importRequest");
            String metadataJson = (String) request.getAttribute("metadataJson");
            String changeLogJson = (String) request.getAttribute("changeLogJson");
            String enrichedDataJson = (String) request.getAttribute("enrichedDataJson");
        %>

        <!-- Show Approved/Rejected Badge -->
        <c:if test="<%= showApprovedBadge %>">
            <div class="container-fluid container-fluid-max-xl mb-3">
                <div class="alert alert-success" role="alert">
                    <span class="alert-indicator">
                        <svg class="lexicon-icon lexicon-icon-check-circle" focusable="false" role="presentation">
                            <use href="/o/classic-theme/images/lexicon/icons.svg#check-circle"></use>
                        </svg>
                    </span>
                    <strong class="lead">Already Approved</strong>
                    <p class="mb-0">This import request has already been approved.</p>
                </div>
            </div>
        </c:if>

        <c:if test="<%= showRejectedBadge %>">
            <div class="container-fluid container-fluid-max-xl mb-3">
                <div class="alert alert-danger" role="alert">
                    <span class="alert-indicator">
                        <svg class="lexicon-icon lexicon-icon-times-circle" focusable="false" role="presentation">
                            <use href="/o/classic-theme/images/lexicon/icons.svg#times-circle"></use>
                        </svg>
                    </span>
                    <strong class="lead">Already Rejected</strong>
                    <p class="mb-0">This import request has already been rejected.</p>
                </div>
            </div>
        </c:if>

        <style>
            .import-request-container { font-family: Arial, sans-serif; padding: 10px; }
            .import-request-container h3 { color: #333; border-bottom: 2px solid #0b5fff; padding-bottom: 5px; margin-top: 20px; }
            .import-request-container .info-row { margin: 5px 0; }
            .import-request-container .info-label { font-weight: bold; color: #555; min-width: 120px; display: inline-block; }
            .import-request-container pre {
                background: #f8f9fa; border: 1px solid #dee2e6; border-radius: 4px;
                padding: 12px; overflow-x: auto; max-height: 500px; overflow-y: auto;
                font-size: 13px; line-height: 1.4;
            }
            .json-section { margin-bottom: 15px; }
            .json-toggle { cursor: pointer; color: #0b5fff; text-decoration: underline; margin-bottom: 5px; display: inline-block; }
        </style>

        <div class="import-request-container">
            <h3>Import Request Details</h3>
            <div class="info-row">
                <span class="info-label">Type:</span> <%= importRequest.getType() %>
            </div>
            <div class="info-row">
                <span class="info-label">File Name:</span> <%= importRequest.getFileName() %>
            </div>

            <c:if test="<%= metadataJson != null %>">
                <div class="json-section">
                    <h3>Metadata</h3>
                    <pre><%= metadataJson %></pre>
                </div>
            </c:if>

            <c:if test="<%= changeLogJson != null %>">
                <div class="json-section">
                    <h3>Change Log</h3>
                    <pre><%= changeLogJson %></pre>
                </div>
            </c:if>

            <c:if test="<%= enrichedDataJson != null %>">
                <div class="json-section">
                    <h3>Data (Enriched)</h3>
                    <pre><%= enrichedDataJson %></pre>
                </div>
            </c:if>
        </div>
    </c:otherwise>
</c:choose>


