<%@page import="java.util.ArrayList"%>
<%@page import="com.ejada.telemoney.db.domain.model.DropDownDataDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui" %>

<portlet:renderURL var="cancel_update">
    <portlet:param name="action" value="view" />
</portlet:renderURL>
<portlet:actionURL name="updateFieldData" var="updateFieldData">
</portlet:actionURL>

<portlet:actionURL name="getUpdateFieldAndDropDownData" var="getUpdateFieldAndDropDownData">
</portlet:actionURL>


<%
String subServiceName  = (String)request.getAttribute("subServiceName");
String subServiceId  = (String)request.getAttribute("subServiceId");
String billerName  = (String)request.getAttribute("billerName");
String fieldId  = (String)request.getAttribute("fieldId");
String fieldCode  = (String)request.getAttribute("fieldCode");
String fieldName  = (String)request.getAttribute("fieldName");
String fieldDetailsId  = (String)request.getAttribute("fieldDetailsId");
String fixedValueFlag  = (String)request.getAttribute("fixedValueFlag");
String fixedValue  = (String)request.getAttribute("fixedValue");
String dateFlag  = (String)request.getAttribute("dateFlag");
String dropDownFlag  = (String)request.getAttribute("dropDownFlag");
boolean hasPendingVersion = (Boolean) request.getAttribute("parentHasPendingVersion");
Set<String> pendingDropDownIds = (Set<String>) request.getAttribute("pendingDropDownIds");
String billerId = request.getAttribute("billerId") != null ? (String) request.getAttribute("billerId") : "";


List<DropDownDataDTO> dropdowns = request.getAttribute("dropdowns") != null
? (List<DropDownDataDTO>) request.getAttribute("dropdowns")
: new ArrayList();

boolean isDisabled = hasPendingVersion;

%>


<div>
    <h3 class="pb-4">
        <% if (hasPendingVersion) { %>
            View MOI Biller Field
            <span class="badge badge-warning ml-2" style="font-size: 0.65rem; vertical-align: middle; background-color: #f0ad4e;">
                Pending Approval - View Only
            </span>
        <% } else { %>
            Edit MOI Biller Field
        <% } %>
    </h3>
    <liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />    
    <liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
    <liferay-ui:error key="hasPendingVersion" message="This MOI biller has a pending version awaiting approval and cannot be modified." />

    <% if (hasPendingVersion) { %>
        <div class="alert alert-warning" role="alert" style="background-color: #fff3cd; border-color: #ffeaa7; color: #856404;">
            <strong>Pending Approval:</strong> This MOI biller field has changes pending approval. You cannot make edits until the pending changes are reviewed.
        </div>
    <% } %>
    <div class="card">
        <div class="card-body">
            <form action="<%=updateFieldData%>" method="post">            
                <fieldset <%= isDisabled ? "disabled" : "" %>>
                <div class="mb-3">
                    
                    <input type="hidden" class="form-control" id="" 
                    name="<portlet:namespace/>subServiceNames" 
                    value="<%=subServiceName %>">
                    
                    <input type="hidden" class="form-control" id=""
                    name="<portlet:namespace/>subServiceId" 
                    value="<%=subServiceId %>">
                </div>
                <input type="hidden" class="form-control" id=""
                    name="<portlet:namespace/>billerName" 
                    value="<%=billerName %>">

                <!-- Old values for workflow comparison -->
                <input type="hidden" name="<portlet:namespace/>oldFieldId" value="<%=fieldId %>">
                <input type="hidden" name="<portlet:namespace/>oldFieldCode" value="<%=fieldCode %>">
                <input type="hidden" name="<portlet:namespace/>oldFieldName" value="<%=fieldName %>">
                <input type="hidden" name="<portlet:namespace/>oldFieldDetailsId" value="<%=fieldDetailsId %>">
                <input type="hidden" name="<portlet:namespace/>oldFixedValueFlag" value="<%=fixedValueFlag %>">
                <input type="hidden" name="<portlet:namespace/>oldFixedValue" value="<%=fixedValue %>">
                <input type="hidden" name="<portlet:namespace/>oldDateFlag" value="<%=dateFlag %>">
                <input type="hidden" name="<portlet:namespace/>oldDropDownFlag" value="<%=dropDownFlag %>">

                <div class="mb-3">
                    <label class="form-label">Field ID</label> 
                    <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id=""
                    name="<portlet:namespace/>fieldId" 
                    value="<%=fieldId %>" readonly>
                </div>
                <div class="mb-3">
                    <label class="form-label">Field code</label> 
                    <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id=""
                    name="<portlet:namespace/>fieldCode" 
                    value="<%=fieldCode %>">
                </div>
                <div class="mb-3">
                    <label class="form-label">Field name</label> 
                    <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id=""
                    name="<portlet:namespace/>fieldName" 
                    value="<%=fieldName %>">
                    
                    
                </div>
                <div class="mb-3">
                    <label class="form-label">Field type</label> 
                    <select pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." class="custom-select" name="<portlet:namespace/>fieldDetailsId" id="fieldType" required onchange="handleFieldTypeChange()">
                        <option value="" >Choose...</option>
                        <option value="1" <%=fieldDetailsId.equals("1") ? "selected":"" %>>Fixed Value</option>
                        <option value="2" <%=fieldDetailsId.equals("2") ? "selected":"" %>>Date</option>
                        <option value="3" <%=fieldDetailsId.equals("3") ? "selected":"" %>>Drop Down</option>
                     </select>
                </div>
                <div class="mb-3" id="fixedValueDiv" style="display: none;">
                    <label class="form-label">Number of digit</label> 
                    <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" name="<portlet:namespace/>fixedValue" value="<%=fixedValue %>">
                </div>
                
                <div class="table-responsive" id="dropdownDiv" style="display: none;">
                    <h3>Dropdown values</h3>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">
                                    Code
                                    <span style="cursor: pointer;">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrows-vertical" viewBox="0 0 16 16">
                                          <path d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z"/>
                                        </svg>
                                    </span>
                                </th>
                                <th scope="col">
                                    Value English 
                                    <span style="cursor: pointer;">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrows-vertical" viewBox="0 0 16 16">
                                          <path d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z"/>
                                        </svg>
                                    </span>
                                </th>
                                <th scope="col">
                                    Value Arabic 
                                    <span style="cursor: pointer;">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrows-vertical" viewBox="0 0 16 16">
                                          <path d="M8.354 14.854a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L7.5 13.293V2.707L6.354 3.854a.5.5 0 1 1-.708-.708l2-2a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1-.708.708L8.5 2.707v10.586l1.146-1.147a.5.5 0 0 1 .708.708z"/>
                                        </svg>
                                    </span>
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                                <% for(DropDownDataDTO dropdown : dropdowns){ 
                                    boolean dropDownHasPendingVersion = hasPendingVersion || pendingDropDownIds.contains(String.valueOf(dropdown.getId()));
                                %>
                            <tr>
                                <td><%=dropdown.getCode() %></td>
                                <td><%=dropdown.getValueEn() %></td>
                                <td><%=dropdown.getValueAr() %>
                                    <% if (dropDownHasPendingVersion) { %>
                                        <span class="badge badge-warning" style="font-size: 0.7rem; vertical-align: middle; background-color: #f0ad4e; margin-left: 8px;">
                                            Pending Approval
                                        </span>
                                    <% } %>
                                </td>
                                <td>
                                    <div class="dropdown">
                                      <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-three-dots-vertical" viewBox="0 0 16 16">
                                          <path d="M9.5 13a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z"/>
                                        </svg>
                                      </button>
                                      <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                      <% if (dropDownHasPendingVersion) { %>
                                      <a
                                            href=<portlet:actionURL name="getUpdateFieldAndDropDownData" >
                                                    <portlet:param name="fieldId" value="<%=fieldId%>" />
                                                    <portlet:param name="fieldCode" value="<%=fieldCode%>" />
                                                    <portlet:param name="fieldName" value="<%=fieldName%>" />
                                                    <portlet:param name="fixedValueFlag" value="<%=fixedValueFlag%>" />
                                                    <portlet:param name="fixedValue" value="<%=fixedValue%>" />
                                                    <portlet:param name="dateFlag" value="<%=dateFlag%>" />
                                                    <portlet:param name="dropDownFlag" value="<%=dropDownFlag%>" />
                                                    <portlet:param name="subServiceId" value="<%=subServiceId%>" />
                                                    <portlet:param name="subServiceName" value="<%=subServiceName%>" />
                                                    <portlet:param name="billerName" value="<%=billerName%>" />
                                                    <portlet:param name="billerId" value="<%=billerId%>" />

                                                    <portlet:param name="id" value="<%=String.valueOf(dropdown.getId())%>" />
                                                    <portlet:param name="code" value="<%=dropdown.getCode()%>" />
                                                    <portlet:param name="valueAr" value="<%=dropdown.getValueAr()%>" />
                                                    <portlet:param name="valueEn" value="<%=dropdown.getValueEn()%>" />
                                                    <portlet:param name="relatedFieldCode" value="<%=dropdown.getRelatedFieldCode()%>" />
                                                    <portlet:param name="relatedFieldId" value="<%=String.valueOf(dropdown.getRelatedFieldId())%>" />
                                                    <portlet:param name="relatedFieldName" value="<%=dropdown.getRelatedFieldName()%>" />
                                                    <portlet:param name="allowedValues" value="<%=String.join(",", dropdown.getAllowedValues())%>" />
                                                    <portlet:param name="parentHasPendingVersion" value="<%= String.valueOf(dropDownHasPendingVersion) %>" />
                                                </portlet:actionURL>
                                            class="dropdown-item"> View </a>
                                      <% } else { %>
                                        <a
                                            href=<portlet:actionURL name="getUpdateFieldAndDropDownData" >
                                                    <portlet:param name="fieldId" value="<%=fieldId%>" />
                                                    <portlet:param name="fieldCode" value="<%=fieldCode%>" />
                                                    <portlet:param name="fieldName" value="<%=fieldName%>" />
                                                    <portlet:param name="fixedValueFlag" value="<%=fixedValueFlag%>" />
                                                    <portlet:param name="fixedValue" value="<%=fixedValue%>" />
                                                    <portlet:param name="dateFlag" value="<%=dateFlag%>" />
                                                    <portlet:param name="dropDownFlag" value="<%=dropDownFlag%>" />
                                                    <portlet:param name="subServiceId" value="<%=subServiceId%>" />
                                                    <portlet:param name="subServiceName" value="<%=subServiceName%>" />
                                                    <portlet:param name="billerName" value="<%=billerName%>" />
                                                    <portlet:param name="billerId" value="<%=billerId%>" />

                                                    <portlet:param name="id" value="<%=String.valueOf(dropdown.getId())%>" />
                                                    <portlet:param name="code" value="<%=dropdown.getCode()%>" />
                                                    <portlet:param name="valueAr" value="<%=dropdown.getValueAr()%>" />
                                                    <portlet:param name="valueEn" value="<%=dropdown.getValueEn()%>" />
                                                    <portlet:param name="relatedFieldCode" value="<%=dropdown.getRelatedFieldCode()%>" />
                                                    <portlet:param name="relatedFieldId" value="<%=String.valueOf(dropdown.getRelatedFieldId())%>" />
                                                    <portlet:param name="relatedFieldName" value="<%=dropdown.getRelatedFieldName()%>" />
                                                    <portlet:param name="allowedValues" value="<%=String.join(",", dropdown.getAllowedValues())%>" />
                                                    <portlet:param name="parentHasPendingVersion" value="<%= String.valueOf(dropDownHasPendingVersion) %>" />
                                                </portlet:actionURL>
                                            class="dropdown-item"> Edit </a>
                                      <% } %>
                                       
                                      </div>
                                    </div>
                                </td>
                            </tr>
                            <%} %>
                        </tbody>
                    </table>
                </div>
                </fieldset>
                <div class="d-flex justify-content-end">
                    <button type="button"
                        onclick="window.location.href='<%=cancel_update%>'"
                        class="btn btn-secondary px-5 mr-3">BACK</button>
                    <% if (!isDisabled) { %>
                    <button type="button" class="btn btn-primary px-5" onclick="showUpdateConfirmation()">Update</button>
                    <% } %>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Update Confirmation Modal -->
<div class="modal hide fade" id="telemoneyUpdateModal" tabindex="-1"
    role="dialog" aria-labelledby="telemoneyUpdateModalCenteredTitle"
    aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered w-100" role="document">
        <div class="modal-content w-auto m-auto">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Update MOI Biller Field</h5>
                <button type="button" class="close" data-dismiss="modal"
                    aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body text-5 text-center">Are you sure you want to update this MOI biller field?</div>
            <div class="modal-footer justify-content-end">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="confirmUpdate()">Confirm</button>
            </div>
        </div>
    </div>
</div>

<script>
$('th').click(function(){
    var table = $(this).parents('table').eq(0)
    var rows = table.find('tr:gt(0)').toArray().sort(comparer($(this).index()))
    this.asc = !this.asc
    if (!this.asc){rows = rows.reverse()}
    for (var i = 0; i < rows.length; i++){table.append(rows[i])}
})
function comparer(index) {
    return function(a, b) {
        var valA = getCellValue(a, index), valB = getCellValue(b, index)
        return $.isNumeric(valA) && $.isNumeric(valB) ? valA - valB : valA.toString().localeCompare(valB)
    }
}
function getCellValue(row, index){ return $(row).children('td').eq(index).text() }

function handleFieldTypeChange() {
    var fieldType = document.getElementById("fieldType").value;
    var fixedValueDiv = document.getElementById("fixedValueDiv");
    var dropdownDiv = document.getElementById("dropdownDiv");

    if (fieldType === "1") { // Fixed Value
        fixedValueDiv.style.display = "block";
        dropdownDiv.style.display = "none";
    } else if (fieldType === "2") { // Date
        fixedValueDiv.style.display = "none";
        dropdownDiv.style.display = "none";
    } else if (fieldType === "3") { // Drop Down
        fixedValueDiv.style.display = "none";
        dropdownDiv.style.display = "block";
    } else {
        fixedValueDiv.style.display = "none";
        dropdownDiv.style.display = "none";
    }
}

// hna b3ml call lel method de 3nd el page render
handleFieldTypeChange();

function showUpdateConfirmation() {
    $("#telemoneyUpdateModal").modal("show");
    $("#telemoneyUpdateModal").removeClass("hide");
}

function confirmUpdate() {
    // Find the form and submit it
    var form = document.querySelector('form[action="<%=updateFieldData%>"]');
    if (form) {
        form.submit();
    }
}

$('#telemoneyUpdateModal').on('hidden.bs.modal', function(e) {
    // Nothing to reset for update
});
</script>
