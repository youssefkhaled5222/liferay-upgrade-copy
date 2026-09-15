<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.ejada.telemoney.biller.portlet.PaymentTypeDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ejada.telemoney.biller.portlet.CategoryDTO"%>
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui" %>


<portlet:actionURL name="addBiller" var="addBiller">
</portlet:actionURL>

<portlet:renderURL var="cancel_add">
	<portlet:param name="action" value="view" />
</portlet:renderURL>

<%
List<CategoryDTO> categories  =  request.getAttribute("billerCategories")!=null?
								(List<CategoryDTO>) request.getAttribute("billerCategories"):
								new ArrayList();
								
List<PaymentTypeDTO> paymentTypes  =  request.getAttribute("paymentTypes")!=null?
								(List<PaymentTypeDTO>) request.getAttribute("paymentTypes"):
								new ArrayList();
String serverURL = PortalUtil.getPortalURL(request);
String itemSelectorURL = (String)request.getAttribute("itemSelectorURL");
String billerCategoryId  = (String)request.getAttribute("billerCategoryId");

%>
<div>
	<h3 class="pb-4">Biller</h3>
	<liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />	
	<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
	<div class="card">
		<div class="card-body">
			<form action="<%=addBiller%>" method="post">			
				<fieldset <%= isOther ? "disabled" : "" %>>
				<div class="mb-3">
					<label class="form-label">Biller category</label> 
					<select pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." class="custom-select" required
					name="<portlet:namespace/>billerCategoryId">				
					    <option value="">Choose...</option>
					    <%
							for (CategoryDTO category : categories) {
						%>
					    <option value="<%= category.getCategoryId()%>"
					    <%= billerCategoryId.equals(String.valueOf(category.getCategoryId()))? "selected" : "" %>>
					    <%= category.getCategoryNameEn() %></option>
					    <% } %>
					 </select>
				</div>
				<div class="mb-3">
					<label class="form-label">Postpaid code</label> 
					<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id="" name="<portlet:namespace/>postpaidcode">
				</div>
				<div class="mb-3">
					<label class="form-label">Prepaid code</label> 
					<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id="" name="<portlet:namespace/>prepaidcode">
				</div>
				<div class="mb-3">
					<label class="form-label">Biller name English</label> 
					<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id="" name="<portlet:namespace/>billerNameEnglish">
				</div>
				<div class="mb-3">
					<label class="form-label">Biller name Arabic</label> 
					<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id="" name="<portlet:namespace/>billerNameArabic">
				</div>
				<div class="mb-3">
					<label class="form-label">Payment type</label> 
					<select pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." class="custom-select" name="<portlet:namespace/>paymentType" required>
					    <option value="">Choose...</option>
					    <%for(PaymentTypeDTO paymentType : paymentTypes){ %>
					    <option value="<%= paymentType.getId()%>"><%=paymentType.getType() %></option>
					    <%} %>
					 </select>
				</div>
				<div class="mb-3">
					<label class="form-label">Label name English</label> 
					<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id="" name="<portlet:namespace/>labelNameEnglish">
				</div>
				<div class="mb-3">
					<label class="form-label">Label name Arabic</label> 
					<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id="" name="<portlet:namespace/>labelNameArabic">
				</div>
				<div class="mb-3">
					<label class="form-label">Allow fixed values</label> 
					<br/>
					<div class="form-check form-check-inline">
					  <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." class="form-check-input" type="radio" name="<portlet:namespace/>allowFixedValues" id="inlineRadio1" value="1">
					  <label class="form-check-label mx-2" for="inlineRadio1">Yes</label>
					</div>
					<div class="form-check form-check-inline">
					  <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." class="form-check-input" type="radio" name="<portlet:namespace/>allowFixedValues" id="inlineRadio2" value="2">
					  <label class="form-check-label mx-2" for="inlineRadio2">No</label>
					</div>
				</div>
				<div class="mb-3">
					<label class="form-label">Payment min amount (optional)</label> 
					<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id="" name="<portlet:namespace/>paymentMinAmount">
				</div>
				<div class="mb-3">
					<label class="form-label">Payment max amount (optional)</label> 
					<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id="" name="<portlet:namespace/>paymentMaxAmount">
				</div>
				<div class="mb-3">
					<label class="form-label">Allowed payment amount</label> 
					<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id="" name="<portlet:namespace/>allowedPaymentAmount">
				</div>
				<div class="mb-3">
					<label class="form-label">Photo link</label> 
					<input type="hidden" id="<portlet:namespace/>serverURL"  name="<portlet:namespace/>serverURL" value="<%=serverURL%>">
					<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id="<portlet:namespace/>photoLink" name="<portlet:namespace/>photoLink" value="">
					<aui:button class="btn px-5 mr-3" name="chooseImage" value="Choose Image" />
				</div>
				</fieldset>
				<div class="d-flex justify-content-end">
					<button type="button"
						onclick="window.location.href='<%=cancel_add%>'"
						class="btn btn-secondary px-5 mr-3"><%= isOther ? "BACK" : "CANCEL" %></button>
					<% if (!isOther) { %>
					<button type="button" class="btn btn-primary px-5" onclick="showAddConfirmation()">Add</button>
					<% } %>
				</div>
			</form>
		</div>
	</div>
</div>

<!-- Add Confirmation Modal -->
<div class="modal hide fade" id="telemoneyAddModal" tabindex="-1"
	role="dialog" aria-labelledby="telemoneyAddModalCenteredTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-100" role="document">
		<div class="modal-content w-auto m-auto">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">Add Biller</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body text-5 text-center">Are you sure you want to add this biller?</div>
			<div class="modal-footer justify-content-end">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary" onclick="confirmAdd()">Confirm</button>
			</div>
		</div>
	</div>
</div>

<script>
	function showAddConfirmation() {
		$("#telemoneyAddModal").modal("show");
		$("#telemoneyAddModal").removeClass("hide");
	}

	function confirmAdd() {
		// Find the form and submit it
		var form = document.querySelector('form[action="<%=addBiller%>"]');
		if (form) {
			form.submit();
		}
	}

	$('#telemoneyAddModal').on('hidden.bs.modal', function(e) {
		// Nothing to reset for add
	});
</script>

<script src="https://cdn.jsdelivr.net/alloyui/2.5.0/alloy-ui/aui-min.js"></script>
<aui:script use="liferay-item-selector-dialog">

    $('#<portlet:namespace />chooseImage').on(
        'click', 
        function(event) {
            var itemSelectorDialog = new A.LiferayItemSelectorDialog(  
                {
                    eventName: 'selectedItemChange',
                    on: {
                            selectedItemChange: function(event) {
                                var selectedItem = event.newVal;
                                if (selectedItem) {
                                    var itemValue = selectedItem.value;
                                    var serverURL = $('#<portlet:namespace />serverURL').val();
                                    $('#<portlet:namespace />photoLink').val(serverURL+itemValue);
                                    
                                    
                                }
                            }
                    },
                    title: '<liferay-ui:message key="select an Image" />',
                    url: '<%= itemSelectorURL.toString() %>'
                }
            );
            itemSelectorDialog.open();
        }
    );
</aui:script>