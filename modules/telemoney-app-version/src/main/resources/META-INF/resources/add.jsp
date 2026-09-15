<%@ include file="/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<portlet:renderURL var="backURL">
    <portlet:param name="page" value="view"/>
</portlet:renderURL>

<portlet:actionURL name="addAppVersion" var="addAppVersionURL" />

<%
    String errorMsg = (String) request.getAttribute("errorMessage") != null
            ? (String) request.getAttribute("errorMessage")
            : "";

    System.out.println("From JSP = "+errorMsg);

    String platform = (String) request.getAttribute("platform") != null
            ? (String) request.getAttribute("platform")
            : "";

    String versionNumber = (String) request.getAttribute("versionNumber") != null
            ? (String) request.getAttribute("versionNumber")
            : "";

    String url = (String) request.getAttribute("url") != null
            ? (String) request.getAttribute("url")
            : "";

    Boolean status = (Boolean) request.getAttribute("status") != null
            ? (Boolean) request.getAttribute("status")
            : true;

    Long channelId = (Long) request.getAttribute("channelId") != null
            ? (Long) request.getAttribute("channelId")
            : 0L;
%>

<div>
    <h3 class="pb-4">Add New App Version</h3>
    <liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />	
    <liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
    <div class="my-3">
        <liferay-ui:error key="error"
                          message="<%=errorMsg.isEmpty() ?  "":errorMsg %>" />
    </div>
    <div class="card">
        <div class="card-body">
            <form action="<%=addAppVersionURL%>" method="post"
                  name="<portlet:namespace/>addAppVersionForm"
                  id="<portlet:namespace/>addAppVersionForm">
				<fieldset <%= isOther ? "disabled" : "" %>>
                <div class="mb-3">
                    <label class="form-label">Platform</label>
                    <select pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." class="form-control"
                            name="<portlet:namespace/>platform"
                            id="<portlet:namespace/>platform" required>
                        <option value="">Select Platform</option>
                        <option value="IOS" <%= "IOS".equals(platform) ? "selected" : "" %>>IOS</option>
                        <option value="Android" <%= "Android".equals(platform) ? "selected" : "" %>>Android</option>
                        <option value="Huawei" <%= "Huawei".equals(platform) ? "selected" : "" %>>Huawei</option>
                    </select>
                </div>

                <div class="mb-3">
                    <label class="form-label">Version Number</label>
                    <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control"
                           id="<portlet:namespace/>versionNumber"
                           name="<portlet:namespace/>versionNumber"
                           value="<%=versionNumber%>"
                           placeholder="e.g. 1.0.0" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Download URL</label>
                    <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="url" class="form-control"
                           id="<portlet:namespace/>url"
                           name="<portlet:namespace/>url"
                           value="<%=url%>"
                           placeholder="https://example.com/app/download" required>
                </div>

                <div class="mb-3 form-check">
                    <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="checkbox" class="form-check-input"
                           id="<portlet:namespace/>status"
                           name="<portlet:namespace/>status"
                        <%= status ? "checked" : "" %>>
                    <label class="form-check-label" for="<portlet:namespace/>status">Active</label>
                </div>
                </fieldset>
                <div class="d-flex justify-content-end mt-3">
                    <button type="button" class="btn btn-secondary px-5 mr-3"
                            onclick="window.location.href='<%=backURL%>'"><%= isOther ? "BACK" : "CANCEL" %></button>
                    <% if (!isOther) { %>
                    <button type="submit" class="btn btn-primary px-5">SAVE</button>
                    <% } %>
                </div>
            </form>
        </div>
    </div>
</div>

<aui:script>
    AUI().use('aui-form-validator', function(A) {
    var formValidator = new A.FormValidator({
    boundingBox: '#<portlet:namespace/>addAppVersionForm',
    rules: {
    '<portlet:namespace/>versionNumber': {
    required: true,
    rangeLength: [1, 20]
    }
    },
    fieldStrings: {
    '<portlet:namespace/>versionNumber': {
    required: 'Version number is required',
    rangeLength: 'Version number must be between 1 and 20 characters'
    }
    }
    });
    });
</aui:script>

<style>
    .form-check {
        padding-left: 0;
    }

    .form-check-input {
        margin-left: 0;
        margin-right: 0.5rem;
    }
</style>