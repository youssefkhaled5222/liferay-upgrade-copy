<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui" %>

<portlet:renderURL var="cancel_update">
    <portlet:param name="action" value="view" />
</portlet:renderURL>
<portlet:actionURL name="UpdateMoiSubService" var="UpdateMoiSubService">
</portlet:actionURL>

<%
String billerName  = (String)request.getAttribute("billerName");
String billerId  = (String)request.getAttribute("billerId");
String subServiceId  = (String)request.getAttribute("subServiceId");
String subServiceName  = (String)request.getAttribute("subServiceName");
String subServiceCode  = (String)request.getAttribute("subServiceCode");
String moiServiceId  = (String)request.getAttribute("moiServiceId");
boolean hasPendingVersion = (Boolean)request.getAttribute("hasPendingVersion");

%>
<div>
    <h3 class="pb-4">MOI Billers service</h3>
    <liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />    
    <liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
    <liferay-ui:error key="hasPendingVersion" message="This MOI biller has a pending version awaiting approval and cannot be modified." />

    <div class="card">
        <div class="card-body">
            <form action="<%=UpdateMoiSubService%>" method="post">
                <!-- Hidden fields for old values -->
                <input type="hidden" name="<portlet:namespace/>oldSubServiceId" value="<%=subServiceId %>">
                <input type="hidden" name="<portlet:namespace/>oldSubServiceName" value="<%=subServiceName %>">
                <input type="hidden" name="<portlet:namespace/>oldSubServiceCode" value="<%=subServiceCode %>">
                <input type="hidden" name="<portlet:namespace/>oldMoiServiceId" value="<%=billerId %>">

                <fieldset <%= hasPendingVersion ? "disabled" : "" %>>
                <div class="mb-3">
                    <label class="form-label">Biller Id</label> 
                    <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id=""
                    name="<portlet:namespace/>billerName" 
                    value="<%=billerId %>" readonly>
                </div>
                <div class="mb-3">
                    <label class="form-label">Biller Name</label> 
                    <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id=""
                    value="<%=billerName %>" readonly>
                </div>
                <div class="mb-3">
                    <label class="form-label">Service ID</label> 
                    <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id=""
                    name="<portlet:namespace/>subServiceId" 
                    value="<%=subServiceId %>">
                    
                    <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="hidden" class="form-control" id=""
                    name="<portlet:namespace/>moiServiceId" 
                    value="<%=billerId %>">
                </div>
                <div class="mb-3">
                    <label class="form-label">Service code</label> 
                    <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id=""
                    name="<portlet:namespace/>subServiceCode" 
                    value="<%=subServiceCode %>">
                </div>
                <div class="mb-3">
                    <label class="form-label">Service name</label> 
                    <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id=""
                    name="<portlet:namespace/>subServiceName" 
                    value="<%=subServiceName %>">
                </div>
                </fieldset>
                <div class="d-flex justify-content-end">
                    <button type="button"
                        onclick="window.location.href='<%=cancel_update%>'"
                        class="btn btn-secondary px-5 mr-3"><%= hasPendingVersion ? "BACK" : "CANCEL" %></button>
                    <% if (!hasPendingVersion) { %>
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
                <h5 class="modal-title" id="exampleModalLongTitle">Update MOI Service</h5>
                <button type="button" class="close" data-dismiss="modal"
                    aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body text-5 text-center">Are you sure you want to update this MOI service?</div>
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
        var form = document.querySelector('form[action="<%=UpdateMoiSubService%>"]');
        if (form) {
            form.submit();
        }
    }

    $('#telemoneyUpdateModal').on('hidden.bs.modal', function(e) {
        // Nothing to reset for update
    });
</script>
