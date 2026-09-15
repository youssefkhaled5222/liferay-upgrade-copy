<%@ include file="/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui"%>

<portlet:renderURL var="cancel_update">
    <portlet:param name="action" value="view" />
</portlet:renderURL>
<portlet:actionURL name="updateFieldAndDropDownData"
    var="updateFieldAndDropDownData">
</portlet:actionURL>

<%
    String subServiceName = request.getAttribute("subServiceName") != null
            ? (String) request.getAttribute("subServiceName")
            : "";

    String fieldId = request.getAttribute("fieldId") != null ? (String) request.getAttribute("fieldId") : "";

    String fieldCode = request.getAttribute("fieldCode") != null ? (String) request.getAttribute("fieldCode")
            : "";

    String fieldName = request.getAttribute("fieldName") != null ? (String) request.getAttribute("fieldName")
            : "";

    String fieldDetailsId = request.getAttribute("fieldDetailsId") != null
            ? (String) request.getAttribute("fieldDetailsId")
            : "";

    String fixedValueFlag = request.getAttribute("fixedValueFlag") != null
            ? (String) request.getAttribute("fixedValueFlag")
            : "";

    String fixedValue = request.getAttribute("fixedValue") != null ? (String) request.getAttribute("fixedValue")
            : "";

    String dateFlag = request.getAttribute("dateFlag") != null ? (String) request.getAttribute("dateFlag") : "";

    String dropDownFlag = request.getAttribute("dropDownFlag") != null
            ? (String) request.getAttribute("dropDownFlag")
            : "";

    String subServiceId = request.getAttribute("subServiceId") != null
            ? (String) request.getAttribute("subServiceId")
            : "";

    String id = request.getAttribute("id") != null ? (String) request.getAttribute("id") : "";

    String code = request.getAttribute("code") != null ? (String) request.getAttribute("code") : "";

    String valueAr = request.getAttribute("valueAr") != null ? (String) request.getAttribute("valueAr") : "";

    String valueEn = request.getAttribute("valueEn") != null ? (String) request.getAttribute("valueEn") : "";

    String relatedFieldCode = request.getAttribute("relatedFieldCode") != null
            ? (String) request.getAttribute("relatedFieldCode")
            : "";

    String relatedFieldId = request.getAttribute("relatedFieldId") != null
            ? (String) request.getAttribute("relatedFieldId")
            : "";

    String relatedFieldName = request.getAttribute("relatedFieldName") != null
            ? (String) request.getAttribute("relatedFieldName")
            : "";

    String allowedValues = request.getAttribute("allowedValues") != null
            ? (String) request.getAttribute("allowedValues")
            : "";


    String billerName = request.getAttribute("billerName") != null
            ? (String) request.getAttribute("billerName")
            : "";
    boolean hasPendingVersion = (Boolean) request.getAttribute("parentHasPendingVersion");
    boolean isDisabled = hasPendingVersion;
            
    
            
%>
<div>
    <h3 class="pb-4">
        <% if (hasPendingVersion) { %>
            View Dropdown value
            <span class="badge badge-warning ml-2" style="font-size: 0.65rem; vertical-align: middle; background-color: #f0ad4e;">
                Pending Approval - View Only
            </span>
        <% } else { %>
            Edit Dropdown value
        <% } %>
    </h3>
    <liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />    
    <liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
    <% if (hasPendingVersion) { %>
        <div class="alert alert-warning" role="alert" style="background-color: #fff3cd; border-color: #ffeaa7; color: #856404;">
            <strong>Pending Approval:</strong> This dropdown value has changes pending approval. You cannot make edits until the pending changes are reviewed.
        </div>
    <% } %>
    <div class="card">
        <div class="card-body">
            <form action="<%=updateFieldAndDropDownData%>" method="post">
                <fieldset <%= isDisabled ? "disabled" : "" %>>
                <div class="mb-3">
                    <input type="hidden" class="form-control" id=""
                        name="<portlet:namespace/>subServiceName" value="<%=subServiceName%>">
                    
                    <input type="hidden" class="form-control" id=""
                        name="<portlet:namespace/>billerName" value="<%=billerName%>">
                        
                    <input type="hidden" class="form-control" id=""
                        name="<portlet:namespace/>fieldId" value="<%=fieldId%>">
                        
                    <input type="hidden" class="form-control" id=""
                        name="<portlet:namespace/>fieldCode" value="<%=fieldCode%>">
                        
                    <input type="hidden" class="form-control" id=""
                        name="<portlet:namespace/>fieldName" value="<%=fieldName%>">
                        
                    <input type="hidden" class="form-control" id=""
                        name="<portlet:namespace/>fieldDetailsId" value="<%=fieldDetailsId%>">
                        
                    <input type="hidden" class="form-control" id=""
                        name="<portlet:namespace/>fixedValueFlag" value="<%=fixedValueFlag%>">
                        
                    <input type="hidden" class="form-control" id=""
                        name="<portlet:namespace/>fixedValue" value="<%=fixedValue%>">
                        
                    <input type="hidden" class="form-control" id=""
                        name="<portlet:namespace/>dateFlag" value="<%=dateFlag%>">
                    
                    <input type="hidden" class="form-control" id=""
                        name="<portlet:namespace/>dropDownFlag" value="<%=dropDownFlag%>">
                        
                    <input type="hidden" class="form-control" id=""
                        name="<portlet:namespace/>subServiceId" value="<%=subServiceId%>">

                    <!-- Old values for workflow comparison -->
                    <input type="hidden" name="<portlet:namespace/>oldFieldId" value="<%=fieldId%>">
                    <input type="hidden" name="<portlet:namespace/>oldFieldCode" value="<%=fieldCode%>">
                    <input type="hidden" name="<portlet:namespace/>oldFieldName" value="<%=fieldName%>">
                    <input type="hidden" name="<portlet:namespace/>oldFieldDetailsId" value="<%=fieldDetailsId%>">
                    <input type="hidden" name="<portlet:namespace/>oldFixedValueFlag" value="<%=fixedValueFlag%>">
                    <input type="hidden" name="<portlet:namespace/>oldFixedValue" value="<%=fixedValue%>">
                    <input type="hidden" name="<portlet:namespace/>oldDateFlag" value="<%=dateFlag%>">
                    <input type="hidden" name="<portlet:namespace/>oldDropDownFlag" value="<%=dropDownFlag%>">
                    <input type="hidden" name="<portlet:namespace/>oldDropDownId" value="<%=id%>">
                    <input type="hidden" name="<portlet:namespace/>oldCode" value="<%=code%>">
                    <input type="hidden" name="<portlet:namespace/>oldValueAr" value="<%=valueAr%>">
                    <input type="hidden" name="<portlet:namespace/>oldValueEn" value="<%=valueEn%>">
                    <input type="hidden" name="<portlet:namespace/>oldRelatedFieldCode" value="<%=relatedFieldCode%>">
                    <input type="hidden" name="<portlet:namespace/>oldRelatedFieldId" value="<%=relatedFieldId%>">
                    <input type="hidden" name="<portlet:namespace/>oldRelatedFieldName" value="<%=relatedFieldName%>">
                    <input type="hidden" name="<portlet:namespace/>oldAllowedValues" value="<%=allowedValues%>">

                    <label class="form-label">Code</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text"
                        class="form-control" id=""
                        name="<portlet:namespace/>paymentMinAmount" value="<%=code%>">

                    <input type="hidden" class="form-control" id=""
                        name="<portlet:namespace/>id" value="<%=id%>">
                </div>
                <div class="mb-3">
                    <label class="form-label">Value English</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text"
                        class="form-control" id="" name="<portlet:namespace/>valueEn"
                        value="<%=valueEn%>">
                </div>
                <div class="mb-3">
                    <label class="form-label">Value Arabic</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text"
                        class="form-control" id="" name="<portlet:namespace/>valueAr"
                        value="<%=valueAr%>">
                </div>
                <div class="mb-3">
                    <label class="form-label">Related field (optional)</label>
                    <input type="hidden" class="form-control" id=""
                        name="<portlet:namespace/>relatedFieldCode"
                        value="<%=relatedFieldCode%>">
                        <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text"
                        class="form-control" id=""
                        name="<portlet:namespace/>relatedFieldName"
                        value="<%=relatedFieldName%>" readonly> 
                        <input type="hidden"
                        class="form-control" id=""
                        name="<portlet:namespace/>relatedFieldId"
                        value="<%=relatedFieldId%>">
                </div>
                <div class="mb-3">
                    <label class="form-label">Allowed payment amount </label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed."
                        type="text" class="form-control" id=""
                        name="<portlet:namespace/>allowedValues"
                        value="<%=allowedValues%>">

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
                <h5 class="modal-title" id="exampleModalLongTitle">Update Dropdown Value</h5>
                <button type="button" class="close" data-dismiss="modal"
                    aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body text-5 text-center">Are you sure you want to update this dropdown value?</div>
            <div class="modal-footer justify-content-end">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="confirmUpdate()">Confirm</button>
            </div>
        </div>
    </div>
</div>

<script>
    function showUpdateConfirmation() {
        $("#telemoneyUpdateModal").modal("show");
        $("#telemoneyUpdateModal").removeClass("hide");
    }

    function confirmUpdate() {
        // Find the form and submit it
        var form = document.querySelector('form[action="<%=updateFieldAndDropDownData%>"]');
        if (form) {
            form.submit();
        }
    }

    $('#telemoneyUpdateModal').on('hidden.bs.modal', function(e) {
        // Nothing to reset for update
    });
</script>
